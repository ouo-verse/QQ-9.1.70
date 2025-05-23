package com.tencent.mobileqq.transfile;

import android.os.Environment;
import android.os.Message;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes19.dex */
public class BaseTransProcessor implements ITransProcessor, IHttpCommunicatorListener, INetEngineListener, AppConstants.RichMediaErrorCode, ProtoReqManagerImpl.IProtoRespBack, RichProtoProc.RichProtoCallback {
    static IPatchRedirector $redirector_ = null;
    public static final String FILE_AST_DIR = "ast";
    public static final String FILE_PTT_DIR = "ptt";
    public static final String TAG = "BaseTransProcessor";
    private static ArrayList<TransProcessorHandler> handlerList;
    private static final Object lock;
    public AppInterface app;
    StringBuilder costReport;
    private int currentProgress;
    public FileMsg file;
    protected long inQueueCost;
    protected boolean isDomainTest;
    boolean isReportValid;
    private String key;
    public BaseTransFileController mController;
    boolean mIsCancel;
    public boolean mIsPause;
    public boolean mIsRawPic;
    public boolean mIsShortVideoReceive;
    public boolean mIsShortVideoSend;
    public IHttpEngineService mNetEngine;
    NetReq mNetReq;
    int mNetworkChgRetryCount;
    public ProcessorReport mProcessorReport;
    protected int mProgress;
    protected RMServMonitorReport mRSMReporter;
    RichProto.RichProtoReq mRichProtoReq;
    private int mState;
    private boolean mSupportFakeProgress;
    public TransferRequest mUiRequest;
    long reportTimeHt;
    long reportTimePicCache;
    long reportTimeTrans;
    protected int segmentNum;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33492);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 62)) {
            redirector.redirect((short) 62);
        } else {
            handlerList = new ArrayList<>();
            lock = new Object();
        }
    }

    public BaseTransProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isDomainTest = false;
        this.mNetworkChgRetryCount = 0;
        this.mRSMReporter = new RMServMonitorReport();
        this.mProcessorReport = new ProcessorReport();
        this.mSupportFakeProgress = false;
        this.mIsPause = false;
        this.mIsRawPic = false;
        this.mIsShortVideoSend = false;
        this.mIsShortVideoReceive = false;
        this.mIsCancel = false;
        this.isReportValid = true;
        this.reportTimeHt = 0L;
        this.reportTimeTrans = 0L;
        this.reportTimePicCache = 0L;
        this.inQueueCost = 0L;
        this.costReport = new StringBuilder();
        this.segmentNum = 0;
    }

    public static void addHandler(TransProcessorHandler transProcessorHandler) {
        synchronized (lock) {
            if (!handlerList.contains(transProcessorHandler)) {
                handlerList.add(transProcessorHandler);
            }
        }
    }

    private void collectTransStatistics(NetResp netResp) {
        this.inQueueCost = netResp.inQueueCost;
    }

    private void doSendProgressMessage() {
        FileMsg fileMsg = this.file;
        if (fileMsg != null) {
            if (fileMsg.actionType == 0) {
                sendMessageToUpdate(1002);
            } else {
                sendMessageToUpdate(2002);
            }
        }
    }

    public static String getExpStackString(Exception exc) {
        return ProcessorReport.getExceptionMessage(exc);
    }

    public static void removeHandler(TransProcessorHandler transProcessorHandler) {
        synchronized (lock) {
            handlerList.remove(transProcessorHandler);
        }
    }

    public static void sendCustomMessageToUpdateDelay(Message message, Class cls, long j3) {
        synchronized (lock) {
            ArrayList<TransProcessorHandler> arrayList = handlerList;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<TransProcessorHandler> it = handlerList.iterator();
                while (it.hasNext()) {
                    TransProcessorHandler next = it.next();
                    ArrayList<Class<?>> filter = next.getFilter();
                    if (!filter.isEmpty()) {
                        Iterator<Class<?>> it5 = filter.iterator();
                        while (it5.hasNext()) {
                            if (cls.isAssignableFrom(it5.next())) {
                                Message obtainMessage = next.obtainMessage();
                                obtainMessage.what = message.what;
                                obtainMessage.obj = message.obj;
                                obtainMessage.arg1 = message.arg1;
                                next.sendMessageDelayed(obtainMessage, j3);
                            }
                        }
                    }
                }
            }
        }
    }

    private void updateProgress() {
        int realProgress;
        if (this.mSupportFakeProgress && (realProgress = getRealProgress()) > this.mProgress) {
            this.mProgress = realProgress;
        }
    }

    public void accountChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void analysisIOProblem(IOException iOException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) iOException);
            return;
        }
        String message = iOException.getMessage();
        String externalStorageState = Environment.getExternalStorageState();
        if (message.contains("EACCES")) {
            this.mProcessorReport.setError(9039, message, null, null);
            return;
        }
        if (message.contains("ENOSPC")) {
            this.mProcessorReport.setError(9040, message, null, null);
        } else if (message.contains("Read-only")) {
            this.mProcessorReport.setError(9039, message, null, null);
        } else if (!"mounted".equals(externalStorageState)) {
            this.mProcessorReport.setError(9039, message, null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean canDoNextStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        if (!this.mIsCancel && !this.mIsPause) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        TransferResult transferResult;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return ((Integer) iPatchRedirector.redirect((short) 58, (Object) this)).intValue();
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null) {
            if (transferRequest.mIsUp) {
                i3 = 1004;
            } else {
                i3 = 2004;
            }
            sendMessageToUpdate(i3);
        }
        this.mIsCancel = true;
        if (QLog.isColorLevel() && this.mUiRequest != null) {
            logRichMediaEvent("cancel", "");
        }
        RichProto.RichProtoReq richProtoReq = this.mRichProtoReq;
        if (richProtoReq != null) {
            RichProtoProc.cancelRichProtoReq(richProtoReq);
            this.mRichProtoReq = null;
        }
        NetReq netReq = this.mNetReq;
        if (netReq != null) {
            this.mNetEngine.cancelReq(netReq);
            this.mNetReq = null;
        }
        this.mController.removeProcessor(getKey());
        synchronized (this) {
            TransferRequest transferRequest2 = this.mUiRequest;
            if (transferRequest2 != null && (transferResult = transferRequest2.mResult) != null) {
                transferResult.mResult = -1;
                transferResult.mErrCode = 9037L;
                transferResult.mOrigReq = transferRequest2;
            }
            if (transferRequest2 != null) {
                logRichMediaEvent("cancel", "");
            }
            notifyAll();
            if (this.mUiRequest != null) {
                logRichMediaEvent("cancel", "");
            }
        }
        return 0;
    }

    public void cancelTransTimer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Integer) iPatchRedirector.redirect((short) 38, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearReprotInfo() {
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.errCode = 0;
        processorReport.errDesc = "";
        processorReport.mReportInfo.clear();
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void decode(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) httpMsg, (Object) httpMsg2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, z16);
        }
    }

    public boolean errerOccered() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        if (this.mProcessorReport.errCode != 9001) {
            return true;
        }
        return false;
    }

    public void fetchReportFlag() {
        int intValue;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this);
            return;
        }
        Integer num = ProcessorReport.sReportMap.get(this.mUiRequest.getKey());
        ProcessorReport processorReport = this.mProcessorReport;
        boolean z16 = false;
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        processorReport.mReportedFlag = intValue;
        ProcessorReport processorReport2 = this.mProcessorReport;
        if (this.mUiRequest.mDbRecVersion < 3) {
            z16 = true;
        }
        processorReport2.mIsOldDbRec = z16;
    }

    String genErrorLog(long j3) {
        return "elapsed:" + j3 + " errCode:" + this.mProcessorReport.errCode + " errDesc:" + this.mProcessorReport.errDesc + " reason:" + this.mProcessorReport.mReportInfo.get(ReportConstant.KEY_REASON);
    }

    public int getCurrentProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.currentProgress;
    }

    public FileMsg getFileMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (FileMsg) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        return this.file;
    }

    public long getFileSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Long) iPatchRedirector.redirect((short) 27, (Object) this)).longValue();
        }
        return this.file.fileSize;
    }

    public long getFileStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Long) iPatchRedirector.redirect((short) 30, (Object) this)).longValue();
        }
        return this.file.status;
    }

    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return (String) iPatchRedirector.redirect((short) 37, (Object) this);
        }
        return this.key;
    }

    public long getLastFileStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Long) iPatchRedirector.redirect((short) 31, (Object) this)).longValue();
        }
        return this.file.lastStatus;
    }

    public int getProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        if (this.mSupportFakeProgress) {
            return this.mProgress;
        }
        FileMsg fileMsg = this.file;
        if (fileMsg != null) {
            long j3 = fileMsg.fileSize;
            if (j3 > 0) {
                return (int) ((fileMsg.transferedSize * 100) / j3);
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public IProtoReqManager getProtoReqManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (IProtoReqManager) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
    }

    public int getRealProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        FileMsg fileMsg = this.file;
        if (fileMsg != null) {
            long j3 = fileMsg.fileSize;
            if (j3 > 0) {
                int i3 = (int) ((fileMsg.transferedSize * 100) / j3);
                if (fileMsg.actionType == 0) {
                    int i16 = fileMsg.fileType;
                    if ((i16 == 1 || i16 == 131075) && i3 == 100 && fileMsg.status != 1003) {
                        return 99;
                    }
                    return i3;
                }
                return i3;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return (String) iPatchRedirector.redirect((short) 52, (Object) this);
        }
        return null;
    }

    protected int getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return this.mState;
    }

    public TransferRequest getTransferRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            return (TransferRequest) iPatchRedirector.redirect((short) 56, (Object) this);
        }
        return this.mUiRequest;
    }

    public long getTransferedSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Long) iPatchRedirector.redirect((short) 29, (Object) this)).longValue();
        }
        return this.file.transferedSize;
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleError(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) httpMsg, (Object) httpMsg2);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public void handleRedirect(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isAppValid() {
        if (this.app.isRunning() && this.app.isLogin()) {
            return true;
        }
        return false;
    }

    public boolean isPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        return this.mIsPause;
    }

    public boolean isRawPic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return ((Boolean) iPatchRedirector.redirect((short) 45, (Object) this)).booleanValue();
        }
        return this.mIsRawPic;
    }

    protected boolean isRetry(HttpMsg httpMsg, HttpMsg httpMsg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) httpMsg, (Object) httpMsg2)).booleanValue();
        }
        if (httpMsg2 == null) {
            return false;
        }
        String errorString = httpMsg2.getErrorString();
        if (errorString != null && errorString.contains(HttpMsg.ERR_CLOSE_OR_CANCEL)) {
            return false;
        }
        return true;
    }

    public void logRichMediaEvent(String str, String str2) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            return;
        }
        FileMsg fileMsg = this.file;
        if (fileMsg == null) {
            TransFileUtil.printRichMediaError(TAG, "logRichMediaEvent", "file is null !");
            return;
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null) {
            i3 = transferRequest.mUinType;
        } else {
            i3 = -1;
        }
        if (transferRequest != null) {
            z16 = transferRequest.mIsUp;
        } else if (fileMsg.actionType == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        TransFileUtil.log(TransFileUtil.getUinDesc(i3), z16, RichMediaUtil.getFileTypeDesc(this.file.fileType), String.valueOf(this.file.uniseq), str, str2);
    }

    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            iPatchRedirector.redirect((short) 57, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onError() {
        long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
        AppInterface appInterface = this.app;
        if (appInterface != null && (!appInterface.isLogin() || !this.app.isRunning())) {
            this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "account switch", null, null);
        }
        String genErrorLog = genErrorLog(nanoTime);
        QLog.i(TAG, 1, "onError, " + genErrorLog);
        logRichMediaEvent("onError", genErrorLog);
        doReport(false);
        this.mController.removeProcessor(getKey());
    }

    @Override // com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.IProtoRespBack
    public void onProtoResp(ProtoReqManagerImpl.ProtoResp protoResp, ProtoReqManagerImpl.ProtoReq protoReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            iPatchRedirector.redirect((short) 55, (Object) this, (Object) protoResp, (Object) protoReq);
        }
    }

    public void onResp(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, (Object) netResp);
        } else {
            collectTransStatistics(netResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSuccess() {
        logRichMediaEvent("onSuccess", "elapsed:" + ((System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000) + ",key:" + getKey());
        doReport(true);
        this.mController.removeProcessor(getKey());
    }

    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    @Override // com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        }
    }

    public void resetTransTimer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Integer) iPatchRedirector.redirect((short) 39, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.ITransProcessor
    public void retry() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessageToUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            sendMessageToUpdateDelay(i3, 0L);
        }
    }

    protected void sendMessageToUpdateDelay(int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        if (i3 != 1002 && i3 != 2002) {
            logRichMediaEvent("updateUiState", "state:" + i3 + " ret:" + i16 + " currentProgress:" + this.currentProgress + " mProgress:" + this.mProgress);
        }
        this.mProcessorReport.mEndTime = System.currentTimeMillis();
        long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
        boolean z16 = nanoTime > 60000 || i3 == 1005;
        if (nanoTime > 60000) {
            RichMediaUtil.stopImageSendReport(true, "image_sending_too_long");
        } else {
            RichMediaUtil.stopImageSendReport(z16, "image_sending_" + this.mProcessorReport.errCode + "_" + this.mProcessorReport.errDesc);
        }
        sendMsgToUpdateUIDelay(i3, i16, j3);
    }

    protected void sendMsgToUpdateUIDelay(int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        if (this.mIsCancel) {
            return;
        }
        synchronized (lock) {
            this.mState = i3;
            if (this.file == null) {
                QLog.w(TAG, 1, "sendMsgToUpdateUIDelay, file is null, ret=" + i16);
                return;
            }
            ArrayList<TransProcessorHandler> arrayList = handlerList;
            if (arrayList != null && !arrayList.isEmpty()) {
                Iterator<TransProcessorHandler> it = handlerList.iterator();
                while (it.hasNext()) {
                    TransProcessorHandler next = it.next();
                    ArrayList<Class<?>> filter = next.getFilter();
                    if (!filter.isEmpty()) {
                        Iterator<Class<?>> it5 = filter.iterator();
                        while (it5.hasNext()) {
                            if (getClass().equals(it5.next())) {
                                Message obtainMessage = next.obtainMessage();
                                FileMsg fileMsg = this.file;
                                fileMsg.lastStatus = fileMsg.status;
                                fileMsg.status = i3;
                                obtainMessage.what = i3;
                                obtainMessage.obj = fileMsg;
                                obtainMessage.arg1 = i16;
                                next.sendMessageDelayed(obtainMessage, j3);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendProgressMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (this.file != null) {
            updateProgress();
            doSendProgressMessage();
        }
    }

    public void setCurrentProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.currentProgress = i3;
        }
    }

    public void setFakeProgressCapable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, z16);
        } else {
            this.mSupportFakeProgress = z16;
        }
    }

    public void setFileSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, j3);
        } else {
            this.file.fileSize = j3;
        }
    }

    public void setId(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, j3);
        } else {
            this.file.setFileId(j3);
        }
    }

    public void setKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) str);
        } else {
            this.key = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this);
        }
    }

    public void setPicTrumbSize(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, j3);
        } else {
            this.file.picThumbSize = j3;
        }
    }

    public void setReportFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this);
            return;
        }
        ProcessorReport.sReportMap.put(this.mUiRequest.getKey(), Integer.valueOf(this.mProcessorReport.mReportedFlag));
        if (ProcessorReport.sReportMap.size() > 2000) {
            ProcessorReport.sReportMap.clear();
        }
    }

    public void setTransType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.file.setFileType(i3);
        }
    }

    @Override // com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener
    public boolean statusChanged(HttpMsg httpMsg, HttpMsg httpMsg2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 41)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 41, this, httpMsg, httpMsg2, Integer.valueOf(i3))).booleanValue();
    }

    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    protected void timeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    public void updateMessageDataBaseContent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMessageToUpdateDelay(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            sendMessageToUpdateDelay(i3, 0, j3);
        } else {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }

    public BaseTransProcessor(String str, String str2, boolean z16, BaseTransFileController baseTransFileController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, Boolean.valueOf(z16), baseTransFileController);
            return;
        }
        this.isDomainTest = false;
        this.mNetworkChgRetryCount = 0;
        this.mRSMReporter = new RMServMonitorReport();
        this.mProcessorReport = new ProcessorReport();
        this.mSupportFakeProgress = false;
        this.mIsPause = false;
        this.mIsRawPic = false;
        this.mIsShortVideoSend = false;
        this.mIsShortVideoReceive = false;
        this.mIsCancel = false;
        this.isReportValid = true;
        this.reportTimeHt = 0L;
        this.reportTimeTrans = 0L;
        this.reportTimePicCache = 0L;
        this.inQueueCost = 0L;
        this.costReport = new StringBuilder();
        this.segmentNum = 0;
        this.mController = baseTransFileController;
        this.app = baseTransFileController.app;
        this.mProcessorReport.mStartTime = System.nanoTime();
        FileMsg fileMsg = new FileMsg(str, str2, !z16 ? 1 : 0);
        this.file = fileMsg;
        fileMsg.processor = this;
    }

    public BaseTransProcessor(String str, boolean z16, BaseTransFileController baseTransFileController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), baseTransFileController);
            return;
        }
        this.isDomainTest = false;
        this.mNetworkChgRetryCount = 0;
        this.mRSMReporter = new RMServMonitorReport();
        this.mProcessorReport = new ProcessorReport();
        this.mSupportFakeProgress = false;
        this.mIsPause = false;
        this.mIsRawPic = false;
        this.mIsShortVideoSend = false;
        this.mIsShortVideoReceive = false;
        this.mIsCancel = false;
        this.isReportValid = true;
        this.reportTimeHt = 0L;
        this.reportTimeTrans = 0L;
        this.reportTimePicCache = 0L;
        this.inQueueCost = 0L;
        this.costReport = new StringBuilder();
        this.segmentNum = 0;
        this.mController = baseTransFileController;
        this.app = baseTransFileController.app;
        this.mProcessorReport.mStartTime = System.nanoTime();
        FileMsg fileMsg = new FileMsg(str, null, !z16 ? 1 : 0);
        this.file = fileMsg;
        fileMsg.processor = this;
    }

    public BaseTransProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.isDomainTest = false;
        this.mNetworkChgRetryCount = 0;
        this.mRSMReporter = new RMServMonitorReport();
        this.mProcessorReport = new ProcessorReport();
        this.mSupportFakeProgress = false;
        this.mIsPause = false;
        this.mIsRawPic = false;
        this.mIsShortVideoSend = false;
        this.mIsShortVideoReceive = false;
        this.mIsCancel = false;
        this.isReportValid = true;
        this.reportTimeHt = 0L;
        this.reportTimeTrans = 0L;
        this.reportTimePicCache = 0L;
        this.inQueueCost = 0L;
        this.costReport = new StringBuilder();
        this.segmentNum = 0;
        this.app = baseTransFileController.app;
        this.mProcessorReport.mStartTime = System.nanoTime();
        TransFileUtil.printRichMediaDebug(TAG, "TimeCompare", "Processor Start Time = " + this.mProcessorReport.mStartTime + "ns,Processor = " + this);
        FileMsg fileMsg = new FileMsg();
        this.file = fileMsg;
        this.mController = baseTransFileController;
        this.mUiRequest = transferRequest;
        fileMsg.fileType = transferRequest.mFileType;
        fileMsg.uniseq = transferRequest.mUniseq;
        fileMsg.uinType = transferRequest.mUinType;
        fileMsg.friendUin = transferRequest.mPeerUin;
        fileMsg.actionType = !transferRequest.mIsUp ? 1 : 0;
        this.mNetEngine = (IHttpEngineService) this.app.getRuntimeService(IHttpEngineService.class, "all");
        fetchReportFlag();
    }

    public BaseTransProcessor(BaseTransFileController baseTransFileController) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) baseTransFileController);
            return;
        }
        this.isDomainTest = false;
        this.mNetworkChgRetryCount = 0;
        this.mRSMReporter = new RMServMonitorReport();
        this.mProcessorReport = new ProcessorReport();
        this.mSupportFakeProgress = false;
        this.mIsPause = false;
        this.mIsRawPic = false;
        this.mIsShortVideoSend = false;
        this.mIsShortVideoReceive = false;
        this.mIsCancel = false;
        this.isReportValid = true;
        this.reportTimeHt = 0L;
        this.reportTimeTrans = 0L;
        this.reportTimePicCache = 0L;
        this.inQueueCost = 0L;
        this.costReport = new StringBuilder();
        this.segmentNum = 0;
        this.mController = baseTransFileController;
        this.app = baseTransFileController.app;
        this.file = new FileMsg();
        this.mProcessorReport.mStartTime = System.nanoTime();
    }
}

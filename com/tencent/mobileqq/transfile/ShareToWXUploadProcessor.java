package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class ShareToWXUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final int COMMAND_ID_SHARE_TO_WX = 73;
    private static final String TAG = "ShareToWXUploadProcessor";

    public ShareToWXUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    private final void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq buildRichProtoReq = buildRichProtoReq();
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
            return;
        }
        if (QLog.isColorLevel() && buildRichProtoReq != null) {
            logRichMediaEvent("requestStart", buildRichProtoReq.toString());
        }
        if (canDoNextStep() && buildRichProtoReq != null) {
            this.mRichProtoReq = buildRichProtoReq;
            RichProtoProc.procRichProtoReq(buildRichProtoReq);
        }
    }

    protected RichProto.RichProtoReq buildRichProtoReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (RichProto.RichProtoReq) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.PicUpReq picUpReq = new RichProto.RichProtoReq.PicUpReq();
        picUpReq.fileName = this.mFileName;
        picUpReq.fileSize = this.mFileSize;
        picUpReq.md5 = this.mLocalMd5;
        picUpReq.width = this.mWidth;
        picUpReq.height = this.mHeight;
        picUpReq.isRaw = this.mIsRawPic;
        picUpReq.selfUin = this.app.getCurrentAccountUin();
        TransferRequest transferRequest = this.mUiRequest;
        picUpReq.isSnapChat = transferRequest.mIsSecSnapChatPic;
        picUpReq.peerUin = transferRequest.mPeerUin;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.SHARE_PIC_TO_WX;
        richProtoReq.reqs.add(picUpReq);
        richProtoReq.protoReqMgr = getProtoReqManager();
        return richProtoReq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.mProcessorReport.mStartTime;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doReport, timeCost:" + currentTimeMillis + " mFileSize:" + this.mFileSize + " errorCode:" + this.mProcessorReport.errCode);
        }
        if (z16) {
            this.mProcessorReport.mReportInfo.put("param_succ_flag", "1");
        } else {
            this.mProcessorReport.mReportInfo.put("param_succ_flag", "0");
        }
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport.errDesc);
        ProcessorReport processorReport2 = this.mProcessorReport;
        processorReport2.mReportInfo.put("param_FailCode", String.valueOf(processorReport2.errCode));
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_TIME_COST, String.valueOf(currentTimeMillis));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.PIC_SHARE_TO_WX_UPLOAD, z16, currentTimeMillis, this.mFileSize, this.mProcessorReport.mReportInfo, null);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public final void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp = (RichProto.RichProtoResp.C2CPicUpResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("onBusiProtoResp", c2CPicUpResp.toString());
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, c2CPicUpResp);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onBusiProtoResp()------response.result = " + c2CPicUpResp.result);
                }
                if (c2CPicUpResp.result == 0) {
                    this.mUkey = c2CPicUpResp.mUkey;
                    FileMsg fileMsg = this.file;
                    fileMsg.orgiDownUrl = c2CPicUpResp.mOriginalDownPara;
                    if (c2CPicUpResp.isExist) {
                        fileMsg.closeInputStream();
                        onSuccess();
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "onBusiProtoResp()---- file is Exsit! " + this.mUiRequest.mLocalPath);
                        }
                    } else {
                        this.mStartOffset = c2CPicUpResp.startOffset;
                        sendFileBDH();
                    }
                } else {
                    onError();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            aVar.f258601e = this.mFileSize;
            aVar.f258603g = this.mMd5Str;
            aVar.f258609m = this.file.orgiDownUrl;
            this.mUiRequest.mUpCallBack.q(aVar);
        } else {
            updateMessageDataBaseContent(true);
        }
        sendMessageToUpdate(1003);
        RichProto.RichProtoReq richProtoReq = this.mRichProtoReq;
        if (richProtoReq != null) {
            RichProtoProc.cancelRichProtoReq(richProtoReq);
            this.mRichProtoReq = null;
        }
    }

    public final void sendFileBDH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendFileBDH");
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        Transaction transaction = new Transaction(this.app.getCurrentAccountUin(), 73, this.mUiRequest.mLocalPath, (int) this.mStartOffset, HexUtil.hexStr2Bytes(this.mUkey), this.mLocalMd5, new ITransactionCallback(SystemClock.uptimeMillis()) { // from class: com.tencent.mobileqq.transfile.ShareToWXUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = r6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ShareToWXUploadProcessor.this, Long.valueOf(r6));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i3, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i3), bArr, hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(ShareToWXUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms");
                }
                ProcessorReport processorReport = ShareToWXUploadProcessor.this.mProcessorReport;
                processorReport.setError(i3, "OnFailed.", "", processorReport.mStepTrans);
                ShareToWXUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.d(ShareToWXUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - this.val$startTime));
                }
                ShareToWXUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                ShareToWXUploadProcessor shareToWXUploadProcessor = ShareToWXUploadProcessor.this;
                shareToWXUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                shareToWXUploadProcessor.mTransferedSize = shareToWXUploadProcessor.mFileSize;
                shareToWXUploadProcessor.file.bdhExtendInfo = bArr;
                shareToWXUploadProcessor.onSuccess();
                ShareToWXUploadProcessor.this.file.closeInputStream();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d(ShareToWXUploadProcessor.TAG, 2, "<BDH_LOG> onTransStart()");
                }
                ShareToWXUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                ShareToWXUploadProcessor shareToWXUploadProcessor = ShareToWXUploadProcessor.this;
                long j3 = i3;
                shareToWXUploadProcessor.file.transferedSize = j3;
                shareToWXUploadProcessor.mTransferedSize = j3;
                if (j3 < shareToWXUploadProcessor.mFileSize && !shareToWXUploadProcessor.mIsCancel && !shareToWXUploadProcessor.mIsPause) {
                    shareToWXUploadProcessor.sendProgressMessage();
                }
            }
        });
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(transaction);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + transaction.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " Path:" + transaction.filePath + " Cmd:73");
        }
        if (submitTransactionTask != 0) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(submitTransactionTask, "SubmitError.", "", processorReport.mStepTrans);
            onError();
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public final void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.start();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start()");
        }
        if (this.mLocalMd5 == null && !getMd5()) {
            onError();
            return;
        }
        String str = this.mUiRequest.mLocalPath;
        long length = new File(str).length();
        this.file.fileSize = length;
        this.mFileSize = length;
        String estimateFileType = FileUtils.estimateFileType(str);
        if (!TextUtils.isEmpty(estimateFileType)) {
            this.mExtName = estimateFileType;
        }
        sendRequest();
    }
}

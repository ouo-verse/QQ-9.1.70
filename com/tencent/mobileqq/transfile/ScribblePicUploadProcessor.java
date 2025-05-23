package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class ScribblePicUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final int SCRIBBLE_COMMAND_ID = 41;
    public static final String TAG = "ScribblePicUploadProcessor";
    private byte[] mLocalMd52;
    private String mPicUrl;
    private byte[] mSessionKey;
    bo messageObserver;
    private Transaction trans;

    public ScribblePicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.trans = null;
        this.mPicUrl = "";
        this.messageObserver = new bo() { // from class: com.tencent.mobileqq.transfile.ScribblePicUploadProcessor.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ScribblePicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bo
            public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                    return;
                }
                ScribblePicUploadProcessor.this.logRichMediaEvent("sendMsgFinish", "success:" + z16);
                ProcessorReport processorReport = ScribblePicUploadProcessor.this.mProcessorReport;
                processorReport.copyStatisInfo(processorReport.mStepMsg, false, z16, statictisInfo);
                if (z16) {
                    ScribblePicUploadProcessor.this.onSuccess();
                    return;
                }
                if (statictisInfo != null) {
                    ScribblePicUploadProcessor.this.shouldMsgReportSucc = statictisInfo.reportSucc;
                }
                ProcessorReport processorReport2 = ScribblePicUploadProcessor.this.mProcessorReport;
                processorReport2.setError(-1, "MessageForScribble SEND FAIL", "", processorReport2.mStepTrans);
                ScribblePicUploadProcessor.this.onError();
            }
        };
        FileMsg fileMsg = this.file;
        fileMsg.processor = this;
        fileMsg.bdhExtendInfo = transferRequest.mExtentionInfo;
    }

    private void getBDHsessionkey() {
        synchronized (SessionInfo.class) {
            if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null) {
                int length = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
                this.mSessionKey = new byte[length];
                System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSessionKey, 0, length);
            }
            if (this.mSessionKey == null) {
                HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
            }
        }
    }

    private void updateMsg(MessageForScribble messageForScribble) {
        if (messageForScribble != null) {
            messageForScribble.prewrite();
            ((IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "")).updateMsgContentByUniseq(messageForScribble.frienduin, messageForScribble.istroop, messageForScribble.uniseq, messageForScribble.msgData);
        }
    }

    public void cancelTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (this.trans != null) {
            this.app.getHwEngine().cancelTransactionTask(this.trans);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        String str = this.mUiRequest.mLocalPath;
        if (TextUtils.isEmpty(str)) {
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("filePath null")), null, null);
            onError();
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            this.mProcessorReport.setError(9042, BaseTransProcessor.getExpStackString(new Exception("sendFile not exist " + str)), null, null);
            onError();
            return -1;
        }
        if (!file.canRead()) {
            this.mProcessorReport.setError(9070, BaseTransProcessor.getExpStackString(new Exception("sendFile not readable " + this.file.filePath)), null, null);
            onError();
            return -1;
        }
        long length = file.length();
        this.file.fileSize = length;
        this.mFileSize = length;
        if (length <= 0) {
            this.mProcessorReport.setError(9071, BaseTransProcessor.getExpStackString(new Exception("file size 0 " + str)), null, null);
            onError();
            return -1;
        }
        return super.checkParam();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        String hexStr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
            return;
        }
        if (!z16 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            int i3 = 2;
            if (!z16 || (processorReport.mReportedFlag & 2) <= 0) {
                if (z16 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i16 = processorReport.mReportedFlag;
                    if (!z16) {
                        i3 = 1;
                    }
                    processorReport.mReportedFlag = i3 | i16;
                    processorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = System.nanoTime();
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    long j3 = (nanoTime - processorReport2.mStartTime) / 1000000;
                    HashMap<String, String> hashMap = processorReport2.mReportInfo;
                    byte[] bArr = this.mSessionKey;
                    if (bArr == null) {
                        hexStr = "null";
                    } else {
                        hexStr = PkgTools.toHexStr(bArr);
                    }
                    hashMap.put(ReportConstant.KEY_SESSION_KEY, hexStr);
                    if (z16) {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SCRIBBLE_UPLOAD_STATIC_TAG, true, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    } else {
                        ProcessorReport processorReport3 = this.mProcessorReport;
                        if (processorReport3.errCode != -9527) {
                            processorReport3.mReportInfo.remove("param_rspHeader");
                        }
                        ProcessorReport processorReport4 = this.mProcessorReport;
                        processorReport4.mReportInfo.put("param_FailCode", String.valueOf(processorReport4.errCode));
                        ProcessorReport processorReport5 = this.mProcessorReport;
                        processorReport5.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport5.errDesc);
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.SCRIBBLE_UPLOAD_STATIC_TAG, false, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    }
                    setReportFlag();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected long getBlockSize(long j3) {
        long min;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this, j3)).longValue();
        }
        long j16 = this.mFileSize - j3;
        if (!this.mSSCMSpanned) {
            min = Math.min(j16, this.sscmObject.d(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));
        } else {
            min = Math.min(j16, 14600L);
        }
        return Math.min(min, 131072L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public byte[] getStreamData(int i3, int i16) {
        return super.getStreamData(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public void log(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        } else if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        sendMessageToUpdate(1005);
        MessageForScribble messageForScribble = (MessageForScribble) this.mUiRequest.mRec;
        if (messageForScribble != null) {
            messageForScribble.fileUploadStatus = 2;
        }
        updateMsg(messageForScribble);
        QLog.e(TAG, 2, "onError()---- errCode: " + this.mProcessorReport.errCode + ", errDesc:" + this.mProcessorReport.errDesc);
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            aVar.f258598b = processorReport.errCode;
            aVar.f258599c = processorReport.errDesc;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        sendMessageToUpdate(1003);
        MessageForScribble messageForScribble = (MessageForScribble) this.mUiRequest.mRec;
        if (messageForScribble != null) {
            messageForScribble.fileUploadStatus = 1;
        }
        updateMsg(messageForScribble);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onSuccess().");
        }
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "ScribblePicUploadProcessor.resume()");
        }
        cancelTask();
        sendFile();
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public void sendFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        ITransactionCallback iTransactionCallback = new ITransactionCallback(SystemClock.uptimeMillis()) { // from class: com.tencent.mobileqq.transfile.ScribblePicUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = r6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ScribblePicUploadProcessor.this, Long.valueOf(r6));
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
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_Xg)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_Xg)).longValue();
                String str = hashMap.get(TransReport.rep_time_cache);
                String str2 = hashMap.get(TransReport.rep_bdhTrans);
                String str3 = hashMap.get(TransReport.rep_segsPerConn);
                String str4 = hashMap.get(TransReport.rep_confSegSize);
                String str5 = hashMap.get(TransReport.rep_confSegNum);
                String str6 = hashMap.get(TransReport.rep_confMaxConn);
                if (QLog.isColorLevel()) {
                    QLog.i(ScribblePicUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms");
                }
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
                ProcessorReport processorReport = ScribblePicUploadProcessor.this.mProcessorReport;
                processorReport.setError(i3, "OnFailed.", "", processorReport.mStepTrans);
                ScribblePicUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_wifi)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_upFlow_Xg)).longValue();
                Long.valueOf(hashMap.get(TransReport.rep_dwFlow_Xg)).longValue();
                String str = hashMap.get(TransReport.rep_time_cache);
                String str2 = hashMap.get(TransReport.rep_bdhTrans);
                String str3 = hashMap.get(TransReport.rep_segsPerConn);
                String str4 = hashMap.get(TransReport.rep_confSegSize);
                String str5 = hashMap.get(TransReport.rep_confSegNum);
                String str6 = hashMap.get(TransReport.rep_confMaxConn);
                if (QLog.isColorLevel()) {
                    QLog.i(ScribblePicUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms ,fileSize:" + ScribblePicUploadProcessor.this.file.fileSize + " transInfo:" + str2);
                }
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
                ScribblePicUploadProcessor.this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
                ScribblePicUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                ScribblePicUploadProcessor scribblePicUploadProcessor = ScribblePicUploadProcessor.this;
                scribblePicUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                scribblePicUploadProcessor.mTransferedSize = scribblePicUploadProcessor.mFileSize;
                Bdh_extinfo.UploadPicExtInfo uploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
                try {
                    uploadPicExtInfo.mergeFrom(bArr, 0, bArr.length);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                ScribblePicUploadProcessor.this.mPicUrl = uploadPicExtInfo.bytes_download_url.get().toStringUtf8();
                if (ScribblePicUploadProcessor.this.mPicUrl == null) {
                    ProcessorReport processorReport = ScribblePicUploadProcessor.this.mProcessorReport;
                    processorReport.setError(-1, "URL IS NULL", "", processorReport.mStepTrans);
                    ScribblePicUploadProcessor.this.onError();
                } else {
                    ScribblePicUploadProcessor.this.sendMsg();
                }
                ScribblePicUploadProcessor.this.file.closeInputStream();
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
                } else {
                    ScribblePicUploadProcessor.this.log("<BDH_LOG> onTransStart()");
                    ScribblePicUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                ScribblePicUploadProcessor scribblePicUploadProcessor = ScribblePicUploadProcessor.this;
                long j3 = i3;
                scribblePicUploadProcessor.file.transferedSize = j3;
                scribblePicUploadProcessor.mTransferedSize = j3;
                if (j3 <= scribblePicUploadProcessor.mFileSize && !scribblePicUploadProcessor.mIsCancel && !scribblePicUploadProcessor.mIsPause) {
                    scribblePicUploadProcessor.sendProgressMessage();
                }
            }
        };
        this.file.commandId = 41;
        String currentAccountUin = this.app.getCurrentAccountUin();
        FileMsg fileMsg = this.file;
        this.trans = new Transaction(currentAccountUin, fileMsg.commandId, this.mUiRequest.mLocalPath, (int) this.mStartOffset, this.mSessionKey, this.mLocalMd5, iTransactionCallback, fileMsg.bdhExtendInfo);
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.trans);
        String bytes2HexStr = HexUtil.bytes2HexStr(this.mLocalMd5);
        String bytes2HexStr2 = HexUtil.bytes2HexStr(this.mLocalMd52);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD51:" + bytes2HexStr + " MD52:" + bytes2HexStr2 + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:" + this.file.commandId);
        }
        if (submitTransactionTask != 0) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(submitTransactionTask, "SubmitError.", "", processorReport.mStepTrans);
            onError();
        }
    }

    protected void sendMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (!canDoNextStep()) {
            log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
            return;
        }
        MessageForScribble messageForScribble = (MessageForScribble) this.mUiRequest.mRec;
        if (messageForScribble != null) {
            messageForScribble.combineFileUrl = this.mPicUrl;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mPicUrl: " + this.mPicUrl);
                QLog.d(TAG, 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
            }
            this.mProcessorReport.mStepMsg.logStartTime();
            ((IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "")).sendMessage(messageForScribble, this.messageObserver);
            QLog.i("SCRIBBLEMSG", 2, "!!!sendMessage uniseq:" + messageForScribble.uniseq);
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.setError(-1, "MessageForScribble IS NULL", "", processorReport.mStepTrans);
        onError();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mPicUrl = "";
        super.start();
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "ScriblePicUploadProcessor.start()");
        }
        getBDHsessionkey();
        MessageForScribble messageForScribble = (MessageForScribble) this.mUiRequest.mRec;
        if (this.mLocalMd5 == null) {
            this.mLocalMd52 = HexUtil.hexStr2Bytes(messageForScribble.combineFileMd5);
            if (!getMd5()) {
                onError();
                return;
            }
            messageForScribble.combineFileMd5 = HexUtil.bytes2HexStr(this.mLocalMd5);
        }
        if (this.mSessionKey != null) {
            sendFile();
        } else {
            QLog.e(TAG, 2, "ScribblePicUploadProcessor get null BDHsession key.");
        }
    }
}

package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes19.dex */
public class ZPlanPicUploadProcessor extends BasePicUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String EVENT_EMOTICON_UPLOAD = "zplan_aio_emoticon_upload";
    private static final String TAG = "[zplan][ZPlanPicUploadProcessor]";
    private boolean isTroop;
    private long mGroupFileId;
    private bo messageObserver;

    public ZPlanPicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.messageObserver = new bo() { // from class: com.tencent.mobileqq.transfile.ZPlanPicUploadProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ZPlanPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bo
            public void onNotifyResultAfterSendRich(boolean z17, long j3, StatictisInfo statictisInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z17), Long.valueOf(j3), statictisInfo);
                    return;
                }
                ZPlanPicUploadProcessor.this.logRichMediaEvent("sendMsgFinish", "success:" + z17);
                ProcessorReport processorReport = ZPlanPicUploadProcessor.this.mProcessorReport;
                processorReport.copyStatisInfo(processorReport.mStepMsg, false, z17, statictisInfo);
                if (z17) {
                    ZPlanPicUploadProcessor.this.onSuccess();
                    return;
                }
                if (statictisInfo != null) {
                    ZPlanPicUploadProcessor.this.shouldMsgReportSucc = statictisInfo.reportSucc;
                }
                ZPlanPicUploadProcessor.this.onError();
            }
        };
        int i3 = transferRequest.mUinType;
        if (i3 != 1 && i3 != 3000) {
            z16 = false;
        }
        this.isTroop = z16;
    }

    private void handleC2CBusinessProtoResp(RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp) {
        QLog.i(TAG, 1, "handleC2CBusinessProtoResp isExist:" + c2CPicUpResp.isExist + ", resId:" + c2CPicUpResp.mResid + ", uuid:" + c2CPicUpResp.mUuid);
        FileMsg fileMsg = this.file;
        String str = c2CPicUpResp.mResid;
        fileMsg.serverPath = str;
        this.mResid = str;
        String str2 = c2CPicUpResp.mUuid;
        fileMsg.uuidPath = str2;
        this.mUuid = str2;
        if (c2CPicUpResp.isExist) {
            reportZPlanUpload(0, 0L, this.mFileSize, true);
            this.mIsPicSecondTransfered = true;
            FileMsg fileMsg2 = this.file;
            fileMsg2.transferedSize = fileMsg2.fileSize;
            sendMsg();
            return;
        }
        sendMessageToUpdate(1002);
        if (!checkContinueSend()) {
            QLog.w(TAG, 1, "handleC2CBusinessProtoResp checkContinueSend failed");
            return;
        }
        this.mUkey = c2CPicUpResp.mUkey;
        this.mStartOffset = c2CPicUpResp.startOffset;
        this.mChannelStatus = 1;
        sendFileBDH();
    }

    private void handleTroopBusinessProtoResp(RichProto.RichProtoResp.GroupPicUpResp groupPicUpResp) {
        QLog.i(TAG, 1, "handleTroopBusinessProtoResp isExist:" + groupPicUpResp.isExist + ", groupFileId:" + groupPicUpResp.groupFileID);
        this.mGroupFileId = groupPicUpResp.groupFileID;
        if (groupPicUpResp.isExist) {
            reportZPlanUpload(0, 0L, this.mFileSize, true);
            this.mIsPicSecondTransfered = true;
            FileMsg fileMsg = this.file;
            fileMsg.transferedSize = fileMsg.fileSize;
            this.mIpList = groupPicUpResp.mIpList;
            sendMsg();
            return;
        }
        sendMessageToUpdate(1002);
        if (!checkContinueSend()) {
            QLog.w(TAG, 1, "handleTroopBusinessProtoResp checkContinueSend failed");
            return;
        }
        this.mUkey = groupPicUpResp.mUkey;
        this.mIpList = groupPicUpResp.mIpList;
        this.mTransferedSize = groupPicUpResp.transferedSize;
        this.mBlockSize = groupPicUpResp.blockSize;
        this.mStartOffset = groupPicUpResp.startOffset;
        this.mChannelStatus = 1;
        sendFileBDH();
    }

    private void onZPlanBusinessProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        this.mRichProtoReq = null;
        if (richProtoResp == null) {
            QLog.e(TAG, 1, "onZPlanBusinessProtoResp resp is null");
            return;
        }
        for (RichProto.RichProtoResp.RespCommon respCommon : richProtoResp.resps) {
            if (QLog.isColorLevel()) {
                logRichMediaEvent("procUrl", respCommon.toString());
            }
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.mSendByQuickHttp = respCommon.isSendByQuickHttp;
            processorReport.copyRespCommon(processorReport.mStepUrl, respCommon);
            if (respCommon.result == 0) {
                if (this.isTroop) {
                    handleTroopBusinessProtoResp((RichProto.RichProtoResp.GroupPicUpResp) respCommon);
                } else {
                    handleC2CBusinessProtoResp((RichProto.RichProtoResp.C2CPicUpResp) respCommon);
                }
            } else {
                QLog.e(TAG, 1, "onZPlanBusinessProtoResp error:" + respCommon);
                this.mChannelStatus = 2;
                onError();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportZPlanUpload(int i3, long j3, long j16, boolean z16) {
        String str;
        QLog.i(TAG, 2, "[ReportZPlanUpload] event=zplan_aio_emoticon_upload result=" + i3 + " duration=" + j3 + " fileSize=" + j16 + " isQuickUpload=" + z16);
        String currentAccountUin = this.app.getCurrentAccountUin();
        HashMap hashMap = new HashMap();
        hashMap.put("type", "sharpP");
        hashMap.put("result", String.valueOf(i3));
        hashMap.put("duration", String.valueOf(j3));
        hashMap.put("file_size", String.valueOf(j16));
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("quick_upload", str);
        QQBeaconReport.report(currentAccountUin, EVENT_EMOTICON_UPLOAD, hashMap);
    }

    private void sendFileBDH() {
        long uptimeMillis = SystemClock.uptimeMillis();
        int i3 = 1;
        QLog.i(TAG, 1, "sendFileBDH, Transaction submit:sendFile:" + this.mUiRequest.mLocalPath + ", this:" + this);
        if (this.mTrans != null) {
            return;
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(this.mUkey);
        ITransactionCallback iTransactionCallback = new ITransactionCallback(uptimeMillis) { // from class: com.tencent.mobileqq.transfile.ZPlanPicUploadProcessor.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = uptimeMillis;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, ZPlanPicUploadProcessor.this, Long.valueOf(uptimeMillis));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i16, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i16), bArr, hashMap);
                    return;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - this.val$startTime;
                QLog.e(ZPlanPicUploadProcessor.TAG, 1, "sendFileBDH, Transaction End: Failed. SendTotalCost:" + uptimeMillis2 + "ms");
                ZPlanPicUploadProcessor.this.addBDHReportInfo(hashMap);
                ZPlanPicUploadProcessor zPlanPicUploadProcessor = ZPlanPicUploadProcessor.this;
                zPlanPicUploadProcessor.reportZPlanUpload(i16, uptimeMillis2, zPlanPicUploadProcessor.mFileSize, false);
                ZPlanPicUploadProcessor zPlanPicUploadProcessor2 = ZPlanPicUploadProcessor.this;
                zPlanPicUploadProcessor2.setError(i16, "OnFailed.", "", zPlanPicUploadProcessor2.mProcessorReport.mStepTrans);
                ZPlanPicUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                    return;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - this.val$startTime;
                QLog.i(ZPlanPicUploadProcessor.TAG, 1, "sendFileBDH, Transaction End: Success. SendTotalCost:" + uptimeMillis2 + "ms, transInfo:" + hashMap.get(TransReport.rep_bdhTrans));
                ZPlanPicUploadProcessor.this.addBDHReportInfo(hashMap);
                ZPlanPicUploadProcessor zPlanPicUploadProcessor = ZPlanPicUploadProcessor.this;
                zPlanPicUploadProcessor.reportZPlanUpload(0, uptimeMillis2, zPlanPicUploadProcessor.mFileSize, false);
                ZPlanPicUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                ZPlanPicUploadProcessor zPlanPicUploadProcessor2 = ZPlanPicUploadProcessor.this;
                zPlanPicUploadProcessor2.mProcessorReport.mStepTrans.result = 1;
                zPlanPicUploadProcessor2.mTransferedSize = zPlanPicUploadProcessor2.mFileSize;
                zPlanPicUploadProcessor2.uploadSuccess = true;
                zPlanPicUploadProcessor2.sendMsg();
                ZPlanPicUploadProcessor.this.file.closeInputStream();
                ZPlanPicUploadProcessor.this.reportForServerMonitor(true, 0, hashMap.get("ip"), hashMap.get("port"));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                    iPatchRedirector.redirect((short) 5, (Object) this);
                    return;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis();
                ZPlanPicUploadProcessor.this.log("sendFileBDH, onSwitch2BackupChannel() switch to HTTP channel");
                ZPlanPicUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis2 - this.val$startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                    iPatchRedirector.redirect((short) 6, (Object) this);
                } else {
                    ZPlanPicUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, i16);
                    return;
                }
                ZPlanPicUploadProcessor zPlanPicUploadProcessor = ZPlanPicUploadProcessor.this;
                long j3 = i16;
                zPlanPicUploadProcessor.file.transferedSize = j3;
                zPlanPicUploadProcessor.mTransferedSize = j3;
                if (j3 < zPlanPicUploadProcessor.mFileSize && !zPlanPicUploadProcessor.mIsCancel && !zPlanPicUploadProcessor.mIsPause) {
                    zPlanPicUploadProcessor.sendProgressMessage();
                }
            }
        };
        if (this.isTroop) {
            i3 = 2;
        }
        this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i3, this.mUiRequest.mLocalPath, (int) this.mStartOffset, hexStr2Bytes, this.mLocalMd5, iTransactionCallback);
        this.mTrans.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.ZPlanPicUploadProcessor.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ZPlanPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public void onFailed(int i16, String str, String str2) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i16), str, str2);
                } else {
                    ZPlanPicUploadProcessor.this.reportForServerMonitor(false, i16, str, str2);
                }
            }
        };
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendFileBDH, Transaction submit RetCode:" + submitTransactionTask + ", T_ID:" + this.mTrans.getTransationId() + ", UniSeq:" + this.mUiRequest.mUniseq + ", MD5:" + this.mMd5Str + ", uuid:" + this.mUuid + ", Path:" + this.mTrans.filePath + ", Cmd:" + i3);
        }
        if (submitTransactionTask != 0) {
            setError(submitTransactionTask, "SubmitError.", "", this.mProcessorReport.mStepTrans);
            onError();
            reportZPlanUpload(submitTransactionTask, 0L, this.mFileSize, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendMsg() {
        if (!canDoNextStep()) {
            QLog.w(TAG, 1, "sendMsg checkContinueSend failed");
            return;
        }
        if (this.mUiRequest.mUpCallBack != null) {
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            TransferRequest transferRequest = this.mUiRequest;
            transferRequest.mMd5 = this.mMd5Str;
            transferRequest.mServerPath = this.mUuid;
            transferRequest.mGroupFileID = this.mGroupFileId;
            MessageRecord g16 = transferRequest.mUpCallBack.g(im_msg_body_richtext);
            QLog.i(TAG, 1, "sendMsg " + g16);
            ((IOrderMediaMsgService) this.app.getRuntimeService(IOrderMediaMsgService.class, "")).sendOrderMsg(g16, this.messageObserver, this);
            return;
        }
        QLog.e(TAG, 1, "sendMsg fail, mUiRequest.mUpCallBack null error!!");
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        super.checkParam();
        String str = this.mUiRequest.mLocalPath;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            this.mFileSize = file.length();
            this.mExtName = FileUtils.estimateFileType(str);
        }
        if (this.mFileSize <= 0) {
            return -1;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public int getRealProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        long j3 = this.mFileSize;
        if (j3 > 0) {
            FileMsg fileMsg = this.file;
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
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
        } else {
            super.onBusiProtoResp(richProtoReq, richProtoResp);
            onZPlanBusinessProtoResp(richProtoReq, richProtoResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        sendMessageToUpdate(1005);
        QLog.i(TAG, 1, "onError()  errCode:" + this.mProcessorReport.errCode + " errDesc:" + this.mProcessorReport.errDesc);
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor
    protected void sendRequest() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.PicUpReq picUpReq = new RichProto.RichProtoReq.PicUpReq();
        picUpReq.fileName = this.mFileName;
        picUpReq.fileSize = this.mFileSize;
        picUpReq.md5 = this.mLocalMd5;
        picUpReq.width = this.mWidth;
        picUpReq.height = this.mHeight;
        picUpReq.isRaw = true;
        TransferRequest transferRequest = this.mUiRequest;
        picUpReq.busiType = transferRequest.mBusiType;
        picUpReq.picType = 1004;
        picUpReq.selfUin = transferRequest.mSelfUin;
        picUpReq.peerUin = transferRequest.mPeerUin;
        picUpReq.secondUin = transferRequest.mSecondId;
        picUpReq.uinType = transferRequest.mUinType;
        richProtoReq.callback = this;
        if (this.isTroop) {
            str = RichProtoProc.GRP_PIC_UP;
        } else {
            str = RichProtoProc.C2C_PIC_UP;
        }
        richProtoReq.protoKey = str;
        richProtoReq.reqs.add(picUpReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, this.mProcessorReport.mStepUrl);
            onError();
            return;
        }
        if (QLog.isColorLevel()) {
            logRichMediaEvent("requestStart", richProtoReq.toString());
        }
        if (!canDoNextStep()) {
            return;
        }
        this.mRichProtoReq = richProtoReq;
        RichProtoProc.procRichProtoReq(richProtoReq);
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        sendMessageToUpdate(1000);
        this.file.closeInputStream();
        sendMessageToUpdate(1001);
        if (!checkFileStandard(true)) {
            QLog.e(TAG, 1, "start, checkFileStandard fail");
        } else {
            this.app.getHwEngine().preConnect();
            sendRequest();
        }
    }
}

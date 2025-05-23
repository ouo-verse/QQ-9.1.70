package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;

/* loaded from: classes19.dex */
public class C2CQzonePicUploadProcessor extends C2CPicUploadProcessor {
    static IPatchRedirector $redirector_;

    public C2CQzonePicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealSendRequest() {
        if (this.mOpenUpTicket != null && this.mLoginSigHead != null) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.mOpenUpTicket + " mLoginSigHead:" + this.mLoginSigHead);
            }
            sendRequest();
            sendFile();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
        }
        this.mIsOpenUpEnable = false;
        sendRequest();
    }

    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        TransferRequest transferRequest = getTransferRequest();
        if (transferRequest != null && transferRequest.mIsFastForward) {
            Object obj = this.mUiRequest.mExtraObj;
            if (obj != null && (obj instanceof TransferRequest.PicUpExtraInfo)) {
                this.mIsRawPic = ((TransferRequest.PicUpExtraInfo) obj).mIsRaw;
            }
            return 0;
        }
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        if (TextUtils.isEmpty(this.mUiRequest.mMd5)) {
            this.mProcessorReport.setError(9042, BaseTransProcessor.getExpStackString(new Exception("qzonePic md5 null!")), null, null);
            onError();
            return -1;
        }
        PhotoSendParams photoSendParams = this.mUiRequest.photoSendParams;
        if (photoSendParams != null && !TextUtils.isEmpty(photoSendParams.rawDownloadUrl) && !TextUtils.isEmpty(this.mUiRequest.photoSendParams.rawMd5)) {
            FileMsg fileMsg = this.file;
            long j3 = this.mUiRequest.photoSendParams.fileSize;
            fileMsg.fileSize = j3;
            this.mFileSize = j3;
            if (j3 <= 0) {
                this.mProcessorReport.setError(9071, BaseTransProcessor.getExpStackString(new Exception("qzonePic file size 0 ")), null, null);
                onError();
                return -1;
            }
            if (j3 >= ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit()) {
                this.mProcessorReport.setError(9063, BaseTransProcessor.getExpStackString(new Exception("qzonePic file size TooBig! ")), null, null);
                onError();
                return -1;
            }
            Object obj2 = this.mUiRequest.mExtraObj;
            if (obj2 != null && (obj2 instanceof TransferRequest.PicUpExtraInfo)) {
                this.mIsRawPic = ((TransferRequest.PicUpExtraInfo) obj2).mIsRaw;
            }
            return 0;
        }
        this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("qzonePic param_check error!")), null, null);
        onError();
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor, com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        super.doReport(z16);
        HashMap<String, String> hashMap = new HashMap<>();
        if (!z16) {
            hashMap.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
            hashMap.put("fail_url", this.mUiRequest.photoSendParams.rawDownloadUrl);
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actC2CSendQzonePicInfo", z16, (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000, 0L, hashMap, "");
    }

    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor
    protected void doStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        sendMessageToUpdate(1000);
        this.file.closeInputStream();
        sendMessageToUpdate(1001);
        TransferRequest transferRequest = getTransferRequest();
        if (transferRequest != null && transferRequest.mIsFastForward) {
            this.mWidth = transferRequest.mFastForwardWidth;
            this.mHeight = transferRequest.mFastForwardHeight;
            this.mFileSize = transferRequest.mFastForwardFileSize;
            this.mLocalMd5 = HexUtil.hexStr2Bytes(transferRequest.mMd5);
            String str = transferRequest.mMd5;
            this.mFileName = str;
            this.mMd5Str = str;
            this.file.fileMd5 = str;
            this.mFileName += "." + this.mExtName;
            this.app.getHwEngine().preConnect();
            sendRequest();
            return;
        }
        PhotoSendParams photoSendParams = this.mUiRequest.photoSendParams;
        if (photoSendParams != null) {
            this.mWidth = photoSendParams.rawWidth;
            this.mHeight = photoSendParams.rawHeight;
            byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(photoSendParams.rawMd5);
            this.mLocalMd5 = hexStr2Bytes;
            String bytes2HexStr = com.qq.taf.jce.HexUtil.bytes2HexStr(hexStr2Bytes);
            this.mFileName = bytes2HexStr;
            this.mMd5Str = bytes2HexStr;
            this.file.fileMd5 = bytes2HexStr;
            this.mExtName = "jpg";
            this.mFileName += "." + this.mExtName;
        }
        this.app.getHwEngine().preConnect();
        if (this.mIsOpenUpEnable) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mIsOpenUpEnable: " + this.mIsOpenUpEnable);
            }
            this.mOpenUpTicket = makeOpenUpTicket();
            this.mExtendInfo = makeExtendInfo();
            TicketManager ticketManager = (TicketManager) this.app.getManager(2);
            if (ticketManager != null && ticketManager.useAsyncTicketInterface()) {
                makeLoginSigHead(new C2CPicUploadProcessor.LoginSigHeadCallBack() { // from class: com.tencent.mobileqq.transfile.C2CQzonePicUploadProcessor.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CQzonePicUploadProcessor.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor.LoginSigHeadCallBack
                    public void onResult(CSDataHighwayHead.LoginSigHead loginSigHead) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) loginSigHead);
                            return;
                        }
                        C2CQzonePicUploadProcessor c2CQzonePicUploadProcessor = C2CQzonePicUploadProcessor.this;
                        c2CQzonePicUploadProcessor.mLoginSigHead = loginSigHead;
                        c2CQzonePicUploadProcessor.dealSendRequest();
                    }
                });
                return;
            } else {
                this.mLoginSigHead = makeLoginSigHead(null);
                dealSendRequest();
                return;
            }
        }
        sendRequest();
    }

    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor, com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
        } else {
            super.onBusiProtoResp(richProtoReq, richProtoResp);
        }
    }

    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor
    protected void onC2CBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        Transaction transaction;
        Transaction transaction2;
        Transaction transaction3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp = (RichProto.RichProtoResp.C2CPicUpResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", c2CPicUpResp.toString());
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.mSendByQuickHttp = c2CPicUpResp.isSendByQuickHttp;
                processorReport.copyRespCommon(processorReport.mStepUrl, c2CPicUpResp);
                if (c2CPicUpResp.result == 0) {
                    if (c2CPicUpResp.isExist) {
                        if (QLog.isColorLevel()) {
                            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp.isExist, mResid:" + c2CPicUpResp.mResid + ", mUuid:" + c2CPicUpResp.mUuid + ", fileSize:" + this.file.fileSize);
                        }
                        this.mIsPicSecondTransfered = true;
                        FileMsg fileMsg = this.file;
                        fileMsg.transferedSize = fileMsg.fileSize;
                        String str = c2CPicUpResp.mResid;
                        fileMsg.serverPath = str;
                        this.mResid = str;
                        String str2 = c2CPicUpResp.mUuid;
                        fileMsg.uuidPath = str2;
                        this.mUuid = str2;
                        if (this.mIsOpenUpEnable && (transaction3 = this.mTrans) != null) {
                            if (!transaction3.isFinish.get() || !this.mTrans.isSuccess.get()) {
                                this.mTrans.cancelTransaction();
                                sendMsg();
                            }
                        } else {
                            sendMsg();
                        }
                    } else {
                        log("<BDH_LOG> onBusiProtoResp() picUpResp exist: " + c2CPicUpResp.isExist + " ,select HTTP channel");
                        this.mChannelStatus = 2;
                        if (!this.mIsOpenUpEnable || (transaction2 = this.mTrans) == null || !transaction2.isFinish.get() || !this.mTrans.isSuccess.get()) {
                            if (this.mIsOpenUpEnable && this.mTrans != null) {
                                this.app.getHwEngine().cancelTransactionTask(this.mTrans);
                            }
                            onError();
                            return;
                        }
                        return;
                    }
                } else {
                    log("<BDH_LOG> onBusiProtoResp() picUpResp error : " + c2CPicUpResp.result + " ,select HTTP channel");
                    this.mChannelStatus = 2;
                    if (!this.mIsOpenUpEnable || (transaction = this.mTrans) == null || !transaction.isFinish.get() || !this.mTrans.isSuccess.get()) {
                        if (this.mIsOpenUpEnable && this.mTrans != null) {
                            this.app.getHwEngine().cancelTransactionTask(this.mTrans);
                        }
                        onError();
                        return;
                    }
                    return;
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor, com.tencent.mobileqq.transfile.BasePicUploadProcessor
    protected void sendRequest() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        RichProto.RichProtoReq.PicUpReq picUpReq = new RichProto.RichProtoReq.PicUpReq();
        TransferRequest transferRequest = this.mUiRequest;
        picUpReq.selfUin = transferRequest.mSelfUin;
        picUpReq.peerUin = transferRequest.mPeerUin;
        picUpReq.secondUin = transferRequest.mSecondId;
        int i3 = transferRequest.mUinType;
        picUpReq.uinType = i3;
        picUpReq.fileName = this.mFileName;
        picUpReq.fileSize = this.mFileSize;
        picUpReq.md5 = this.mLocalMd5;
        picUpReq.width = this.mWidth;
        picUpReq.height = this.mHeight;
        if (i3 == 1006) {
            z16 = true;
        } else {
            z16 = false;
        }
        picUpReq.isContact = z16;
        picUpReq.isRaw = this.mIsRawPic;
        picUpReq.typeHotPic = 3;
        picUpReq.transferUrl = transferRequest.photoSendParams.rawDownloadUrl;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.C2C_PIC_UP;
        richProtoReq.reqs.add(picUpReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (MessageForPic.class.isInstance(messageRecord)) {
            int i16 = ((MessageForPic) messageRecord).imageType;
            picUpReq.picType = i16;
            this.mPicType = i16;
        }
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
}

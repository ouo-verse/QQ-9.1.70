package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

/* loaded from: classes19.dex */
public class GroupQzonePicUploadProcessor extends GroupPicUploadProcessor {
    static IPatchRedirector $redirector_;

    public GroupQzonePicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
        }
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    protected int doCheckParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        int i3 = this.mUiRequest.mUinType;
        if (i3 != 1 && i3 != 1026) {
            this.mIsGroup = false;
        } else {
            this.mIsGroup = true;
        }
        TransferRequest transferRequest = getTransferRequest();
        if (transferRequest != null && transferRequest.mIsFastForward) {
            Object obj = this.mUiRequest.mExtraObj;
            if (obj != null && (obj instanceof TransferRequest.PicUpExtraInfo)) {
                this.mIsRawPic = ((TransferRequest.PicUpExtraInfo) obj).mIsRaw;
            }
            return 0;
        }
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
            if (j3 >= ((IPicBus) QRoute.api(IPicBus.class)).getGroupPicSizeLimit()) {
                setError(9063, BaseTransProcessor.getExpStackString(new Exception("qzonePic file size TooBig! ")), null, null);
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
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor, com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
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
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actGroupSendQzonePicInfo", z16, (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000, 0L, hashMap, "");
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    protected void doStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        if (!z16) {
            sendMessageToUpdate(1001);
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
        sendRequest();
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    protected void onGroupBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.RespCommon respCommon = richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", respCommon.toString());
                }
                this.mProcessorReport.mSendByQuickHttp = respCommon.isSendByQuickHttp;
                if (QLog.isColorLevel()) {
                    QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mProcessorReport.mSendByQuickHttp);
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, respCommon);
                if (respCommon instanceof RichProto.RichProtoResp.GroupPicUpResp) {
                    RichProto.RichProtoResp.GroupPicUpResp groupPicUpResp = (RichProto.RichProtoResp.GroupPicUpResp) respCommon;
                    if (groupPicUpResp.result == 0) {
                        if (groupPicUpResp.isExist) {
                            if (QLog.isColorLevel()) {
                                QLog.d(GroupPicUploadProcessor.TAG, 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + groupPicUpResp.groupFileID + ", mFileSize:" + this.file.fileSize);
                            }
                            this.mIsPicSecondTransfered = true;
                            FileMsg fileMsg = this.file;
                            fileMsg.transferedSize = fileMsg.fileSize;
                            this.mFileID = groupPicUpResp.groupFileID;
                            this.mIpList = groupPicUpResp.mIpList;
                            sendMsg();
                        } else {
                            log("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + groupPicUpResp.isExist + " ,select HTTP channel");
                            this.mChannelStatus = 2;
                            onError();
                            return;
                        }
                    } else {
                        log("<BDH_LOG> onBusiProtoResp() picUpResp error : " + groupPicUpResp.result + " ,select HTTP channel");
                        this.mChannelStatus = 2;
                        onError();
                        return;
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor, com.tencent.mobileqq.transfile.BasePicUploadProcessor
    protected void sendRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
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
        picUpReq.isRaw = this.mIsRawPic;
        TransferRequest transferRequest = this.mUiRequest;
        picUpReq.busiType = transferRequest.mBusiType;
        picUpReq.typeHotPic = 3;
        picUpReq.transferUrl = transferRequest.photoSendParams.rawDownloadUrl;
        MessageRecord messageRecord = transferRequest.mRec;
        if (MessageForPic.class.isInstance(messageRecord)) {
            int i3 = ((MessageForPic) messageRecord).imageType;
            picUpReq.picType = i3;
            this.mPicType = i3;
        }
        TransferRequest transferRequest2 = this.mUiRequest;
        picUpReq.selfUin = transferRequest2.mSelfUin;
        picUpReq.peerUin = transferRequest2.mPeerUin;
        picUpReq.secondUin = transferRequest2.mSecondId;
        picUpReq.uinType = transferRequest2.mUinType;
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.GRP_PIC_UP;
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
}

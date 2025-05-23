package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$ResvAttr;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$RichText;

/* loaded from: classes19.dex */
public class GuildPicUploadProcessor extends GroupPicUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "GuildPicUploadProcessor";
    String mChannelId;
    byte[] mDownLoadIndex;
    String mGuildId;

    public GuildPicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mGuildId = "";
        this.mChannelId = "";
        this.mChannelId = transferRequest.mPeerUin;
        IGProChannelInfo channelInfo = ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getChannelInfo(transferRequest.mPeerUin);
        if (channelInfo != null) {
            TransferRequest transferRequest2 = this.mUiRequest;
            String guildId = channelInfo.getGuildId();
            transferRequest2.mSecondId = guildId;
            this.mGuildId = guildId;
            return;
        }
        this.mGuildId = this.mUiRequest.mSecondId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    @NonNull
    public CustomFaceExtPb$ResvAttr constructResvAttr(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CustomFaceExtPb$ResvAttr) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic);
        }
        CustomFaceExtPb$ResvAttr constructResvAttr = super.constructResvAttr(messageForPic);
        byte[] bArr = this.mDownLoadIndex;
        if (bArr != null && bArr.length > 0) {
            constructResvAttr.bytes_download_index.set(ByteStringMicro.copyFrom(bArr));
        } else {
            QLog.i(TAG, 1, "constructResvAttr: mDownLoadIndex = null, uin = " + messageForPic.selfuin);
        }
        return constructResvAttr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    public void doRealReport(boolean z16, long j3, long j16) {
        String valueOf;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        super.doRealReport(z16, j3, j16);
        r.a aVar = new r.a();
        aVar.f231044a = "0";
        if (z16) {
            valueOf = "0";
        } else {
            valueOf = String.valueOf(this.mProcessorReport.errCode);
        }
        aVar.f231051h = valueOf;
        aVar.f231052i = this.mProcessorReport.errDesc;
        NetReq netReq = this.mNetReq;
        if (netReq != null) {
            str = ((HttpNetReq) netReq).mReqUrl;
        } else {
            str = "";
        }
        aVar.f231045b = str;
        aVar.f231055l = this.mFileName;
        aVar.f231047d = this.mMd5Str;
        aVar.f231048e = "0";
        aVar.f231049f = String.valueOf(System.currentTimeMillis() - j3);
        aVar.f231050g = String.valueOf(j3);
        aVar.f231046c = String.valueOf(this.mFileSize);
        if (j3 > 0 && this.mFileSize > 0) {
            str2 = ((this.mFileSize / j3) * 1000) + "B/s";
        } else {
            str2 = "0B/s";
        }
        aVar.f231056m = str2;
        r.d(GuildTelemetryTask.UPLOAD_PIC, aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    public void fillMessageRecord(im_msg_body$RichText im_msg_body_richtext, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) im_msg_body_richtext, (Object) messageRecord);
        } else {
            super.fillMessageRecord(im_msg_body_richtext, messageRecord);
            ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageRecord, this.mGuildId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    public im_msg_body$CustomFace getCustomFace(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (im_msg_body$CustomFace) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord);
        }
        im_msg_body$CustomFace customFace = super.getCustomFace(messageRecord);
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            customFace.uint32_thumb_height.set(messageForPic.thumbHeight);
            customFace.uint32_thumb_width.set(messageForPic.thumbWidth);
        }
        return customFace;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    public ad.a getSendResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (ad.a) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        ad.a sendResult = super.getSendResult();
        sendResult.f258611o = this.mDownLoadIndex;
        return sendResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public void log(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            QLog.d(TAG, 1, str);
        }
    }

    protected byte[] makeExtendInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        CSDataHighwayHead.PicInfoExt picInfoExt = new CSDataHighwayHead.PicInfoExt();
        try {
            picInfoExt.uint64_qqmeet_channel_id.set(Long.parseLong(this.mChannelId));
            picInfoExt.uint64_qqmeet_guild_id.set(Long.parseLong(this.mGuildId));
        } catch (Exception unused) {
            QLog.d(TAG, 1, "makeExtendInfo errormChannelId:" + this.mChannelId + "mGuildId:" + this.mGuildId);
        }
        return picInfoExt.toByteArray();
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    protected void onGroupBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        byte[] bArr;
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
                if (respCommon instanceof RichProto.RichProtoResp.GuildPicUpResp) {
                    RichProto.RichProtoResp.GuildPicUpResp guildPicUpResp = (RichProto.RichProtoResp.GuildPicUpResp) respCommon;
                    if (guildPicUpResp.result == 0 && (bArr = guildPicUpResp.mDownLoadIndex) != null && bArr.length > 0) {
                        this.mDownLoadIndex = bArr;
                        reportQuickSend(guildPicUpResp.isExist);
                        if (guildPicUpResp.isExist) {
                            log("<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
                            this.mIsPicSecondTransfered = true;
                            FileMsg fileMsg = this.file;
                            fileMsg.transferedSize = fileMsg.fileSize;
                            this.mFileID = guildPicUpResp.groupFileID;
                            this.mIpList = guildPicUpResp.mIpList;
                            sendMsg();
                        } else {
                            sendMessageToUpdate(1002);
                            if (!checkContinueSend()) {
                                return;
                            }
                            this.mFileID = guildPicUpResp.groupFileID;
                            this.mUkey = guildPicUpResp.mUkey;
                            this.mIpList = guildPicUpResp.mIpList;
                            this.mTransferedSize = guildPicUpResp.transferedSize;
                            this.mBlockSize = guildPicUpResp.blockSize;
                            this.mStartOffset = guildPicUpResp.startOffset;
                            this.mChannelStatus = 1;
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
                            }
                            sendFileBDH();
                        }
                    } else {
                        log("<BDH_LOG> onBusiProtoResp() error : " + guildPicUpResp.result + " ,select HTTP channel");
                        this.mChannelStatus = 2;
                        onError();
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor, com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258601e = this.mFileSize;
            aVar.f258603g = this.mMd5Str;
            aVar.f258602f = this.mFileName;
            TransferRequest transferRequest = this.mUiRequest;
            aVar.f258600d = transferRequest.mLocalPath;
            aVar.f258604h = this.mFileID;
            aVar.f258610n = this.mDownLoadIndex;
            if (transferRequest.isShareImageByServer) {
                aVar.f258608l = getImageInfo();
            }
            this.mUiRequest.mUpCallBack.q(aVar);
        } else {
            updateMessageDataBaseContent(true);
        }
        sendMessageToUpdate(1003);
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor
    public void sendFileBDH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.startTime == -1) {
            this.startTime = SystemClock.uptimeMillis();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction submit:sendFile:" + this.mTrans + "  this:" + this);
        }
        if (this.mTrans != null) {
            return;
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 83, this.mUiRequest.mLocalPath, (int) this.mStartOffset, HexUtil.hexStr2Bytes(this.mUkey), this.mLocalMd5, new ITransactionCallback() { // from class: com.tencent.mobileqq.transfile.GuildPicUploadProcessor.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildPicUploadProcessor.this);
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
                GuildPicUploadProcessor.this.log("<BDH_LOG> Guild Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - GuildPicUploadProcessor.this.startTime) + "msretCode" + i3);
                GuildPicUploadProcessor.this.addBDHReportInfo(hashMap);
                GuildPicUploadProcessor guildPicUploadProcessor = GuildPicUploadProcessor.this;
                guildPicUploadProcessor.setError(i3, "OnFailed.", "", guildPicUploadProcessor.mProcessorReport.mStepTrans);
                GuildPicUploadProcessor.this.onError();
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
                if (QLog.isColorLevel()) {
                    QLog.d(GuildPicUploadProcessor.TAG, 2, "<BDH_LOG> Guild Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - GuildPicUploadProcessor.this.startTime) + "ms ,fileSize:" + GuildPicUploadProcessor.this.file.fileSize + " transInfo:" + hashMap.get(TransReport.rep_bdhTrans));
                }
                GuildPicUploadProcessor.this.addBDHReportInfo(hashMap);
                GuildPicUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                GuildPicUploadProcessor guildPicUploadProcessor = GuildPicUploadProcessor.this;
                guildPicUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                guildPicUploadProcessor.mTransferedSize = guildPicUploadProcessor.mFileSize;
                guildPicUploadProcessor.uploadSuccess = true;
                guildPicUploadProcessor.sendMsg();
                GuildPicUploadProcessor.this.file.closeInputStream();
                GuildPicUploadProcessor.this.reportForServerMonitor(true, 0, hashMap.get("ip"), hashMap.get("port"));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                GuildPicUploadProcessor.this.log("<BDH_LOG> Guild onSwitch2BackupChannel() switch to HTTP channel");
                GuildPicUploadProcessor guildPicUploadProcessor = GuildPicUploadProcessor.this;
                guildPicUploadProcessor.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis - guildPicUploadProcessor.startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                } else {
                    GuildPicUploadProcessor.this.log("<BDH_LOG> Guild onTransStart()");
                    GuildPicUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                GuildPicUploadProcessor guildPicUploadProcessor = GuildPicUploadProcessor.this;
                long j3 = i3;
                guildPicUploadProcessor.file.transferedSize = j3;
                guildPicUploadProcessor.mTransferedSize = j3;
                if (j3 < guildPicUploadProcessor.mFileSize && !guildPicUploadProcessor.mIsCancel && !guildPicUploadProcessor.mIsPause) {
                    guildPicUploadProcessor.sendProgressMessage();
                    if (GuildPicUploadProcessor.this.isStoryPhoto) {
                        IPeakIpcController iPeakIpcController = (IPeakIpcController) QRoute.api(IPeakIpcController.class);
                        GuildPicUploadProcessor guildPicUploadProcessor2 = GuildPicUploadProcessor.this;
                        iPeakIpcController.updatePeakVideoAndPicStatus(guildPicUploadProcessor2.picMsg, 1002, guildPicUploadProcessor2.getProgress());
                    }
                }
            }
        }, makeExtendInfo());
        this.mTrans.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.GuildPicUploadProcessor.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GuildPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public void onFailed(int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                } else {
                    GuildPicUploadProcessor.this.reportForServerMonitor(false, i3, str, str2);
                }
            }
        };
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:2");
        }
        if (submitTransactionTask != 0) {
            setError(submitTransactionTask, "SubmitError.", "", this.mProcessorReport.mStepTrans);
            onError();
        }
    }

    @Override // com.tencent.mobileqq.transfile.GroupPicUploadProcessor, com.tencent.mobileqq.transfile.BasePicUploadProcessor
    protected void sendRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
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
        picUpReq.busiType = this.mUiRequest.mBusiType;
        changeRequest(picUpReq);
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (MessageForPic.class.isInstance(messageRecord)) {
            int i3 = ((MessageForPic) messageRecord).imageType;
            picUpReq.picType = i3;
            this.mPicType = i3;
        }
        TransferRequest transferRequest = this.mUiRequest;
        picUpReq.selfUin = transferRequest.mSelfUin;
        picUpReq.peerUin = transferRequest.mPeerUin;
        picUpReq.secondUin = transferRequest.mSecondId;
        int i16 = transferRequest.mUinType;
        picUpReq.uinType = i16;
        if (i16 == 1026) {
            picUpReq.uinType = 1;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
            }
        }
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.GLD_PIC_UP;
        richProtoReq.reqs.add(picUpReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, this.mProcessorReport.mStepUrl);
            onError();
            return;
        }
        log("requestStart" + richProtoReq.toString());
        if (!canDoNextStep()) {
            log("requestStart cancel");
        } else {
            this.mRichProtoReq = richProtoReq;
            RichProtoProc.procRichProtoReq(richProtoReq);
        }
    }
}

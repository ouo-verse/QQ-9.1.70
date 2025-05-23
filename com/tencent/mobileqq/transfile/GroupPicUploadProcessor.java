package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.common.app.AppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ac;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.SigInfo;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb$ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$CustomFace;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;

/* loaded from: classes19.dex */
public class GroupPicUploadProcessor extends BasePicUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "GroupPicUploadProcessor";
    protected boolean isStoryPhoto;
    BaseTransFileController mController;
    long mFileID;
    boolean mHasVirtualStarted;
    boolean mIsGroup;
    bo messageObserver;
    protected MessageForPic picMsg;
    protected long startTime;

    public GroupPicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mIsGroup = true;
        this.mHasVirtualStarted = false;
        this.isStoryPhoto = false;
        this.startTime = -1L;
        this.messageObserver = new bo() { // from class: com.tencent.mobileqq.transfile.GroupPicUploadProcessor.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bo
            public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                    return;
                }
                GroupPicUploadProcessor.this.logRichMediaEvent("sendMsgFinish", "success:" + z16);
                ProcessorReport processorReport = GroupPicUploadProcessor.this.mProcessorReport;
                processorReport.copyStatisInfo(processorReport.mStepMsg, false, z16, statictisInfo);
                if (z16) {
                    GroupPicUploadProcessor.this.onSuccess();
                    return;
                }
                if (statictisInfo != null) {
                    GroupPicUploadProcessor.this.shouldMsgReportSucc = statictisInfo.reportSucc;
                }
                GroupPicUploadProcessor.this.onError();
            }
        };
        this.mController = baseTransFileController;
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord != null && (messageRecord instanceof MessageForPic)) {
            boolean z16 = ((MessageForPic) messageRecord).isStoryPhoto;
            this.isStoryPhoto = z16;
            if (z16) {
                this.picMsg = (MessageForPic) messageRecord;
            }
        }
    }

    private int getReportSource() {
        int i3 = this.mUiRequest.mBusiType;
        if (i3 != 1027) {
            switch (i3) {
                case 1006:
                    return 103;
                case 1007:
                    return 101;
                case 1008:
                    return 105;
                case 1009:
                    return 104;
                default:
                    return 200;
            }
        }
        return 106;
    }

    private void resetStatictisInfo() {
        this.file.stepSig.reset();
        this.file.stepUrl.reset();
        this.file.stepTrans.reset();
        this.file.stepNotify.reset();
        ProcessorReport processorReport = this.mProcessorReport;
        FileMsg fileMsg = this.file;
        long nanoTime = System.nanoTime();
        fileMsg.startTime = nanoTime;
        processorReport.mStartTime = nanoTime;
        this.file.endTime = 0L;
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this)).intValue();
        }
        return super.cancel();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        super.checkParam();
        return doCheckParam();
    }

    protected im_msg_body$RichText constructPicRichText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (im_msg_body$RichText) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        try {
            MessageRecord messageRecord = this.mUiRequest.mRec;
            im_msg_body$CustomFace customFace = getCustomFace(messageRecord);
            if (QLog.isColorLevel()) {
                logRichMediaEvent("busiTypeStat", "uiBusiType:" + this.mUiRequest.mBusiType + " protoBusiType:" + customFace.biz_type.get());
            }
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            if (ac.c(messageRecord)) {
                im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
                im_msg_body_commonelem.uint32_service_type.set(3);
                hummer_commelem$MsgElemInfo_servtype3 hummer_commelem_msgeleminfo_servtype3 = new hummer_commelem$MsgElemInfo_servtype3();
                hummer_commelem_msgeleminfo_servtype3.flash_troop_pic.set(customFace);
                im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype3.toByteArray()));
                im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
                im_msg_body_richtext.elems.add(im_msg_body_elem);
                if (QLog.isColorLevel()) {
                    QLog.d("flash", 2, "GroupPicUploadProcessor constructPicRichText send flash");
                }
                im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
                im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.qqStr(R.string.f171683k62)));
                im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                im_msg_body_elem2.text.set(im_msg_body_text);
                im_msg_body_richtext.elems.add(im_msg_body_elem2);
            } else {
                im_msg_body_elem.custom_face.set(customFace);
                im_msg_body_richtext.elems.add(im_msg_body_elem);
            }
            IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
            TransferRequest transferRequest = this.mUiRequest;
            MessageRecord msgItemByUniseq = iMessageFacade.getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(msgItemByUniseq)) {
                ((IMsgStructing) QRoute.api(IMsgStructing.class)).uploadPicConstructRichText(msgItemByUniseq, this.mMd5Str, this.mFileName, this.mFileSize, Long.valueOf(this.mFileID), im_msg_body_richtext);
                return im_msg_body_richtext;
            }
            return im_msg_body_richtext;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Construct richtext error", e16);
            }
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public CustomFaceExtPb$ResvAttr constructResvAttr(MessageForPic messageForPic) {
        CustomFaceExtPb$ResvAttr customFaceExtPb$ResvAttr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (CustomFaceExtPb$ResvAttr) iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageForPic);
        }
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData != null) {
            customFaceExtPb$ResvAttr = picMessageExtraData.getCustomFaceResvAttr();
            if (QLog.isColorLevel()) {
                QLog.d("picExtra", 4, "imageBizType: " + messageForPic.picExtraData.imageBizType);
            }
        } else {
            customFaceExtPb$ResvAttr = new CustomFaceExtPb$ResvAttr();
            if (QLog.isColorLevel()) {
                QLog.d("picExtra", 4, "imageBizType: 0");
            }
        }
        int picSourceReport = getPicSourceReport(messageForPic, this.mUiRequest.mPicSendSource);
        if (QLog.isColorLevel()) {
            QLog.d("picExtra", 4, "source: " + picSourceReport);
        }
        customFaceExtPb$ResvAttr.uint32_source.set(picSourceReport);
        return customFaceExtPb$ResvAttr;
    }

    protected int doCheckParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
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
        String estimateFileType = FileUtils.estimateFileType(str);
        if (!TextUtils.isEmpty(estimateFileType)) {
            if (!estimateFileType.contains(FileUtils.unKnownFileTypeMark) && FileUtils.isPicFileByExt(estimateFileType)) {
                this.mExtName = estimateFileType;
            } else {
                setError(9072, estimateFileType, ProcessorReport.getClientReason(estimateFileType), null);
                onError();
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.transfile.GroupPicUploadProcessor.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupPicUploadProcessor.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            QQToast.makeText(BaseApplication.getContext(), R.string.f170242k0, 1).show();
                        }
                    }
                });
                return -1;
            }
        }
        if (length >= ((IPicBus) QRoute.api(IPicBus.class)).getGroupPicSizeLimit()) {
            setError(9063, estimateFileType, ProcessorReport.getClientReason(estimateFileType), null);
            onError();
            return -1;
        }
        Object obj2 = this.mUiRequest.mExtraObj;
        if (obj2 != null && (obj2 instanceof TransferRequest.PicUpExtraInfo)) {
            this.mIsRawPic = ((TransferRequest.PicUpExtraInfo) obj2).mIsRaw;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doRealReport(boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (z16) {
            collectChnlCostReport();
            TransferRequest transferRequest = this.mUiRequest;
            if (transferRequest.mIsPresend) {
                long j17 = this.mEnterAioTime;
                long j18 = 0;
                if (j17 != 0) {
                    j18 = (j16 - j17) / 1000000;
                }
                if (transferRequest.myPresendInvalid) {
                    j18 = j3;
                }
                double d16 = j18 / j3;
                BasePicUploadProcessor.reportActPSdoneAioDuration(j18, this.mFileSize, this.mIsPicSecondTransfered, d16);
                if (d16 >= 0.0d && d16 <= 1.0d) {
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_AIOPERCENT, d16 + "");
                }
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_AIODURATION, j18 + "");
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "doReport ,mStartTime = " + this.mProcessorReport.mStartTime + ",mEnterAioTime = " + this.mEnterAioTime + ",finishTime  = " + j16 + ", aioDuration = " + j18 + ", duration = " + j3 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.mUiRequest.myPresendInvalid + ",Percent = " + d16);
                }
            }
            this.mProcessorReport.reportForIpv6(true, j3, true, getReportTAG());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        } else {
            ProcessorReport processorReport = this.mProcessorReport;
            if (processorReport.errCode != -9527) {
                processorReport.mReportInfo.remove("param_rspHeader");
            }
            this.mProcessorReport.mReportInfo.remove("param_url");
            ProcessorReport processorReport2 = this.mProcessorReport;
            processorReport2.mReportInfo.put("param_FailCode", String.valueOf(processorReport2.errCode));
            ProcessorReport processorReport3 = this.mProcessorReport;
            processorReport3.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport3.errDesc);
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
            this.mProcessorReport.mReportInfo.put("param_uniseq", String.valueOf(this.mUiRequest.mUniseq));
            this.mProcessorReport.reportForIpv6(false, j3, true, getReportTAG());
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
        }
        setReportFlag();
        super.doReport(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
            return;
        }
        int i3 = 1;
        if (!z16) {
            String str = LogTag.RICH_MEDIA + TransFileUtil.getUinDesc(this.mUiRequest.mUinType) + "." + RichMediaUtil.getFileType(this.mUiRequest.mFileType);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("id:" + this.mUiRequest.mUniseq + "  ");
            sb5.append("errCode:" + this.mProcessorReport.errCode + "  ");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("errDesc:");
            sb6.append(this.mProcessorReport.errDesc);
            sb5.append(sb6.toString());
            QLog.d(str, 1, sb5.toString());
        }
        if (!z16 && this.shouldMsgReportSucc == 1) {
            this.mProcessorReport.mStepMsg.result = 1;
            z17 = true;
        } else {
            z17 = z16;
        }
        String str2 = this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doDSReport : GroupPic doReport : result:" + z17);
        }
        if (!z17) {
            String str3 = this.mProcessorReport.mReportInfo.get(ReportConstant.KEY_REASON);
            if ("connError_unreachable".equalsIgnoreCase(str3)) {
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_REASON, "N_1");
            } else if ("connError_noroute".equalsIgnoreCase(str3)) {
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_REASON, "N_2");
            }
        }
        if (this.mUiRequest.mBusiType == 1030) {
            return;
        }
        if (!z17 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            if (!z17 || (processorReport.mReportedFlag & 2) <= 0) {
                if (z17 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i16 = processorReport.mReportedFlag;
                    if (z17) {
                        i3 = 2;
                    }
                    processorReport.mReportedFlag = i3 | i16;
                    processorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = System.nanoTime();
                    long j3 = (nanoTime - this.mProcessorReport.mStartTime) / 1000000;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("SendGrpPic, cost=");
                    StepInfo stepInfo = this.mProcessorReport.mStepTrans;
                    sb7.append((stepInfo.finishTime - stepInfo.startTime) / 1000000);
                    Log.i("AutoMonitor", sb7.toString());
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, str2);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_FILE_ID, String.valueOf(this.mFileID));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_MD5, this.mFileName);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_PRESEND, this.mUiRequest.mIsPresend + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_SECOND_TRANS, this.mIsPicSecondTransfered + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PHONE_TYPE, ah.u() + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_NET_TYPE, NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IS_RAW_PIC, this.mIsRawPic + "");
                    this.mProcessorReport.mReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(this.mUiRequest.mUinType));
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    processorReport2.mReportInfo.put(ReportConstant.KEY_SENDBY_QUICK_HTTP, String.valueOf(processorReport2.mSendByQuickHttp));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_TYPE, String.valueOf(this.mPicType));
                    this.mProcessorReport.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SOURCE_TYPE, String.valueOf(this.mUiRequest.isQzonePic ? 1 : 0));
                    doRealReport(z17, j3, nanoTime);
                }
            }
        }
    }

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
        if (!checkFileStandard(true)) {
            return;
        }
        this.app.getHwEngine().preConnect();
        sendRequest();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fillMessageRecord(im_msg_body$RichText im_msg_body_richtext, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) im_msg_body_richtext, (Object) messageRecord);
            return;
        }
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            messageForPic.richText = im_msg_body_richtext;
            messageForPic.size = this.mFileSize;
        }
        if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
            ((MessageForRichText) messageRecord).richText = im_msg_body_richtext;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public im_msg_body$CustomFace getCustomFace(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (im_msg_body$CustomFace) iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageRecord);
        }
        im_msg_body$CustomFace im_msg_body_customface = new im_msg_body$CustomFace();
        im_msg_body_customface.uint32_file_id.set((int) this.mFileID);
        ArrayList<ServerAddr> arrayList = this.mIpList;
        if (arrayList != null && arrayList.size() > 0) {
            ServerAddr serverAddr = this.mIpList.get(0);
            im_msg_body_customface.uint32_server_ip.set(BaseUploadProcessor.ipToLong(serverAddr.mIp));
            im_msg_body_customface.uint32_server_port.set(serverAddr.port);
        }
        changeRichText();
        Integer num = 66;
        im_msg_body_customface.uint32_file_type.set(num.intValue());
        im_msg_body_customface.uint32_useful.set(1);
        SigInfo.fillCustomFaceSessionKey(this.app, im_msg_body_customface);
        im_msg_body_customface.bytes_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        im_msg_body_customface.str_file_path.set(this.mFileName);
        im_msg_body_customface.uint32_origin.set(this.mIsRawPic ? 1 : 0);
        if (MessageForPic.class.isInstance(messageRecord)) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            im_msg_body_customface.uint32_show_len.set(messageForPic.mShowLength);
            im_msg_body_customface.uint32_download_len.set(messageForPic.mDownloadLength);
            im_msg_body_customface.image_type.set(messageForPic.imageType);
            im_msg_body_customface.bytes_pb_reserve.set(ByteStringMicro.copyFrom(constructResvAttr(messageForPic).get().toByteArray()), true);
        }
        im_msg_body_customface.biz_type.set(getReportBizType());
        im_msg_body_customface.uint32_width.set(this.mWidth);
        im_msg_body_customface.uint32_height.set(this.mHeight);
        im_msg_body_customface.uint32_size.set((int) this.mFileSize);
        im_msg_body_customface.uint32_source.set(getReportSource());
        return im_msg_body_customface;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (this.mIsGroup) {
            if (this.mChannelStatus == 1) {
                return StatisticCollector.TROOP_PIC_UPLOAD_STATISTIC_TAG_V2;
            }
            return StatisticCollector.TROOP_PIC_UPLOAD_STATISTIC_TAG;
        }
        if (this.mChannelStatus == 1) {
            return StatisticCollector.DISCUSSION_PIC_UPLOAD_STATISTIC_TAG_V2;
        }
        return StatisticCollector.DISCUSSION_PIC_UPLOAD_STATISTIC_TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ad.a getSendResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ad.a) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        ad.a aVar = new ad.a();
        aVar.f258601e = this.mFileSize;
        aVar.f258603g = this.mMd5Str;
        aVar.f258602f = this.mFileName;
        TransferRequest transferRequest = this.mUiRequest;
        aVar.f258600d = transferRequest.mLocalPath;
        aVar.f258604h = this.mFileID;
        if (transferRequest.isShareImageByServer) {
            aVar.f258608l = getImageInfo();
        }
        return aVar;
    }

    void inter_retry() {
        if (this.mIsCancel) {
            return;
        }
        if (this.mUkey != null && this.mFileID != 0) {
            if (this.mTransferedSize >= this.mFileSize) {
                sendMsg();
                return;
            } else if (this.mChannelStatus == 1 && this.mTrans != null) {
                log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
                this.app.getHwEngine().resumeTransactionTask(this.mTrans);
                return;
            } else {
                start();
                return;
            }
        }
        start();
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
        } else {
            super.onBusiProtoResp(richProtoReq, richProtoResp);
            onGroupBusiProtoResp(richProtoReq, richProtoResp);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        if (this.mProcessorReport.errCode != 9333) {
            sendMessageToUpdate(1005);
        }
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            aVar.f258598b = processorReport.errCode;
            aVar.f258599c = processorReport.errDesc;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
        QLog.i(TAG, 1, "onError()  errCode:" + this.mProcessorReport.errCode + " errDesc:" + this.mProcessorReport.errDesc);
    }

    protected void onGroupBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp == null) {
            QLog.i(TAG, 1, "onGroupBusiProtoResp() resp is null");
            return;
        }
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
                if (groupPicUpResp.result != 0) {
                    QLog.i(TAG, 1, "<BDH_LOG> onGroupBusiProtoResp() error : " + groupPicUpResp.result + " ,select HTTP channel");
                    this.mChannelStatus = 2;
                    onError();
                    return;
                }
                reportQuickSend(groupPicUpResp.isExist);
                if (groupPicUpResp.isExist) {
                    QLog.i(TAG, 1, "<BDH_LOG> onGroupBusiProtoResp() GroupPicUpResp.isExist. fileID: " + groupPicUpResp.groupFileID);
                    this.mIsPicSecondTransfered = true;
                    FileMsg fileMsg = this.file;
                    fileMsg.transferedSize = fileMsg.fileSize;
                    this.mFileID = groupPicUpResp.groupFileID;
                    this.mIpList = groupPicUpResp.mIpList;
                    sendMsg();
                } else {
                    sendMessageToUpdate(1002);
                    if (!checkContinueSend()) {
                        return;
                    }
                    this.mFileID = groupPicUpResp.groupFileID;
                    this.mUkey = groupPicUpResp.mUkey;
                    this.mIpList = groupPicUpResp.mIpList;
                    this.mTransferedSize = groupPicUpResp.transferedSize;
                    this.mBlockSize = groupPicUpResp.blockSize;
                    this.mStartOffset = groupPicUpResp.startOffset;
                    this.mChannelStatus = 1;
                    QLog.i(TAG, 1, "<BDH_LOG> About to submit Transaction , from onGroupBusiProtoResp. fileID: " + this.mFileID + " uuid:" + this.mUuid + " resId:" + this.mResid);
                    sendFileBDH();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        ad adVar = this.mUiRequest.mUpCallBack;
        if (adVar != null) {
            adVar.q(getSendResult());
        } else {
            updateMessageDataBaseContent(true);
        }
        sendMessageToUpdate(1003);
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        super.pause();
        if (!this.mIsPause) {
            this.mIsPause = true;
            if (QLog.isColorLevel()) {
                logRichMediaEvent("pause", "");
            }
            sendMessageToUpdate(1006);
            RichProto.RichProtoReq richProtoReq = this.mRichProtoReq;
            if (richProtoReq != null) {
                RichProtoProc.cancelRichProtoReq(richProtoReq);
                this.mRichProtoReq = null;
            }
            int i3 = this.mChannelStatus;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        log("<BDH_LOG> pause() pause HTTP channel");
                        NetReq netReq = this.mNetReq;
                        if (netReq != null) {
                            this.mNetEngine.cancelReq(netReq);
                            this.mNetReq = null;
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (this.mTrans != null) {
                    log("<BDH_LOG> pause() pause BDH channel, transation id=" + this.mTrans.getTransationId());
                    this.app.getHwEngine().stopTransactionTask(this.mTrans);
                    return;
                }
                log("<BDH_LOG> pause() pause BDH channel, but trans == null");
                return;
            }
            log("<BDH_LOG> pause() BUT current status is INIT");
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            sendMessageToUpdate(1002);
            if (this.mChannelStatus != 1) {
                this.mTransferedSize = 0L;
                this.mUkey = null;
            }
            this.mServerRollbackCount = 0;
            this.mTryCount = 0;
            this.mReqUrlCount = 0;
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.errCode = 0;
            processorReport.errDesc = "";
            this.sscmObject.e();
            resetStatictisInfo();
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.GroupPicUploadProcessor.4
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupPicUploadProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        GroupPicUploadProcessor.this.inter_retry();
                    }
                }
            });
        }
        return 0;
    }

    public void sendFileBDH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
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
        this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 2, this.mUiRequest.mLocalPath, (int) this.mStartOffset, HexUtil.hexStr2Bytes(this.mUkey), this.mLocalMd5, new ITransactionCallback() { // from class: com.tencent.mobileqq.transfile.GroupPicUploadProcessor.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupPicUploadProcessor.this);
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
                QLog.i(GroupPicUploadProcessor.TAG, 1, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - GroupPicUploadProcessor.this.startTime) + "ms");
                GroupPicUploadProcessor.this.addBDHReportInfo(hashMap);
                GroupPicUploadProcessor groupPicUploadProcessor = GroupPicUploadProcessor.this;
                groupPicUploadProcessor.setError(i3, "OnFailed.", "", groupPicUploadProcessor.mProcessorReport.mStepTrans);
                GroupPicUploadProcessor.this.onError();
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
                QLog.i(GroupPicUploadProcessor.TAG, 1, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - GroupPicUploadProcessor.this.startTime) + "ms ,fileSize:" + GroupPicUploadProcessor.this.file.fileSize + " transInfo:" + hashMap.get(TransReport.rep_bdhTrans));
                GroupPicUploadProcessor.this.addBDHReportInfo(hashMap);
                GroupPicUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                GroupPicUploadProcessor groupPicUploadProcessor = GroupPicUploadProcessor.this;
                groupPicUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                groupPicUploadProcessor.mTransferedSize = groupPicUploadProcessor.mFileSize;
                groupPicUploadProcessor.uploadSuccess = true;
                groupPicUploadProcessor.sendMsg();
                GroupPicUploadProcessor.this.file.closeInputStream();
                GroupPicUploadProcessor.this.reportForServerMonitor(true, 0, hashMap.get("ip"), hashMap.get("port"));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                GroupPicUploadProcessor.this.log("<BDH_LOG> onSwitch2BackupChannel() switch to HTTP channel");
                GroupPicUploadProcessor groupPicUploadProcessor = GroupPicUploadProcessor.this;
                groupPicUploadProcessor.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis - groupPicUploadProcessor.startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                } else {
                    GroupPicUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                GroupPicUploadProcessor groupPicUploadProcessor = GroupPicUploadProcessor.this;
                long j3 = i3;
                groupPicUploadProcessor.file.transferedSize = j3;
                groupPicUploadProcessor.mTransferedSize = j3;
                if (j3 < groupPicUploadProcessor.mFileSize && !groupPicUploadProcessor.mIsCancel && !groupPicUploadProcessor.mIsPause) {
                    groupPicUploadProcessor.sendProgressMessage();
                    if (GroupPicUploadProcessor.this.isStoryPhoto) {
                        IPeakIpcController iPeakIpcController = (IPeakIpcController) QRoute.api(IPeakIpcController.class);
                        GroupPicUploadProcessor groupPicUploadProcessor2 = GroupPicUploadProcessor.this;
                        iPeakIpcController.updatePeakVideoAndPicStatus(groupPicUploadProcessor2.picMsg, 1002, groupPicUploadProcessor2.getProgress());
                    }
                }
            }
        });
        this.mTrans.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.GroupPicUploadProcessor.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public void onFailed(int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                } else {
                    GroupPicUploadProcessor.this.reportForServerMonitor(false, i3, str, str2);
                }
            }
        };
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        QLog.i(TAG, 1, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:2");
        if (submitTransactionTask != 0) {
            setError(submitTransactionTask, "SubmitError.", "", this.mProcessorReport.mStepTrans);
            onError();
        }
    }

    void sendGroupMsg() {
        MessageRecord messageRecord;
        String str;
        if (this.needSendMsg && !this.mUiRequest.mIsPresend) {
            im_msg_body$RichText constructPicRichText = constructPicRichText();
            if (constructPicRichText == null) {
                setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, this.mProcessorReport.mStepMsg);
                onError();
                return;
            }
            if (!isAppValid()) {
                setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, this.mProcessorReport.mStepMsg);
                onError();
                return;
            }
            TransferRequest transferRequest = this.mUiRequest;
            ad adVar = transferRequest.mUpCallBack;
            if (adVar != null) {
                messageRecord = adVar.g(constructPicRichText);
            } else {
                messageRecord = transferRequest.mRec;
                if (messageRecord == null) {
                    IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
                    TransferRequest transferRequest2 = this.mUiRequest;
                    messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq);
                }
            }
            if (messageRecord != null && ((messageRecord instanceof MessageForPic) || ((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord))) {
                fillMessageRecord(constructPicRichText, messageRecord);
                addInfoToMsg();
                ((IOrderMediaMsgService) this.app.getRuntimeService(IOrderMediaMsgService.class, "")).sendOrderMsg(messageRecord, this.messageObserver, this);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Mr_");
            if (messageRecord == null) {
                str = "null";
            } else {
                str = "" + messageRecord.msgtype;
            }
            sb5.append(str);
            setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "msgtypeError", sb5.toString(), this.mProcessorReport.mStepMsg);
            onError();
            return;
        }
        TransferRequest transferRequest3 = this.mUiRequest;
        if (transferRequest3.mIsPresend) {
            ((MessageForPic) transferRequest3.mRec).mPresendTransferedSize = this.mTransferedSize;
        }
        im_msg_body$RichText constructPicRichText2 = constructPicRichText();
        if (constructPicRichText2 == null) {
            setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, this.mProcessorReport.mStepMsg);
            onError();
        } else if (!isAppValid()) {
            setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, this.mProcessorReport.mStepMsg);
            onError();
            return;
        } else {
            ad adVar2 = this.mUiRequest.mUpCallBack;
            if (adVar2 != null) {
                adVar2.g(constructPicRichText2);
            }
        }
        TransferRequest transferRequest4 = this.mUiRequest;
        if (transferRequest4.mIsPresend && this.mIsPicSecondTransfered) {
            ((MessageForPic) transferRequest4.mRec).mPresendTransferedSize = 0L;
        }
        addInfoToMsg();
        onSuccess();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void sendMessageToUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, i3);
            return;
        }
        super.sendMessageToUpdate(i3);
        if (this.isStoryPhoto) {
            ((IPeakIpcController) QRoute.api(IPeakIpcController.class)).updatePeakVideoAndPicStatus(this.picMsg, i3, getProgress());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMsg() {
        if (!canDoNextStep()) {
            log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
            return;
        }
        this.mProcessorReport.mStepMsg.logStartTime();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
        }
        sendGroupMsg();
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor
    protected void sendRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
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
        richProtoReq.protoKey = RichProtoProc.GRP_PIC_UP;
        richProtoReq.reqs.add(picUpReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, this.mProcessorReport.mStepUrl);
            onError();
            return;
        }
        logRichMediaEvent("requestStart", richProtoReq.toString());
        if (!canDoNextStep()) {
            return;
        }
        this.mRichProtoReq = richProtoReq;
        RichProtoProc.procRichProtoReq(richProtoReq);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void setMtype() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        int i3 = this.mUiRequest.mFileType;
        NetReq netReq = this.mNetReq;
        if (netReq instanceof HttpNetReq) {
            if (this.mIsGroup) {
                if (i3 != 2) {
                    ((HttpNetReq) netReq).mReqUrl = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_PIC_GU, ((HttpNetReq) netReq).mReqUrl);
                    return;
                }
                return;
            }
            if (i3 != 2) {
                ((HttpNetReq) netReq).mReqUrl = MsfSdkUtils.insertMtype(AppConstants.HTTP_TYPE_PIC_DU, ((HttpNetReq) netReq).mReqUrl);
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.start();
            doStart(false);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor
    public void updateMessageData(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            messageForPic.path = this.mUiRequest.mLocalPath;
            messageForPic.size = this.mFileSize;
            messageForPic.uuid = this.mFileName;
            messageForPic.groupFileID = this.mFileID;
            messageForPic.md5 = this.mMd5Str;
            messageForPic.type = 1;
            messageForPic.serial();
            IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
            TransferRequest transferRequest = this.mUiRequest;
            iMessageFacade.updateMsgContentByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, messageRecord.uniseq, messageForPic.msgData);
            return;
        }
        if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
            IMsgStructing iMsgStructing = (IMsgStructing) QRoute.api(IMsgStructing.class);
            AppInterface appInterface = this.app;
            String str = this.mMd5Str;
            String str2 = this.mResid;
            if (str2 == null) {
                str2 = this.mUuid;
            }
            String str3 = str2;
            long j3 = this.mFileSize;
            Long valueOf = Long.valueOf(this.mFileID);
            TransferRequest transferRequest2 = this.mUiRequest;
            iMsgStructing.updateMsgAfterUpload(appInterface, messageRecord, str, str3, j3, valueOf, transferRequest2.mPeerUin, transferRequest2.mUinType);
        }
    }
}

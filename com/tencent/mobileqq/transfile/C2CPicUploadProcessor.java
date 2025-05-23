package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.aelight.camera.qqstory.api.IPeakIpcController;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
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
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.openup.OpenUpConfig;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
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
import com.tencent.mobileqq.utils.bv;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import mqq.manager.MainTicketCallback;
import mqq.manager.MainTicketInfo;
import mqq.manager.TicketManager;
import org.slf4j.Marker;
import tencent.im.msg.hummer.resv6.NotOnlineImageExtPb$ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NotOnlineImage;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;

/* loaded from: classes19.dex */
public class C2CPicUploadProcessor extends BasePicUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "C2CPicUploadProcessor";
    private boolean isStoryPhoto;
    protected BaseTransFileController mController;
    protected byte[] mExtendInfo;
    protected boolean mIsOpenUpEnable;
    protected CSDataHighwayHead.LoginSigHead mLoginSigHead;
    protected byte[] mOpenUpTicket;
    private int mPreSendDots;
    private byte[] mSessionKey;
    private byte[] mSigSession;
    private StepInfo mStepTransLeft;
    private StepInfo mStepTransPre;
    bo messageObserver;
    private MessageForPic picMsg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public interface LoginSigHeadCallBack {
        void onResult(CSDataHighwayHead.LoginSigHead loginSigHead);
    }

    public C2CPicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mStepTransPre = new StepInfo();
        this.mStepTransLeft = new StepInfo();
        this.isStoryPhoto = false;
        this.messageObserver = new bo() { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bo
            public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                    return;
                }
                C2CPicUploadProcessor.this.logRichMediaEvent("sendMsgFinish", "success:" + z16);
                ProcessorReport processorReport = C2CPicUploadProcessor.this.mProcessorReport;
                processorReport.copyStatisInfo(processorReport.mStepMsg, false, z16, statictisInfo);
                if (z16) {
                    C2CPicUploadProcessor.this.onSuccess();
                    return;
                }
                if (statictisInfo != null) {
                    C2CPicUploadProcessor.this.shouldMsgReportSucc = statictisInfo.reportSucc;
                }
                C2CPicUploadProcessor.this.onError();
            }
        };
        this.mController = baseTransFileController;
        FileMsg fileMsg = this.file;
        TransferRequest transferRequest2 = this.mUiRequest;
        fileMsg.fileType = transferRequest2.mFileType;
        fileMsg.uniseq = transferRequest2.mUniseq;
        fileMsg.actionType = 0;
        fileMsg.friendUin = transferRequest2.mPeerUin;
        fileMsg.uinType = 0;
        fileMsg.processorDoReportSelf = true;
        this.mIsOpenUpEnable = OpenUpConfig.isOpenUpEnable;
        this.mPreSendDots = OpenUpConfig.getPreSendDots(BaseApplication.getContext());
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null || !(messageRecord instanceof MessageForPic)) {
            return;
        }
        boolean z16 = ((MessageForPic) messageRecord).isStoryPhoto;
        this.isStoryPhoto = z16;
        if (z16) {
            this.picMsg = (MessageForPic) messageRecord;
        }
    }

    private im_msg_body$RichText constructRichText() {
        int i3;
        NotOnlineImageExtPb$ResvAttr notOnlineImageExtPb$ResvAttr;
        try {
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$NotOnlineImage im_msg_body_notonlineimage = new im_msg_body$NotOnlineImage();
            changeRichText();
            im_msg_body_notonlineimage.file_path.set(ByteStringMicro.copyFromUtf8(this.mFileName));
            String str = this.file.uuidPath;
            if (str != null) {
                im_msg_body_notonlineimage.download_path.set(ByteStringMicro.copyFromUtf8(str));
            }
            String str2 = this.file.serverPath;
            if (str2 != null) {
                im_msg_body_notonlineimage.res_id.set(ByteStringMicro.copyFromUtf8(str2));
            }
            im_msg_body_notonlineimage.file_len.set((int) this.mFileSize);
            im_msg_body_notonlineimage.pic_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
            im_msg_body_notonlineimage.pic_height.set(this.mHeight);
            im_msg_body_notonlineimage.pic_width.set(this.mWidth);
            PBUInt32Field pBUInt32Field = im_msg_body_notonlineimage.original;
            if (this.mIsRawPic) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            pBUInt32Field.set(i3);
            MessageRecord messageRecord = this.mUiRequest.mRec;
            if (MessageForPic.class.isInstance(messageRecord)) {
                MessageForPic messageForPic = (MessageForPic) messageRecord;
                im_msg_body_notonlineimage.uint32_show_len.set(messageForPic.mShowLength);
                im_msg_body_notonlineimage.uint32_download_len.set(messageForPic.mDownloadLength);
                im_msg_body_notonlineimage.img_type.set(messageForPic.imageType);
                PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
                if (picMessageExtraData != null) {
                    notOnlineImageExtPb$ResvAttr = picMessageExtraData.getOfflineImageResvAttr();
                    if (QLog.isColorLevel()) {
                        QLog.d("picExtra", 4, "imageBizType: " + messageForPic.picExtraData.imageBizType);
                    }
                } else {
                    notOnlineImageExtPb$ResvAttr = new NotOnlineImageExtPb$ResvAttr();
                    if (QLog.isColorLevel()) {
                        QLog.d("picExtra", 4, "imageBizType: 0");
                    }
                }
                int picSourceReport = getPicSourceReport(messageForPic, this.mUiRequest.mPicSendSource);
                if (QLog.isColorLevel()) {
                    QLog.d("picExtra", 4, "source: " + picSourceReport);
                }
                notOnlineImageExtPb$ResvAttr.uint32_source.set(picSourceReport);
                im_msg_body_notonlineimage.bytes_pb_reserve.set(ByteStringMicro.copyFrom(notOnlineImageExtPb$ResvAttr.get().toByteArray()), true);
            }
            im_msg_body_notonlineimage.biz_type.set(getReportBizType());
            if (QLog.isColorLevel()) {
                logRichMediaEvent("busiTypeStat", "uiBusiType:" + this.mUiRequest.mBusiType + " protoBusiType:" + im_msg_body_notonlineimage.biz_type.get());
            }
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            if (ac.c(messageRecord)) {
                im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
                im_msg_body_commonelem.uint32_service_type.set(3);
                hummer_commelem$MsgElemInfo_servtype3 hummer_commelem_msgeleminfo_servtype3 = new hummer_commelem$MsgElemInfo_servtype3();
                hummer_commelem_msgeleminfo_servtype3.flash_c2c_pic.set(im_msg_body_notonlineimage);
                im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(hummer_commelem_msgeleminfo_servtype3.toByteArray()));
                im_msg_body_elem.common_elem.set(im_msg_body_commonelem);
                im_msg_body_richtext.elems.add(im_msg_body_elem);
                if (QLog.isColorLevel()) {
                    QLog.d("flash", 2, "C2CPicUploadProcessor constructPicRichText send flash");
                }
                im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
                im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.qqStr(R.string.f171683k62)));
                im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
                im_msg_body_elem2.text.set(im_msg_body_text);
                im_msg_body_richtext.elems.add(im_msg_body_elem2);
            } else {
                im_msg_body_elem.not_online_image.set(im_msg_body_notonlineimage);
                im_msg_body_richtext.elems.add(im_msg_body_elem);
            }
            IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
            TransferRequest transferRequest = this.mUiRequest;
            MessageRecord msgItemByUniseq = iMessageFacade.getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(msgItemByUniseq)) {
                IMsgStructing iMsgStructing = (IMsgStructing) QRoute.api(IMsgStructing.class);
                String str3 = this.mMd5Str;
                String str4 = this.mResid;
                if (str4 == null) {
                    str4 = this.mUuid;
                }
                iMsgStructing.uploadPicConstructRichText(msgItemByUniseq, str3, str4, this.mFileSize, null, im_msg_body_richtext);
                return im_msg_body_richtext;
            }
            return im_msg_body_richtext;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("C2CPicUploadProcessor", 2, "Construct richtext error", e16);
            }
            e16.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealSendRequest() {
        if (this.mOpenUpTicket != null && this.mLoginSigHead != null) {
            if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mOpenUpTicket: " + this.mOpenUpTicket + " mLoginSigHead:" + this.mLoginSigHead);
            }
            sendRequest();
            sendFileBDH();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> set mIsOpenUpEnable false");
        }
        this.mIsOpenUpEnable = false;
        sendRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CSDataHighwayHead.LoginSigHead getLoginSigHead(String str) {
        byte[] bytes;
        CSDataHighwayHead.LoginSigHead loginSigHead = new CSDataHighwayHead.LoginSigHead();
        if (str != null) {
            try {
                bytes = str.getBytes("utf-8");
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return null;
            }
        } else {
            bytes = null;
        }
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        loginSigHead.bytes_loginsig.set(ByteStringMicro.copyFrom(bytes));
        loginSigHead.uint32_loginsig_type.set(8);
        return loginSigHead;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parseExtInfo(byte[] bArr) {
        byte[] decrypt;
        if (bArr != null && bArr.length != 0) {
            CSDataHighwayHead.PicRspExtInfo picRspExtInfo = new CSDataHighwayHead.PicRspExtInfo();
            try {
                picRspExtInfo.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.d("C2CPicUploadProcessor", 2, e16.getMessage());
                }
            }
            if (!picRspExtInfo.bytes_skey.has()) {
                return;
            }
            byte[] byteArray = picRspExtInfo.bytes_skey.get().toByteArray();
            byte[] bArr2 = new byte[byteArray.length];
            System.arraycopy(byteArray, 0, bArr2, 0, byteArray.length);
            if (QLog.isColorLevel()) {
                QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> byte_skey.length:" + byteArray.length);
            }
            Cryptor cryptor = new Cryptor();
            byte[] bArr3 = this.mSessionKey;
            if (bArr3 != null && (decrypt = cryptor.decrypt(bArr2, 0, byteArray.length, bArr3)) != null && decrypt.length > 36) {
                if (QLog.isColorLevel()) {
                    QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> result.length:" + decrypt.length);
                }
                byte[] bArr4 = new byte[decrypt.length];
                System.arraycopy(decrypt, 0, bArr4, 0, decrypt.length);
                int i3 = ByteBuffer.wrap(bArr4).getShort(34);
                char[] cArr = new char[i3];
                for (int i16 = 0; i16 < i3; i16++) {
                    cArr[i16] = (char) bArr4[i16 + 36];
                }
                String valueOf = String.valueOf(cArr);
                if (QLog.isColorLevel()) {
                    QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> fileIdStr:" + valueOf);
                }
                FileMsg fileMsg = this.file;
                fileMsg.serverPath = valueOf;
                this.mResid = valueOf;
                fileMsg.uuidPath = valueOf;
                this.mUuid = valueOf;
            }
        }
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

    private void sendFileNotBlockCallThread() {
        this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                C2CPicUploadProcessor c2CPicUploadProcessor = C2CPicUploadProcessor.this;
                if (c2CPicUploadProcessor.mTrans != null) {
                    c2CPicUploadProcessor.log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel");
                    C2CPicUploadProcessor.this.app.getHwEngine().resumeTransactionTask(C2CPicUploadProcessor.this.mTrans);
                } else {
                    c2CPicUploadProcessor.log("<BDH_LOG> sendFileNotBlockCallThread() resume BDH channel, but trans == null");
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
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
        String str = this.mUiRequest.mLocalPath;
        if (TextUtils.isEmpty(str)) {
            this.mProcessorReport.setError(9302, BaseTransProcessor.getExpStackString(new Exception("filePath null")), null, null);
            onError();
            return -1;
        }
        File file = getFile(str);
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
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this);
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
        if (length >= ((IPicBus) QRoute.api(IPicBus.class)).getC2CPicSizeLimit()) {
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

    protected void doRealReport(boolean z16, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Long.valueOf(j3), Long.valueOf(j16));
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
                    QLog.d("C2CPicUploadProcessor", 2, "doReport ,mStartTime = " + this.mProcessorReport.mStartTime + ",mEnterAioTime = " + this.mEnterAioTime + ",finishTime  = " + j16 + ", aioDuration = " + j18 + ", duration = " + j3 + "processor:" + this + ",mUiRequest.myPresendInvalid = " + this.mUiRequest.myPresendInvalid + ",Percent = " + d16);
                }
            }
            this.mProcessorReport.reportForIpv6(true, j3, true, getReportTAG());
            HashMap<String, String> hashMap = new HashMap<>();
            for (Map.Entry<String, String> entry : this.mProcessorReport.mReportInfo.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, j3, this.mFileSize, hashMap, "");
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
            this.mProcessorReport.mReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(this.mUiRequest.mUinType));
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
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
        String str3 = this.mStepTransPre.getReportInfo(21) + ";" + this.mStepTransLeft.getReportInfo(22);
        if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> stepParam: " + str2);
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> openUpSetpParam: " + str3);
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> mStepUrl: " + this.mProcessorReport.mStepUrl.toString() + ";mStepTrans: " + this.mProcessorReport.mStepTrans.toString() + ";mStepMsg: " + this.mProcessorReport.mStepMsg.toString() + ";mStepTransPre: " + this.mStepTransPre.toString() + ";mStepTransLeft: " + this.mStepTransLeft.toString() + ";");
        }
        if (!z17) {
            String str4 = this.mProcessorReport.mReportInfo.get(ReportConstant.KEY_REASON);
            if ("connError_unreachable".equalsIgnoreCase(str4)) {
                this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_REASON, "N_1");
            } else if ("connError_noroute".equalsIgnoreCase(str4)) {
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
                    sb7.append("SendC2CPic, cost=");
                    StepInfo stepInfo = this.mProcessorReport.mStepTrans;
                    sb7.append((stepInfo.finishTime - stepInfo.startTime) / 1000000);
                    Log.i("AutoMonitor", sb7.toString());
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, str2);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_OPEN_UP_STEP_INFO, str3);
                    HashMap<String, String> hashMap = this.mProcessorReport.mReportInfo;
                    String str5 = this.mResid;
                    if (str5 == null) {
                        str5 = this.mUuid;
                    }
                    hashMap.put(ReportConstant.KEY_UUID, str5);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_TO_UIN, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_MD5, this.mFileName);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_PRESEND, this.mUiRequest.mIsPresend + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_SECOND_TRANS, this.mIsPicSecondTransfered + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PHONE_TYPE, ah.u() + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_NET_TYPE, NetworkUtil.getSystemNetwork(BaseApplication.getContext()) + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IS_RAW_PIC, this.mIsRawPic + "");
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    processorReport2.mReportInfo.put(ReportConstant.KEY_SENDBY_QUICK_HTTP, String.valueOf(processorReport2.mSendByQuickHttp));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_TYPE, String.valueOf(this.mPicType));
                    this.mProcessorReport.mReportInfo.put("param_busi", String.valueOf(this.mUiRequest.mBusiType));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IS_OPEN_UP, String.valueOf(this.mIsOpenUpEnable));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SOURCE_TYPE, String.valueOf(this.mUiRequest.isQzonePic ? 1 : 0));
                    doRealReport(z17, j3, nanoTime);
                }
            }
        }
    }

    protected void doStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
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
        if (!checkFileStandard(true)) {
            return;
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
                makeLoginSigHead(new LoginSigHeadCallBack() { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.2
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this);
                        }
                    }

                    @Override // com.tencent.mobileqq.transfile.C2CPicUploadProcessor.LoginSigHeadCallBack
                    public void onResult(CSDataHighwayHead.LoginSigHead loginSigHead) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) loginSigHead);
                            return;
                        }
                        C2CPicUploadProcessor c2CPicUploadProcessor = C2CPicUploadProcessor.this;
                        c2CPicUploadProcessor.mLoginSigHead = loginSigHead;
                        c2CPicUploadProcessor.dealSendRequest();
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

    File getFile(String str) {
        return new File(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (this.mChannelStatus == 1) {
            return StatisticCollector.C2C_PICUP_STATISTIC_TAG_V2;
        }
        return StatisticCollector.C2C_PICUP_STATISTIC_TAG;
    }

    void internal_retry() {
        if (this.mIsCancel) {
            return;
        }
        if (this.mResid == null && this.mUuid == null) {
            start();
        } else if (this.mTransferedSize >= this.mFileSize) {
            sendMsg();
        } else {
            sendFileNotBlockCallThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] makeExtendInfo() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (byte[]) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        CSDataHighwayHead.PicInfoExt picInfoExt = new CSDataHighwayHead.PicInfoExt();
        int i16 = 1;
        picInfoExt.uint32_busi_type.set(1);
        int i17 = 5;
        picInfoExt.uint32_src_term.set(5);
        picInfoExt.uint32_plat_type.set(9);
        int netType = NetworkCenter.getInstance().getNetType();
        if (netType != 1) {
            i3 = 6;
            if (netType != 2) {
                if (netType != 3) {
                    if (netType == 4) {
                        i3 = 8;
                    }
                } else {
                    i3 = 7;
                }
            }
        } else {
            i3 = 3;
        }
        String apnType = NetworkCenter.getInstance().getApnType();
        if (apnType == null || !apnType.contains("wap")) {
            i17 = i3;
        }
        picInfoExt.uint32_net_type.set(i17);
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (MessageForPic.class.isInstance(messageRecord)) {
            picInfoExt.uint32_img_type.set(((MessageForPic) messageRecord).imageType);
        }
        picInfoExt.uint32_app_pic_type.set(1);
        picInfoExt.uint32_pic_width.set(this.mWidth);
        picInfoExt.uint32_pic_height.set(this.mHeight);
        if (this.mIsRawPic) {
            i16 = 3;
        }
        picInfoExt.uint32_pic_flag.set(i16);
        return picInfoExt.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CSDataHighwayHead.LoginSigHead makeLoginSigHead(LoginSigHeadCallBack loginSigHeadCallBack) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (CSDataHighwayHead.LoginSigHead) iPatchRedirector.redirect((short) 9, (Object) this, (Object) loginSigHeadCallBack);
        }
        TicketManager ticketManager = (TicketManager) this.app.getManager(2);
        if (ticketManager == null || TextUtils.isEmpty(this.app.getAccount())) {
            return null;
        }
        if (ticketManager.useAsyncTicketInterface()) {
            ticketManager.getA2(bv.b(this.app.getCurrentUin(), 0L), 16, new MainTicketCallback(loginSigHeadCallBack) { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.6
                static IPatchRedirector $redirector_;
                final /* synthetic */ LoginSigHeadCallBack val$callBack;

                {
                    this.val$callBack = loginSigHeadCallBack;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this, (Object) loginSigHeadCallBack);
                    }
                }

                @Override // mqq.manager.MainTicketCallback
                public void onFail(int i3, String str) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                        iPatchRedirector2.redirect((short) 3, (Object) this, i3, (Object) str);
                        return;
                    }
                    QLog.i("C2CPicUploadProcessor", 1, "makeLoginSigHead async get login ticket fail");
                    LoginSigHeadCallBack loginSigHeadCallBack2 = this.val$callBack;
                    if (loginSigHeadCallBack2 != null) {
                        loginSigHeadCallBack2.onResult(null);
                    }
                }

                @Override // mqq.manager.MainTicketCallback
                public void onSuccess(MainTicketInfo mainTicketInfo) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) mainTicketInfo);
                        return;
                    }
                    QLog.i("C2CPicUploadProcessor", 1, "makeLoginSigHead async get login ticket success");
                    LoginSigHeadCallBack loginSigHeadCallBack2 = this.val$callBack;
                    if (loginSigHeadCallBack2 != null) {
                        loginSigHeadCallBack2.onResult(C2CPicUploadProcessor.this.getLoginSigHead(mainTicketInfo.getA2()));
                    }
                }
            });
            return null;
        }
        return getLoginSigHead(ticketManager.getA2(this.app.getAccount()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public byte[] makeOpenUpTicket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        byte[] sessionKey = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey();
        this.mSessionKey = sessionKey;
        if (sessionKey != null && sessionKey.length != 0) {
            byte[] httpconn_sig_session = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session();
            this.mSigSession = httpconn_sig_session;
            if (httpconn_sig_session != null && httpconn_sig_session.length != 0) {
                try {
                    long longValue = Long.valueOf(this.mUiRequest.mSelfUin).longValue();
                    String str = this.mUiRequest.mPeerUin;
                    if (str.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                        str = str.substring(1);
                    }
                    long longValue2 = Long.valueOf(str).longValue();
                    int i3 = (int) this.mFileSize;
                    int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
                    byte[] bArr = this.mLocalMd5;
                    if (bArr != null && bArr.length != 0) {
                        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 56 + 8);
                        allocate.putInt(0, 1).putLong(4, longValue).putLong(12, longValue2).putInt(20, i3).putInt(24, currentTimeMillis);
                        byte[] array = allocate.array();
                        System.arraycopy(bArr, 0, array, 28, bArr.length);
                        byte[] encrypt = new Cryptor().encrypt(array, this.mSessionKey);
                        if (encrypt != null && encrypt.length != 0) {
                            CSDataHighwayHead.NewServiceTicket newServiceTicket = new CSDataHighwayHead.NewServiceTicket();
                            newServiceTicket.bytes_ukey.set(ByteStringMicro.copyFrom(encrypt));
                            newServiceTicket.bytes_signature.set(ByteStringMicro.copyFrom(this.mSigSession));
                            return newServiceTicket.toByteArray();
                        }
                        if (QLog.isColorLevel()) {
                            QLog.e("C2CPicUploadProcessor", 2, "ukey is null ");
                        }
                        return null;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.e("C2CPicUploadProcessor", 2, "md5 is null ");
                    }
                    return null;
                } catch (Exception e16) {
                    QLog.e("C2CPicUploadProcessor", 2, "makeOpenUpTicket error", e16);
                    return null;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> signature is null ");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.e("C2CPicUploadProcessor", 2, "<BDH_LOG> sessionKey is null ");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
        } else {
            super.onBusiProtoResp(richProtoReq, richProtoResp);
            onC2CBusiProtoResp(richProtoReq, richProtoResp);
        }
    }

    protected void onC2CBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        Transaction transaction;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp == null) {
            QLog.i("C2CPicUploadProcessor", 1, "onC2CBusiProtoResp() resp is null");
            return;
        }
        for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
            RichProto.RichProtoResp.C2CPicUpResp c2CPicUpResp = (RichProto.RichProtoResp.C2CPicUpResp) richProtoResp.resps.get(i3);
            if (QLog.isColorLevel()) {
                logRichMediaEvent("procUrl", c2CPicUpResp.toString());
            }
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.mSendByQuickHttp = c2CPicUpResp.isSendByQuickHttp;
            processorReport.copyRespCommon(processorReport.mStepUrl, c2CPicUpResp);
            if (c2CPicUpResp.result != 0) {
                QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> onBusiProtoResp() error : " + c2CPicUpResp.result + " ,select HTTP channel");
                this.mChannelStatus = 2;
                Transaction transaction2 = this.mTrans;
                if (transaction2 == null) {
                    onError();
                    return;
                }
                if (!this.mIsOpenUpEnable || !transaction2.isFinish.get() || !this.mTrans.isSuccess.get()) {
                    if (this.mIsOpenUpEnable && this.mTrans != null) {
                        this.app.getHwEngine().cancelTransactionTask(this.mTrans);
                    }
                    onError();
                    return;
                }
                return;
            }
            reportQuickSend(c2CPicUpResp.isExist);
            if (c2CPicUpResp.isExist) {
                QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> onC2CBusiProtoResp() picUpResp.isExist, uuid=" + c2CPicUpResp.mUuid + ", resid=" + c2CPicUpResp.mResid);
                this.mIsPicSecondTransfered = true;
                FileMsg fileMsg = this.file;
                fileMsg.transferedSize = fileMsg.fileSize;
                String str = c2CPicUpResp.mResid;
                fileMsg.serverPath = str;
                this.mResid = str;
                String str2 = c2CPicUpResp.mUuid;
                fileMsg.uuidPath = str2;
                this.mUuid = str2;
                if (this.mIsOpenUpEnable) {
                    Transaction transaction3 = this.mTrans;
                    if (transaction3 != null && (!transaction3.isFinish.get() || !this.mTrans.isSuccess.get())) {
                        this.mTrans.cancelTransaction();
                        sendMsg();
                    }
                } else {
                    sendMsg();
                }
            } else {
                sendMessageToUpdate(1002);
                if (!checkContinueSend()) {
                    return;
                }
                if (this.mIsOpenUpEnable && (transaction = this.mTrans) != null && transaction.isFinish.get() && this.mTrans.isSuccess.get()) {
                    return;
                }
                if (!this.mIsOpenUpEnable) {
                    FileMsg fileMsg2 = this.file;
                    String str3 = c2CPicUpResp.mResid;
                    fileMsg2.serverPath = str3;
                    this.mResid = str3;
                    String str4 = c2CPicUpResp.mUuid;
                    fileMsg2.uuidPath = str4;
                    this.mUuid = str4;
                } else {
                    StepInfo stepInfo = this.mProcessorReport.mStepTrans;
                    stepInfo.startTime = 0L;
                    stepInfo.logStartTime();
                }
                this.mUkey = c2CPicUpResp.mUkey;
                this.mStartOffset = c2CPicUpResp.startOffset;
                QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> About to submit Transaction , from onC2CBusiProtoResp. uuid:" + this.mUuid + " resId:" + this.mResid);
                this.mChannelStatus = 1;
                if (this.mIsOpenUpEnable) {
                    Transaction transaction4 = this.mTrans;
                    if (transaction4 != null) {
                        transaction4.continueTrans();
                        this.mStepTransLeft.logStartTime();
                    }
                } else {
                    sendFileBDH();
                }
            }
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
        QLog.i("C2CPicUploadProcessor", 1, "onError()  errCode:" + this.mProcessorReport.errCode + " errDesc:" + this.mProcessorReport.errDesc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            aVar.f258601e = this.mFileSize;
            aVar.f258603g = this.mMd5Str;
            String str = this.mResid;
            if (str == null) {
                str = this.mUuid;
            }
            aVar.f258602f = str;
            if (this.mUiRequest.isShareImageByServer) {
                aVar.f258608l = getImageInfo();
            }
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

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            sendMessageToUpdate(1002);
            this.mServerRollbackCount = 0;
            this.mTryCount = 0;
            if (this.mChannelStatus != 1) {
                this.mResid = null;
                this.mUuid = null;
                this.mTransferedSize = 0L;
            }
            this.mUkey = null;
            this.mReqUrlCount = 0;
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.errCode = 0;
            processorReport.errDesc = "";
            this.sscmObject.e();
            resetStatictisInfo();
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        C2CPicUploadProcessor.this.internal_retry();
                    }
                }
            });
        }
        return 0;
    }

    public void sendFileBDH() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction submit:sendFile:" + this.mTrans + "  this:" + this);
        }
        if (this.mIsOpenUpEnable) {
            this.mStepTransPre.logStartTime();
        } else {
            this.mProcessorReport.mStepTrans.logStartTime();
        }
        if (this.mTrans != null) {
            return;
        }
        byte[] hexStr2Bytes = HexUtil.hexStr2Bytes(this.mUkey);
        ITransactionCallback iTransactionCallback = new ITransactionCallback(SystemClock.uptimeMillis()) { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.4
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = r6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, C2CPicUploadProcessor.this, Long.valueOf(r6));
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
                QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms");
                C2CPicUploadProcessor.this.addBDHReportInfo(hashMap);
                C2CPicUploadProcessor c2CPicUploadProcessor = C2CPicUploadProcessor.this;
                c2CPicUploadProcessor.setError(i3, "OnFailed.", "", c2CPicUploadProcessor.mProcessorReport.mStepTrans);
                C2CPicUploadProcessor.this.onError();
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
                QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms ,fileSize:" + C2CPicUploadProcessor.this.file.fileSize + " transInfo:" + hashMap.get(TransReport.rep_bdhTrans));
                C2CPicUploadProcessor.this.addBDHReportInfo(hashMap);
                C2CPicUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                C2CPicUploadProcessor c2CPicUploadProcessor = C2CPicUploadProcessor.this;
                c2CPicUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                c2CPicUploadProcessor.mStepTransLeft.logFinishTime();
                C2CPicUploadProcessor.this.mStepTransLeft.result = 1;
                C2CPicUploadProcessor c2CPicUploadProcessor2 = C2CPicUploadProcessor.this;
                c2CPicUploadProcessor2.mTransferedSize = c2CPicUploadProcessor2.mFileSize;
                c2CPicUploadProcessor2.uploadSuccess = true;
                if (c2CPicUploadProcessor2.mIsOpenUpEnable) {
                    c2CPicUploadProcessor2.parseExtInfo(bArr);
                }
                C2CPicUploadProcessor.this.sendMsg();
                C2CPicUploadProcessor.this.file.closeInputStream();
                C2CPicUploadProcessor.this.reportForServerMonitor(true, 0, hashMap.get("ip"), hashMap.get("port"));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                C2CPicUploadProcessor.this.log("<BDH_LOG> onSwitch2BackupChannel()");
                C2CPicUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis - this.val$startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                C2CPicUploadProcessor.this.log("<BDH_LOG> onTransStart()");
                StepInfo stepInfo = C2CPicUploadProcessor.this.mProcessorReport.mStepTrans;
                stepInfo.startTime = 0L;
                stepInfo.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                    return;
                }
                C2CPicUploadProcessor c2CPicUploadProcessor = C2CPicUploadProcessor.this;
                long j3 = i3;
                c2CPicUploadProcessor.file.transferedSize = j3;
                c2CPicUploadProcessor.mTransferedSize = j3;
                if (j3 < c2CPicUploadProcessor.mFileSize && !c2CPicUploadProcessor.mIsCancel && !c2CPicUploadProcessor.mIsPause) {
                    if (c2CPicUploadProcessor.mIsOpenUpEnable && i3 >= c2CPicUploadProcessor.mPreSendDots * 8192) {
                        C2CPicUploadProcessor.this.mStepTransPre.logFinishTime();
                        C2CPicUploadProcessor.this.mStepTransPre.result = 1;
                    }
                    C2CPicUploadProcessor.this.sendProgressMessage();
                    if (C2CPicUploadProcessor.this.isStoryPhoto) {
                        ((IPeakIpcController) QRoute.api(IPeakIpcController.class)).updatePeakVideoAndPicStatus(C2CPicUploadProcessor.this.picMsg, 1002, C2CPicUploadProcessor.this.getProgress());
                    }
                }
            }
        };
        if (this.mIsOpenUpEnable) {
            this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 4, this.mUiRequest.mLocalPath, (int) this.mStartOffset, this.mOpenUpTicket, this.mLocalMd5, iTransactionCallback, this.mPreSendDots, this.mExtendInfo, this.mLoginSigHead);
        } else {
            this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 1, this.mUiRequest.mLocalPath, (int) this.mStartOffset, hexStr2Bytes, this.mLocalMd5, iTransactionCallback);
        }
        this.mTrans.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public void onFailed(int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                } else {
                    C2CPicUploadProcessor.this.reportForServerMonitor(false, i3, str, str2);
                }
            }
        };
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        QLog.i("C2CPicUploadProcessor", 1, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:1");
        if (submitTransactionTask != 0) {
            setError(submitTransactionTask, "SubmitError.", "", this.mProcessorReport.mStepTrans);
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void sendMessageToUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        super.sendMessageToUpdate(i3);
        if (this.isStoryPhoto) {
            ((IPeakIpcController) QRoute.api(IPeakIpcController.class)).updatePeakVideoAndPicStatus(this.picMsg, i3, getProgress());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendMsg() {
        MessageRecord messageRecord;
        String str;
        boolean z16;
        if (!canDoNextStep()) {
            log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
            return;
        }
        MessageRecord messageRecord2 = this.mUiRequest.mRec;
        if (messageRecord2 != null && (messageRecord2 instanceof MessageForPic) && ((MessageForPic) messageRecord2).DSKey != 0) {
            onSuccess();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("C2CPicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
        }
        if (this.needSendMsg && !this.mUiRequest.mIsPresend) {
            this.mProcessorReport.mStepMsg.logStartTime();
            im_msg_body$RichText constructRichText = constructRichText();
            if (constructRichText == null) {
                setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, this.mProcessorReport.mStepMsg);
                onError();
                return;
            }
            TransferRequest transferRequest = this.mUiRequest;
            ad adVar = transferRequest.mUpCallBack;
            if (adVar != null) {
                messageRecord = adVar.g(constructRichText);
            } else {
                messageRecord = transferRequest.mRec;
                if (messageRecord == null) {
                    IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
                    TransferRequest transferRequest2 = this.mUiRequest;
                    messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq);
                }
            }
            if (messageRecord != null && (((z16 = messageRecord instanceof MessageForPic)) || ((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord))) {
                if (z16) {
                    MessageForPic messageForPic = (MessageForPic) messageRecord;
                    messageForPic.richText = constructRichText;
                    messageForPic.size = this.mFileSize;
                    if (messageForPic.isBlessPic) {
                        messageForPic.uuid = this.mResid;
                        ((IMessageHandler) this.app.getRuntimeService(IMessageHandler.class, "")).notifyUI((BaseQQAppInterface) this.app, 999, true, messageRecord.frienduin);
                        return;
                    }
                }
                if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
                    ((MessageForRichText) messageRecord).richText = constructRichText;
                }
                if (!isAppValid()) {
                    setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, this.mProcessorReport.mStepMsg);
                    onError();
                    return;
                } else {
                    addInfoToMsg();
                    ((IOrderMediaMsgService) this.app.getRuntimeService(IOrderMediaMsgService.class, "")).sendOrderMsg(messageRecord, this.messageObserver, this);
                    return;
                }
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
        im_msg_body$RichText constructRichText2 = constructRichText();
        if (constructRichText2 == null) {
            setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, this.mProcessorReport.mStepMsg);
            onError();
            return;
        }
        ad adVar2 = this.mUiRequest.mUpCallBack;
        if (adVar2 != null) {
            adVar2.g(constructRichText2);
        }
        TransferRequest transferRequest4 = this.mUiRequest;
        if (transferRequest4.mIsPresend && this.mIsPicSecondTransfered) {
            ((MessageForPic) transferRequest4.mRec).mPresendTransferedSize = 0L;
        }
        addInfoToMsg();
        onSuccess();
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor
    protected void sendRequest() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
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
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.C2C_PIC_UP;
        richProtoReq.reqs.add(picUpReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        changeRequest(picUpReq);
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

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.start();
            doStart();
        }
    }

    @Override // com.tencent.mobileqq.transfile.BasePicUploadProcessor
    public void updateMessageData(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageRecord);
            return;
        }
        if (messageRecord instanceof MessageForPic) {
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            messageForPic.size = this.mFileSize;
            String str = this.mResid;
            if (str == null) {
                str = this.mUuid;
            }
            messageForPic.uuid = str;
            messageForPic.serial();
            IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
            TransferRequest transferRequest = this.mUiRequest;
            iMessageFacade.updateMsgContentByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, messageRecord.uniseq, messageForPic.msgData);
            return;
        }
        if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
            IMsgStructing iMsgStructing = (IMsgStructing) QRoute.api(IMsgStructing.class);
            AppInterface appInterface = this.app;
            String str2 = this.mMd5Str;
            String str3 = this.mResid;
            if (str3 == null) {
                str3 = this.mUuid;
            }
            String str4 = str3;
            long j3 = this.mFileSize;
            TransferRequest transferRequest2 = this.mUiRequest;
            iMsgStructing.updateMsgAfterUpload(appInterface, messageRecord, str2, str4, j3, null, transferRequest2.mPeerUin, transferRequest2.mUinType);
        }
    }

    public C2CPicUploadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mStepTransPre = new StepInfo();
        this.mStepTransLeft = new StepInfo();
        this.isStoryPhoto = false;
        this.messageObserver = new bo() { // from class: com.tencent.mobileqq.transfile.C2CPicUploadProcessor.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) C2CPicUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bo
            public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                    return;
                }
                C2CPicUploadProcessor.this.logRichMediaEvent("sendMsgFinish", "success:" + z16);
                ProcessorReport processorReport = C2CPicUploadProcessor.this.mProcessorReport;
                processorReport.copyStatisInfo(processorReport.mStepMsg, false, z16, statictisInfo);
                if (z16) {
                    C2CPicUploadProcessor.this.onSuccess();
                    return;
                }
                if (statictisInfo != null) {
                    C2CPicUploadProcessor.this.shouldMsgReportSucc = statictisInfo.reportSucc;
                }
                C2CPicUploadProcessor.this.onError();
            }
        };
    }
}

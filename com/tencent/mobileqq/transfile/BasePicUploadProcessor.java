package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.pic.operator.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.r;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.chatpic.PicUploadExplicitError;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.v;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgsvc.msg_ctrl$MsgCtrl;

/* loaded from: classes19.dex */
public class BasePicUploadProcessor extends BaseUploadProcessor implements Handler.Callback, IOrderMediaMsgService.a, IPicTransFile.b {
    static IPatchRedirector $redirector_ = null;
    public static final int SEND_PIC_AREA_LIMIT = 200000000;
    public static final int SEND_PIC_LENGTH_LIMIT = 30000;
    private static final int SHOW_PROGRESS = -255;
    private static final String TAG = "BasePicUploadProcessor";
    private int delayShowProgressTimeInMs;
    Handler handler;
    protected b.a mQuickSendObject;
    protected boolean uploadSuccess;

    public BasePicUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.uploadSuccess = false;
        this.delayShowProgressTimeInMs = transferRequest.delayShowProgressTimeInMs;
        this.handler = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.mQuickSendObject = com.tencent.mobileqq.pic.operator.b.L(transferRequest.mRec, transferRequest);
    }

    private void handleQuickSendFailed() {
        if (isDynamicPic()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "handleQuickSendFailed:" + getMessageForPic());
            }
            ((IPicHelper) QRoute.api(IPicHelper.class)).getDrawable(getMessageForPic(), 65537, null, null).downloadImediatly();
        }
    }

    public static void reportActPSdoneAioDuration(long j3, long j16, boolean z16, double d16) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (j3 <= 86400000 && d16 >= 0.0d && d16 <= 1.0d) {
            int systemNetwork = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            int u16 = ah.u();
            hashMap.put(j.I0, systemNetwork + "");
            hashMap.put("param_aio_duration", j3 + "");
            hashMap.put("param_second_trans", z16 + "");
            hashMap.put("param_phone_type", u16 + "");
            hashMap.put("param_pic_filesize", j16 + "");
            hashMap.put("param_optimizePercent", d16 + "");
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPSdoneaioduration", false, 0L, 0L, hashMap, "", false);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "reportActPSdoneAioDuration,aioduration =" + j3 + ",filesize = " + j16 + ",isSecondTrans = " + z16 + ",phoneType = " + u16 + ",percent = " + d16);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportActPSdoneAioDuration,invalid arg,return!");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addInfoToMsg() {
        MessageRecord messageRecord;
        msg_ctrl$MsgCtrl msgCtrlForPicMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        try {
            if (!ZhuoXusManager.instance().isSendPicQRCodeOpen() && !ZhuoXusManager.instance().isSendPicAppProbOpen() && !ZhuoXusManager.instance().isSendPicExifOpen()) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "a , s close !");
                    return;
                }
                return;
            }
            TransferRequest transferRequest = this.mUiRequest;
            if (transferRequest != null && (messageRecord = transferRequest.mRec) != null && (messageRecord instanceof MessageForPic) && (msgCtrlForPicMsg = ((IDep) QRoute.api(IDep.class)).getMsgCtrlForPicMsg(this.mUiRequest.mLocalPath)) != null) {
                ((MessageForPic) this.mUiRequest.mRec).msgCtrl = msgCtrlForPicMsg;
                this.mProcessorReport.mReportInfo.put("param_amc", "1");
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        if (this.mQuickSendObject != null) {
            handleQuickSendFailed();
        }
        return super.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeRequest(RichProto.RichProtoReq.PicUpReq picUpReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) picUpReq);
            return;
        }
        b.a aVar = this.mQuickSendObject;
        if (aVar != null && !aVar.f258759d) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "changeRequest,file Size:" + picUpReq.fileSize + " md5:" + picUpReq.md5 + " busiType:" + this.mUiRequest.mBusiType + " quickSendObject:" + this.mQuickSendObject);
            }
            b.a aVar2 = this.mQuickSendObject;
            picUpReq.fileSize = aVar2.f258757b;
            picUpReq.md5 = HexUtil.hexStr2Bytes(aVar2.f258756a);
            if (this.mUiRequest.mBusiType == 1042) {
                picUpReq.typeHotPic = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void changeRichText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        b.a aVar = this.mQuickSendObject;
        if (aVar != null && !aVar.f258759d) {
            this.mFileSize = aVar.f258757b;
            String str = aVar.f258756a;
            this.mMd5Str = str;
            this.mLocalMd5 = HexUtil.hexStr2Bytes(str);
            if (getClass().equals(GroupPicUploadProcessor.class)) {
                this.mFileName = this.mMd5Str + "." + this.mExtName;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkContinueSend() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        if (this.mUiRequest.mIsFastForward) {
            this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_FAST_FORWARD_MD5_MISS, "Server MD5 fast forward missed", null, null);
            onError();
            return false;
        }
        b.a aVar = this.mQuickSendObject;
        if (aVar == null || aVar.f258759d) {
            return true;
        }
        aVar.f258759d = true;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "QuickSendFail");
        }
        sendRequest();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkFileStandard(boolean z16) {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, z16)).booleanValue();
        }
        if (this.mLocalMd5 == null && !getMd5()) {
            this.mProcessorReport.setError(9041, "No Local MD5", null, null);
            onError();
            return false;
        }
        if (z16 && (this.mHeight == 0 || this.mWidth == 0)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BaseImageUtil.decodeFileWithBufferedStream(this.mUiRequest.mLocalPath, options);
            this.mHeight = options.outHeight;
            this.mWidth = options.outWidth;
            TransferRequest transferRequest = this.mUiRequest;
            Object obj = transferRequest.mExtraObj;
            if (obj != null && (obj instanceof TransferRequest.PicUpExtraInfo) && ((TransferRequest.PicUpExtraInfo) obj).mIsRaw && RichMediaUtil.isPicLandscape(transferRequest.mLocalPath)) {
                this.mHeight = options.outWidth;
                this.mWidth = options.outHeight;
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("doStart", "raw pic is Landscape,swap w,h; options.outWidth = " + options.outWidth + ",options.outHeight = " + options.outHeight + ",mWidth = " + this.mWidth + ",mHeight = " + this.mHeight);
                }
            }
        }
        if (this.mRaf == null) {
            try {
                this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                this.mRaf = null;
            }
            if (this.mRaf == null) {
                this.mProcessorReport.setError(9303, "read file error", null, null);
                onError();
                return false;
            }
        }
        if (!(this.mUiRequest.mRec instanceof MessageForPic) || ((i3 = this.mHeight) <= 30000 && (i16 = this.mWidth) <= 30000 && i16 * i3 <= 200000000)) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "checkFileStandard fail\uff0cmHeight:" + this.mHeight + " mWidth:" + this.mWidth);
        }
        this.mProcessorReport.setError(AppConstants.RichMediaErrorCode.ERROR_PIC_FILE_OVER_LIMIT, "PicOverStandard", null, null);
        onError();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
            return;
        }
        if (this.mProcessorReport.errCode != 9333) {
            super.doReport(z16);
            if (QLog.isColorLevel() && ConfigManager.mUseHardCodeIp == 1) {
                r.a("BDH_UPLOAD_USE_HARDCORD_IP", this.mProcessorReport.mReportInfo.get("serverip"));
                ConfigManager.mUseHardCodeIp = 0;
            }
        }
    }

    public int[] getImageInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (int[]) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        int[] iArr = {(int) this.mFileSize, v.a(this.mUiRequest.mLocalPath), this.mWidth, this.mHeight, 0};
        int rotateDegree = BaseImageUtil.getRotateDegree(this.mUiRequest.mLocalPath);
        if (rotateDegree == 90 || 270 == rotateDegree) {
            iArr[2] = this.mHeight;
            iArr[3] = this.mWidth;
        }
        QLog.d(TAG, 1, "rotateDegree : " + rotateDegree + ", params[2] : " + iArr[2] + " params[3] : " + iArr[3]);
        return iArr;
    }

    protected MessageForPic getMessageForPic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (MessageForPic) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord instanceof MessageForPic) {
            return (MessageForPic) messageRecord;
        }
        if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
            return ((IMsgStructing) QRoute.api(IMsgStructing.class)).getMessageForPic(messageRecord);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getPicSourceReport(MessageForPic messageForPic, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Integer) iPatchRedirector.redirect((short) 19, (Object) this, (Object) messageForPic, i3)).intValue();
        }
        if (i3 > 0) {
            return i3;
        }
        int i17 = this.mUiRequest.mBusiType;
        if (i17 != 1009 && i17 != 1031 && i17 != 1048) {
            switch (i17) {
                case 1050:
                    i16 = 1;
                    break;
                case 1051:
                    i16 = 3;
                    break;
                case 1052:
                    i16 = 2;
                    break;
                case 1053:
                    i16 = 7;
                    break;
                default:
                    i16 = 6;
                    break;
            }
        } else {
            i16 = 4;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("enable_fix_img_and_video_report") && this.mUiRequest.mBusiType == 1037) {
            i16 = 9;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getPicSourceReport:" + this.mUiRequest.mBusiType + " source:" + i16);
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getReportBizType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        int i3 = this.mUiRequest.mBusiType;
        if (i3 != 1027) {
            if (i3 != 1031) {
                if (i3 != 1034) {
                    if (i3 != 1037) {
                        if (i3 != 1038) {
                            switch (i3) {
                                case 1006:
                                    return 5;
                                case 1007:
                                    return 3;
                                case 1008:
                                    return 2;
                                case 1009:
                                    break;
                                default:
                                    return 0;
                            }
                        } else {
                            return 9;
                        }
                    } else {
                        return 8;
                    }
                } else {
                    return 7;
                }
            }
            return 4;
        }
        return 6;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) message)).booleanValue();
        }
        if (message.what != SHOW_PROGRESS) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "unknown msg");
                return true;
            }
            return true;
        }
        if (this.file.status < 1002) {
            sendMessageToUpdate(1002);
            return true;
        }
        return true;
    }

    protected boolean isDynamicPic() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this)).booleanValue();
        }
        MessageForPic messageForPic = getMessageForPic();
        if (messageForPic != null && messageForPic.imageType == 2000) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicTransFile.b
    public boolean isUploadSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.uploadSuccess;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
        } else {
            this.handler.removeMessages(SHOW_PROGRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        b.a aVar = this.mQuickSendObject;
        if (aVar != null && aVar.f258759d) {
            handleQuickSendFailed();
        }
        this.handler.removeMessages(SHOW_PROGRESS);
        if (this.mUiRequest != null) {
            ((IDep) QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, String.valueOf(this.mProcessorReport.errCode), true);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService.a
    public void onSendBegin(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) messageRecord);
        } else {
            sendMessageToUpdate(1003);
        }
    }

    @Override // com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService.a
    public void onSendEnd(boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        String str;
        String str2;
        String str3;
        super.onSuccess();
        this.handler.removeMessages(SHOW_PROGRESS);
        b.a aVar = this.mQuickSendObject;
        if (aVar != null) {
            String str4 = aVar.f258756a;
            if (!aVar.f258759d) {
                if (str4 != null && this.mUiRequest != null) {
                    URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(str4, 65537);
                    if (url != null) {
                        str = url.toString();
                    } else {
                        str = null;
                    }
                    if (!AbsDownloader.hasFile(str)) {
                        String filePath = AbsDownloader.getFilePath(str);
                        if (isDynamicPic()) {
                            str3 = this.mUiRequest.mLocalPath;
                        } else {
                            URL url2 = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(this.mQuickSendObject.f258756a, 65537);
                            if (url2 != null) {
                                str2 = url2.toString();
                            } else {
                                str2 = null;
                            }
                            if (AbsDownloader.hasFile(str2)) {
                                str3 = AbsDownloader.getFilePath(str2);
                            } else {
                                str3 = this.mUiRequest.mLocalPath;
                            }
                        }
                        boolean copyFile = FileUtils.copyFile(str3, filePath);
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "quick send copy file:" + this.mUiRequest.mLocalPath + " to:" + filePath + " ret:" + copyFile);
                        }
                    }
                }
            } else {
                handleQuickSendFailed();
            }
        }
        if (this.mUiRequest != null) {
            ((IDep) QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, null, true);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.handler.removeMessages(SHOW_PROGRESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportForServerMonitor(boolean z16, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
            return;
        }
        String str3 = this.mFileName;
        String str4 = this.mResid;
        if (str4 == null) {
            str4 = this.mUuid;
        }
        reportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_PICUP, z16, i3, str, str2, str3, str4, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportQuickSend(boolean z16) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
            return;
        }
        b.a aVar = this.mQuickSendObject;
        if (aVar != null && !aVar.f258759d) {
            HashMap<String, String> hashMap = new HashMap<>();
            if (z16) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put("param_succ_flag", str);
            if (this.mUiRequest.mBusiType == 1042) {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "HotPicQuickSend", z16, 0L, 0L, hashMap, "");
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "PicQuickSend", z16, 0L, 0L, hashMap, "");
        }
    }

    protected void sendRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public void setError(int i3, String str, String str2, StepInfo stepInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), str, str2, stepInfo);
        } else {
            this.mProcessorReport.setError(i3, str, str2, stepInfo);
            PicUploadExplicitError.uploadFailUpdateMsg(this.mUiRequest.mRec, i3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.start();
            this.handler.sendEmptyMessageDelayed(SHOW_PROGRESS, this.delayShowProgressTimeInMs);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void updateMessageDataBaseContent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class, "");
            TransferRequest transferRequest = this.mUiRequest;
            messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
        }
        if (messageRecord == null) {
            logRichMediaEvent("updateDb", "msg null");
        } else if (messageRecord.isMultiMsg) {
            logRichMediaEvent("updateDb", "is multiMsg");
        } else {
            updateMessageData(messageRecord);
        }
    }

    public BasePicUploadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.uploadSuccess = false;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    void updateMessageData(MessageRecord messageRecord) {
    }
}

package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.BaseHandler;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Marker;
import tencent.im.cs.cmd0x346.cmd0x346$ApplyUploadReq;
import tencent.im.cs.cmd0x346.cmd0x346$ExtensionReq;
import tencent.im.cs.cmd0x346.cmd0x346$ReqBody;
import tencent.im.cs.cmd0x388.cmd0x388$ExpRoamExtendInfo;
import tencent.im.cs.cmd0x388.cmd0x388$StoreFileInfo;

/* loaded from: classes19.dex */
public class BDHCommonUploadProcessor extends BaseUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final int COMMAND_ID_AE_CAMERA_UPLOAD_ARK_VIDEO = 82;
    public static final int COMMAND_ID_AI_EMOTICON = 2021;
    public static final int COMMAND_ID_AREA_GRAB = 35;
    public static final int COMMAND_ID_AVATAR_UNCACHE = 90;
    public static final int COMMAND_ID_AV_GAME_RESULT = 78;
    public static final int COMMAND_ID_BUSINESS_CARD = 18;
    public static final int COMMAND_ID_C2B_PA_PIC = 10;
    public static final int COMMAND_ID_CAMERA_EMO_ROAMING = 70;
    public static final int COMMAND_ID_CMSHOW = 36;
    public static final int COMMAND_ID_CMSHOW_3D_FACE = 79;
    public static final int COMMAND_ID_DANCE_PKSHARE = 58;
    public static final int COMMAND_ID_ECOMMERCE = 2006;
    public static final int COMMAND_ID_FACE_SNAPCHAT_PIC = 7;
    public static final int COMMAND_ID_FAV_ROAMING = 9;
    public static final int COMMAND_ID_GAME_CENTER_STRATEGY = 94;
    public static final int COMMAND_ID_IDENTIFICATION = 61;
    public static final int COMMAND_ID_MINI_APP_ARK_SHARE = 62;
    public static final int COMMAND_ID_MINI_APP_USER_LOG = 65;
    public static final int COMMAND_ID_MULTIMSG = 27;
    public static final int COMMAND_ID_MULTIMSG_NEW = 77;
    public static final int COMMAND_ID_NEARBYPRO_PIC = 1019;
    public static final int COMMAND_ID_PIC_OCR = 76;
    public static final int COMMAND_ID_QAV_ENC_FILE = 64;
    public static final int COMMAND_ID_QQCOMIC = 20;
    public static final int COMMAND_ID_READINJOY_VIDEO = 54;
    public static final int COMMAND_ID_SMALL_HOME_UPLOAD_PIC = 2001;
    public static final int COMMAND_ID_TRIBE_VIDEO_UPLOAD = 57;
    public static final int COMMAND_ID_TROOP_AVATAR = 3000;
    public static final int COMMAND_ID_TROOP_CHECKIN_PIC = 75;
    public static final int COMMAND_ID_TROOP_CHECKIN_VIDEO = 74;
    public static final int COMMAND_ID_TROOP_HW_NOTICE = 2018;
    public static final int COMMAND_ID_UPLOAD_PIC_STUDY_ROOM = 80;
    public static final int COMMAND_ID_UPLOAD_WEBPIC = 51;
    public static final int COMMAND_ID_VOICE_HB = 3001;
    public static final int COMMAND_ID_VOICE_SEARCH = 40;
    public static final int COMMAND_ID_WINK_EDITOR_UPLOAD_IMAGE = 93;
    public static final int COMMAND_ID_ZPLAN_RED_PACKET_UPLOAD_PIC = 92;
    public static final int COMMAND_ID_ZPLAN_VAS_UPLOAD_PIC = 101;
    public static final int RET_ERR_COMIC_PIC_LIMITED = 120509;
    public static final int RET_ERR_FAV_EMO_NORMAL_LIMITED = 400010;
    public static final int RET_ERR_FAV_EMO_SVIP_LIMITED = 400011;
    public static final String TAG = "BDHCommonUploadProcessor";
    private int mCommandId;
    private byte[] mExtention;
    private long mFileID;
    private cmd0x388$ExpRoamExtendInfo mResid;
    private String mRichTag;
    private String mSessionKey;
    private Bdh_extinfo.UploadPicExtInfo mUploadPicExtInfo;
    Transaction trans;

    public BDHCommonUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mResid = new cmd0x388$ExpRoamExtendInfo();
        this.mUploadPicExtInfo = new Bdh_extinfo.UploadPicExtInfo();
        this.trans = null;
        int i3 = transferRequest.mCommandId;
        this.mCommandId = i3;
        this.file.commandId = i3;
        this.mRichTag = transferRequest.mRichTag;
        this.mExtention = transferRequest.mExtentionInfo;
    }

    private boolean handleSendFile() {
        int i3 = this.mCommandId;
        if (36 != i3 && 18 != i3 && 40 != i3 && 78 != i3 && 54 != i3 && 51 != i3 && 62 != i3 && 58 != i3 && 65 != i3 && 70 != i3 && 76 != i3 && 79 != i3 && 80 != i3 && 82 != i3 && 93 != i3 && 94 != i3 && 3000 != i3 && 3001 != i3 && 1019 != i3 && 2018 != i3 && !isVasId()) {
            return false;
        }
        return true;
    }

    private boolean isVasId() {
        int i3 = this.mCommandId;
        if (i3 != 92 && i3 != 2001 && i3 != 101 && i3 != 2006) {
            return false;
        }
        return true;
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
        if (QLog.isColorLevel()) {
            logRichMediaEvent("requestStart", buildRichProtoReq.toString());
        }
        if (canDoNextStep() && buildRichProtoReq != null) {
            this.mRichProtoReq = buildRichProtoReq;
            QLog.i(TAG, 1, "BDHCommonUploadProcessor commonId: " + this.mCommandId);
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
        richProtoReq.protoKey = RichProtoProc.BDH_COMMON_UP;
        richProtoReq.reqs.add(picUpReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        richProtoReq.commandId = this.mCommandId;
        richProtoReq.extention = this.mExtention;
        return richProtoReq;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public final int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        super.cancel();
        if (this.trans != null) {
            this.app.getHwEngine().cancelTransactionTask(this.trans);
            return 0;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public final int checkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        logRichMediaEvent("uiParam", this.mUiRequest.toString());
        if (!TextUtils.isEmpty(this.mUiRequest.mLocalPath)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = 1;
            BaseImageUtil.decodeFileWithBufferedStream(this.mUiRequest.mLocalPath, options);
            this.mHeight = options.outHeight;
            this.mWidth = options.outWidth;
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
            this.mExtName = estimateFileType;
        }
        Object obj = this.mUiRequest.mExtraObj;
        if (obj != null && (obj instanceof TransferRequest.PicUpExtraInfo)) {
            this.mIsRawPic = ((TransferRequest.PicUpExtraInfo) obj).mIsRaw;
            return 0;
        }
        return 0;
    }

    byte[] constructReqBody() {
        cmd0x346$ReqBody cmd0x346_reqbody = new cmd0x346$ReqBody();
        cmd0x346_reqbody.uint32_cmd.set(500);
        cmd0x346_reqbody.uint32_business_id.set(3);
        cmd0x346_reqbody.uint32_client_type.set(104);
        cmd0x346$ApplyUploadReq cmd0x346_applyuploadreq = new cmd0x346$ApplyUploadReq();
        cmd0x346_applyuploadreq.uint64_sender_uin.set(Long.parseLong(this.app.getCurrentUin()));
        try {
            String currentUin = this.app.getCurrentUin();
            if (currentUin.startsWith(Marker.ANY_NON_NULL_MARKER)) {
                currentUin = currentUin.substring(1);
            }
            cmd0x346_applyuploadreq.uint64_recver_uin.set(Long.valueOf(currentUin).longValue());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        cmd0x346_applyuploadreq.uint32_file_type.set(2);
        cmd0x346_applyuploadreq.str_file_name.set(this.mFileName);
        cmd0x346_applyuploadreq.uint64_file_size.set(this.mFileSize);
        cmd0x346_applyuploadreq.bytes_10m_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        cmd0x346_reqbody.msg_apply_upload_req.set(cmd0x346_applyuploadreq);
        cmd0x346$ExtensionReq cmd0x346_extensionreq = new cmd0x346$ExtensionReq();
        cmd0x346_extensionreq.uint64_id.set(3L);
        cmd0x346_extensionreq.uint32_ptt_format.set(0);
        cmd0x346_extensionreq.uint32_ptt_time.set(this.mUiRequest.mRequestLength);
        cmd0x346_extensionreq.uint32_net_type.set(BaseHandler.getHandlerNetType());
        cmd0x346_extensionreq.uint32_voice_type.set(2);
        cmd0x346_extensionreq.uint64_type.set(0);
        cmd0x346_reqbody.msg_extension_req.set(cmd0x346_extensionreq);
        return cmd0x346_reqbody.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, z16);
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
                    String str = this.mSessionKey;
                    if (str == null) {
                        str = "null";
                    }
                    hashMap.put(ReportConstant.KEY_SESSION_KEY, str);
                    if (z16) {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.mRichTag, true, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
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
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.mRichTag, false, j3, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                    }
                    setReportFlag();
                }
            }
        }
    }

    protected final void doStatistic(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) hashMap);
            return;
        }
        try {
            Long.valueOf(hashMap.get(TransReport.rep_upFlow_wifi)).longValue();
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "upFlow_Wifi : number format exception !");
            }
        }
        try {
            Long.valueOf(hashMap.get(TransReport.rep_dwFlow_wifi)).longValue();
        } catch (Exception unused2) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "dwFlow_Wifi : number format exception !");
            }
        }
        try {
            Long.valueOf(hashMap.get(TransReport.rep_upFlow_Xg)).longValue();
        } catch (Exception unused3) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "upFlow_Xg : number format exception !");
            }
        }
        try {
            Long.valueOf(hashMap.get(TransReport.rep_dwFlow_Xg)).longValue();
        } catch (Exception unused4) {
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "dwFlow_Xg : number format exception !");
            }
        }
        String str = hashMap.get(TransReport.rep_time_cache);
        String str2 = hashMap.get(TransReport.rep_bdhTrans);
        String str3 = hashMap.get(TransReport.rep_segsPerConn);
        String str4 = hashMap.get(TransReport.rep_confSegSize);
        String str5 = hashMap.get(TransReport.rep_confSegNum);
        String str6 = hashMap.get(TransReport.rep_confMaxConn);
        String str7 = hashMap.get(TransReport.rep_finLost);
        if (str != null) {
            this.mProcessorReport.mReportInfo.put("X-piccachetime", str);
        }
        if (str7 != null) {
            this.mProcessorReport.mReportInfo.put(TransReport.rep_finLost, str7);
        }
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHTRANS_INFO, str2);
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SEG_PER_CNT, str3);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegSize, str4);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_confSegNum, str5);
        this.mProcessorReport.mReportInfo.put(TransReport.rep_confMaxConn, str6);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    protected final long getBlockSize(long j3) {
        long min;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, j3)).longValue();
        }
        long j16 = this.mFileSize - j3;
        if (!this.mSSCMSpanned) {
            min = Math.min(j16, this.sscmObject.d(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));
        } else {
            min = Math.min(j16, 14600L);
        }
        return Math.min(min, 131072L);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public final void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        String str;
        cmd0x388$StoreFileInfo cmd0x388_storefileinfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.BDHCommonUpResp bDHCommonUpResp = (RichProto.RichProtoResp.BDHCommonUpResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", bDHCommonUpResp.toString());
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, bDHCommonUpResp);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onBusiProtoResp()------response.result = " + bDHCommonUpResp.result);
                }
                if (bDHCommonUpResp.result == 0) {
                    this.mSessionKey = bDHCommonUpResp.mUkey;
                    this.mTransferedSize = this.mFileSize;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onBusiProtoResp()---- sessionKey: " + this.mSessionKey);
                    }
                    FileMsg fileMsg = this.file;
                    fileMsg.downDomain = bDHCommonUpResp.downDomain;
                    fileMsg.orgiDownUrl = bDHCommonUpResp.orgiDownUrl;
                    fileMsg.thumbDownUrl = bDHCommonUpResp.thumbDownUrl;
                    fileMsg.bigDownUrl = bDHCommonUpResp.bigDownUrl;
                    fileMsg.fileUrl = "http://" + bDHCommonUpResp.downDomain + bDHCommonUpResp.orgiDownUrl;
                    this.file.thumbUrl = "http://" + bDHCommonUpResp.downDomain + bDHCommonUpResp.thumbDownUrl;
                    this.file.compressUrl = "http://" + bDHCommonUpResp.downDomain + bDHCommonUpResp.bigDownUrl;
                    FileMsg fileMsg2 = this.file;
                    String str2 = bDHCommonUpResp.resid;
                    fileMsg2.serverPath = str2;
                    if (bDHCommonUpResp.isExist) {
                        fileMsg2.closeInputStream();
                        onSuccess();
                        if (QLog.isColorLevel() && this.mUiRequest != null) {
                            QLog.d(TAG, 2, "onBusiProtoResp()---- file is Exsit! " + this.mUiRequest.mLocalPath);
                        }
                    } else {
                        if (this.mCommandId == 9) {
                            if (str2 != null) {
                                this.mResid.bytes_resid.set(ByteStringMicro.copyFrom(str2.getBytes()));
                            }
                            TransferRequest transferRequest = this.mUiRequest;
                            if (transferRequest != null && (cmd0x388_storefileinfo = transferRequest.storeFileInfo) != null) {
                                this.mResid.emoji_extend_info.set(ByteStringMicro.copyFrom(cmd0x388_storefileinfo.toByteArray()));
                            }
                        }
                        if (this.mCommandId == 20 && (str = bDHCommonUpResp.resid) != null) {
                            this.mUploadPicExtInfo.bytes_file_resid.set(ByteStringMicro.copyFrom(str.getBytes()));
                        }
                        this.mUkey = bDHCommonUpResp.mUkey;
                        this.mTransferedSize = bDHCommonUpResp.transferedSize;
                        this.mStartOffset = bDHCommonUpResp.startOffset;
                        sendFile();
                    }
                    long j3 = bDHCommonUpResp.groupFileID;
                    this.mFileID = j3;
                    this.file.fileID = j3;
                    if (QLog.isColorLevel() && this.mUiRequest != null) {
                        QLog.d(TAG, 2, "mFileID->" + this.mFileID + " groupUin->" + this.mUiRequest.mPeerUin);
                    }
                } else {
                    onError();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    final void onError() {
        super.onError();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "uploadCustomEmoticon resultError");
        }
        sendMessageToUpdate(1005);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "uploadCustomEmoticon resultError ---- errCode: " + this.mProcessorReport.errCode + ", errDesc:" + this.mProcessorReport.errDesc);
        }
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            aVar.f258598b = processorReport.errCode;
            aVar.f258599c = processorReport.errDesc;
            if (this.mCommandId == 20 && ProcessorReport.getUrlReason(120509L).equals(this.mProcessorReport.mReportInfo.get(ReportConstant.KEY_REASON))) {
                aVar.f258598b = RET_ERR_COMIC_PIC_LIMITED;
            }
            if (this.mCommandId == 9) {
                String str = this.mProcessorReport.mReportInfo.get(ReportConstant.KEY_REASON);
                if (ProcessorReport.getUrlReason(400010L).equals(str)) {
                    aVar.f258598b = RET_ERR_FAV_EMO_NORMAL_LIMITED;
                } else if (ProcessorReport.getUrlReason(400011L).equals(str)) {
                    aVar.f258598b = RET_ERR_FAV_EMO_SVIP_LIMITED;
                }
            }
            this.mUiRequest.mUpCallBack.q(aVar);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public final void onResp(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) netResp);
        } else {
            super.onResp(netResp);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    final void onSuccess() {
        super.onSuccess();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "uploadCustomEmoticon resultOk");
        }
        sendMessageToUpdate(1003);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSuccess().");
        }
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            if (this.mCommandId == 20) {
                aVar.f258602f = this.file.serverPath;
            }
            this.mUiRequest.mUpCallBack.q(aVar);
        }
        int i3 = this.mCommandId;
        if (i3 == 9 || i3 == 76) {
            sendMessageToUpdate(1008);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BDHCommonUploadProcessor.pause()");
        }
        if (this.mCommandId == 54) {
            if (!this.mIsPause) {
                this.mIsPause = true;
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("pause", "");
                }
                sendMessageToUpdate(1006);
                if (this.trans != null) {
                    this.app.getHwEngine().stopTransactionTask(this.trans);
                    return;
                }
                return;
            }
            return;
        }
        super.pause();
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public final int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BDHCommonUploadProcessor.resume()");
        }
        if (this.mCommandId == 54) {
            if (this.mIsPause) {
                this.mIsPause = false;
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("resume", "");
                }
                if (this.trans != null) {
                    this.app.getHwEngine().resumeTransactionTask(this.trans);
                }
            }
            return super.resume();
        }
        cancel();
        sendRequest();
        return 0;
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor
    public final void sendFile() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "BDHNormalUploadProcessor.sendFile()");
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        ITransactionCallback iTransactionCallback = new ITransactionCallback(SystemClock.uptimeMillis()) { // from class: com.tencent.mobileqq.transfile.BDHCommonUploadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long val$startTime;

            {
                this.val$startTime = r6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, BDHCommonUploadProcessor.this, Long.valueOf(r6));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i16, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i16), bArr, hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                BDHCommonUploadProcessor.this.doStatistic(hashMap);
                if (QLog.isColorLevel()) {
                    QLog.d(BDHCommonUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms");
                }
                BDHCommonUploadProcessor bDHCommonUploadProcessor = BDHCommonUploadProcessor.this;
                bDHCommonUploadProcessor.file.bdhExtendInfo = bArr;
                ProcessorReport processorReport = bDHCommonUploadProcessor.mProcessorReport;
                processorReport.setError(i16, "OnFailed.", "", processorReport.mStepTrans);
                BDHCommonUploadProcessor.this.onError();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                BDHCommonUploadProcessor.this.doStatistic(hashMap);
                if (QLog.isColorLevel()) {
                    QLog.d(BDHCommonUploadProcessor.TAG, 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - this.val$startTime) + "ms ,fileSize:" + BDHCommonUploadProcessor.this.file.fileSize);
                }
                BDHCommonUploadProcessor.this.mProcessorReport.mStepTrans.logFinishTime();
                BDHCommonUploadProcessor bDHCommonUploadProcessor = BDHCommonUploadProcessor.this;
                bDHCommonUploadProcessor.mProcessorReport.mStepTrans.result = 1;
                bDHCommonUploadProcessor.mTransferedSize = bDHCommonUploadProcessor.mFileSize;
                bDHCommonUploadProcessor.file.bdhExtendInfo = bArr;
                bDHCommonUploadProcessor.onSuccess();
                BDHCommonUploadProcessor.this.file.closeInputStream();
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
                    QLog.d(BDHCommonUploadProcessor.TAG, 2, "<BDH_LOG> onTransStart()");
                }
                BDHCommonUploadProcessor.this.mProcessorReport.mStepTrans.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                    return;
                }
                BDHCommonUploadProcessor bDHCommonUploadProcessor = BDHCommonUploadProcessor.this;
                long j3 = i16;
                bDHCommonUploadProcessor.file.transferedSize = j3;
                bDHCommonUploadProcessor.mTransferedSize = j3;
                if (j3 < bDHCommonUploadProcessor.mFileSize && !bDHCommonUploadProcessor.mIsCancel && !bDHCommonUploadProcessor.mIsPause) {
                    bDHCommonUploadProcessor.sendProgressMessage();
                }
            }
        };
        int i16 = this.mCommandId;
        if (i16 == 9) {
            this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int) this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, iTransactionCallback, this.mResid.toByteArray());
        } else if (i16 == 20) {
            this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int) this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, iTransactionCallback, this.mUploadPicExtInfo.toByteArray());
        } else if (i16 == 36) {
            this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int) this.mStartOffset, this.mLocalMd5, iTransactionCallback, constructReqBody(), false);
        } else if (i16 == 40) {
            String currentAccountUin = this.app.getCurrentAccountUin();
            int i17 = this.mCommandId;
            TransferRequest transferRequest = this.mUiRequest;
            this.trans = new Transaction(currentAccountUin, i17, transferRequest.mLocalPath, (int) this.mStartOffset, this.mLocalMd5, iTransactionCallback, transferRequest.mExtentionInfo, true);
        } else if (i16 == 54) {
            String currentAccountUin2 = this.app.getCurrentAccountUin();
            int i18 = this.mCommandId;
            TransferRequest transferRequest2 = this.mUiRequest;
            this.trans = new Transaction(currentAccountUin2, i18, transferRequest2.mLocalPath, (int) this.mStartOffset, this.mLocalMd5, iTransactionCallback, transferRequest2.mExtentionInfo, false);
        } else if (i16 != 51 && i16 != 58 && i16 != 62 && i16 != 65 && i16 != 70 && i16 != 76 && i16 != 78 && i16 != 79 && i16 != 80 && i16 != 82 && i16 != 93 && i16 != 2018 && !isVasId() && (i3 = this.mCommandId) != 94 && i3 != 3001 && i3 != 3000 && i3 != 1019) {
            this.trans = new Transaction(this.app.getCurrentAccountUin(), this.mCommandId, this.mUiRequest.mLocalPath, (int) this.mStartOffset, PkgTools.hexToBytes(this.mSessionKey), this.mLocalMd5, iTransactionCallback);
        } else {
            String currentAccountUin3 = this.app.getCurrentAccountUin();
            int i19 = this.mCommandId;
            TransferRequest transferRequest3 = this.mUiRequest;
            this.trans = new Transaction(currentAccountUin3, i19, transferRequest3.mLocalPath, (int) this.mStartOffset, this.mLocalMd5, iTransactionCallback, transferRequest3.mExtentionInfo, false);
        }
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.trans);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:3");
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
            QLog.d(TAG, 2, "BDHCommonUploadProcessor.start()");
        }
        if (this.mLocalMd5 == null && !getMd5()) {
            onError();
            return;
        }
        int i3 = this.mCommandId;
        if (36 == i3) {
            this.mSessionKey = "null";
            this.file.filePath = this.mUiRequest.mLocalPath;
        } else if (18 == i3) {
            this.mSessionKey = "null";
        } else if (78 == i3) {
            this.file.compressUrl = (String) this.mUiRequest.extraObject;
        } else if (isVasId()) {
            Object obj = this.mUiRequest.extraObject;
            if (obj instanceof Map) {
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    this.file.stepTrans.extraInfo.put(entry.getKey().toString(), entry.getValue().toString());
                }
            }
        }
        if (handleSendFile()) {
            sendFile();
        } else {
            sendRequest();
        }
        sendMessageToUpdate(1001);
    }
}

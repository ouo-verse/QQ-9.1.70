package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.r;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.aa;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.shortvideo.h;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.shortvideo.p;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.bm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQToastUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import pttcenterservice.PttShortVideo$PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo$PttShortVideoFileInfoExtend;
import pttcenterservice.PttShortVideo$PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo$PttShortVideoUploadResp;
import tencent.im.msg.hummer.resv.videoFile$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;
import tencent.im.msg.im_msg_body$VideoFile;

/* loaded from: classes19.dex */
public class ShortVideoUploadProcessor extends BaseShortVideoUploadProcessor implements IShortVideoUploadProcessor {
    static IPatchRedirector $redirector_ = null;
    public static final int GUILD_LONG_VIDEO_TRANS_HW_BUZ_TYPE = 89;
    public static final int GUILD_SHORT_VIDEO_TRANS_HW_BUZ_TYPE = 87;
    public static final String TAG = "ShortVideoUploadProcessor";
    BaseQQAppInterface app;
    Boolean isBDHExistBeforeVideoUpload;
    public boolean isBDHSuccess;
    public boolean isFromFavorite;
    private volatile boolean mIsCacheDiff;
    boolean mIsSecondTransfered;
    boolean mNeedSyncStory;
    StepInfo mPreUpStepTrans;
    int mReportBusiType;
    private byte[] mSessionKey;
    private byte[] mSigSession;
    int mSwitch;
    protected int mThumbFileHeight;
    protected String mThumbFilePath;
    protected long mThumbFileSize;
    protected int mThumbFileWidth;
    int mVideoAttr;
    int mVideoKandianType;
    bo messageObserver;
    protected int videoTime;

    public ShortVideoUploadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.isBDHSuccess = false;
        this.mReportBusiType = -1;
        this.mPreUpStepTrans = new StepInfo();
        this.mIsSecondTransfered = false;
        this.mIsCacheDiff = false;
        this.mVideoAttr = 0;
        this.mVideoKandianType = 0;
        this.mNeedSyncStory = false;
        this.isBDHExistBeforeVideoUpload = Boolean.FALSE;
        this.messageObserver = new bo() { // from class: com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bo
            public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                    return;
                }
                if (ShortVideoUploadProcessor.this.mUiRequest.mUinType == 10014) {
                    QLog.i("ShortVideoUploadProcessor<gld>.video", 1, "onNotifyResultAfterSendRich seq:" + ShortVideoUploadProcessor.this.mUiRequest.mUniseq);
                }
                ShortVideoUploadProcessor.this.logRichMediaEvent("sendMsgFinish", "success:" + z16);
                bm.c(String.valueOf(ShortVideoUploadProcessor.this.mUiRequest.mUniseq), "message", "sendMsgFinish isSuccess:" + z16 + ",mr = " + ShortVideoUploadProcessor.this.mUiRequest.mRec.toString());
                ProcessorReport processorReport = ShortVideoUploadProcessor.this.mProcessorReport;
                processorReport.copyStatisInfo(processorReport.mStepMsg, false, z16, statictisInfo);
                if (z16) {
                    ShortVideoUploadProcessor.this.onSuccess();
                } else {
                    ShortVideoUploadProcessor.this.onError();
                }
            }
        };
        this.app = (BaseQQAppInterface) super.app;
        this.mSwitch = 1;
        TransferRequest transferRequest2 = this.mUiRequest;
        MessageRecord messageRecord = transferRequest2.mRec;
        if (messageRecord != null && (messageRecord instanceof MessageForShortVideo)) {
            this.mReportBusiType = ((MessageForShortVideo) messageRecord).busiType;
        } else {
            this.mReportBusiType = 0;
        }
        if (!transferRequest2.mIsPresend) {
            String str = transferRequest2.mLocalPath;
            String[] split = str.split(ShortVideoForwardProcessor.SEPERATOR);
            if (4 != split.length) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "path was not set correctlly------path = " + str);
                }
                this.mProcessorReport.setError(9304, "path =" + str, null, null);
                onError();
                this.mIsCancel = true;
                return;
            }
            this.mUiRequest.mLocalPath = split[0];
            this.mThumbFilePath = split[1];
            this.videoTime = Integer.parseInt(split[2]);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "Init params videoTime : " + this.videoTime);
            }
            this.thumbFileMd5 = HexUtil.hexStr2Bytes(split[3]);
        }
    }

    private int getFormat(String str) {
        if (FileUtils.FILE_TYPE_AVI.equals(str)) {
            return 2;
        }
        if ("mp4".equals(str)) {
            return 3;
        }
        if (FileUtils.FILE_TYPE_WMV.equals(str)) {
            return 4;
        }
        if ("mkv".equals(str)) {
            return 5;
        }
        if ("rmvb".equals(str)) {
            return 6;
        }
        if (MsfCmdConfig.CMD_DELETE_FILE.equals(str)) {
            return 7;
        }
        if ("afs".equals(str)) {
            return 8;
        }
        if (FileUtils.FILE_TYPE_MOV.equals(str)) {
            return 9;
        }
        if ("mod".equals(str)) {
            return 10;
        }
        if ("ts".equals(str)) {
            return 1;
        }
        if ("mts".equals(str)) {
            return 11;
        }
        return -1;
    }

    private void handleHotVideoRichText(videoFile$ResvAttr videofile_resvattr, MessageForShortVideo messageForShortVideo, im_msg_body$VideoFile im_msg_body_videofile) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "constructRichText MessageForHotVideo ");
        }
        videofile_resvattr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoIconUrl));
        videofile_resvattr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoTitle));
        videofile_resvattr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoUrl));
        videofile_resvattr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoSubIconUrl));
        videofile_resvattr.uint32_special_video_type.set(messageForShortVideo.specialVideoType);
        String str = this.mUuid;
        if (str != null) {
            im_msg_body_videofile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(str));
        } else {
            String str2 = messageForShortVideo.uuid;
            if (str2 != null) {
                im_msg_body_videofile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(str2));
            }
        }
        String str3 = this.mMd5Str;
        if (str3 != null && str3.length() > 0) {
            im_msg_body_videofile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.mMd5Str)));
            String str4 = messageForShortVideo.md5;
            if (str4 == null || str4.length() == 0) {
                messageForShortVideo.md5 = this.mMd5Str;
            }
        } else {
            String str5 = messageForShortVideo.md5;
            if (str5 != null) {
                im_msg_body_videofile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str5)));
            }
        }
        setThumbInfoForHotVideo(messageForShortVideo);
        String str6 = messageForShortVideo.videoFileName;
        if (str6 == null || str6.length() == 0) {
            StringBuilder sb5 = new StringBuilder();
            String str7 = this.mMd5Str;
            if (str7 == null) {
                str7 = "HotVideo";
            }
            sb5.append(str7);
            sb5.append(".mp4");
            messageForShortVideo.videoFileName = sb5.toString();
        }
        im_msg_body_videofile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.videoFileName));
    }

    private void setThumbInfoForHotVideo(MessageForShortVideo messageForShortVideo) {
        int i3;
        int i16;
        int i17;
        int i18;
        if (this.mThumbFileSize == 0 && (i18 = messageForShortVideo.thumbFileSize) != 0) {
            this.mThumbFileSize = i18;
        }
        if (this.mFileSize == 0 && (i17 = messageForShortVideo.videoFileSize) != 0) {
            this.mFileSize = i17 + this.mThumbFileSize;
        }
        if (this.mThumbFileWidth == 0 && (i16 = messageForShortVideo.thumbWidth) != 0) {
            this.mThumbFileWidth = i16;
        }
        if (this.mThumbFileHeight == 0 && (i3 = messageForShortVideo.thumbHeight) != 0) {
            this.mThumbFileHeight = i3;
        }
    }

    private void setVideoSource(MessageForShortVideo messageForShortVideo, videoFile$ResvAttr videofile_resvattr) {
        int i3;
        String str;
        if (this.isFromFavorite) {
            i3 = 7;
            str = "favorite";
        } else {
            int i16 = messageForShortVideo.busiType;
            if (i16 == 0) {
                str = "gallery";
                i3 = 2;
            } else if (i16 == 1) {
                str = "aio camera";
                i3 = 1;
            } else {
                i3 = 6;
                str = "unknown";
            }
        }
        if (((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("enable_fix_img_and_video_report")) {
            videofile_resvattr.uint32_source.set(i3);
        } else {
            videofile_resvattr.uint32_source.set(2);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "videoSource report: ", Integer.valueOf(i3), ", from ", str);
        }
    }

    public byte[] buildExtendInfo(RichProto.RichProtoReq.ShortVideoUpReq shortVideoUpReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this, (Object) shortVideoUpReq);
        }
        PttShortVideo$PttShortVideoUploadReq pttShortVideo$PttShortVideoUploadReq = new PttShortVideo$PttShortVideoUploadReq();
        pttShortVideo$PttShortVideoUploadReq.setHasFlag(true);
        pttShortVideo$PttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(shortVideoUpReq.selfUin));
        pttShortVideo$PttShortVideoUploadReq.uint64_touin.set(Long.parseLong(shortVideoUpReq.peerUin));
        pttShortVideo$PttShortVideoUploadReq.uint32_chat_type.set(shortVideoUpReq.chatType);
        pttShortVideo$PttShortVideoUploadReq.uint32_client_type.set(shortVideoUpReq.clientType);
        String str = shortVideoUpReq.troopUin;
        if (str != null) {
            pttShortVideo$PttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(str));
        } else {
            pttShortVideo$PttShortVideoUploadReq.uint64_group_code.set(0L);
        }
        if (shortVideoUpReq.uinType == 10014) {
            pttShortVideo$PttShortVideoUploadReq.uint32_sub_business_type.set(shortVideoUpReq.subBusiType);
        }
        pttShortVideo$PttShortVideoUploadReq.uint32_agent_type.set(shortVideoUpReq.agentType);
        pttShortVideo$PttShortVideoUploadReq.uint32_business_type.set(shortVideoUpReq.busiType);
        pttShortVideo$PttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
        pttShortVideo$PttShortVideoUploadReq.uint32_codec_format.set(shortVideoUpReq.sourceVideoCodecFormat);
        PttShortVideo$PttShortVideoFileInfo pttShortVideo$PttShortVideoFileInfo = new PttShortVideo$PttShortVideoFileInfo();
        pttShortVideo$PttShortVideoFileInfo.str_file_name.set(shortVideoUpReq.fileName);
        pttShortVideo$PttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(shortVideoUpReq.md5));
        pttShortVideo$PttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(shortVideoUpReq.thumbFileMd5));
        pttShortVideo$PttShortVideoFileInfo.uint64_file_size.set(shortVideoUpReq.fileSize);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_res_length.set(shortVideoUpReq.fileResLength);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_res_width.set(shortVideoUpReq.fileResWidth);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_format.set(shortVideoUpReq.format);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_time.set(shortVideoUpReq.fileTime);
        pttShortVideo$PttShortVideoFileInfo.uint64_thumb_file_size.set(shortVideoUpReq.thumbFileSize);
        if (shortVideoUpReq.bitrateInKilo > 0) {
            PttShortVideo$PttShortVideoFileInfoExtend pttShortVideo$PttShortVideoFileInfoExtend = new PttShortVideo$PttShortVideoFileInfoExtend();
            pttShortVideo$PttShortVideoFileInfoExtend.uint32_bit_rate.set(shortVideoUpReq.bitrateInKilo);
            pttShortVideo$PttShortVideoFileInfo.bytes_extend.set(ByteStringMicro.copyFrom(pttShortVideo$PttShortVideoFileInfoExtend.toByteArray()));
        }
        pttShortVideo$PttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(pttShortVideo$PttShortVideoFileInfo);
        return pttShortVideo$PttShortVideoUploadReq.toByteArray();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.FileInputStream] */
    public boolean buildThumbInfo() {
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        byte[] bArr = this.thumbFileMd5;
        ?? r26 = 0;
        try {
            if (bArr == null) {
                try {
                    fileInputStream = new FileInputStream(this.mThumbFilePath);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (r26 != 0) {
                        try {
                            r26.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] mD5Byte = MD5.toMD5Byte(fileInputStream, 0L);
                    this.thumbFileMd5 = mD5Byte;
                    if (mD5Byte == null) {
                        this.mProcessorReport.setError(9041, "get thumb file Md5 error" + this.mThumbFilePath, null, null);
                        onError();
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        return false;
                    }
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                } catch (IOException e26) {
                    e = e26;
                    this.thumbFileMd5 = null;
                    analysisIOProblem(e);
                    onError();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    return false;
                }
            }
            if (this.mThumbRaf == null) {
                try {
                    this.mThumbRaf = new RandomAccessFile(this.mThumbFilePath, "r");
                } catch (FileNotFoundException e28) {
                    e28.printStackTrace();
                    this.mThumbRaf = null;
                }
                if (this.mThumbRaf == null) {
                    this.mProcessorReport.setError(9303, "read thumb file error", null, null);
                    onError();
                    return false;
                }
            }
            this.mThumbFileSize = new File(this.mThumbFilePath).length();
            getThumbFileSize(this.mThumbFilePath);
            return true;
        } catch (Throwable th6) {
            th = th6;
            r26 = bArr;
        }
    }

    public boolean buildVideoMd5() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (!TextUtils.isEmpty(this.mUiRequest.mMd5)) {
            this.mLocalMd5 = HexUtil.hexStr2Bytes(this.mUiRequest.mMd5);
            FileMsg fileMsg = this.file;
            String str = this.mUiRequest.mMd5;
            fileMsg.fileMd5 = str;
            this.mMd5Str = str;
        }
        if (this.mLocalMd5 == null && !getMd5()) {
            onError();
            return false;
        }
        if (!FileUtils.fileExistsAndNotEmpty(this.mUiRequest.mLocalPath)) {
            QQToastUtil.showQQToast(R.string.f214245sd);
            this.mProcessorReport.setError(9042, "video file not exists", null, null);
            onError();
            return false;
        }
        if (this.mRaf == null) {
            try {
                this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
            } catch (FileNotFoundException e16) {
                e16.printStackTrace();
                this.mRaf = null;
            }
            if (this.mRaf == null) {
                this.mProcessorReport.setError(9303, "read video file error", null, null);
                onError();
                return false;
            }
            return true;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int checkParam() {
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null && (messageRecord = transferRequest.mRec) != null && ((MessageForShortVideo) messageRecord).busiType == 0) {
            this.mIsShortVideoSend = true;
            return 0;
        }
        return 0;
    }

    im_msg_body$RichText constructRichText() {
        MessageForShortVideo messageForShortVideo;
        try {
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$VideoFile im_msg_body_videofile = new im_msg_body$VideoFile();
            im_msg_body_videofile.setHasFlag(true);
            String str = this.mResid;
            if (str != null) {
                im_msg_body_videofile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(str));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "mResid uuid=" + this.mResid);
            }
            MessageRecord messageRecord = this.mUiRequest.mRec;
            if (messageRecord instanceof MessageForShortVideo) {
                messageForShortVideo = (MessageForShortVideo) messageRecord;
            } else {
                messageForShortVideo = null;
            }
            if (messageForShortVideo != null) {
                im_msg_body_videofile.bytes_source.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.fileSource));
                im_msg_body_videofile.uint32_busi_type.set(messageForShortVideo.busiType);
                im_msg_body_videofile.bool_support_progressive.set(messageForShortVideo.supportProgressive);
                im_msg_body_videofile.uint32_file_width.set(messageForShortVideo.fileWidth);
                im_msg_body_videofile.uint32_file_height.set(messageForShortVideo.fileHeight);
                im_msg_body_videofile.uint32_sub_busi_type.set(messageForShortVideo.subBusiType);
                videoFile$ResvAttr videofile_resvattr = new videoFile$ResvAttr();
                videofile_resvattr.uint32_msg_tail_type.set(messageForShortVideo.msgTailType);
                if (messageForShortVideo.checkIsHotVideo()) {
                    handleHotVideoRichText(videofile_resvattr, messageForShortVideo, im_msg_body_videofile);
                } else {
                    if (messageForShortVideo.checkIsDanceVideo()) {
                        videofile_resvattr.uint32_special_video_type.set(messageForShortVideo.specialVideoType);
                    }
                    im_msg_body_videofile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mLocalPath));
                    im_msg_body_videofile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.mUiRequest.mMd5)));
                }
                PBBytesField pBBytesField = videofile_resvattr.bytes_camera_templateid;
                String str2 = messageForShortVideo.templateId;
                String str3 = "";
                if (str2 == null) {
                    str2 = "";
                }
                pBBytesField.set(ByteStringMicro.copyFromUtf8(str2));
                PBBytesField pBBytesField2 = videofile_resvattr.bytes_camera_templateName;
                String str4 = messageForShortVideo.templateName;
                if (str4 == null) {
                    str4 = "";
                }
                pBBytesField2.set(ByteStringMicro.copyFromUtf8(str4));
                videofile_resvattr.uint32_long_video_kandian_type.set(this.mVideoKandianType);
                setVideoSource(messageForShortVideo, videofile_resvattr);
                if (messageForShortVideo.embedVideo == 1) {
                    videofile_resvattr.uint32_embed_video.set(1);
                }
                int i3 = messageForShortVideo.sourceVideoCodecFormat;
                if (i3 >= 0) {
                    videofile_resvattr.uint32_source_codec_format.set(i3);
                }
                PBBytesField pBBytesField3 = videofile_resvattr.bytes_original_video_md5;
                String str5 = messageForShortVideo.originVideoMd5;
                if (str5 != null) {
                    str3 = str5;
                }
                pBBytesField3.set(ByteStringMicro.copyFromUtf8(str3));
                im_msg_body_videofile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(videofile_resvattr.toByteArray()));
                im_msg_body_videofile.uint32_video_attr.set(this.mVideoAttr);
            }
            im_msg_body_videofile.uint32_file_format.set(2);
            im_msg_body_videofile.uint32_file_size.set((int) (this.mFileSize - this.mThumbFileSize));
            im_msg_body_videofile.uint32_file_time.set(this.videoTime);
            im_msg_body_videofile.uint32_thumb_width.set(this.mThumbFileWidth);
            im_msg_body_videofile.uint32_thumb_height.set(this.mThumbFileHeight);
            im_msg_body_videofile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.thumbFileMd5));
            im_msg_body_videofile.uint32_thumb_file_size.set((int) this.mThumbFileSize);
            im_msg_body_videofile.uint32_from_chat_type.set(-1);
            im_msg_body_videofile.uint32_to_chat_type.set(-1);
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.setHasFlag(true);
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.qqStr(R.string.ti_)));
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body_elem.text.set(im_msg_body_text);
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body_elem2.video_file.set(im_msg_body_videofile);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            im_msg_body_richtext.elems.add(im_msg_body_elem2);
            return im_msg_body_richtext;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "Construct richtext error", e16);
            }
            e16.printStackTrace();
            return null;
        }
    }

    public void doOnSendFailed(int i3, HashMap<String, String> hashMap, long j3) {
        StepInfo stepInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), hashMap, Long.valueOf(j3));
            return;
        }
        QLog.d(TAG, 1, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (SystemClock.uptimeMillis() - j3) + "ms");
        addBDHReportInfo(hashMap);
        if (hashMap.get(TransReport.rep_BDH_Cache_Diff).equals(String.valueOf(true))) {
            this.mIsCacheDiff = true;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.setError(i3, "OnFailed.", "", processorReport.mStepTrans);
        if (this.mSwitch == 3 && (stepInfo = this.mPreUpStepTrans) != null) {
            stepInfo.logFinishTime();
            this.mPreUpStepTrans.result = 0;
        }
        onError();
    }

    public void doOnSendSuccess(byte[] bArr, HashMap<String, String> hashMap, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, bArr, hashMap, str, Long.valueOf(j3));
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            PttShortVideo$PttShortVideoUploadResp mergeFrom = new PttShortVideo$PttShortVideoUploadResp().mergeFrom(bArr);
            if (mergeFrom.str_fileid.has()) {
                String str2 = mergeFrom.str_fileid.get();
                if (str2.length() > 0) {
                    this.mResid = str2;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "set uuid from BDH ");
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "get uuid from BDH error", e16);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (uptimeMillis - j3) + "ms ,fileSize:" + this.file.fileSize + " transInfo:" + hashMap.get(TransReport.rep_bdhTrans));
        }
        addBDHReportInfo(hashMap);
        if (hashMap.get(TransReport.rep_BDH_Cache_Diff).equals(String.valueOf(true))) {
            this.mIsCacheDiff = true;
        }
        this.mProcessorReport.mStepTrans.logFinishTime();
        this.mProcessorReport.mStepTrans.result = 1;
        this.mTransferedSize = this.mFileSize;
        this.isBDHSuccess = true;
        sendMessageToUpdate(1007);
        sendMsg(false);
        this.file.closeInputStream();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction Success,delete combined file");
        }
        FileUtils.deleteFile(str);
        String str3 = hashMap.get("ip");
        String str4 = hashMap.get("port");
        String str5 = this.mFileName;
        String str6 = this.mResid;
        if (str6 == null) {
            str6 = this.mUuid;
        }
        reportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_VIDEOUP, true, 0, str3, str4, str5, str6, this.mReportBusiType + "");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
            return;
        }
        if (!z16 && RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode)) {
            return;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (!processorReport.mIsOldDbRec) {
            if (!z16 || (processorReport.mReportedFlag & 2) <= 0) {
                if (z16 || (processorReport.mReportedFlag & 1) <= 0) {
                    int i16 = processorReport.mReportedFlag;
                    if (z16) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    processorReport.mReportedFlag = i16 | i3;
                    TransferRequest transferRequest = this.mUiRequest;
                    int i17 = transferRequest.mUinType;
                    if (i17 == 1 || i17 == 3000) {
                        processorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, transferRequest.mPeerUin);
                    }
                    this.mProcessorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3));
                    HashMap<String, String> hashMap = this.mProcessorReport.mReportInfo;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.mReportBusiType);
                    sb5.append("");
                    hashMap.put("param_busiType", sb5.toString());
                    HashMap<String, String> hashMap2 = this.mProcessorReport.mReportInfo;
                    String str = this.mResid;
                    if (str == null) {
                        str = this.mUuid;
                    }
                    hashMap2.put(ReportConstant.KEY_UUID, str);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_TO_UIN, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_VIDEO_THUMB_SIZE, String.valueOf(this.mThumbFileSize));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_SECOND_TRANS, this.mIsSecondTransfered + "");
                    if (this.mUiRequest.mBusiType == 0) {
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_BDHEXIST_BEFORE_VIDEO_UPLOAD, String.valueOf(this.isBDHExistBeforeVideoUpload));
                    }
                    if (this.mSwitch != 3) {
                        this.mProcessorReport.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
                    }
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_FILE_MD5, this.mUiRequest.mMd5);
                    this.mProcessorReport.mReportInfo.put(TransReport.rep_BDH_Cache_Diff, String.valueOf(this.mIsCacheDiff));
                    if (z16) {
                        this.mProcessorReport.reportForIpv6(true, nanoTime, true, getReportTAG());
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, nanoTime, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                        doReportForGuild(true, nanoTime);
                    } else {
                        ProcessorReport processorReport2 = this.mProcessorReport;
                        if (processorReport2.errCode != -9527) {
                            processorReport2.mReportInfo.remove("param_rspHeader");
                        }
                        ProcessorReport processorReport3 = this.mProcessorReport;
                        processorReport3.mReportInfo.put("param_FailCode", String.valueOf(processorReport3.errCode));
                        ProcessorReport processorReport4 = this.mProcessorReport;
                        processorReport4.mReportInfo.put(ReportConstant.KEY_ERR_DESC, processorReport4.errDesc);
                        this.mProcessorReport.mReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(this.mUiRequest.mUinType));
                        this.mProcessorReport.reportForIpv6(false, nanoTime, true, getReportTAG());
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, nanoTime, this.mFileSize, this.mProcessorReport.mReportInfo, "");
                        doReportForGuild(false, nanoTime);
                    }
                    setReportFlag();
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "AutoMonitor_fragment MineFragment onAttach");
                    }
                    reportMoovInfo();
                    reportTemp(z16, nanoTime);
                }
            }
        }
    }

    protected String doReportForGuild(boolean z16, long j3) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, this, Boolean.valueOf(z16), Long.valueOf(j3));
        }
        if (10014 == this.mUiRequest.mUinType) {
            r.a aVar = new r.a();
            String str2 = "0";
            aVar.f231044a = "0";
            NetReq netReq = this.mNetReq;
            if (netReq != null) {
                str = ((HttpNetReq) netReq).mReqUrl;
            } else {
                str = "";
            }
            aVar.f231045b = str;
            aVar.f231046c = String.valueOf(this.mFileSize);
            aVar.f231047d = this.mUiRequest.mMd5;
            aVar.f231048e = String.valueOf(this.videoTime);
            aVar.f231049f = String.valueOf(System.currentTimeMillis() - j3);
            aVar.f231050g = String.valueOf(j3);
            if (!z16) {
                str2 = String.valueOf(this.mProcessorReport.errCode);
            }
            aVar.f231051h = str2;
            aVar.f231052i = this.mProcessorReport.errDesc;
            if (j3 > 0) {
                aVar.f231056m = (((((float) this.mFileSize) * 1.0f) / ((float) j3)) * 1000.0f) + "B/s";
            }
            FileMsg fileMsg = this.file;
            if (fileMsg != null) {
                aVar.f231054k = fileMsg.filePath;
            }
            aVar.f231055l = this.mFileName;
            r.d(GuildTelemetryTask.UPLOAD_VIDEO, aVar);
            return aVar.f231051h;
        }
        return null;
    }

    void doSendMsg(im_msg_body$RichText im_msg_body_richtext, aa aaVar, boolean z16) {
        MessageRecord messageRecord;
        String str;
        TransferRequest transferRequest = this.mUiRequest;
        ad adVar = transferRequest.mUpCallBack;
        if (adVar != null) {
            messageRecord = adVar.g(im_msg_body_richtext);
        } else {
            messageRecord = transferRequest.mRec;
            if (messageRecord == null) {
                IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class);
                TransferRequest transferRequest2 = this.mUiRequest;
                messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq);
            }
        }
        if (messageRecord != null && (messageRecord instanceof MessageForShortVideo)) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
            messageForShortVideo.richText = im_msg_body_richtext;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendMsg() start, subBusiType = " + messageForShortVideo.subBusiType);
            }
            TransferRequest transferRequest3 = this.mUiRequest;
            if (transferRequest3.mBusiType == 1010 && transferRequest3.mUpCallBack != null) {
                onSuccess();
                return;
            }
            if (messageRecord instanceof MessageForBlessPTV) {
                ((MessageForBlessPTV) messageRecord).uuid = this.mResid;
                ((IMessageHandler) this.app.getRuntimeService(IMessageHandler.class, "")).notifyUI(this.app, 999, true, messageRecord.frienduin);
                f.b(TAG, "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
                return;
            }
            if (!isAppValid()) {
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepMsg);
                onError();
                return;
            }
            if (messageRecord.istroop == 10014) {
                if (messageForShortVideo.embedVideo == 1) {
                    onSuccess();
                    return;
                }
                ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(messageRecord, ((IGPSService) this.app.getRuntimeService(IGPSService.class, "")).getGuildIdOf(messageRecord.frienduin));
                QLog.i("ShortVideoUploadProcessor<gld>.video", 1, "doSendMsg seq:" + messageRecord.uniseq);
            }
            bm.c(String.valueOf(this.mUiRequest.mUniseq), "message", "sendMsg() []. mr = " + messageRecord.toString());
            ((IOrderMediaMsgService) this.app.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(messageRecord, this.messageObserver);
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
        String sb6 = sb5.toString();
        ProcessorReport processorReport2 = this.mProcessorReport;
        processorReport2.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "msgtypeError", sb6, processorReport2.mStepMsg);
        onError();
    }

    public void doStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!buildVideoMd5()) {
            return;
        }
        if (((MessageForShortVideo) this.mUiRequest.mRec).busiType == 1 && VideoUpConfigInfo.sSwitch == 2) {
            this.mSwitch = 2;
        }
        if (!buildThumbInfo() || !handleBDHKey()) {
            return;
        }
        QLog.d(TAG, 1, "<BDH_LOG>mSwitch : " + this.mSwitch);
        if (this.mSwitch != 2) {
            sendRequest();
        } else {
            this.mChannelStatus = 1;
            sendFileByBDH();
        }
    }

    public void getBDHSessionInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        synchronized (SessionInfo.class) {
            if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null) {
                int length = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
                this.mSigSession = new byte[length];
                System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSigSession, 0, length);
            }
            if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey() != null) {
                int length2 = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey().length;
                this.mSessionKey = new byte[length2];
                System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey(), 0, this.mSessionKey, 0, length2);
            }
        }
    }

    public IMessageFacade getMessageFacade() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (IMessageFacade) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        int i3 = this.mUiRequest.mUinType;
        if (i3 != 1 && i3 != 3000) {
            if (this.mChannelStatus == 1) {
                return StatisticCollector.C2C_SHORTVIDEO_UPLOAD_BDH;
            }
            return StatisticCollector.C2C_SHORTVIDEO_UPLOAD;
        }
        if (this.mChannelStatus == 1) {
            return StatisticCollector.GROUP_SHORTVIDEO_UPLOAD_BDH;
        }
        return StatisticCollector.GROUP_SHORTVIDEO_UPLOAD;
    }

    protected void getThumbFileSize(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.mThumbFileWidth = options.outWidth;
        this.mThumbFileHeight = options.outHeight;
    }

    public boolean handleBDHKey() {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        getBDHSessionInfo();
        byte[] bArr2 = this.mSigSession;
        if (bArr2 == null || bArr2.length == 0 || (bArr = this.mSessionKey) == null || bArr.length == 0) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "sessionKey or sigSession is null ! ");
            }
            HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
            return true;
        }
        return true;
    }

    public void handleHotVideo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start() isHotVideo");
        }
        TransferRequest transferRequest = this.mUiRequest;
        Object obj = transferRequest.mExtraObj;
        if (obj == null || (obj instanceof p)) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) transferRequest.mRec;
            String str = messageForShortVideo.md5;
            if (str != null && str.length() > 0) {
                this.mMd5Str = messageForShortVideo.md5;
            }
            String str2 = messageForShortVideo.uuid;
            if (str2 != null && str2.length() > 0) {
                this.mUuid = messageForShortVideo.uuid;
            }
            String str3 = messageForShortVideo.thumbMD5;
            if (str3 != null && str3.length() > 0) {
                this.thumbFileMd5 = HexUtil.hexStr2Bytes(messageForShortVideo.thumbMD5);
            }
        }
        sendMessageToUpdate(1001);
        sendMsg(false);
    }

    void inter_retry() {
        Transaction transaction;
        if (this.mIsCancel) {
            return;
        }
        if (this.mChannelStatus == 1 && (transaction = this.mTrans) != null) {
            if (transaction.isSuccess.get()) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "inter_retry resume sendMsg!");
                }
                sendMsg(false);
                return;
            }
            this.app.getHwEngine().resumeTransactionTask(this.mTrans);
            return;
        }
        if (this.mResid != null && this.mTransferedSize >= this.mFileSize) {
            sendMsg(false);
        } else {
            start();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor
    public boolean isBDHSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.isBDHSuccess;
    }

    RichProto.RichProtoReq.ShortVideoUpReq makeShortVideoUpReq() {
        String str;
        int i3;
        RichProto.RichProtoReq.ShortVideoUpReq shortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
        TransferRequest transferRequest = this.mUiRequest;
        shortVideoUpReq.seq = (int) transferRequest.mUniseq;
        shortVideoUpReq.selfUin = transferRequest.mSelfUin;
        MessageRecord messageRecord = transferRequest.mRec;
        if (messageRecord != null && (messageRecord instanceof MessageForBlessPTV)) {
            MessageForBlessPTV messageForBlessPTV = (MessageForBlessPTV) messageRecord;
            ArrayList<String> arrayList = messageForBlessPTV.uinList;
            if (arrayList != null) {
                str = arrayList.get(0);
            } else {
                str = "0";
            }
            shortVideoUpReq.peerUin = str;
            shortVideoUpReq.subBusiType = 1;
            ArrayList<String> arrayList2 = messageForBlessPTV.uinList;
            if (arrayList2 != null) {
                i3 = arrayList2.size();
            } else {
                i3 = 1;
            }
            shortVideoUpReq.userCnt = i3;
        } else if (messageRecord != null && ((MessageForShortVideo) messageRecord).checkIsHotVideo()) {
            shortVideoUpReq.peerUin = this.mUiRequest.mPeerUin;
            shortVideoUpReq.subBusiType = 0;
            shortVideoUpReq.userCnt = 1;
        } else {
            TransferRequest transferRequest2 = this.mUiRequest;
            MessageRecord messageRecord2 = transferRequest2.mRec;
            if ((messageRecord2 instanceof MessageForShortVideo) && 10014 == transferRequest2.mUinType) {
                shortVideoUpReq.peerUin = transferRequest2.mPeerUin;
                shortVideoUpReq.subBusiType = ((MessageForShortVideo) messageRecord2).subBusiType;
                shortVideoUpReq.userCnt = 1;
            } else {
                shortVideoUpReq.peerUin = transferRequest2.mPeerUin;
                shortVideoUpReq.subBusiType = 0;
                shortVideoUpReq.userCnt = 1;
            }
        }
        TransferRequest transferRequest3 = this.mUiRequest;
        int i16 = transferRequest3.mUinType;
        shortVideoUpReq.uinType = i16;
        shortVideoUpReq.agentType = 0;
        if (i16 != 0 && 1008 != i16) {
            if ((transferRequest3.mRec instanceof MessageForShortVideo) && 10014 == i16) {
                shortVideoUpReq.troopUin = String.valueOf(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getGuildIdFromMR(this.mUiRequest.mRec));
            } else {
                shortVideoUpReq.troopUin = transferRequest3.mPeerUin;
            }
        } else {
            shortVideoUpReq.troopUin = null;
        }
        int i17 = shortVideoUpReq.uinType;
        if (i17 == 0) {
            shortVideoUpReq.chatType = 0;
        } else if (1 == i17) {
            shortVideoUpReq.chatType = 1;
        } else if (3000 == i17) {
            shortVideoUpReq.chatType = 2;
        } else if (10014 == i17) {
            shortVideoUpReq.chatType = 4;
        } else {
            shortVideoUpReq.chatType = 3;
        }
        shortVideoUpReq.clientType = 2;
        File file = new File(this.mUiRequest.mLocalPath);
        String name = file.getName();
        shortVideoUpReq.fileName = name;
        long length = file.length();
        shortVideoUpReq.fileSize = length;
        shortVideoUpReq.md5 = this.mLocalMd5;
        shortVideoUpReq.thumbFileMd5 = this.thumbFileMd5;
        shortVideoUpReq.fileResWidth = this.mThumbFileWidth;
        shortVideoUpReq.fileResLength = this.mThumbFileHeight;
        shortVideoUpReq.fileTime = this.videoTime;
        long j3 = this.mThumbFileSize;
        shortVideoUpReq.thumbFileSize = j3;
        FileMsg fileMsg = this.file;
        long j16 = length + j3;
        this.mFileSize = j16;
        fileMsg.fileSize = j16;
        int format = getFormat(name.substring(name.lastIndexOf(".") + 1));
        shortVideoUpReq.format = format;
        TransferRequest transferRequest4 = this.mUiRequest;
        shortVideoUpReq.sourceVideoCodecFormat = transferRequest4.mSourceVideoCodecFormat;
        int c16 = k.c(transferRequest4.mLocalPath);
        if (c16 > 0) {
            shortVideoUpReq.bitrateInKilo = c16 / 1000;
        }
        QLog.d(TAG, 1, "[H265_VIDEO]", " makeShortVideoUpReq sourceVideoCodecFormat = ", Integer.valueOf(shortVideoUpReq.sourceVideoCodecFormat));
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_VIDEO_FILE_FORMAT, String.valueOf(format));
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_RES_LENGTH, String.valueOf(this.mThumbFileHeight));
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_RES_WIDTH, String.valueOf(this.mThumbFileWidth));
        MessageRecord messageRecord3 = this.mUiRequest.mRec;
        if (messageRecord3 != null && (messageRecord3 instanceof MessageForShortVideo)) {
            shortVideoUpReq.busiType = ((MessageForShortVideo) messageRecord3).busiType;
        } else {
            shortVideoUpReq.busiType = 0;
        }
        this.mReportBusiType = shortVideoUpReq.busiType;
        return shortVideoUpReq;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.ShortVideoUpResp shortVideoUpResp = (RichProto.RichProtoResp.ShortVideoUpResp) richProtoResp.resps.get(i3);
                if (QLog.isColorLevel()) {
                    logRichMediaEvent("procUrl", shortVideoUpResp.toString());
                }
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, shortVideoUpResp);
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onBusiProtoResp()------response.result = " + shortVideoUpResp.result);
                }
                this.mResid = shortVideoUpResp.fileId;
                if (shortVideoUpResp.result == 0) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onBusiProtoResp()------response.isExist = " + shortVideoUpResp.isExist);
                    }
                    this.mVideoAttr = shortVideoUpResp.videoAttr;
                    this.mVideoKandianType = shortVideoUpResp.videoKandianType;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onBusiProtoResp()------response.videoAttr = " + shortVideoUpResp.videoAttr + ", response.videoKandianType = " + shortVideoUpResp.videoKandianType);
                    }
                    if (shortVideoUpResp.isExist) {
                        this.mIsSecondTransfered = true;
                        sendMessageToUpdate(1007);
                        sendMsg(true);
                    } else {
                        this.mStartOffset = shortVideoUpResp.startOffset;
                        log("<BDH_LOG> onBusiProtoResp() send by bdh");
                        this.mChannelStatus = 1;
                        sendFileByBDH();
                    }
                } else {
                    onError();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        String str;
        super.onError();
        if (this.mSwitch == 3 && (str = this.mMd5Str) != null && str.length() > 0) {
            MessageRecord messageRecord = this.mUiRequest.mRec;
            if (messageRecord == null) {
                IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class);
                TransferRequest transferRequest = this.mUiRequest;
                messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            }
            if (messageRecord != null && (messageRecord instanceof MessageForShortVideo)) {
                ((MessageForShortVideo) messageRecord).md5 = this.mMd5Str;
            }
        }
        sendMessageToUpdate(1005);
        QLog.e(TAG, 1, "onError()---- errCode:" + this.mProcessorReport.errCode);
        QLog.e(TAG, 1, "onError()---- errDesc:" + this.mProcessorReport.errDesc);
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            aVar.f258598b = processorReport.errCode;
            aVar.f258599c = processorReport.errDesc;
            this.mUiRequest.mUpCallBack.q(aVar);
        }
        MessageRecord messageRecord2 = this.mUiRequest.mRec;
        if (messageRecord2 != null && (messageRecord2 instanceof MessageForBlessPTV)) {
            ((IMessageHandler) this.app.getRuntimeService(IMessageHandler.class, "")).notifyUI(this.app, 999, false, this.mUiRequest.mRec.frienduin);
            f.b(TAG, "onError", "notifyUI bless ptv send error");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            long j3 = this.mFileSize;
            long j16 = this.mThumbFileSize;
            aVar.f258601e = j3 - j16;
            aVar.f258603g = this.mMd5Str;
            String str = this.mResid;
            if (str == null) {
                str = this.mUuid;
            }
            aVar.f258602f = str;
            aVar.f258605i = j16;
            aVar.f258606j = this.mVideoAttr;
            aVar.f258607k = this.mVideoKandianType;
            this.mUiRequest.mUpCallBack.q(aVar);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onSuccess uuid = " + aVar.f258602f);
            }
        } else {
            updateMessageDataBaseContent(true);
        }
        sendMessageToUpdate(1003);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSuccess().");
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (!this.mIsPause) {
            this.mIsPause = true;
            if (QLog.isColorLevel()) {
                logRichMediaEvent("pause", "");
            }
            sendMessageToUpdate(1004);
            TransferRequest transferRequest = this.mUiRequest;
            if (transferRequest.mBusiType == 1010 && transferRequest.mUpCallBack != null) {
                ad.a aVar = new ad.a();
                aVar.f258597a = -1;
                aVar.f258598b = AppConstants.RichMediaErrorCode.ERROR_USER_CANCEL;
                aVar.f258599c = "cancel";
                this.mUiRequest.mUpCallBack.q(aVar);
            }
            RichProto.RichProtoReq richProtoReq = this.mRichProtoReq;
            if (richProtoReq != null) {
                RichProtoProc.cancelRichProtoReq(richProtoReq);
                this.mRichProtoReq = null;
            }
            int i3 = this.mChannelStatus;
            if (i3 != 0) {
                if (i3 == 1) {
                    if (this.mTrans != null) {
                        log("<BDH_LOG> pause() pause BDH channel, transation id=" + this.mTrans.getTransationId());
                        this.app.getHwEngine().stopTransactionTask(this.mTrans);
                        return;
                    }
                    log("<BDH_LOG> pause() pause BDH channel, but trans == null");
                    return;
                }
                return;
            }
            log("<BDH_LOG> pause() BUT current status is INIT");
        }
    }

    protected void reportMoovInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
            return;
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (((MessageForShortVideo) transferRequest.mRec).busiType == 0) {
            ThreadManagerV2.post(new Runnable(transferRequest.mLocalPath) { // from class: com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$filePath;

                {
                    this.val$filePath = r5;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoUploadProcessor.this, (Object) r5);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long uptimeMillis = SystemClock.uptimeMillis();
                    File file = new File(this.val$filePath);
                    String d16 = j.d(file);
                    if (d16 == null) {
                        return;
                    }
                    long longValue = Long.valueOf(d16.split("\\|")[0]).longValue();
                    long longValue2 = Long.valueOf(d16.split("\\|")[1]).longValue();
                    long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("param_moovOffset", longValue + "");
                    hashMap.put("param_moovSize", longValue2 + "");
                    hashMap.put("param_videoLen", file.length() + "");
                    hashMap.put("param_moovPosition", new DecimalFormat("##.000").format((((double) longValue) * 1.0d) / ((double) file.length())) + "");
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actShortVideoMoov", false, uptimeMillis2, -1L, hashMap, "");
                }
            }, 5, null, true);
        }
    }

    protected void reportTemp(boolean z16, long j3) {
        BaseQQAppInterface baseQQAppInterface;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (this.mTrans != null && this.mChannelStatus == 1 && (baseQQAppInterface = this.app) != null && baseQQAppInterface.getHwEngine() != null && this.app.getHwEngine().getCurrentConfig().segNum > 32) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("segNum", String.valueOf(this.app.getHwEngine().getCurrentConfig().segNum));
            hashMap.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "tempVideoUploadBDH", z16, j3, this.mFileSize, hashMap, "");
        }
    }

    void resetStatictisInfo() {
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

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "resume()  + mIsPause : " + this.mIsPause);
        }
        if (this.mIsPause) {
            this.mIsPause = false;
            this.mIsCancel = false;
            sendMessageToUpdate(1002);
            this.mServerRollbackCount = 0;
            this.mTryCount = 0;
            this.mReqUrlCount = 0;
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.errCode = 0;
            processorReport.errDesc = "";
            resetStatictisInfo();
            sendMessageToUpdate(1001);
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoUploadProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ShortVideoUploadProcessor.this.inter_retry();
                    }
                }
            });
        }
        return 0;
    }

    public void sendFileByBDH() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        if (this.mTrans != null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        String combineThumbAndVideo = combineThumbAndVideo();
        RichProto.RichProtoReq.ShortVideoUpReq makeShortVideoUpReq = makeShortVideoUpReq();
        byte[] buildExtendInfo = buildExtendInfo(makeShortVideoUpReq);
        ITransactionCallback iTransactionCallback = new ITransactionCallback(combineThumbAndVideo, uptimeMillis) { // from class: com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$combinePath;
            final /* synthetic */ long val$startTime;

            {
                this.val$combinePath = combineThumbAndVideo;
                this.val$startTime = uptimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ShortVideoUploadProcessor.this, combineThumbAndVideo, Long.valueOf(uptimeMillis));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i16, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i16), bArr, hashMap);
                } else {
                    ShortVideoUploadProcessor.this.doOnSendFailed(i16, hashMap, this.val$startTime);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                } else {
                    ShortVideoUploadProcessor.this.doOnSendSuccess(bArr, hashMap, this.val$combinePath, this.val$startTime);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSwitch2BackupChannel() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this);
                    return;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis();
                ShortVideoUploadProcessor.this.log("<BDH_LOG> onSwitch2BackupChannel()");
                ShortVideoUploadProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis2 - this.val$startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                ShortVideoUploadProcessor.this.log("<BDH_LOG> onTransStart()");
                StepInfo stepInfo = ShortVideoUploadProcessor.this.mProcessorReport.mStepTrans;
                stepInfo.startTime = 0L;
                stepInfo.logStartTime();
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onUpdateProgress(int i16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i16);
                    return;
                }
                ShortVideoUploadProcessor shortVideoUploadProcessor = ShortVideoUploadProcessor.this;
                long j3 = i16;
                shortVideoUploadProcessor.file.transferedSize = j3;
                shortVideoUploadProcessor.mTransferedSize = j3;
                if (j3 < shortVideoUploadProcessor.mFileSize && !shortVideoUploadProcessor.mIsCancel && !shortVideoUploadProcessor.mIsPause) {
                    shortVideoUploadProcessor.sendProgressMessage();
                }
            }
        };
        int i16 = makeShortVideoUpReq.busiType;
        if (i16 == 0) {
            i3 = 25;
        } else {
            if (i16 == 4601) {
                int i17 = makeShortVideoUpReq.subBusiType;
                if (i17 == 4601) {
                    i3 = 89;
                } else if (i17 == 4602) {
                    i3 = 87;
                }
            }
            i3 = 12;
        }
        this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i3, combineThumbAndVideo, (int) this.mStartOffset, this.mLocalMd5, iTransactionCallback, buildExtendInfo, true);
        this.mTrans.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoUploadProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public void onFailed(int i18, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i18), str, str2);
                    return;
                }
                ShortVideoUploadProcessor shortVideoUploadProcessor = ShortVideoUploadProcessor.this;
                String str3 = shortVideoUploadProcessor.mFileName;
                String str4 = shortVideoUploadProcessor.mResid;
                if (str4 == null) {
                    str4 = shortVideoUploadProcessor.mUuid;
                }
                shortVideoUploadProcessor.reportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_VIDEOUP, false, i18, str, str2, str3, str4, ShortVideoUploadProcessor.this.mReportBusiType + "");
            }
        };
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + i3);
        }
        if (submitTransactionTask != 0) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(submitTransactionTask, "sendFileByBDH SubmitError.", "", processorReport.mStepTrans);
            onError();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void sendMessageToUpdate(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        super.sendMessageToUpdate(i3);
        if (i3 != 1002 && QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendMessageToUpdate------state = " + i3 + ", str= " + j.a(i3));
        }
        if (this.mIsPause && 1004 != i3) {
            return;
        }
        h.r(this.app, this.file, this.mUiRequest);
    }

    void sendMsg(boolean z16) {
        aa aaVar;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendMsg() start.");
        }
        if (!canDoNextStep()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "do not send message, due to mIsCancel=true || mIsPause=true.");
                return;
            }
            return;
        }
        Object obj = this.mUiRequest.mExtraObj;
        if (obj != null && (obj instanceof aa)) {
            aaVar = (aa) obj;
            this.mNeedSyncStory = aaVar.N;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendMsg() start, mNeedSyncStory = " + this.mNeedSyncStory);
            }
        } else {
            aaVar = null;
        }
        if (aaVar != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendMsg() start, isHotVideo = " + aaVar.D);
            }
            if (aaVar.D) {
                this.mUuid = aaVar.f288039b;
                String str = aaVar.f288047j;
                this.mMd5Str = str;
                this.mLocalMd5 = HexUtil.hexStr2Bytes(str);
                long j3 = aaVar.f287749r;
                long j16 = aaVar.L;
                this.mFileSize = j3 + j16;
                this.videoTime = aaVar.f287750s;
                this.mThumbFileSize = j16;
                this.thumbFileMd5 = HexUtil.hexStr2Bytes(aaVar.f288049l);
                this.mThumbFileHeight = aaVar.f287748q;
                this.mThumbFileWidth = aaVar.f287747p;
            }
        }
        if (!this.needSendMsg) {
            return;
        }
        bm.c(String.valueOf(this.mUiRequest.mUniseq), "message", "sendMsg() start.");
        this.mProcessorReport.mStepMsg.logStartTime();
        im_msg_body$RichText constructRichText = constructRichText();
        if (constructRichText == null) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, processorReport.mStepMsg);
            onError();
            return;
        }
        doSendMsg(constructRichText, aaVar, z16);
    }

    void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendGetUrlReq()----busiReq.seq : " + this.mUiRequest.mUniseq);
        }
        RichProto.RichProtoReq.ShortVideoUpReq makeShortVideoUpReq = makeShortVideoUpReq();
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.SHORT_VIDEO_UP;
        richProtoReq.reqs.add(makeShortVideoUpReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
            return;
        }
        if (makeShortVideoUpReq.fileSize == 0) {
            this.mProcessorReport.setError(9303, "video filesize is 0", null, null);
            onError();
            return;
        }
        if (this.mThumbFileSize == 0) {
            this.mProcessorReport.setError(9303, "thumbfile filesize is 0", null, null);
            onError();
            return;
        }
        if (makeShortVideoUpReq.busiType == 0 && this.app.getHwEngine().mConnManager.getCurrentConnNum() > 0) {
            this.isBDHExistBeforeVideoUpload = Boolean.TRUE;
        }
        logRichMediaEvent("requestStart", richProtoReq.toString());
        if (!canDoNextStep()) {
            QLog.e(TAG, 1, "canDoNextStep IsCancel " + this.mIsCancel + " isPause" + this.mIsPause);
            return;
        }
        this.mRichProtoReq = richProtoReq;
        RichProtoProc.procRichProtoReq(richProtoReq);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mIsCancel) {
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (((MessageForShortVideo) messageRecord).busiType == 0 && ((MessageForShortVideo) messageRecord).isPause) {
            QLog.d(TAG, 1, "video send pause!");
            pause();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start()");
        }
        super.start();
        if (((MessageForShortVideo) this.mUiRequest.mRec).checkIsHotVideo()) {
            handleHotVideo();
            return;
        }
        Object obj = this.mUiRequest.mExtraObj;
        if (obj != null && (obj instanceof aa)) {
            this.isFromFavorite = ((aa) obj).R;
        }
        sendMessageToUpdate(1001);
        this.file.closeInputStream();
        doStart();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void updateMessageDataBaseContent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, z16);
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (messageRecord == null) {
            IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class);
            TransferRequest transferRequest = this.mUiRequest;
            messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
        }
        if (messageRecord == null) {
            logRichMediaEvent("updateDb", "msg null");
            return;
        }
        if (messageRecord instanceof MessageForShortVideo) {
            MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
            messageForShortVideo.videoFileSize = (int) (this.mFileSize - this.mThumbFileSize);
            String str = this.mResid;
            if (str == null) {
                str = this.mUuid;
            }
            messageForShortVideo.uuid = str;
            messageForShortVideo.md5 = this.mMd5Str;
            messageForShortVideo.videoAttr = this.mVideoAttr;
            messageForShortVideo.videoKandianType = this.mVideoKandianType;
            messageForShortVideo.serial();
            IMessageFacade messageFacade = getMessageFacade();
            TransferRequest transferRequest2 = this.mUiRequest;
            messageFacade.updateMsgContentByUniseq(transferRequest2.mPeerUin, transferRequest2.mUinType, messageRecord.uniseq, messageForShortVideo.msgData);
        }
    }
}

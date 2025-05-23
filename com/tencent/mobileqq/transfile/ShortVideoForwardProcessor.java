package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.qqstory.utils.k;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pic.ad;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.api.IShortVideoReForwardProcessor;
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
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import eipc.EIPCResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
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
public class ShortVideoForwardProcessor extends BaseShortVideoUploadProcessor implements xq2.a {
    static IPatchRedirector $redirector_ = null;
    public static final String SEPERATOR = "QQ_&_MoblieQQ_&_QQ";
    public static final String TAG = "ShortVideoForwardProcessor";
    BaseQQAppInterface app;
    boolean isStoryVideo;
    public boolean isUploadSuccess;
    public boolean mIsFromMsgTabCamera;
    boolean mIsSecondTransfered;
    int mReportBusiType;
    protected int mThumbFileHeight;
    protected String mThumbFilePath;
    protected long mThumbFileSize;
    protected int mThumbFileWidth;
    byte[] mThumbMd5Local;
    int mVideoAttr;
    String mVideoFileName;
    long mVideoFileSize;
    int mVideoKandianType;
    byte[] mVideoMd5Local;
    bo messageObserver;

    /* renamed from: msg, reason: collision with root package name */
    MessageForShortVideo f293466msg;
    protected int videoTime;

    public ShortVideoForwardProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mReportBusiType = -1;
        this.mIsSecondTransfered = false;
        this.mVideoAttr = 0;
        this.mVideoKandianType = 0;
        this.isStoryVideo = false;
        this.f293466msg = null;
        this.isUploadSuccess = false;
        this.messageObserver = new bo() { // from class: com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.4
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoForwardProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.app.bo
            public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                    return;
                }
                ShortVideoForwardProcessor.this.logRichMediaEvent("sendMsgFinish", "success:" + z16);
                ProcessorReport processorReport = ShortVideoForwardProcessor.this.mProcessorReport;
                processorReport.copyStatisInfo(processorReport.mStepMsg, false, z16, statictisInfo);
                if (z16) {
                    ShortVideoForwardProcessor.this.onSuccess();
                } else {
                    ShortVideoForwardProcessor.this.onError();
                }
            }
        };
        this.app = (BaseQQAppInterface) super.app;
        TransferRequest transferRequest2 = this.mUiRequest;
        if (transferRequest2 != null && (messageRecord = transferRequest2.mRec) != null && (messageRecord instanceof MessageForShortVideo)) {
            this.mReportBusiType = ((MessageForShortVideo) messageRecord).busiType;
            boolean z16 = ((MessageForShortVideo) messageRecord).isStoryVideo;
            this.isStoryVideo = z16;
            if (z16) {
                this.f293466msg = (MessageForShortVideo) messageRecord;
            }
        } else {
            this.mReportBusiType = 0;
        }
        String str = transferRequest.mLocalPath;
        String[] split = str.split(SEPERATOR);
        if (4 != split.length) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "path was not set correctlly------path = " + str);
            }
            this.mProcessorReport.setError(9304, "path =" + str, null, null);
            onError();
            this.mIsCancel = true;
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "init ShortVideoForwardProcessor=> " + Arrays.toString(split));
        }
        transferRequest.mLocalPath = split[0];
        this.mThumbFilePath = split[1];
        this.videoTime = Integer.parseInt(split[2]);
        this.thumbFileMd5 = HexUtil.hexStr2Bytes(split[3]);
    }

    private im_msg_body$RichText constructRichText() {
        MessageForShortVideo messageForShortVideo;
        try {
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body$VideoFile im_msg_body_videofile = new im_msg_body$VideoFile();
            im_msg_body_videofile.setHasFlag(true);
            byte[] bArr = this.mLocalMd5;
            if (bArr != null && bArr.length > 0) {
                im_msg_body_videofile.bytes_file_md5.set(ByteStringMicro.copyFrom(bArr));
            }
            String str = this.mResid;
            if (str != null && str.length() > 0) {
                im_msg_body_videofile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "constructRichText(): mResid uuid=" + this.mResid);
            }
            MessageRecord messageRecord = this.mUiRequest.mRec;
            if (messageRecord instanceof MessageForShortVideo) {
                messageForShortVideo = (MessageForShortVideo) messageRecord;
            } else {
                messageForShortVideo = null;
            }
            if (messageForShortVideo != null) {
                im_msg_body_videofile.uint32_file_format.set(messageForShortVideo.videoFileFormat);
                im_msg_body_videofile.uint32_file_time.set(messageForShortVideo.videoFileTime);
                String str2 = messageForShortVideo.videoFileName;
                if (str2 != null && str2.length() > 0) {
                    im_msg_body_videofile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.videoFileName));
                }
                String str3 = messageForShortVideo.fileSource;
                if (str3 != null && str3.length() > 0) {
                    im_msg_body_videofile.bytes_source.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.fileSource));
                }
                im_msg_body_videofile.uint32_busi_type.set(messageForShortVideo.busiType);
                im_msg_body_videofile.uint32_from_chat_type.set(messageForShortVideo.fromChatType);
                im_msg_body_videofile.uint32_to_chat_type.set(messageForShortVideo.toChatType);
                im_msg_body_videofile.bool_support_progressive.set(messageForShortVideo.supportProgressive);
                im_msg_body_videofile.uint32_file_width.set(messageForShortVideo.fileWidth);
                im_msg_body_videofile.uint32_file_height.set(messageForShortVideo.fileHeight);
            }
            byte[] bArr2 = this.thumbFileMd5;
            if (bArr2 != null && bArr2.length > 0) {
                im_msg_body_videofile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(bArr2));
            }
            im_msg_body_videofile.uint32_thumb_file_size.set((int) this.mThumbFileSize);
            im_msg_body_videofile.uint32_file_size.set((int) this.mVideoFileSize);
            im_msg_body_videofile.uint32_thumb_width.set(this.mThumbFileWidth);
            im_msg_body_videofile.uint32_thumb_height.set(this.mThumbFileHeight);
            String str4 = this.mVideoFileName;
            if (str4 != null && str4.length() > 0) {
                im_msg_body_videofile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mVideoFileName));
            }
            videoFile$ResvAttr videofile_resvattr = new videoFile$ResvAttr();
            setExtendAttrs(messageForShortVideo, videofile_resvattr);
            if (this.mIsFromMsgTabCamera) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "videoSource report : 3 , from msg tab camera");
                }
                videofile_resvattr.uint32_source.set(3);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "videoSource report : 4 , from forward");
                }
                videofile_resvattr.uint32_source.set(4);
            }
            im_msg_body_videofile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(videofile_resvattr.toByteArray()));
            im_msg_body_videofile.uint32_video_attr.set(this.mVideoAttr);
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.setHasFlag(true);
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.qqStr(R.string.thg)));
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body_elem.text.set(im_msg_body_text);
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body_elem2.video_file.set(im_msg_body_videofile);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            im_msg_body_richtext.elems.add(im_msg_body_elem2);
            return im_msg_body_richtext;
        } catch (Exception e16) {
            logRichMediaEvent("Construct richtext", "Construct richtext error");
            e16.printStackTrace();
            return null;
        }
    }

    private boolean handleNotExistForH265() {
        TransferRequest transferRequest = this.mUiRequest;
        if ((transferRequest.mExtraObj instanceof p) && (transferRequest.mRec instanceof MessageForShortVideo)) {
            return ((IShortVideoReForwardProcessor) QRoute.api(IShortVideoReForwardProcessor.class)).handleForwardVideoNotExistsOnServer(this.app, (MessageForShortVideo) this.mUiRequest.mRec);
        }
        return false;
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

    private void setExtendAttrs(MessageForShortVideo messageForShortVideo, videoFile$ResvAttr videofile_resvattr) {
        if (messageForShortVideo != null && messageForShortVideo.checkIsHotVideo()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "constructRichText MessageForHotVideo ");
            }
            String str = messageForShortVideo.hotVideoIconUrl;
            if (str != null && str.length() > 0) {
                videofile_resvattr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoIconUrl));
            }
            String str2 = messageForShortVideo.hotVideoTitle;
            if (str2 != null && str2.length() > 0) {
                videofile_resvattr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoTitle));
            }
            String str3 = messageForShortVideo.hotVideoUrl;
            if (str3 != null && str3.length() > 0) {
                videofile_resvattr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoUrl));
            }
            String str4 = messageForShortVideo.hotVideoSubIconUrl;
            if (str4 != null && str4.length() > 0) {
                videofile_resvattr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.hotVideoSubIconUrl));
            }
            videofile_resvattr.uint32_special_video_type.set(messageForShortVideo.specialVideoType);
        }
        if (messageForShortVideo != null) {
            videofile_resvattr.uint32_msg_tail_type.set(messageForShortVideo.msgTailType);
            if (messageForShortVideo.checkIsDanceVideo()) {
                videofile_resvattr.uint32_special_video_type.set(messageForShortVideo.specialVideoType);
            }
            PBBytesField pBBytesField = videofile_resvattr.bytes_camera_templateid;
            String str5 = messageForShortVideo.templateId;
            String str6 = "";
            if (str5 == null) {
                str5 = "";
            }
            pBBytesField.set(ByteStringMicro.copyFromUtf8(str5));
            PBBytesField pBBytesField2 = videofile_resvattr.bytes_camera_templateName;
            String str7 = messageForShortVideo.templateName;
            if (str7 != null) {
                str6 = str7;
            }
            pBBytesField2.set(ByteStringMicro.copyFromUtf8(str6));
        }
        videofile_resvattr.uint32_long_video_kandian_type.set(this.mVideoKandianType);
        if (messageForShortVideo != null) {
            int i3 = messageForShortVideo.sourceVideoCodecFormat;
            if (i3 >= 0) {
                videofile_resvattr.uint32_source_codec_format.set(i3);
            }
            if (!TextUtils.isEmpty(messageForShortVideo.originVideoMd5)) {
                videofile_resvattr.bytes_original_video_md5.set(ByteStringMicro.copyFromUtf8(messageForShortVideo.originVideoMd5));
            }
        }
    }

    public byte[] buildExtendInfo(RichProto.RichProtoReq.ShortVideoForwardReq shortVideoForwardReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this, (Object) shortVideoForwardReq);
        }
        PttShortVideo$PttShortVideoUploadReq pttShortVideo$PttShortVideoUploadReq = new PttShortVideo$PttShortVideoUploadReq();
        pttShortVideo$PttShortVideoUploadReq.setHasFlag(true);
        pttShortVideo$PttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(this.app.getCurrentAccountUin()));
        pttShortVideo$PttShortVideoUploadReq.uint64_touin.set(Long.parseLong(shortVideoForwardReq.peerUin));
        pttShortVideo$PttShortVideoUploadReq.uint32_chat_type.set(shortVideoForwardReq.toChatType);
        pttShortVideo$PttShortVideoUploadReq.uint32_client_type.set(shortVideoForwardReq.clientType);
        String str = shortVideoForwardReq.troopUin;
        if (str != null) {
            pttShortVideo$PttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(str));
        } else {
            pttShortVideo$PttShortVideoUploadReq.uint64_group_code.set(0L);
        }
        pttShortVideo$PttShortVideoUploadReq.uint32_agent_type.set(shortVideoForwardReq.agentType);
        pttShortVideo$PttShortVideoUploadReq.uint32_business_type.set(shortVideoForwardReq.toBusiType);
        pttShortVideo$PttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
        pttShortVideo$PttShortVideoUploadReq.uint32_codec_format.set(shortVideoForwardReq.sourceVideoCodecFormat);
        PttShortVideo$PttShortVideoFileInfo pttShortVideo$PttShortVideoFileInfo = new PttShortVideo$PttShortVideoFileInfo();
        PBStringField pBStringField = pttShortVideo$PttShortVideoFileInfo.str_file_name;
        String str2 = shortVideoForwardReq.fileName;
        if (str2 == null) {
            str2 = "";
        }
        pBStringField.set(str2);
        pttShortVideo$PttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(shortVideoForwardReq.md5));
        pttShortVideo$PttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(shortVideoForwardReq.thumbFileMd5));
        pttShortVideo$PttShortVideoFileInfo.uint64_file_size.set(shortVideoForwardReq.fileSize);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_res_length.set(shortVideoForwardReq.fileResLength);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_res_width.set(shortVideoForwardReq.fileResWidth);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_format.set(shortVideoForwardReq.format);
        pttShortVideo$PttShortVideoFileInfo.uint32_file_time.set(shortVideoForwardReq.fileTime);
        pttShortVideo$PttShortVideoFileInfo.uint64_thumb_file_size.set(shortVideoForwardReq.thumbFileSize);
        if (shortVideoForwardReq.bitrateInKilo > 0) {
            PttShortVideo$PttShortVideoFileInfoExtend pttShortVideo$PttShortVideoFileInfoExtend = new PttShortVideo$PttShortVideoFileInfoExtend();
            pttShortVideo$PttShortVideoFileInfoExtend.uint32_bit_rate.set(shortVideoForwardReq.bitrateInKilo);
            pttShortVideo$PttShortVideoFileInfo.bytes_extend.set(ByteStringMicro.copyFrom(pttShortVideo$PttShortVideoFileInfoExtend.toByteArray()));
        }
        pttShortVideo$PttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(pttShortVideo$PttShortVideoFileInfo);
        return pttShortVideo$PttShortVideoUploadReq.toByteArray();
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

    /* JADX WARN: Removed duplicated region for block: B:42:0x006d A[Catch: Exception -> 0x0070, TRY_LEAVE, TryCatch #1 {Exception -> 0x0070, blocks: (B:47:0x0068, B:42:0x006d), top: B:46:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0068 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkVideoBroken() {
        FileInputStream fileInputStream;
        Throwable th5;
        ReportMediaPlayer reportMediaPlayer;
        Throwable th6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        ReportMediaPlayer reportMediaPlayer2 = null;
        try {
            reportMediaPlayer = new ReportMediaPlayer();
            try {
                fileInputStream = new FileInputStream(this.mUiRequest.mLocalPath);
            } catch (Exception unused) {
                fileInputStream = null;
            } catch (Throwable th7) {
                th6 = th7;
                fileInputStream = null;
                th5 = th6;
                if (reportMediaPlayer != null) {
                }
                if (fileInputStream != null) {
                }
                throw th5;
            }
            try {
                reportMediaPlayer.setDataSource(fileInputStream.getFD());
                reportMediaPlayer.prepare();
                try {
                    reportMediaPlayer.release();
                    fileInputStream.close();
                } catch (Exception unused2) {
                }
                return false;
            } catch (Exception unused3) {
                reportMediaPlayer2 = reportMediaPlayer;
                try {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "ShortVideo can not play");
                    }
                    if (reportMediaPlayer2 != null) {
                        try {
                            reportMediaPlayer2.release();
                        } catch (Exception unused4) {
                            return true;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return true;
                } catch (Throwable th8) {
                    th6 = th8;
                    reportMediaPlayer = reportMediaPlayer2;
                    th5 = th6;
                    if (reportMediaPlayer != null) {
                        try {
                            reportMediaPlayer.release();
                        } catch (Exception unused5) {
                            throw th5;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th5;
                }
            } catch (Throwable th9) {
                th5 = th9;
                if (reportMediaPlayer != null) {
                }
                if (fileInputStream != null) {
                }
                throw th5;
            }
        } catch (Exception unused6) {
            fileInputStream = null;
        } catch (Throwable th10) {
            fileInputStream = null;
            th5 = th10;
            reportMediaPlayer = null;
        }
    }

    public boolean checkVideoFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        String str = this.mUiRequest.mLocalPath;
        if (str != null && str.length() > 0) {
            byte[] bArr = this.mVideoMd5Local;
            if (bArr == null || bArr.length == 0) {
                this.mVideoMd5Local = HexUtil.hexStr2Bytes(FileUtils.calcMd5(this.mUiRequest.mLocalPath));
            }
            File file = new File(this.mUiRequest.mLocalPath);
            if (file.exists() && file.length() > 0) {
                this.mVideoFileSize = file.length();
                this.mVideoFileName = file.getName();
                return true;
            }
            this.mProcessorReport.setError(9042, "onBusiProtoResp=> video file not exists", null, null);
            onError();
            return false;
        }
        this.mProcessorReport.setError(9302, "onBusiProtoResp=> video file path null", null, null);
        onError();
        return false;
    }

    public void doOnSendFailed(int i3, HashMap<String, String> hashMap, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), hashMap, Long.valueOf(j3));
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (uptimeMillis - j3) + "ms");
        }
        addBDHReportInfo(hashMap);
        ProcessorReport processorReport = this.mProcessorReport;
        processorReport.setError(i3, "OnFailed.", "", processorReport.mStepTrans);
        onError();
    }

    public void doOnSendSucess(byte[] bArr, HashMap<String, String> hashMap, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, bArr, hashMap, str, Long.valueOf(j3));
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
        this.mProcessorReport.mStepTrans.logFinishTime();
        this.mProcessorReport.mStepTrans.result = 1;
        this.mTransferedSize = this.mFileSize;
        this.isUploadSuccess = true;
        sendMsg(false);
        this.file.closeInputStream();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> Transaction Success,delete combined file");
        }
        FileUtils.deleteFile(str);
        reportForServerMonitor(true, 0, hashMap.get("ip"), hashMap.get("port"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void doReport(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
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
                    processorReport.mEndTime = System.currentTimeMillis();
                    long nanoTime = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000;
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_STEP_INFO, this.mProcessorReport.mStepUrl.getReportInfo(1) + ";" + this.mProcessorReport.mStepTrans.getReportInfo(2) + ";" + this.mProcessorReport.mStepMsg.getReportInfo(3));
                    HashMap<String, String> hashMap = this.mProcessorReport.mReportInfo;
                    String str = this.mResid;
                    if (str == null) {
                        str = this.mUuid;
                    }
                    hashMap.put(ReportConstant.KEY_UUID, str);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_TO_UIN, this.mUiRequest.mPeerUin);
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_GROUP_ID, this.mUiRequest.mPeerUin);
                    if (this.mIpList.size() > 0) {
                        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SERVER_VIDEO_IPS, this.mIpList.toString());
                    }
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_SIZE, String.valueOf(this.mFileSize));
                    this.mProcessorReport.mReportInfo.put("param_busiType", this.mReportBusiType + "");
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_FILE_MD5, HexUtil.bytes2HexStr(this.mLocalMd5));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_VIDEO_THUMB_SIZE, String.valueOf(this.mThumbFileSize));
                    this.mProcessorReport.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
                    this.mProcessorReport.mReportInfo.put(ReportConstant.KEYIS_SECOND_TRANS, this.mIsSecondTransfered + "");
                    MessageRecord messageRecord = this.mUiRequest.mRec;
                    if (messageRecord != null) {
                        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("video_download_response_codec_format");
                        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_VIDEO_CODEC_FORMAT, extInfoFromExtStr);
                        }
                    }
                    if (z16) {
                        this.mProcessorReport.reportForIpv6(true, nanoTime, true, getReportTAG());
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, nanoTime, this.mFileSize, this.mProcessorReport.mReportInfo, "");
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
                    }
                    setReportFlag();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("ShortVideoForward, cost=");
                    StepInfo stepInfo = this.mProcessorReport.mStepTrans;
                    sb5.append((stepInfo.finishTime - stepInfo.startTime) / 1000000);
                    sb5.append(", getReportTAG = ");
                    sb5.append(getReportTAG());
                    Log.i("AutoMonitor", sb5.toString());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public String getReportTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        if (this.mChannelStatus == 1) {
            return StatisticCollector.SHORTVIDEO_FORWARD_BDH;
        }
        return StatisticCollector.SHORTVIDEO_FORWARD;
    }

    protected void getThumbFileSize(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        this.mThumbFileWidth = options.outWidth;
        this.mThumbFileHeight = options.outHeight;
    }

    public void handleNotExist(RichProto.RichProtoResp.ShortVideoForwardResp shortVideoForwardResp) {
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) shortVideoForwardResp);
            return;
        }
        if (this.mReportBusiType == 0) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "check ShortVideo before forward:" + this.mUiRequest.mLocalPath);
            }
            if (checkVideoBroken() && j.m()) {
                this.mProcessorReport.setError(9305, "onBusiProtoResp=> video file can not play", null, null);
                onError();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
                hashMap.put("filePath", this.mUiRequest.mLocalPath);
                hashMap.put("uuid", this.mUuid);
                hashMap.put("md5", this.mUiRequest.mMd5);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.FORWARD_VIDEO_BROKEN, true, 0L, 0L, hashMap, "");
                return;
            }
        }
        if (!checkVideoFile()) {
            return;
        }
        String str = this.mThumbFilePath;
        if (str != null && str.length() > 0) {
            byte[] bArr4 = this.mThumbMd5Local;
            if (bArr4 == null || bArr4.length == 0) {
                this.mThumbMd5Local = HexUtil.hexStr2Bytes(FileUtils.calcMd5(this.mThumbFilePath));
            }
            File file = new File(this.mThumbFilePath);
            if (file.exists() && file.length() > 0) {
                this.mThumbFileSize = file.length();
                getThumbFileSize(this.mThumbFilePath);
                this.mFileSize = this.mVideoFileSize + this.mThumbFileSize;
                byte[] bArr5 = this.mLocalMd5;
                if (bArr5 != null && bArr5.length > 0 && (bArr = this.mVideoMd5Local) != null && bArr.length > 0 && (bArr2 = this.thumbFileMd5) != null && bArr2.length > 0 && (bArr3 = this.mThumbMd5Local) != null && bArr3.length > 0 && (!Arrays.equals(bArr5, bArr) || !Arrays.equals(this.thumbFileMd5, this.mThumbMd5Local))) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "md5 diffrent : resend request !   mLocalMd5 : " + HexUtil.bytes2HexStr(this.mLocalMd5) + " mVideoMd5_local : " + HexUtil.bytes2HexStr(this.mVideoMd5Local) + " thumbFileMd5 : " + HexUtil.bytes2HexStr(this.thumbFileMd5) + " mThumbMd5_local : " + HexUtil.bytes2HexStr(this.mThumbMd5Local));
                    }
                    this.mLocalMd5 = this.mVideoMd5Local;
                    this.thumbFileMd5 = this.mThumbMd5Local;
                    sendRequest();
                    return;
                }
                FileMsg fileMsg = this.file;
                long j3 = this.mVideoFileSize + this.mThumbFileSize;
                this.mFileSize = j3;
                fileMsg.fileSize = j3;
                if (handleNotExistForH265()) {
                    QLog.d(TAG, 1, "[H265_VIDEO]", "onBusiProtoResp()=> handleNotExist return, because has been handled by ShortVideoReForwardProcessor.");
                    return;
                }
                this.mStartOffset = shortVideoForwardResp.startOffset;
                this.mChannelStatus = 1;
                sendFileByBDH();
                return;
            }
            this.mProcessorReport.setError(9042, "onBusiProtoResp=> thumb file not exists", null, null);
            onError();
            return;
        }
        this.mProcessorReport.setError(9302, "onBusiProtoResp=> mThumbFilePath is null", null, null);
        onError();
    }

    void inter_retry() {
        if (this.mIsCancel) {
            return;
        }
        if (this.mResid != null) {
            if (this.mTransferedSize >= this.mFileSize) {
                sendMsg(false);
                return;
            } else if (this.mChannelStatus == 1 && this.mTrans != null) {
                this.app.getHwEngine().resumeTransactionTask(this.mTrans);
                return;
            } else {
                start();
                return;
            }
        }
        start();
    }

    @Override // xq2.a
    public boolean isUpLoadSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.isUploadSuccess;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void logRichMediaEvent(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.file == null) {
            TransFileUtil.printRichMediaError(TAG, "logRichMediaEvent", "file is null !");
            return;
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest != null) {
            RichMediaUtil.logForFw("T", TransFileUtil.getUinDesc(transferRequest.mUinType), RichMediaUtil.getFileTypeDesc(this.file.fileType), String.valueOf(this.file.uniseq), str, str2, null);
        }
    }

    RichProto.RichProtoReq.ShortVideoForwardReq makeShortVideoForwardReq() {
        RichProto.RichProtoReq.ShortVideoForwardReq shortVideoForwardReq = new RichProto.RichProtoReq.ShortVideoForwardReq();
        TransferRequest transferRequest = this.mUiRequest;
        shortVideoForwardReq.seq = (int) transferRequest.mUniseq;
        shortVideoForwardReq.selfUin = transferRequest.mSelfUin;
        String str = transferRequest.mPeerUin;
        shortVideoForwardReq.peerUin = str;
        shortVideoForwardReq.uinType = transferRequest.mUinType;
        shortVideoForwardReq.agentType = 0;
        shortVideoForwardReq.troopUin = str;
        shortVideoForwardReq.clientType = 2;
        Object obj = transferRequest.mExtraObj;
        if (obj != null && (obj instanceof p)) {
            p pVar = (p) obj;
            shortVideoForwardReq.fromChatType = pVar.f288200n;
            shortVideoForwardReq.toChatType = pVar.f288201o;
            int i3 = pVar.f288202p;
            shortVideoForwardReq.fromBusiType = i3;
            shortVideoForwardReq.toBusiType = pVar.f288203q;
            this.mReportBusiType = i3;
            int i16 = pVar.f288209w;
            this.videoTime = i16;
            shortVideoForwardReq.fileTime = i16;
            shortVideoForwardReq.uuid = pVar.f288039b;
            shortVideoForwardReq.fileName = pVar.A;
            shortVideoForwardReq.format = pVar.B;
            shortVideoForwardReq.fromUin = pVar.D;
            shortVideoForwardReq.sourceVideoCodecFormat = transferRequest.mSourceVideoCodecFormat;
            int c16 = k.c(transferRequest.mLocalPath);
            if (c16 > 0) {
                shortVideoForwardReq.bitrateInKilo = c16 / 1000;
            }
            QLog.d(TAG, 1, "[H265_VIDEO]", " makeShortVideoForwardReq sourceVideoCodecFormat = ", Integer.valueOf(shortVideoForwardReq.sourceVideoCodecFormat));
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_VIDEO_FILE_FORMAT, String.valueOf(shortVideoForwardReq.format));
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_RES_LENGTH, String.valueOf(this.mThumbFileHeight));
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_PIC_RES_WIDTH, String.valueOf(this.mThumbFileWidth));
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_FROM_CHAT_TYPE, String.valueOf(shortVideoForwardReq.fromChatType));
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_TO_CHAT_TYPE, String.valueOf(shortVideoForwardReq.toChatType));
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_FROM_BUSI_TYPE, String.valueOf(shortVideoForwardReq.fromBusiType));
            this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_TO_BUSI_TYPE, String.valueOf(shortVideoForwardReq.toBusiType));
            String str2 = this.mVideoFileName;
            if (str2 != null && str2.length() > 0) {
                shortVideoForwardReq.fileName = this.mVideoFileName;
            }
            shortVideoForwardReq.fileSize = this.mVideoFileSize;
            shortVideoForwardReq.thumbFileSize = this.mThumbFileSize;
            shortVideoForwardReq.fileResWidth = this.mThumbFileWidth;
            shortVideoForwardReq.fileResLength = this.mThumbFileHeight;
            String str3 = shortVideoForwardReq.fileName;
            if (str3 == null) {
                str3 = "";
            }
            shortVideoForwardReq.fileName = str3;
            shortVideoForwardReq.md5 = this.mLocalMd5;
            shortVideoForwardReq.thumbFileMd5 = this.thumbFileMd5;
            return shortVideoForwardReq;
        }
        logRichMediaEvent("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.protohandler.RichProtoProc.RichProtoCallback
    public void onBusiProtoResp(RichProto.RichProtoReq richProtoReq, RichProto.RichProtoResp richProtoResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) richProtoReq, (Object) richProtoResp);
            return;
        }
        this.mRichProtoReq = null;
        if (richProtoResp != null) {
            for (int i3 = 0; i3 < richProtoResp.resps.size(); i3++) {
                RichProto.RichProtoResp.ShortVideoForwardResp shortVideoForwardResp = (RichProto.RichProtoResp.ShortVideoForwardResp) richProtoResp.resps.get(i3);
                logRichMediaEvent("procUrl", shortVideoForwardResp.toString());
                ProcessorReport processorReport = this.mProcessorReport;
                processorReport.copyRespCommon(processorReport.mStepUrl, shortVideoForwardResp);
                this.mResid = shortVideoForwardResp.fileId;
                if (shortVideoForwardResp.result == 0) {
                    this.mVideoAttr = shortVideoForwardResp.videoAttr;
                    this.mVideoKandianType = shortVideoForwardResp.videoKandianType;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onBusiProtoResp()------response.videoAttr = " + shortVideoForwardResp.videoAttr + ", response.videoKandianType = " + shortVideoForwardResp.videoKandianType);
                    }
                    if (shortVideoForwardResp.isExist) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "ShortVideo exist on server.");
                        }
                        this.mIsSecondTransfered = true;
                        sendMessageToUpdate(1007);
                        sendMsg(true);
                    } else {
                        handleNotExist(shortVideoForwardResp);
                    }
                } else {
                    ProcessorReport processorReport2 = this.mProcessorReport;
                    if (-5100026 == processorReport2.errCode) {
                        processorReport2.setError(AppConstants.RichMediaErrorCode.ERR_BAN_DOWNLOAD, "\u5b89\u5168\u6253\u51fbmUiRequest.mMd5:" + this.mUiRequest.mMd5, null, null);
                    } else {
                        processorReport2.setError(9045, HardCodeUtil.qqStr(R.string.ti6), null, null);
                    }
                    onError();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        super.onError();
        int i3 = this.mProcessorReport.errCode;
        if (-5100026 == i3) {
            sendMessageToUpdate(5001);
        } else if (9042 == i3) {
            sendMessageToUpdate(5002);
        } else {
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
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onSuccess() {
        super.onSuccess();
        if (this.mUiRequest.mUpCallBack != null) {
            ad.a aVar = new ad.a();
            aVar.f258597a = 0;
            aVar.f258601e = this.mVideoFileSize;
            aVar.f258603g = this.mMd5Str;
            String str = this.mResid;
            if (str == null) {
                str = this.mUuid;
            }
            aVar.f258602f = str;
            aVar.f258605i = this.mThumbFileSize;
            aVar.f258606j = this.mVideoAttr;
            aVar.f258607k = this.mVideoKandianType;
            this.mUiRequest.mUpCallBack.q(aVar);
        } else {
            updateMessageDataBaseContent(true);
        }
        sendMessageToUpdate(1003);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (!this.mIsPause) {
            this.mIsPause = true;
            if (QLog.isColorLevel()) {
                logRichMediaEvent("pause", "");
            }
            sendMessageToUpdate(1004);
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

    protected void reportForServerMonitor(boolean z16, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2);
            return;
        }
        this.mRSMReporter.mBusiType = this.mReportBusiType + "";
        RMServMonitorReport rMServMonitorReport = this.mRSMReporter;
        rMServMonitorReport.mMD5 = this.mFileName;
        String str3 = this.mResid;
        if (str3 == null) {
            str3 = this.mUuid;
        }
        rMServMonitorReport.mUUID = str3;
        rMServMonitorReport.mServerIp = str;
        rMServMonitorReport.mServerPort = str2;
        rMServMonitorReport.mFailCode = String.valueOf(i3);
        RMServMonitorReport rMServMonitorReport2 = this.mRSMReporter;
        rMServMonitorReport2.mFileSize = this.mFileSize;
        ProcessorReport processorReport = this.mProcessorReport;
        String str4 = processorReport.reason;
        String str5 = processorReport.errDesc;
        TransferRequest transferRequest = this.mUiRequest;
        rMServMonitorReport2.doReportForServerMonitor(RMServMonitorReport.REPORT_NAME_NM_VIDEOUP, z16, str4, str5, transferRequest.mUinType, transferRequest.mPeerUin, true, processorReport.mStepTrans);
    }

    @Override // com.tencent.mobileqq.transfile.BaseUploadProcessor, com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
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
            this.sscmObject.e();
            resetStatictisInfo();
            this.mController.mHandler.post(new Runnable() { // from class: com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoForwardProcessor.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ShortVideoForwardProcessor.this.inter_retry();
                    }
                }
            });
        }
        return 0;
    }

    public void sendFileByBDH() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
        }
        this.mProcessorReport.mStepTrans.logStartTime();
        if (this.mTrans != null) {
            return;
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
                return;
            }
        }
        if (this.mThumbRaf == null) {
            try {
                this.mThumbRaf = new RandomAccessFile(this.mThumbFilePath, "r");
            } catch (FileNotFoundException e17) {
                e17.printStackTrace();
                this.mThumbRaf = null;
            }
            if (this.mThumbRaf == null) {
                this.mProcessorReport.setError(9303, "read thumb file error", null, null);
                onError();
                return;
            }
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        String combineThumbAndVideo = combineThumbAndVideo();
        RichProto.RichProtoReq.ShortVideoForwardReq makeShortVideoForwardReq = makeShortVideoForwardReq();
        if (makeShortVideoForwardReq == null) {
            this.mProcessorReport.setError(9302, "makeShortVideoForwardReq failed", null, null);
            onError();
            return;
        }
        byte[] buildExtendInfo = buildExtendInfo(makeShortVideoForwardReq);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG> sendFileByBDH . ,shortVideoReq.md5 :" + HexUtil.bytes2HexStr(makeShortVideoForwardReq.md5) + ",shortVideoReq.thumbFileMd5 = " + HexUtil.bytes2HexStr(makeShortVideoForwardReq.thumbFileMd5) + ",mLocalMd5 = " + HexUtil.bytes2HexStr(this.mLocalMd5));
        }
        ITransactionCallback iTransactionCallback = new ITransactionCallback(combineThumbAndVideo, uptimeMillis) { // from class: com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ String val$combinePath;
            final /* synthetic */ long val$startTime;

            {
                this.val$combinePath = combineThumbAndVideo;
                this.val$startTime = uptimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ShortVideoForwardProcessor.this, combineThumbAndVideo, Long.valueOf(uptimeMillis));
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onFailed(int i16, byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, this, Integer.valueOf(i16), bArr, hashMap);
                } else {
                    ShortVideoForwardProcessor.this.doOnSendFailed(i16, hashMap, this.val$startTime);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onSuccess(byte[] bArr, HashMap<String, String> hashMap) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) bArr, (Object) hashMap);
                } else {
                    ShortVideoForwardProcessor.this.doOnSendSucess(bArr, hashMap, this.val$combinePath, this.val$startTime);
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
                ShortVideoForwardProcessor.this.log("<BDH_LOG> onSwitch2BackupChannel()");
                ShortVideoForwardProcessor.this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_SWITCH_CHNL, String.valueOf(uptimeMillis2 - this.val$startTime));
            }

            @Override // com.tencent.mobileqq.highway.api.ITransactionCallback
            public void onTransStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 6)) {
                    iPatchRedirector2.redirect((short) 6, (Object) this);
                    return;
                }
                ShortVideoForwardProcessor.this.log("<BDH_LOG> onTransStart()");
                StepInfo stepInfo = ShortVideoForwardProcessor.this.mProcessorReport.mStepTrans;
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
                ShortVideoForwardProcessor shortVideoForwardProcessor = ShortVideoForwardProcessor.this;
                long j3 = i16;
                shortVideoForwardProcessor.file.transferedSize = j3;
                shortVideoForwardProcessor.mTransferedSize = j3;
                if (j3 < shortVideoForwardProcessor.mFileSize && !shortVideoForwardProcessor.mIsCancel && !shortVideoForwardProcessor.mIsPause) {
                    shortVideoForwardProcessor.sendProgressMessage();
                    ShortVideoForwardProcessor shortVideoForwardProcessor2 = ShortVideoForwardProcessor.this;
                    if (shortVideoForwardProcessor2.isStoryVideo) {
                        shortVideoForwardProcessor2.updateVideoAndPicStatus(shortVideoForwardProcessor2.f293466msg, 1002, shortVideoForwardProcessor2.getProgress());
                    }
                }
            }
        };
        if (makeShortVideoForwardReq.fromBusiType == 0) {
            i3 = 25;
        } else {
            i3 = 12;
        }
        this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i3, combineThumbAndVideo, (int) this.mStartOffset, this.mLocalMd5, iTransactionCallback, buildExtendInfo, true);
        this.mTrans.cbForReport = new ITransCallbackForReport() { // from class: com.tencent.mobileqq.transfile.ShortVideoForwardProcessor.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShortVideoForwardProcessor.this);
                }
            }

            @Override // com.tencent.mobileqq.highway.api.ITransCallbackForReport
            public void onFailed(int i16, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i16), str, str2);
                } else {
                    ShortVideoForwardProcessor.this.reportForServerMonitor(false, i16, str, str2);
                }
            }
        };
        int submitTransactionTask = this.app.getHwEngine().submitTransactionTask(this.mTrans);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + submitTransactionTask + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:12");
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
            return;
        }
        super.sendMessageToUpdate(i3);
        if (this.isStoryVideo) {
            updateVideoAndPicStatus(this.f293466msg, i3, getProgress());
        }
        if (this.mIsPause && 1004 != i3) {
            return;
        }
        h.r(this.app, this.file, this.mUiRequest);
    }

    void sendMsg(boolean z16) {
        MessageRecord messageRecord;
        String str;
        if (!canDoNextStep()) {
            log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
            return;
        }
        if (!this.needSendMsg) {
            return;
        }
        this.mProcessorReport.mStepMsg.logStartTime();
        im_msg_body$RichText constructRichText = constructRichText();
        if (constructRichText == null) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "constructpberror", null, processorReport.mStepMsg);
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
                IMessageFacade iMessageFacade = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class);
                TransferRequest transferRequest2 = this.mUiRequest;
                messageRecord = iMessageFacade.getMsgItemByUniseq(transferRequest2.mPeerUin, transferRequest2.mUinType, transferRequest2.mUniseq);
            }
        }
        if (messageRecord != null && (messageRecord instanceof MessageForShortVideo)) {
            ((MessageForShortVideo) messageRecord).richText = constructRichText;
            if (!isAppValid()) {
                ProcessorReport processorReport2 = this.mProcessorReport;
                processorReport2.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport2.mStepMsg);
                onError();
                return;
            }
            TransferRequest transferRequest3 = this.mUiRequest;
            if (transferRequest3.mBusiType == 1010 && transferRequest3.mUpCallBack != null) {
                super.onSuccess();
                ad.a aVar = new ad.a();
                aVar.f258597a = 0;
                aVar.f258601e = this.mVideoFileSize;
                aVar.f258603g = this.mMd5Str;
                String str2 = this.mResid;
                if (str2 == null) {
                    str2 = this.mUuid;
                }
                aVar.f258602f = str2;
                aVar.f258605i = this.mThumbFileSize;
                aVar.f258606j = this.mVideoAttr;
                aVar.f258607k = this.mVideoKandianType;
                this.mUiRequest.mUpCallBack.r(aVar);
                this.mUiRequest.mUpCallBack.q(aVar);
                return;
            }
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
        ProcessorReport processorReport3 = this.mProcessorReport;
        processorReport3.setError(AppConstants.RichMediaErrorCode.ERROR_MSG_ERROR, "msgtypeError", sb6, processorReport3.mStepMsg);
        onError();
    }

    void sendRequest() {
        this.mProcessorReport.mStepUrl.logStartTime();
        RichProto.RichProtoReq richProtoReq = new RichProto.RichProtoReq();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendGetUrlReq()----busiReq.seq : " + this.mUiRequest.mUniseq);
        }
        RichProto.RichProtoReq.ShortVideoForwardReq makeShortVideoForwardReq = makeShortVideoForwardReq();
        if (makeShortVideoForwardReq == null) {
            return;
        }
        richProtoReq.callback = this;
        richProtoReq.protoKey = RichProtoProc.SHORT_VIDEO_FW;
        richProtoReq.reqs.add(makeShortVideoForwardReq);
        richProtoReq.protoReqMgr = (IProtoReqManager) this.app.getRuntimeService(IProtoReqManager.class, "");
        if (!isAppValid()) {
            ProcessorReport processorReport = this.mProcessorReport;
            processorReport.setError(AppConstants.RichMediaErrorCode.ERROR_ACCOUNT_SWITCH, "illegal app", null, processorReport.mStepUrl);
            onError();
        } else {
            logRichMediaEvent("requestStart", richProtoReq.toString());
            if (!canDoNextStep()) {
                return;
            }
            this.mRichProtoReq = richProtoReq;
            RichProtoProc.procRichProtoReq(richProtoReq);
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void start() {
        Throwable th5;
        FileInputStream fileInputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.mIsCancel) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "start()");
        }
        super.start();
        sendMessageToUpdate(1001);
        this.file.closeInputStream();
        if (!TextUtils.isEmpty(this.mUiRequest.mMd5)) {
            this.mLocalMd5 = HexUtil.hexStr2Bytes(this.mUiRequest.mMd5);
            FileMsg fileMsg = this.file;
            String str = this.mUiRequest.mMd5;
            fileMsg.fileMd5 = str;
            this.mMd5Str = str;
        }
        Object obj = this.mUiRequest.mExtraObj;
        if (obj != null && (obj instanceof p)) {
            p pVar = (p) obj;
            long j3 = pVar.f288208v;
            this.mVideoFileSize = j3;
            this.mThumbFileSize = pVar.C;
            this.mThumbFileWidth = pVar.f288206t;
            this.mThumbFileHeight = pVar.f288207u;
            this.mIsFromMsgTabCamera = pVar.T;
            byte[] bArr = this.mLocalMd5;
            if (bArr == null || bArr.length == 0 || j3 <= 0) {
                if (!getMd5()) {
                    onError();
                    return;
                }
                this.mVideoMd5Local = this.mLocalMd5;
                File file = new File(this.mUiRequest.mLocalPath);
                this.mVideoFileSize = file.length();
                this.mVideoFileName = file.getName();
            }
            byte[] bArr2 = this.thumbFileMd5;
            if (bArr2 == null || bArr2.length == 0 || this.mThumbFileSize <= 0 || this.mThumbFileWidth <= 0 || this.mThumbFileHeight <= 0) {
                try {
                    fileInputStream = new FileInputStream(this.mThumbFilePath);
                } catch (IOException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    fileInputStream = null;
                }
                try {
                    try {
                        byte[] mD5Byte = MD5.toMD5Byte(fileInputStream, 0L);
                        this.thumbFileMd5 = mD5Byte;
                        if (mD5Byte == null) {
                            this.mProcessorReport.setError(9041, "get thumb file Md5 error" + this.mThumbFilePath, null, null);
                            onError();
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e17) {
                                e17.printStackTrace();
                                return;
                            }
                        }
                        this.mThumbMd5Local = mD5Byte;
                        try {
                            fileInputStream.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                        this.mThumbFileSize = new File(this.mThumbFilePath).length();
                        getThumbFileSize(this.mThumbFilePath);
                    } catch (IOException e19) {
                        e = e19;
                        this.thumbFileMd5 = null;
                        analysisIOProblem(e);
                        onError();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                return;
                            } catch (IOException e26) {
                                e26.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e27) {
                            e27.printStackTrace();
                        }
                    }
                    throw th5;
                }
            }
            sendRequest();
            return;
        }
        logRichMediaEvent("start", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
        this.mProcessorReport.setError(9302, "get mUiRequest.mExtraObj error", null, null);
        onError();
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void updateMessageDataBaseContent(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
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
            messageForShortVideo.videoFileSize = (int) this.mFileSize;
            String str = this.mResid;
            if (str == null) {
                str = this.mUuid;
            }
            messageForShortVideo.uuid = str;
            messageForShortVideo.md5 = this.mMd5Str;
            messageForShortVideo.videoAttr = this.mVideoAttr;
            messageForShortVideo.videoKandianType = this.mVideoKandianType;
            messageForShortVideo.serial();
            IMessageFacade iMessageFacade2 = (IMessageFacade) this.app.getRuntimeService(IMessageFacade.class);
            TransferRequest transferRequest2 = this.mUiRequest;
            iMessageFacade2.updateMsgContentByUniseq(transferRequest2.mPeerUin, transferRequest2.mUinType, messageRecord.uniseq, messageForShortVideo.msgData);
        }
    }

    public void updateVideoAndPicStatus(MessageRecord messageRecord, int i3, int i16) {
        Bundle bundle;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, messageRecord, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("key_status", i3);
        bundle2.putInt("key_progress", i16);
        bundle2.putLong("key_uinsequence", messageRecord.uniseq);
        bundle2.putString("uin", messageRecord.frienduin);
        bundle2.putInt("uintype", messageRecord.istroop);
        if (messageRecord instanceof MessageForShortVideo) {
            bundle2.putString("key_file_md5", ((MessageForShortVideo) messageRecord).md5);
        } else if (messageRecord instanceof MessageForPic) {
            bundle2.putString("key_file_md5", ((MessageForPic) messageRecord).md5);
        }
        EIPCResult callClient = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:peak", 1, "PeakIpcModuleClient", "action_update_status", bundle2);
        if (callClient != null && (bundle = callClient.data) != null) {
            z16 = bundle.getBoolean("key_result");
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "client result:" + z16);
        }
    }
}

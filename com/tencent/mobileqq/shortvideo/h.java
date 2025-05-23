package com.tencent.mobileqq.shortvideo;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.msg.api.IMultiMsgProxy;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.api.capability.TPDecoderCapability;
import java.io.File;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public static long f287889a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f287890b;

    /* renamed from: c, reason: collision with root package name */
    public static long f287891c;

    public static String a(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo.busiType != 0) {
            return messageForShortVideo.md5 + messageForShortVideo.uniseq;
        }
        String extInfoFromExtStr = messageForShortVideo.getExtInfoFromExtStr("video_init_download_response_codec_format");
        String extInfoFromExtStr2 = messageForShortVideo.getExtInfoFromExtStr("video_download_response_codec_format");
        if (!TextUtils.isEmpty(extInfoFromExtStr) && !TextUtils.isEmpty(extInfoFromExtStr2) && !TextUtils.equals(extInfoFromExtStr, extInfoFromExtStr2)) {
            String extInfoFromExtStr3 = messageForShortVideo.getExtInfoFromExtStr("video_download_response_md5");
            if (QLog.isColorLevel()) {
                QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", Long.valueOf(messageForShortVideo.uniseq), " calculateVideoFileID replace file id.", ", videoInitDownloadResponseCodecFormat = " + extInfoFromExtStr, ", videoDownloadResponseCodecFormat = " + extInfoFromExtStr2);
            }
            if (TextUtils.isEmpty(extInfoFromExtStr3)) {
                return "md5" + messageForShortVideo.uniseq;
            }
            return extInfoFromExtStr3 + messageForShortVideo.uniseq;
        }
        return messageForShortVideo.md5 + messageForShortVideo.uniseq;
    }

    public static v b(int i3, int i16) {
        v vVar = new v();
        vVar.f288264d = i3;
        vVar.f288265e = i16;
        return vVar;
    }

    public static v c(BaseQQAppInterface baseQQAppInterface, MessageForShortVideo messageForShortVideo, int i3) {
        return d(baseQQAppInterface, messageForShortVideo, i3, g(baseQQAppInterface, messageForShortVideo));
    }

    public static v d(BaseQQAppInterface baseQQAppInterface, MessageForShortVideo messageForShortVideo, int i3, int i16) {
        if (messageForShortVideo.videoFileStatus == 5002) {
            if (QLog.isColorLevel()) {
                QLog.d("SVBusiUtil", 2, "createShortVideoReqByMsg expired");
                return null;
            }
            return null;
        }
        v b16 = b(2, messageForShortVideo.busiType);
        n downloadInfo = messageForShortVideo.getDownloadInfo(b16.f288265e);
        downloadInfo.f288193q = j.j(messageForShortVideo, "mp4");
        downloadInfo.f288196t = i3;
        downloadInfo.f288199w = i16;
        downloadInfo.f288050m = messageForShortVideo.sourceVideoCodecFormat;
        int i17 = messageForShortVideo.busiType;
        if (i17 == 0) {
            downloadInfo.f288198v = true;
        }
        if (i17 == 4601 && messageForShortVideo.subBusiType == 4601) {
            downloadInfo.f288198v = true;
        }
        IMessageFacade iMessageFacade = (IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class);
        if (iMessageFacade.isChatting() && iMessageFacade.getCurrChatUin().equals(messageForShortVideo.frienduin)) {
            downloadInfo.f288197u = 2;
        } else {
            downloadInfo.f288197u = 1;
        }
        int i18 = messageForShortVideo.istroop;
        if (i18 != 0 && i18 != 1008) {
            if (i18 == 3000) {
                downloadInfo.f288195s = 1005;
            } else if (i18 == 1) {
                downloadInfo.f288195s = 1003;
            } else if (i18 == 10014) {
                downloadInfo.f288195s = 1007;
            }
        } else {
            downloadInfo.f288195s = 1001;
        }
        b16.c(downloadInfo);
        b16.g(messageForShortVideo);
        return b16;
    }

    public static int e(FileMsg fileMsg) {
        long j3 = fileMsg.fileSize;
        if (j3 == 0) {
            return 0;
        }
        return (int) ((fileMsg.transferedSize * 100) / j3);
    }

    public static MessageRecord f(BaseQQAppInterface baseQQAppInterface, TransferRequest transferRequest) {
        MessageRecord messageRecord = transferRequest.mRec;
        if (messageRecord == null) {
            MessageRecord msgItemByUniseq = ((IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class)).getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq);
            com.tencent.mobileqq.pic.f.b("SVBusiUtil", "updataMessageDataBaseContent", "findmsgbyMsgId,need fix");
            return msgItemByUniseq;
        }
        return messageRecord;
    }

    public static int g(AppInterface appInterface, MessageForShortVideo messageForShortVideo) {
        if (appInterface != null && messageForShortVideo != null) {
            int i3 = messageForShortVideo.busiType;
            if ((i3 != 0 && i3 != 1) || !i(appInterface, messageForShortVideo)) {
                return 0;
            }
            if (messageForShortVideo.busiType != 1 && !String.valueOf(1).equals(messageForShortVideo.getExtInfoFromExtStr("video_download_response_codec_format")) && String.valueOf(0).equals(messageForShortVideo.getExtInfoFromExtStr("video_download_response_codec_format")) && (messageForShortVideo.getBitValue(0) == 0 || "1".equals(messageForShortVideo.getExtInfoFromExtStr("video_keep_download_after_pre_download")))) {
                return 0;
            }
            return 1;
        }
        QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", "getVideoDownloadRequestCodecFormat error, invalid params.");
        return 0;
    }

    public static boolean h(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", "isAIOConfigEnableH265Video return, invalid params.");
            return false;
        }
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_enable_h265_video", false);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean i(AppInterface appInterface, MessageForShortVideo messageForShortVideo) {
        boolean z16;
        if (appInterface != null && messageForShortVideo != null) {
            if (!h(appInterface)) {
                QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", "isAIOEnableH265Video return, config disable h265 video.");
                return false;
            }
            int i3 = messageForShortVideo.fileWidth;
            if (i3 <= 0) {
                i3 = messageForShortVideo.thumbWidth;
            }
            int i16 = messageForShortVideo.fileHeight;
            if (i16 <= 0) {
                i16 = messageForShortVideo.thumbHeight;
            }
            try {
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("SVBusiUtil", 2, "[H265_VIDEO]", "isAIOEnableH265Video check video codec capability failed.", th5);
                }
            }
            if (TPDecoderCapability.getVideoDecoderCapability(172, i3, i16, 30.0f) == 1) {
                z16 = true;
                if (!z16) {
                    QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", "isAIOEnableH265Video enableDecodeH265Video = false");
                }
                return z16;
            }
            z16 = false;
            if (!z16) {
            }
            return z16;
        }
        QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", "isAIOEnableH265Video return, invalid params.");
        return false;
    }

    public static boolean j(FileMsg fileMsg, MessageForShortVideo messageForShortVideo) {
        int i3 = messageForShortVideo.videoFileStatus;
        if (i3 == 2004 || i3 == 1004) {
            int i16 = fileMsg.status;
            if (i16 != 1002 && i16 != 2002) {
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean k(AppRuntime appRuntime) {
        if (appRuntime == null) {
            QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", "isConfigEnableTranscodingH265ToH264WhenForward return, invalid params.");
            return false;
        }
        if (!h(appRuntime)) {
            return false;
        }
        return ((IFeatureRuntimeService) appRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_enable_h265_video_upload");
    }

    public static boolean l(AppInterface appInterface) {
        if (appInterface == null) {
            QLog.d("SVBusiUtil", 1, "[H265_VIDEO]", "isConfigEnableTranscodingH265ToH264WhenForward return, invalid params.");
            return false;
        }
        if (!h(appInterface)) {
            return false;
        }
        return ((IFeatureRuntimeService) appInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("aio_enable_transcoding_h265_to_h264_when_forward_video");
    }

    public static boolean m(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo == null) {
            return false;
        }
        return String.valueOf(1).equals(messageForShortVideo.getExtInfoFromExtStr("video_download_response_codec_format"));
    }

    public static boolean n(FileMsg fileMsg, MessageForShortVideo messageForShortVideo, int i3, int i16) {
        int i17 = messageForShortVideo.videoFileStatus;
        if ((i17 == 1002 || i17 == 2002) && i17 == fileMsg.status && i3 - i16 < 10) {
            return false;
        }
        return true;
    }

    public static void o(FileMsg fileMsg, TransferRequest transferRequest, MessageForShortVideo messageForShortVideo) {
        String str;
        if (messageForShortVideo.mPreUpload && fileMsg.status == 1003 && (str = transferRequest.mMd5) != null) {
            messageForShortVideo.md5 = str;
        }
    }

    public static void p(FileMsg fileMsg, MessageForShortVideo messageForShortVideo) {
        int i3 = fileMsg.fileType;
        if (i3 == 6 || i3 == 17 || i3 == 9 || i3 == 20 || i3 == 67) {
            int i16 = fileMsg.status;
            if (i16 == 2002) {
                messageForShortVideo.transferedSize = (int) fileMsg.transferedSize;
            }
            if (i16 == 2003) {
                messageForShortVideo.transferedSize = 0;
            }
        }
    }

    public static void q(FileMsg fileMsg, MessageForShortVideo messageForShortVideo, int i3) {
        int i16 = fileMsg.fileType;
        if (i16 != 7 && i16 != 16 && i16 != 18) {
            messageForShortVideo.videoFileProgress = i3;
        }
    }

    public static void r(BaseQQAppInterface baseQQAppInterface, FileMsg fileMsg, TransferRequest transferRequest) {
        if (fileMsg != null && transferRequest != null) {
            MessageRecord f16 = f(baseQQAppInterface, transferRequest);
            if (f16 == null) {
                com.tencent.mobileqq.pic.f.d("SVBusiUtil", "updataMessageDataBaseContent", "msg null");
                return;
            }
            boolean z16 = f16 instanceof MessageForShortVideo;
            if (z16) {
                MessageForShortVideo messageForShortVideo = (MessageForShortVideo) f16;
                int e16 = e(fileMsg);
                if (messageForShortVideo.videoFileProgress < 0) {
                    messageForShortVideo.videoFileProgress = 0;
                }
                if (!n(fileMsg, messageForShortVideo, e16, messageForShortVideo.videoFileProgress)) {
                    return;
                }
                if (messageForShortVideo.videoFileStatus == 1003) {
                    messageForShortVideo.videoFileProgress = 100;
                }
                p(fileMsg, messageForShortVideo);
                if (j(fileMsg, messageForShortVideo)) {
                    return;
                }
                messageForShortVideo.videoFileStatus = fileMsg.status;
                messageForShortVideo.fileType = fileMsg.fileType;
                q(fileMsg, messageForShortVideo, e16);
                o(fileMsg, transferRequest, messageForShortVideo);
                if (fileMsg.status == 2003) {
                    messageForShortVideo.lastModified = new File(transferRequest.mOutFilePath).lastModified();
                }
                messageForShortVideo.serial();
                if (!messageForShortVideo.isMultiMsg && transferRequest.mBusiType != 1010) {
                    if (!(messageForShortVideo instanceof MessageForBlessPTV)) {
                        if (z16 && messageForShortVideo.embedVideo == 1) {
                            ((IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, f16.uniseq, ((IMsgMixed) QRoute.api(IMsgMixed.class)).updateMixmsgBySVMsg(((IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class)).getMsgItemByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, transferRequest.mUniseq), f16, messageForShortVideo.subMsgId).msgData);
                        } else {
                            ((IMessageFacade) baseQQAppInterface.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(transferRequest.mPeerUin, transferRequest.mUinType, f16.uniseq, messageForShortVideo.msgData);
                        }
                        int i3 = fileMsg.status;
                        if (i3 == 1003 || i3 == 2003) {
                            ((IMessageHandler) baseQQAppInterface.getRuntimeService(IMessageHandler.class, "")).notifyUI(baseQQAppInterface, 999, true, transferRequest.mPeerUin);
                            com.tencent.mobileqq.pic.f.b("SVBusiUtil", "updataMessageDataBaseContent", "app.getMsgHandler().notifyUI");
                            return;
                        }
                        return;
                    }
                    return;
                }
                int i16 = messageForShortVideo.videoFileStatus;
                if (i16 != 1002 && i16 != 2002) {
                    ((IMultiMsgProxy) QRoute.api(IMultiMsgProxy.class)).updateMultiMsg(baseQQAppInterface, messageForShortVideo);
                    return;
                }
                return;
            }
            return;
        }
        com.tencent.mobileqq.pic.f.d("SVBusiUtil", "updataMessageDataBaseContent", "fileMsg or req is null");
    }
}

package com.tencent.mobileqq.emotionintegrate;

import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.app.bo;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.msg.api.IConfessMsgUtil;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.msg.api.IMessageRecordFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.pb.client.ClientMessageModel$VideoEmojiInfo;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import tencent.im.msg.hummer.resv.videoFile$ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype44;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;
import tencent.im.msg.im_msg_body$VideoFile;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ad {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a extends bo {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MessageForVideoEmoticon f205204d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ QQAppInterface f205205e;

        a(MessageForVideoEmoticon messageForVideoEmoticon, QQAppInterface qQAppInterface) {
            this.f205204d = messageForVideoEmoticon;
            this.f205205e = qQAppInterface;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) messageForVideoEmoticon, (Object) qQAppInterface);
            }
        }

        @Override // com.tencent.mobileqq.app.bo
        public void onNotifyResultAfterSendRich(boolean z16, long j3, StatictisInfo statictisInfo) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), statictisInfo);
                return;
            }
            super.onNotifyResultAfterSendRich(z16, j3, statictisInfo);
            if (QLog.isColorLevel()) {
                QLog.e("VideoEmoticonMsgUtil", 1, "sendVideoEmoticonMessage isSuccess=", Boolean.valueOf(z16));
            }
            MessageForVideoEmoticon messageForVideoEmoticon = this.f205204d;
            if (z16) {
                i3 = 1003;
            } else {
                i3 = 1005;
            }
            messageForVideoEmoticon.videoFileStatus = i3;
            messageForVideoEmoticon.serial();
            IMessageFacade iMessageFacade = (IMessageFacade) this.f205205e.getRuntimeService(IMessageFacade.class);
            MessageForVideoEmoticon messageForVideoEmoticon2 = this.f205204d;
            iMessageFacade.updateMsgContentByUniseq(messageForVideoEmoticon2.frienduin, messageForVideoEmoticon2.istroop, messageForVideoEmoticon2.uniseq, messageForVideoEmoticon2.msgData);
            ((IMessageHandler) this.f205205e.getRuntimeService(IMessageHandler.class, "")).notifyUI(this.f205205e, 999, z16, this.f205204d.frienduin);
        }
    }

    public static MessageForVideoEmoticon a(QQAppInterface qQAppInterface, Intent intent) {
        if (qQAppInterface == null) {
            QLog.e("VideoEmoticonMsgUtil", 1, "constructMessageFromIntent failed, app is null!");
            return null;
        }
        if (intent == null) {
            QLog.e("VideoEmoticonMsgUtil", 1, "constructMessageFromIntent failed, intent is null!");
            return null;
        }
        String stringExtra = intent.getStringExtra("uin");
        String stringExtra2 = intent.getStringExtra("troop_uin");
        int intExtra = intent.getIntExtra("uintype", -2);
        String stringExtra3 = intent.getStringExtra("file_send_path");
        String stringExtra4 = intent.getStringExtra(ShortVideoConstants.FILE_VIDEO_SOURCE_DIR);
        if (TextUtils.isEmpty(stringExtra4)) {
            stringExtra4 = stringExtra3;
        }
        String stringExtra5 = intent.getStringExtra(ShortVideoConstants.FILE_UUID);
        String stringExtra6 = intent.getStringExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5);
        long longExtra = intent.getLongExtra(ShortVideoConstants.FILE_SEND_SIZE, 0L);
        int intExtra2 = intent.getIntExtra(ShortVideoConstants.FILE_WIDTH, 0);
        int intExtra3 = intent.getIntExtra(ShortVideoConstants.FILE_HEIGHT, 0);
        int intExtra4 = intent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, -1);
        String stringExtra7 = intent.getStringExtra(ShortVideoConstants.FILE_SOURCE);
        boolean booleanExtra = intent.getBooleanExtra(ShortVideoConstants.SUPPORT_PROGRESSIVE, false);
        String stringExtra8 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH);
        String stringExtra9 = intent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5);
        long longExtra2 = intent.getLongExtra(ShortVideoConstants.FILE_THUMB_SIZE, 0L);
        int intExtra5 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, 0);
        int intExtra6 = intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, 0);
        int intExtra7 = intent.getIntExtra(ShortVideoConstants.VIDEO_EMOTICON_SRC_TYPE, 0);
        String stringExtra10 = intent.getStringExtra(ShortVideoConstants.VIDEO_EMOTICON_SRC_DESC);
        String stringExtra11 = intent.getStringExtra(ShortVideoConstants.VIDEO_EMOTICON_HOMEPAGE_URL);
        String stringExtra12 = intent.getStringExtra(ShortVideoConstants.VIDEO_EMOTICON_VIDEO_ICON_URL);
        String stringExtra13 = intent.getStringExtra(ShortVideoConstants.VIDEO_EMOTICON_VIDEO_OTHER);
        MessageForVideoEmoticon messageForVideoEmoticon = (MessageForVideoEmoticon) ((IMessageRecordFactory) QRoute.api(IMessageRecordFactory.class)).createSendMSg_VideoEmoticon(qQAppInterface, stringExtra, stringExtra2, intExtra);
        messageForVideoEmoticon.busiType = 1021;
        messageForVideoEmoticon.subBusiType = 0;
        messageForVideoEmoticon.uuid = stringExtra5;
        messageForVideoEmoticon.md5 = stringExtra6;
        messageForVideoEmoticon.videoFileName = stringExtra3;
        messageForVideoEmoticon.mVideoFileSourceDir = stringExtra4;
        messageForVideoEmoticon.videoFileFormat = 2;
        messageForVideoEmoticon.videoFileSize = (int) longExtra;
        messageForVideoEmoticon.videoFileTime = intExtra4;
        messageForVideoEmoticon.fileWidth = intExtra2;
        messageForVideoEmoticon.fileHeight = intExtra3;
        messageForVideoEmoticon.fileSource = stringExtra7;
        messageForVideoEmoticon.thumbWidth = intExtra5;
        messageForVideoEmoticon.thumbHeight = intExtra6;
        messageForVideoEmoticon.mThumbFilePath = stringExtra8;
        messageForVideoEmoticon.thumbMD5 = stringExtra9;
        messageForVideoEmoticon.thumbFileSize = (int) longExtra2;
        messageForVideoEmoticon.fromChatType = -1;
        messageForVideoEmoticon.toChatType = -1;
        messageForVideoEmoticon.uiOperatorFlag = 1;
        messageForVideoEmoticon.supportProgressive = booleanExtra;
        messageForVideoEmoticon.f203106msg = HardCodeUtil.qqStr(R.string.f238107iv);
        messageForVideoEmoticon.srcType = intExtra7;
        messageForVideoEmoticon.srcDesc = stringExtra10;
        messageForVideoEmoticon.homepageUrl = stringExtra11;
        messageForVideoEmoticon.videoIconUrl = stringExtra12;
        messageForVideoEmoticon.videoOther = stringExtra13;
        e(messageForVideoEmoticon);
        if (intExtra == 0) {
            ((IConfessMsgUtil) QRoute.api(IConfessMsgUtil.class)).bindC2CFirstMsgConfessInfo(qQAppInterface, messageForVideoEmoticon, stringExtra);
        } else if (intExtra == 1) {
            ((IConfessMsgUtil) QRoute.api(IConfessMsgUtil.class)).bindGroupFirstMsgConfessInfo(qQAppInterface, messageForVideoEmoticon, stringExtra);
        }
        messageForVideoEmoticon.extraflag = 32772;
        messageForVideoEmoticon.videoFileProgress = 100;
        messageForVideoEmoticon.videoFileStatus = 1007;
        messageForVideoEmoticon.serial();
        return messageForVideoEmoticon;
    }

    private static im_msg_body$RichText b(MessageForVideoEmoticon messageForVideoEmoticon) {
        try {
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
            im_msg_body_text.setHasFlag(true);
            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.qqStr(R.string.f238107iv)));
            im_msg_body_elem.text.set(im_msg_body_text);
            im_msg_body$Elem im_msg_body_elem2 = new im_msg_body$Elem();
            im_msg_body$CommonElem im_msg_body_commonelem = new im_msg_body$CommonElem();
            im_msg_body_commonelem.uint32_service_type.set(44);
            im_msg_body_commonelem.uint32_business_type.set(1);
            hummer_commelem$MsgElemInfo_servtype44 hummer_commelem_msgeleminfo_servtype44 = new hummer_commelem$MsgElemInfo_servtype44();
            hummer_commelem_msgeleminfo_servtype44.video_file.set(d(messageForVideoEmoticon));
            hummer_commelem_msgeleminfo_servtype44.bytes_msg_data.set(ByteStringMicro.copyFrom(c(messageForVideoEmoticon).toByteArray()));
            im_msg_body_commonelem.bytes_pb_elem.set(ByteStringMicro.copyFrom(com.tencent.mobileqq.structmsg.k.b(hummer_commelem_msgeleminfo_servtype44.toByteArray(), true)));
            im_msg_body_elem2.common_elem.set(im_msg_body_commonelem);
            im_msg_body$RichText im_msg_body_richtext = new im_msg_body$RichText();
            im_msg_body_richtext.elems.add(im_msg_body_elem);
            im_msg_body_richtext.elems.add(im_msg_body_elem2);
            return im_msg_body_richtext;
        } catch (Throwable th5) {
            QLog.e("VideoEmoticonMsgUtil", 1, "Construct richtext error", th5);
            return null;
        }
    }

    private static ClientMessageModel$VideoEmojiInfo c(MessageForVideoEmoticon messageForVideoEmoticon) {
        ClientMessageModel$VideoEmojiInfo clientMessageModel$VideoEmojiInfo = new ClientMessageModel$VideoEmojiInfo();
        clientMessageModel$VideoEmojiInfo.bytes_video_md5.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.md5));
        clientMessageModel$VideoEmojiInfo.uint32_video_width.set(messageForVideoEmoticon.fileWidth);
        clientMessageModel$VideoEmojiInfo.uint32_video_height.set(messageForVideoEmoticon.fileHeight);
        clientMessageModel$VideoEmojiInfo.bytes_video_fileid.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.uuid));
        clientMessageModel$VideoEmojiInfo.uint64_video_size.set(messageForVideoEmoticon.videoFileSize);
        clientMessageModel$VideoEmojiInfo.bytes_video_name.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.videoFileName));
        clientMessageModel$VideoEmojiInfo.uint64_video_duration.set(messageForVideoEmoticon.videoFileTime);
        clientMessageModel$VideoEmojiInfo.uint32_video_format.set(messageForVideoEmoticon.videoFileFormat);
        clientMessageModel$VideoEmojiInfo.bytes_thumb_img_md5.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.thumbMD5));
        clientMessageModel$VideoEmojiInfo.uint32_thumb_img_width.set(messageForVideoEmoticon.thumbWidth);
        clientMessageModel$VideoEmojiInfo.uint32_thumb_img_height.set(messageForVideoEmoticon.thumbHeight);
        clientMessageModel$VideoEmojiInfo.bytes_thumb_img_fileid.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.uuid));
        clientMessageModel$VideoEmojiInfo.uint64_thumb_size.set(messageForVideoEmoticon.thumbFileSize);
        clientMessageModel$VideoEmojiInfo.uint32_src_type.set(messageForVideoEmoticon.srcType);
        if (!TextUtils.isEmpty(messageForVideoEmoticon.srcDesc)) {
            clientMessageModel$VideoEmojiInfo.bytes_src_desc.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.srcDesc));
        }
        if (!TextUtils.isEmpty(messageForVideoEmoticon.homepageUrl)) {
            clientMessageModel$VideoEmojiInfo.bytes_homepage_url.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.homepageUrl));
        }
        if (!TextUtils.isEmpty(messageForVideoEmoticon.videoIconUrl)) {
            clientMessageModel$VideoEmojiInfo.bytes_icon_url.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.videoIconUrl));
        }
        if (!TextUtils.isEmpty(messageForVideoEmoticon.videoOther)) {
            clientMessageModel$VideoEmojiInfo.bytes_video_other.set(ByteStringMicro.copyFrom(messageForVideoEmoticon.videoOther.getBytes(StandardCharsets.ISO_8859_1)));
        }
        return clientMessageModel$VideoEmojiInfo;
    }

    private static im_msg_body$VideoFile d(MessageForVideoEmoticon messageForVideoEmoticon) {
        im_msg_body$VideoFile im_msg_body_videofile = new im_msg_body$VideoFile();
        im_msg_body_videofile.setHasFlag(true);
        String str = messageForVideoEmoticon.uuid;
        if (str != null) {
            im_msg_body_videofile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(str));
        }
        if (QLog.isColorLevel()) {
            QLog.d("VideoEmoticonMsgUtil", 2, "videoFileId uuid=" + str);
        }
        im_msg_body_videofile.uint32_busi_type.set(messageForVideoEmoticon.busiType);
        im_msg_body_videofile.uint32_sub_busi_type.set(messageForVideoEmoticon.subBusiType);
        im_msg_body_videofile.bytes_source.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.fileSource));
        im_msg_body_videofile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(messageForVideoEmoticon.videoFileName));
        im_msg_body_videofile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(messageForVideoEmoticon.md5)));
        im_msg_body_videofile.uint32_file_format.set(2);
        im_msg_body_videofile.uint32_file_size.set(messageForVideoEmoticon.videoFileSize);
        im_msg_body_videofile.uint32_file_time.set((int) messageForVideoEmoticon.time);
        im_msg_body_videofile.uint32_thumb_width.set(messageForVideoEmoticon.thumbWidth);
        im_msg_body_videofile.uint32_thumb_height.set(messageForVideoEmoticon.thumbHeight);
        im_msg_body_videofile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(messageForVideoEmoticon.md5)));
        im_msg_body_videofile.uint32_thumb_file_size.set(messageForVideoEmoticon.thumbFileSize);
        im_msg_body_videofile.bool_support_progressive.set(messageForVideoEmoticon.supportProgressive);
        im_msg_body_videofile.uint32_file_width.set(messageForVideoEmoticon.fileWidth);
        im_msg_body_videofile.uint32_file_height.set(messageForVideoEmoticon.fileHeight);
        videoFile$ResvAttr videofile_resvattr = new videoFile$ResvAttr();
        videofile_resvattr.uint32_source.set(5);
        im_msg_body_videofile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(videofile_resvattr.toByteArray()));
        im_msg_body_videofile.uint32_video_attr.set(0);
        im_msg_body_videofile.uint32_from_chat_type.set(-1);
        im_msg_body_videofile.uint32_to_chat_type.set(-1);
        return im_msg_body_videofile;
    }

    private static void e(MessageForVideoEmoticon messageForVideoEmoticon) {
        int i3 = messageForVideoEmoticon.istroop;
        if (i3 == 0) {
            messageForVideoEmoticon.fileType = 6;
            return;
        }
        if (i3 == 3000) {
            messageForVideoEmoticon.fileType = 17;
        } else if (i3 == 1) {
            messageForVideoEmoticon.fileType = 9;
        } else if (i3 == 10014) {
            messageForVideoEmoticon.fileType = 67;
        }
    }

    public static void f(QQAppInterface qQAppInterface, Intent intent) {
        if (qQAppInterface == null) {
            QLog.e("VideoEmoticonMsgUtil", 1, "sendVideoEmoticonMessage failed, app is null!");
        } else if (intent == null) {
            QLog.e("VideoEmoticonMsgUtil", 1, "sendVideoEmoticonMessage failed, intent is null!");
        } else {
            g(qQAppInterface, a(qQAppInterface, intent), true);
        }
    }

    public static void g(QQAppInterface qQAppInterface, MessageForVideoEmoticon messageForVideoEmoticon, boolean z16) {
        if (qQAppInterface == null) {
            QLog.e("VideoEmoticonMsgUtil", 1, "sendVideoEmoticonMessage with message failed, app is null!");
            return;
        }
        if (messageForVideoEmoticon == null) {
            QLog.e("VideoEmoticonMsgUtil", 1, "sendVideoEmoticonMessage with message failed, message is null!");
            return;
        }
        IOrderMediaMsgService iOrderMediaMsgService = (IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class);
        iOrderMediaMsgService.enqueueMediaMsgByUniseq(messageForVideoEmoticon.frienduin, messageForVideoEmoticon.uniseq);
        messageForVideoEmoticon.richText = b(messageForVideoEmoticon);
        messageForVideoEmoticon.serial();
        if (z16) {
            iOrderMediaMsgService.addOrderMsg(messageForVideoEmoticon, messageForVideoEmoticon.videoFileName);
        }
        ((IOrderMediaMsgService) qQAppInterface.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(messageForVideoEmoticon, new a(messageForVideoEmoticon, qQAppInterface));
    }
}

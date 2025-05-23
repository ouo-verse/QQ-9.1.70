package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForVideoEmoticon;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.VideoEmoticonMessage;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import localpb.richMsg.RichMsg$VideoFile;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.NotNull;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.hummer.resv.videoFile$ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype44;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$VideoFile;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ap extends af {
    static IPatchRedirector $redirector_;

    public ap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        byte[] bArr = null;
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.general_flags.has()) {
                im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
            }
            if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.bytes_pb_elem.has()) {
                bArr = im_msg_body_elem.common_elem.bytes_pb_elem.get().toByteArray();
            }
        }
        if (bArr == null) {
            QLog.e("VideoEmoticonElemDecoder", 1, "[deserializeVideoEmoticonInfo] bytes_pb_common_elem is null!");
            return;
        }
        hummer_commelem$MsgElemInfo_servtype44 hummer_commelem_msgeleminfo_servtype44 = new hummer_commelem$MsgElemInfo_servtype44();
        try {
            hummer_commelem_msgeleminfo_servtype44.mergeFrom(com.tencent.mobileqq.structmsg.k.i(bArr, -1));
            if (QLog.isColorLevel()) {
                sb5.append("elemType:video_file;\n");
            }
            MessageForVideoEmoticon e16 = e(im_msg_body_generalflags, hummer_commelem_msgeleminfo_servtype44);
            if (e16 == null) {
                QLog.e("VideoEmoticonElemDecoder", 1, "[deserializeVideoEmoticonInfo] failed, mr is null! ");
                return;
            }
            list2.add(e16);
            if (QLog.isColorLevel()) {
                sb5.append("ShortVideo.msg: ");
                sb5.append(e16.toString() + "\n" + e16.toLogString());
                sb5.append("\n");
                QLog.d("VideoEmoticonElemDecoder", 2, sb5);
            }
        } catch (Throwable th5) {
            QLog.e("VideoEmoticonElemDecoder", 1, "[deserializeVideoEmoticonInfo] bytes_pb_elem error! ", th5);
        }
    }

    private MessageForVideoEmoticon e(im_msg_body$GeneralFlags im_msg_body_generalflags, hummer_commelem$MsgElemInfo_servtype44 hummer_commelem_msgeleminfo_servtype44) {
        if (!hummer_commelem_msgeleminfo_servtype44.video_file.has()) {
            QLog.e("VideoEmoticonElemDecoder", 1, "getMessageForVideoEmoticon failed, video_file is empty!");
            return null;
        }
        if (!hummer_commelem_msgeleminfo_servtype44.bytes_msg_data.has()) {
            QLog.e("VideoEmoticonElemDecoder", 1, "getMessageForVideoEmoticon failed, bytes_msg_data is empty!");
            return null;
        }
        RichMsg$VideoFile f16 = f(hummer_commelem_msgeleminfo_servtype44.video_file.get(), im_msg_body_generalflags);
        VideoEmoticonMessage videoEmoticonMessage = new VideoEmoticonMessage();
        videoEmoticonMessage.videoFileDataBuf = f16.toByteArray();
        videoEmoticonMessage.videoEmoticonDataBuf = hummer_commelem_msgeleminfo_servtype44.bytes_msg_data.get().toByteArray();
        try {
            byte[] bytesFromObject = MessagePkgUtils.getBytesFromObject(videoEmoticonMessage);
            MessageForVideoEmoticon messageForVideoEmoticon = (MessageForVideoEmoticon) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_VIDEO_EMOTICON);
            messageForVideoEmoticon.msgData = bytesFromObject;
            if (f16.uint32_busi_type.get() == 2) {
                messageForVideoEmoticon.f203106msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
            } else {
                messageForVideoEmoticon.f203106msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
            }
            messageForVideoEmoticon.parse();
            return messageForVideoEmoticon;
        } catch (Exception e16) {
            QLog.e("VideoEmoticonElemDecoder", 1, "getMessageForVideoEmoticon serial videoEmoticonMessage failed!", e16);
            return null;
        }
    }

    @NotNull
    private RichMsg$VideoFile f(im_msg_body$VideoFile im_msg_body_videofile, im_msg_body$GeneralFlags im_msg_body_generalflags) {
        RichMsg$VideoFile richMsg$VideoFile = new RichMsg$VideoFile();
        richMsg$VideoFile.setHasFlag(true);
        richMsg$VideoFile.bytes_file_name.set(im_msg_body_videofile.bytes_file_name.get());
        richMsg$VideoFile.bytes_file_md5.set(im_msg_body_videofile.bytes_file_md5.get());
        richMsg$VideoFile.bytes_file_uuid.set(im_msg_body_videofile.bytes_file_uuid.get());
        richMsg$VideoFile.uint32_file_format.set(im_msg_body_videofile.uint32_file_format.get());
        richMsg$VideoFile.uint32_file_size.set(im_msg_body_videofile.uint32_file_size.get());
        richMsg$VideoFile.uint32_file_time.set(im_msg_body_videofile.uint32_file_time.get());
        richMsg$VideoFile.uint32_thumb_width.set(im_msg_body_videofile.uint32_thumb_width.get());
        richMsg$VideoFile.uint32_thumb_height.set(im_msg_body_videofile.uint32_thumb_height.get());
        richMsg$VideoFile.uint32_file_status.set(2008);
        richMsg$VideoFile.uint32_file_progress.set(0);
        richMsg$VideoFile.bytes_thumb_file_md5.set(im_msg_body_videofile.bytes_thumb_file_md5.get());
        richMsg$VideoFile.bytes_source.set(im_msg_body_videofile.bytes_source.get());
        richMsg$VideoFile.uint32_thumb_file_size.set(im_msg_body_videofile.uint32_thumb_file_size.get());
        richMsg$VideoFile.uint32_busi_type.set(im_msg_body_videofile.uint32_busi_type.get());
        richMsg$VideoFile.uin32_from_chat_type.set(im_msg_body_videofile.uint32_from_chat_type.get());
        richMsg$VideoFile.uin32_to_chat_type.set(im_msg_body_videofile.uint32_to_chat_type.get());
        richMsg$VideoFile.bool_support_progressive.set(im_msg_body_videofile.bool_support_progressive.get());
        richMsg$VideoFile.uint32_file_width.set(im_msg_body_videofile.uint32_file_width.get());
        richMsg$VideoFile.uint32_file_height.set(im_msg_body_videofile.uint32_file_height.get());
        richMsg$VideoFile.uint32_sub_busi_type.set(im_msg_body_videofile.uint32_sub_busi_type.get());
        richMsg$VideoFile.uint32_video_attr.set(im_msg_body_videofile.uint32_video_attr.get());
        if (im_msg_body_videofile.bytes_pb_reserve.has()) {
            videoFile$ResvAttr videofile_resvattr = new videoFile$ResvAttr();
            try {
                videofile_resvattr.mergeFrom(im_msg_body_videofile.bytes_pb_reserve.get().toByteArray());
                richMsg$VideoFile.bytes_hotvideo_icon.set(videofile_resvattr.bytes_hotvideo_icon.get());
                richMsg$VideoFile.bytes_hotvideo_icon_sub.set(videofile_resvattr.bytes_hotvideo_icon_sub.get());
                richMsg$VideoFile.bytes_hotvideo_title.set(videofile_resvattr.bytes_hotvideo_title.get());
                richMsg$VideoFile.bytes_hotvideo_url.set(videofile_resvattr.bytes_hotvideo_url.get());
                richMsg$VideoFile.uint32_special_video_type.set(videofile_resvattr.uint32_special_video_type.get());
                richMsg$VideoFile.uint32_msg_tail_type.set(videofile_resvattr.uint32_msg_tail_type.get());
                richMsg$VideoFile.uint32_long_video_kandian_type.set(videofile_resvattr.uint32_long_video_kandian_type.get());
                if (videofile_resvattr.bytes_camera_templateid.has()) {
                    richMsg$VideoFile.bytes_camera_video_templateid.set(videofile_resvattr.bytes_camera_templateid.get());
                }
                if (videofile_resvattr.bytes_camera_templateName.has()) {
                    richMsg$VideoFile.bytes_camera_video_templatename.set(videofile_resvattr.bytes_camera_templateName.get());
                }
                if (videofile_resvattr.uint32_embed_video.has()) {
                    richMsg$VideoFile.uint32_embed_video.set(videofile_resvattr.uint32_embed_video.get());
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoEmoticonElemDecoder", 2, "ShortVideo doParse error!", e16);
                }
            }
        }
        if (im_msg_body_generalflags != null && im_msg_body_generalflags.bytes_pb_reserve.has()) {
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            try {
                generalflags_resvattr.mergeFrom(im_msg_body_generalflags.bytes_pb_reserve.get().toByteArray());
                richMsg$VideoFile.uint32_red_envelope_type.set(generalflags_resvattr.uint32_red_envelope_type.get());
                richMsg$VideoFile.bytes_shortVideoId.set(generalflags_resvattr.bytes_shortVideoId.get());
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoEmoticonElemDecoder", 2, "ShortVideo doParse generalFlag error!", e17);
                }
            }
        }
        return richMsg$VideoFile;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        d(list, list2, sb5);
        return true;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        if (im_msg_body_elem.common_elem.has() && 44 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1000;
    }
}

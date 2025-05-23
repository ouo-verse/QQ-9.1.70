package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
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
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$GeneralFlags;
import tencent.im.msg.im_msg_body$VideoFile;

/* compiled from: P */
/* loaded from: classes7.dex */
public class aq extends af {
    static IPatchRedirector $redirector_;

    public aq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5) {
        im_msg_body$VideoFile im_msg_body_videofile = null;
        boolean z16 = false;
        im_msg_body$GeneralFlags im_msg_body_generalflags = null;
        boolean z17 = false;
        int i3 = -1;
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (im_msg_body_elem.video_file.has()) {
                im_msg_body_videofile = im_msg_body_elem.video_file.get();
            }
            if (im_msg_body_elem.bless_msg.has() && im_msg_body_elem.bless_msg.uint32_msg_type.get() == 1) {
                if (im_msg_body_elem.bless_msg.uint32_ex_flag.has()) {
                    i3 = im_msg_body_elem.bless_msg.uint32_ex_flag.get();
                }
                z17 = true;
            }
            if (im_msg_body_elem.general_flags.has()) {
                im_msg_body_generalflags = im_msg_body_elem.general_flags.get();
            }
        }
        if (im_msg_body_videofile == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:video_file;\n");
        }
        MessageForShortVideo e16 = e(im_msg_body_generalflags, f(im_msg_body_videofile, im_msg_body_generalflags));
        list2.add(e16);
        if (z17) {
            if (QLog.isColorLevel()) {
                QLog.d("VideoFileElemDecoder", 2, "decodePBMsgElems, isBlessMsg: true ,updateFlag: " + i3);
            }
            e16.isBlessMsg = true;
            if (i3 > -1) {
                if ((i3 & 1) == 1) {
                    z16 = true;
                }
                e16.needUpdateMsgTag = z16;
            }
        }
        if (QLog.isColorLevel()) {
            sb5.append("ShortVideo.msg: ");
            sb5.append(e16.toString() + "\n" + e16.toLogString());
            sb5.append("\n");
        }
    }

    @NotNull
    private MessageForShortVideo e(im_msg_body$GeneralFlags im_msg_body_generalflags, RichMsg$VideoFile richMsg$VideoFile) {
        MessageForShortVideo messageForShortVideo = (MessageForShortVideo) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO);
        messageForShortVideo.msgtype = MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO;
        messageForShortVideo.msgData = richMsg$VideoFile.toByteArray();
        if (richMsg$VideoFile.uint32_busi_type.get() == 2) {
            messageForShortVideo.f203106msg = ShortVideoConstants.MESSAGE_FOR_SHORT_VIDEO_PTV;
        } else {
            messageForShortVideo.f203106msg = ShortVideoConstants.MESSAGEFORSHORTVIDEO_MSG;
        }
        if (im_msg_body_generalflags != null) {
            im_msg_body_generalflags.babyq_guide_msg_cookie.has();
        }
        messageForShortVideo.parse();
        return messageForShortVideo;
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
                if (videofile_resvattr.uint32_source_codec_format.has()) {
                    richMsg$VideoFile.uint32_source_codec_format.set(videofile_resvattr.uint32_source_codec_format.get());
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("VideoFileElemDecoder", 2, "ShortVideo doParse error!", e16);
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
                    QLog.d("VideoFileElemDecoder", 2, "ShortVideo doParse generalFlag error!", e17);
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
        return im_msg_body_elem.video_file.has();
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

package com.tencent.imcore.message.ext.codec.decoder.pbelement;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.tencent.mobileqq.app.identity.Proto2JsonUtil;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.group_pro_proto.user.msgTransData$TransData;
import tencent.im.msg.hummer.resv.generalflags$MetaData;
import tencent.im.msg.hummer.resv.generalflags$PassThrough;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.oidb.oidb_0xdea$PassThrough;

/* compiled from: P */
/* loaded from: classes7.dex */
public class n extends af {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void d(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.uint32_bot_message_class_id.has()) {
            int i3 = generalflags_resvattr.uint32_bot_message_class_id.get();
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr(ITroopRobotService.ROBOT_NEWS_CLASS_ID, String.valueOf(i3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_bot_message_class_id = " + i3);
            }
        }
    }

    private void e(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        boolean z16;
        if (generalflags_resvattr.uint32_comment_flag.has() && generalflags_resvattr.uint64_comment_location.has() && !list.isEmpty()) {
            if (generalflags_resvattr.uint32_comment_flag.get() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            long j3 = generalflags_resvattr.uint64_comment_location.get();
            MessageRecord messageRecord = list.get(0);
            if (messageRecord instanceof MessageForReplyText) {
                MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                messageForReplyText.isBarrageMsg = z16;
                messageForReplyText.barrageTimeLocation = j3;
                if (z16) {
                    messageForReplyText.saveExtInfoToExtStr(MessageForReplyText.KEY_BARRAGE_TIME_LOCATION, String.valueOf(j3));
                    try {
                        oidb_0xdea$PassThrough oidb_0xdea_passthrough = new oidb_0xdea$PassThrough();
                        oidb_0xdea_passthrough.mergeFrom(generalflags_resvattr.bytes_pass_through.get().toByteArray());
                        messageForReplyText.barrageSourceMsgType = oidb_0xdea_passthrough.entrance.get();
                    } catch (Exception e16) {
                        QLog.i("GeneralFlagsElemDecoder", 1, "handleGeneralSettingFlags fail, " + e16);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "receive replay msg, isBarrageMsg: ", Boolean.valueOf(z16), " timeLocation:", Long.valueOf(j3));
            }
        }
    }

    private void f(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.uint32_diy_font_timestamp.has()) {
            long j3 = generalflags_resvattr.uint32_diy_font_timestamp.get();
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr(FontManagerConstants.MESSAGE_EXTRA_INFO_KEY_DIY_TIMESTAMP, String.valueOf(j3));
            }
        }
    }

    private void g(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        float f16;
        float f17;
        int i3;
        long j3;
        long j16;
        MessageRecord messageRecord;
        if (generalflags_resvattr.float_sticker_x.has()) {
            StickerInfo stickerInfo = new StickerInfo();
            stickerInfo.f204679x = generalflags_resvattr.float_sticker_x.get();
            float f18 = 0.0f;
            if (generalflags_resvattr.float_sticker_y.has()) {
                f16 = generalflags_resvattr.float_sticker_y.get();
            } else {
                f16 = 0.0f;
            }
            stickerInfo.f204680y = f16;
            if (generalflags_resvattr.float_sticker_width.has()) {
                f17 = generalflags_resvattr.float_sticker_width.get();
            } else {
                f17 = 0.0f;
            }
            stickerInfo.width = f17;
            if (generalflags_resvattr.float_sticker_height.has()) {
                f18 = generalflags_resvattr.float_sticker_height.get();
            }
            stickerInfo.height = f18;
            if (generalflags_resvattr.uint32_sticker_rotate.has()) {
                i3 = generalflags_resvattr.uint32_sticker_rotate.get();
            } else {
                i3 = 0;
            }
            stickerInfo.rotate = i3;
            long j17 = 0;
            if (generalflags_resvattr.uint64_sticker_host_msgseq.has()) {
                j3 = generalflags_resvattr.uint64_sticker_host_msgseq.get();
            } else {
                j3 = 0;
            }
            stickerInfo.hostMsgSeq = j3;
            if (generalflags_resvattr.uint64_sticker_host_msguid.has()) {
                j16 = generalflags_resvattr.uint64_sticker_host_msguid.get();
            } else {
                j16 = 0;
            }
            stickerInfo.hostMsgUid = j16;
            if (generalflags_resvattr.uint64_sticker_host_time.has()) {
                j17 = generalflags_resvattr.uint64_sticker_host_time.get();
            }
            stickerInfo.hostMsgTime = j17;
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "decodeC2CMsgPkg_EmojSticker->" + stickerInfo.toString());
            }
            if (!list.isEmpty() && (messageRecord = list.get(0)) != null) {
                messageRecord.saveExtInfoToExtStr("sticker_info", stickerInfo.toJsonString());
                EmojiStickerManager.z(messageRecord, stickerInfo);
                messageRecord.saveExtInfoToExtStr("message_is_sticker", "true");
            }
        }
    }

    private void h(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.unit32_file_from_scene.has() && !list.isEmpty()) {
            com.tencent.mobileqq.filemanager.util.k.c(list.get(0), generalflags_resvattr.unit32_file_from_scene.get());
        }
    }

    private void i(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (list.isEmpty()) {
            return;
        }
        MessageRecord messageRecord = list.get(0);
        if (generalflags_resvattr.game_meta_data.has()) {
            generalflags$MetaData generalflags_metadata = generalflags_resvattr.game_meta_data.get();
            String str = generalflags_metadata.ext_nick.get();
            String str2 = generalflags_metadata.data_from.get();
            messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_GAME_NICK, str);
            messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_GAME_TYPE, str2);
        }
    }

    private void j(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.uint32_tail_key.has()) {
            int i3 = generalflags_resvattr.uint32_tail_key.get();
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr(AppGuideTipsConfig.TAIL_ID, String.valueOf(i3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_tail_key = " + i3);
            }
        }
    }

    private void k(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.uint32_holiday_flag.has()) {
            int i3 = generalflags_resvattr.uint32_holiday_flag.get();
            if (i3 == 1 && !list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286260c, String.valueOf(i3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_holiday_flag = " + i3);
            }
        }
    }

    private void l(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (!generalflags_resvattr.uint32_compound_msg_flag.has()) {
            return;
        }
        int i3 = generalflags_resvattr.uint32_compound_msg_flag.get();
        if (QLog.isColorLevel()) {
            QLog.d("GeneralFlagsElemDecoder", 2, "decodeMixMsgExtraInfo, uint32_compound_msg_flag = " + i3);
        }
        if (!list.isEmpty()) {
            list.get(0).saveExtInfoToExtStr("key_compound_msg_flag", String.valueOf(i3));
        }
    }

    private boolean m(List<MessageRecord> list, boolean z16, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.uint32_mobile_custom_font.has()) {
            long j3 = generalflags_resvattr.uint32_mobile_custom_font.get() & 4294967295L;
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr("vip_font_id", String.valueOf(j3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "vip_font_id = " + j3 + " fontId = " + FontManagerConstants.parseFontId(j3) + " type = " + FontManagerConstants.parseFontType(j3));
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags vip_font not has");
            return z16;
        }
        return z16;
    }

    private void n(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        try {
            if (generalflags_resvattr.uint32_msg_info_flag.has()) {
                int i3 = generalflags_resvattr.uint32_msg_info_flag.get();
                if (!list.isEmpty()) {
                    list.get(0).saveExtInfoToExtStr("key_message_extra_info_flag", String.valueOf(i3));
                }
                if (QLog.isColorLevel()) {
                    QLog.i("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: invoked.  flag: " + i3 + ", mr: " + list.get(0));
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void o(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        generalflags$PassThrough generalflags_passthrough;
        if (generalflags_resvattr != null && (generalflags_passthrough = generalflags_resvattr.pass_through) != null) {
            if (generalflags_passthrough.bytes_qqconnect_tag_name.has()) {
                String stringUtf8 = generalflags_resvattr.pass_through.bytes_qqconnect_tag_name.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    QLog.d("GeneralFlagsElemDecoder", 2, "decodeOpenExtraInfo, bytes_qqconnect_tag_name= " + stringUtf8);
                }
                if (!list.isEmpty()) {
                    list.get(0).saveExtInfoToExtStr("key_open_game_tag_name", stringUtf8);
                }
            }
            if (generalflags_resvattr.pass_through.bytes_qqconnect_message_ext.has()) {
                String stringUtf82 = generalflags_resvattr.pass_through.bytes_qqconnect_message_ext.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    QLog.d("GeneralFlagsElemDecoder", 2, "decodeOpenExtraInfo, bytes_qqconnect_message_ext= " + stringUtf82);
                }
                if (!list.isEmpty()) {
                    list.get(0).saveExtInfoToExtStr("key_open_game_message_ext", stringUtf82);
                }
            }
        }
    }

    private void p(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        try {
            if (generalflags_resvattr.bytes_yuheng_task_msg_buf.has()) {
                String str = new String(generalflags_resvattr.bytes_yuheng_task_msg_buf.get().toByteArray(), "ISO_8859_1");
                if (!list.isEmpty()) {
                    list.get(0).saveExtInfoToExtStr("key_qcircle_extra_info", str);
                }
                if (QLog.isColorLevel()) {
                    QLog.i("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: decodeQCircleExtraInfo invoked.  extra: " + str + ", mr: " + list.get(0));
                }
            }
        } catch (Throwable th5) {
            QLog.e("GeneralFlagsElemDecoder", 1, "handleGeneralSettingFlags: decodeQCircleExtraInfo failed!exception:" + th5.toString());
        }
    }

    private void q(generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.uint32_tail_key.has() && 2 == generalflags_resvattr.uint32_tail_key.get() && generalflags_resvattr.uint32_show_tail_flag.has() && 1 != generalflags_resvattr.uint32_show_tail_flag.get()) {
            generalflags_resvattr.uint32_tail_key.clear();
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags uint32_show_tail_flag != 1, uint32_tail_key been cleaned ");
            }
        }
    }

    private void r(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.bot_meta_data.has() && !list.isEmpty()) {
            list.get(0).saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_MSG_TYPE, String.valueOf(generalflags_resvattr.bot_meta_data.uint32_msg_type.get()));
            list.get(0).saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_IS_SHOW_MSG_SETTING, String.valueOf(generalflags_resvattr.bot_meta_data.bool_show_msg_setting.get()));
            list.get(0).saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_ID, String.valueOf(String.valueOf(generalflags_resvattr.bot_meta_data.source_guild.guild_id.get())));
            list.get(0).saveExtInfoToExtStr(IGuildMessageUtilsApi.ROBOT_MSG_SRC_GUILD_NAME, String.valueOf(generalflags_resvattr.bot_meta_data.source_guild.guild_name.get()));
        }
    }

    private void s(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr, StringBuilder sb5) {
        if (generalflags_resvattr.bytes_service_msg_name.has()) {
            String stringUtf8 = generalflags_resvattr.bytes_service_msg_name.get().toStringUtf8();
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.B, stringUtf8);
            }
            sb5.append("---bytes_service_msg_name = ");
            sb5.append(stringUtf8);
            sb5.append("---");
        }
    }

    private void t(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr, StringBuilder sb5) {
        if (generalflags_resvattr.uint32_service_msg_remind_type.has()) {
            int i3 = generalflags_resvattr.uint32_service_msg_remind_type.get();
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.A, String.valueOf(i3));
            }
            sb5.append("---uint32_service_msg_remind_type = ");
            sb5.append(i3);
            sb5.append("---");
        }
    }

    private void u(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr, StringBuilder sb5) {
        if (generalflags_resvattr.uint32_service_msg_type.has()) {
            int i3 = generalflags_resvattr.uint32_service_msg_type.get();
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286283z, String.valueOf(i3));
            }
            sb5.append("---uint32_service_msg_type = ");
            sb5.append(i3);
            sb5.append("---");
        }
    }

    private void v(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (!generalflags_resvattr.trans_data.has()) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildGeneralFlagsElemDecoder", 2, "decodeTransDataExtraInfo, has transdata");
        }
        if (!list.isEmpty()) {
            msgTransData$TransData msgtransdata_transdata = new msgTransData$TransData();
            try {
                msgtransdata_transdata.mergeFrom(generalflags_resvattr.trans_data.get().toByteArray());
                list.get(0).saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_GUILD_TRANS_DATA, Proto2JsonUtil.proto2Json(msgtransdata_transdata));
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.w("GuildGeneralFlagsElemDecoder", 1, "decodeTransDataExtraInfo error " + e16);
            }
        }
    }

    private void w(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.uint64_subfont_id.has()) {
            long j3 = generalflags_resvattr.uint64_subfont_id.get();
            if (!list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr("vip_sub_font_id", String.valueOf(j3));
            }
            if (QLog.isColorLevel()) {
                QLog.d("GeneralFlagsElemDecoder", 2, "handleGeneralSettingFlags: subFontId=" + j3);
            }
        }
    }

    private void x(List<MessageRecord> list, generalflags$ResvAttr generalflags_resvattr) {
        if (generalflags_resvattr.bytes_wo_info.has() && !list.isEmpty()) {
            k23.a aVar = new k23.a();
            try {
                aVar.mergeFrom(CodedInputByteBufferNano.newInstance(generalflags_resvattr.bytes_wo_info.get().toByteArray()));
                MessageRecord messageRecord = list.get(0);
                if (QLog.isColorLevel()) {
                    QLog.i("GeneralFlagsElemDecoder", 1, "decodeXiaoWoData invoke " + messageRecord.getLogColorContent() + " smallHomeEntrance.show " + aVar.f411433a + " smallHomeLabel: " + aVar.f411435c + " smallHome rank: " + aVar.f411434b);
                }
                if (aVar.f411433a) {
                    messageRecord.saveExtInfoToExtStr("xiao_wo_info", "1");
                    messageRecord.saveExtInfoToExtStr("xiao_wo_label", String.valueOf(aVar.f411436d));
                    messageRecord.saveExtInfoToExtStr("xiao_wo_rank", String.valueOf(aVar.f411434b));
                }
            } catch (Exception e16) {
                QLog.e("GeneralFlagsElemDecoder", 1, "decodeXiaoWoData error:" + e16.toString());
            }
        }
    }

    private void z(List<MessageRecord> list, msg_comm$Msg msg_comm_msg, boolean z16) {
        if (!z16) {
            long e16 = com.tencent.mobileqq.service.message.p.e(msg_comm_msg);
            if (e16 >= 0) {
                if (!list.isEmpty()) {
                    list.get(0).saveExtInfoToExtStr("vip_font_id", String.valueOf(e16));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("GeneralFlagsElemDecoder", 2, "old vip_font_id = " + e16 + " fontId = " + FontManagerConstants.parseFontId(e16) + " type = " + FontManagerConstants.parseFontType(e16));
                }
            }
        }
    }

    protected void A(List<MessageRecord> list, StringBuilder sb5, im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, list, sb5, im_msg_body_elem);
            return;
        }
        if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.get().uint32_olympic_torch.has()) {
            int i3 = im_msg_body_elem.general_flags.uint32_olympic_torch.get();
            if (QLog.isColorLevel()) {
                sb5.append("has olympicTorch:");
                sb5.append(i3);
                sb5.append(";");
            }
            if (i3 > 0 && !list.isEmpty()) {
                list.get(0).saveExtInfoToExtStr("olympic_torch_flg", i3 + "");
            }
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, list, msg_comm_msg, list2, sb5, Boolean.valueOf(z16), Boolean.valueOf(z17), cVar, abVar, aVar)).booleanValue();
        }
        for (im_msg_body$Elem im_msg_body_elem : list) {
            A(list2, sb5, im_msg_body_elem);
            y(list2, msg_comm_msg, im_msg_body_elem);
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) im_msg_body_elem)).booleanValue();
        }
        return im_msg_body_elem.general_flags.has();
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return -1000;
    }

    protected void y(List<MessageRecord> list, msg_comm$Msg msg_comm_msg, im_msg_body$Elem im_msg_body_elem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, list, msg_comm_msg, im_msg_body_elem);
            return;
        }
        if (im_msg_body_elem.general_flags.has()) {
            boolean z16 = false;
            if (im_msg_body_elem.general_flags.uint64_pendant_id.has()) {
                long j3 = im_msg_body_elem.general_flags.uint64_pendant_id.get();
                if (j3 >= 0 && !list.isEmpty()) {
                    list.get(0).saveExtInfoToExtStr("vip_pendant_id", String.valueOf(j3));
                }
            }
            if (im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                try {
                    generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                    g(list, generalflags_resvattr);
                    boolean m3 = m(list, false, generalflags_resvattr);
                    try {
                        w(list, generalflags_resvattr);
                        f(list, generalflags_resvattr);
                        q(generalflags_resvattr);
                        j(list, generalflags_resvattr);
                        d(list, generalflags_resvattr);
                        k(list, generalflags_resvattr);
                        StringBuilder sb5 = new StringBuilder("<---decodeMiniProgramPBMsgElems:");
                        u(list, generalflags_resvattr, sb5);
                        t(list, generalflags_resvattr, sb5);
                        s(list, generalflags_resvattr, sb5);
                        if (QLog.isColorLevel()) {
                            QLog.d("GeneralFlagsElemDecoder", 2, sb5);
                        }
                        n(list, generalflags_resvattr);
                        e(list, generalflags_resvattr);
                        p(list, generalflags_resvattr);
                        o(list, generalflags_resvattr);
                        l(list, generalflags_resvattr);
                        i(list, generalflags_resvattr);
                        v(list, generalflags_resvattr);
                        r(list, generalflags_resvattr);
                        x(list, generalflags_resvattr);
                        h(list, generalflags_resvattr);
                        z16 = m3;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e = e16;
                        z16 = m3;
                        e.printStackTrace();
                        z(list, msg_comm_msg, z16);
                    }
                } catch (InvalidProtocolBufferMicroException e17) {
                    e = e17;
                }
            }
            z(list, msg_comm_msg, z16);
        }
    }
}

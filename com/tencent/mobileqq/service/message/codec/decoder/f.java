package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.ptt.IQQRecorderUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.o;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.stt.ISttManagerApi;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.cm;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import localpb.richMsg.RichMsg$PttRec;
import msf.msgcomm.msg_comm$Msg;
import org.jetbrains.annotations.NotNull;
import tencent.im.cs.ptt_reserve.ptt_reserve$ReserveStruct;
import tencent.im.cs.ptt_waveform.ptt_waveform$PttWaveform;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$NearByMessageType;
import tencent.im.msg.im_msg_body$Ptt;
import tencent.im.msg.im_msg_body$PubGroup;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f implements d {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(msg_comm$Msg msg_comm_msg, MessageRecord messageRecord, List<im_msg_body$Elem> list, StringBuilder sb5) {
        for (int i3 = 0; i3 < list.size(); i3++) {
            im_msg_body$Elem im_msg_body_elem = list.get(i3);
            if (im_msg_body_elem.near_by_msg.has()) {
                if (QLog.isColorLevel()) {
                    sb5.append("elemType: near_by_msg;");
                }
                im_msg_body$NearByMessageType im_msg_body_nearbymessagetype = im_msg_body_elem.near_by_msg;
                if (im_msg_body_nearbymessagetype.uint32_identify_type.has() && im_msg_body_nearbymessagetype.uint32_identify_type.get() == 1) {
                    messageRecord.saveExtInfoToExtStr("identify_flag", "true");
                    if (QLog.isColorLevel()) {
                        sb5.append("has identify;");
                    }
                }
            } else {
                String str = "";
                if (im_msg_body_elem.pub_group.has()) {
                    im_msg_body$PubGroup im_msg_body_pubgroup = im_msg_body_elem.pub_group.get();
                    if (im_msg_body_pubgroup != null) {
                        int i16 = im_msg_body_pubgroup.uint32_gender.get();
                        String stringUtf8 = im_msg_body_pubgroup.bytes_nickname.get().toStringUtf8();
                        messageRecord.saveExtInfoToExtStr("hotchat_gender", String.valueOf(i16));
                        if (stringUtf8 != null) {
                            str = stringUtf8;
                        }
                        messageRecord.saveExtInfoToExtStr("hotchat_nick", str);
                        if (QLog.isColorLevel()) {
                            sb5.append("has pub_group;");
                        }
                    }
                } else if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.get().uint32_olympic_torch.has()) {
                    int i17 = im_msg_body_elem.general_flags.uint32_olympic_torch.get();
                    if (QLog.isColorLevel()) {
                        sb5.append("has olympicTorch:");
                        sb5.append(i17);
                        sb5.append(";");
                    }
                    if (i17 > 0) {
                        messageRecord.saveExtInfoToExtStr("olympic_torch_flg", i17 + "");
                    }
                } else if (im_msg_body_elem.common_elem.has() && 13 == im_msg_body_elem.common_elem.uint32_service_type.get()) {
                    if (QLog.isColorLevel()) {
                        sb5.append("decodeGrpDisMsgPkg_PTT decode hummer_commelem == UpdateStrangerAvatar");
                    }
                    new o().p1(list, msg_comm_msg, sb5);
                }
            }
            g(messageRecord, im_msg_body_elem);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x010e  */
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private MessageRecord d(BaseMessageHandler baseMessageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, im_msg_body$Ptt im_msg_body_ptt, String str, String str2) {
        String str3;
        long j3;
        String bytes2HexStr;
        String str4;
        String str5;
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        boolean sttAbility = ((ISttManagerApi) QRoute.api(ISttManagerApi.class)).getSttAbility(baseMessageHandler.getApp());
        int e16 = e(msg_comm_msg);
        int i27 = im_msg_body_ptt.uint32_file_type.get();
        boolean z16 = im_msg_body_ptt.bool_valid.get();
        long j16 = im_msg_body_ptt.uint64_src_uin.get();
        long j17 = im_msg_body_ptt.uint32_file_size.get() & 4294967295L;
        long j18 = im_msg_body_ptt.uint32_file_id.get() & 4294967295L;
        long j19 = im_msg_body_ptt.uint32_server_ip.get() & 4294967295L;
        long j26 = im_msg_body_ptt.uint32_server_port.get() & 4294967295L;
        byte[] byteArray = im_msg_body_ptt.bytes_file_uuid.get().toByteArray();
        byte[] byteArray2 = im_msg_body_ptt.bytes_file_md5.get().toByteArray();
        int i28 = im_msg_body_ptt.uint32_format.has() ? im_msg_body_ptt.uint32_format.get() : 0;
        long f16 = f(im_msg_body_ptt.uint32_time.has() ? im_msg_body_ptt.uint32_time.get() : 0);
        if (im_msg_body_ptt.bytes_down_para.has()) {
            if (QLog.isColorLevel()) {
                QLog.d("SPD", 2, "receive ptt msg , bytes_down_para has ! " + im_msg_body_ptt.bytes_down_para.get());
            }
            ByteStringMicro byteStringMicro = im_msg_body_ptt.bytes_down_para.get();
            if (byteStringMicro != null) {
                str3 = byteStringMicro.toStringUtf8();
                if (QLog.isColorLevel()) {
                    j3 = j17;
                } else {
                    StringBuilder sb5 = new StringBuilder();
                    j3 = j17;
                    sb5.append("receive ptt msg , url : ");
                    sb5.append(str3);
                    sb5.append(" srcuin ");
                    sb5.append(j16);
                    sb5.append("filename");
                    sb5.append(str);
                    QLog.d("SPD", 2, sb5.toString());
                }
                if (QLog.isColorLevel()) {
                    QLog.d("RecordParams", 2, "<---decodeGrpDisMsgPkg_PTT voiceType\uff1a" + i28 + " voiceLengh:" + f16);
                }
                String bytes2HexStr2 = HexUtil.bytes2HexStr(byteArray);
                bytes2HexStr = HexUtil.bytes2HexStr(byteArray2);
                if (im_msg_body_ptt.bytes_group_file_key.has()) {
                    try {
                        str4 = new String(im_msg_body_ptt.bytes_group_file_key.get().toByteArray(), "utf-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                    String str6 = bytes2HexStr == null ? "" : bytes2HexStr;
                    if (QLog.isColorLevel()) {
                        QLog.d("GrpDisPTTDecoder", 2, "<---decodeSinglePbMsg_GroupDis: pttType:" + i27 + " isValid:" + z16 + " srcUin:" + j16 + " fileSize:" + j3 + " fileID" + j18 + " serverIP:" + j19 + " serverPort:" + j26 + " fileName:" + str + " uuidStr:" + bytes2HexStr2 + " md5Str:" + str6 + " GrpFileKey:" + str4);
                    }
                    if (im_msg_body_ptt.bytes_pb_reserve.has()) {
                        ptt_reserve$ReserveStruct ptt_reserve_reservestruct = new ptt_reserve$ReserveStruct();
                        try {
                            ptt_reserve_reservestruct.mergeFrom(im_msg_body_ptt.bytes_pb_reserve.get().toByteArray());
                            i18 = ptt_reserve_reservestruct.uint32_change_voice.get();
                        } catch (Exception unused2) {
                            i18 = 0;
                        }
                        try {
                            i19 = ptt_reserve_reservestruct.uint32_redpack_type.get();
                        } catch (Exception unused3) {
                            i19 = 0;
                            i26 = 0;
                            str5 = str2;
                            i17 = i18;
                            i16 = i19;
                            i3 = i26;
                            int i29 = i3;
                            String str7 = str5;
                            int i36 = i16;
                            TransfileUtile.makeTransFileProtocolData(str, 0L, 2, false, str);
                            RichMsg$PttRec richMsg$PttRec = new RichMsg$PttRec();
                            richMsg$PttRec.localPath.set(str);
                            richMsg$PttRec.size.set(im_msg_body_ptt.uint32_file_size.get());
                            richMsg$PttRec.type.set(2);
                            richMsg$PttRec.uuid.set(str);
                            richMsg$PttRec.isRead.set(false);
                            richMsg$PttRec.md5.set(str6);
                            richMsg$PttRec.isReport.set(0);
                            richMsg$PttRec.version.set(5);
                            richMsg$PttRec.groupFileID.set(j18);
                            richMsg$PttRec.pttFlag.set(sttAbility ? 1 : 0);
                            richMsg$PttRec.longPttVipFlag.set(e16);
                            if (str4 != null) {
                            }
                            long currentTimeMillis = System.currentTimeMillis() / 1000;
                            long j27 = msg_comm_msg.msg_head.msg_time.get();
                            richMsg$PttRec.msgRecTime.set(currentTimeMillis);
                            richMsg$PttRec.msgTime.set(j27);
                            richMsg$PttRec.voiceType.set(i28);
                            richMsg$PttRec.voiceLength.set(Utils.O(f16));
                            richMsg$PttRec.voiceChangeFlag.set(i17);
                            richMsg$PttRec.directUrl.set(str3);
                            richMsg$PttRec.redpack_type.set(i36);
                            richMsg$PttRec.autototext_voice.set(i29);
                            richMsg$PttRec.sttText.set(str7);
                            MessageRecord d16 = q.d(-2002);
                            d16.msgtype = -2002;
                            d16.msgData = richMsg$PttRec.toByteArray();
                            ((MessageForPtt) d16).parse();
                            list.add(d16);
                            return d16;
                        }
                        try {
                            i26 = ptt_reserve_reservestruct.uint32_autototext_voice.get();
                        } catch (Exception unused4) {
                            i26 = 0;
                            str5 = str2;
                            i17 = i18;
                            i16 = i19;
                            i3 = i26;
                            int i292 = i3;
                            String str72 = str5;
                            int i362 = i16;
                            TransfileUtile.makeTransFileProtocolData(str, 0L, 2, false, str);
                            RichMsg$PttRec richMsg$PttRec2 = new RichMsg$PttRec();
                            richMsg$PttRec2.localPath.set(str);
                            richMsg$PttRec2.size.set(im_msg_body_ptt.uint32_file_size.get());
                            richMsg$PttRec2.type.set(2);
                            richMsg$PttRec2.uuid.set(str);
                            richMsg$PttRec2.isRead.set(false);
                            richMsg$PttRec2.md5.set(str6);
                            richMsg$PttRec2.isReport.set(0);
                            richMsg$PttRec2.version.set(5);
                            richMsg$PttRec2.groupFileID.set(j18);
                            richMsg$PttRec2.pttFlag.set(sttAbility ? 1 : 0);
                            richMsg$PttRec2.longPttVipFlag.set(e16);
                            if (str4 != null) {
                            }
                            long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                            long j272 = msg_comm_msg.msg_head.msg_time.get();
                            richMsg$PttRec2.msgRecTime.set(currentTimeMillis2);
                            richMsg$PttRec2.msgTime.set(j272);
                            richMsg$PttRec2.voiceType.set(i28);
                            richMsg$PttRec2.voiceLength.set(Utils.O(f16));
                            richMsg$PttRec2.voiceChangeFlag.set(i17);
                            richMsg$PttRec2.directUrl.set(str3);
                            richMsg$PttRec2.redpack_type.set(i362);
                            richMsg$PttRec2.autototext_voice.set(i292);
                            richMsg$PttRec2.sttText.set(str72);
                            MessageRecord d162 = q.d(-2002);
                            d162.msgtype = -2002;
                            d162.msgData = richMsg$PttRec2.toByteArray();
                            ((MessageForPtt) d162).parse();
                            list.add(d162);
                            return d162;
                        }
                        try {
                            str5 = ptt_reserve_reservestruct.bytes_voice_text_abs.get().toStringUtf8();
                        } catch (Exception unused5) {
                            str5 = str2;
                            i17 = i18;
                            i16 = i19;
                            i3 = i26;
                            int i2922 = i3;
                            String str722 = str5;
                            int i3622 = i16;
                            TransfileUtile.makeTransFileProtocolData(str, 0L, 2, false, str);
                            RichMsg$PttRec richMsg$PttRec22 = new RichMsg$PttRec();
                            richMsg$PttRec22.localPath.set(str);
                            richMsg$PttRec22.size.set(im_msg_body_ptt.uint32_file_size.get());
                            richMsg$PttRec22.type.set(2);
                            richMsg$PttRec22.uuid.set(str);
                            richMsg$PttRec22.isRead.set(false);
                            richMsg$PttRec22.md5.set(str6);
                            richMsg$PttRec22.isReport.set(0);
                            richMsg$PttRec22.version.set(5);
                            richMsg$PttRec22.groupFileID.set(j18);
                            richMsg$PttRec22.pttFlag.set(sttAbility ? 1 : 0);
                            richMsg$PttRec22.longPttVipFlag.set(e16);
                            if (str4 != null) {
                            }
                            long currentTimeMillis22 = System.currentTimeMillis() / 1000;
                            long j2722 = msg_comm_msg.msg_head.msg_time.get();
                            richMsg$PttRec22.msgRecTime.set(currentTimeMillis22);
                            richMsg$PttRec22.msgTime.set(j2722);
                            richMsg$PttRec22.voiceType.set(i28);
                            richMsg$PttRec22.voiceLength.set(Utils.O(f16));
                            richMsg$PttRec22.voiceChangeFlag.set(i17);
                            richMsg$PttRec22.directUrl.set(str3);
                            richMsg$PttRec22.redpack_type.set(i3622);
                            richMsg$PttRec22.autototext_voice.set(i2922);
                            richMsg$PttRec22.sttText.set(str722);
                            MessageRecord d1622 = q.d(-2002);
                            d1622.msgtype = -2002;
                            d1622.msgData = richMsg$PttRec22.toByteArray();
                            ((MessageForPtt) d1622).parse();
                            list.add(d1622);
                            return d1622;
                        }
                        i17 = i18;
                        i16 = i19;
                        i3 = i26;
                    } else {
                        str5 = str2;
                        i3 = 0;
                        i16 = 0;
                        i17 = 0;
                    }
                    int i29222 = i3;
                    String str7222 = str5;
                    int i36222 = i16;
                    TransfileUtile.makeTransFileProtocolData(str, 0L, 2, false, str);
                    RichMsg$PttRec richMsg$PttRec222 = new RichMsg$PttRec();
                    richMsg$PttRec222.localPath.set(str);
                    richMsg$PttRec222.size.set(im_msg_body_ptt.uint32_file_size.get());
                    richMsg$PttRec222.type.set(2);
                    richMsg$PttRec222.uuid.set(str);
                    richMsg$PttRec222.isRead.set(false);
                    richMsg$PttRec222.md5.set(str6);
                    richMsg$PttRec222.isReport.set(0);
                    richMsg$PttRec222.version.set(5);
                    richMsg$PttRec222.groupFileID.set(j18);
                    richMsg$PttRec222.pttFlag.set(sttAbility ? 1 : 0);
                    richMsg$PttRec222.longPttVipFlag.set(e16);
                    if (str4 != null) {
                        richMsg$PttRec222.group_file_key.set(str4);
                    }
                    long currentTimeMillis222 = System.currentTimeMillis() / 1000;
                    long j27222 = msg_comm_msg.msg_head.msg_time.get();
                    richMsg$PttRec222.msgRecTime.set(currentTimeMillis222);
                    richMsg$PttRec222.msgTime.set(j27222);
                    richMsg$PttRec222.voiceType.set(i28);
                    richMsg$PttRec222.voiceLength.set(Utils.O(f16));
                    richMsg$PttRec222.voiceChangeFlag.set(i17);
                    richMsg$PttRec222.directUrl.set(str3);
                    richMsg$PttRec222.redpack_type.set(i36222);
                    richMsg$PttRec222.autototext_voice.set(i29222);
                    richMsg$PttRec222.sttText.set(str7222);
                    MessageRecord d16222 = q.d(-2002);
                    d16222.msgtype = -2002;
                    d16222.msgData = richMsg$PttRec222.toByteArray();
                    ((MessageForPtt) d16222).parse();
                    list.add(d16222);
                    return d16222;
                }
                str4 = null;
                if (bytes2HexStr == null) {
                }
                if (QLog.isColorLevel()) {
                }
                if (im_msg_body_ptt.bytes_pb_reserve.has()) {
                }
                int i292222 = i3;
                String str72222 = str5;
                int i362222 = i16;
                TransfileUtile.makeTransFileProtocolData(str, 0L, 2, false, str);
                RichMsg$PttRec richMsg$PttRec2222 = new RichMsg$PttRec();
                richMsg$PttRec2222.localPath.set(str);
                richMsg$PttRec2222.size.set(im_msg_body_ptt.uint32_file_size.get());
                richMsg$PttRec2222.type.set(2);
                richMsg$PttRec2222.uuid.set(str);
                richMsg$PttRec2222.isRead.set(false);
                richMsg$PttRec2222.md5.set(str6);
                richMsg$PttRec2222.isReport.set(0);
                richMsg$PttRec2222.version.set(5);
                richMsg$PttRec2222.groupFileID.set(j18);
                richMsg$PttRec2222.pttFlag.set(sttAbility ? 1 : 0);
                richMsg$PttRec2222.longPttVipFlag.set(e16);
                if (str4 != null) {
                }
                long currentTimeMillis2222 = System.currentTimeMillis() / 1000;
                long j272222 = msg_comm_msg.msg_head.msg_time.get();
                richMsg$PttRec2222.msgRecTime.set(currentTimeMillis2222);
                richMsg$PttRec2222.msgTime.set(j272222);
                richMsg$PttRec2222.voiceType.set(i28);
                richMsg$PttRec2222.voiceLength.set(Utils.O(f16));
                richMsg$PttRec2222.voiceChangeFlag.set(i17);
                richMsg$PttRec2222.directUrl.set(str3);
                richMsg$PttRec2222.redpack_type.set(i362222);
                richMsg$PttRec2222.autototext_voice.set(i292222);
                richMsg$PttRec2222.sttText.set(str72222);
                MessageRecord d162222 = q.d(-2002);
                d162222.msgtype = -2002;
                d162222.msgData = richMsg$PttRec2222.toByteArray();
                ((MessageForPtt) d162222).parse();
                list.add(d162222);
                return d162222;
            }
        }
        str3 = "";
        if (QLog.isColorLevel()) {
        }
        if (QLog.isColorLevel()) {
        }
        String bytes2HexStr22 = HexUtil.bytes2HexStr(byteArray);
        bytes2HexStr = HexUtil.bytes2HexStr(byteArray2);
        if (im_msg_body_ptt.bytes_group_file_key.has()) {
        }
        str4 = null;
        if (bytes2HexStr == null) {
        }
        if (QLog.isColorLevel()) {
        }
        if (im_msg_body_ptt.bytes_pb_reserve.has()) {
        }
        int i2922222 = i3;
        String str722222 = str5;
        int i3622222 = i16;
        TransfileUtile.makeTransFileProtocolData(str, 0L, 2, false, str);
        RichMsg$PttRec richMsg$PttRec22222 = new RichMsg$PttRec();
        richMsg$PttRec22222.localPath.set(str);
        richMsg$PttRec22222.size.set(im_msg_body_ptt.uint32_file_size.get());
        richMsg$PttRec22222.type.set(2);
        richMsg$PttRec22222.uuid.set(str);
        richMsg$PttRec22222.isRead.set(false);
        richMsg$PttRec22222.md5.set(str6);
        richMsg$PttRec22222.isReport.set(0);
        richMsg$PttRec22222.version.set(5);
        richMsg$PttRec22222.groupFileID.set(j18);
        richMsg$PttRec22222.pttFlag.set(sttAbility ? 1 : 0);
        richMsg$PttRec22222.longPttVipFlag.set(e16);
        if (str4 != null) {
        }
        long currentTimeMillis22222 = System.currentTimeMillis() / 1000;
        long j2722222 = msg_comm_msg.msg_head.msg_time.get();
        richMsg$PttRec22222.msgRecTime.set(currentTimeMillis22222);
        richMsg$PttRec22222.msgTime.set(j2722222);
        richMsg$PttRec22222.voiceType.set(i28);
        richMsg$PttRec22222.voiceLength.set(Utils.O(f16));
        richMsg$PttRec22222.voiceChangeFlag.set(i17);
        richMsg$PttRec22222.directUrl.set(str3);
        richMsg$PttRec22222.redpack_type.set(i3622222);
        richMsg$PttRec22222.autototext_voice.set(i2922222);
        richMsg$PttRec22222.sttText.set(str722222);
        MessageRecord d1622222 = q.d(-2002);
        d1622222.msgtype = -2002;
        d1622222.msgData = richMsg$PttRec22222.toByteArray();
        ((MessageForPtt) d1622222).parse();
        list.add(d1622222);
        return d1622222;
    }

    private int e(msg_comm$Msg msg_comm_msg) {
        if (!msg_comm_msg.msg_body.has() || !msg_comm_msg.msg_body.get().rich_text.has()) {
            return 0;
        }
        for (im_msg_body$Elem im_msg_body_elem : msg_comm_msg.msg_body.get().rich_text.get().elems.get()) {
            if (im_msg_body_elem.elem_flags2.has() && im_msg_body_elem.elem_flags2.get().uint32_vip_status.has()) {
                int i3 = im_msg_body_elem.elem_flags2.get().uint32_vip_status.get();
                int i16 = 1;
                if (i3 != 1) {
                    i16 = 2;
                    if (i3 != 2) {
                        return 0;
                    }
                }
                return i16;
            }
        }
        return 0;
    }

    private void g(MessageRecord messageRecord, im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
            generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
            try {
                generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                if (generalflags_resvattr.uint32_holiday_flag.has()) {
                    int i3 = generalflags_resvattr.uint32_holiday_flag.get();
                    if (i3 == 1) {
                        messageRecord.saveExtInfoToExtStr(com.tencent.mobileqq.service.message.i.f286260c, String.valueOf(i3));
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("GrpDisPTTDecoder", 2, "decodeGrpDisMsgPkg_PTT uint32_holiday_flag = " + i3);
                    }
                }
                if (generalflags_resvattr.bytes_pb_ptt_waveform.has()) {
                    try {
                        ptt_waveform$PttWaveform ptt_waveform_pttwaveform = new ptt_waveform$PttWaveform();
                        ptt_waveform_pttwaveform.mergeFrom(generalflags_resvattr.bytes_pb_ptt_waveform.get().toByteArray());
                        ((MessageForPtt) messageRecord).waveformArray = cm.a(ptt_waveform_pttwaveform);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            int[] iArr = ((MessageForPtt) messageRecord).waveformArray;
                            if (iArr != null) {
                                for (int i16 : iArr) {
                                    sb5.append(i16);
                                    sb5.append(";");
                                }
                            }
                            QLog.d("GrpDisPTTDecoder", 2, "decodeGrpDisMsgPkg_PTT, waveformArray = " + sb5.toString());
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (((MessageForPtt) messageRecord).waveformArray == null || ((MessageForPtt) messageRecord).waveformArray.length == 0) {
                    ((MessageForPtt) messageRecord).buileDefaultWaveform();
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    private void h(BaseMessageHandler baseMessageHandler, msg_comm$Msg msg_comm_msg, MessageRecord messageRecord, List<im_msg_body$Elem> list) {
        byte[] bArr;
        for (int i3 = 0; i3 < list.size(); i3++) {
            im_msg_body$Elem im_msg_body_elem = list.get(i3);
            if (im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
                generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
                try {
                    generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
                    if (generalflags_resvattr.uint32_robot_msg_flag.has()) {
                        int i16 = generalflags_resvattr.uint32_robot_msg_flag.get();
                        messageRecord.mRobotFlag = i16;
                        if (QLog.isColorLevel()) {
                            QLog.d("GrpDisPTTDecoder", 2, "handleGeneralSettingFlags uint32_robot_msg_flag = " + i16);
                        }
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
            }
        }
        boolean isRobotUin = ((ITroopRobotService) baseMessageHandler.getApp().getRuntimeService(ITroopRobotService.class, "all")).isRobotUin(msg_comm_msg.msg_head.get().from_uin.get());
        int i17 = messageRecord.mRobotFlag;
        if (i17 == 1 || i17 == 2 || isRobotUin) {
            for (im_msg_body$Elem im_msg_body_elem2 : list) {
                if (im_msg_body_elem2.text.has()) {
                    im_msg_body$Text im_msg_body_text = im_msg_body_elem2.text.get();
                    if (im_msg_body_text.attr_6_buf.has()) {
                        ByteStringMicro byteStringMicro = im_msg_body_text.attr_6_buf.get();
                        if (byteStringMicro != null) {
                            bArr = byteStringMicro.toByteArray();
                        } else {
                            bArr = null;
                        }
                        if (bArr != null && bArr.length != 0) {
                            short shortData = PkgTools.getShortData(bArr, 0);
                            short s16 = 0;
                            int i18 = 2;
                            while (s16 < shortData && i18 < 2048) {
                                AtTroopMemberInfo atTroopMemberInfo = new AtTroopMemberInfo();
                                if (!atTroopMemberInfo.readFrom(bArr, i18)) {
                                    break;
                                }
                                i18 += atTroopMemberInfo.length();
                                s16 = (short) (s16 + 1);
                                if (messageRecord.atInfoList == null) {
                                    messageRecord.atInfoList = new ArrayList<>();
                                }
                                messageRecord.atInfoList.add(atTroopMemberInfo);
                            }
                        }
                    }
                }
            }
            ((MessageForPtt) messageRecord).parse();
        }
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(BaseMessageHandler baseMessageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        MessageRecord messageRecord;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, baseMessageHandler, msg_comm_msg, list, aVar);
            return;
        }
        im_msg_body$Ptt im_msg_body_ptt = msg_comm_msg.msg_body.get().rich_text.get().ptt.get();
        String stringUtf8 = im_msg_body_ptt.bytes_file_name.get().toStringUtf8();
        if (stringUtf8.endsWith(".amr")) {
            messageRecord = d(baseMessageHandler, msg_comm_msg, list, im_msg_body_ptt, stringUtf8, "");
        } else {
            messageRecord = null;
        }
        if (messageRecord == null) {
            return;
        }
        List<im_msg_body$Elem> list2 = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
        StringBuilder sb5 = new StringBuilder();
        if (list2 != null && list2.size() > 0) {
            if (QLog.isColorLevel()) {
                sb5.append("elemsSize");
                sb5.append(list2.size());
                sb5.append("\n");
            }
            c(msg_comm_msg, messageRecord, list2, sb5);
            h(baseMessageHandler, msg_comm_msg, messageRecord, list2);
            ConfessMsgUtil.l(msg_comm_msg, messageRecord, baseMessageHandler.getApp());
            if (QLog.isColorLevel()) {
                QLog.d("GrpDisPTTDecoder", 2, sb5.toString());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elems:null || elems.size() <= 0");
            QLog.d("GrpDisPTTDecoder", 2, sb5.toString());
        }
    }

    public long f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this, i3)).longValue();
        }
        return ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).getPttShowTime(i3);
    }
}

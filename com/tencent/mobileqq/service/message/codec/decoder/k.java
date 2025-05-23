package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ac;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import localpb.richMsg.RichMsg$PttRec;
import msf.msgcomm.msg_comm$C2CTmpMsgHead;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.cs.ptt_reserve.ptt_reserve$ReserveStruct;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$Text;
import tencent.im.msg.im_msg_body$TmpPtt;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k implements d<MessageHandler> {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(MessageHandler messageHandler, ab abVar, com.tencent.mobileqq.service.message.a aVar, byte b16, byte b17, byte[] bArr) {
        int i3 = abVar.f286173a;
        if (i3 != 1001) {
            if (i3 != 7400) {
                if (i3 != 10002) {
                    if (i3 != 10004) {
                        if (i3 != 10010) {
                            if (i3 != 10019) {
                                if (i3 != 1005) {
                                    if (i3 != 1006) {
                                        if (i3 != 10007) {
                                            if (i3 != 10008) {
                                                switch (i3) {
                                                    case 1008:
                                                        byte[] bArr2 = new byte[bArr.length + 2];
                                                        bArr2[0] = b16;
                                                        bArr2[1] = b17;
                                                        PkgTools.copyData(bArr2, 2, bArr, 0, bArr.length);
                                                        messageHandler.Q.getMsgCache().H(String.valueOf(aVar.f286338a), bArr2);
                                                        return;
                                                    case 1009:
                                                        messageHandler.Q.getMsgCache().K(String.valueOf(aVar.f286338a), bArr);
                                                        return;
                                                    case 1010:
                                                        messageHandler.Q.getMsgCache().n(String.valueOf(aVar.f286338a), bArr);
                                                        return;
                                                    default:
                                                        switch (i3) {
                                                            case 1021:
                                                                messageHandler.Q.getMsgCache().k(String.valueOf(aVar.f286338a), bArr);
                                                                return;
                                                            case 1022:
                                                                messageHandler.Q.getMsgCache().r(String.valueOf(aVar.f286338a), bArr);
                                                                return;
                                                            case 1023:
                                                                byte[] bArr3 = new byte[bArr.length + 2];
                                                                bArr3[0] = b16;
                                                                bArr3[1] = b17;
                                                                PkgTools.copyData(bArr3, 2, bArr, 0, bArr.length);
                                                                messageHandler.Q.getMsgCache().E(String.valueOf(aVar.f286338a), bArr3);
                                                                return;
                                                            case 1024:
                                                            case 1025:
                                                                messageHandler.Q.getMsgCache().h(String.valueOf(aVar.f286338a), bArr);
                                                                return;
                                                            default:
                                                                switch (i3) {
                                                                    case 1032:
                                                                    case 1033:
                                                                    case 1034:
                                                                        messageHandler.Q.getMsgCache().m(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c), bArr);
                                                                        return;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 1044:
                                                                                messageHandler.Q.getMsgCache().v(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c), bArr);
                                                                                return;
                                                                            case 1045:
                                                                                messageHandler.Q.getMsgCache().w(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c), bArr, false);
                                                                                return;
                                                                            case 1046:
                                                                                messageHandler.Q.getMsgCache().x(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c), bArr);
                                                                                return;
                                                                            default:
                                                                                c(messageHandler, abVar, aVar, b16, b17, bArr);
                                                                                return;
                                                                        }
                                                                }
                                                        }
                                                }
                                            }
                                            messageHandler.Q.getMsgCache().I(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c), bArr);
                                            return;
                                        }
                                        if (aVar.f286162q) {
                                            messageHandler.Q.getMsgCache().P(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c), bArr);
                                            return;
                                        }
                                        return;
                                    }
                                    byte[] bArr4 = new byte[bArr.length + 2];
                                    bArr4[0] = b16;
                                    bArr4[1] = b17;
                                    PkgTools.copyData(bArr4, 2, bArr, 0, bArr.length);
                                    return;
                                }
                                byte[] bArr5 = new byte[bArr.length + 2];
                                bArr5[0] = b16;
                                bArr5[1] = b17;
                                PkgTools.copyData(bArr5, 2, bArr, 0, bArr.length);
                                messageHandler.Q.getMsgCache().T(String.valueOf(aVar.f286338a), bArr5);
                                return;
                            }
                            messageHandler.Q.getMsgCache().N(String.valueOf(aVar.f286338a), String.valueOf(aVar.f286148c), bArr);
                            return;
                        }
                        messageHandler.Q.getMsgCache().g(String.valueOf(aVar.f286338a), bArr);
                        return;
                    }
                    messageHandler.Q.getMsgCache().z(String.valueOf(aVar.f286338a), bArr);
                    return;
                }
                messageHandler.Q.getMsgCache().S(String.valueOf(aVar.f286338a), bArr);
                return;
            }
            messageHandler.Q.getMsgCache().f(String.valueOf(aVar.f286338a), bArr);
            return;
        }
        messageHandler.Q.getMsgCache().d(String.valueOf(aVar.f286338a), bArr);
    }

    private void e(MessageHandler messageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, ab abVar, com.tencent.mobileqq.service.message.a aVar, boolean z16, List<im_msg_body$Elem> list2) {
        if (z16) {
            if (list2 != null && list2.size() > 0) {
                im_msg_body$Text im_msg_body_text = list2.get(0).text.get();
                if (!aVar.f286155j) {
                    String str = BaseApplication.getContext().getString(R.string.f170517tj) + " " + im_msg_body_text.str.get().toStringUtf8();
                    MessageRecord d16 = q.d(-10000);
                    d16.msgtype = -10000;
                    d16.f203106msg = str;
                    list.add(d16);
                    return;
                }
                return;
            }
            return;
        }
        if (abVar != null) {
            f(messageHandler, list, msg_comm_msg, abVar, aVar);
        }
    }

    private void f(MessageHandler messageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$TmpPtt im_msg_body_tmpptt;
        int i3;
        String str;
        MessageRecord d16;
        if (msg_comm_msg.msg_head.get().msg_type.get() == 529 && msg_comm_msg.msg_head.get().c2c_cmd.get() == 6) {
            try {
                im_msg_body_tmpptt = new im_msg_body$TmpPtt().mergeFrom(msg_comm_msg.msg_body.get().msg_content.get().toByteArray());
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                im_msg_body_tmpptt = null;
            }
            if (im_msg_body_tmpptt != null && im_msg_body_tmpptt.uint32_file_type.has() && im_msg_body_tmpptt.uint32_file_type.get() == 4 && im_msg_body_tmpptt.bytes_file_uuid.has()) {
                String stringUtf8 = im_msg_body_tmpptt.bytes_file_uuid.get().toStringUtf8();
                if (QLog.isColorLevel()) {
                    QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : ptt uuid:" + stringUtf8);
                }
                RichMsg$PttRec richMsg$PttRec = new RichMsg$PttRec();
                richMsg$PttRec.localPath.set(im_msg_body_tmpptt.bytes_file_uuid.get().toStringUtf8());
                richMsg$PttRec.size.set(im_msg_body_tmpptt.uint32_file_size.get());
                richMsg$PttRec.type.set(2);
                richMsg$PttRec.uuid.set(stringUtf8);
                int i16 = 0;
                richMsg$PttRec.isRead.set(false);
                richMsg$PttRec.serverStorageSource.set("pttcenter");
                richMsg$PttRec.isReport.set(0);
                richMsg$PttRec.version.set(5);
                richMsg$PttRec.pttFlag.set(0);
                int h16 = h(im_msg_body_tmpptt, 0);
                if (im_msg_body_tmpptt.bytes_pb_reserve.has()) {
                    ptt_reserve$ReserveStruct ptt_reserve_reservestruct = new ptt_reserve$ReserveStruct();
                    try {
                        ptt_reserve_reservestruct.mergeFrom(im_msg_body_tmpptt.bytes_pb_reserve.get().toByteArray());
                        int i17 = ptt_reserve_reservestruct.uint32_change_voice.get();
                        try {
                            i16 = ptt_reserve_reservestruct.uint32_autototext_voice.get();
                            String stringUtf82 = ptt_reserve_reservestruct.bytes_voice_text_abs.get().toStringUtf8();
                            i3 = i16;
                            i16 = i17;
                            str = stringUtf82;
                        } catch (Exception unused) {
                            i3 = i16;
                            i16 = i17;
                        }
                    } catch (Exception unused2) {
                    }
                    richMsg$PttRec.longPttVipFlag.set(h16);
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    long j3 = msg_comm_msg.msg_head.msg_time.get();
                    richMsg$PttRec.msgRecTime.set(currentTimeMillis);
                    richMsg$PttRec.msgTime.set(j3);
                    richMsg$PttRec.voiceChangeFlag.set(i16);
                    richMsg$PttRec.busiType.set(im_msg_body_tmpptt.uint32_busi_type.get());
                    richMsg$PttRec.autototext_voice.set(i3);
                    richMsg$PttRec.sttText.set(str);
                    d16 = q.d(-2002);
                    d16.msgtype = -2002;
                    d16.msgData = richMsg$PttRec.toByteArray();
                    ((MessageForPtt) d16).parse();
                    if (im_msg_body_tmpptt.uint64_msg_id.has() && im_msg_body_tmpptt.uint64_msg_id.get() != 0) {
                        d16.saveExtInfoToExtStr("pa_msgId", im_msg_body_tmpptt.uint64_msg_id.get() + "");
                    }
                    ConfessMsgUtil.l(msg_comm_msg, d16, messageHandler.Q);
                    com.tencent.qidian.util.b.d(abVar, msg_comm_msg, d16);
                    list.add(d16);
                    return;
                }
                i3 = 0;
                str = "";
                richMsg$PttRec.longPttVipFlag.set(h16);
                long currentTimeMillis2 = System.currentTimeMillis() / 1000;
                long j36 = msg_comm_msg.msg_head.msg_time.get();
                richMsg$PttRec.msgRecTime.set(currentTimeMillis2);
                richMsg$PttRec.msgTime.set(j36);
                richMsg$PttRec.voiceChangeFlag.set(i16);
                richMsg$PttRec.busiType.set(im_msg_body_tmpptt.uint32_busi_type.get());
                richMsg$PttRec.autototext_voice.set(i3);
                richMsg$PttRec.sttText.set(str);
                d16 = q.d(-2002);
                d16.msgtype = -2002;
                d16.msgData = richMsg$PttRec.toByteArray();
                ((MessageForPtt) d16).parse();
                if (im_msg_body_tmpptt.uint64_msg_id.has()) {
                    d16.saveExtInfoToExtStr("pa_msgId", im_msg_body_tmpptt.uint64_msg_id.get() + "");
                }
                ConfessMsgUtil.l(msg_comm_msg, d16, messageHandler.Q);
                com.tencent.qidian.util.b.d(abVar, msg_comm_msg, d16);
                list.add(d16);
                return;
            }
            return;
        }
        com.tencent.mobileqq.troop.data.c cVar = new com.tencent.mobileqq.troop.data.c();
        cVar.f294891a = String.valueOf(aVar.f286338a);
        p.g(messageHandler, list, msg_comm_msg, true, aVar.f286155j, cVar, abVar, aVar);
    }

    private void g(MessageHandler messageHandler, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        boolean z16;
        byte[] bArr;
        boolean z17;
        List<im_msg_body$Elem> list2;
        String str;
        int i3;
        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
        boolean z18 = true;
        if (msg_comm_msghead.msg_type.get() == 529 && msg_comm_msghead.c2c_cmd.get() == 6) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (msg_comm_msghead.c2c_tmp_msg_head.has() && msg_comm_msg.msg_body.has() && (z16 || msg_comm_msg.msg_body.get().rich_text.has())) {
            msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead = msg_comm_msghead.c2c_tmp_msg_head.get();
            int i16 = msg_comm_c2ctmpmsghead.c2c_type.get();
            int i17 = msg_comm_c2ctmpmsghead.service_type.get();
            if (i(messageHandler, abVar, aVar, msg_comm_c2ctmpmsghead)) {
                return;
            }
            if (!aVar.f286157l && msg_comm_c2ctmpmsghead.sig.has()) {
                bArr = msg_comm_c2ctmpmsghead.sig.get().toByteArray();
                if (QLog.isDevelopLevel()) {
                    if (bArr != null) {
                        str = HexUtil.bytes2HexStr(bArr);
                    } else {
                        str = "";
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("tempHead.sig.get()----> sig:");
                    sb5.append(str);
                    sb5.append(",length:");
                    if (bArr != null) {
                        i3 = bArr.length;
                    } else {
                        i3 = 0;
                    }
                    sb5.append(i3);
                    QLog.d("TempSessionDecoder", 4, sb5.toString());
                }
            } else {
                bArr = null;
            }
            if (bArr != null) {
                b(messageHandler, abVar, aVar, (byte) i16, (byte) i17, bArr);
            }
            if (msg_comm_msg.content_head.has() && msg_comm_msg.content_head.get().auto_reply.has()) {
                if (msg_comm_msg.content_head.get().auto_reply.get() != 1) {
                    z18 = false;
                }
                z17 = z18;
            } else {
                z17 = false;
            }
            if (!z16) {
                list2 = msg_comm_msg.msg_body.get().rich_text.get().elems.get();
            } else {
                list2 = null;
            }
            e(messageHandler, list, msg_comm_msg, abVar, aVar, z17, list2);
        }
    }

    private int h(im_msg_body$TmpPtt im_msg_body_tmpptt, int i3) {
        if (im_msg_body_tmpptt.uint32_user_type.has()) {
            int i16 = im_msg_body_tmpptt.uint32_user_type.get();
            if (i16 == 1 || i16 == 2) {
                return i16;
            }
            return i3;
        }
        return i3;
    }

    private boolean i(MessageHandler messageHandler, ab abVar, com.tencent.mobileqq.service.message.a aVar, msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead) {
        if (!aVar.f286157l && abVar.f286173a == 1006) {
            String str = msg_comm_c2ctmpmsghead.from_phone.get();
            if (msg_comm_c2ctmpmsghead.from_phone.has() && str != null && !str.equals("+0")) {
                ac.c(messageHandler.Q, msg_comm_c2ctmpmsghead.from_phone.get(), aVar.f286338a + "");
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("TempSessionDecoder", 2, "<---decodeC2CMsgPkg_Temp2 : contact fromPhoneNum error : " + msg_comm_c2ctmpmsghead.from_phone.get());
                return true;
            }
            return true;
        }
        return false;
    }

    public static ab j(msg_comm$Msg msg_comm_msg, QQAppInterface qQAppInterface) {
        ab abVar = new ab();
        msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead = msg_comm_msg.msg_head.get().c2c_tmp_msg_head.get();
        l(msg_comm_c2ctmpmsghead);
        abVar.f286176d = msg_comm_c2ctmpmsghead.direction_flag.get();
        int i3 = msg_comm_c2ctmpmsghead.c2c_type.get();
        int i16 = msg_comm_c2ctmpmsghead.service_type.get();
        abVar.f286173a = o(msg_comm_msg, -1, i16);
        abVar.f286174b = -1L;
        abVar.f286175c = -1L;
        n(abVar, msg_comm_c2ctmpmsghead, i16);
        m(abVar, i3, i16);
        return abVar;
    }

    private static int k(int i3, int i16) {
        if (i16 != 133) {
            if (i16 != 137) {
                if (i16 != 144) {
                    if (i16 != 149) {
                        if (i16 != 153) {
                            if (i16 != 156) {
                                if (i16 != 160) {
                                    if (i16 != 161) {
                                        if (i16 != 172) {
                                            if (i16 != 173) {
                                                switch (i16) {
                                                    case 163:
                                                        return 1044;
                                                    case 164:
                                                        return 10007;
                                                    case 165:
                                                        return 10008;
                                                    case 166:
                                                        return 1045;
                                                    case 167:
                                                        return 10010;
                                                    default:
                                                        return i3;
                                                }
                                            }
                                            return 10019;
                                        }
                                        return 1046;
                                    }
                                    return 1038;
                                }
                                return 1036;
                            }
                            return 1032;
                        }
                        return 10004;
                    }
                    return 10002;
                }
                return AppConstants.VALUE.UIN_TYPE_DINGDONG_MSG_SESSION;
            }
            return 1010;
        }
        return 1023;
    }

    private static void l(msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead) {
        if (!msg_comm_c2ctmpmsghead.c2c_type.has()) {
            if (QLog.isColorLevel()) {
                QLog.e("TempSessionDecoder", 2, "It doesn't has a c2cType.");
            }
        } else if (!msg_comm_c2ctmpmsghead.service_type.has() && QLog.isColorLevel()) {
            QLog.e("TempSessionDecoder", 2, "Invalid service type, the pb data has no service type.");
        }
    }

    private static void m(ab abVar, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("TempSessionDecoder", 2, "<---getC2CMsgPkgTempInfo: dump info: c2cType:" + i3 + " serviceType:" + i16 + "direction_flag:" + abVar.f286176d + " info:" + abVar.toString());
        }
    }

    private static void n(ab abVar, msg_comm$C2CTmpMsgHead msg_comm_c2ctmpmsghead, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 132) {
                    return;
                }
            } else {
                abVar.f286174b = msg_comm_c2ctmpmsghead.group_code.get();
                abVar.f286175c = msg_comm_c2ctmpmsghead.group_code.get();
                return;
            }
        }
        abVar.f286174b = msg_comm_c2ctmpmsghead.group_code.get();
        abVar.f286175c = msg_comm_c2ctmpmsghead.group_uin.get();
    }

    private static int o(msg_comm$Msg msg_comm_msg, int i3, int i16) {
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 58) {
                    if (i16 != 121) {
                        if (i16 != 124) {
                            if (i16 != 134) {
                                if (i16 != 140 && i16 != 142) {
                                    if (i16 != 201) {
                                        switch (i16) {
                                            case 129:
                                                break;
                                            case 130:
                                                return 1006;
                                            case 131:
                                                return 1009;
                                            case 132:
                                                return 1020;
                                            default:
                                                return k(i3, i16);
                                        }
                                    } else {
                                        return 1005;
                                    }
                                }
                                return 1008;
                            }
                            return 1022;
                        }
                        return 1001;
                    }
                    return 1021;
                }
                if (!nx.a.b(BaseApplication.getContext(), String.valueOf(msg_comm_msg.msg_head.from_uin.get())) && !nx.a.b(BaseApplication.getContext(), String.valueOf(msg_comm_msg.msg_head.to_uin.get()))) {
                    return 1024;
                }
                return 1025;
            }
            return 1004;
        }
        return 1000;
    }

    @Override // com.tencent.mobileqq.service.message.codec.decoder.d
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(MessageHandler messageHandler, msg_comm$Msg msg_comm_msg, List<MessageRecord> list, com.tencent.mobileqq.service.message.a aVar) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, messageHandler, msg_comm_msg, list, aVar);
            return;
        }
        ab j3 = j(msg_comm_msg, messageHandler.Q);
        int i16 = j3.f286173a;
        if (i16 == -1) {
            z16 = false;
        } else if (i16 == 1000 || i16 == 1020 || i16 == 1004) {
            aVar.f286149d = j3.f286175c;
        }
        if (z16) {
            aVar.f286164s = j3.f286176d;
            g(messageHandler, list, msg_comm_msg, j3, aVar);
            aVar.f286163r = j3.f286173a;
        }
        if (list.size() > 0 && ConfessMsgUtil.s(list.get(0))) {
            if (list.get(0).isSelfConfessor()) {
                i3 = 1033;
            } else {
                i3 = 1034;
            }
            j3.f286173a = i3;
            aVar.f286163r = i3;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TempSessionDecoder", 2, "friendType:" + aVar.f286163r + ", direction_flag:" + aVar.f286164s);
        }
    }

    private void c(MessageHandler messageHandler, ab abVar, com.tencent.mobileqq.service.message.a aVar, byte b16, byte b17, byte[] bArr) {
    }
}

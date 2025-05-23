package com.tencent.mobileqq.msgbackup.data;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.anonymous.a;
import com.tencent.imcore.message.ad;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$ContentHead;
import msf.msgcomm.msg_comm$DiscussInfo;
import msf.msgcomm.msg_comm$GroupInfo;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.msg.im_msg_body$AnonymousGroupMsg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$ElemFlags2;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e extends BaseProxy {
    static IPatchRedirector $redirector_;

    public e(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
        }
    }

    private static void a(QQAppInterface qQAppInterface, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, msg_comm$MsgHead msg_comm_msghead, int i3, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        int i16 = msg_comm_msghead.c2c_cmd.get();
        if (i3 == 529 && i16 == 4) {
            qQAppInterface.getFileManagerEngine().R().c(arrayList, msg_comm_msg.msg_body.get().msg_content.get(), msg_comm_msg);
        } else if (i16 == 175 || i16 == 11) {
            p.f(messageHandler, arrayList, msg_comm_msg, true, false, cVar);
        }
    }

    private static void b(QQAppInterface qQAppInterface, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        if (!qQAppInterface.getFileManagerEngine().R().d(arrayList, msg_comm_msg)) {
            p.f(messageHandler, arrayList, msg_comm_msg, false, false, cVar);
        }
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
        if (im_msg_body_msgbody.rich_text.has() && im_msg_body_msgbody.rich_text.get().ptt.has()) {
            new com.tencent.mobileqq.service.message.codec.decoder.f().a(messageHandler, msg_comm_msg, arrayList, null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void c(QQAppInterface qQAppInterface, msg_comm$Msg msg_comm_msg, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList, com.tencent.mobileqq.troop.data.c cVar) {
        String str;
        Iterator<MessageRecord> it;
        String str2;
        if (!qQAppInterface.getFileManagerEngine().R().f(arrayList, msg_comm_msg)) {
            p.f(messageHandler, arrayList, msg_comm_msg, false, false, cVar);
        }
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
        if (im_msg_body_msgbody.rich_text.has()) {
            im_msg_body$RichText im_msg_body_richtext = im_msg_body_msgbody.rich_text.get();
            if (im_msg_body_richtext.elems.has()) {
                List<im_msg_body$Elem> list = im_msg_body_richtext.elems.get();
                if (list != null) {
                    Iterator<im_msg_body$Elem> it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        im_msg_body$Elem next = it5.next();
                        if (next.anon_group_msg.has()) {
                            im_msg_body$AnonymousGroupMsg im_msg_body_anonymousgroupmsg = next.anon_group_msg.get();
                            int i3 = im_msg_body_anonymousgroupmsg.uint32_flags.get();
                            byte[] byteArray = im_msg_body_anonymousgroupmsg.str_anon_id.get().toByteArray();
                            byte[] byteArray2 = im_msg_body_anonymousgroupmsg.str_anon_nick.get().toByteArray();
                            int i16 = im_msg_body_anonymousgroupmsg.uint32_head_portrait.get();
                            int i17 = im_msg_body_anonymousgroupmsg.uint32_expire_time.get();
                            String stringUtf8 = im_msg_body_anonymousgroupmsg.str_rank_color.get().toStringUtf8();
                            if (byteArray != null) {
                                try {
                                    str = new String(byteArray, "ISO-8859-1");
                                } catch (UnsupportedEncodingException e16) {
                                    e16.printStackTrace();
                                }
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                    MessageRecord next2 = it.next();
                                    if (byteArray2 == null) {
                                        str2 = "";
                                    } else {
                                        str2 = new String(byteArray2);
                                    }
                                    next2.saveExtInfoToExtStr("anonymous", com.tencent.biz.anonymous.a.i(i3, str, str2, i16, i17, stringUtf8));
                                    next2.extLong |= 3;
                                    str = str;
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i3);
                                }
                            }
                            str = "";
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                            }
                            if (QLog.isColorLevel()) {
                            }
                        }
                    }
                }
                if (im_msg_body_richtext.ptt.has()) {
                    new com.tencent.mobileqq.service.message.codec.decoder.f().a(messageHandler, msg_comm_msg, arrayList, null);
                }
            }
        }
    }

    public static long d(long j3, long j16, long j17) {
        if (j16 == j3) {
            return j17;
        }
        return j16;
    }

    public static long e(long j3, long j16, long j17) {
        if (j17 != j16) {
            return j17;
        }
        return j3;
    }

    public static im_msg_body$MsgBody f(MessageRecord messageRecord, QQAppInterface qQAppInterface) {
        im_msg_body$RichText h16;
        int i3 = messageRecord.msgtype;
        if (i3 != -1000 && i3 != -10000 && i3 != -7014) {
            if (i3 == -1049) {
                h16 = p.z((MessageForReplyText) messageRecord);
            } else {
                if (i3 == -2005) {
                    return qQAppInterface.getFileManagerEngine().R().g(2, messageRecord);
                }
                if (i3 == -2017) {
                    return qQAppInterface.getFileManagerEngine().R().g(2, messageRecord);
                }
                if (i3 == -2000) {
                    h16 = p.t((MessageForPic) messageRecord);
                } else if (i3 == -5008) {
                    h16 = p.l((MessageForArkApp) messageRecord, true);
                } else if (i3 == -5016) {
                    h16 = p.m((MessageForArkBabyqReply) messageRecord, true);
                } else if (i3 == -5017) {
                    h16 = p.o((MessageForArkApp) messageRecord, true);
                } else if (i3 == -5013) {
                    h16 = p.n((MessageForArkFlashChat) messageRecord);
                } else if (i3 == -2011) {
                    h16 = p.y((MessageForStructing) messageRecord);
                    if (h16 == null) {
                        return null;
                    }
                } else if (i3 == -1035) {
                    h16 = p.s((MessageForMixedMsg) messageRecord);
                } else if (i3 == -1051) {
                    h16 = p.q((MessageForLongTextMsg) messageRecord, false);
                } else if (i3 == -2022) {
                    h16 = ((MessageForRichText) messageRecord).richText;
                } else if (i3 == -2002) {
                    h16 = ((MessageForRichText) messageRecord).richText;
                } else if (i3 == -2007) {
                    h16 = p.r((MessageForMarketFace) messageRecord);
                } else if (i3 == -2059) {
                    if (!TextUtils.isEmpty(messageRecord.f203106msg)) {
                        h16 = new im_msg_body$RichText();
                        im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                        im_msg_body$Text im_msg_body_text = new im_msg_body$Text();
                        im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8(messageRecord.f203106msg));
                        im_msg_body_elem.text.set(im_msg_body_text);
                        h16.elems.add(im_msg_body_elem);
                    }
                    h16 = null;
                } else {
                    if (i3 == -8018) {
                        h16 = p.k((MessageForAniSticker) messageRecord);
                    }
                    h16 = null;
                }
            }
        } else {
            h16 = h(messageRecord, messageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"));
        }
        i(messageRecord, h16);
        g(messageRecord, h16);
        im_msg_body$MsgBody im_msg_body_msgbody = new im_msg_body$MsgBody();
        if (h16 != null) {
            im_msg_body_msgbody.rich_text.set(h16);
        }
        return im_msg_body_msgbody;
    }

    private static void g(MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext) {
        if (im_msg_body_richtext != null && com.tencent.biz.anonymous.a.m(messageRecord)) {
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body$AnonymousGroupMsg im_msg_body_anonymousgroupmsg = new im_msg_body$AnonymousGroupMsg();
            a.C0789a e16 = com.tencent.biz.anonymous.a.e(messageRecord);
            im_msg_body_anonymousgroupmsg.uint32_flags.set(e16.f78365a);
            if (!TextUtils.isEmpty(e16.f78366b)) {
                im_msg_body_anonymousgroupmsg.str_anon_id.set(ByteStringMicro.copyFrom(e16.f78366b.getBytes()));
            }
            if (!TextUtils.isEmpty(e16.f78367c)) {
                im_msg_body_anonymousgroupmsg.str_anon_nick.set(ByteStringMicro.copyFrom(e16.f78367c.getBytes()));
            }
            im_msg_body_anonymousgroupmsg.uint32_head_portrait.set(e16.f78368d);
            im_msg_body_anonymousgroupmsg.uint32_expire_time.set(e16.f78369e);
            if (!TextUtils.isEmpty(e16.f78370f)) {
                im_msg_body_anonymousgroupmsg.str_rank_color.set(ByteStringMicro.copyFrom(e16.f78370f.getBytes()));
            }
            im_msg_body_anonymousgroupmsg.uint32_bubble_id.set((int) messageRecord.vipBubbleID);
            im_msg_body_elem.anon_group_msg.set(im_msg_body_anonymousgroupmsg);
            if (QLog.isColorLevel()) {
                QLog.d("anonymous_decode", 2, "anonymous_addd anon_group_msg = ");
            }
            im_msg_body_richtext.elems.add(im_msg_body_elem);
        }
    }

    private static im_msg_body$RichText h(MessageRecord messageRecord, String str) {
        if (!TextUtils.isEmpty(str)) {
            return p.C(messageRecord);
        }
        return p.A((MessageForText) messageRecord);
    }

    private static void i(MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext) {
        if (im_msg_body_richtext != null) {
            im_msg_body$ElemFlags2 im_msg_body_elemflags2 = new im_msg_body$ElemFlags2();
            im_msg_body_elemflags2.uint32_color_text_id.set((int) (messageRecord.vipBubbleID & 4294967295L));
            im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
            im_msg_body_elem.elem_flags2.set(im_msg_body_elemflags2);
            im_msg_body_richtext.elems.add(im_msg_body_elem);
        }
    }

    public static msg_comm$MsgHead j(MessageRecord messageRecord, long j3, boolean z16) {
        msg_comm$MsgHead msg_comm_msghead = new msg_comm$MsgHead();
        try {
            long longValue = Long.valueOf(ad.k(messageRecord)).longValue();
            long longValue2 = Long.valueOf(messageRecord.frienduin).longValue();
            msg_comm_msghead.from_uin.set(longValue);
            msg_comm_msghead.to_uin.set(longValue2);
            msg_comm_msghead.is_src_msg.set(messageRecord.isReplySource);
            msg_comm_msghead.msg_seq.set((int) messageRecord.shmsgseq);
            msg_comm_msghead.msg_time.set((int) messageRecord.time);
            msg_comm_msghead.msg_uid.set(Long.valueOf(messageRecord.msgUid).longValue());
            int i3 = messageRecord.istroop;
            if (i3 != 0 && i3 != 6000 && i3 != 6003 && i3 != 1000 && i3 != 1004 && i3 != 1022 && (!z16 || !ao.t(i3, messageRecord.frienduin) || ao.u(messageRecord.istroop))) {
                int i16 = messageRecord.istroop;
                if (i16 == 3000) {
                    msg_comm_msghead.msg_type.set(83);
                    msg_comm$DiscussInfo msg_comm_discussinfo = new msg_comm$DiscussInfo();
                    msg_comm_discussinfo.discuss_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
                    msg_comm_msghead.discuss_info.set(msg_comm_discussinfo);
                } else if (i16 == 1) {
                    msg_comm_msghead.msg_type.set(82);
                    msg_comm$GroupInfo msg_comm_groupinfo = new msg_comm$GroupInfo();
                    msg_comm_groupinfo.group_code.set(Long.valueOf(messageRecord.frienduin).longValue());
                    msg_comm_msghead.group_info.set(msg_comm_groupinfo);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup_msgproxy", 2, "getMultiMsgHead, error:mr is not a C2C/dis/troop msg. istroop=" + messageRecord.istroop);
                    }
                    return null;
                }
                return msg_comm_msghead;
            }
            msg_comm_msghead.to_uin.set(e(j3, longValue, longValue2));
            if (longValue != longValue2 && messageRecord.istroop == 1006) {
                msg_comm_msghead.from_uin.set(j3);
            }
            if (messageRecord instanceof MessageForPtt) {
                msg_comm_msghead.msg_type.set(208);
            } else if (messageRecord instanceof MessageForFile) {
                msg_comm_msghead.msg_type.set(529);
            } else {
                msg_comm_msghead.msg_type.set(9);
            }
            if (!(messageRecord instanceof MessageForText) && !(messageRecord instanceof MessageForStructing)) {
                if (messageRecord instanceof MessageForFile) {
                    msg_comm_msghead.c2c_cmd.set(4);
                } else {
                    msg_comm_msghead.c2c_cmd.set(175);
                }
                return msg_comm_msghead;
            }
            msg_comm_msghead.c2c_cmd.set(11);
            return msg_comm_msghead;
        } catch (Exception e16) {
            QLog.e("MsgBackup_msgproxy", 1, e16, new Object[0]);
            return null;
        }
    }

    public static byte[] k(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        im_msg_body$MsgBody im_msg_body_msgbody;
        msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
        msg_comm$MsgHead j3 = j(messageRecord, qQAppInterface.getLongAccountUin(), false);
        try {
            im_msg_body_msgbody = f(messageRecord, qQAppInterface);
        } catch (Throwable th5) {
            QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + messageRecord.getClass().getSimpleName());
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(th5, "MsgBackup_msgproxy,mr = " + messageRecord.getClass().getSimpleName());
            im_msg_body_msgbody = null;
        }
        if (j3 == null || im_msg_body_msgbody == null) {
            return null;
        }
        msg_comm_msg.msg_head.set(j3);
        msg_comm_msg.msg_body.set(im_msg_body_msgbody);
        return msg_comm_msg.toByteArray();
    }

    private static long m(@NonNull QQAppInterface qQAppInterface, msg_comm$Msg msg_comm_msg, msg_comm$MsgHead msg_comm_msghead, long j3, long j16, int i3, com.tencent.mobileqq.troop.data.c cVar, long j17, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        if ((s.i(i3) || i3 == 208 || i3 == 529) && msg_comm_msghead.c2c_cmd.has()) {
            long d16 = d(qQAppInterface.getLongAccountUin(), j3, j16);
            a(qQAppInterface, msg_comm_msg, cVar, msg_comm_msghead, i3, messageHandler, arrayList);
            if (i3 == 208) {
                new com.tencent.mobileqq.service.message.codec.decoder.i().a(messageHandler, msg_comm_msg, arrayList, null);
            }
            return d16;
        }
        if ((i3 == 82 || i3 == 43) && msg_comm_msghead.group_info.has()) {
            long j18 = msg_comm_msghead.group_info.group_code.get();
            c(qQAppInterface, msg_comm_msg, messageHandler, arrayList, cVar);
            return j18;
        }
        if ((i3 == 83 || i3 == 42) && msg_comm_msghead.discuss_info.has()) {
            long j19 = msg_comm_msghead.discuss_info.discuss_uin.get();
            b(qQAppInterface, msg_comm_msg, cVar, messageHandler, arrayList);
            return j19;
        }
        return j17;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0155 A[Catch: Exception -> 0x018a, TryCatch #0 {Exception -> 0x018a, blocks: (B:3:0x0007, B:5:0x008a, B:6:0x00a8, B:7:0x00ac, B:9:0x00b2, B:11:0x00f0, B:12:0x00f6, B:15:0x0101, B:25:0x0117, B:27:0x0125, B:28:0x013e, B:29:0x0151, B:31:0x0155, B:33:0x0159, B:35:0x015f, B:38:0x012a, B:40:0x0136, B:41:0x013b, B:42:0x0141, B:43:0x014a, B:46:0x017d), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015f A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static MessageRecord n(@NonNull QQAppInterface qQAppInterface, @NonNull byte[] bArr) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str;
        msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
        try {
            msg_comm_msg.mergeFrom(bArr);
            msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
            long j3 = msg_comm_msghead.from_uin.get();
            long j16 = msg_comm_msghead.to_uin.get();
            long j17 = msg_comm_msghead.msg_seq.get();
            long j18 = msg_comm_msghead.msg_time.get();
            long j19 = msg_comm_msghead.msg_uid.get();
            int i26 = msg_comm_msghead.msg_type.get();
            boolean z16 = msg_comm_msghead.is_src_msg.get();
            com.tencent.mobileqq.troop.data.c cVar = new com.tencent.mobileqq.troop.data.c();
            MessageHandler msgHandler = qQAppInterface.getMsgHandler();
            long c16 = com.tencent.imcore.message.p.c(msgHandler, msg_comm_msg, String.valueOf(j16), String.valueOf(j3));
            ArrayList arrayList = new ArrayList();
            long j26 = c16;
            int i27 = i26;
            boolean z17 = z16;
            long j27 = j19;
            long j28 = j18;
            long j29 = j17;
            long m3 = m(qQAppInterface, msg_comm_msg, msg_comm_msghead, j3, j16, i27, cVar, 0L, msgHandler, arrayList);
            int a16 = com.tencent.imcore.message.p.a(msg_comm_msg);
            if (msg_comm_msg.content_head.has()) {
                msg_comm$ContentHead msg_comm_contenthead = msg_comm_msg.content_head.get();
                i16 = msg_comm_contenthead.div_seq.get();
                i17 = msg_comm_contenthead.pkg_num.get();
                i3 = msg_comm_contenthead.pkg_index.get();
            } else {
                i3 = 0;
                i16 = 0;
                i17 = 0;
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                MessageRecord messageRecord = (MessageRecord) it.next();
                messageRecord.isReplySource = z17;
                long j36 = j28;
                messageRecord.time = j36;
                long j37 = j29;
                messageRecord.shmsgseq = j37;
                int i28 = i17;
                long j38 = j27;
                messageRecord.msgUid = j38;
                messageRecord.selfuin = qQAppInterface.getCurrentAccountUin();
                messageRecord.senderuin = String.valueOf(j3);
                messageRecord.frienduin = String.valueOf(m3);
                messageRecord.vipBubbleDiyTextId = a16;
                long j39 = m3;
                long j46 = j26;
                j26 = j46;
                messageRecord.vipBubbleID = SVIPHandlerConstants.mixedBubbleAndTextId((int) j46, a16);
                messageRecord.isread = true;
                if (i28 > 1) {
                    messageRecord.longMsgCount = i28;
                    messageRecord.longMsgId = i16;
                    messageRecord.longMsgIndex = i3;
                }
                if (j3 == qQAppInterface.getLongAccountUin()) {
                    i18 = 2;
                } else {
                    i18 = 0;
                }
                messageRecord.issend = i18;
                int i29 = i27;
                if (i29 != 82 && i29 != 43) {
                    if (i29 != 83 && i29 != 42) {
                        i19 = i3;
                        if (AppConstants.DATALINE_PC_UIN.equals(Long.valueOf(j16))) {
                            messageRecord.istroop = 6000;
                        } else if (AppConstants.DATALINE_IPAD_UIN.equals(Long.valueOf(j16))) {
                            messageRecord.istroop = 6003;
                        } else {
                            messageRecord.istroop = 0;
                        }
                        messageRecord.msgseq = j37;
                        if (messageRecord.msgData != null && (str = messageRecord.f203106msg) != null) {
                            messageRecord.msgData = str.getBytes();
                        }
                        messageRecord.msgBackupMsgSeq = j37;
                        messageRecord.msgBackupMsgRandom = s.g(j38);
                        i27 = i29;
                        j28 = j36;
                        j29 = j37;
                        z17 = z17;
                        i3 = i19;
                        i17 = i28;
                        m3 = j39;
                        j27 = j38;
                    }
                    i19 = i3;
                    messageRecord.istroop = 3000;
                    messageRecord.shmsgseq = j37;
                    if (messageRecord.msgData != null) {
                        messageRecord.msgData = str.getBytes();
                    }
                    messageRecord.msgBackupMsgSeq = j37;
                    messageRecord.msgBackupMsgRandom = s.g(j38);
                    i27 = i29;
                    j28 = j36;
                    j29 = j37;
                    z17 = z17;
                    i3 = i19;
                    i17 = i28;
                    m3 = j39;
                    j27 = j38;
                }
                i19 = i3;
                messageRecord.istroop = 1;
                messageRecord.shmsgseq = j37;
                if (messageRecord.msgData != null) {
                }
                messageRecord.msgBackupMsgSeq = j37;
                messageRecord.msgBackupMsgRandom = s.g(j38);
                i27 = i29;
                j28 = j36;
                j29 = j37;
                z17 = z17;
                i3 = i19;
                i17 = i28;
                m3 = j39;
                j27 = j38;
            }
            BaseMessageHandlerUtils.blankMsgFilter(arrayList);
            return (MessageRecord) arrayList.get(0);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup_msgproxy", 2, "transToMessageRecord, error happens :" + e16);
            }
            return null;
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public MsgBackupMsgEntity l(@NonNull MessageRecord messageRecord, boolean z16) {
        im_msg_body$MsgBody im_msg_body_msgbody;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MsgBackupMsgEntity) iPatchRedirector.redirect((short) 5, this, messageRecord, Boolean.valueOf(z16));
        }
        if (messageRecord == null) {
            return null;
        }
        if (messageRecord.istroop == 1 && messageRecord.shmsgseq == 0) {
            QLog.e("MsgBackup_msgproxy", 1, "troopMsg msgshseq = 0,mr  == " + messageRecord.getUserLogString());
        }
        msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
        if (messageRecord.isLongMsg()) {
            msg_comm$ContentHead msg_comm_contenthead = new msg_comm$ContentHead();
            msg_comm_contenthead.pkg_num.set(messageRecord.longMsgCount);
            msg_comm_contenthead.div_seq.set(messageRecord.longMsgId);
            msg_comm_contenthead.pkg_index.set(messageRecord.longMsgIndex);
            msg_comm_msg.content_head.set(msg_comm_contenthead);
        }
        if (z16 && messageRecord.msgtype == -10000) {
            msg_comm$ContentHead msg_comm_contenthead2 = new msg_comm$ContentHead();
            msg_comm_contenthead2.auto_reply.set(1);
            msg_comm_msg.content_head.set(msg_comm_contenthead2);
        }
        msg_comm$MsgHead j3 = j(messageRecord, this.app.getLongAccountUin(), z16);
        try {
            im_msg_body_msgbody = f(messageRecord, (QQAppInterface) this.app);
        } catch (Throwable th5) {
            QLog.e("MsgBackup_msgproxy", 1, "transToBackupEntity,getMsgBody error mr = " + messageRecord.getClass().getSimpleName());
            com.tencent.qqperf.monitor.crash.catchedexception.a.c(th5, "MsgBackup_msgproxy,mr = " + messageRecord.getClass().getSimpleName());
            im_msg_body_msgbody = null;
        }
        if (j3 != null && im_msg_body_msgbody != null) {
            msg_comm_msg.msg_head.set(j3);
            msg_comm_msg.msg_body.set(im_msg_body_msgbody);
            MsgBackupMsgEntity msgBackupMsgEntity = new MsgBackupMsgEntity();
            msgBackupMsgEntity.chatUin = messageRecord.frienduin;
            msgBackupMsgEntity.chatType = com.tencent.mobileqq.msgbackup.util.f.q(messageRecord.istroop);
            msgBackupMsgEntity.msgType = com.tencent.mobileqq.msgbackup.util.f.u(messageRecord.msgtype);
            msgBackupMsgEntity.msgTime = messageRecord.time;
            msgBackupMsgEntity.msgSeq = messageRecord.msgseq;
            int i3 = messageRecord.istroop;
            if (i3 != 1 && i3 != 3000) {
                int g16 = s.g(messageRecord.msgUid);
                msgBackupMsgEntity.msgSeq = ((short) messageRecord.shmsgseq) & 65535;
                msgBackupMsgEntity.msgRandom = g16;
            } else {
                msgBackupMsgEntity.msgSeq = messageRecord.shmsgseq;
            }
            if (com.tencent.mobileqq.msgbackup.util.f.f251424d) {
                int serializedSize = msg_comm_msg.getSerializedSize();
                byte[] b16 = com.tencent.mobileqq.msgbackup.controller.h.b(serializedSize);
                if (b16 == null) {
                    b16 = msg_comm_msg.toByteArray();
                    com.tencent.mobileqq.msgbackup.controller.h.c(b16);
                } else {
                    msg_comm_msg.toByteArray(b16, 0, serializedSize);
                }
                msgBackupMsgEntity.extensionData = b16;
            } else {
                msgBackupMsgEntity.extensionData = msg_comm_msg.toByteArray();
            }
            return msgBackupMsgEntity;
        }
        com.tencent.mobileqq.msgbackup.util.f.D("transBackupEntity error,mr = %s ", messageRecord.toString(), new Object[0]);
        return null;
    }

    public MessageRecord o(@NonNull Object obj) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 4, (Object) this, obj);
        }
        if (obj == null || (bArr = ((MsgBackupMsgEntity) obj).extensionData) == null) {
            return null;
        }
        return n((QQAppInterface) this.app, bArr);
    }
}

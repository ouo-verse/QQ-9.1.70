package com.tencent.mobileqq.app.message;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.anonymous.a;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseMessageHandlerUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.BaseProxy;
import com.tencent.mobileqq.app.proxy.BaseProxyManager;
import com.tencent.mobileqq.app.proxy.ProxyListener;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.IMultiMsgRecordOp;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForDLFile;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForLongTextMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.vas.svip.api.SVIPHandlerConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import msf.msgcomm.msg_comm$DiscussInfo;
import msf.msgcomm.msg_comm$GroupInfo;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import msf.msgcomm.msg_comm$MutilTransHead;
import msf.msgsvc.msgtransmit.msg_transmit$PbMultiMsgItem;
import msf.msgsvc.msgtransmit.msg_transmit$PbMultiMsgNew;
import msf.msgsvc.msgtransmit.msg_transmit$PbMultiMsgTransmit;
import org.jetbrains.annotations.Nullable;
import tencent.im.msg.im_msg_body$AnonymousGroupMsg;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$ElemFlags2;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.msg.im_msg_body$RichText;

@KeepClassConstructor
/* loaded from: classes11.dex */
public class MultiMsgProxy extends BaseProxy {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final Class[] f195861c;

    /* renamed from: a, reason: collision with root package name */
    com.tencent.mobileqq.persistence.g f195862a;

    /* renamed from: b, reason: collision with root package name */
    private Object f195863b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70341);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 30)) {
            redirector.redirect((short) 30);
        } else {
            f195861c = new Class[]{MessageForText.class, MessageForPic.class, MessageForMixedMsg.class, MessageForLongMsg.class, MessageForShortVideo.class, MessageForReplyText.class, MessageForTroopFile.class, MessageForArkApp.class, MessageForArkFlashChat.class, MessageRecordForMarkdown.class};
        }
    }

    public MultiMsgProxy(QQAppInterface qQAppInterface, BaseProxyManager baseProxyManager) {
        super(qQAppInterface, baseProxyManager);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface, (Object) baseProxyManager);
        } else {
            this.f195862a = null;
            this.f195863b = new Object();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A(MessageRecord messageRecord, HashMap<String, ArrayList<MessageRecord>> hashMap, HashMap<String, ArrayList<MessageRecord>> hashMap2, int i3, ProxyListener proxyListener, boolean z16, boolean z17, ArrayList<MessageRecord> arrayList) {
        ArrayList<? extends MessageRecord> arrayList2;
        ArrayList<MessageRecord> w3;
        String str;
        String str2;
        int i16;
        if (i3 > 3) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of max recurTime");
                return;
            }
            return;
        }
        if (messageRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "recursivePreAddMultiMsg return before of null structmsg");
                return;
            }
            return;
        }
        String p16 = p(i3, messageRecord);
        if (hashMap.containsKey(p16)) {
            ArrayList<? extends MessageRecord> arrayList3 = hashMap.get(p16);
            if (com.tencent.mobileqq.multimsg.i.k()) {
                Object[] objArr = new Object[2];
                if (arrayList3 != null) {
                    i16 = arrayList3.size();
                } else {
                    i16 = 0;
                }
                objArr[0] = Integer.valueOf(i16);
                objArr[1] = p16;
                QLog.d("MultiMsg_TAG", 1, String.format("recursivePreAddMultiMsg find list size:%d, filename:%s", objArr));
            }
            arrayList2 = arrayList3;
        } else {
            if (com.tencent.mobileqq.multimsg.i.k()) {
                QLog.d("MultiMsg_TAG", 1, String.format("recursivePreAddMultiMsg error filename:%s not found, recurTimes=%d", p16, Integer.valueOf(i3)));
            }
            arrayList2 = null;
        }
        if (arrayList2 != null && arrayList2.size() > 0 && (w3 = w(messageRecord, arrayList2, proxyListener, z16, z17, arrayList)) != null) {
            Iterator<MessageRecord> it = w3.iterator();
            while (it.hasNext()) {
                MessageRecord next = it.next();
                if (com.tencent.mobileqq.multimsg.i.m(next)) {
                    if (next instanceof IMultiMsgRecordOp) {
                        IMultiMsgRecordOp iMultiMsgRecordOp = (IMultiMsgRecordOp) next;
                        str = iMultiMsgRecordOp.getFilename();
                        str2 = String.valueOf(next.uniseq);
                        iMultiMsgRecordOp.updateFilename(str2);
                    } else {
                        str = "";
                        str2 = "";
                    }
                    N(next, null);
                    hashMap.put(str2, hashMap.remove(str));
                }
            }
            hashMap2.put(p16, w3);
            if (w3.size() > 0) {
                int i17 = 1 + i3;
                Iterator<MessageRecord> it5 = w3.iterator();
                while (it5.hasNext()) {
                    MessageRecord next2 = it5.next();
                    if (com.tencent.mobileqq.multimsg.i.m((ChatMessage) next2)) {
                        A(next2, hashMap, hashMap2, i17, proxyListener, z16, z17, arrayList);
                    }
                }
            }
        }
    }

    private void B(MessageRecord messageRecord, HashMap<String, ArrayList<MessageRecord>> hashMap, int i3) {
        if (i3 > 2) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of max recurTime");
                return;
            }
            return;
        }
        if (messageRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "recursiveQueryMultiMsg return before of null structmsg");
                return;
            }
            return;
        }
        ArrayList<MessageRecord> z16 = z(messageRecord.uniseq);
        if (z16 != null && z16.size() > 0) {
            hashMap.put(p(i3, messageRecord), z16);
            int i16 = i3 + 1;
            Iterator<MessageRecord> it = z16.iterator();
            while (it.hasNext()) {
                MessageRecord next = it.next();
                if (com.tencent.mobileqq.multimsg.i.m((ChatMessage) next)) {
                    if (i16 == 3) {
                        MessageRecord c16 = c(next, com.tencent.mobileqq.multimsg.g.f251615a, false);
                        c16.setStatus(1000);
                        c16.msgData = c16.f203106msg.getBytes();
                        z16.set(z16.indexOf(next), c16);
                    } else {
                        B(next, hashMap, i16);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, String.format("recursiveQueryMultiMsg need recur, uniseq:%d, recurTimes:%d", Long.valueOf(next.uniseq), Integer.valueOf(i16)));
                    }
                }
            }
        }
    }

    private void D(msg_comm$MutilTransHead msg_comm_mutiltranshead, MessageRecord messageRecord) {
        if (!com.tencent.mobileqq.multimsg.i.j((AppInterface) this.app)) {
            return;
        }
        if (msg_comm_mutiltranshead != null && messageRecord != null) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("friend_flag");
            String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("from_anno_id");
            String extInfoFromExtStr3 = messageRecord.getExtInfoFromExtStr("from_face_url");
            if (com.tencent.mobileqq.multimsg.i.n() && QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "MultiMsg:setMultiTransHeadAddInfo for send, get friendFlag:" + extInfoFromExtStr + ", fromAnnoId:" + extInfoFromExtStr2 + ", fromFaceUrl:" + extInfoFromExtStr3);
            }
            try {
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    msg_comm_mutiltranshead.friend_flag.set(Integer.valueOf(extInfoFromExtStr).intValue());
                }
                if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                    msg_comm_mutiltranshead.from_anno_id.set(extInfoFromExtStr2);
                }
                if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
                    msg_comm_mutiltranshead.from_face_url.set(extInfoFromExtStr3);
                    return;
                }
                return;
            } catch (Exception e16) {
                QLog.d("MultiMsg_TAG", 1, "MultiMsg:setMultiTransHeadAddInfo exception", e16);
                return;
            }
        }
        QLog.d("MultiMsg_TAG", 1, "MultiMsg:setMultiTransHeadAddInfo error, illegal args");
    }

    public static byte[] E(byte[] bArr) {
        StringBuilder sb5;
        if (bArr != null && bArr.length != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "ungzip:before unzip length:" + bArr.length);
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = null;
            try {
                try {
                    byte[] bArr3 = new byte[1024];
                    GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    while (true) {
                        int read = gZIPInputStream.read(bArr3, 0, 1024);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                    gZIPInputStream.close();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "ungzip:after unzip length:" + bArr2.length);
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e16) {
                        e = e16;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("ungzip: ungzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("MultiMsg_TAG", 2, sb5.toString());
                        }
                    }
                } catch (Exception e17) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "ungzip: ungzip throw error," + e17.getMessage());
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e18) {
                        e = e18;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("ungzip: ungzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("MultiMsg_TAG", 2, sb5.toString());
                        }
                    }
                } catch (OutOfMemoryError e19) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "ungzip: ungzip throw error," + e19.getMessage());
                    }
                    try {
                        byteArrayOutputStream.close();
                        byteArrayInputStream.close();
                    } catch (IOException e26) {
                        e = e26;
                        if (QLog.isColorLevel()) {
                            sb5 = new StringBuilder();
                            sb5.append("ungzip: ungzip throw ioexception,");
                            sb5.append(e.getMessage());
                            QLog.d("MultiMsg_TAG", 2, sb5.toString());
                        }
                    }
                }
                if (bArr2 != null) {
                    return bArr2;
                }
                return bArr;
            } catch (Throwable th5) {
                try {
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e27) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", 2, "ungzip: ungzip throw ioexception," + e27.getMessage());
                    }
                }
                throw th5;
            }
        }
        return new byte[0];
    }

    private MessageRecord G(MessageRecord messageRecord, msg_comm$MsgHead msg_comm_msghead, ArrayList<MessageRecord> arrayList, int i3, MessageRecord messageRecord2) {
        if (!com.tencent.mobileqq.receipt.a.g(messageRecord) && !com.tencent.mobileqq.multimsg.i.o((QQAppInterface) this.app, (ChatMessage) messageRecord2) && !(messageRecord2 instanceof MessageForArkApp)) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "not support multi forward msg! " + messageRecord2.toString());
            }
            MessageRecord d16 = q.d(-1000);
            d16.f203106msg = msg_comm_msghead.multi_compatible_text.get();
            arrayList.set(i3, d16);
            return d16;
        }
        return messageRecord2;
    }

    private void H(@NonNull HashMap<String, String> hashMap, com.tencent.mobileqq.troop.data.c cVar, msg_comm$Msg msg_comm_msg, msg_comm$MsgHead msg_comm_msghead, long j3, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        int i3 = msg_comm_msghead.c2c_cmd.get();
        if (i3 == 175 || i3 == 11) {
            if (msg_comm_msg.msg_body.get().msg_content.has()) {
                ((QQAppInterface) this.app).getFileManagerEngine().R().c(arrayList, msg_comm_msg.msg_body.get().msg_content.get(), msg_comm_msg);
            } else {
                com.tencent.mobileqq.service.message.p.f(messageHandler, arrayList, msg_comm_msg, true, false, cVar);
            }
        }
        if (msg_comm_msghead.from_nick.has()) {
            hashMap.put(String.valueOf(j3), msg_comm_msghead.from_nick.get());
        }
    }

    private void I(@NonNull HashMap<String, String> hashMap, com.tencent.mobileqq.troop.data.c cVar, msg_comm$Msg msg_comm_msg, msg_comm$MsgHead msg_comm_msghead, long j3, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        if (!((QQAppInterface) this.app).getFileManagerEngine().R().d(arrayList, msg_comm_msg)) {
            com.tencent.mobileqq.service.message.p.f(messageHandler, arrayList, msg_comm_msg, false, false, cVar);
        }
        if (msg_comm_msghead.discuss_info.discuss_remark.has()) {
            hashMap.put(String.valueOf(j3), msg_comm_msghead.discuss_info.discuss_remark.get().toStringUtf8());
        }
    }

    private long J(@NonNull HashMap<String, String> hashMap, com.tencent.mobileqq.troop.data.c cVar, msg_comm$Msg msg_comm_msg, msg_comm$MsgHead msg_comm_msghead, long j3, long j16, int i3, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        if (!s.i(i3) && i3 != 208) {
            if (i3 != 82 && i3 != 43) {
                if (i3 == 83 || i3 == 42) {
                    long j17 = msg_comm_msghead.discuss_info.discuss_uin.get();
                    I(hashMap, cVar, msg_comm_msg, msg_comm_msghead, j3, messageHandler, arrayList);
                    return j17;
                }
            } else {
                long j18 = msg_comm_msghead.group_info.group_code.get();
                K(hashMap, cVar, msg_comm_msg, msg_comm_msghead, j3, messageHandler, arrayList);
                return j18;
            }
        } else {
            H(hashMap, cVar, msg_comm_msg, msg_comm_msghead, j3, messageHandler, arrayList);
        }
        return j16;
    }

    private void K(@NonNull HashMap<String, String> hashMap, com.tencent.mobileqq.troop.data.c cVar, msg_comm$Msg msg_comm_msg, msg_comm$MsgHead msg_comm_msghead, long j3, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        if (!((QQAppInterface) this.app).getFileManagerEngine().R().f(arrayList, msg_comm_msg)) {
            com.tencent.mobileqq.service.message.p.f(messageHandler, arrayList, msg_comm_msg, false, false, cVar);
        }
        if (msg_comm_msghead.group_info.group_card.has()) {
            hashMap.put(String.valueOf(j3), msg_comm_msghead.group_info.group_card.get().toStringUtf8());
        }
    }

    private String d(msg_comm$Msg msg_comm_msg, HashMap<String, String> hashMap, com.tencent.mobileqq.troop.data.c cVar, msg_comm$MsgHead msg_comm_msghead, long j3, int i3, String str, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList, MessageRecord messageRecord) {
        String str2;
        int i16 = msg_comm_msghead.c2c_cmd.get();
        if (i3 == 529 && i16 == 4) {
            ((QQAppInterface) this.app).getFileManagerEngine().R().c(arrayList, msg_comm_msg.msg_body.get().msg_content.get(), msg_comm_msg);
        } else if (i16 == 175 || i16 == 11) {
            com.tencent.mobileqq.service.message.p.f(messageHandler, arrayList, msg_comm_msg, true, false, cVar);
        }
        if (msg_comm_msghead.from_nick.has() && hashMap != null) {
            str2 = msg_comm_msghead.from_nick.get();
            hashMap.put(String.valueOf(j3), msg_comm_msghead.from_nick.get());
        } else {
            str2 = str;
        }
        f(messageRecord, msg_comm_msg, messageHandler, arrayList);
        return str2;
    }

    private String e(msg_comm$Msg msg_comm_msg, HashMap<String, String> hashMap, MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar, msg_comm$MsgHead msg_comm_msghead, long j3, String str, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        String str2;
        msg_comm_msghead.discuss_info.discuss_uin.get();
        if (!((QQAppInterface) this.app).getFileManagerEngine().R().d(arrayList, msg_comm_msg)) {
            com.tencent.mobileqq.service.message.p.f(messageHandler, arrayList, msg_comm_msg, false, false, cVar);
        }
        if (msg_comm_msghead.discuss_info.discuss_remark.has() && hashMap != null) {
            str2 = msg_comm_msghead.discuss_info.discuss_remark.get().toStringUtf8();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(String.valueOf(j3), str2);
            }
        } else {
            str2 = str;
        }
        f(messageRecord, msg_comm_msg, messageHandler, arrayList);
        return str2;
    }

    private void f(MessageRecord messageRecord, msg_comm$Msg msg_comm_msg, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList) {
        AbsStructMsg absStructMsg;
        if ((messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null && absStructMsg.mMsgServiceID == 107) {
            int i3 = messageRecord.istroop;
            if (i3 != 1 && i3 != 3000) {
                new com.tencent.mobileqq.service.message.codec.decoder.i().a(messageHandler, msg_comm_msg, arrayList, null);
            } else {
                new com.tencent.mobileqq.service.message.codec.decoder.f().a(messageHandler, msg_comm_msg, arrayList, null);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String g(msg_comm$Msg msg_comm_msg, HashMap<String, String> hashMap, MessageRecord messageRecord, msg_comm$MsgHead msg_comm_msghead, long j3, String str, MessageHandler messageHandler, ArrayList<MessageRecord> arrayList, com.tencent.mobileqq.troop.data.c cVar) {
        MessageRecord messageRecord2;
        String str2;
        List<im_msg_body$Elem> list;
        String str3;
        Iterator<MessageRecord> it;
        String str4;
        if (!((QQAppInterface) this.app).getFileManagerEngine().R().f(arrayList, msg_comm_msg)) {
            com.tencent.mobileqq.service.message.p.f(messageHandler, arrayList, msg_comm_msg, false, false, cVar);
        }
        if (msg_comm_msghead.group_info.group_card.has() && hashMap != null) {
            str2 = msg_comm_msghead.group_info.group_card.get().toStringUtf8();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put(String.valueOf(j3), str2);
            }
            messageRecord2 = messageRecord;
        } else {
            messageRecord2 = messageRecord;
            str2 = str;
        }
        f(messageRecord2, msg_comm_msg, messageHandler, arrayList);
        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
        if (im_msg_body_msgbody.rich_text.has()) {
            im_msg_body$RichText im_msg_body_richtext = im_msg_body_msgbody.rich_text.get();
            if (im_msg_body_richtext.elems.has() && (list = im_msg_body_richtext.elems.get()) != null) {
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
                                str3 = new String(byteArray, "ISO-8859-1");
                            } catch (UnsupportedEncodingException e16) {
                                e16.printStackTrace();
                            }
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                                MessageRecord next2 = it.next();
                                if (byteArray2 == null) {
                                    str4 = "";
                                } else {
                                    str4 = new String(byteArray2);
                                }
                                next2.saveExtInfoToExtStr("anonymous", com.tencent.biz.anonymous.a.i(i3, str3, str4, i16, i17, stringUtf8));
                                next2.extLong |= 3;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("anonymous_decode", 2, "anonymous_flags has = " + i3);
                            }
                        }
                        str3 = "";
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                    }
                }
            }
        }
        return str2;
    }

    private com.tencent.mobileqq.persistence.g h() {
        com.tencent.mobileqq.persistence.g gVar = this.f195862a;
        if (gVar == null || !gVar.isOpen()) {
            synchronized (this.f195863b) {
                com.tencent.mobileqq.persistence.g gVar2 = this.f195862a;
                if (gVar2 == null || !gVar2.isOpen()) {
                    this.f195862a = (com.tencent.mobileqq.persistence.g) ((QQAppInterface) this.app).getEntityManagerFactory().a();
                }
            }
        }
        return this.f195862a;
    }

    private void j(MessageRecord messageRecord, im_msg_body$RichText im_msg_body_richtext) {
        if (com.tencent.biz.anonymous.a.m(messageRecord)) {
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

    private im_msg_body$RichText k(MessageRecord messageRecord) {
        String qqStr = HardCodeUtil.qqStr(R.string.f172207oc0);
        if (messageRecord instanceof MessageForFile) {
            qqStr = ((MessageForFile) messageRecord).getSummaryMsg();
        }
        return com.tencent.mobileqq.service.message.p.A((MessageForText) c(messageRecord, qqStr, false));
    }

    private im_msg_body$RichText l(MessageRecord messageRecord) {
        if (!TextUtils.isEmpty(messageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info"))) {
            return com.tencent.mobileqq.service.message.p.C(messageRecord);
        }
        return com.tencent.mobileqq.service.message.p.A((MessageForText) messageRecord);
    }

    @Nullable
    private im_msg_body$RichText m(MessageForStructing messageForStructing) {
        com.tencent.mobileqq.structmsg.view.e firstImageElement;
        im_msg_body$RichText y16 = com.tencent.mobileqq.service.message.p.y(messageForStructing);
        try {
            AbsStructMsg absStructMsg = messageForStructing.structingMsg;
            if (absStructMsg != null && (absStructMsg instanceof StructMsgForImageShare) && (firstImageElement = ((StructMsgForImageShare) absStructMsg).getFirstImageElement()) != null) {
                y16.elems.add(firstImageElement.f290638c1.richText.elems.get(0));
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, " packMultiMsg.structMsg.exception...");
            }
        }
        return y16;
    }

    private im_msg_body$RichText n(MessageRecord messageRecord) {
        String qqStr = HardCodeUtil.qqStr(R.string.oby);
        if (messageRecord instanceof MessageForTroopFile) {
            qqStr = ((MessageForTroopFile) messageRecord).getSummaryMsg();
        }
        return com.tencent.mobileqq.service.message.p.A((MessageForText) c(messageRecord, qqStr, false));
    }

    public static byte[] q(byte[] bArr) {
        StringBuilder sb5;
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "gzip:before zip length:" + bArr.length);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = null;
        try {
            try {
                byte[] bArr3 = new byte[1024];
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                while (true) {
                    int read = byteArrayInputStream.read(bArr3, 0, 1024);
                    if (read == -1) {
                        break;
                    }
                    gZIPOutputStream.write(bArr3, 0, read);
                }
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                bArr2 = byteArrayOutputStream.toByteArray();
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "gzip:after zip length:" + bArr2.length);
                }
                try {
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("gzip: gzip throw ioexception,");
                        sb5.append(e.getMessage());
                        QLog.d("MultiMsg_TAG", 2, sb5.toString());
                    }
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "gzip: gzip throw exception," + e17.getMessage());
                }
                try {
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e18) {
                    e = e18;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("gzip: gzip throw ioexception,");
                        sb5.append(e.getMessage());
                        QLog.d("MultiMsg_TAG", 2, sb5.toString());
                    }
                }
            } catch (OutOfMemoryError e19) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "gzip: gzip throw error," + e19.getMessage());
                }
                try {
                    byteArrayOutputStream.close();
                    byteArrayInputStream.close();
                } catch (IOException e26) {
                    e = e26;
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("gzip: gzip throw ioexception,");
                        sb5.append(e.getMessage());
                        QLog.d("MultiMsg_TAG", 2, sb5.toString());
                    }
                }
            }
            return bArr2;
        } catch (Throwable th5) {
            try {
                byteArrayOutputStream.close();
                byteArrayInputStream.close();
            } catch (IOException e27) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "gzip: gzip throw ioexception," + e27.getMessage());
                }
            }
            throw th5;
        }
    }

    public static boolean r(ChatMessage chatMessage) {
        if (MessageForStructing.class.isInstance(chatMessage)) {
            MessageForStructing messageForStructing = (MessageForStructing) chatMessage;
            if (StructMsgForImageShare.class.isInstance(messageForStructing.structingMsg) && ((StructMsgForImageShare) messageForStructing.structingMsg).getFirstImageElement() != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean C(HashMap<String, ArrayList<MessageRecord>> hashMap, MessageRecord messageRecord) {
        boolean z16;
        MessageRecord sourceMessage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this, (Object) hashMap, (Object) messageRecord)).booleanValue();
        }
        if (hashMap == null || hashMap.size() <= 0) {
            return false;
        }
        Iterator<String> it = hashMap.keySet().iterator();
        boolean z17 = false;
        while (it.hasNext()) {
            ArrayList<MessageRecord> arrayList = hashMap.get(it.next());
            Iterator<MessageRecord> it5 = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (it5.hasNext()) {
                    MessageRecord next = it5.next();
                    z16 = true;
                    if (((next instanceof MessageForReplyText) && (sourceMessage = ((MessageForReplyText) next).getSourceMessage()) != null && (((sourceMessage instanceof MessageForPic) || (sourceMessage instanceof MessageForShortVideo)) && sourceMessage.uniseq == messageRecord.uniseq)) || next.uniseq == messageRecord.uniseq) {
                        break;
                    }
                    i3++;
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                if (arrayList.get(i3) instanceof MessageForReplyText) {
                    ((MessageForReplyText) arrayList.get(i3)).setSourceMessageRecord(messageRecord);
                } else {
                    arrayList.set(i3, messageRecord);
                }
                return z16;
            }
            z17 = z16;
        }
        return z17;
    }

    public ArrayList<MessageRecord> F(msg_comm$Msg msg_comm_msg, HashMap<String, String> hashMap, MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar) {
        String str;
        String str2;
        long j3;
        long j16;
        long j17;
        String d16;
        int i3;
        msg_comm$MsgHead msg_comm_msghead;
        long j18;
        msg_comm$MsgHead msg_comm_msghead2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (ArrayList) iPatchRedirector.redirect((short) 22, this, msg_comm_msg, hashMap, messageRecord, cVar);
        }
        if (msg_comm_msg.msg_body.has() && (msg_comm_msg.msg_body.get().rich_text.has() || msg_comm_msg.msg_body.get().msg_content.has())) {
            msg_comm$MsgHead msg_comm_msghead3 = msg_comm_msg.msg_head.get();
            long j19 = msg_comm_msghead3.from_uin.get();
            long j26 = msg_comm_msghead3.msg_seq.get();
            long j27 = msg_comm_msghead3.msg_time.get();
            long j28 = msg_comm_msghead3.msg_uid.get();
            int i16 = msg_comm_msghead3.msg_type.get();
            int i17 = msg_comm_msghead3.mutiltrans_head.friend_flag.get();
            String str3 = msg_comm_msghead3.mutiltrans_head.from_anno_id.get();
            String str4 = msg_comm_msghead3.mutiltrans_head.from_face_url.get();
            String valueOf = String.valueOf(j19);
            MessageHandler msgHandler = ((QQAppInterface) this.app).getMsgHandler();
            long c16 = com.tencent.imcore.message.p.c(msgHandler, msg_comm_msg, String.valueOf(j19), String.valueOf(j19));
            ArrayList<MessageRecord> arrayList = new ArrayList<>();
            if ((s.i(i16) || i16 == 208 || i16 == 529) && msg_comm_msghead3.c2c_cmd.has()) {
                str = str4;
                str2 = str3;
                j3 = j28;
                j16 = j27;
                j17 = j26;
                d16 = d(msg_comm_msg, hashMap, cVar, msg_comm_msghead3, j19, i16, valueOf, msgHandler, arrayList, messageRecord);
                i3 = i16;
                msg_comm_msghead = msg_comm_msghead3;
                j18 = j19;
            } else {
                str = str4;
                str2 = str3;
                j3 = j28;
                j16 = j27;
                j17 = j26;
                if (i16 != 82 && i16 != 43) {
                    i3 = i16;
                    msg_comm_msghead2 = msg_comm_msghead3;
                } else if (msg_comm_msghead3.group_info.has()) {
                    j18 = msg_comm_msghead3.group_info.group_code.get();
                    msg_comm_msghead = msg_comm_msghead3;
                    i3 = i16;
                    valueOf = g(msg_comm_msg, hashMap, messageRecord, msg_comm_msghead3, j19, valueOf, msgHandler, arrayList, cVar);
                    d16 = valueOf;
                } else {
                    i3 = i16;
                    msg_comm_msghead2 = msg_comm_msghead3;
                }
                if ((i3 == 83 || i3 == 42) && msg_comm_msghead2.discuss_info.has()) {
                    j18 = msg_comm_msghead2.discuss_info.discuss_uin.get();
                    msg_comm_msghead = msg_comm_msghead2;
                    valueOf = e(msg_comm_msg, hashMap, messageRecord, cVar, msg_comm_msghead2, j19, valueOf, msgHandler, arrayList);
                } else {
                    msg_comm_msghead = msg_comm_msghead2;
                    j18 = j19;
                }
                d16 = valueOf;
            }
            int a16 = com.tencent.imcore.message.p.a(msg_comm_msg);
            Iterator<MessageRecord> it = arrayList.iterator();
            int i18 = 0;
            while (it.hasNext()) {
                MessageRecord G = G(messageRecord, msg_comm_msghead, arrayList, i18, it.next());
                i18++;
                G.time = j16;
                long j29 = j17;
                G.shmsgseq = j29;
                G.msgUid = j3;
                G.selfuin = ((QQAppInterface) this.app).getCurrentAccountUin();
                G.senderuin = String.valueOf(j19);
                G.frienduin = String.valueOf(j18);
                G.vipBubbleDiyTextId = a16;
                G.vipBubbleID = SVIPHandlerConstants.mixedBubbleAndTextId((int) c16, a16);
                com.tencent.mobileqq.multimsg.i.a(G, d16, messageRecord);
                String str5 = str;
                String str6 = str2;
                com.tencent.mobileqq.multimsg.i.b((QQAppInterface) this.app, G, String.valueOf(i17), str6, str5);
                if (i3 != 82 && i3 != 43) {
                    if (i3 != 83 && i3 != 42) {
                        G.istroop = 0;
                    } else {
                        G.istroop = 3000;
                    }
                } else {
                    G.istroop = 1;
                }
                str = str5;
                j17 = j29;
                str2 = str6;
            }
            BaseMessageHandlerUtils.blankMsgFilter(arrayList);
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, no msg_body or rich_text, msg_body.has():" + msg_comm_msg.msg_body.has());
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<MessageRecord> L(@NonNull byte[] bArr, @NonNull HashMap<String, String> hashMap, MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar) {
        ArrayList<MessageRecord> arrayList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, this, bArr, hashMap, messageRecord, cVar);
        }
        System.currentTimeMillis();
        byte[] E = E(bArr);
        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
        try {
            msg_transmit$PbMultiMsgTransmit mergeFrom = new msg_transmit$PbMultiMsgTransmit().mergeFrom(E);
            int i3 = 0;
            while (i3 < mergeFrom.f417539msg.size()) {
                msg_comm$Msg msg_comm_msg = mergeFrom.f417539msg.get(i3);
                msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
                long j3 = msg_comm_msghead.from_uin.get();
                long j16 = msg_comm_msghead.msg_seq.get();
                long j17 = msg_comm_msghead.msg_time.get();
                long j18 = msg_comm_msghead.msg_uid.get();
                int i16 = msg_comm_msghead.msg_type.get();
                MessageHandler msgHandler = ((QQAppInterface) this.app).getMsgHandler();
                long c16 = com.tencent.imcore.message.p.c(msgHandler, msg_comm_msg, String.valueOf(j3), String.valueOf(j3));
                ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
                long j19 = c16;
                long j26 = j18;
                long j27 = j17;
                long j28 = j16;
                int i17 = i16;
                int i18 = i3;
                msg_transmit$PbMultiMsgTransmit msg_transmit_pbmultimsgtransmit = mergeFrom;
                ArrayList<MessageRecord> arrayList4 = arrayList2;
                try {
                    long J = J(hashMap, cVar, msg_comm_msg, msg_comm_msghead, j3, j3, i17, msgHandler, arrayList3);
                    f(messageRecord, msg_comm_msg, msgHandler, arrayList3);
                    int a16 = com.tencent.imcore.message.p.a(msg_comm_msg);
                    Iterator<MessageRecord> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        MessageRecord next = it.next();
                        long j29 = j27;
                        next.time = j29;
                        long j36 = j28;
                        next.shmsgseq = j36;
                        long j37 = j26;
                        next.msgUid = j37;
                        next.selfuin = ((QQAppInterface) this.app).getCurrentAccountUin();
                        next.senderuin = String.valueOf(j3);
                        next.frienduin = String.valueOf(J);
                        next.vipBubbleDiyTextId = a16;
                        long j38 = J;
                        long j39 = j19;
                        j19 = j39;
                        next.vipBubbleID = SVIPHandlerConstants.mixedBubbleAndTextId((int) j39, a16);
                        int i19 = i17;
                        if (i19 != 82 && i19 != 43) {
                            if (i19 != 83 && i19 != 42) {
                                next.istroop = 0;
                                i17 = i19;
                                j27 = j29;
                                j28 = j36;
                                J = j38;
                                j26 = j37;
                            }
                            next.istroop = 3000;
                            i17 = i19;
                            j27 = j29;
                            j28 = j36;
                            J = j38;
                            j26 = j37;
                        }
                        next.istroop = 1;
                        i17 = i19;
                        j27 = j29;
                        j28 = j36;
                        J = j38;
                        j26 = j37;
                    }
                    BaseMessageHandlerUtils.blankMsgFilter(arrayList3);
                    arrayList = arrayList4;
                } catch (Exception e16) {
                    e = e16;
                    arrayList = arrayList4;
                    if (!com.tencent.mobileqq.multimsg.i.k()) {
                    }
                }
                try {
                    arrayList.addAll(arrayList3);
                    i3 = i18 + 1;
                    arrayList2 = arrayList;
                    mergeFrom = msg_transmit_pbmultimsgtransmit;
                } catch (Exception e17) {
                    e = e17;
                    if (!com.tencent.mobileqq.multimsg.i.k()) {
                        QLog.d("MultiMsg_TAG", 1, "unpackPbToMultiMsg, error: exception occurs while parsing the pb bytes", e);
                        return arrayList;
                    }
                    return arrayList;
                }
            }
            arrayList = arrayList2;
            a(messageRecord, arrayList, null);
            return arrayList;
        } catch (Exception e18) {
            e = e18;
            arrayList = arrayList2;
        }
    }

    public HashMap<String, ArrayList<MessageRecord>> M(byte[] bArr, HashMap<String, String> hashMap, MessageRecord messageRecord, com.tencent.mobileqq.troop.data.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (HashMap) iPatchRedirector.redirect((short) 21, this, bArr, hashMap, messageRecord, cVar);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, start unpack, startTime:" + currentTimeMillis);
        }
        try {
            msg_transmit$PbMultiMsgTransmit mergeFrom = new msg_transmit$PbMultiMsgTransmit().mergeFrom(E(bArr));
            HashMap<String, ArrayList<MessageRecord>> hashMap2 = new HashMap<>();
            if (!mergeFrom.pbItemList.has()) {
                ArrayList<MessageRecord> arrayList = new ArrayList<>();
                if (mergeFrom.f417539msg.has()) {
                    for (int i16 = 0; i16 < mergeFrom.f417539msg.size(); i16++) {
                        ArrayList<MessageRecord> F = F(mergeFrom.f417539msg.get(i16), hashMap, messageRecord, cVar);
                        if (F != null && F.size() > 0) {
                            arrayList.addAll(F);
                            if (QLog.isColorLevel()) {
                                QLog.d("MultiMsg_TAG", 2, String.format("unpackPbToMultiMsgWithNest for old version, msgsize:%d, msgtype:%d", Integer.valueOf(F.size()), Integer.valueOf(F.get(0).msgtype)));
                            }
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    hashMap2.put("MultiMsg", arrayList);
                }
            } else {
                int i17 = 0;
                while (i17 < mergeFrom.pbItemList.size()) {
                    msg_transmit$PbMultiMsgItem msg_transmit_pbmultimsgitem = mergeFrom.pbItemList.get(i17);
                    String str = msg_transmit_pbmultimsgitem.fileName.get();
                    msg_transmit$PbMultiMsgNew msg_transmit_pbmultimsgnew = new msg_transmit$PbMultiMsgNew();
                    try {
                        msg_transmit_pbmultimsgnew.mergeFrom(msg_transmit_pbmultimsgitem.buffer.get().toByteArray());
                        ArrayList<MessageRecord> arrayList2 = new ArrayList<>();
                        for (int i18 = i3; i18 < msg_transmit_pbmultimsgnew.f417538msg.size(); i18++) {
                            ArrayList<MessageRecord> F2 = F(msg_transmit_pbmultimsgnew.f417538msg.get(i18), hashMap, messageRecord, cVar);
                            if (F2 != null && F2.size() > 0) {
                                arrayList2.addAll(F2);
                            }
                        }
                        hashMap2.put(str, arrayList2);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgNew", e16);
                        }
                    }
                    i17++;
                    i3 = 0;
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "unpackPbToMultiMsgWithNest, end unpack,endTime:" + currentTimeMillis2 + " cost:" + (currentTimeMillis2 - currentTimeMillis));
            }
            return hashMap2;
        } catch (Exception e17) {
            if (com.tencent.mobileqq.multimsg.i.k()) {
                QLog.d("MultiMsg_TAG", 1, "unpackPbToMultiMsgWithNest, error: exception occurs while parsing PbMultiMsgTransmit", e17);
                return null;
            }
            return null;
        }
    }

    public boolean N(MessageRecord messageRecord, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) messageRecord, (Object) proxyListener)).booleanValue();
        }
        if (messageRecord.getStatus() == 1000) {
            this.proxyManager.addMsgQueueDonotNotify(messageRecord.frienduin, messageRecord.istroop, messageRecord.getTableName(), messageRecord, 3, null);
        } else {
            this.proxyManager.addMsgQueueDonotNotify(messageRecord.frienduin, messageRecord.istroop, messageRecord.getTableName(), messageRecord, 4, null);
        }
        this.proxyManager.transSaveToDatabase();
        return true;
    }

    public boolean O(List<MessageRecord> list, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) list, (Object) proxyListener)).booleanValue();
        }
        for (MessageRecord messageRecord : list) {
            if (messageRecord.getStatus() == 1000) {
                this.proxyManager.addMsgQueueDonotNotify(messageRecord.frienduin, messageRecord.istroop, messageRecord.getTableName(), messageRecord, 3, null);
            } else {
                this.proxyManager.addMsgQueueDonotNotify(messageRecord.frienduin, messageRecord.istroop, messageRecord.getTableName(), messageRecord, 4, null);
            }
        }
        this.proxyManager.transSaveToDatabase();
        return true;
    }

    protected boolean a(MessageRecord messageRecord, List<MessageRecord> list, ProxyListener proxyListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, messageRecord, list, proxyListener)).booleanValue();
        }
        b(messageRecord, list, proxyListener);
        this.proxyManager.transSaveToDatabase();
        return true;
    }

    protected void b(MessageRecord messageRecord, List<MessageRecord> list, ProxyListener proxyListener) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, messageRecord, list, proxyListener);
            return;
        }
        for (MessageRecord messageRecord2 : list) {
            if (messageRecord.senderuin.equals(messageRecord2.senderuin)) {
                messageRecord2.issend = 1;
                messageRecord2.selfuin = messageRecord2.senderuin;
            }
            if (messageRecord2 instanceof MessageForPtt) {
                messageRecord2.issend = messageRecord.issend;
            }
            messageRecord2.msgseq = messageRecord.uniseq;
            messageRecord2.isMultiMsg = true;
            if (messageRecord2.msgtype == -1035) {
                for (MessageRecord messageRecord3 : ((MessageForMixedMsg) messageRecord2).msgElemList) {
                    messageRecord3.msgseq = messageRecord2.msgseq;
                    messageRecord3.isMultiMsg = true;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "addMultiMsgSingle, time:" + messageRecord2.time + " senderuin:" + messageRecord2.senderuin + " istroop:" + messageRecord2.istroop + " shmsgseq:" + messageRecord2.shmsgseq + " msgseq:" + messageRecord2.msgseq + " msgData:" + messageRecord2.msgData);
            }
            this.proxyManager.addMsgQueueDonotNotify(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.getTableName(), messageRecord2, 0, proxyListener);
        }
        if (com.tencent.mobileqq.multimsg.i.k()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("addMultiMsgSingle, structMsg=");
            if (messageRecord == null) {
                i3 = -1;
            } else {
                i3 = messageRecord.msgtype;
            }
            sb5.append(i3);
            sb5.append(", list=");
            sb5.append(list.size());
            QLog.d("MultiMsg_TAG", 1, sb5.toString());
        }
        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMultiMsgAdd(list);
    }

    public MessageRecord c(MessageRecord messageRecord, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 28, this, messageRecord, str, Boolean.valueOf(z16));
        }
        MessageRecord d16 = q.d(-1000);
        d16.f203106msg = str;
        d16.uniseq = messageRecord.uniseq;
        d16.msgseq = messageRecord.msgseq;
        d16.time = messageRecord.time;
        d16.shmsgseq = messageRecord.shmsgseq;
        d16.msgUid = messageRecord.msgUid;
        d16.selfuin = messageRecord.selfuin;
        d16.senderuin = messageRecord.senderuin;
        d16.frienduin = messageRecord.frienduin;
        d16.istroop = messageRecord.istroop;
        d16.vipBubbleDiyTextId = messageRecord.vipBubbleDiyTextId;
        d16.vipBubbleID = messageRecord.vipBubbleID;
        d16.isMultiMsg = messageRecord.isMultiMsg;
        d16.extLong = messageRecord.extLong;
        d16.extStr = messageRecord.extStr;
        if (z16) {
            d16.setId(messageRecord.getId());
            d16.setStatus(messageRecord.getStatus());
            h().update(d16);
        }
        return d16;
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        com.tencent.mobileqq.persistence.g gVar = this.f195862a;
        if (gVar != null && gVar.isOpen()) {
            this.f195862a.close();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0142 A[Catch: Exception -> 0x013d, TRY_LEAVE, TryCatch #1 {Exception -> 0x013d, blocks: (B:37:0x0117, B:21:0x0142), top: B:36:0x0117 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public im_msg_body$MsgBody i(MessageRecord messageRecord, boolean z16) {
        im_msg_body$RichText l3;
        im_msg_body$MsgBody im_msg_body_msgbody;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (im_msg_body$MsgBody) iPatchRedirector.redirect((short) 6, this, messageRecord, Boolean.valueOf(z16));
        }
        im_msg_body$RichText im_msg_body_richtext = null;
        try {
            int i3 = messageRecord.msgtype;
            if (i3 != -1000 && i3 != -10000) {
                if (i3 == -1049) {
                    l3 = com.tencent.mobileqq.service.message.p.z((MessageForReplyText) messageRecord);
                } else if (i3 == -2005) {
                    if (z16) {
                        l3 = k(messageRecord);
                    } else {
                        im_msg_body_msgbody = ((QQAppInterface) this.app).getFileManagerEngine().R().g(1, messageRecord);
                        if (im_msg_body_richtext != null) {
                            try {
                                im_msg_body$ElemFlags2 im_msg_body_elemflags2 = new im_msg_body$ElemFlags2();
                                im_msg_body_elemflags2.uint32_color_text_id.set((int) (messageRecord.vipBubbleID & 4294967295L));
                                im_msg_body$Elem im_msg_body_elem = new im_msg_body$Elem();
                                im_msg_body_elem.elem_flags2.set(im_msg_body_elemflags2);
                                im_msg_body_richtext.elems.add(im_msg_body_elem);
                                j(messageRecord, im_msg_body_richtext);
                            } catch (Exception e16) {
                                e = e16;
                                im_msg_body_richtext = im_msg_body_msgbody;
                                QLog.e("MultiMsg_TAG", 1, e, new Object[0]);
                                return im_msg_body_richtext;
                            }
                        }
                        if (im_msg_body_msgbody != 0) {
                            im_msg_body$MsgBody im_msg_body_msgbody2 = new im_msg_body$MsgBody();
                            if (im_msg_body_richtext != null) {
                                try {
                                    im_msg_body_msgbody2.rich_text.set(im_msg_body_richtext);
                                } catch (Exception e17) {
                                    im_msg_body_richtext = im_msg_body_msgbody2;
                                    e = e17;
                                    QLog.e("MultiMsg_TAG", 1, e, new Object[0]);
                                    return im_msg_body_richtext;
                                }
                            }
                            return im_msg_body_msgbody2;
                        }
                        return im_msg_body_msgbody;
                    }
                } else if (i3 == -2017) {
                    if (z16) {
                        l3 = n(messageRecord);
                    } else {
                        im_msg_body_msgbody = ((QQAppInterface) this.app).getFileManagerEngine().R().g(1, messageRecord);
                        if (im_msg_body_richtext != null) {
                        }
                        if (im_msg_body_msgbody != 0) {
                        }
                    }
                } else if (i3 == -3017) {
                    if (z16) {
                        l3 = k(messageRecord);
                    } else {
                        im_msg_body_msgbody = ((QQAppInterface) this.app).getFileManagerEngine().R().g(1, messageRecord);
                        if (im_msg_body_richtext != null) {
                        }
                        if (im_msg_body_msgbody != 0) {
                        }
                    }
                } else if (i3 == -2000) {
                    l3 = com.tencent.mobileqq.service.message.p.t((MessageForPic) messageRecord);
                } else if (i3 == -5008) {
                    l3 = com.tencent.mobileqq.service.message.p.l((MessageForArkApp) messageRecord, true);
                } else if (i3 == -5016) {
                    l3 = com.tencent.mobileqq.service.message.p.m((MessageForArkBabyqReply) messageRecord, true);
                } else if (i3 == -5017) {
                    l3 = com.tencent.mobileqq.service.message.p.o((MessageForArkApp) messageRecord, true);
                } else if (i3 == -5013) {
                    l3 = com.tencent.mobileqq.service.message.p.n((MessageForArkFlashChat) messageRecord);
                } else if (i3 == -2011) {
                    l3 = m((MessageForStructing) messageRecord);
                } else if (i3 == -1035) {
                    l3 = com.tencent.mobileqq.service.message.p.s((MessageForMixedMsg) messageRecord);
                } else if (i3 == -1051) {
                    l3 = com.tencent.mobileqq.service.message.p.q((MessageForLongTextMsg) messageRecord, false);
                } else if (i3 == -2022) {
                    l3 = ((MessageForRichText) messageRecord).richText;
                } else if (i3 == -2002) {
                    l3 = ((MessageForRichText) messageRecord).richText;
                } else {
                    im_msg_body_msgbody = 0;
                    if (im_msg_body_richtext != null) {
                    }
                    if (im_msg_body_msgbody != 0) {
                    }
                }
                im_msg_body_richtext = l3;
                im_msg_body_msgbody = 0;
                if (im_msg_body_richtext != null) {
                }
                if (im_msg_body_msgbody != 0) {
                }
            }
            l3 = l(messageRecord);
            im_msg_body_richtext = l3;
            im_msg_body_msgbody = 0;
            if (im_msg_body_richtext != null) {
            }
            if (im_msg_body_msgbody != 0) {
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    @Override // com.tencent.mobileqq.app.proxy.BaseProxy
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public msg_comm$MsgHead o(MessageRecord messageRecord, HashMap<String, String> hashMap, boolean z16, int i3, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (msg_comm$MsgHead) iPatchRedirector.redirect((short) 7, this, messageRecord, hashMap, Boolean.valueOf(z16), Integer.valueOf(i3), Boolean.valueOf(z17));
        }
        msg_comm$MsgHead msg_comm_msghead = new msg_comm$MsgHead();
        msg_comm_msghead.from_uin.set(Long.valueOf(ad.k(messageRecord)).longValue());
        msg_comm_msghead.msg_seq.set((int) messageRecord.shmsgseq);
        msg_comm_msghead.msg_time.set((int) messageRecord.time);
        msg_comm_msghead.msg_uid.set(Long.valueOf(messageRecord.msgUid).longValue());
        msg_comm$MutilTransHead msg_comm_mutiltranshead = new msg_comm$MutilTransHead();
        PBUInt32Field pBUInt32Field = msg_comm_mutiltranshead.status;
        if (!z16) {
            i16 = -1;
        }
        pBUInt32Field.set(i16);
        msg_comm_mutiltranshead.msgId.set(i3);
        D(msg_comm_mutiltranshead, messageRecord);
        msg_comm_msghead.mutiltrans_head.set(msg_comm_mutiltranshead);
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("self_nickname");
        String k3 = ad.k(messageRecord);
        if (TextUtils.isEmpty(extInfoFromExtStr) && hashMap != null && hashMap.containsKey(k3)) {
            extInfoFromExtStr = hashMap.get(k3);
        }
        int i17 = messageRecord.istroop;
        if (i17 != 0 && i17 != 1000 && i17 != 1004 && i17 != 1022) {
            if (i17 == 3000) {
                msg_comm_msghead.msg_type.set(83);
                msg_comm$DiscussInfo msg_comm_discussinfo = new msg_comm$DiscussInfo();
                msg_comm_discussinfo.discuss_uin.set(Long.valueOf(messageRecord.frienduin).longValue());
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    msg_comm_discussinfo.discuss_remark.set(ByteStringMicro.copyFromUtf8(extInfoFromExtStr));
                }
                msg_comm_msghead.discuss_info.set(msg_comm_discussinfo);
            } else if (i17 == 1) {
                msg_comm_msghead.msg_type.set(82);
                msg_comm$GroupInfo msg_comm_groupinfo = new msg_comm$GroupInfo();
                msg_comm_groupinfo.group_code.set(Long.valueOf(messageRecord.frienduin).longValue());
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    msg_comm_groupinfo.group_card.set(ByteStringMicro.copyFromUtf8(extInfoFromExtStr));
                }
                msg_comm_msghead.group_info.set(msg_comm_groupinfo);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "MultiMsg:getMultiMsgHead, error:mr is not a C2C/dis/troop msg");
                    return null;
                }
                return null;
            }
        } else {
            if (messageRecord instanceof MessageForPtt) {
                msg_comm_msghead.msg_type.set(208);
            } else if (!z17 && (messageRecord instanceof MessageForFile)) {
                msg_comm_msghead.msg_type.set(529);
            } else if (!z17 && (messageRecord instanceof MessageForDLFile)) {
                msg_comm_msghead.msg_type.set(529);
            } else {
                msg_comm_msghead.msg_type.set(9);
            }
            if (!(messageRecord instanceof MessageForText) && !(messageRecord instanceof MessageForStructing)) {
                if (!z17 && (messageRecord instanceof MessageForFile)) {
                    msg_comm_msghead.c2c_cmd.set(4);
                } else if (!z17 && (messageRecord instanceof MessageForDLFile)) {
                    msg_comm_msghead.c2c_cmd.set(4);
                } else {
                    msg_comm_msghead.c2c_cmd.set(175);
                }
            } else {
                msg_comm_msghead.c2c_cmd.set(11);
            }
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                msg_comm_msghead.from_nick.set(extInfoFromExtStr);
            }
        }
        return msg_comm_msghead;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String p(int i3, MessageRecord messageRecord) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this, i3, (Object) messageRecord);
        }
        if (i3 <= 0) {
            return "MultiMsg";
        }
        if (messageRecord instanceof IMultiMsgRecordOp) {
            str = ((IMultiMsgRecordOp) messageRecord).getFilename();
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = "MultiMsg_" + i3;
        QLog.d("MultiMsg_TAG", 1, "resid is null! " + str2);
        return str2;
    }

    public byte[] s(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (byte[]) iPatchRedirector.redirect((short) 19, (Object) this, (Object) messageRecord);
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, start pack, startTime:" + currentTimeMillis);
        }
        msg_transmit$PbMultiMsgTransmit msg_transmit_pbmultimsgtransmit = new msg_transmit$PbMultiMsgTransmit();
        String currentNickname = ((QQAppInterface) this.app).getCurrentNickname();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(messageRecord.senderuin, currentNickname);
        msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
        msg_comm$MsgHead o16 = o(messageRecord, hashMap, true, 1, false);
        im_msg_body$MsgBody i3 = i(messageRecord, false);
        if (o16 != null && i3 != null) {
            msg_comm_msg.msg_head.set(o16);
            msg_comm_msg.msg_body.set(i3);
            msg_transmit_pbmultimsgtransmit.f417539msg.add(msg_comm_msg);
        } else if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, error:msg_head or msg_body is null,uniseq:" + messageRecord.uniseq);
        }
        byte[] q16 = q(msg_transmit_pbmultimsgtransmit.toByteArray());
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbFromLongTextMsg, end pack, endTime:" + currentTimeMillis2 + " cost:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return q16;
    }

    public byte[] t(ArrayList<MessageRecord> arrayList, HashMap<String, String> hashMap, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, this, arrayList, hashMap, Boolean.valueOf(z16));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbToMultiMsg, start pack, startTime:", Long.valueOf(currentTimeMillis));
        }
        msg_transmit$PbMultiMsgTransmit msg_transmit_pbmultimsgtransmit = new msg_transmit$PbMultiMsgTransmit();
        int nextInt = new Random(System.currentTimeMillis()).nextInt();
        Iterator<MessageRecord> it = arrayList.iterator();
        int i3 = nextInt;
        StringBuilder sb5 = null;
        while (it.hasNext()) {
            MessageRecord next = it.next();
            msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
            int i16 = i3 + 1;
            msg_comm$MsgHead o16 = o(next, hashMap, z16, i3, false);
            im_msg_body$MsgBody i17 = i(next, false);
            if (o16 != null && i17 != null) {
                msg_comm_msg.msg_head.set(o16);
                msg_comm_msg.msg_body.set(i17);
                msg_transmit_pbmultimsgtransmit.f417539msg.add(msg_comm_msg);
            } else {
                if (sb5 == null) {
                    sb5 = new StringBuilder("packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:");
                }
                sb5.append(next.uniseq);
                sb5.append("|");
            }
            i3 = i16;
        }
        if (sb5 != null && QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, sb5.toString());
        }
        byte[] q16 = q(msg_transmit_pbmultimsgtransmit.toByteArray());
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbToMultiMsg, end pack,endTime:" + currentTimeMillis2 + " cost:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return q16;
    }

    public byte[] u(HashMap<String, ArrayList<MessageRecord>> hashMap, HashMap<String, String> hashMap2, boolean z16) {
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (byte[]) iPatchRedirector.redirect((short) 20, this, hashMap, hashMap2, Boolean.valueOf(z16));
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbFromMultiMsgWithNest, start pack, startTime:", Long.valueOf(currentTimeMillis));
        }
        msg_transmit$PbMultiMsgTransmit msg_transmit_pbmultimsgtransmit = new msg_transmit$PbMultiMsgTransmit();
        int nextInt = new Random(System.currentTimeMillis()).nextInt();
        Iterator<String> it = hashMap.keySet().iterator();
        StringBuilder sb6 = null;
        while (it.hasNext()) {
            String next = it.next();
            ArrayList<MessageRecord> arrayList = hashMap.get(next);
            msg_transmit$PbMultiMsgItem msg_transmit_pbmultimsgitem = new msg_transmit$PbMultiMsgItem();
            msg_transmit$PbMultiMsgNew msg_transmit_pbmultimsgnew = new msg_transmit$PbMultiMsgNew();
            Iterator<MessageRecord> it5 = arrayList.iterator();
            int i3 = nextInt;
            StringBuilder sb7 = sb6;
            while (it5.hasNext()) {
                MessageRecord next2 = it5.next();
                msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
                int i16 = i3 + 1;
                msg_transmit$PbMultiMsgNew msg_transmit_pbmultimsgnew2 = msg_transmit_pbmultimsgnew;
                msg_transmit$PbMultiMsgItem msg_transmit_pbmultimsgitem2 = msg_transmit_pbmultimsgitem;
                String str = next;
                msg_comm$MsgHead o16 = o(next2, hashMap2, z16, i3, false);
                im_msg_body$MsgBody i17 = i(next2, false);
                if (o16 != null && i17 != null) {
                    msg_comm_msg.msg_head.set(o16);
                    msg_comm_msg.msg_body.set(i17);
                    msg_transmit_pbmultimsgnew2.f417538msg.add(msg_comm_msg);
                    msg_transmit_pbmultimsgnew = msg_transmit_pbmultimsgnew2;
                } else {
                    if (sb7 == null) {
                        sb5 = new StringBuilder("packPbFromMultiMsgWithNest error:msg_head or msg_body is null, uniseq:");
                    } else {
                        sb5 = sb7;
                    }
                    sb5.append(next2.uniseq);
                    sb5.append("|");
                    msg_transmit_pbmultimsgnew = msg_transmit_pbmultimsgnew2;
                    sb7 = sb5;
                }
                i3 = i16;
                msg_transmit_pbmultimsgitem = msg_transmit_pbmultimsgitem2;
                next = str;
            }
            msg_transmit$PbMultiMsgItem msg_transmit_pbmultimsgitem3 = msg_transmit_pbmultimsgitem;
            msg_transmit_pbmultimsgitem3.fileName.set(next);
            msg_transmit_pbmultimsgitem3.buffer.set(ByteStringMicro.copyFrom(msg_transmit_pbmultimsgnew.toByteArray()));
            msg_transmit_pbmultimsgtransmit.pbItemList.add(msg_transmit_pbmultimsgitem3);
            nextInt = i3;
            sb6 = sb7;
        }
        if (sb6 != null && QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, sb6.toString());
        }
        ArrayList<MessageRecord> arrayList2 = hashMap.get("MultiMsg");
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<MessageRecord> it6 = arrayList2.iterator();
            int i18 = nextInt;
            while (it6.hasNext()) {
                MessageRecord next3 = it6.next();
                if (com.tencent.mobileqq.multimsg.i.m((ChatMessage) next3)) {
                    next3 = c(next3, com.tencent.mobileqq.multimsg.g.f251616b, false);
                }
                MessageRecord messageRecord = next3;
                msg_comm$Msg msg_comm_msg2 = new msg_comm$Msg();
                int i19 = i18 + 1;
                msg_comm$MsgHead o17 = o(messageRecord, hashMap2, z16, i18, true);
                im_msg_body$MsgBody i26 = i(messageRecord, true);
                if (o17 != null && i26 != null) {
                    msg_comm_msg2.msg_head.set(o17);
                    msg_comm_msg2.msg_body.set(i26);
                    msg_transmit_pbmultimsgtransmit.f417539msg.add(msg_comm_msg2);
                } else if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "packPbFromMultiMsg error:msg_head or msg_body is null, uniseq:" + messageRecord.uniseq);
                }
                i18 = i19;
            }
        }
        byte[] q16 = q(msg_transmit_pbmultimsgtransmit.toByteArray());
        long currentTimeMillis2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "packPbFromMultiMsgWithNest, end pack,endTime:" + currentTimeMillis2 + " cost:" + (currentTimeMillis2 - currentTimeMillis));
        }
        return q16;
    }

    public ArrayList<MessageRecord> v(MessageRecord messageRecord, ArrayList<? extends MessageRecord> arrayList, ProxyListener proxyListener, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ArrayList) iPatchRedirector.redirect((short) 9, this, messageRecord, arrayList, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        ArrayList<MessageRecord> w3 = w(messageRecord, arrayList, proxyListener, z16, z17, new ArrayList<>(0));
        if (z16) {
            this.proxyManager.transSaveToDatabase();
        }
        return w3;
    }

    public ArrayList<MessageRecord> w(MessageRecord messageRecord, ArrayList<? extends MessageRecord> arrayList, ProxyListener proxyListener, boolean z16, boolean z17, ArrayList<MessageRecord> arrayList2) {
        MessageRecord messageRecord2;
        boolean z18;
        int i3;
        boolean z19;
        ArkAppMessage arkAppMessage;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 2;
        boolean z26 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (ArrayList) iPatchRedirector.redirect((short) 23, this, messageRecord, arrayList, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17), arrayList2);
        }
        ArrayList<MessageRecord> arrayList3 = new ArrayList<>();
        Iterator<? extends MessageRecord> it = arrayList.iterator();
        while (it.hasNext()) {
            MessageRecord next = it.next();
            if (z17) {
                int i17 = next.msgtype;
                if (i17 == -1037) {
                    messageRecord2 = ((MessageForLongMsg) next).rebuildLongMsg(true);
                } else if (i17 == -1036) {
                    messageRecord2 = (MessageForMixedMsg) ((MessageForLongMsg) next).rebuildLongMsg();
                } else if (i17 == -1035) {
                    MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) next;
                    MessageRecord rebuildMixedMsg = messageForMixedMsg.rebuildMixedMsg();
                    MessageForMixedMsg messageForMixedMsg2 = (MessageForMixedMsg) rebuildMixedMsg;
                    if (messageForMixedMsg2.getReplyMessage((QQAppInterface) this.app) != null) {
                        arrayList2.add(messageForMixedMsg2.getReplyMessage((QQAppInterface) this.app));
                        MessageForReplyText replyMessage = messageForMixedMsg.getReplyMessage((QQAppInterface) this.app);
                        MessageForReplyText replyMessage2 = messageForMixedMsg2.getReplyMessage((QQAppInterface) this.app);
                        if (replyMessage != null && replyMessage2 != null) {
                            QFileUtils.k0((QQAppInterface) this.app, replyMessage.getSourceMessage(), replyMessage2.getSourceMessage());
                        }
                    }
                    messageRecord2 = rebuildMixedMsg;
                } else if (i17 == -2011) {
                    messageRecord2 = new MessageForStructing(next);
                } else if (i17 == -1049) {
                    messageRecord2 = (MessageRecord) next.deepCopyByReflect();
                    if (messageRecord2 != null) {
                        MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord2;
                        messageForReplyText.deepCopySourceMsg((MessageForReplyText) next);
                        messageForReplyText.isBarrageMsg = z26;
                        messageForReplyText.barrageTimeLocation = 0L;
                        messageRecord2.removeExtInfoToExtStr(MessageForReplyText.KEY_BARRAGE_TIME_LOCATION);
                        messageRecord2.removeExtInfoToExtStr(MessageForReplyText.KEY_BARRAGE_SOURCE_MSG_TYPE);
                    }
                } else {
                    messageRecord2 = (MessageRecord) next.deepCopyByReflect();
                }
                if (messageRecord2 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MultiMsg_TAG", i16, "preAddMultiMsg.mrTemp is null ,not normal...");
                    }
                    return null;
                }
                if (!TextUtils.isEmpty(messageRecord2.getExtInfoFromExtStr("troop_at_info_list"))) {
                    messageRecord2.removeExtInfoToExtStr("troop_at_info_list");
                }
                if (!TextUtils.isEmpty(messageRecord2.getExtInfoFromExtStr("disc_at_info_list"))) {
                    messageRecord2.removeExtInfoToExtStr("disc_at_info_list");
                }
                messageRecord2.atInfoList = null;
                if (com.tencent.biz.anonymous.a.m(messageRecord2) && com.tencent.biz.anonymous.a.n(messageRecord2)) {
                    messageRecord2.senderuin = "80000000";
                }
                messageRecord2.extLong = next.extLong;
            } else {
                messageRecord2 = next;
            }
            messageRecord2.createMessageUniseq();
            messageRecord2.msgseq = messageRecord.uniseq;
            messageRecord2.isMultiMsg = true;
            messageRecord2.setExtraFlag(32770);
            if (messageRecord2.msgtype == -1035) {
                for (MessageRecord messageRecord3 : ((MessageForMixedMsg) messageRecord2).msgElemList) {
                    messageRecord3.msgseq = messageRecord2.msgseq;
                    messageRecord3.isMultiMsg = true;
                }
            }
            QFileUtils.k0((QQAppInterface) this.app, next, messageRecord2);
            if (messageRecord2.msgtype == -1049) {
                QFileUtils.k0((QQAppInterface) this.app, ((MessageForReplyText) next).getSourceMessage(), ((MessageForReplyText) messageRecord2).getSourceMessage());
            }
            int i18 = messageRecord2.msgtype;
            if (i18 == -2022) {
                z18 = false;
                ((MessageForShortVideo) messageRecord2).redBagType = 0;
            } else {
                z18 = false;
            }
            if (i18 == -5008 && (arkAppMessage = ((MessageForArkApp) messageRecord2).ark_app_message) != null) {
                arkAppMessage.updateMultiInfo("", messageRecord2.uniseq);
            }
            arrayList3.add(messageRecord2);
            if (QLog.isColorLevel()) {
                i3 = 2;
                QLog.d("MultiMsg_TAG", 2, "preAddMultiMsg, MessageRecord:" + next.toString());
            } else {
                i3 = 2;
            }
            if (z16) {
                if (messageRecord2.getStatus() == 1000) {
                    z19 = z18;
                    this.proxyManager.addMsgQueueDonotNotify(messageRecord2.frienduin, messageRecord2.istroop, messageRecord2.getTableName(), messageRecord2, 0, proxyListener);
                } else {
                    z19 = z18;
                    N(messageRecord2, null);
                }
            } else {
                z19 = z18;
            }
            int i19 = i3;
            z26 = z19;
            i16 = i19;
        }
        if (z16) {
            ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onMultiMsgAdd(arrayList3);
        }
        return arrayList3;
    }

    public HashMap<String, ArrayList<MessageRecord>> x(MessageRecord messageRecord, HashMap<String, ArrayList<MessageRecord>> hashMap, ProxyListener proxyListener, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (HashMap) iPatchRedirector.redirect((short) 24, this, messageRecord, hashMap, proxyListener, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        HashMap<String, ArrayList<MessageRecord>> hashMap2 = new HashMap<>();
        ArrayList<MessageRecord> arrayList = new ArrayList<>();
        if (messageRecord != null && hashMap != null) {
            if (!com.tencent.mobileqq.multimsg.i.m((ChatMessage) messageRecord)) {
                if (QLog.isColorLevel()) {
                    QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of not structMsg");
                }
                return hashMap2;
            }
            A(messageRecord, hashMap, hashMap2, 0, proxyListener, z16, z17, arrayList);
            if (arrayList.size() > 0) {
                hashMap2.put("reply_msg", arrayList);
            }
            if (z16) {
                this.proxyManager.transSaveToDatabase();
            }
            return hashMap2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MultiMsg_TAG", 2, "preAddMultiMsgWithNest error before of null msg or map");
        }
        return hashMap2;
    }

    public HashMap<String, ArrayList<MessageRecord>> y(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (HashMap) iPatchRedirector.redirect((short) 26, (Object) this, (Object) messageRecord);
        }
        HashMap<String, ArrayList<MessageRecord>> hashMap = new HashMap<>();
        if (messageRecord == null) {
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "queryMultiMsgWithNest error before of null msg or not structMsg type");
            }
            return hashMap;
        }
        B(messageRecord, hashMap, 0);
        return hashMap;
    }

    public ArrayList<MessageRecord> z(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ArrayList) iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
        ArrayList<MessageRecord> arrayList = (ArrayList) h().rawQuery(MessageRecord.class, "select * from mr_multimessage where msgseq=? order by _id asc", new String[]{String.valueOf(j3)});
        if (arrayList != null && arrayList.size() >= 1) {
            Iterator<MessageRecord> it = arrayList.iterator();
            while (it.hasNext()) {
                MessageRecord next = it.next();
                next.isMultiMsg = true;
                if (next.msgtype == -1035) {
                    Iterator<MessageRecord> it5 = ((MessageForMixedMsg) next).msgElemList.iterator();
                    while (it5.hasNext()) {
                        it5.next().isMultiMsg = true;
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiMsg_TAG", 2, "querySevalMsgFromMultiMsg,list.get(0).uniseq:" + arrayList.get(0).uniseq + " msgseq:" + arrayList.get(0).msgseq);
            }
            return arrayList;
        }
        return new ArrayList<>();
    }
}

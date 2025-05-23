package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0x9f.MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bk implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bk() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00a8 A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:3:0x000d, B:12:0x0046, B:14:0x00a8, B:15:0x00ad, B:19:0x00ab, B:21:0x002b, B:23:0x0038), top: B:2:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ab A[Catch: Exception -> 0x00d3, TryCatch #0 {Exception -> 0x00d3, blocks: (B:3:0x000d, B:12:0x0046, B:14:0x00a8, B:15:0x00ad, B:19:0x00ab, B:21:0x002b, B:23:0x0038), top: B:2:0x000d }] */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MessageRecord b(QQAppInterface qQAppInterface, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        int i3;
        String valueOf;
        int i16;
        String str;
        int i17;
        String str2;
        int i18;
        MsgBody msgBody = new MsgBody();
        MessageForQQWalletTips messageForQQWalletTips = (MessageForQQWalletTips) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_QQWALLET_TIPS);
        try {
            msgBody.mergeFrom(msgType0x210.vProtobuf);
            i3 = msgBody.sint32_sessiontype.get();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 6) {
                    i18 = 0;
                } else {
                    i18 = 1001;
                }
                i17 = i18;
                str = "";
                messageForQQWalletTips.senderUin = msgBody.uint64_sender_uin.get() + "";
                messageForQQWalletTips.reciverUin = msgBody.uint64_receiver_uin.get() + "";
                messageForQQWalletTips.senderContent = msgBody.bytes_sender_rich_content.get().toStringUtf8();
                messageForQQWalletTips.reciverContent = msgBody.bytes_receiver_rich_content.get().toStringUtf8();
                messageForQQWalletTips.authKey = msgBody.bytes_authkey.get().toStringUtf8();
                String currentAccountUin = qQAppInterface.getCurrentAccountUin();
                if (!qQAppInterface.getCurrentAccountUin().equals(messageForQQWalletTips.senderUin)) {
                    str2 = messageForQQWalletTips.reciverUin;
                } else {
                    str2 = messageForQQWalletTips.senderUin;
                }
                messageForQQWalletTips.init(currentAccountUin, str2, str, "[QQWallet Tips]", msgInfo.getUMsgTime(), MessageRecord.MSG_TYPE_QQWALLET_TIPS, i17, msgInfo.getShMsgSeq());
                messageForQQWalletTips.isread = true;
                messageForQQWalletTips.shmsgseq = msgInfo.shMsgSeq;
                messageForQQWalletTips.msgUid = msgInfo.lMsgUid;
                messageForQQWalletTips.getBytes();
                messageForQQWalletTips.onReceiveGrapTips();
                return messageForQQWalletTips;
            }
            valueOf = String.valueOf(msgBody.uint64_group_uin.get());
            i16 = 1004;
        } else {
            valueOf = String.valueOf(msgBody.uint64_group_uin.get());
            i16 = 1000;
        }
        str = valueOf;
        i17 = i16;
        messageForQQWalletTips.senderUin = msgBody.uint64_sender_uin.get() + "";
        messageForQQWalletTips.reciverUin = msgBody.uint64_receiver_uin.get() + "";
        messageForQQWalletTips.senderContent = msgBody.bytes_sender_rich_content.get().toStringUtf8();
        messageForQQWalletTips.reciverContent = msgBody.bytes_receiver_rich_content.get().toStringUtf8();
        messageForQQWalletTips.authKey = msgBody.bytes_authkey.get().toStringUtf8();
        String currentAccountUin2 = qQAppInterface.getCurrentAccountUin();
        if (!qQAppInterface.getCurrentAccountUin().equals(messageForQQWalletTips.senderUin)) {
        }
        messageForQQWalletTips.init(currentAccountUin2, str2, str, "[QQWallet Tips]", msgInfo.getUMsgTime(), MessageRecord.MSG_TYPE_QQWALLET_TIPS, i17, msgInfo.getShMsgSeq());
        messageForQQWalletTips.isread = true;
        messageForQQWalletTips.shmsgseq = msgInfo.shMsgSeq;
        messageForQQWalletTips.msgUid = msgInfo.lMsgUid;
        messageForQQWalletTips.getBytes();
        messageForQQWalletTips.onReceiveGrapTips();
        return messageForQQWalletTips;
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        return b((QQAppInterface) afVar.d(), msgInfo, msgType0x210);
    }
}

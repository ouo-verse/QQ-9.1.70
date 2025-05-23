package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.msgtype0x210.submsgtype0xa2.MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bl implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    private static MessageRecord b(QQAppInterface qQAppInterface, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        String str;
        int i3;
        FriendsManager friendsManager = (FriendsManager) qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        MsgBody msgBody = new MsgBody();
        MessageForQQWalletTips messageForQQWalletTips = (MessageForQQWalletTips) com.tencent.mobileqq.service.message.q.d(MessageRecord.MSG_TYPE_QQWALLET_TIPS);
        try {
            msgBody.mergeFrom(msgType0x210.vProtobuf);
            String str2 = msgBody.uint64_sender_uin.get() + "";
            String str3 = msgBody.uint64_receiver_uin.get() + "";
            if (qQAppInterface.getCurrentAccountUin().equals(str2)) {
                str = str3;
            } else {
                str = str2;
            }
            Friends v3 = friendsManager.v(str);
            if (v3 != null && v3.isFriend()) {
                i3 = 0;
            } else {
                i3 = 1001;
            }
            messageForQQWalletTips.senderUin = str2;
            messageForQQWalletTips.reciverUin = str3;
            messageForQQWalletTips.senderContent = msgBody.bytes_sender_rich_content.get().toStringUtf8();
            messageForQQWalletTips.reciverContent = msgBody.bytes_receiver_rich_content.get().toStringUtf8();
            messageForQQWalletTips.authKey = msgBody.bytes_authkey.get().toStringUtf8();
            messageForQQWalletTips.init(qQAppInterface.getCurrentAccountUin(), str, "", "[QQWallet Tips]", msgInfo.getUMsgTime(), MessageRecord.MSG_TYPE_QQWALLET_TIPS, i3, msgInfo.getShMsgSeq());
            messageForQQWalletTips.isread = true;
            messageForQQWalletTips.shmsgseq = msgInfo.shMsgSeq;
            messageForQQWalletTips.msgUid = msgInfo.lMsgUid;
            messageForQQWalletTips.getBytes();
            messageForQQWalletTips.onReceiveGrapTips();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
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

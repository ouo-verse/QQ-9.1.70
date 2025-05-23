package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class cc implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public cc() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0xeb");
        }
        try {
            submsgtype0xeb$MsgBody submsgtype0xeb_msgbody = new submsgtype0xeb$MsgBody();
            if (afVar.L(msgType0x210)) {
                submsgtype0xeb_msgbody.mergeFrom(msgType0x210.vProtobuf);
            }
            ActivateFriendsManager.C((QQAppInterface) afVar.d(), submsgtype0xeb_msgbody);
        } catch (Exception e16) {
            QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0xeb], errInfo->" + e16.getMessage());
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b(afVar, msgType0x210);
        return null;
    }
}

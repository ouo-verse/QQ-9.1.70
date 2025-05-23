package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class g implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x11a");
        }
        try {
            submsgtype0x11a$MsgBody submsgtype0x11a_msgbody = new submsgtype0x11a$MsgBody();
            if (afVar.L(msgType0x210)) {
                submsgtype0x11a_msgbody.mergeFrom(msgType0x210.vProtobuf);
                com.tencent.mobileqq.msgbackup.authentication.c.b().c(submsgtype0x11a_msgbody);
            }
        } catch (Exception e16) {
            QLog.e("Q.msg.BaseMessageProcessor", 1, "[msg0x210.uSubMsgType == 0x11a], errInfo->" + e16.getMessage());
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

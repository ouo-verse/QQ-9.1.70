package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class n implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgInfo msgInfo, MsgType0x210 msgType0x210) {
        boolean z16;
        tr2.e w3 = ((tr2.b) qQAppInterface.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER)).w(4);
        if (w3 != null) {
            byte[] bArr = msgType0x210.vProtobuf;
            long j3 = msgInfo.shMsgSeq;
            long j16 = msgInfo.uRealMsgTime;
            if (msgType0x210.uSubMsgType == 295) {
                z16 = false;
            } else {
                z16 = true;
            }
            w3.d(qQAppInterface, bArr, j3, j16, z16);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        b((QQAppInterface) afVar.d(), msgInfo, msgType0x210);
        return null;
    }
}

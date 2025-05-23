package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xa8.SubMsgType0xa8$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bn implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210) {
        SubMsgType0xa8$MsgBody subMsgType0xa8$MsgBody = new SubMsgType0xa8$MsgBody();
        try {
            subMsgType0xa8$MsgBody.mergeFrom(msgType0x210.vProtobuf);
            afVar.b0(subMsgType0xa8$MsgBody);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("PullActive", 2, "recv 0x210_0xa8, prase msgBody error");
            }
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

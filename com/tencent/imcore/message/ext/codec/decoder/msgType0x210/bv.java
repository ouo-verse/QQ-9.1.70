package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xcf.submsgtype0xcf$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class bv implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public bv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("QAV.Random.push", 2, "[1v1] onLinePush receive 0x210_0xcf");
        }
        try {
            submsgtype0xcf$MsgBody submsgtype0xcf_msgbody = new submsgtype0xcf$MsgBody();
            submsgtype0xcf_msgbody.mergeFrom(msgType0x210.vProtobuf);
            qQAppInterface.getGAudioHandler().m(submsgtype0xcf_msgbody);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("QAV.Random.push", 2, "[1v1] onLinePush 0x210_0xcf push exception", e16);
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
        b((QQAppInterface) afVar.d(), msgType0x210);
        return null;
    }
}

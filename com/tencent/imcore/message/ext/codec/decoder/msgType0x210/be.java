package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a$ReqBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class be implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public be() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b onlinepush");
        }
        Submsgtype0x8a$ReqBody submsgtype0x8a$ReqBody = new Submsgtype0x8a$ReqBody();
        try {
            submsgtype0x8a$ReqBody.mergeFrom(msgType0x210.vProtobuf);
            MsgType0x210Decoder.K(qQAppInterface, submsgtype0x8a$ReqBody, 0L, false);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b online msg, prase reqBody error");
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

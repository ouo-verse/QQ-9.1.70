package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ai implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ai() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        if (qQAppInterface == null) {
            QLog.e("QCirclePush.0x15e", 1, "decode msg, app == null");
            return null;
        }
        if (bArr == null) {
            QLog.e("QCirclePush.0x15e", 1, "decode msg, vProtobuf == null");
            return null;
        }
        com.tencent.mobileqq.qcirclepush.b.a(qQAppInterface, bArr, true);
        com.tencent.mobileqq.service.message.w.w(qQAppInterface, msgInfo.lFromUin, msgInfo.shMsgSeq, msgInfo.lMsgUid, msgInfo.shMsgType);
        return null;
    }
}

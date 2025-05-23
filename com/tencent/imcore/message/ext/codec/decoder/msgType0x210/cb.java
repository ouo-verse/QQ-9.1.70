package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class cb implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public cb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, MsgType0x210 msgType0x210) {
        if (QLog.isColorLevel()) {
            QLog.d("Qidian0xe5Push", 2, "<---receive qidian0xe5 push : forward to qidianHandler");
        }
        try {
            ((QidianHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).l3(new Submsgtype0xe5$MsgBody().mergeFrom(msgType0x210.vProtobuf));
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "<---decode0xe5push parse failed.", e16);
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

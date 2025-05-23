package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasSquareApi;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x156.SubMsgType0x156$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ad implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x156");
        }
        SubMsgType0x156$MsgBody subMsgType0x156$MsgBody = new SubMsgType0x156$MsgBody();
        try {
            subMsgType0x156$MsgBody.mergeFrom(bArr);
            if (QLog.isColorLevel()) {
                QLog.d("SubType0x156", 2, "handle0x210Sub0x156Push msgBody type:" + subMsgType0x156$MsgBody.msg_type.get());
            }
            ((IVasSquareApi) QRoute.api(IVasSquareApi.class)).handleOIDBPush(subMsgType0x156$MsgBody.msg_type.get(), subMsgType0x156$MsgBody.data.get().toByteArray());
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x151 " + e16);
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
        b((QQAppInterface) afVar.d(), msgType0x210.vProtobuf);
        return null;
    }
}

package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.olympic.OlympicMedalEventHandler;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x145.SubMsgType0x145$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class r implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        int i3;
        long j16;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
        SubMsgType0x145$MsgBody subMsgType0x145$MsgBody = new SubMsgType0x145$MsgBody();
        try {
            subMsgType0x145$MsgBody.mergeFrom(bArr);
            if (subMsgType0x145$MsgBody.event_id.has()) {
                i3 = subMsgType0x145$MsgBody.event_id.get();
            } else {
                i3 = -1;
            }
            long j17 = -1;
            if (subMsgType0x145$MsgBody.start.has()) {
                j16 = subMsgType0x145$MsgBody.start.get();
            } else {
                j16 = -1;
            }
            if (subMsgType0x145$MsgBody.end.has()) {
                j17 = subMsgType0x145$MsgBody.end.get();
            }
            if (subMsgType0x145$MsgBody.f436051msg.has()) {
                str = subMsgType0x145$MsgBody.f436051msg.get();
            } else {
                str = null;
            }
            QLog.e("SubType0x145", 1, "SubType0x145 end=" + j17 + " eventId=" + i3 + " startTime=" + j16 + " msg=" + str);
            ((OlympicMedalEventHandler) qQAppInterface.getBusinessHandler(OlympicMedalEventHandler.class.getName())).D2(new Object[]{Integer.valueOf(i3), Long.valueOf(j16), Long.valueOf(j17), str});
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("SubType0x145", 1, "C2C revoke OlympicMetalEvent push", e16);
        }
        return null;
    }
}

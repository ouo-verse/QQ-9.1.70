package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.c2cshortcutbar.C2CShortcutBarHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.submsgtype0x139.Submsgtype0x139$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class p implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void b(QQAppInterface qQAppInterface, byte[] bArr) {
        Submsgtype0x139$MsgBody submsgtype0x139$MsgBody = new Submsgtype0x139$MsgBody();
        try {
            submsgtype0x139$MsgBody.mergeFrom(bArr);
            long j3 = submsgtype0x139$MsgBody.uint64_friend.get();
            long j16 = submsgtype0x139$MsgBody.uint64_uin.get();
            int i3 = submsgtype0x139$MsgBody.uint32_op_type.get();
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush shortcut receive 0x210_0x139,pushType =", Integer.valueOf(i3), " friendUin =", Long.valueOf(j3), " accountUin = ", Long.valueOf(j16));
            }
            C2CShortcutBarHandler c2CShortcutBarHandler = (C2CShortcutBarHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.C2C_SHORTCUT_BAR_HANDLER);
            if (i3 == 1) {
                c2CShortcutBarHandler.G2(j3);
            } else if (i3 == 2) {
                c2CShortcutBarHandler.H2(j3, j16, true);
            } else if (i3 == 3) {
                c2CShortcutBarHandler.H2(j3, j16, false);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.msg.BaseMessageProcessor", 2, "onLinePush receive 0x210_0x139 " + e16);
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

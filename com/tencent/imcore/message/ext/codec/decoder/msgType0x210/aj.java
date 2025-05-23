package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.biz.qrcode.logindev.pclock.UnlockPCPushModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x16a.SubMsgType0x16a$LockStatusChangeNotify;

/* compiled from: P */
/* loaded from: classes7.dex */
public class aj implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public aj() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(QQAppInterface qQAppInterface, SubMsgType0x16a$LockStatusChangeNotify subMsgType0x16a$LockStatusChangeNotify) {
        int i3 = subMsgType0x16a$LockStatusChangeNotify.instance_id.get();
        int i16 = subMsgType0x16a$LockStatusChangeNotify.lock_status.get();
        String stringUtf8 = subMsgType0x16a$LockStatusChangeNotify.dev_name.get().toStringUtf8();
        int i17 = subMsgType0x16a$LockStatusChangeNotify.platform_id.get();
        QLog.d("SubType0x16a", 2, "handleAskUnlock platform id: " + i17 + " lock status: " + i16);
        com.tencent.biz.qrcode.logindev.pclock.b.f94950a.e(new UnlockPCPushModel(i3, i16, i17, stringUtf8));
    }

    private void c(QQAppInterface qQAppInterface, SubMsgType0x16a$LockStatusChangeNotify subMsgType0x16a$LockStatusChangeNotify) {
        ((rd0.g) qQAppInterface.getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER)).s(subMsgType0x16a$LockStatusChangeNotify.instance_id.get(), subMsgType0x16a$LockStatusChangeNotify.lock_status.get());
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        QLog.d("SubType0x16a", 2, "decode ");
        SubMsgType0x16a$LockStatusChangeNotify subMsgType0x16a$LockStatusChangeNotify = new SubMsgType0x16a$LockStatusChangeNotify();
        try {
            subMsgType0x16a$LockStatusChangeNotify.mergeFrom(bArr);
            int i3 = subMsgType0x16a$LockStatusChangeNotify.type.get();
            QLog.d("SubType0x16a", 2, "type: " + i3 + " platform id :" + subMsgType0x16a$LockStatusChangeNotify.platform_id.get());
            QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
            if (i3 == 2) {
                b(qQAppInterface, subMsgType0x16a$LockStatusChangeNotify);
            } else if (i3 == 3) {
                c(qQAppInterface, subMsgType0x16a$LockStatusChangeNotify);
            }
            return null;
        } catch (Exception e16) {
            QLog.w("SubType0x16a", 1, "merge from exception", e16);
            return null;
        }
    }
}

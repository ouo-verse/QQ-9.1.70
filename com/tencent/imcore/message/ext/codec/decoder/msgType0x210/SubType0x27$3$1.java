package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes7.dex */
class SubType0x27$3$1 implements Runnable {
    static IPatchRedirector $redirector_;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (QLog.isColorLevel()) {
                new StringBuilder().append("push a ModFriendGroup  = id:");
                throw null;
            }
            throw null;
        }
    }
}

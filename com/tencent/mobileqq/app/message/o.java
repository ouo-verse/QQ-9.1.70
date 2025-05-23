package com.tencent.mobileqq.app.message;

import com.tencent.imcore.message.C2CMessageManager;
import com.tencent.imcore.message.MsgPool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class o extends C2CMessageManager {
    static IPatchRedirector $redirector_;

    public o(AppRuntime appRuntime, MsgPool msgPool) {
        super(appRuntime, msgPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) msgPool);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TinyIdMsgMessageManager", 2, "TinyIdMsgMessageManager() called with: app = [" + appRuntime + "], msgPool = [" + msgPool + "]");
        }
    }
}

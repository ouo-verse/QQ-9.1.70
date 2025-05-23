package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class OnReceiveVerifyList {
    static IPatchRedirector $redirector_;
    public OnReceiveVerify[] cases;

    public OnReceiveVerifyList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

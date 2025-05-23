package com.tencent.mobileqq.msf.core.auth;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class Constants {
    static IPatchRedirector $redirector_ = null;
    public static final String SP_UIN_TO_UID = "MSF_SP_UIN_TO_UID";

    public Constants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

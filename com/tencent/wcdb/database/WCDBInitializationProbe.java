package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes27.dex */
class WCDBInitializationProbe {
    static IPatchRedirector $redirector_;
    static volatile long apiEnv;
    static boolean libLoaded;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22429);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            libLoaded = false;
            apiEnv = 0L;
        }
    }

    WCDBInitializationProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

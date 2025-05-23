package com.tencent.nativecrash;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

@Keep
/* loaded from: classes21.dex */
class InitializationProbe {
    static IPatchRedirector $redirector_ = null;
    static boolean libLoaded = false;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61702);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public InitializationProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

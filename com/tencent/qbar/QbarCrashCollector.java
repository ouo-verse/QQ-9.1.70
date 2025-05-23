package com.tencent.qbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QbarCrashCollector {
    static IPatchRedirector $redirector_;
    public static String sCurrentUrl;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(77467);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sCurrentUrl = null;
        }
    }

    public QbarCrashCollector() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

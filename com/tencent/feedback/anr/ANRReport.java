package com.tencent.feedback.anr;

import com.tencent.feedback.eup.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ANRReport {
    static IPatchRedirector $redirector_;

    public ANRReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void startANRMonitor() {
        a.l(true);
    }

    public static void stopANRMonitor() {
        a.l(false);
    }
}

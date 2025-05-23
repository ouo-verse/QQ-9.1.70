package com.tencent.opentelemetry.sdk.ntp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import d3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AndroidSystemClock {
    static IPatchRedirector $redirector_;
    public static a androidClock;

    public AndroidSystemClock() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void registerAndroidSystemClock(a aVar) {
        androidClock = aVar;
    }
}

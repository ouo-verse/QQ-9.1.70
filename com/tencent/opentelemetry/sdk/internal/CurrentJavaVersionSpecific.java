package com.tencent.opentelemetry.sdk.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class CurrentJavaVersionSpecific {
    static IPatchRedirector $redirector_;

    CurrentJavaVersionSpecific() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JavaVersionSpecific get() {
        return new JavaVersionSpecific();
    }
}

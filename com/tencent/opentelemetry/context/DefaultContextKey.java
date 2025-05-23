package com.tencent.opentelemetry.context;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
final class DefaultContextKey<T> implements ContextKey<T> {
    static IPatchRedirector $redirector_;
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultContextKey(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.name = str;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.name;
    }
}

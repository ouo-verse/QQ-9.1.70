package com.tencent.opentelemetry.sdk.autoconfigure;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ConfigurationException extends RuntimeException {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 4717640118051490483L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConfigurationException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
    }

    ConfigurationException(String str, Throwable th5) {
        super(str, th5);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) th5);
    }
}

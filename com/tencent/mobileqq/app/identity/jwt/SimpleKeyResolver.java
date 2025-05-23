package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.security.Key;

/* compiled from: P */
/* loaded from: classes11.dex */
public class SimpleKeyResolver {
    static IPatchRedirector $redirector_;
    private Key key;

    public SimpleKeyResolver(Key key) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) key);
        } else {
            this.key = key;
        }
    }

    public Key resolveKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Key) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.key;
    }
}

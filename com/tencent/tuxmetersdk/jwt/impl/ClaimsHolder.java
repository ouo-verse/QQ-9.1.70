package com.tencent.tuxmetersdk.jwt.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class ClaimsHolder {
    static IPatchRedirector $redirector_;
    private Map<String, Object> claims;

    /* JADX INFO: Access modifiers changed from: protected */
    public ClaimsHolder(Map<String, Object> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
        } else {
            this.claims = map == null ? new HashMap<>() : map;
        }
    }

    public Map<String, Object> getClaims() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Map) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.claims;
    }
}

package com.tencent.tuxmetersdk.jwt.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* loaded from: classes27.dex */
public final class PayloadClaimsHolder extends ClaimsHolder {
    static IPatchRedirector $redirector_;

    public PayloadClaimsHolder(Map<String, Object> map) {
        super(map);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
        }
    }
}

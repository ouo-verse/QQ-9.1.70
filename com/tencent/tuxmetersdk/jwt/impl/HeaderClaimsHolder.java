package com.tencent.tuxmetersdk.jwt.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class HeaderClaimsHolder extends ClaimsHolder {
    static IPatchRedirector $redirector_;

    public HeaderClaimsHolder(Map<String, Object> map) {
        super(map);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) map);
        }
    }
}

package com.tencent.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TokenVasIdMap {
    static IPatchRedirector $redirector_;
    public static final Map<Integer, Integer> TOKEN_VAS_MAP;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53819);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            TOKEN_VAS_MAP = new HashMap();
        }
    }

    public TokenVasIdMap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

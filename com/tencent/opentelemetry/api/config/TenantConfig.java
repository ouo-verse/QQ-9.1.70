package com.tencent.opentelemetry.api.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TenantConfig {
    static IPatchRedirector $redirector_;
    public static String tenantID;
    public static String tenantName;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15682);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            tenantID = "default";
            tenantName = "default";
        }
    }

    public TenantConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

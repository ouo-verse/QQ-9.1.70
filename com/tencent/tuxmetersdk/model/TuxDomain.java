package com.tencent.tuxmetersdk.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.tuxmetersdk.export.config.TuxEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class TuxDomain {
    static IPatchRedirector $redirector_ = null;
    public static final String FETCH_URL_DEVELOP = "https://t.tux.qq.com";
    public static final String FETCH_URL_RELEASE = "https://tux.qq.com";
    private final String developDomain;
    private final String releaseDomain;

    public TuxDomain(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) str2);
        } else {
            this.releaseDomain = str;
            this.developDomain = str2;
        }
    }

    public static TuxDomain getDefaultDomain() {
        return new TuxDomain(FETCH_URL_RELEASE, FETCH_URL_DEVELOP);
    }

    public String getDomainByEnvironment(TuxEnvironment tuxEnvironment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) tuxEnvironment);
        }
        if (tuxEnvironment == TuxEnvironment.DEVELOP) {
            return this.developDomain;
        }
        return this.releaseDomain;
    }
}

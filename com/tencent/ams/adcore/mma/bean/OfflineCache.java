package com.tencent.ams.adcore.mma.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class OfflineCache {
    static IPatchRedirector $redirector_;
    public String length;
    public String queueExpirationSecs;
    public String timeout;

    public OfflineCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "<offlineCache>\r\n<length>" + this.length + "</length>\r\n<queueExpirationSecs>" + this.queueExpirationSecs + "</queueExpirationSecs>\r\n<timeout>" + this.timeout + "</timeout></offlineCache>\r\n";
    }
}

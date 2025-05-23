package com.tencent.mobileqq.qqlive.data.pendant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class PushWebPendantData {
    static IPatchRedirector $redirector_;
    public long viewId;
    public String webData;

    public PushWebPendantData() {
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
        return "PushWebPendantDataBean{webData='" + this.webData + "', viewId=" + this.viewId + '}';
    }
}

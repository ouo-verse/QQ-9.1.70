package com.tencent.mobileqq.qqlive.data.pendant;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class WebPendantData {
    static IPatchRedirector $redirector_;
    public String dataCmd;
    public String pendantWebData;
    public String pendantWebUrl;

    public WebPendantData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

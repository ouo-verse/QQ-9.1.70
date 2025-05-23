package com.tencent.mobileqq.qqlive.data.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class CustomData {
    static IPatchRedirector $redirector_;
    public String liveVerifyUrl;

    public CustomData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.liveVerifyUrl = "";
        }
    }
}

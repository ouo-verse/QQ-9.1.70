package com.tencent.mobileqq.splashad.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes18.dex */
public class NormalSplashConfigProcessor extends AbsSplashConfigProcessor {
    static IPatchRedirector $redirector_;

    public NormalSplashConfigProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.config.l
    public int type() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 852;
    }
}

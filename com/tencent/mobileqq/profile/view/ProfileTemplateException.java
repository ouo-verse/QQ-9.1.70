package com.tencent.mobileqq.profile.view;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileTemplateException extends Exception {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = -100;

    public ProfileTemplateException(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}

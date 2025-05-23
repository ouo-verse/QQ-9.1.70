package com.tencent.mobileqq.profilecard.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileColor {
    static IPatchRedirector $redirector_;
    public long blue;
    public long green;
    public long red;

    public ProfileColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.red = 0L;
        this.green = 0L;
        this.blue = 0L;
    }
}

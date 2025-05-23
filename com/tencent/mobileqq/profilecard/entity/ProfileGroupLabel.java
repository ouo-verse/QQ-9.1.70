package com.tencent.mobileqq.profilecard.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes16.dex */
public class ProfileGroupLabel {
    static IPatchRedirector $redirector_;
    public long attr;
    public ProfileColor edgingColor;
    public String strWording;
    public ProfileColor textColor;
    public long type;

    public ProfileGroupLabel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.strWording = "";
        this.textColor = null;
        this.type = 0L;
        this.attr = 0L;
        this.edgingColor = null;
    }
}

package com.tencent.tuxmetersdk.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OptionStatus {
    static IPatchRedirector $redirector_ = null;
    public static final int CHOOSED = 0;
    public static final int UNCHOOSED = 1;
    public static final int UNSHOWED = 2;

    public OptionStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

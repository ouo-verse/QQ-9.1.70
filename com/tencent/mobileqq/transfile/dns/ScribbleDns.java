package com.tencent.mobileqq.transfile.dns;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ScribbleDns {
    static IPatchRedirector $redirector_ = null;
    public static final int SCRIBBLE_DOMAIN = 1018;

    public ScribbleDns() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

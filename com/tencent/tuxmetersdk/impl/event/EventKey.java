package com.tencent.tuxmetersdk.impl.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public class EventKey {
    static IPatchRedirector $redirector_ = null;
    public static final String EXTRA = "tux_extra";

    public EventKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

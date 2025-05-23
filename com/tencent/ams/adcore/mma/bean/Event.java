package com.tencent.ams.adcore.mma.bean;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class Event {
    static IPatchRedirector $redirector_;
    public String key;
    public boolean urlEncode;
    public String value;

    public Event() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

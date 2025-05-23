package com.tencent.mobileqq.highway.netprobe;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class DefaultProbe extends ProbeChain {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_PRIORITY = 10;

    public DefaultProbe() {
        super(10);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            addProbeItem(new EchoProbe());
            addProbeItem(new TracerouteProbe());
        }
    }
}

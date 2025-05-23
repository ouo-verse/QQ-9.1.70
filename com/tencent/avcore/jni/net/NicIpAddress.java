package com.tencent.avcore.jni.net;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NicIpAddress {
    static IPatchRedirector $redirector_;
    public String ipv4Address;
    public String ipv6Address;

    public NicIpAddress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

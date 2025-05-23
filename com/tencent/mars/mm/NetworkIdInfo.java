package com.tencent.mars.mm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class NetworkIdInfo {
    static IPatchRedirector $redirector_;
    public byte[] clientIp;
    public byte[] ctx;
    public byte[] networkId;

    public NetworkIdInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}

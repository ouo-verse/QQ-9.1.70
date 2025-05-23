package com.tencent.mobileqq.msf.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NetConnInfoCenterImpl {
    static IPatchRedirector $redirector_;

    public NetConnInfoCenterImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int getSystemNetworkType() {
        return NetConnInfoCenter.getSystemNetworkType();
    }
}

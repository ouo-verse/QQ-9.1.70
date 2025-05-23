package com.tencent.mobileqq.armap.sensor.provider;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes11.dex */
public class OrientationProviderNotFound extends Exception {
    static IPatchRedirector $redirector_;

    public OrientationProviderNotFound(String str) {
        super("sensor type:" + str + " not found");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        }
    }
}

package com.tencent.mobileqq.statistics.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.IBeaconConfig;
import com.tencent.mobileqq.statistics.b;

/* compiled from: P */
/* loaded from: classes18.dex */
public class BeaconConfigImpl implements IBeaconConfig {
    static IPatchRedirector $redirector_;

    public BeaconConfigImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.statistics.IBeaconConfig
    public boolean getUseSocket() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return b.a();
    }
}

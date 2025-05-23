package com.tencent.mobileqq.qqperf.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes17.dex */
public class DeviceOptSwitchImpl implements IDeviceOptSwitch {
    static IPatchRedirector $redirector_;

    public DeviceOptSwitchImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch
    public Set<Integer> getPreDownloadWhiteList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return vy3.a.f443732a;
    }

    @Override // com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch
    public boolean isDisablePreDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return vy3.a.f443733b;
    }

    @Override // com.tencent.mobileqq.qqperf.api.IDeviceOptSwitch
    public void setDisablePreDownloadTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
        } else {
            vy3.a.f443745n = j3;
        }
    }
}

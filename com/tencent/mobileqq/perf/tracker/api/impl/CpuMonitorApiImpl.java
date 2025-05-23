package com.tencent.mobileqq.perf.tracker.api.impl;

import com.tencent.mobileqq.perf.tracker.api.ICpuMonitorApi;
import com.tencent.mobileqq.power.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CpuMonitorApiImpl implements ICpuMonitorApi {
    static IPatchRedirector $redirector_;

    public CpuMonitorApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.perf.tracker.api.ICpuMonitorApi
    public void startCpuMonitor(Float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) f16);
        } else {
            c.f259407a.d(f16.floatValue());
        }
    }
}

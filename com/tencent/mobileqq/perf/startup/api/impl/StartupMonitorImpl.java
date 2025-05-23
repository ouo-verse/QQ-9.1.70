package com.tencent.mobileqq.perf.startup.api.impl;

import com.tencent.mobileqq.perf.startup.api.IStartupMonitor;
import com.tencent.mobileqq.perf.startup.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class StartupMonitorImpl implements IStartupMonitor {
    static IPatchRedirector $redirector_;

    public StartupMonitorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.perf.startup.api.IStartupMonitor
    public void traceBegin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        } else {
            f.g(str);
        }
    }

    @Override // com.tencent.mobileqq.perf.startup.api.IStartupMonitor
    public void traceEnd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            f.h(str);
        }
    }
}

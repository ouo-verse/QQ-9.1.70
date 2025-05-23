package com.tencent.mobileqq.statistics.crash.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.crash.RenderInSubThreadMonitor;
import com.tencent.mobileqq.statistics.crash.api.IRenderInSubThreadMonitor;

/* compiled from: P */
/* loaded from: classes18.dex */
public class RenderInSubThreadMonitorImpl implements IRenderInSubThreadMonitor {
    static IPatchRedirector $redirector_;

    public RenderInSubThreadMonitorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.statistics.crash.api.IRenderInSubThreadMonitor
    public void disableMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            RenderInSubThreadMonitor.disableMonitor();
        }
    }

    @Override // com.tencent.mobileqq.statistics.crash.api.IRenderInSubThreadMonitor
    public void enableMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            RenderInSubThreadMonitor.enableMonitor();
        }
    }
}

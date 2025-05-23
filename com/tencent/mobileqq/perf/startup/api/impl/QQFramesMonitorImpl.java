package com.tencent.mobileqq.perf.startup.api.impl;

import com.tencent.mobileqq.perf.startup.api.IQQFramesMonitor;
import com.tencent.mobileqq.perf.startup.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQFramesMonitorImpl implements IQQFramesMonitor {
    static IPatchRedirector $redirector_;

    public QQFramesMonitorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.perf.startup.api.IQQFramesMonitor
    public void recordFrameAddCost(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str);
        } else {
            b.a(j3, str);
        }
    }
}

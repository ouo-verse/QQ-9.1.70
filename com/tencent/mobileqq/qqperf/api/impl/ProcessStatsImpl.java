package com.tencent.mobileqq.qqperf.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqperf.api.IProcessStats;
import com.tencent.qqperf.tools.f;

/* loaded from: classes17.dex */
public class ProcessStatsImpl implements IProcessStats {
    static IPatchRedirector $redirector_;

    public ProcessStatsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqperf.api.IProcessStats
    public double getCpuUsage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
        }
        return f.f363418d.f363431m;
    }
}

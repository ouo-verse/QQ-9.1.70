package com.tencent.mobileqq.perf.api.impl;

import com.tencent.mobileqq.perf.api.ICpuUtilApi;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CpuUtilApiImpl implements ICpuUtilApi {
    static IPatchRedirector $redirector_;

    public CpuUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.perf.api.ICpuUtilApi
    public float getCpuUsage(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Float) iPatchRedirector.redirect((short) 2, (Object) this, i3)).floatValue();
        }
        return CpuUtil.f258160a.g(i3);
    }
}

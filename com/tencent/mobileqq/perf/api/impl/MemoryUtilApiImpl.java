package com.tencent.mobileqq.perf.api.impl;

import android.os.Debug;
import com.tencent.mobileqq.perf.api.IMemoryUtilApi;
import com.tencent.mobileqq.perf.tool.MemoryUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
public class MemoryUtilApiImpl implements IMemoryUtilApi {
    static IPatchRedirector $redirector_;

    public MemoryUtilApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.perf.api.IMemoryUtilApi
    public Debug.MemoryInfo getThrottledMemoryInfo(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Debug.MemoryInfo) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return MemoryUtil.f258173a.p(i3);
    }

    @Override // com.tencent.mobileqq.perf.api.IMemoryUtilApi
    public long getThrottledMemoryTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        return MemoryUtil.f258173a.o();
    }
}

package com.tencent.mobileqq.qqbattery.feature;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
class MonitorFeature$Snapshot$Sampler$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
    
        throw null;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            throw null;
        } catch (Exception e16) {
            com.tencent.mobileqq.qqbattery.utils.a.d("Matrix.battery.Sampler", e16, "onSamplingFailed: " + e16, new Object[0]);
            throw null;
        }
    }
}

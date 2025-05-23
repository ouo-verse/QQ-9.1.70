package com.tencent.mobileqq.qqbattery.feature;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
class DeviceStatMonitorFeature$1$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Intent f262280d;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            if (this.f262280d.getIntExtra("status", -1) == 5) {
                com.tencent.mobileqq.qqbattery.utils.a.a("QQBattery_DeviceStatusMonitorFeature", "BatteryFullCharged", new Object[0]);
                return;
            }
            throw null;
        }
    }
}

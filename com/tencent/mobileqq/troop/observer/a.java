package com.tencent.mobileqq.troop.observer;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    protected abstract void a(long j3);

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("GroupAppsObserver", 2, " onReceive: invoked. " + ("success = [" + z16 + "], [" + bundle + "]"));
        }
        if (z16 && i3 == 1) {
            a(bundle.getLong("KEY_GROUP_UIN"));
        }
    }
}

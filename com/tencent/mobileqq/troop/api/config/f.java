package com.tencent.mobileqq.troop.api.config;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class f {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a(AppRuntime appRuntime, TroopInfo troopInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 4, this, appRuntime, troopInfo, Boolean.valueOf(z16))).booleanValue();
    }
}

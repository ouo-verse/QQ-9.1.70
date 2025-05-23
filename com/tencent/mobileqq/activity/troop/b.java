package com.tencent.mobileqq.activity.troop;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.config.f;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends f {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.f
    public boolean a(AppRuntime appRuntime, TroopInfo troopInfo, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, appRuntime, troopInfo, Boolean.valueOf(z16))).booleanValue();
        }
        return ((TroopManager) appRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).d0(troopInfo, z16);
    }
}

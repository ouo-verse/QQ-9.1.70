package com.tencent.mobileqq.troop.utils;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.troop.ITroopGagUtils;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class aj implements Manager {
    static IPatchRedirector $redirector_;

    @SuppressLint({"WrongConstant"})
    public aj(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    public com.tencent.mobileqq.troop.troopgag.data.d a(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.mobileqq.troop.troopgag.data.d) iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16));
        }
        return ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).getSelfGagInfo(str, z16);
    }

    public com.tencent.mobileqq.troop.troopgag.data.e b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.mobileqq.troop.troopgag.data.e) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).getTroopGagInfo(str);
    }

    public String c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).getTroopOwnerReportStr(str);
    }

    public boolean d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        return ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).isAdmin(str);
    }

    public boolean e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        return ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).isMySelfSilent(str);
    }

    public boolean f(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).booleanValue();
        }
        return ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).isOwner(str);
    }

    public void g(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            ((ITroopGagUtils) QRoute.api(ITroopGagUtils.class)).showTipsToast(i3, z16);
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }
}

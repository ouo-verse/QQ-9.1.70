package com.tencent.upgrade.checker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upgrade.bean.UpgradeStrategy;
import com.tencent.upgrade.core.j;
import com.tencent.upgrade.util.d;
import com.tencent.upgrade.util.h;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a(UpgradeStrategy upgradeStrategy, UpgradeStrategy upgradeStrategy2) {
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) upgradeStrategy, (Object) upgradeStrategy2)).booleanValue();
        }
        String tacticsId = upgradeStrategy2.getTacticsId();
        String tacticsId2 = upgradeStrategy.getTacticsId();
        if (upgradeStrategy2.getUpdateTime() > upgradeStrategy.getUpdateTime()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!h.c(tacticsId) && (!tacticsId.equals(tacticsId2) || z16)) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!upgradeStrategy2.isLaterThan(upgradeStrategy) && !z16) {
            z18 = false;
        } else {
            z18 = true;
        }
        d.a("UpgradeStrategyFilter", "strategy valid = " + z17 + ", new strategy is newer = " + z18);
        if (z17 && z18) {
            return true;
        }
        return false;
    }

    public boolean b(UpgradeStrategy upgradeStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) upgradeStrategy)).booleanValue();
        }
        int k3 = j.l().k();
        int j3 = j.l().j();
        String f16 = com.tencent.upgrade.util.a.f();
        boolean isLaterThan = upgradeStrategy.isLaterThan(k3, j3, f16);
        d.a("UpgradeStrategyFilter", "isNewStrategyValid currentVersionCode = " + k3 + ", currentVersionName = " + f16 + ", currentBuildNo = " + j3 + ", result = " + isLaterThan);
        return isLaterThan;
    }
}

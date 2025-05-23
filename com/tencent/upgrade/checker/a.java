package com.tencent.upgrade.checker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upgrade.bean.UpgradeStrategy;
import com.tencent.upgrade.core.j;
import com.tencent.upgrade.util.d;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static a a() {
        return new a();
    }

    public boolean b(UpgradeStrategy upgradeStrategy) {
        long f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) upgradeStrategy)).booleanValue();
        }
        if (upgradeStrategy == null) {
            d.a("CachedStrategyFilter", "isLocalCachedStrategyInvalid,cache strategy is null");
            return true;
        }
        if (UpgradeStrategy.getDefaultCache().equals(upgradeStrategy)) {
            d.a("CachedStrategyFilter", "isLocalCachedStrategyInvalid,cache strategy is empty");
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - upgradeStrategy.getReceiveMoment();
        if (j.l().f() < 0) {
            f16 = 86400000;
        } else {
            f16 = j.l().f();
        }
        if (currentTimeMillis > f16) {
            d.a("CachedStrategyFilter", "isLocalCachedStrategyInvalid,cache strategy is timeout, interval = " + currentTimeMillis);
            return true;
        }
        if (!upgradeStrategy.isLaterThan(j.l().k(), j.l().j(), com.tencent.upgrade.util.a.f())) {
            d.a("CachedStrategyFilter", "isLocalCachedStrategyInvalid,cache strategy is deprecated");
            return true;
        }
        d.a("CachedStrategyFilter", "isLocalCachedStrategyInvalid,cache strategy is valid ");
        return false;
    }
}

package com.tencent.mobileqq.upgrade;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upgrade.bean.UpgradeStrategy;

/* compiled from: P */
/* loaded from: classes20.dex */
public class c implements pw4.d {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // pw4.d
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else if (QLog.isColorLevel()) {
            QLog.i("ShiplyUpgradeManager", 2, "ShiplyRequestCallback NoStrategy");
        }
    }

    @Override // pw4.d
    public void b(UpgradeStrategy upgradeStrategy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) upgradeStrategy);
        } else if (upgradeStrategy == null) {
            QLog.e("ShiplyUpgradeManager", 1, "ShiplyRequestCallback onReceiveStrategy null!");
        } else {
            e.e().m(upgradeStrategy);
        }
    }

    @Override // pw4.d
    public void onFail(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ShiplyRequestCallback fail, Code:");
        sb5.append(i3);
        sb5.append("  Msg:");
        if (str == null) {
            str = "null";
        }
        sb5.append(str);
        QLog.e("ShiplyUpgradeManager", 1, sb5.toString());
    }
}

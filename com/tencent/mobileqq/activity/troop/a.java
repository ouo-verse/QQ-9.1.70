package com.tencent.mobileqq.activity.troop;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.config.i;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends i {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.i
    public void a(String str, TroopInfo troopInfo) {
        TroopManager troopManager;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) troopInfo);
            return;
        }
        QQAppInterface qQAppInterface = (QQAppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (qQAppInterface != null && (troopManager = (TroopManager) qQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)) != null) {
            troopManager.e0(str, troopInfo);
        }
    }
}

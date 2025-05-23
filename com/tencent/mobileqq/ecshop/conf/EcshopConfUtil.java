package com.tencent.mobileqq.ecshop.conf;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EcshopConfUtil {
    static IPatchRedirector $redirector_;

    public EcshopConfUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static EcshopConfBean getEcshopConfBean() {
        return (EcshopConfBean) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(EcshopConfProcessor.CONFIG_ID);
    }

    public static boolean isAdClickAreaSwitchOn() {
        if (getEcshopConfBean().adClickAreaSwitch == 1) {
            return true;
        }
        return false;
    }
}

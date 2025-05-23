package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes19.dex */
public class InitHwEngineImp implements IHwEngineValue {
    static IPatchRedirector $redirector_ = null;
    public static final String BDH_IPV6_SWITCH = "bdh_ipv6_switch";

    public InitHwEngineImp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.transfile.IHwEngineValue
    public boolean getIpv6Switch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(BDH_IPV6_SWITCH, true);
    }

    @Override // com.tencent.mobileqq.transfile.IHwEngineValue
    public int getLocaleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return LocaleManager.getLocaleId();
    }
}

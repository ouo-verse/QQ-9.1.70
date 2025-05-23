package com.tencent.qqnt.dns.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.dns.api.IIpStrategy;

/* compiled from: P */
/* loaded from: classes24.dex */
public class IpStrategyImpl implements IIpStrategy {
    static IPatchRedirector $redirector_ = null;
    public static final String RICHMEDIA_DOWN_IPV6_SWITH = "richmedia_down_ipv6_switch";

    public IpStrategyImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.dns.api.IIpStrategy
    public boolean isRichMediaIpv6SwitchOpen() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(RICHMEDIA_DOWN_IPV6_SWITH, true);
    }
}

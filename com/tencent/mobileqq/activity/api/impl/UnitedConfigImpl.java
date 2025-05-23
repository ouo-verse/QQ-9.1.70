package com.tencent.mobileqq.activity.api.impl;

import com.tencent.mobileqq.activity.api.IUnitedConfig;
import com.tencent.mobileqq.graytip.UniteEntity;
import com.tencent.mobileqq.graytip.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class UnitedConfigImpl implements IUnitedConfig {
    static IPatchRedirector $redirector_;

    public UnitedConfigImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.api.IUnitedConfig
    public Boolean isSwitchOn(String str, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bool);
        }
        return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(str, bool.booleanValue()));
    }

    @Override // com.tencent.mobileqq.activity.api.IUnitedConfig
    public UniteEntity parseXMLContent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (UniteEntity) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return i.l(str);
    }
}

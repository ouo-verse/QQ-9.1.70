package com.tencent.mobileqq.msg.api.impl;

import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes15.dex */
public class FeatureSwitchImpl implements IFeatureSwitch {
    static IPatchRedirector $redirector_;

    public FeatureSwitchImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IFeatureSwitch
    public boolean isFeatureSwitchEnable(String str) {
        IFeatureRuntimeService iFeatureRuntimeService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")) == null) {
            return false;
        }
        return iFeatureRuntimeService.isFeatureSwitchEnable(str);
    }

    @Override // com.tencent.mobileqq.msg.api.IFeatureSwitch
    public boolean isFeatureSwitchEnable(String str, boolean z16) {
        IFeatureRuntimeService iFeatureRuntimeService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")) == null) {
            return false;
        }
        return iFeatureRuntimeService.isFeatureSwitchEnable(str, z16);
    }
}

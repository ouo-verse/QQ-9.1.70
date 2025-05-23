package com.tencent.mobileqq.util.impl;

import android.util.Pair;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.util.IFeatureServiceProxy;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes20.dex */
public class FeatureServiceProxyImpl implements IFeatureServiceProxy {
    @Override // com.tencent.mobileqq.util.IFeatureServiceProxy
    public Pair<Boolean, String> getSwitchAndValue(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        boolean isFeatureSwitchEnable = iFeatureRuntimeService.isFeatureSwitchEnable(str);
        return new Pair<>(Boolean.valueOf(isFeatureSwitchEnable), iFeatureRuntimeService.getString(str, ""));
    }

    @Override // com.tencent.mobileqq.util.IFeatureServiceProxy
    public boolean isAppRuntimeNull() {
        if (MobileQQ.sMobileQQ.peekAppRuntime() == null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.util.IFeatureServiceProxy
    public boolean isFeatureSwitchOn(String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return false;
        }
        return ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(str);
    }

    @Override // com.tencent.mobileqq.util.IFeatureServiceProxy
    public boolean isFeatureSwitchOn(String str, boolean z16) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        return peekAppRuntime == null ? z16 : ((IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable(str, z16);
    }
}

package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.List;

@ProxyService(proxy = WnsConfigProxy.class)
/* loaded from: classes23.dex */
public class WnsConfigProxyDefault extends WnsConfigProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public List<String> getApiReportConfig() {
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public String getConfig(String str, String str2) {
        if (QUAUtil.isDemoApp() && str.equals("qqminiapp") && str2.equals(WnsConfig.UNITY_SANDBOX_WHITELIST)) {
            return CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI;
        }
        return null;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public boolean getWebgl2Enable(String str, boolean z16) {
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy
    public boolean isWebAudioEnable() {
        return true;
    }
}

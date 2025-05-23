package com.tencent.qqmini.proxyimpl;

import com.tencent.mobileqq.mini.network.RequestStrategy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@ProxyService(proxy = RequestStrategyProxy.class)
/* loaded from: classes34.dex */
public class be implements RequestStrategyProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public void addHttpForwardingInfo(JSONObject jSONObject) {
        RequestStrategy.f246656g.addHttpForwardingInfo(jSONObject);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public boolean isIPV6Only() {
        return RequestStrategy.f246656g.isIPv6Only();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public boolean isOpenIpv6Request() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("is_mini_app_ipv6_open", false);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public void notifyNetWorkStatusChange() {
        RequestStrategy.f246656g.notifyNetWorkStatusChange();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public String addHttpForwardingInfo(String str, Map<String, String> map) {
        return RequestStrategy.f246656g.addHttpForwardingInfo(str, map);
    }
}

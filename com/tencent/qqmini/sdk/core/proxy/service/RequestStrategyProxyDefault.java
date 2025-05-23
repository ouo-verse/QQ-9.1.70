package com.tencent.qqmini.sdk.core.proxy.service;

import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy;
import java.util.Map;
import org.json.JSONObject;

@ProxyService(proxy = RequestStrategyProxy.class)
/* loaded from: classes23.dex */
public class RequestStrategyProxyDefault implements RequestStrategyProxy {
    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public String addHttpForwardingInfo(String str, Map<String, String> map) {
        return str;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public boolean isIPV6Only() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public boolean isOpenIpv6Request() {
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public void addHttpForwardingInfo(JSONObject jSONObject) {
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.RequestStrategyProxy
    public void notifyNetWorkStatusChange() {
    }
}

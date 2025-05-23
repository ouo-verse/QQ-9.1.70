package com.tencent.qqmini.sdk.core.proxy.engine;

import com.tencent.qqmini.sdk.core.utils.ReflectionUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public class ProxyServiceList {
    private static final String AD_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.AdProxyServiceScope";
    private static final String APP_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.AppProxyServiceScope";
    private static final String EXT_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.ExtProxyServiceScope";
    private static final String GAME_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.GameProxyServiceScope";
    private static final String GENERATED_PACKAGE = "com.tencent.qqmini.sdk.core.generated.";
    private static final String MAP_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.MapProxyServiceScope";
    private static final String MINICODE_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.MiniCodeProxyServiceScope";
    private static final String PAY_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.PayProxyServiceScope";
    private static final String PROXY_SERVICES = "PROXY_SERVICES";
    private static final String SANDBOX_AD_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.UnityAdProxyServiceScope";
    private static final String SANDBOX_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.UnityProxyServiceScope";
    private static final String SDK_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.SdkProxyServiceScope";
    private static final String TAG = "ProxyServiceList";
    private static final String UNION_AD_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.UnionAdProxyServiceScope";
    private static final String ZZCONFIG_PROXY_SERVICE = "com.tencent.qqmini.sdk.core.generated.ZZConfigProxyServiceScope";

    public static Map<Class, Class> get() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(getProxyServices(SDK_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(APP_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(GAME_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(PAY_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(AD_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(UNION_AD_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(MINICODE_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(MAP_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(ZZCONFIG_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(SANDBOX_AD_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(SANDBOX_PROXY_SERVICE));
        hashMap.putAll(getProxyServices(EXT_PROXY_SERVICE));
        return hashMap;
    }

    private static Map<Class, Class> getProxyServices(String str) {
        Object staticField = ReflectionUtil.getStaticField(str, PROXY_SERVICES);
        if (staticField instanceof Map) {
            return (Map) staticField;
        }
        return new HashMap();
    }
}

package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.map.proxyImpl.MapProxyImplDefault;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public final class MapProxyServiceScope {
    public static final Map PROXY_SERVICES;

    static {
        HashMap hashMap = new HashMap();
        PROXY_SERVICES = hashMap;
        hashMap.put(MapProxy.class, MapProxyImplDefault.class);
    }
}

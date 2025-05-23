package com.tencent.qqmini.sdk.core.generated;

import com.tencent.qqmini.miniapp.proxy.VideoJsProxyDefault;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes23.dex */
public final class AppProxyServiceScope {
    public static final Map PROXY_SERVICES;

    static {
        HashMap hashMap = new HashMap();
        PROXY_SERVICES = hashMap;
        hashMap.put(VideoJsProxy.class, VideoJsProxyDefault.class);
    }
}

package com.tencent.minibox.proxy;

import androidx.annotation.Keep;

@Keep
/* loaded from: classes9.dex */
public class ProxyRef {
    private static MiniBoxProxy proxyHolder;

    public static MiniBoxProxy getProxyHolder() {
        return proxyHolder;
    }

    public static void init(MiniBoxProxy miniBoxProxy) {
        proxyHolder = miniBoxProxy;
    }
}

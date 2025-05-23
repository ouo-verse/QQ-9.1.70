package com.tencent.qqmini.sdk.core.proxy;

import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.core.proxy.engine.ProxyServiceEngine;

@MiniKeep
/* loaded from: classes23.dex */
public class ProxyManager {
    public static <T> T get(Class<T> cls) {
        return (T) ProxyServiceEngine.g().getProxyService(cls);
    }

    public static <T> T getNew(Class<T> cls) {
        return (T) ProxyServiceEngine.g().newProxyService(cls);
    }
}

package com.tencent.smtt.sdk;

import java.util.concurrent.Executor;

/* loaded from: classes23.dex */
public abstract class ProxyController {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        static final ProxyController f368990a = new e();
    }

    public static ProxyController getInstance() {
        return a.f368990a;
    }

    public abstract void clearProxyOverride(Executor executor, Runnable runnable);

    public abstract void setProxyOverride(ProxyConfig proxyConfig, Executor executor, Runnable runnable);

    public abstract void syncSetProxy();
}

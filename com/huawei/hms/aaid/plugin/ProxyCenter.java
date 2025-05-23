package com.huawei.hms.aaid.plugin;

/* loaded from: classes2.dex */
public class ProxyCenter {
    public PushProxy proxy;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static ProxyCenter f36602a = new ProxyCenter();
    }

    public static ProxyCenter getInstance() {
        return a.f36602a;
    }

    public static PushProxy getProxy() {
        return getInstance().proxy;
    }

    public static void register(PushProxy pushProxy) {
        getInstance().proxy = pushProxy;
    }
}

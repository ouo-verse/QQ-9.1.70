package com.tencent.xweb;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

/* loaded from: classes27.dex */
public abstract class ProxyController {

    /* loaded from: classes27.dex */
    public static class DUMMY_LAZY_HOLDER {

        /* renamed from: a, reason: collision with root package name */
        public static final ProxyController f384967a = new DummyProxyControllerImpl();
    }

    /* loaded from: classes27.dex */
    public static class SYS_LAZY_HOLDER {

        /* renamed from: a, reason: collision with root package name */
        public static final ProxyController f384968a = new SysProxyControllerImpl();
    }

    /* loaded from: classes27.dex */
    public static class XWEB_LAZY_HOLDER {

        /* renamed from: a, reason: collision with root package name */
        public static final ProxyController f384969a = new XWebProxyControllerImpl();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ProxyController() {
    }

    @NonNull
    public static ProxyController getInstance() {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
            if (XWebSdk.isSysWebView()) {
                return SYS_LAZY_HOLDER.f384968a;
            }
            if (XWebSdk.isXWebView()) {
                return XWEB_LAZY_HOLDER.f384969a;
            }
            return DUMMY_LAZY_HOLDER.f384967a;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    public abstract void clearProxyOverride(@NonNull Executor executor, @NonNull Runnable runnable);

    public abstract void setProxyOverride(@NonNull ProxyConfig proxyConfig, @NonNull Executor executor, @NonNull Runnable runnable);
}

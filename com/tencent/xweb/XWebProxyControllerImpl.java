package com.tencent.xweb;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.tq.d;
import com.tencent.luggage.wxa.tq.g;
import com.tencent.xweb.ProxyConfig;
import com.tencent.xweb.WebView;
import com.tencent.xweb.internal.ConstValue;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes27.dex */
public class XWebProxyControllerImpl extends ProxyController {
    @NonNull
    @VisibleForTesting
    public static String[][] proxyRulesToStringArray(@NonNull List<ProxyConfig.ProxyRule> list) {
        String[][] strArr = (String[][]) Array.newInstance((Class<?>) String.class, list.size(), 2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            strArr[i3][0] = list.get(i3).getSchemeFilter();
            strArr[i3][1] = list.get(i3).getUrl();
        }
        return strArr;
    }

    @Override // com.tencent.xweb.ProxyController
    public void clearProxyOverride(@NonNull Executor executor, @NonNull Runnable runnable) {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
            if (XWebSdk.isXWebCoreInited()) {
                d a16 = g.a(WebView.WebViewKind.WV_KIND_PINUS);
                if (a16 != null) {
                    a16.invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_CLEAR_PROXY_OVERRIDE, new Object[]{runnable, executor});
                    return;
                }
                return;
            }
            throw new IllegalStateException("XWebCore is not inited!");
        }
        throw new IllegalStateException("WebViewFeature.PROXY_OVERRIDE Unsupportedd!");
    }

    @Override // com.tencent.xweb.ProxyController
    public void setProxyOverride(@NonNull ProxyConfig proxyConfig, @NonNull Executor executor, @NonNull Runnable runnable) {
        String[][] proxyRulesToStringArray = proxyRulesToStringArray(proxyConfig.getProxyRules());
        String[] strArr = (String[]) proxyConfig.getBypassRules().toArray(new String[0]);
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE) && !proxyConfig.isReverseBypassEnabled()) {
            if (XWebSdk.isXWebCoreInited()) {
                d a16 = g.a(WebView.WebViewKind.WV_KIND_PINUS);
                if (a16 != null) {
                    a16.invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_SET_PROXY_OVERRIDE, new Object[]{proxyRulesToStringArray, strArr, runnable, executor});
                    n0.a(1749L, 83L, 1L);
                    return;
                }
                return;
            }
            n0.a(1749L, 84L, 1L);
            throw new IllegalStateException("WebViewFeature.PROXY_OVERRIDE Supported, ReverseBypass Disabled, XWebCore is not inited!");
        }
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE) && WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE_REVERSE_BYPASS)) {
            if (XWebSdk.isXWebCoreInited()) {
                d a17 = g.a(WebView.WebViewKind.WV_KIND_PINUS);
                if (a17 != null) {
                    a17.invokeRuntimeChannel(ConstValue.INVOKE_RUNTIME_ID_PROXY_OVERRIDE_REVERSE_BYPASS, new Object[]{proxyRulesToStringArray, strArr, runnable, executor, Boolean.valueOf(proxyConfig.isReverseBypassEnabled())});
                    n0.a(1749L, 86L, 1L);
                    return;
                }
                return;
            }
            n0.a(1749L, 87L, 1L);
            throw new IllegalStateException("WebViewFeature.PROXY_OVERRIDE Supported, ReverseBypass Enabled, WebViewFeature.PROXY_OVERRIDE_REVERSE_BYPASS Supported, XWebCore is not inited!");
        }
        n0.a(1749L, 84L, 1L);
        throw new IllegalStateException("WebViewFeature.PROXY_OVERRIDE Unsupported");
    }
}

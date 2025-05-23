package com.tencent.xweb;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.webkit.ProxyConfig;
import com.tencent.xweb.ProxyConfig;
import java.lang.reflect.Array;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes27.dex */
public class SysProxyControllerImpl extends ProxyController {
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
            androidx.webkit.ProxyController.getInstance().clearProxyOverride(executor, runnable);
            return;
        }
        throw new IllegalStateException("WebViewFeature.PROXY_OVERRIDE Unsupportedd!");
    }

    @Override // com.tencent.xweb.ProxyController
    public void setProxyOverride(@NonNull ProxyConfig proxyConfig, @NonNull Executor executor, @NonNull Runnable runnable) {
        List<ProxyConfig.ProxyRule> proxyRules = proxyConfig.getProxyRules();
        List<String> bypassRules = proxyConfig.getBypassRules();
        boolean isReverseBypassEnabled = proxyConfig.isReverseBypassEnabled();
        ProxyConfig.Builder builder = new ProxyConfig.Builder();
        for (int i3 = 0; i3 < proxyRules.size(); i3++) {
            if (proxyRules.get(i3).getSchemeFilter().equals("http")) {
                builder.addProxyRule(proxyRules.get(i3).getUrl(), "http");
            }
            if (proxyRules.get(i3).getSchemeFilter().equals("https")) {
                builder.addProxyRule(proxyRules.get(i3).getUrl(), "https");
            }
            if (proxyRules.get(i3).getSchemeFilter().equals("*")) {
                builder.addProxyRule(proxyRules.get(i3).getUrl(), "*");
            }
        }
        for (int i16 = 0; i16 < bypassRules.size(); i16++) {
            builder.addBypassRule(bypassRules.get(i16));
        }
        builder.setReverseBypassEnabled(isReverseBypassEnabled);
        androidx.webkit.ProxyController.getInstance().setProxyOverride(builder.build(), executor, runnable);
    }
}

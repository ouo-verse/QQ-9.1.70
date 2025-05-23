package com.tencent.xweb;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: P */
/* loaded from: classes27.dex */
public class WebViewFeature {
    public static final String PROXY_OVERRIDE = "PROXY_OVERRIDE";
    public static final String PROXY_OVERRIDE_REVERSE_BYPASS = "PROXY_OVERRIDE_REVERSE_BYPASS";
    public static final String TAG = "WebViewFeature";

    /* compiled from: P */
    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* loaded from: classes27.dex */
    public @interface WebViewSupportFeature {
    }

    public static boolean isFeatureSupported(@NonNull String str) {
        if (XWebSdk.isSysWebView()) {
            return androidx.webkit.WebViewFeature.isFeatureSupported(str);
        }
        if (XWebSdk.isXWebView()) {
            if (XWebSdk.isXWebCoreInited()) {
                if (str.equals(PROXY_OVERRIDE)) {
                    return XWebSdk.isCurrentVersionSupportSetProxyOverride();
                }
                if (str.equals(PROXY_OVERRIDE_REVERSE_BYPASS)) {
                    return XWebSdk.isCurrentVersionSupportProxyOverrideReverseBypass();
                }
                Log.i(TAG, "isFeatureSupported, unknown WebViewFeature");
                return false;
            }
            Log.i(TAG, "isFeatureSupported, XWebCore is not inited!");
            return false;
        }
        Log.i(TAG, "isFeatureSupported, unknown core! Not Sys Core! Not XWeb Core!");
        return false;
    }
}

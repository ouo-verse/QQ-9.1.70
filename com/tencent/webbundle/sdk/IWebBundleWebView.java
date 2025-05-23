package com.tencent.webbundle.sdk;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IWebBundleWebView {

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnPageFinishedListener {
        void onPageFinished(@NotNull IWebBundleWebView iWebBundleWebView, @NotNull String str);
    }

    void addJavascriptInterface(@NotNull Object obj, @NotNull String str);

    void destroy();

    void dispatchJsEvent(@NotNull String str, @NotNull JSONObject jSONObject, @Nullable JSONObject jSONObject2);

    void enableJavaScript(boolean z16);

    void loadUrl(@NotNull String str);

    void setOnPageFinishedListener(@NotNull OnPageFinishedListener onPageFinishedListener);
}

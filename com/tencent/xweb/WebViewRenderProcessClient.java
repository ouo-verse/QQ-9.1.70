package com.tencent.xweb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes27.dex */
public abstract class WebViewRenderProcessClient {
    public abstract void onRenderProcessResponsive(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess);

    public abstract void onRenderProcessUnresponsive(@NonNull WebView webView, @Nullable WebViewRenderProcess webViewRenderProcess);
}

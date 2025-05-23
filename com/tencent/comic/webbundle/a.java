package com.tencent.comic.webbundle;

import android.content.Context;
import com.tencent.mobileqq.webview.swift.utils.i;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.webbundle.sdk.IWebBundleRuntime;
import com.tencent.webbundle.sdk.IWebBundleWebView;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a extends IWebBundleRuntime {
    public a(Context context) {
        super(context);
    }

    @Override // com.tencent.webbundle.sdk.IWebBundleRuntime
    public IWebBundleWebView createWebView(Context context) {
        WebBundleWebView webBundleWebView = new WebBundleWebView(context);
        WebSettings settings = webBundleWebView.getSettings();
        settings.setUserAgentString(i.n(settings.getUserAgentString(), "VipComic", webBundleWebView.getX5WebViewExtension() != null));
        return webBundleWebView;
    }
}

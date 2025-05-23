package com.tencent.mobileqq.wxmini.wxacontainer.growth;

import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* compiled from: P */
/* loaded from: classes35.dex */
public class GameGrowthWebView extends WebViewFragment {
    private WebViewClient ph() {
        return new a();
    }

    private void qh(WebView webView) {
        QLog.i("GameGrowthWebView", 1, "initWebView");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new ZKPageJSInterface(getHostActivity()), "__zkPage__");
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setWebView(TouchWebView touchWebView) {
        QLog.i("GameGrowthWebView", 1, "setWebView");
        touchWebView.setWebViewClient(ph());
        qh(touchWebView);
        super.setWebView(touchWebView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes35.dex */
    public class a extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        private boolean f327823b = true;

        a() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            this.f327823b = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.f327823b = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i("GameGrowthWebView", 1, "URLDecoder.decode, url:" + str);
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine == null) {
                    return false;
                }
                pluginEngine.v(str, this.f327823b);
                pluginEngine.k().b((CustomWebView) webView, str, pluginEngine.f314119i, this.f327823b);
                return false;
            } catch (Exception e16) {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.e("GameGrowthWebView", 2, "parseUrl error,exception:" + e16.toString());
                return false;
            }
        }
    }
}

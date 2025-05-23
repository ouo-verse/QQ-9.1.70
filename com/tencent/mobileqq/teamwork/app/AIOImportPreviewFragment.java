package com.tencent.mobileqq.teamwork.app;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqlive.module.videoreport.inject.webview.webclient.ReportX5CoreWebChromeClient;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

/* loaded from: classes18.dex */
public class AIOImportPreviewFragment extends WebViewFragment {
    private WebViewClient ph() {
        return new a();
    }

    private void qh(WebSettings webSettings) {
        if (webSettings == null) {
            return;
        }
        webSettings.setUserAgentString(com.tencent.mobileqq.webview.swift.utils.i.n(webSettings.getUserAgentString(), null, false));
        webSettings.setJavaScriptEnabled(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setCacheMode(-1);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        webSettings.setUseWideViewPort(true);
        webSettings.setAllowContentAccess(true);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setAppCacheEnabled(true);
    }

    private void rh(WebView webView) {
        Intent intent = this.intent;
        if (intent != null) {
            String stringExtra = intent.getStringExtra("cookie");
            if (!TextUtils.isEmpty(stringExtra)) {
                for (String str : stringExtra.split(";")) {
                    CookieManager.getInstance().setCookie(ITeamWorkHandler.DOCS_DOMAIN, str, true);
                }
            }
        }
        webView.setWebChromeClient(new ReportX5CoreWebChromeClient());
        webView.setScrollBarStyle(0);
        webView.requestFocus();
        WebView.setWebContentsDebuggingEnabled(true);
        webView.setFocusableInTouchMode(false);
        qh(webView.getSettings());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment
    public void setTitle(String str) {
        Intent intent = this.intent;
        if (intent != null) {
            str = intent.getStringExtra("title");
        }
        super.setTitle(str);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void setWebView(TouchWebView touchWebView) {
        touchWebView.setWebViewClient(ph());
        rh(touchWebView);
        super.setWebView(touchWebView);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes18.dex */
    public class a extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        private boolean f291871b = true;

        a() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            this.f291871b = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.f291871b = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            try {
                if (QLog.isColorLevel()) {
                    QLog.i(WebViewFragment.TAG, 1, "URLDecoder.decode, url:" + str);
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine == null) {
                    return false;
                }
                pluginEngine.v(str, this.f291871b);
                pluginEngine.k().b((CustomWebView) webView, str, pluginEngine.f314119i, this.f291871b);
                return false;
            } catch (Exception e16) {
                if (!QLog.isColorLevel()) {
                    return false;
                }
                QLog.e(WebViewFragment.TAG, 2, "parseUrl error,exception:" + e16.toString());
                return false;
            }
        }
    }
}

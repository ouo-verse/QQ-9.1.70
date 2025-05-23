package com.tencent.comic.webbundle;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.comic.ui.QQComicFragment;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.smtt.sdk.WebView;
import com.tencent.webbundle.sdk.WebBundleClient;
import com.tencent.webbundle.sdk.WebBundleConstants;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WebBundleFragment extends QQComicFragment {
    private WebBundleClient F = null;
    private String G = "";
    private String H = "";

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public String getUAMark() {
            return "VipComic";
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean interceptStartLoadUrl() {
            if ((WebBundleFragment.this.F != null && WebBundleFragment.this.F.interceptLoadUrl(((WebViewFragment) WebBundleFragment.this).intent)) || TextUtils.isEmpty(((WebViewFragment) WebBundleFragment.this).mUrl)) {
                return true;
            }
            ((WebViewFragment) WebBundleFragment.this).webView.loadUrl(((WebViewFragment) WebBundleFragment.this).mUrl);
            return true;
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onDataInit(Bundle bundle) {
            WebBundleFragment webBundleFragment = WebBundleFragment.this;
            webBundleFragment.G = ((WebViewFragment) webBundleFragment).intent.getStringExtra(WebBundleConstants.WEBBUNDLE_REAL_URL);
            WebBundleFragment webBundleFragment2 = WebBundleFragment.this;
            webBundleFragment2.H = ((WebViewFragment) webBundleFragment2).intent.getStringExtra(WebBundleConstants.WEBBUNDLE_PRELOAD_URL);
            String stringExtra = ((WebViewFragment) WebBundleFragment.this).intent.getStringExtra(WebBundleConstants.WEBBUNDLE_BUNDLE_DATA);
            if (!TextUtils.isEmpty(WebBundleFragment.this.H) && !TextUtils.isEmpty(WebBundleFragment.this.G) && !TextUtils.isEmpty(stringExtra)) {
                WebBundleFragment.this.F = new WebBundleClient("comic");
            }
            super.onDataInit(bundle);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            WebBundleFragment.this.onFinalState(bundle, this.webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.z
        public void onPageFinished(WebView webView, String str) {
            WebBundleFragment.this.yh(webView, str, this.webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
            WebBundleFragment.this.zh(bundle, touchWebView, this.webViewKernelCallBack);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public WebViewWrapper createWebViewWrapper(boolean z16) {
        WebBundleClient webBundleClient = this.F;
        if (webBundleClient == null) {
            return null;
        }
        Object validWebView = webBundleClient.getValidWebView(super.getQBaseActivity(), this.H);
        if (validWebView instanceof TouchWebView) {
            WebBundleReportUtils.b(this.G, true, WebBundleReportUtils.f99493a);
            return new WebViewWrapper(this.webViewSurface, this.intent, (TouchWebView) validWebView);
        }
        WebBundleReportUtils.b(this.G, false, WebBundleReportUtils.f99495c);
        return null;
    }

    @Override // com.tencent.comic.ui.QQComicFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }
}

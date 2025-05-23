package com.tencent.mobileqq.tvideo.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.tvideo.pullqqlive.h;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* loaded from: classes19.dex */
public class TVideoPublicWebView extends CustomWebView {
    private c C;
    private boolean D;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class b extends WebChromeClient {
        b() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            super.onProgressChanged(webView, i3);
        }
    }

    /* loaded from: classes19.dex */
    public interface c {
        void a(int i3);
    }

    public TVideoPublicWebView(Context context) {
        this(context, null);
    }

    private void B() {
        setPluginEngine(WebAccelerateHelper.getInstance().createWebViewPluginEngine(MobileQQ.sMobileQQ.peekAppRuntime(), Foreground.getTopActivity(), this, null));
        setWebViewClient(new a());
        setWebChromeClient(new b());
        setBackgroundColor(0);
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.startsWith("txvideo://") && !str.startsWith("tenvideo2://") && !str.startsWith("tenvideo3://")) {
            return false;
        }
        return true;
    }

    private void E() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setDomStorageEnabled(true);
    }

    public void D(String str, String str2) {
        d.s(this, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.smtt.sdk.WebView, android.view.View
    public void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(i3);
        }
    }

    public void setVisibilityChangeListener(c cVar) {
        this.C = cVar;
    }

    public TVideoPublicWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.D = true;
        B();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes19.dex */
    public class a extends WebViewClient {
        a() {
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (((CustomWebView) TVideoPublicWebView.this).mPluginEngine != null) {
                ((CustomWebView) TVideoPublicWebView.this).mPluginEngine.s(str, 8589934594L, null);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
            if (((CustomWebView) TVideoPublicWebView.this).mPluginEngine != null) {
                ((CustomWebView) TVideoPublicWebView.this).mPluginEngine.s(str, 8589934593L, null);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            if (((CustomWebView) TVideoPublicWebView.this).mPluginEngine != null) {
                ((CustomWebView) TVideoPublicWebView.this).mPluginEngine.q(str2, 8589934595L, i3);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            TVideoPublicWebView.this.D = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            TVideoPublicWebView.this.D = true;
            return shouldOverrideUrlLoading;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            QLog.i("TVideoPublicWebView", 1, "shouldOverrideUrlLoading url = " + str);
            if (!TVideoPublicWebView.this.C(str)) {
                return ((CustomWebView) TVideoPublicWebView.this).mPluginEngine != null && ((CustomWebView) TVideoPublicWebView.this).mPluginEngine.S(str, TVideoPublicWebView.this.D);
            }
            QLog.i("TVideoPublicWebView", 1, "startActionUrl url = " + str);
            h.p(webView.getContext(), str);
            return true;
        }
    }
}

package com.tencent.ams.fusion.widget.downloadcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.ams.fusion.widget.utils.IFusionWebView;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.webview.QmWebview;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DefaultFusionWebViewImpl implements IFusionWebView {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "FusionWebViewImpl";
    private WebView mWebView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultFusionWebViewImpl(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        if (context == null) {
            Logger.e(TAG, "[DefaultFusionWebViewImpl]: context is null");
            return;
        }
        QmWebview qmWebview = new QmWebview(context);
        this.mWebView = qmWebview;
        qmWebview.setScrollBarStyle(33554432);
        this.mWebView.setScrollbarFadingEnabled(false);
        this.mWebView.setBackgroundColor(0);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.tencent.ams.fusion.widget.downloadcard.DefaultFusionWebViewImpl.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultFusionWebViewImpl.this);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                JsInjector.getInstance().onPageStarted(webView);
                super.onPageStarted(webView, str, bitmap);
            }

            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) webView, (Object) webResourceRequest)).booleanValue();
                }
                return false;
            }
        });
        WebSettings settings = this.mWebView.getSettings();
        if (settings != null) {
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptEnabled(true);
            int i3 = Build.VERSION.SDK_INT;
            settings.setMediaPlaybackRequiresUserGesture(false);
            settings.setAllowFileAccess(true);
            settings.setMixedContentMode(2);
            settings.setUseWideViewPort(true);
            settings.setLoadWithOverviewMode(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);
            settings.setAllowContentAccess(true);
            if (i3 >= 29) {
                if (ViewUtils.isDarkMode()) {
                    settings.setForceDark(2);
                } else {
                    settings.setForceDark(0);
                }
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.IFusionWebView
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            try {
                this.mWebView.destroy();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.utils.IFusionWebView
    public View getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mWebView;
    }

    @Override // com.tencent.ams.fusion.widget.utils.IFusionWebView
    public void loadUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            Logger.e(TAG, "[loadUrl]: url is empty");
            return;
        }
        WebView webView = this.mWebView;
        if (webView == null) {
            Logger.e(TAG, "[loadUrl]: mWebView is null");
        } else {
            webView.loadUrl(str);
        }
    }
}

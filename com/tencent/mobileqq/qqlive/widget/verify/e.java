package com.tencent.mobileqq.qqlive.widget.verify;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.z;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes17.dex */
public class e extends WebViewWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    private Activity f274079j;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a extends WebChromeClient {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        @SuppressLint({"InflateParams"})
        public View getVideoLoadingProgressView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return e.this.G();
            }
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                e.this.H(str, geolocationPermissionsCallback);
            } else {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                e.this.I();
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, this, webView, str, str2, jsResult)).booleanValue();
            }
            if (((WebViewWrapper) e.this).f314154a != null) {
                ((WebViewWrapper) e.this).f314154a.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                e.this.J(webView, i3);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, i3);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                e.this.K(webView, str);
            } else {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) webView, (Object) str);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                e.this.M(view, customViewCallback);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) customViewCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, this, webView, valueCallback, fileChooserParams)).booleanValue();
            }
            if (m.c().j(webView, valueCallback, e.this.f274079j, fileChooserParams)) {
                return true;
            }
            if (valueCallback != null && ((WebViewWrapper) e.this).f314154a != null) {
                return ((WebViewWrapper) e.this).f314154a.onShowFileChooser(valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
                e.this.N(valueCallback, str, str2);
            } else {
                iPatchRedirector.redirect((short) 9, this, valueCallback, str, str2);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                e.this.L(view, i3, customViewCallback);
            } else {
                iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), customViewCallback);
            }
        }
    }

    public e(Activity activity, z zVar, Intent intent, boolean z16) {
        super(zVar, intent, activity, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, zVar, intent, Boolean.valueOf(z16));
        } else {
            this.f274079j = activity;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"InflateParams"})
    public View G() {
        z zVar = this.f314154a;
        if (zVar != null) {
            return zVar.getVideoLoadingProgressView();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        z zVar = this.f314154a;
        if (zVar != null) {
            zVar.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        z zVar = this.f314154a;
        if (zVar != null) {
            zVar.onHideCustomView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(WebView webView, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "onProgressChanged:" + i3);
        }
        z zVar = this.f314154a;
        if (zVar != null) {
            zVar.onProgressChanged(webView, i3);
        }
        if (i3 > 30 && !webView.getSettings().getLoadsImagesAutomatically()) {
            webView.getSettings().setLoadsImagesAutomatically(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(WebView webView, String str) {
        z zVar = this.f314154a;
        if (zVar != null) {
            zVar.onReceivedTitle(webView, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        z zVar = this.f314154a;
        if (zVar != null) {
            zVar.showCustomView(view, i3, customViewCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        z zVar = this.f314154a;
        if (zVar != null) {
            zVar.showCustomView(view, 10, customViewCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(ValueCallback<Uri> valueCallback, String str, String str2) {
        z zVar;
        if (!m.c().k(valueCallback, str, this.f274079j) && (zVar = this.f314154a) != null) {
            zVar.openFileChooser(valueCallback, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    public TouchWebView p(TouchWebView touchWebView, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 2, (Object) this, (Object) touchWebView, (Object) intent);
        }
        super.p(touchWebView, intent);
        m.c().l(touchWebView, BaseApplication.getContext());
        touchWebView.setWebChromeClient(new a());
        return touchWebView;
    }
}

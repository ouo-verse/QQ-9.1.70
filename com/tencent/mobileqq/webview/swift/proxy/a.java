package com.tencent.mobileqq.webview.swift.proxy;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webview.swift.ad;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class a implements t {
    static IPatchRedirector $redirector_;
    protected t webViewKernelCallBack;

    public a(@NonNull t tVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tVar);
        } else {
            this.webViewKernelCallBack = tVar;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean afterWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        return this.webViewKernelCallBack.afterWebViewEngineHandleOverrideUrl(webView, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean beforeWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        return this.webViewKernelCallBack.beforeWebViewEngineHandleOverrideUrl(webView, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public int getCacheMode(ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) adVar)).intValue();
        }
        return this.webViewKernelCallBack.getCacheMode(adVar);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public DownloadListener getDownloadListener(CustomWebView customWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (DownloadListener) iPatchRedirector.redirect((short) 43, (Object) this, (Object) customWebView);
        }
        return this.webViewKernelCallBack.getDownloadListener(customWebView);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUAMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return (String) iPatchRedirector.redirect((short) 38, (Object) this);
        }
        return this.webViewKernelCallBack.getUAMark();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUserAgent(String str, String str2, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, this, str, str2, bool);
        }
        return this.webViewKernelCallBack.getUserAgent(str, str2, bool);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public View getVideoLoadingProgressView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (View) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return this.webViewKernelCallBack.getVideoLoadingProgressView();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void handlePreloadCallback(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3, (Object) str);
        } else {
            this.webViewKernelCallBack.handlePreloadCallback(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public Object handlerMiscCallback(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return iPatchRedirector.redirect((short) 36, (Object) this, (Object) str, (Object) bundle);
        }
        return this.webViewKernelCallBack.handlerMiscCallback(str, bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean interceptInitUIFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.webViewKernelCallBack.interceptInitUIFrame();
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean interceptStartLoadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.webViewKernelCallBack.interceptStartLoadUrl();
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean interceptTouchEvent(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean interceptUserAgentGenerate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return this.webViewKernelCallBack.interceptUserAgentGenerate();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean isFinishing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return ((Boolean) iPatchRedirector.redirect((short) 44, (Object) this)).booleanValue();
        }
        return this.webViewKernelCallBack.isFinishing();
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void loadUrlFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.webViewKernelCallBack.loadUrlFinish();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onDataInit(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
        } else {
            this.webViewKernelCallBack.onDataInit(bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onDetectedBlankScreen(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) str, i3);
        } else {
            this.webViewKernelCallBack.onDetectedBlankScreen(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onFinalState(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle);
        } else {
            this.webViewKernelCallBack.onFinalState(bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
        } else {
            this.webViewKernelCallBack.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onHideCustomView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else {
            this.webViewKernelCallBack.onHideCustomView();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onInitBottomBar(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
        } else {
            this.webViewKernelCallBack.onInitBottomBar(bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onInitTitleBar(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        } else {
            this.webViewKernelCallBack.onInitTitleBar(bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onInitUIContent(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        } else {
            this.webViewKernelCallBack.onInitUIContent(bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, this, webView, str, str2, jsResult)).booleanValue();
        }
        return this.webViewKernelCallBack.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onLongClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Boolean) iPatchRedirector.redirect((short) 37, (Object) this, (Object) view)).booleanValue();
        }
        return this.webViewKernelCallBack.onLongClick(view);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageCommitVisible(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) webView, (Object) str);
        } else {
            this.webViewKernelCallBack.onPageCommitVisible(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageFinished(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) webView, (Object) str);
        } else {
            this.webViewKernelCallBack.onPageFinished(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, webView, str, bitmap);
        } else {
            this.webViewKernelCallBack.onPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) permissionRequest);
        } else {
            this.webViewKernelCallBack.onPermissionRequest(permissionRequest);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onProgressChanged(WebView webView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) webView, i3);
        } else {
            this.webViewKernelCallBack.onProgressChanged(webView, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, webView, Integer.valueOf(i3), str, str2);
        } else {
            this.webViewKernelCallBack.onReceivedError(webView, i3, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, this, webView, sslErrorHandler, sslError)).booleanValue();
        }
        return this.webViewKernelCallBack.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedTitle(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) webView, (Object) str);
        } else {
            this.webViewKernelCallBack.onReceivedTitle(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) valueCallback, (Object) fileChooserParams)).booleanValue();
        }
        return this.webViewKernelCallBack.onShowFileChooser(valueCallback, fileChooserParams);
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onShowPreview(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle);
        } else {
            this.webViewKernelCallBack.onShowPreview(bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onUrlChange(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) str2);
        } else {
            this.webViewKernelCallBack.onUrlChange(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onWebViewClientImplPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, this, webView, str, bitmap);
        } else {
            this.webViewKernelCallBack.onWebViewClientImplPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onWebViewInit(Bundle bundle, TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle, (Object) touchWebView);
        } else {
            this.webViewKernelCallBack.onWebViewInit(bundle, touchWebView);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public void onX5Init(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            this.webViewKernelCallBack.onX5Init(bundle);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, valueCallback, str, str2);
        } else {
            this.webViewKernelCallBack.openFileChooser(valueCallback, str, str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        return this.webViewKernelCallBack.shouldOverrideUrlLoading(webView, str);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void showCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, view, Integer.valueOf(i3), customViewCallback);
        } else {
            this.webViewKernelCallBack.showCustomView(view, i3, customViewCallback);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.utils.t
    public boolean softKeyboardResizeCompactOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.webViewKernelCallBack.softKeyboardResizeCompactOn();
    }
}

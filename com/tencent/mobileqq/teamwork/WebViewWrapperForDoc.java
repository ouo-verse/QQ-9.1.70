package com.tencent.mobileqq.teamwork;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class WebViewWrapperForDoc extends WebViewWrapper {

    /* renamed from: j, reason: collision with root package name */
    public boolean f291580j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends WebViewClientImpl {
        b() {
            super();
        }

        @Override // com.tencent.mobileqq.teamwork.WebViewWrapperForDoc.WebViewClientImpl, com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            return a(webView, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame());
        }
    }

    public WebViewWrapperForDoc(Activity activity, com.tencent.mobileqq.webview.swift.z zVar, Intent intent, boolean z16) {
        super(zVar, intent, activity, z16);
    }

    private void f(TouchWebView touchWebView) {
        a aVar = new a();
        touchWebView.setWebChromeClient(aVar);
        this.f314157d = aVar;
    }

    void g(TouchWebView touchWebView) {
        touchWebView.setWebViewClient(new b());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    public TouchWebView h(Context context, boolean z16) {
        TouchWebView touchWebView;
        com.tencent.biz.common.util.k.a(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = true;
        if (TenDocWebPreLoadHelper.b(context, this.f314156c.getStringExtra("url"))) {
            touchWebView = TenDocWebPreLoadHelper.a(context);
            if (touchWebView != null) {
                this.f291580j = true;
            }
        } else {
            touchWebView = null;
        }
        if (touchWebView == null) {
            if (z16) {
                if (SwiftReuseTouchWebView.I != 0) {
                    z17 = false;
                }
                touchWebView = SwiftReuseTouchWebView.q(context);
            } else {
                touchWebView = new TouchWebView(context);
            }
        } else {
            z17 = false;
        }
        DisplayMetrics displayMetrics = MobileQQ.sMobileQQ.getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = touchWebView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
        }
        touchWebView.setLayoutParams(layoutParams);
        if (z17) {
            this.f314159f = System.currentTimeMillis() - currentTimeMillis;
        }
        return touchWebView;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    public void i() {
        if (this.f314154a != null) {
            this.f314154a = null;
        }
        TouchWebView touchWebView = this.f314155b;
        if (touchWebView != null) {
            WebViewPluginEngine pluginEngine = touchWebView.getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.H();
            }
            this.f314155b.setPluginEngine(null);
            if (this.f314155b.getParent() != null) {
                try {
                    ((ViewGroup) this.f314155b.getParent()).removeView(this.f314155b);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("WebLog_WebViewWrapper", 2, "remove webview error");
                    }
                }
            }
            try {
                this.f314155b.stopLoading();
            } catch (Exception unused2) {
            }
            if (this.f291580j) {
                bo.b().h(this.f314155b);
            } else {
                this.f314155b.loadUrlOriginal("about:blank");
                this.f314155b.clearView();
                this.f314155b.destroy();
            }
            this.f314155b = null;
        }
        com.tencent.biz.pubaccount.h hVar = this.f314157d;
        if (hVar != null) {
            hVar.a();
            this.f314157d = null;
        }
    }

    String l(com.tencent.mobileqq.webview.swift.z zVar) {
        if (zVar != null) {
            return zVar.getUAMark();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0103, code lost:
    
        if (r3.hasSystemFeature("android.hardware.faketouch.multitouch.distinct") != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ca  */
    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TouchWebView p(TouchWebView touchWebView, Intent intent) {
        String str;
        boolean z16;
        boolean z17;
        boolean z18;
        int lastIndexOf;
        long j3 = this.f314159f;
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + j3);
        }
        touchWebView.setIntent(intent);
        com.tencent.biz.common.util.k.d(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        long currentTimeMillis = System.currentTimeMillis();
        g(touchWebView);
        f(touchWebView);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        touchWebView.setScrollBarStyle(0);
        com.tencent.biz.common.util.k.a(AbsBaseWebViewActivity.WEBVIEW_ADJUST_SETTINGS);
        WebSettings settings = touchWebView.getSettings();
        com.tencent.biz.common.util.k.a(AbsBaseWebViewActivity.WEBVIEW_SET_USER_AGENT);
        String str2 = "";
        if (!new ta1.n().a()) {
            str = "";
        } else {
            str = " _tdocFlag/1";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("tendocpreload get UA");
        IGetExternalInterface iGetExternalInterface = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
        String userAgentString = settings.getUserAgentString();
        String l3 = l(this.f314154a);
        if (touchWebView.getX5WebViewExtension() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(iGetExternalInterface.getWebViewUAForQQ(userAgentString, l3, z16));
        QLog.i("WebLog_WebViewWrapper", 1, sb5.toString());
        StringBuilder sb6 = new StringBuilder();
        IGetExternalInterface iGetExternalInterface2 = (IGetExternalInterface) QRoute.api(IGetExternalInterface.class);
        String userAgentString2 = settings.getUserAgentString();
        String l16 = l(this.f314154a);
        if (touchWebView.getX5WebViewExtension() != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb6.append(iGetExternalInterface2.getWebViewUAForQQ(userAgentString2, l16, z17));
        sb6.append(str);
        settings.setUserAgentString(sb6.toString());
        com.tencent.biz.common.util.k.d(AbsBaseWebViewActivity.WEBVIEW_SET_USER_AGENT);
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        PackageManager packageManager = BaseApplication.getContext().getPackageManager();
        try {
            if (!packageManager.hasSystemFeature("android.hardware.touchscreen.multitouch")) {
            }
            z18 = true;
        } catch (RuntimeException unused) {
        }
        settings.setDisplayZoomControls(!z18);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
        if (qQProcessName != null && (lastIndexOf = qQProcessName.lastIndexOf(58)) > -1) {
            str2 = "_" + qQProcessName.substring(lastIndexOf + 1);
        }
        String str3 = str2;
        settings.setDatabasePath(BaseApplication.getContext().getDir("database" + str3, 0).getPath());
        settings.setAppCachePath(BaseApplication.getContext().getDir("appcache" + str3, 0).getPath());
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
        touchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        try {
            touchWebView.requestFocus();
        } catch (Exception unused2) {
        }
        touchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(BaseApplication.getContext());
        if (touchWebView.getX5WebViewExtension() == null) {
            touchWebView.getX5WebViewExtension().setWebViewClientExtension(new c(touchWebView, this.f314154a));
            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).addAioParamForX5(intent);
        } else {
            ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).addAioParamForSystem(intent);
        }
        com.tencent.biz.common.util.k.d(AbsBaseWebViewActivity.WEBVIEW_ADJUST_SETTINGS);
        if (((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getReportPerformance()) {
            HashMap<String, String> hashMap = new HashMap<>(5);
            hashMap.put("createWebview", String.valueOf(j3));
            hashMap.put("initWebClient", String.valueOf(currentTimeMillis2));
            hashMap.put("setWebSetting", String.valueOf(currentTimeMillis3));
            hashMap.put("coreInit", String.valueOf(((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getWebAcceleratorCostTime()));
            hashMap.put("coldStart", String.valueOf(((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getPreloadWebProcess()));
            StatisticCollector.getInstance(BaseApplication.getContext().getApplicationContext()).collectPerformance(null, "actWebviewInit", true, 0L, 0L, hashMap, null);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "sReportPerformance:", Boolean.valueOf(((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getReportPerformance()), " cost:", Long.valueOf(((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getWebAcceleratorCostTime()));
        }
        return touchWebView;
        z18 = false;
        settings.setDisplayZoomControls(!z18);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String qQProcessName2 = MobileQQ.getMobileQQ().getQQProcessName();
        if (qQProcessName2 != null) {
            str2 = "_" + qQProcessName2.substring(lastIndexOf + 1);
        }
        String str32 = str2;
        settings.setDatabasePath(BaseApplication.getContext().getDir("database" + str32, 0).getPath());
        settings.setAppCachePath(BaseApplication.getContext().getDir("appcache" + str32, 0).getPath());
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        long currentTimeMillis32 = System.currentTimeMillis() - currentTimeMillis;
        touchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        touchWebView.requestFocus();
        touchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(BaseApplication.getContext());
        if (touchWebView.getX5WebViewExtension() == null) {
        }
        com.tencent.biz.common.util.k.d(AbsBaseWebViewActivity.WEBVIEW_ADJUST_SETTINGS);
        if (((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getReportPerformance()) {
        }
        if (QLog.isColorLevel()) {
        }
        return touchWebView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends com.tencent.biz.pubaccount.h {
        a() {
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        @SuppressLint({"InflateParams"})
        public View getVideoLoadingProgressView() {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                return ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.getVideoLoadingProgressView();
            }
            return null;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onHideCustomView();
            }
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onPermissionRequest(permissionRequest);
            }
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewWrapper", 2, "onProgressChanged:" + i3);
            }
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onProgressChanged(webView, i3);
            }
            if (i3 > 30 && !webView.getSettings().getLoadsImagesAutomatically()) {
                webView.getSettings().setLoadsImagesAutomatically(true);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onReceivedTitle(webView, str);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.showCustomView(view, 10, customViewCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            if (valueCallback != null && ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                return ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onShowFileChooser(valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.openFileChooser(valueCallback, str, str2);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.showCustomView(view, i3, customViewCallback);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class WebViewClientImpl extends WebViewClient {

        /* renamed from: b, reason: collision with root package name */
        private boolean f291581b = true;

        /* renamed from: c, reason: collision with root package name */
        ArrayMap<String, Object> f291582c;

        WebViewClientImpl() {
        }

        WebResourceResponse a(WebView webView, final String str, final boolean z16) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(IPublicAccountH5AbilityPlugin.LOCALID_HEAD)) {
                return ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).getWebResponse(str);
            }
            final WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine == null) {
                return null;
            }
            if (str.startsWith("https://jsbridge/")) {
                str = str.replace("https://jsbridge/", "jsbridge://");
            } else if (str.startsWith("http://jsbridge/")) {
                str = str.replace("http://jsbridge/", "jsbridge://");
            }
            if (QLog.isColorLevel()) {
                if (str.startsWith("jsbridge://") && str.length() > 512) {
                    QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str.substring(0, 512));
                } else {
                    QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str);
                }
            }
            if (str.startsWith("jsbridge:") && ((WebViewWrapper) WebViewWrapperForDoc.this).f314155b != null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.teamwork.WebViewWrapperForDoc.WebViewClientImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        pluginEngine.S(str, z16);
                    }
                });
                WebResourceResponse webResourceResponse = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
                Map<String, String> responseHeaders = webResourceResponse.getResponseHeaders();
                if (responseHeaders == null) {
                    responseHeaders = new HashMap<>();
                }
                responseHeaders.put("cache-control", "must-revalidate\uff0cno-store");
                webResourceResponse.setResponseHeaders(responseHeaders);
                return webResourceResponse;
            }
            try {
                Object r16 = pluginEngine.r(str, 8L);
                if (!(r16 instanceof WebResourceResponse)) {
                    return null;
                }
                return (WebResourceResponse) r16;
            } catch (Exception e16) {
                QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error:" + e16.getMessage());
                return null;
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onDetectedBlankScreen(String str, int i3) {
            QLog.i("WebLog_WebViewWrapper", 1, "onDetectedBlankScreen, status: " + i3 + ", url:" + str);
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onDetectedBlankScreen(str, i3);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            if (!WebViewWrapperForDoc.this.q() && ((WebViewWrapper) WebViewWrapperForDoc.this).f314155b != null) {
                QLog.d("WebLog_WebViewWrapper", 1, "onPageFinished:" + str);
                super.onPageFinished(webView, str);
                if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                    ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onPageFinished(webView, str);
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.s(str, 8589934594L, null);
                }
                ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).paramInitFinish(((WebViewWrapper) WebViewWrapperForDoc.this).f314156c);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            if (!WebViewWrapperForDoc.this.q() && ((WebViewWrapper) WebViewWrapperForDoc.this).f314155b != null) {
                QLog.d("WebLog_WebViewWrapper", 1, "onPageStarted:" + str);
                super.onPageStarted(webView, str, bitmap);
                if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                    ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onPageStarted(webView, str, bitmap);
                    ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onWebViewClientImplPageStarted(webView, str, bitmap);
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.s(str, 8589934593L, null);
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            if (!WebViewWrapperForDoc.this.q() && ((WebViewWrapper) WebViewWrapperForDoc.this).f314155b != null) {
                QLog.e("WebLog_WebViewWrapper", 1, "onReceivedError:" + i3 + ", desc=" + str + ", url=" + str2);
                if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                    ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onReceivedError(webView, i3, str, str2);
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.q(str2, 8589934595L, i3);
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewPluginEngine pluginEngine;
            if (webView != null && webResourceRequest != null && webResourceResponse != null) {
                QLog.e("WebLog_WebViewWrapper", 1, "onReceivedHttpError:" + webResourceRequest.getUrl() + "Occur error, resp code=" + webResourceResponse.getStatusCode());
                String url = webView.getUrl();
                if (url != null && AuthorizeConfig.y().l0(url) && (pluginEngine = ((CustomWebView) webView).getPluginEngine()) != null) {
                    if (this.f291582c == null) {
                        this.f291582c = new ArrayMap<>(4);
                    }
                    this.f291582c.put(WebViewPlugin.KEY_REQUEST, webResourceRequest);
                    this.f291582c.put(WebViewPlugin.KEY_RESPONSE, webResourceResponse);
                    this.f291582c.put("errorCode", Integer.valueOf(webResourceResponse.getStatusCode()));
                    pluginEngine.s(url, 64L, this.f291582c);
                    pluginEngine.s(url, 8589934612L, this.f291582c);
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String sslCertificate;
            if (!WebViewWrapperForDoc.this.q() && ((WebViewWrapper) WebViewWrapperForDoc.this).f314155b != null) {
                SslCertificate certificate = sslError.getCertificate();
                String url = webView.getUrl();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onReceivedSslError:");
                sb5.append(sslError.getPrimaryError());
                sb5.append(", cert=");
                if (certificate == null) {
                    sslCertificate = "null";
                } else {
                    sslCertificate = certificate.toString();
                }
                sb5.append(sslCertificate);
                sb5.append(", pageUrl=");
                sb5.append(com.tencent.biz.common.util.k.f(url, new String[0]));
                QLog.e("WebLog_WebViewWrapper", 1, sb5.toString());
                if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                    ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.onReceivedSslError(webView, sslErrorHandler, sslError);
                }
                sslErrorHandler.cancel();
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            this.f291581b = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.f291581b = true;
            return shouldOverrideUrlLoading;
        }

        /* JADX WARN: Code restructure failed: missing block: B:76:0x01c9, code lost:
        
            if (r8.s(r2, 16, null) == false) goto L84;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:?, code lost:
        
            return true;
         */
        @Override // com.tencent.smtt.sdk.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewPluginEngine pluginEngine;
            String str2 = str;
            if (((WebViewWrapper) WebViewWrapperForDoc.this).f314155b != null && !WebViewWrapperForDoc.this.q()) {
                if (!TextUtils.isEmpty(str) && !"about:blank;".equals(str2) && !"about:blank".equals(str2)) {
                    ta1.n nVar = new ta1.n();
                    if (str2.startsWith("mqqapi:") && str2.contains("getTcntDocData") && nVar.a()) {
                        String queryParameter = Uri.parse(str).getQueryParameter("id");
                        bo.f(queryParameter, ((WebViewWrapper) WebViewWrapperForDoc.this).f314155b);
                        if (((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).isInstanceTeamWorkDocEditBrowserFragment(((WebViewWrapper) WebViewWrapperForDoc.this).f314154a)) {
                            bo.f(queryParameter, ((WebViewWrapper) WebViewWrapperForDoc.this).f314155b);
                        } else {
                            bo.b().h(WebViewWrapperForDoc.this.n());
                        }
                        return true;
                    }
                    if (str2.startsWith("https://jsbridge/")) {
                        str2 = str2.replace("https://jsbridge/", "jsbridge://");
                    } else if (str2.startsWith("http://jsbridge/")) {
                        str2 = str2.replace("http://jsbridge/", "jsbridge://");
                    }
                    if (QLog.isColorLevel()) {
                        if (str2.startsWith("jsbridge://") && str2.length() > 512) {
                            QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + str2.substring(0, 512));
                        } else {
                            QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + com.tencent.biz.common.util.k.f(str2, new String[0]));
                        }
                    }
                    ((IGetExternalInterface) QRoute.api(IGetExternalInterface.class)).endUrlLoad(((WebViewWrapper) WebViewWrapperForDoc.this).f314156c, str2);
                    String d16 = com.tencent.mobileqq.teamwork.b.d(str2);
                    if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null && ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.beforeWebViewEngineHandleOverrideUrl(((WebViewWrapper) WebViewWrapperForDoc.this).f314155b, str2)) {
                        QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
                        return true;
                    }
                    if (("http".equals(d16) || "data".equals(d16)) && !str2.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) {
                        CustomWebView.addContextLog(com.tencent.biz.common.util.k.f(str2, new String[0]));
                    }
                    try {
                        pluginEngine = ((CustomWebView) webView).getPluginEngine();
                    } catch (RuntimeException e16) {
                        String stackTraceString = QLog.getStackTraceString(e16);
                        ReportController.n(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, stackTraceString.length() > 255 ? stackTraceString.substring(0, 255) : stackTraceString, "", "", "");
                        QLog.e("WebLog_WebViewWrapper", 1, stackTraceString);
                    }
                    if (pluginEngine != null && pluginEngine.s(str2, 1024L, null)) {
                        QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
                        return true;
                    }
                    if (pluginEngine != null && pluginEngine.S(str2, this.f291581b)) {
                        return true;
                    }
                    if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null && ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.shouldOverrideUrlLoading(webView, str2)) {
                        return true;
                    }
                    if (!"http".equals(d16) && !"https".equals(d16) && !"data".equals(d16) && !"file".equals(d16)) {
                        if (((WebViewWrapper) WebViewWrapperForDoc.this).f314154a != null) {
                            ((WebViewWrapper) WebViewWrapperForDoc.this).f314154a.afterWebViewEngineHandleOverrideUrl(((WebViewWrapper) WebViewWrapperForDoc.this).f314155b, str2);
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
                StringBuilder sb5 = new StringBuilder("shouldOverrideUrlLoading fail , url=[");
                sb5.append(str2);
                sb5.append("].");
                QLog.e("WebLog_WebViewWrapper", 1, sb5);
                return true;
            }
            QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    final class c extends ProxyWebViewClientExtension {

        /* renamed from: b, reason: collision with root package name */
        final TouchWebView f291590b;

        /* renamed from: c, reason: collision with root package name */
        com.tencent.mobileqq.webview.swift.z f291591c;

        /* renamed from: d, reason: collision with root package name */
        ArrayMap<String, Object> f291592d;

        public c(TouchWebView touchWebView, com.tencent.mobileqq.webview.swift.z zVar) {
            this.f291590b = touchWebView;
            this.f291591c = zVar;
        }

        void a(Object obj, Object obj2, Object obj3, Object obj4) {
            WebViewPluginEngine pluginEngine = this.f291590b.getPluginEngine();
            if (pluginEngine != null) {
                if (this.f291592d == null) {
                    this.f291592d = new ArrayMap<>(4);
                }
                this.f291592d.put("performanceData", obj);
                this.f291592d.put(WebViewPlugin.KEY_REQUEST, obj2);
                this.f291592d.put(WebViewPlugin.KEY_RESPONSE, obj3);
                this.f291592d.put("errorCode", obj4);
                pluginEngine.s(this.f291590b.getUrl(), 64L, this.f291592d);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebCoreDump", 2, "No JS plugin engine to web core dump");
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void computeScroll(View view) {
            this.f291590b.computeScroll(view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            return this.f291590b.dispatchTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            return this.f291590b.onInterceptTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
            if (!str.equalsIgnoreCase("onReportResourceInfo") && !str.equalsIgnoreCase("onResourcesPerformance")) {
                if (!str.equalsIgnoreCase("onReportSetCookieInfo")) {
                    return null;
                }
                com.tencent.mobileqq.webview.swift.utils.i.t(bundle);
                return null;
            }
            a(obj, obj2, obj3, obj4);
            return null;
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view) {
            this.f291590b.onOverScrolled(i3, i16, z16, z17, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onPrefetchResourceHit(boolean z16) {
            QLog.i("WebLog_WebViewWrapper", 1, "now prefetchResource is hit: " + z16);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onPreloadCallback(int i3, String str) {
            com.tencent.mobileqq.webview.swift.z zVar = this.f291591c;
            if (zVar != null) {
                zVar.handlePreloadCallback(i3, str);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i3) {
            a(null, webResourceRequest, webResourceResponse, Integer.valueOf(i3));
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            this.f291590b.onScrollChanged(i3, i16, i17, i18, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onTouchEvent(MotionEvent motionEvent, View view) {
            return this.f291590b.onTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onUrlChange(String str, String str2) {
            SwiftBrowserCookieMonster.H();
            com.tencent.mobileqq.webview.swift.z zVar = this.f291591c;
            if (zVar != null) {
                zVar.onUrlChange(str, str2);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
            return this.f291590b.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle) {
            QLog.d("WebLog_WebViewWrapper", 1, "onMiscCallBack for one args: " + str);
            com.tencent.mobileqq.webview.swift.z zVar = this.f291591c;
            if (zVar != null) {
                return zVar.handlerMiscCallback(str, bundle);
            }
            if (!str.equalsIgnoreCase("onReportSetCookieInfo")) {
                return null;
            }
            com.tencent.mobileqq.webview.swift.utils.i.t(bundle);
            return null;
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    protected void r() {
    }
}

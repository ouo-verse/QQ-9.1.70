package com.tencent.mobileqq.webview.swift;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.dynamicwidget.http.Method;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.DebugTrace;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
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
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.widget.TraceUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewWrapper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected z f314154a;

    /* renamed from: b, reason: collision with root package name */
    protected TouchWebView f314155b;

    /* renamed from: c, reason: collision with root package name */
    protected Intent f314156c;

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.biz.pubaccount.h f314157d;

    /* renamed from: e, reason: collision with root package name */
    protected com.tencent.mobileqq.webview.html.l f314158e;

    /* renamed from: f, reason: collision with root package name */
    public long f314159f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f314160g;

    /* renamed from: h, reason: collision with root package name */
    private q f314161h;

    /* renamed from: i, reason: collision with root package name */
    private j f314162i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends WebViewClientImpl {
        static IPatchRedirector $redirector_;

        b() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewWrapper.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl, com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            super.onPageStarted(webView, str, bitmap);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (WebResourceResponse) iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, (Object) webResourceRequest);
            }
            return a(webView, d.a(webResourceRequest));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public String f314182a;

        /* renamed from: b, reason: collision with root package name */
        public String f314183b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f314184c;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f314182a = "";
            this.f314183b = "";
            this.f314184c = false;
        }

        public static d a(WebResourceRequest webResourceRequest) {
            d dVar = new d();
            dVar.f314182a = webResourceRequest.getUrl().toString();
            dVar.f314183b = webResourceRequest.getMethod();
            dVar.f314184c = webResourceRequest.isForMainFrame();
            return dVar;
        }
    }

    public WebViewWrapper(z zVar, Intent intent, Context context, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, zVar, intent, context, Boolean.valueOf(z16));
            return;
        }
        this.f314159f = 0L;
        this.f314160g = true;
        this.f314154a = zVar;
        this.f314156c = intent;
        this.f314155b = h(context, z16);
        r();
        p(this.f314155b, intent);
    }

    private void f(TouchWebView touchWebView) {
        a aVar = new a();
        touchWebView.setWebChromeClient(aVar);
        this.f314157d = aVar;
    }

    private void j(long j3, long j16, long j17) {
        if (SwiftBrowserStatistics.f314346k1 || !((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            HashMap hashMap = new HashMap(5);
            hashMap.put("createWebview", String.valueOf(j3));
            hashMap.put("initWebClient", String.valueOf(j16));
            hashMap.put("setWebSetting", String.valueOf(j17));
            hashMap.put("coreInit", String.valueOf(SwiftBrowserStatistics.W0));
            hashMap.put("coldStart", String.valueOf(SwiftBrowserStatistics.f314343h1));
            ThreadManagerV2.excute(new Runnable(hashMap) { // from class: com.tencent.mobileqq.webview.swift.WebViewWrapper.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ HashMap f314163d;

                {
                    this.f314163d = hashMap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewWrapper.this, (Object) hashMap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance(null, "actWebviewInit", true, 0L, 0L, this.f314163d, null);
                    }
                }
            }, 128, null, true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "sReportPerformance:", Boolean.valueOf(SwiftBrowserStatistics.f314346k1), " cost:", Long.valueOf(SwiftBrowserStatistics.W0));
        }
    }

    private void o(WebSettings webSettings, TouchWebView touchWebView) {
        boolean z16;
        boolean z17;
        String str;
        try {
            int i3 = 0;
            if (touchWebView.getX5WebViewExtension() == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106124", false);
            if (QLog.isColorLevel()) {
                QLog.i("WebLog_WebViewWrapper", 2, "initDarkMode isSysCore:" + z16 + ", isAdaptDarkSwitch:" + isSwitchOn);
            }
            String str2 = "dark_on";
            if (isSwitchOn) {
                IX5WebSettingsExtension settingsExtension = touchWebView.getSettingsExtension();
                if (settingsExtension != null) {
                    if (!QQTheme.isNowThemeIsNight()) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    settingsExtension.setDayOrNight(z17);
                    if (QLog.isColorLevel()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("initDarkMode isAdaptDarkSwitch is true, x5 core, setColorMode:");
                        if (QQTheme.isNowThemeIsNight()) {
                            str = "dark_on";
                        } else {
                            str = "dark_off";
                        }
                        sb5.append(str);
                        QLog.i("WebLog_WebViewWrapper", 2, sb5.toString());
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.i("WebLog_WebViewWrapper", 2, "initDarkMode isAdaptDarkSwitch is false, x5 core, do nothing ");
            }
            if (Build.VERSION.SDK_INT >= 29 && z16) {
                Field declaredField = WebSettings.class.getDeclaredField("b");
                declaredField.setAccessible(true);
                android.webkit.WebSettings webSettings2 = (android.webkit.WebSettings) declaredField.get(webSettings);
                if (!isSwitchOn) {
                    webSettings2.setForceDark(0);
                    if (QLog.isColorLevel()) {
                        QLog.i("WebLog_WebViewWrapper", 2, "initDarkMode isAdaptDarkSwitch is false, sys core, setColorMode: dark_off");
                        return;
                    }
                    return;
                }
                if (QQTheme.isNowThemeIsNight()) {
                    i3 = 2;
                }
                webSettings2.setForceDark(i3);
                if (QLog.isColorLevel()) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("initDarkMode isAdaptDarkSwitch is true, sys core, setColorMode:");
                    if (!QQTheme.isNowThemeIsNight()) {
                        str2 = "dark_off";
                    }
                    sb6.append(str2);
                    QLog.i("WebLog_WebViewWrapper", 2, sb6.toString());
                }
            }
        } catch (Exception e16) {
            QLog.e("WebLog_WebViewWrapper", 1, "initDarkMode exception. ", e16);
        }
    }

    void g(TouchWebView touchWebView) {
        touchWebView.setWebViewClient(new b());
    }

    public TouchWebView h(Context context, boolean z16) {
        boolean z17;
        TouchWebView q16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 7, this, context, Boolean.valueOf(z16));
        }
        com.tencent.mobileqq.webview.util.s.a(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("WebLog_WebViewWrapper", 1, "[init webview] start create webview");
        }
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = SwiftReuseTouchWebView.I;
        if (i3 == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z16 && i3 <= 0) {
            q16 = new TouchWebView(context);
        } else {
            q16 = SwiftReuseTouchWebView.q(context);
        }
        QLog.i("WebLog_WebViewWrapper", 1, String.format("[webViewReuse] createWebView isNew=%b canUseCache=%b poolSize=%d wv=%s", Boolean.valueOf(z17), Boolean.valueOf(z16), Integer.valueOf(SwiftReuseTouchWebView.I), Integer.valueOf(q16.hashCode())));
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("WebLog_WebViewWrapper", 1, "[init webview] getDisplayMetrics");
        }
        ViewGroup.LayoutParams layoutParams = q16.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
        }
        q16.setLayoutParams(layoutParams);
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("WebLog_WebViewWrapper", 1, "[init webview] setLayoutParams");
        }
        if (z17) {
            this.f314159f = System.currentTimeMillis() - currentTimeMillis;
        }
        return q16;
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
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
            if (!com.tencent.mobileqq.webview.util.s.k(this.f314155b)) {
                this.f314155b.loadUrlOriginal("about:blank");
            }
            this.f314155b.clearView();
            this.f314155b.setWebChromeClient(null);
            this.f314155b.setWebViewClient(null);
            this.f314155b.destroy();
            this.f314155b = null;
        }
        com.tencent.biz.pubaccount.h hVar = this.f314157d;
        if (hVar != null) {
            hVar.a();
            this.f314157d = null;
        }
        com.tencent.mobileqq.webview.html.l lVar = this.f314158e;
        if (lVar != null) {
            lVar.destroy();
            this.f314158e = null;
        }
    }

    public com.tencent.biz.pubaccount.h k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.biz.pubaccount.h) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f314157d;
    }

    String l(z zVar) {
        if (zVar != null) {
            return zVar.getUAMark();
        }
        return null;
    }

    String m(String str, Boolean bool) {
        String l3 = l(this.f314154a);
        z zVar = this.f314154a;
        if (zVar != null && zVar.interceptUserAgentGenerate()) {
            String userAgent = this.f314154a.getUserAgent(str, l3, bool);
            if (!TextUtils.isEmpty(userAgent)) {
                return userAgent;
            }
        }
        return com.tencent.mobileqq.webview.swift.utils.i.n(str, l3, bool.booleanValue());
    }

    public TouchWebView n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f314155b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00f6, code lost:
    
        if (r5.hasSystemFeature("android.hardware.faketouch.multitouch.distinct") != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0283  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0261  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TouchWebView p(TouchWebView touchWebView, Intent intent) {
        boolean z16;
        String qQProcessName;
        String str;
        String str2;
        z zVar;
        DownloadListener downloadListener;
        int lastIndexOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (TouchWebView) iPatchRedirector.redirect((short) 8, (Object) this, (Object) touchWebView, (Object) intent);
        }
        long j3 = this.f314159f;
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewWrapper", 2, "createWebView TouchWebView cost = " + j3);
        }
        touchWebView.setIntent(intent);
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("WebLog_WebViewWrapper", 1, "[init webview] setIntent");
        }
        com.tencent.mobileqq.webview.util.s.b(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        long currentTimeMillis = System.currentTimeMillis();
        g(touchWebView);
        f(touchWebView);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("WebLog_WebViewWrapper", 1, "Web_qqbrowser_getWebView_initWebViewClient, cost=" + currentTimeMillis2);
            currentTimeMillis = System.currentTimeMillis();
        }
        touchWebView.setScrollBarStyle(0);
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.tencent.mobileqq.webview.util.s.a(AbsBaseWebViewActivity.WEBVIEW_ADJUST_SETTINGS);
        WebSettings settings = touchWebView.getSettings();
        com.tencent.mobileqq.webview.util.s.a(AbsBaseWebViewActivity.WEBVIEW_SET_USER_AGENT);
        String userAgentString = settings.getUserAgentString();
        com.tencent.mobileqq.webview.swift.utils.i.w(userAgentString);
        settings.setUserAgentString(m(userAgentString, Boolean.valueOf(com.tencent.mobileqq.webview.util.s.k(touchWebView))));
        com.tencent.mobileqq.webview.util.s.b(AbsBaseWebViewActivity.WEBVIEW_SET_USER_AGENT);
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
            z16 = true;
        } catch (RuntimeException unused) {
        }
        settings.setDisplayZoomControls(!z16);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        qQProcessName = MobileQQ.sMobileQQ.getQQProcessName();
        if (qQProcessName == null && (lastIndexOf = qQProcessName.lastIndexOf(58)) > -1) {
            StringBuilder sb5 = new StringBuilder();
            str = AbsBaseWebViewActivity.WEBVIEW_ADJUST_SETTINGS;
            sb5.append("_");
            sb5.append(qQProcessName.substring(lastIndexOf + 1));
            str2 = sb5.toString();
        } else {
            str = AbsBaseWebViewActivity.WEBVIEW_ADJUST_SETTINGS;
            str2 = "";
        }
        settings.setDatabasePath(BaseApplication.getContext().getDir("database" + str2, 0).getPath());
        settings.setAppCachePath(BaseApplication.getContext().getDir("appcache" + str2, 0).getPath());
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        int scale = (int) (GlobalDisplayMetricsManager.getScale() * 100.0f);
        settings.setTextZoom(scale);
        QLog.i("WebLog_WebViewWrapper", 1, "setTextZoom " + scale);
        o(settings, touchWebView);
        long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("WebLog_WebViewWrapper", 1, "Web_qqbrowser_getWebView_setWebSettings, cost=" + currentTimeMillis3);
            currentTimeMillis = System.currentTimeMillis();
        }
        touchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        try {
            touchWebView.requestFocus();
        } catch (Exception unused2) {
        }
        touchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(BaseApplication.getContext());
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("WebLog_WebViewWrapper", 1, "Web_qqbrowser_getWebView_CookieSyncManagerCreateInstance, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (touchWebView.getX5WebViewExtension() == null) {
            touchWebView.getX5WebViewExtension().setWebViewClientExtension(new c(touchWebView, this.f314154a));
            Bundle bundle = new Bundle();
            bundle.putBoolean("enable", true);
            touchWebView.getX5WebViewExtension().invokeMiscMethod("setHandleCertificateError", bundle);
            com.tencent.mobileqq.webview.swift.utils.c.a(intent, TbsDownloadConfig.TbsConfigKey.KEY_USE_X5, "1");
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QLog.i("Web_qqbrowser_core", 1, "Current WebView core is X5");
            }
        } else {
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QLog.i("Web_qqbrowser_core", 1, "Current WebView core is System");
            }
            com.tencent.mobileqq.webview.swift.utils.c.a(intent, TbsDownloadConfig.TbsConfigKey.KEY_USE_X5, "2");
        }
        zVar = this.f314154a;
        if (zVar == null) {
            downloadListener = zVar.getDownloadListener(touchWebView);
        } else {
            downloadListener = null;
        }
        if (downloadListener != null) {
            touchWebView.setDownloadListener(downloadListener);
        }
        j(j3, currentTimeMillis2, currentTimeMillis3);
        com.tencent.mobileqq.webview.util.s.b(str);
        return touchWebView;
        z16 = false;
        settings.setDisplayZoomControls(!z16);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        qQProcessName = MobileQQ.sMobileQQ.getQQProcessName();
        if (qQProcessName == null) {
        }
        str = AbsBaseWebViewActivity.WEBVIEW_ADJUST_SETTINGS;
        str2 = "";
        settings.setDatabasePath(BaseApplication.getContext().getDir("database" + str2, 0).getPath());
        settings.setAppCachePath(BaseApplication.getContext().getDir("appcache" + str2, 0).getPath());
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setMixedContentMode(0);
        int scale2 = (int) (GlobalDisplayMetricsManager.getScale() * 100.0f);
        settings.setTextZoom(scale2);
        QLog.i("WebLog_WebViewWrapper", 1, "setTextZoom " + scale2);
        o(settings, touchWebView);
        long currentTimeMillis32 = System.currentTimeMillis() - currentTimeMillis;
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
        }
        touchWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        touchWebView.requestFocus();
        touchWebView.setFocusableInTouchMode(true);
        CookieSyncManager.createInstance(BaseApplication.getContext());
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
        }
        if (touchWebView.getX5WebViewExtension() == null) {
        }
        zVar = this.f314154a;
        if (zVar == null) {
        }
        if (downloadListener != null) {
        }
        j(j3, currentTimeMillis2, currentTimeMillis32);
        com.tencent.mobileqq.webview.util.s.b(str);
        return touchWebView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        z zVar = this.f314154a;
        if (zVar != null && !zVar.isFinishing()) {
            return false;
        }
        return true;
    }

    protected void r() {
        boolean isDebugVersion;
        RuntimeException runtimeException;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            ArrayList<Class<? extends j>> arrayList = ap.f314205a;
            if (arrayList != null && arrayList.size() > 0) {
                this.f314162i = ap.f314205a.get(0).newInstance();
            }
        } finally {
            if (!isDebugVersion) {
            }
        }
    }

    public void s(com.tencent.mobileqq.webview.html.l lVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) lVar);
        } else {
            this.f314158e = lVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a extends com.tencent.biz.pubaccount.h {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewWrapper.this);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        @SuppressLint({"InflateParams"})
        public View getVideoLoadingProgressView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (View) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                return zVar.getVideoLoadingProgressView();
            }
            return null;
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
                return;
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.onHideCustomView();
            }
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, this, webView, str, str2, jsResult)).booleanValue();
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.onJsAlert(webView, str, str2, jsResult);
            }
            return super.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onPermissionRequest(PermissionRequest permissionRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) permissionRequest);
                return;
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.onPermissionRequest(permissionRequest);
            }
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, i3);
                return;
            }
            if (QLog.isDevelopLevel() || i3 == 100) {
                QLog.d("WebLog_WebViewWrapper", 2, "onProgressChanged:" + i3);
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.onProgressChanged(webView, i3);
            }
            if (i3 > 30 && !webView.getSettings().getLoadsImagesAutomatically()) {
                webView.getSettings().setLoadsImagesAutomatically(true);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) webView, (Object) str);
                return;
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.onReceivedTitle(webView, str);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) customViewCallback);
                return;
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.showCustomView(view, 10, customViewCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            z zVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, this, webView, valueCallback, fileChooserParams)).booleanValue();
            }
            if (valueCallback != null && (zVar = WebViewWrapper.this.f314154a) != null) {
                return zVar.onShowFileChooser(valueCallback, fileChooserParams);
            }
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, valueCallback, str, str2);
                return;
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.openFileChooser(valueCallback, str, str2);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), customViewCallback);
                return;
            }
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.showCustomView(view, i3, customViewCallback);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class WebViewClientImpl extends WebViewClient {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private boolean f314164b;

        /* renamed from: c, reason: collision with root package name */
        ArrayMap<String, Object> f314165c;

        /* compiled from: P */
        /* loaded from: classes20.dex */
        class a implements ValueCallback<Bundle> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewClientImpl.this);
                }
            }

            @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(Bundle bundle) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
                    return;
                }
                int i3 = bundle.getInt("input-box-num", 0);
                if (QLog.isColorLevel()) {
                    QLog.d("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised detect ", Integer.valueOf(i3), " input box");
                }
            }
        }

        WebViewClientImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewWrapper.this);
            } else {
                this.f314164b = true;
            }
        }

        private boolean b(String str, WebViewPluginEngine webViewPluginEngine, boolean z16) {
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                TraceUtils.traceBegin("CheckCanHandleJsRequest");
            }
            if (webViewPluginEngine != null && webViewPluginEngine.S(str, z16)) {
                if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                    TraceUtils.traceEnd();
                    return true;
                }
                return true;
            }
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                TraceUtils.traceEnd();
                return false;
            }
            return false;
        }

        private String c(String str) {
            if (str.startsWith("https://jsbridge/")) {
                str = str.replace("https://jsbridge/", "jsbridge://");
            } else if (str.startsWith("http://jsbridge/")) {
                str = str.replace("http://jsbridge/", "jsbridge://");
            }
            if (QLog.isDevelopLevel()) {
                if (str.startsWith("jsbridge://") && str.length() > 512) {
                    QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + str.substring(0, 512));
                } else {
                    QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + com.tencent.mobileqq.webview.util.s.d(str, new String[0]));
                }
            }
            return str;
        }

        WebResourceResponse a(WebView webView, d dVar) {
            String str = dVar.f314182a;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            com.tencent.mobileqq.webview.html.l lVar = WebViewWrapper.this.f314158e;
            if (lVar != null) {
                Object shouldInterceptRequest = lVar.shouldInterceptRequest(str);
                if (shouldInterceptRequest instanceof WebResourceResponse) {
                    QLog.e("htmlAgent_WebLog_WebViewWrapper", 1, "doInterceptRequest hit");
                    return (WebResourceResponse) shouldInterceptRequest;
                }
            }
            if (WebViewWrapper.this.f314162i != null && WebViewWrapper.this.f314162i.a(str)) {
                return WebViewWrapper.this.f314162i.c(webView, str, dVar.f314183b, dVar.f314184c);
            }
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine == null) {
                return null;
            }
            if (str.startsWith("https://jsbridge/")) {
                str = str.replace("https://jsbridge/", "jsbridge://");
            } else if (str.startsWith("http://jsbridge/")) {
                str = str.replace("http://jsbridge/", "jsbridge://");
            }
            boolean z16 = false;
            if (QLog.isDevelopLevel()) {
                if (str.startsWith("jsbridge://") && str.length() > 512) {
                    QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str.substring(0, 512));
                } else {
                    QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str);
                }
            }
            if (WebViewWrapper.this.f314155b != null && dVar.f314183b.equalsIgnoreCase(Method.POST) && dVar.f314184c) {
                z16 = true;
            }
            if (z16 && !com.tencent.mobileqq.webview.swift.utils.q.b().c(str)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(str, pluginEngine, dVar) { // from class: com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f314167d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ WebViewPluginEngine f314168e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ d f314169f;

                    {
                        this.f314167d = str;
                        this.f314168e = pluginEngine;
                        this.f314169f = dVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, WebViewClientImpl.this, str, pluginEngine, dVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                            return;
                        }
                        com.tencent.mobileqq.webview.swift.utils.q.b().a(this.f314167d);
                        boolean S = this.f314168e.S(this.f314167d, this.f314169f.f314184c);
                        com.tencent.mobileqq.webview.swift.utils.q.b().d(this.f314167d);
                        if (QLog.isColorLevel()) {
                            QLog.d("WebLog_WebViewWrapper", 2, "post intercept:", Boolean.valueOf(S), " ", com.tencent.mobileqq.webview.swift.utils.i.m(this.f314167d));
                        }
                    }
                });
            }
            if (str.startsWith("jsbridge:") && WebViewWrapper.this.f314155b != null) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(pluginEngine, str, dVar) { // from class: com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ WebViewPluginEngine f314171d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f314172e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ d f314173f;

                    {
                        this.f314171d = pluginEngine;
                        this.f314172e = str;
                        this.f314173f = dVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, WebViewClientImpl.this, pluginEngine, str, dVar);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            this.f314171d.S(this.f314172e, this.f314173f.f314184c);
                        }
                    }
                });
                return com.tencent.mobileqq.webview.swift.utils.i.a();
            }
            try {
                Object r16 = pluginEngine.r(str, 8L);
                if (!(r16 instanceof WebResourceResponse)) {
                    return null;
                }
                return (WebResourceResponse) r16;
            } catch (Exception e16) {
                QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error:" + e16.getMessage());
                if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                    return null;
                }
                QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error stack :" + e16.getStackTrace());
                throw new RuntimeException(e16.getMessage());
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onDetectedBlankScreen(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
                return;
            }
            QLog.i("WebLog_WebViewWrapper", 1, "onDetectedBlankScreen, status: " + i3 + ", url:" + str);
            z zVar = WebViewWrapper.this.f314154a;
            if (zVar != null) {
                zVar.onDetectedBlankScreen(str, i3);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageCommitVisible(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) webView, (Object) str);
                return;
            }
            super.onPageCommitVisible(webView, str);
            if (!WebViewWrapper.this.q() && webView != null) {
                QLog.d("WebLog_WebViewWrapper", 1, "onPageCommitVisible:" + str);
                z zVar = WebViewWrapper.this.f314154a;
                if (zVar != null) {
                    zVar.onPageCommitVisible(webView, str);
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) webView, (Object) str);
                return;
            }
            if (!WebViewWrapper.this.q() && WebViewWrapper.this.f314155b != null) {
                QLog.d("WebLog_WebViewWrapper", 1, "onPageFinished:" + str);
                if (WebViewWrapper.this.f314160g) {
                    WebViewWrapper.this.f314160g = false;
                    DebugTrace.e(DebugTrace.Step.webview_pageload);
                }
                super.onPageFinished(webView, str);
                z zVar = WebViewWrapper.this.f314154a;
                if (zVar != null) {
                    zVar.onPageFinished(webView, str);
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.s(str, 8589934594L, null);
                }
                if (WebViewWrapper.this.f314155b.getX5WebViewExtension() != null) {
                    try {
                        Bundle bundle = new Bundle();
                        bundle.putString("input-box-num", "");
                        WebViewWrapper.this.f314155b.getX5WebViewExtension().getFakeLoginStatus(bundle, new a());
                    } catch (Throwable th5) {
                        if (QLog.isColorLevel()) {
                            QLog.d("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised e:", th5);
                        }
                    }
                }
                com.tencent.mobileqq.webview.swift.utils.c.l(WebViewWrapper.this.f314156c);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            JsInjector.getInstance().onPageStarted(webView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, webView, str, bitmap);
                return;
            }
            if (!WebViewWrapper.this.q() && WebViewWrapper.this.f314155b != null) {
                QLog.d("WebLog_WebViewWrapper", 1, "onPageStarted:" + str);
                DebugTrace.g(DebugTrace.Step.webview_pageload);
                super.onPageStarted(webView, str, bitmap);
                z zVar = WebViewWrapper.this.f314154a;
                if (zVar != null) {
                    zVar.onPageStarted(webView, str, bitmap);
                    WebViewWrapper.this.f314154a.onWebViewClientImplPageStarted(webView, str, bitmap);
                }
                WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                if (pluginEngine != null) {
                    pluginEngine.s(str, 8589934593L, null);
                }
                try {
                    if (WebViewWrapper.this.f314155b.getX5WebViewExtension() != null) {
                        Bundle bundle = new Bundle();
                        bundle.putStringArrayList("recognised-text", com.tencent.mobileqq.webview.swift.component.s.a());
                        WebViewWrapper.this.f314155b.getX5WebViewExtension().setFakeLoginParams(bundle);
                        if (QLog.isDevelopLevel()) {
                            QLog.d("WebLog_WebViewWrapper", 2, "initWebviewExtension success");
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, webView, Integer.valueOf(i3), str, str2);
                return;
            }
            if (!WebViewWrapper.this.q() && WebViewWrapper.this.f314155b != null) {
                QLog.e("WebLog_WebViewWrapper", 1, "onReceivedError:" + i3 + ", desc=" + str + ", url=" + str2);
                z zVar = WebViewWrapper.this.f314154a;
                if (zVar != null) {
                    zVar.onReceivedError(webView, i3, str, str2);
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, webView, webResourceRequest, webResourceResponse);
                return;
            }
            if (webView != null && webResourceRequest != null && webResourceResponse != null) {
                QLog.e("WebLog_WebViewWrapper", 1, "onReceivedHttpError:" + webResourceRequest.getUrl() + "Occur error, resp code=" + webResourceResponse.getStatusCode());
                String url = webView.getUrl();
                if (url != null && AuthorizeConfig.y().l0(url) && (pluginEngine = ((CustomWebView) webView).getPluginEngine()) != null) {
                    if (this.f314165c == null) {
                        this.f314165c = new ArrayMap<>(4);
                    }
                    this.f314165c.put(WebViewPlugin.KEY_REQUEST, webResourceRequest);
                    this.f314165c.put(WebViewPlugin.KEY_RESPONSE, webResourceResponse);
                    this.f314165c.put("errorCode", Integer.valueOf(webResourceResponse.getStatusCode()));
                    pluginEngine.s(url, 64L, this.f314165c);
                    pluginEngine.s(url, 8589934612L, this.f314165c);
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String sslCertificate;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, webView, sslErrorHandler, sslError);
                return;
            }
            if (!WebViewWrapper.this.q() && WebViewWrapper.this.f314155b != null) {
                SslCertificate certificate = sslError.getCertificate();
                String url = sslError.getUrl();
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
                sb5.append(com.tencent.mobileqq.webview.util.s.d(webView.getUrl(), new String[0]));
                sb5.append(", errUrl=");
                sb5.append(com.tencent.mobileqq.webview.util.s.d(url, new String[0]));
                QLog.e("WebLog_WebViewWrapper", 1, sb5.toString());
                if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ((Boolean) com.tencent.mobileqq.webview.util.t.j().b("debug_close_url_check", Boolean.FALSE)).booleanValue()) {
                    QLog.e("WebLog_WebViewWrapper", 1, "proceed cause of debug config");
                    sslErrorHandler.proceed();
                } else {
                    if (q.f(webView, sslErrorHandler, sslError)) {
                        return;
                    }
                    z zVar = WebViewWrapper.this.f314154a;
                    if (zVar != null && zVar.onReceivedSslError(webView, sslErrorHandler, sslError)) {
                        return;
                    }
                    if (WebViewWrapper.this.f314161h == null) {
                        WebViewWrapper.this.f314161h = new q();
                    }
                    WebViewWrapper.this.f314161h.e(webView, sslErrorHandler, sslError);
                }
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean onRenderProcessGone(WebView webView, WebViewClient.RenderProcessGoneDetail renderProcessGoneDetail) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) webView, (Object) renderProcessGoneDetail)).booleanValue();
            }
            try {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("url", SwiftBrowserStatistics.u(webView.getUrl()));
                hashMap.put("coreVersion", "" + WebView.getTbsCoreVersion(webView.getContext()));
                boolean didCrash = renderProcessGoneDetail.didCrash();
                int rendererPriorityAtExit = renderProcessGoneDetail.rendererPriorityAtExit();
                if (didCrash) {
                    str = "1";
                } else {
                    str = "0";
                }
                hashMap.put("didCrash", str);
                hashMap.put("priority", "" + rendererPriorityAtExit);
                ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("webViewRenderProcessGone", "webview", true, 0L, 0L, hashMap, "");
                QLog.e("WebLog_WebViewWrapper", 1, String.format("onRenderProcessGone didCrash:%s priority:%d url:%s", Boolean.valueOf(didCrash), Integer.valueOf(rendererPriorityAtExit), webView.getUrl()));
            } catch (Exception e16) {
                QLog.e("WebLog_WebViewWrapper", 1, e16.getMessage(), e16);
            }
            return true;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) webView, (Object) webResourceRequest)).booleanValue();
            }
            this.f314164b = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.f314164b = true;
            return shouldOverrideUrlLoading;
        }

        /* JADX WARN: Code restructure failed: missing block: B:65:0x0117, code lost:
        
            if (r9.s(r2, 16, null) == false) goto L70;
         */
        /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        
            return true;
         */
        @Override // com.tencent.smtt.sdk.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewPluginEngine pluginEngine;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            WebViewWrapper webViewWrapper = WebViewWrapper.this;
            if (webViewWrapper.f314155b != null && !webViewWrapper.q()) {
                if (!TextUtils.isEmpty(str) && !"about:blank;".equals(str) && !"about:blank".equals(str)) {
                    String c16 = c(str);
                    com.tencent.mobileqq.webview.swift.utils.c.h(WebViewWrapper.this.f314156c, c16);
                    String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(c16);
                    WebViewWrapper webViewWrapper2 = WebViewWrapper.this;
                    z zVar = webViewWrapper2.f314154a;
                    if (zVar != null && zVar.beforeWebViewEngineHandleOverrideUrl(webViewWrapper2.f314155b, c16)) {
                        QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
                        return true;
                    }
                    if (("http".equals(k3) || "data".equals(k3)) && !c16.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) {
                        CustomWebView.addContextLog(com.tencent.mobileqq.webview.util.s.d(c16, new String[0]));
                    }
                    try {
                        pluginEngine = ((CustomWebView) webView).getPluginEngine();
                        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                            TraceUtils.traceBegin("WebViewFragment.KEY_EVENT_OVERRIDE_URL_LOADING");
                        }
                    } catch (RuntimeException e16) {
                        String stackTraceString = QLog.getStackTraceString(e16);
                        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, stackTraceString.length() > 255 ? stackTraceString.substring(0, 255) : stackTraceString, "", "", "");
                        QLog.e("WebLog_WebViewWrapper", 1, stackTraceString);
                    }
                    if (pluginEngine != null && pluginEngine.s(c16, 1024L, null)) {
                        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                            TraceUtils.traceEnd();
                        }
                        QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
                        return true;
                    }
                    if (b(c16, pluginEngine, this.f314164b)) {
                        return true;
                    }
                    z zVar2 = WebViewWrapper.this.f314154a;
                    if (zVar2 != null && zVar2.shouldOverrideUrlLoading(webView, c16)) {
                        return true;
                    }
                    if (!"http".equals(k3) && !"https".equals(k3) && !"data".equals(k3) && !"file".equals(k3)) {
                        WebViewWrapper webViewWrapper3 = WebViewWrapper.this;
                        z zVar3 = webViewWrapper3.f314154a;
                        if (zVar3 != null) {
                            zVar3.afterWebViewEngineHandleOverrideUrl(webViewWrapper3.f314155b, c16);
                            return true;
                        }
                        return true;
                    }
                    return false;
                }
                StringBuilder sb5 = new StringBuilder("shouldOverrideUrlLoading fail , url=[");
                sb5.append(str);
                sb5.append("].");
                QLog.e("WebLog_WebViewWrapper", 1, sb5);
                return true;
            }
            QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public final class c extends ProxyWebViewClientExtension {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final TouchWebView f314178b;

        /* renamed from: c, reason: collision with root package name */
        z f314179c;

        /* renamed from: d, reason: collision with root package name */
        ArrayMap<String, Object> f314180d;

        public c(TouchWebView touchWebView, z zVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, WebViewWrapper.this, touchWebView, zVar);
            } else {
                this.f314178b = touchWebView;
                this.f314179c = zVar;
            }
        }

        void a(Object obj, Object obj2, Object obj3, Object obj4) {
            WebViewPluginEngine pluginEngine = this.f314178b.getPluginEngine();
            if (pluginEngine != null) {
                if (this.f314180d == null) {
                    this.f314180d = new ArrayMap<>(4);
                }
                this.f314180d.put("performanceData", obj);
                this.f314180d.put(WebViewPlugin.KEY_REQUEST, obj2);
                this.f314180d.put(WebViewPlugin.KEY_RESPONSE, obj3);
                this.f314180d.put("errorCode", obj4);
                pluginEngine.s(this.f314178b.getUrl(), 64L, this.f314180d);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebCoreDump", 2, "No JS plugin engine to web core dump");
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void computeScroll(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this, (Object) view);
            } else {
                this.f314178b.computeScroll(view);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent, (Object) view)).booleanValue();
            }
            return this.f314178b.dispatchTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public int getHostByName(String str, List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) list)).intValue();
            }
            List<String> e16 = ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).e(str);
            if (e16.size() > 0) {
                QLog.d("WebLog_WebViewWrapper", 1, "getHostByName dnsMapping: " + str + ", ips: " + Arrays.toString(e16.toArray()));
                list.addAll(e16);
                return 0;
            }
            QLog.d("WebLog_WebViewWrapper", 1, "getHostByName dnsMapping: " + str + " ips not found.");
            return -1;
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onFakeLoginRecognised(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this, (Object) bundle);
                return;
            }
            super.onFakeLoginRecognised(bundle);
            if (WebViewWrapper.this.f314162i != null) {
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                if (peekAppRuntime == null) {
                    QLog.w("WebLog_WebViewWrapper", 1, "onFakeLoginRecognised app is null");
                } else {
                    WebViewWrapper.this.f314162i.b(bundle, WebViewWrapper.this.f314155b, peekAppRuntime.getCurrentAccountUin());
                }
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) motionEvent, (Object) view)).booleanValue();
            }
            return this.f314178b.onInterceptTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle, Object obj, Object obj2, Object obj3, Object obj4) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return iPatchRedirector.redirect((short) 4, this, str, bundle, obj, obj2, obj3, obj4);
            }
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
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), view);
            } else {
                this.f314178b.onOverScrolled(i3, i16, z16, z17, view);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onPrefetchResourceHit(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
                return;
            }
            QLog.i("WebLog_WebViewWrapper", 1, "now prefetchResource is hit: " + z16);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onPreloadCallback(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
                return;
            }
            z zVar = this.f314179c;
            if (zVar != null) {
                zVar.handlePreloadCallback(i3, str);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, webResourceRequest, webResourceResponse, Integer.valueOf(i3));
            } else {
                a(null, webResourceRequest, webResourceResponse, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
            } else {
                this.f314178b.onScrollChanged(i3, i16, i17, i18, view);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onTouchEvent(MotionEvent motionEvent, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent, (Object) view)).booleanValue();
            }
            return this.f314178b.onTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onUrlChange(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
                return;
            }
            SwiftBrowserCookieMonster.H();
            z zVar = this.f314179c;
            if (zVar != null) {
                zVar.onUrlChange(str, str2);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16), view)).booleanValue();
            }
            return this.f314178b.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) bundle);
            }
            if (str.equalsIgnoreCase("onReportSetCookieInfo")) {
                com.tencent.mobileqq.webview.swift.utils.i.t(bundle);
            } else if (str.equalsIgnoreCase("onDnsResultCallback") && ((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
                QLog.d("WebLog_WebViewWrapper", 1, "onDnsResultCallback host:", bundle.getString("hostname", ""), ", dnsType:", bundle.getString("dnstype", ""), ", dnsResult:", bundle.getString("dnsresult", ""), "httpDnError:", bundle.getString("httpdnserror", ""));
            }
            z zVar = this.f314179c;
            if (zVar != null) {
                return zVar.handlerMiscCallback(str, bundle);
            }
            return null;
        }
    }

    public WebViewWrapper(z zVar, Intent intent, TouchWebView touchWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, zVar, intent, touchWebView);
            return;
        }
        this.f314159f = 0L;
        this.f314160g = true;
        this.f314154a = zVar;
        this.f314156c = intent;
        this.f314155b = touchWebView;
        r();
        TouchWebView touchWebView2 = this.f314155b;
        if (touchWebView2 != null) {
            p(touchWebView2, intent);
        }
    }
}

package com.tencent.mobileqq.webview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.Nullable;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.util.WebStateReporter;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public abstract class AbsWebView {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "AbsWebView";
    public static final String WEBP_DECODER_VERSION_OF_X5 = " WebP/0.3.0";
    private com.tencent.biz.pubaccount.h mChromeClient;
    protected Context mContext;
    protected Activity mInActivity;
    protected AppRuntime mInterface;
    protected boolean mIsFirstOnPageStart;
    protected ProgressBar mLoadProgress;
    public WebViewProgressBar mLoadingProgressBar;
    protected boolean mPerfFirstLoadTag;
    protected WebViewPluginEngine mPluginEngine;
    public ArrayList<WebViewPlugin> mPluginList;
    public bx mProgressBarController;
    public long mRedirect302Time;
    public String mRedirect302Url;
    protected long mStartLoadUrlMilliTimeStamp;
    public WebStateReporter mStateReporter;
    protected long mTimeBeforeLoadUrl;
    public String mUrl;
    private WebViewClient mWebViewClient;
    public TouchWebView mWebview;
    public JSONObject mX5PerformanceJson;
    private final Object sInitEngineLock;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements DownloadListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsWebView.this);
            }
        }

        @Override // com.tencent.smtt.sdk.DownloadListener
        public void onDownloadStart(String str, String str2, String str3, String str4, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, Long.valueOf(j3));
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AbsWebView.TAG, 2, "start UniformDownloadActivity");
            }
            ((com.tencent.mobileqq.webview.swift.injector.f) aa.k(com.tencent.mobileqq.webview.swift.injector.f.class)).b(str, str2, str3, str4, j3, AbsWebView.this.mInActivity, AbsWebView.this.mWebview.getUrl());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends WebViewClientImpl {
        static IPatchRedirector $redirector_;

        b() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsWebView.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl, com.tencent.smtt.sdk.WebViewClient
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
            return a(webView, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c extends com.tencent.biz.pubaccount.h {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsWebView.this);
            }
        }

        private void c(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            if (QLog.isColorLevel()) {
                QLog.d(AbsWebView.TAG, 2, "show custom view called");
            }
            AbsWebView.this.showCustomView(view, i3, customViewCallback);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public View getVideoLoadingProgressView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (View) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return AbsWebView.this.getVideoLoadingProgressView();
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AbsWebView.TAG, 2, "onGeolocationPermissionsShowPrompt:" + str);
            }
            AbsWebView.this.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onHideCustomView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AbsWebView.TAG, 2, "hide custom view called");
            }
            AbsWebView.this.onHideCustomView();
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, this, webView, str, str2, jsResult)).booleanValue();
            }
            return AbsWebView.this.onJsAlert(webView, str, str2, jsResult);
        }

        @Override // com.tencent.biz.pubaccount.h, com.tencent.smtt.sdk.WebChromeClient
        public void onProgressChanged(WebView webView, int i3) {
            JsInjector.getInstance().onProgressChanged(webView, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) webView, i3);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d(AbsWebView.TAG, 2, "onProgressChanged:" + i3);
            }
            bx bxVar = AbsWebView.this.mProgressBarController;
            if (bxVar != null && bxVar.c() == 0) {
                AbsWebView.this.mProgressBarController.a((byte) 1);
            }
            if (i3 == 100) {
                AbsWebView.this.showProgressBar(false);
            }
            AbsWebView.this.onProgressChanged(webView, i3);
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onReceivedTitle(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) webView, (Object) str);
            } else {
                AbsWebView.this.onReceivedTitle(webView, str);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        @SuppressLint({"InlinedApi"})
        public void onShowCustomView(View view, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                c(view, 10, customViewCallback);
            } else {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) customViewCallback);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, valueCallback, str, str2);
            } else {
                AbsWebView.this.openFileChooser(valueCallback, str, str2);
            }
        }

        @Override // com.tencent.smtt.sdk.WebChromeClient
        public void onShowCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                c(view, i3, customViewCallback);
            } else {
                iPatchRedirector.redirect((short) 4, this, view, Integer.valueOf(i3), customViewCallback);
            }
        }
    }

    public AbsWebView(Context context, Activity activity, AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, activity, appRuntime);
            return;
        }
        this.mPluginList = null;
        this.sInitEngineLock = new Object();
        this.mStateReporter = new WebStateReporter();
        this.mRedirect302Time = -1L;
        this.mRedirect302Url = "";
        this.mX5PerformanceJson = null;
        this.mPerfFirstLoadTag = true;
        this.mTimeBeforeLoadUrl = 0L;
        this.mIsFirstOnPageStart = true;
        this.mContext = context;
        this.mInActivity = activity;
        this.mInterface = appRuntime;
    }

    private void bindAllJavaScript() {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "bindAllJavaScript");
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList<WebViewPlugin> arrayList = this.mPluginList;
        if (arrayList == null) {
            this.mPluginList = new ArrayList<>();
        } else {
            arrayList.clear();
        }
        bindJavaScript(this.mPluginList);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "bindAllJavaScript time = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void bindWebChromeClient() {
        if (this.mChromeClient == null) {
            this.mChromeClient = new c();
        }
        this.mWebview.setWebChromeClient(this.mChromeClient);
    }

    private void bindWebViewClient() {
        b bVar = new b();
        this.mWebViewClient = bVar;
        this.mWebview.setWebViewClient(bVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0070, code lost:
    
        if (r1.hasSystemFeature("android.hardware.faketouch.multitouch.distinct") != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0196  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void initWebView() {
        boolean z16;
        boolean z17;
        String str;
        int lastIndexOf;
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "initWebView");
        }
        this.mWebview.setPluginEngine(this.mPluginEngine);
        this.mPluginEngine.s(this.mUrl, 1L, null);
        WebSettings settings = this.mWebview.getSettings();
        String userAgentString = settings.getUserAgentString();
        String uAMark = getUAMark();
        if (this.mWebview.getX5WebViewExtension() != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        settings.setUserAgentString(com.tencent.mobileqq.webview.swift.utils.i.n(userAgentString, uAMark, z16));
        settings.setSavePassword(false);
        settings.setSaveFormData(false);
        settings.setBuiltInZoomControls(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setMediaPlaybackRequiresUserGesture(false);
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            if (!packageManager.hasSystemFeature("android.hardware.touchscreen.multitouch")) {
            }
            z17 = true;
        } catch (RuntimeException unused) {
        }
        settings.setDisplayZoomControls(!z17);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String qQProcessName = MobileQQ.getMobileQQ().getQQProcessName();
        if (qQProcessName == null && (lastIndexOf = qQProcessName.lastIndexOf(58)) > -1) {
            str = "_" + qQProcessName.substring(lastIndexOf + 1);
        } else {
            str = "";
        }
        settings.setDatabasePath(this.mContext.getApplicationContext().getDir("database" + str, 0).getPath());
        settings.setAppCachePath(this.mContext.getApplicationContext().getDir("appcache" + str, 0).getPath());
        this.mWebview.removeJavascriptInterface("searchBoxJavaBridge_");
        try {
            this.mWebview.requestFocus();
        } catch (Exception unused2) {
        }
        this.mWebview.setFocusableInTouchMode(true);
        this.mWebview.setDownloadListener(new a());
        CookieSyncManager.createInstance(this.mContext.getApplicationContext());
        if (this.mWebview.getX5WebViewExtension() == null) {
            this.mWebview.getX5WebViewExtension().setWebViewClientExtension(new d(this.mWebview));
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QLog.i("Web_qqbrowser_core", 1, "Current WebView core is X5");
            }
            if (((Boolean) t.j().b("WebView_enable_X5_Report", Boolean.TRUE)).booleanValue()) {
                if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                    QLog.i("Web_X5_Performance", 1, "enable x5 report performance!");
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(NodeProps.ENABLED, true);
                this.mWebview.getX5WebViewExtension().invokeMiscMethod("webPerformanceRecordingEnabled", bundle);
                return;
            }
            return;
        }
        if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("Web_qqbrowser_core", 1, "Current WebView core is System");
            return;
        }
        return;
        z17 = false;
        settings.setDisplayZoomControls(!z17);
        settings.setPluginsEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setDatabaseEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        String qQProcessName2 = MobileQQ.getMobileQQ().getQQProcessName();
        if (qQProcessName2 == null) {
        }
        str = "";
        settings.setDatabasePath(this.mContext.getApplicationContext().getDir("database" + str, 0).getPath());
        settings.setAppCachePath(this.mContext.getApplicationContext().getDir("appcache" + str, 0).getPath());
        this.mWebview.removeJavascriptInterface("searchBoxJavaBridge_");
        this.mWebview.requestFocus();
        this.mWebview.setFocusableInTouchMode(true);
        this.mWebview.setDownloadListener(new a());
        CookieSyncManager.createInstance(this.mContext.getApplicationContext());
        if (this.mWebview.getX5WebViewExtension() == null) {
        }
    }

    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void buildBaseWebView(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "buildBaseWebView");
        }
        initPluginEngine();
        initWebView();
        bindWebViewClient();
        bindWebChromeClient();
    }

    public Object doInterceptRequest(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return iPatchRedirector.redirect((short) 20, (Object) this, (Object) webView, (Object) str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doOnBackPressed(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnBackPressed");
        }
        String url = this.mWebview.getUrl();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnBackPressed...url=" + url);
        }
        this.mStateReporter.d(this.mContext, appRuntime.getLongAccountUin(), url, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doOnCreate(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnCreate");
        }
        this.mStateReporter.f(1);
        if (intent != null) {
            this.mStateReporter.g(intent.getStringExtra(VasWebviewConstants.KEY_SERVICE_ID));
            long longExtra = intent.getLongExtra("startOpenPageTime", -1L);
            if (-1 == longExtra) {
                longExtra = System.currentTimeMillis();
            }
            this.mStateReporter.e(longExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnDestroy");
        }
        com.tencent.biz.pubaccount.h hVar = this.mChromeClient;
        if (hVar != null) {
            hVar.a();
        }
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView != null) {
            WebViewPluginEngine pluginEngine = touchWebView.getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.s(this.mWebview.getUrl(), 8589934596L, null);
                pluginEngine.H();
            }
            try {
                this.mWebview.stopLoading();
            } catch (Exception unused) {
            }
            this.mWebview.loadUrlOriginal("about:blank");
            this.mWebview.clearView();
            this.mWebview.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doOnPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnPause");
        }
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView != null) {
            touchWebView.onPause();
            WebViewPluginEngine pluginEngine = this.mWebview.getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.s(this.mWebview.getUrl(), 8589934597L, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doOnResume");
        }
        TouchWebView touchWebView = this.mWebview;
        if (touchWebView != null) {
            touchWebView.onResume();
            WebViewPluginEngine pluginEngine = this.mWebview.getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.s(this.mWebview.getUrl(), 2L, null);
            }
        }
    }

    public long getStartLoadUrlMilliTimeStamp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.mStartLoadUrlMilliTimeStamp;
    }

    public long getTimeBeforeLoadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Long) iPatchRedirector.redirect((short) 38, (Object) this)).longValue();
        }
        return this.mTimeBeforeLoadUrl;
    }

    protected String getUAMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return (String) iPatchRedirector.redirect((short) 34, (Object) this);
        }
        return null;
    }

    public View getVideoLoadingProgressView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return (View) iPatchRedirector.redirect((short) 30, (Object) this);
        }
        return null;
    }

    public CustomWebView getWebView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CustomWebView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mWebview;
    }

    public void initPluginEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initPluginEngine");
        }
        if (this.mPluginEngine != null) {
            return;
        }
        synchronized (this.sInitEngineLock) {
            if (this.mPluginEngine == null) {
                bindAllJavaScript();
                this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mInterface, this.mInActivity, null, myCommonJsPlugins(), this.mPluginList);
            }
        }
    }

    public boolean isIsFirstOnPageStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.mIsFirstOnPageStart;
    }

    public boolean isPerfFirstLoadTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        return this.mPerfFirstLoadTag;
    }

    protected com.tencent.mobileqq.webview.swift.a myCommonJsPlugins() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.mobileqq.webview.swift.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return new com.tencent.mobileqq.webview.swift.a();
    }

    protected void notifyLocalInterceptRequest(WebView webView, String str, @Nullable WebResourceResponse webResourceResponse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, webView, str, webResourceResponse);
        }
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
        }
    }

    public void onHideCustomView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            return true;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 27, this, webView, str, str2, jsResult)).booleanValue();
    }

    public Object onMiscCallBack(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, (Object) bundle);
        }
        return null;
    }

    public void onPageFinished(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) webView, (Object) str);
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, webView, str, bitmap);
        }
    }

    public void onProgressChanged(WebView webView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) webView, i3);
        }
    }

    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, webView, Integer.valueOf(i3), str, str2);
        }
    }

    public void onReceivedTitle(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) webView, (Object) str);
        }
    }

    public void onWebViewReady() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        }
    }

    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, this, valueCallback, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void preInitPluginEngine() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 2, "preInitPluginEngine");
        }
        if (this.mPluginEngine == null && WebViewPluginEngine.I != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "use preloaded web engine!");
            }
            this.mPluginEngine = WebViewPluginEngine.I;
            WebViewPluginEngine.I = null;
            bindAllJavaScript();
            this.mPluginEngine.J(this.mInterface, this.mInActivity, this.mPluginList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "WebAccelerateHelper.isWebViewCache:" + WebAccelerateHelper.isWebViewEntered + ",mPluginEngine=" + this.mPluginEngine);
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.webview.AbsWebView.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AbsWebView.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                long uptimeMillis = SystemClock.uptimeMillis();
                AbsWebView absWebView = AbsWebView.this;
                if (absWebView.mPluginEngine == null) {
                    absWebView.initPluginEngine();
                    if (QLog.isDevelopLevel()) {
                        QLog.d(AbsWebView.TAG, 2, "initPluginEngine cost= " + (SystemClock.uptimeMillis() - uptimeMillis));
                    }
                }
                Thread.yield();
            }
        }, null, false);
    }

    public void refresh() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mWebview.reload();
        }
    }

    public void setIsFirstOnPageStart(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.mIsFirstOnPageStart = z16;
        }
    }

    public void setPerfFirstLoadTag(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.mPerfFirstLoadTag = z16;
        }
    }

    public void setStartLoadUrlMilliTimeStamp(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, j3);
        } else {
            this.mStartLoadUrlMilliTimeStamp = j3;
        }
    }

    public void setTimeBeforeLoadUrl(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, j3);
        } else {
            this.mTimeBeforeLoadUrl = j3;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        return false;
    }

    public void showCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, this, view, Integer.valueOf(i3), customViewCallback);
        }
    }

    public void showProgressBar(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        ProgressBar progressBar = this.mLoadProgress;
        if (progressBar != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            progressBar.setVisibility(i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class WebViewClientImpl extends WebViewClient {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private boolean f313740b;

        WebViewClientImpl() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsWebView.this);
            } else {
                this.f313740b = true;
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(15:11|(6:13|(1:15)(2:55|(1:57))|16|(2:18|(1:26)(1:25))|27|(8:33|(1:39)|40|41|42|43|44|45)(2:31|32))|58|16|(0)|27|(1:29)|33|(3:35|37|39)|40|41|42|43|44|45) */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00eb, code lost:
        
            r13 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00f0, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00f2, code lost:
        
            com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.webview.AbsWebView.TAG, 2, "shouldInterceptRequest got exception!", r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0104, code lost:
        
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() != false) goto L55;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0115, code lost:
        
            throw new java.lang.RuntimeException(r13.getMessage());
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0060  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected WebResourceResponse a(WebView webView, String str, boolean z16) {
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (WebResourceResponse) iPatchRedirector.redirect((short) 9, this, webView, str, Boolean.valueOf(z16));
            }
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            WebResourceResponse webResourceResponse = null;
            if (pluginEngine == null) {
                return null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (str.startsWith("https://jsbridge/")) {
                    str2 = str.replace("https://jsbridge/", "jsbridge://");
                } else if (str.startsWith("http://jsbridge/")) {
                    str2 = str.replace("http://jsbridge/", "jsbridge://");
                }
                if (QLog.isDevelopLevel()) {
                    if (str.length() > 512 && (str.startsWith("jsbridge://") || (str2 != null && str2.startsWith("jsbridge://")))) {
                        QLog.i(AbsWebView.TAG, 2, "doInterceptRequest:" + str.substring(0, 512));
                    } else {
                        QLog.i(AbsWebView.TAG, 2, "doInterceptRequest:" + str);
                    }
                }
                if (TextUtils.isEmpty(str2) && AbsWebView.this.mWebview != null) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(pluginEngine, str2, z16) { // from class: com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ WebViewPluginEngine f313742d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f313743e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ boolean f313744f;

                        {
                            this.f313742d = pluginEngine;
                            this.f313743e = str2;
                            this.f313744f = z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, WebViewClientImpl.this, pluginEngine, str2, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            WebViewPluginEngine webViewPluginEngine = this.f313742d;
                            if (webViewPluginEngine != null) {
                                webViewPluginEngine.S(this.f313743e, this.f313744f);
                            }
                        }
                    });
                    return new WebResourceResponse("text/html", "utf-8", null);
                }
                if (!TextUtils.isEmpty(str) && str.startsWith("jsbridge") && AbsWebView.this.mWebview != null) {
                    ThreadManagerV2.getUIHandlerV2().post(new Runnable(pluginEngine, str, z16) { // from class: com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.2
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ WebViewPluginEngine f313746d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f313747e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ boolean f313748f;

                        {
                            this.f313746d = pluginEngine;
                            this.f313747e = str;
                            this.f313748f = z16;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, WebViewClientImpl.this, pluginEngine, str, Boolean.valueOf(z16));
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            WebViewPluginEngine webViewPluginEngine = this.f313746d;
                            if (webViewPluginEngine != null) {
                                webViewPluginEngine.S(this.f313747e, this.f313748f);
                            }
                        }
                    });
                }
                webResourceResponse = (WebResourceResponse) pluginEngine.r(str, 8L);
                AbsWebView.this.notifyLocalInterceptRequest(webView, str, webResourceResponse);
                return webResourceResponse;
            }
            str2 = null;
            if (QLog.isDevelopLevel()) {
            }
            if (TextUtils.isEmpty(str2)) {
            }
            if (!TextUtils.isEmpty(str)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable(pluginEngine, str, z16) { // from class: com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.2
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ WebViewPluginEngine f313746d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ String f313747e;

                    /* renamed from: f, reason: collision with root package name */
                    final /* synthetic */ boolean f313748f;

                    {
                        this.f313746d = pluginEngine;
                        this.f313747e = str;
                        this.f313748f = z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, WebViewClientImpl.this, pluginEngine, str, Boolean.valueOf(z16));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        WebViewPluginEngine webViewPluginEngine = this.f313746d;
                        if (webViewPluginEngine != null) {
                            webViewPluginEngine.S(this.f313747e, this.f313748f);
                        }
                    }
                });
            }
            webResourceResponse = (WebResourceResponse) pluginEngine.r(str, 8L);
            AbsWebView.this.notifyLocalInterceptRequest(webView, str, webResourceResponse);
            return webResourceResponse;
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onDetectedBlankScreen(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, i3);
                return;
            }
            QLog.i(AbsWebView.TAG, 1, "onDetectedBlankScreen, status: " + i3 + ", url:" + str);
            AbsWebView absWebView = AbsWebView.this;
            absWebView.mStateReporter.b(absWebView.mInterface, str, i3);
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) webView, (Object) str);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AbsWebView.TAG, 2, "onPageFinished:" + str);
            }
            bx bxVar = AbsWebView.this.mProgressBarController;
            if (bxVar != null) {
                bxVar.a((byte) 2);
            }
            super.onPageFinished(webView, str);
            AbsWebView.this.onPageFinished(webView, str);
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.s(str, 8589934594L, null);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            bx bxVar;
            JsInjector.getInstance().onPageStarted(webView);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, webView, str, bitmap);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AbsWebView.TAG, 2, "onPageStarted:" + str);
            }
            if (!"about:blank".equalsIgnoreCase(str)) {
                AbsWebView.this.mStateReporter.f(2);
            }
            if (!AbsWebView.this.isIsFirstOnPageStart() && (bxVar = AbsWebView.this.mProgressBarController) != null && bxVar.c() != 0) {
                AbsWebView.this.mProgressBarController.a((byte) 0);
            }
            if (AbsWebView.this.isIsFirstOnPageStart()) {
                AbsWebView.this.setIsFirstOnPageStart(false);
                AbsWebView.this.setStartLoadUrlMilliTimeStamp(System.currentTimeMillis());
            }
            super.onPageStarted(webView, str, bitmap);
            AbsWebView.this.onPageStarted(webView, str, bitmap);
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.s(str, 8589934593L, null);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedError(WebView webView, int i3, String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, webView, Integer.valueOf(i3), str, str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(AbsWebView.TAG, 2, "onReceivedError:" + i3 + ", desc=" + str + ", url=" + str2);
            }
            AbsWebView.this.onReceivedError(webView, i3, str, str2);
            WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
            if (pluginEngine != null) {
                pluginEngine.q(str2, 8589934595L, i3);
            }
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String sslCertificate;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, webView, sslErrorHandler, sslError);
                return;
            }
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
            sb5.append(s.d(url, new String[0]));
            QLog.w(AbsWebView.TAG, 1, sb5.toString());
            sslErrorHandler.cancel();
        }

        @Override // com.tencent.smtt.sdk.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) webView, (Object) webResourceRequest)).booleanValue();
            }
            this.f313740b = webResourceRequest.isForMainFrame();
            boolean shouldOverrideUrlLoading = super.shouldOverrideUrlLoading(webView, webResourceRequest);
            this.f313740b = true;
            return shouldOverrideUrlLoading;
        }

        /* JADX WARN: Code restructure failed: missing block: B:57:0x016d, code lost:
        
            if (r7.s(r26, 16, null) == false) goto L81;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x0170, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
        
            return false;
         */
        @Override // com.tencent.smtt.sdk.WebViewClient
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebView.HitTestResult hitTestResult;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) webView, (Object) str)).booleanValue();
            }
            if (QLog.isColorLevel()) {
                if (str.startsWith("jsbridge://") && str.length() > 512) {
                    QLog.d(AbsWebView.TAG, 2, "shouldOverrideUrlLoading:" + str.substring(0, 512));
                } else {
                    QLog.d(AbsWebView.TAG, 2, "shouldOverrideUrlLoading:" + s.d(str, new String[0]));
                }
            }
            if (str.startsWith("http://") || str.startsWith("https://")) {
                AbsWebView.this.setPerfFirstLoadTag(false);
                AbsWebView.this.setTimeBeforeLoadUrl(System.currentTimeMillis());
            }
            if (!TextUtils.isEmpty(str) && !"about:blank;".equals(str) && !"about:blank".equals(str)) {
                if ((str.startsWith("http") || str.startsWith("data:")) && !str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080")) {
                    CustomWebView.addContextLog(s.d(str, new String[0]));
                }
                try {
                    if ((str.startsWith("http://") || str.startsWith("https://")) && (hitTestResult = webView.getHitTestResult()) != null && hitTestResult.getType() == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.i(AbsWebView.TAG, 2, "shouldOverrideUrlLoading detect 302 url: " + str);
                        }
                        AbsWebView.this.mRedirect302Time = System.currentTimeMillis();
                        AbsWebView.this.mRedirect302Url = str;
                        SwiftBrowserCookieMonster.H();
                    }
                    WebViewPluginEngine pluginEngine = ((CustomWebView) webView).getPluginEngine();
                    if ((pluginEngine != null && pluginEngine.S(str, this.f313740b)) || AbsWebView.this.shouldOverrideUrlLoading(webView, str)) {
                        return true;
                    }
                    if (!str.startsWith("file://") && !str.startsWith("data:") && !str.startsWith("http://") && !str.startsWith("https://")) {
                        if (str.startsWith("tnow://openpage/recordstory")) {
                            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse(str));
                            intent.setFlags(268435456);
                            AbsWebView.this.mContext.startActivity(intent);
                        }
                    }
                    return false;
                } catch (RuntimeException e16) {
                    String stackTraceString = QLog.getStackTraceString(e16);
                    ((com.tencent.mobileqq.webview.swift.injector.m) aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, stackTraceString.length() > 255 ? stackTraceString.substring(0, 255) : stackTraceString, "", "", "");
                    QLog.e(AbsWebView.TAG, 2, stackTraceString);
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public final class d extends ProxyWebViewClientExtension {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        private TouchWebView f313753b;

        /* renamed from: c, reason: collision with root package name */
        private ArrayMap<String, Object> f313754c;

        public d(TouchWebView touchWebView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbsWebView.this, (Object) touchWebView);
            } else {
                this.f313753b = touchWebView;
            }
        }

        private void a(Object obj, Object obj2, Object obj3, Object obj4) {
            WebViewPluginEngine pluginEngine = this.f313753b.getPluginEngine();
            if (pluginEngine != null) {
                if (this.f313754c == null) {
                    this.f313754c = new ArrayMap<>(4);
                }
                this.f313754c.put("performanceData", obj);
                this.f313754c.put(WebViewPlugin.KEY_REQUEST, obj2);
                this.f313754c.put(WebViewPlugin.KEY_RESPONSE, obj3);
                this.f313754c.put("errorCode", obj4);
                pluginEngine.s(this.f313753b.getUrl(), 64L, this.f313754c);
                if (QLog.isColorLevel()) {
                    QLog.i("WebCoreDump", 2, "Take web core dump for " + s.d(this.f313753b.getUrl(), new String[0]));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebCoreDump", 2, "No JS plugin engine to handle web core dump");
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void computeScroll(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, (Object) view);
            } else {
                this.f313753b.computeScroll(view);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean dispatchTouchEvent(MotionEvent motionEvent, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) motionEvent, (Object) view)).booleanValue();
            }
            return this.f313753b.dispatchTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onInterceptTouchEvent(MotionEvent motionEvent, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent, (Object) view)).booleanValue();
            }
            return this.f313753b.onInterceptTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public Object onMiscCallBack(String str, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) bundle);
            }
            AbsWebView.this.onMiscCallBack(str, bundle);
            if (!str.equalsIgnoreCase("onReportSetCookieInfo")) {
                return null;
            }
            com.tencent.mobileqq.webview.swift.utils.i.t(bundle);
            return null;
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Boolean.valueOf(z17), view);
            } else {
                this.f313753b.onOverScrolled(i3, i16, z16, z17, view);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onResponseReceived(WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, webResourceRequest, webResourceResponse, Integer.valueOf(i3));
            } else {
                a(null, webResourceRequest, webResourceResponse, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onScrollChanged(int i3, int i16, int i17, int i18, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), view);
            } else {
                this.f313753b.onScrollChanged(i3, i16, i17, i18, view);
            }
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean onTouchEvent(MotionEvent motionEvent, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent, (Object) view)).booleanValue();
            }
            return this.f313753b.onTouchEvent(motionEvent, view);
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public void onUrlChange(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this, (Object) str, (Object) str2);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i(AbsWebView.TAG, 2, "onUrlChange detect 302 url: " + str2);
            }
            SwiftBrowserCookieMonster.H();
        }

        @Override // com.tencent.smtt.export.external.extension.proxy.ProxyWebViewClientExtension, com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension
        public boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), Integer.valueOf(i28), Boolean.valueOf(z16), view)).booleanValue();
            }
            return this.f313753b.overScrollBy(i3, i16, i17, i18, i19, i26, i27, i28, z16, view);
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
    }
}

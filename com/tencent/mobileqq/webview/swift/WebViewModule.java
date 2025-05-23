package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.api.IPublicAccountJavascriptInterface;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.w;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.scheduler.a;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.GeolocationPermissionsCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.PermissionRequest;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewModule implements z {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WebViewModule";
    protected AuthorizeConfig authConfig;
    public BrowserAppInterface browserApp;
    private Intent intent;
    public boolean isDestroyed;
    protected volatile boolean isSendWebSoRequest;
    public volatile AppInterface mApp;
    private Context mContext;
    protected int mCreateLoopNextStep;
    protected final com.tencent.mobileqq.webview.swift.scheduler.a mCreateLoopScheduler;
    protected boolean mNightMode;
    protected volatile WebViewPluginEngine mPluginEngine;
    public String mRedirect302Url;
    private String mUrl;
    boolean redirectCookie;
    public String uin;
    public TouchWebView webView;
    WebViewWrapper webViewWrapper;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements a.InterfaceC8977a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewModule.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.scheduler.a.InterfaceC8977a
        public int a(Bundle bundle) {
            int doCreateLoopStep_InitData;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).intValue();
            }
            int i3 = WebViewModule.this.mCreateLoopNextStep;
            long currentTimeMillis = System.currentTimeMillis();
            WebViewModule webViewModule = WebViewModule.this;
            int i16 = webViewModule.mCreateLoopNextStep;
            if (i16 != 2) {
                if (i16 != 4) {
                    if (i16 != 8) {
                        if (i16 != 16) {
                            if (i16 != 32) {
                                if (i16 != 1024) {
                                    doCreateLoopStep_InitData = -1;
                                } else {
                                    doCreateLoopStep_InitData = webViewModule.doCreateLoopStep_Final(bundle);
                                }
                            } else {
                                doCreateLoopStep_InitData = webViewModule.doCreateLoopStep_LoadUrl(bundle);
                            }
                        } else {
                            doCreateLoopStep_InitData = webViewModule.doCreateLoopStep_InitWebView(bundle);
                        }
                    } else {
                        doCreateLoopStep_InitData = webViewModule.doCreateLoopStep_InitX5Environment(bundle);
                    }
                } else {
                    doCreateLoopStep_InitData = webViewModule.doCreateLoopStep_InitAppAndWebVieEngine(bundle);
                }
            } else {
                doCreateLoopStep_InitData = webViewModule.doCreateLoopStep_InitData(bundle);
            }
            QLog.i(WebViewModule.TAG, 1, "CreateLoop:step[" + i3 + "] -> step[" + WebViewModule.this.mCreateLoopNextStep + "] cost" + (System.currentTimeMillis() - currentTimeMillis) + " ms.");
            return doCreateLoopStep_InitData;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b extends SwiftBrowserIdleTaskHelper.b {
        static IPatchRedirector $redirector_;

        b(int i3) {
            super(i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewModule.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.b
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.i(WebViewModule.TAG, 2, "TASK_ID_BROWSER_ACTIVITY_RUN_ONCE.");
                return 1;
            }
            return 1;
        }
    }

    public WebViewModule(@NotNull Intent intent, Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent, (Object) context);
            return;
        }
        this.isSendWebSoRequest = false;
        this.mCreateLoopNextStep = 1;
        this.mUrl = null;
        this.mNightMode = false;
        this.mRedirect302Url = "";
        this.redirectCookie = true;
        this.mCreateLoopScheduler = new com.tencent.mobileqq.webview.swift.scheduler.a(new a());
        this.mContext = context;
        this.intent = intent;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean afterWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean beforeWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        if (!this.isDestroyed && this.webView != null) {
            com.tencent.biz.common.util.k.a("urlInterceptManager");
            com.tencent.mobileqq.webview.swift.utils.i.k(str);
            com.tencent.biz.common.util.k.d("urlInterceptManager");
            return false;
        }
        return true;
    }

    void buildCookieForRedirect(String str, String str2) {
        SwiftBrowserCookieMonster s16;
        try {
            String f16 = com.tencent.mobileqq.webview.swift.cookie.b.f(str);
            String f17 = com.tencent.mobileqq.webview.swift.cookie.b.f(str2);
            if ((f16 != null && f16.contains("ptlogin")) || (f17 != null && f17.contains("ptlogin"))) {
                this.redirectCookie = false;
            }
            if (this.redirectCookie && (s16 = SwiftBrowserCookieMonster.s(str2)) != null) {
                s16.I(str2, null, null, this.intent);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public final WebViewWrapper createWebViewWrapper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (WebViewWrapper) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        WebViewWrapper webViewWrapper = new WebViewWrapper(this, this.intent, this.mContext, false);
        this.webViewWrapper = webViewWrapper;
        TouchWebView n3 = webViewWrapper.n();
        this.mPluginEngine.Q(n3);
        n3.setPluginEngine(this.mPluginEngine);
        if (this.mNightMode) {
            n3.setMask(true);
        }
        return this.webViewWrapper;
    }

    void destroyWebView() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        this.isDestroyed = true;
        WebViewWrapper webViewWrapper = this.webViewWrapper;
        if (webViewWrapper != null) {
            webViewWrapper.i();
            this.webViewWrapper = null;
            this.webView = null;
        }
        this.mApp = null;
    }

    protected boolean dispatchPluginEvent(long j3, Map<String, Object> map) {
        WebViewPluginEngine pluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), map)).booleanValue();
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView == null || (pluginEngine = touchWebView.getPluginEngine()) == null) {
            return false;
        }
        return pluginEngine.s(this.webView.getUrl(), j3, map);
    }

    protected int doCreateLoopStep_Final(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) bundle)).intValue();
        }
        com.tencent.biz.common.util.k.a("Web_qqbrowser_state_machine_init_FINAL");
        com.tencent.biz.common.util.k.a("Web_IPCSetup");
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(BaseApplicationImpl.getApplication());
        }
        com.tencent.biz.common.util.k.d("Web_IPCSetup");
        SwiftBrowserIdleTaskHelper.h().f(new b(2));
        com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_init_FINAL");
        com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_all");
        this.mCreateLoopNextStep = 1;
        return -1;
    }

    protected int doCreateLoopStep_InitAppAndWebVieEngine(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle)).intValue();
        }
        com.tencent.biz.common.util.k.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
        this.mApp = (AppInterface) MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
        if (this.mApp instanceof BrowserAppInterface) {
            this.browserApp = (BrowserAppInterface) this.mApp;
        }
        if (!WebAccelerateHelper.isWebViewEntered && !VipWebViewReportLog.g()) {
            VipWebViewReportLog.f(this.mApp.getApplication(), this.mApp);
        }
        this.uin = this.mApp.getAccount();
        ensurePluginEngineCreated();
        if (this.mPluginEngine != null) {
            this.mPluginEngine.D(this.intent.getStringArrayExtra("insertPluginsArray"));
            this.mPluginEngine.s(this.mUrl, 1L, null);
        }
        this.mCreateLoopNextStep = 16;
        com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_init_app_and_webview_engine");
        return 1;
    }

    protected int doCreateLoopStep_InitData(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle)).intValue();
        }
        com.tencent.biz.common.util.k.a("Web_qqbrowser_state_machine_init_data");
        QbSdk.setQQBuildNumber(AppSetting.f99542b);
        String stringExtra = this.intent.getStringExtra("options");
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.intent.putExtra("url", jSONObject.getString("url"));
                if (!this.intent.hasExtra("key_isReadModeEnabled")) {
                    this.intent.putExtra("key_isReadModeEnabled", true);
                }
                this.intent.putExtra("ba_is_login", jSONObject.optBoolean("ba_is_login", true));
                this.intent.putExtra("isShowAd", jSONObject.optBoolean("isShowAd", true));
                this.intent.putExtra("avoidLoginWeb", jSONObject.optBoolean("avoidLoginWeb", false));
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, e16.toString());
                }
            }
        }
        String str = Build.MANUFACTURER;
        DeviceInfoMonitor.getModel();
        boolean booleanExtra = this.intent.getBooleanExtra(QQBrowserActivity.KEY_FROM_NEARBY, false);
        com.tencent.mobileqq.statistics.w.a(getClass(), hashCode(), booleanExtra ? 1 : 0, this.mUrl);
        com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_init_data");
        this.mCreateLoopNextStep = 8;
        return 0;
    }

    protected int doCreateLoopStep_InitWebView(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) bundle)).intValue();
        }
        com.tencent.biz.common.util.k.a("Web_qqbrowser_state_machine_init_webview");
        initWebView();
        com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_init_webview");
        this.mCreateLoopNextStep = 32;
        return 0;
    }

    protected int doCreateLoopStep_InitX5Environment(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle)).intValue();
        }
        com.tencent.biz.common.util.k.a("Web_qqbrowser_state_machine_init_x5_environment");
        this.mCreateLoopNextStep = 4;
        if (com.tencent.mobileqq.webview.swift.utils.m.e()) {
            com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_init_x5_environment");
            return 0;
        }
        if (com.tencent.mobileqq.webview.swift.utils.m.g()) {
            com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_init_x5_environment");
            return 0;
        }
        com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_init_x5_environment");
        return 0;
    }

    protected int doCreateLoopStep_LoadUrl(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, (Object) bundle)).intValue();
        }
        com.tencent.biz.common.util.k.a("Web_qqbrowser_state_machine_load_url");
        System.currentTimeMillis();
        com.tencent.biz.common.util.k.a("Web_qqbrowser_init");
        startLoadUrl();
        com.tencent.biz.common.util.k.d("Web_qqbrowser_init");
        com.tencent.biz.common.util.k.d("Web_qqbrowser_state_machine_load_url");
        this.mCreateLoopNextStep = 1024;
        return 0;
    }

    void doWebSoRequest() {
        if (!this.isSendWebSoRequest) {
            this.isSendWebSoRequest = true;
            String stringExtra = this.intent.getStringExtra("url");
            if (com.tencent.mobileqq.webview.webso.e.E(stringExtra)) {
                ThreadManagerV2.postImmediately(new Runnable(stringExtra) { // from class: com.tencent.mobileqq.webview.swift.WebViewModule.3
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ String f314106d;

                    {
                        this.f314106d = stringExtra;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewModule.this, (Object) stringExtra);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            WebSoService.j().E(this.f314106d, null);
                        }
                    }
                }, null, false);
            }
        }
    }

    void ensureCreateLoopFinished() {
        if (1 != this.mCreateLoopNextStep) {
            this.mCreateLoopScheduler.a();
            this.mCreateLoopScheduler.b();
            this.mCreateLoopScheduler.d(new Bundle());
        }
    }

    protected void ensurePluginEngineCreated() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        this.mPluginEngine = SwiftWebAccelerator.h().g();
        if (this.mPluginEngine != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "-->web engine and plugin initialized at process preload!");
            }
            this.mPluginEngine.H();
            if (ae.a(this.intent) != null) {
                this.mPluginEngine.J(this.mApp, getActivity(), ae.a(this.intent).getCommonJsPlugin());
                return;
            }
            return;
        }
        this.mPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.mApp, getActivity(), null, ae.a(this.intent), null);
        this.mPluginEngine.I(this.mApp, getActivity());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Activity getActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Activity) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public DownloadListener getDownloadListener(CustomWebView customWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return (DownloadListener) iPatchRedirector.redirect((short) 46, (Object) this, (Object) customWebView);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUAMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return null;
    }

    public String getUrlFromIntent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String stringExtra = this.intent.getStringExtra("url");
        if (stringExtra == null) {
            String stringExtra2 = this.intent.getStringExtra("key_params_qq");
            if (stringExtra2 == null) {
                return "";
            }
            return stringExtra2;
        }
        return stringExtra;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUserAgent(String str, String str2, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            return (String) iPatchRedirector.redirect((short) 43, this, str, str2, bool);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public View getVideoLoadingProgressView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return (View) iPatchRedirector.redirect((short) 29, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void handlePreloadCallback(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public Object handlerMiscCallback(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return iPatchRedirector.redirect((short) 39, (Object) this, (Object) str, (Object) bundle);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initWebView() {
        Bundle h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.webView == null) {
            this.webView = createWebViewWrapper().n();
            System.currentTimeMillis();
            int i3 = -1;
            int intExtra = this.intent.getIntExtra("reqType", -1);
            boolean z16 = true;
            if (intExtra != 1) {
                if (intExtra == 4) {
                    i3 = 0;
                }
            } else {
                i3 = 2;
            }
            if (AppSetting.B) {
                i3 = 2;
            }
            this.webView.getSettings().setCacheMode(i3);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "setCacheMode=" + i3);
            }
            this.webView.getSettings().setAllowFileAccessFromFileURLs(false);
            this.webView.getSettings().setAllowUniversalAccessFromFileURLs(false);
            System.currentTimeMillis();
            long currentTimeMillis = System.currentTimeMillis();
            IX5WebViewExtension x5WebViewExtension = this.webView.getX5WebViewExtension();
            if (x5WebViewExtension == null) {
                z16 = false;
            }
            if (z16 && (h16 = com.tencent.mobileqq.webview.swift.utils.i.h()) != null) {
                x5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", h16);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "setDomainsAndArgumentForImageRequest, cost=" + (currentTimeMillis2 - currentTimeMillis));
            }
            this.mPluginEngine.s(this.mUrl, 8589934623L, null);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean interceptUserAgentGenerate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean isFinishing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this)).booleanValue();
        }
        return false;
    }

    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        preInitData();
        doWebSoRequest();
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.WebViewModule.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewModule.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    com.tencent.mobileqq.webview.swift.utils.g.e(WebViewModule.this.getUrlFromIntent());
                }
            }
        }, 5, null, true);
        this.mNightMode = "1103".equals(ThemeUtil.getCurrentThemeInfo().getString("themeId"));
        this.authConfig = AuthorizeConfig.y();
        this.isDestroyed = false;
        this.mCreateLoopNextStep = 2;
        if (WebAccelerateHelper.isWebViewEntered || SwiftReuseTouchWebView.I > 0) {
            this.mCreateLoopScheduler.b();
        }
        WebAccelerateHelper.isWebViewEntered = true;
        this.mCreateLoopScheduler.d(new Bundle());
    }

    public void onDestroy() {
        WebViewPluginEngine webViewPluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (1 != this.mCreateLoopNextStep) {
            this.mCreateLoopScheduler.a();
            this.mCreateLoopNextStep = 1;
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            webViewPluginEngine = touchWebView.getPluginEngine();
        } else {
            webViewPluginEngine = null;
        }
        if (webViewPluginEngine != null) {
            webViewPluginEngine.s(this.webView.getUrl(), 8589934596L, null);
        }
        new Bundle().putString("url", this.mUrl);
        destroyWebView();
        if (QQBrowserActivity.sQQBrowserActivityCounter == 0) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doUnbindService(BaseApplicationImpl.getApplication());
            SwiftBrowserStatistics.b.f314406g = -1;
        }
        w.a d16 = com.tencent.mobileqq.statistics.w.d(getClass(), hashCode());
        if (d16 != null) {
            String str = d16.f290173d;
            ReportController.o(null, "CliOper", "", "", str, str, d16.f290174e, 0, Long.toString(SystemClock.elapsedRealtime() - d16.f290172c), "", "", "");
        }
        SwiftBrowserIdleTaskHelper.h().i(2);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onDetectedBlankScreen(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, (Object) str, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        String str2;
        boolean z16;
        TouchWebView touchWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGeolocationPermissionsShowPrompt:" + str);
        }
        if (str != null && str.indexOf(58) == -1 && (touchWebView = this.webView) != null && touchWebView.getX5WebViewExtension() != null) {
            str = "https://" + str + "/";
        }
        boolean F = this.authConfig.F(str, "publicAccount.getLocation");
        TouchWebView touchWebView2 = this.webView;
        if (touchWebView2 != null) {
            str2 = com.tencent.mobileqq.webview.util.s.h(touchWebView2.getUrl(), 2);
        } else {
            str2 = "";
        }
        boolean locationPermissionGrant = ((IPublicAccountJavascriptInterface) QRoute.api(IPublicAccountJavascriptInterface.class)).getLocationPermissionGrant(this.uin, str2);
        if (locationPermissionGrant && F) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGeolocationPermissionsShowPrompt allow:", Boolean.valueOf(F), " granted:", Boolean.valueOf(locationPermissionGrant), " hasRight:", Boolean.valueOf(z16), " uin:", this.uin, " urlHost:", str2);
        }
        geolocationPermissionsCallback.invoke(str, z16, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onHideCustomView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 36, this, webView, str, str2, jsResult)).booleanValue();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onLongClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this, (Object) view)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageCommitVisible(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) webView, (Object) str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageFinished(WebView webView, String str) {
        WebViewWrapper webViewWrapper;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) webView, (Object) str);
            return;
        }
        if (!this.isDestroyed && this.webView != null) {
            ensureCreateLoopFinished();
            this.redirectCookie = false;
            if (!this.isDestroyed && (webViewWrapper = this.webViewWrapper) != null && webViewWrapper.k() != null) {
                onReceivedTitle(webView, webView.getTitle());
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, webView, str, bitmap);
        } else if (!this.isDestroyed && this.webView != null) {
            ensureCreateLoopFinished();
        }
    }

    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            dispatchPluginEvent(8589934597L, null);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) permissionRequest);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onProgressChanged(WebView webView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) webView, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, webView, Integer.valueOf(i3), str, str2);
        } else if (!this.isDestroyed && this.webView != null) {
            ensureCreateLoopFinished();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, this, webView, sslErrorHandler, sslError)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedTitle(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) webView, (Object) str);
        }
    }

    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        TouchWebView touchWebView = this.webView;
        if (touchWebView != null) {
            touchWebView.onResume();
        }
        dispatchPluginEvent(2L, null);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, (Object) this, (Object) valueCallback, (Object) fileChooserParams)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onUrlChange(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "X5 webkit detect 302 url: " + str2);
        }
        this.mRedirect302Url = str2;
        SwiftBrowserCookieMonster.H();
        buildCookieForRedirect(str, str2);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onWebViewClientImplPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, this, webView, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, this, valueCallback, str, str2);
        }
    }

    void preInitData() {
        this.mUrl = getUrlFromIntent();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebView.HitTestResult hitTestResult;
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        if (this.isDestroyed || this.webView == null) {
            return true;
        }
        if (!str.startsWith("http://")) {
            str.startsWith("https://");
        }
        if ((str.startsWith("file://") || str.startsWith("data:") || str.startsWith("http://") || str.startsWith("https://")) && !str.startsWith("http://")) {
            str.startsWith("https://");
        }
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(str);
        if (("http".equals(k3) || "https".equals(k3)) && (hitTestResult = webView.getHitTestResult()) != null && hitTestResult.getType() == 0) {
            if (QLog.isColorLevel()) {
                f16 = str;
            } else {
                f16 = com.tencent.biz.common.util.k.f(str, new String[0]);
            }
            QLog.i(TAG, 1, "shouldOverrideUrlLoading detect 302, url: " + f16);
            String str2 = this.mRedirect302Url;
            this.mRedirect302Url = str;
            SwiftBrowserCookieMonster.H();
            buildCookieForRedirect(str2, this.mRedirect302Url);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void showCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, view, Integer.valueOf(i3), customViewCallback);
        }
    }

    public void startLoadUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        com.tencent.biz.common.util.k.a("Web_readyToLoadUrl");
        if (this.webView == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.mUrl)) {
            this.webView.loadUrl(this.mUrl);
        }
        com.tencent.biz.common.util.k.d("Web_readyToLoadUrl");
        TouchWebView touchWebView = this.webView;
        if (touchWebView.isPaused) {
            touchWebView.onResume();
        }
    }
}

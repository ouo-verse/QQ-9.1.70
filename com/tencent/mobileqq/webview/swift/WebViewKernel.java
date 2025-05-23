package com.tencent.mobileqq.webview.swift;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.DebugTrace;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.SandBoxControl;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserTBSHandler;
import com.tencent.mobileqq.webview.swift.scheduler.a;
import com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper;
import com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator;
import com.tencent.mobileqq.webview.swift.utils.m;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WebViewKernel implements z, View.OnTouchListener, View.OnLongClickListener, com.tencent.mobileqq.webviewplugin.i {
    static IPatchRedirector $redirector_;
    private WebViewWrapper C;
    private volatile WebViewPluginEngine D;
    private boolean E;
    private String F;
    private long G;
    private com.tencent.mobileqq.webview.swift.component.f H;
    private ad I;
    protected final com.tencent.mobileqq.webview.swift.scheduler.a J;

    /* renamed from: d, reason: collision with root package name */
    private WebViewProvider f314094d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.webview.swift.utils.t f314095e;

    /* renamed from: f, reason: collision with root package name */
    private Intent f314096f;

    /* renamed from: h, reason: collision with root package name */
    private TouchWebView f314097h;

    /* renamed from: i, reason: collision with root package name */
    private SwiftBrowserStatistics f314098i;

    /* renamed from: m, reason: collision with root package name */
    private int f314099m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements a.InterfaceC8977a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewKernel.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.scheduler.a.InterfaceC8977a
        public int a(Bundle bundle) {
            int s16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                int i3 = WebViewKernel.this.f314099m;
                long currentTimeMillis = System.currentTimeMillis();
                int i16 = WebViewKernel.this.f314099m;
                if (i16 != 2) {
                    if (i16 != 4) {
                        if (i16 != 8) {
                            if (i16 != 16) {
                                if (i16 != 32) {
                                    if (i16 != 64) {
                                        if (i16 != 128) {
                                            if (i16 != 256) {
                                                if (i16 != 512) {
                                                    if (i16 != 1024) {
                                                        s16 = -1;
                                                    } else {
                                                        DebugTrace.Step step = DebugTrace.Step.kernel_initfinal;
                                                        DebugTrace.g(step);
                                                        s16 = WebViewKernel.this.p(bundle);
                                                        DebugTrace.e(step);
                                                    }
                                                } else {
                                                    DebugTrace.Step step2 = DebugTrace.Step.kernel_initbottom;
                                                    DebugTrace.g(step2);
                                                    s16 = WebViewKernel.this.r(bundle);
                                                    DebugTrace.e(step2);
                                                }
                                            } else {
                                                DebugTrace.Step step3 = DebugTrace.Step.kernel_inittitlebar;
                                                DebugTrace.g(step3);
                                                s16 = WebViewKernel.this.t(bundle);
                                                DebugTrace.e(step3);
                                            }
                                        } else {
                                            DebugTrace.Step step4 = DebugTrace.Step.kernel_inituicontent;
                                            DebugTrace.g(step4);
                                            s16 = WebViewKernel.this.u(bundle);
                                            DebugTrace.e(step4);
                                        }
                                    } else {
                                        DebugTrace.Step step5 = DebugTrace.Step.kernel_inituiframe;
                                        DebugTrace.g(step5);
                                        s16 = WebViewKernel.this.v(bundle);
                                        DebugTrace.e(step5);
                                    }
                                } else {
                                    DebugTrace.Step step6 = DebugTrace.Step.kernel_loadurl;
                                    DebugTrace.g(step6);
                                    s16 = WebViewKernel.this.y(bundle);
                                    DebugTrace.e(step6);
                                }
                            } else {
                                DebugTrace.Step step7 = DebugTrace.Step.kernel_initwebview;
                                DebugTrace.g(step7);
                                s16 = WebViewKernel.this.w(bundle);
                                DebugTrace.e(step7);
                            }
                        } else {
                            DebugTrace.Step step8 = DebugTrace.Step.kernel_initx5;
                            DebugTrace.g(step8);
                            s16 = WebViewKernel.this.x(bundle);
                            DebugTrace.e(step8);
                        }
                    } else {
                        DebugTrace.Step step9 = DebugTrace.Step.kernel_initengine;
                        DebugTrace.g(step9);
                        s16 = WebViewKernel.this.q(bundle);
                        DebugTrace.e(step9);
                    }
                } else {
                    DebugTrace.Step step10 = DebugTrace.Step.kernel_initdata;
                    DebugTrace.g(step10);
                    s16 = WebViewKernel.this.s(bundle);
                    DebugTrace.e(step10);
                }
                QLog.i("WebLog_WebViewKernel", 1, "CreateLoop:step[" + i3 + "] -> step[" + WebViewKernel.this.f314099m + "] cost=" + (System.currentTimeMillis() - currentTimeMillis) + " ms. nextAction= " + s16);
                return s16;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).intValue();
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
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) WebViewKernel.this, i3);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.utils.SwiftBrowserIdleTaskHelper.b
        public int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (QLog.isColorLevel()) {
                QLog.i("WebLog_WebViewKernel", 2, "TASK_ID_BROWSER_ACTIVITY_RUN_ONCE.");
                return 1;
            }
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class c implements m.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<WebViewKernel> f314104a;

        /* renamed from: b, reason: collision with root package name */
        private Bundle f314105b;

        c(WebViewKernel webViewKernel, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) webViewKernel, (Object) bundle);
            } else {
                this.f314104a = new WeakReference<>(webViewKernel);
                this.f314105b = bundle;
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.utils.m.a
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            WebViewKernel webViewKernel = this.f314104a.get();
            if (webViewKernel != null && !webViewKernel.J.c()) {
                webViewKernel.J.d(this.f314105b);
            }
        }
    }

    public WebViewKernel(@NonNull WebViewProvider webViewProvider, com.tencent.mobileqq.webview.swift.utils.t tVar, @NonNull ad adVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, webViewProvider, tVar, adVar);
            return;
        }
        this.f314099m = 1;
        this.E = true;
        this.F = "";
        this.G = 0L;
        this.J = new com.tencent.mobileqq.webview.swift.scheduler.a(new a());
        this.f314094d = webViewProvider;
        this.f314095e = tVar;
        this.f314096f = webViewProvider.getIntent();
        this.f314098i = (SwiftBrowserStatistics) this.f314094d.getComponentProvider().a(-2);
        this.H = (com.tencent.mobileqq.webview.swift.component.f) this.f314094d.getComponentProvider().a(-1);
        this.I = adVar;
    }

    private void B() {
        int i3 = this.f314099m;
        if (1 != i3) {
            this.J.a();
            this.J.b();
            this.J.d(null);
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QLog.w("WebLog_WebViewKernel", 1, "call ensureCreateLoopFinished: create loop next step:" + i3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(String str, String str2) {
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "BizTechReport", "", "web", "float_bar_fv", 0, 1, 0, this.I.c() + "", str, com.tencent.mobileqq.webview.util.g.a() + "", str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H() {
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int) ((System.nanoTime() - this.f314098i.J) / 1000000), "", "", "", "" + this.f314098i.B0);
    }

    private void j(String str, String str2) {
        SwiftBrowserCookieMonster s16;
        try {
            String f16 = com.tencent.mobileqq.webview.swift.cookie.b.f(str);
            String f17 = com.tencent.mobileqq.webview.swift.cookie.b.f(str2);
            if ((f16 != null && f16.contains("ptlogin")) || (f17 != null && f17.contains("ptlogin"))) {
                this.E = false;
            }
            if (this.E && (s16 = SwiftBrowserCookieMonster.s(str2)) != null) {
                s16.I(str2, null, null, this.f314096f);
            }
        } catch (Throwable th5) {
            QLog.e("WebLog_WebViewKernel", 1, th5, new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l() {
        long j3;
        int i3;
        if (this.f314098i.G0) {
            j3 = 2;
        } else {
            j3 = SwiftBrowserStatistics.f314343h1 ? 1L : 0L;
        }
        TouchWebView touchWebView = this.f314097h;
        if (touchWebView instanceof SwiftReuseTouchWebView) {
            i3 = ((SwiftReuseTouchWebView) touchWebView).s(1);
        } else {
            i3 = 0;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("WebLog_WebViewKernel", 2, String.format("reportInitPerformance, initType: %d, webViewType: %d, TbsAccelerator.sCostTime: %d", Long.valueOf(j3), Integer.valueOf(i3), Long.valueOf(SwiftBrowserStatistics.W0)));
        }
        this.f314098i.f314352a0 = SystemClock.elapsedRealtime();
    }

    private WebViewWrapper m(ViewGroup viewGroup) {
        boolean b16 = this.I.b();
        WebViewWrapper createWebViewWrapper = this.f314094d.createWebViewWrapper(b16);
        this.C = createWebViewWrapper;
        if (createWebViewWrapper == null) {
            this.C = new WebViewWrapper(this, this.f314096f, this.f314094d.getHostActivity(), b16);
        }
        TouchWebView n3 = this.C.n();
        com.tencent.mobileqq.webview.html.l h16 = com.tencent.mobileqq.webview.html.c.f313882a.h(this.f314094d.getUrlFromIntent());
        if (h16 != null) {
            h16.d(n3);
            this.C.s(h16);
        }
        this.D.Q(n3);
        n3.setPluginEngine(this.D);
        if (n3 instanceof SwiftReuseTouchWebView) {
            this.f314098i.E0 = ((SwiftReuseTouchWebView) n3).s(1);
        }
        n3.getView().setOnTouchListener(this);
        if (viewGroup != null) {
            viewGroup.addView(n3);
        }
        return this.C;
    }

    private void n() {
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewKernel", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        WebViewWrapper webViewWrapper = this.C;
        if (webViewWrapper != null) {
            webViewWrapper.i();
            this.C = null;
            this.f314097h = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int q(Bundle bundle) {
        boolean z16;
        v.f(v.f314820p);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_app_and_webview_engine");
        com.tencent.mobileqq.webview.swift.startup.e.c(com.tencent.mobileqq.webview.swift.startup.e.EVENT_KERNEL_INIT_ENGINE, new Object[0]);
        AppRuntime appRuntime = this.f314094d.getAppRuntime();
        if (appRuntime.getLongAccountUin() != 0) {
            SwiftBrowserStatistics swiftBrowserStatistics = this.f314098i;
            if (appRuntime.getLongAccountUin() % SwiftBrowserStatistics.f314345j1 == 6) {
                z16 = true;
            } else {
                z16 = false;
            }
            swiftBrowserStatistics.f314379w0 = z16;
        }
        C();
        if (this.D != null) {
            this.D.D(this.f314096f.getStringArrayExtra("insertPluginsArray"));
            this.D.s(this.f314094d.getCurrentUrl(), 1L, null);
        }
        this.f314099m = 8;
        if (SwiftBrowserStatistics.f314346k1) {
            this.f314098i.K("webview_init", System.currentTimeMillis() - this.f314098i.f314361h, "0");
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_app_and_webview_engine");
        v.d(v.f314820p);
        if (com.tencent.mobileqq.webview.swift.utils.m.f()) {
            return 0;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int r(Bundle bundle) {
        v.f(v.f314826v);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_bottombar");
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onInitBottomBar(bundle);
        }
        this.f314099m = 1024;
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_bottombar");
        v.d(v.f314826v);
        if (this.f314097h == null) {
            if (QLog.isColorLevel()) {
                QLog.i("WebLog_WebViewKernel", 2, "mCreateLoopNextStep is CREATE_LOOP_STEP_FINAL, but webview is still null!");
                return -1;
            }
            return -1;
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int x(Bundle bundle) {
        int i3;
        v.f(v.f314819o);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_x5_environment");
        this.f314098i.f314364i0 = System.currentTimeMillis();
        this.f314099m = 16;
        if (!com.tencent.mobileqq.webview.swift.utils.m.e()) {
            if (com.tencent.mobileqq.webview.swift.utils.m.f()) {
                com.tencent.mobileqq.webview.swift.utils.m.h(new c(this, bundle));
                i3 = -1;
            } else {
                com.tencent.mobileqq.webview.swift.utils.m.g();
                i3 = 1;
            }
        } else {
            i3 = 0;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onX5Init(bundle);
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_x5_environment");
        v.d(v.f314819o);
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y(Bundle bundle) {
        com.tencent.mobileqq.webview.swift.startup.e.c(com.tencent.mobileqq.webview.swift.startup.e.EVENT_KERNEL_LOAD_URL, new Object[0]);
        v.f(v.f314814j);
        v.f(v.f314822r);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_load_url");
        this.f314098i.g0("state_load_url");
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_init");
        N();
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_init");
        this.f314098i.N = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_WebViewKernel", 2, "init param and load url, cost = " + this.f314098i.N);
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_load_url");
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.loadUrlFinish();
        }
        this.f314099m = 64;
        v.d(v.f314822r);
        return 0;
    }

    public AuthorizeConfig A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            return (AuthorizeConfig) iPatchRedirector.redirect((short) 50, (Object) this);
        }
        return AuthorizeConfig.y();
    }

    protected void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        this.D = SwiftWebAccelerator.h().g();
        if (this.D != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("WebLog_WebViewKernel", 2, "-->web engine and plugin initialized at process preload!");
            }
            this.D.I(this.f314094d.getAppRuntime(), this.f314094d.getHostActivity());
            this.D.L();
            this.D.a(this.f314094d);
            return;
        }
        this.D = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.f314094d.getAppRuntime(), this.f314094d.getHostActivity(), null, null);
        this.D.a(this.f314094d);
    }

    public String D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.F;
    }

    public int E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.f314099m;
    }

    protected void F() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f314097h == null) {
            TouchWebView n3 = m(null).n();
            this.f314097h = n3;
            n3.getView().setOnTouchListener(this);
            boolean z16 = false;
            if (!this.f314096f.getBooleanExtra("key_from_opensdk_qrcode", false)) {
                this.f314097h.setOnLongClickListener(this);
            }
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
            if (tVar != null) {
                i3 = tVar.getCacheMode(this.I);
            } else {
                i3 = -1;
            }
            this.f314097h.getSettings().setCacheMode(i3);
            this.f314097h.getSettings().setAllowFileAccessFromFileURLs(false);
            this.f314097h.getSettings().setAllowUniversalAccessFromFileURLs(false);
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ((Boolean) com.tencent.mobileqq.webview.util.t.j().b("debug_time_trace_log", Boolean.FALSE)).booleanValue()) {
                this.f314097h.getSettings().setAllowFileAccess(true);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            SwiftBrowserStatistics swiftBrowserStatistics = this.f314098i;
            swiftBrowserStatistics.M = currentTimeMillis2 - currentTimeMillis;
            swiftBrowserStatistics.f314366k0 = currentTimeMillis2;
            long currentTimeMillis3 = System.currentTimeMillis();
            IX5WebViewExtension x5WebViewExtension = this.f314097h.getX5WebViewExtension();
            if (x5WebViewExtension != null) {
                z16 = true;
            }
            if (z16) {
                Bundle h16 = com.tencent.mobileqq.webview.swift.utils.i.h();
                if (h16 != null) {
                    x5WebViewExtension.invokeMiscMethod("setDomainsAndArgumentForImageRequest", h16);
                }
                SwiftBrowserStatistics swiftBrowserStatistics2 = this.f314098i;
                swiftBrowserStatistics2.M0 = 2;
                swiftBrowserStatistics2.N0 = String.valueOf(QbSdk.getTbsVersion(MobileQQ.sMobileQQ));
            } else {
                SwiftBrowserStatistics swiftBrowserStatistics3 = this.f314098i;
                swiftBrowserStatistics3.M0 = 1;
                swiftBrowserStatistics3.N0 = String.valueOf(Build.VERSION.SDK_INT);
            }
            this.f314098i.f314355d0 = this.C.f314159f;
            long currentTimeMillis4 = System.currentTimeMillis();
            if (QLog.isDevelopLevel()) {
                QLog.i("WebLog_WebViewKernel", 2, "setDomainsAndArgumentForImageRequest, cost=" + (currentTimeMillis4 - currentTimeMillis3) + "init browser, cost = " + this.f314098i.M + "setCacheMode=" + i3);
            }
        }
    }

    public void I(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
            return;
        }
        if (bundle != null) {
            QLog.e("WebLog_WebViewKernel", 1, "onCreate from restore mOnCreateMilliTimeStamp = " + this.f314096f.getLongExtra("qqBrowserActivityCreateTime", -2L));
            this.f314096f.removeExtra("qqBrowserActivityCreateTime");
            this.f314096f.putExtra("startOpenPageTime", System.currentTimeMillis());
        }
        com.tencent.mobileqq.webview.swift.startup.e.c(com.tencent.mobileqq.webview.swift.startup.e.EVENT_KERNEL_CREATE, new Object[0]);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_all");
        this.f314099m = 2;
        if ((WebAccelerateHelper.isWebViewEntered && com.tencent.mobileqq.webview.swift.utils.m.e()) || SwiftReuseTouchWebView.I > 0) {
            if (QLog.isColorLevel()) {
                QLog.d("WebLog_WebViewKernel", 2, "onCreate entered: ", Boolean.valueOf(WebAccelerateHelper.isWebViewEntered), ", tbsDone: ", Boolean.valueOf(com.tencent.mobileqq.webview.swift.utils.m.e()), ", wvPool: ", Integer.valueOf(SwiftReuseTouchWebView.I));
            }
            this.J.b();
            this.f314098i.X = false;
        }
        WebAccelerateHelper.isWebViewEntered = true;
        QLog.d("WebLog_WebViewKernel", 1, "schedule url: " + com.tencent.mobileqq.webview.util.s.d(this.f314094d.getCurrentUrl(), new String[0]));
        this.J.d(bundle);
    }

    public void J() {
        WebViewPluginEngine webViewPluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        if (1 != this.f314099m) {
            this.J.a();
            this.f314099m = 1;
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QQToast.makeText(this.f314094d.getHostActivity(), "call doOnDestroy: cancel all state machine ", 1).show();
            }
        }
        TouchWebView touchWebView = this.f314097h;
        if (touchWebView != null) {
            webViewPluginEngine = touchWebView.getPluginEngine();
        } else {
            webViewPluginEngine = null;
        }
        if (webViewPluginEngine != null) {
            webViewPluginEngine.s(this.f314097h.getUrl(), 8589934596L, null);
        }
        SwiftBrowserIdleTaskHelper.h().i(2);
        n();
    }

    public void K() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            o(8589934597L, null);
        }
    }

    public void L() {
        WebViewFragment currentWebViewFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("WebLog_WebViewKernel", 2, "webview_trace end");
        }
        TouchWebView touchWebView = this.f314097h;
        if (touchWebView != null) {
            touchWebView.onResume();
        }
        ComponentCallbacks2 hostActivity = this.f314094d.getHostActivity();
        boolean z16 = true;
        if ((hostActivity instanceof u) && (currentWebViewFragment = ((u) hostActivity).getCurrentWebViewFragment()) != null && currentWebViewFragment != this.f314094d) {
            z16 = false;
        }
        if (z16) {
            o(2L, null);
        }
    }

    public void M(int i3, com.tencent.mobileqq.webview.swift.startup.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, i3, (Object) dVar);
        } else {
            QLog.d("WebLog_WebViewKernel", 1, String.format("onStepDone:%d data:%s", Integer.valueOf(i3), com.tencent.mobileqq.webview.swift.startup.d.a(dVar)));
        }
    }

    protected void N() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        com.tencent.mobileqq.webview.util.s.a("Web_readyToLoadUrl");
        if (this.f314097h == null) {
            return;
        }
        SwiftBrowserStatistics swiftBrowserStatistics = this.f314098i;
        if (swiftBrowserStatistics.f314379w0 && swiftBrowserStatistics.J > 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.ac
                @Override // java.lang.Runnable
                public final void run() {
                    WebViewKernel.this.H();
                }
            }, 16, null, false);
            this.f314098i.J = 0L;
        }
        this.f314098i.R = System.currentTimeMillis();
        SwiftBrowserStatistics swiftBrowserStatistics2 = this.f314098i;
        long j3 = swiftBrowserStatistics2.R - swiftBrowserStatistics2.f314358f;
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && this.f314098i.f314358f > 0 && j3 < 60000) {
            QLog.i("WebLog_WebViewKernel", 1, "Web_qqbrowser_from_click_to_readyLoadUrl, cost=" + j3);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null && tVar.interceptStartLoadUrl()) {
            QLog.i("WebLog_WebViewKernel", 1, "interceptStartLoadUrl");
        }
        com.tencent.mobileqq.webview.util.s.b("Web_readyToLoadUrl");
        this.f314098i.a0(this.f314097h, this.f314094d.getCurrentUrl(), 0, 0, 0, 0, 0, new String[0]);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean afterWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        String scheme = Uri.parse(str).getScheme();
        if (this.f314094d.isActivityResume() && A().G(webView.getUrl(), scheme).booleanValue()) {
            com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
            if (tVar != null) {
                tVar.afterWebViewEngineHandleOverrideUrl(webView, str);
            }
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean beforeWebViewEngineHandleOverrideUrl(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        if (this.f314094d.isDestroyed() || this.f314097h == null) {
            return true;
        }
        com.tencent.mobileqq.webview.util.s.a("urlInterceptManager");
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null && tVar.beforeWebViewEngineHandleOverrideUrl(webView, str)) {
            com.tencent.mobileqq.webview.util.s.b("urlInterceptManager");
            return true;
        }
        com.tencent.mobileqq.webview.util.s.b("urlInterceptManager");
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public DownloadListener getDownloadListener(CustomWebView customWebView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            return (DownloadListener) iPatchRedirector.redirect((short) 45, (Object) this, (Object) customWebView);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            return tVar.getDownloadListener(customWebView);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUAMark() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (String) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return null;
        }
        return tVar.getUAMark();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public String getUserAgent(String str, String str2, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return (String) iPatchRedirector.redirect((short) 42, this, str, str2, bool);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return null;
        }
        return tVar.getUserAgent(str, str2, bool);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public View getVideoLoadingProgressView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return (View) iPatchRedirector.redirect((short) 31, (Object) this);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return null;
        }
        return tVar.getVideoLoadingProgressView();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void handlePreloadCallback(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3, (Object) str);
            return;
        }
        SwiftBrowserTBSHandler swiftBrowserTBSHandler = (SwiftBrowserTBSHandler) this.f314094d.getComponentProvider().a(16);
        if (swiftBrowserTBSHandler != null) {
            swiftBrowserTBSHandler.l(i3, str);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.handlePreloadCallback(i3, str);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public Object handlerMiscCallback(String str, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return iPatchRedirector.redirect((short) 38, (Object) this, (Object) str, (Object) bundle);
        }
        SwiftBrowserTBSHandler swiftBrowserTBSHandler = (SwiftBrowserTBSHandler) this.f314094d.getComponentProvider().a(16);
        if (swiftBrowserTBSHandler != null) {
            return swiftBrowserTBSHandler.n(str, bundle);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return null;
        }
        return tVar.handlerMiscCallback(str, bundle);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean interceptUserAgentGenerate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return ((Boolean) iPatchRedirector.redirect((short) 41, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return false;
        }
        return tVar.interceptUserAgentGenerate();
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean isFinishing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Boolean) iPatchRedirector.redirect((short) 46, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            return tVar.isFinishing();
        }
        return false;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this);
            return;
        }
        if (1 != this.f314099m) {
            this.J.a();
            this.f314099m = 1;
            if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                QQToast.makeText(MobileQQ.sMobileQQ, "call onBackEvent: cancel all state machine ", 1).show();
            }
        }
    }

    public boolean o(long j3, Map<String, Object> map) {
        WebViewPluginEngine pluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, this, Long.valueOf(j3), map)).booleanValue();
        }
        TouchWebView touchWebView = this.f314097h;
        if (touchWebView == null || (pluginEngine = touchWebView.getPluginEngine()) == null) {
            return false;
        }
        return pluginEngine.s(this.f314097h.getUrl(), j3, map);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onDetectedBlankScreen(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) str, i3);
            return;
        }
        this.f314098i.E(str, i3);
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onDetectedBlankScreen(str, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissionsCallback geolocationPermissionsCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str, (Object) geolocationPermissionsCallback);
            return;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onGeolocationPermissionsShowPrompt(str, geolocationPermissionsCallback);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onHideCustomView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onHideCustomView();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Boolean) iPatchRedirector.redirect((short) 35, this, webView, str, str2, jsResult)).booleanValue();
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return false;
        }
        return tVar.onJsAlert(webView, str, str2, jsResult);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onLongClick(View view) {
        boolean onLongClick;
        EventCollector.getInstance().onViewLongClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            onLongClick = ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this, (Object) view)).booleanValue();
        } else if (!this.H.g("web_view_long_click", true)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("WebLog_WebViewKernel", 1, "disable long click on current url!");
            }
            onLongClick = true;
        } else {
            if (!this.H.g("image_long_click", false)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("WebLog_WebViewKernel", 1, "disable image long click on current url!");
                }
            } else {
                com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
                if (tVar != null) {
                    onLongClick = tVar.onLongClick(view);
                }
            }
            onLongClick = false;
        }
        EventCollector.getInstance().onViewLongClicked(view);
        return onLongClick;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageCommitVisible(WebView webView, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) webView, (Object) str);
            return;
        }
        if (!this.f314094d.isDestroyed() && webView != null) {
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            this.f314094d.getComponentProvider().b(11, bundle);
            com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
            if (tVar != null) {
                tVar.onPageCommitVisible(webView, str);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageFinished(WebView webView, String str) {
        WebViewWrapper webViewWrapper;
        Bundle bundleExtra;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) webView, (Object) str);
            return;
        }
        if (!this.f314094d.isDestroyed() && this.f314097h != null) {
            SandBoxControl.f();
            this.f314098i.g0("state_page_finished");
            B();
            if (!"about:blank".equalsIgnoreCase(str)) {
                SwiftBrowserStatistics.b bVar = this.f314098i.T0;
                if (bVar.f314408a == 2) {
                    bVar.f314408a = 8;
                    bVar.f314412e = System.currentTimeMillis();
                }
            }
            v.f(v.f314816l);
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            this.f314094d.getComponentProvider().b(8, bundle);
            if (this.f314098i.f314381y0) {
                this.E = false;
                SwiftBrowserIdleTaskHelper.h().f(new SwiftBrowserIdleTaskHelper.c(1));
                if (this.f314096f.getBooleanExtra("banner_fromBanner", false) && (bundleExtra = this.f314096f.getBundleExtra("banner_webview_extra")) != null && bundleExtra.containsKey("AIO_Scroll_Y") && (i3 = bundleExtra.getInt("AIO_Scroll_Y")) > 0 && this.f314097h.getView() != null) {
                    ThreadManager.getUIHandler().post(new Runnable(i3) { // from class: com.tencent.mobileqq.webview.swift.WebViewKernel.4
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ int f314101d;

                        {
                            this.f314101d = i3;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewKernel.this, i3);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("WebLog_WebViewKernel", 2, "banner scroll to " + this.f314101d + " !");
                            }
                            if (!WebViewKernel.this.f314097h.isPaused) {
                                WebViewKernel.this.f314097h.getView().scrollTo(0, this.f314101d);
                            }
                        }
                    });
                }
                this.f314098i.f314369m0 = System.currentTimeMillis();
                if (SwiftBrowserStatistics.f314346k1) {
                    this.f314098i.K("web_loaded_url", System.currentTimeMillis() - this.f314098i.f314361h, "0");
                }
            }
            if (!this.f314094d.isDestroyed() && (webViewWrapper = this.C) != null && webViewWrapper.k() != null) {
                onReceivedTitle(webView, webView.getTitle());
            }
            com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
            if (tVar != null) {
                tVar.onPageFinished(webView, str);
            }
            SwiftBrowserStatistics swiftBrowserStatistics = this.f314098i;
            swiftBrowserStatistics.f314381y0 = false;
            swiftBrowserStatistics.g0("state_final");
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, webView, str, bitmap);
            return;
        }
        if (!this.f314094d.isDestroyed() && this.f314097h != null) {
            B();
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            this.f314094d.getComponentProvider().b(7, bundle);
            com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
            if (tVar != null) {
                tVar.onPageStarted(webView, str, bitmap);
            }
            if (this.f314098i.f314380x0) {
                v.f(v.f314815k);
                final String currentUrl = this.f314094d.getCurrentUrl();
                final String uin = this.f314094d.getUin();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.ab
                    @Override // java.lang.Runnable
                    public final void run() {
                        WebViewKernel.this.G(currentUrl, uin);
                    }
                }, 16, null, false);
                if (SwiftBrowserStatistics.f314346k1) {
                    this.f314098i.K("web_start_load_url", System.currentTimeMillis() - this.f314098i.f314361h, "0");
                }
                this.f314098i.f314380x0 = false;
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onPermissionRequest(PermissionRequest permissionRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) permissionRequest);
            return;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return;
        }
        tVar.onPermissionRequest(permissionRequest);
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onProgressChanged(WebView webView, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) webView, i3);
            return;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onProgressChanged(webView, i3);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedError(WebView webView, int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, webView, Integer.valueOf(i3), str, str2);
            return;
        }
        if (!this.f314094d.isDestroyed() && this.f314097h != null) {
            B();
            QLog.e("WebLog_WebViewKernel", 1, "errorCode=" + i3 + "descrip=" + str + "failingUrl" + com.tencent.mobileqq.webview.util.s.d(str2, new String[0]));
            this.f314098i.H(this.f314097h, i3, str, str2);
            if (SwiftBrowserStatistics.f314346k1) {
                this.f314098i.K("web_loaded_url_err", System.currentTimeMillis() - this.f314098i.f314361h, String.valueOf(i3));
            }
            com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
            if (tVar != null) {
                tVar.onReceivedError(webView, i3, str, str2);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, this, webView, sslErrorHandler, sslError)).booleanValue();
        }
        if (SwiftBrowserStatistics.f314346k1) {
            this.f314098i.K("web_loaded_url_err", System.currentTimeMillis() - this.f314098i.f314361h, String.valueOf(sslError.getPrimaryError()));
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            return tVar.onReceivedSslError(webView, sslErrorHandler, sslError);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onReceivedTitle(WebView webView, String str) {
        com.tencent.mobileqq.webview.swift.utils.t tVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) webView, (Object) str);
        } else if (!this.f314094d.isDestroyed() && this.f314097h != null && (tVar = this.f314095e) != null) {
            tVar.onReceivedTitle(webView, str);
        }
    }

    @Override // com.tencent.mobileqq.webviewplugin.i
    public void onRuntimeUpdate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) appRuntime);
        } else if (this.D != null) {
            this.D.onRuntimeUpdate(appRuntime);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Boolean) iPatchRedirector.redirect((short) 34, (Object) this, (Object) valueCallback, (Object) fileChooserParams)).booleanValue();
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar == null) {
            return false;
        }
        return tVar.onShowFileChooser(valueCallback, fileChooserParams);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return ((Boolean) iPatchRedirector.redirect((short) 47, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.interceptTouchEvent(view, motionEvent);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onUrlChange(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("WebLog_WebViewKernel", 2, "X5 webkit detect 302 url: " + str2);
        }
        this.F = str2;
        SwiftBrowserCookieMonster.H();
        j(str, str2);
        this.f314098i.Z(str2);
        if (this.D != null) {
            this.D.s(str2, 8589934626L, null);
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onUrlChange(str, str2);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void onWebViewClientImplPageStarted(WebView webView, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, this, webView, str, bitmap);
            return;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onWebViewClientImplPageStarted(webView, str, bitmap);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, this, valueCallback, str, str2);
            return;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.openFileChooser(valueCallback, str, str2);
        }
    }

    protected int p(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle)).intValue();
        }
        v.f(v.f314827w);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_FINAL");
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.WebViewKernel.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) WebViewKernel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.WebViewKernel.2.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            SwiftBrowserTBSHandler swiftBrowserTBSHandler = (SwiftBrowserTBSHandler) WebViewKernel.this.f314094d.getComponentProvider().a(16);
                            if (swiftBrowserTBSHandler != null) {
                                swiftBrowserTBSHandler.o();
                            }
                        }
                    }, null, false);
                }
            }
        }, 3000L);
        SwiftBrowserIdleTaskHelper.h().f(new b(2));
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onFinalState(bundle);
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_FINAL");
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_all");
        this.f314099m = 1;
        l();
        v.d(v.f314827w);
        v.f(v.f314817m);
        return -1;
    }

    protected int s(Bundle bundle) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).intValue();
        }
        v.f(v.f314818n);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_data");
        QbSdk.setQQBuildNumber(((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).f());
        String stringExtra = this.f314096f.getStringExtra("options");
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.f314096f.putExtra("url", jSONObject.getString("url"));
                if (!this.f314096f.hasExtra("key_isReadModeEnabled")) {
                    this.f314096f.putExtra("key_isReadModeEnabled", true);
                }
                this.f314096f.putExtra("ba_is_login", jSONObject.optBoolean("ba_is_login", true));
                this.f314096f.putExtra("isShowAd", jSONObject.optBoolean("isShowAd", true));
                this.f314096f.putExtra("avoidLoginWeb", jSONObject.optBoolean("avoidLoginWeb", false));
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("WebLog_WebViewKernel", 2, e16.toString());
                }
            }
        }
        this.f314098i.T0.f314410c = this.f314096f.getIntExtra("individuation_url_type", -1);
        SwiftBrowserStatistics swiftBrowserStatistics = this.f314098i;
        SwiftBrowserStatistics.b bVar = swiftBrowserStatistics.T0;
        if (bVar.f314410c == -1 && (i3 = SwiftBrowserStatistics.b.f314406g) != -1) {
            bVar.f314410c = i3;
        }
        swiftBrowserStatistics.A0 = this.f314094d.getCurrentUrl();
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onDataInit(bundle);
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_data");
        v.d(v.f314818n);
        this.f314099m = 4;
        return 0;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        WebView.HitTestResult hitTestResult;
        String d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this, (Object) webView, (Object) str)).booleanValue();
        }
        if (this.f314094d.isDestroyed() || this.f314097h == null) {
            return true;
        }
        if (str.startsWith("http://") || str.startsWith("https://")) {
            this.f314098i.f314377u0 = false;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null && tVar.shouldOverrideUrlLoading(webView, str)) {
            return true;
        }
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(str);
        if (("http".equals(k3) || "https".equals(k3)) && (hitTestResult = webView.getHitTestResult()) != null && hitTestResult.getType() == 0) {
            if (QLog.isColorLevel()) {
                d16 = str;
            } else {
                d16 = com.tencent.mobileqq.webview.util.s.d(str, new String[0]);
            }
            QLog.i("WebLog_WebViewKernel", 1, "shouldOverrideUrlLoading detect 302, url: " + d16);
            String str2 = this.F;
            this.F = str;
            SwiftBrowserCookieMonster.H();
            j(str2, this.F);
            this.f314098i.Z(str);
            if (this.D != null) {
                this.D.s(str, 8589934626L, null);
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.webview.swift.z
    public void showCustomView(View view, int i3, IX5WebChromeClient.CustomViewCallback customViewCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, view, Integer.valueOf(i3), customViewCallback);
            return;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.showCustomView(view, i3, customViewCallback);
        }
    }

    protected int t(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle)).intValue();
        }
        v.f(v.f314825u);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_titlebar");
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onInitTitleBar(bundle);
        }
        this.f314099m = 512;
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_titlebar");
        v.d(v.f314825u);
        return 1;
    }

    protected int u(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle)).intValue();
        }
        v.f(v.f314824t);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_ui_main_content");
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_initView");
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onInitUIContent(bundle);
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_initView");
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_ui_main_content");
        this.f314099m = 256;
        v.d(v.f314824t);
        return 1;
    }

    protected int v(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) bundle)).intValue();
        }
        v.f(v.f314823s);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_ui_frame");
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null && tVar.interceptInitUIFrame()) {
            this.f314099m = 128;
            com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_ui_frame");
            return 2;
        }
        com.tencent.mobileqq.webview.swift.utils.t tVar2 = this.f314095e;
        if (tVar2 != null) {
            tVar2.onShowPreview(bundle);
        }
        this.f314099m = 128;
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_ui_frame");
        v.d(v.f314823s);
        return 2;
    }

    protected int w(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).intValue();
        }
        v.f(v.f314821q);
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_state_machine_init_webview");
        this.f314098i.g0("state_webview_create");
        com.tencent.mobileqq.webview.swift.startup.e.c(com.tencent.mobileqq.webview.swift.startup.e.EVENT_KERNEL_INIT_WEBVIEW, new Object[0]);
        F();
        this.f314094d.setWebView(this.f314097h);
        com.tencent.mobileqq.webview.swift.utils.t tVar = this.f314095e;
        if (tVar != null) {
            tVar.onWebViewInit(bundle, this.f314097h);
        }
        com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_state_machine_init_webview");
        this.f314099m = 32;
        this.f314098i.f314365j0 = System.currentTimeMillis();
        if (SwiftBrowserStatistics.f314346k1) {
            SwiftBrowserStatistics swiftBrowserStatistics = this.f314098i;
            swiftBrowserStatistics.K("should_start_load", swiftBrowserStatistics.f314365j0 - swiftBrowserStatistics.f314361h, "0");
        }
        v.d(v.f314821q);
        this.f314098i.V = v.c(v.f314821q);
        return 0;
    }

    public void z(Intent intent) {
        TouchWebView touchWebView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) intent);
            return;
        }
        String dataString = intent.getDataString();
        if (dataString != null && (touchWebView = this.f314097h) != null) {
            touchWebView.loadUrl(dataString);
            return;
        }
        this.f314096f = intent;
        this.J.a();
        if (intent.getBooleanExtra("onNewIntentReDoStateMachine", true)) {
            this.f314099m = 2;
            this.J.d(intent.getExtras());
        }
    }
}

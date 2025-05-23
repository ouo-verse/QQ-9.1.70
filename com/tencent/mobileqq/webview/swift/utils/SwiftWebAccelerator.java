package com.tencent.mobileqq.webview.swift.utils;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.log.VipWebViewReportLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.scheduler.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftWebAccelerator {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static SwiftWebAccelerator f314717e;

    /* renamed from: f, reason: collision with root package name */
    public static final Object f314718f;

    /* renamed from: a, reason: collision with root package name */
    public int f314719a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f314720b;

    /* renamed from: c, reason: collision with root package name */
    public int f314721c;

    /* renamed from: d, reason: collision with root package name */
    final com.tencent.mobileqq.webview.swift.scheduler.a f314722d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator$4, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SwiftReuseTouchWebView f314726d;
        final /* synthetic */ SwiftWebAccelerator this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                this.f314726d.destroy();
            } catch (Exception e16) {
                QLog.e("WebLog_SwiftWebAccelerator", 1, "doMainStep_WarnUpWebView error:" + e16.toString());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements a.InterfaceC8977a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftWebAccelerator.this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.scheduler.a.InterfaceC8977a
        public int a(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle)).intValue();
            }
            if (SwiftWebAccelerator.this.f314720b) {
                QLog.i("WebLog_SwiftWebAccelerator", 1, "mScheduler.next:is in real world, stop the preload task.");
                return -1;
            }
            SwiftWebAccelerator swiftWebAccelerator = SwiftWebAccelerator.this;
            if ((swiftWebAccelerator.f314721c & 2) != 0) {
                if ((swiftWebAccelerator.f314719a & 1024) == 0) {
                    swiftWebAccelerator.f(bundle);
                }
                SwiftWebAccelerator swiftWebAccelerator2 = SwiftWebAccelerator.this;
                if ((swiftWebAccelerator2.f314719a & 2048) == 0) {
                    swiftWebAccelerator2.d(bundle);
                }
                SwiftWebAccelerator swiftWebAccelerator3 = SwiftWebAccelerator.this;
                if ((swiftWebAccelerator3.f314719a & 4096) == 0) {
                    swiftWebAccelerator3.e(bundle);
                }
                SwiftWebAccelerator swiftWebAccelerator4 = SwiftWebAccelerator.this;
                if ((swiftWebAccelerator4.f314719a & 1) == 0) {
                    return swiftWebAccelerator4.i(bundle);
                }
            }
            SwiftWebAccelerator swiftWebAccelerator5 = SwiftWebAccelerator.this;
            if ((swiftWebAccelerator5.f314721c & 1) != 0) {
                try {
                    if ((swiftWebAccelerator5.f314719a & 2) == 0) {
                        if (m.e()) {
                            return SwiftWebAccelerator.this.b(bundle);
                        }
                        QLog.i("WebLog_SwiftWebAccelerator", 1, "tbs core not ready yet");
                        return -1;
                    }
                    if (!SwiftBrowserStatistics.f314343h1) {
                        SwiftBrowserStatistics.f314343h1 = true;
                        if (WebProcessReceiver.f313724c > 0) {
                            long j3 = WebProcessReceiver.f313725d;
                            if (j3 > 0) {
                                SwiftBrowserStatistics.Z0 = j3 - WebProcessReceiver.f313724c;
                                SwiftBrowserStatistics.f314336a1 = System.currentTimeMillis() - WebProcessReceiver.f313725d;
                                int i3 = (int) SwiftBrowserStatistics.Z0;
                                int i16 = (int) SwiftBrowserStatistics.f314336a1;
                                QLog.i("WebLog_SwiftWebAccelerator", 1, "cross process cost: " + i3 + "ms, preload cost: " + i16 + "ms.");
                                VasBaseWebviewUtil.reportVasStatus("Preload_Web_Process", "", "", i3, i16, 0, 0, "", "");
                            }
                        }
                    }
                    SwiftWebAccelerator swiftWebAccelerator6 = SwiftWebAccelerator.this;
                    if ((swiftWebAccelerator6.f314719a & 8) == 0) {
                        return swiftWebAccelerator6.a(bundle);
                    }
                    if (bundle.getBoolean("_should_set_cookie_", false)) {
                        SwiftWebAccelerator swiftWebAccelerator7 = SwiftWebAccelerator.this;
                        if ((swiftWebAccelerator7.f314719a & 16) == 0) {
                            return swiftWebAccelerator7.c(bundle);
                        }
                    }
                    if (!SwiftBrowserStatistics.f314344i1) {
                        SwiftBrowserStatistics.f314344i1 = true;
                        if (WebProcessReceiver.f313724c > 0 && WebProcessReceiver.f313725d > 0) {
                            SwiftBrowserStatistics.f314337b1 = System.currentTimeMillis() - WebProcessReceiver.f313725d;
                            QLog.i("WebLog_SwiftWebAccelerator", 1, "WebProcessReceiver.onReceive cost: " + SwiftBrowserStatistics.Z0 + "ms, complete preload cost: " + SwiftBrowserStatistics.f314337b1 + "ms.");
                        }
                        QLog.i("WebLog_SwiftWebAccelerator", 1, "well done, all preload task execute success!");
                    }
                } catch (Throwable th5) {
                    SwiftWebAccelerator.this.f314722d.a();
                    QLog.e("WebLog_SwiftWebAccelerator", 1, "ACCELERATOR_MODE_MAIN exception", th5.getMessage(), th5);
                    if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                        return -1;
                    }
                    throw new RuntimeException("exception in ACCELERATOR_MODE_MAIN!!!");
                }
            }
            return -1;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49483);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            f314718f = new Object();
        }
    }

    SwiftWebAccelerator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314719a = 0;
        this.f314720b = false;
        this.f314721c = 0;
        this.f314722d = new com.tencent.mobileqq.webview.swift.scheduler.a(new a());
    }

    public static SwiftWebAccelerator h() {
        if (f314717e == null) {
            synchronized (SwiftWebAccelerator.class) {
                if (f314717e == null) {
                    f314717e = new SwiftWebAccelerator();
                }
            }
        }
        return f314717e;
    }

    public int a(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bundle)).intValue();
        }
        this.f314719a |= 8;
        long currentTimeMillis = System.currentTimeMillis();
        if (WebAccelerateHelper.preloadBrowserView == null) {
            WebAccelerateHelper.preInflaterBrowserView();
            SwiftBrowserStatistics.f314341f1 = System.currentTimeMillis() - currentTimeMillis;
            QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateBrowserView, cost = " + SwiftBrowserStatistics.f314341f1 + "ms.");
            return 1;
        }
        return 0;
    }

    public int b(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle)).intValue();
        }
        this.f314719a |= 2;
        long currentTimeMillis = System.currentTimeMillis();
        if (SwiftReuseTouchWebView.I == 0) {
            try {
                SwiftReuseTouchWebView.q(BaseApplication.getContext()).t(true);
            } catch (Throwable th5) {
                this.f314722d.a();
                QLog.e("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateWebView exception", th5.getMessage(), th5);
                return -1;
            }
        }
        SwiftBrowserStatistics.f314339d1 = System.currentTimeMillis() - currentTimeMillis;
        QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_CreateWebView:create webview cost " + SwiftBrowserStatistics.f314339d1 + "ms.");
        return 1;
    }

    public int c(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle)).intValue();
        }
        this.f314719a |= 16;
        long currentTimeMillis = System.currentTimeMillis();
        int i3 = bundle.getInt("from", -1);
        if (QLog.isColorLevel()) {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "doMainStep_SetCookie: preload from " + i3);
        }
        if (i3 == 2) {
            String[] strArr = {"https://qc.vip.qq.com/", "https://m.gamecenter.qq.com"};
            for (int i16 = 0; i16 < 2; i16++) {
                String str = strArr[i16];
                SwiftBrowserCookieMonster s16 = SwiftBrowserCookieMonster.s(str);
                if (s16 != null) {
                    s16.I(str, null, null, null);
                }
            }
        } else {
            SwiftBrowserCookieMonster s17 = SwiftBrowserCookieMonster.s("https://zb.vip.qq.com/");
            if (s17 != null) {
                s17.I("https://zb.vip.qq.com/", null, null, null);
            }
        }
        String str2 = WebAccelerateHelper.getInstance().getWebViewFeatureConfigs().get(WebAccelerateHelper.KEY_PRELOAD_URL);
        if (!TextUtils.isEmpty(str2) && (str2.startsWith("http:") || str2.startsWith("https:"))) {
            if (str2.startsWith("http:")) {
                str2 = str2.replace("http:", "https:");
                if (QLog.isColorLevel()) {
                    QLog.d("WebLog_SwiftWebAccelerator", 2, "SetCookie replace https");
                }
            }
            SwiftBrowserCookieMonster s18 = SwiftBrowserCookieMonster.s(str2);
            if (s18 != null) {
                s18.I(str2, null, null, null);
            }
        }
        QLog.i("WebLog_SwiftWebAccelerator", 1, "doMainStep_SetCookie:pre set cookie(" + str2 + "), cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
        return 1;
    }

    public void d(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) bundle);
        } else {
            this.f314719a |= 2048;
            ThreadManagerV2.postImmediately(new Runnable(System.currentTimeMillis(), bundle) { // from class: com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f314729d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f314730e;

                {
                    this.f314729d = r6;
                    this.f314730e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SwiftWebAccelerator.this, Long.valueOf(r6), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers.run cost " + (System.currentTimeMillis() - this.f314729d) + "ms.");
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VipWebViewReportLog.g()) {
                        VipWebViewReportLog.f(MobileQQ.sMobileQQ.getApplicationContext(), MobileQQ.sMobileQQ.waitAppRuntime(null));
                    }
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load http core data config, cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                    long currentTimeMillis2 = System.currentTimeMillis();
                    i.u();
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load cdn cache config, cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms.");
                    long currentTimeMillis3 = System.currentTimeMillis();
                    ((com.tencent.mobileqq.webview.swift.injector.q) aa.k(com.tencent.mobileqq.webview.swift.injector.q.class)).a(this.f314730e);
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_FireOthers:load Individuation url config, cost " + (System.currentTimeMillis() - currentTimeMillis3) + "ms.");
                }
            }, null, false);
        }
    }

    public void e(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bundle);
            return;
        }
        this.f314719a |= 4096;
        if (WebViewPluginEngine.I == null) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.7
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftWebAccelerator.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    SwiftWebAccelerator.this.j();
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_InitEngine:init plugin engine, cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                }
            }, null, false);
        } else if (QLog.isColorLevel()) {
            QLog.d("WebLog_SwiftWebAccelerator", 2, "preCreateWebViewPluginEngine preload success");
        }
    }

    public void f(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) bundle);
        } else {
            this.f314719a |= 1024;
            ThreadManagerV2.postImmediately(new Runnable(System.currentTimeMillis(), bundle) { // from class: com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ long f314727d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ Bundle f314728e;

                {
                    this.f314727d = r6;
                    this.f314728e = bundle;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SwiftWebAccelerator.this, Long.valueOf(r6), bundle);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs.run cost " + (System.currentTimeMillis() - this.f314727d) + "ms.");
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:init inner-dns cost " + (System.currentTimeMillis() - this.f314727d) + "ms.");
                    long currentTimeMillis = System.currentTimeMillis();
                    AuthorizeConfig z16 = AuthorizeConfig.z(false);
                    z16.F("https://www.qq.com/", "foo.bar");
                    z16.v("skey");
                    z16.v("pskey");
                    z16.v("pt4_token");
                    z16.v(ICustomDataEditor.STRING_ARRAY_PARAM_1);
                    z16.v(ICustomDataEditor.STRING_ARRAY_PARAM_2);
                    z16.D("https://www.qq.com/");
                    z16.b0();
                    z16.a0();
                    z16.e0();
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:load domain white list config, cost " + (System.currentTimeMillis() - currentTimeMillis) + "ms.");
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (WebAccelerateHelper.getInstance().isPreGetKey()) {
                        SwiftTicketCookie.x(MobileQQ.sMobileQQ.waitAppRuntime(null), new Intent());
                    }
                    QLog.i("WebLog_SwiftWebAccelerator", 1, "doThreadedStep_LoadConfigs:pre get key, cost " + (System.currentTimeMillis() - currentTimeMillis2) + "ms.");
                    this.f314728e.putBoolean("_should_set_cookie_", true);
                    SwiftWebAccelerator.this.k(this.f314728e);
                }
            }, null, false);
        }
    }

    public WebViewPluginEngine g() {
        WebViewPluginEngine webViewPluginEngine;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (WebViewPluginEngine) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        synchronized (f314718f) {
            webViewPluginEngine = WebViewPluginEngine.I;
            if (webViewPluginEngine != null) {
                WebViewPluginEngine.I = null;
            } else {
                webViewPluginEngine = null;
            }
        }
        return webViewPluginEngine;
    }

    public int i(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) bundle)).intValue();
        }
        this.f314719a |= 1;
        MobileQQ.sMobileQQ.waitAppRuntime(null);
        long currentTimeMillis = System.currentTimeMillis();
        boolean e16 = m.e();
        QLog.i("WebLog_SwiftWebAccelerator", 1, String.format("initX5Environment alreadyDone=%b inSubThread=%b", Boolean.valueOf(e16), Boolean.TRUE));
        if (e16) {
            return 1;
        }
        ThreadManagerV2.postImmediately(new Runnable(currentTimeMillis, bundle) { // from class: com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ long f314724d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Bundle f314725e;

            {
                this.f314724d = currentTimeMillis;
                this.f314725e = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SwiftWebAccelerator.this, Long.valueOf(currentTimeMillis), bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (SwiftWebAccelerator.this.f314720b) {
                    return;
                }
                if (!m.e()) {
                    z16 = m.g();
                } else {
                    z16 = false;
                }
                SwiftBrowserStatistics.f314338c1 = System.currentTimeMillis() - this.f314724d;
                QLog.i("WebLog_SwiftWebAccelerator", 1, "initX5Environment on sub thread, cost " + SwiftBrowserStatistics.f314338c1 + "ms,doneHere " + z16);
                SwiftWebAccelerator.this.k(this.f314725e);
            }
        }, null, false);
        return -1;
    }

    public void j() {
        AppRuntime peekAppRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            if (WebViewPluginEngine.I != null) {
                return;
            }
            synchronized (f314718f) {
                if (WebViewPluginEngine.I == null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
                    WebViewPluginEngine.I = WebAccelerateHelper.getInstance().createWebViewPluginEngine(peekAppRuntime.getAppRuntime("modular_web"), null, null, null);
                }
            }
        }
    }

    public void k(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
            return;
        }
        if (this.f314720b) {
            QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule say no because is in real world now.");
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (!this.f314720b && !this.f314722d.c()) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                this.f314721c = bundle.getInt("_accelerator_mode_", 0);
                this.f314722d.a();
                this.f314722d.d(bundle);
                QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule restart and new mode is " + this.f314721c + ".");
                return;
            }
            QLog.i("WebLog_SwiftWebAccelerator", 1, "smartSchedule say no because is in real world now.");
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable(bundle) { // from class: com.tencent.mobileqq.webview.swift.utils.SwiftWebAccelerator.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Bundle f314723d;

            {
                this.f314723d = bundle;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SwiftWebAccelerator.this, (Object) bundle);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SwiftWebAccelerator.this.k(this.f314723d);
                }
            }
        });
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else if (!this.f314720b) {
            QLog.i("WebLog_SwiftWebAccelerator", 1, "switch 2 RealWorld and cancel state machine schedule.");
            this.f314720b = true;
            this.f314722d.a();
        }
    }
}

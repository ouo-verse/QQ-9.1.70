package com.tencent.mobileqq.webview.swift.component;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.MSFAccountChangeRegisterTask;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.EmotionConstants;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasBaseWebviewUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.SandBoxControl;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.b;
import com.tencent.mobileqq.webview.swift.injector.c;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.sdk.MultiProcessHelper;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.tuxmeterqui.config.TuxDialogBundleKey;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserStatistics extends b.C8976b {
    static IPatchRedirector $redirector_;
    public static long U0;
    public static boolean V0;
    public static long W0;
    public static long X0;
    public static boolean Y0;
    public static long Z0;

    /* renamed from: a1, reason: collision with root package name */
    public static long f314336a1;

    /* renamed from: b1, reason: collision with root package name */
    public static long f314337b1;

    /* renamed from: c1, reason: collision with root package name */
    public static long f314338c1;

    /* renamed from: d1, reason: collision with root package name */
    public static long f314339d1;

    /* renamed from: e1, reason: collision with root package name */
    public static long f314340e1;

    /* renamed from: f1, reason: collision with root package name */
    public static long f314341f1;

    /* renamed from: g1, reason: collision with root package name */
    public static volatile boolean f314342g1;

    /* renamed from: h1, reason: collision with root package name */
    public static volatile boolean f314343h1;

    /* renamed from: i1, reason: collision with root package name */
    public static volatile boolean f314344i1;

    /* renamed from: j1, reason: collision with root package name */
    public static int f314345j1;

    /* renamed from: k1, reason: collision with root package name */
    public static boolean f314346k1;

    /* renamed from: l1, reason: collision with root package name */
    public static boolean f314347l1;

    /* renamed from: m1, reason: collision with root package name */
    public static boolean f314348m1;

    /* renamed from: n1, reason: collision with root package name */
    public static boolean f314349n1;

    /* renamed from: o1, reason: collision with root package name */
    public static boolean f314350o1;

    /* renamed from: p1, reason: collision with root package name */
    public static HashMap<String, a> f314351p1;
    public String A0;
    public int B0;
    public String C;
    public boolean C0;
    public long D;
    public boolean D0;
    public long E;
    public boolean E0;
    public long F;
    public boolean F0;
    public long G;
    public boolean G0;
    public long H;
    public JSONObject H0;
    public long I;
    public List<String> I0;
    public long J;
    public com.tencent.mobileqq.webview.html.o J0;
    public long K;
    public String K0;
    public long L;
    public String L0;
    public long M;
    public int M0;
    public long N;
    public String N0;
    public boolean O0;
    public long P;
    public boolean P0;
    public long Q;
    public boolean Q0;
    public long R;
    Activity R0;
    public long S;

    @NonNull
    private final com.tencent.mobileqq.webview.swift.injector.o S0;
    public long T;
    public b T0;
    public long U;
    public long V;
    public boolean W;
    public boolean X;
    public long Y;
    public long Z;

    /* renamed from: a0, reason: collision with root package name */
    public long f314352a0;

    /* renamed from: b0, reason: collision with root package name */
    public String f314353b0;

    /* renamed from: c0, reason: collision with root package name */
    public boolean f314354c0;

    /* renamed from: d0, reason: collision with root package name */
    public long f314355d0;

    /* renamed from: e, reason: collision with root package name */
    public long f314356e;

    /* renamed from: e0, reason: collision with root package name */
    private SparseArray<String> f314357e0;

    /* renamed from: f, reason: collision with root package name */
    public long f314358f;

    /* renamed from: f0, reason: collision with root package name */
    private HashMap<String, Long> f314359f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f314360g0;

    /* renamed from: h, reason: collision with root package name */
    public long f314361h;

    /* renamed from: h0, reason: collision with root package name */
    public long f314362h0;

    /* renamed from: i, reason: collision with root package name */
    public long f314363i;

    /* renamed from: i0, reason: collision with root package name */
    public long f314364i0;

    /* renamed from: j0, reason: collision with root package name */
    public long f314365j0;

    /* renamed from: k0, reason: collision with root package name */
    public long f314366k0;

    /* renamed from: l0, reason: collision with root package name */
    public long f314367l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f314368m;

    /* renamed from: m0, reason: collision with root package name */
    public long f314369m0;

    /* renamed from: n0, reason: collision with root package name */
    public long f314370n0;

    /* renamed from: o0, reason: collision with root package name */
    public long f314371o0;

    /* renamed from: p0, reason: collision with root package name */
    public long f314372p0;

    /* renamed from: q0, reason: collision with root package name */
    public long f314373q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f314374r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f314375s0;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f314376t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f314377u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f314378v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f314379w0;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f314380x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f314381y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f314382z0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f314398a;

        /* renamed from: b, reason: collision with root package name */
        String f314399b;

        /* renamed from: c, reason: collision with root package name */
        String f314400c;

        /* renamed from: d, reason: collision with root package name */
        String f314401d;

        /* renamed from: e, reason: collision with root package name */
        boolean f314402e;

        /* renamed from: f, reason: collision with root package name */
        boolean f314403f;

        /* renamed from: g, reason: collision with root package name */
        boolean f314404g;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: f, reason: collision with root package name */
        public static HashMap<String, Integer> f314405f;

        /* renamed from: g, reason: collision with root package name */
        public static int f314406g;

        /* renamed from: h, reason: collision with root package name */
        public static List<String> f314407h;

        /* renamed from: a, reason: collision with root package name */
        public int f314408a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f314409b;

        /* renamed from: c, reason: collision with root package name */
        public int f314410c;

        /* renamed from: d, reason: collision with root package name */
        public int f314411d;

        /* renamed from: e, reason: collision with root package name */
        public long f314412e;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49236);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f314405f = new HashMap<>(10);
                f314406g = -1;
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f314408a = 1;
            this.f314409b = false;
            this.f314411d = 6;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49249);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
            return;
        }
        U0 = 0L;
        V0 = false;
        W0 = 0L;
        X0 = 0L;
        Y0 = false;
        Z0 = 0L;
        f314336a1 = 0L;
        f314337b1 = 0L;
        f314338c1 = 0L;
        f314339d1 = 0L;
        f314340e1 = 0L;
        f314341f1 = 0L;
        f314342g1 = false;
        f314343h1 = false;
        f314344i1 = false;
        f314345j1 = 10;
        f314346k1 = s.b(1, false);
        f314347l1 = s.b(2, false);
        f314348m1 = s.b(5, false);
        f314349n1 = s.b(4, false);
        f314350o1 = s.b(3, false);
        f314351p1 = new HashMap<>();
    }

    public SwiftBrowserStatistics() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f314356e = 0L;
        this.f314368m = false;
        this.C = "";
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.M = 0L;
        this.N = 0L;
        this.P = 0L;
        this.Q = 0L;
        this.R = -1L;
        this.S = 0L;
        this.T = 0L;
        this.U = -1L;
        this.V = 0L;
        this.W = true;
        this.X = true;
        this.Y = 0L;
        this.Z = 0L;
        this.f314352a0 = 0L;
        this.f314354c0 = false;
        this.f314355d0 = 0L;
        this.f314357e0 = new SparseArray<>(8);
        this.f314359f0 = new HashMap<>(7);
        this.f314360g0 = "state_activity_init";
        this.f314362h0 = 0L;
        this.f314364i0 = 0L;
        this.f314365j0 = 0L;
        this.f314366k0 = 0L;
        this.f314367l0 = 0L;
        this.f314369m0 = 0L;
        this.f314370n0 = 0L;
        this.f314371o0 = 0L;
        this.f314372p0 = 0L;
        this.f314373q0 = 0L;
        this.f314374r0 = -1;
        this.f314375s0 = false;
        this.f314376t0 = false;
        this.f314377u0 = true;
        this.f314378v0 = 0;
        this.f314379w0 = false;
        this.f314380x0 = true;
        this.f314381y0 = true;
        this.B0 = 0;
        this.C0 = false;
        this.D0 = false;
        this.E0 = false;
        this.F0 = false;
        this.G0 = false;
        this.H0 = null;
        this.I0 = new ArrayList();
        this.J0 = null;
        this.M0 = 0;
        this.N0 = "";
        this.O0 = false;
        this.P0 = false;
        this.Q0 = false;
        this.S0 = (com.tencent.mobileqq.webview.swift.injector.o) com.tencent.mobileqq.webview.swift.injector.aa.d(com.tencent.mobileqq.webview.swift.injector.o.class);
        this.T0 = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(int i3, int i16) {
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("proc", MobileQQ.getProcessSuffix(MobileQQ.sMobileQQ.getQQProcessName(), "com.tencent.mobileqq"));
            hashMap.put("type", "" + i3);
            hashMap.put("coreVer", "" + i16);
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_force_sys_core", true, 0L, 0L, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserStatistics", 2, String.format("reportForceSysCore mapParams=%s", hashMap));
            }
        } catch (Exception e16) {
            QLog.w("SwiftBrowserStatistics", 1, "reportForceSysCore " + e16.getMessage(), e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(String str, String str2) {
        Uri parse;
        String host;
        if (str == null) {
            parse = null;
        } else {
            parse = Uri.parse(str);
        }
        if (parse == null) {
            host = "";
        } else {
            host = parse.getHost();
        }
        String j06 = j0(u(str), 80);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("cmd_name", str2);
        hashMap.put("host", host);
        hashMap.put("url", j06);
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_jsapi_auth", true, 0L, 0L, hashMap, "");
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            QLog.i("SwiftBrowserStatistics", 2, String.format("reportJsapiAuth cmdName=%s host=%s url=%s", str2, host, j06));
        }
    }

    private void J(Context context, String str, Intent intent, long j3, String str2) {
        ThreadManagerV2.post(new Runnable(str, intent, context, j3, str2) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f314387d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Intent f314388e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Context f314389f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ long f314390h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ String f314391i;

            {
                this.f314387d = str;
                this.f314388e = intent;
                this.f314389f = context;
                this.f314390h = j3;
                this.f314391i = str2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, SwiftBrowserStatistics.this, str, intent, context, Long.valueOf(j3), str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    Uri parse = Uri.parse(this.f314387d);
                    boolean z16 = false;
                    if (parse != null) {
                        String host = parse.getHost();
                        if ((TextUtils.isEmpty(host) || !host.endsWith(QQWinkConstants.VALID_HOST)) && SwiftBrowserStatistics.this.T0.f314408a < 11) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QQBrowser_report", 2, "mUrl is null or url is not from qq.com!");
                                return;
                            }
                            return;
                        }
                        String queryParameter = parse.getQueryParameter("hasRedDot");
                        if (!TextUtils.isEmpty(queryParameter)) {
                            SwiftBrowserStatistics.this.T0.f314409b = queryParameter.equalsIgnoreCase("1");
                        }
                        SwiftBrowserStatistics swiftBrowserStatistics = SwiftBrowserStatistics.this;
                        b bVar = swiftBrowserStatistics.T0;
                        if (!bVar.f314409b) {
                            bVar.f314409b = swiftBrowserStatistics.S0.i(this.f314388e, false);
                        }
                        String queryParameter2 = parse.getQueryParameter("crashFrom");
                        if (!TextUtils.isEmpty(queryParameter2)) {
                            SwiftBrowserStatistics.this.T0.f314410c = Integer.parseInt(queryParameter2);
                        }
                    }
                    int indexOf = this.f314387d.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
                    if (indexOf != -1) {
                        str3 = this.f314387d.substring(0, indexOf);
                    } else {
                        str3 = this.f314387d;
                    }
                    int i3 = 10;
                    if (b.f314405f.isEmpty()) {
                        SwiftBrowserStatistics swiftBrowserStatistics2 = SwiftBrowserStatistics.this;
                        swiftBrowserStatistics2.I(this.f314389f, swiftBrowserStatistics2.T0);
                        if (b.f314405f.isEmpty() || !b.f314405f.containsKey(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE)) {
                            b.f314405f.put(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE, 10);
                        }
                    }
                    if (b.f314405f.containsKey(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE)) {
                        i3 = b.f314405f.get(IjkMediaMeta.IJKM_KEY_SAMPLE_RATE).intValue();
                    }
                    if (b.f314405f.containsKey(str3)) {
                        i3 = b.f314405f.get(str3).intValue();
                    }
                    AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                    if (waitAppRuntime != null && waitAppRuntime.getLongAccountUin() != 0 && waitAppRuntime.getLongAccountUin() % i3 == SwiftBrowserStatistics.this.T0.f314411d) {
                        z16 = true;
                    }
                    if (i3 == 1) {
                        z16 = true;
                    }
                    if (z16) {
                        if (SwiftBrowserStatistics.this.T0.f314410c != -1) {
                            str3 = str3 + "?type=" + SwiftBrowserStatistics.this.T0.f314410c;
                        }
                        String str4 = str3;
                        if (QLog.isColorLevel()) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("try report web status, onBackEvent,  step: ");
                            sb5.append(SwiftBrowserStatistics.this.T0.f314408a);
                            sb5.append(", hasRedDot : ");
                            sb5.append(SwiftBrowserStatistics.this.T0.f314409b);
                            sb5.append(", crashFrom : ");
                            sb5.append(SwiftBrowserStatistics.this.T0.f314410c);
                            sb5.append(", stepTime: ");
                            SwiftBrowserStatistics swiftBrowserStatistics3 = SwiftBrowserStatistics.this;
                            sb5.append(swiftBrowserStatistics3.T0.f314412e - swiftBrowserStatistics3.f314358f);
                            sb5.append(", totalTime: ");
                            sb5.append(this.f314390h - SwiftBrowserStatistics.this.f314358f);
                            sb5.append("\n");
                            sb5.append(str4);
                            QLog.d("QQBrowser_report", 2, sb5.toString());
                        }
                        SwiftBrowserStatistics.this.X(str4, this.f314390h, waitAppRuntime, this.f314391i, "WebStatusReport");
                        SwiftBrowserStatistics.this.T0.f314410c = -1;
                        b.f314406g = -1;
                    }
                    SwiftBrowserStatistics.this.S0.e(SwiftBrowserStatistics.this.f314441d.getWebViewProvider(), this.f314387d, this.f314390h, waitAppRuntime, this.f314391i);
                } catch (Throwable th5) {
                    QLog.e("QQBrowser_report", 1, "report step error!", th5);
                }
            }
        }, 5, null, false);
    }

    public static void L() {
        String str;
        try {
            HashMap<String, a> hashMap = f314351p1;
            f314351p1 = new HashMap<>();
            Collection<a> values = hashMap.values();
            if (values != null) {
                for (a aVar : values) {
                    HashMap<String, String> hashMap2 = new HashMap<>();
                    hashMap2.put("originUrl", aVar.f314398a);
                    hashMap2.put("curUrl", aVar.f314399b);
                    if (!TextUtils.isEmpty(aVar.f314400c)) {
                        hashMap2.put("recognisedText", aVar.f314400c);
                    }
                    String str2 = "1";
                    if (aVar.f314402e) {
                        str = "1";
                    } else {
                        str = "0";
                    }
                    hashMap2.put("passwdTyped", str);
                    if (!aVar.f314403f) {
                        str2 = "0";
                    }
                    hashMap2.put("showPasswd", str2);
                    ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "wvAntiPasswd", true, 0L, 0L, hashMap2, "");
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 2, "nothing to report");
            }
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserStatistics", 2, th5, new Object[0]);
        }
    }

    public static void O(final int i3, final int i16) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.o
            @Override // java.lang.Runnable
            public final void run() {
                SwiftBrowserStatistics.B(i3, i16);
            }
        }, 16, null, true);
    }

    public static void P(final String str, final String str2) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.n
            @Override // java.lang.Runnable
            public final void run() {
                SwiftBrowserStatistics.C(str2, str);
            }
        }, 16, null, false);
    }

    public static void T(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            String j06 = j0(str2, 80);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("cmd", str);
            hashMap.put("url", j06);
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_risk_method_call", true, 0L, 0L, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserStatistics", 2, String.format("reportRiskMethodCall cmd=%s url=%s", str, j06));
            }
        }
    }

    public static void U(String str, SslError sslError, HashMap<String, String> hashMap) {
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() || f314346k1) {
            String url = sslError.getUrl();
            String j06 = j0(str, 80);
            String j07 = j0(url, 120);
            hashMap.put(VasWebviewConstants.KEY_PAGE_URL, j06);
            hashMap.put("errUrl", j07);
            hashMap.put("errCode", "" + sslError.getPrimaryError());
            hashMap.put("cert", sslError.getCertificate().toString());
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_ssl_error", true, 0L, 0L, hashMap, "");
        }
    }

    public static void V(String str, String str2, boolean z16, int i3) {
        String str3;
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("originUrl", str);
            hashMap.put("curUrl", str2);
            hashMap.put("keyType", i3 + "");
            String str4 = "0";
            if (!z16) {
                str3 = "0";
            } else {
                str3 = "1";
            }
            hashMap.put("isCached", str3);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str4 = peekAppRuntime.getAccount();
            }
            hashMap.put("qqnum", str4);
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "setCookieAsync", true, 0L, 0L, hashMap, "");
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserStatistics", 2, th5, new Object[0]);
        }
    }

    public static void b0(int i3, String str, String str2) {
        Uri parse;
        String host;
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() || f314347l1) {
            if (str2 == null) {
                parse = null;
            } else {
                parse = Uri.parse(str2);
            }
            if (parse == null) {
                host = "";
            } else {
                host = parse.getHost();
            }
            String j06 = j0(str2, 80);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("call_state", String.valueOf(i3));
            hashMap.put("cmd_name", str);
            hashMap.put("host", host);
            hashMap.put("path", j06);
            hashMap.put("pid", MobileQQ.sProcessId + "");
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_jsapi_call", true, 0L, 0L, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserStatistics", 2, String.format("reportWebViewJsapiCall state=%d cmdName=%s url=%s", Integer.valueOf(i3), str, str2));
            }
        }
    }

    public static void c0(int i3, String str, String str2) {
        Uri parse;
        String host;
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() || f314350o1) {
            if (str2 == null) {
                parse = null;
            } else {
                parse = Uri.parse(str2);
            }
            if (parse == null) {
                host = "";
            } else {
                host = parse.getHost();
            }
            String j06 = j0(str2, 80);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("call_state", String.valueOf(i3));
            hashMap.put("cmd_name", str);
            hashMap.put("host", host);
            hashMap.put("url", j06);
            hashMap.put("pid", MobileQQ.sProcessId + "");
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_openapi_call", true, 0L, 0L, hashMap, "");
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserStatistics", 2, String.format("reportWebViewOpenapiCall state=%d cmdName=%s url=%s", Integer.valueOf(i3), str, str2));
            }
        }
    }

    public static void d0() {
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() && !f314346k1) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String processSuffix = MobileQQ.getProcessSuffix(MobileQQ.sMobileQQ.getQQProcessName(), "com.tencent.mobileqq");
        hashMap.put("proc", processSuffix);
        hashMap.put("pid", MobileQQ.sProcessId + "");
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_use_process", true, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserStatistics", 2, "reportWebViewProcess: " + processSuffix);
        }
    }

    public static void e0(String str, String str2, int i3) {
        Uri parse;
        String host;
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(str);
        if (!"http".equals(k3) && !"https".equals(k3)) {
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() || f314349n1) {
                String l3 = com.tencent.mobileqq.webview.swift.utils.i.l(str);
                if (str2 == null) {
                    parse = null;
                } else {
                    parse = Uri.parse(str2);
                }
                if (parse == null) {
                    host = "";
                } else {
                    host = parse.getHost();
                }
                String j06 = j0(str2, 80);
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("call_state", String.valueOf(i3));
                hashMap.put("cmd_name", l3);
                hashMap.put(ZPlanPublishSource.FROM_SCHEME, k3);
                hashMap.put("host", host);
                hashMap.put("url", j06);
                hashMap.put("pid", MobileQQ.sProcessId + "");
                ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_scheme_request", true, 0L, 0L, hashMap, "");
                if (QLog.isColorLevel()) {
                    QLog.i("SwiftBrowserStatistics", 2, String.format("reportWebViewSchemeRequest state=%d scheme=%s cmdName=%s url=%s", Integer.valueOf(i3), k3, l3, host));
                }
            }
        }
    }

    public static void f0(int i3, String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("update_state", String.valueOf(i3));
        hashMap.put("last_ver", str);
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webview_whitelist_update", true, 0L, 0L, hashMap, "");
        if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserStatistics", 2, String.format("reportWebViewWhiteListUpdate state=%d lastVer=%s", Integer.valueOf(i3), str));
        }
    }

    public static boolean i0(String str) {
        String k3 = com.tencent.mobileqq.webview.swift.utils.i.k(str);
        if (!"null".equals(str) && str.length() <= 1024 && ("http".equals(k3) || "https".equals(k3))) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 2, "not report url:", str);
        }
        return false;
    }

    public static String j0(String str, int i3) {
        if (!TextUtils.isEmpty(str) && i3 > 0 && str.length() > i3) {
            return str.substring(0, i3);
        }
        return str;
    }

    public static synchronized void k0(String str, String str2, String str3, String str4, boolean z16, boolean z17, boolean z18) {
        synchronized (SwiftBrowserStatistics.class) {
            if (TextUtils.isEmpty(str2) && QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 2, "curUrl is null");
                return;
            }
            if (!f314351p1.containsKey(str2)) {
                f314351p1.put(str2, new a());
            }
            a aVar = f314351p1.get(str2);
            aVar.f314399b = str2;
            if (!TextUtils.isEmpty(str)) {
                aVar.f314398a = str;
            }
            if (!TextUtils.isEmpty(str3)) {
                aVar.f314400c = str3;
            }
            if (!TextUtils.isEmpty(str4)) {
                aVar.f314401d = str4;
            }
            if (z16) {
                aVar.f314402e = z16;
            }
            if (z17) {
                aVar.f314403f = z17;
            }
            aVar.f314404g = z18;
            f314351p1.put(str2, aVar);
        }
    }

    public static synchronized Bundle r(String str) {
        int i3;
        int i16;
        int i17;
        synchronized (SwiftBrowserStatistics.class) {
            Bundle bundle = new Bundle();
            try {
            } catch (Throwable th5) {
                QLog.e("SwiftBrowserStatistics", 1, th5, new Object[0]);
            }
            if (TextUtils.isEmpty(str)) {
                return bundle;
            }
            if (f314351p1.containsKey(str)) {
                a aVar = f314351p1.get(str);
                String str2 = aVar.f314400c;
                if (str2 != null) {
                    String[] split = str2.split(",");
                    ArrayList<String> arrayList = new ArrayList<>(split.length);
                    for (String str3 : split) {
                        arrayList.add(str3);
                    }
                    bundle.putStringArrayList("text_features", arrayList);
                }
                if (TextUtils.isEmpty(aVar.f314401d)) {
                    bundle.putString("inputText", aVar.f314401d);
                }
                if (aVar.f314403f) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                bundle.putInt("passwdShow", i3);
                if (aVar.f314402e) {
                    i16 = 1;
                } else {
                    i16 = 0;
                }
                bundle.putInt("passwdInput", i16);
                if (aVar.f314404g) {
                    i17 = 1;
                } else {
                    i17 = 0;
                }
                bundle.putInt("hasVirtualKB", i17);
            }
            return bundle;
        }
    }

    public static String s(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("\\.");
        if (split.length <= 0) {
            return "";
        }
        return split[split.length - 1];
    }

    public static String u(String str) {
        if (str == null) {
            return "null";
        }
        int indexOf = str.indexOf(63);
        int indexOf2 = str.indexOf(35);
        if (indexOf == -1) {
            if (indexOf2 == -1) {
                indexOf = str.length();
            } else {
                indexOf = indexOf2;
            }
        } else if (indexOf2 != -1) {
            indexOf = Math.min(indexOf, indexOf2);
        }
        if (indexOf == 0) {
            return "null";
        }
        return str.substring(0, indexOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(Uri uri) {
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "Grp_open", "", "time", "wide_time", 0, 1, 0, "", uri.getQueryParameter("appid"), ((int) ((System.nanoTime() - this.H) / 1000000)) + "", uri.getQueryParameter("group_openid"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(String str, String str2, String str3) {
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFD", "0X8004FFD", 0, 1, 0, com.tencent.mobileqq.webview.util.g.a() + "", str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(String str) {
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004FFE", "0X8004FFE", 0, 1, 0, com.tencent.mobileqq.webview.util.g.a() + "", String.valueOf((System.nanoTime() - this.I) / 1000000), String.valueOf(((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess() ? 1 : 0), String.valueOf(this.G0 ? 1 : 0) + ", " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(int i3) {
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).a(null, "P_CliOper", "Vip_SummaryCard", "", "0X8004F62", "0X8004F62", 0, 1, 0, com.tencent.mobileqq.webview.util.g.a() + "", "" + i3, String.valueOf(((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess() ? 1 : 0), String.valueOf(this.G0 ? 1 : 0));
    }

    public void D(Intent intent, String str) {
        boolean z16;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) str);
            return;
        }
        this.H = System.nanoTime();
        long longExtra = intent.getLongExtra("qqBrowserActivityCreateTime", -1L);
        this.f314361h = longExtra;
        if (longExtra <= 0) {
            this.f314361h = System.currentTimeMillis();
        }
        this.Z = SystemClock.elapsedRealtime();
        QLog.e("SwiftBrowserStatistics", 1, "onCreate mOnCreateMilliTimeStamp = " + this.f314361h);
        b bVar = this.T0;
        bVar.f314408a = 1;
        bVar.f314412e = this.f314361h;
        this.f314358f = intent.getLongExtra("startOpenPageTime", -1L);
        QLog.e("SwiftBrowserStatistics", 1, "onCreate mClickTime = " + this.f314358f);
        intent.getBooleanExtra("fromPublicAccount", false);
        if (this.f314358f == -1) {
            this.f314358f = this.f314361h;
        }
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("AutoMonitor", 1, "Web_qqbrowser_from_click_to_onCreate, cost=" + (this.f314361h - this.f314358f));
        }
        this.J = this.S0.c(intent, 0L);
        this.K = this.S0.j(intent, 0L);
        this.D0 = intent.getBooleanExtra("FORCE_BLANK_SCREEN_REPORTE", false);
        this.f314375s0 = this.S0.d(intent, false);
        boolean i3 = this.S0.i(intent, false);
        this.f314376t0 = i3;
        this.T0.f314409b = i3;
        this.S0.g(intent, str);
        if (QLog.isColorLevel()) {
            QLog.i("GOTOWEB", 2, "onQQBrowserCreate() time = " + this.H);
        }
        if (WebAccelerateHelper.isWebViewEntered) {
            this.G0 = true;
            QLog.d("SwiftBrowserStatistics", 1, "onCreate, isWebViewCache = true");
        }
        this.f314362h0 = System.currentTimeMillis();
        this.B0 = ((f314343h1 ? 1 : 0) << 2) + ((this.f314375s0 ? 1 : 0) << 1) + (this.f314376t0 ? 1 : 0);
        this.K0 = u(str);
        this.L0 = com.tencent.mobileqq.webview.util.g.b();
        if (f314346k1) {
            long j16 = this.K;
            if (j16 > 0) {
                j3 = this.f314361h - j16;
            } else {
                j3 = 0;
            }
            K("process_init", j3, "0");
        }
        this.Y = intent.getLongExtra("StartClickTime", 0L);
        intent.removeExtra("StartClickTime");
        Activity activity = this.R0;
        if (activity != null && activity.getIntent() != null) {
            this.R0.getIntent().removeExtra("StartClickTime");
        }
        this.f314353b0 = intent.getStringExtra("SourceActivityName");
        if (this.Y <= 0) {
            this.W = false;
            this.Y = this.Z;
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 4, "reportTime mClickUrlMilliTime=" + this.Y);
            }
            N(str, "ClickTime", this.Y + "");
        }
        com.tencent.mobileqq.webview.swift.v.g(com.tencent.mobileqq.webview.swift.v.f314806b, this.Y);
        if (this.Z - this.Y > 10000) {
            N(str, "CreateActivity", (this.Z - this.Y) + "");
        }
        if (U0 > this.Y) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f314354c0 = z16;
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 2, "mClickUrlMilliTime: ", Long.valueOf(this.Y), " mSourceActivityClassName:", this.f314353b0, " mProcessLaunchMilliTime:", Long.valueOf(U0), " mIsColdLaunch:", Boolean.valueOf(this.f314354c0));
        }
        f314351p1.clear();
    }

    public void E(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, i3);
        } else {
            if (i3 == 0 || !this.f314379w0 || TextUtils.isEmpty(str)) {
                return;
            }
            ThreadManagerV2.post(new Runnable(str, i3, str, i3) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f314383d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f314384e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f314385f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f314386h;

                {
                    this.f314383d = str;
                    this.f314384e = i3;
                    this.f314385f = str;
                    this.f314386h = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SwiftBrowserStatistics.this, str, Integer.valueOf(i3), str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    String str3 = "";
                    try {
                        Uri parse = Uri.parse(this.f314383d);
                        if (parse != null) {
                            String host = parse.getHost();
                            if (TextUtils.isEmpty(host)) {
                                return;
                            }
                            if (!SwiftBrowserStatistics.this.D0 && !AuthorizeConfig.y().O("white_list_authorize_config", host)) {
                                return;
                            } else {
                                str3 = URLEncoder.encode(this.f314383d);
                            }
                        }
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    if (SwiftBrowserStatistics.this.T0.f314408a == 13) {
                        str2 = "1";
                    } else {
                        str2 = "0";
                    }
                    sb5.append(str2);
                    sb5.append("|");
                    sb5.append(String.valueOf(-this.f314384e));
                    sb5.append("|");
                    sb5.append(str3);
                    sb5.append("|");
                    sb5.append(str3);
                    sb5.append("|");
                    sb5.append(this.f314384e);
                    ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).d(null, "dc00757", sb5.toString(), true);
                    SwiftBrowserStatistics.this.S0.onDetectedBlankScreen(this.f314385f, this.f314386h);
                }
            }, 5, null, false);
        }
    }

    public void F(TouchWebView touchWebView, String str) {
        String str2;
        char c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) touchWebView, (Object) str);
            return;
        }
        if (touchWebView == null) {
            return;
        }
        final String t16 = t(touchWebView);
        int i3 = 1;
        try {
            if (this.A0.startsWith("http://") || str.startsWith("http://")) {
                HashMap<String, String> hashMap = new HashMap<>(2);
                hashMap.put("url", str);
                hashMap.put("first_url", this.A0);
                Activity activity = this.R0;
                if (activity != null && activity.getIntent() != null) {
                    Intent intent = this.R0.getIntent();
                    int intExtra = intent.getIntExtra("articalChannelId", 100);
                    boolean booleanExtra = intent.getBooleanExtra("fromAio", false);
                    String stringExtra = intent.getStringExtra("SourceActivityName");
                    hashMap.put("fromChannel", String.valueOf(intExtra));
                    hashMap.put(EmotionConstants.FROM_AIO, String.valueOf(booleanExtra));
                    hashMap.put("fromAct", stringExtra);
                }
                ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "actWVHttpReport", true, 0L, 0L, hashMap, "");
            }
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserStatistics", 1, th5, new Object[0]);
        }
        if (this.f314379w0 && this.f314381y0 && !this.f314382z0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.r
                @Override // java.lang.Runnable
                public final void run() {
                    SwiftBrowserStatistics.this.y(t16);
                }
            }, 16, null, false);
            if (QLog.isDevelopLevel()) {
                QLog.d("web_report", 4, "web_load_url, cost = " + ((System.nanoTime() - this.I) / 1000000) + ", url = " + com.tencent.mobileqq.webview.util.s.d(this.A0, new String[0]) + ", isFromLeba = " + this.f314375s0 + ", hasRedDot = " + this.f314376t0 + ", " + t16);
            }
        }
        if (this.f314381y0 && !this.f314382z0) {
            if (touchWebView.getHtmlSessionClient() != null) {
                this.J0 = touchWebView.getHtmlSessionClient().e();
            }
            Y(str);
            if (touchWebView.getX5WebViewExtension() != null) {
                i3 = 3;
            }
            for (String str3 : this.I0) {
                if (str3 != null) {
                    str2 = str3;
                } else {
                    str2 = "unknown";
                }
                VasBaseWebviewUtil.reportQBWebInfo(t16, "qbweb_load_redirect", "", str2.replace("|", "%7C"), i3, 0, "0", String.valueOf(this.B0), com.tencent.mobileqq.webview.util.g.b(), 0, 0, "", MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
                if (QLog.isColorLevel()) {
                    c16 = 2;
                    QLog.d("SwiftBrowserStatistics", 2, "url=" + str3 + ", rlt=" + MSFAccountChangeRegisterTask.MSF_DEFAULT_UIN);
                } else {
                    c16 = 2;
                }
            }
            this.I0.clear();
        }
        this.S0.l(touchWebView, str, this.f314380x0, this.B0, this.I);
    }

    public void G(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            return;
        }
        if ("about:blank".equalsIgnoreCase(str) || !this.f314380x0) {
            return;
        }
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.i("QQBrowser", 1, "Web_qqbrowser_loadurl_pagestart, cost=" + (System.currentTimeMillis() - this.R));
        }
        this.I = System.nanoTime();
        b bVar = this.T0;
        bVar.f314408a = 2;
        bVar.f314412e = System.currentTimeMillis();
        this.f314370n0 = this.T0.f314412e - this.f314358f;
        if (QLog.isColorLevel()) {
            QLog.d("QQBrowser_report", 2, "try report web status, onPageStarted,  step: " + this.T0.f314408a + ", asyncMode: " + this.f314378v0 + ", stepTime: " + this.f314370n0 + ", totalTime: " + (System.currentTimeMillis() - this.f314358f) + "\n" + str);
        }
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            QLog.d("QQBrowser_report", 1, "Web_qqbrowser_report_onPageStarted, cost=" + this.f314370n0);
        }
        if (this.f314379w0 && !this.f314382z0) {
            final int i3 = (int) ((this.I - this.H) / 1000000);
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.p
                @Override // java.lang.Runnable
                public final void run() {
                    SwiftBrowserStatistics.this.z(i3);
                }
            }, 16, null, false);
            if (QLog.isDevelopLevel()) {
                QLog.d("web_report", 4, "web_before_load_url, cost = " + i3 + ", url = " + com.tencent.mobileqq.webview.util.s.d(this.A0, new String[0]) + ", isFromLeba = " + this.f314375s0 + ", hasRedDot = " + this.f314376t0);
            }
        }
        if (!this.f314382z0) {
            this.I0.add(str);
        }
        this.G = System.currentTimeMillis();
        this.S0.f(str, this.I);
    }

    public void H(TouchWebView touchWebView, int i3, String str, String str2) {
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, touchWebView, Integer.valueOf(i3), str, str2);
            return;
        }
        String t16 = t(touchWebView);
        if (touchWebView.getX5WebViewExtension() == null) {
            i16 = 1;
        }
        for (int i17 = 0; i17 < this.I0.size(); i17++) {
            String str5 = this.I0.get(i17);
            if (i17 == this.I0.size() - 1) {
                str3 = String.valueOf(i3);
            } else {
                str3 = HippyQQConstants.HIPPY_CHANNEL;
            }
            if (str5 != null) {
                str4 = str5;
            } else {
                str4 = "unknown";
            }
            VasBaseWebviewUtil.reportQBWebInfo(t16, "qbweb_load_redirect", "", str4.replace("|", "%7C"), i16, 0, "0", String.valueOf(this.B0), com.tencent.mobileqq.webview.util.g.b(), 0, 0, "", str3);
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 2, "url=" + str5 + ", rlt=" + str3);
            }
        }
        this.I0.clear();
        this.S0.h(touchWebView, i3, str, str2);
    }

    void I(Context context, b bVar) {
        c.a t16 = ((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).t();
        if (t16 != null) {
            b.f314405f.putAll(t16.f314604a);
            bVar.f314411d = t16.f314605b;
        }
        if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserStatistics", 2, String.format("parseCrashStatConfig config=%s", t16));
        }
    }

    public void K(final String str, final long j3, final String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, str, Long.valueOf(j3), str2);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.l
                @Override // java.lang.Runnable
                public final void run() {
                    SwiftBrowserStatistics.this.A(str, j3, str2);
                }
            }, 16, null, false);
        }
    }

    public void M(Intent intent, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) intent, (Object) str);
            return;
        }
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() && !f314346k1) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String u16 = u(str);
        if (!i0(u16)) {
            return;
        }
        hashMap.put("url", u16);
        hashMap.put("source_activity", intent.getStringExtra("SourceActivityName"));
        boolean z17 = true;
        if (U0 > this.Y) {
            z16 = true;
        } else {
            z16 = false;
        }
        for (String str2 : this.f314359f0.keySet()) {
            hashMap.put(str2, (this.f314359f0.get(str2).longValue() - this.Y) + "");
        }
        hashMap.put("bounce_rate_state", this.f314360g0);
        hashMap.put("is_cold_launch", "" + z16);
        hashMap.put("network_type", com.tencent.mobileqq.webview.util.g.b());
        hashMap.put("system_os", DeviceInfoMonitor.getModel() + Build.VERSION.SDK_INT);
        hashMap.put("QQ_version", ((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).e());
        hashMap.put("use_offline_package", V0 + "");
        hashMap.put("use_sonic", "false");
        hashMap.put("use_pre_load", "" + f314343h1);
        StringBuilder sb5 = new StringBuilder();
        if (X0 > this.Y) {
            z17 = false;
        }
        sb5.append(z17);
        sb5.append("");
        hashMap.put("is_x5_init", sb5.toString());
        hashMap.put("core_type", this.M0 + "");
        hashMap.put("activity_create_final", String.valueOf(this.f314352a0 - this.Z));
        hashMap.put("origin_url", this.K0);
        if (this.I0.size() > 0) {
            hashMap.put("redirect_time", "" + this.I0.size());
            hashMap.put("first_url", this.I0.get(0));
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 4, "reportBounceRate: " + hashMap);
        }
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webviewBounceRateCollection", true, 0L, 0L, hashMap, "");
    }

    public void N(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, str2, str3);
            return;
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            String u16 = u(str);
            if (!i0(u16)) {
                return;
            }
            hashMap.put("url", u16);
            hashMap.put(str2, str3);
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserStatistics", 4, "reportErrorScene: " + hashMap);
            }
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "actWvReportError", true, 0L, 0L, hashMap, "");
        } catch (Throwable th5) {
            QLog.e("SwiftBrowserStatistics", 2, th5, new Object[0]);
        }
    }

    @VisibleForTesting
    void R(String str, String str2, String str3, Context context) {
        if (str2 != null && str2.contains("https://kandian.qq.com/kdv/h5/diversion/index")) {
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserStatistics", 2, "kandian web page is in progress, event is :" + str + ", url is:" + str2);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(TuxDialogBundleKey.WEB_URL, str2);
            hashMap.put("time", System.currentTimeMillis() + "");
            ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance(str3, str, true, 0L, 0L, hashMap, "", true);
        }
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void A(String str, long j3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        int i16 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, str, Long.valueOf(j3), str2);
            return;
        }
        this.S0.k(str, j3, str2, this.A0);
        com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
        String str3 = this.K0;
        boolean z16 = this.O0;
        if (!this.P0) {
            i3 = 0;
        }
        int i17 = (z16 ? 1 : 0) | i3;
        if (!this.Q0) {
            i16 = 0;
        }
        mVar.b(null, "dc00899", "WV_Analysis", "", str, str3, i17 | i16, (int) j3, String.valueOf(this.M0), this.N0, this.L0, str2);
    }

    public void W(Context context, String str, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, context, str, intent);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String str2 = "UNKNOWN";
        try {
            int systemNetwork = NetworkUtil.getSystemNetwork(context);
            if (systemNetwork != -1) {
                String[] strArr = AppConstants.NET_TYPE_NAME;
                if (systemNetwork < strArr.length) {
                    str2 = strArr[systemNetwork];
                }
            }
        } catch (Exception unused) {
        }
        J(context, str, intent, System.currentTimeMillis(), str2);
    }

    public void X(String str, long j3, AppRuntime appRuntime, String str2, String str3) {
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, str, Long.valueOf(j3), appRuntime, str2, str3);
            return;
        }
        if (this.T0.f314409b) {
            str4 = this.S0.a(appRuntime);
        } else {
            str4 = "";
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("mission", str4);
            jSONObject.put("redtouch", jSONObject2);
        } catch (JSONException unused) {
        }
        com.tencent.mobileqq.webview.swift.injector.m mVar = (com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class);
        String jSONObject3 = jSONObject.toString();
        b bVar = this.T0;
        mVar.a(null, "P_CliOper", str3, "", jSONObject3, str2, bVar.f314409b ? 1 : 0, 1, bVar.f314408a, str, Build.VERSION.RELEASE, String.valueOf(bVar.f314412e - this.f314358f), String.valueOf(j3 - this.f314358f));
    }

    public void Y(String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && !f314346k1) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String u16 = u(str);
        if (!i0(u16)) {
            return;
        }
        hashMap.put("url", j0(u16, 50));
        if (!TextUtils.isEmpty(this.f314353b0)) {
            hashMap.put("source_activity", s(this.f314353b0));
        }
        String str6 = "1";
        if (this.X) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("kernel_async", str2);
        if (this.W) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("has_click_time", str3);
        if (this.f314354c0) {
            str4 = "1";
        } else {
            str4 = "0";
        }
        hashMap.put("is_cold_launch", str4);
        hashMap.put("network_type", this.L0);
        hashMap.put("use_offline_package", V0 + "");
        hashMap.put("use_sonic", "false");
        hashMap.put("use_pre_load", "" + f314343h1);
        StringBuilder sb5 = new StringBuilder();
        if (X0 <= this.Y) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        sb5.append(str5);
        sb5.append("");
        hashMap.put("is_x5_init", sb5.toString());
        if (!Y0) {
            str6 = "0";
        }
        hashMap.put("x5PreloadSwitchOn", str6);
        hashMap.put("int_tbs_env", String.valueOf(W0));
        hashMap.put("webview_create_time", String.valueOf(this.f314355d0));
        hashMap.put("core_type", String.valueOf(this.M0));
        hashMap.put("core_ver", this.N0);
        hashMap.put("device_level", String.valueOf(((com.tencent.mobileqq.webview.swift.injector.v) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.v.class)).getDeviceLevel()));
        hashMap.put("sandBoxOn", "" + MultiProcessHelper.getMultiProcessType());
        if (this.I0.size() > 0) {
            hashMap.put("redirect_time", "" + this.I0.size());
            if (!TextUtils.isEmpty(this.I0.get(0))) {
                String u17 = u(this.I0.get(0));
                if (!u17.equals(u16)) {
                    hashMap.put("first_url", j0(u17, 50));
                }
            }
        }
        q(hashMap);
        com.tencent.mobileqq.webview.swift.v.h(hashMap);
        StringBuilder sb6 = new StringBuilder(1024);
        sb6.append(SandBoxControl.c(MobileQQ.sMobileQQ) ? 1 : 0);
        hashMap.put("ex", sb6.toString());
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 4, "webviewSpendingTimeCollection: " + hashMap);
        }
        ((com.tencent.mobileqq.webview.swift.injector.m) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.m.class)).collectPerformance("", "webviewSpendingTimeCollection", true, 0L, 0L, hashMap, "");
    }

    public void Z(String str) {
        String d16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            d16 = str;
        } else {
            d16 = com.tencent.mobileqq.webview.util.s.d(str, new String[0]);
        }
        QLog.i("SwiftBrowserStatistics", 1, "shouldOverrideUrlLoading detect 302, url: " + d16);
        this.U = System.currentTimeMillis();
        this.f314377u0 = true;
        this.I0.add(str);
    }

    public void a0(CustomWebView customWebView, String str, int i3, int i16, int i17, int i18, int i19, String... strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, customWebView, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), strArr);
        } else {
            ThreadManagerV2.post(new Runnable(customWebView, str, i3, i16, i17, i18, i19, strArr) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int C;
                final /* synthetic */ String[] D;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ CustomWebView f314392d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f314393e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f314394f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ int f314395h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ int f314396i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ int f314397m;

                {
                    this.f314392d = customWebView;
                    this.f314393e = str;
                    this.f314394f = i3;
                    this.f314395h = i16;
                    this.f314396i = i17;
                    this.f314397m = i18;
                    this.C = i19;
                    this.D = strArr;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, SwiftBrowserStatistics.this, customWebView, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), strArr);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i26;
                    String str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f314392d.getX5WebViewExtension() != null) {
                        i26 = 1;
                    } else {
                        i26 = 0;
                    }
                    int tbsVersion = QbSdk.getTbsVersion(BaseApplication.getContext());
                    int tbsSDKVersion = WebView.getTbsSDKVersion(BaseApplication.getContext());
                    boolean isPreloadWebProcess = ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess();
                    boolean z16 = SwiftBrowserStatistics.this.G0;
                    int a16 = com.tencent.mobileqq.webview.util.g.a();
                    if (a16 != -1) {
                        if (a16 != 1) {
                            if (a16 != 2) {
                                if (a16 != 3) {
                                    if (a16 != 4) {
                                        str2 = "";
                                    } else {
                                        str2 = "4G";
                                    }
                                } else {
                                    str2 = "3G";
                                }
                            } else {
                                str2 = "2G";
                            }
                        } else {
                            str2 = Global.TRACKING_WIFI;
                        }
                    } else {
                        str2 = " UNKNOWN";
                    }
                    com.tencent.mobileqq.webview.util.y.b(i26, tbsVersion, tbsSDKVersion, isPreloadWebProcess ? 1 : 0, z16 ? 1 : 0, str2, this.f314393e, this.f314394f, this.f314395h, this.f314396i, this.f314397m, this.C, this.D);
                }
            }, 5, null, false);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            super.e();
            this.R0 = this.f314441d.getActivity();
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.component.b.C8976b
    public void f(int i3, Bundle bundle) {
        String str;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bundle);
            return;
        }
        super.f(i3, bundle);
        String str2 = "";
        if (bundle == null || !bundle.containsKey("url")) {
            str = "";
        } else {
            str = bundle.getString("url");
        }
        String currentAccountUin = MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentAccountUin();
        BaseApplication context = BaseApplication.getContext();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 6) {
                        if (i3 != 7) {
                            if (i3 == 8) {
                                R("kd_init_ug_web_page_success", str, currentAccountUin, context);
                                if (bundle != null && bundle.containsKey("url")) {
                                    str2 = bundle.getString("url");
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    F((TouchWebView) this.f314441d.getWebView(), str2);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        R("kd_init_ug_web_page", str, currentAccountUin, context);
                        if (bundle != null && bundle.containsKey("url")) {
                            G(bundle.getString("url"));
                            return;
                        }
                        return;
                    }
                    R("kd_start_ug_web_page", str, currentAccountUin, context);
                    long j3 = this.J;
                    if (j3 > 0) {
                        i16 = (int) ((this.H - j3) / 1000000);
                    } else {
                        i16 = 0;
                    }
                    if (this.f314379w0) {
                        final String valueOf = String.valueOf(this.G0 ? 1 : 0);
                        final String valueOf2 = String.valueOf(((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).isPreloadWebProcess() ? 1 : 0);
                        final String valueOf3 = String.valueOf(System.currentTimeMillis() - this.K);
                        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                SwiftBrowserStatistics.x(valueOf3, valueOf2, valueOf);
                            }
                        }, 16, null, false);
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.d("web_report", 4, "web_before_create, cost = " + i16 + ", url = " + com.tencent.mobileqq.webview.util.s.d(this.A0, new String[0]) + ", isFromLeba = " + this.f314375s0 + ", hasRedDot = " + this.f314376t0 + ", isProgressCreate = " + f314343h1 + ", flag=" + this.B0);
                        return;
                    }
                    return;
                }
                R("kd_load_ug_web_page", str, currentAccountUin, context);
                if (bundle != null && bundle.containsKey("url")) {
                    o(bundle.getString("url"));
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("GOTOWEB", 2, "onQQBrowserResume() time = " + System.currentTimeMillis());
            }
            this.f314363i = System.currentTimeMillis();
            return;
        }
        p();
    }

    public void g0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        if (str.equals("state_back")) {
            if (!this.f314360g0.equals("state_final")) {
                this.f314359f0.put("state_back", Long.valueOf(SystemClock.elapsedRealtime()));
                return;
            }
            return;
        }
        if (this.f314357e0.size() == 0) {
            this.f314357e0.put(0, "state_activity_init");
            this.f314357e0.put(1, "state_activity_create");
            this.f314357e0.put(2, "state_webview_create");
            this.f314357e0.put(3, "state_load_url");
            this.f314357e0.put(4, "state_activity_first_line");
            this.f314357e0.put(5, "state_first_screen");
            this.f314357e0.put(6, "state_page_finished");
            this.f314357e0.put(7, "state_final");
        }
        int indexOfValue = this.f314357e0.indexOfValue(str);
        int indexOfValue2 = this.f314357e0.indexOfValue(this.f314360g0);
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserStatistics", 4, "setBounceRateState state=" + str + " mCurr=" + this.f314360g0);
        }
        if (indexOfValue > indexOfValue2) {
            this.f314360g0 = str;
            this.f314359f0.put(str, Long.valueOf(SystemClock.elapsedRealtime()));
        }
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            final Uri parse = Uri.parse(str);
            if (this.C0) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        SwiftBrowserStatistics.this.v(parse);
                    }
                }, 16, null, false);
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("web_report", 4, "web_stay_in_url, cost = " + ((System.nanoTime() - this.H) / 1000000) + ", url = " + com.tencent.mobileqq.webview.util.s.d(this.A0, new String[0]) + ", isFromLeba = " + this.f314375s0 + ", hasRedDot = " + this.f314376t0);
        }
        this.S0.m(this.f314381y0, this.A0);
    }

    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.S0.b(this.f314381y0, this.A0, this.f314363i);
        }
    }

    public void q(HashMap<String, String> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) hashMap);
            return;
        }
        if (this.J0 == null) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.J0.g());
        sb5.append("|");
        sb5.append(this.J0.c());
        sb5.append("|");
        sb5.append(this.J0.k() ? 1 : 0);
        sb5.append("|");
        sb5.append(this.J0.b());
        long a16 = com.tencent.mobileqq.webview.swift.v.a(this.J0.d(), this.J0.h());
        long a17 = com.tencent.mobileqq.webview.swift.v.a(this.J0.h(), this.J0.e());
        long a18 = com.tencent.mobileqq.webview.swift.v.a(this.J0.e(), this.J0.f());
        long a19 = com.tencent.mobileqq.webview.swift.v.a(com.tencent.mobileqq.webview.swift.v.b(com.tencent.mobileqq.webview.swift.v.f314810f), this.J0.j());
        long a26 = com.tencent.mobileqq.webview.swift.v.a(com.tencent.mobileqq.webview.swift.v.b(com.tencent.mobileqq.webview.swift.v.f314810f), this.J0.f());
        sb5.append("|");
        sb5.append(a16);
        sb5.append("|");
        sb5.append(a17);
        sb5.append("|");
        sb5.append(a18);
        sb5.append("|");
        sb5.append(a19);
        sb5.append("|");
        sb5.append(a26);
        sb5.append("|");
        sb5.append(s(this.J0.a()));
        hashMap.put("HS_data", sb5.toString());
        String j06 = j0(u(this.J0.i()), 50);
        if (!j06.equals(hashMap.get("url"))) {
            hashMap.put("HS_url", j06);
        }
    }

    public String t(TouchWebView touchWebView) {
        OfflinePlugin offlinePlugin;
        WebViewPlugin m3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, (Object) touchWebView);
        }
        WebViewPluginEngine pluginEngine = touchWebView.getPluginEngine();
        if (pluginEngine != null && (m3 = pluginEngine.m("offline")) != null && (m3 instanceof OfflinePlugin)) {
            offlinePlugin = (OfflinePlugin) m3;
        } else {
            offlinePlugin = null;
        }
        if (offlinePlugin != null && offlinePlugin.A() != null) {
            return offlinePlugin.A();
        }
        return "";
    }
}

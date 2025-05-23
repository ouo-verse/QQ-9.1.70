package com.tencent.mobileqq.webview.swift.component;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.webview.swift.cookie.CookiesMap;
import com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie;
import com.tencent.mtt.hippy.bridge.HippyBridge;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftBrowserCookieMonster {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name */
    private static final LruCache<String, SwiftBrowserCookieMonster> f314207q;

    /* renamed from: r, reason: collision with root package name */
    private static ArrayList f314208r;

    /* renamed from: a, reason: collision with root package name */
    public volatile String f314209a;

    /* renamed from: b, reason: collision with root package name */
    public volatile String f314210b;

    /* renamed from: c, reason: collision with root package name */
    public volatile String f314211c;

    /* renamed from: d, reason: collision with root package name */
    public String f314212d;

    /* renamed from: e, reason: collision with root package name */
    public String f314213e;

    /* renamed from: f, reason: collision with root package name */
    public String f314214f;

    /* renamed from: g, reason: collision with root package name */
    final AtomicInteger f314215g;

    /* renamed from: h, reason: collision with root package name */
    public volatile boolean f314216h;

    /* renamed from: i, reason: collision with root package name */
    public String f314217i;

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public final String f314218j;

    /* renamed from: k, reason: collision with root package name */
    public final AuthorizeConfig f314219k;

    /* renamed from: l, reason: collision with root package name */
    final ConcurrentHashMap<String, CopyOnWriteArrayList<t43.b>> f314220l;

    /* renamed from: m, reason: collision with root package name */
    boolean f314221m;

    /* renamed from: n, reason: collision with root package name */
    @QAutoInject(configPath = "AutoInjectYml/Business/Webview/Inject_browser_cookie_business.yml", version = 1)
    private ArrayList<t43.a> f314222n;

    /* renamed from: o, reason: collision with root package name */
    long f314223o;

    /* renamed from: p, reason: collision with root package name */
    private SwiftTicketCookie f314224p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements com.tencent.mobileqq.webview.swift.injector.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f314230a;

        a(CountDownLatch countDownLatch) {
            this.f314230a = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserCookieMonster.this, (Object) countDownLatch);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.d("SwiftBrowserCookieMonster", 1, "getPskeyIfNeed onFail:" + str);
            this.f314230a.countDown();
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NotNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            if (map == null) {
                QLog.e("SwiftBrowserCookieMonster", 1, "getPskeyIfNeed map is null");
                this.f314230a.countDown();
                return;
            }
            String str = map.get(SwiftBrowserCookieMonster.this.f314213e);
            if (!TextUtils.isEmpty(str)) {
                SwiftBrowserCookieMonster.this.f314209a = str;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getPskeyIfNeed onSuccess ");
                sb5.append(com.tencent.mobileqq.webview.util.s.c(" p_skey=" + SwiftBrowserCookieMonster.this.f314209a, new String[0]));
                QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
                this.f314230a.countDown();
                return;
            }
            QLog.e("SwiftBrowserCookieMonster", 1, "getPskeyIfNeed pskey is null");
            this.f314230a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements com.tencent.mobileqq.webview.swift.injector.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f314232a;

        b(CountDownLatch countDownLatch) {
            this.f314232a = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserCookieMonster.this, (Object) countDownLatch);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.d("SwiftBrowserCookieMonster", 1, "getUskeyIfNeed onFail:" + str);
            this.f314232a.countDown();
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NotNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            if (map == null) {
                QLog.e("SwiftBrowserCookieMonster", 1, "getUskeyIfNeed map is null");
                this.f314232a.countDown();
                return;
            }
            String str = map.get(SwiftBrowserCookieMonster.this.f314213e);
            if (!TextUtils.isEmpty(str)) {
                SwiftBrowserCookieMonster.this.f314210b = str;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getUskeyIfNeed onSuccess ");
                sb5.append(com.tencent.mobileqq.webview.util.s.c(" uskey=" + SwiftBrowserCookieMonster.this.f314210b, new String[0]));
                QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
                this.f314232a.countDown();
                return;
            }
            QLog.e("SwiftBrowserCookieMonster", 1, "getUskeyIfNeed uskey is null");
            this.f314232a.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements com.tencent.mobileqq.webview.swift.injector.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f314234a;

        c(String[] strArr) {
            this.f314234a = strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SwiftBrowserCookieMonster.this, (Object) strArr);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.d("SwiftBrowserCookieMonster", 1, "getUskeyImmediately onFail:" + str);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NotNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            if (map == null) {
                QLog.e("SwiftBrowserCookieMonster", 1, "getUskeyImmediately map is null");
                return;
            }
            String str = map.get(SwiftBrowserCookieMonster.this.f314213e);
            if (!TextUtils.isEmpty(str)) {
                this.f314234a[0] = str;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getUskeyImmediately onSuccess ");
                sb5.append(com.tencent.mobileqq.webview.util.s.c(" uskey=" + str, new String[0]));
                QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
                return;
            }
            QLog.e("SwiftBrowserCookieMonster", 1, "getUskeyImmediately uskey is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements com.tencent.mobileqq.webview.swift.injector.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f314236a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f314237b;

        d(String str, String[] strArr) {
            this.f314236a = str;
            this.f314237b = strArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SwiftBrowserCookieMonster.this, str, strArr);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.d("SwiftBrowserCookieMonster", 1, "getPskeyImmediately onFail:" + str);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NotNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            if (map == null) {
                QLog.e("SwiftBrowserCookieMonster", 1, "getPskeyImmediately map is null");
                return;
            }
            String str = map.get(this.f314236a);
            if (!TextUtils.isEmpty(str)) {
                this.f314237b[0] = str;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("getPskeyImmediately onSuccess ");
                sb5.append(com.tencent.mobileqq.webview.util.s.c(" pskey=" + str, new String[0]));
                QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
                return;
            }
            QLog.e("SwiftBrowserCookieMonster", 1, "getPskeyImmediately pskey is null");
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49195);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        f314208r = arrayList;
        arrayList.add(sx.a.class);
        f314208r.add(com.tencent.mobileqq.qqlive.widget.verify.f.class);
        f314208r.add(com.tencent.mobileqq.qqgift.webview.c.class);
        f314208r.add(com.tencent.timi.game.api.cookie.impl.c.class);
        f314208r.add(com.tencent.mobileqq.tvideo.webview.a.class);
        f314207q = new LruCache<>(8);
    }

    SwiftBrowserCookieMonster(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f314215g = new AtomicInteger(1);
        this.f314220l = new ConcurrentHashMap<>();
        this.f314221m = false;
        this.f314222n = new ArrayList<>();
        this.f314223o = 0L;
        this.f314218j = str;
        LruCache<String, SwiftBrowserCookieMonster> lruCache = f314207q;
        if (lruCache.size() == 0) {
            CookieSyncManager.createInstance(BaseApplication.getContext());
        }
        this.f314219k = AuthorizeConfig.y();
        lruCache.put(str, this);
        SwiftTicketCookie.E();
        E();
        this.f314224p = new SwiftTicketCookie();
    }

    static void C() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length > 2) {
            QLog.d("SwiftBrowserCookieMonster", 1, stackTrace[1] + " at " + stackTrace[2].toString());
        }
    }

    private void D(AppRuntime appRuntime, StringBuilder sb5, TicketManager ticketManager, String str, boolean z16, boolean z17, boolean z18, boolean z19, String[] strArr) {
        String realSkey;
        for (String str2 : strArr) {
            if (!TextUtils.isEmpty(str2)) {
                com.tencent.mobileqq.webview.swift.cookie.b.h(sb5);
                String str3 = "fail";
                if (str2.startsWith("p_skey=") && z17) {
                    if (!TextUtils.isEmpty(this.f314213e)) {
                        if (TextUtils.isEmpty(this.f314209a)) {
                            this.f314209a = v(this.f314213e, MobileQQ.sMobileQQ.peekAppRuntime());
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("getCookie4WebSo: pSkey is miss and fetch result is ");
                            if (!TextUtils.isEmpty(this.f314209a)) {
                                str3 = "success";
                            }
                            sb6.append(str3);
                            QLog.i("SwiftBrowserCookieMonster", 1, sb6.toString());
                        }
                    } else {
                        this.f314209a = null;
                        QLog.i("SwiftBrowserCookieMonster", 1, "processTicket pSkeyDomain is null");
                    }
                    com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, this.f314209a, "p_skey=", t(str2));
                } else if (str2.startsWith("uskey=") && z18) {
                    if (!TextUtils.isEmpty(this.f314213e)) {
                        if (TextUtils.isEmpty(this.f314210b)) {
                            this.f314210b = y(this.f314213e, MobileQQ.sMobileQQ.peekAppRuntime());
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append("getCookie4WebSo: uskey is miss and fetch result is ");
                            if (!TextUtils.isEmpty(this.f314210b)) {
                                str3 = "success";
                            }
                            sb7.append(str3);
                            QLog.i("SwiftBrowserCookieMonster", 1, sb7.toString());
                        }
                    } else {
                        this.f314210b = null;
                        QLog.i("SwiftBrowserCookieMonster", 1, "processTicket[uskey] pSkeyDomain is null");
                    }
                    com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, this.f314209a, "uskey=", t(str2));
                } else {
                    String str4 = "";
                    if (str2.startsWith("p_uin=") && z17) {
                        if (appRuntime != null && appRuntime.isLogin()) {
                            str4 = com.tencent.mobileqq.webview.swift.cookie.b.e(appRuntime.getAccount());
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("getCookie4WebSo: p_uin result is ");
                            if (!TextUtils.isEmpty(str4)) {
                                str3 = "success";
                            }
                            sb8.append(str3);
                            QLog.i("SwiftBrowserCookieMonster", 1, sb8.toString());
                        }
                        sb5.append("p_uin=");
                        sb5.append(str4);
                    } else if (str2.startsWith("p_uid=") && z18) {
                        if (appRuntime != null && appRuntime.isLogin()) {
                            String currentUid = appRuntime.getCurrentUid();
                            if (currentUid != null) {
                                str4 = currentUid;
                            }
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append("getCookie4WebSo: p_uid result is ");
                            if (!TextUtils.isEmpty(str4)) {
                                str3 = "success";
                            }
                            sb9.append(str3);
                            QLog.i("SwiftBrowserCookieMonster", 1, sb9.toString());
                        }
                        sb5.append("p_uid=");
                        sb5.append(str4);
                    } else if (str2.startsWith("skey=") && z16) {
                        if (TextUtils.isEmpty(SwiftTicketCookie.f314535h)) {
                            if (((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).u()) {
                                realSkey = com.tencent.mobileqq.webview.util.s.g(str);
                            } else {
                                realSkey = ticketManager.getRealSkey(str);
                            }
                            SwiftTicketCookie.f314535h = realSkey;
                            StringBuilder sb10 = new StringBuilder();
                            sb10.append("getCookie4WebSo: sKey is miss and fetch result is ");
                            if (!TextUtils.isEmpty(SwiftTicketCookie.f314535h)) {
                                str3 = "success";
                            }
                            sb10.append(str3);
                            QLog.i("SwiftBrowserCookieMonster", 1, sb10.toString());
                        }
                        if (!TextUtils.isEmpty(SwiftTicketCookie.f314535h)) {
                            QLog.i("SwiftBrowserCookieMonster", 1, com.tencent.mobileqq.webview.util.s.c("skey=" + SwiftTicketCookie.f314535h, new String[0]));
                        } else {
                            QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                        }
                        com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, SwiftTicketCookie.f314535h, "skey=", t(str2));
                    } else if (str2.startsWith("pt4_token=") && z19) {
                        if (TextUtils.isEmpty(this.f314211c)) {
                            this.f314211c = SwiftTicketCookie.p(appRuntime, this.f314219k.k0(this.f314218j));
                            StringBuilder sb11 = new StringBuilder();
                            sb11.append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                            if (!TextUtils.isEmpty(this.f314211c)) {
                                str3 = "success";
                            }
                            sb11.append(str3);
                            QLog.i("SwiftBrowserCookieMonster", 1, sb11.toString());
                        }
                        com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, this.f314211c, "pt4_token=", t(str2));
                    } else {
                        sb5.append(str2);
                    }
                }
            }
        }
    }

    @QAutoInitMethod
    private void E() {
        com.tencent.mobileqq.qroute.utils.b.c(f314208r, this.f314222n);
        if (this.f314222n.size() > 0) {
            if (QLog.isDebugVersion()) {
                Iterator<t43.a> it = this.f314222n.iterator();
                while (it.hasNext()) {
                    QLog.i("SwiftBrowserCookieMonster", 2, "inject name:" + it.next().getClass());
                }
                return;
            }
            return;
        }
        QLog.e("SwiftBrowserCookieMonster", 1, "mBrowserCookieInjectors Failed !");
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
        } else {
            throw new RuntimeException("mBrowserCookieInjectors failed!");
        }
    }

    public static void H() {
        SwiftTicketCookie.f314535h = "";
        SwiftTicketCookie.f314536i = "";
        SwiftTicketCookie.f314537j = "";
        SwiftTicketCookie.f314538k = "";
        SwiftTicketCookie.f314539l = "";
        SwiftTicketCookie.f314528a.set(1);
        f314207q.evictAll();
        SwiftTicketCookie.G();
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            C();
        }
        QLog.w("SwiftBrowserCookieMonster", 1, "resetAllKeyAndCache");
    }

    private boolean K(AppRuntime appRuntime, String str, StringBuilder sb5, boolean z16, String str2) {
        String str3;
        if (!TextUtils.isEmpty(str2)) {
            if (!TextUtils.isEmpty(str) && str.contains("pt4_token=")) {
                if (str.contains("pt4_token=")) {
                    return true;
                }
                return z16;
            }
            if (TextUtils.isEmpty(this.f314211c)) {
                this.f314211c = SwiftTicketCookie.p(appRuntime, str2);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getCookie4WebSo: pt4Token is miss and fetch result is ");
                if (TextUtils.isEmpty(this.f314211c)) {
                    str3 = "fail";
                } else {
                    str3 = "success";
                }
                sb6.append(str3);
                QLog.i("SwiftBrowserCookieMonster", 1, sb6.toString());
            }
            com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, this.f314211c, "pt4_token=", "");
            return z16;
        }
        return z16;
    }

    private boolean L(AppRuntime appRuntime, String str, StringBuilder sb5, String str2) {
        String str3;
        if (!TextUtils.isEmpty(this.f314213e)) {
            if (!TextUtils.isEmpty(str) && str.contains("p_skey=")) {
                if (str.contains("p_skey=")) {
                    return true;
                }
            } else {
                if (!TextUtils.isEmpty(str) && str.contains("p_uin=;")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uin");
                    }
                } else if (TextUtils.isEmpty(str) || !str.contains("p_uin=")) {
                    com.tencent.mobileqq.webview.swift.cookie.b.h(sb5);
                    sb5.append("p_uin=");
                    sb5.append(str2);
                }
                if (TextUtils.isEmpty(this.f314209a)) {
                    this.f314209a = v(this.f314213e, appRuntime);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("getCookie4WebSo: pSkey is miss and fetch result is ");
                    if (TextUtils.isEmpty(this.f314209a)) {
                        str3 = "fail";
                    } else {
                        str3 = "success";
                    }
                    sb6.append(str3);
                    QLog.i("SwiftBrowserCookieMonster", 1, sb6.toString());
                }
                com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, this.f314209a, "p_skey=", "");
            }
        } else {
            QLog.i("SwiftBrowserCookieMonster", 1, "getCookie4WebSo pSkeyDomain is null");
        }
        return false;
    }

    private boolean M(String str, StringBuilder sb5, TicketManager ticketManager, String str2) {
        String realSkey;
        String str3;
        if (!TextUtils.isEmpty(str) && str.contains("skey=")) {
            if (str.contains("skey=;")) {
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserCookieMonster", 2, "not need set skey");
                }
            } else if (str.contains("skey=")) {
                return true;
            }
        } else {
            if (TextUtils.isEmpty(SwiftTicketCookie.f314535h)) {
                if (((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).u()) {
                    realSkey = com.tencent.mobileqq.webview.util.s.g(str2);
                } else {
                    realSkey = ticketManager.getRealSkey(str2);
                }
                SwiftTicketCookie.f314535h = realSkey;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("getCookie4WebSo: skey is miss and fetch result is ");
                if (TextUtils.isEmpty(SwiftTicketCookie.f314535h)) {
                    str3 = "fail";
                } else {
                    str3 = "success";
                }
                sb6.append(str3);
                QLog.i("SwiftBrowserCookieMonster", 1, sb6.toString());
            }
            if (!TextUtils.isEmpty(SwiftTicketCookie.f314535h)) {
                QLog.i("SwiftBrowserCookieMonster", 1, com.tencent.mobileqq.webview.util.s.c("skey=" + SwiftTicketCookie.f314535h, new String[0]));
            } else {
                QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
            }
            com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, SwiftTicketCookie.f314535h, "skey=", "");
        }
        return false;
    }

    private boolean N(AppRuntime appRuntime, String str, StringBuilder sb5, String str2) {
        String str3;
        if (!TextUtils.isEmpty(this.f314213e)) {
            if (!TextUtils.isEmpty(str) && str.contains("uskey=")) {
                if (str.contains("uskey=")) {
                    return true;
                }
            } else {
                if (!TextUtils.isEmpty(str) && str.contains("p_uid=;")) {
                    if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserCookieMonster", 2, "not need set p_uid");
                    }
                } else if (TextUtils.isEmpty(str) || !str.contains("p_uid=")) {
                    com.tencent.mobileqq.webview.swift.cookie.b.h(sb5);
                    sb5.append("p_uid=");
                    sb5.append(str2);
                }
                if (TextUtils.isEmpty(this.f314210b)) {
                    this.f314210b = y(this.f314213e, MobileQQ.sMobileQQ.peekAppRuntime());
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("getCookie4WebSo: uskey is miss and fetch result is ");
                    if (TextUtils.isEmpty(this.f314210b)) {
                        str3 = "fail";
                    } else {
                        str3 = "success";
                    }
                    sb6.append(str3);
                    QLog.i("SwiftBrowserCookieMonster", 1, sb6.toString());
                }
                com.tencent.mobileqq.webview.swift.cookie.b.a(sb5, this.f314210b, "uskey=", "");
            }
        } else {
            QLog.i("SwiftBrowserCookieMonster", 1, "getCookie4WebSo[uskey] PskeyDomain is null");
        }
        return false;
    }

    public static void O(AppRuntime appRuntime) {
        long currentTimeMillis = System.currentTimeMillis();
        AtomicInteger atomicInteger = SwiftTicketCookie.f314528a;
        int i3 = atomicInteger.get();
        if (3 != i3) {
            if (1 == i3) {
                if (appRuntime == null) {
                    appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                }
                SwiftTicketCookie.n(appRuntime);
            }
            synchronized (atomicInteger) {
                while (true) {
                    AtomicInteger atomicInteger2 = SwiftTicketCookie.f314528a;
                    if (2 != atomicInteger2.get()) {
                        break;
                    }
                    try {
                        LockMethodProxy.wait(atomicInteger2);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
            }
            if (QLog.isDevelopLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 4, "waitAndGetCommonKeys cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            }
        }
    }

    private void d(String str, t43.b bVar, AppRuntime appRuntime, Intent intent, String str2) {
        String str3;
        if (this.f314223o > 0) {
            o();
            QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, errorCode: " + this.f314223o);
        }
        String cookie = CookieManager.getInstance().getCookie(str);
        if (((!TextUtils.isEmpty(cookie) && cookie.contains("skey=")) || !this.f314219k.l0(str)) && !A(cookie)) {
            boolean z16 = this.f314221m;
            if (!z16 && this.f314223o <= 0) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("hit cookie cache, callback: ");
                if (QLog.isColorLevel()) {
                    str3 = com.tencent.mobileqq.webview.util.s.d(str2, new String[0]);
                } else {
                    str3 = this.f314218j;
                }
                sb5.append(str3);
                sb5.append(", errorCode: ");
                sb5.append(this.f314223o);
                QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
                bVar.a(str2, null, this.f314223o);
                return;
            }
            if (z16) {
                QLog.w("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + com.tencent.mobileqq.webview.util.s.d(str2, new String[0]));
            }
            bVar.a(str2, null, this.f314223o);
            n(str2);
            return;
        }
        QLog.e("SwiftBrowserCookieMonster", 1, "some cookie goes wrong, retry set cookie: " + cookie + "");
        G();
        I(str, bVar, appRuntime, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(AppRuntime appRuntime) {
        if (appRuntime != null) {
            long currentTimeMillis = System.currentTimeMillis();
            String account = appRuntime.getAccount();
            boolean e16 = com.tencent.mobileqq.webview.swift.cookie.c.e(account, 3);
            if (e16) {
                com.tencent.mobileqq.webview.swift.utils.m.g();
                com.tencent.mobileqq.webview.swift.cookie.c.i(account, 3);
            }
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "clearLastUinCookiesIfNeed, didClear=" + e16 + ", uin=" + account + ", cost=" + (System.currentTimeMillis() - currentTimeMillis));
            }
        }
    }

    private void i(CookiesMap cookiesMap) {
        StringBuilder sb5 = new StringBuilder(1024);
        Iterator<t43.a> it = this.f314222n.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3++;
            List<String> a16 = it.next().a(this.f314218j);
            if (a16 != null && a16.size() != 0) {
                sb5.append(" ");
                sb5.append("[");
                sb5.append(i3);
                sb5.append("]=");
                sb5.append(a16.size());
                for (String str : a16) {
                    if (!TextUtils.isEmpty(str)) {
                        cookiesMap.addCookie(this.f314218j, str);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("SwiftBrowserCookieMonster", 1, "collectBusinessCookie: [" + sb5.toString() + "]");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k(Intent intent, CookiesMap cookiesMap, AppRuntime appRuntime) {
        String str;
        int i3;
        String str2;
        String str3 = null;
        if (!TextUtils.isEmpty(this.f314213e)) {
            CountDownLatch countDownLatch = new CountDownLatch(2);
            long currentTimeMillis = System.currentTimeMillis();
            u(this.f314213e, appRuntime, countDownLatch);
            x(this.f314213e, appRuntime, countDownLatch);
            try {
                countDownLatch.await(10000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException unused) {
                QLog.e("SwiftBrowserCookieMonster", 1, "latch await timeout.");
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("SwiftBrowserCookieMonster", 1, "latch await cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            }
            if (!TextUtils.isEmpty(this.f314210b)) {
                String c16 = com.tencent.mobileqq.webview.swift.cookie.b.c("uskey", this.f314210b, this.f314213e);
                cookiesMap.addCookie(this.f314218j, c16);
                if (this.f314218j.contains("http://") && this.f314218j.contains("qzone.qq.com")) {
                    cookiesMap.addCookie(this.f314218j.replace("http", "https"), c16);
                }
            } else {
                str3 = CookieManager.getInstance().getCookie(this.f314218j);
                if (TextUtils.isEmpty(str3) || !str3.contains("uskey=") || str3.contains("uskey=;")) {
                    QLog.e("SwiftBrowserCookieMonster", 1, this.f314213e + " collectUskeyCookies: get uSkey fail!");
                    i3 = 1;
                    if (TextUtils.isEmpty(this.f314209a)) {
                        String c17 = com.tencent.mobileqq.webview.swift.cookie.b.c("p_skey", this.f314209a, this.f314213e);
                        cookiesMap.addCookie(this.f314218j, c17);
                        if (this.f314218j.contains("http://") && this.f314218j.contains("qzone.qq.com")) {
                            cookiesMap.addCookie(this.f314218j.replace("http", "https"), c17);
                        }
                    } else {
                        if (str3 == null) {
                            str3 = CookieManager.getInstance().getCookie(this.f314218j);
                        }
                        if (TextUtils.isEmpty(str3) || !str3.contains("p_skey=") || str3.contains("p_skey=;")) {
                            this.f314223o |= 32;
                            QLog.e("SwiftBrowserCookieMonster", 1, this.f314213e + " collectPskeyCookies: get pSkey fail! noFlag: " + i3);
                            i3 |= 2;
                        }
                    }
                    if (i3 == 3) {
                        if (intent != null) {
                            str2 = intent.getStringExtra("url");
                        } else {
                            str2 = "";
                        }
                        SwiftBrowserStatistics.V(str2, this.f314218j, false, i3);
                        return;
                    }
                }
            }
            i3 = 0;
            if (TextUtils.isEmpty(this.f314209a)) {
            }
            if (i3 == 3) {
            }
        } else {
            QLog.e("SwiftBrowserCookieMonster", 1, "pSkeyDomain is null for: " + this.f314218j);
        }
        if (!TextUtils.isEmpty(this.f314214f) && TextUtils.isEmpty(this.f314211c)) {
            this.f314211c = SwiftTicketCookie.p(appRuntime, this.f314214f);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.f314214f);
            sb5.append(": pt4Token is miss and fetch result is ");
            if (TextUtils.isEmpty(this.f314211c)) {
                str = "fail";
            } else {
                str = "success";
            }
            sb5.append(str);
            QLog.i("SwiftBrowserCookieMonster", 1, sb5.toString());
        }
        if (!z(cookiesMap, str3, this.f314218j) && !TextUtils.isEmpty(this.f314213e) && this.f314213e.equals(ITeamWorkHandler.DOCS_DOMAIN)) {
            cookiesMap.addCookie(this.f314218j, com.tencent.mobileqq.webview.swift.cookie.b.b(ITeamWorkUtils.TD_SOURCE_QQ_ADTAG, "s_qq_c2c_chatfiles", this.f314213e, false));
        }
    }

    public static String r(String str) {
        SwiftBrowserCookieMonster s16 = s(str);
        String str2 = "";
        if (s16 != null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime != null && waitAppRuntime.isLogin()) {
                try {
                    CookieSyncManager.createInstance(waitAppRuntime.getApplication().getApplicationContext());
                    str2 = CookieManager.getInstance().getCookie(str);
                    if (QLog.isColorLevel()) {
                        QLog.d("SwiftBrowserCookieMonster", 2, "Get cookie:" + com.tencent.mobileqq.webview.util.s.c(str2, new String[0]) + " from " + com.tencent.mobileqq.webview.util.s.d(str, new String[0]));
                    }
                } catch (Throwable th5) {
                    QLog.e("SwiftBrowserCookieMonster", 1, "getCookie4WebSoOrSonic error:" + th5.getMessage() + ".");
                }
                return s16.q(waitAppRuntime, str2);
            }
            QLog.e("SwiftBrowserCookieMonster", 1, "getCookie4WebSoOrSonic error:get cookieMonster fail, url=[" + com.tencent.mobileqq.webview.util.s.d(str, new String[0]) + "].");
            return "";
        }
        QLog.e("SwiftBrowserCookieMonster", 1, "getCookie4WebSoOrSonic error:get cookieMonster fail, url=[" + com.tencent.mobileqq.webview.util.s.d(str, new String[0]) + "].");
        return "";
    }

    public static synchronized SwiftBrowserCookieMonster s(String str) {
        synchronized (SwiftBrowserCookieMonster.class) {
            String f16 = com.tencent.mobileqq.webview.swift.cookie.b.f(str);
            if (!TextUtils.isEmpty(f16)) {
                SwiftBrowserCookieMonster swiftBrowserCookieMonster = f314207q.get(f16);
                if (swiftBrowserCookieMonster == null) {
                    swiftBrowserCookieMonster = new SwiftBrowserCookieMonster(f16);
                }
                return swiftBrowserCookieMonster;
            }
            return null;
        }
    }

    private static String t(String str) {
        if (str != null && str.contains(ContainerUtils.KEY_VALUE_DELIMITER)) {
            String[] split = str.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split.length == 2) {
                return split[1];
            }
            return null;
        }
        return null;
    }

    private void u(String str, AppRuntime appRuntime, CountDownLatch countDownLatch) {
        if (!TextUtils.isEmpty(this.f314209a)) {
            countDownLatch.countDown();
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("SwiftBrowserCookieMonster", 1, "getPskey start");
        }
        com.tencent.mobileqq.webview.swift.cookie.a.b(str, appRuntime, new a(countDownLatch));
    }

    private String v(String str, AppRuntime appRuntime) {
        String[] strArr = {""};
        com.tencent.mobileqq.webview.swift.cookie.a.b(str, appRuntime, new d(str, strArr));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getPskeyImmediately: ");
        sb5.append(com.tencent.mobileqq.webview.util.s.c(" pskey=" + strArr[0], new String[0]));
        QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
        return strArr[0];
    }

    private void x(String str, AppRuntime appRuntime, CountDownLatch countDownLatch) {
        if (!TextUtils.isEmpty(this.f314210b)) {
            countDownLatch.countDown();
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.e("SwiftBrowserCookieMonster", 1, "getUskey start");
        }
        com.tencent.mobileqq.webview.swift.cookie.a.d(str, appRuntime, new b(countDownLatch));
    }

    private String y(String str, AppRuntime appRuntime) {
        String[] strArr = {""};
        com.tencent.mobileqq.webview.swift.cookie.a.d(str, appRuntime, new c(strArr));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getUskeyImmediately: ");
        sb5.append(com.tencent.mobileqq.webview.util.s.c(" uskey=" + strArr[0], new String[0]));
        QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
        return strArr[0];
    }

    private boolean z(CookiesMap cookiesMap, String str, String str2) {
        if (!TextUtils.isEmpty(this.f314214f)) {
            if (!TextUtils.isEmpty(this.f314211c)) {
                cookiesMap.addCookie(str2, com.tencent.mobileqq.webview.swift.cookie.b.c("pt4_token", this.f314211c, this.f314214f));
                return false;
            }
            if (str == null) {
                str = CookieManager.getInstance().getCookie(str2);
            }
            if (TextUtils.isEmpty(str) || !str.contains("pt4_token=") || str.contains("pt4_token=;")) {
                this.f314223o |= 64;
                QLog.e("SwiftBrowserCookieMonster", 1, this.f314214f + ": get pt4Token fail!");
                return true;
            }
            return false;
        }
        return false;
    }

    boolean A(String str) {
        boolean z16 = false;
        if (!TextUtils.isEmpty(str) && !str.contains("p_skey")) {
            if (!TextUtils.isEmpty(this.f314213e) && (this.f314213e.equals(ITeamWorkHandler.DOCS_DOMAIN) || this.f314213e.equals("docx.qq.com"))) {
                z16 = true;
            }
            if (z16) {
                QLog.i("SwiftBrowserCookieMonster", 1, "isNeedPskey we should re - setAllCookies");
            }
        }
        return z16;
    }

    public boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.f314215g.get() == 3) {
            return true;
        }
        return false;
    }

    public void F(t43.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar);
            return;
        }
        if (bVar != null) {
            Iterator<String> it = this.f314220l.keySet().iterator();
            while (it.hasNext()) {
                CopyOnWriteArrayList<t43.b> copyOnWriteArrayList = this.f314220l.get(it.next());
                if (copyOnWriteArrayList.contains(bVar)) {
                    copyOnWriteArrayList.remove(bVar);
                    return;
                }
            }
        }
    }

    void G() {
        this.f314215g.set(1);
        this.f314221m = false;
        this.f314223o = 0L;
    }

    public boolean I(String str, t43.b bVar, AppRuntime appRuntime, Intent intent) {
        String str2;
        AppRuntime appRuntime2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, str, bVar, appRuntime, intent)).booleanValue();
        }
        if (this.f314215g.get() == 3) {
            if (appRuntime == null) {
                appRuntime2 = MobileQQ.sMobileQQ.waitAppRuntime(null);
            } else {
                appRuntime2 = appRuntime;
            }
            String w3 = w(str, appRuntime2);
            if (bVar != null) {
                d(str, bVar, appRuntime, intent, w3);
                return true;
            }
        }
        if (bVar != null) {
            CopyOnWriteArrayList<t43.b> copyOnWriteArrayList = this.f314220l.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.f314220l.put(str, copyOnWriteArrayList);
            }
            if (!copyOnWriteArrayList.contains(bVar)) {
                copyOnWriteArrayList.add(bVar);
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("setAllCookies ");
        if (bVar != null) {
            str2 = "with callback: ";
        } else {
            str2 = "with no callback: ";
        }
        sb5.append(str2);
        sb5.append(com.tencent.mobileqq.webview.util.s.d(str, new String[0]));
        QLog.i("SwiftBrowserCookieMonster", 1, sb5.toString());
        com.tencent.mobileqq.webview.util.s.a("Web_qqbrowser_check_and_set_cookies");
        Runnable runnable = new Runnable(appRuntime, str, intent, str) { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ AppRuntime f314225d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f314226e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Intent f314227f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f314228h;

            {
                this.f314225d = appRuntime;
                this.f314226e = str;
                this.f314227f = intent;
                this.f314228h = str;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, SwiftBrowserCookieMonster.this, appRuntime, str, intent, str);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String str3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime appRuntime3 = this.f314225d;
                if (appRuntime3 == null) {
                    appRuntime3 = MobileQQ.sMobileQQ.waitAppRuntime(null);
                }
                if (SwiftBrowserCookieMonster.this.f314215g.get() == 2) {
                    SwiftBrowserCookieMonster.this.f(appRuntime3);
                    SwiftBrowserCookieMonster.this.p();
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("set all cookies start: ");
                    if (QLog.isColorLevel()) {
                        str3 = com.tencent.mobileqq.webview.util.s.d(this.f314226e, new String[0]);
                    } else {
                        str3 = SwiftBrowserCookieMonster.this.f314218j;
                    }
                    sb6.append(str3);
                    QLog.d("SwiftBrowserCookieMonster", 1, sb6.toString());
                    SwiftBrowserCookieMonster swiftBrowserCookieMonster = SwiftBrowserCookieMonster.this;
                    swiftBrowserCookieMonster.J(swiftBrowserCookieMonster.g(this.f314227f, appRuntime3), true);
                    if (SwiftBrowserCookieMonster.this.f314215g.compareAndSet(2, 3)) {
                        synchronized (SwiftBrowserCookieMonster.this.f314215g) {
                            SwiftBrowserCookieMonster.this.f314215g.notifyAll();
                        }
                        SwiftBrowserCookieMonster swiftBrowserCookieMonster2 = SwiftBrowserCookieMonster.this;
                        if (swiftBrowserCookieMonster2.f314223o > 0) {
                            swiftBrowserCookieMonster2.o();
                            QLog.e("SwiftBrowserCookieMonster", 1, "set cookie error :" + SwiftBrowserCookieMonster.this.f314223o);
                        } else if (QLog.isColorLevel()) {
                            QLog.i("SwiftBrowserCookieMonster", 2, "set cookie success: now start post handle callback");
                        }
                    }
                    com.tencent.mobileqq.webview.util.s.b("Web_qqbrowser_check_and_set_cookies");
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster.1.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String str4;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                                return;
                            }
                            for (String str5 : SwiftBrowserCookieMonster.this.f314220l.keySet()) {
                                CopyOnWriteArrayList<t43.b> copyOnWriteArrayList2 = SwiftBrowserCookieMonster.this.f314220l.get(str5);
                                AppRuntime appRuntime4 = AnonymousClass1.this.f314225d;
                                if (appRuntime4 == null) {
                                    appRuntime4 = MobileQQ.sMobileQQ.waitAppRuntime(null);
                                }
                                String w16 = SwiftBrowserCookieMonster.this.w(str5, appRuntime4);
                                Iterator<t43.b> it = copyOnWriteArrayList2.iterator();
                                while (it.hasNext()) {
                                    t43.b next = it.next();
                                    StringBuilder sb7 = new StringBuilder();
                                    sb7.append("callback: ");
                                    if (QLog.isColorLevel()) {
                                        str4 = com.tencent.mobileqq.webview.util.s.d(w16, new String[0]);
                                    } else {
                                        str4 = SwiftBrowserCookieMonster.this.f314218j;
                                    }
                                    sb7.append(str4);
                                    sb7.append(", errorCode: ");
                                    sb7.append(SwiftBrowserCookieMonster.this.f314223o);
                                    QLog.d("SwiftBrowserCookieMonster", 1, sb7.toString());
                                    if (SwiftBrowserCookieMonster.this.f314221m) {
                                        QLog.w("SwiftBrowserCookieMonster", 1, "cookie is wrong, need do jump ptlogin! " + com.tencent.mobileqq.webview.util.s.d(w16, new String[0]));
                                    }
                                    next.a(w16, null, SwiftBrowserCookieMonster.this.f314223o);
                                }
                            }
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            SwiftBrowserCookieMonster swiftBrowserCookieMonster3 = SwiftBrowserCookieMonster.this;
                            if (!swiftBrowserCookieMonster3.f314221m && swiftBrowserCookieMonster3.f314223o <= 0) {
                                swiftBrowserCookieMonster3.f314220l.remove(anonymousClass1.f314228h);
                            } else {
                                swiftBrowserCookieMonster3.n(anonymousClass1.f314228h);
                            }
                        }
                    });
                }
            }
        };
        if (this.f314215g.compareAndSet(1, 2)) {
            CookieSyncManager.createInstance(BaseApplication.getContext());
            if (QLog.isDevelopLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 1, "post to set all cookies");
            }
            ThreadManagerV2.excute(runnable, 16, null, true);
        }
        return true;
    }

    void J(CookiesMap cookiesMap, boolean z16) {
        boolean z17;
        HashMap hashMap = new HashMap();
        Set<Map.Entry<String, ArrayList<String>>> entrySet = cookiesMap.entrySet();
        int i3 = 0;
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && ((Boolean) com.tencent.mobileqq.webview.util.t.j().b("debug_webview_cookie_dump_on", Boolean.FALSE)).booleanValue()) {
            z17 = true;
        } else {
            z17 = false;
        }
        for (Map.Entry<String, ArrayList<String>> entry : entrySet) {
            String key = entry.getKey();
            ArrayList<String> value = entry.getValue();
            if (z17) {
                QLog.i("SwiftBrowserCookieMonster", 1, "setCookies[" + i3 + "] key: " + key + ", value: " + value);
                i3++;
            }
            if (value != null && value.size() > 0) {
                hashMap.put(key, (String[]) value.toArray(new String[value.size()]));
            }
        }
        if (hashMap.size() > 0) {
            try {
                CookieManager.getInstance().setCookies(hashMap);
            } catch (Throwable th5) {
                QLog.w("SwiftBrowserCookieMonster", 1, "setCookies exception: " + th5.getMessage(), th5);
            }
            if (z16) {
                CookieSyncManager.createInstance(MobileQQ.sMobileQQ);
                try {
                    CookieSyncManager.getInstance().sync();
                } catch (Throwable th6) {
                    QLog.w("SwiftBrowserCookieMonster", 1, "setCookies sync exception: " + th6.getMessage(), th6);
                }
            }
        }
    }

    void b(CookiesMap cookiesMap) {
        String read = PropertiesUtils.read(BaseApplication.getContext(), PropertiesUtils.KEY_LOCALE_ID, "0");
        if ("0".equals(read)) {
            return;
        }
        String str = "qq_locale_id=" + read + ';';
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserCookieMonster", 2, "addLocaleIdCookie, cookie = " + str);
        }
        Iterator<String> it = cookiesMap.keySet().iterator();
        while (it.hasNext()) {
            cookiesMap.addCookie(it.next(), str);
        }
    }

    void c(CookiesMap cookiesMap) {
        String str = "qq_route_id=" + MsfSdkUtils.getRoutingID(BaseApplication.getContext()) + ";";
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserCookieMonster", 2, "addRoutingID, cookie = " + str);
        }
        cookiesMap.addCookie(this.f314218j, str);
    }

    @Deprecated
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        p();
        CookiesMap cookiesMap = new CookiesMap();
        m(cookiesMap, null);
        h(cookiesMap);
        J(cookiesMap, true);
        f314207q.evictAll();
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
            C();
        }
    }

    CookiesMap g(Intent intent, AppRuntime appRuntime) {
        CookiesMap cookiesMap = new CookiesMap();
        if (!m(cookiesMap, appRuntime)) {
            QLog.e("SwiftBrowserCookieMonster", 1, "setCookies error: collectUinRelatedCookies return false.");
        }
        if (appRuntime != null && appRuntime.isLogin()) {
            k(intent, cookiesMap, appRuntime);
            j(cookiesMap, appRuntime);
        } else {
            l(cookiesMap, appRuntime);
        }
        b(cookiesMap);
        if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && !((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isGrayVersion()) {
            c(cookiesMap);
        }
        i(cookiesMap);
        return cookiesMap;
    }

    void h(CookiesMap cookiesMap) {
        for (String str : this.f314219k.v("skey")) {
            cookiesMap.addCookie(com.tencent.mobileqq.webview.swift.cookie.b.d(str, true), com.tencent.mobileqq.webview.swift.cookie.b.b("skey", "", str, false));
        }
        cookiesMap.addCookie(com.tencent.mobileqq.webview.swift.cookie.b.d("ptlogin2.qq.com", true), com.tencent.mobileqq.webview.swift.cookie.b.b("superkey", "", "ptlogin2.qq.com", true));
        if (!TextUtils.isEmpty(this.f314213e)) {
            cookiesMap.addCookie(this.f314218j, com.tencent.mobileqq.webview.swift.cookie.b.b("p_skey", "", this.f314213e, false));
        }
        if (!TextUtils.isEmpty(this.f314212d)) {
            cookiesMap.addCookie(this.f314218j, com.tencent.mobileqq.webview.swift.cookie.b.b(ICustomDataEditor.STRING_ARRAY_PARAM_2, "", this.f314212d, true));
        }
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserCookieMonster", 2, com.tencent.mobileqq.webview.util.s.d(this.f314218j, new String[0]) + " forbidden login state, remove all login key");
        }
    }

    boolean j(CookiesMap cookiesMap, AppRuntime appRuntime) {
        boolean z16;
        if (!SwiftTicketCookie.t()) {
            O(appRuntime);
        }
        if (TextUtils.isEmpty(SwiftTicketCookie.f314536i)) {
            this.f314223o |= 2;
        } else {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(SwiftTicketCookie.f314536i.getBytes());
                int length = messageDigest.digest().length;
                SwiftTicketCookie.f314537j = Long.toString(((r9[length - 4] & 255) << 24) | ((r9[length - 3] & 255) << 16) | ((r9[length - 2] & 255) << 8) | (r9[length - 1] & 255));
            } catch (NoSuchAlgorithmException e16) {
                if (QLog.isColorLevel()) {
                    QLog.w("SwiftBrowserCookieMonster", 2, "Super key hash failed:" + e16.getMessage());
                }
                this.f314223o |= 4;
            }
            String d16 = com.tencent.mobileqq.webview.swift.cookie.b.d("ptlogin2.qq.com", true);
            cookiesMap.addCookie(d16, com.tencent.mobileqq.webview.swift.cookie.b.b("superkey", SwiftTicketCookie.f314536i, "ptlogin2.qq.com", true));
            cookiesMap.addCookie(d16, com.tencent.mobileqq.webview.swift.cookie.b.b("supertoken", SwiftTicketCookie.f314537j, "ptlogin2.qq.com", false));
            cookiesMap.addCookie(com.tencent.mobileqq.webview.swift.cookie.b.d("ptlogin2.qq.com", false), com.tencent.mobileqq.webview.swift.cookie.b.b("superkey", SwiftTicketCookie.f314536i, "ptlogin2.qq.com", true));
        }
        if (!TextUtils.isEmpty(this.f314212d)) {
            if (TextUtils.isEmpty(SwiftTicketCookie.f314539l)) {
                this.f314223o |= 16;
            } else {
                cookiesMap.addCookie(this.f314218j, com.tencent.mobileqq.webview.swift.cookie.b.b(ICustomDataEditor.STRING_ARRAY_PARAM_2, SwiftTicketCookie.f314539l, this.f314212d, true));
            }
        }
        if (TextUtils.isEmpty(SwiftTicketCookie.f314535h)) {
            this.f314223o |= 1;
        } else {
            for (String str : this.f314219k.v("skey")) {
                if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).a() > 28) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                cookiesMap.addCookie(com.tencent.mobileqq.webview.swift.cookie.b.d(str, z16), com.tencent.mobileqq.webview.swift.cookie.b.c("skey", SwiftTicketCookie.f314535h, str));
            }
        }
        return true;
    }

    void l(CookiesMap cookiesMap, AppRuntime appRuntime) {
        String str;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        String format = simpleDateFormat.format(new Date(System.currentTimeMillis() + 10000));
        String str2 = this.f314218j;
        if (appRuntime == null) {
            str = "login_key_set_failed=NullRuntime; EXPIRES=" + format + ";";
        } else {
            str = "login_key_set_failed=AlreadyLogout; EXPIRES=" + format + ";";
        }
        cookiesMap.addCookie(str2, str);
    }

    boolean m(CookiesMap cookiesMap, AppRuntime appRuntime) {
        String str;
        boolean z16;
        String str2 = "";
        if (appRuntime == null || !appRuntime.isLogin()) {
            str = "";
        } else {
            String e16 = com.tencent.mobileqq.webview.swift.cookie.b.e(appRuntime.getAccount());
            str = appRuntime.getCurrentUid();
            if (TextUtils.isEmpty(str)) {
                QLog.d("SwiftBrowserCookieMonster", 1, "collectUinRelatedCookies uid = " + str);
                if (str == null) {
                    str = "";
                }
            }
            str2 = e16;
        }
        QLog.d("SwiftBrowserCookieMonster", 1, "collectUinRelatedCookies uin: " + str2 + " uid: " + str);
        String d16 = com.tencent.mobileqq.webview.swift.cookie.b.d("ptlogin2.qq.com", true);
        cookiesMap.addCookie(d16, com.tencent.mobileqq.webview.swift.cookie.b.b("superuin", str2, "ptlogin2.qq.com", false));
        for (String str3 : this.f314219k.v("skey")) {
            if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).a() > 28) {
                z16 = false;
            } else {
                z16 = true;
            }
            String d17 = com.tencent.mobileqq.webview.swift.cookie.b.d(str3, z16);
            cookiesMap.addCookie(d17, com.tencent.mobileqq.webview.swift.cookie.b.c("uin", str2, str3));
            d16 = d17;
        }
        if (!TextUtils.isEmpty(this.f314213e)) {
            cookiesMap.addCookie(this.f314218j, com.tencent.mobileqq.webview.swift.cookie.b.c(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, str2, this.f314213e));
        }
        if (!TextUtils.isEmpty(this.f314213e)) {
            cookiesMap.addCookie(this.f314218j, com.tencent.mobileqq.webview.swift.cookie.b.c("p_uid", str, this.f314213e));
        }
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        this.f314223o |= 128;
        if (QLog.isColorLevel()) {
            QLog.d("SwiftBrowserCookieMonster", 2, "cookieUin isempty\uff0curl:" + d16);
        }
        return false;
    }

    public void n(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        G();
        this.f314220l.remove(str);
        f314207q.remove(this.f314218j);
    }

    void o() {
        if (((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion()) {
            QLog.i("SwiftBrowserCookieMonster", 1, "dump cookies include Skey=" + SwiftTicketCookie.f314535h + "; Superkey=" + SwiftTicketCookie.f314536i + "; STwxWeb=" + SwiftTicketCookie.f314538k + "; pSkeyDomain=" + this.f314213e + "; pSkey=" + this.f314209a + "; superToken=" + SwiftTicketCookie.f314537j + "; Pt4TokenDomain=" + this.f314214f + "; Pt4Token=" + this.f314211c + "; a2Domain=" + this.f314212d + ";, a2=" + SwiftTicketCookie.f314539l + ";");
        }
    }

    synchronized void p() {
        if (!this.f314216h) {
            if (this.f314218j.startsWith(HippyBridge.URI_SCHEME_FILE)) {
                this.f314217i = "qq.com";
                this.f314214f = "";
                this.f314212d = "";
                this.f314213e = "";
            } else {
                this.f314217i = com.tencent.mobileqq.webview.util.s.i(this.f314218j);
                this.f314212d = this.f314219k.i0(this.f314218j);
                this.f314213e = this.f314219k.j0(this.f314218j);
                this.f314214f = this.f314219k.k0(this.f314218j);
                if (!((com.tencent.mobileqq.inject.b) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion() && this.f314218j.equals("qqtestproxy.qq.com")) {
                    this.f314213e = null;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("SwiftBrowserCookieMonster", 2, "CookieMonsterTask:topLevelDomain=" + this.f314217i + ",pSkeyDomain=" + this.f314213e + ",Pt4TokenDomain=" + this.f314214f + ",a2Domain=" + this.f314212d);
                }
            }
            this.f314216h = true;
        }
    }

    String q(AppRuntime appRuntime, String str) {
        boolean z16;
        boolean K;
        StringBuilder sb5 = new StringBuilder();
        TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
        String account = appRuntime.getAccount();
        String e16 = com.tencent.mobileqq.webview.swift.cookie.b.e(account);
        String currentUid = appRuntime.getCurrentUid();
        if (TextUtils.isEmpty(currentUid)) {
            QLog.d("SwiftBrowserCookieMonster", 1, "getCookie uid = " + currentUid);
            if (currentUid == null) {
                currentUid = "";
            }
        }
        if (!TextUtils.isEmpty(str)) {
            sb5.append(str);
        }
        com.tencent.mobileqq.webview.swift.cookie.b.h(sb5);
        sb5.append("uin=");
        sb5.append(e16);
        boolean M = M(str, sb5, ticketManager, account);
        this.f314213e = this.f314219k.j0(this.f314218j);
        boolean L = L(appRuntime, str, sb5, e16);
        boolean N = N(appRuntime, str, sb5, currentUid);
        if (!TextUtils.isEmpty(str) && str.contains("pt4_token=;")) {
            if (QLog.isColorLevel()) {
                QLog.d("SwiftBrowserCookieMonster", 2, "not need set pt4_token");
            }
            z16 = N;
            K = false;
        } else {
            z16 = N;
            K = K(appRuntime, str, sb5, false, this.f314219k.k0(this.f314218j));
        }
        if (M || L || K || z16) {
            QLog.i("SwiftBrowserCookieMonster", 1, "getCookie4WebSo: cookie need update: isNeedReplaceSkey(" + M + "), isNeedReplacePskey(" + L + "), isNeedReplaceUskey(" + z16 + "), isNeedReplacePt4Token(" + K + ").");
            String replaceAll = sb5.toString().replaceAll(" ", "");
            StringBuilder sb6 = new StringBuilder();
            if (replaceAll.contains(";")) {
                D(appRuntime, sb6, ticketManager, account, M, L, z16, K, replaceAll.split(";"));
            }
            sb5 = sb6;
        }
        return sb5.toString();
    }

    String w(String str, AppRuntime appRuntime) {
        String str2;
        String str3;
        if (this.f314221m) {
            if (QLog.isColorLevel()) {
                QLog.w("SwiftBrowserCookieMonster", 2, "Cookies is wrong, now do ptlogin jumping!");
            }
            if (!TextUtils.isEmpty(SwiftTicketCookie.f314538k)) {
                boolean g16 = com.tencent.mobileqq.webview.swift.cookie.b.g(appRuntime);
                StringBuilder sb5 = new StringBuilder("http");
                String str4 = "";
                if (!g16) {
                    str2 = "";
                } else {
                    str2 = ReportConstant.COSTREPORT_PREFIX;
                }
                sb5.append(str2);
                sb5.append(QzoneWebViewOfflinePlugin.STR_DEVIDER);
                if (g16) {
                    str4 = "ssl.";
                }
                sb5.append(str4);
                sb5.append("ptlogin2.qq.com/jump?clientuin=");
                sb5.append(appRuntime.getAccount());
                sb5.append("&clientkey=");
                sb5.append(SwiftTicketCookie.f314538k);
                sb5.append("&keyindex=19&pt_mq=");
                if (str.startsWith("https://s.p.qq.com")) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                sb5.append(str3);
                sb5.append("&u1=");
                sb5.append(URLEncoder.encode(str));
                return sb5.toString();
            }
            if (QLog.isColorLevel()) {
                QLog.w("SwiftBrowserCookieMonster", 2, "Can't do ptlogin jumping because STwxWeb is empty!");
            }
            this.f314223o |= 8;
        }
        return str;
    }
}

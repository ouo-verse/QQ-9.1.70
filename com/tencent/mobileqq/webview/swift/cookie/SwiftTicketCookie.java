package com.tencent.mobileqq.webview.swift.cookie;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.webview.swift.injector.i;
import com.tencent.mobileqq.webview.swift.injector.m;
import com.tencent.mobileqq.webview.swift.injector.t;
import com.tencent.mobileqq.webview.swift.injector.u;
import com.tencent.mobileqq.webview.util.s;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.TicketManagerListener;
import mqq.manager.TicketManager;
import oicq.wlogin_sdk.request.Ticket;
import oicq.wlogin_sdk.request.WtTicketPromise;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SwiftTicketCookie {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicInteger f314528a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f314529b;

    /* renamed from: c, reason: collision with root package name */
    private static final byte[] f314530c;

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f314531d;

    /* renamed from: e, reason: collision with root package name */
    private static Boolean f314532e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f314533f;

    /* renamed from: g, reason: collision with root package name */
    private static Boolean f314534g;

    /* renamed from: h, reason: collision with root package name */
    public static volatile String f314535h;

    /* renamed from: i, reason: collision with root package name */
    public static volatile String f314536i;

    /* renamed from: j, reason: collision with root package name */
    public static volatile String f314537j;

    /* renamed from: k, reason: collision with root package name */
    public static volatile String f314538k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile String f314539l;

    /* renamed from: m, reason: collision with root package name */
    private static volatile i f314540m;

    /* renamed from: n, reason: collision with root package name */
    private static volatile g f314541n;

    /* renamed from: o, reason: collision with root package name */
    private static volatile t f314542o;

    /* renamed from: p, reason: collision with root package name */
    private static volatile long f314543p;

    /* renamed from: q, reason: collision with root package name */
    private static volatile long f314544q;

    /* renamed from: r, reason: collision with root package name */
    private static volatile List<String> f314545r;

    /* renamed from: s, reason: collision with root package name */
    public static int f314546s;

    /* renamed from: t, reason: collision with root package name */
    public static int f314547t;

    /* renamed from: u, reason: collision with root package name */
    public static int f314548u;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements u {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.u
        public void onFail(int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d("AuthorizeConfig", 1, "preGetStweb onFail result = " + i3 + ", errMSg = " + str);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.u
        public void onSuccess(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                QLog.d("AuthorizeConfig", 1, "preGetStweb onSuccess sig length = " + str.length());
                SwiftTicketCookie.f314538k = str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements u {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f314552a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f314553b;

        b(String[] strArr, CountDownLatch countDownLatch) {
            this.f314552a = strArr;
            this.f314553b = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) strArr, (Object) countDownLatch);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.u
        public void onFail(int i3, @NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
                return;
            }
            QLog.e("SwiftBrowserCookieMonster", 1, "getSuperKey failed:" + i3 + ", msg:" + str);
            this.f314553b.countDown();
            SwiftTicketCookie.k(1);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.u
        public void onSuccess(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            this.f314552a[0] = str;
            SwiftTicketCookie.f314536i = str;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getSuperKey onSuccess ");
            sb5.append(s.c(" superkey=" + str, new String[0]));
            QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
            this.f314553b.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class c implements com.tencent.mobileqq.webview.swift.injector.g {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f314554a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f314555b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f314556c;

        c(String[] strArr, String str, CountDownLatch countDownLatch) {
            this.f314554a = strArr;
            this.f314555b = str;
            this.f314556c = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, strArr, str, countDownLatch);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.e("SwiftBrowserCookieMonster", 1, "getPt4Token failed: " + str);
            this.f314556c.countDown();
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NonNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
                return;
            }
            this.f314554a[0] = map.get(this.f314555b);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("getPt4Token onSuccess ");
            sb5.append(s.c(" pt4Token=" + this.f314554a[0], new String[0]));
            QLog.d("SwiftBrowserCookieMonster", 1, sb5.toString());
            this.f314556c.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class d implements WtTicketPromise {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f314557a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f314558b;

        d(String str, long j3) {
            this.f314557a = str;
            this.f314558b = j3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Long.valueOf(j3));
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Done(Ticket ticket) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ticket);
                return;
            }
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("pt4_token response received for ");
                sb5.append(this.f314557a);
                sb5.append(", cost=");
                sb5.append(System.currentTimeMillis() - this.f314558b);
                if (ticket != null) {
                    str = "";
                } else {
                    str = ". But result was null!";
                }
                sb5.append(str);
                QLog.d("SwiftBrowserCookieMonster", 2, sb5.toString());
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Failed(ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("SwiftBrowserCookieMonster", 2, "Get pt4_token failed for " + this.f314557a + " because " + errMsg + ", cost=" + (System.currentTimeMillis() - this.f314558b));
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Timeout(ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) errMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.w("SwiftBrowserCookieMonster", 2, "Get pt4_token timeout for " + this.f314557a + " because " + errMsg + ", cost=" + (System.currentTimeMillis() - this.f314558b));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class e implements com.tencent.mobileqq.webview.swift.injector.g {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onFail(@NonNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QLog.i("SwiftBrowserCookieMonster", 1, "preGetKeyInPreloadService [pskey] failed " + str + ", next");
            SwiftTicketCookie.z(SwiftTicketCookie.f314545r);
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.g
        public void onSuccess(@NonNull Map<String, String> map) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) map);
            } else {
                QLog.i("SwiftBrowserCookieMonster", 1, "preGetKeyInPreloadService [pskey] suc. next");
                SwiftTicketCookie.z(SwiftTicketCookie.f314545r);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class f implements WtTicketPromise {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.webview.swift.injector.g f314559a;

        f(com.tencent.mobileqq.webview.swift.injector.g gVar) {
            this.f314559a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) gVar);
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Done(Ticket ticket) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) ticket);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService [pt4token] : Done");
            }
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f314559a;
            if (gVar != null) {
                gVar.onSuccess(new HashMap());
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Failed(ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) errMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService [pt4token] failed " + errMsg);
            }
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f314559a;
            if (gVar != null) {
                gVar.onFail(errMsg.getMessage());
            }
        }

        @Override // oicq.wlogin_sdk.request.WtTicketPromise
        public void Timeout(ErrMsg errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) errMsg);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService [pt4token] timeout!" + errMsg);
            }
            com.tencent.mobileqq.webview.swift.injector.g gVar = this.f314559a;
            if (gVar != null) {
                gVar.onFail(errMsg.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class g implements i.a {
        static IPatchRedirector $redirector_;

        g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.i.a
        public void a() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - SwiftTicketCookie.f314543p > 600000) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 1, "invoke onPskeyChanged shouldRefresh: " + z16);
            }
            if (z16) {
                SwiftTicketCookie.f314543p = currentTimeMillis;
                SwiftBrowserCookieMonster.H();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class h implements t {
        static IPatchRedirector $redirector_;

        h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.webview.swift.injector.t
        public void onChange(long j3) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, j3);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (SwiftTicketCookie.f314544q == 0) {
                SwiftTicketCookie.f314544q = currentTimeMillis;
            }
            if (currentTimeMillis - SwiftTicketCookie.f314544q > 30000 && SwiftTicketCookie.f314528a.get() != 2) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 1, "invoke onThirdSigChanged shouldRefresh: " + z16);
            }
            if (z16) {
                SwiftTicketCookie.f314544q = currentTimeMillis;
                SwiftBrowserCookieMonster.H();
                SwiftTicketCookie.y(MobileQQ.sMobileQQ.peekAppRuntime(), new Intent());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class i implements TicketManagerListener {
        static IPatchRedirector $redirector_;

        i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // mqq.app.TicketManagerListener
        public void onTicketRefreshed() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i("SwiftBrowserCookieMonster", 1, "TicketManager invoke onTicketRefreshed");
            if (!((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isDebugVersion() && !((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isGrayVersion()) {
                SwiftBrowserCookieMonster.H();
            }
            SwiftTicketCookie.y(MobileQQ.sMobileQQ.peekAppRuntime(), new Intent());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49348);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f314528a = new AtomicInteger(1);
        f314529b = new byte[0];
        f314530c = new byte[0];
        f314531d = new byte[0];
        f314532e = null;
        f314533f = null;
        f314534g = null;
        f314545r = new ArrayList();
        f314546s = 0;
        f314547t = 1;
        f314548u = 2;
    }

    public SwiftTicketCookie() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void A(AppRuntime appRuntime, String str, @NonNull List<String> list, com.tencent.mobileqq.webview.swift.injector.g gVar) {
        boolean H = H();
        if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "preGetKeyInPreloadService [pt4token] isNew=" + H + " callback=" + gVar);
        }
        if (H) {
            ((com.tencent.mobileqq.webview.swift.injector.s) aa.k(com.tencent.mobileqq.webview.swift.injector.s.class)).b(appRuntime, 16, (ArrayList) list, gVar);
            return;
        }
        String[] strArr = new String[list.size()];
        Iterator<String> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            strArr[i3] = String.format("(%d)%s", 134217728, it.next());
            i3++;
        }
        ((TicketManager) appRuntime.getManager(2)).getPskey(str, 16L, strArr, new f(gVar));
    }

    private static void B(AppRuntime appRuntime) {
        ((com.tencent.mobileqq.webview.swift.injector.s) aa.k(com.tencent.mobileqq.webview.swift.injector.s.class)).c(appRuntime, 16, new a());
    }

    static void C() {
        if (f314541n == null) {
            synchronized (f314530c) {
                if (f314541n == null) {
                    f314541n = new g();
                    ((com.tencent.mobileqq.webview.swift.injector.i) aa.k(com.tencent.mobileqq.webview.swift.injector.i.class)).e(f314541n);
                }
            }
        }
    }

    static void D() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        if ((I() || H() || H()) && f314542o == null) {
            synchronized (f314531d) {
                if (f314542o == null) {
                    f314542o = new h();
                    ((com.tencent.mobileqq.webview.swift.injector.s) aa.k(com.tencent.mobileqq.webview.swift.injector.s.class)).a(peekAppRuntime, f314542o);
                }
            }
        }
    }

    public static void E() {
        if (f314540m == null || f314541n == null || f314542o == null) {
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    SwiftTicketCookie.F();
                    SwiftTicketCookie.C();
                    SwiftTicketCookie.D();
                }
            }, null, false);
        }
    }

    static void F() {
        AppRuntime waitAppRuntime;
        TicketManager ticketManager;
        if (f314540m == null) {
            synchronized (f314529b) {
                if (f314540m == null && (waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null)) != null && (ticketManager = (TicketManager) waitAppRuntime.getManager(2)) != null) {
                    f314540m = new i();
                    ticketManager.registTicketManagerListener(f314540m);
                }
            }
        }
    }

    public static void G() {
        TicketManager ticketManager;
        if (f314540m != null) {
            synchronized (f314529b) {
                if (f314540m != null) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null && (ticketManager = (TicketManager) peekAppRuntime.getManager(2)) != null) {
                        ticketManager.unregistTicketManagerListener(f314540m);
                    }
                    f314540m = null;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).isSwitchOn("102764", false) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean H() {
        boolean z16;
        if (f314534g == null) {
            if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                z16 = false;
            }
            z16 = true;
            f314534g = Boolean.valueOf(z16);
        }
        return f314534g.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0022, code lost:
    
        if (((com.tencent.mobileqq.webview.swift.injector.c) com.tencent.mobileqq.webview.swift.injector.aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).isSwitchOn("102430", false) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean I() {
        boolean z16;
        if (f314532e == null) {
            if (((com.tencent.mobileqq.inject.b) aa.k(com.tencent.mobileqq.inject.b.class)).isPublicVersion()) {
                z16 = false;
            }
            z16 = true;
            f314532e = Boolean.valueOf(z16);
        }
        return f314532e.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void k(final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.cookie.f
            @Override // java.lang.Runnable
            public final void run() {
                SwiftTicketCookie.u(i3);
            }
        }, 16, null, true);
    }

    public static void l(List<String> list, com.tencent.mobileqq.webview.swift.component.aa aaVar) {
        ThreadManagerV2.post(new Runnable(list, aaVar) { // from class: com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ List f314549d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.webview.swift.component.aa f314550e;

            {
                this.f314549d = list;
                this.f314550e = aaVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) list, (Object) aaVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    SwiftTicketCookie.m(this.f314549d, this.f314550e);
                }
            }
        }, 5, null, false);
    }

    static void m(List<String> list, com.tencent.mobileqq.webview.swift.component.aa aaVar) {
        Set<String> v3 = AuthorizeConfig.y().v("pskey");
        for (String str : list) {
            if (!v3.contains(str)) {
                if (QLog.isColorLevel()) {
                    QLog.i("SwiftBrowserCookieMonster", 2, str + " doesn't need pskey any more,so delete! ");
                }
                aaVar.a(str, "p_skey");
            }
        }
    }

    public static boolean n(AppRuntime appRuntime) {
        if (f314528a.compareAndSet(1, 2)) {
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.webview.swift.cookie.SwiftTicketCookie.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AppRuntime.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (SwiftTicketCookie.f314528a.get() == 2) {
                        SwiftTicketCookie.o(AppRuntime.this);
                    }
                }
            };
            if (Looper.getMainLooper() == Looper.myLooper()) {
                ThreadManagerV2.postImmediately(runnable, null, false);
            } else {
                runnable.run();
            }
        }
        return true;
    }

    static void o(AppRuntime appRuntime) {
        String realSkey;
        if (appRuntime != null && appRuntime.isLogin()) {
            if (QLog.isColorLevel()) {
                QLog.i("SwiftBrowserCookieMonster", 2, "get common keys: " + appRuntime.getAccount());
            }
            TicketManager ticketManager = (TicketManager) appRuntime.getManager(2);
            String account = appRuntime.getAccount();
            if (TextUtils.isEmpty(f314535h)) {
                if (((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).u()) {
                    realSkey = s.g(account);
                } else {
                    realSkey = ticketManager.getRealSkey(account);
                }
                f314535h = realSkey;
                if (!TextUtils.isEmpty(f314535h)) {
                    QLog.i("SwiftBrowserCookieMonster", 1, s.c("skey=" + f314535h, new String[0]));
                } else {
                    QLog.e("SwiftBrowserCookieMonster", 1, "skey is null!");
                }
            }
            f314536i = r(appRuntime);
            if (TextUtils.isEmpty(f314539l)) {
                f314539l = ticketManager.getA2(account);
            }
            B(appRuntime);
            AtomicInteger atomicInteger = f314528a;
            synchronized (atomicInteger) {
                if (t()) {
                    atomicInteger.compareAndSet(2, 3);
                } else {
                    atomicInteger.compareAndSet(2, 1);
                }
                atomicInteger.notifyAll();
            }
        }
    }

    public static String p(AppRuntime appRuntime, String str) {
        return q(appRuntime, str, f314547t);
    }

    public static String q(AppRuntime appRuntime, String str, int i3) {
        int i16;
        if (appRuntime != null && !TextUtils.isEmpty(str)) {
            if (H()) {
                i16 = f314546s;
            } else {
                i16 = i3;
            }
            String[] strArr = {null};
            long currentTimeMillis = System.currentTimeMillis();
            if (i16 == f314546s) {
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ArrayList<String> arrayList = new ArrayList<>(1);
                arrayList.add(str);
                ((com.tencent.mobileqq.webview.swift.injector.s) aa.k(com.tencent.mobileqq.webview.swift.injector.s.class)).b(appRuntime, 16, arrayList, new c(strArr, str, countDownLatch));
                try {
                    countDownLatch.await(200L, TimeUnit.MILLISECONDS);
                } catch (InterruptedException unused) {
                    QLog.e("SwiftBrowserCookieMonster", 1, "getPt4Token latch await timeout.");
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("SwiftBrowserCookieMonster", 1, "getPt4Token latch await cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                }
            } else if (i16 == f314548u) {
                strArr[0] = ((TicketManager) appRuntime.getManager(2)).getPt4Token(appRuntime.getAccount(), str);
            } else {
                Ticket pskey = ((TicketManager) appRuntime.getManager(2)).getPskey(appRuntime.getAccount(), 16L, new String[]{String.format("(%d)%s", 134217728, str)}, new d(str, currentTimeMillis));
                if (pskey != null) {
                    strArr[0] = pskey.getPt4Token(str);
                }
            }
            s(appRuntime, str, "pt4_token");
            if (QLog.isColorLevel()) {
                if (!TextUtils.isEmpty(strArr[0])) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Get pt4_token cache success for ");
                    sb5.append(str);
                    sb5.append(", token is: ");
                    sb5.append(s.c("pt4_token=" + strArr[0], new String[0]));
                    sb5.append(", way=");
                    sb5.append(i16);
                    QLog.d("SwiftBrowserCookieMonster", 2, sb5.toString());
                } else {
                    QLog.d("SwiftBrowserCookieMonster", 2, "Get pt4_token cache failed for " + str + ", way=" + i16);
                }
            }
            String str2 = strArr[0];
            if (str2 == null) {
                return "";
            }
            return str2;
        }
        QLog.d("SwiftBrowserCookieMonster", 1, "getPt4Token app or domain invalid return. domain: " + str);
        return "";
    }

    public static String r(AppRuntime appRuntime) {
        String[] strArr = {""};
        CountDownLatch countDownLatch = new CountDownLatch(1);
        long currentTimeMillis = System.currentTimeMillis();
        if (QLog.isDevelopLevel()) {
            QLog.e("SwiftBrowserCookieMonster", 1, "getSuperKey start");
        }
        ((com.tencent.mobileqq.webview.swift.injector.s) aa.k(com.tencent.mobileqq.webview.swift.injector.s.class)).d(appRuntime, 16, new b(strArr, countDownLatch));
        try {
            countDownLatch.await(15000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            QLog.e("SwiftBrowserCookieMonster", 1, "getSuperKey latch await timeout.");
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("SwiftBrowserCookieMonster", 1, "getSuperKey latch await cost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        }
        if (TextUtils.isEmpty(strArr[0])) {
            k(2);
        }
        return strArr[0];
    }

    private static void s(final AppRuntime appRuntime, final String str, final String str2) {
        Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.webview.swift.cookie.d
            @Override // java.lang.Runnable
            public final void run() {
                SwiftTicketCookie.v(AppRuntime.this, str, str2);
            }
        };
        if (Looper.getMainLooper() != Looper.myLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.excute(runnable, 16, null, true);
        }
    }

    public static boolean t() {
        if (!TextUtils.isEmpty(f314535h) && !TextUtils.isEmpty(f314536i) && !TextUtils.isEmpty(f314538k) && !TextUtils.isEmpty(f314539l)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(int i3) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("errCode", "" + i3);
        hashMap.put("tokenType", "superkey");
        ((m) aa.k(m.class)).collectPerformance("", "actWVThirdSigError", true, 0L, 0L, hashMap, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(AppRuntime appRuntime, String str, String str2) {
        new com.tencent.mobileqq.webview.swift.component.aa(appRuntime.getAppRuntime("modular_web")).c(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(AppRuntime appRuntime, Intent intent) {
        long currentTimeMillis = System.currentTimeMillis();
        x(appRuntime, intent);
        if (QLog.isColorLevel()) {
            QLog.i("SwiftBrowserCookieMonster", 2, "Web_qqbrowser_pre_get_key, cost=" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:5:0x002a A[Catch: Exception -> 0x0023, TryCatch #0 {Exception -> 0x0023, blocks: (B:47:0x0008, B:51:0x0011, B:5:0x002a, B:7:0x0030, B:9:0x0054, B:11:0x005a, B:13:0x0060, B:14:0x007c, B:16:0x008e, B:17:0x0092, B:19:0x0098, B:21:0x00bc, B:22:0x00bf, B:24:0x00c5, B:25:0x00cd, B:27:0x00d3, B:28:0x00e6, B:39:0x0080, B:41:0x0086, B:42:0x00da, B:44:0x00e0), top: B:46:0x0008 }] */
    @SuppressLint({"DefaultLocale"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void x(AppRuntime appRuntime, Intent intent) {
        boolean z16;
        String str;
        int i3 = 0;
        if (appRuntime != null) {
            try {
                if (appRuntime.isLogin()) {
                    z16 = true;
                    if (intent != null) {
                        z16 = true ^ intent.getBooleanExtra("avoidLoginWeb", false);
                        str = intent.getStringExtra("url");
                    } else {
                        str = null;
                    }
                    if (!z16) {
                        if (TextUtils.isEmpty(str)) {
                            AuthorizeConfig y16 = AuthorizeConfig.y();
                            String account = appRuntime.getAccount();
                            Set<String> v3 = y16.v("pt4_token");
                            com.tencent.mobileqq.webview.swift.component.aa aaVar = new com.tencent.mobileqq.webview.swift.component.aa(appRuntime.getAppRuntime("modular_web"));
                            List<String> b16 = aaVar.b("p_skey");
                            if (b16 != null && b16.size() > 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("SwiftBrowserCookieMonster", 2, "p_skey top hosts: " + TextUtils.join(", ", b16));
                                }
                                l(b16, aaVar);
                            } else if (QLog.isColorLevel()) {
                                QLog.i("SwiftBrowserCookieMonster", 2, "no any top hosts for p_skey");
                            }
                            if (b16 != null) {
                                i3 = b16.size();
                            }
                            if (QLog.isColorLevel()) {
                                QLog.i("SwiftBrowserCookieMonster", 2, "now preGetPt4tokens: " + v3.size() + ", preGetPskeys:" + i3);
                            }
                            if (i3 > 0) {
                                z(b16);
                            }
                            if (v3.size() > 0) {
                                A(appRuntime, account, new ArrayList(v3), null);
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("SwiftBrowserCookieMonster", 2, "Batch load pt4_token when process preload");
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("SwiftBrowserCookieMonster", 2, "Get tickets when load url");
                        }
                        n(appRuntime);
                        return;
                    }
                    return;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SwiftBrowserCookieMonster", 2, "preGetKey exception:" + e16.toString());
                }
                e16.printStackTrace();
                return;
            }
        }
        str = null;
        z16 = false;
        if (!z16) {
        }
    }

    public static void y(final AppRuntime appRuntime, final Intent intent) {
        if (appRuntime == null) {
            return;
        }
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.webview.swift.cookie.e
            @Override // java.lang.Runnable
            public final void run() {
                SwiftTicketCookie.w(AppRuntime.this, intent);
            }
        }, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z(List<String> list) {
        if (list != null && list.size() != 0) {
            ArrayList arrayList = new ArrayList(20);
            ArrayList arrayList2 = new ArrayList();
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (i3 < 20) {
                    arrayList.add(list.get(i3));
                } else {
                    arrayList2.add(list.get(i3));
                }
            }
            f314545r = arrayList2;
            com.tencent.mobileqq.webview.swift.cookie.a.a(arrayList, false, MobileQQ.sMobileQQ.peekAppRuntime(), new e());
        }
    }
}

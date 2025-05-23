package com.tencent.qimei.ai;

import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.aa.b;
import com.tencent.qimei.ai.d;
import com.tencent.qimei.al.a;
import com.tencent.qimei.ao.a;
import com.tencent.qimei.as.a;
import com.tencent.qimei.log.IObservableLog;
import com.tencent.qimei.report.beat.BeatType;
import com.tencent.qimei.sdk.IAsyncQimeiListener;
import com.tencent.qimei.sdk.IQimeiSDK;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.sdk.QimeiSDK;
import com.tencent.qimei.sdk.debug.IDebugger;
import com.tencent.qimei.shell.sdkinfo.UserInfoType;
import com.tencent.qimei.strategy.terminal.ITerminalStrategy;
import com.tencent.qimei.uin.U;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e implements IQimeiSDK, com.tencent.qimei.ap.b, com.tencent.qimei.ap.c, com.tencent.qimei.y.c, com.tencent.qimei.ar.f, d.c {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final Map<String, e> f343020j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f343021k;

    /* renamed from: a, reason: collision with root package name */
    public final List<IAsyncQimeiListener> f343022a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f343023b;

    /* renamed from: c, reason: collision with root package name */
    public final IDebugger f343024c;

    /* renamed from: d, reason: collision with root package name */
    public final String f343025d;

    /* renamed from: e, reason: collision with root package name */
    public Context f343026e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f343027f;

    /* renamed from: g, reason: collision with root package name */
    public String f343028g;

    /* renamed from: h, reason: collision with root package name */
    public String f343029h;

    /* renamed from: i, reason: collision with root package name */
    public long f343030i;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IAsyncQimeiListener f343031a;

        public a(IAsyncQimeiListener iAsyncQimeiListener) {
            this.f343031a = iAsyncQimeiListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, (Object) iAsyncQimeiListener);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Qimei qimei = e.this.getQimei();
            if (qimei != null && !qimei.isEmpty()) {
                this.f343031a.onQimeiDispatch(qimei);
            } else {
                e.this.a(this.f343031a);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f343033a;

        /* renamed from: b, reason: collision with root package name */
        public final String f343034b;

        public b(Runnable runnable, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) runnable, (Object) str);
            } else {
                this.f343033a = runnable;
                this.f343034b = str;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f343033a != null && !TextUtils.isEmpty(this.f343034b)) {
                if (com.tencent.qimei.an.a.d(this.f343034b)) {
                    com.tencent.qimei.t.a.a().a(this.f343033a);
                }
                com.tencent.qimei.t.a.a().a(TimeUnit.HOURS.toMillis(24L) + TimeUnit.SECONDS.toMillis(5L), this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f343020j = new ConcurrentHashMap();
        String a16 = com.tencent.qimei.r.a.a(19);
        if (a16.equals("") || a16.length() != 30) {
            a16 = QimeiSDK.class.getCanonicalName();
        }
        f343021k = a16;
    }

    public e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343022a = Collections.synchronizedList(new ArrayList(8));
        this.f343023b = new ConcurrentHashMap<>();
        this.f343026e = null;
        this.f343027f = false;
        this.f343028g = "";
        this.f343029h = "";
        this.f343025d = str;
        this.f343024c = new com.tencent.qimei.aj.a(str);
    }

    @Override // com.tencent.qimei.ap.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 23)) ? this.f343028g : (String) iPatchRedirector.redirect((short) 23, (Object) this);
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK addUserId(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (IQimeiSDK) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        }
        this.f343023b.put(str, str2);
        return this;
    }

    @Override // com.tencent.qimei.ap.b
    public String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (String) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.f343029h;
    }

    @Override // com.tencent.qimei.y.c
    public void c() {
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        synchronized (com.tencent.qimei.u.c.class) {
            cVar = com.tencent.qimei.u.c.f343390p;
        }
        cVar.f();
        k();
        com.tencent.qimei.au.a a16 = com.tencent.qimei.au.a.a(this.f343025d);
        synchronized (com.tencent.qimei.u.c.class) {
        }
        a16.f343149b.put(UserInfoType.TYPE_NET_WORK_TYPE.toString(), cVar.e());
        com.tencent.qimei.ah.a.a(this.f343025d, BeatType.NET_CHANGE, com.tencent.qimei.f.a.a());
    }

    @Override // com.tencent.qimei.y.c
    public void d() {
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        synchronized (com.tencent.qimei.u.c.class) {
            cVar = com.tencent.qimei.u.c.f343390p;
        }
        cVar.f();
    }

    @Override // com.tencent.qimei.ap.c
    @Nullable
    public Context e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (Context) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        if (this.f343026e == null) {
            com.tencent.qimei.ad.c.a("SDK_INIT", "Context has been destroyed!!", new Object[0]);
        }
        return this.f343026e;
    }

    @Override // com.tencent.qimei.ap.b
    public String f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (String) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        Qimei qimei = getQimei();
        if (qimei == null) {
            return "";
        }
        return qimei.getQimei16();
    }

    @Override // com.tencent.qimei.ap.b
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        synchronized (this.f343022a) {
            Qimei qimei = getQimei();
            if (qimei != null && !qimei.isEmpty()) {
                Iterator<IAsyncQimeiListener> it = this.f343022a.iterator();
                while (it.hasNext()) {
                    it.next().onQimeiDispatch(qimei);
                }
                this.f343022a.clear();
            }
        }
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public String getBeaconTicket() {
        boolean z16;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        if (!j()) {
            return "";
        }
        String str = this.f343025d;
        if (com.tencent.qimei.an.a.c(str)) {
            return null;
        }
        com.tencent.qimei.ai.b a16 = com.tencent.qimei.ai.b.a(str);
        if (a16.f342997d == 0) {
            a16.f342997d = System.currentTimeMillis();
        }
        if (!TextUtils.isEmpty(a16.f342996c)) {
            sb5 = new StringBuilder();
        } else {
            String d16 = com.tencent.qimei.aa.f.b(a16.f342994a).d(TtmlNode.TAG_TT);
            a16.f342996c = d16;
            if (!TextUtils.isEmpty(d16)) {
                sb5 = new StringBuilder();
            } else {
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return "";
                }
                a16.f342996c = a16.b();
                return a16.f342996c + a16.f342997d;
            }
        }
        sb5.append(a16.f342996c);
        sb5.append(a16.f342997d);
        return sb5.toString();
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IDebugger getDebugger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (IDebugger) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.f343024c;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public Qimei getQimei() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Qimei) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        if (j()) {
            return com.tencent.qimei.an.a.a(this.f343025d);
        }
        return null;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public String getSdkVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return "2.1.2.132";
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public ITerminalStrategy getStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (ITerminalStrategy) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return com.tencent.qimei.ar.a.a(this.f343025d).f343094b;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public String getToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        if (!j()) {
            com.tencent.qimei.ad.c.a("SDK_INIT", "getToken fail, sdk not init!", new Object[0]);
            k.b(this.f343025d).f343046e = "1";
            return "";
        }
        return k.b(this.f343025d).a();
    }

    @Override // com.tencent.qimei.ap.b
    public String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return new JSONObject(this.f343023b).toString();
    }

    @Override // com.tencent.qimei.ap.b
    public String i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (String) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        Qimei qimei = getQimei();
        if (qimei == null) {
            return "";
        }
        return qimei.getQimei36();
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public synchronized boolean init(Context context) {
        boolean z16;
        boolean exists;
        boolean exists2;
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context)).booleanValue();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f343027f) {
            return true;
        }
        com.tencent.qimei.ad.c.b("SDK_INIT", "\n\n\n\n< Your AppKey is: %s SDK_VERSION is: %s>\n", this.f343025d, "2.1.2.132");
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            this.f343026e = applicationContext;
            if (applicationContext == null) {
                this.f343026e = context;
            }
        }
        synchronized (this) {
            TextUtils.isEmpty(this.f343025d);
            if (this.f343026e == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                com.tencent.qimei.ad.c.a("SDK_INIT", "appkey:%s parameter exception", this.f343025d);
                return false;
            }
            ConcurrentHashMap<String, com.tencent.qimei.aq.a> concurrentHashMap = com.tencent.qimei.ao.a.f343086a;
            a.C9309a.f343087a.getClass();
            ConcurrentHashMap<String, com.tencent.qimei.aq.a> concurrentHashMap2 = com.tencent.qimei.ao.a.f343086a;
            concurrentHashMap2.put("SdkInfo", this);
            concurrentHashMap2.put("BizInfo" + this.f343025d, this);
            Context context2 = this.f343026e;
            if (context2 != null) {
                String str = f343021k;
                File filesDir = context2.getFilesDir();
                if (!filesDir.exists()) {
                    exists = false;
                } else {
                    exists = new File(filesDir, str).exists();
                }
                if (!exists) {
                    File filesDir2 = context2.getFilesDir();
                    if (!filesDir2.exists()) {
                        exists2 = false;
                    } else {
                        exists2 = new File(filesDir2, "com.ola.star.sdk.OstarSDK").exists();
                    }
                    if (exists2) {
                        com.tencent.qimei.al.a.a(context2, str, "com.ola.star.sdk.OstarSDK");
                    }
                }
            }
            com.tencent.qimei.al.a aVar = a.C9307a.f343059a;
            String str2 = this.f343025d;
            Context context3 = this.f343026e;
            String str3 = f343021k;
            String str4 = com.tencent.qimei.ar.a.a(str2).f343094b.f343141m;
            boolean z17 = com.tencent.qimei.ar.a.a(this.f343025d).f343094b.f343138j;
            synchronized (com.tencent.qimei.al.a.class) {
                aVar.a(str2, context3, str3, str4, z17);
            }
            com.tencent.qimei.aa.f b16 = com.tencent.qimei.aa.f.b(this.f343025d);
            Context context4 = this.f343026e;
            b16.f342909e = str3;
            b16.f342907c = context4;
            b.a.f342891a.f342890b = context4;
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            cVar.getClass();
            if (U.a(com.tencent.qimei.r.a.a(23)).equals("Androws")) {
                if (!this.f343027f) {
                    this.f343029h = "Androws";
                }
                this.f343023b.put("guid", U.a(com.tencent.qimei.r.a.a(24)));
                this.f343023b.put("winQm", U.a(com.tencent.qimei.r.a.a(22)));
            }
            if (U.a(com.tencent.qimei.r.a.a(23)).equals("Syzs")) {
                if (!this.f343027f) {
                    this.f343029h = "Syzs";
                }
                this.f343023b.put("guid", U.a(com.tencent.qimei.r.a.a(24)));
                this.f343023b.put("winQm", U.a(com.tencent.qimei.r.a.a(22)));
            }
            com.tencent.qimei.t.a.a().a(new f(this));
            com.tencent.qimei.t.a.a().a(new com.tencent.qimei.ae.d(com.tencent.qimei.ae.a.a(this.f343025d), new g(this)));
            com.tencent.qimei.ad.c.b("SDK_INIT", "\n\n\n\n\t\t\t\t ----- initialization finished! From appkey:%s ----- \n\n\n\n\t\t\t\t", this.f343025d);
            this.f343027f = true;
            this.f343030i = SystemClock.uptimeMillis() - uptimeMillis;
            return true;
        }
    }

    public final synchronized boolean j() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        synchronized (this) {
            TextUtils.isEmpty(this.f343025d);
            if (this.f343026e == null) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16 && this.f343027f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                com.tencent.qimei.ad.c.a("SDK_INIT", "appkey:%s uninitialized", this.f343025d);
            }
        }
        return z17;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k() {
        boolean z16;
        d dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        String str = this.f343025d;
        ConcurrentHashMap<String, String> concurrentHashMap = com.tencent.qimei.an.a.f343079a;
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(str).f343094b;
        aVar.getClass();
        int i3 = 0;
        if (com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343112j, aVar.f343146r).booleanValue()) {
            com.tencent.qimei.ad.c.b("SDK_INIT \uff5c QM", "force update Qm", new Object[0]);
        } else {
            Qimei a16 = com.tencent.qimei.an.a.a(str);
            if (a16 != null && !a16.isEmpty()) {
                z16 = false;
                String str2 = this.f343025d;
                synchronized (d.class) {
                    Map<String, d> map = d.f343006i;
                    dVar = map.get(str2);
                    if (dVar == null) {
                        dVar = new d(str2);
                        dVar.f343008a = this;
                        map.put(str2, dVar);
                    }
                }
                if (z16) {
                    com.tencent.qimei.t.a.a().a(dVar);
                } else if (com.tencent.qimei.an.a.b(this.f343025d)) {
                    if (com.tencent.qimei.an.a.a(this.f343025d, this.f343026e)) {
                        i3 = com.tencent.qimei.ai.b.a(this.f343025d).f342998e;
                    }
                    com.tencent.qimei.t.a.a().a(i3, dVar);
                } else {
                    com.tencent.qimei.ad.c.b("SDK_INIT \uff5c QM", "no need to update QM(appKey: %s)", this.f343025d);
                    g();
                }
                com.tencent.qimei.t.a.a().a(TimeUnit.HOURS.toMillis(24L) + TimeUnit.SECONDS.toMillis(5L), new b(dVar, this.f343025d));
                return;
            }
            com.tencent.qimei.ad.c.b("SDK_INIT \uff5c QM", "QM is null,need update Qm", new Object[0]);
        }
        z16 = true;
        String str22 = this.f343025d;
        synchronized (d.class) {
        }
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setAppVersion(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (IQimeiSDK) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            com.tencent.qimei.u.a.f343384c = str;
        }
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setChannelID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (IQimeiSDK) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        this.f343028g = str;
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public synchronized IQimeiSDK setLogAble(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (IQimeiSDK) iPatchRedirector.redirect((short) 11, (Object) this, z16);
        }
        synchronized (com.tencent.qimei.ad.a.class) {
            Log.i("Q_LOG", "logAble: " + z16);
            com.tencent.qimei.ad.a.f342941a = z16;
        }
        synchronized (com.tencent.qimei.ad.a.class) {
            com.tencent.qimei.ad.a.f342942b = z16;
        }
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public synchronized IQimeiSDK setLogObserver(IObservableLog iObservableLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (IQimeiSDK) iPatchRedirector.redirect((short) 12, (Object) this, (Object) iObservableLog);
        }
        synchronized (com.tencent.qimei.ad.a.class) {
            com.tencent.qimei.ad.a.f342943c = iObservableLog;
        }
        return this;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public boolean setOstarCached(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public IQimeiSDK setSdkName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (IQimeiSDK) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        if (!this.f343027f) {
            this.f343029h = str;
        }
        return this;
    }

    public final void a(IAsyncQimeiListener iAsyncQimeiListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) iAsyncQimeiListener);
            return;
        }
        synchronized (this.f343022a) {
            if (!this.f343022a.contains(iAsyncQimeiListener)) {
                this.f343022a.add(iAsyncQimeiListener);
            }
        }
    }

    @Override // com.tencent.qimei.sdk.IQimeiSDK
    public synchronized void getQimei(IAsyncQimeiListener iAsyncQimeiListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) iAsyncQimeiListener);
        } else if (j()) {
            com.tencent.qimei.t.a.a().a(new a(iAsyncQimeiListener));
        } else {
            a(iAsyncQimeiListener);
        }
    }
}

package com.tencent.qimei.ai;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qimei.al.a;
import com.tencent.qimei.as.a;
import com.tencent.qimei.sdk.Qimei;
import com.tencent.qimei.uin.U;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static final Map<String, b> f342993h;

    /* renamed from: a, reason: collision with root package name */
    public final String f342994a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Qimei f342995b;

    /* renamed from: c, reason: collision with root package name */
    public String f342996c;

    /* renamed from: d, reason: collision with root package name */
    public long f342997d;

    /* renamed from: e, reason: collision with root package name */
    public int f342998e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f342999f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f343000g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14944);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f342993h = new ConcurrentHashMap();
        }
    }

    public b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f343000g = false;
        this.f342994a = str;
        this.f342996c = "";
        this.f342997d = 0L;
        this.f342998e = 0;
        this.f342999f = false;
        this.f342995b = new Qimei(str);
    }

    public static synchronized b a(String str) {
        b bVar;
        synchronized (b.class) {
            Map<String, b> map = f342993h;
            bVar = map.get(str);
            if (bVar == null) {
                bVar = new b(str);
                bVar.a();
                map.put(str, bVar);
            }
        }
        return bVar;
    }

    public final String b() {
        String a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        com.tencent.qimei.at.a aVar = com.tencent.qimei.ar.a.a(com.tencent.qimei.ae.a.a(this.f342994a).f342945a).f343094b;
        aVar.getClass();
        if (!com.tencent.qimei.as.a.a(a.InterfaceC9310a.f343114l, aVar.f343146r).booleanValue()) {
            a16 = "";
        } else {
            a16 = U.a();
        }
        if (a16 == null) {
            return "";
        }
        return a16;
    }

    public synchronized void a(Qimei qimei) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) qimei);
            return;
        }
        if (qimei != null && !qimei.isEmpty()) {
            this.f342995b = qimei;
        }
    }

    public void a() {
        byte a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (this.f343000g) {
            return;
        }
        synchronized (this) {
            a(com.tencent.qimei.an.a.e(this.f342994a));
            com.tencent.qimei.ak.a a17 = com.tencent.qimei.ak.a.a(this.f342994a);
            if (a17.a()) {
                Qimei qimei = this.f342995b;
                a17.f343053e = new Qimei(qimei.getQimei16(), qimei.getQimei36(), a17.f343049a);
                this.f342995b = new Qimei(this.f342994a);
                String str = this.f342994a;
                if (com.tencent.qimei.u.a.f() && a.C9307a.f343059a.f343058a && (a16 = U.a(str, "")) != 0) {
                    com.tencent.qimei.f.a.a(str, a16);
                }
                com.tencent.qimei.aa.f b16 = com.tencent.qimei.aa.f.b(this.f342994a);
                if (b16.a() != null && com.tencent.qimei.u.a.f()) {
                    b16.f342905a.edit().clear().apply();
                }
            } else {
                Qimei qimei2 = this.f342995b;
                new Qimei();
                if (qimei2 == null || qimei2.isEmpty()) {
                    qimei2 = a.a(this.f342994a);
                    this.f342999f = true;
                }
                if (qimei2 == null) {
                    com.tencent.qimei.ad.c.b("QM", "Local qm cache failed(appKey: %s)", this.f342994a);
                    qimei2 = new Qimei();
                }
                a(qimei2);
                com.tencent.qimei.ad.c.b("QM", "(appKey: %s) Qm load successfully from cache, detail: %s", this.f342994a, this.f342995b.toString());
            }
        }
        this.f343000g = true;
    }
}

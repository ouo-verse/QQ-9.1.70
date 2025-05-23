package com.tencent.msdk.dns.core.rest.share;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.o;
import com.tencent.msdk.dns.core.rest.share.a;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<Runnable> f336347a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, C9221d> f336348b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<o<g>> f336349c;

    /* renamed from: d, reason: collision with root package name */
    private final i<g> f336350d;

    /* renamed from: e, reason: collision with root package name */
    private final com.tencent.msdk.dns.core.h f336351e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f336352d;

        a(String str) {
            this.f336352d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) str);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("Cache of %s(%d) expired", this.f336352d, Integer.valueOf(d.this.f336350d.a().f336255b));
            d.this.f336351e.a(this.f336352d);
            d.this.f336347a.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f336354d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f336355e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ o f336356f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Runnable f336357h;

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class a implements Runnable {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> j3 = com.tencent.msdk.dns.core.g.j(b.this.f336356f);
                e.b(j3);
                if (j3.f336252b.a() || j3.f336252b.e()) {
                    DnsExecutors.f336207b.a(b.this.f336357h);
                    d.this.f336347a.remove(b.this.f336357h);
                }
            }
        }

        b(String str, int i3, o oVar, Runnable runnable) {
            this.f336354d = str;
            this.f336355e = i3;
            this.f336356f = oVar;
            this.f336357h = runnable;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, str, Integer.valueOf(i3), oVar, runnable);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("%.2f of TTL goes by, lookup for %s(%d) async", Float.valueOf(0.75f), this.f336354d, Integer.valueOf(this.f336355e));
            DnsExecutors.f336208c.execute(new a());
            d.this.f336347a.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements com.tencent.msdk.dns.c.c.c {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes21.dex */
        class a implements Runnable {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ o f336361d;

            a(c cVar, o oVar) {
                this.f336361d = oVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) oVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    e.b(com.tencent.msdk.dns.core.g.j(this.f336361d));
                }
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.msdk.dns.c.c.c
        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            com.tencent.msdk.dns.base.log.c.c("Network changed, clear caches", new Object[0]);
            d.this.f336351e.a();
            synchronized (d.this.f336347a) {
                Iterator it = d.this.f336347a.iterator();
                while (it.hasNext()) {
                    DnsExecutors.f336207b.a((Runnable) it.next());
                }
            }
            synchronized (d.this.f336349c) {
                com.tencent.msdk.dns.base.log.c.c("Network changed, enable async lookup", new Object[0]);
                Iterator it5 = d.this.f336349c.iterator();
                while (it5.hasNext()) {
                    o oVar = (o) it5.next();
                    com.tencent.msdk.dns.base.log.c.c("Async lookup for %s start", oVar.f336287b);
                    DnsExecutors.f336208c.execute(new a(this, new o.b(oVar).n(true).f()));
                    it5.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.msdk.dns.core.rest.share.d$d, reason: collision with other inner class name */
    /* loaded from: classes21.dex */
    public static class C9221d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Runnable f336362a;

        /* renamed from: b, reason: collision with root package name */
        public Runnable f336363b;

        C9221d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ C9221d(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(i<g> iVar, com.tencent.msdk.dns.core.h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVar, (Object) hVar);
            return;
        }
        this.f336347a = new Vector();
        this.f336348b = new ConcurrentHashMap();
        this.f336349c = Collections.synchronizedSet(kl3.a.c());
        if (iVar != null) {
            if (hVar != null) {
                this.f336350d = iVar;
                this.f336351e = hVar;
                c();
                return;
            }
            throw new IllegalArgumentException("cache".concat(" can not be null"));
        }
        throw new IllegalArgumentException("dns".concat(" can not be null"));
    }

    private void c() {
        com.tencent.msdk.dns.c.c.d.b(new c());
    }

    public com.tencent.msdk.dns.core.d a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.msdk.dns.core.d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        if (!TextUtils.isEmpty(str)) {
            return this.f336351e.b(str);
        }
        throw new IllegalArgumentException("hostname".concat(" can not be empty"));
    }

    public void d(o<g> oVar, com.tencent.msdk.dns.core.rest.share.h.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) oVar, (Object) aVar);
            return;
        }
        if (oVar != null) {
            if (aVar != null) {
                if (com.tencent.msdk.dns.core.rest.share.h.a.f336369d == aVar) {
                    return;
                }
                String str = oVar.f336287b;
                a.C9218a c9218a = new a.C9218a(aVar.f336372b, aVar.f336371a, aVar.f336373c);
                c9218a.f336319e = 0;
                this.f336351e.a(str, new com.tencent.msdk.dns.core.d(aVar.f336372b, c9218a));
                C9221d c9221d = this.f336348b.get(str);
                a aVar2 = null;
                if (c9221d != null) {
                    Runnable runnable = c9221d.f336362a;
                    if (runnable != null) {
                        DnsExecutors.f336207b.a(runnable);
                        c9221d.f336362a = null;
                    }
                    Runnable runnable2 = c9221d.f336363b;
                    if (runnable2 != null) {
                        DnsExecutors.f336207b.a(runnable2);
                        c9221d.f336363b = null;
                    }
                } else {
                    c9221d = new C9221d(aVar2);
                }
                C9221d c9221d2 = c9221d;
                a aVar3 = new a(str);
                c9221d2.f336362a = aVar3;
                this.f336347a.add(aVar3);
                com.tencent.msdk.dns.base.executor.a aVar4 = DnsExecutors.f336207b;
                aVar4.a(aVar3, aVar.f336373c * 1000);
                if (oVar.f336296k) {
                    int i3 = oVar.f336294i;
                    int i16 = this.f336350d.a().f336255b;
                    if (oVar.f336292g || i3 != i16 || oVar.f336298m) {
                        oVar = new o.b(oVar).l(false).g(i16).n(false).f();
                    }
                    o<g> oVar2 = oVar;
                    this.f336349c.add(oVar2);
                    b bVar = new b(str, i16, oVar2, aVar3);
                    c9221d2.f336363b = bVar;
                    this.f336347a.add(bVar);
                    aVar4.a(bVar, aVar.f336373c * 0.75f * 1000.0f);
                }
                if (!this.f336348b.containsKey(str)) {
                    this.f336348b.put(str, c9221d2);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("rsp".concat(" can not be null"));
        }
        throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
    }
}

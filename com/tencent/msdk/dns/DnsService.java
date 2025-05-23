package com.tencent.msdk.dns;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.a;
import com.tencent.msdk.dns.base.executor.DnsExecutors;
import com.tencent.msdk.dns.core.g;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.j;
import com.tencent.msdk.dns.core.o;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class DnsService {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static Context f336156a = null;

    /* renamed from: b, reason: collision with root package name */
    private static com.tencent.msdk.dns.a f336157b = null;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f336158c = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements j {
        static IPatchRedirector $redirector_;

        a(com.tencent.msdk.dns.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar);
            }
        }

        @Override // com.tencent.msdk.dns.core.j
        public void a(o oVar, com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) oVar, (Object) dVar);
                return;
            }
            String str = oVar.f336287b;
            com.tencent.msdk.dns.core.a aVar = dVar.f336252b;
            if (!(aVar instanceof com.tencent.msdk.dns.core.stat.b)) {
                com.tencent.msdk.dns.base.log.c.c("Looked up for %s may be by LocalDns", str);
                return;
            }
            new com.tencent.msdk.dns.core.d(dVar.f336251a, (com.tencent.msdk.dns.core.stat.b) aVar);
            if (oVar.f336295j) {
                if (3 == oVar.f336294i) {
                    throw null;
                }
                throw null;
            }
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f336159d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.msdk.dns.core.d[] f336160e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f336161f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f336162h;

        b(String str, com.tencent.msdk.dns.core.d[] dVarArr, int i3, CountDownLatch countDownLatch) {
            this.f336159d = str;
            this.f336160e = dVarArr;
            this.f336161f = i3;
            this.f336162h = countDownLatch;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, dVarArr, Integer.valueOf(i3), countDownLatch);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            this.f336160e[this.f336161f] = g.j(new o.b().b(DnsService.f336156a).k(this.f336159d).j(DnsService.f336157b.f336177g).h(d.f().a()).c(DnsService.f336157b.f336176f).d(DnsService.f336157b.f336181k).l(false).e(DnsService.f336157b.f336183m).m(true).i(DnsService.f336157b.f336180j.contains(this.f336159d)).f());
            this.f336162h.countDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class c implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f336163d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ com.tencent.msdk.dns.core.d[] f336164e;

        c(CountDownLatch countDownLatch, com.tencent.msdk.dns.core.d[] dVarArr) {
            this.f336163d = countDownLatch;
            this.f336164e = dVarArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) countDownLatch, (Object) dVarArr);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                this.f336163d.await();
                com.tencent.msdk.dns.base.log.c.c("Await for pre lookup count down success", new Object[0]);
            } catch (Exception e16) {
                com.tencent.msdk.dns.base.log.c.j(e16, "Await for pre lookup count down failed", new Object[0]);
            }
            com.tencent.msdk.dns.d.c.g(this.f336164e);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17443);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    private static void c(List<com.tencent.msdk.dns.base.log.a> list) {
        com.tencent.msdk.dns.base.log.c.g("DnsService.addLogNodes(%s) called", com.tencent.msdk.dns.c.e.a.h(list));
        if (list == null) {
            return;
        }
        Iterator<com.tencent.msdk.dns.base.log.a> it = list.iterator();
        while (it.hasNext()) {
            com.tencent.msdk.dns.base.log.c.b(it.next());
        }
    }

    private static void d(List<com.tencent.msdk.dns.base.report.a> list) {
        com.tencent.msdk.dns.base.log.c.g("DnsService.addReporters(%s) called", com.tencent.msdk.dns.c.e.a.h(list));
        if (list == null) {
            return;
        }
        Iterator<com.tencent.msdk.dns.base.report.a> it = list.iterator();
        while (it.hasNext()) {
            com.tencent.msdk.dns.base.report.e.d(it.next());
        }
    }

    private static com.tencent.msdk.dns.core.c e(String str, String str2, boolean z16, boolean z17) {
        if (f336158c) {
            if (!TextUtils.isEmpty(str)) {
                String trim = str.trim();
                if (!TextUtils.isEmpty(trim)) {
                    if (com.tencent.msdk.dns.c.e.c.b(trim)) {
                        com.tencent.msdk.dns.base.log.c.c("Hostname %s is an v4 ip, just return it", trim);
                        return new com.tencent.msdk.dns.core.c(new String[]{trim}, com.tencent.msdk.dns.core.e.f336253a);
                    }
                    if (com.tencent.msdk.dns.c.e.c.c(trim)) {
                        com.tencent.msdk.dns.base.log.c.c("Hostname %s is an v6 ip, just return it", trim);
                        return new com.tencent.msdk.dns.core.c(com.tencent.msdk.dns.core.e.f336253a, new String[]{trim});
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = f336157b.f336181k;
                    }
                    String a16 = d.f().a();
                    com.tencent.msdk.dns.base.log.c.g("DnsService.getAddrsByName(%s, %s, %b, %b) called", trim, str2, Boolean.valueOf(z16), Boolean.valueOf(z17));
                    if (f336157b.a(trim)) {
                        com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> j3 = g.j(new o.b().b(f336156a).k(trim).j(f336157b.f336177g).h(a16).c(f336157b.f336176f).d(str2).l(z16).e(f336157b.f336183m).i(z17).f());
                        com.tencent.msdk.dns.d.c.c(j3, f336156a);
                        return j3.f336251a;
                    }
                    if (z16) {
                        com.tencent.msdk.dns.base.log.c.c("Hostname %s is not in protected domain list, just lookup by LocalDns", trim);
                        return g.j(new o.b().b(f336156a).k(trim).j(f336157b.f336177g).h(a16).c(i.a.f336268a).d("Local").l(false).e(f336157b.f336183m).f()).f336251a;
                    }
                    return com.tencent.msdk.dns.core.c.f336247d;
                }
            }
            com.tencent.msdk.dns.base.log.c.c("Hostname is empty", new Object[0]);
            return com.tencent.msdk.dns.core.c.f336247d;
        }
        throw new IllegalStateException("DnsService".concat(" is not initialized yet"));
    }

    public static com.tencent.msdk.dns.core.c f(String str, boolean z16) {
        return e(str, f336157b.f336181k, z16, false);
    }

    public static String g(String str) {
        return ((com.tencent.msdk.dns.core.stat.b) g.a(new o.b().b(f336156a).k(str).j(f336157b.f336177g).h(d.f().a()).c(f336157b.f336176f).d(f336157b.f336181k).l(true).e(f336157b.f336183m).i(false).f()).f336252b).f();
    }

    public static void h(Context context, com.tencent.msdk.dns.a aVar) {
        if (context != null) {
            if (aVar == null) {
                aVar = new a.C9208a().c();
            }
            com.tencent.msdk.dns.base.log.c.f(aVar.f336171a);
            c(aVar.f336184n);
            com.tencent.msdk.dns.base.log.c.g("DnsService.init(%s, %s) called, ver:%s", context, aVar, "3.9.0a");
            Context applicationContext = context.getApplicationContext();
            f336156a = applicationContext;
            f336157b = aVar;
            d.f().b(f336157b);
            com.tencent.msdk.dns.d.d.c().d();
            com.tencent.msdk.dns.c.c.d.a(applicationContext);
            com.tencent.msdk.dns.c.b.b.d(applicationContext);
            com.tencent.msdk.dns.base.report.e.a(1);
            if (aVar.f336174d) {
                com.tencent.msdk.dns.base.report.e.b(1, new com.tencent.msdk.dns.base.report.d(applicationContext, f336157b.f336172b));
            }
            com.tencent.msdk.dns.d.c.b(aVar);
            f336157b.getClass();
            com.tencent.msdk.dns.base.executor.a aVar2 = DnsExecutors.f336207b;
            j(null);
            d(aVar.f336185o);
            f336158c = true;
            i();
            return;
        }
        throw new IllegalArgumentException("context".concat(" can not be null"));
    }

    private static void i() {
        if (com.tencent.msdk.dns.c.e.a.f(f336157b.f336179i)) {
            return;
        }
        int size = f336157b.f336179i.size();
        String[] strArr = (String[]) f336157b.f336179i.toArray(new String[size]);
        if (f336157b.f336180j == null) {
            Collections.emptySet();
        }
        com.tencent.msdk.dns.core.d[] dVarArr = new com.tencent.msdk.dns.core.d[size];
        CountDownLatch countDownLatch = new CountDownLatch(size);
        for (int i3 = 0; i3 < size; i3++) {
            DnsExecutors.f336208c.execute(new b(strArr[i3], dVarArr, i3, countDownLatch));
        }
        DnsExecutors.f336208c.execute(new c(countDownLatch, dVarArr));
    }

    private static void j(com.tencent.msdk.dns.b bVar) {
        com.tencent.msdk.dns.base.log.c.g("DnsService.setLookedUpListener(%s) called", bVar);
        if (bVar == null) {
            return;
        }
        g.e(new a(bVar));
    }

    public static synchronized void k(String str) {
        synchronized (DnsService.class) {
            if (f336158c) {
                if (!TextUtils.isEmpty(str)) {
                    f336157b.f336173c = str;
                } else {
                    throw new IllegalArgumentException("userId".concat(" can not be empty"));
                }
            } else {
                throw new IllegalStateException("DnsService".concat(" is not initialized yet"));
            }
        }
    }
}

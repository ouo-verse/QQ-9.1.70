package com.tencent.msdk.dns.core;

import android.os.SystemClock;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msdk.dns.core.a;
import com.tencent.msdk.dns.core.b;
import com.tencent.msdk.dns.core.i;
import com.tencent.msdk.dns.core.m;
import com.tencent.msdk.dns.core.o;
import com.tencent.msdk.dns.core.p.a;
import java.io.IOException;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, b> f336256a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<o, c> f336257b;

    /* renamed from: c, reason: collision with root package name */
    private static m.a f336258c;

    /* renamed from: d, reason: collision with root package name */
    private static l f336259d;

    /* renamed from: e, reason: collision with root package name */
    private static a.InterfaceC9211a f336260e;

    /* renamed from: f, reason: collision with root package name */
    private static volatile j f336261f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        i f336262a;

        /* renamed from: b, reason: collision with root package name */
        i f336263b;

        /* renamed from: c, reason: collision with root package name */
        i f336264c;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final CountDownLatch f336265a;

        /* renamed from: b, reason: collision with root package name */
        final d f336266b;

        public c(CountDownLatch countDownLatch, d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) countDownLatch, (Object) dVar);
            } else {
                if (countDownLatch != null) {
                    if (dVar != null) {
                        this.f336265a = countDownLatch;
                        this.f336266b = dVar;
                        return;
                    }
                    throw new IllegalArgumentException("lookupResultHolder".concat(" can not be null"));
                }
                throw new IllegalArgumentException("lookupLatch".concat(" can not be null"));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(16142);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f336256a = kl3.a.a();
        f336257b = new ConcurrentHashMap();
        f336258c = new a.b();
        f336259d = new com.tencent.msdk.dns.core.o.a();
        f336260e = new com.tencent.msdk.dns.core.stat.c();
        f336261f = null;
        c(new com.tencent.msdk.dns.core.local.a());
        c(new com.tencent.msdk.dns.core.n.b.b(1));
        c(new com.tencent.msdk.dns.core.n.b.b(2));
        c(new com.tencent.msdk.dns.core.n.a.b(1));
        c(new com.tencent.msdk.dns.core.n.a.b(2));
        c(new com.tencent.msdk.dns.core.n.c.a(1));
        c(new com.tencent.msdk.dns.core.n.c.a(2));
    }

    public static <LookupExtra extends i.a> com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> a(o<LookupExtra> oVar) {
        b bVar = f336256a.get(oVar.f336291f);
        if (bVar == null) {
            return new com.tencent.msdk.dns.core.d<>(com.tencent.msdk.dns.core.c.f336247d, new com.tencent.msdk.dns.core.stat.b(oVar.f336286a));
        }
        LookupExtra lookupextra = oVar.f336290e;
        n k3 = n.k(oVar);
        k3.a(com.tencent.msdk.dns.c.e.d.a());
        m a16 = f336258c.a(k3.p());
        k3.d(a16);
        com.tencent.msdk.dns.core.a<LookupExtra> a17 = f336260e.a(lookupextra.getClass(), oVar.f336286a);
        k3.b(a17);
        com.tencent.msdk.dns.core.d c16 = bVar.f336263b.c(oVar);
        if (c16.f336252b.a()) {
            com.tencent.msdk.dns.base.log.c.c("getResultFromCache by ipv4:" + Arrays.toString(c16.f336251a.f336250c), new Object[0]);
            k3.A().a(bVar.f336263b, c16.f336251a.f336250c);
            k3.B().c(bVar.f336263b, c16.f336252b);
        }
        com.tencent.msdk.dns.core.d c17 = bVar.f336264c.c(oVar);
        if (c17.f336252b.a()) {
            com.tencent.msdk.dns.base.log.c.c("getResultFromCache by ipv6:" + Arrays.toString(c17.f336251a.f336250c), new Object[0]);
            k3.A().a(bVar.f336264c, c17.f336251a.f336250c);
            k3.B().c(bVar.f336264c, c17.f336252b);
        }
        if (!c16.f336252b.a() && !c17.f336252b.a()) {
            return new com.tencent.msdk.dns.core.d<>(com.tencent.msdk.dns.core.c.f336247d, new com.tencent.msdk.dns.core.stat.b(oVar.f336286a));
        }
        com.tencent.msdk.dns.core.c a18 = a16.a();
        a17.d(a18);
        com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> dVar = new com.tencent.msdk.dns.core.d<>(a18, a17);
        com.tencent.msdk.dns.base.log.c.c("getResultFromCache by httpdns cache:" + dVar.f336251a + "; " + dVar.f336252b, new Object[0]);
        return dVar;
    }

    private static <LookupExtra extends i.a> void b(b bVar, n<LookupExtra> nVar) {
        int p16 = nVar.p();
        int t16 = nVar.t();
        boolean v3 = nVar.v();
        i iVar = bVar.f336264c;
        if (iVar == null && bVar.f336263b == null) {
            i iVar2 = bVar.f336262a;
            if (iVar2 != null) {
                if (v3 || (p16 & 3) != 0) {
                    d(iVar2, nVar);
                    return;
                }
                return;
            }
            return;
        }
        if (iVar != null && (t16 & 2) != 0 && (v3 || (p16 & 2) != 0)) {
            d(iVar, nVar);
        }
        i iVar3 = bVar.f336263b;
        if (iVar3 != null && (t16 & 1) != 0) {
            if (v3 || (p16 & 1) != 0) {
                d(iVar3, nVar);
            }
        }
    }

    public static synchronized void c(i iVar) {
        b bVar;
        synchronized (g.class) {
            if (iVar != null) {
                String str = iVar.a().f336254a;
                Map<String, b> map = f336256a;
                if (map.containsKey(str)) {
                    bVar = map.get(str);
                } else {
                    b bVar2 = new b(null);
                    map.put(str, bVar2);
                    bVar = bVar2;
                }
                int i3 = iVar.a().f336255b;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            bVar.f336262a = iVar;
                        }
                    } else {
                        bVar.f336264c = iVar;
                    }
                } else {
                    bVar.f336263b = iVar;
                }
            } else {
                throw new IllegalArgumentException("dns".concat(" can not be null"));
            }
        }
    }

    private static <LookupExtra extends i.a> void d(i<LookupExtra> iVar, n<LookupExtra> nVar) {
        i.b a16;
        com.tencent.msdk.dns.base.log.c.c("prepareTask:" + iVar, new Object[0]);
        nVar.r().add(iVar);
        if (!nVar.m() && !"Local".equals(iVar.a().f336254a)) {
            if (!"Https".equals(nVar.n()) && ((nVar.y() != null || l(nVar)) && (a16 = iVar.a(nVar)) != null)) {
                k.a(a16, nVar);
                return;
            } else {
                k.c(iVar, nVar);
                return;
            }
        }
        k.c(iVar, nVar);
    }

    public static void e(j jVar) {
        f336261f = jVar;
    }

    private static void f(n nVar) {
        Iterator<i.b> it = nVar.z().iterator();
        while (it.hasNext()) {
            if (it.next().c()) {
                it.remove();
            }
        }
    }

    private static boolean g(long j3, int i3, int i16, int i17) {
        if (i17 < i16 && ((int) (SystemClock.elapsedRealtime() - j3)) > (i3 * (i17 + 1)) / (i16 + 1)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0420 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r20v1, types: [com.tencent.msdk.dns.core.b$c] */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r20v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r20v7 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <LookupExtra extends i.a> com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> h(o<LookupExtra> oVar) {
        b bVar;
        String str;
        String str2;
        Selector y16;
        long j3;
        int i3;
        ?? r202;
        String str3;
        b bVar2;
        Selector selector;
        int i16;
        CountDownLatch countDownLatch;
        long j16;
        if (oVar != null) {
            com.tencent.msdk.dns.base.log.c.g("DnsManager.lookup(%s) called", oVar);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Map<o, c> map = f336257b;
            c cVar = map.get(oVar);
            if (cVar != null) {
                com.tencent.msdk.dns.base.log.c.c("The same lookup task(for %s) is running, just wait for it", oVar);
                try {
                    if (cVar.f336265a.await(oVar.f336288c * 1.2f, TimeUnit.MILLISECONDS)) {
                        return cVar.f336266b.f336267a;
                    }
                    com.tencent.msdk.dns.base.log.c.c("Await for running lookup for %s timeout", oVar);
                    return new com.tencent.msdk.dns.core.d<>(com.tencent.msdk.dns.core.c.f336247d, new com.tencent.msdk.dns.core.stat.b(oVar.f336286a));
                } catch (Exception e16) {
                    com.tencent.msdk.dns.base.log.c.j(e16, "Await for running lookup for %s failed", oVar);
                    int elapsedRealtime2 = (int) (oVar.f336288c - (SystemClock.elapsedRealtime() - elapsedRealtime));
                    if (elapsedRealtime2 > 0) {
                        return h(new o.b(oVar).j(elapsedRealtime2).f());
                    }
                    return new com.tencent.msdk.dns.core.d<>(com.tencent.msdk.dns.core.c.f336247d, new com.tencent.msdk.dns.core.stat.b(oVar.f336286a));
                }
            }
            CountDownLatch countDownLatch2 = new CountDownLatch(1);
            b bVar3 = null;
            d dVar = new d(false ? 1 : 0);
            map.put(oVar, new c(countDownLatch2, dVar));
            int i17 = oVar.f336288c;
            LookupExtra lookupextra = oVar.f336290e;
            String str4 = oVar.f336291f;
            boolean z16 = oVar.f336292g;
            n<LookupExtra> k3 = n.k(oVar);
            if (z16) {
                bVar = f336256a.get("Local");
            } else {
                bVar = null;
            }
            if ("Local".equals(str4)) {
                bVar = f336256a.get("Local");
            } else {
                bVar3 = f336256a.get(str4);
            }
            k3.a(com.tencent.msdk.dns.c.e.d.a());
            m a16 = f336258c.a(k3.p());
            k3.d(a16);
            l lVar = f336259d;
            com.tencent.msdk.dns.core.a<LookupExtra> a17 = f336260e.a(lookupextra.getClass(), oVar.f336286a);
            k3.b(a17);
            b.c a18 = com.tencent.msdk.dns.core.b.a();
            k3.c(a18);
            Set<i> synchronizedSet = Collections.synchronizedSet(kl3.a.c());
            k3.h(synchronizedSet);
            ArrayList arrayList = new ArrayList();
            k3.g(arrayList);
            String str5 = "FINALLY statMerge: %s";
            try {
                if (bVar3 != null) {
                    b.c cVar2 = a18;
                    com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> a19 = a(oVar);
                    i3 = i17;
                    StringBuilder sb5 = new StringBuilder();
                    j3 = elapsedRealtime;
                    sb5.append("getResultFromCache: ");
                    sb5.append(a19);
                    com.tencent.msdk.dns.base.log.c.c(sb5.toString(), new Object[0]);
                    if (a19.f336252b.a()) {
                        dVar.f336267a = a19;
                        com.tencent.msdk.dns.base.log.c.c("DnsManager lookup getResultFromCache success", new Object[0]);
                        i(k3);
                        countDownLatch2.countDown();
                        map.remove(oVar);
                        a17.b(k3);
                        com.tencent.msdk.dns.base.log.c.c("FINALLY statMerge: %s", a17.f());
                        f(k3);
                        synchronizedSet.clear();
                        Selector y17 = k3.y();
                        if (y17 != null) {
                            try {
                                y17.close();
                                com.tencent.msdk.dns.base.log.c.c("%s closed", y17);
                            } catch (IOException unused) {
                            }
                        }
                        return a19;
                    }
                    b(bVar3, k3);
                    r202 = cVar2;
                    r202 = cVar2;
                    if (!k3.j() && bVar != null) {
                        b(bVar, k3);
                        r202 = cVar2;
                    }
                } else {
                    j3 = elapsedRealtime;
                    i3 = i17;
                    b.c cVar3 = a18;
                    r202 = cVar3;
                    if (bVar != null) {
                        b(bVar, k3);
                        r202 = cVar3;
                    }
                }
                int a26 = lVar.a();
                int elapsedRealtime3 = i3 - ((int) (SystemClock.elapsedRealtime() - j3));
                if (a26 > 0) {
                    elapsedRealtime3 /= a26 + 1;
                }
                CountDownLatch c16 = r202.c();
                k3.i(c16);
                Selector y18 = k3.y();
                try {
                    if (y18 == null) {
                        r202 = "%s closed";
                        try {
                            com.tencent.msdk.dns.base.log.c.c("selector is null", new Object[0]);
                            int i18 = 0;
                            while (!synchronizedSet.isEmpty() && (c16.getCount() != 1 || !synchronizedSet.contains(bVar.f336262a))) {
                                str3 = str5;
                                int i19 = i3;
                                b bVar4 = bVar;
                                if (SystemClock.elapsedRealtime() - j3 >= i19) {
                                    break;
                                }
                                try {
                                    c16.await(elapsedRealtime3, TimeUnit.MILLISECONDS);
                                } catch (Exception e17) {
                                    com.tencent.msdk.dns.base.log.c.d(e17, "sessions not empty, but exception", new Object[0]);
                                }
                                if (!synchronizedSet.isEmpty()) {
                                    j16 = j3;
                                    if (g(j16, i19, a26, i18)) {
                                        i18++;
                                        i16 = a26;
                                        countDownLatch = c16;
                                        lVar.b(k3.e(new o.b(oVar).j(i19 - ((int) (SystemClock.elapsedRealtime() - j16))).a(i18).f()));
                                    } else {
                                        i16 = a26;
                                        countDownLatch = c16;
                                    }
                                } else {
                                    i16 = a26;
                                    countDownLatch = c16;
                                    j16 = j3;
                                }
                                j3 = j16;
                                bVar = bVar4;
                                a26 = i16;
                                c16 = countDownLatch;
                                str5 = str3;
                                i3 = i19;
                            }
                            str3 = str5;
                            com.tencent.msdk.dns.core.c a27 = a16.a();
                            a17.d(a27);
                            com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> dVar2 = new com.tencent.msdk.dns.core.d<>(a27, a17);
                            dVar.f336267a = dVar2;
                            i(k3);
                            countDownLatch2.countDown();
                            f336257b.remove(oVar);
                            a17.b(k3);
                            com.tencent.msdk.dns.base.log.c.c(str3, a17.f());
                            f(k3);
                            synchronizedSet.clear();
                            Selector y19 = k3.y();
                            if (y19 != null) {
                                try {
                                    y19.close();
                                    com.tencent.msdk.dns.base.log.c.c(r202, y19);
                                } catch (IOException unused2) {
                                }
                            }
                            return dVar2;
                        } catch (Throwable th5) {
                            th = th5;
                            str2 = str5;
                            str = r202;
                            i(k3);
                            countDownLatch2.countDown();
                            f336257b.remove(oVar);
                            a17.b(k3);
                            com.tencent.msdk.dns.base.log.c.c(str2, a17.f());
                            f(k3);
                            synchronizedSet.clear();
                            y16 = k3.y();
                            if (y16 != null) {
                            }
                            throw th;
                        }
                    }
                    int i26 = a26;
                    CountDownLatch countDownLatch3 = c16;
                    str2 = "FINALLY statMerge: %s";
                    int i27 = i3;
                    b bVar5 = bVar;
                    long j17 = j3;
                    r202 = "%s closed";
                    int i28 = 0;
                    while (true) {
                        try {
                            str3 = str2;
                            if (!arrayList.isEmpty()) {
                                int i29 = i28;
                                if (SystemClock.elapsedRealtime() - j17 >= i27) {
                                    break;
                                }
                                try {
                                    LockMethodProxy.sleep(10L);
                                } catch (Exception unused3) {
                                }
                                try {
                                    com.tencent.msdk.dns.base.log.c.c("selector %s wait for sessions:%d, mills:%d", y18, Integer.valueOf(arrayList.size()), Integer.valueOf(elapsedRealtime3));
                                    y18.select(elapsedRealtime3);
                                } catch (Exception e18) {
                                    com.tencent.msdk.dns.base.log.c.d(e18, "sessions not empty, but exception", new Object[0]);
                                }
                                k(k3);
                                if (!arrayList.isEmpty()) {
                                    int i36 = i26;
                                    i28 = i29;
                                    if (g(j17, i27, i36, i28)) {
                                        i26 = i36;
                                        selector = y18;
                                        com.tencent.msdk.dns.base.log.c.c("sessions is not empty, sessions:%d, enter retry", Integer.valueOf(arrayList.size()));
                                        i28++;
                                        lVar.a(k3.e(new o.b(oVar).a(i28).f()));
                                    } else {
                                        i26 = i36;
                                        selector = y18;
                                    }
                                } else {
                                    selector = y18;
                                    i28 = i29;
                                }
                                y18 = selector;
                                str2 = str3;
                            } else {
                                break;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            str = r202;
                            i(k3);
                            countDownLatch2.countDown();
                            f336257b.remove(oVar);
                            a17.b(k3);
                            com.tencent.msdk.dns.base.log.c.c(str2, a17.f());
                            f(k3);
                            synchronizedSet.clear();
                            y16 = k3.y();
                            if (y16 != null) {
                            }
                            throw th;
                        }
                    }
                    SystemClock.elapsedRealtime();
                    try {
                        if (arrayList.size() > 0) {
                            com.tencent.msdk.dns.base.log.c.c("selector wait for last timeout if sessions is not empty, sessions:%d, mills:%d", Integer.valueOf(arrayList.size()), Integer.valueOf(elapsedRealtime3));
                        }
                        while (countDownLatch3.getCount() != 0) {
                            if (countDownLatch3.getCount() == 1) {
                                bVar2 = bVar5;
                                if (synchronizedSet.contains(bVar2.f336262a)) {
                                    break;
                                }
                            } else {
                                bVar2 = bVar5;
                            }
                            bVar5 = bVar2;
                            if (SystemClock.elapsedRealtime() - j17 < i27) {
                                break;
                            }
                            CountDownLatch countDownLatch4 = countDownLatch3;
                            countDownLatch4.await(100L, TimeUnit.MILLISECONDS);
                            countDownLatch3 = countDownLatch4;
                        }
                    } catch (Exception unused4) {
                    }
                    com.tencent.msdk.dns.core.c a28 = a16.a();
                    a17.d(a28);
                    com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> dVar3 = new com.tencent.msdk.dns.core.d<>(a28, a17);
                    dVar.f336267a = dVar3;
                    i(k3);
                    countDownLatch2.countDown();
                    f336257b.remove(oVar);
                    a17.b(k3);
                    com.tencent.msdk.dns.base.log.c.c(str3, a17.f());
                    f(k3);
                    synchronizedSet.clear();
                    Selector y26 = k3.y();
                    if (y26 != null) {
                        try {
                            y26.close();
                            com.tencent.msdk.dns.base.log.c.c(r202, y26);
                        } catch (IOException unused5) {
                        }
                    }
                    return dVar3;
                } catch (Throwable th7) {
                    th = th7;
                    str = r202;
                    str2 = str3;
                }
                th = th7;
                str = r202;
                str2 = str3;
            } catch (Throwable th8) {
                th = th8;
                str = "%s closed";
                str2 = "FINALLY statMerge: %s";
            }
            i(k3);
            countDownLatch2.countDown();
            f336257b.remove(oVar);
            a17.b(k3);
            com.tencent.msdk.dns.base.log.c.c(str2, a17.f());
            f(k3);
            synchronizedSet.clear();
            y16 = k3.y();
            if (y16 != null) {
                try {
                    y16.close();
                    com.tencent.msdk.dns.base.log.c.c(str, y16);
                } catch (IOException unused6) {
                }
            }
            throw th;
        }
        throw new IllegalArgumentException("lookupParams".concat(" can not be null"));
    }

    private static <LookupExtra extends i.a> void i(n<LookupExtra> nVar) {
        for (i.b bVar : nVar.z()) {
            bVar.d();
            nVar.B().c(bVar.g(), bVar.f());
        }
    }

    public static <LookupExtra extends i.a> com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> j(o<LookupExtra> oVar) {
        com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> h16 = h(oVar);
        com.tencent.msdk.dns.base.log.c.c("LookupResult %s", h16.f336251a);
        if (f336261f != null) {
            f336261f.a(oVar, h16);
        }
        return h16;
    }

    private static <LookupExtra extends i.a> void k(n<LookupExtra> nVar) {
        Iterator<i.b> it = nVar.z().iterator();
        while (it.hasNext()) {
            i.b next = it.next();
            if (!next.c()) {
                i.b.a a16 = next.a();
                if (a16.c()) {
                    com.tencent.msdk.dns.base.log.c.c("%s event readable", next.g().a());
                    String[] b16 = next.b();
                    if (next.f().a() || next.f().e()) {
                        i g16 = next.g();
                        it.remove();
                        nVar.r().remove(g16);
                        if (next.f().a()) {
                            nVar.A().a(g16, b16);
                        }
                        nVar.B().c(g16, next.f());
                    }
                } else if (a16.b()) {
                    com.tencent.msdk.dns.base.log.c.c("%s event writable", next.g().a());
                    next.h();
                } else {
                    if (a16.d()) {
                        com.tencent.msdk.dns.base.log.c.c("%s event connectable", next.g().a());
                        next.e();
                    }
                    com.tencent.msdk.dns.base.log.c.c("%s event finishConnect:%b", next.g().a(), Boolean.valueOf(a16.e()));
                }
                if (!a16.a()) {
                    com.tencent.msdk.dns.base.log.c.c("%s event not available, maybe closed", next.g().a());
                    i g17 = next.g();
                    it.remove();
                    nVar.r().remove(g17);
                }
            }
        }
    }

    private static boolean l(n nVar) {
        try {
            Selector open = Selector.open();
            nVar.f(open);
            com.tencent.msdk.dns.base.log.c.c("%s opened", open);
            return true;
        } catch (Exception e16) {
            com.tencent.msdk.dns.base.log.c.d(e16, "Open selector failed", new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        com.tencent.msdk.dns.core.d<com.tencent.msdk.dns.core.a> f336267a;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f336267a = null;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* synthetic */ d(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }
}

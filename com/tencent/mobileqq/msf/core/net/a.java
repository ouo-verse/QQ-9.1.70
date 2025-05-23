package com.tencent.mobileqq.msf.core.net;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.t;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: j, reason: collision with root package name */
    public static final String f248695j = "ComplexConnect";

    /* renamed from: k, reason: collision with root package name */
    public static final int f248696k = 15;

    /* renamed from: l, reason: collision with root package name */
    public static final int f248697l = -3;

    /* renamed from: m, reason: collision with root package name */
    public static final int f248698m = -2;

    /* renamed from: n, reason: collision with root package name */
    public static final int f248699n = -1;

    /* renamed from: o, reason: collision with root package name */
    public static final int f248700o = 0;

    /* renamed from: p, reason: collision with root package name */
    public static final int f248701p = 1;

    /* renamed from: q, reason: collision with root package name */
    public static final int f248702q = 2;

    /* renamed from: r, reason: collision with root package name */
    public static final int f248703r = 3;

    /* renamed from: s, reason: collision with root package name */
    public static final int f248704s = -1;

    /* renamed from: a, reason: collision with root package name */
    private final MsfCore f248705a;

    /* renamed from: b, reason: collision with root package name */
    private final t f248706b;

    /* renamed from: c, reason: collision with root package name */
    private final int f248707c;

    /* renamed from: d, reason: collision with root package name */
    private final int f248708d;

    /* renamed from: e, reason: collision with root package name */
    private final long f248709e;

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<n> f248710f;

    /* renamed from: g, reason: collision with root package name */
    private final CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.net.b> f248711g;

    /* renamed from: h, reason: collision with root package name */
    private int f248712h;

    /* renamed from: i, reason: collision with root package name */
    private final ExecutorService f248713i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.net.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public class RunnableC8086a implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.msf.core.d f248714a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ n f248715b;

        RunnableC8086a(com.tencent.mobileqq.msf.core.d dVar, n nVar) {
            this.f248714a = dVar;
            this.f248715b = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, dVar, nVar);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                a.this.b(this.f248714a, this.f248715b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.a();
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(MsfCore msfCore, t tVar, ExecutorService executorService, ArrayList<n> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msfCore, tVar, executorService, arrayList);
            return;
        }
        this.f248711g = new CopyOnWriteArrayList<>();
        this.f248712h = -1;
        this.f248705a = msfCore;
        this.f248706b = tVar;
        this.f248710f = arrayList;
        this.f248707c = com.tencent.mobileqq.msf.core.b.f().a();
        this.f248708d = com.tencent.mobileqq.msf.core.b.f().b();
        this.f248709e = com.tencent.mobileqq.msf.core.b.f().d();
        this.f248713i = executorService;
    }

    private void e() {
        Iterator<n> it = this.f248710f.iterator();
        while (it.hasNext()) {
            n next = it.next();
            if (next.c() != 0) {
                next.a(com.tencent.qphone.base.a.closeByComplexConnReset);
                next.b(0);
            }
        }
    }

    private void f() {
        if (this.f248712h != -1) {
            this.f248713i.submit(new b());
        } else {
            a();
        }
    }

    private int g() {
        int i3 = -1;
        long j3 = TTL.MAX_VALUE;
        for (int i16 = 0; i16 < this.f248710f.size(); i16++) {
            if (this.f248710f.get(i16) != null && this.f248710f.get(i16).c() == 3 && this.f248710f.get(i16).d() < j3) {
                long d16 = this.f248710f.get(i16).d();
                QLog.d(f248695j, 1, "select mainSocketIndex: " + i16 + ", connCostTime:" + d16);
                j3 = d16;
                i3 = i16;
            }
        }
        return i3;
    }

    public CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.net.b> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f248711g : (CopyOnWriteArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f248712h;
    }

    public ArrayList<n> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f248710f;
    }

    public int a(CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList, CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList2) {
        int i3;
        boolean z16;
        int a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) copyOnWriteArrayList, (Object) copyOnWriteArrayList2)).intValue();
        }
        NetConnInfoCenter.checkConnInfo();
        int i16 = 0;
        while (true) {
            boolean z17 = true;
            while (z17) {
                try {
                } catch (Exception e16) {
                    e = e16;
                    i3 = i16;
                    z16 = false;
                }
                if (k.e() && copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    a16 = a(copyOnWriteArrayList);
                    if (a16 == 2) {
                        break;
                    }
                    i16 = a16;
                } else if (copyOnWriteArrayList2 != null && copyOnWriteArrayList2.size() > 0) {
                    if (k.c() != null) {
                        CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
                        Iterator<com.tencent.mobileqq.msf.core.d> it = copyOnWriteArrayList2.iterator();
                        while (it.hasNext()) {
                            com.tencent.mobileqq.msf.core.d next = it.next();
                            if (next.f247933j == 1) {
                                copyOnWriteArrayList3.add(next);
                            }
                        }
                        i16 = a(copyOnWriteArrayList3);
                        z17 = i16 == 2;
                        if (i16 == 0) {
                            try {
                                a16 = a(copyOnWriteArrayList2);
                                if (a16 == 2) {
                                    break;
                                }
                                i16 = a16;
                            } catch (Exception e17) {
                                z16 = z17;
                                e = e17;
                                i3 = i16;
                                QLog.d(f248695j, 1, "selectAndConnect error, ", e);
                                z17 = z16;
                                i16 = i3;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        a16 = a(copyOnWriteArrayList2);
                        if (a16 == 2) {
                            break;
                        }
                        i16 = a16;
                    }
                }
                z17 = false;
            }
            return i16;
            i16 = a16;
        }
    }

    public void b(com.tencent.mobileqq.msf.core.d dVar, n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) dVar, (Object) nVar);
            return;
        }
        com.tencent.mobileqq.msf.core.net.b bVar = new com.tencent.mobileqq.msf.core.net.b();
        bVar.f248726i = System.currentTimeMillis();
        bVar.f248719b = dVar.n();
        bVar.f248724g = NetConnInfoCenter.getSystemNetworkType();
        bVar.f248727j = 0;
        bVar.f248728k = 0;
        bVar.f248729l = 0;
        bVar.f248730m = 0;
        if (dVar.e().equalsIgnoreCase("http")) {
            nVar.a(dVar, new d(this.f248705a, this.f248706b), bVar);
        } else {
            nVar.a(dVar, new p(this.f248705a, this.f248706b), bVar);
        }
        if (bVar.f248721d) {
            nVar.b(3);
        } else {
            nVar.b(-1);
        }
        this.f248711g.add(bVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    private int a(CopyOnWriteArrayList<com.tencent.mobileqq.msf.core.d> copyOnWriteArrayList) {
        int i3;
        boolean z16;
        long j3;
        boolean z17;
        boolean z18;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() <= 0) {
            return -1;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f248711g.clear();
        e();
        int i16 = 1;
        try {
            long uptimeMillis2 = SystemClock.uptimeMillis() - this.f248707c;
            boolean z19 = false;
            int i17 = 0;
            int i18 = 0;
            boolean z26 = false;
            while (true) {
                long uptimeMillis3 = SystemClock.uptimeMillis();
                if (z19) {
                    z16 = z19;
                    j3 = 0;
                } else {
                    z16 = z19;
                    j3 = this.f248707c - (uptimeMillis3 - uptimeMillis2);
                }
                int a16 = a(this.f248710f, 2);
                int a17 = a(this.f248710f, 0);
                if (i17 >= copyOnWriteArrayList.size() || i17 >= 15 || !a(j3, a16, a17)) {
                    z17 = z16;
                } else {
                    QLog.d(f248695j, i16, "[connectImpatient], nextConnectTime arrival, index: " + i17 + ", runningCount: " + a16 + ", availableCount: " + a17 + ", try open endPoint: " + copyOnWriteArrayList.get(i17).hashCode());
                    uptimeMillis2 = SystemClock.uptimeMillis();
                    i18 = a(copyOnWriteArrayList.get(i17)) == 2 ? i16 : 0;
                    i17++;
                    z17 = false;
                }
                if (i18 != 0) {
                    QLog.d(f248695j, i16, "[connectImpatient] break by netChange");
                    break;
                }
                int i19 = i16;
                int i26 = 0;
                ?? r102 = z17;
                while (true) {
                    if (i26 >= this.f248710f.size()) {
                        break;
                    }
                    if (this.f248710f.get(i26) != null) {
                        if (this.f248710f.get(i26).c() != 0) {
                            i19 = 0;
                        }
                        if (this.f248710f.get(i26).c() == -1) {
                            this.f248710f.get(i26).a(com.tencent.qphone.base.a.closeByComplexConnFailed);
                            com.tencent.mobileqq.msf.core.d h16 = this.f248710f.get(i26).h();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("[connectImpatient] socketEngine index: ");
                            sb5.append(i26);
                            sb5.append(" conn error with endpoint: ");
                            sb5.append(h16 == null ? 0 : h16.hashCode());
                            QLog.d(f248695j, 1, sb5.toString());
                            r102 = -1;
                        } else if (this.f248710f.get(i26).c() == 3) {
                            com.tencent.mobileqq.msf.core.d h17 = this.f248710f.get(i26).h();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("[connectImpatient] socketEngine index: ");
                            sb6.append(i26);
                            sb6.append(" conn success with endpoint: ");
                            sb6.append(h17 == null ? 0 : h17.hashCode());
                            QLog.d(f248695j, 1, sb6.toString());
                            z26 = true;
                        }
                    }
                    i26++;
                    r102 = r102;
                }
                if (z26 || (i19 != 0 && i17 == copyOnWriteArrayList.size())) {
                    break;
                }
                boolean z27 = r102;
                if (SystemClock.uptimeMillis() - uptimeMillis > this.f248709e) {
                    QLog.d(f248695j, 1, "[connectImpatient] loopTimeout, cost: " + (SystemClock.uptimeMillis() - uptimeMillis));
                    z18 = true;
                    break;
                }
                z19 = z27;
                i16 = 1;
            }
            z18 = false;
            if (i18 == 0 && !z18) {
                this.f248712h = g();
            }
            f();
            if (i18 != 0) {
                i3 = 2;
            } else {
                i3 = this.f248712h != -1 ? 3 : z18 ? -3 : -1;
            }
        } catch (Exception e16) {
            QLog.d("ComplexConnectComplexConnContext.", 1, "connectImpatient error, ", e16);
            i3 = -2;
        }
        QLog.d(f248695j, 1, "[connectImpatient] finish, connState: " + i3 + ", costTime: " + (SystemClock.uptimeMillis() - uptimeMillis));
        return i3;
    }

    public void a(com.tencent.mobileqq.msf.core.d dVar, n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f248713i.submit(new RunnableC8086a(dVar, nVar));
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) dVar, (Object) nVar);
        }
    }

    private boolean a(long j3, int i3, int i16) {
        return j3 <= 0 && i3 < this.f248708d && i16 > 0;
    }

    private int a(com.tencent.mobileqq.msf.core.d dVar) {
        for (int i3 = 0; i3 < this.f248710f.size(); i3++) {
            if (this.f248710f.get(i3) != null && this.f248710f.get(i3).c() == 0) {
                NetConnInfoCenter.checkConnInfo();
                if (k.a(dVar)) {
                    return -1;
                }
                QLog.d(f248695j, 1, "[connectImpatient] socketEngine index: " + i3 + " asyncDoOpenConn with endPoint: " + dVar.hashCode());
                this.f248710f.get(i3).b(1);
                a(dVar, this.f248710f.get(i3));
                return 0;
            }
        }
        return 0;
    }

    private int a(ArrayList<n> arrayList, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < arrayList.size(); i17++) {
            n nVar = arrayList.get(i17);
            if (nVar != null && nVar.c() == i3) {
                i16++;
            }
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        for (int i3 = 0; i3 < this.f248710f.size(); i3++) {
            if (this.f248710f.get(i3) != null && i3 != this.f248712h) {
                this.f248710f.get(i3).a(com.tencent.qphone.base.a.closeByComplexConnFailed);
            }
        }
    }
}

package com.tencent.hlyyb.downloader.e;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import com.tencent.hlyyb.downloader.a.a.a;
import com.tencent.hlyyb.downloader.b.c;
import com.tencent.hlyyb.downloader.e.d.b;
import com.tencent.hlyyb.downloader.e.f.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public h f114465a;

    /* renamed from: b, reason: collision with root package name */
    public volatile DownloaderTaskStatus f114466b;

    /* renamed from: c, reason: collision with root package name */
    public Vector<DownloaderTaskListener> f114467c;

    /* renamed from: d, reason: collision with root package name */
    public Vector<DownloaderTaskListener> f114468d;

    /* renamed from: e, reason: collision with root package name */
    public int f114469e;

    /* renamed from: f, reason: collision with root package name */
    public volatile boolean f114470f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedBlockingQueue<a> f114471g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final a f114472a;

        /* renamed from: b, reason: collision with root package name */
        public static final a f114473b;

        /* renamed from: c, reason: collision with root package name */
        public static final a f114474c;

        /* renamed from: d, reason: collision with root package name */
        public static final a f114475d;

        /* renamed from: e, reason: collision with root package name */
        public static final a f114476e;

        /* renamed from: f, reason: collision with root package name */
        public static final a f114477f;

        /* renamed from: g, reason: collision with root package name */
        public static final a f114478g;

        /* renamed from: h, reason: collision with root package name */
        public static final a f114479h;

        /* renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ a[] f114480i;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11257);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            a aVar = new a("Inform_Pending", 0);
            f114472a = aVar;
            a aVar2 = new a("Inform_Started", 1);
            f114473b = aVar2;
            a aVar3 = new a("Inform_Detected", 2);
            f114474c = aVar3;
            a aVar4 = new a("Inform_Received", 3);
            f114475d = aVar4;
            a aVar5 = new a("Inform_Paused", 4);
            f114476e = aVar5;
            a aVar6 = new a("Inform_Failed", 5);
            f114477f = aVar6;
            a aVar7 = new a("Inform_Succeed", 6);
            f114478g = aVar7;
            a aVar8 = new a("Inform_Deleted", 7);
            f114479h = aVar8;
            f114480i = new a[]{aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8};
        }

        public a(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static a[] a() {
            return (a[]) f114480i.clone();
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public final class d implements com.tencent.hlyyb.downloader.a.a.b, com.tencent.hlyyb.downloader.a.a, c.a, Runnable {
        static IPatchRedirector $redirector_;
        public Map<String, String> C;
        public int D;
        public String E;
        public boolean F;
        public boolean G;
        public com.tencent.hlyyb.downloader.a.a.c H;
        public Object I;
        public com.tencent.hlyyb.downloader.e.d.b J;
        public String K;
        public boolean L;
        public List<com.tencent.hlyyb.downloader.b.c> M;
        public Map<com.tencent.hlyyb.downloader.e.f.a, com.tencent.hlyyb.downloader.b.c> N;
        public Map<com.tencent.hlyyb.downloader.e.f.a, List<String>> P;
        public com.tencent.hlyyb.downloader.b.a Q;
        public volatile boolean R;
        public volatile boolean S;
        public AtomicInteger T;
        public AtomicInteger U;
        public boolean V;
        public boolean W;
        public int X;
        public boolean Y;
        public volatile int Z;

        /* renamed from: a0, reason: collision with root package name */
        public long f114481a0;

        /* renamed from: b0, reason: collision with root package name */
        public volatile boolean f114482b0;

        /* renamed from: d, reason: collision with root package name */
        public boolean f114483d;

        /* renamed from: e, reason: collision with root package name */
        public com.tencent.hlyyb.downloader.e.f.b f114484e;

        /* renamed from: f, reason: collision with root package name */
        public com.tencent.hlyyb.downloader.a.a f114485f;

        /* renamed from: h, reason: collision with root package name */
        public j f114486h;

        /* renamed from: i, reason: collision with root package name */
        public i f114487i;

        /* renamed from: m, reason: collision with root package name */
        public com.tencent.hlyyb.downloader.e.f.a f114488m;

        public d(com.tencent.hlyyb.downloader.e.f.b bVar, boolean z16, com.tencent.hlyyb.downloader.a.a aVar, j jVar, Map<String, String> map, boolean z17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, bVar, Boolean.valueOf(z16), aVar, jVar, map, Boolean.valueOf(z17));
                return;
            }
            this.f114483d = true;
            this.C = null;
            this.D = 0;
            this.E = "";
            this.F = false;
            this.G = false;
            this.I = new Object();
            this.J = new com.tencent.hlyyb.downloader.e.d.b();
            this.L = true;
            this.R = false;
            this.S = false;
            this.V = true;
            this.W = true;
            this.X = 3;
            this.Y = false;
            this.f114482b0 = true;
            this.f114484e = bVar;
            this.f114483d = z16;
            this.J.f114500a = z16;
            this.f114485f = aVar;
            this.f114486h = jVar;
            this.C = map;
            this.L = z17;
        }

        private boolean c(com.tencent.hlyyb.downloader.e.f.a aVar) {
            List<com.tencent.hlyyb.downloader.d.a> s16;
            if (this.f114484e.a() <= 0 || (s16 = this.f114484e.s()) == null || s16.size() <= 0 || TextUtils.isEmpty(this.f114484e.r()) || aVar == null || this.N.get(aVar) != null || !this.f114482b0 || !this.L || !this.V) {
                return false;
            }
            return true;
        }

        @Override // com.tencent.hlyyb.downloader.b.c.a
        public final com.tencent.hlyyb.downloader.e.f.a a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (com.tencent.hlyyb.downloader.e.f.a) iPatchRedirector.redirect((short) 15, (Object) this);
            }
            try {
                ArrayList arrayList = new ArrayList();
                synchronized (this.M) {
                    Iterator<com.tencent.hlyyb.downloader.b.c> it = this.M.iterator();
                    while (it.hasNext()) {
                        arrayList.add(it.next().f114410d);
                    }
                }
                com.tencent.hlyyb.downloader.e.f.a e16 = this.f114484e.e(arrayList, this.T.get() >= this.X);
                if (c(e16)) {
                    com.tencent.hlyyb.downloader.b.c cVar = new com.tencent.hlyyb.downloader.b.c((h) this.f114485f, this.f114484e, e16, this.M, this.N, this, false, this.U, this.T);
                    synchronized (this.M) {
                        this.M.add(cVar);
                    }
                    this.N.put(e16, cVar);
                    cVar.f114426t = this.f114481a0;
                    cVar.f114407a = true;
                    cVar.f114415i = com.tencent.hlyyb.downloader.f.a.a().c(cVar);
                }
                return e16;
            } catch (Exception e17) {
                e17.printStackTrace();
                return null;
            }
        }

        public final void b(List<com.tencent.hlyyb.downloader.b.c> list, Map<com.tencent.hlyyb.downloader.e.f.a, com.tencent.hlyyb.downloader.b.c> map, Map<com.tencent.hlyyb.downloader.e.f.a, List<String>> map2, com.tencent.hlyyb.downloader.b.a aVar, AtomicInteger atomicInteger, AtomicInteger atomicInteger2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, this, list, map, map2, aVar, atomicInteger, atomicInteger2, Long.valueOf(j3));
                return;
            }
            this.M = list;
            this.N = map;
            this.P = map2;
            this.Q = aVar;
            this.T = atomicInteger;
            this.U = atomicInteger2;
            this.f114481a0 = j3;
        }

        public final int e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.D;
        }

        public final String f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.E;
        }

        public final void g() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
                return;
            }
            com.tencent.hlyyb.downloader.a.a.c cVar = this.H;
            if (cVar != null) {
                cVar.b();
            }
        }

        public final void h() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
                return;
            }
            try {
                this.F = true;
                com.tencent.hlyyb.downloader.a.a.c cVar = this.H;
                if (cVar != null) {
                    cVar.b();
                }
                synchronized (this.I) {
                    this.I.notifyAll();
                }
            } catch (Throwable unused) {
            }
        }

        public final boolean i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
            }
            return this.G;
        }

        public final String j() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            com.tencent.hlyyb.downloader.e.d.b bVar = this.J;
            if (bVar != null) {
                return bVar.a();
            }
            return "";
        }

        public final String k() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (String) iPatchRedirector.redirect((short) 11, (Object) this);
            }
            com.tencent.hlyyb.downloader.e.d.b bVar = this.J;
            if (bVar != null) {
                return bVar.toString();
            }
            return "";
        }

        public final String l() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (String) iPatchRedirector.redirect((short) 12, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            sb6.append(!this.f114483d ? 1 : 0);
            sb5.append(sb6.toString());
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(this.K);
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            StringBuilder sb7 = new StringBuilder();
            sb7.append(this.D);
            sb5.append(sb7.toString());
            sb5.append(",");
            sb5.append(",");
            sb5.append(",");
            sb5.append(";");
            return sb5.toString();
        }

        public final int m() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
            }
            return this.Z;
        }

        public final String n() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (String) iPatchRedirector.redirect((short) 18, (Object) this);
            }
            try {
                com.tencent.hlyyb.downloader.a.a.c cVar = this.H;
                if (cVar != null) {
                    return ((com.tencent.hlyyb.downloader.a.a.a) cVar).f();
                }
                return "";
            } catch (Exception e16) {
                e16.printStackTrace();
                return "";
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:201:0x0539, code lost:
        
            r10 = r9;
         */
        /* JADX WARN: Code restructure failed: missing block: B:202:0x053a, code lost:
        
            r35.R = r3;
            r35.f114486h.c(r35);
            r35.H = null;
            r35.K = r10.e();
            r10.s();
         */
        /* JADX WARN: Code restructure failed: missing block: B:328:0x040c, code lost:
        
            r9 = r34;
            r3 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:368:0x02c1, code lost:
        
            r3 = false;
            r15 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:410:0x00fc, code lost:
        
            if (r2 != com.tencent.hlyyb.downloader.e.f.a.EnumC5821a.f114543g) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:412:0x0104, code lost:
        
            if (r2 == null) goto L91;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x05f1, code lost:
        
            r15 = r10;
         */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0148  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0158 A[Catch: all -> 0x0140, TryCatch #0 {all -> 0x0140, blocks: (B:391:0x0138, B:102:0x014c, B:104:0x0158, B:106:0x0160, B:107:0x0166), top: B:390:0x0138 }] */
        /* JADX WARN: Removed duplicated region for block: B:122:0x05d0 A[DONT_GENERATE] */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01a9 A[Catch: all -> 0x05a6, TryCatch #3 {all -> 0x05a6, blocks: (B:131:0x0195, B:133:0x019b, B:135:0x019f, B:137:0x01a9, B:139:0x01de, B:141:0x01e2, B:143:0x0200, B:147:0x0246, B:149:0x0259, B:151:0x0261), top: B:130:0x0195 }] */
        /* JADX WARN: Removed duplicated region for block: B:221:0x0517  */
        /* JADX WARN: Removed duplicated region for block: B:259:0x0351  */
        /* JADX WARN: Removed duplicated region for block: B:260:0x035c  */
        /* JADX WARN: Removed duplicated region for block: B:296:0x0411 A[Catch: all -> 0x0592, TRY_ENTER, TryCatch #10 {all -> 0x0592, blocks: (B:292:0x03f2, B:296:0x0411, B:298:0x0417, B:304:0x0428), top: B:291:0x03f2 }] */
        /* JADX WARN: Removed duplicated region for block: B:334:0x040c A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:384:0x01a7 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:389:0x014b  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void run() {
            boolean z16;
            boolean z17;
            com.tencent.hlyyb.downloader.e.f.a b16;
            boolean z18;
            boolean z19;
            com.tencent.hlyyb.downloader.a.a.d dVar;
            int i3;
            com.tencent.hlyyb.downloader.a.a.d dVar2;
            b.a aVar;
            com.tencent.hlyyb.downloader.a.a.d dVar3;
            boolean z26;
            boolean b17;
            boolean z27;
            boolean z28;
            com.tencent.hlyyb.downloader.a.a aVar2;
            com.tencent.hlyyb.downloader.a.a aVar3;
            List<String> o16;
            boolean z29;
            boolean z36;
            boolean z37;
            boolean z38;
            com.tencent.hlyyb.downloader.a.a aVar4;
            com.tencent.hlyyb.downloader.a.a aVar5;
            com.tencent.hlyyb.downloader.a.a aVar6;
            com.tencent.hlyyb.downloader.a.a aVar7;
            com.tencent.hlyyb.downloader.a.a aVar8;
            com.tencent.hlyyb.downloader.a.a aVar9;
            com.tencent.hlyyb.downloader.a.a aVar10;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
                this.J.f114501b = System.currentTimeMillis();
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j3 = 0;
                boolean z39 = false;
                boolean z46 = true;
                boolean z47 = true;
                int i16 = 0;
                boolean z48 = false;
                long j16 = 0;
                while (true) {
                    if (!((this.F || (aVar10 = this.f114485f) == null) ? z46 : aVar10.b())) {
                        try {
                            if (!this.f114483d) {
                                this.f114484e.o(15000);
                                try {
                                    if (this.L && this.W && !this.Y) {
                                        this.Q.a(this.f114484e.a());
                                        this.Y = z46;
                                    }
                                } catch (Exception e16) {
                                    e16.printStackTrace();
                                }
                            }
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                        if (!((this.F || (aVar9 = this.f114485f) == null) ? z46 : aVar9.b()) && (this.f114483d || this.L)) {
                            if (i16 > 0) {
                                synchronized (this.I) {
                                    try {
                                        this.I.wait(i16);
                                    } catch (InterruptedException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                            }
                            if (!((this.F || (aVar8 = this.f114485f) == null) ? z46 : aVar8.b())) {
                                if (j16 == j3) {
                                    j16 = SystemClock.elapsedRealtime();
                                }
                                long j17 = j16;
                                if (this.S) {
                                    this.S = z39;
                                    z47 = z46;
                                    z17 = z47;
                                } else {
                                    z17 = z39;
                                }
                                if (z47) {
                                    int i17 = this.D;
                                    b16 = this.f114484e.d(com.tencent.hlyyb.common.a.a.b(), this.f114488m, this.f114483d, false, z17, (i17 == 404 || i17 == -10 || i17 == -11 || this.T.get() >= this.X) ? z46 : z39);
                                } else {
                                    int i18 = this.f114488m.f114532b;
                                    if (i18 != a.EnumC5821a.f114538b) {
                                        if (i18 != a.EnumC5821a.f114537a) {
                                        }
                                    }
                                    b16 = this.f114484e.b(i18);
                                }
                                this.f114488m = b16;
                                com.tencent.hlyyb.downloader.e.f.a aVar11 = this.f114488m;
                                aVar11.f114536f = z46;
                                com.tencent.hlyyb.downloader.b.c cVar = this.N.get(aVar11);
                                if (cVar == null || !cVar.f114412f || this.f114484e.t() <= 0 || cVar.f114414h) {
                                    i e18 = this.f114486h.e(this);
                                    this.f114487i = e18;
                                    if (e18 != null) {
                                        try {
                                            if (z48) {
                                                try {
                                                    if (!com.tencent.hlyyb.common.a.a.h()) {
                                                        z19 = z39;
                                                        i3 = !z19 ? 524288 : -1;
                                                        i iVar = this.f114487i;
                                                        boolean a16 = this.f114486h.a();
                                                        long j18 = iVar.f114638g;
                                                        if (i3 > 0) {
                                                            if (iVar.f114638g == -1) {
                                                                j18 = iVar.f114637f + i3;
                                                            } else {
                                                                long j19 = i3;
                                                                try {
                                                                    if (j19 < iVar.f114638g - iVar.f114637f) {
                                                                        j18 = iVar.f114637f + j19;
                                                                    } else if (!a16) {
                                                                        j18 = -1;
                                                                    }
                                                                } catch (Throwable th6) {
                                                                    th = th6;
                                                                    z18 = false;
                                                                    z16 = true;
                                                                    dVar = null;
                                                                    try {
                                                                        th.printStackTrace();
                                                                        this.D = -61;
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        sb5.append(th);
                                                                        this.E = sb5.toString();
                                                                        this.G = z16;
                                                                        this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                        this.f114486h.d(this);
                                                                        return;
                                                                    } finally {
                                                                        this.R = z18;
                                                                        this.f114486h.c(this);
                                                                        this.H = null;
                                                                        if (dVar != null) {
                                                                            this.K = dVar.e();
                                                                            dVar.s();
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        a.C5817a c5817a = new a.C5817a(iVar.f114637f, j18);
                                                        com.tencent.hlyyb.downloader.e.f.a aVar12 = this.f114488m;
                                                        boolean z49 = z19;
                                                        dVar2 = new com.tencent.hlyyb.downloader.a.a.d(aVar12, this.C, c5817a, z19, this, aVar12.f114534d, 1);
                                                        this.H = dVar2;
                                                        if ((!this.F || (aVar7 = this.f114485f) == null) ? true : aVar7.b()) {
                                                            com.tencent.hlyyb.downloader.e.d.b bVar = this.J;
                                                            int i19 = bVar.f114503d;
                                                            bVar.f114503d = i19 + 1;
                                                            this.Z = i19;
                                                            b.a aVar13 = new b.a(this.Z, this.f114488m);
                                                            aVar13.f114510f = SystemClock.elapsedRealtime() - elapsedRealtime;
                                                            aVar13.f114508d = z49;
                                                            aVar13.f114509e = this.f114487i.toString();
                                                            aVar13.f114513i = c5817a.toString();
                                                            long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                                            dVar2.q();
                                                            if (!((this.F || (aVar6 = this.f114485f) == null) ? true : aVar6.b())) {
                                                                this.D = dVar2.a();
                                                                this.E = dVar2.c();
                                                                aVar13.f114512h = this.D;
                                                                aVar13.f114511g = SystemClock.elapsedRealtime() - elapsedRealtime;
                                                                aVar13.f114514j = dVar2.h();
                                                                aVar13.f114516l = dVar2.j();
                                                                aVar13.f114517m = dVar2.k();
                                                                aVar13.f114515k = dVar2.d();
                                                                aVar13.f114518n = dVar2.i();
                                                                aVar13.f114519o = dVar2.l();
                                                                aVar13.f114520p = dVar2.m();
                                                                try {
                                                                    aVar13.f114525u = dVar2.a(false);
                                                                    aVar13.f114526v = dVar2.g();
                                                                    this.J.a(aVar13);
                                                                    if (this.D != -53 || this.f114486h.a()) {
                                                                        aVar = aVar13;
                                                                        dVar3 = dVar2;
                                                                    } else {
                                                                        com.tencent.hlyyb.downloader.e.f.a aVar14 = this.f114488m;
                                                                        dVar3 = new com.tencent.hlyyb.downloader.a.a.d(aVar14, this.C, null, z49, this, aVar14.f114534d, 1);
                                                                        try {
                                                                            this.H = dVar3;
                                                                            if (!((this.F || (aVar5 = this.f114485f) == null) ? true : aVar5.b())) {
                                                                                com.tencent.hlyyb.downloader.e.d.b bVar2 = this.J;
                                                                                int i26 = bVar2.f114503d;
                                                                                bVar2.f114503d = i26 + 1;
                                                                                this.Z = i26;
                                                                                b.a aVar15 = new b.a(this.Z, this.f114488m);
                                                                                aVar15.f114510f = SystemClock.elapsedRealtime() - elapsedRealtime;
                                                                                aVar15.f114508d = z49;
                                                                                aVar15.f114509e = this.f114487i.toString();
                                                                                aVar15.f114513i = "";
                                                                                dVar3.q();
                                                                                if (!((this.F || (aVar4 = this.f114485f) == null) ? true : aVar4.b())) {
                                                                                    this.D = dVar3.a();
                                                                                    this.E = dVar3.c();
                                                                                    aVar15.f114511g = SystemClock.elapsedRealtime() - elapsedRealtime;
                                                                                    aVar15.f114514j = dVar3.h();
                                                                                    aVar15.f114516l = dVar3.j();
                                                                                    aVar15.f114517m = dVar3.k();
                                                                                    aVar15.f114515k = dVar3.d();
                                                                                    aVar15.f114518n = dVar3.i();
                                                                                    aVar15.f114519o = dVar3.l();
                                                                                    aVar15.f114520p = dVar3.m();
                                                                                    try {
                                                                                        aVar15.f114525u = dVar3.a(false);
                                                                                        aVar15.f114526v = dVar3.g();
                                                                                        this.J.a(aVar15);
                                                                                        aVar = aVar15;
                                                                                    } catch (Throwable th7) {
                                                                                        th = th7;
                                                                                        z18 = false;
                                                                                        dVar = dVar3;
                                                                                        z16 = true;
                                                                                        th.printStackTrace();
                                                                                        this.D = -61;
                                                                                        StringBuilder sb52 = new StringBuilder();
                                                                                        sb52.append(th);
                                                                                        this.E = sb52.toString();
                                                                                        this.G = z16;
                                                                                        this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                                        this.f114486h.d(this);
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch (Throwable th8) {
                                                                            th = th8;
                                                                            dVar = dVar3;
                                                                            z18 = false;
                                                                            z16 = true;
                                                                            th.printStackTrace();
                                                                            this.D = -61;
                                                                            StringBuilder sb522 = new StringBuilder();
                                                                            sb522.append(th);
                                                                            this.E = sb522.toString();
                                                                            this.G = z16;
                                                                            this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                            this.f114486h.d(this);
                                                                            return;
                                                                        }
                                                                    }
                                                                    try {
                                                                        long elapsedRealtime3 = SystemClock.elapsedRealtime() - elapsedRealtime2;
                                                                        int i27 = this.D;
                                                                        int i28 = 1000;
                                                                        if (i27 != 0) {
                                                                            if (i27 == -59) {
                                                                                z37 = false;
                                                                                z49 = true;
                                                                            } else {
                                                                                z37 = true;
                                                                            }
                                                                            if (elapsedRealtime3 > 10000) {
                                                                                z47 = z37;
                                                                                dVar2 = dVar3;
                                                                                z48 = z49;
                                                                                z18 = false;
                                                                                i16 = 0;
                                                                            } else {
                                                                                if (i27 != -16 && i27 != -15 && i27 != -77) {
                                                                                    z38 = false;
                                                                                    if (z38) {
                                                                                        z47 = z37;
                                                                                        dVar2 = dVar3;
                                                                                        z48 = z49;
                                                                                        i16 = 1000;
                                                                                        z18 = false;
                                                                                    } else {
                                                                                        i16 = 3000;
                                                                                        dVar2 = dVar3;
                                                                                        z48 = z49;
                                                                                        z18 = false;
                                                                                        z28 = true;
                                                                                        z16 = true;
                                                                                        z47 = z37;
                                                                                    }
                                                                                }
                                                                                z38 = true;
                                                                                if (z38) {
                                                                                }
                                                                            }
                                                                            z28 = true;
                                                                            z16 = true;
                                                                        } else {
                                                                            try {
                                                                                if (!this.f114484e.k(false) || (o16 = dVar3.o()) == null || o16.size() <= 0) {
                                                                                    z26 = false;
                                                                                } else {
                                                                                    Iterator<String> it = o16.iterator();
                                                                                    while (it.hasNext()) {
                                                                                        this.f114484e.j(com.tencent.hlyyb.common.a.a.b(), it.next(), a.EnumC5821a.f114541e);
                                                                                    }
                                                                                    z26 = false;
                                                                                    try {
                                                                                        this.f114484e.q(false);
                                                                                    } catch (Throwable th9) {
                                                                                        th = th9;
                                                                                        z18 = false;
                                                                                        dVar = dVar3;
                                                                                        z16 = true;
                                                                                        th.printStackTrace();
                                                                                        this.D = -61;
                                                                                        StringBuilder sb5222 = new StringBuilder();
                                                                                        sb5222.append(th);
                                                                                        this.E = sb5222.toString();
                                                                                        this.G = z16;
                                                                                        this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                                        this.f114486h.d(this);
                                                                                        return;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th10) {
                                                                                th = th10;
                                                                                z18 = false;
                                                                            }
                                                                            try {
                                                                                if ((this.F || (aVar3 = this.f114485f) == null) ? true : aVar3.b()) {
                                                                                    z18 = z26;
                                                                                    dVar2 = dVar3;
                                                                                    z16 = true;
                                                                                } else {
                                                                                    com.tencent.hlyyb.downloader.a.a.d dVar4 = dVar3;
                                                                                    z16 = true;
                                                                                    try {
                                                                                        com.tencent.hlyyb.common.a.e a17 = this.f114486h.a(this, this.f114488m, dVar3.f(), dVar3.d(), dVar3.p(), dVar3.l(), dVar3.m(), dVar3.i(), dVar3.n());
                                                                                        if (!this.F) {
                                                                                            try {
                                                                                                com.tencent.hlyyb.downloader.a.a aVar16 = this.f114485f;
                                                                                                if (aVar16 != null) {
                                                                                                    b17 = aVar16.b();
                                                                                                    if (b17) {
                                                                                                        int i29 = a17.f114336a;
                                                                                                        aVar.f114521q = i29;
                                                                                                        if (i29 == 0) {
                                                                                                            if (!((this.F || (aVar2 = this.f114485f) == null) ? true : aVar2.b())) {
                                                                                                                this.R = true;
                                                                                                                dVar2 = dVar4;
                                                                                                                try {
                                                                                                                    dVar2.a(this);
                                                                                                                    com.tencent.hlyyb.downloader.e.f.a aVar17 = this.f114488m;
                                                                                                                    z18 = false;
                                                                                                                    this.R = false;
                                                                                                                    aVar17.f114536f = false;
                                                                                                                    this.D = dVar2.a();
                                                                                                                    this.E = dVar2.c();
                                                                                                                    aVar.f114522r = this.D;
                                                                                                                    aVar.f114523s = this.f114487i.toString();
                                                                                                                    aVar.f114524t = SystemClock.elapsedRealtime() - elapsedRealtime;
                                                                                                                    if (!this.S) {
                                                                                                                        List<String> list = this.P.get(this.f114488m);
                                                                                                                        if (list == null) {
                                                                                                                            list = Collections.synchronizedList(new ArrayList());
                                                                                                                            this.P.put(this.f114488m, list);
                                                                                                                        }
                                                                                                                        if (this.f114487i.f114637f > this.f114487i.f114635d) {
                                                                                                                            list.add(this.f114487i.f114635d + "," + this.f114487i.f114637f);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    z27 = false;
                                                                                                                    i28 = 0;
                                                                                                                    j17 = 0;
                                                                                                                    if (this.D != 0) {
                                                                                                                        z28 = z27;
                                                                                                                        z47 = true;
                                                                                                                    }
                                                                                                                    z47 = z18;
                                                                                                                    z28 = z27;
                                                                                                                } catch (Throwable th11) {
                                                                                                                    th = th11;
                                                                                                                    z18 = false;
                                                                                                                    dVar = dVar2;
                                                                                                                    th.printStackTrace();
                                                                                                                    this.D = -61;
                                                                                                                    StringBuilder sb52222 = new StringBuilder();
                                                                                                                    sb52222.append(th);
                                                                                                                    this.E = sb52222.toString();
                                                                                                                    this.G = z16;
                                                                                                                    this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                                                                    this.f114486h.d(this);
                                                                                                                    return;
                                                                                                                }
                                                                                                            }
                                                                                                        } else {
                                                                                                            dVar2 = dVar4;
                                                                                                            z18 = false;
                                                                                                            if (i29 < 0) {
                                                                                                                this.D = i29;
                                                                                                                this.E = a17.f114337b;
                                                                                                                z27 = true;
                                                                                                                z28 = z27;
                                                                                                                z47 = true;
                                                                                                            } else {
                                                                                                                z27 = true;
                                                                                                                z47 = z18;
                                                                                                                z28 = z27;
                                                                                                            }
                                                                                                        }
                                                                                                        i16 = i28;
                                                                                                        z48 = z49;
                                                                                                    }
                                                                                                }
                                                                                            } catch (Throwable th12) {
                                                                                                th = th12;
                                                                                                dVar = dVar4;
                                                                                                z18 = false;
                                                                                                th.printStackTrace();
                                                                                                this.D = -61;
                                                                                                StringBuilder sb522222 = new StringBuilder();
                                                                                                sb522222.append(th);
                                                                                                this.E = sb522222.toString();
                                                                                                this.G = z16;
                                                                                                this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                                                this.f114486h.d(this);
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                        b17 = true;
                                                                                        if (b17) {
                                                                                        }
                                                                                    } catch (Throwable th13) {
                                                                                        th = th13;
                                                                                        dVar2 = dVar4;
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th14) {
                                                                                th = th14;
                                                                                z18 = z26;
                                                                                dVar2 = dVar3;
                                                                                z16 = true;
                                                                                dVar = dVar2;
                                                                                th.printStackTrace();
                                                                                this.D = -61;
                                                                                StringBuilder sb5222222 = new StringBuilder();
                                                                                sb5222222.append(th);
                                                                                this.E = sb5222222.toString();
                                                                                this.G = z16;
                                                                                this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                                this.f114486h.d(this);
                                                                                return;
                                                                            }
                                                                        }
                                                                        if (z28) {
                                                                            try {
                                                                                long elapsedRealtime4 = SystemClock.elapsedRealtime() - j17;
                                                                                if (elapsedRealtime4 <= 60000) {
                                                                                    int i36 = this.D;
                                                                                    if (i36 != -16 && i36 != -15 && i36 != -77) {
                                                                                        z29 = z18;
                                                                                        if (z29 || elapsedRealtime4 <= 20000) {
                                                                                            if (i36 != -76 && i36 != -73 && i36 != -71 && i36 != -68 && i36 != -51 && i36 != -44 && i36 != -43 && i36 != -11 && i36 != -10) {
                                                                                                switch (i36) {
                                                                                                    case -56:
                                                                                                    case -55:
                                                                                                    case -54:
                                                                                                        break;
                                                                                                    default:
                                                                                                        if (i36 > 0 && i36 != 200 && i36 != 206) {
                                                                                                            break;
                                                                                                        } else {
                                                                                                            z36 = z18;
                                                                                                            break;
                                                                                                        }
                                                                                                }
                                                                                            }
                                                                                            z36 = z16;
                                                                                            if ((z36 || elapsedRealtime4 <= 10000) && (i36 != -15 || elapsedRealtime4 <= com.tencent.hlyyb.downloader.a.b.d())) {
                                                                                                if (this.D == -51 && this.f114488m.f114532b == a.EnumC5821a.f114538b) {
                                                                                                    SystemClock.sleep(1000L);
                                                                                                    this.R = z18;
                                                                                                    this.f114486h.c(this);
                                                                                                    this.H = null;
                                                                                                    this.K = dVar2.e();
                                                                                                    dVar2.s();
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                    z29 = z16;
                                                                                    if (z29) {
                                                                                    }
                                                                                    if (i36 != -76) {
                                                                                        switch (i36) {
                                                                                        }
                                                                                    }
                                                                                    z36 = z16;
                                                                                    if (z36) {
                                                                                    }
                                                                                    if (this.D == -51) {
                                                                                        SystemClock.sleep(1000L);
                                                                                        this.R = z18;
                                                                                        this.f114486h.c(this);
                                                                                        this.H = null;
                                                                                        this.K = dVar2.e();
                                                                                        dVar2.s();
                                                                                    }
                                                                                }
                                                                            } catch (Throwable th15) {
                                                                                th = th15;
                                                                                dVar = dVar2;
                                                                                th.printStackTrace();
                                                                                this.D = -61;
                                                                                StringBuilder sb52222222 = new StringBuilder();
                                                                                sb52222222.append(th);
                                                                                this.E = sb52222222.toString();
                                                                                this.G = z16;
                                                                                this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                                                this.f114486h.d(this);
                                                                                return;
                                                                            }
                                                                        }
                                                                        this.R = z18;
                                                                        this.f114486h.c(this);
                                                                        this.H = null;
                                                                        this.K = dVar2.e();
                                                                        dVar2.s();
                                                                        z39 = z18;
                                                                        z46 = z16;
                                                                        j16 = j17;
                                                                        j3 = 0;
                                                                    } catch (Throwable th16) {
                                                                        th = th16;
                                                                        dVar2 = dVar3;
                                                                        z18 = false;
                                                                    }
                                                                } catch (Throwable th17) {
                                                                    th = th17;
                                                                    z18 = false;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } catch (Throwable th18) {
                                                    th = th18;
                                                    z16 = z46;
                                                    z18 = z39;
                                                    dVar = null;
                                                    th.printStackTrace();
                                                    this.D = -61;
                                                    StringBuilder sb522222222 = new StringBuilder();
                                                    sb522222222.append(th);
                                                    this.E = sb522222222.toString();
                                                    this.G = z16;
                                                    this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                                                    this.f114486h.d(this);
                                                    return;
                                                }
                                            }
                                            this.H = dVar2;
                                            if ((!this.F || (aVar7 = this.f114485f) == null) ? true : aVar7.b()) {
                                            }
                                        } catch (Throwable th19) {
                                            th = th19;
                                            z18 = false;
                                        }
                                        z19 = z48;
                                        if (!z19) {
                                        }
                                        i iVar2 = this.f114487i;
                                        boolean a162 = this.f114486h.a();
                                        long j182 = iVar2.f114638g;
                                        if (i3 > 0) {
                                        }
                                        a.C5817a c5817a2 = new a.C5817a(iVar2.f114637f, j182);
                                        com.tencent.hlyyb.downloader.e.f.a aVar122 = this.f114488m;
                                        boolean z492 = z19;
                                        dVar2 = new com.tencent.hlyyb.downloader.a.a.d(aVar122, this.C, c5817a2, z19, this, aVar122.f114534d, 1);
                                    }
                                } else {
                                    this.S = z46;
                                    j16 = j17;
                                }
                            }
                        }
                    }
                }
                this.R = false;
                this.f114486h.c(this);
                this.H = null;
                this.K = dVar2.e();
                dVar2.s();
                z16 = true;
                this.G = z16;
                this.J.f114502c = System.currentTimeMillis() - this.J.f114501b;
                try {
                    this.f114486h.d(this);
                    return;
                } catch (Throwable th20) {
                    th20.printStackTrace();
                    return;
                }
            }
            iPatchRedirector.redirect((short) 7, (Object) this);
        }

        @Override // com.tencent.hlyyb.downloader.b.c.a
        public final void a(com.tencent.hlyyb.downloader.e.f.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this, (Object) aVar);
                return;
            }
            com.tencent.hlyyb.downloader.b.c cVar = this.N.get(aVar);
            if (cVar == null || cVar.f114414h) {
                return;
            }
            this.Q.a(aVar, cVar);
        }

        @Override // com.tencent.hlyyb.downloader.a.a
        public final boolean b() {
            com.tencent.hlyyb.downloader.a.a aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
            }
            if (this.F || (aVar = this.f114485f) == null) {
                return true;
            }
            return aVar.b();
        }

        public final void a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
                this.f114482b0 = false;
            } else {
                iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.hlyyb.downloader.a.a.b
        public final boolean a(byte[] bArr, int i3, boolean z16) {
            byte b16;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z17 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, this, bArr, Integer.valueOf(i3), Boolean.valueOf(z16))).booleanValue();
            }
            if (c(this.f114488m)) {
                com.tencent.hlyyb.downloader.b.c cVar = new com.tencent.hlyyb.downloader.b.c((h) this.f114485f, this.f114484e, this.f114488m, this.M, this.N, this, false, this.U, this.T);
                synchronized (this.M) {
                    this.M.add(cVar);
                }
                this.N.put(this.f114488m, cVar);
                cVar.f114426t = this.f114481a0;
                cVar.f114415i = com.tencent.hlyyb.downloader.f.a.a().c(cVar);
                cVar.a(!this.f114483d ? 1 : 0, this.Z);
            }
            com.tencent.hlyyb.downloader.b.c cVar2 = this.N.get(this.f114488m);
            if (cVar2 == null || !cVar2.f114413g || cVar2.f114414h || !this.Q.a(this.f114487i, cVar2)) {
                b16 = false;
            } else {
                this.S = true;
                b16 = true;
            }
            if (b16 == true) {
                return false;
            }
            if (this.f114486h == null) {
                return true;
            }
            if (this.f114487i.f114637f + i3 >= this.f114487i.f114638g) {
                i16 = (int) (this.f114487i.f114638g - this.f114487i.f114637f);
            } else {
                i16 = i3;
                z17 = true;
            }
            return z17 & this.f114486h.b(this, this.f114487i.f114637f, bArr, i16, z16);
        }
    }

    public c(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) hVar);
            return;
        }
        this.f114466b = DownloaderTaskStatus.PENDING;
        this.f114467c = new Vector<>();
        this.f114468d = new Vector<>();
        this.f114469e = 0;
        this.f114470f = false;
        this.f114471g = new LinkedBlockingQueue<>();
        this.f114465a = hVar;
    }

    public final DownloaderTaskStatus a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f114466b : (DownloaderTaskStatus) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    public final synchronized void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f114471g.clear();
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0024. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:32:0x015d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0013 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d() {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        boolean z18 = true;
        this.f114470f = true;
        while (true) {
            try {
            } catch (InterruptedException e16) {
                e = e16;
                z16 = false;
            } catch (Throwable th5) {
                th = th5;
                z18 = false;
            }
            switch (b.f114464b[this.f114471g.take().ordinal()]) {
                case 2:
                    com.tencent.hlyyb.downloader.c.b.f().onTaskStartedSubloop(this.f114465a);
                    synchronized (this.f114467c) {
                        Iterator<DownloaderTaskListener> it = this.f114467c.iterator();
                        while (it.hasNext()) {
                            DownloaderTaskListener next = it.next();
                            if (next != null) {
                                next.onTaskStartedSubloop(this.f114465a);
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                        break;
                    }
                case 3:
                    com.tencent.hlyyb.downloader.c.b.f().onTaskDetectedSubloop(this.f114465a);
                    synchronized (this.f114467c) {
                        Iterator<DownloaderTaskListener> it5 = this.f114467c.iterator();
                        while (it5.hasNext()) {
                            DownloaderTaskListener next2 = it5.next();
                            if (next2 != null) {
                                next2.onTaskDetectedSubloop(this.f114465a);
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                    break;
                case 4:
                    com.tencent.hlyyb.downloader.c.b.f().onTaskReceivedSubloop(this.f114465a);
                    synchronized (this.f114467c) {
                        Iterator<DownloaderTaskListener> it6 = this.f114467c.iterator();
                        while (it6.hasNext()) {
                            DownloaderTaskListener next3 = it6.next();
                            if (next3 != null) {
                                next3.onTaskReceivedSubloop(this.f114465a);
                            }
                        }
                    }
                    z17 = false;
                    if (!z17) {
                    }
                    break;
                case 5:
                    com.tencent.hlyyb.downloader.c.b.f().onTaskPausedSubloop(this.f114465a);
                    synchronized (this.f114467c) {
                        Iterator<DownloaderTaskListener> it7 = this.f114467c.iterator();
                        while (it7.hasNext()) {
                            DownloaderTaskListener next4 = it7.next();
                            if (next4 != null) {
                                next4.onTaskPausedSubloop(this.f114465a);
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                    break;
                case 6:
                    com.tencent.hlyyb.downloader.c.b.f().onTaskFailedSubloop(this.f114465a);
                    synchronized (this.f114467c) {
                        Iterator<DownloaderTaskListener> it8 = this.f114467c.iterator();
                        while (it8.hasNext()) {
                            DownloaderTaskListener next5 = it8.next();
                            if (next5 != null) {
                                next5.onTaskFailedSubloop(this.f114465a);
                            }
                        }
                    }
                    z17 = true;
                    if (!z17) {
                    }
                    break;
                case 7:
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        synchronized (this.f114467c) {
                            Iterator<DownloaderTaskListener> it9 = this.f114467c.iterator();
                            while (it9.hasNext()) {
                                DownloaderTaskListener next6 = it9.next();
                                if (next6 != null) {
                                    next6.onTaskCompletedSubloop(this.f114465a);
                                }
                            }
                        }
                        this.f114469e = (int) (SystemClock.elapsedRealtime() - elapsedRealtime);
                        this.f114465a.E();
                        SystemClock.elapsedRealtime();
                        com.tencent.hlyyb.downloader.c.b.f().onTaskCompletedSubloop(this.f114465a);
                        z17 = true;
                        if (!z17) {
                        }
                    } catch (InterruptedException e17) {
                        e = e17;
                        z16 = true;
                        try {
                            e.printStackTrace();
                        } catch (Throwable th6) {
                            th = th6;
                            z18 = z16;
                            if (!z18) {
                                throw th;
                            }
                            this.f114470f = false;
                        }
                        if (z16) {
                            this.f114470f = false;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        if (!z18) {
                        }
                        this.f114470f = false;
                    }
                    break;
                case 8:
                    z17 = true;
                    if (!z17) {
                    }
                    break;
                default:
                    z17 = false;
                    if (!z17) {
                    }
                    break;
            }
        }
        this.f114470f = false;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return this.f114470f;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.f114469e;
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        synchronized (this.f114467c) {
            this.f114467c.clear();
        }
        synchronized (this.f114468d) {
            this.f114468d.clear();
        }
    }

    public final void a(DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) downloaderTaskListener);
            return;
        }
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (this.f114467c) {
                if (!this.f114467c.contains(downloaderTaskListener)) {
                    this.f114467c.add(downloaderTaskListener);
                }
            }
            synchronized (this.f114468d) {
                if (!this.f114468d.contains(downloaderTaskListener)) {
                    this.f114468d.add(downloaderTaskListener);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(DownloaderTaskListener downloaderTaskListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloaderTaskListener);
            return;
        }
        if (downloaderTaskListener == null) {
            return;
        }
        try {
            synchronized (this.f114467c) {
                if (this.f114467c.contains(downloaderTaskListener)) {
                    this.f114467c.remove(downloaderTaskListener);
                }
            }
            synchronized (this.f114468d) {
                if (this.f114468d.contains(downloaderTaskListener)) {
                    this.f114468d.remove(downloaderTaskListener);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final synchronized void a(DownloaderTaskStatus downloaderTaskStatus) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            a(downloaderTaskStatus, true);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) downloaderTaskStatus);
        }
    }

    private synchronized void a(DownloaderTaskStatus downloaderTaskStatus, boolean z16) {
        a aVar;
        if ((this.f114466b == DownloaderTaskStatus.COMPLETE || this.f114466b == DownloaderTaskStatus.FAILED || this.f114466b == DownloaderTaskStatus.PAUSED || this.f114466b == DownloaderTaskStatus.DELETED) && downloaderTaskStatus != DownloaderTaskStatus.PENDING) {
            return;
        }
        this.f114466b = downloaderTaskStatus;
        switch (b.f114463a[downloaderTaskStatus.ordinal()]) {
            case 1:
                aVar = a.f114472a;
                break;
            case 2:
                aVar = a.f114473b;
                break;
            case 3:
                aVar = a.f114475d;
                break;
            case 4:
                aVar = a.f114478g;
                break;
            case 5:
                aVar = a.f114477f;
                break;
            case 6:
                aVar = a.f114476e;
                break;
            case 7:
                aVar = a.f114479h;
                break;
            default:
                aVar = null;
                break;
        }
        a(aVar);
    }

    public final void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        if (aVar != null) {
            if (aVar != a.f114479h) {
                com.tencent.hlyyb.common.a.f().post(new e(this, aVar));
            }
            try {
                this.f114471g.put(aVar);
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
        }
    }
}

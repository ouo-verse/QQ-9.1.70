package com.tencent.luggage.wxa.m;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.luggage.wxa.d0.g;
import com.tencent.luggage.wxa.d0.h;
import com.tencent.luggage.wxa.k0.h;
import com.tencent.luggage.wxa.m.e;
import com.tencent.luggage.wxa.m.n;
import com.tencent.luggage.wxa.m.u;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements Handler.Callback, g.a, h.a, h.a {
    public p C;
    public r D;
    public com.tencent.luggage.wxa.n0.h E;
    public com.tencent.luggage.wxa.d0.h F;
    public r[] G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public int L = 1;
    public int M;
    public int N;
    public int O;
    public long P;
    public int Q;
    public c R;
    public long S;
    public a T;
    public a U;
    public a V;
    public u W;

    /* renamed from: a, reason: collision with root package name */
    public final r[] f133847a;

    /* renamed from: b, reason: collision with root package name */
    public final s[] f133848b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.k0.h f133849c;

    /* renamed from: d, reason: collision with root package name */
    public final m f133850d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.q f133851e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f133852f;

    /* renamed from: g, reason: collision with root package name */
    public final HandlerThread f133853g;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f133854h;

    /* renamed from: i, reason: collision with root package name */
    public final e f133855i;

    /* renamed from: j, reason: collision with root package name */
    public final u.c f133856j;

    /* renamed from: k, reason: collision with root package name */
    public final u.b f133857k;

    /* renamed from: l, reason: collision with root package name */
    public final n f133858l;

    /* renamed from: m, reason: collision with root package name */
    public b f133859m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.d0.g f133860a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f133861b;

        /* renamed from: c, reason: collision with root package name */
        public final int f133862c;

        /* renamed from: d, reason: collision with root package name */
        public final com.tencent.luggage.wxa.d0.k[] f133863d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean[] f133864e;

        /* renamed from: f, reason: collision with root package name */
        public final long f133865f;

        /* renamed from: g, reason: collision with root package name */
        public n.b f133866g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f133867h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f133868i;

        /* renamed from: j, reason: collision with root package name */
        public a f133869j;

        /* renamed from: k, reason: collision with root package name */
        public com.tencent.luggage.wxa.k0.i f133870k;

        /* renamed from: l, reason: collision with root package name */
        public final r[] f133871l;

        /* renamed from: m, reason: collision with root package name */
        public final s[] f133872m;

        /* renamed from: n, reason: collision with root package name */
        public final com.tencent.luggage.wxa.k0.h f133873n;

        /* renamed from: o, reason: collision with root package name */
        public final m f133874o;

        /* renamed from: p, reason: collision with root package name */
        public final com.tencent.luggage.wxa.d0.h f133875p;

        /* renamed from: q, reason: collision with root package name */
        public com.tencent.luggage.wxa.k0.i f133876q;

        public a(r[] rVarArr, s[] sVarArr, long j3, com.tencent.luggage.wxa.k0.h hVar, m mVar, com.tencent.luggage.wxa.d0.h hVar2, Object obj, int i3, n.b bVar) {
            this.f133871l = rVarArr;
            this.f133872m = sVarArr;
            this.f133865f = j3;
            this.f133873n = hVar;
            this.f133874o = mVar;
            this.f133875p = hVar2;
            this.f133861b = com.tencent.luggage.wxa.n0.a.a(obj);
            this.f133862c = i3;
            this.f133866g = bVar;
            this.f133863d = new com.tencent.luggage.wxa.d0.k[rVarArr.length];
            this.f133864e = new boolean[rVarArr.length];
            com.tencent.luggage.wxa.d0.g a16 = hVar2.a(bVar.f133912a, mVar.b());
            if (bVar.f133914c != Long.MIN_VALUE) {
                com.tencent.luggage.wxa.d0.c cVar = new com.tencent.luggage.wxa.d0.c(a16, true);
                cVar.a(0L, bVar.f133914c);
                a16 = cVar;
            }
            this.f133860a = a16;
        }

        public long a() {
            return this.f133862c == 0 ? this.f133865f : this.f133865f - this.f133866g.f133913b;
        }

        public void b() {
            this.f133867h = true;
            e();
            this.f133866g = this.f133866g.a(a(this.f133866g.f133913b, false));
        }

        public long c(long j3) {
            return j3 - a();
        }

        public long d(long j3) {
            return j3 + a();
        }

        public boolean e() {
            com.tencent.luggage.wxa.k0.i a16 = this.f133873n.a(this.f133872m, this.f133860a.g());
            if (a16.a(this.f133876q)) {
                return false;
            }
            this.f133870k = a16;
            return true;
        }

        public boolean a(boolean z16, long j3) {
            long c16 = !this.f133867h ? this.f133866g.f133913b : this.f133860a.c();
            if (c16 == Long.MIN_VALUE) {
                n.b bVar = this.f133866g;
                if (bVar.f133918g) {
                    return true;
                }
                c16 = bVar.f133916e;
            }
            return this.f133874o.a(c16 - c(j3), z16);
        }

        public boolean c() {
            return this.f133867h && (!this.f133868i || this.f133860a.c() == Long.MIN_VALUE);
        }

        public void d() {
            try {
                if (this.f133866g.f133914c != Long.MIN_VALUE) {
                    this.f133875p.a(((com.tencent.luggage.wxa.d0.c) this.f133860a).f123937a);
                } else {
                    this.f133875p.a(this.f133860a);
                }
            } catch (RuntimeException e16) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e16);
            }
        }

        public boolean b(long j3) {
            long b16 = !this.f133867h ? 0L : this.f133860a.b();
            if (b16 == Long.MIN_VALUE) {
                return false;
            }
            return this.f133874o.a(b16 - c(j3));
        }

        public void a(long j3) {
            this.f133860a.a(c(j3));
        }

        public long a(long j3, boolean z16) {
            return a(j3, z16, new boolean[this.f133871l.length]);
        }

        public long a(long j3, boolean z16, boolean[] zArr) {
            com.tencent.luggage.wxa.k0.g gVar = this.f133870k.f131410b;
            int i3 = 0;
            while (true) {
                boolean z17 = true;
                if (i3 >= gVar.f131405a) {
                    break;
                }
                boolean[] zArr2 = this.f133864e;
                if (z16 || !this.f133870k.a(this.f133876q, i3)) {
                    z17 = false;
                }
                zArr2[i3] = z17;
                i3++;
            }
            long a16 = this.f133860a.a(gVar.a(), this.f133864e, this.f133863d, zArr, j3);
            this.f133876q = this.f133870k;
            this.f133868i = false;
            int i16 = 0;
            while (true) {
                com.tencent.luggage.wxa.d0.k[] kVarArr = this.f133863d;
                if (i16 < kVarArr.length) {
                    if (kVarArr[i16] != null) {
                        com.tencent.luggage.wxa.n0.a.b(gVar.a(i16) != null);
                        this.f133868i = true;
                    } else {
                        com.tencent.luggage.wxa.n0.a.b(gVar.a(i16) == null);
                    }
                    i16++;
                } else {
                    this.f133874o.a(this.f133871l, this.f133870k.f131409a, gVar);
                    return a16;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final h.b f133877a;

        /* renamed from: b, reason: collision with root package name */
        public final long f133878b;

        /* renamed from: c, reason: collision with root package name */
        public final long f133879c;

        /* renamed from: d, reason: collision with root package name */
        public volatile long f133880d;

        /* renamed from: e, reason: collision with root package name */
        public volatile long f133881e;

        public b(int i3, long j3) {
            this(new h.b(i3), j3);
        }

        public b a(int i3) {
            b bVar = new b(this.f133877a.a(i3), this.f133878b, this.f133879c);
            bVar.f133880d = this.f133880d;
            bVar.f133881e = this.f133881e;
            return bVar;
        }

        public b(h.b bVar, long j3) {
            this(bVar, j3, -9223372036854775807L);
        }

        public b(h.b bVar, long j3, long j16) {
            this.f133877a = bVar;
            this.f133878b = j3;
            this.f133879c = j16;
            this.f133880d = j3;
            this.f133881e = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final u f133882a;

        /* renamed from: b, reason: collision with root package name */
        public final int f133883b;

        /* renamed from: c, reason: collision with root package name */
        public final long f133884c;

        public c(u uVar, int i3, long j3) {
            this.f133882a = uVar;
            this.f133883b = i3;
            this.f133884c = j3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final u f133885a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f133886b;

        /* renamed from: c, reason: collision with root package name */
        public final b f133887c;

        /* renamed from: d, reason: collision with root package name */
        public final int f133888d;

        public d(u uVar, Object obj, b bVar, int i3) {
            this.f133885a = uVar;
            this.f133886b = obj;
            this.f133887c = bVar;
            this.f133888d = i3;
        }
    }

    public h(r[] rVarArr, com.tencent.luggage.wxa.k0.h hVar, m mVar, boolean z16, int i3, Handler handler, b bVar, e eVar) {
        this.f133847a = rVarArr;
        this.f133849c = hVar;
        this.f133850d = mVar;
        this.I = z16;
        this.M = i3;
        this.f133854h = handler;
        this.f133859m = bVar;
        this.f133855i = eVar;
        this.f133848b = new s[rVarArr.length];
        for (int i16 = 0; i16 < rVarArr.length; i16++) {
            rVarArr[i16].a(i16);
            this.f133848b[i16] = rVarArr[i16].i();
        }
        this.f133851e = new com.tencent.luggage.wxa.n0.q();
        this.G = new r[0];
        this.f133856j = new u.c();
        this.f133857k = new u.b();
        this.f133858l = new n();
        hVar.a((h.a) this);
        this.C = p.f133919d;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f133853g = baseHandlerThread;
        baseHandlerThread.start();
        this.f133852f = new Handler(baseHandlerThread.getLooper(), this);
    }

    public void b(e.c... cVarArr) {
        if (this.H) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.N++;
            this.f133852f.obtainMessage(11, cVarArr).sendToTarget();
        }
    }

    public void c(boolean z16) {
        this.f133852f.obtainMessage(1, z16 ? 1 : 0, 0).sendToTarget();
    }

    @Override // com.tencent.luggage.wxa.d0.l.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(com.tencent.luggage.wxa.d0.g gVar) {
        this.f133852f.obtainMessage(9, gVar).sendToTarget();
    }

    public final void e() {
        n.b a16;
        long a17;
        int i3;
        a aVar = this.T;
        if (aVar == null) {
            a16 = this.f133858l.a(this.f133859m);
        } else if (!aVar.f133866g.f133918g && aVar.c()) {
            a aVar2 = this.T;
            n.b bVar = aVar2.f133866g;
            if (bVar.f133916e != -9223372036854775807L) {
                a aVar3 = this.V;
                if (aVar3 != null && aVar2.f133862c - aVar3.f133862c == 100) {
                    return;
                } else {
                    a16 = this.f133858l.a(bVar, aVar2.a(), this.S);
                }
            } else {
                return;
            }
        } else {
            return;
        }
        if (a16 == null) {
            this.F.a();
            return;
        }
        a aVar4 = this.T;
        if (aVar4 == null) {
            a17 = AEEditorConstants.MAX_CLIP_TIME_US;
        } else {
            a17 = aVar4.a() + this.T.f133866g.f133916e;
        }
        long j3 = a17;
        a aVar5 = this.T;
        if (aVar5 == null) {
            i3 = 0;
        } else {
            i3 = aVar5.f133862c + 1;
        }
        Object obj = this.W.a(a16.f133912a.f123995a, this.f133857k, true).f133927b;
        a aVar6 = new a(this.f133847a, this.f133848b, j3, this.f133849c, this.f133850d, this.F, obj, i3, a16);
        a aVar7 = this.T;
        if (aVar7 != null) {
            aVar7.f133869j = aVar6;
        }
        this.T = aVar6;
        aVar6.f133860a.a(this, a16.f133913b);
        b(true);
    }

    public synchronized void f() {
        if (this.H) {
            return;
        }
        this.f133852f.sendEmptyMessage(6);
        boolean z16 = false;
        while (!this.H) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
        this.f133853g.quit();
    }

    public final void g() {
        a(true);
        this.f133850d.d();
        b(1);
        synchronized (this) {
            this.H = true;
            notifyAll();
        }
    }

    public final void h() {
        boolean z16;
        boolean z17;
        a aVar = this.V;
        if (aVar == null) {
            return;
        }
        boolean z18 = true;
        while (aVar != null && aVar.f133867h) {
            if (aVar.e()) {
                if (z18) {
                    a aVar2 = this.U;
                    a aVar3 = this.V;
                    if (aVar2 != aVar3) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    a(aVar3.f133869j);
                    a aVar4 = this.V;
                    aVar4.f133869j = null;
                    this.T = aVar4;
                    this.U = aVar4;
                    boolean[] zArr = new boolean[this.f133847a.length];
                    long a16 = aVar4.a(this.f133859m.f133880d, z16, zArr);
                    if (a16 != this.f133859m.f133880d) {
                        this.f133859m.f133880d = a16;
                        b(a16);
                    }
                    boolean[] zArr2 = new boolean[this.f133847a.length];
                    int i3 = 0;
                    int i16 = 0;
                    while (true) {
                        r[] rVarArr = this.f133847a;
                        if (i3 >= rVarArr.length) {
                            break;
                        }
                        r rVar = rVarArr[i3];
                        if (rVar.getState() != 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        zArr2[i3] = z17;
                        com.tencent.luggage.wxa.d0.k kVar = this.V.f133863d[i3];
                        if (kVar != null) {
                            i16++;
                        }
                        if (z17) {
                            if (kVar != rVar.l()) {
                                if (rVar == this.D) {
                                    if (kVar == null) {
                                        this.f133851e.a(this.E);
                                    }
                                    this.E = null;
                                    this.D = null;
                                }
                                a(rVar);
                                rVar.e();
                            } else if (zArr[i3]) {
                                rVar.a(this.S);
                            }
                        }
                        i3++;
                    }
                    this.f133854h.obtainMessage(3, aVar.f133870k).sendToTarget();
                    a(zArr2, i16);
                } else {
                    this.T = aVar;
                    for (a aVar5 = aVar.f133869j; aVar5 != null; aVar5 = aVar5.f133869j) {
                        aVar5.d();
                    }
                    a aVar6 = this.T;
                    aVar6.f133869j = null;
                    if (aVar6.f133867h) {
                        this.T.a(Math.max(aVar6.f133866g.f133913b, aVar6.c(this.S)), false);
                    }
                }
                c();
                n();
                this.f133852f.sendEmptyMessage(2);
                return;
            }
            if (aVar == this.U) {
                z18 = false;
            }
            aVar = aVar.f133869j;
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            boolean z16 = false;
            switch (message.what) {
                case 0:
                    com.tencent.luggage.wxa.d0.h hVar = (com.tencent.luggage.wxa.d0.h) message.obj;
                    if (message.arg1 != 0) {
                        z16 = true;
                    }
                    b(hVar, z16);
                    return true;
                case 1:
                    if (message.arg1 != 0) {
                        z16 = true;
                    }
                    d(z16);
                    return true;
                case 2:
                    b();
                    return true;
                case 3:
                    b((c) message.obj);
                    return true;
                case 4:
                    b((p) message.obj);
                    return true;
                case 5:
                    k();
                    return true;
                case 6:
                    g();
                    return true;
                case 7:
                    a((Pair) message.obj);
                    return true;
                case 8:
                    c((com.tencent.luggage.wxa.d0.g) message.obj);
                    return true;
                case 9:
                    b((com.tencent.luggage.wxa.d0.g) message.obj);
                    return true;
                case 10:
                    h();
                    return true;
                case 11:
                    c((e.c[]) message.obj);
                    return true;
                case 12:
                    a(message.arg1);
                    return true;
                default:
                    return false;
            }
        } catch (com.tencent.luggage.wxa.m.d e16) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e16);
            this.f133854h.obtainMessage(8, e16).sendToTarget();
            k();
            return true;
        } catch (IOException e17) {
            Log.e("ExoPlayerImplInternal", "Source error.", e17);
            this.f133854h.obtainMessage(8, com.tencent.luggage.wxa.m.d.a(e17)).sendToTarget();
            k();
            return true;
        } catch (RuntimeException e18) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e18);
            this.f133854h.obtainMessage(8, com.tencent.luggage.wxa.m.d.a(e18)).sendToTarget();
            k();
            return true;
        }
    }

    public final void i() {
        this.J = false;
        this.f133851e.a();
        for (r rVar : this.G) {
            rVar.start();
        }
    }

    public void j() {
        this.f133852f.sendEmptyMessage(5);
    }

    public final void k() {
        a(true);
        this.f133850d.c();
        b(1);
    }

    public final void l() {
        this.f133851e.b();
        for (r rVar : this.G) {
            a(rVar);
        }
    }

    public final void m() {
        a aVar;
        boolean z16;
        com.tencent.luggage.wxa.d0.h hVar;
        if (this.W == null && (hVar = this.F) != null) {
            hVar.a();
            return;
        }
        e();
        a aVar2 = this.T;
        int i3 = 0;
        if (aVar2 != null && !aVar2.c()) {
            if (this.T != null && !this.K) {
                c();
            }
        } else {
            b(false);
        }
        if (this.V == null) {
            return;
        }
        while (true) {
            a aVar3 = this.V;
            aVar = this.U;
            if (aVar3 == aVar || this.S < aVar3.f133869j.f133865f) {
                break;
            }
            aVar3.d();
            b(this.V.f133869j);
            n.b bVar = this.V.f133866g;
            this.f133859m = new b(bVar.f133912a, bVar.f133913b, bVar.f133915d);
            n();
            this.f133854h.obtainMessage(5, this.f133859m).sendToTarget();
        }
        if (aVar.f133866g.f133918g) {
            while (true) {
                r[] rVarArr = this.f133847a;
                if (i3 < rVarArr.length) {
                    r rVar = rVarArr[i3];
                    com.tencent.luggage.wxa.d0.k kVar = this.U.f133863d[i3];
                    if (kVar != null && rVar.l() == kVar && rVar.c()) {
                        rVar.d();
                    }
                    i3++;
                } else {
                    return;
                }
            }
        } else {
            int i16 = 0;
            while (true) {
                r[] rVarArr2 = this.f133847a;
                if (i16 < rVarArr2.length) {
                    r rVar2 = rVarArr2[i16];
                    com.tencent.luggage.wxa.d0.k kVar2 = this.U.f133863d[i16];
                    if (rVar2.l() == kVar2) {
                        if (kVar2 == null || rVar2.c()) {
                            i16++;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    a aVar4 = this.U;
                    a aVar5 = aVar4.f133869j;
                    if (aVar5 != null && aVar5.f133867h) {
                        com.tencent.luggage.wxa.k0.i iVar = aVar4.f133870k;
                        this.U = aVar5;
                        com.tencent.luggage.wxa.k0.i iVar2 = aVar5.f133870k;
                        if (aVar5.f133860a.d() != -9223372036854775807L) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        int i17 = 0;
                        while (true) {
                            r[] rVarArr3 = this.f133847a;
                            if (i17 < rVarArr3.length) {
                                r rVar3 = rVarArr3[i17];
                                if (iVar.f131410b.a(i17) != null) {
                                    if (z16) {
                                        rVar3.d();
                                    } else if (!rVar3.g()) {
                                        com.tencent.luggage.wxa.k0.f a16 = iVar2.f131410b.a(i17);
                                        t tVar = iVar.f131412d[i17];
                                        t tVar2 = iVar2.f131412d[i17];
                                        if (a16 != null && tVar2.equals(tVar)) {
                                            int length = a16.length();
                                            j[] jVarArr = new j[length];
                                            for (int i18 = 0; i18 < length; i18++) {
                                                jVarArr[i18] = a16.a(i18);
                                            }
                                            a aVar6 = this.U;
                                            rVar3.a(jVarArr, aVar6.f133863d[i17], aVar6.a());
                                        } else {
                                            rVar3.d();
                                        }
                                    }
                                }
                                i17++;
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void n() {
        long c16;
        a aVar = this.V;
        if (aVar == null) {
            return;
        }
        long d16 = aVar.f133860a.d();
        if (d16 != -9223372036854775807L) {
            b(d16);
        } else {
            r rVar = this.D;
            if (rVar != null && !rVar.b()) {
                long j3 = this.E.j();
                this.S = j3;
                this.f133851e.a(j3);
            } else {
                this.S = this.f133851e.j();
            }
            d16 = this.V.c(this.S);
        }
        this.f133859m.f133880d = d16;
        this.P = SystemClock.elapsedRealtime() * 1000;
        if (this.G.length == 0) {
            c16 = Long.MIN_VALUE;
        } else {
            c16 = this.V.f133860a.c();
        }
        b bVar = this.f133859m;
        if (c16 == Long.MIN_VALUE) {
            c16 = this.V.f133866g.f133916e;
        }
        bVar.f133881e = c16;
    }

    public void a(com.tencent.luggage.wxa.d0.h hVar, boolean z16) {
        this.f133852f.obtainMessage(0, z16 ? 1 : 0, 0, hVar).sendToTarget();
    }

    public final void c(e.c[] cVarArr) {
        try {
            for (e.c cVar : cVarArr) {
                cVar.f133819a.a(cVar.f133820b, cVar.f133821c);
            }
            int i3 = this.L;
            if (i3 == 3 || i3 == 2) {
                this.f133852f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.O++;
                notifyAll();
            }
        } catch (Throwable th5) {
            synchronized (this) {
                this.O++;
                notifyAll();
                throw th5;
            }
        }
    }

    public final void d(boolean z16) {
        this.J = false;
        this.I = z16;
        if (!z16) {
            l();
            n();
            return;
        }
        int i3 = this.L;
        if (i3 == 3) {
            i();
            this.f133852f.sendEmptyMessage(2);
        } else if (i3 == 2) {
            this.f133852f.sendEmptyMessage(2);
        }
    }

    public void a(u uVar, int i3, long j3) {
        this.f133852f.obtainMessage(3, new c(uVar, i3, j3)).sendToTarget();
    }

    public final void b(int i3) {
        if (this.L != i3) {
            this.L = i3;
            this.f133854h.obtainMessage(1, i3, 0).sendToTarget();
        }
    }

    public void a(p pVar) {
        this.f133852f.obtainMessage(4, pVar).sendToTarget();
    }

    public synchronized void a(e.c... cVarArr) {
        if (this.H) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i3 = this.N;
        this.N = i3 + 1;
        this.f133852f.obtainMessage(11, cVarArr).sendToTarget();
        boolean z16 = false;
        while (this.O <= i3) {
            try {
                LockMethodProxy.wait(this);
            } catch (InterruptedException unused) {
                z16 = true;
            }
        }
        if (z16) {
            Thread.currentThread().interrupt();
        }
    }

    public final void b(boolean z16) {
        if (this.K != z16) {
            this.K = z16;
            this.f133854h.obtainMessage(2, z16 ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void d() {
        a aVar = this.T;
        if (aVar == null || aVar.f133867h) {
            return;
        }
        a aVar2 = this.U;
        if (aVar2 == null || aVar2.f133869j == aVar) {
            for (r rVar : this.G) {
                if (!rVar.c()) {
                    return;
                }
            }
            this.T.f133860a.f();
        }
    }

    public final void b(com.tencent.luggage.wxa.d0.h hVar, boolean z16) {
        this.f133854h.sendEmptyMessage(0);
        a(true);
        this.f133850d.a();
        if (z16) {
            this.f133859m = new b(0, -9223372036854775807L);
        } else {
            b bVar = this.f133859m;
            this.f133859m = new b(bVar.f133877a, bVar.f133880d, this.f133859m.f133879c);
        }
        this.F = hVar;
        if (hVar != null) {
            hVar.a(this.f133855i, true, this);
        }
        b(2);
        this.f133852f.sendEmptyMessage(2);
    }

    @Override // com.tencent.luggage.wxa.d0.h.a
    public void a(u uVar, Object obj) {
        this.f133852f.obtainMessage(7, Pair.create(uVar, obj)).sendToTarget();
    }

    public final void c(com.tencent.luggage.wxa.d0.g gVar) {
        a aVar = this.T;
        if (aVar == null || aVar.f133860a != gVar) {
            return;
        }
        aVar.b();
        if (this.V == null) {
            a aVar2 = this.T;
            this.U = aVar2;
            b(aVar2.f133866g.f133913b);
            b(this.U);
        }
        c();
    }

    @Override // com.tencent.luggage.wxa.d0.g.a
    public void a(com.tencent.luggage.wxa.d0.g gVar) {
        this.f133852f.obtainMessage(8, gVar).sendToTarget();
    }

    public final void a(int i3) {
        a aVar;
        a aVar2;
        this.M = i3;
        this.f133858l.a(i3);
        a aVar3 = this.V;
        if (aVar3 == null) {
            aVar3 = this.T;
        }
        if (aVar3 == null) {
            return;
        }
        while (true) {
            int a16 = this.W.a(aVar3.f133866g.f133912a.f123995a, this.f133857k, this.f133856j, i3);
            while (true) {
                aVar = aVar3.f133869j;
                if (aVar == null || aVar3.f133866g.f133917f) {
                    break;
                } else {
                    aVar3 = aVar;
                }
            }
            if (a16 == -1 || aVar == null || aVar.f133866g.f133912a.f123995a != a16) {
                break;
            } else {
                aVar3 = aVar;
            }
        }
        int i16 = this.T.f133862c;
        a aVar4 = this.U;
        int i17 = aVar4 != null ? aVar4.f133862c : -1;
        if (aVar != null) {
            a(aVar);
            aVar3.f133869j = null;
        }
        aVar3.f133866g = this.f133858l.a(aVar3.f133866g);
        int i18 = aVar3.f133862c;
        if (!(i16 <= i18)) {
            this.T = aVar3;
        }
        if ((i17 != -1 && i17 <= i18) || (aVar2 = this.V) == null) {
            return;
        }
        h.b bVar = aVar2.f133866g.f133912a;
        this.f133859m = new b(bVar, a(bVar, this.f133859m.f133880d), this.f133859m.f133879c);
    }

    public final void b() {
        boolean a16;
        int i3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        m();
        if (this.V == null) {
            d();
            a(elapsedRealtime, 10L);
            return;
        }
        com.tencent.luggage.wxa.n0.t.a("doSomeWork");
        n();
        this.V.f133860a.c(this.f133859m.f133880d);
        boolean z16 = true;
        boolean z17 = true;
        for (r rVar : this.G) {
            rVar.a(this.S, this.P);
            z17 = z17 && rVar.b();
            boolean z18 = rVar.isReady() || rVar.b();
            if (!z18) {
                rVar.f();
            }
            z16 = z16 && z18;
        }
        if (!z16) {
            d();
        }
        com.tencent.luggage.wxa.n0.h hVar = this.E;
        if (hVar != null) {
            p h16 = hVar.h();
            if (!h16.equals(this.C)) {
                this.C = h16;
                this.f133851e.a(this.E);
                this.f133854h.obtainMessage(7, h16).sendToTarget();
            }
        }
        long j3 = this.V.f133866g.f133916e;
        if (z17 && ((j3 == -9223372036854775807L || j3 <= this.f133859m.f133880d) && this.V.f133866g.f133918g)) {
            b(4);
            l();
        } else {
            int i16 = this.L;
            if (i16 == 2) {
                if (this.G.length > 0) {
                    a16 = z16 && this.T.a(this.J, this.S);
                } else {
                    a16 = a(j3);
                }
                if (a16) {
                    b(3);
                    if (this.I) {
                        i();
                    }
                }
            } else if (i16 == 3) {
                if (this.G.length <= 0) {
                    z16 = a(j3);
                }
                if (!z16) {
                    this.J = this.I;
                    b(2);
                    l();
                }
            }
        }
        if (this.L == 2) {
            for (r rVar2 : this.G) {
                rVar2.f();
            }
        }
        if ((this.I && this.L == 3) || (i3 = this.L) == 2) {
            a(elapsedRealtime, 10L);
        } else if (this.G.length != 0 && i3 != 4) {
            a(elapsedRealtime, 1000L);
        } else {
            this.f133852f.removeMessages(2);
        }
        com.tencent.luggage.wxa.n0.t.a();
    }

    public final void c() {
        boolean b16 = this.T.b(this.S);
        b(b16);
        if (b16) {
            this.T.a(this.S);
        }
    }

    public final void a(long j3, long j16) {
        this.f133852f.removeMessages(2);
        long elapsedRealtime = (j3 + j16) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f133852f.sendEmptyMessage(2);
        } else {
            this.f133852f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    public final long a(h.b bVar, long j3) {
        a aVar;
        l();
        this.J = false;
        b(2);
        a aVar2 = this.V;
        if (aVar2 == null) {
            a aVar3 = this.T;
            if (aVar3 != null) {
                aVar3.d();
            }
            aVar = null;
        } else {
            aVar = null;
            while (aVar2 != null) {
                if (aVar == null && a(bVar, j3, aVar2)) {
                    aVar = aVar2;
                } else {
                    aVar2.d();
                }
                aVar2 = aVar2.f133869j;
            }
        }
        a aVar4 = this.V;
        if (aVar4 != aVar || aVar4 != this.U) {
            for (r rVar : this.G) {
                rVar.e();
            }
            this.G = new r[0];
            this.E = null;
            this.D = null;
            this.V = null;
        }
        if (aVar != null) {
            aVar.f133869j = null;
            this.T = aVar;
            this.U = aVar;
            b(aVar);
            a aVar5 = this.V;
            if (aVar5.f133868i) {
                j3 = aVar5.f133860a.b(j3);
            }
            b(j3);
            c();
        } else {
            this.T = null;
            this.U = null;
            this.V = null;
            b(j3);
        }
        this.f133852f.sendEmptyMessage(2);
        return j3;
    }

    public final void b(c cVar) {
        int i3;
        long j3;
        if (this.W == null) {
            this.Q++;
            this.R = cVar;
            return;
        }
        Pair a16 = a(cVar);
        if (a16 == null) {
            b bVar = new b(0, 0L);
            this.f133859m = bVar;
            this.f133854h.obtainMessage(4, 1, 0, bVar).sendToTarget();
            this.f133859m = new b(0, -9223372036854775807L);
            b(4);
            a(false);
            return;
        }
        int i16 = cVar.f133884c == -9223372036854775807L ? 1 : 0;
        int intValue = ((Integer) a16.first).intValue();
        long longValue = ((Long) a16.second).longValue();
        h.b a17 = this.f133858l.a(intValue, longValue);
        if (a17.a()) {
            i3 = 1;
            j3 = 0;
        } else {
            i3 = i16;
            j3 = longValue;
        }
        try {
            if (a17.equals(this.f133859m.f133877a) && j3 / 1000 == this.f133859m.f133880d / 1000) {
                return;
            }
            long a18 = a(a17, j3);
            int i17 = i3 | (j3 == a18 ? 0 : 1);
            b bVar2 = new b(a17, a18, longValue);
            this.f133859m = bVar2;
            this.f133854h.obtainMessage(4, i17, 0, bVar2).sendToTarget();
        } finally {
            b bVar3 = new b(a17, j3, longValue);
            this.f133859m = bVar3;
            this.f133854h.obtainMessage(4, i3, 0, bVar3).sendToTarget();
        }
    }

    public final boolean a(h.b bVar, long j3, a aVar) {
        if (!bVar.equals(aVar.f133866g.f133912a) || !aVar.f133867h) {
            return false;
        }
        this.W.a(aVar.f133866g.f133912a.f123995a, this.f133857k);
        int a16 = this.f133857k.a(j3);
        return a16 == -1 || this.f133857k.b(a16) == aVar.f133866g.f133914c;
    }

    public final void a(boolean z16) {
        this.f133852f.removeMessages(2);
        this.J = false;
        this.f133851e.b();
        this.E = null;
        this.D = null;
        this.S = AEEditorConstants.MAX_CLIP_TIME_US;
        for (r rVar : this.G) {
            try {
                a(rVar);
                rVar.e();
            } catch (com.tencent.luggage.wxa.m.d | RuntimeException e16) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e16);
            }
        }
        this.G = new r[0];
        a aVar = this.V;
        if (aVar == null) {
            aVar = this.T;
        }
        a(aVar);
        this.T = null;
        this.U = null;
        this.V = null;
        b(false);
        if (z16) {
            com.tencent.luggage.wxa.d0.h hVar = this.F;
            if (hVar != null) {
                hVar.b();
                this.F = null;
            }
            this.f133858l.a((u) null);
            this.W = null;
        }
    }

    public final void b(long j3) {
        a aVar = this.V;
        long d16 = aVar == null ? j3 + AEEditorConstants.MAX_CLIP_TIME_US : aVar.d(j3);
        this.S = d16;
        this.f133851e.a(d16);
        for (r rVar : this.G) {
            rVar.a(this.S);
        }
    }

    public final void a(r rVar) {
        if (rVar.getState() == 2) {
            rVar.stop();
        }
    }

    public final boolean a(long j3) {
        a aVar;
        return j3 == -9223372036854775807L || this.f133859m.f133880d < j3 || ((aVar = this.V.f133869j) != null && (aVar.f133867h || aVar.f133866g.f133912a.a()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x01cb, code lost:
    
        r6 = r20.U;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01cd, code lost:
    
        if (r6 == null) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01d3, code lost:
    
        if (r6.f133862c >= r5.f133862c) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01d5, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01d6, code lost:
    
        if (r4 != false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01d8, code lost:
    
        r20.f133859m = new com.tencent.luggage.wxa.m.h.b(r20.V.f133866g.f133912a, a(r20.V.f133866g.f133912a, r20.f133859m.f133880d), r20.f133859m.f133879c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01f9, code lost:
    
        r20.T = r2;
        r2.f133869j = null;
        a(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Pair pair) {
        u uVar = this.W;
        u uVar2 = (u) pair.first;
        this.W = uVar2;
        this.f133858l.a(uVar2);
        Object obj = pair.second;
        boolean z16 = false;
        if (uVar == null) {
            if (this.Q > 0) {
                Pair a16 = a(this.R);
                int i3 = this.Q;
                this.Q = 0;
                this.R = null;
                if (a16 == null) {
                    a(obj, i3);
                    return;
                }
                int intValue = ((Integer) a16.first).intValue();
                long longValue = ((Long) a16.second).longValue();
                h.b a17 = this.f133858l.a(intValue, longValue);
                this.f133859m = new b(a17, a17.a() ? 0L : longValue, longValue);
                b(obj, i3);
                return;
            }
            if (this.f133859m.f133878b == -9223372036854775807L) {
                if (this.W.c()) {
                    a(obj);
                    return;
                }
                Pair a18 = a(0, -9223372036854775807L);
                int intValue2 = ((Integer) a18.first).intValue();
                long longValue2 = ((Long) a18.second).longValue();
                h.b a19 = this.f133858l.a(intValue2, longValue2);
                this.f133859m = new b(a19, a19.a() ? 0L : longValue2, longValue2);
                b(obj);
                return;
            }
            b(obj);
            return;
        }
        int i16 = this.f133859m.f133877a.f123995a;
        a aVar = this.V;
        if (aVar == null) {
            aVar = this.T;
        }
        if (aVar == null && i16 >= uVar.a()) {
            b(obj);
            return;
        }
        int a26 = this.W.a(aVar == null ? uVar.a(i16, this.f133857k, true).f133927b : aVar.f133861b);
        if (a26 == -1) {
            int a27 = a(i16, uVar, this.W);
            if (a27 == -1) {
                a(obj);
                return;
            }
            Pair a28 = a(this.W.a(a27, this.f133857k).f133928c, -9223372036854775807L);
            int intValue3 = ((Integer) a28.first).intValue();
            long longValue3 = ((Long) a28.second).longValue();
            this.W.a(intValue3, this.f133857k, true);
            if (aVar != null) {
                Object obj2 = this.f133857k.f133927b;
                aVar.f133866g = aVar.f133866g.a(-1);
                while (true) {
                    aVar = aVar.f133869j;
                    if (aVar == null) {
                        break;
                    } else if (aVar.f133861b.equals(obj2)) {
                        aVar.f133866g = this.f133858l.a(aVar.f133866g, intValue3);
                    } else {
                        aVar.f133866g = aVar.f133866g.a(-1);
                    }
                }
            }
            h.b bVar = new h.b(intValue3);
            this.f133859m = new b(bVar, a(bVar, longValue3));
            b(obj);
            return;
        }
        if (a26 != i16) {
            this.f133859m = this.f133859m.a(a26);
        }
        if (this.f133859m.f133877a.a()) {
            h.b a29 = this.f133858l.a(a26, this.f133859m.f133879c);
            if (!a29.a() || a29.f123997c != this.f133859m.f133877a.f123997c) {
                this.f133859m = new b(a29, a(a29, this.f133859m.f133879c), a29.a() ? this.f133859m.f133879c : -9223372036854775807L);
                b(obj);
                return;
            }
        }
        if (aVar == null) {
            b(obj);
            return;
        }
        a a36 = a(aVar, a26);
        while (true) {
            a aVar2 = a36.f133869j;
            if (aVar2 == null) {
                break;
            }
            a26 = this.W.a(a26, this.f133857k, this.f133856j, this.M);
            if (a26 == -1 || !aVar2.f133861b.equals(this.W.a(a26, this.f133857k, true).f133927b)) {
                break;
            } else {
                a36 = a(aVar2, a26);
            }
        }
        b(obj);
    }

    public final void b(p pVar) {
        p a16;
        com.tencent.luggage.wxa.n0.h hVar = this.E;
        if (hVar != null) {
            a16 = hVar.a(pVar);
        } else {
            a16 = this.f133851e.a(pVar);
        }
        this.C = a16;
        this.f133854h.obtainMessage(7, a16).sendToTarget();
    }

    public final void b(Object obj) {
        b(obj, 0);
    }

    public final void b(Object obj, int i3) {
        this.f133854h.obtainMessage(6, new d(this.W, obj, this.f133859m, i3)).sendToTarget();
    }

    public final void b(com.tencent.luggage.wxa.d0.g gVar) {
        a aVar = this.T;
        if (aVar == null || aVar.f133860a != gVar) {
            return;
        }
        c();
    }

    public final void b(a aVar) {
        if (this.V == aVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f133847a.length];
        int i3 = 0;
        int i16 = 0;
        while (true) {
            r[] rVarArr = this.f133847a;
            if (i3 < rVarArr.length) {
                r rVar = rVarArr[i3];
                zArr[i3] = rVar.getState() != 0;
                com.tencent.luggage.wxa.k0.f a16 = aVar.f133870k.f131410b.a(i3);
                if (a16 != null) {
                    i16++;
                }
                if (zArr[i3] && (a16 == null || (rVar.g() && rVar.l() == this.V.f133863d[i3]))) {
                    if (rVar == this.D) {
                        this.f133851e.a(this.E);
                        this.E = null;
                        this.D = null;
                    }
                    a(rVar);
                    rVar.e();
                }
                i3++;
            } else {
                this.V = aVar;
                this.f133854h.obtainMessage(3, aVar.f133870k).sendToTarget();
                a(zArr, i16);
                return;
            }
        }
    }

    public final a a(a aVar, int i3) {
        a aVar2;
        while (true) {
            n.b a16 = this.f133858l.a(aVar.f133866g, i3);
            aVar.f133866g = a16;
            if (a16.f133917f || (aVar2 = aVar.f133869j) == null) {
                break;
            }
            aVar = aVar2;
        }
        return aVar;
    }

    public final void a(Object obj) {
        a(obj, 0);
    }

    public final void a(Object obj, int i3) {
        this.f133859m = new b(0, 0L);
        b(obj, i3);
        this.f133859m = new b(0, -9223372036854775807L);
        b(4);
        a(false);
    }

    public final int a(int i3, u uVar, u uVar2) {
        int a16 = uVar.a();
        int i16 = -1;
        for (int i17 = 0; i17 < a16 && i16 == -1; i17++) {
            i3 = uVar.a(i3, this.f133857k, this.f133856j, this.M);
            if (i3 == -1) {
                break;
            }
            i16 = uVar2.a(uVar.a(i3, this.f133857k, true).f133927b);
        }
        return i16;
    }

    public final Pair a(c cVar) {
        u uVar = cVar.f133882a;
        if (uVar.c()) {
            uVar = this.W;
        }
        try {
            Pair a16 = uVar.a(this.f133856j, this.f133857k, cVar.f133883b, cVar.f133884c);
            u uVar2 = this.W;
            if (uVar2 == uVar) {
                return a16;
            }
            int a17 = uVar2.a(uVar.a(((Integer) a16.first).intValue(), this.f133857k, true).f133927b);
            if (a17 != -1) {
                return Pair.create(Integer.valueOf(a17), a16.second);
            }
            int a18 = a(((Integer) a16.first).intValue(), uVar, this.W);
            if (a18 != -1) {
                return a(this.W.a(a18, this.f133857k).f133928c, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new l(this.W, cVar.f133883b, cVar.f133884c);
        }
    }

    public final Pair a(int i3, long j3) {
        return this.W.a(this.f133856j, this.f133857k, i3, j3);
    }

    public final void a(a aVar) {
        while (aVar != null) {
            aVar.d();
            aVar = aVar.f133869j;
        }
    }

    public final void a(boolean[] zArr, int i3) {
        this.G = new r[i3];
        int i16 = 0;
        int i17 = 0;
        while (true) {
            r[] rVarArr = this.f133847a;
            if (i16 >= rVarArr.length) {
                return;
            }
            r rVar = rVarArr[i16];
            com.tencent.luggage.wxa.k0.f a16 = this.V.f133870k.f131410b.a(i16);
            if (a16 != null) {
                int i18 = i17 + 1;
                this.G[i17] = rVar;
                if (rVar.getState() == 0) {
                    t tVar = this.V.f133870k.f131412d[i16];
                    boolean z16 = this.I && this.L == 3;
                    boolean z17 = !zArr[i16] && z16;
                    int length = a16.length();
                    j[] jVarArr = new j[length];
                    for (int i19 = 0; i19 < length; i19++) {
                        jVarArr[i19] = a16.a(i19);
                    }
                    a aVar = this.V;
                    rVar.a(tVar, jVarArr, aVar.f133863d[i16], this.S, z17, aVar.a());
                    com.tencent.luggage.wxa.n0.h m3 = rVar.m();
                    if (m3 != null) {
                        if (this.E == null) {
                            this.E = m3;
                            this.D = rVar;
                            m3.a(this.C);
                        } else {
                            throw com.tencent.luggage.wxa.m.d.a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z16) {
                        rVar.start();
                    }
                }
                i17 = i18;
            }
            i16++;
        }
    }
}

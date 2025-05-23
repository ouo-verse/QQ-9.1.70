package com.tencent.luggage.wxa.d0;

import android.net.Uri;
import android.os.Handler;
import com.tencent.luggage.wxa.d0.f;
import com.tencent.luggage.wxa.d0.g;
import com.tencent.luggage.wxa.d0.j;
import com.tencent.luggage.wxa.l0.r;
import com.tencent.luggage.wxa.n0.v;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e implements com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.q.f, r.a, r.d, j.b {
    public g.a E;
    public com.tencent.luggage.wxa.q.k F;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public int M;
    public o N;
    public long O;
    public boolean[] P;
    public boolean[] Q;
    public boolean R;
    public long T;
    public int V;
    public boolean W;
    public boolean X;

    /* renamed from: a, reason: collision with root package name */
    public final Uri f123950a;

    /* renamed from: b, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.g f123951b;

    /* renamed from: c, reason: collision with root package name */
    public final int f123952c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f123953d;

    /* renamed from: e, reason: collision with root package name */
    public final f.a f123954e;

    /* renamed from: f, reason: collision with root package name */
    public final f f123955f;

    /* renamed from: g, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.b f123956g;

    /* renamed from: h, reason: collision with root package name */
    public final String f123957h;

    /* renamed from: i, reason: collision with root package name */
    public final long f123958i;

    /* renamed from: k, reason: collision with root package name */
    public final C6126e f123960k;

    /* renamed from: j, reason: collision with root package name */
    public final r f123959j = new r("Loader:ExtractorMediaPeriod");

    /* renamed from: l, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.e f123961l = new com.tencent.luggage.wxa.n0.e();

    /* renamed from: m, reason: collision with root package name */
    public final Runnable f123962m = new a();
    public final Runnable C = new b();
    public final Handler D = new Handler();
    public int[] H = new int[0];
    public j[] G = new j[0];
    public long U = -9223372036854775807L;
    public long S = -1;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.k();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!e.this.X) {
                e.this.E.a((l) e.this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IOException f123965a;

        public c(IOException iOException) {
            this.f123965a = iOException;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.f123954e.onLoadError(this.f123965a);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class d implements r.c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f123967a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.l0.g f123968b;

        /* renamed from: c, reason: collision with root package name */
        public final C6126e f123969c;

        /* renamed from: d, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.e f123970d;

        /* renamed from: f, reason: collision with root package name */
        public volatile boolean f123972f;

        /* renamed from: h, reason: collision with root package name */
        public long f123974h;

        /* renamed from: e, reason: collision with root package name */
        public final com.tencent.luggage.wxa.q.j f123971e = new com.tencent.luggage.wxa.q.j();

        /* renamed from: g, reason: collision with root package name */
        public boolean f123973g = true;

        /* renamed from: i, reason: collision with root package name */
        public long f123975i = -1;

        public d(Uri uri, com.tencent.luggage.wxa.l0.g gVar, C6126e c6126e, com.tencent.luggage.wxa.n0.e eVar) {
            this.f123967a = (Uri) com.tencent.luggage.wxa.n0.a.a(uri);
            this.f123968b = (com.tencent.luggage.wxa.l0.g) com.tencent.luggage.wxa.n0.a.a(gVar);
            this.f123969c = (C6126e) com.tencent.luggage.wxa.n0.a.a(c6126e);
            this.f123970d = eVar;
        }

        @Override // com.tencent.luggage.wxa.l0.r.c
        public void b() {
            com.tencent.luggage.wxa.q.b bVar;
            long j3;
            int i3 = 0;
            while (i3 == 0 && !this.f123972f) {
                try {
                    j3 = this.f123971e.f137769a;
                    long a16 = this.f123968b.a(new com.tencent.luggage.wxa.l0.j(this.f123967a, j3, -1L, e.this.f123957h));
                    this.f123975i = a16;
                    if (a16 != -1) {
                        this.f123975i = a16 + j3;
                    }
                    bVar = new com.tencent.luggage.wxa.q.b(this.f123968b, j3, this.f123975i);
                } catch (Throwable th5) {
                    th = th5;
                    bVar = null;
                }
                try {
                    com.tencent.luggage.wxa.q.d a17 = this.f123969c.a(bVar, this.f123968b.getUri());
                    if (this.f123973g) {
                        a17.a(j3, this.f123974h);
                        this.f123973g = false;
                    }
                    while (i3 == 0 && !this.f123972f) {
                        this.f123970d.a();
                        i3 = a17.a(bVar, this.f123971e);
                        if (bVar.getPosition() > e.this.f123958i + j3) {
                            j3 = bVar.getPosition();
                            this.f123970d.b();
                            e.this.D.post(e.this.C);
                        }
                    }
                    if (i3 == 1) {
                        i3 = 0;
                    } else {
                        this.f123971e.f137769a = bVar.getPosition();
                    }
                    v.a(this.f123968b);
                } catch (Throwable th6) {
                    th = th6;
                    if (i3 != 1 && bVar != null) {
                        this.f123971e.f137769a = bVar.getPosition();
                    }
                    v.a(this.f123968b);
                    throw th;
                }
            }
        }

        @Override // com.tencent.luggage.wxa.l0.r.c
        public void c() {
            this.f123972f = true;
        }

        public void a(long j3, long j16) {
            this.f123971e.f137769a = j3;
            this.f123974h = j16;
            this.f123973g = true;
        }

        @Override // com.tencent.luggage.wxa.l0.r.c
        public boolean a() {
            return this.f123972f;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface f {
        void a(long j3, boolean z16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public final class g implements k {

        /* renamed from: a, reason: collision with root package name */
        public final int f123980a;

        public g(int i3) {
            this.f123980a = i3;
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public boolean isReady() {
            return e.this.a(this.f123980a);
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public void a() {
            e.this.l();
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public int a(com.tencent.luggage.wxa.m.k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16) {
            return e.this.a(this.f123980a, kVar, dVar, z16);
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public void a(long j3) {
            e.this.a(this.f123980a, j3);
        }
    }

    public e(Uri uri, com.tencent.luggage.wxa.l0.g gVar, com.tencent.luggage.wxa.q.d[] dVarArr, int i3, Handler handler, f.a aVar, f fVar, com.tencent.luggage.wxa.l0.b bVar, String str, int i16) {
        this.f123950a = uri;
        this.f123951b = gVar;
        this.f123952c = i3;
        this.f123953d = handler;
        this.f123954e = aVar;
        this.f123955f = fVar;
        this.f123956g = bVar;
        this.f123957h = str;
        this.f123958i = i16;
        this.f123960k = new C6126e(dVarArr, this);
    }

    public final long i() {
        long j3 = Long.MIN_VALUE;
        for (j jVar : this.G) {
            j3 = Math.max(j3, jVar.d());
        }
        return j3;
    }

    public final boolean j() {
        if (this.U != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    public final void k() {
        if (!this.X && !this.J && this.F != null && this.I) {
            for (j jVar : this.G) {
                if (jVar.f() == null) {
                    return;
                }
            }
            this.f123961l.b();
            int length = this.G.length;
            n[] nVarArr = new n[length];
            this.Q = new boolean[length];
            this.P = new boolean[length];
            this.O = this.F.c();
            int i3 = 0;
            while (true) {
                boolean z16 = true;
                if (i3 < length) {
                    com.tencent.luggage.wxa.m.j f16 = this.G[i3].f();
                    nVarArr[i3] = new n(f16);
                    String str = f16.f133896f;
                    if (!com.tencent.luggage.wxa.n0.i.i(str) && !com.tencent.luggage.wxa.n0.i.g(str)) {
                        z16 = false;
                    }
                    this.Q[i3] = z16;
                    this.R = z16 | this.R;
                    i3++;
                } else {
                    this.N = new o(nVarArr);
                    this.J = true;
                    this.f123955f.a(this.O, this.F.a());
                    this.E.a((com.tencent.luggage.wxa.d0.g) this);
                    return;
                }
            }
        }
    }

    public void l() {
        this.f123959j.c();
    }

    public void m() {
        boolean a16 = this.f123959j.a(this);
        if (this.J && !a16) {
            for (j jVar : this.G) {
                jVar.b();
            }
        }
        this.D.removeCallbacksAndMessages(null);
        this.X = true;
    }

    public final void n() {
        com.tencent.luggage.wxa.q.k kVar;
        d dVar = new d(this.f123950a, this.f123951b, this.f123960k, this.f123961l);
        if (this.J) {
            com.tencent.luggage.wxa.n0.a.b(j());
            long j3 = this.O;
            if (j3 != -9223372036854775807L && this.U >= j3) {
                this.W = true;
                this.U = -9223372036854775807L;
                return;
            } else {
                dVar.a(this.F.a(this.U), this.U);
                this.U = -9223372036854775807L;
            }
        }
        this.V = h();
        int i3 = this.f123952c;
        if (i3 == -1) {
            if (this.J && this.S == -1 && ((kVar = this.F) == null || kVar.c() == -9223372036854775807L)) {
                i3 = 6;
            } else {
                i3 = 3;
            }
        }
        this.f123959j.a(dVar, this, i3);
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public long b() {
        if (this.M == 0) {
            return Long.MIN_VALUE;
        }
        return c();
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void c(long j3) {
        int length = this.G.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.G[i3].b(j3, false, this.P[i3]);
        }
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public long d() {
        if (!this.L) {
            return -9223372036854775807L;
        }
        this.L = false;
        return this.T;
    }

    @Override // com.tencent.luggage.wxa.q.f
    public void e() {
        this.I = true;
        this.D.post(this.f123962m);
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void f() {
        l();
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public o g() {
        return this.N;
    }

    public final int h() {
        int i3 = 0;
        for (j jVar : this.G) {
            i3 += jVar.g();
        }
        return i3;
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public long b(long j3) {
        if (!this.F.a()) {
            j3 = 0;
        }
        this.T = j3;
        this.L = false;
        if (!j() && d(j3)) {
            return j3;
        }
        this.U = j3;
        this.W = false;
        if (this.f123959j.b()) {
            this.f123959j.a();
        } else {
            for (j jVar : this.G) {
                jVar.j();
            }
        }
        return j3;
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public long c() {
        long i3;
        if (this.W) {
            return Long.MIN_VALUE;
        }
        if (j()) {
            return this.U;
        }
        if (this.R) {
            int length = this.G.length;
            i3 = Long.MAX_VALUE;
            for (int i16 = 0; i16 < length; i16++) {
                if (this.Q[i16]) {
                    i3 = Math.min(i3, this.G[i16].d());
                }
            }
        } else {
            i3 = i();
        }
        return i3 == Long.MIN_VALUE ? this.T : i3;
    }

    @Override // com.tencent.luggage.wxa.l0.r.d
    public void a() {
        this.f123960k.a();
        for (j jVar : this.G) {
            jVar.j();
        }
    }

    public final boolean d(long j3) {
        int length = this.G.length;
        for (int i3 = 0; i3 < length; i3++) {
            j jVar = this.G[i3];
            jVar.k();
            if (!jVar.a(j3, true, false) && (this.Q[i3] || !this.R)) {
                return false;
            }
            jVar.c();
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void a(g.a aVar, long j3) {
        this.E = aVar;
        this.f123961l.c();
        n();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.d0.e$e, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6126e {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.q.d[] f123977a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.q.f f123978b;

        /* renamed from: c, reason: collision with root package name */
        public com.tencent.luggage.wxa.q.d f123979c;

        public C6126e(com.tencent.luggage.wxa.q.d[] dVarArr, com.tencent.luggage.wxa.q.f fVar) {
            this.f123977a = dVarArr;
            this.f123978b = fVar;
        }

        public com.tencent.luggage.wxa.q.d a(com.tencent.luggage.wxa.q.e eVar, Uri uri) {
            com.tencent.luggage.wxa.q.d dVar = this.f123979c;
            if (dVar != null) {
                return dVar;
            }
            com.tencent.luggage.wxa.q.d[] dVarArr = this.f123977a;
            int length = dVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                com.tencent.luggage.wxa.q.d dVar2 = dVarArr[i3];
                try {
                } catch (EOFException unused) {
                } catch (Throwable th5) {
                    eVar.a();
                    throw th5;
                }
                if (dVar2.a(eVar)) {
                    this.f123979c = dVar2;
                    eVar.a();
                    break;
                }
                continue;
                eVar.a();
                i3++;
            }
            com.tencent.luggage.wxa.q.d dVar3 = this.f123979c;
            if (dVar3 != null) {
                dVar3.a(this.f123978b);
                return this.f123979c;
            }
            throw new p("None of the available extractors (" + v.a(this.f123977a) + ") could read the stream.", uri);
        }

        public void a() {
            com.tencent.luggage.wxa.q.d dVar = this.f123979c;
            if (dVar != null) {
                dVar.release();
                this.f123979c = null;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public long a(com.tencent.luggage.wxa.k0.f[] fVarArr, boolean[] zArr, k[] kVarArr, boolean[] zArr2, long j3) {
        com.tencent.luggage.wxa.k0.f fVar;
        com.tencent.luggage.wxa.n0.a.b(this.J);
        int i3 = this.M;
        int i16 = 0;
        for (int i17 = 0; i17 < fVarArr.length; i17++) {
            k kVar = kVarArr[i17];
            if (kVar != null && (fVarArr[i17] == null || !zArr[i17])) {
                int i18 = ((g) kVar).f123980a;
                com.tencent.luggage.wxa.n0.a.b(this.P[i18]);
                this.M--;
                this.P[i18] = false;
                kVarArr[i17] = null;
            }
        }
        boolean z16 = !this.K ? j3 == 0 : i3 != 0;
        for (int i19 = 0; i19 < fVarArr.length; i19++) {
            if (kVarArr[i19] == null && (fVar = fVarArr[i19]) != null) {
                com.tencent.luggage.wxa.n0.a.b(fVar.length() == 1);
                com.tencent.luggage.wxa.n0.a.b(fVar.b(0) == 0);
                int a16 = this.N.a(fVar.c());
                com.tencent.luggage.wxa.n0.a.b(!this.P[a16]);
                this.M++;
                this.P[a16] = true;
                kVarArr[i19] = new g(a16);
                zArr2[i19] = true;
                if (!z16) {
                    j jVar = this.G[a16];
                    jVar.k();
                    z16 = (jVar.a(j3, true, true) || jVar.e() == 0) ? false : true;
                }
            }
        }
        if (this.M == 0) {
            this.L = false;
            if (this.f123959j.b()) {
                j[] jVarArr = this.G;
                int length = jVarArr.length;
                while (i16 < length) {
                    jVarArr[i16].b();
                    i16++;
                }
                this.f123959j.a();
            } else {
                j[] jVarArr2 = this.G;
                int length2 = jVarArr2.length;
                while (i16 < length2) {
                    jVarArr2[i16].j();
                    i16++;
                }
            }
        } else if (z16) {
            j3 = b(j3);
            while (i16 < kVarArr.length) {
                if (kVarArr[i16] != null) {
                    zArr2[i16] = true;
                }
                i16++;
            }
        }
        this.K = true;
        return j3;
    }

    public final void b(d dVar) {
        if (this.S == -1) {
            this.S = dVar.f123975i;
        }
    }

    public final void b(IOException iOException) {
        Handler handler = this.f123953d;
        if (handler == null || this.f123954e == null) {
            return;
        }
        handler.post(new c(iOException));
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public boolean a(long j3) {
        if (this.W) {
            return false;
        }
        if (this.J && this.M == 0) {
            return false;
        }
        boolean c16 = this.f123961l.c();
        if (this.f123959j.b()) {
            return c16;
        }
        n();
        return true;
    }

    public boolean a(int i3) {
        return this.W || (!j() && this.G[i3].h());
    }

    public int a(int i3, com.tencent.luggage.wxa.m.k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16) {
        if (this.L || j()) {
            return -3;
        }
        return this.G[i3].a(kVar, dVar, z16, this.W, this.T);
    }

    public void a(int i3, long j3) {
        j jVar = this.G[i3];
        if (this.W && j3 > jVar.d()) {
            jVar.a();
        } else {
            jVar.a(j3, true, true);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public void a(d dVar, long j3, long j16) {
        b(dVar);
        this.W = true;
        if (this.O == -9223372036854775807L) {
            long i3 = i();
            long j17 = i3 == Long.MIN_VALUE ? 0L : i3 + 10000;
            this.O = j17;
            this.f123955f.a(j17, this.F.a());
        }
        this.E.a((l) this);
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public void a(d dVar, long j3, long j16, boolean z16) {
        if (z16) {
            return;
        }
        b(dVar);
        for (j jVar : this.G) {
            jVar.j();
        }
        if (this.M > 0) {
            this.E.a((l) this);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public int a(d dVar, long j3, long j16, IOException iOException) {
        b(dVar);
        b(iOException);
        if (a(iOException)) {
            return 3;
        }
        int i3 = h() > this.V ? 1 : 0;
        a(dVar);
        this.V = h();
        return i3;
    }

    @Override // com.tencent.luggage.wxa.q.f
    public com.tencent.luggage.wxa.q.l a(int i3, int i16) {
        int length = this.G.length;
        for (int i17 = 0; i17 < length; i17++) {
            if (this.H[i17] == i3) {
                return this.G[i17];
            }
        }
        j jVar = new j(this.f123956g);
        jVar.a(this);
        int i18 = length + 1;
        int[] copyOf = Arrays.copyOf(this.H, i18);
        this.H = copyOf;
        copyOf[length] = i3;
        j[] jVarArr = (j[]) Arrays.copyOf(this.G, i18);
        this.G = jVarArr;
        jVarArr[length] = jVar;
        return jVar;
    }

    @Override // com.tencent.luggage.wxa.q.f
    public void a(com.tencent.luggage.wxa.q.k kVar) {
        this.F = kVar;
        this.D.post(this.f123962m);
    }

    @Override // com.tencent.luggage.wxa.d0.j.b
    public void a(com.tencent.luggage.wxa.m.j jVar) {
        this.D.post(this.f123962m);
    }

    public final void a(d dVar) {
        if (this.S == -1) {
            com.tencent.luggage.wxa.q.k kVar = this.F;
            if (kVar == null || kVar.c() == -9223372036854775807L) {
                this.T = 0L;
                this.L = this.J;
                for (j jVar : this.G) {
                    jVar.j();
                }
                dVar.a(0L, 0L);
            }
        }
    }

    public final boolean a(IOException iOException) {
        return iOException instanceof p;
    }
}

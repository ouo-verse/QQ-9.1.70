package com.tencent.luggage.wxa.f0;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.luggage.wxa.d0.a;
import com.tencent.luggage.wxa.d0.j;
import com.tencent.luggage.wxa.d0.l;
import com.tencent.luggage.wxa.d0.n;
import com.tencent.luggage.wxa.d0.o;
import com.tencent.luggage.wxa.f0.c;
import com.tencent.luggage.wxa.g0.a;
import com.tencent.luggage.wxa.l0.r;
import com.tencent.luggage.wxa.n0.v;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements r.a, r.d, com.tencent.luggage.wxa.d0.l, com.tencent.luggage.wxa.q.f, j.b {
    public boolean D;
    public boolean E;
    public int F;
    public com.tencent.luggage.wxa.m.j G;
    public int H;
    public boolean I;
    public o J;
    public int K;
    public boolean L;
    public boolean[] M;
    public boolean[] N;
    public long O;
    public long P;
    public boolean Q;
    public boolean R;
    public boolean S;

    /* renamed from: a, reason: collision with root package name */
    public final int f125166a;

    /* renamed from: b, reason: collision with root package name */
    public final b f125167b;

    /* renamed from: c, reason: collision with root package name */
    public final c f125168c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.b f125169d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.m.j f125170e;

    /* renamed from: f, reason: collision with root package name */
    public final int f125171f;

    /* renamed from: h, reason: collision with root package name */
    public final a.C6124a f125173h;

    /* renamed from: g, reason: collision with root package name */
    public final r f125172g = new r("Loader:HlsSampleStreamWrapper");

    /* renamed from: i, reason: collision with root package name */
    public final c.b f125174i = new c.b();
    public int[] C = new int[0];

    /* renamed from: m, reason: collision with root package name */
    public com.tencent.luggage.wxa.d0.j[] f125178m = new com.tencent.luggage.wxa.d0.j[0];

    /* renamed from: j, reason: collision with root package name */
    public final LinkedList f125175j = new LinkedList();

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f125176k = new a();

    /* renamed from: l, reason: collision with root package name */
    public final Handler f125177l = new Handler();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.k();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends l.a {
        void a();

        void a(a.C6226a c6226a);
    }

    public j(int i3, b bVar, c cVar, com.tencent.luggage.wxa.l0.b bVar2, long j3, com.tencent.luggage.wxa.m.j jVar, int i16, a.C6124a c6124a) {
        this.f125166a = i3;
        this.f125167b = bVar;
        this.f125168c = cVar;
        this.f125169d = bVar2;
        this.f125170e = jVar;
        this.f125171f = i16;
        this.f125173h = c6124a;
        this.O = j3;
        this.P = j3;
    }

    @Override // com.tencent.luggage.wxa.q.f
    public void a(com.tencent.luggage.wxa.q.k kVar) {
    }

    public void b(com.tencent.luggage.wxa.m.j jVar) {
        a(0, -1).a(jVar);
        this.D = true;
        k();
    }

    public void c(long j3) {
        int length = this.f125178m.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f125178m[i3].b(j3, false, this.M[i3]);
        }
    }

    public final boolean d(long j3) {
        int length = this.f125178m.length;
        for (int i3 = 0; i3 < length; i3++) {
            com.tencent.luggage.wxa.d0.j jVar = this.f125178m[i3];
            jVar.k();
            if (!jVar.a(j3, true, false) && (this.N[i3] || !this.L)) {
                return false;
            }
            jVar.c();
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.q.f
    public void e() {
        this.D = true;
        this.f125177l.post(this.f125176k);
    }

    public void f() {
        l();
    }

    public o g() {
        return this.J;
    }

    public final void h() {
        boolean z16;
        com.tencent.luggage.wxa.m.j jVar;
        int length = this.f125178m.length;
        int i3 = 0;
        char c16 = 0;
        int i16 = -1;
        while (true) {
            char c17 = 3;
            if (i3 >= length) {
                break;
            }
            String str = this.f125178m[i3].f().f133896f;
            if (!com.tencent.luggage.wxa.n0.i.i(str)) {
                if (com.tencent.luggage.wxa.n0.i.g(str)) {
                    c17 = 2;
                } else if (com.tencent.luggage.wxa.n0.i.h(str)) {
                    c17 = 1;
                } else {
                    c17 = 0;
                }
            }
            if (c17 > c16) {
                i16 = i3;
                c16 = c17;
            } else if (c17 == c16 && i16 != -1) {
                i16 = -1;
            }
            i3++;
        }
        n b16 = this.f125168c.b();
        int i17 = b16.f124048a;
        this.K = -1;
        this.M = new boolean[length];
        this.N = new boolean[length];
        n[] nVarArr = new n[length];
        for (int i18 = 0; i18 < length; i18++) {
            com.tencent.luggage.wxa.m.j f16 = this.f125178m[i18].f();
            String str2 = f16.f133896f;
            if (!com.tencent.luggage.wxa.n0.i.i(str2) && !com.tencent.luggage.wxa.n0.i.g(str2)) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.N[i18] = z16;
            this.L = z16 | this.L;
            if (i18 == i16) {
                com.tencent.luggage.wxa.m.j[] jVarArr = new com.tencent.luggage.wxa.m.j[i17];
                for (int i19 = 0; i19 < i17; i19++) {
                    jVarArr[i19] = a(b16.a(i19), f16);
                }
                nVarArr[i18] = new n(jVarArr);
                this.K = i18;
            } else {
                if (c16 == 3 && com.tencent.luggage.wxa.n0.i.g(f16.f133896f)) {
                    jVar = this.f125170e;
                } else {
                    jVar = null;
                }
                nVarArr[i18] = new n(a(jVar, f16));
            }
        }
        this.J = new o(nVarArr);
    }

    public void i() {
        if (!this.E) {
            a(this.O);
        }
    }

    public final boolean j() {
        if (this.P != -9223372036854775807L) {
            return true;
        }
        return false;
    }

    public final void k() {
        if (!this.I && !this.E && this.D) {
            for (com.tencent.luggage.wxa.d0.j jVar : this.f125178m) {
                if (jVar.f() == null) {
                    return;
                }
            }
            h();
            this.E = true;
            this.f125167b.a();
        }
    }

    public void l() {
        this.f125172g.c();
        this.f125168c.d();
    }

    public void m() {
        boolean a16 = this.f125172g.a(this);
        if (this.E && !a16) {
            for (com.tencent.luggage.wxa.d0.j jVar : this.f125178m) {
                jVar.b();
            }
        }
        this.f125177l.removeCallbacksAndMessages(null);
        this.I = true;
    }

    public final void n() {
        for (com.tencent.luggage.wxa.d0.j jVar : this.f125178m) {
            jVar.a(this.Q);
        }
        this.Q = false;
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.use(jadx.core.dex.instructions.args.RegisterArg)" because "ssaVar" is null
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:489)
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:492)
        */
    @Override // com.tencent.luggage.wxa.d0.l
    public long c() {
        /*
            r7 = this;
            boolean r0 = r7.S
            if (r0 == 0) goto L7
            r0 = -9223372036854775808
            return r0
        L7:
            boolean r0 = r7.j()
            if (r0 == 0) goto L10
            long r0 = r7.P
            return r0
        L10:
            long r0 = r7.O
            java.util.LinkedList r2 = r7.f125175j
            java.lang.Object r2 = r2.getLast()
            com.tencent.luggage.wxa.f0.f r2 = (com.tencent.luggage.wxa.f0.f) r2
            boolean r3 = r2.g()
            if (r3 == 0) goto L21
            goto L3a
        L21:
            java.util.LinkedList r2 = r7.f125175j
            int r2 = r2.size()
            r3 = 1
            if (r2 <= r3) goto L39
            java.util.LinkedList r2 = r7.f125175j
            int r3 = r2.size()
            int r3 = r3 + (-2)
            java.lang.Object r2 = r2.get(r3)
            com.tencent.luggage.wxa.f0.f r2 = (com.tencent.luggage.wxa.f0.f) r2
            goto L3a
        L39:
            r2 = 0
        L3a:
            if (r2 == 0) goto L42
            long r2 = r2.f124464g
            long r0 = java.lang.Math.max(r0, r2)
        L42:
            com.tencent.luggage.wxa.d0.j[] r2 = r7.f125178m
            int r3 = r2.length
            r4 = 0
        L46:
            if (r4 >= r3) goto L55
            r5 = r2[r4]
            long r5 = r5.d()
            long r0 = java.lang.Math.max(r0, r5)
            int r4 = r4 + 1
            goto L46
        L55:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.luggage.wxa.f0.j.c():long");
    }

    @Override // com.tencent.luggage.wxa.d0.l
    public long b() {
        if (j()) {
            return this.P;
        }
        if (this.S) {
            return Long.MIN_VALUE;
        }
        return ((f) this.f125175j.getLast()).f124464g;
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.tencent.luggage.wxa.k0.f[] fVarArr, boolean[] zArr, com.tencent.luggage.wxa.d0.k[] kVarArr, boolean[] zArr2, long j3, boolean z16) {
        boolean z17;
        boolean z18;
        com.tencent.luggage.wxa.k0.f fVar;
        com.tencent.luggage.wxa.n0.a.b(this.E);
        int i3 = this.F;
        int i16 = 0;
        for (int i17 = 0; i17 < fVarArr.length; i17++) {
            com.tencent.luggage.wxa.d0.k kVar = kVarArr[i17];
            if (kVar != null && (fVarArr[i17] == null || !zArr[i17])) {
                b(((i) kVar).f125164a, false);
                kVarArr[i17] = null;
            }
        }
        boolean z19 = z16 || (!this.R ? j3 == this.O : i3 != 0);
        com.tencent.luggage.wxa.k0.f c16 = this.f125168c.c();
        com.tencent.luggage.wxa.k0.f fVar2 = c16;
        for (int i18 = 0; i18 < fVarArr.length; i18++) {
            if (kVarArr[i18] == null && (fVar = fVarArr[i18]) != null) {
                int a16 = this.J.a(fVar.c());
                b(a16, true);
                if (a16 == this.K) {
                    this.f125168c.a(fVar);
                    fVar2 = fVar;
                }
                kVarArr[i18] = new i(this, a16);
                zArr2[i18] = true;
                if (!z19) {
                    com.tencent.luggage.wxa.d0.j jVar = this.f125178m[a16];
                    jVar.k();
                    z19 = (jVar.a(j3, true, true) || jVar.e() == 0) ? false : true;
                }
            }
        }
        if (this.F == 0) {
            this.f125168c.e();
            this.G = null;
            this.f125175j.clear();
            if (this.f125172g.b()) {
                com.tencent.luggage.wxa.d0.j[] jVarArr = this.f125178m;
                int length = jVarArr.length;
                while (i16 < length) {
                    jVarArr[i16].b();
                    i16++;
                }
                this.f125172g.a();
            } else {
                n();
            }
        } else {
            if (!this.f125175j.isEmpty() && !v.a(fVar2, c16)) {
                if (!this.R) {
                    fVar2.a(0L);
                    if (fVar2.d() == this.f125168c.b().a(((f) this.f125175j.getLast()).f124460c)) {
                        z18 = false;
                        if (z18) {
                            this.Q = true;
                            z17 = true;
                            z19 = true;
                            if (z19) {
                                a(j3, z17);
                                while (i16 < kVarArr.length) {
                                    if (kVarArr[i16] != null) {
                                        zArr2[i16] = true;
                                    }
                                    i16++;
                                }
                            }
                        }
                    }
                }
                z18 = true;
                if (z18) {
                }
            }
            z17 = z16;
            if (z19) {
            }
        }
        this.R = true;
        return z19;
    }

    @Override // com.tencent.luggage.wxa.q.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.d0.j a(int i3, int i16) {
        int length = this.f125178m.length;
        for (int i17 = 0; i17 < length; i17++) {
            if (this.C[i17] == i3) {
                return this.f125178m[i17];
            }
        }
        com.tencent.luggage.wxa.d0.j jVar = new com.tencent.luggage.wxa.d0.j(this.f125169d);
        jVar.a(this);
        int i18 = length + 1;
        int[] copyOf = Arrays.copyOf(this.C, i18);
        this.C = copyOf;
        copyOf[length] = i3;
        com.tencent.luggage.wxa.d0.j[] jVarArr = (com.tencent.luggage.wxa.d0.j[]) Arrays.copyOf(this.f125178m, i18);
        this.f125178m = jVarArr;
        jVarArr[length] = jVar;
        return jVar;
    }

    public final void b(int i3, boolean z16) {
        com.tencent.luggage.wxa.n0.a.b(this.M[i3] != z16);
        this.M[i3] = z16;
        this.F += z16 ? 1 : -1;
    }

    public static String b(String str) {
        return a(str, 2);
    }

    public boolean a(long j3, boolean z16) {
        this.O = j3;
        if (!z16 && !j() && d(j3)) {
            return false;
        }
        this.P = j3;
        this.S = false;
        this.f125175j.clear();
        if (this.f125172g.b()) {
            this.f125172g.a();
            return true;
        }
        n();
        return true;
    }

    @Override // com.tencent.luggage.wxa.l0.r.d
    public void a() {
        n();
    }

    public void a(boolean z16) {
        this.f125168c.a(z16);
    }

    public void a(a.C6226a c6226a, long j3) {
        this.f125168c.a(c6226a, j3);
    }

    public boolean a(int i3) {
        return this.S || (!j() && this.f125178m[i3].h());
    }

    public int a(int i3, com.tencent.luggage.wxa.m.k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16) {
        if (j()) {
            return -3;
        }
        if (!this.f125175j.isEmpty()) {
            while (this.f125175j.size() > 1 && a((f) this.f125175j.getFirst())) {
                this.f125175j.removeFirst();
            }
            f fVar = (f) this.f125175j.getFirst();
            com.tencent.luggage.wxa.m.j jVar = fVar.f124460c;
            if (!jVar.equals(this.G)) {
                this.f125173h.a(this.f125166a, jVar, fVar.f124461d, fVar.f124462e, fVar.f124463f);
            }
            this.G = jVar;
        }
        return this.f125178m[i3].a(kVar, dVar, z16, this.S, this.O);
    }

    public void a(int i3, long j3) {
        com.tencent.luggage.wxa.d0.j jVar = this.f125178m[i3];
        if (this.S && j3 > jVar.d()) {
            jVar.a();
        } else {
            jVar.a(j3, true, true);
        }
    }

    public final boolean a(f fVar) {
        int i3 = fVar.f125127j;
        int i16 = 0;
        while (true) {
            com.tencent.luggage.wxa.d0.j[] jVarArr = this.f125178m;
            if (i16 >= jVarArr.length) {
                return true;
            }
            if (this.M[i16] && jVarArr[i16].i() == i3) {
                return false;
            }
            i16++;
        }
    }

    @Override // com.tencent.luggage.wxa.d0.l
    public boolean a(long j3) {
        if (this.S || this.f125172g.b()) {
            return false;
        }
        c cVar = this.f125168c;
        f fVar = this.f125175j.isEmpty() ? null : (f) this.f125175j.getLast();
        long j16 = this.P;
        if (j16 == -9223372036854775807L) {
            j16 = j3;
        }
        cVar.a(fVar, j16, this.f125174i);
        c.b bVar = this.f125174i;
        boolean z16 = bVar.f125122b;
        com.tencent.luggage.wxa.e0.a aVar = bVar.f125121a;
        a.C6226a c6226a = bVar.f125123c;
        bVar.a();
        if (z16) {
            this.P = -9223372036854775807L;
            this.S = true;
            return true;
        }
        if (aVar == null) {
            if (c6226a != null) {
                this.f125167b.a(c6226a);
            }
            return false;
        }
        if (a(aVar)) {
            this.P = -9223372036854775807L;
            f fVar2 = (f) aVar;
            fVar2.a(this);
            this.f125175j.add(fVar2);
        }
        this.f125173h.a(aVar.f124458a, aVar.f124459b, this.f125166a, aVar.f124460c, aVar.f124461d, aVar.f124462e, aVar.f124463f, aVar.f124464g, this.f125172g.a(aVar, this, this.f125171f));
        return true;
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public void a(com.tencent.luggage.wxa.e0.a aVar, long j3, long j16) {
        this.f125168c.a(aVar);
        this.f125173h.b(aVar.f124458a, aVar.f124459b, this.f125166a, aVar.f124460c, aVar.f124461d, aVar.f124462e, aVar.f124463f, aVar.f124464g, j3, j16, aVar.d());
        if (!this.E) {
            a(this.O);
        } else {
            this.f125167b.a(this);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public void a(com.tencent.luggage.wxa.e0.a aVar, long j3, long j16, boolean z16) {
        this.f125173h.a(aVar.f124458a, aVar.f124459b, this.f125166a, aVar.f124460c, aVar.f124461d, aVar.f124462e, aVar.f124463f, aVar.f124464g, j3, j16, aVar.d());
        if (z16) {
            return;
        }
        n();
        if (this.F > 0) {
            this.f125167b.a(this);
        }
    }

    @Override // com.tencent.luggage.wxa.l0.r.a
    public int a(com.tencent.luggage.wxa.e0.a aVar, long j3, long j16, IOException iOException) {
        long d16 = aVar.d();
        boolean a16 = a(aVar);
        boolean z16 = true;
        if (!this.f125168c.a(aVar, !a16 || d16 == 0, iOException)) {
            z16 = false;
        } else if (a16) {
            com.tencent.luggage.wxa.n0.a.b(((f) this.f125175j.removeLast()) == aVar);
            if (this.f125175j.isEmpty()) {
                this.P = this.O;
            }
        }
        this.f125173h.a(aVar.f124458a, aVar.f124459b, this.f125166a, aVar.f124460c, aVar.f124461d, aVar.f124462e, aVar.f124463f, aVar.f124464g, j3, j16, aVar.d(), iOException, z16);
        if (!z16) {
            return 0;
        }
        if (!this.E) {
            a(this.O);
            return 2;
        }
        this.f125167b.a(this);
        return 2;
    }

    public void a(int i3, boolean z16) {
        this.H = i3;
        for (com.tencent.luggage.wxa.d0.j jVar : this.f125178m) {
            jVar.c(i3);
        }
        if (z16) {
            for (com.tencent.luggage.wxa.d0.j jVar2 : this.f125178m) {
                jVar2.l();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.d0.j.b
    public void a(com.tencent.luggage.wxa.m.j jVar) {
        this.f125177l.post(this.f125176k);
    }

    public static com.tencent.luggage.wxa.m.j a(com.tencent.luggage.wxa.m.j jVar, com.tencent.luggage.wxa.m.j jVar2) {
        String b16;
        if (jVar == null) {
            return jVar2;
        }
        int d16 = com.tencent.luggage.wxa.n0.i.d(jVar2.f133896f);
        if (d16 == 1) {
            b16 = a(jVar.f133893c);
        } else {
            b16 = d16 == 2 ? b(jVar.f133893c) : null;
        }
        return jVar2.a(jVar.f133891a, b16, jVar.f133892b, jVar.f133900j, jVar.f133901k, jVar.M, jVar.N);
    }

    public final boolean a(com.tencent.luggage.wxa.e0.a aVar) {
        return aVar instanceof f;
    }

    public static String a(String str) {
        return a(str, 1);
    }

    public static String a(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : split) {
            if (i3 == com.tencent.luggage.wxa.n0.i.e(str2)) {
                if (sb5.length() > 0) {
                    sb5.append(",");
                }
                sb5.append(str2);
            }
        }
        if (sb5.length() > 0) {
            return sb5.toString();
        }
        return null;
    }
}

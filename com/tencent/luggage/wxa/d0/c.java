package com.tencent.luggage.wxa.d0;

import com.tencent.luggage.wxa.d0.g;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements g, g.a {

    /* renamed from: a, reason: collision with root package name */
    public final g f123937a;

    /* renamed from: b, reason: collision with root package name */
    public g.a f123938b;

    /* renamed from: c, reason: collision with root package name */
    public long f123939c = -9223372036854775807L;

    /* renamed from: d, reason: collision with root package name */
    public long f123940d = -9223372036854775807L;

    /* renamed from: e, reason: collision with root package name */
    public a[] f123941e = new a[0];

    /* renamed from: f, reason: collision with root package name */
    public boolean f123942f;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements k {

        /* renamed from: a, reason: collision with root package name */
        public final g f123943a;

        /* renamed from: b, reason: collision with root package name */
        public final k f123944b;

        /* renamed from: c, reason: collision with root package name */
        public final long f123945c;

        /* renamed from: d, reason: collision with root package name */
        public final long f123946d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f123947e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f123948f;

        public a(g gVar, k kVar, long j3, long j16, boolean z16) {
            this.f123943a = gVar;
            this.f123944b = kVar;
            this.f123945c = j3;
            this.f123946d = j16;
            this.f123947e = z16;
        }

        public void b() {
            this.f123947e = false;
        }

        public void c() {
            this.f123948f = false;
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public boolean isReady() {
            return this.f123944b.isReady();
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public void a() {
            this.f123944b.a();
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public int a(com.tencent.luggage.wxa.m.k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16) {
            if (this.f123947e) {
                return -3;
            }
            if (this.f123948f) {
                dVar.c(4);
                return -4;
            }
            int a16 = this.f123944b.a(kVar, dVar, z16);
            long j3 = this.f123946d;
            if (j3 != Long.MIN_VALUE && ((a16 == -4 && dVar.f135957d >= j3) || (a16 == -3 && this.f123943a.c() == Long.MIN_VALUE))) {
                dVar.a();
                dVar.c(4);
                this.f123948f = true;
                return -4;
            }
            if (a16 == -4 && !dVar.c()) {
                dVar.f135957d -= this.f123945c;
            }
            return a16;
        }

        @Override // com.tencent.luggage.wxa.d0.k
        public void a(long j3) {
            this.f123944b.a(this.f123945c + j3);
        }
    }

    public c(g gVar, boolean z16) {
        this.f123937a = gVar;
        this.f123942f = z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        if (r0 > r6) goto L17;
     */
    @Override // com.tencent.luggage.wxa.d0.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long b(long j3) {
        boolean z16 = false;
        for (a aVar : this.f123941e) {
            if (aVar != null) {
                aVar.c();
            }
        }
        long b16 = this.f123937a.b(this.f123939c + j3);
        long j16 = this.f123939c;
        if (b16 != j3 + j16) {
            if (b16 >= j16) {
                long j17 = this.f123940d;
                if (j17 != Long.MIN_VALUE) {
                }
            }
            com.tencent.luggage.wxa.n0.a.b(z16);
            return b16 - this.f123939c;
        }
        z16 = true;
        com.tencent.luggage.wxa.n0.a.b(z16);
        return b16 - this.f123939c;
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void c(long j3) {
        this.f123937a.c(j3 + this.f123939c);
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public long d() {
        boolean z16;
        boolean z17 = false;
        if (this.f123942f) {
            for (a aVar : this.f123941e) {
                if (aVar != null) {
                    aVar.b();
                }
            }
            this.f123942f = false;
            long d16 = d();
            if (d16 == -9223372036854775807L) {
                return 0L;
            }
            return d16;
        }
        long d17 = this.f123937a.d();
        if (d17 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (d17 >= this.f123939c) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        long j3 = this.f123940d;
        if (j3 == Long.MIN_VALUE || d17 <= j3) {
            z17 = true;
        }
        com.tencent.luggage.wxa.n0.a.b(z17);
        return d17 - this.f123939c;
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void f() {
        this.f123937a.f();
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public o g() {
        return this.f123937a.g();
    }

    public void a(long j3, long j16) {
        this.f123939c = j3;
        this.f123940d = j16;
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public long c() {
        long c16 = this.f123937a.c();
        if (c16 != Long.MIN_VALUE) {
            long j3 = this.f123940d;
            if (j3 == Long.MIN_VALUE || c16 < j3) {
                return Math.max(0L, c16 - this.f123939c);
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.tencent.luggage.wxa.d0.g
    public void a(g.a aVar, long j3) {
        this.f123938b = aVar;
        this.f123937a.a(this, this.f123939c + j3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        if (r12 > r3) goto L27;
     */
    @Override // com.tencent.luggage.wxa.d0.g
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long a(com.tencent.luggage.wxa.k0.f[] fVarArr, boolean[] zArr, k[] kVarArr, boolean[] zArr2, long j3) {
        this.f123941e = new a[kVarArr.length];
        k[] kVarArr2 = new k[kVarArr.length];
        int i3 = 0;
        while (true) {
            k kVar = null;
            if (i3 >= kVarArr.length) {
                break;
            }
            a[] aVarArr = this.f123941e;
            a aVar = (a) kVarArr[i3];
            aVarArr[i3] = aVar;
            if (aVar != null) {
                kVar = aVar.f123944b;
            }
            kVarArr2[i3] = kVar;
            i3++;
        }
        long a16 = this.f123937a.a(fVarArr, zArr, kVarArr2, zArr2, j3 + this.f123939c);
        boolean z16 = true;
        if (this.f123942f) {
            this.f123942f = this.f123939c != 0 && a(fVarArr);
        }
        long j16 = this.f123939c;
        if (a16 != j3 + j16) {
            if (a16 >= j16) {
                long j17 = this.f123940d;
                if (j17 != Long.MIN_VALUE) {
                }
            }
            z16 = false;
        }
        com.tencent.luggage.wxa.n0.a.b(z16);
        for (int i16 = 0; i16 < kVarArr.length; i16++) {
            if (kVarArr2[i16] == null) {
                this.f123941e[i16] = null;
            } else if (kVarArr[i16] == null || this.f123941e[i16].f123944b != kVarArr2[i16]) {
                this.f123941e[i16] = new a(this, kVarArr2[i16], this.f123939c, this.f123940d, this.f123942f);
            }
            kVarArr[i16] = this.f123941e[i16];
        }
        return a16 - this.f123939c;
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public long b() {
        long b16 = this.f123937a.b();
        if (b16 != Long.MIN_VALUE) {
            long j3 = this.f123940d;
            if (j3 == Long.MIN_VALUE || b16 < j3) {
                return b16 - this.f123939c;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // com.tencent.luggage.wxa.d0.l.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(g gVar) {
        this.f123938b.a((l) this);
    }

    @Override // com.tencent.luggage.wxa.d0.g, com.tencent.luggage.wxa.d0.l
    public boolean a(long j3) {
        return this.f123937a.a(j3 + this.f123939c);
    }

    @Override // com.tencent.luggage.wxa.d0.g.a
    public void a(g gVar) {
        com.tencent.luggage.wxa.n0.a.b((this.f123939c == -9223372036854775807L || this.f123940d == -9223372036854775807L) ? false : true);
        this.f123938b.a((g) this);
    }

    public static boolean a(com.tencent.luggage.wxa.k0.f[] fVarArr) {
        for (com.tencent.luggage.wxa.k0.f fVar : fVarArr) {
            if (fVar != null && !com.tencent.luggage.wxa.n0.i.g(fVar.e().f133896f)) {
                return true;
            }
        }
        return false;
    }
}

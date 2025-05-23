package com.tencent.luggage.wxa.w;

import android.util.SparseArray;
import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class p implements com.tencent.luggage.wxa.q.d {

    /* renamed from: h, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.q.g f143922h = new a();

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.s f143923a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray f143924b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143925c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f143926d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f143927e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f143928f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.f f143929g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements com.tencent.luggage.wxa.q.g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new p()};
        }
    }

    public p() {
        this(new com.tencent.luggage.wxa.n0.s(0L));
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        byte[] bArr = new byte[14];
        eVar.b(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        eVar.a(bArr[13] & 7);
        eVar.b(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    public p(com.tencent.luggage.wxa.n0.s sVar) {
        this.f143923a = sVar;
        this.f143925c = new com.tencent.luggage.wxa.n0.l(4096);
        this.f143924b = new SparseArray();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.f143929g = fVar;
        fVar.a(new k.a(-9223372036854775807L));
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.f143923a.d();
        for (int i3 = 0; i3 < this.f143924b.size(); i3++) {
            ((b) this.f143924b.valueAt(i3)).c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final h f143930a;

        /* renamed from: b, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.s f143931b;

        /* renamed from: c, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.k f143932c = new com.tencent.luggage.wxa.n0.k(new byte[64]);

        /* renamed from: d, reason: collision with root package name */
        public boolean f143933d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f143934e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f143935f;

        /* renamed from: g, reason: collision with root package name */
        public int f143936g;

        /* renamed from: h, reason: collision with root package name */
        public long f143937h;

        public b(h hVar, com.tencent.luggage.wxa.n0.s sVar) {
            this.f143930a = hVar;
            this.f143931b = sVar;
        }

        public void a(com.tencent.luggage.wxa.n0.l lVar) {
            lVar.a(this.f143932c.f135084a, 0, 3);
            this.f143932c.b(0);
            a();
            lVar.a(this.f143932c.f135084a, 0, this.f143936g);
            this.f143932c.b(0);
            b();
            this.f143930a.a(this.f143937h, true);
            this.f143930a.a(lVar);
            this.f143930a.b();
        }

        public final void b() {
            this.f143937h = 0L;
            if (this.f143933d) {
                this.f143932c.c(4);
                this.f143932c.c(1);
                this.f143932c.c(1);
                long a16 = (this.f143932c.a(3) << 30) | (this.f143932c.a(15) << 15) | this.f143932c.a(15);
                this.f143932c.c(1);
                if (!this.f143935f && this.f143934e) {
                    this.f143932c.c(4);
                    this.f143932c.c(1);
                    this.f143932c.c(1);
                    this.f143932c.c(1);
                    this.f143931b.b((this.f143932c.a(3) << 30) | (this.f143932c.a(15) << 15) | this.f143932c.a(15));
                    this.f143935f = true;
                }
                this.f143937h = this.f143931b.b(a16);
            }
        }

        public void c() {
            this.f143935f = false;
            this.f143930a.a();
        }

        public final void a() {
            this.f143932c.c(8);
            this.f143933d = this.f143932c.c();
            this.f143934e = this.f143932c.c();
            this.f143932c.c(6);
            this.f143936g = this.f143932c.a(8);
        }
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        h hVar;
        if (!eVar.a(this.f143925c.f135088a, 0, 4, true)) {
            return -1;
        }
        this.f143925c.e(0);
        int f16 = this.f143925c.f();
        if (f16 == 441) {
            return -1;
        }
        if (f16 == 442) {
            eVar.b(this.f143925c.f135088a, 0, 10);
            this.f143925c.e(9);
            eVar.c((this.f143925c.q() & 7) + 14);
            return 0;
        }
        if (f16 == 443) {
            eVar.b(this.f143925c.f135088a, 0, 2);
            this.f143925c.e(0);
            eVar.c(this.f143925c.w() + 6);
            return 0;
        }
        if (((f16 & (-256)) >> 8) != 1) {
            eVar.c(1);
            return 0;
        }
        int i3 = f16 & 255;
        b bVar = (b) this.f143924b.get(i3);
        if (!this.f143926d) {
            if (bVar == null) {
                boolean z16 = this.f143927e;
                if (!z16 && i3 == 189) {
                    hVar = new com.tencent.luggage.wxa.w.b();
                    this.f143927e = true;
                } else if (!z16 && (i3 & 224) == 192) {
                    hVar = new m();
                    this.f143927e = true;
                } else if (this.f143928f || (i3 & 240) != 224) {
                    hVar = null;
                } else {
                    hVar = new i();
                    this.f143928f = true;
                }
                if (hVar != null) {
                    hVar.a(this.f143929g, new v.d(i3, 256));
                    bVar = new b(hVar, this.f143923a);
                    this.f143924b.put(i3, bVar);
                }
            }
            if ((this.f143927e && this.f143928f) || eVar.getPosition() > 1048576) {
                this.f143926d = true;
                this.f143929g.e();
            }
        }
        eVar.b(this.f143925c.f135088a, 0, 2);
        this.f143925c.e(0);
        int w3 = this.f143925c.w() + 6;
        if (bVar == null) {
            eVar.c(w3);
        } else {
            this.f143925c.c(w3);
            eVar.a(this.f143925c.f135088a, 0, w3);
            this.f143925c.e(6);
            bVar.a(this.f143925c);
            com.tencent.luggage.wxa.n0.l lVar = this.f143925c;
            lVar.d(lVar.b());
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }
}

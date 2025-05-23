package com.tencent.luggage.wxa.w;

import android.util.Log;
import com.tencent.luggage.wxa.w.v;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k implements h {

    /* renamed from: a, reason: collision with root package name */
    public final s f143860a;

    /* renamed from: b, reason: collision with root package name */
    public String f143861b;

    /* renamed from: c, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143862c;

    /* renamed from: d, reason: collision with root package name */
    public a f143863d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f143864e;

    /* renamed from: l, reason: collision with root package name */
    public long f143871l;

    /* renamed from: m, reason: collision with root package name */
    public long f143872m;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f143865f = new boolean[3];

    /* renamed from: g, reason: collision with root package name */
    public final n f143866g = new n(32, 128);

    /* renamed from: h, reason: collision with root package name */
    public final n f143867h = new n(33, 128);

    /* renamed from: i, reason: collision with root package name */
    public final n f143868i = new n(34, 128);

    /* renamed from: j, reason: collision with root package name */
    public final n f143869j = new n(39, 128);

    /* renamed from: k, reason: collision with root package name */
    public final n f143870k = new n(40, 128);

    /* renamed from: n, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143873n = new com.tencent.luggage.wxa.n0.l();

    public k(s sVar) {
        this.f143860a = sVar;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        com.tencent.luggage.wxa.n0.j.a(this.f143865f);
        this.f143866g.b();
        this.f143867h.b();
        this.f143868i.b();
        this.f143869j.b();
        this.f143870k.b();
        this.f143863d.a();
        this.f143871l = 0L;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
    }

    public final void b(long j3, int i3, int i16, long j16) {
        if (this.f143864e) {
            this.f143863d.a(j3, i3, i16, j16);
        } else {
            this.f143866g.b(i16);
            this.f143867h.b(i16);
            this.f143868i.b(i16);
        }
        this.f143869j.b(i16);
        this.f143870k.b(i16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.q.l f143874a;

        /* renamed from: b, reason: collision with root package name */
        public long f143875b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f143876c;

        /* renamed from: d, reason: collision with root package name */
        public int f143877d;

        /* renamed from: e, reason: collision with root package name */
        public long f143878e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f143879f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f143880g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f143881h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f143882i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f143883j;

        /* renamed from: k, reason: collision with root package name */
        public long f143884k;

        /* renamed from: l, reason: collision with root package name */
        public long f143885l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f143886m;

        public a(com.tencent.luggage.wxa.q.l lVar) {
            this.f143874a = lVar;
        }

        public void a() {
            this.f143879f = false;
            this.f143880g = false;
            this.f143881h = false;
            this.f143882i = false;
            this.f143883j = false;
        }

        public void a(long j3, int i3, int i16, long j16) {
            this.f143880g = false;
            this.f143881h = false;
            this.f143878e = j16;
            this.f143877d = 0;
            this.f143875b = j3;
            if (i16 >= 32) {
                if (!this.f143883j && this.f143882i) {
                    a(i3);
                    this.f143882i = false;
                }
                if (i16 <= 34) {
                    this.f143881h = !this.f143883j;
                    this.f143883j = true;
                }
            }
            boolean z16 = i16 >= 16 && i16 <= 21;
            this.f143876c = z16;
            this.f143879f = z16 || i16 <= 9;
        }

        public void a(byte[] bArr, int i3, int i16) {
            if (this.f143879f) {
                int i17 = this.f143877d;
                int i18 = (i3 + 2) - i17;
                if (i18 < i16) {
                    this.f143880g = (bArr[i18] & 128) != 0;
                    this.f143879f = false;
                } else {
                    this.f143877d = i17 + (i16 - i3);
                }
            }
        }

        public void a(long j3, int i3) {
            if (this.f143883j && this.f143880g) {
                this.f143886m = this.f143876c;
                this.f143883j = false;
            } else if (this.f143881h || this.f143880g) {
                if (this.f143882i) {
                    a(i3 + ((int) (j3 - this.f143875b)));
                }
                this.f143884k = this.f143875b;
                this.f143885l = this.f143878e;
                this.f143882i = true;
                this.f143886m = this.f143876c;
            }
        }

        public final void a(int i3) {
            boolean z16 = this.f143886m;
            this.f143874a.a(this.f143885l, z16 ? 1 : 0, (int) (this.f143875b - this.f143884k), i3, null);
        }
    }

    public static void b(com.tencent.luggage.wxa.n0.m mVar) {
        int f16 = mVar.f();
        boolean z16 = false;
        int i3 = 0;
        for (int i16 = 0; i16 < f16; i16++) {
            if (i16 != 0) {
                z16 = mVar.c();
            }
            if (z16) {
                mVar.g();
                mVar.f();
                for (int i17 = 0; i17 <= i3; i17++) {
                    if (mVar.c()) {
                        mVar.g();
                    }
                }
            } else {
                int f17 = mVar.f();
                int f18 = mVar.f();
                int i18 = f17 + f18;
                for (int i19 = 0; i19 < f17; i19++) {
                    mVar.f();
                    mVar.g();
                }
                for (int i26 = 0; i26 < f18; i26++) {
                    mVar.f();
                    mVar.g();
                }
                i3 = i18;
            }
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        this.f143861b = dVar.b();
        com.tencent.luggage.wxa.q.l a16 = fVar.a(dVar.c(), 2);
        this.f143862c = a16;
        this.f143863d = new a(a16);
        this.f143860a.a(fVar, dVar);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        this.f143872m = j3;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        while (lVar.a() > 0) {
            int c16 = lVar.c();
            int d16 = lVar.d();
            byte[] bArr = lVar.f135088a;
            this.f143871l += lVar.a();
            this.f143862c.a(lVar, lVar.a());
            while (c16 < d16) {
                int a16 = com.tencent.luggage.wxa.n0.j.a(bArr, c16, d16, this.f143865f);
                if (a16 == d16) {
                    a(bArr, c16, d16);
                    return;
                }
                int a17 = com.tencent.luggage.wxa.n0.j.a(bArr, a16);
                int i3 = a16 - c16;
                if (i3 > 0) {
                    a(bArr, c16, a16);
                }
                int i16 = d16 - a16;
                long j3 = this.f143871l - i16;
                a(j3, i16, i3 < 0 ? -i3 : 0, this.f143872m);
                b(j3, i16, a17, this.f143872m);
                c16 = a16 + 3;
            }
        }
    }

    public final void a(byte[] bArr, int i3, int i16) {
        if (this.f143864e) {
            this.f143863d.a(bArr, i3, i16);
        } else {
            this.f143866g.a(bArr, i3, i16);
            this.f143867h.a(bArr, i3, i16);
            this.f143868i.a(bArr, i3, i16);
        }
        this.f143869j.a(bArr, i3, i16);
        this.f143870k.a(bArr, i3, i16);
    }

    public final void a(long j3, int i3, int i16, long j16) {
        if (this.f143864e) {
            this.f143863d.a(j3, i3);
        } else {
            this.f143866g.a(i16);
            this.f143867h.a(i16);
            this.f143868i.a(i16);
            if (this.f143866g.a() && this.f143867h.a() && this.f143868i.a()) {
                this.f143862c.a(a(this.f143861b, this.f143866g, this.f143867h, this.f143868i));
                this.f143864e = true;
            }
        }
        if (this.f143869j.a(i16)) {
            n nVar = this.f143869j;
            this.f143873n.a(this.f143869j.f143908d, com.tencent.luggage.wxa.n0.j.c(nVar.f143908d, nVar.f143909e));
            this.f143873n.f(5);
            this.f143860a.a(j16, this.f143873n);
        }
        if (this.f143870k.a(i16)) {
            n nVar2 = this.f143870k;
            this.f143873n.a(this.f143870k.f143908d, com.tencent.luggage.wxa.n0.j.c(nVar2.f143908d, nVar2.f143909e));
            this.f143873n.f(5);
            this.f143860a.a(j16, this.f143873n);
        }
    }

    public static com.tencent.luggage.wxa.m.j a(String str, n nVar, n nVar2, n nVar3) {
        float f16;
        float f17;
        int i3 = nVar.f143909e;
        byte[] bArr = new byte[nVar2.f143909e + i3 + nVar3.f143909e];
        System.arraycopy(nVar.f143908d, 0, bArr, 0, i3);
        System.arraycopy(nVar2.f143908d, 0, bArr, nVar.f143909e, nVar2.f143909e);
        System.arraycopy(nVar3.f143908d, 0, bArr, nVar.f143909e + nVar2.f143909e, nVar3.f143909e);
        com.tencent.luggage.wxa.n0.m mVar = new com.tencent.luggage.wxa.n0.m(nVar2.f143908d, 0, nVar2.f143909e);
        mVar.d(44);
        int b16 = mVar.b(3);
        mVar.g();
        mVar.d(88);
        mVar.d(8);
        int i16 = 0;
        for (int i17 = 0; i17 < b16; i17++) {
            if (mVar.c()) {
                i16 += 89;
            }
            if (mVar.c()) {
                i16 += 8;
            }
        }
        mVar.d(i16);
        if (b16 > 0) {
            mVar.d((8 - b16) * 2);
        }
        mVar.f();
        int f18 = mVar.f();
        if (f18 == 3) {
            mVar.g();
        }
        int f19 = mVar.f();
        int f26 = mVar.f();
        if (mVar.c()) {
            int f27 = mVar.f();
            int f28 = mVar.f();
            int f29 = mVar.f();
            int f36 = mVar.f();
            f19 -= ((f18 == 1 || f18 == 2) ? 2 : 1) * (f27 + f28);
            f26 -= (f18 == 1 ? 2 : 1) * (f29 + f36);
        }
        int i18 = f19;
        int i19 = f26;
        mVar.f();
        mVar.f();
        int f37 = mVar.f();
        for (int i26 = mVar.c() ? 0 : b16; i26 <= b16; i26++) {
            mVar.f();
            mVar.f();
            mVar.f();
        }
        mVar.f();
        mVar.f();
        mVar.f();
        mVar.f();
        mVar.f();
        mVar.f();
        if (mVar.c() && mVar.c()) {
            a(mVar);
        }
        mVar.d(2);
        if (mVar.c()) {
            mVar.d(8);
            mVar.f();
            mVar.f();
            mVar.g();
        }
        b(mVar);
        if (mVar.c()) {
            for (int i27 = 0; i27 < mVar.f(); i27++) {
                mVar.d(f37 + 4 + 1);
            }
        }
        mVar.d(2);
        if (mVar.c() && mVar.c()) {
            int b17 = mVar.b(8);
            if (b17 == 255) {
                int b18 = mVar.b(16);
                int b19 = mVar.b(16);
                if (b18 != 0 && b19 != 0) {
                    f17 = b18 / b19;
                    return com.tencent.luggage.wxa.m.j.a(str, "video/hevc", (String) null, -1, -1, i18, i19, -1.0f, Collections.singletonList(bArr), -1, f17, (com.tencent.luggage.wxa.p.a) null);
                }
            } else {
                float[] fArr = com.tencent.luggage.wxa.n0.j.f135068b;
                if (b17 < fArr.length) {
                    f16 = fArr[b17];
                    f17 = f16;
                    return com.tencent.luggage.wxa.m.j.a(str, "video/hevc", (String) null, -1, -1, i18, i19, -1.0f, Collections.singletonList(bArr), -1, f17, (com.tencent.luggage.wxa.p.a) null);
                }
                Log.w("H265Reader", "Unexpected aspect_ratio_idc value: " + b17);
            }
        }
        f16 = 1.0f;
        f17 = f16;
        return com.tencent.luggage.wxa.m.j.a(str, "video/hevc", (String) null, -1, -1, i18, i19, -1.0f, Collections.singletonList(bArr), -1, f17, (com.tencent.luggage.wxa.p.a) null);
    }

    public static void a(com.tencent.luggage.wxa.n0.m mVar) {
        for (int i3 = 0; i3 < 4; i3++) {
            int i16 = 0;
            while (i16 < 6) {
                int i17 = 1;
                if (!mVar.c()) {
                    mVar.f();
                } else {
                    int min = Math.min(64, 1 << ((i3 << 1) + 4));
                    if (i3 > 1) {
                        mVar.e();
                    }
                    for (int i18 = 0; i18 < min; i18++) {
                        mVar.e();
                    }
                }
                if (i3 == 3) {
                    i17 = 3;
                }
                i16 += i17;
            }
        }
    }
}

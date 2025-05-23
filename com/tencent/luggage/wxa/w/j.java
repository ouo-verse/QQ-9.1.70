package com.tencent.luggage.wxa.w;

import android.util.SparseArray;
import com.tencent.luggage.wxa.n0.j;
import com.tencent.luggage.wxa.w.v;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements h {

    /* renamed from: a, reason: collision with root package name */
    public final s f143812a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f143813b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f143814c;

    /* renamed from: g, reason: collision with root package name */
    public long f143818g;

    /* renamed from: i, reason: collision with root package name */
    public String f143820i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.q.l f143821j;

    /* renamed from: k, reason: collision with root package name */
    public b f143822k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f143823l;

    /* renamed from: m, reason: collision with root package name */
    public long f143824m;

    /* renamed from: h, reason: collision with root package name */
    public final boolean[] f143819h = new boolean[3];

    /* renamed from: d, reason: collision with root package name */
    public final n f143815d = new n(7, 128);

    /* renamed from: e, reason: collision with root package name */
    public final n f143816e = new n(8, 128);

    /* renamed from: f, reason: collision with root package name */
    public final n f143817f = new n(6, 128);

    /* renamed from: n, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143825n = new com.tencent.luggage.wxa.n0.l();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final com.tencent.luggage.wxa.q.l f143826a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f143827b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f143828c;

        /* renamed from: d, reason: collision with root package name */
        public final SparseArray f143829d = new SparseArray();

        /* renamed from: e, reason: collision with root package name */
        public final SparseArray f143830e = new SparseArray();

        /* renamed from: f, reason: collision with root package name */
        public final com.tencent.luggage.wxa.n0.m f143831f;

        /* renamed from: g, reason: collision with root package name */
        public byte[] f143832g;

        /* renamed from: h, reason: collision with root package name */
        public int f143833h;

        /* renamed from: i, reason: collision with root package name */
        public int f143834i;

        /* renamed from: j, reason: collision with root package name */
        public long f143835j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f143836k;

        /* renamed from: l, reason: collision with root package name */
        public long f143837l;

        /* renamed from: m, reason: collision with root package name */
        public a f143838m;

        /* renamed from: n, reason: collision with root package name */
        public a f143839n;

        /* renamed from: o, reason: collision with root package name */
        public boolean f143840o;

        /* renamed from: p, reason: collision with root package name */
        public long f143841p;

        /* renamed from: q, reason: collision with root package name */
        public long f143842q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f143843r;

        /* compiled from: P */
        /* loaded from: classes8.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            public boolean f143844a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f143845b;

            /* renamed from: c, reason: collision with root package name */
            public j.b f143846c;

            /* renamed from: d, reason: collision with root package name */
            public int f143847d;

            /* renamed from: e, reason: collision with root package name */
            public int f143848e;

            /* renamed from: f, reason: collision with root package name */
            public int f143849f;

            /* renamed from: g, reason: collision with root package name */
            public int f143850g;

            /* renamed from: h, reason: collision with root package name */
            public boolean f143851h;

            /* renamed from: i, reason: collision with root package name */
            public boolean f143852i;

            /* renamed from: j, reason: collision with root package name */
            public boolean f143853j;

            /* renamed from: k, reason: collision with root package name */
            public boolean f143854k;

            /* renamed from: l, reason: collision with root package name */
            public int f143855l;

            /* renamed from: m, reason: collision with root package name */
            public int f143856m;

            /* renamed from: n, reason: collision with root package name */
            public int f143857n;

            /* renamed from: o, reason: collision with root package name */
            public int f143858o;

            /* renamed from: p, reason: collision with root package name */
            public int f143859p;

            public a() {
            }

            public boolean b() {
                int i3;
                if (this.f143845b && ((i3 = this.f143848e) == 7 || i3 == 2)) {
                    return true;
                }
                return false;
            }

            public void a() {
                this.f143845b = false;
                this.f143844a = false;
            }

            public void a(int i3) {
                this.f143848e = i3;
                this.f143845b = true;
            }

            public void a(j.b bVar, int i3, int i16, int i17, int i18, boolean z16, boolean z17, boolean z18, boolean z19, int i19, int i26, int i27, int i28, int i29) {
                this.f143846c = bVar;
                this.f143847d = i3;
                this.f143848e = i16;
                this.f143849f = i17;
                this.f143850g = i18;
                this.f143851h = z16;
                this.f143852i = z17;
                this.f143853j = z18;
                this.f143854k = z19;
                this.f143855l = i19;
                this.f143856m = i26;
                this.f143857n = i27;
                this.f143858o = i28;
                this.f143859p = i29;
                this.f143844a = true;
                this.f143845b = true;
            }

            public final boolean a(a aVar) {
                boolean z16;
                boolean z17;
                if (this.f143844a) {
                    if (!aVar.f143844a || this.f143849f != aVar.f143849f || this.f143850g != aVar.f143850g || this.f143851h != aVar.f143851h) {
                        return true;
                    }
                    if (this.f143852i && aVar.f143852i && this.f143853j != aVar.f143853j) {
                        return true;
                    }
                    int i3 = this.f143847d;
                    int i16 = aVar.f143847d;
                    if (i3 != i16 && (i3 == 0 || i16 == 0)) {
                        return true;
                    }
                    int i17 = this.f143846c.f135081h;
                    if (i17 == 0 && aVar.f143846c.f135081h == 0 && (this.f143856m != aVar.f143856m || this.f143857n != aVar.f143857n)) {
                        return true;
                    }
                    if ((i17 == 1 && aVar.f143846c.f135081h == 1 && (this.f143858o != aVar.f143858o || this.f143859p != aVar.f143859p)) || (z16 = this.f143854k) != (z17 = aVar.f143854k)) {
                        return true;
                    }
                    if (z16 && z17 && this.f143855l != aVar.f143855l) {
                        return true;
                    }
                }
                return false;
            }
        }

        public b(com.tencent.luggage.wxa.q.l lVar, boolean z16, boolean z17) {
            this.f143826a = lVar;
            this.f143827b = z16;
            this.f143828c = z17;
            this.f143838m = new a();
            this.f143839n = new a();
            byte[] bArr = new byte[128];
            this.f143832g = bArr;
            this.f143831f = new com.tencent.luggage.wxa.n0.m(bArr, 0, 0);
            b();
        }

        public boolean a() {
            return this.f143828c;
        }

        public void b() {
            this.f143836k = false;
            this.f143840o = false;
            this.f143839n.a();
        }

        public void a(j.b bVar) {
            this.f143829d.append(bVar.f135074a, bVar);
        }

        public void a(j.a aVar) {
            this.f143830e.append(aVar.f135071a, aVar);
        }

        public void a(long j3, int i3, long j16) {
            this.f143834i = i3;
            this.f143837l = j16;
            this.f143835j = j3;
            if (!this.f143827b || i3 != 1) {
                if (!this.f143828c) {
                    return;
                }
                if (i3 != 5 && i3 != 1 && i3 != 2) {
                    return;
                }
            }
            a aVar = this.f143838m;
            this.f143838m = this.f143839n;
            this.f143839n = aVar;
            aVar.a();
            this.f143833h = 0;
            this.f143836k = true;
        }

        /* JADX WARN: Removed duplicated region for block: B:50:0x00fb  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0102  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x011a  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
        /* JADX WARN: Removed duplicated region for block: B:89:0x00fe  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(byte[] bArr, int i3, int i16) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            int i17;
            int i18;
            int i19;
            int i26;
            int i27;
            int i28;
            if (this.f143836k) {
                int i29 = i16 - i3;
                byte[] bArr2 = this.f143832g;
                int length = bArr2.length;
                int i36 = this.f143833h + i29;
                if (length < i36) {
                    this.f143832g = Arrays.copyOf(bArr2, i36 * 2);
                }
                System.arraycopy(bArr, i3, this.f143832g, this.f143833h, i29);
                int i37 = this.f143833h + i29;
                this.f143833h = i37;
                this.f143831f.a(this.f143832g, 0, i37);
                if (this.f143831f.a(8)) {
                    this.f143831f.g();
                    int b16 = this.f143831f.b(2);
                    this.f143831f.d(5);
                    if (this.f143831f.b()) {
                        this.f143831f.f();
                        if (this.f143831f.b()) {
                            int f16 = this.f143831f.f();
                            if (!this.f143828c) {
                                this.f143836k = false;
                                this.f143839n.a(f16);
                                return;
                            }
                            if (this.f143831f.b()) {
                                int f17 = this.f143831f.f();
                                if (this.f143830e.indexOfKey(f17) < 0) {
                                    this.f143836k = false;
                                    return;
                                }
                                j.a aVar = (j.a) this.f143830e.get(f17);
                                j.b bVar = (j.b) this.f143829d.get(aVar.f135072b);
                                if (bVar.f135078e) {
                                    if (!this.f143831f.a(2)) {
                                        return;
                                    } else {
                                        this.f143831f.d(2);
                                    }
                                }
                                if (this.f143831f.a(bVar.f135080g)) {
                                    int b17 = this.f143831f.b(bVar.f135080g);
                                    if (bVar.f135079f) {
                                        z16 = false;
                                        z17 = false;
                                    } else {
                                        if (!this.f143831f.a(1)) {
                                            return;
                                        }
                                        boolean c16 = this.f143831f.c();
                                        if (c16) {
                                            if (this.f143831f.a(1)) {
                                                z16 = c16;
                                                z17 = true;
                                                z18 = this.f143831f.c();
                                                z19 = this.f143834i != 5;
                                                if (z19) {
                                                    i17 = 0;
                                                } else if (!this.f143831f.b()) {
                                                    return;
                                                } else {
                                                    i17 = this.f143831f.f();
                                                }
                                                i18 = bVar.f135081h;
                                                if (i18 != 0) {
                                                    if (!this.f143831f.a(bVar.f135082i)) {
                                                        return;
                                                    }
                                                    int b18 = this.f143831f.b(bVar.f135082i);
                                                    if (aVar.f135073c && !z16) {
                                                        if (this.f143831f.b()) {
                                                            i26 = this.f143831f.e();
                                                            i19 = b18;
                                                            i27 = 0;
                                                            i28 = i27;
                                                            this.f143839n.a(bVar, b16, f16, b17, f17, z16, z17, z18, z19, i17, i19, i26, i27, i28);
                                                            this.f143836k = false;
                                                        }
                                                        return;
                                                    }
                                                    i19 = b18;
                                                    i26 = 0;
                                                } else {
                                                    if (i18 == 1 && !bVar.f135083j) {
                                                        if (this.f143831f.b()) {
                                                            int e16 = this.f143831f.e();
                                                            if (!aVar.f135073c || z16) {
                                                                i27 = e16;
                                                                i19 = 0;
                                                                i26 = 0;
                                                                i28 = 0;
                                                            } else {
                                                                if (!this.f143831f.b()) {
                                                                    return;
                                                                }
                                                                i28 = this.f143831f.e();
                                                                i27 = e16;
                                                                i19 = 0;
                                                                i26 = 0;
                                                            }
                                                            this.f143839n.a(bVar, b16, f16, b17, f17, z16, z17, z18, z19, i17, i19, i26, i27, i28);
                                                            this.f143836k = false;
                                                        }
                                                        return;
                                                    }
                                                    i19 = 0;
                                                    i26 = 0;
                                                }
                                                i27 = i26;
                                                i28 = i27;
                                                this.f143839n.a(bVar, b16, f16, b17, f17, z16, z17, z18, z19, i17, i19, i26, i27, i28);
                                                this.f143836k = false;
                                            }
                                            return;
                                        }
                                        z16 = c16;
                                        z17 = false;
                                    }
                                    z18 = z17;
                                    if (this.f143834i != 5) {
                                    }
                                    if (z19) {
                                    }
                                    i18 = bVar.f135081h;
                                    if (i18 != 0) {
                                    }
                                    i27 = i26;
                                    i28 = i27;
                                    this.f143839n.a(bVar, b16, f16, b17, f17, z16, z17, z18, z19, i17, i19, i26, i27, i28);
                                    this.f143836k = false;
                                }
                            }
                        }
                    }
                }
            }
        }

        public void a(long j3, int i3) {
            boolean z16 = false;
            if (this.f143834i == 9 || (this.f143828c && this.f143839n.a(this.f143838m))) {
                if (this.f143840o) {
                    a(i3 + ((int) (j3 - this.f143835j)));
                }
                this.f143841p = this.f143835j;
                this.f143842q = this.f143837l;
                this.f143843r = false;
                this.f143840o = true;
            }
            boolean z17 = this.f143843r;
            int i16 = this.f143834i;
            if (i16 == 5 || (this.f143827b && i16 == 1 && this.f143839n.b())) {
                z16 = true;
            }
            this.f143843r = z17 | z16;
        }

        public final void a(int i3) {
            boolean z16 = this.f143843r;
            this.f143826a.a(this.f143842q, z16 ? 1 : 0, (int) (this.f143835j - this.f143841p), i3, null);
        }
    }

    public j(s sVar, boolean z16, boolean z17) {
        this.f143812a = sVar;
        this.f143813b = z16;
        this.f143814c = z17;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a() {
        com.tencent.luggage.wxa.n0.j.a(this.f143819h);
        this.f143815d.b();
        this.f143816e.b();
        this.f143817f.b();
        this.f143822k.b();
        this.f143818g = 0L;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.q.f fVar, v.d dVar) {
        dVar.a();
        this.f143820i = dVar.b();
        com.tencent.luggage.wxa.q.l a16 = fVar.a(dVar.c(), 2);
        this.f143821j = a16;
        this.f143822k = new b(a16, this.f143813b, this.f143814c);
        this.f143812a.a(fVar, dVar);
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(long j3, boolean z16) {
        this.f143824m = j3;
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void a(com.tencent.luggage.wxa.n0.l lVar) {
        int c16 = lVar.c();
        int d16 = lVar.d();
        byte[] bArr = lVar.f135088a;
        this.f143818g += lVar.a();
        this.f143821j.a(lVar, lVar.a());
        while (true) {
            int a16 = com.tencent.luggage.wxa.n0.j.a(bArr, c16, d16, this.f143819h);
            if (a16 == d16) {
                a(bArr, c16, d16);
                return;
            }
            int b16 = com.tencent.luggage.wxa.n0.j.b(bArr, a16);
            int i3 = a16 - c16;
            if (i3 > 0) {
                a(bArr, c16, a16);
            }
            int i16 = d16 - a16;
            long j3 = this.f143818g - i16;
            a(j3, i16, i3 < 0 ? -i3 : 0, this.f143824m);
            a(j3, b16, this.f143824m);
            c16 = a16 + 3;
        }
    }

    @Override // com.tencent.luggage.wxa.w.h
    public void b() {
    }

    public final void a(long j3, int i3, long j16) {
        if (!this.f143823l || this.f143822k.a()) {
            this.f143815d.b(i3);
            this.f143816e.b(i3);
        }
        this.f143817f.b(i3);
        this.f143822k.a(j3, i3, j16);
    }

    public final void a(byte[] bArr, int i3, int i16) {
        if (!this.f143823l || this.f143822k.a()) {
            this.f143815d.a(bArr, i3, i16);
            this.f143816e.a(bArr, i3, i16);
        }
        this.f143817f.a(bArr, i3, i16);
        this.f143822k.a(bArr, i3, i16);
    }

    public final void a(long j3, int i3, int i16, long j16) {
        if (!this.f143823l || this.f143822k.a()) {
            this.f143815d.a(i16);
            this.f143816e.a(i16);
            if (!this.f143823l) {
                if (this.f143815d.a() && this.f143816e.a()) {
                    ArrayList arrayList = new ArrayList();
                    n nVar = this.f143815d;
                    arrayList.add(Arrays.copyOf(nVar.f143908d, nVar.f143909e));
                    n nVar2 = this.f143816e;
                    arrayList.add(Arrays.copyOf(nVar2.f143908d, nVar2.f143909e));
                    n nVar3 = this.f143815d;
                    j.b c16 = com.tencent.luggage.wxa.n0.j.c(nVar3.f143908d, 3, nVar3.f143909e);
                    n nVar4 = this.f143816e;
                    j.a b16 = com.tencent.luggage.wxa.n0.j.b(nVar4.f143908d, 3, nVar4.f143909e);
                    this.f143821j.a(com.tencent.luggage.wxa.m.j.a(this.f143820i, "video/avc", (String) null, -1, -1, c16.f135075b, c16.f135076c, -1.0f, arrayList, -1, c16.f135077d, (com.tencent.luggage.wxa.p.a) null));
                    this.f143823l = true;
                    this.f143822k.a(c16);
                    this.f143822k.a(b16);
                    this.f143815d.b();
                    this.f143816e.b();
                }
            } else if (this.f143815d.a()) {
                n nVar5 = this.f143815d;
                this.f143822k.a(com.tencent.luggage.wxa.n0.j.c(nVar5.f143908d, 3, nVar5.f143909e));
                this.f143815d.b();
            } else if (this.f143816e.a()) {
                n nVar6 = this.f143816e;
                this.f143822k.a(com.tencent.luggage.wxa.n0.j.b(nVar6.f143908d, 3, nVar6.f143909e));
                this.f143816e.b();
            }
        }
        if (this.f143817f.a(i16)) {
            n nVar7 = this.f143817f;
            this.f143825n.a(this.f143817f.f143908d, com.tencent.luggage.wxa.n0.j.c(nVar7.f143908d, nVar7.f143909e));
            this.f143825n.e(4);
            this.f143812a.a(j16, this.f143825n);
        }
        this.f143822k.a(j3, i3);
    }
}

package com.tencent.luggage.wxa.d0;

import com.tencent.luggage.wxa.d0.i;
import com.tencent.luggage.wxa.q.l;
import java.io.EOFException;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements com.tencent.luggage.wxa.q.l {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.l0.b f124019a;

    /* renamed from: b, reason: collision with root package name */
    public final int f124020b;

    /* renamed from: c, reason: collision with root package name */
    public final i f124021c;

    /* renamed from: d, reason: collision with root package name */
    public final i.a f124022d;

    /* renamed from: e, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f124023e;

    /* renamed from: f, reason: collision with root package name */
    public a f124024f;

    /* renamed from: g, reason: collision with root package name */
    public a f124025g;

    /* renamed from: h, reason: collision with root package name */
    public a f124026h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.j f124027i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f124028j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.m.j f124029k;

    /* renamed from: l, reason: collision with root package name */
    public long f124030l;

    /* renamed from: m, reason: collision with root package name */
    public long f124031m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f124032n;

    /* renamed from: o, reason: collision with root package name */
    public b f124033o;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b {
        void a(com.tencent.luggage.wxa.m.j jVar);
    }

    public j(com.tencent.luggage.wxa.l0.b bVar) {
        this.f124019a = bVar;
        int c16 = bVar.c();
        this.f124020b = c16;
        this.f124021c = new i();
        this.f124022d = new i.a();
        this.f124023e = new com.tencent.luggage.wxa.n0.l(32);
        a aVar = new a(0L, c16);
        this.f124024f = aVar;
        this.f124025g = aVar;
        this.f124026h = aVar;
    }

    public void a(boolean z16) {
        this.f124021c.a(z16);
        a(this.f124024f);
        a aVar = new a(0L, this.f124020b);
        this.f124024f = aVar;
        this.f124025g = aVar;
        this.f124026h = aVar;
        this.f124031m = 0L;
        this.f124019a.b();
    }

    public void b(long j3, boolean z16, boolean z17) {
        b(this.f124021c.b(j3, z16, z17));
    }

    public void c(int i3) {
        this.f124021c.e(i3);
    }

    public long d() {
        return this.f124021c.d();
    }

    public int e() {
        return this.f124021c.e();
    }

    public com.tencent.luggage.wxa.m.j f() {
        return this.f124021c.f();
    }

    public int g() {
        return this.f124021c.g();
    }

    public boolean h() {
        return this.f124021c.h();
    }

    public int i() {
        return this.f124021c.i();
    }

    public void j() {
        a(false);
    }

    public void k() {
        this.f124021c.j();
        this.f124025g = this.f124024f;
    }

    public void l() {
        this.f124032n = true;
    }

    public void b() {
        b(this.f124021c.b());
    }

    public void c() {
        b(this.f124021c.c());
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f124034a;

        /* renamed from: b, reason: collision with root package name */
        public final long f124035b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f124036c;

        /* renamed from: d, reason: collision with root package name */
        public com.tencent.luggage.wxa.l0.a f124037d;

        /* renamed from: e, reason: collision with root package name */
        public a f124038e;

        public a(long j3, int i3) {
            this.f124034a = j3;
            this.f124035b = j3 + i3;
        }

        public void a(com.tencent.luggage.wxa.l0.a aVar, a aVar2) {
            this.f124037d = aVar;
            this.f124038e = aVar2;
            this.f124036c = true;
        }

        public int a(long j3) {
            return ((int) (j3 - this.f124034a)) + this.f124037d.f132761b;
        }

        public a a() {
            this.f124037d = null;
            a aVar = this.f124038e;
            this.f124038e = null;
            return aVar;
        }
    }

    public final void b(long j3) {
        a aVar;
        if (j3 == -1) {
            return;
        }
        while (true) {
            aVar = this.f124024f;
            if (j3 < aVar.f124035b) {
                break;
            }
            this.f124019a.a(aVar.f124037d);
            this.f124024f = this.f124024f.a();
        }
        if (this.f124025g.f124034a < aVar.f124034a) {
            this.f124025g = aVar;
        }
    }

    public void a() {
        this.f124021c.a();
    }

    public final int b(int i3) {
        a aVar = this.f124026h;
        if (!aVar.f124036c) {
            aVar.a(this.f124019a.a(), new a(this.f124026h.f124035b, this.f124020b));
        }
        return Math.min(i3, (int) (this.f124026h.f124035b - this.f124031m));
    }

    public boolean a(long j3, boolean z16, boolean z17) {
        return this.f124021c.a(j3, z16, z17);
    }

    public int a(com.tencent.luggage.wxa.m.k kVar, com.tencent.luggage.wxa.o.d dVar, boolean z16, boolean z17, long j3) {
        int a16 = this.f124021c.a(kVar, dVar, z16, z17, this.f124027i, this.f124022d);
        if (a16 == -5) {
            this.f124027i = kVar.f133904a;
            return -5;
        }
        if (a16 != -4) {
            if (a16 == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!dVar.c()) {
            if (dVar.f135957d < j3) {
                dVar.a(Integer.MIN_VALUE);
            }
            if (dVar.f()) {
                a(dVar, this.f124022d);
            }
            dVar.e(this.f124022d.f124016a);
            i.a aVar = this.f124022d;
            a(aVar.f124017b, dVar.f135956c, aVar.f124016a);
        }
        return -4;
    }

    public final void a(com.tencent.luggage.wxa.o.d dVar, i.a aVar) {
        long j3 = aVar.f124017b;
        int i3 = 1;
        this.f124023e.c(1);
        a(j3, this.f124023e.f135088a, 1);
        long j16 = j3 + 1;
        byte b16 = this.f124023e.f135088a[0];
        boolean z16 = (b16 & 128) != 0;
        int i16 = b16 & Byte.MAX_VALUE;
        com.tencent.luggage.wxa.o.b bVar = dVar.f135955b;
        if (bVar.f135936a == null) {
            bVar.f135936a = new byte[16];
        }
        a(j16, bVar.f135936a, i16);
        long j17 = j16 + i16;
        if (z16) {
            this.f124023e.c(2);
            a(j17, this.f124023e.f135088a, 2);
            j17 += 2;
            i3 = this.f124023e.w();
        }
        int i17 = i3;
        com.tencent.luggage.wxa.o.b bVar2 = dVar.f135955b;
        int[] iArr = bVar2.f135939d;
        if (iArr == null || iArr.length < i17) {
            iArr = new int[i17];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = bVar2.f135940e;
        if (iArr3 == null || iArr3.length < i17) {
            iArr3 = new int[i17];
        }
        int[] iArr4 = iArr3;
        if (z16) {
            int i18 = i17 * 6;
            this.f124023e.c(i18);
            a(j17, this.f124023e.f135088a, i18);
            j17 += i18;
            this.f124023e.e(0);
            for (int i19 = 0; i19 < i17; i19++) {
                iArr2[i19] = this.f124023e.w();
                iArr4[i19] = this.f124023e.u();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar.f124016a - ((int) (j17 - aVar.f124017b));
        }
        l.a aVar2 = aVar.f124018c;
        com.tencent.luggage.wxa.o.b bVar3 = dVar.f135955b;
        bVar3.a(i17, iArr2, iArr4, aVar2.f137772b, bVar3.f135936a, aVar2.f137771a, aVar2.f137773c, aVar2.f137774d);
        long j18 = aVar.f124017b;
        int i26 = (int) (j17 - j18);
        aVar.f124017b = j18 + i26;
        aVar.f124016a -= i26;
    }

    public final void a(long j3, ByteBuffer byteBuffer, int i3) {
        a(j3);
        while (i3 > 0) {
            int min = Math.min(i3, (int) (this.f124025g.f124035b - j3));
            a aVar = this.f124025g;
            byteBuffer.put(aVar.f124037d.f132760a, aVar.a(j3), min);
            i3 -= min;
            j3 += min;
            a aVar2 = this.f124025g;
            if (j3 == aVar2.f124035b) {
                this.f124025g = aVar2.f124038e;
            }
        }
    }

    public final void a(long j3, byte[] bArr, int i3) {
        a(j3);
        int i16 = i3;
        while (i16 > 0) {
            int min = Math.min(i16, (int) (this.f124025g.f124035b - j3));
            a aVar = this.f124025g;
            System.arraycopy(aVar.f124037d.f132760a, aVar.a(j3), bArr, i3 - i16, min);
            i16 -= min;
            j3 += min;
            a aVar2 = this.f124025g;
            if (j3 == aVar2.f124035b) {
                this.f124025g = aVar2.f124038e;
            }
        }
    }

    public final void a(long j3) {
        while (true) {
            a aVar = this.f124025g;
            if (j3 < aVar.f124035b) {
                return;
            } else {
                this.f124025g = aVar.f124038e;
            }
        }
    }

    public void a(b bVar) {
        this.f124033o = bVar;
    }

    @Override // com.tencent.luggage.wxa.q.l
    public void a(com.tencent.luggage.wxa.m.j jVar) {
        com.tencent.luggage.wxa.m.j a16 = a(jVar, this.f124030l);
        boolean a17 = this.f124021c.a(a16);
        this.f124029k = jVar;
        this.f124028j = false;
        b bVar = this.f124033o;
        if (bVar == null || !a17) {
            return;
        }
        bVar.a(a16);
    }

    @Override // com.tencent.luggage.wxa.q.l
    public int a(com.tencent.luggage.wxa.q.e eVar, int i3, boolean z16) {
        int b16 = b(i3);
        a aVar = this.f124026h;
        int read = eVar.read(aVar.f124037d.f132760a, aVar.a(this.f124031m), b16);
        if (read != -1) {
            a(read);
            return read;
        }
        if (z16) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.tencent.luggage.wxa.q.l
    public void a(com.tencent.luggage.wxa.n0.l lVar, int i3) {
        while (i3 > 0) {
            int b16 = b(i3);
            a aVar = this.f124026h;
            lVar.a(aVar.f124037d.f132760a, aVar.a(this.f124031m), b16);
            i3 -= b16;
            a(b16);
        }
    }

    @Override // com.tencent.luggage.wxa.q.l
    public void a(long j3, int i3, int i16, int i17, l.a aVar) {
        if (this.f124028j) {
            a(this.f124029k);
        }
        if (this.f124032n) {
            if ((i3 & 1) == 0 || !this.f124021c.a(j3)) {
                return;
            } else {
                this.f124032n = false;
            }
        }
        this.f124021c.a(j3 + this.f124030l, i3, (this.f124031m - i16) - i17, i16, aVar);
    }

    public final void a(a aVar) {
        if (aVar.f124036c) {
            a aVar2 = this.f124026h;
            boolean z16 = aVar2.f124036c;
            int i3 = (z16 ? 1 : 0) + (((int) (aVar2.f124034a - aVar.f124034a)) / this.f124020b);
            com.tencent.luggage.wxa.l0.a[] aVarArr = new com.tencent.luggage.wxa.l0.a[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                aVarArr[i16] = aVar.f124037d;
                aVar = aVar.a();
            }
            this.f124019a.a(aVarArr);
        }
    }

    public final void a(int i3) {
        long j3 = this.f124031m + i3;
        this.f124031m = j3;
        a aVar = this.f124026h;
        if (j3 == aVar.f124035b) {
            this.f124026h = aVar.f124038e;
        }
    }

    public static com.tencent.luggage.wxa.m.j a(com.tencent.luggage.wxa.m.j jVar, long j3) {
        if (jVar == null) {
            return null;
        }
        if (j3 == 0) {
            return jVar;
        }
        long j16 = jVar.L;
        return j16 != Long.MAX_VALUE ? jVar.a(j16 + j3) : jVar;
    }
}

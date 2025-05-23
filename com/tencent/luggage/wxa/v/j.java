package com.tencent.luggage.wxa.v;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.n0.l;
import com.tencent.luggage.wxa.v.h;
import com.tencent.luggage.wxa.v.k;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends h {

    /* renamed from: n, reason: collision with root package name */
    public a f142906n;

    /* renamed from: o, reason: collision with root package name */
    public int f142907o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f142908p;

    /* renamed from: q, reason: collision with root package name */
    public k.d f142909q;

    /* renamed from: r, reason: collision with root package name */
    public k.b f142910r;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final k.d f142911a;

        /* renamed from: b, reason: collision with root package name */
        public final k.b f142912b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f142913c;

        /* renamed from: d, reason: collision with root package name */
        public final k.c[] f142914d;

        /* renamed from: e, reason: collision with root package name */
        public final int f142915e;

        public a(k.d dVar, k.b bVar, byte[] bArr, k.c[] cVarArr, int i3) {
            this.f142911a = dVar;
            this.f142912b = bVar;
            this.f142913c = bArr;
            this.f142914d = cVarArr;
            this.f142915e = i3;
        }
    }

    public static int a(byte b16, int i3, int i16) {
        return (b16 >> i16) & (255 >>> (8 - i3));
    }

    public static boolean c(l lVar) {
        try {
            return k.a(1, lVar, true);
        } catch (o unused) {
            return false;
        }
    }

    public a b(l lVar) {
        if (this.f142909q == null) {
            this.f142909q = k.b(lVar);
            return null;
        }
        if (this.f142910r == null) {
            this.f142910r = k.a(lVar);
            return null;
        }
        byte[] bArr = new byte[lVar.d()];
        System.arraycopy(lVar.f135088a, 0, bArr, 0, lVar.d());
        return new a(this.f142909q, this.f142910r, bArr, k.a(lVar, this.f142909q.f142929b), k.a(r5.length - 1));
    }

    @Override // com.tencent.luggage.wxa.v.h
    public void a(boolean z16) {
        super.a(z16);
        if (z16) {
            this.f142906n = null;
            this.f142909q = null;
            this.f142910r = null;
        }
        this.f142907o = 0;
        this.f142908p = false;
    }

    @Override // com.tencent.luggage.wxa.v.h
    public void c(long j3) {
        super.c(j3);
        this.f142908p = j3 != 0;
        k.d dVar = this.f142909q;
        this.f142907o = dVar != null ? dVar.f142934g : 0;
    }

    @Override // com.tencent.luggage.wxa.v.h
    public long a(l lVar) {
        byte b16 = lVar.f135088a[0];
        if ((b16 & 1) == 1) {
            return -1L;
        }
        int a16 = a(b16, this.f142906n);
        long j3 = this.f142908p ? (this.f142907o + a16) / 4 : 0;
        a(lVar, j3);
        this.f142908p = true;
        this.f142907o = a16;
        return j3;
    }

    @Override // com.tencent.luggage.wxa.v.h
    public boolean a(l lVar, long j3, h.b bVar) {
        if (this.f142906n != null) {
            return false;
        }
        a b16 = b(lVar);
        this.f142906n = b16;
        if (b16 == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f142906n.f142911a.f142937j);
        arrayList.add(this.f142906n.f142913c);
        k.d dVar = this.f142906n.f142911a;
        bVar.f142900a = com.tencent.luggage.wxa.m.j.a(null, "audio/vorbis", null, dVar.f142932e, -1, dVar.f142929b, (int) dVar.f142930c, arrayList, null, 0, null);
        return true;
    }

    public static void a(l lVar, long j3) {
        lVar.d(lVar.d() + 4);
        lVar.f135088a[lVar.d() - 4] = (byte) (j3 & 255);
        lVar.f135088a[lVar.d() - 3] = (byte) ((j3 >>> 8) & 255);
        lVar.f135088a[lVar.d() - 2] = (byte) ((j3 >>> 16) & 255);
        lVar.f135088a[lVar.d() - 1] = (byte) ((j3 >>> 24) & 255);
    }

    public static int a(byte b16, a aVar) {
        if (!aVar.f142914d[a(b16, aVar.f142915e, 1)].f142924a) {
            return aVar.f142911a.f142934g;
        }
        return aVar.f142911a.f142935h;
    }
}

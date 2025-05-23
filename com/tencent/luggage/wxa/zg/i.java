package com.tencent.luggage.wxa.zg;

import com.tencent.luggage.wxa.w.p;
import com.tencent.luggage.wxa.w.u;
import java.lang.reflect.Constructor;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class i implements com.tencent.luggage.wxa.q.g {

    /* renamed from: g, reason: collision with root package name */
    public static final Constructor f146650g;

    /* renamed from: a, reason: collision with root package name */
    public int f146651a;

    /* renamed from: b, reason: collision with root package name */
    public int f146652b;

    /* renamed from: c, reason: collision with root package name */
    public int f146653c;

    /* renamed from: d, reason: collision with root package name */
    public int f146654d;

    /* renamed from: e, reason: collision with root package name */
    public int f146655e = 1;

    /* renamed from: f, reason: collision with root package name */
    public int f146656f;

    static {
        Constructor constructor;
        try {
            constructor = Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(com.tencent.luggage.wxa.q.d.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        f146650g = constructor;
    }

    @Override // com.tencent.luggage.wxa.q.g
    public synchronized com.tencent.luggage.wxa.q.d[] a() {
        int i3;
        com.tencent.luggage.wxa.q.d[] dVarArr;
        Constructor constructor = f146650g;
        if (constructor == null) {
            i3 = 11;
        } else {
            i3 = 12;
        }
        dVarArr = new com.tencent.luggage.wxa.q.d[i3];
        dVarArr[0] = new com.tencent.luggage.wxa.u.g(this.f146652b);
        dVarArr[1] = new u(this.f146655e, this.f146656f);
        dVarArr[2] = new com.tencent.luggage.wxa.u.e(this.f146653c);
        dVarArr[3] = new com.tencent.luggage.wxa.t.b(this.f146654d);
        dVarArr[4] = new com.tencent.luggage.wxa.s.d(this.f146651a);
        dVarArr[5] = new com.tencent.luggage.wxa.w.c();
        dVarArr[6] = new com.tencent.luggage.wxa.w.a();
        dVarArr[7] = new com.tencent.luggage.wxa.r.b();
        dVarArr[8] = new com.tencent.luggage.wxa.v.c();
        dVarArr[9] = new p();
        dVarArr[10] = new com.tencent.luggage.wxa.x.a();
        if (constructor != null) {
            try {
                dVarArr[11] = (com.tencent.luggage.wxa.q.d) constructor.newInstance(new Object[0]);
            } catch (Exception e16) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e16);
            }
        }
        return dVarArr;
    }
}

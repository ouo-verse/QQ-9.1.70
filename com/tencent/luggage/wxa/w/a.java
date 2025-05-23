package com.tencent.luggage.wxa.w;

import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.w.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements com.tencent.luggage.wxa.q.d {

    /* renamed from: e, reason: collision with root package name */
    public static final com.tencent.luggage.wxa.q.g f143732e = new C6857a();

    /* renamed from: f, reason: collision with root package name */
    public static final int f143733f = com.tencent.luggage.wxa.n0.v.b("ID3");

    /* renamed from: a, reason: collision with root package name */
    public final long f143734a;

    /* renamed from: b, reason: collision with root package name */
    public final b f143735b;

    /* renamed from: c, reason: collision with root package name */
    public final com.tencent.luggage.wxa.n0.l f143736c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f143737d;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.w.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6857a implements com.tencent.luggage.wxa.q.g {
        @Override // com.tencent.luggage.wxa.q.g
        public com.tencent.luggage.wxa.q.d[] a() {
            return new com.tencent.luggage.wxa.q.d[]{new a()};
        }
    }

    public a() {
        this(0L);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(com.tencent.luggage.wxa.q.e eVar) {
        com.tencent.luggage.wxa.n0.l lVar = new com.tencent.luggage.wxa.n0.l(10);
        int i3 = 0;
        while (true) {
            eVar.b(lVar.f135088a, 0, 10);
            lVar.e(0);
            if (lVar.t() != f143733f) {
                break;
            }
            lVar.f(3);
            int p16 = lVar.p();
            i3 += p16 + 10;
            eVar.a(p16);
        }
        eVar.a();
        eVar.a(i3);
        int i16 = 0;
        int i17 = i3;
        while (true) {
            eVar.b(lVar.f135088a, 0, 5);
            lVar.e(0);
            if (lVar.w() != 2935) {
                eVar.a();
                i17++;
                if (i17 - i3 >= 8192) {
                    return false;
                }
                eVar.a(i17);
                i16 = 0;
            } else {
                i16++;
                if (i16 >= 4) {
                    return true;
                }
                int a16 = com.tencent.luggage.wxa.n.a.a(lVar.f135088a);
                if (a16 == -1) {
                    return false;
                }
                eVar.a(a16 - 5);
            }
        }
    }

    public a(long j3) {
        this.f143734a = j3;
        this.f143735b = new b();
        this.f143736c = new com.tencent.luggage.wxa.n0.l(2786);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(com.tencent.luggage.wxa.q.f fVar) {
        this.f143735b.a(fVar, new v.d(0, 1));
        fVar.e();
        fVar.a(new k.a(-9223372036854775807L));
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.f143737d = false;
        this.f143735b.a();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(com.tencent.luggage.wxa.q.e eVar, com.tencent.luggage.wxa.q.j jVar) {
        int read = eVar.read(this.f143736c.f135088a, 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.f143736c.e(0);
        this.f143736c.d(read);
        if (!this.f143737d) {
            this.f143735b.a(this.f143734a, true);
            this.f143737d = true;
        }
        this.f143735b.a(this.f143736c);
        return 0;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }
}

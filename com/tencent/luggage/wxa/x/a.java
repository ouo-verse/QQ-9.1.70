package com.tencent.luggage.wxa.x;

import com.tencent.luggage.wxa.m.o;
import com.tencent.luggage.wxa.q.d;
import com.tencent.luggage.wxa.q.e;
import com.tencent.luggage.wxa.q.f;
import com.tencent.luggage.wxa.q.g;
import com.tencent.luggage.wxa.q.j;
import com.tencent.luggage.wxa.q.k;
import com.tencent.luggage.wxa.q.l;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a implements d, k {

    /* renamed from: f, reason: collision with root package name */
    public static final g f144426f = new C6893a();

    /* renamed from: a, reason: collision with root package name */
    public f f144427a;

    /* renamed from: b, reason: collision with root package name */
    public l f144428b;

    /* renamed from: c, reason: collision with root package name */
    public b f144429c;

    /* renamed from: d, reason: collision with root package name */
    public int f144430d;

    /* renamed from: e, reason: collision with root package name */
    public int f144431e;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.x.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C6893a implements g {
        @Override // com.tencent.luggage.wxa.q.g
        public d[] a() {
            return new d[]{new a()};
        }
    }

    @Override // com.tencent.luggage.wxa.q.k
    public boolean a() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long c() {
        return this.f144429c.c();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public boolean a(e eVar) {
        return c.a(eVar) != null;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(f fVar) {
        this.f144427a = fVar;
        this.f144428b = fVar.a(0, 1);
        this.f144429c = null;
        fVar.e();
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void a(long j3, long j16) {
        this.f144431e = 0;
    }

    @Override // com.tencent.luggage.wxa.q.d
    public int a(e eVar, j jVar) {
        if (this.f144429c == null) {
            b a16 = c.a(eVar);
            this.f144429c = a16;
            if (a16 != null) {
                this.f144428b.a(com.tencent.luggage.wxa.m.j.a((String) null, "audio/raw", (String) null, a16.a(), 32768, this.f144429c.e(), this.f144429c.f(), this.f144429c.d(), (List) null, (com.tencent.luggage.wxa.p.a) null, 0, (String) null));
                this.f144430d = this.f144429c.b();
            } else {
                throw new o("Unsupported or unrecognized wav header.");
            }
        }
        if (!this.f144429c.g()) {
            c.a(eVar, this.f144429c);
            this.f144427a.a(this);
        }
        int a17 = this.f144428b.a(eVar, 32768 - this.f144431e, true);
        if (a17 != -1) {
            this.f144431e += a17;
        }
        int i3 = this.f144431e / this.f144430d;
        if (i3 > 0) {
            long b16 = this.f144429c.b(eVar.getPosition() - this.f144431e);
            int i16 = i3 * this.f144430d;
            int i17 = this.f144431e - i16;
            this.f144431e = i17;
            this.f144428b.a(b16, 1, i16, i17, null);
        }
        return a17 == -1 ? -1 : 0;
    }

    @Override // com.tencent.luggage.wxa.q.k
    public long a(long j3) {
        return this.f144429c.a(j3);
    }

    @Override // com.tencent.luggage.wxa.q.d
    public void release() {
    }
}

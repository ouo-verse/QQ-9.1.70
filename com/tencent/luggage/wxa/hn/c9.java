package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public long f127404d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f127405e;

    @Override // com.tencent.luggage.wxa.fn.b
    public byte[] b() {
        d();
        return super.b();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public Object c() {
        return Long.valueOf(f());
    }

    public final int e() {
        return 0;
    }

    public long f() {
        return this.f127404d;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public c9 d() {
        if (this.f127405e) {
            return this;
        }
        throw new com.tencent.luggage.wxa.gr.b("Not all required fields were included (false = not included in message),  llVal:" + this.f127405e);
    }

    public String toString() {
        return (("" + getClass().getName() + "(") + "llVal = " + this.f127404d + "   ") + ")";
    }

    public c9 a(long j3) {
        this.f127404d = j3;
        this.f127405e = true;
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public c9 a(byte[] bArr) {
        com.tencent.luggage.wxa.hr.a aVar = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
        for (int a16 = com.tencent.luggage.wxa.fn.b.a(aVar); a16 > 0; a16 = com.tencent.luggage.wxa.fn.b.a(aVar)) {
            if (!a(aVar, this, a16)) {
                aVar.b();
            }
        }
        return d();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public int a() {
        return com.tencent.luggage.wxa.gr.a.a(1, this.f127404d) + 0 + e();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public void a(com.tencent.luggage.wxa.mr.a aVar) {
        aVar.a(1, this.f127404d);
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public boolean a(com.tencent.luggage.wxa.hr.a aVar, com.tencent.luggage.wxa.fn.b bVar, int i3) {
        c9 c9Var = (c9) bVar;
        if (i3 != 1) {
            return false;
        }
        c9Var.a(aVar.g(i3));
        return true;
    }
}

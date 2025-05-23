package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z8 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public float f129142d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f129143e;

    @Override // com.tencent.luggage.wxa.fn.b
    public byte[] b() {
        d();
        return super.b();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public Object c() {
        return Float.valueOf(f());
    }

    public final int e() {
        return 0;
    }

    public float f() {
        return this.f129142d;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public z8 d() {
        if (this.f129143e) {
            return this;
        }
        throw new com.tencent.luggage.wxa.gr.b("Not all required fields were included (false = not included in message),  fVal:" + this.f129143e);
    }

    public String toString() {
        return (("" + getClass().getName() + "(") + "fVal = " + this.f129142d + "   ") + ")";
    }

    public z8 a(float f16) {
        this.f129142d = f16;
        this.f129143e = true;
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public z8 a(byte[] bArr) {
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
        return com.tencent.luggage.wxa.gr.a.a(1, this.f129142d) + 0 + e();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public void a(com.tencent.luggage.wxa.mr.a aVar) {
        aVar.a(1, this.f129142d);
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public boolean a(com.tencent.luggage.wxa.hr.a aVar, com.tencent.luggage.wxa.fn.b bVar, int i3) {
        z8 z8Var = (z8) bVar;
        if (i3 != 1) {
            return false;
        }
        z8Var.a(aVar.d(i3));
        return true;
    }
}

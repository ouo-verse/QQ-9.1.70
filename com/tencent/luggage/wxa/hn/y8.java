package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class y8 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public double f129085d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f129086e;

    @Override // com.tencent.luggage.wxa.fn.b
    public byte[] b() {
        d();
        return super.b();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public Object c() {
        return Double.valueOf(f());
    }

    public final int e() {
        return 0;
    }

    public double f() {
        return this.f129085d;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public y8 d() {
        if (this.f129086e) {
            return this;
        }
        throw new com.tencent.luggage.wxa.gr.b("Not all required fields were included (false = not included in message),  dVal:" + this.f129086e);
    }

    public String toString() {
        return (("" + getClass().getName() + "(") + "dVal = " + this.f129085d + "   ") + ")";
    }

    public y8 a(double d16) {
        this.f129085d = d16;
        this.f129086e = true;
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public y8 a(byte[] bArr) {
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
        return com.tencent.luggage.wxa.gr.a.a(1, this.f129085d) + 0 + e();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public void a(com.tencent.luggage.wxa.mr.a aVar) {
        aVar.a(1, this.f129085d);
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public boolean a(com.tencent.luggage.wxa.hr.a aVar, com.tencent.luggage.wxa.fn.b bVar, int i3) {
        y8 y8Var = (y8) bVar;
        if (i3 != 1) {
            return false;
        }
        y8Var.a(aVar.c(i3));
        return true;
    }
}

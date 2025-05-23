package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127349d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f127350e;

    @Override // com.tencent.luggage.wxa.fn.b
    public byte[] b() {
        d();
        return super.b();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public Object c() {
        return Integer.valueOf(f());
    }

    public final int e() {
        return 0;
    }

    public int f() {
        return this.f127349d;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b9 d() {
        if (this.f127350e) {
            return this;
        }
        throw new com.tencent.luggage.wxa.gr.b("Not all required fields were included (false = not included in message),  iVal:" + this.f127350e);
    }

    public String toString() {
        return (("" + getClass().getName() + "(") + "iVal = " + this.f127349d + "   ") + ")";
    }

    public b9 a(int i3) {
        this.f127349d = i3;
        this.f127350e = true;
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public b9 a(byte[] bArr) {
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
        return com.tencent.luggage.wxa.gr.a.a(1, this.f127349d) + 0 + e();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public void a(com.tencent.luggage.wxa.mr.a aVar) {
        aVar.a(1, this.f127349d);
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public boolean a(com.tencent.luggage.wxa.hr.a aVar, com.tencent.luggage.wxa.fn.b bVar, int i3) {
        b9 b9Var = (b9) bVar;
        if (i3 != 1) {
            return false;
        }
        b9Var.a(aVar.e(i3));
        return true;
    }
}

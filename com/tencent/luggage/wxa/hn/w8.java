package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class w8 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128961d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f128962e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128963f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f128964g;

    @Override // com.tencent.luggage.wxa.fn.b
    public byte[] b() {
        d();
        return super.b();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public Object c() {
        return "";
    }

    public final int e() {
        return 0;
    }

    public byte[] f() {
        return this.f128963f.a();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public w8 d() {
        if (this.f128962e) {
            return this;
        }
        throw new com.tencent.luggage.wxa.gr.b("Not all required fields were included (false = not included in message),  iLen:" + this.f128962e);
    }

    public String toString() {
        String str = ("" + getClass().getName() + "(") + "iLen = " + this.f128961d + "   ";
        if (this.f128964g) {
            str = str + "Buffer = " + this.f128963f + "   ";
        }
        return str + ")";
    }

    public final w8 a(int i3) {
        this.f128961d = i3;
        this.f128962e = true;
        return this;
    }

    public w8 c(byte[] bArr) {
        com.tencent.luggage.wxa.fn.c a16 = com.tencent.luggage.wxa.fn.c.a(bArr);
        a(a16);
        a(a16.b());
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public w8 a(byte[] bArr) {
        com.tencent.luggage.wxa.hr.a aVar = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
        for (int a16 = com.tencent.luggage.wxa.fn.b.a(aVar); a16 > 0; a16 = com.tencent.luggage.wxa.fn.b.a(aVar)) {
            if (!a(aVar, this, a16)) {
                aVar.b();
            }
        }
        return d();
    }

    public w8 a(com.tencent.luggage.wxa.fn.c cVar) {
        if (cVar == null) {
            c(null);
        }
        this.f128963f = cVar;
        this.f128964g = true;
        a(cVar.b());
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public int a() {
        int a16 = com.tencent.luggage.wxa.gr.a.a(1, this.f128961d) + 0;
        if (this.f128964g) {
            a16 += com.tencent.luggage.wxa.gr.a.a(2, this.f128963f);
        }
        return a16 + e();
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public void a(com.tencent.luggage.wxa.mr.a aVar) {
        aVar.a(1, this.f128961d);
        if (this.f128964g) {
            aVar.a(2, this.f128963f);
        }
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public final boolean a(com.tencent.luggage.wxa.hr.a aVar, com.tencent.luggage.wxa.fn.b bVar, int i3) {
        w8 w8Var = (w8) bVar;
        if (i3 == 1) {
            w8Var.a(aVar.e(i3));
            return true;
        }
        if (i3 != 2) {
            return false;
        }
        w8Var.a(aVar.b(i3));
        return true;
    }
}

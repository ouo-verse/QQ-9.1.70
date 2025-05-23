package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128510d;

    /* renamed from: e, reason: collision with root package name */
    public String f128511e;

    /* renamed from: f, reason: collision with root package name */
    public int f128512f;

    /* renamed from: g, reason: collision with root package name */
    public int f128513g;

    /* renamed from: h, reason: collision with root package name */
    public int f128514h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128510d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128511e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f128512f);
            aVar.b(4, this.f128513g);
            aVar.b(5, this.f128514h);
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f128510d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            String str4 = this.f128511e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128512f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128513g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128514h);
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a16 = com.tencent.luggage.wxa.fn.b.a(aVar2); a16 > 0; a16 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a16)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        q9 q9Var = (q9) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        q9Var.f128514h = aVar3.f(intValue);
                        return 0;
                    }
                    q9Var.f128513g = aVar3.f(intValue);
                    return 0;
                }
                q9Var.f128512f = aVar3.f(intValue);
                return 0;
            }
            q9Var.f128511e = aVar3.i(intValue);
            return 0;
        }
        q9Var.f128510d = aVar3.i(intValue);
        return 0;
    }
}

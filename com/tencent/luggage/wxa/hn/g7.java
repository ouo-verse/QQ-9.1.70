package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g7 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127677d;

    /* renamed from: e, reason: collision with root package name */
    public String f127678e;

    /* renamed from: f, reason: collision with root package name */
    public int f127679f;

    /* renamed from: g, reason: collision with root package name */
    public String f127680g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127677d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f127678e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f127679f);
            String str3 = this.f127680g;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f127677d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            String str5 = this.f127678e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f127679f);
            String str6 = this.f127680g;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(5, str6);
            }
            return b16;
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
        g7 g7Var = (g7) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 5) {
                        return -1;
                    }
                    g7Var.f127680g = aVar3.i(intValue);
                    return 0;
                }
                g7Var.f127679f = aVar3.f(intValue);
                return 0;
            }
            g7Var.f127678e = aVar3.i(intValue);
            return 0;
        }
        g7Var.f127677d = aVar3.i(intValue);
        return 0;
    }
}

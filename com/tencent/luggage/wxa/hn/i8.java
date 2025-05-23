package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i8 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127872d;

    /* renamed from: e, reason: collision with root package name */
    public int f127873e;

    /* renamed from: f, reason: collision with root package name */
    public String f127874f;

    /* renamed from: g, reason: collision with root package name */
    public String f127875g;

    /* renamed from: h, reason: collision with root package name */
    public int f127876h;

    /* renamed from: i, reason: collision with root package name */
    public int f127877i;

    /* renamed from: j, reason: collision with root package name */
    public String f127878j;

    /* renamed from: k, reason: collision with root package name */
    public String f127879k;

    /* renamed from: l, reason: collision with root package name */
    public String f127880l;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127872d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127873e);
            String str2 = this.f127874f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127875g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f127876h);
            aVar.b(6, this.f127877i);
            String str4 = this.f127878j;
            if (str4 != null) {
                aVar.a(7, str4);
            }
            String str5 = this.f127879k;
            if (str5 != null) {
                aVar.a(8, str5);
            }
            String str6 = this.f127880l;
            if (str6 != null) {
                aVar.a(9, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            String str7 = this.f127872d;
            if (str7 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str7);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127873e);
            String str8 = this.f127874f;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str8);
            }
            String str9 = this.f127875g;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str9);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127876h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127877i);
            String str10 = this.f127878j;
            if (str10 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(7, str10);
            }
            String str11 = this.f127879k;
            if (str11 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(8, str11);
            }
            String str12 = this.f127880l;
            if (str12 != null) {
                return b17 + com.tencent.luggage.wxa.gr.a.a(9, str12);
            }
            return b17;
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
        i8 i8Var = (i8) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                i8Var.f127872d = aVar3.i(intValue);
                return 0;
            case 2:
                i8Var.f127873e = aVar3.f(intValue);
                return 0;
            case 3:
                i8Var.f127874f = aVar3.i(intValue);
                return 0;
            case 4:
                i8Var.f127875g = aVar3.i(intValue);
                return 0;
            case 5:
                i8Var.f127876h = aVar3.f(intValue);
                return 0;
            case 6:
                i8Var.f127877i = aVar3.f(intValue);
                return 0;
            case 7:
                i8Var.f127878j = aVar3.i(intValue);
                return 0;
            case 8:
                i8Var.f127879k = aVar3.i(intValue);
                return 0;
            case 9:
                i8Var.f127880l = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128168d;

    /* renamed from: e, reason: collision with root package name */
    public String f128169e;

    /* renamed from: f, reason: collision with root package name */
    public int f128170f;

    /* renamed from: g, reason: collision with root package name */
    public String f128171g;

    /* renamed from: h, reason: collision with root package name */
    public String f128172h;

    /* renamed from: i, reason: collision with root package name */
    public String f128173i;

    /* renamed from: j, reason: collision with root package name */
    public String f128174j;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128168d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128169e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f128170f);
            String str3 = this.f128171g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f128172h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            String str5 = this.f128173i;
            if (str5 != null) {
                aVar.a(6, str5);
            }
            String str6 = this.f128174j;
            if (str6 != null) {
                aVar.a(7, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            String str7 = this.f128168d;
            if (str7 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str7);
            }
            String str8 = this.f128169e;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str8);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128170f);
            String str9 = this.f128171g;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str9);
            }
            String str10 = this.f128172h;
            if (str10 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str10);
            }
            String str11 = this.f128173i;
            if (str11 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str11);
            }
            String str12 = this.f128174j;
            if (str12 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(7, str12);
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
        m9 m9Var = (m9) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                m9Var.f128168d = aVar3.i(intValue);
                return 0;
            case 2:
                m9Var.f128169e = aVar3.i(intValue);
                return 0;
            case 3:
                m9Var.f128170f = aVar3.f(intValue);
                return 0;
            case 4:
                m9Var.f128171g = aVar3.i(intValue);
                return 0;
            case 5:
                m9Var.f128172h = aVar3.i(intValue);
                return 0;
            case 6:
                m9Var.f128173i = aVar3.i(intValue);
                return 0;
            case 7:
                m9Var.f128174j = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

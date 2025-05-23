package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x4 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f129001d;

    /* renamed from: e, reason: collision with root package name */
    public String f129002e;

    /* renamed from: f, reason: collision with root package name */
    public String f129003f;

    /* renamed from: g, reason: collision with root package name */
    public String f129004g;

    /* renamed from: h, reason: collision with root package name */
    public String f129005h;

    /* renamed from: i, reason: collision with root package name */
    public String f129006i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f129001d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f129002e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f129003f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f129004g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            String str5 = this.f129005h;
            if (str5 != null) {
                aVar.a(5, str5);
            }
            String str6 = this.f129006i;
            if (str6 != null) {
                aVar.a(6, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            String str7 = this.f129001d;
            if (str7 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str7);
            }
            String str8 = this.f129002e;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str8);
            }
            String str9 = this.f129003f;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            String str10 = this.f129004g;
            if (str10 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str10);
            }
            String str11 = this.f129005h;
            if (str11 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str11);
            }
            String str12 = this.f129006i;
            if (str12 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(6, str12);
            }
            return i16;
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
        x4 x4Var = (x4) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                x4Var.f129001d = aVar3.i(intValue);
                return 0;
            case 2:
                x4Var.f129002e = aVar3.i(intValue);
                return 0;
            case 3:
                x4Var.f129003f = aVar3.i(intValue);
                return 0;
            case 4:
                x4Var.f129004g = aVar3.i(intValue);
                return 0;
            case 5:
                x4Var.f129005h = aVar3.i(intValue);
                return 0;
            case 6:
                x4Var.f129006i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

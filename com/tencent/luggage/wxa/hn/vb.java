package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class vb extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128902d;

    /* renamed from: e, reason: collision with root package name */
    public String f128903e;

    /* renamed from: f, reason: collision with root package name */
    public String f128904f;

    /* renamed from: g, reason: collision with root package name */
    public String f128905g;

    /* renamed from: h, reason: collision with root package name */
    public String f128906h;

    /* renamed from: i, reason: collision with root package name */
    public String f128907i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128902d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128903e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128904f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f128905g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            String str5 = this.f128906h;
            if (str5 != null) {
                aVar.a(5, str5);
            }
            String str6 = this.f128907i;
            if (str6 != null) {
                aVar.a(6, str6);
            }
            return 0;
        }
        if (i3 == 1) {
            String str7 = this.f128902d;
            if (str7 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str7);
            }
            String str8 = this.f128903e;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str8);
            }
            String str9 = this.f128904f;
            if (str9 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str9);
            }
            String str10 = this.f128905g;
            if (str10 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str10);
            }
            String str11 = this.f128906h;
            if (str11 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str11);
            }
            String str12 = this.f128907i;
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
        vb vbVar = (vb) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                vbVar.f128902d = aVar3.i(intValue);
                return 0;
            case 2:
                vbVar.f128903e = aVar3.i(intValue);
                return 0;
            case 3:
                vbVar.f128904f = aVar3.i(intValue);
                return 0;
            case 4:
                vbVar.f128905g = aVar3.i(intValue);
                return 0;
            case 5:
                vbVar.f128906h = aVar3.i(intValue);
                return 0;
            case 6:
                vbVar.f128907i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

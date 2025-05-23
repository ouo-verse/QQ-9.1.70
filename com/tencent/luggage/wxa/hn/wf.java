package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class wf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128973d;

    /* renamed from: e, reason: collision with root package name */
    public int f128974e;

    /* renamed from: f, reason: collision with root package name */
    public String f128975f;

    /* renamed from: g, reason: collision with root package name */
    public String f128976g;

    /* renamed from: h, reason: collision with root package name */
    public String f128977h;

    /* renamed from: i, reason: collision with root package name */
    public String f128978i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128973d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f128974e);
            String str2 = this.f128975f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128976g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f128977h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            String str5 = this.f128978i;
            if (str5 != null) {
                aVar.a(6, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            String str6 = this.f128973d;
            if (str6 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str6);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128974e);
            String str7 = this.f128975f;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            String str8 = this.f128976g;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            String str9 = this.f128977h;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str9);
            }
            String str10 = this.f128978i;
            if (str10 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(6, str10);
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
        wf wfVar = (wf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                wfVar.f128973d = aVar3.i(intValue);
                return 0;
            case 2:
                wfVar.f128974e = aVar3.f(intValue);
                return 0;
            case 3:
                wfVar.f128975f = aVar3.i(intValue);
                return 0;
            case 4:
                wfVar.f128976g = aVar3.i(intValue);
                return 0;
            case 5:
                wfVar.f128977h = aVar3.i(intValue);
                return 0;
            case 6:
                wfVar.f128978i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

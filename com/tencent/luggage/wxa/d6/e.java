package com.tencent.luggage.wxa.d6;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f124113d;

    /* renamed from: e, reason: collision with root package name */
    public int f124114e;

    /* renamed from: f, reason: collision with root package name */
    public int f124115f;

    /* renamed from: g, reason: collision with root package name */
    public String f124116g;

    /* renamed from: h, reason: collision with root package name */
    public String f124117h;

    /* renamed from: i, reason: collision with root package name */
    public int f124118i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f124113d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f124114e);
            aVar.b(3, this.f124115f);
            String str2 = this.f124116g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f124117h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            aVar.b(6, this.f124118i);
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f124113d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f124114e) + com.tencent.luggage.wxa.gr.a.b(3, this.f124115f);
            String str5 = this.f124116g;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str5);
            }
            String str6 = this.f124117h;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str6);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(6, this.f124118i);
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
        e eVar = (e) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                eVar.f124113d = aVar3.i(intValue);
                return 0;
            case 2:
                eVar.f124114e = aVar3.f(intValue);
                return 0;
            case 3:
                eVar.f124115f = aVar3.f(intValue);
                return 0;
            case 4:
                eVar.f124116g = aVar3.i(intValue);
                return 0;
            case 5:
                eVar.f124117h = aVar3.i(intValue);
                return 0;
            case 6:
                eVar.f124118i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

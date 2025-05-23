package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class af extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127302d;

    /* renamed from: e, reason: collision with root package name */
    public int f127303e;

    /* renamed from: f, reason: collision with root package name */
    public int f127304f;

    /* renamed from: g, reason: collision with root package name */
    public String f127305g;

    /* renamed from: h, reason: collision with root package name */
    public String f127306h;

    /* renamed from: i, reason: collision with root package name */
    public String f127307i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127302d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127303e);
            aVar.b(3, this.f127304f);
            String str2 = this.f127305g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127306h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127307i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            String str5 = this.f127302d;
            if (str5 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str5);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127303e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127304f);
            String str6 = this.f127305g;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            String str7 = this.f127306h;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str7);
            }
            String str8 = this.f127307i;
            if (str8 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(6, str8);
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
        af afVar = (af) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                afVar.f127302d = aVar3.i(intValue);
                return 0;
            case 2:
                afVar.f127303e = aVar3.f(intValue);
                return 0;
            case 3:
                afVar.f127304f = aVar3.f(intValue);
                return 0;
            case 4:
                afVar.f127305g = aVar3.i(intValue);
                return 0;
            case 5:
                afVar.f127306h = aVar3.i(intValue);
                return 0;
            case 6:
                afVar.f127307i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

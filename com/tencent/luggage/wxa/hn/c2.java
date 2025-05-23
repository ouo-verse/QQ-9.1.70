package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c2 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127376d;

    /* renamed from: e, reason: collision with root package name */
    public int f127377e;

    /* renamed from: f, reason: collision with root package name */
    public int f127378f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127379g;

    /* renamed from: h, reason: collision with root package name */
    public String f127380h;

    /* renamed from: i, reason: collision with root package name */
    public String f127381i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127376d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127377e);
            aVar.b(3, this.f127378f);
            com.tencent.luggage.wxa.fn.c cVar = this.f127379g;
            if (cVar != null) {
                aVar.a(4, cVar);
            }
            String str2 = this.f127380h;
            if (str2 != null) {
                aVar.a(5, str2);
            }
            String str3 = this.f127381i;
            if (str3 != null) {
                aVar.a(6, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f127376d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127377e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127378f);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127379g;
            if (cVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, cVar2);
            }
            String str5 = this.f127380h;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str5);
            }
            String str6 = this.f127381i;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(6, str6);
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
        c2 c2Var = (c2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                c2Var.f127376d = aVar3.i(intValue);
                return 0;
            case 2:
                c2Var.f127377e = aVar3.f(intValue);
                return 0;
            case 3:
                c2Var.f127378f = aVar3.f(intValue);
                return 0;
            case 4:
                c2Var.f127379g = aVar3.b(intValue);
                return 0;
            case 5:
                c2Var.f127380h = aVar3.i(intValue);
                return 0;
            case 6:
                c2Var.f127381i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

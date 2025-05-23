package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z6 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f129129d;

    /* renamed from: e, reason: collision with root package name */
    public String f129130e;

    /* renamed from: f, reason: collision with root package name */
    public String f129131f;

    /* renamed from: g, reason: collision with root package name */
    public String f129132g;

    /* renamed from: h, reason: collision with root package name */
    public int f129133h;

    /* renamed from: i, reason: collision with root package name */
    public int f129134i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f129129d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f129130e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f129131f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            String str4 = this.f129132g;
            if (str4 != null) {
                aVar.a(4, str4);
            }
            aVar.b(5, this.f129133h);
            aVar.b(6, this.f129134i);
            return 0;
        }
        if (i3 == 1) {
            String str5 = this.f129129d;
            if (str5 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str5);
            }
            String str6 = this.f129130e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            String str7 = this.f129131f;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            String str8 = this.f129132g;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f129133h) + com.tencent.luggage.wxa.gr.a.b(6, this.f129134i);
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
        z6 z6Var = (z6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                z6Var.f129129d = aVar3.i(intValue);
                return 0;
            case 2:
                z6Var.f129130e = aVar3.i(intValue);
                return 0;
            case 3:
                z6Var.f129131f = aVar3.i(intValue);
                return 0;
            case 4:
                z6Var.f129132g = aVar3.i(intValue);
                return 0;
            case 5:
                z6Var.f129133h = aVar3.f(intValue);
                return 0;
            case 6:
                z6Var.f129134i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

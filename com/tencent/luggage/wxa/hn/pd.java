package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class pd extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128434d;

    /* renamed from: e, reason: collision with root package name */
    public String f128435e;

    /* renamed from: f, reason: collision with root package name */
    public String f128436f;

    /* renamed from: g, reason: collision with root package name */
    public String f128437g;

    /* renamed from: h, reason: collision with root package name */
    public int f128438h;

    /* renamed from: i, reason: collision with root package name */
    public z1 f128439i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128434d);
            String str = this.f128435e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128436f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128437g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f128438h);
            z1 z1Var = this.f128439i;
            if (z1Var != null) {
                aVar.c(6, z1Var.a());
                this.f128439i.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128434d) + 0;
            String str4 = this.f128435e;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f128436f;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f128437g;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128438h);
            z1 z1Var2 = this.f128439i;
            if (z1Var2 != null) {
                return b17 + com.tencent.luggage.wxa.gr.a.c(6, z1Var2.a());
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
        pd pdVar = (pd) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                pdVar.f128434d = aVar3.f(intValue);
                return 0;
            case 2:
                pdVar.f128435e = aVar3.i(intValue);
                return 0;
            case 3:
                pdVar.f128436f = aVar3.i(intValue);
                return 0;
            case 4:
                pdVar.f128437g = aVar3.i(intValue);
                return 0;
            case 5:
                pdVar.f128438h = aVar3.f(intValue);
                return 0;
            case 6:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr = (byte[]) h16.get(i16);
                    z1 z1Var3 = new z1();
                    if (bArr != null && bArr.length > 0) {
                        z1Var3.a(bArr);
                    }
                    pdVar.f128439i = z1Var3;
                }
                return 0;
            default:
                return -1;
        }
    }
}

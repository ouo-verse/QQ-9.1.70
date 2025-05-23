package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h1 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public int f127733e;

    /* renamed from: f, reason: collision with root package name */
    public String f127734f;

    /* renamed from: g, reason: collision with root package name */
    public String f127735g;

    /* renamed from: h, reason: collision with root package name */
    public String f127736h;

    /* renamed from: i, reason: collision with root package name */
    public String f127737i;

    /* renamed from: j, reason: collision with root package name */
    public String f127738j;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            h0 h0Var = this.f128743d;
            if (h0Var != null) {
                aVar.c(1, h0Var.a());
                this.f128743d.a(aVar);
            }
            aVar.b(2, this.f127733e);
            String str = this.f127734f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f127735g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127736h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127737i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f127738j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127733e);
            String str6 = this.f127734f;
            if (str6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            String str7 = this.f127735g;
            if (str7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            String str8 = this.f127736h;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            String str9 = this.f127737i;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str9);
            }
            String str10 = this.f127738j;
            if (str10 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(7, str10);
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
        h1 h1Var = (h1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr != null && bArr.length > 0) {
                        h0Var3.a(bArr);
                    }
                    h1Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                h1Var.f127733e = aVar3.f(intValue);
                return 0;
            case 3:
                h1Var.f127734f = aVar3.i(intValue);
                return 0;
            case 4:
                h1Var.f127735g = aVar3.i(intValue);
                return 0;
            case 5:
                h1Var.f127736h = aVar3.i(intValue);
                return 0;
            case 6:
                h1Var.f127737i = aVar3.i(intValue);
                return 0;
            case 7:
                h1Var.f127738j = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

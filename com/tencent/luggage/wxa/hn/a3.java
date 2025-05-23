package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a3 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127259e;

    /* renamed from: f, reason: collision with root package name */
    public String f127260f;

    /* renamed from: g, reason: collision with root package name */
    public int f127261g;

    /* renamed from: h, reason: collision with root package name */
    public String f127262h;

    /* renamed from: i, reason: collision with root package name */
    public String f127263i;

    /* renamed from: j, reason: collision with root package name */
    public String f127264j;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            g0 g0Var = this.f128671d;
            if (g0Var != null) {
                aVar.c(1, g0Var.a());
                this.f128671d.a(aVar);
            }
            String str = this.f127259e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127260f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f127261g);
            String str3 = this.f127262h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127263i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            String str5 = this.f127264j;
            if (str5 != null) {
                aVar.a(7, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str6 = this.f127259e;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str6);
            }
            String str7 = this.f127260f;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str7);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127261g);
            String str8 = this.f127262h;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            String str9 = this.f127263i;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str9);
            }
            String str10 = this.f127264j;
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
        a3 a3Var = (a3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    g0 g0Var3 = new g0();
                    if (bArr != null && bArr.length > 0) {
                        g0Var3.a(bArr);
                    }
                    a3Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                a3Var.f127259e = aVar3.i(intValue);
                return 0;
            case 3:
                a3Var.f127260f = aVar3.i(intValue);
                return 0;
            case 4:
                a3Var.f127261g = aVar3.f(intValue);
                return 0;
            case 5:
                a3Var.f127262h = aVar3.i(intValue);
                return 0;
            case 6:
                a3Var.f127263i = aVar3.i(intValue);
                return 0;
            case 7:
                a3Var.f127264j = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

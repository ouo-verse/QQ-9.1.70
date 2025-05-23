package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v1 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128857e;

    /* renamed from: f, reason: collision with root package name */
    public String f128858f;

    /* renamed from: g, reason: collision with root package name */
    public String f128859g;

    /* renamed from: h, reason: collision with root package name */
    public int f128860h;

    /* renamed from: i, reason: collision with root package name */
    public String f128861i;

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
            String str = this.f128857e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128858f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f128859g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f128860h);
            String str4 = this.f128861i;
            if (str4 != null) {
                aVar.a(6, str4);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str5 = this.f128857e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f128858f;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            String str7 = this.f128859g;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f128860h);
            String str8 = this.f128861i;
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
        v1 v1Var = (v1) objArr[1];
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
                    v1Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                v1Var.f128857e = aVar3.i(intValue);
                return 0;
            case 3:
                v1Var.f128858f = aVar3.i(intValue);
                return 0;
            case 4:
                v1Var.f128859g = aVar3.i(intValue);
                return 0;
            case 5:
                v1Var.f128860h = aVar3.f(intValue);
                return 0;
            case 6:
                v1Var.f128861i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

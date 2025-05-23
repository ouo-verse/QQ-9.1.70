package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i3 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127844e;

    /* renamed from: f, reason: collision with root package name */
    public String f127845f;

    /* renamed from: g, reason: collision with root package name */
    public String f127846g;

    /* renamed from: h, reason: collision with root package name */
    public int f127847h;

    /* renamed from: i, reason: collision with root package name */
    public int f127848i;

    /* renamed from: j, reason: collision with root package name */
    public int f127849j = 4;

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
            String str = this.f127844e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127845f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127846g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f127847h);
            aVar.b(6, this.f127848i);
            aVar.b(7, this.f127849j);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str4 = this.f127844e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127845f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f127846g;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127847h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127848i) + com.tencent.luggage.wxa.gr.a.b(7, this.f127849j);
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
        i3 i3Var = (i3) objArr[1];
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
                    i3Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                i3Var.f127844e = aVar3.i(intValue);
                return 0;
            case 3:
                i3Var.f127845f = aVar3.i(intValue);
                return 0;
            case 4:
                i3Var.f127846g = aVar3.i(intValue);
                return 0;
            case 5:
                i3Var.f127847h = aVar3.f(intValue);
                return 0;
            case 6:
                i3Var.f127848i = aVar3.f(intValue);
                return 0;
            case 7:
                i3Var.f127849j = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

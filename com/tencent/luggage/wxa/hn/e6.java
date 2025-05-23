package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e6 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127549e;

    /* renamed from: f, reason: collision with root package name */
    public String f127550f;

    /* renamed from: g, reason: collision with root package name */
    public String f127551g;

    /* renamed from: h, reason: collision with root package name */
    public String f127552h;

    /* renamed from: i, reason: collision with root package name */
    public int f127553i;

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
            String str = this.f127549e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127550f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127551g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f127552h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            aVar.b(6, this.f127553i);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str5 = this.f127549e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f127550f;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            String str7 = this.f127551g;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str7);
            }
            String str8 = this.f127552h;
            if (str8 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str8);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(6, this.f127553i);
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
        e6 e6Var = (e6) objArr[1];
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
                    e6Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                e6Var.f127549e = aVar3.i(intValue);
                return 0;
            case 3:
                e6Var.f127550f = aVar3.i(intValue);
                return 0;
            case 4:
                e6Var.f127551g = aVar3.i(intValue);
                return 0;
            case 5:
                e6Var.f127552h = aVar3.i(intValue);
                return 0;
            case 6:
                e6Var.f127553i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

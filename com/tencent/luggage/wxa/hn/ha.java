package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ha extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127790e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127791f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public String f127792g;

    /* renamed from: h, reason: collision with root package name */
    public String f127793h;

    /* renamed from: i, reason: collision with root package name */
    public String f127794i;

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
            String str = this.f127790e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.a(3, 2, this.f127791f);
            String str2 = this.f127792g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127793h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            String str4 = this.f127794i;
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
            String str5 = this.f127790e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 2, this.f127791f);
            String str6 = this.f127792g;
            if (str6 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            String str7 = this.f127793h;
            if (str7 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(5, str7);
            }
            String str8 = this.f127794i;
            if (str8 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(6, str8);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127791f.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
            for (int a17 = com.tencent.luggage.wxa.fn.b.a(aVar2); a17 > 0; a17 = com.tencent.luggage.wxa.fn.b.a(aVar2)) {
                if (!super.a(aVar2, this, a17)) {
                    aVar2.b();
                }
            }
            return 0;
        }
        if (i3 != 3) {
            return -1;
        }
        com.tencent.luggage.wxa.hr.a aVar3 = (com.tencent.luggage.wxa.hr.a) objArr[0];
        ha haVar = (ha) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    g0 g0Var3 = new g0();
                    if (bArr2 != null && bArr2.length > 0) {
                        g0Var3.a(bArr2);
                    }
                    haVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                haVar.f127790e = aVar3.i(intValue);
                return 0;
            case 3:
                haVar.f127791f.add(Integer.valueOf(aVar3.f(intValue)));
                return 0;
            case 4:
                haVar.f127792g = aVar3.i(intValue);
                return 0;
            case 5:
                haVar.f127793h = aVar3.i(intValue);
                return 0;
            case 6:
                haVar.f127794i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

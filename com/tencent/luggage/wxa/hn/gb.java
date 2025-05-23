package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class gb extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f127703e;

    /* renamed from: f, reason: collision with root package name */
    public int f127704f;

    /* renamed from: g, reason: collision with root package name */
    public int f127705g;

    /* renamed from: h, reason: collision with root package name */
    public int f127706h;

    /* renamed from: i, reason: collision with root package name */
    public int f127707i;

    /* renamed from: j, reason: collision with root package name */
    public String f127708j;

    /* renamed from: k, reason: collision with root package name */
    public int f127709k;

    /* renamed from: l, reason: collision with root package name */
    public String f127710l;

    /* renamed from: m, reason: collision with root package name */
    public int f127711m;

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
            aVar.b(2, this.f127703e);
            aVar.b(3, this.f127704f);
            aVar.b(4, this.f127705g);
            aVar.b(5, this.f127706h);
            aVar.b(6, this.f127707i);
            String str = this.f127708j;
            if (str != null) {
                aVar.a(7, str);
            }
            aVar.b(8, this.f127709k);
            String str2 = this.f127710l;
            if (str2 != null) {
                aVar.a(9, str2);
            }
            aVar.b(11, this.f127711m);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127703e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127704f) + com.tencent.luggage.wxa.gr.a.b(4, this.f127705g) + com.tencent.luggage.wxa.gr.a.b(5, this.f127706h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127707i);
            String str3 = this.f127708j;
            if (str3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str3);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(8, this.f127709k);
            String str4 = this.f127710l;
            if (str4 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(9, str4);
            }
            return b17 + com.tencent.luggage.wxa.gr.a.b(11, this.f127711m);
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
        gb gbVar = (gb) objArr[1];
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
                    gbVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                gbVar.f127703e = aVar3.f(intValue);
                return 0;
            case 3:
                gbVar.f127704f = aVar3.f(intValue);
                return 0;
            case 4:
                gbVar.f127705g = aVar3.f(intValue);
                return 0;
            case 5:
                gbVar.f127706h = aVar3.f(intValue);
                return 0;
            case 6:
                gbVar.f127707i = aVar3.f(intValue);
                return 0;
            case 7:
                gbVar.f127708j = aVar3.i(intValue);
                return 0;
            case 8:
                gbVar.f127709k = aVar3.f(intValue);
                return 0;
            case 9:
                gbVar.f127710l = aVar3.i(intValue);
                return 0;
            case 10:
            default:
                return -1;
            case 11:
                gbVar.f127711m = aVar3.f(intValue);
                return 0;
        }
    }
}

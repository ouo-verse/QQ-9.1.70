package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r1 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128551e;

    /* renamed from: f, reason: collision with root package name */
    public String f128552f;

    /* renamed from: g, reason: collision with root package name */
    public int f128553g;

    /* renamed from: h, reason: collision with root package name */
    public int f128554h;

    /* renamed from: i, reason: collision with root package name */
    public int f128555i;

    /* renamed from: j, reason: collision with root package name */
    public int f128556j;

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
            String str = this.f128551e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f128552f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f128553g);
            aVar.b(5, this.f128554h);
            aVar.b(6, this.f128555i);
            aVar.b(7, this.f128556j);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str3 = this.f128551e;
            if (str3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            String str4 = this.f128552f;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128553g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128554h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128555i) + com.tencent.luggage.wxa.gr.a.b(7, this.f128556j);
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
        r1 r1Var = (r1) objArr[1];
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
                    r1Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                r1Var.f128551e = aVar3.i(intValue);
                return 0;
            case 3:
                r1Var.f128552f = aVar3.i(intValue);
                return 0;
            case 4:
                r1Var.f128553g = aVar3.f(intValue);
                return 0;
            case 5:
                r1Var.f128554h = aVar3.f(intValue);
                return 0;
            case 6:
                r1Var.f128555i = aVar3.f(intValue);
                return 0;
            case 7:
                r1Var.f128556j = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class kb extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public double f128019e;

    /* renamed from: f, reason: collision with root package name */
    public double f128020f;

    /* renamed from: g, reason: collision with root package name */
    public double f128021g;

    /* renamed from: h, reason: collision with root package name */
    public double f128022h;

    /* renamed from: i, reason: collision with root package name */
    public double f128023i;

    /* renamed from: j, reason: collision with root package name */
    public int f128024j;

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
            aVar.a(2, this.f128019e);
            aVar.a(3, this.f128020f);
            aVar.a(4, this.f128021g);
            aVar.a(5, this.f128022h);
            aVar.a(6, this.f128023i);
            aVar.b(7, this.f128024j);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, this.f128019e) + com.tencent.luggage.wxa.gr.a.a(3, this.f128020f) + com.tencent.luggage.wxa.gr.a.a(4, this.f128021g) + com.tencent.luggage.wxa.gr.a.a(5, this.f128022h) + com.tencent.luggage.wxa.gr.a.a(6, this.f128023i) + com.tencent.luggage.wxa.gr.a.b(7, this.f128024j);
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
        kb kbVar = (kb) objArr[1];
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
                    kbVar.f128671d = g0Var3;
                }
                return 0;
            case 2:
                kbVar.f128019e = aVar3.c(intValue);
                return 0;
            case 3:
                kbVar.f128020f = aVar3.c(intValue);
                return 0;
            case 4:
                kbVar.f128021g = aVar3.c(intValue);
                return 0;
            case 5:
                kbVar.f128022h = aVar3.c(intValue);
                return 0;
            case 6:
                kbVar.f128023i = aVar3.c(intValue);
                return 0;
            case 7:
                kbVar.f128024j = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

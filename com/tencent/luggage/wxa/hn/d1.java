package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d1 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127445e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127446f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127447g;

    /* renamed from: h, reason: collision with root package name */
    public int f127448h;

    /* renamed from: i, reason: collision with root package name */
    public int f127449i;

    /* renamed from: j, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127450j;

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
            com.tencent.luggage.wxa.fn.c cVar = this.f127445e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127446f;
            if (cVar2 != null) {
                aVar.a(3, cVar2);
            }
            com.tencent.luggage.wxa.fn.c cVar3 = this.f127447g;
            if (cVar3 != null) {
                aVar.a(4, cVar3);
            }
            aVar.b(5, this.f127448h);
            aVar.b(6, this.f127449i);
            com.tencent.luggage.wxa.fn.c cVar4 = this.f127450j;
            if (cVar4 != null) {
                aVar.a(7, cVar4);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            com.tencent.luggage.wxa.fn.c cVar5 = this.f127445e;
            if (cVar5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, cVar5);
            }
            com.tencent.luggage.wxa.fn.c cVar6 = this.f127446f;
            if (cVar6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, cVar6);
            }
            com.tencent.luggage.wxa.fn.c cVar7 = this.f127447g;
            if (cVar7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, cVar7);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127448h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127449i);
            com.tencent.luggage.wxa.fn.c cVar8 = this.f127450j;
            if (cVar8 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(7, cVar8);
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
        d1 d1Var = (d1) objArr[1];
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
                    d1Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                d1Var.f127445e = aVar3.b(intValue);
                return 0;
            case 3:
                d1Var.f127446f = aVar3.b(intValue);
                return 0;
            case 4:
                d1Var.f127447g = aVar3.b(intValue);
                return 0;
            case 5:
                d1Var.f127448h = aVar3.f(intValue);
                return 0;
            case 6:
                d1Var.f127449i = aVar3.f(intValue);
                return 0;
            case 7:
                d1Var.f127450j = aVar3.b(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

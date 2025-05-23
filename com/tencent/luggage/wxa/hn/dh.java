package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class dh extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public u1 f127516e;

    /* renamed from: f, reason: collision with root package name */
    public q4 f127517f;

    /* renamed from: g, reason: collision with root package name */
    public od f127518g;

    /* renamed from: h, reason: collision with root package name */
    public int f127519h;

    /* renamed from: i, reason: collision with root package name */
    public int f127520i;

    /* renamed from: j, reason: collision with root package name */
    public String f127521j;

    /* renamed from: k, reason: collision with root package name */
    public int f127522k;

    /* renamed from: l, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127523l;

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
            u1 u1Var = this.f127516e;
            if (u1Var != null) {
                aVar.c(2, u1Var.a());
                this.f127516e.a(aVar);
            }
            q4 q4Var = this.f127517f;
            if (q4Var != null) {
                aVar.c(3, q4Var.a());
                this.f127517f.a(aVar);
            }
            od odVar = this.f127518g;
            if (odVar != null) {
                aVar.c(4, odVar.a());
                this.f127518g.a(aVar);
            }
            aVar.b(5, this.f127519h);
            aVar.b(6, this.f127520i);
            String str = this.f127521j;
            if (str != null) {
                aVar.a(7, str);
            }
            aVar.b(8, this.f127522k);
            com.tencent.luggage.wxa.fn.c cVar = this.f127523l;
            if (cVar != null) {
                aVar.a(9, cVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            u1 u1Var2 = this.f127516e;
            if (u1Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, u1Var2.a());
            }
            q4 q4Var2 = this.f127517f;
            if (q4Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(3, q4Var2.a());
            }
            od odVar2 = this.f127518g;
            if (odVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(4, odVar2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127519h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127520i);
            String str2 = this.f127521j;
            if (str2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str2);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(8, this.f127522k);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127523l;
            if (cVar2 != null) {
                return b17 + com.tencent.luggage.wxa.gr.a.a(9, cVar2);
            }
            return b17;
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
        dh dhVar = (dh) objArr[1];
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
                    dhVar.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    u1 u1Var3 = new u1();
                    if (bArr2 != null && bArr2.length > 0) {
                        u1Var3.a(bArr2);
                    }
                    dhVar.f127516e = u1Var3;
                }
                return 0;
            case 3:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    q4 q4Var3 = new q4();
                    if (bArr3 != null && bArr3.length > 0) {
                        q4Var3.a(bArr3);
                    }
                    dhVar.f127517f = q4Var3;
                }
                return 0;
            case 4:
                LinkedList h19 = aVar3.h(intValue);
                int size4 = h19.size();
                for (int i26 = 0; i26 < size4; i26++) {
                    byte[] bArr4 = (byte[]) h19.get(i26);
                    od odVar3 = new od();
                    if (bArr4 != null && bArr4.length > 0) {
                        odVar3.a(bArr4);
                    }
                    dhVar.f127518g = odVar3;
                }
                return 0;
            case 5:
                dhVar.f127519h = aVar3.f(intValue);
                return 0;
            case 6:
                dhVar.f127520i = aVar3.f(intValue);
                return 0;
            case 7:
                dhVar.f127521j = aVar3.i(intValue);
                return 0;
            case 8:
                dhVar.f127522k = aVar3.f(intValue);
                return 0;
            case 9:
                dhVar.f127523l = aVar3.b(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

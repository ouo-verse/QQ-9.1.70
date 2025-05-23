package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r7 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public sa f128588e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f128589f;

    /* renamed from: g, reason: collision with root package name */
    public int f128590g;

    /* renamed from: h, reason: collision with root package name */
    public int f128591h;

    /* renamed from: i, reason: collision with root package name */
    public String f128592i;

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
            sa saVar = this.f128588e;
            if (saVar != null) {
                aVar.c(2, saVar.a());
                this.f128588e.a(aVar);
            }
            aVar.a(3, this.f128589f);
            aVar.b(4, this.f128590g);
            aVar.b(5, this.f128591h);
            String str = this.f128592i;
            if (str != null) {
                aVar.a(6, str);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            sa saVar2 = this.f128588e;
            if (saVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, saVar2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, this.f128589f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128590g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128591h);
            String str2 = this.f128592i;
            if (str2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(6, str2);
            }
            return a16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        r7 r7Var = (r7) objArr[1];
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
                    r7Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    sa saVar3 = new sa();
                    if (bArr2 != null && bArr2.length > 0) {
                        saVar3.a(bArr2);
                    }
                    r7Var.f128588e = saVar3;
                }
                return 0;
            case 3:
                r7Var.f128589f = aVar3.a(intValue);
                return 0;
            case 4:
                r7Var.f128590g = aVar3.f(intValue);
                return 0;
            case 5:
                r7Var.f128591h = aVar3.f(intValue);
                return 0;
            case 6:
                r7Var.f128592i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

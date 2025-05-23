package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class yd extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f129095e;

    /* renamed from: f, reason: collision with root package name */
    public String f129096f;

    /* renamed from: g, reason: collision with root package name */
    public String f129097g;

    /* renamed from: h, reason: collision with root package name */
    public int f129098h;

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
            wd wdVar = this.f129095e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f129095e.a(aVar);
            }
            String str = this.f129096f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f129097g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            aVar.b(5, this.f129098h);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            wd wdVar2 = this.f129095e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            String str3 = this.f129096f;
            if (str3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str3);
            }
            String str4 = this.f129097g;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str4);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f129098h);
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
        yd ydVar = (yd) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        ydVar.f129098h = aVar3.f(intValue);
                        return 0;
                    }
                    ydVar.f129097g = aVar3.i(intValue);
                    return 0;
                }
                ydVar.f129096f = aVar3.i(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr = (byte[]) h16.get(i17);
                wd wdVar3 = new wd();
                if (bArr != null && bArr.length > 0) {
                    wdVar3.a(bArr);
                }
                ydVar.f129095e = wdVar3;
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr2 = (byte[]) h17.get(i18);
            h0 h0Var3 = new h0();
            if (bArr2 != null && bArr2.length > 0) {
                h0Var3.a(bArr2);
            }
            ydVar.f128743d = h0Var3;
        }
        return 0;
    }
}

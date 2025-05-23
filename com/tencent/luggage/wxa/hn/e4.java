package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e4 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127541e;

    /* renamed from: f, reason: collision with root package name */
    public hf f127542f;

    /* renamed from: g, reason: collision with root package name */
    public Cif f127543g;

    /* renamed from: h, reason: collision with root package name */
    public jf f127544h;

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
            String str = this.f127541e;
            if (str != null) {
                aVar.a(2, str);
            }
            hf hfVar = this.f127542f;
            if (hfVar != null) {
                aVar.c(3, hfVar.a());
                this.f127542f.a(aVar);
            }
            Cif cif = this.f127543g;
            if (cif != null) {
                aVar.c(6, cif.a());
                this.f127543g.a(aVar);
            }
            jf jfVar = this.f127544h;
            if (jfVar != null) {
                aVar.c(7, jfVar.a());
                this.f127544h.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str2 = this.f127541e;
            if (str2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            hf hfVar2 = this.f127542f;
            if (hfVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(3, hfVar2.a());
            }
            Cif cif2 = this.f127543g;
            if (cif2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(6, cif2.a());
            }
            jf jfVar2 = this.f127544h;
            if (jfVar2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.c(7, jfVar2.a());
            }
            return i16;
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
        e4 e4Var = (e4) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 6) {
                        if (intValue != 7) {
                            return -1;
                        }
                        LinkedList h16 = aVar3.h(intValue);
                        int size = h16.size();
                        for (int i17 = 0; i17 < size; i17++) {
                            byte[] bArr = (byte[]) h16.get(i17);
                            jf jfVar3 = new jf();
                            if (bArr != null && bArr.length > 0) {
                                jfVar3.a(bArr);
                            }
                            e4Var.f127544h = jfVar3;
                        }
                        return 0;
                    }
                    LinkedList h17 = aVar3.h(intValue);
                    int size2 = h17.size();
                    for (int i18 = 0; i18 < size2; i18++) {
                        byte[] bArr2 = (byte[]) h17.get(i18);
                        Cif cif3 = new Cif();
                        if (bArr2 != null && bArr2.length > 0) {
                            cif3.a(bArr2);
                        }
                        e4Var.f127543g = cif3;
                    }
                    return 0;
                }
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    hf hfVar3 = new hf();
                    if (bArr3 != null && bArr3.length > 0) {
                        hfVar3.a(bArr3);
                    }
                    e4Var.f127542f = hfVar3;
                }
                return 0;
            }
            e4Var.f127541e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h19 = aVar3.h(intValue);
        int size4 = h19.size();
        for (int i26 = 0; i26 < size4; i26++) {
            byte[] bArr4 = (byte[]) h19.get(i26);
            g0 g0Var3 = new g0();
            if (bArr4 != null && bArr4.length > 0) {
                g0Var3.a(bArr4);
            }
            e4Var.f128671d = g0Var3;
        }
        return 0;
    }
}

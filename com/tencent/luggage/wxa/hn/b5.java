package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b5 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public c5 f127340e;

    /* renamed from: g, reason: collision with root package name */
    public String f127342g;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127341f = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public LinkedList f127343h = new LinkedList();

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
            c5 c5Var = this.f127340e;
            if (c5Var != null) {
                aVar.c(2, c5Var.a());
                this.f127340e.a(aVar);
            }
            aVar.a(3, 8, this.f127341f);
            String str = this.f127342g;
            if (str != null) {
                aVar.a(4, str);
            }
            aVar.a(5, 8, this.f127343h);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            c5 c5Var2 = this.f127340e;
            if (c5Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, c5Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f127341f);
            String str2 = this.f127342g;
            if (str2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(4, str2);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.a(5, 8, this.f127343h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127341f.clear();
            this.f127343h.clear();
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
        b5 b5Var = (b5) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        LinkedList h16 = aVar3.h(intValue);
                        int size = h16.size();
                        for (int i17 = 0; i17 < size; i17++) {
                            byte[] bArr2 = (byte[]) h16.get(i17);
                            a6 a6Var = new a6();
                            if (bArr2 != null && bArr2.length > 0) {
                                a6Var.a(bArr2);
                            }
                            b5Var.f127343h.add(a6Var);
                        }
                        return 0;
                    }
                    b5Var.f127342g = aVar3.i(intValue);
                    return 0;
                }
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    y4 y4Var = new y4();
                    if (bArr3 != null && bArr3.length > 0) {
                        y4Var.a(bArr3);
                    }
                    b5Var.f127341f.add(y4Var);
                }
                return 0;
            }
            LinkedList h18 = aVar3.h(intValue);
            int size3 = h18.size();
            for (int i19 = 0; i19 < size3; i19++) {
                byte[] bArr4 = (byte[]) h18.get(i19);
                c5 c5Var3 = new c5();
                if (bArr4 != null && bArr4.length > 0) {
                    c5Var3.a(bArr4);
                }
                b5Var.f127340e = c5Var3;
            }
            return 0;
        }
        LinkedList h19 = aVar3.h(intValue);
        int size4 = h19.size();
        for (int i26 = 0; i26 < size4; i26++) {
            byte[] bArr5 = (byte[]) h19.get(i26);
            h0 h0Var3 = new h0();
            if (bArr5 != null && bArr5.length > 0) {
                h0Var3.a(bArr5);
            }
            b5Var.f128743d = h0Var3;
        }
        return 0;
    }
}

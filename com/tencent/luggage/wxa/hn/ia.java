package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ia extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public y f127883e;

    /* renamed from: f, reason: collision with root package name */
    public int f127884f;

    /* renamed from: g, reason: collision with root package name */
    public c0 f127885g;

    /* renamed from: h, reason: collision with root package name */
    public String f127886h;

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
            y yVar = this.f127883e;
            if (yVar != null) {
                aVar.c(2, yVar.a());
                this.f127883e.a(aVar);
            }
            aVar.b(3, this.f127884f);
            c0 c0Var = this.f127885g;
            if (c0Var != null) {
                aVar.c(4, c0Var.a());
                this.f127885g.a(aVar);
            }
            String str = this.f127886h;
            if (str != null) {
                aVar.a(5, str);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            y yVar2 = this.f127883e;
            if (yVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, yVar2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f127884f);
            c0 c0Var2 = this.f127885g;
            if (c0Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(4, c0Var2.a());
            }
            String str2 = this.f127886h;
            if (str2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(5, str2);
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
        ia iaVar = (ia) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        iaVar.f127886h = aVar3.i(intValue);
                        return 0;
                    }
                    LinkedList h16 = aVar3.h(intValue);
                    int size = h16.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        byte[] bArr = (byte[]) h16.get(i17);
                        c0 c0Var3 = new c0();
                        if (bArr != null && bArr.length > 0) {
                            c0Var3.a(bArr);
                        }
                        iaVar.f127885g = c0Var3;
                    }
                    return 0;
                }
                iaVar.f127884f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i18 = 0; i18 < size2; i18++) {
                byte[] bArr2 = (byte[]) h17.get(i18);
                y yVar3 = new y();
                if (bArr2 != null && bArr2.length > 0) {
                    yVar3.a(bArr2);
                }
                iaVar.f127883e = yVar3;
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i19 = 0; i19 < size3; i19++) {
            byte[] bArr3 = (byte[]) h18.get(i19);
            h0 h0Var3 = new h0();
            if (bArr3 != null && bArr3.length > 0) {
                h0Var3.a(bArr3);
            }
            iaVar.f128743d = h0Var3;
        }
        return 0;
    }
}

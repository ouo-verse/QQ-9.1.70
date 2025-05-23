package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class x3 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128998e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public String f128999f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f129000g;

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
            aVar.a(2, 8, this.f128998e);
            String str = this.f128999f;
            if (str != null) {
                aVar.a(3, str);
            }
            aVar.a(4, this.f129000g);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f128998e);
            String str2 = this.f128999f;
            if (str2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(3, str2);
            }
            return a16 + com.tencent.luggage.wxa.gr.a.a(4, this.f129000g);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128998e.clear();
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
        x3 x3Var = (x3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    x3Var.f129000g = aVar3.a(intValue);
                    return 0;
                }
                x3Var.f128999f = aVar3.i(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i17 = 0; i17 < size; i17++) {
                byte[] bArr2 = (byte[]) h16.get(i17);
                s0 s0Var = new s0();
                if (bArr2 != null && bArr2.length > 0) {
                    s0Var.a(bArr2);
                }
                x3Var.f128998e.add(s0Var);
            }
            return 0;
        }
        LinkedList h17 = aVar3.h(intValue);
        int size2 = h17.size();
        for (int i18 = 0; i18 < size2; i18++) {
            byte[] bArr3 = (byte[]) h17.get(i18);
            h0 h0Var3 = new h0();
            if (bArr3 != null && bArr3.length > 0) {
                h0Var3.a(bArr3);
            }
            x3Var.f128743d = h0Var3;
        }
        return 0;
    }
}

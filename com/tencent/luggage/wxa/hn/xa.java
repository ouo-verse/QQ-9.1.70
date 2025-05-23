package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class xa extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f129028d;

    /* renamed from: e, reason: collision with root package name */
    public h7 f129029e;

    /* renamed from: f, reason: collision with root package name */
    public i7 f129030f;

    /* renamed from: g, reason: collision with root package name */
    public h f129031g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f129028d);
            h7 h7Var = this.f129029e;
            if (h7Var != null) {
                aVar.c(2, h7Var.a());
                this.f129029e.a(aVar);
            }
            i7 i7Var = this.f129030f;
            if (i7Var != null) {
                aVar.c(3, i7Var.a());
                this.f129030f.a(aVar);
            }
            h hVar = this.f129031g;
            if (hVar != null) {
                aVar.c(4, hVar.a());
                this.f129031g.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f129028d) + 0;
            h7 h7Var2 = this.f129029e;
            if (h7Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(2, h7Var2.a());
            }
            i7 i7Var2 = this.f129030f;
            if (i7Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(3, i7Var2.a());
            }
            h hVar2 = this.f129031g;
            if (hVar2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.c(4, hVar2.a());
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
        xa xaVar = (xa) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    LinkedList h16 = aVar3.h(intValue);
                    int size = h16.size();
                    for (int i16 = 0; i16 < size; i16++) {
                        byte[] bArr = (byte[]) h16.get(i16);
                        h hVar3 = new h();
                        if (bArr != null && bArr.length > 0) {
                            hVar3.a(bArr);
                        }
                        xaVar.f129031g = hVar3;
                    }
                    return 0;
                }
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i17 = 0; i17 < size2; i17++) {
                    byte[] bArr2 = (byte[]) h17.get(i17);
                    i7 i7Var3 = new i7();
                    if (bArr2 != null && bArr2.length > 0) {
                        i7Var3.a(bArr2);
                    }
                    xaVar.f129030f = i7Var3;
                }
                return 0;
            }
            LinkedList h18 = aVar3.h(intValue);
            int size3 = h18.size();
            for (int i18 = 0; i18 < size3; i18++) {
                byte[] bArr3 = (byte[]) h18.get(i18);
                h7 h7Var3 = new h7();
                if (bArr3 != null && bArr3.length > 0) {
                    h7Var3.a(bArr3);
                }
                xaVar.f129029e = h7Var3;
            }
            return 0;
        }
        xaVar.f129028d = aVar3.f(intValue);
        return 0;
    }
}

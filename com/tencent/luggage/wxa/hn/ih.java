package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ih extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127905e;

    /* renamed from: f, reason: collision with root package name */
    public xa f127906f;

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
            com.tencent.luggage.wxa.fn.c cVar = this.f127905e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            xa xaVar = this.f127906f;
            if (xaVar != null) {
                aVar.c(3, xaVar.a());
                this.f127906f.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127905e;
            if (cVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, cVar2);
            }
            xa xaVar2 = this.f127906f;
            if (xaVar2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.c(3, xaVar2.a());
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
        ih ihVar = (ih) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    xa xaVar3 = new xa();
                    if (bArr != null && bArr.length > 0) {
                        xaVar3.a(bArr);
                    }
                    ihVar.f127906f = xaVar3;
                }
                return 0;
            }
            ihVar.f127905e = aVar3.b(intValue);
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
            ihVar.f128743d = h0Var3;
        }
        return 0;
    }
}

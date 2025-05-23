package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n3 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128253e;

    /* renamed from: f, reason: collision with root package name */
    public int f128254f;

    /* renamed from: g, reason: collision with root package name */
    public String f128255g;

    /* renamed from: h, reason: collision with root package name */
    public LinkedList f128256h = new LinkedList();

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
            String str = this.f128253e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.b(3, this.f128254f);
            String str2 = this.f128255g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            aVar.a(5, 1, this.f128256h);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            String str3 = this.f128253e;
            if (str3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128254f);
            String str4 = this.f128255g;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str4);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(5, 1, this.f128256h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128256h.clear();
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a(bArr, com.tencent.luggage.wxa.fn.b.f126260c);
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
        n3 n3Var = (n3) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        n3Var.f128256h.add(aVar3.i(intValue));
                        return 0;
                    }
                    n3Var.f128255g = aVar3.i(intValue);
                    return 0;
                }
                n3Var.f128254f = aVar3.f(intValue);
                return 0;
            }
            n3Var.f128253e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr2 = (byte[]) h16.get(i17);
            h0 h0Var3 = new h0();
            if (bArr2 != null && bArr2.length > 0) {
                h0Var3.a(bArr2);
            }
            n3Var.f128743d = h0Var3;
        }
        return 0;
    }
}

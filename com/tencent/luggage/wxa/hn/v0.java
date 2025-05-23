package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v0 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128852d;

    /* renamed from: e, reason: collision with root package name */
    public int f128853e;

    /* renamed from: f, reason: collision with root package name */
    public String f128854f;

    /* renamed from: g, reason: collision with root package name */
    public int f128855g;

    /* renamed from: h, reason: collision with root package name */
    public LinkedList f128856h = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128852d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f128853e);
            String str2 = this.f128854f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.b(4, this.f128855g);
            aVar.a(5, 8, this.f128856h);
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f128852d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128853e);
            String str4 = this.f128854f;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128855g) + com.tencent.luggage.wxa.gr.a.a(5, 8, this.f128856h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128856h.clear();
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
        v0 v0Var = (v0) objArr[1];
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
                            t0 t0Var = new t0();
                            if (bArr2 != null && bArr2.length > 0) {
                                t0Var.a(bArr2);
                            }
                            v0Var.f128856h.add(t0Var);
                        }
                        return 0;
                    }
                    v0Var.f128855g = aVar3.f(intValue);
                    return 0;
                }
                v0Var.f128854f = aVar3.i(intValue);
                return 0;
            }
            v0Var.f128853e = aVar3.f(intValue);
            return 0;
        }
        v0Var.f128852d = aVar3.i(intValue);
        return 0;
    }
}

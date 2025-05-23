package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ch extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127435e;

    /* renamed from: f, reason: collision with root package name */
    public String f127436f;

    /* renamed from: g, reason: collision with root package name */
    public String f127437g;

    /* renamed from: h, reason: collision with root package name */
    public LinkedList f127438h = new LinkedList();

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
            String str = this.f127435e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127436f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127437g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.a(5, 1, this.f127438h);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str4 = this.f127435e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127436f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f127437g;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(5, 1, this.f127438h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127438h.clear();
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
        ch chVar = (ch) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        chVar.f127438h.add(aVar3.i(intValue));
                        return 0;
                    }
                    chVar.f127437g = aVar3.i(intValue);
                    return 0;
                }
                chVar.f127436f = aVar3.i(intValue);
                return 0;
            }
            chVar.f127435e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr2 = (byte[]) h16.get(i17);
            g0 g0Var3 = new g0();
            if (bArr2 != null && bArr2.length > 0) {
                g0Var3.a(bArr2);
            }
            chVar.f128671d = g0Var3;
        }
        return 0;
    }
}

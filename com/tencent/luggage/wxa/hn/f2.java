package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f2 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public wd f127594e;

    /* renamed from: f, reason: collision with root package name */
    public String f127595f;

    /* renamed from: g, reason: collision with root package name */
    public String f127596g;

    /* renamed from: h, reason: collision with root package name */
    public String f127597h;

    /* renamed from: i, reason: collision with root package name */
    public int f127598i;

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
            wd wdVar = this.f127594e;
            if (wdVar != null) {
                aVar.c(2, wdVar.a());
                this.f127594e.a(aVar);
            }
            String str = this.f127595f;
            if (str != null) {
                aVar.a(3, str);
            }
            String str2 = this.f127596g;
            if (str2 != null) {
                aVar.a(4, str2);
            }
            String str3 = this.f127597h;
            if (str3 != null) {
                aVar.a(5, str3);
            }
            aVar.b(6, this.f127598i);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            wd wdVar2 = this.f127594e;
            if (wdVar2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, wdVar2.a());
            }
            String str4 = this.f127595f;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            String str5 = this.f127596g;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str5);
            }
            String str6 = this.f127597h;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(5, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(6, this.f127598i);
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
        f2 f2Var = (f2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr != null && bArr.length > 0) {
                        h0Var3.a(bArr);
                    }
                    f2Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    wd wdVar3 = new wd();
                    if (bArr2 != null && bArr2.length > 0) {
                        wdVar3.a(bArr2);
                    }
                    f2Var.f127594e = wdVar3;
                }
                return 0;
            case 3:
                f2Var.f127595f = aVar3.i(intValue);
                return 0;
            case 4:
                f2Var.f127596g = aVar3.i(intValue);
                return 0;
            case 5:
                f2Var.f127597h = aVar3.i(intValue);
                return 0;
            case 6:
                f2Var.f127598i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

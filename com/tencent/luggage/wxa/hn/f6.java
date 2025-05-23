package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class f6 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127610e;

    /* renamed from: f, reason: collision with root package name */
    public String f127611f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f127612g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f127613h;

    /* renamed from: i, reason: collision with root package name */
    public int f127614i;

    /* renamed from: j, reason: collision with root package name */
    public String f127615j;

    /* renamed from: k, reason: collision with root package name */
    public zf f127616k;

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
            String str = this.f127610e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127611f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.a(4, this.f127612g);
            aVar.a(5, this.f127613h);
            aVar.b(6, this.f127614i);
            String str3 = this.f127615j;
            if (str3 != null) {
                aVar.a(7, str3);
            }
            zf zfVar = this.f127616k;
            if (zfVar != null) {
                aVar.c(8, zfVar.a());
                this.f127616k.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            String str4 = this.f127610e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127611f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(4, this.f127612g) + com.tencent.luggage.wxa.gr.a.a(5, this.f127613h) + com.tencent.luggage.wxa.gr.a.b(6, this.f127614i);
            String str6 = this.f127615j;
            if (str6 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(7, str6);
            }
            zf zfVar2 = this.f127616k;
            if (zfVar2 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.c(8, zfVar2.a());
            }
            return a16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        f6 f6Var = (f6) objArr[1];
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
                    f6Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                f6Var.f127610e = aVar3.i(intValue);
                return 0;
            case 3:
                f6Var.f127611f = aVar3.i(intValue);
                return 0;
            case 4:
                f6Var.f127612g = aVar3.a(intValue);
                return 0;
            case 5:
                f6Var.f127613h = aVar3.a(intValue);
                return 0;
            case 6:
                f6Var.f127614i = aVar3.f(intValue);
                return 0;
            case 7:
                f6Var.f127615j = aVar3.i(intValue);
                return 0;
            case 8:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    zf zfVar3 = new zf();
                    if (bArr2 != null && bArr2.length > 0) {
                        zfVar3.a(bArr2);
                    }
                    f6Var.f127616k = zfVar3;
                }
                return 0;
            default:
                return -1;
        }
    }
}

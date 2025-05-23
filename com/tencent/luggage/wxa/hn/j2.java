package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j2 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f127927e;

    /* renamed from: f, reason: collision with root package name */
    public int f127928f;

    /* renamed from: g, reason: collision with root package name */
    public int f127929g;

    /* renamed from: h, reason: collision with root package name */
    public int f127930h;

    /* renamed from: i, reason: collision with root package name */
    public String f127931i;

    /* renamed from: j, reason: collision with root package name */
    public String f127932j;

    /* renamed from: k, reason: collision with root package name */
    public int f127933k;

    /* renamed from: l, reason: collision with root package name */
    public LinkedList f127934l = new LinkedList();

    /* renamed from: m, reason: collision with root package name */
    public LinkedList f127935m = new LinkedList();

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
            aVar.b(2, this.f127927e);
            aVar.b(3, this.f127928f);
            aVar.b(4, this.f127929g);
            aVar.b(5, this.f127930h);
            String str = this.f127931i;
            if (str != null) {
                aVar.a(6, str);
            }
            String str2 = this.f127932j;
            if (str2 != null) {
                aVar.a(7, str2);
            }
            aVar.b(8, this.f127933k);
            aVar.a(9, 8, this.f127934l);
            aVar.a(10, 6, this.f127935m);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127927e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127928f) + com.tencent.luggage.wxa.gr.a.b(4, this.f127929g) + com.tencent.luggage.wxa.gr.a.b(5, this.f127930h);
            String str3 = this.f127931i;
            if (str3 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str3);
            }
            String str4 = this.f127932j;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(7, str4);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(8, this.f127933k) + com.tencent.luggage.wxa.gr.a.a(9, 8, this.f127934l) + com.tencent.luggage.wxa.gr.a.a(10, 6, this.f127935m);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127934l.clear();
            this.f127935m.clear();
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
        j2 j2Var = (j2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    g0 g0Var3 = new g0();
                    if (bArr2 != null && bArr2.length > 0) {
                        g0Var3.a(bArr2);
                    }
                    j2Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                j2Var.f127927e = aVar3.f(intValue);
                return 0;
            case 3:
                j2Var.f127928f = aVar3.f(intValue);
                return 0;
            case 4:
                j2Var.f127929g = aVar3.f(intValue);
                return 0;
            case 5:
                j2Var.f127930h = aVar3.f(intValue);
                return 0;
            case 6:
                j2Var.f127931i = aVar3.i(intValue);
                return 0;
            case 7:
                j2Var.f127932j = aVar3.i(intValue);
                return 0;
            case 8:
                j2Var.f127933k = aVar3.f(intValue);
                return 0;
            case 9:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    i2 i2Var = new i2();
                    if (bArr3 != null && bArr3.length > 0) {
                        i2Var.a(bArr3);
                    }
                    j2Var.f127934l.add(i2Var);
                }
                return 0;
            case 10:
                j2Var.f127935m.add(aVar3.b(intValue));
                return 0;
            default:
                return -1;
        }
    }
}

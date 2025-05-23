package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t2 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public r8 f128716d;

    /* renamed from: e, reason: collision with root package name */
    public l6 f128717e;

    /* renamed from: f, reason: collision with root package name */
    public int f128718f;

    /* renamed from: g, reason: collision with root package name */
    public int f128719g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f128720h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f128721i;

    /* renamed from: j, reason: collision with root package name */
    public int f128722j;

    /* renamed from: k, reason: collision with root package name */
    public String f128723k;

    /* renamed from: l, reason: collision with root package name */
    public String f128724l;

    /* renamed from: m, reason: collision with root package name */
    public String f128725m;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            r8 r8Var = this.f128716d;
            if (r8Var != null) {
                aVar.c(1, r8Var.a());
                this.f128716d.a(aVar);
            }
            l6 l6Var = this.f128717e;
            if (l6Var != null) {
                aVar.c(2, l6Var.a());
                this.f128717e.a(aVar);
            }
            aVar.b(3, this.f128718f);
            aVar.b(4, this.f128719g);
            aVar.a(5, this.f128720h);
            aVar.a(6, this.f128721i);
            aVar.b(7, this.f128722j);
            String str = this.f128723k;
            if (str != null) {
                aVar.a(8, str);
            }
            String str2 = this.f128724l;
            if (str2 != null) {
                aVar.a(9, str2);
            }
            String str3 = this.f128725m;
            if (str3 != null) {
                aVar.a(10, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            r8 r8Var2 = this.f128716d;
            if (r8Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, r8Var2.a());
            }
            l6 l6Var2 = this.f128717e;
            if (l6Var2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, l6Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128718f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128719g) + com.tencent.luggage.wxa.gr.a.a(5, this.f128720h) + com.tencent.luggage.wxa.gr.a.a(6, this.f128721i) + com.tencent.luggage.wxa.gr.a.b(7, this.f128722j);
            String str4 = this.f128723k;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(8, str4);
            }
            String str5 = this.f128724l;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(9, str5);
            }
            String str6 = this.f128725m;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(10, str6);
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
        t2 t2Var = (t2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    r8 r8Var3 = new r8();
                    if (bArr != null && bArr.length > 0) {
                        r8Var3.a(bArr);
                    }
                    t2Var.f128716d = r8Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    l6 l6Var3 = new l6();
                    if (bArr2 != null && bArr2.length > 0) {
                        l6Var3.a(bArr2);
                    }
                    t2Var.f128717e = l6Var3;
                }
                return 0;
            case 3:
                t2Var.f128718f = aVar3.f(intValue);
                return 0;
            case 4:
                t2Var.f128719g = aVar3.f(intValue);
                return 0;
            case 5:
                t2Var.f128720h = aVar3.a(intValue);
                return 0;
            case 6:
                t2Var.f128721i = aVar3.a(intValue);
                return 0;
            case 7:
                t2Var.f128722j = aVar3.f(intValue);
                return 0;
            case 8:
                t2Var.f128723k = aVar3.i(intValue);
                return 0;
            case 9:
                t2Var.f128724l = aVar3.i(intValue);
                return 0;
            case 10:
                t2Var.f128725m = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

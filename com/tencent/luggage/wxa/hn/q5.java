package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128498e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128499f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public int f128500g;

    /* renamed from: h, reason: collision with root package name */
    public gf f128501h;

    /* renamed from: i, reason: collision with root package name */
    public String f128502i;

    /* renamed from: j, reason: collision with root package name */
    public fg f128503j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f128504k;

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
            String str = this.f128498e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.a(3, 1, this.f128499f);
            aVar.b(4, this.f128500g);
            gf gfVar = this.f128501h;
            if (gfVar != null) {
                aVar.c(5, gfVar.a());
                this.f128501h.a(aVar);
            }
            String str2 = this.f128502i;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            fg fgVar = this.f128503j;
            if (fgVar != null) {
                aVar.c(7, fgVar.a());
                this.f128503j.a(aVar);
            }
            aVar.a(8, this.f128504k);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str3 = this.f128498e;
            if (str3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 1, this.f128499f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128500g);
            gf gfVar2 = this.f128501h;
            if (gfVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(5, gfVar2.a());
            }
            String str4 = this.f128502i;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str4);
            }
            fg fgVar2 = this.f128503j;
            if (fgVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(7, fgVar2.a());
            }
            return a16 + com.tencent.luggage.wxa.gr.a.a(8, this.f128504k);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128499f.clear();
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
        q5 q5Var = (q5) objArr[1];
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
                    q5Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                q5Var.f128498e = aVar3.i(intValue);
                return 0;
            case 3:
                q5Var.f128499f.add(aVar3.i(intValue));
                return 0;
            case 4:
                q5Var.f128500g = aVar3.f(intValue);
                return 0;
            case 5:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    gf gfVar3 = new gf();
                    if (bArr3 != null && bArr3.length > 0) {
                        gfVar3.a(bArr3);
                    }
                    q5Var.f128501h = gfVar3;
                }
                return 0;
            case 6:
                q5Var.f128502i = aVar3.i(intValue);
                return 0;
            case 7:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    fg fgVar3 = new fg();
                    if (bArr4 != null && bArr4.length > 0) {
                        fgVar3.a(bArr4);
                    }
                    q5Var.f128503j = fgVar3;
                }
                return 0;
            case 8:
                q5Var.f128504k = aVar3.a(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

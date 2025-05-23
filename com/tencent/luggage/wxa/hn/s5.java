package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s5 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128660e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128661f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public int f128662g;

    /* renamed from: h, reason: collision with root package name */
    public String f128663h;

    /* renamed from: i, reason: collision with root package name */
    public int f128664i;

    /* renamed from: j, reason: collision with root package name */
    public int f128665j;

    /* renamed from: k, reason: collision with root package name */
    public gf f128666k;

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
            String str = this.f128660e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.a(3, 1, this.f128661f);
            aVar.b(4, this.f128662g);
            String str2 = this.f128663h;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            aVar.b(7, this.f128664i);
            aVar.b(8, this.f128665j);
            gf gfVar = this.f128666k;
            if (gfVar != null) {
                aVar.c(9, gfVar.a());
                this.f128666k.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str3 = this.f128660e;
            if (str3 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str3);
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(3, 1, this.f128661f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128662g);
            String str4 = this.f128663h;
            if (str4 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str4);
            }
            int b16 = a16 + com.tencent.luggage.wxa.gr.a.b(7, this.f128664i) + com.tencent.luggage.wxa.gr.a.b(8, this.f128665j);
            gf gfVar2 = this.f128666k;
            if (gfVar2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.c(9, gfVar2.a());
            }
            return b16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128661f.clear();
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
        s5 s5Var = (s5) objArr[1];
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
                    s5Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                s5Var.f128660e = aVar3.i(intValue);
                return 0;
            case 3:
                s5Var.f128661f.add(aVar3.i(intValue));
                return 0;
            case 4:
                s5Var.f128662g = aVar3.f(intValue);
                return 0;
            case 5:
            default:
                return -1;
            case 6:
                s5Var.f128663h = aVar3.i(intValue);
                return 0;
            case 7:
                s5Var.f128664i = aVar3.f(intValue);
                return 0;
            case 8:
                s5Var.f128665j = aVar3.f(intValue);
                return 0;
            case 9:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    gf gfVar3 = new gf();
                    if (bArr3 != null && bArr3.length > 0) {
                        gfVar3.a(bArr3);
                    }
                    s5Var.f128666k = gfVar3;
                }
                return 0;
        }
    }
}

package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m4 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public int f128140e;

    /* renamed from: f, reason: collision with root package name */
    public int f128141f;

    /* renamed from: g, reason: collision with root package name */
    public int f128142g;

    /* renamed from: h, reason: collision with root package name */
    public int f128143h;

    /* renamed from: i, reason: collision with root package name */
    public int f128144i;

    /* renamed from: j, reason: collision with root package name */
    public String f128145j;

    /* renamed from: k, reason: collision with root package name */
    public m6 f128146k;

    /* renamed from: l, reason: collision with root package name */
    public a7 f128147l;

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
            aVar.b(2, this.f128140e);
            aVar.b(3, this.f128141f);
            aVar.b(4, this.f128142g);
            aVar.b(5, this.f128143h);
            aVar.b(6, this.f128144i);
            String str = this.f128145j;
            if (str != null) {
                aVar.a(10, str);
            }
            m6 m6Var = this.f128146k;
            if (m6Var != null) {
                aVar.c(11, m6Var.a());
                this.f128146k.a(aVar);
            }
            a7 a7Var = this.f128147l;
            if (a7Var != null) {
                aVar.c(12, a7Var.a());
                this.f128147l.a(aVar);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128140e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128141f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128142g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128143h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128144i);
            String str2 = this.f128145j;
            if (str2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(10, str2);
            }
            m6 m6Var2 = this.f128146k;
            if (m6Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(11, m6Var2.a());
            }
            a7 a7Var2 = this.f128147l;
            if (a7Var2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.c(12, a7Var2.a());
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
        m4 m4Var = (m4) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    g0 g0Var3 = new g0();
                    if (bArr != null && bArr.length > 0) {
                        g0Var3.a(bArr);
                    }
                    m4Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                m4Var.f128140e = aVar3.f(intValue);
                return 0;
            case 3:
                m4Var.f128141f = aVar3.f(intValue);
                return 0;
            case 4:
                m4Var.f128142g = aVar3.f(intValue);
                return 0;
            case 5:
                m4Var.f128143h = aVar3.f(intValue);
                return 0;
            case 6:
                m4Var.f128144i = aVar3.f(intValue);
                return 0;
            case 7:
            case 8:
            case 9:
            default:
                return -1;
            case 10:
                m4Var.f128145j = aVar3.i(intValue);
                return 0;
            case 11:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr2 = (byte[]) h17.get(i18);
                    m6 m6Var3 = new m6();
                    if (bArr2 != null && bArr2.length > 0) {
                        m6Var3.a(bArr2);
                    }
                    m4Var.f128146k = m6Var3;
                }
                return 0;
            case 12:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr3 = (byte[]) h18.get(i19);
                    a7 a7Var3 = new a7();
                    if (bArr3 != null && bArr3.length > 0) {
                        a7Var3.a(bArr3);
                    }
                    m4Var.f128147l = a7Var3;
                }
                return 0;
        }
    }
}

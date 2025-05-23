package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q0 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128472e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public int f128473f;

    /* renamed from: g, reason: collision with root package name */
    public int f128474g;

    /* renamed from: h, reason: collision with root package name */
    public xe f128475h;

    /* renamed from: i, reason: collision with root package name */
    public String f128476i;

    /* renamed from: j, reason: collision with root package name */
    public String f128477j;

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
            aVar.a(2, 8, this.f128472e);
            aVar.b(3, this.f128473f);
            aVar.b(4, this.f128474g);
            xe xeVar = this.f128475h;
            if (xeVar != null) {
                aVar.c(5, xeVar.a());
                this.f128475h.a(aVar);
            }
            String str = this.f128476i;
            if (str != null) {
                aVar.a(6, str);
            }
            String str2 = this.f128477j;
            if (str2 != null) {
                aVar.a(7, str2);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            int a16 = i16 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f128472e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128473f) + com.tencent.luggage.wxa.gr.a.b(4, this.f128474g);
            xe xeVar2 = this.f128475h;
            if (xeVar2 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.c(5, xeVar2.a());
            }
            String str3 = this.f128476i;
            if (str3 != null) {
                a16 += com.tencent.luggage.wxa.gr.a.a(6, str3);
            }
            String str4 = this.f128477j;
            if (str4 != null) {
                return a16 + com.tencent.luggage.wxa.gr.a.a(7, str4);
            }
            return a16;
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128472e.clear();
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
        q0 q0Var = (q0) objArr[1];
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
                    q0Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    te teVar = new te();
                    if (bArr3 != null && bArr3.length > 0) {
                        teVar.a(bArr3);
                    }
                    q0Var.f128472e.add(teVar);
                }
                return 0;
            case 3:
                q0Var.f128473f = aVar3.f(intValue);
                return 0;
            case 4:
                q0Var.f128474g = aVar3.f(intValue);
                return 0;
            case 5:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    xe xeVar3 = new xe();
                    if (bArr4 != null && bArr4.length > 0) {
                        xeVar3.a(bArr4);
                    }
                    q0Var.f128475h = xeVar3;
                }
                return 0;
            case 6:
                q0Var.f128476i = aVar3.i(intValue);
                return 0;
            case 7:
                q0Var.f128477j = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

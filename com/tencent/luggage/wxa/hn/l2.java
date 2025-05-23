package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l2 extends t8 {

    /* renamed from: e, reason: collision with root package name */
    public int f128051e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128052f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f128053g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public LinkedList f128054h = new LinkedList();

    /* renamed from: i, reason: collision with root package name */
    public LinkedList f128055i = new LinkedList();

    /* renamed from: j, reason: collision with root package name */
    public LinkedList f128056j = new LinkedList();

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
            aVar.b(2, this.f128051e);
            aVar.a(3, 2, this.f128052f);
            aVar.a(4, 8, this.f128053g);
            aVar.a(5, 8, this.f128054h);
            aVar.a(6, 6, this.f128055i);
            aVar.a(7, 6, this.f128056j);
            return 0;
        }
        if (i3 == 1) {
            h0 h0Var2 = this.f128743d;
            if (h0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, h0Var2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128051e) + com.tencent.luggage.wxa.gr.a.a(3, 2, this.f128052f) + com.tencent.luggage.wxa.gr.a.a(4, 8, this.f128053g) + com.tencent.luggage.wxa.gr.a.a(5, 8, this.f128054h) + com.tencent.luggage.wxa.gr.a.a(6, 6, this.f128055i) + com.tencent.luggage.wxa.gr.a.a(7, 6, this.f128056j);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128052f.clear();
            this.f128053g.clear();
            this.f128054h.clear();
            this.f128055i.clear();
            this.f128056j.clear();
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
        l2 l2Var = (l2) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    h0 h0Var3 = new h0();
                    if (bArr2 != null && bArr2.length > 0) {
                        h0Var3.a(bArr2);
                    }
                    l2Var.f128743d = h0Var3;
                }
                return 0;
            case 2:
                l2Var.f128051e = aVar3.f(intValue);
                return 0;
            case 3:
                l2Var.f128052f.add(Integer.valueOf(aVar3.f(intValue)));
                return 0;
            case 4:
                LinkedList h17 = aVar3.h(intValue);
                int size2 = h17.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    byte[] bArr3 = (byte[]) h17.get(i18);
                    k2 k2Var = new k2();
                    if (bArr3 != null && bArr3.length > 0) {
                        k2Var.a(bArr3);
                    }
                    l2Var.f128053g.add(k2Var);
                }
                return 0;
            case 5:
                LinkedList h18 = aVar3.h(intValue);
                int size3 = h18.size();
                for (int i19 = 0; i19 < size3; i19++) {
                    byte[] bArr4 = (byte[]) h18.get(i19);
                    h2 h2Var = new h2();
                    if (bArr4 != null && bArr4.length > 0) {
                        h2Var.a(bArr4);
                    }
                    l2Var.f128054h.add(h2Var);
                }
                return 0;
            case 6:
                l2Var.f128055i.add(aVar3.b(intValue));
                return 0;
            case 7:
                l2Var.f128056j.add(aVar3.b(intValue));
                return 0;
            default:
                return -1;
        }
    }
}

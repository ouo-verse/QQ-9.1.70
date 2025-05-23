package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m3 extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128135e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f128136f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f128137g = new LinkedList();

    /* renamed from: h, reason: collision with root package name */
    public int f128138h;

    /* renamed from: i, reason: collision with root package name */
    public int f128139i;

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
            String str = this.f128135e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.a(3, this.f128136f);
            aVar.a(4, 1, this.f128137g);
            aVar.b(5, this.f128138h);
            aVar.b(6, this.f128139i);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str2 = this.f128135e;
            if (str2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, this.f128136f) + com.tencent.luggage.wxa.gr.a.a(4, 1, this.f128137g) + com.tencent.luggage.wxa.gr.a.b(5, this.f128138h) + com.tencent.luggage.wxa.gr.a.b(6, this.f128139i);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128137g.clear();
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
        m3 m3Var = (m3) objArr[1];
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
                    m3Var.f128671d = g0Var3;
                }
                return 0;
            case 2:
                m3Var.f128135e = aVar3.i(intValue);
                return 0;
            case 3:
                m3Var.f128136f = aVar3.a(intValue);
                return 0;
            case 4:
                m3Var.f128137g.add(aVar3.i(intValue));
                return 0;
            case 5:
                m3Var.f128138h = aVar3.f(intValue);
                return 0;
            case 6:
                m3Var.f128139i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z1 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f129114d;

    /* renamed from: e, reason: collision with root package name */
    public int f129115e;

    /* renamed from: f, reason: collision with root package name */
    public int f129116f;

    /* renamed from: g, reason: collision with root package name */
    public int f129117g;

    /* renamed from: h, reason: collision with root package name */
    public LinkedList f129118h = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f129114d);
            aVar.b(2, this.f129115e);
            aVar.b(3, this.f129116f);
            aVar.b(4, this.f129117g);
            aVar.a(5, 2, this.f129118h);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f129114d) + 0 + com.tencent.luggage.wxa.gr.a.b(2, this.f129115e) + com.tencent.luggage.wxa.gr.a.b(3, this.f129116f) + com.tencent.luggage.wxa.gr.a.b(4, this.f129117g) + com.tencent.luggage.wxa.gr.a.a(5, 2, this.f129118h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f129118h.clear();
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
        z1 z1Var = (z1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        z1Var.f129118h.add(Integer.valueOf(aVar3.f(intValue)));
                        return 0;
                    }
                    z1Var.f129117g = aVar3.f(intValue);
                    return 0;
                }
                z1Var.f129116f = aVar3.f(intValue);
                return 0;
            }
            z1Var.f129115e = aVar3.f(intValue);
            return 0;
        }
        z1Var.f129114d = aVar3.f(intValue);
        return 0;
    }
}

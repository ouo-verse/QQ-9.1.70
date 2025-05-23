package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128420d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128421e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128422f;

    /* renamed from: g, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128423g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128424h;

    /* renamed from: i, reason: collision with root package name */
    public q9 f128425i;

    /* renamed from: j, reason: collision with root package name */
    public int f128426j;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128420d);
            com.tencent.luggage.wxa.fn.c cVar = this.f128421e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128422f;
            if (cVar2 != null) {
                aVar.a(3, cVar2);
            }
            com.tencent.luggage.wxa.fn.c cVar3 = this.f128423g;
            if (cVar3 != null) {
                aVar.a(4, cVar3);
            }
            com.tencent.luggage.wxa.fn.c cVar4 = this.f128424h;
            if (cVar4 != null) {
                aVar.a(5, cVar4);
            }
            q9 q9Var = this.f128425i;
            if (q9Var != null) {
                aVar.c(6, q9Var.a());
                this.f128425i.a(aVar);
            }
            aVar.b(7, this.f128426j);
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128420d) + 0;
            com.tencent.luggage.wxa.fn.c cVar5 = this.f128421e;
            if (cVar5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(2, cVar5);
            }
            com.tencent.luggage.wxa.fn.c cVar6 = this.f128422f;
            if (cVar6 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, cVar6);
            }
            com.tencent.luggage.wxa.fn.c cVar7 = this.f128423g;
            if (cVar7 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, cVar7);
            }
            com.tencent.luggage.wxa.fn.c cVar8 = this.f128424h;
            if (cVar8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, cVar8);
            }
            q9 q9Var2 = this.f128425i;
            if (q9Var2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(6, q9Var2.a());
            }
            return b16 + com.tencent.luggage.wxa.gr.a.b(7, this.f128426j);
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
        p9 p9Var = (p9) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                p9Var.f128420d = aVar3.f(intValue);
                return 0;
            case 2:
                p9Var.f128421e = aVar3.b(intValue);
                return 0;
            case 3:
                p9Var.f128422f = aVar3.b(intValue);
                return 0;
            case 4:
                p9Var.f128423g = aVar3.b(intValue);
                return 0;
            case 5:
                p9Var.f128424h = aVar3.b(intValue);
                return 0;
            case 6:
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr = (byte[]) h16.get(i16);
                    q9 q9Var3 = new q9();
                    if (bArr != null && bArr.length > 0) {
                        q9Var3.a(bArr);
                    }
                    p9Var.f128425i = q9Var3;
                }
                return 0;
            case 7:
                p9Var.f128426j = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

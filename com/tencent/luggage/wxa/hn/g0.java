package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g0 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127654d;

    /* renamed from: e, reason: collision with root package name */
    public int f127655e;

    /* renamed from: f, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127656f;

    /* renamed from: g, reason: collision with root package name */
    public int f127657g;

    /* renamed from: h, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f127658h;

    /* renamed from: i, reason: collision with root package name */
    public int f127659i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            com.tencent.luggage.wxa.fn.c cVar = this.f127654d;
            if (cVar != null) {
                aVar.a(1, cVar);
            }
            aVar.b(2, this.f127655e);
            com.tencent.luggage.wxa.fn.c cVar2 = this.f127656f;
            if (cVar2 != null) {
                aVar.a(3, cVar2);
            }
            aVar.b(4, this.f127657g);
            com.tencent.luggage.wxa.fn.c cVar3 = this.f127658h;
            if (cVar3 != null) {
                aVar.a(5, cVar3);
            }
            aVar.b(6, this.f127659i);
            return 0;
        }
        if (i3 == 1) {
            com.tencent.luggage.wxa.fn.c cVar4 = this.f127654d;
            if (cVar4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, cVar4);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127655e);
            com.tencent.luggage.wxa.fn.c cVar5 = this.f127656f;
            if (cVar5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, cVar5);
            }
            int b17 = b16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127657g);
            com.tencent.luggage.wxa.fn.c cVar6 = this.f127658h;
            if (cVar6 != null) {
                b17 += com.tencent.luggage.wxa.gr.a.a(5, cVar6);
            }
            return b17 + com.tencent.luggage.wxa.gr.a.b(6, this.f127659i);
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
        g0 g0Var = (g0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                g0Var.f127654d = aVar3.b(intValue);
                return 0;
            case 2:
                g0Var.f127655e = aVar3.f(intValue);
                return 0;
            case 3:
                g0Var.f127656f = aVar3.b(intValue);
                return 0;
            case 4:
                g0Var.f127657g = aVar3.f(intValue);
                return 0;
            case 5:
                g0Var.f127658h = aVar3.b(intValue);
                return 0;
            case 6:
                g0Var.f127659i = aVar3.f(intValue);
                return 0;
            default:
                return -1;
        }
    }
}

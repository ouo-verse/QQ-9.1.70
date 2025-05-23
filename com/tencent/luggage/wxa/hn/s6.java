package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class s6 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128667d;

    /* renamed from: e, reason: collision with root package name */
    public com.tencent.luggage.wxa.fn.c f128668e;

    public static final s6 e() {
        return new s6();
    }

    public s6 a(String str) {
        this.f128667d = str;
        return this;
    }

    public s6 a(com.tencent.luggage.wxa.fn.c cVar) {
        this.f128668e = cVar;
        return this;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128667d;
            if (str != null) {
                aVar.a(1, str);
            }
            com.tencent.luggage.wxa.fn.c cVar = this.f128668e;
            if (cVar != null) {
                aVar.a(2, cVar);
            }
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f128667d;
            int a16 = str2 != null ? 0 + com.tencent.luggage.wxa.gr.a.a(1, str2) : 0;
            com.tencent.luggage.wxa.fn.c cVar2 = this.f128668e;
            return cVar2 != null ? a16 + com.tencent.luggage.wxa.gr.a.a(2, cVar2) : a16;
        }
        if (i3 == 2) {
            com.tencent.luggage.wxa.hr.a aVar2 = new com.tencent.luggage.wxa.hr.a((byte[]) objArr[0], com.tencent.luggage.wxa.fn.b.f126260c);
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
        s6 s6Var = (s6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue == 1) {
            s6Var.f128667d = aVar3.i(intValue);
            return 0;
        }
        if (intValue != 2) {
            return -1;
        }
        s6Var.f128668e = aVar3.b(intValue);
        return 0;
    }
}

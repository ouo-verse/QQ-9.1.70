package com.tencent.luggage.wxa.hn;

/* compiled from: P */
/* loaded from: classes8.dex */
public class gf extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127718d;

    /* renamed from: e, reason: collision with root package name */
    public int f127719e;

    /* renamed from: f, reason: collision with root package name */
    public int f127720f;

    /* renamed from: g, reason: collision with root package name */
    public long f127721g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127718d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127719e);
            aVar.b(3, this.f127720f);
            aVar.a(4, this.f127721g);
            return 0;
        }
        if (i3 == 1) {
            String str2 = this.f127718d;
            if (str2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127719e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127720f) + com.tencent.luggage.wxa.gr.a.a(4, this.f127721g);
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
        gf gfVar = (gf) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    gfVar.f127721g = aVar3.g(intValue);
                    return 0;
                }
                gfVar.f127720f = aVar3.f(intValue);
                return 0;
            }
            gfVar.f127719e = aVar3.f(intValue);
            return 0;
        }
        gfVar.f127718d = aVar3.i(intValue);
        return 0;
    }
}

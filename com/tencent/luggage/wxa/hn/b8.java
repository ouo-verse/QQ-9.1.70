package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b8 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f127346d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f127347e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public int f127348f;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f127346d);
            aVar.a(2, 8, this.f127347e);
            aVar.b(3, this.f127348f);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.b(1, this.f127346d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f127347e) + com.tencent.luggage.wxa.gr.a.b(3, this.f127348f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127347e.clear();
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
        b8 b8Var = (b8) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                b8Var.f127348f = aVar3.f(intValue);
                return 0;
            }
            LinkedList h16 = aVar3.h(intValue);
            int size = h16.size();
            for (int i16 = 0; i16 < size; i16++) {
                byte[] bArr2 = (byte[]) h16.get(i16);
                c8 c8Var = new c8();
                if (bArr2 != null && bArr2.length > 0) {
                    c8Var.a(bArr2);
                }
                b8Var.f127347e.add(c8Var);
            }
            return 0;
        }
        b8Var.f127346d = aVar3.f(intValue);
        return 0;
    }
}

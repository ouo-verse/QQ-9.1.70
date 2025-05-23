package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ga extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public fa f127698d;

    /* renamed from: e, reason: collision with root package name */
    public fa f127699e;

    /* renamed from: f, reason: collision with root package name */
    public fa f127700f;

    /* renamed from: g, reason: collision with root package name */
    public int f127701g;

    /* renamed from: h, reason: collision with root package name */
    public int f127702h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            fa faVar = this.f127698d;
            if (faVar != null) {
                aVar.c(1, faVar.a());
                this.f127698d.a(aVar);
            }
            fa faVar2 = this.f127699e;
            if (faVar2 != null) {
                aVar.c(2, faVar2.a());
                this.f127699e.a(aVar);
            }
            fa faVar3 = this.f127700f;
            if (faVar3 != null) {
                aVar.c(3, faVar3.a());
                this.f127700f.a(aVar);
            }
            aVar.b(4, this.f127701g);
            aVar.b(5, this.f127702h);
            return 0;
        }
        if (i3 == 1) {
            fa faVar4 = this.f127698d;
            if (faVar4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, faVar4.a());
            }
            fa faVar5 = this.f127699e;
            if (faVar5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(2, faVar5.a());
            }
            fa faVar6 = this.f127700f;
            if (faVar6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.c(3, faVar6.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f127701g) + com.tencent.luggage.wxa.gr.a.b(5, this.f127702h);
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
        ga gaVar = (ga) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        gaVar.f127702h = aVar3.f(intValue);
                        return 0;
                    }
                    gaVar.f127701g = aVar3.f(intValue);
                    return 0;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr = (byte[]) h16.get(i17);
                    fa faVar7 = new fa();
                    if (bArr != null && bArr.length > 0) {
                        faVar7.a(bArr);
                    }
                    gaVar.f127700f = faVar7;
                }
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i18 = 0; i18 < size2; i18++) {
                byte[] bArr2 = (byte[]) h17.get(i18);
                fa faVar8 = new fa();
                if (bArr2 != null && bArr2.length > 0) {
                    faVar8.a(bArr2);
                }
                gaVar.f127699e = faVar8;
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i19 = 0; i19 < size3; i19++) {
            byte[] bArr3 = (byte[]) h18.get(i19);
            fa faVar9 = new fa();
            if (bArr3 != null && bArr3.length > 0) {
                faVar9.a(bArr3);
            }
            gaVar.f127698d = faVar9;
        }
        return 0;
    }
}

package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class od extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public LinkedList f128371d = new LinkedList();

    /* renamed from: e, reason: collision with root package name */
    public LinkedList f128372e = new LinkedList();

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f128373f = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.a(1, 8, this.f128371d);
            aVar.a(2, 8, this.f128372e);
            aVar.a(3, 8, this.f128373f);
            return 0;
        }
        if (i3 == 1) {
            return com.tencent.luggage.wxa.gr.a.a(1, 8, this.f128371d) + 0 + com.tencent.luggage.wxa.gr.a.a(2, 8, this.f128372e) + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f128373f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f128371d.clear();
            this.f128372e.clear();
            this.f128373f.clear();
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
        od odVar = (od) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i16 = 0; i16 < size; i16++) {
                    byte[] bArr2 = (byte[]) h16.get(i16);
                    x7 x7Var = new x7();
                    if (bArr2 != null && bArr2.length > 0) {
                        x7Var.a(bArr2);
                    }
                    odVar.f128373f.add(x7Var);
                }
                return 0;
            }
            LinkedList h17 = aVar3.h(intValue);
            int size2 = h17.size();
            for (int i17 = 0; i17 < size2; i17++) {
                byte[] bArr3 = (byte[]) h17.get(i17);
                ua uaVar = new ua();
                if (bArr3 != null && bArr3.length > 0) {
                    uaVar.a(bArr3);
                }
                odVar.f128372e.add(uaVar);
            }
            return 0;
        }
        LinkedList h18 = aVar3.h(intValue);
        int size3 = h18.size();
        for (int i18 = 0; i18 < size3; i18++) {
            byte[] bArr4 = (byte[]) h18.get(i18);
            pd pdVar = new pd();
            if (bArr4 != null && bArr4.length > 0) {
                pdVar.a(bArr4);
            }
            odVar.f128371d.add(pdVar);
        }
        return 0;
    }
}

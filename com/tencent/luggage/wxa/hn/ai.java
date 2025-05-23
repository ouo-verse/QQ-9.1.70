package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ai extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public ph f127310d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f127311e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127312f = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            ph phVar = this.f127310d;
            if (phVar != null) {
                aVar.c(1, phVar.a());
                this.f127310d.a(aVar);
            }
            aVar.a(2, this.f127311e);
            aVar.a(3, 1, this.f127312f);
            return 0;
        }
        if (i3 == 1) {
            ph phVar2 = this.f127310d;
            if (phVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, phVar2.a());
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(2, this.f127311e) + com.tencent.luggage.wxa.gr.a.a(3, 1, this.f127312f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127312f.clear();
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
        ai aiVar = (ai) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                aiVar.f127312f.add(aVar3.i(intValue));
                return 0;
            }
            aiVar.f127311e = aVar3.a(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr2 = (byte[]) h16.get(i17);
            ph phVar3 = new ph();
            if (bArr2 != null && bArr2.length > 0) {
                phVar3.a(bArr2);
            }
            aiVar.f127310d = phVar3;
        }
        return 0;
    }
}

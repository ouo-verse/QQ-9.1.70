package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class zh extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public ph f129162d;

    /* renamed from: e, reason: collision with root package name */
    public String f129163e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f129164f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public int f129165g;

    /* renamed from: h, reason: collision with root package name */
    public int f129166h;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            ph phVar = this.f129162d;
            if (phVar != null) {
                aVar.c(1, phVar.a());
                this.f129162d.a(aVar);
            }
            String str = this.f129163e;
            if (str != null) {
                aVar.a(2, str);
            }
            aVar.a(3, 2, this.f129164f);
            aVar.b(4, this.f129165g);
            aVar.b(5, this.f129166h);
            return 0;
        }
        if (i3 == 1) {
            ph phVar2 = this.f129162d;
            if (phVar2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, phVar2.a());
            }
            String str2 = this.f129163e;
            if (str2 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, 2, this.f129164f) + com.tencent.luggage.wxa.gr.a.b(4, this.f129165g) + com.tencent.luggage.wxa.gr.a.b(5, this.f129166h);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f129164f.clear();
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
        zh zhVar = (zh) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        zhVar.f129166h = aVar3.f(intValue);
                        return 0;
                    }
                    zhVar.f129165g = aVar3.f(intValue);
                    return 0;
                }
                zhVar.f129164f.add(Integer.valueOf(aVar3.f(intValue)));
                return 0;
            }
            zhVar.f129163e = aVar3.i(intValue);
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
            zhVar.f129162d = phVar3;
        }
        return 0;
    }
}

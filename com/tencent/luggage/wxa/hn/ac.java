package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ac extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127292d;

    /* renamed from: e, reason: collision with root package name */
    public String f127293e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127294f = new LinkedList();

    /* renamed from: g, reason: collision with root package name */
    public int f127295g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127292d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f127293e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.a(3, 1, this.f127294f);
            aVar.b(4, this.f127295g);
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f127292d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            String str4 = this.f127293e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, 1, this.f127294f) + com.tencent.luggage.wxa.gr.a.b(4, this.f127295g);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127294f.clear();
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
        ac acVar = (ac) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    acVar.f127295g = aVar3.f(intValue);
                    return 0;
                }
                acVar.f127294f.add(aVar3.i(intValue));
                return 0;
            }
            acVar.f127293e = aVar3.i(intValue);
            return 0;
        }
        acVar.f127292d = aVar3.i(intValue);
        return 0;
    }
}

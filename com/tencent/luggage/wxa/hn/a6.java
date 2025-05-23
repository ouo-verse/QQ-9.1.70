package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a6 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127278d;

    /* renamed from: e, reason: collision with root package name */
    public int f127279e;

    /* renamed from: f, reason: collision with root package name */
    public String f127280f;

    /* renamed from: g, reason: collision with root package name */
    public LinkedList f127281g = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127278d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f127279e);
            String str2 = this.f127280f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            aVar.a(4, 1, this.f127281g);
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f127278d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f127279e);
            String str4 = this.f127280f;
            if (str4 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(3, str4);
            }
            return b16 + com.tencent.luggage.wxa.gr.a.a(4, 1, this.f127281g);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127281g.clear();
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
        a6 a6Var = (a6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    a6Var.f127281g.add(aVar3.i(intValue));
                    return 0;
                }
                a6Var.f127280f = aVar3.i(intValue);
                return 0;
            }
            a6Var.f127279e = aVar3.f(intValue);
            return 0;
        }
        a6Var.f127278d = aVar3.i(intValue);
        return 0;
    }
}

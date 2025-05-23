package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c0 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f127371d;

    /* renamed from: e, reason: collision with root package name */
    public String f127372e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedList f127373f = new LinkedList();

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f127371d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f127372e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.a(3, 8, this.f127373f);
            return 0;
        }
        if (i3 == 1) {
            String str3 = this.f127371d;
            if (str3 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str3);
            }
            String str4 = this.f127372e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.a(3, 8, this.f127373f);
        }
        if (i3 == 2) {
            byte[] bArr = (byte[]) objArr[0];
            this.f127373f.clear();
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
        c0 c0Var = (c0) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    return -1;
                }
                LinkedList h16 = aVar3.h(intValue);
                int size = h16.size();
                for (int i17 = 0; i17 < size; i17++) {
                    byte[] bArr2 = (byte[]) h16.get(i17);
                    b0 b0Var = new b0();
                    if (bArr2 != null && bArr2.length > 0) {
                        b0Var.a(bArr2);
                    }
                    c0Var.f127373f.add(b0Var);
                }
                return 0;
            }
            c0Var.f127372e = aVar3.i(intValue);
            return 0;
        }
        c0Var.f127371d = aVar3.i(intValue);
        return 0;
    }
}

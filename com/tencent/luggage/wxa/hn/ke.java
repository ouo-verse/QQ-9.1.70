package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ke extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128028d;

    /* renamed from: e, reason: collision with root package name */
    public int f128029e;

    /* renamed from: f, reason: collision with root package name */
    public int f128030f;

    /* renamed from: g, reason: collision with root package name */
    public long f128031g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f128032h;

    /* renamed from: i, reason: collision with root package name */
    public String f128033i;

    /* renamed from: j, reason: collision with root package name */
    public ze f128034j;

    /* renamed from: k, reason: collision with root package name */
    public String f128035k;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128028d;
            if (str != null) {
                aVar.a(1, str);
            }
            aVar.b(2, this.f128029e);
            aVar.b(3, this.f128030f);
            aVar.a(4, this.f128031g);
            aVar.a(5, this.f128032h);
            String str2 = this.f128033i;
            if (str2 != null) {
                aVar.a(6, str2);
            }
            ze zeVar = this.f128034j;
            if (zeVar != null) {
                aVar.c(10, zeVar.a());
                this.f128034j.a(aVar);
            }
            String str3 = this.f128035k;
            if (str3 != null) {
                aVar.a(11, str3);
            }
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f128028d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(2, this.f128029e) + com.tencent.luggage.wxa.gr.a.b(3, this.f128030f) + com.tencent.luggage.wxa.gr.a.a(4, this.f128031g) + com.tencent.luggage.wxa.gr.a.a(5, this.f128032h);
            String str5 = this.f128033i;
            if (str5 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(6, str5);
            }
            ze zeVar2 = this.f128034j;
            if (zeVar2 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.c(10, zeVar2.a());
            }
            String str6 = this.f128035k;
            if (str6 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(11, str6);
            }
            return b16;
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
        ke keVar = (ke) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 10) {
            if (intValue != 11) {
                switch (intValue) {
                    case 1:
                        keVar.f128028d = aVar3.i(intValue);
                        return 0;
                    case 2:
                        keVar.f128029e = aVar3.f(intValue);
                        return 0;
                    case 3:
                        keVar.f128030f = aVar3.f(intValue);
                        return 0;
                    case 4:
                        keVar.f128031g = aVar3.g(intValue);
                        return 0;
                    case 5:
                        keVar.f128032h = aVar3.a(intValue);
                        return 0;
                    case 6:
                        keVar.f128033i = aVar3.i(intValue);
                        return 0;
                    default:
                        return -1;
                }
            }
            keVar.f128035k = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            ze zeVar3 = new ze();
            if (bArr != null && bArr.length > 0) {
                zeVar3.a(bArr);
            }
            keVar.f128034j = zeVar3;
        }
        return 0;
    }
}

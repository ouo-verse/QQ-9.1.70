package com.tencent.luggage.wxa.hn;

import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class of extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f128375e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            g0 g0Var = this.f128671d;
            if (g0Var != null) {
                aVar.c(1, g0Var.a());
                this.f128671d.a(aVar);
            }
            String str = this.f128375e;
            if (str != null) {
                aVar.a(2, str);
            }
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str2 = this.f128375e;
            if (str2 != null) {
                return i16 + com.tencent.luggage.wxa.gr.a.a(2, str2);
            }
            return i16;
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
        of ofVar = (of) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            ofVar.f128375e = aVar3.i(intValue);
            return 0;
        }
        LinkedList h16 = aVar3.h(intValue);
        int size = h16.size();
        for (int i17 = 0; i17 < size; i17++) {
            byte[] bArr = (byte[]) h16.get(i17);
            g0 g0Var3 = new g0();
            if (bArr != null && bArr.length > 0) {
                g0Var3.a(bArr);
            }
            ofVar.f128671d = g0Var3;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "BaseRequest", this.f128671d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "appid", this.f128375e, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

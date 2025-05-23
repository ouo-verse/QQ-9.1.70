package com.tencent.luggage.wxa.hn;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v6 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128893d;

    /* renamed from: e, reason: collision with root package name */
    public String f128894e;

    /* renamed from: f, reason: collision with root package name */
    public String f128895f;

    /* renamed from: g, reason: collision with root package name */
    public int f128896g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128893d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128894e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128895f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            aVar.b(4, this.f128896g);
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f128893d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            String str5 = this.f128894e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f128895f;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128896g);
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
        v6 v6Var = (v6) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    v6Var.f128896g = aVar3.f(intValue);
                    return 0;
                }
                v6Var.f128895f = aVar3.i(intValue);
                return 0;
            }
            v6Var.f128894e = aVar3.i(intValue);
            return 0;
        }
        v6Var.f128893d = aVar3.i(intValue);
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "appid", this.f128893d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "plugin_appid", this.f128894e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope", this.f128895f, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "state", Integer.valueOf(this.f128896g), false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

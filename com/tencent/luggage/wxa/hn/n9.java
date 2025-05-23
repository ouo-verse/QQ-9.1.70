package com.tencent.luggage.wxa.hn;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class n9 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128271d;

    /* renamed from: e, reason: collision with root package name */
    public String f128272e;

    /* renamed from: f, reason: collision with root package name */
    public int f128273f;

    /* renamed from: g, reason: collision with root package name */
    public String f128274g;

    /* renamed from: h, reason: collision with root package name */
    public String f128275h;

    /* renamed from: i, reason: collision with root package name */
    public String f128276i;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128271d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128272e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            aVar.b(3, this.f128273f);
            String str3 = this.f128274g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            String str4 = this.f128275h;
            if (str4 != null) {
                aVar.a(5, str4);
            }
            String str5 = this.f128276i;
            if (str5 != null) {
                aVar.a(6, str5);
            }
            return 0;
        }
        if (i3 == 1) {
            String str6 = this.f128271d;
            if (str6 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str6);
            }
            String str7 = this.f128272e;
            if (str7 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str7);
            }
            int b16 = i16 + com.tencent.luggage.wxa.gr.a.b(3, this.f128273f);
            String str8 = this.f128274g;
            if (str8 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(4, str8);
            }
            String str9 = this.f128275h;
            if (str9 != null) {
                b16 += com.tencent.luggage.wxa.gr.a.a(5, str9);
            }
            String str10 = this.f128276i;
            if (str10 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(6, str10);
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
        n9 n9Var = (n9) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        switch (intValue) {
            case 1:
                n9Var.f128271d = aVar3.i(intValue);
                return 0;
            case 2:
                n9Var.f128272e = aVar3.i(intValue);
                return 0;
            case 3:
                n9Var.f128273f = aVar3.f(intValue);
                return 0;
            case 4:
                n9Var.f128274g = aVar3.i(intValue);
                return 0;
            case 5:
                n9Var.f128275h = aVar3.i(intValue);
                return 0;
            case 6:
                n9Var.f128276i = aVar3.i(intValue);
                return 0;
            default:
                return -1;
        }
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "scope", this.f128271d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "desc", this.f128272e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "state", Integer.valueOf(this.f128273f), false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "icon_url", this.f128274g, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "dark_mode_icon_url", this.f128275h, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "sub_desc", this.f128276i, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

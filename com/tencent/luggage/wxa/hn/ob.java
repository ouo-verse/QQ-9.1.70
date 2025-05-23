package com.tencent.luggage.wxa.hn;

import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class ob extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public int f128367d;

    /* renamed from: e, reason: collision with root package name */
    public String f128368e;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            aVar.b(1, this.f128367d);
            String str = this.f128368e;
            if (str != null) {
                aVar.a(2, str);
            }
            return 0;
        }
        if (i3 == 1) {
            int b16 = com.tencent.luggage.wxa.gr.a.b(1, this.f128367d) + 0;
            String str2 = this.f128368e;
            if (str2 != null) {
                return b16 + com.tencent.luggage.wxa.gr.a.a(2, str2);
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
        ob obVar = (ob) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                return -1;
            }
            obVar.f128368e = aVar3.i(intValue);
            return 0;
        }
        obVar.f128367d = aVar3.f(intValue);
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "errCode", Integer.valueOf(this.f128367d), false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "errMsg", this.f128368e, false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

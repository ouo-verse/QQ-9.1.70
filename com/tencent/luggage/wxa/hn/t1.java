package com.tencent.luggage.wxa.hn;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class t1 extends com.tencent.luggage.wxa.fn.b {

    /* renamed from: d, reason: collision with root package name */
    public String f128712d;

    /* renamed from: e, reason: collision with root package name */
    public String f128713e;

    /* renamed from: f, reason: collision with root package name */
    public String f128714f;

    /* renamed from: g, reason: collision with root package name */
    public int f128715g;

    @Override // com.tencent.luggage.wxa.fn.b
    public final int a(int i3, Object... objArr) {
        int i16 = 0;
        if (i3 == 0) {
            com.tencent.luggage.wxa.mr.a aVar = (com.tencent.luggage.wxa.mr.a) objArr[0];
            String str = this.f128712d;
            if (str != null) {
                aVar.a(1, str);
            }
            String str2 = this.f128713e;
            if (str2 != null) {
                aVar.a(2, str2);
            }
            String str3 = this.f128714f;
            if (str3 != null) {
                aVar.a(3, str3);
            }
            aVar.b(4, this.f128715g);
            return 0;
        }
        if (i3 == 1) {
            String str4 = this.f128712d;
            if (str4 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.a(1, str4);
            }
            String str5 = this.f128713e;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str5);
            }
            String str6 = this.f128714f;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(4, this.f128715g);
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
        t1 t1Var = (t1) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        return -1;
                    }
                    t1Var.f128715g = aVar3.f(intValue);
                    return 0;
                }
                t1Var.f128714f = aVar3.i(intValue);
                return 0;
            }
            t1Var.f128713e = aVar3.i(intValue);
            return 0;
        }
        t1Var.f128712d = aVar3.i(intValue);
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, WinkDaTongReportConstant.ElementParamKey.MODEL_ID, this.f128712d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, ReportConstant.COSTREPORT_SN, this.f128713e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "name", this.f128714f, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "status", Integer.valueOf(this.f128715g), false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

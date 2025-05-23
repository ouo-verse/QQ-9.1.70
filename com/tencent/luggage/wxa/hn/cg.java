package com.tencent.luggage.wxa.hn;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import java.util.LinkedList;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class cg extends s8 {

    /* renamed from: e, reason: collision with root package name */
    public String f127431e;

    /* renamed from: f, reason: collision with root package name */
    public String f127432f;

    /* renamed from: g, reason: collision with root package name */
    public String f127433g;

    /* renamed from: h, reason: collision with root package name */
    public int f127434h;

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
            String str = this.f127431e;
            if (str != null) {
                aVar.a(2, str);
            }
            String str2 = this.f127432f;
            if (str2 != null) {
                aVar.a(3, str2);
            }
            String str3 = this.f127433g;
            if (str3 != null) {
                aVar.a(4, str3);
            }
            aVar.b(5, this.f127434h);
            return 0;
        }
        if (i3 == 1) {
            g0 g0Var2 = this.f128671d;
            if (g0Var2 != null) {
                i16 = 0 + com.tencent.luggage.wxa.gr.a.c(1, g0Var2.a());
            }
            String str4 = this.f127431e;
            if (str4 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(2, str4);
            }
            String str5 = this.f127432f;
            if (str5 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(3, str5);
            }
            String str6 = this.f127433g;
            if (str6 != null) {
                i16 += com.tencent.luggage.wxa.gr.a.a(4, str6);
            }
            return i16 + com.tencent.luggage.wxa.gr.a.b(5, this.f127434h);
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
        cg cgVar = (cg) objArr[1];
        int intValue = ((Integer) objArr[2]).intValue();
        if (intValue != 1) {
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue != 4) {
                        if (intValue != 5) {
                            return -1;
                        }
                        cgVar.f127434h = aVar3.f(intValue);
                        return 0;
                    }
                    cgVar.f127433g = aVar3.i(intValue);
                    return 0;
                }
                cgVar.f127432f = aVar3.i(intValue);
                return 0;
            }
            cgVar.f127431e = aVar3.i(intValue);
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
            cgVar.f128671d = g0Var3;
        }
        return 0;
    }

    @Override // com.tencent.luggage.wxa.fn.b
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "BaseRequest", this.f128671d, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "appid", this.f127431e, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, WinkDaTongReportConstant.ElementParamKey.MODEL_ID, this.f127432f, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, ReportConstant.COSTREPORT_SN, this.f127433g, false);
            com.tencent.luggage.wxa.yb.b.a(jSONObject, "status", Integer.valueOf(this.f127434h), false);
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}

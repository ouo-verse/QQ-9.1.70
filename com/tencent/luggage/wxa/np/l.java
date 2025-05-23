package com.tencent.luggage.wxa.np;

import com.tencent.biz.lebasearch.Utils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public String f135907a = null;

    /* renamed from: b, reason: collision with root package name */
    public String f135908b = null;

    /* renamed from: c, reason: collision with root package name */
    public long f135909c = -1;

    /* renamed from: d, reason: collision with root package name */
    public String f135910d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f135911e = "";

    /* renamed from: f, reason: collision with root package name */
    public String f135912f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f135913g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f135914h = "";

    /* renamed from: i, reason: collision with root package name */
    public int f135915i = 20;

    /* renamed from: j, reason: collision with root package name */
    public String f135916j = "";

    /* renamed from: k, reason: collision with root package name */
    public String f135917k = "";

    public String a() {
        return this.f135916j;
    }

    public String b() {
        return this.f135917k;
    }

    public final void c(String str) {
        this.f135908b = str;
    }

    public final void d(String str) {
        this.f135912f = str;
    }

    public final void e(String str) {
        this.f135913g = str;
    }

    public final void f(String str) {
        this.f135916j = str;
    }

    public final void g(String str) {
        this.f135907a = str;
    }

    public void h(String str) {
        this.f135917k = str;
    }

    public final void i(String str) {
        this.f135910d = str;
    }

    public final void j(String str) {
        this.f135911e = str;
    }

    public String toString() {
        return "SoterSignatureResult{rawValue='" + this.f135907a + "', fid='" + this.f135908b + "', counter=" + this.f135909c + ", TEEName='" + this.f135910d + "', TEEVersion='" + this.f135911e + "', FpName='" + this.f135912f + "', FpVersion='" + this.f135913g + "', cpuId='" + this.f135914h + "', saltLen=" + this.f135915i + ", jsonValue='" + this.f135916j + "', signature='" + this.f135917k + "'}";
    }

    public static l a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            l lVar = new l();
            lVar.f(str);
            lVar.g(jSONObject.optString("raw"));
            lVar.c(jSONObject.optString(Utils.KEY_BUSINESS_ID));
            lVar.a(jSONObject.optLong("counter"));
            lVar.i(jSONObject.optString("tee_n"));
            lVar.j(jSONObject.optString("tee_v"));
            lVar.d(jSONObject.optString("fp_n"));
            lVar.e(jSONObject.optString("fp_v"));
            lVar.b(jSONObject.optString("cpu_id"));
            lVar.a(jSONObject.optInt("rsa_pss_saltlen", 20));
            return lVar;
        } catch (JSONException e16) {
            e.b("Soter.SoterSignatureResult", "soter: convert from json failed." + e16.toString(), new Object[0]);
            return null;
        }
    }

    public void b(String str) {
        this.f135914h = str;
    }

    public final void a(long j3) {
        this.f135909c = j3;
    }

    public final void a(int i3) {
        this.f135915i = i3;
    }
}

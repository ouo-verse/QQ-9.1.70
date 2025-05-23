package com.huawei.hms.hatool;

import com.tencent.mobileqq.transfile.report.ReportConstant;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class l extends t {

    /* renamed from: b, reason: collision with root package name */
    private String f37159b = "";

    /* renamed from: c, reason: collision with root package name */
    private String f37160c = "";

    /* renamed from: d, reason: collision with root package name */
    private String f37161d = "";

    /* renamed from: e, reason: collision with root package name */
    private String f37162e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f37163f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f37164g;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("androidid", this.f37225a);
        jSONObject.put("oaid", this.f37164g);
        jSONObject.put("uuid", this.f37163f);
        jSONObject.put("upid", this.f37162e);
        jSONObject.put("imei", this.f37159b);
        jSONObject.put(ReportConstant.COSTREPORT_SN, this.f37160c);
        jSONObject.put("udid", this.f37161d);
        return jSONObject;
    }

    public void b(String str) {
        this.f37159b = str;
    }

    public void c(String str) {
        this.f37164g = str;
    }

    public void d(String str) {
        this.f37160c = str;
    }

    public void e(String str) {
        this.f37161d = str;
    }

    public void f(String str) {
        this.f37162e = str;
    }

    public void g(String str) {
        this.f37163f = str;
    }
}

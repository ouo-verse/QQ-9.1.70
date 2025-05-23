package com.huawei.hms.hatool;

import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class y0 extends t0 {

    /* renamed from: f, reason: collision with root package name */
    String f37243f;

    /* renamed from: g, reason: collision with root package name */
    String f37244g;

    /* renamed from: h, reason: collision with root package name */
    private String f37245h;

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("_rom_ver", this.f37245h);
        jSONObject.put("_emui_ver", this.f37226a);
        jSONObject.put("_model", DeviceInfoMonitor.getModel());
        jSONObject.put("_mcc", this.f37243f);
        jSONObject.put("_mnc", this.f37244g);
        jSONObject.put("_package_name", this.f37227b);
        jSONObject.put("_app_ver", this.f37228c);
        jSONObject.put("_lib_ver", "2.2.0.313");
        jSONObject.put("_channel", this.f37229d);
        jSONObject.put("_lib_name", "hianalytics");
        jSONObject.put("_oaid_tracking_flag", this.f37230e);
        return jSONObject;
    }

    public void f(String str) {
        this.f37243f = str;
    }

    public void g(String str) {
        this.f37244g = str;
    }

    public void h(String str) {
        this.f37245h = str;
    }
}

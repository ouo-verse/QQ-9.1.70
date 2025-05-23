package com.huawei.hms.hatool;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f0 extends k0 {

    /* renamed from: g, reason: collision with root package name */
    private String f37102g = "";

    @Override // com.huawei.hms.hatool.o1
    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(ReportDataBuilder.KEY_PROTOCOL_VERSION, "1");
        jSONObject.put("compress_mode", "1");
        jSONObject.put("serviceid", this.f37156d);
        jSONObject.put("appid", this.f37153a);
        jSONObject.put("hmac", this.f37102g);
        jSONObject.put("chifer", this.f37158f);
        jSONObject.put("timestamp", this.f37154b);
        jSONObject.put("servicetag", this.f37155c);
        jSONObject.put("requestid", this.f37157e);
        return jSONObject;
    }

    public void g(String str) {
        this.f37102g = str;
    }
}

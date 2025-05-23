package com.tencent.qqperf.crashdefend.report;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
class f extends b {

    /* renamed from: k, reason: collision with root package name */
    String f363119k;

    /* renamed from: l, reason: collision with root package name */
    String f363120l;

    f() {
        this.f363119k = "unknown";
        this.f363120l = b.f363103h.format(new Date(System.currentTimeMillis()));
    }

    @Override // com.tencent.qqperf.crashdefend.report.b
    protected JSONArray b() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("eventCode", "crash_defender_startup_crash_report");
        jSONObject.put("eventTime", "" + System.currentTimeMillis());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("crashInfo", this.f363119k);
        jSONObject2.put("crashTime", this.f363120l);
        jSONObject2.put("crashUin", this.f363112g);
        jSONObject2.put("appVersion", this.f363106a);
        jSONObject2.put("deviceModel", this.f363107b);
        jSONObject2.put("deviceRom", this.f363109d);
        jSONObject2.put("dID", this.f363108c);
        jSONObject2.put("systemSDK", this.f363110e);
        jSONObject2.put("systemRelease", this.f363111f);
        jSONObject2.put("processKey", b.f363105j);
        jSONObject.put("mapValue", jSONObject2);
        jSONArray.mo162put(jSONObject);
        return jSONArray;
    }

    public f(com.tencent.mobileqq.qqperftool.crash.b bVar) {
        this();
        a();
        if (bVar != null) {
            this.f363119k = bVar.g();
            this.f363120l = b.f363103h.format(new Date(bVar.d()));
        }
    }
}

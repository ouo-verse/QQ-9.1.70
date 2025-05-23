package com.tencent.qqperf.crashdefend.report;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends b {

    /* renamed from: k, reason: collision with root package name */
    private int f363102k;

    public a(int i3) {
        a();
        this.f363102k = i3;
    }

    @Override // com.tencent.qqperf.crashdefend.report.b
    protected JSONArray b() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("eventCode", "crash_defender_exist_report");
        jSONObject.put("eventTime", "" + System.currentTimeMillis());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("existReason", this.f363102k);
        jSONObject2.put("existUin", this.f363112g);
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
}

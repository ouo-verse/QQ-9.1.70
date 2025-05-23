package com.tencent.qqperf.crashdefend.report;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e extends b {

    /* renamed from: k, reason: collision with root package name */
    private int f363117k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f363118l;

    public e(int i3, boolean z16) {
        this.f363117k = 0;
        this.f363118l = false;
        a();
        this.f363117k = i3;
        this.f363118l = z16;
    }

    @Override // com.tencent.qqperf.crashdefend.report.b
    protected JSONArray b() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("eventCode", "safe_mode_fix_success_report");
        jSONObject.put("eventTime", "" + System.currentTimeMillis());
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("lastStartFailedNum", this.f363117k);
        jSONObject2.put("isCrashDefendMod", this.f363118l);
        jSONObject2.put("reportUin", this.f363112g);
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

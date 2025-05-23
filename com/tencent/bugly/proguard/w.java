package com.tencent.bugly.proguard;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class w extends com.tencent.rmonitor.base.config.data.k {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f98578a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f98579b = f98578a;

    @Override // com.tencent.rmonitor.base.config.data.k
    public final String getName() {
        return "crash_report";
    }

    @Override // com.tencent.rmonitor.base.config.h
    public final void parsePluginConfig(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("report_with_json")) {
            this.f98579b = jSONObject.optBoolean("report_with_json", f98578a);
        }
    }
}

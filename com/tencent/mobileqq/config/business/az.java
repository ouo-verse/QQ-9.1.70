package com.tencent.mobileqq.config.business;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class az {

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f202584e;

    /* renamed from: a, reason: collision with root package name */
    private boolean f202580a = false;

    /* renamed from: b, reason: collision with root package name */
    private int f202581b = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f202582c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f202583d = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f202585f = -1;

    /* renamed from: g, reason: collision with root package name */
    private int f202586g = -1;

    /* renamed from: h, reason: collision with root package name */
    private int f202587h = -1;

    public static az h(com.tencent.mobileqq.config.ai[] aiVarArr) {
        az azVar = new az();
        try {
            JSONObject jSONObject = new JSONObject(aiVarArr[0].f202268b);
            azVar.f202580a = jSONObject.optBoolean("isEnableAll");
            azVar.f202581b = jSONObject.optInt("loginDays");
            azVar.f202582c = jSONObject.optInt("stayInMsgtab");
            azVar.f202583d = jSONObject.optInt("openQQCount");
            azVar.f202584e = jSONObject.optJSONObject("sceneConfig");
            azVar.f202585f = jSONObject.optInt("openIntervalDay");
            azVar.f202586g = jSONObject.optInt("openMaxTimes");
            azVar.f202587h = jSONObject.optInt("openAllTimeDay");
        } catch (JSONException e16) {
            QLog.e("QQKouBeiYunYingConfBean", 1, "parse error e=" + e16);
        }
        return azVar;
    }

    public boolean a() {
        return this.f202580a;
    }

    public int b() {
        return this.f202587h;
    }

    public int c() {
        return this.f202585f;
    }

    public int d() {
        return this.f202586g;
    }

    public int e() {
        return this.f202583d;
    }

    public JSONObject f() {
        return this.f202584e;
    }

    public int g() {
        return this.f202582c;
    }
}

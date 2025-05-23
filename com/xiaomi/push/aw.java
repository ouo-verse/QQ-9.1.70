package com.xiaomi.push;

import cooperation.qqcircle.report.QCircleWeakNetReporter;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class aw {

    /* renamed from: a, reason: collision with root package name */
    private int f388213a;

    /* renamed from: b, reason: collision with root package name */
    private long f388214b;

    /* renamed from: c, reason: collision with root package name */
    private long f388215c;

    /* renamed from: d, reason: collision with root package name */
    private String f388216d;

    /* renamed from: e, reason: collision with root package name */
    private long f388217e;

    public aw() {
        this(0, 0L, 0L, null);
    }

    public int a() {
        return this.f388213a;
    }

    public aw b(JSONObject jSONObject) {
        this.f388214b = jSONObject.getLong(QCircleWeakNetReporter.KEY_COST);
        this.f388217e = jSONObject.getLong("size");
        this.f388215c = jSONObject.getLong("ts");
        this.f388213a = jSONObject.getInt("wt");
        this.f388216d = jSONObject.optString("expt");
        return this;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(QCircleWeakNetReporter.KEY_COST, this.f388214b);
        jSONObject.put("size", this.f388217e);
        jSONObject.put("ts", this.f388215c);
        jSONObject.put("wt", this.f388213a);
        jSONObject.put("expt", this.f388216d);
        return jSONObject;
    }

    public aw(int i3, long j3, long j16, Exception exc) {
        this.f388213a = i3;
        this.f388214b = j3;
        this.f388217e = j16;
        this.f388215c = System.currentTimeMillis();
        if (exc != null) {
            this.f388216d = exc.getClass().getSimpleName();
        }
    }
}

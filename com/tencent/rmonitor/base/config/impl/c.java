package com.tencent.rmonitor.base.config.impl;

import com.tencent.bugly.common.constants.SPKey;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    public JSONObject f365344a = null;

    /* renamed from: b, reason: collision with root package name */
    public int f365345b = 0;

    /* renamed from: c, reason: collision with root package name */
    public String f365346c = null;

    /* renamed from: d, reason: collision with root package name */
    public long f365347d = 0;

    /* renamed from: e, reason: collision with root package name */
    public long f365348e = 0;

    /* renamed from: f, reason: collision with root package name */
    public long f365349f = 0;

    public c() {
        b();
    }

    public void a(String str) {
        if (Logger.debug) {
            Logger.f365497g.d("RMonitor_config", str + ", status: " + this.f365345b + ", md5code: " + this.f365346c + ", next_time_in_sec: " + (this.f365347d / 1000) + ", config_latest_update_time_in_sec: " + this.f365348e + ", last_load_config_time_in_ms: " + this.f365349f);
        }
    }

    public void b() {
        this.f365344a = null;
        this.f365345b = 0;
        this.f365346c = null;
        this.f365347d = 0L;
        this.f365348e = 0L;
        this.f365349f = 0L;
    }

    public void c(c cVar) {
        if (cVar == null) {
            return;
        }
        this.f365344a = cVar.f365344a;
        this.f365345b = cVar.f365345b;
        this.f365346c = cVar.f365346c;
        this.f365347d = cVar.f365347d;
        this.f365348e = cVar.f365348e;
        this.f365349f = cVar.f365349f;
    }

    public void d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.f365349f = System.currentTimeMillis();
        this.f365345b = jSONObject.optInt("status");
        this.f365344a = jSONObject.optJSONObject("data");
        this.f365346c = jSONObject.optString("md5code");
        this.f365347d = jSONObject.optLong("next_time_in_sec", 0L) * 1000;
        this.f365348e = jSONObject.optLong(SPKey.KEY_CONFIG_LOAD_TIME, 0L);
        a("apply result from json");
    }
}

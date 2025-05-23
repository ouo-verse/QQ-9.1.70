package com.tencent.rmonitor.base.config.data;

import android.support.annotation.NonNull;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d extends m {
    public long C;
    public long D;
    public long E;
    public long F;
    public long G;
    public long H;
    public long I;

    /* renamed from: m, reason: collision with root package name */
    public long f365311m;

    public d() {
        super(BuglyMonitorName.BATTERY_ELEMENT, false, 1000, 0.5f, 0.0f, 100);
        this.f365311m = 10000L;
        this.C = 30000L;
        this.D = 20L;
        this.E = 10000L;
        this.F = 30000L;
        this.G = 20L;
        this.H = 20L;
        this.I = 20L;
    }

    private void b(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("single_location_duration_in_ms")) {
            this.f365311m = jSONObject.getLong("single_location_duration_in_ms");
        }
        if (jSONObject.has("total_location_duration_in_ms")) {
            this.C = jSONObject.getLong("total_location_duration_in_ms");
        }
        if (jSONObject.has("max_location_open_num")) {
            this.D = jSONObject.getLong("max_location_open_num");
        }
        if (jSONObject.has("single_wakelock_duration_in_ms")) {
            this.E = jSONObject.getLong("single_wakelock_duration_in_ms");
        }
        if (jSONObject.has("total_wakelock_duration_in_ms")) {
            this.F = jSONObject.getLong("total_wakelock_duration_in_ms");
        }
        if (jSONObject.has("max_wakelock_open_num")) {
            this.G = jSONObject.getLong("max_wakelock_open_num");
        }
        if (jSONObject.has("max_alarm_open_num")) {
            this.H = jSONObject.getLong("max_alarm_open_num");
        }
        if (jSONObject.has("max_wakeup_alarm_open_num")) {
            this.I = jSONObject.getLong("max_wakeup_alarm_open_num");
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public d mo105clone() {
        return new d(this);
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.data.k
    public String getName() {
        return BuglyMonitorName.BATTERY_ELEMENT;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            b(jSONObject);
        } catch (Throwable th5) {
            Logger.f365497g.b("BatteryElementPluginConfig", "parsePluginConfig", th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof d) {
            d dVar = (d) mVar;
            this.f365311m = dVar.f365311m;
            this.C = dVar.C;
            this.D = dVar.D;
            this.E = dVar.E;
            this.F = dVar.F;
            this.G = dVar.G;
            this.H = dVar.H;
            this.I = dVar.I;
        }
    }

    public d(d dVar) {
        super(dVar);
        this.f365311m = 10000L;
        this.C = 30000L;
        this.D = 20L;
        this.E = 10000L;
        this.F = 30000L;
        this.G = 20L;
        this.H = 20L;
        this.I = 20L;
        update(dVar);
    }
}

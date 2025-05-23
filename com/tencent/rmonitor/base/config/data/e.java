package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class e extends m {
    public int C;
    public boolean D;
    public boolean E;

    /* renamed from: m, reason: collision with root package name */
    public int f365312m;

    public e() {
        super(BuglyMonitorName.FD_ANALYZE, false, 10, 0.5f, 0.1f, 800);
        this.f365312m = 1;
        this.C = 9;
        this.D = false;
        this.E = false;
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e mo105clone() {
        return new e(this);
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            if (jSONObject.has("fd_monitor_switch")) {
                this.f365312m = jSONObject.getInt("fd_monitor_switch");
            }
            if (jSONObject.has("hprof_strip_switch")) {
                this.C = jSONObject.getInt("hprof_strip_switch");
            }
            if (jSONObject.has("check_leak_in_native")) {
                this.D = jSONObject.getBoolean("check_leak_in_native");
            }
            if (jSONObject.has("use_fd_track_feature")) {
                this.E = jSONObject.getBoolean("use_fd_track_feature");
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config", "parsePluginConfig", th5);
        }
    }

    public String toString() {
        return "FdLeakPluginConfig{threshold=" + this.threshold + ", maxReportNum=" + this.dailyReportLimit + ", eventSampleRatio=" + this.eventSampleRatio + ", fdMonitorSwitch=" + this.f365312m + ", hprofStripSwitch=" + this.C + ", checkLeakInNative=" + this.D + ", useFdTrackFeature=" + this.E + "}";
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof e) {
            e eVar = (e) mVar;
            this.f365312m = eVar.f365312m;
            this.C = eVar.C;
            this.D = eVar.D;
            this.E = eVar.E;
        }
    }

    protected e(e eVar) {
        super(eVar);
        this.f365312m = 1;
        this.C = 9;
        this.D = false;
        this.E = false;
        update(eVar);
    }
}

package com.tencent.rmonitor.base.config.data;

import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f extends m {
    public boolean C;
    private String D;
    public long E;
    public boolean F;

    /* renamed from: m, reason: collision with root package name */
    public boolean f365313m;

    public f(String str) {
        super(str, false, 1000, 0.0f, 200);
        this.f365313m = true;
        this.C = true;
        this.D = null;
        this.E = 3000L;
        this.F = true;
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public f mo105clone() {
        return new f(this);
    }

    public void b(f fVar) {
        boolean z16;
        if (fVar == null) {
            return;
        }
        if (!this.enabled && !fVar.enabled) {
            z16 = false;
        } else {
            z16 = true;
        }
        this.enabled = z16;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            this.D = jSONObject.optString("name");
            if (jSONObject.has("enable_custom_stage")) {
                this.f365313m = jSONObject.optBoolean("enable_custom_stage", true);
            }
            if (jSONObject.has("enable_activity_switch")) {
                this.C = jSONObject.optBoolean("enable_activity_switch", true);
            }
            if (jSONObject.has("report_background_delay")) {
                this.E = Math.max(jSONObject.optLong("report_background_delay", 0L), 0L);
            }
            if (jSONObject.has("report_background")) {
                this.F = jSONObject.optBoolean("report_background", true);
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_config", th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof f) {
            f fVar = (f) mVar;
            this.f365313m = fVar.f365313m;
            this.C = fVar.C;
            this.D = fVar.D;
            this.E = fVar.E;
            this.F = fVar.F;
        }
    }

    protected f(f fVar) {
        super(fVar);
        this.f365313m = true;
        this.C = true;
        this.D = null;
        this.E = 3000L;
        this.F = true;
        update(fVar);
    }
}

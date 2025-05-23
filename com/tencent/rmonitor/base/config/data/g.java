package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class g extends m {
    private boolean C;
    private boolean D;
    private long E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private long J;
    private boolean K;
    public String L;

    /* renamed from: m, reason: collision with root package name */
    private float f365314m;

    public g() {
        super(BuglyMonitorName.LOOPER_STACK, false, 100, 0.1f, 200);
        this.f365314m = 0.0f;
        this.C = true;
        this.D = false;
        this.E = 52L;
        this.F = true;
        this.G = 30;
        this.H = 20L;
        this.I = 3000L;
        this.J = 180000L;
        this.K = true;
        this.L = "msg";
    }

    private void k(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("quick_trace_ratio")) {
            this.f365314m = (float) jSONObject.optDouble("quick_trace_ratio");
        }
        if (jSONObject.has("quick_trace_record")) {
            this.C = jSONObject.optBoolean("quick_trace_record");
        }
        if (jSONObject.has("quick_trace_protect")) {
            this.D = jSONObject.optBoolean("quick_trace_protect");
        }
    }

    private void l(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("enable_validate")) {
            this.F = jSONObject.optBoolean("enable_validate");
        }
        if (jSONObject.has("long_lag_slice_count")) {
            int optInt = jSONObject.optInt("long_lag_slice_count");
            if (optInt <= 0) {
                optInt = 30;
            }
            this.G = optInt;
        }
        if (jSONObject.has("collect_stack_delay_in_ms")) {
            long optLong = jSONObject.optLong("collect_stack_delay_in_ms");
            if (optLong <= 0) {
                optLong = 20;
            }
            this.H = optLong;
        }
        if (jSONObject.has("long_lag_in_ms")) {
            long optLong2 = jSONObject.optLong("long_lag_in_ms");
            if (optLong2 <= 0) {
                optLong2 = 3000;
            }
            this.I = optLong2;
        }
        if (jSONObject.has("lag_max_cost_in_ms")) {
            long optLong3 = jSONObject.optLong("lag_max_cost_in_ms");
            if (optLong3 <= 0) {
                optLong3 = 180000;
            }
            this.J = optLong3;
        }
    }

    public boolean a() {
        return this.D;
    }

    public boolean b() {
        return this.C;
    }

    public boolean c() {
        return this.F;
    }

    public long d() {
        return this.H;
    }

    public long e() {
        return this.J;
    }

    public int f() {
        return this.G;
    }

    public float h() {
        return this.f365314m;
    }

    public boolean i() {
        return this.K;
    }

    public long j() {
        return this.E;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            k(jSONObject);
            if (jSONObject.has("stack_interval_ms")) {
                long optLong = jSONObject.optLong("stack_interval_ms");
                if (optLong < 5) {
                    optLong = 5;
                }
                this.E = optLong;
            }
            l(jSONObject);
            if (jSONObject.has("suspend_before_get_stack")) {
                this.K = jSONObject.optBoolean("suspend_before_get_stack");
            }
            if (jSONObject.has("detect_strategy")) {
                String optString = jSONObject.optString("detect_strategy");
                if ("msg".equals(optString)) {
                    this.L = "msg";
                } else if ("vsync".equals(optString)) {
                    this.L = "vsync";
                }
            }
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_config", "LooperConfigParser, t: " + th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        if (mVar == null) {
            return;
        }
        super.update(mVar);
        if (mVar instanceof g) {
            g gVar = (g) mVar;
            this.f365314m = gVar.f365314m;
            this.D = gVar.D;
            this.C = gVar.C;
            this.E = gVar.E;
            this.F = gVar.F;
            this.G = gVar.G;
            this.H = gVar.H;
            this.I = gVar.I;
            this.J = gVar.J;
            this.K = gVar.K;
            this.L = gVar.L;
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: clone */
    public m mo105clone() {
        return new g(this);
    }

    protected g(g gVar) {
        super(gVar);
        this.f365314m = 0.0f;
        this.C = true;
        this.D = false;
        this.E = 52L;
        this.F = true;
        this.G = 30;
        this.H = 20L;
        this.I = 3000L;
        this.J = 180000L;
        this.K = true;
        this.L = "msg";
        update(gVar);
    }
}

package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class i extends m {
    private boolean C;
    private int D;
    private boolean E;
    private boolean F;

    /* renamed from: m, reason: collision with root package name */
    public int f365316m;

    public i() {
        super(BuglyMonitorName.MEMORY_JAVA_LEAK, false, 10, 0.1f, 0.1f, 0);
        this.f365316m = 9;
        this.C = true;
        this.D = 100;
        this.E = false;
        this.F = true;
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public i mo105clone() {
        return new i(this);
    }

    public int b() {
        return this.D;
    }

    public boolean c() {
        return this.C;
    }

    public boolean d() {
        return this.F;
    }

    public boolean e() {
        if ((this.f365316m & 1) != 0) {
            return true;
        }
        return false;
    }

    public boolean f() {
        return this.E;
    }

    public void h(boolean z16) {
        this.C = z16;
    }

    public void i(boolean z16) {
        this.F = z16;
    }

    public void j(int i3) {
        this.f365316m = i3;
    }

    public void k(boolean z16) {
        this.E = z16;
    }

    public void l(int i3) {
        this.D = i3;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            if (jSONObject.has("auto_dump")) {
                h(jSONObject.getBoolean("auto_dump"));
            }
            if (jSONObject.has("loop_max_count")) {
                l(jSONObject.getInt("loop_max_count"));
            }
            if (jSONObject.has("keep_uuid_when_leaked")) {
                k(jSONObject.getBoolean("keep_uuid_when_leaked"));
            }
            if (jSONObject.has("enable_fragment_inspect")) {
                i(jSONObject.getBoolean("enable_fragment_inspect"));
            }
            if (jSONObject.has("hprof_strip_switch")) {
                j(jSONObject.getInt("hprof_strip_switch"));
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config", "parsePluginConfig", th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof i) {
            i iVar = (i) mVar;
            this.C = iVar.C;
            this.D = iVar.D;
            this.E = iVar.E;
            this.F = iVar.F;
            this.f365316m = iVar.f365316m;
        }
    }

    protected i(i iVar) {
        super(iVar);
        this.f365316m = 9;
        this.C = true;
        this.D = 100;
        this.E = false;
        this.F = true;
        update(iVar);
    }
}

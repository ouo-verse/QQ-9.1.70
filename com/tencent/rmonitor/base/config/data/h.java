package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class h extends m {
    public int C;
    public int D;

    /* renamed from: m, reason: collision with root package name */
    public int f365315m;

    public h() {
        super(BuglyMonitorName.MEMORY_JAVA_CEILING, false, 5, 0.5f, 90);
        this.f365315m = 9;
        this.C = 3;
        this.D = 5;
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    @NotNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public h mo105clone() {
        return new h(this);
    }

    public boolean b() {
        if ((this.f365315m & 1) != 0) {
            return true;
        }
        return false;
    }

    public void c(int i3) {
        this.f365315m = i3;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            if (jSONObject.has("hprof_strip_switch")) {
                c(jSONObject.getInt("hprof_strip_switch"));
            }
            if (jSONObject.has("max_check_count")) {
                this.C = jSONObject.optInt("max_check_count", 3);
            }
            if (jSONObject.has("max_gc_count")) {
                this.D = jSONObject.optInt("max_gc_count", 5);
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config", "parsePluginConfig", th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof h) {
            h hVar = (h) mVar;
            this.f365315m = hVar.f365315m;
            this.C = hVar.C;
            this.D = hVar.D;
        }
    }

    protected h(h hVar) {
        super(hVar);
        this.f365315m = 9;
        this.C = 3;
        this.D = 5;
        update(hVar);
    }
}

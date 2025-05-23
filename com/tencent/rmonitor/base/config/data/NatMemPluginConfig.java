package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class NatMemPluginConfig extends m {
    private int C;
    private int D;
    private int E;
    private int F;
    private long G;
    private long H;
    private boolean I;
    private boolean J;
    private List<String> K;
    private List<String> L;
    private List<String> M;

    /* renamed from: m, reason: collision with root package name */
    private boolean f365307m;

    public NatMemPluginConfig() {
        super(BuglyMonitorName.NATIVE_MEMORY_ANALYZE, false, 10, 0.5f, 0.1f, 0);
        this.f365307m = false;
        this.C = 50;
        this.D = 100;
        this.E = 4096;
        this.F = 4096;
        this.G = 1073741824L;
        this.H = 1099511627776L;
        this.I = true;
        this.J = false;
        this.K = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.NatMemPluginConfig.1
            {
                add("/data/.*.so$");
            }
        };
        this.L = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.NatMemPluginConfig.2
            {
                add("[^/data/].*.so$");
            }
        };
        this.M = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.NatMemPluginConfig.3
            {
                add(".*/librmonitor_memory.so$");
                add(".*/librmonitor_base.so$");
                add(".*/libBugly_Native.so$");
                add(".*/libbuglybacktrace.so$");
            }
        };
        this.E = 8192;
        this.F = 8192;
        this.C = 100;
        this.f365307m = false;
        this.I = true;
        this.G = 1073741824L;
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public NatMemPluginConfig mo105clone() {
        return new NatMemPluginConfig(this);
    }

    public int b() {
        return this.F;
    }

    public boolean c() {
        return this.I;
    }

    public boolean d() {
        return this.f365307m;
    }

    public List<String> e() {
        return this.M;
    }

    public long f() {
        return this.G;
    }

    public long h() {
        return this.H;
    }

    public List<String> i() {
        return this.K;
    }

    public List<String> j() {
        return this.L;
    }

    public int k() {
        return this.E;
    }

    public int l() {
        return this.C;
    }

    public int m() {
        return this.D;
    }

    public void n(int i3) {
        this.F = i3;
    }

    public void o(boolean z16) {
        this.I = z16;
    }

    public void p(boolean z16) {
        this.f365307m = z16;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            if (jSONObject.has("sys_min_size")) {
                s(jSONObject.getInt("sys_min_size"));
            }
            if (jSONObject.has("app_min_size")) {
                n(jSONObject.getInt("app_min_size"));
            }
            if (jSONObject.has("sys_sample_factor")) {
                t(jSONObject.getInt("sys_sample_factor"));
            }
            if (jSONObject.has("enable_sys_hook")) {
                p(jSONObject.getBoolean("enable_sys_hook"));
            }
            if (jSONObject.has("max_physical_pss")) {
                r(jSONObject.getLong("max_physical_pss"));
            }
            if (jSONObject.has("enable_libc_hook")) {
                o(jSONObject.getBoolean("enable_libc_hook"));
            }
            if (jSONObject.has("max_history_mem_size")) {
                q(jSONObject.getInt("max_history_mem_size"));
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("RMonitor_config", "parsePluginConfig", th5);
        }
    }

    public void q(int i3) {
        if (i3 > 0) {
            l14.f.f413659y = i3;
        }
    }

    public void r(long j3) {
        this.G = j3;
    }

    public void s(int i3) {
        this.E = i3;
    }

    public void t(int i3) {
        this.C = i3;
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof NatMemPluginConfig) {
            NatMemPluginConfig natMemPluginConfig = (NatMemPluginConfig) mVar;
            this.E = natMemPluginConfig.E;
            this.F = natMemPluginConfig.F;
            this.C = natMemPluginConfig.C;
            this.f365307m = natMemPluginConfig.f365307m;
            this.G = natMemPluginConfig.G;
            this.K = natMemPluginConfig.K;
            this.L = natMemPluginConfig.L;
            this.M = natMemPluginConfig.M;
            this.I = natMemPluginConfig.I;
            this.J = natMemPluginConfig.J;
        }
    }

    protected NatMemPluginConfig(NatMemPluginConfig natMemPluginConfig) {
        super(natMemPluginConfig);
        this.f365307m = false;
        this.C = 50;
        this.D = 100;
        this.E = 4096;
        this.F = 4096;
        this.G = 1073741824L;
        this.H = 1099511627776L;
        this.I = true;
        this.J = false;
        this.K = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.NatMemPluginConfig.1
            {
                add("/data/.*.so$");
            }
        };
        this.L = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.NatMemPluginConfig.2
            {
                add("[^/data/].*.so$");
            }
        };
        this.M = new ArrayList<String>() { // from class: com.tencent.rmonitor.base.config.data.NatMemPluginConfig.3
            {
                add(".*/librmonitor_memory.so$");
                add(".*/librmonitor_base.so$");
                add(".*/libBugly_Native.so$");
                add(".*/libbuglybacktrace.so$");
            }
        };
        update(natMemPluginConfig);
    }
}

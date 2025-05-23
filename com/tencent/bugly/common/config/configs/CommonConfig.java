package com.tencent.bugly.common.config.configs;

import com.tencent.rmonitor.base.config.data.m;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CommonConfig extends m {
    public static final String ENABLE_GC_INFO = "enable_gc_info";
    public static final String ENABLE_OOM_HPROF = "enable_oom_hprof";
    public static final String NAME = "common";
    public static final String SUSPEND_THREAD_FEATURE = "suspend_thread_feature";
    private boolean enableGcInfo;
    private boolean enableOOMHprof;
    private boolean enableThreadSuspend;

    public CommonConfig(String str) {
        super(str);
        this.enableThreadSuspend = false;
        this.enableOOMHprof = false;
        this.enableGcInfo = false;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.data.k
    public String getName() {
        return "common";
    }

    public boolean isEnableGcInfo() {
        return this.enableGcInfo;
    }

    public boolean isEnableOOMHprof() {
        return this.enableOOMHprof;
    }

    public boolean isEnableThreadSuspend() {
        return this.enableThreadSuspend;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject.has(SUSPEND_THREAD_FEATURE)) {
            this.enableThreadSuspend = jSONObject.optBoolean(SUSPEND_THREAD_FEATURE, false);
        }
        if (jSONObject.has(ENABLE_OOM_HPROF)) {
            this.enableOOMHprof = jSONObject.optBoolean(ENABLE_OOM_HPROF, false);
        }
        if (jSONObject.has(ENABLE_GC_INFO)) {
            this.enableGcInfo = jSONObject.optBoolean(ENABLE_GC_INFO, false);
        }
    }
}

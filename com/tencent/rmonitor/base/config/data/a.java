package com.tencent.rmonitor.base.config.data;

import android.support.annotation.RestrictTo;
import com.tencent.bugly.common.utils.ProcessUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class a extends m {

    /* renamed from: m, reason: collision with root package name */
    private boolean f365309m;

    public a() {
        super(BuglyMonitorName.LAUNCH, false, 100, 1.0f);
        this.f365309m = false;
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mo105clone() {
        return new a(this);
    }

    public boolean b() {
        return this.f365309m;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public void parsePluginConfig(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        super.parsePluginConfig(jSONObject);
        try {
            if (jSONObject.has("enable_protect")) {
                this.f365309m = jSONObject.getBoolean("enable_protect");
            }
        } catch (Throwable th5) {
            Logger.f365497g.e("RMonitor_config", "AppLaunchPluginConfig, parseLaunchConfigInfo, t: " + th5);
        }
        if (ProcessUtil.isMainProcess(BaseInfo.app)) {
            new b().a(this);
        }
    }

    @Override // com.tencent.rmonitor.base.config.data.m
    public void update(m mVar) {
        super.update(mVar);
        if (mVar instanceof a) {
            this.f365309m = ((a) mVar).f365309m;
        }
    }

    protected a(a aVar) {
        super(aVar);
        this.f365309m = false;
        update(aVar);
    }
}

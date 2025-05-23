package com.tencent.rmonitor.base.config.impl;

import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.rmonitor.base.config.IConfigLoader;
import com.tencent.rmonitor.base.config.data.l;
import com.tencent.rmonitor.common.logger.Logger;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g implements IConfigLoader {

    /* renamed from: e, reason: collision with root package name */
    private UserMeta f365357e;

    /* renamed from: c, reason: collision with root package name */
    private final b f365355c = new b();

    /* renamed from: d, reason: collision with root package name */
    private IConfigApply f365356d = null;

    /* renamed from: a, reason: collision with root package name */
    private final i f365353a = new f();

    /* renamed from: b, reason: collision with root package name */
    private final h f365354b = new e();

    private boolean b(a aVar, IConfigLoader.LoadReason loadReason) {
        if (loadReason == IConfigLoader.LoadReason.CONFIG_CHANGE || aVar == null || aVar.c(this.f365355c)) {
            return true;
        }
        c b16 = aVar.b();
        if (Math.abs(System.currentTimeMillis() - b16.f365349f) >= b16.f365347d) {
            return true;
        }
        return false;
    }

    private IConfigApply c() {
        if (this.f365356d == null) {
            try {
                this.f365356d = new d(new URL(this.f365355c.f365332a));
            } catch (Throwable th5) {
                Logger.f365497g.c("RMonitor_config_Loader", th5);
            }
        }
        return this.f365356d;
    }

    @Nullable
    private JSONObject e(IConfigApply iConfigApply, a aVar) {
        String str;
        JSONObject jSONObject;
        Logger.f365497g.d("RMonitor_config_Loader", "load config from server.");
        b bVar = this.f365355c;
        if (aVar == null) {
            str = "";
        } else {
            str = aVar.b().f365346c;
        }
        bVar.f365333b = str;
        iConfigApply.f(this.f365355c);
        int loadConfigs = iConfigApply.loadConfigs();
        c e16 = iConfigApply.e();
        boolean z16 = true;
        if (loadConfigs == 1) {
            jSONObject = e16.f365344a;
        } else if (aVar == null) {
            jSONObject = null;
        } else {
            jSONObject = aVar.b().f365344a;
        }
        if (loadConfigs != 3) {
            if (loadConfigs != 1) {
                z16 = false;
            }
            this.f365353a.b(new a(this.f365355c, e16, z16));
        }
        return jSONObject;
    }

    @Override // com.tencent.rmonitor.base.config.IConfigLoader
    public void a(@NotNull l lVar, IConfigLoader.LoadReason loadReason) {
        JSONObject jSONObject;
        this.f365355c.c(this.f365357e);
        IConfigApply c16 = c();
        a a16 = this.f365353a.a();
        if (c16 != null && b(a16, loadReason)) {
            jSONObject = e(c16, a16);
        } else {
            if (a16 == null) {
                jSONObject = null;
            } else {
                jSONObject = a16.b().f365344a;
            }
            Logger.f365497g.i("RMonitor_config_Loader", "load config from cache.");
        }
        if (jSONObject != null) {
            this.f365354b.a(jSONObject, lVar);
        }
        lVar.a("loadConfig");
    }

    public void d(@NotNull l lVar) {
        JSONObject jSONObject;
        try {
            a a16 = this.f365353a.a();
            if (a16 == null) {
                jSONObject = null;
            } else {
                jSONObject = a16.b().f365344a;
            }
            if (jSONObject != null) {
                this.f365354b.a(jSONObject, lVar);
            }
            Logger.f365497g.d("RMonitor_config_Loader", "load config from local.");
        } catch (Throwable unused) {
            Logger.f365497g.e("RMonitor_config_Loader", "load config from local fail.");
        }
    }

    public void f(String str) {
        this.f365355c.f365332a = str;
    }

    public void g(UserMeta userMeta) {
        this.f365357e = userMeta;
    }
}

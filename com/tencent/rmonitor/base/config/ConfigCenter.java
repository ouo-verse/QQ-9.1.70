package com.tencent.rmonitor.base.config;

import android.support.annotation.RestrictTo;
import android.text.TextUtils;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.IConfigLoader;
import com.tencent.rmonitor.base.config.data.k;
import com.tencent.rmonitor.base.config.data.l;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.config.data.n;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.CrashProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes25.dex */
public class ConfigCenter implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Set<g> f365256a = new CopyOnWriteArraySet();

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<String, Boolean> f365257b = new HashMap<>(3);

    /* renamed from: d, reason: collision with root package name */
    private IConfigLoader f365259d = null;

    /* renamed from: e, reason: collision with root package name */
    private boolean f365260e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f365261f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f365262g = false;

    /* renamed from: c, reason: collision with root package name */
    private final CopyOnWriteArraySet<f> f365258c = new CopyOnWriteArraySet<>();

    public ConfigCenter() {
        m();
    }

    private void f() {
        Logger.f365497g.d("RMonitor_config", "apply config");
        for (String str : h04.a.f404030a) {
            m h16 = ConfigFetcher.g().h(str);
            w(h16, str);
            d j3 = j(str);
            if (h16 != null && j3 != null) {
                j3.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String = h16;
            }
        }
        k d16 = ConfigFetcher.g().d("safe_mode");
        if (d16 instanceof n) {
            CrashProtector.g(((n) d16).f365321m);
        }
        k d17 = ConfigFetcher.g().d(k.ATTA_CONFIG_KEY);
        if (d17 instanceof com.tencent.rmonitor.sla.a) {
            com.tencent.rmonitor.sla.e.b().d((com.tencent.rmonitor.sla.a) d17);
        }
    }

    private d j(String str) {
        for (d dVar : PluginCombination.INSTANCE.b()) {
            if (TextUtils.equals(str, dVar.pluginName)) {
                return dVar;
            }
        }
        return null;
    }

    private boolean l() {
        return this.f365261f;
    }

    private void m() {
        this.f365257b.put("JVM_TI_OPEN", Boolean.FALSE);
        this.f365257b.put("CONFIG_USE_V7", Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.f365260e) {
            return;
        }
        this.f365260e = true;
        PluginController.f365404b.c();
        ConfigFetcher g16 = ConfigFetcher.g();
        IConfigLoader iConfigLoader = this.f365259d;
        if (iConfigLoader != null) {
            g16.o(iConfigLoader);
        } else {
            g16.p(BaseInfo.getConfigUrl("v7"));
            g16.q(BaseInfo.userMeta);
        }
        g16.i(ThreadManager.getMonitorThreadLooper());
        g16.b(this);
    }

    private boolean p(String str) {
        for (String str2 : h04.a.f404031b) {
            if (TextUtils.equals(str2, str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final IConfigLoader.LoadReason loadReason) {
        Logger.f365497g.i("RMonitor_config", "load config");
        Runnable runnable = new Runnable() { // from class: com.tencent.rmonitor.base.config.ConfigCenter.2
            @Override // java.lang.Runnable
            public void run() {
                ConfigCenter.this.o();
                ConfigFetcher.g().j(loadReason);
            }
        };
        if (ThreadManager.inMonitorThread()) {
            runnable.run();
        } else {
            ThreadManager.runInMonitorThread(runnable, 0L);
        }
    }

    private void r() {
        Logger.f365497g.d("RMonitor_config", "merge list_metric");
        m h16 = ConfigFetcher.g().h(BuglyMonitorName.FLUENCY_METRIC);
        m h17 = ConfigFetcher.g().h("list_metric");
        if ((h17 instanceof com.tencent.rmonitor.base.config.data.f) && (h16 instanceof com.tencent.rmonitor.base.config.data.f)) {
            ((com.tencent.rmonitor.base.config.data.f) h16).b((com.tencent.rmonitor.base.config.data.f) h17);
        }
    }

    private void w(m mVar, String str) {
        try {
            if (l()) {
                for (g gVar : this.f365256a) {
                    if (!p(str)) {
                        gVar.a(mVar);
                    }
                }
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("RMonitor_config", th5);
        }
    }

    @Override // com.tencent.rmonitor.base.config.f
    public void a(l lVar) {
        r();
        f();
        Iterator<f> it = this.f365258c.iterator();
        while (it.hasNext()) {
            it.next().a(lVar);
        }
    }

    public void d(f fVar) {
        if (fVar != null) {
            this.f365258c.add(fVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void e(g gVar) {
        if (gVar != null && l()) {
            this.f365256a.add(gVar);
        }
    }

    public List<String> g(List<String> list) {
        n();
        return ConfigFetcher.g().n(list);
    }

    public k h(String str) {
        return ConfigFetcher.g().d(str);
    }

    public d i(String str) {
        n();
        return j(str);
    }

    public m k(String str) {
        return ConfigFetcher.g().h(str);
    }

    public void n() {
        if (!this.f365262g) {
            Logger.f365497g.i("RMonitor_config", "init config");
            this.f365262g = true;
            f();
            ThreadManager.runInMonitorThread(new Runnable() { // from class: com.tencent.rmonitor.base.config.ConfigCenter.1
                @Override // java.lang.Runnable
                public void run() {
                    ConfigCenter.this.q(IConfigLoader.LoadReason.LAUNCH);
                }
            }, 200L);
        }
    }

    public void s() {
        if (this.f365262g) {
            Logger.f365497g.i("RMonitor_config", "refresh config");
            ConfigFetcher.g().q(BaseInfo.userMeta);
            q(IConfigLoader.LoadReason.APPLY_PARAM_CHANGE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void t(g gVar) {
        if (gVar != null && l()) {
            this.f365256a.remove(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void u(boolean z16) {
        this.f365261f = z16;
    }

    public void v(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            this.f365257b.put(str, Boolean.valueOf(z16));
        }
    }
}

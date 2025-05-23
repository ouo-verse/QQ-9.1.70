package com.tencent.rmonitor.metrics.looper;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.ThreadUtil;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.plugin.monitor.QAPMScenePlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes25.dex */
public class DropFrameMonitor extends QAPMScenePlugin implements a {

    /* renamed from: f, reason: collision with root package name */
    private final MetricMonitor f365743f;

    /* renamed from: i, reason: collision with root package name */
    private f f365745i;

    /* renamed from: m, reason: collision with root package name */
    private LooperMetricReporter f365746m;

    /* renamed from: d, reason: collision with root package name */
    private boolean f365741d = false;

    /* renamed from: e, reason: collision with root package name */
    private final b f365742e = new b(this);

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.rmonitor.base.config.data.f f365744h = null;

    public DropFrameMonitor() {
        this.f365745i = null;
        this.f365746m = null;
        this.f365745i = new f();
        LooperMetricReporter looperMetricReporter = new LooperMetricReporter();
        this.f365746m = looperMetricReporter;
        this.f365743f = new MetricMonitor(this.f365745i, looperMetricReporter);
    }

    private void d() {
        final String h16 = com.tencent.rmonitor.common.lifecycle.a.i().h();
        if (!TextUtils.isEmpty(h16)) {
            ThreadManager.runInMainThread(new Runnable() { // from class: com.tencent.rmonitor.metrics.looper.DropFrameMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    if (DropFrameMonitor.this.isRunning()) {
                        DropFrameMonitor.this.c(h16);
                    } else {
                        DropFrameMonitor.this.a(h16);
                    }
                }
            }, 0L);
        }
    }

    private boolean e() {
        com.tencent.rmonitor.base.config.data.f g16 = g();
        if (g16 != null) {
            return g16.C;
        }
        return true;
    }

    private boolean f() {
        com.tencent.rmonitor.base.config.data.f g16 = g();
        if (g16 != null) {
            return g16.f365313m;
        }
        return true;
    }

    private com.tencent.rmonitor.base.config.data.f g() {
        if (this.f365744h == null) {
            m k3 = ConfigProxy.INSTANCE.getConfig().k(getPluginName());
            if (k3 instanceof com.tencent.rmonitor.base.config.data.f) {
                this.f365744h = (com.tencent.rmonitor.base.config.data.f) k3;
            }
        }
        return this.f365744h;
    }

    @Override // com.tencent.rmonitor.common.lifecycle.c
    public void a(String str) {
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_looper_metric", "endScene, sceneName: ", str);
        }
        if (ThreadUtil.isInMainThread() && f()) {
            this.f365743f.h(str);
        }
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void b(String str) {
        if (e()) {
            this.f365743f.b(str);
        }
    }

    @Override // com.tencent.rmonitor.common.lifecycle.c
    public void c(String str) {
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_looper_metric", "beginScene, sceneName: ", str);
        }
        if (TextUtils.isEmpty(str)) {
            Logger.f365497g.i("RMonitor_looper_metric", "beginScene fail when sceneName is empty.");
            return;
        }
        if (!isRunning()) {
            Logger.f365497g.i("RMonitor_looper_metric", "beginScene fail when not running, sceneName: ", str);
        } else if (ThreadUtil.isInMainThread() && f()) {
            this.f365743f.g(str);
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public String getPluginName() {
        return BuglyMonitorName.FLUENCY_METRIC;
    }

    public void h(g gVar) {
        f fVar = this.f365745i;
        if (fVar != null) {
            fVar.k(gVar);
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public boolean isRunning() {
        return this.f365741d;
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void onBackground() {
        this.f365743f.onBackground();
        LooperMetricReporter looperMetricReporter = this.f365746m;
        if (looperMetricReporter != null) {
            looperMetricReporter.h();
        }
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void onForeground() {
        this.f365743f.onForeground();
        LooperMetricReporter looperMetricReporter = this.f365746m;
        if (looperMetricReporter != null) {
            looperMetricReporter.i();
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (!AndroidVersion.isOverJellyBean()) {
            notifyStartResult(2, getPluginName() + " start fail for build version is lower than jelly bean.");
            return;
        }
        if (this.f365741d) {
            Logger.f365497g.e("RMonitor_looper_metric", getPluginName() + " has start before.");
            return;
        }
        Logger.f365497g.d("RMonitor_looper_metric", getPluginName() + " start");
        this.f365741d = true;
        this.f365742e.b();
        com.tencent.rmonitor.common.lifecycle.a.i().m(this);
        b(com.tencent.rmonitor.common.lifecycle.a.e());
        this.f365743f.n(g());
        this.f365743f.j();
        d();
        notifyStartResult(0, null);
        LooperMetricReporter looperMetricReporter = this.f365746m;
        if (looperMetricReporter != null) {
            looperMetricReporter.l(g());
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        if (!this.f365741d) {
            Logger.f365497g.e("RMonitor_looper_metric", getPluginName() + " not start yet.");
            return;
        }
        Logger.f365497g.d("RMonitor_looper_metric", getPluginName() + " stop");
        this.f365741d = false;
        this.f365742e.c();
        com.tencent.rmonitor.common.lifecycle.a.i().o(this);
        d();
        this.f365743f.l();
        notifyStopResult(0, null);
        LooperMetricReporter looperMetricReporter = this.f365746m;
        if (looperMetricReporter != null) {
            looperMetricReporter.m();
        }
    }
}

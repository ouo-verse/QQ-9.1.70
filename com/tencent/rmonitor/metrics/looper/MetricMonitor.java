package com.tencent.rmonitor.metrics.looper;

import android.text.TextUtils;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MetricMonitor implements a {

    /* renamed from: d, reason: collision with root package name */
    private final c f365758d;

    /* renamed from: e, reason: collision with root package name */
    private final f f365759e;

    /* renamed from: f, reason: collision with root package name */
    private long f365760f = 200;

    /* renamed from: h, reason: collision with root package name */
    private String f365761h = null;

    /* renamed from: i, reason: collision with root package name */
    private String f365762i = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f365763m = false;

    /* JADX INFO: Access modifiers changed from: protected */
    public MetricMonitor(f fVar, c cVar) {
        Logger.f365497g.i("RMonitor_looper_metric", "MetricCollectorWrapper init");
        this.f365759e = fVar;
        this.f365758d = cVar;
    }

    private void d() {
        String str = this.f365759e.d().scene;
        String i3 = i();
        if (TextUtils.equals(str, i3)) {
            return;
        }
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_looper_metric", "changeScene, " + str + " --> " + i3);
        }
        e();
    }

    private void e() {
        if (this.f365759e.g()) {
            f(this.f365759e.d());
            this.f365759e.b(i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_looper_metric", "startCollect, isStart: " + this.f365759e.g() + ", isForeground: " + LifecycleCallback.G.m());
        }
        if (!this.f365759e.g() && LifecycleCallback.G.m()) {
            this.f365759e.l(i(), this.f365760f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (Logger.verbos) {
            Logger.f365497g.v("RMonitor_looper_metric", "stopCollect, isStart: " + this.f365759e.g() + ", isForeground: " + LifecycleCallback.G.m());
        }
        if (this.f365759e.g()) {
            f(this.f365759e.d());
            this.f365759e.m();
        }
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void b(String str) {
        this.f365761h = str;
        d();
    }

    protected void f(DropFrameResultMeta dropFrameResultMeta) {
        if (dropFrameResultMeta.totalDuration <= 0) {
            return;
        }
        DropFrameResultMeta dropFrameResultMeta2 = new DropFrameResultMeta();
        dropFrameResultMeta2.copyFrom(dropFrameResultMeta);
        this.f365758d.a(dropFrameResultMeta2);
    }

    public void g(String str) {
        if (!TextUtils.equals(this.f365762i, str)) {
            this.f365762i = str;
            d();
        }
    }

    public void h(String str) {
        if (TextUtils.equals(this.f365762i, str)) {
            this.f365762i = null;
            d();
        }
    }

    public String i() {
        String str = this.f365762i;
        if (TextUtils.isEmpty(str)) {
            str = this.f365761h;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public synchronized void j() {
        if (!this.f365763m) {
            this.f365763m = true;
            ThreadManager.runInMainThread(new Runnable() { // from class: com.tencent.rmonitor.metrics.looper.MetricMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    MetricMonitor.this.k();
                }
            }, 0L);
        }
    }

    public synchronized void l() {
        if (this.f365763m) {
            this.f365763m = false;
            ThreadManager.runInMainThread(new Runnable() { // from class: com.tencent.rmonitor.metrics.looper.MetricMonitor.2
                @Override // java.lang.Runnable
                public void run() {
                    MetricMonitor.this.m();
                }
            }, 0L);
        }
    }

    public void n(com.tencent.rmonitor.base.config.data.f fVar) {
        if (fVar != null) {
            this.f365760f = fVar.threshold;
        }
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void onBackground() {
        if (this.f365759e.g()) {
            this.f365759e.i();
        }
        e();
    }

    @Override // com.tencent.rmonitor.metrics.looper.a
    public void onForeground() {
        if (this.f365759e.g()) {
            this.f365759e.j();
        } else {
            k();
        }
    }
}

package com.tencent.rmonitor.looper;

import com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes25.dex */
public class WorkThreadMonitor extends RMonitorPlugin {

    /* renamed from: e, reason: collision with root package name */
    protected static WeakReference<WorkThreadMonitor> f365656e;

    /* renamed from: d, reason: collision with root package name */
    private boolean f365657d = false;

    public WorkThreadMonitor() {
        f365656e = new WeakReference<>(this);
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public String getPluginName() {
        return "work_thread_lag";
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public boolean isRunning() {
        return this.f365657d;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (!a.f365658a.b("work_thread_lag")) {
            this.f365657d = false;
            notifyStartResult(1, "can not collect");
            Logger.f365497g.i("RMonitor_looper_WorkThread", "start, can not collect");
        } else {
            this.f365657d = true;
            Logger.f365497g.i("RMonitor_looper_WorkThread", "start");
            notifyStartResult(0, null);
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        this.f365657d = false;
        Logger.f365497g.i("RMonitor_looper_WorkThread", "stop");
        notifyStopResult(0, null);
    }
}

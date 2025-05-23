package com.tencent.rmonitor.metrics;

import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import l14.d;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MemoryQuantileMonitor extends QAPMMonitorPlugin {

    /* renamed from: d, reason: collision with root package name */
    private static boolean f365740d = false;

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (!f365740d) {
            f365740d = true;
            ReporterMachine.f365411g.k(new Runnable() { // from class: com.tencent.rmonitor.metrics.MemoryQuantileMonitor.1
                @Override // java.lang.Runnable
                public void run() {
                    d.a().d();
                }
            });
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
    }
}

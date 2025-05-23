package com.tencent.rmonitor.memory.leakdetect;

import android.os.Handler;
import com.tencent.bugly.common.heapdump.DumpEnableChecker;
import com.tencent.bugly.common.heapdump.ForkJvmHeapDumper;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.DebugInterfaceProxy;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.plugin.listener.IMemoryLeakListener;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class MemoryLeakMonitor extends QAPMMonitorPlugin {

    /* renamed from: d, reason: collision with root package name */
    private MemoryLeakInspector f365737d;

    /* renamed from: e, reason: collision with root package name */
    private i14.a f365738e;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final MemoryLeakMonitor f365739a = new MemoryLeakMonitor();
    }

    private i14.a d(MemoryLeakInspector memoryLeakInspector) {
        return new i14.a(memoryLeakInspector);
    }

    public static MemoryLeakMonitor getInstance() {
        return b.f365739a;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public synchronized void start() {
        if (!DumpEnableChecker.isForkDumpVersionPermitted() && !DebugInterfaceProxy.a()) {
            Logger.f365497g.i("RMonitor_MemoryLeak", "don't support fork dumper");
            return;
        }
        if (b14.a.a() instanceof ForkJvmHeapDumper) {
            if (this.f365737d == null) {
                Handler handler = new Handler(ThreadManager.getMonitorThreadLooper());
                IMemoryLeakListener b16 = i04.a.memoryLeakListener.b();
                if (b16 == null) {
                    b16 = new h14.a();
                }
                MemoryLeakInspector memoryLeakInspector = new MemoryLeakInspector(handler, b16);
                this.f365737d = memoryLeakInspector;
                this.f365738e = d(memoryLeakInspector);
            }
            this.f365738e.a();
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.MEMORY_JAVA_LEAK));
        } else {
            Logger.f365497g.i("RMonitor_MemoryLeak", "has not valid dumper, start failed");
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        if (b14.a.a() instanceof ForkJvmHeapDumper) {
            MemoryLeakInspector memoryLeakInspector = this.f365737d;
            if (memoryLeakInspector != null) {
                memoryLeakInspector.n();
            }
            i14.a aVar = this.f365738e;
            if (aVar != null) {
                aVar.b();
            }
            RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.MEMORY_JAVA_LEAK));
        }
    }

    MemoryLeakMonitor() {
    }
}

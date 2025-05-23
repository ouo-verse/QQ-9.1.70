package com.tencent.bugly.impl;

import android.text.TextUtils;
import com.tencent.bugly.battery.plugins.BatteryElementMetricPlugin;
import com.tencent.bugly.battery.plugins.BatteryElementPlugin;
import com.tencent.bugly.battery.plugins.BatteryMetricPlugin;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.bugly.network.NetQualityMonitor;
import com.tencent.bugly.traffic.TrafficDetailPlugin;
import com.tencent.bugly.traffic.TrafficPlugin;
import com.tencent.rmonitor.asan.AddressSanitizer;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.bigbitmap.BigBitmapMonitor;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.fd.FdLeakMonitor;
import com.tencent.rmonitor.looper.LooperMonitor;
import com.tencent.rmonitor.looper.WorkThreadMonitor;
import com.tencent.rmonitor.manager.d;
import com.tencent.rmonitor.memory.ceil.MemoryCeilingMonitor;
import com.tencent.rmonitor.memory.leakdetect.MemoryLeakMonitor;
import com.tencent.rmonitor.metrics.MemoryQuantileMonitor;
import com.tencent.rmonitor.metrics.looper.DropFrameMonitor;
import com.tencent.rmonitor.natmem.NatMemMonitor;
import com.tencent.rmonitor.pagelaunch.PageLaunchPlugin;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class PluginFactoryImpl implements d {
    private static final String TAG = "RMonitor_init";

    private QAPMMonitorPlugin createLooperPlugin(String str) {
        if (BuglyMonitorName.LOOPER_STACK.equals(str)) {
            return new LooperMonitor();
        }
        if ("work_thread_lag".equals(str)) {
            return new WorkThreadMonitor();
        }
        return null;
    }

    private QAPMMonitorPlugin createMemoryPlugin(String str) {
        if (BuglyMonitorName.MEMORY_JAVA_LEAK.equals(str)) {
            return MemoryLeakMonitor.getInstance();
        }
        if (BuglyMonitorName.MEMORY_BIG_BITMAP.equals(str)) {
            return BigBitmapMonitor.getInstance();
        }
        if (BuglyMonitorName.FD_ANALYZE.equals(str)) {
            return FdLeakMonitor.getInstance();
        }
        if (BuglyMonitorName.NATIVE_MEMORY_ANALYZE.equals(str)) {
            return NatMemMonitor.getInstance();
        }
        if (BuglyMonitorName.MEMORY_JAVA_CEILING.equals(str)) {
            return MemoryCeilingMonitor.getInstance();
        }
        if (BuglyMonitorName.ASAN.equals(str)) {
            return AddressSanitizer.getInstance();
        }
        return null;
    }

    private QAPMMonitorPlugin createMetricPlugin(String str) {
        if (BuglyMonitorName.FLUENCY_METRIC.equals(str)) {
            return new DropFrameMonitor();
        }
        if (BuglyMonitorName.MEMORY_METRIC.equals(str)) {
            return new MemoryQuantileMonitor();
        }
        if (BuglyMonitorName.MEMORY_METRIC_OF_SUB_PROCESS.equals(str)) {
            return new MemoryQuantileMonitor();
        }
        return null;
    }

    private QAPMMonitorPlugin createPageLaunchPlugin(String str) {
        if (BuglyMonitorName.PAGE_LAUNCH.equals(str)) {
            return new PageLaunchPlugin();
        }
        return null;
    }

    private QAPMMonitorPlugin createResourcePlugin(String str) {
        if (BuglyMonitorName.TRAFFIC.equals(str)) {
            return new TrafficPlugin();
        }
        if (BuglyMonitorName.TRAFFIC_DETAIL.equals(str)) {
            return new TrafficDetailPlugin();
        }
        if (BuglyMonitorName.NET_QUALITY.equals(str)) {
            return new NetQualityMonitor();
        }
        if (BuglyMonitorName.BATTERY_ELEMENT.equals(str)) {
            return new BatteryElementPlugin();
        }
        if (BuglyMonitorName.BATTERY_ELEMENT_METRIC.equals(str)) {
            return new BatteryElementMetricPlugin();
        }
        if (BuglyMonitorName.BATTERY_METRIC.equals(str)) {
            return new BatteryMetricPlugin();
        }
        return null;
    }

    @Override // com.tencent.rmonitor.manager.d
    public QAPMMonitorPlugin createPlugin(com.tencent.rmonitor.base.config.d dVar) {
        if (dVar == null) {
            return null;
        }
        String str = dVar.pluginName;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        QAPMMonitorPlugin createMetricPlugin = createMetricPlugin(str);
        if (createMetricPlugin == null) {
            createMetricPlugin = createLooperPlugin(str);
        }
        if (createMetricPlugin == null) {
            createMetricPlugin = createMemoryPlugin(str);
        }
        if (createMetricPlugin == null) {
            createMetricPlugin = createResourcePlugin(str);
        }
        if (createMetricPlugin == null) {
            createMetricPlugin = createPageLaunchPlugin(str);
        }
        if (createMetricPlugin == null) {
            Logger.f365497g.i(TAG, "create plugin fail {" + str + "}");
        }
        return createMetricPlugin;
    }
}

package com.tencent.bugly.battery.plugins;

import com.tencent.bugly.battery.BatteryMetricMonitor;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes5.dex */
public class BatteryMetricPlugin extends QAPMMonitorPlugin {
    private static final String TAG = "BatteryMetricPlugin";
    private final m batteryMetricPlugin = ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.BATTERY_METRIC);

    private boolean isCheckPermitted() {
        if (!PluginController.f365404b.b(BuglyMonitorName.BATTERY_METRIC)) {
            Logger.f365497g.i(TAG, "battery metric report too many times today,  please try again next day");
            return false;
        }
        if (!AndroidVersion.isOverL()) {
            Logger.f365497g.i(TAG, "battery metric report couldn't open below Android L");
            return false;
        }
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (this.batteryMetricPlugin.enabled && isCheckPermitted()) {
            Logger.f365497g.i(TAG, "start battery metric plugin");
            BatteryMetricMonitor.SInstanceHolder.INSTANCE.start();
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.BATTERY_METRIC));
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        Logger.f365497g.i(TAG, "stop battery metric plugin");
        BatteryMetricMonitor.SInstanceHolder.INSTANCE.stop();
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.BATTERY_METRIC));
    }
}

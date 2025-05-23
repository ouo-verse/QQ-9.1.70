package com.tencent.bugly.battery.plugins;

import com.tencent.bugly.battery.BatteryMonitor;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes5.dex */
public class BatteryElementMetricPlugin extends QAPMMonitorPlugin {
    private static final String TAG = "BatteryElementMetricPlugin";
    private final m batteryElementMetricPlugin = ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.BATTERY_ELEMENT_METRIC);

    private boolean isCheckPermitted() {
        if (!PluginController.f365404b.b(BuglyMonitorName.BATTERY_ELEMENT_METRIC)) {
            Logger.f365497g.i(TAG, "battery element metric report too many times today,  please try again next day");
            return false;
        }
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (this.batteryElementMetricPlugin.enabled && isCheckPermitted()) {
            Logger.f365497g.i(TAG, "start battery element metric plugin");
            BatteryMonitor.getInstance().setBatteryElementMetricEnable(true);
            BatteryMonitor.getInstance().start();
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.BATTERY_ELEMENT_METRIC));
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        Logger.f365497g.i(TAG, "stop battery element metric plugin");
        BatteryMonitor.getInstance().setBatteryElementMetricEnable(false);
        BatteryMonitor.getInstance().stop();
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.BATTERY_ELEMENT_METRIC));
    }
}

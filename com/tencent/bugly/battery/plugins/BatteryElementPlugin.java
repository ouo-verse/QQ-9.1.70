package com.tencent.bugly.battery.plugins;

import com.tencent.bugly.battery.BatteryMonitor;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.d;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes5.dex */
public class BatteryElementPlugin extends QAPMMonitorPlugin {
    private static final String TAG = "BatteryElementPlugin";
    private final d batteryElementPluginConfig = (d) ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.BATTERY_ELEMENT);

    private boolean isCheckPermitted() {
        if (!PluginController.f365404b.b(BuglyMonitorName.BATTERY_ELEMENT)) {
            Logger.f365497g.i(TAG, "battery element  report too many times today,  please try again next day");
            return false;
        }
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (this.batteryElementPluginConfig.enabled && isCheckPermitted()) {
            Logger.f365497g.i(TAG, "start battery element plugin");
            BatteryMonitor.getInstance().setBatteryElementEnable(true);
            BatteryMonitor.getInstance().start();
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.BATTERY_ELEMENT));
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        Logger.f365497g.i(TAG, "stop battery element plugin");
        BatteryMonitor.getInstance().setBatteryElementEnable(false);
        BatteryMonitor.getInstance().stop();
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.BATTERY_ELEMENT));
    }
}

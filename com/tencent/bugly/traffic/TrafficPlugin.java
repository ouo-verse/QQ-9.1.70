package com.tencent.bugly.traffic;

import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes5.dex */
public class TrafficPlugin extends QAPMMonitorPlugin {
    private static final String TAG = "TrafficPlugin";
    private final m trafficPluginConfig = ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.TRAFFIC);

    private boolean isCheckPermitted() {
        if (!PluginController.f365404b.b(BuglyMonitorName.TRAFFIC)) {
            Logger.f365497g.i(TAG, "traffic report too many times today,  please try again next day");
            return false;
        }
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (this.trafficPluginConfig.enabled && isCheckPermitted()) {
            Logger.f365497g.i(TAG, "start traffic plugin");
            TrafficMonitor.getInstance().setTrafficEnabled(true);
            TrafficMonitor.getInstance().start();
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.TRAFFIC));
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        Logger.f365497g.i(TAG, "stop traffic plugin");
        TrafficMonitor.getInstance().setTrafficEnabled(false);
        TrafficMonitor.getInstance().stop(true);
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.TRAFFIC));
    }
}

package com.tencent.bugly.traffic;

import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.TrafficDetailPluginConfig;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes5.dex */
public class TrafficDetailPlugin extends QAPMMonitorPlugin {
    private static final String TAG = "TrafficDetailPlugin";
    private final TrafficDetailPluginConfig trafficDetailPluginConfig = (TrafficDetailPluginConfig) ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.TRAFFIC_DETAIL);

    private boolean isCheckPermitted() {
        if (!PluginController.f365404b.b(BuglyMonitorName.TRAFFIC_DETAIL)) {
            Logger.f365497g.i(TAG, "traffic detail report too many times today,  please try again next day");
            return false;
        }
        return true;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (this.trafficDetailPluginConfig.enabled && isCheckPermitted()) {
            Logger.f365497g.i(TAG, "start traffic detail plugin");
            TrafficMonitor.getInstance().setTrafficDetailEnabled(true);
            TrafficMonitor.getInstance().start();
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(BuglyMonitorName.TRAFFIC_DETAIL));
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        Logger.f365497g.i(TAG, "stop traffic detail plugin");
        TrafficMonitor.getInstance().setTrafficDetailEnabled(false);
        TrafficMonitor.getInstance().stop(false);
        RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(BuglyMonitorName.TRAFFIC_DETAIL));
    }
}

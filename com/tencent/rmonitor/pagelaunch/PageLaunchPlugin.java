package com.tencent.rmonitor.pagelaunch;

import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;

/* loaded from: classes25.dex */
public class PageLaunchPlugin extends RMonitorPlugin {

    /* renamed from: d, reason: collision with root package name */
    private boolean f365792d = false;

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public String getPluginName() {
        return BuglyMonitorName.PAGE_LAUNCH;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public boolean isRunning() {
        return this.f365792d;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        m k3 = ConfigProxy.INSTANCE.getConfig().k(BuglyMonitorName.PAGE_LAUNCH);
        if (k3 == null) {
            Logger.f365497g.i("PageLaunchPlugin", "get config failed");
            return;
        }
        if (!k3.enabled) {
            Logger.f365497g.i("PageLaunchPlugin", "config not enabled, just return");
            return;
        }
        if (!PluginController.f365404b.b(BuglyMonitorName.PAGE_LAUNCH)) {
            Logger.f365497g.i("PageLaunchPlugin", "report num reach the limit, just return");
            return;
        }
        if (!AndroidVersion.isOverJellyBeanMr2()) {
            Logger.f365497g.i("PageLaunchPlugin", "isOverJellyBeanMr2 false, just return");
        } else if (b.b() != null) {
            this.f365792d = true;
            b.b().c();
            notifyStartResult(0, "");
            Logger.f365497g.i("PageLaunchPlugin", "start page launch monitor");
        }
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        if (b.b() != null && this.f365792d) {
            b.b().d();
            this.f365792d = false;
            notifyStopResult(0, "");
            Logger.f365497g.i("PageLaunchPlugin", "stop page launch monitor");
        }
    }
}

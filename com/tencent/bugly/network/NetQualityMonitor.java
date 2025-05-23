package com.tencent.bugly.network;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.d;
import com.tencent.rmonitor.base.config.data.m;
import com.tencent.rmonitor.base.db.e;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.lifecycle.f;
import com.tencent.rmonitor.common.logger.Logger;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class NetQualityMonitor extends RMonitorPlugin {
    private static final String TAG = "RMonitor_net_quality";
    private final Object lock = new Object();
    private boolean isStart = false;
    private HttpReportMetaDealer metaDealer = null;
    private HttpEventListenerFactory factory = null;
    private MyCallback myCallback = null;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static class MyCallback extends f {
        private final HttpReportMetaDealer dealer;

        public MyCallback(HttpReportMetaDealer httpReportMetaDealer) {
            this.dealer = httpReportMetaDealer;
        }

        @Override // com.tencent.rmonitor.common.lifecycle.f, com.tencent.rmonitor.common.lifecycle.b
        public void onBackground() {
            if (this.dealer != null) {
                Logger.f365497g.d(NetQualityMonitor.TAG, "try report or cache data for background.");
                this.dealer.reportOrCacheDataAsync("onBackground");
            }
        }
    }

    @NotNull
    protected NetQualityPluginConfig getConfig() {
        m mVar;
        d pluginConfig = getPluginConfig();
        if (pluginConfig != null) {
            mVar = pluginConfig.com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
        } else {
            mVar = null;
        }
        if (mVar instanceof NetQualityPluginConfig) {
            return (NetQualityPluginConfig) mVar;
        }
        return new NetQualityPluginConfig();
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public String getPluginName() {
        return BuglyMonitorName.NET_QUALITY;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.RMonitorPlugin
    public boolean isRunning() {
        return this.isStart;
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void start() {
        if (this.isStart) {
            return;
        }
        if (!PluginController.f365404b.b(getPluginName())) {
            Logger.f365497g.i(TAG, "can not start plugin for can not collect.");
            return;
        }
        synchronized (this.lock) {
            if (!this.isStart) {
                if (this.metaDealer == null) {
                    this.metaDealer = new HttpReportMetaDealer(getConfig(), new e());
                }
                if (this.factory == null) {
                    this.factory = new HttpEventListenerFactory(this.metaDealer);
                }
                this.factory.start();
                BuglyListenerFactory.getInstance().addFactory(this.factory);
                this.isStart = true;
                notifyStartResult(0, "");
            }
        }
        MyCallback myCallback = new MyCallback(this.metaDealer);
        LifecycleCallback.r(myCallback);
        this.myCallback = myCallback;
        Logger.f365497g.i(TAG, "start");
    }

    @Override // com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin
    public void stop() {
        if (!this.isStart) {
            return;
        }
        synchronized (this.lock) {
            if (this.isStart) {
                BuglyListenerFactory.getInstance().removeFactory(this.factory);
                HttpEventListenerFactory httpEventListenerFactory = this.factory;
                if (httpEventListenerFactory != null) {
                    httpEventListenerFactory.stop();
                }
                this.isStart = false;
                notifyStopResult(0, "");
            }
        }
        LifecycleCallback.s(this.myCallback);
        Logger.f365497g.i(TAG, "stop");
    }
}

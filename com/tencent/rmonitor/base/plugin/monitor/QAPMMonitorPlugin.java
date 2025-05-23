package com.tencent.rmonitor.base.plugin.monitor;

import com.tencent.rmonitor.base.config.d;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "", "", "start", "stop", "Lcom/tencent/rmonitor/base/config/d;", "pluginConfig", "Lcom/tencent/rmonitor/base/config/d;", "getPluginConfig", "()Lcom/tencent/rmonitor/base/config/d;", "setPluginConfig", "(Lcom/tencent/rmonitor/base/config/d;)V", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public abstract class QAPMMonitorPlugin {

    @Nullable
    private d pluginConfig;

    @Nullable
    public final d getPluginConfig() {
        return this.pluginConfig;
    }

    public final void setPluginConfig(@Nullable d dVar) {
        this.pluginConfig = dVar;
    }

    public abstract void start();

    public abstract void stop();
}

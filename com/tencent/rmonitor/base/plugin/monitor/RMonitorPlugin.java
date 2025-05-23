package com.tencent.rmonitor.base.plugin.monitor;

import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.rmonitor.base.config.data.j;
import com.tencent.rmonitor.base.plugin.listener.IPluginStateListener;
import i04.a;
import java.util.Iterator;

/* loaded from: classes25.dex */
public abstract class RMonitorPlugin extends QAPMMonitorPlugin {
    public abstract String getPluginName();

    public boolean isResume() {
        return true;
    }

    public abstract boolean isRunning();

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyStartResult(int i3, String str) {
        if (i3 == 0) {
            RMonitorFeatureHelper.getInstance().onPluginStarted(j.a(getPluginName()));
        }
        Iterator<IPluginStateListener> it = a.pluginStateListener.c().iterator();
        while (it.hasNext()) {
            it.next().onStartResult(getPluginName(), i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyStopResult(int i3, String str) {
        if (i3 == 0) {
            RMonitorFeatureHelper.getInstance().onPluginClosed(j.a(getPluginName()));
        }
        Iterator<IPluginStateListener> it = a.pluginStateListener.c().iterator();
        while (it.hasNext()) {
            it.next().onStopResult(getPluginName(), i3, str);
        }
    }

    public void pause() {
    }

    public void resume() {
    }
}

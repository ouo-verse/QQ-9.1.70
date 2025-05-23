package com.tencent.qqlive.tvkplayer.plugin;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKPluginManager {
    private final List<ITVKPlugin> mLoadedPluginList = new LinkedList();

    public synchronized void loadPlugin(ITVKPlugin iTVKPlugin) {
        if (iTVKPlugin != null) {
            if (!this.mLoadedPluginList.contains(iTVKPlugin)) {
                iTVKPlugin.onLoad();
                this.mLoadedPluginList.add(iTVKPlugin);
            }
        }
    }

    public synchronized void unloadAllPlugins() {
        Iterator<ITVKPlugin> it = this.mLoadedPluginList.iterator();
        while (it.hasNext()) {
            it.next().onUnload();
        }
        this.mLoadedPluginList.clear();
    }

    public synchronized void unloadPlugin(ITVKPlugin iTVKPlugin) {
        if (iTVKPlugin != null) {
            if (this.mLoadedPluginList.contains(iTVKPlugin)) {
                iTVKPlugin.onUnload();
                this.mLoadedPluginList.remove(iTVKPlugin);
            }
        }
    }
}

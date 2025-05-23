package com.tencent.hydevteam.pluginframework.pluginloader;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;

@API
/* loaded from: classes7.dex */
public interface PluginLoader {
    @API
    ProgressFuture<RunningPlugin> loadPlugin(Context context, InstalledPlugin installedPlugin) throws LoadPluginException;

    @API
    boolean setPluginDisabled(InstalledPlugin installedPlugin);
}

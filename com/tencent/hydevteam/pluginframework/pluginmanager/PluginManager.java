package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import java.util.List;

@API
/* loaded from: classes7.dex */
public interface PluginManager {

    @API
    public static final String DEFAULT_STORE_DIR_NAME = "PluginManager";

    @API
    List<InstalledPlugin> getCachedLatestPlugin(String str);

    @API
    VersionChecker getVersionChecker();

    @API
    ProgressFuture preloadApk(Context context, InstalledPlugin installedPlugin, boolean z16);

    @API
    List<ProgressFuture<InstalledPlugin>> updatePlugin(String str, TargetDownloadInfo targetDownloadInfo, String str2);
}

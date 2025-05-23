package com.tencent.hydevteam.pluginframework.pluginloader;

import android.content.Intent;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.ProgressFuture;

@API
/* loaded from: classes7.dex */
public interface RunningPlugin {
    @API
    ProgressFuture startInitActivity(Intent intent);

    @API
    ProgressFuture startLauncherActivity(Intent intent);

    @API
    void unload();
}

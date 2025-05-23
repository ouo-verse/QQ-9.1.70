package com.tencent.qqmini.sdk.launcher.shell;

import androidx.annotation.Nullable;
import com.tencent.qqmini.sdk.launcher.action.EngineChannel;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ICommonManager {
    void addActivityResultListener(IActivityResultListener iActivityResultListener);

    void fetchPeriodicCacheIfNeed(MiniAppInfo miniAppInfo);

    EngineChannel getChannelForType(int i3);

    @Nullable
    CrashRtInfoHolder getCrashRtInfoHolder();

    @Deprecated
    BaseRuntime getCurrentRuntime();

    String getTissueSoPath();

    void removeActivityResultListener(IActivityResultListener iActivityResultListener);

    void setTissueSoPath(String str);

    boolean verifyTissueEngine(String str);
}

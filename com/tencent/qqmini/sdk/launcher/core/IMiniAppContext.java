package com.tencent.qqmini.sdk.launcher.core;

import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.model.AdReportData;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface IMiniAppContext extends IBaseAppContext {
    boolean canLaunchApp();

    AdReportData getAdReportData();

    String getBaseLibVersion();

    int getLaunchAppScene();

    @NonNull
    <T> T getManager(Class<T> cls);

    MiniAppInfo getMiniAppInfo();

    boolean isContainer();

    boolean isMiniGame();

    boolean isOrientationLandscape();

    <T> T performAction(Action<T> action);
}

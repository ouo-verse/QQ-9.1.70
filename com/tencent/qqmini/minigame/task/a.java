package com.tencent.qqmini.minigame.task;

import androidx.annotation.NonNull;
import com.tencent.qqmini.minigame.gpkg.MiniGamePkg;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface a {
    void notifyRuntimeEvent(int i3, Object... objArr);

    void onAppInfoUpdateSuccess(@NonNull MiniAppInfo miniAppInfo);

    void onGameInfoLoadSuccess(MiniGamePkg miniGamePkg);

    void onGameLoadFailed(long j3, String str);
}

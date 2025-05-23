package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.GameVersionInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@MiniKeep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqmini/minigame/action/GameVersionAction;", "Lcom/tencent/qqmini/sdk/launcher/core/action/Action;", "Lcom/tencent/qqmini/sdk/launcher/core/model/GameVersionInfo;", "()V", "perform", "runtime", "Lcom/tencent/qqmini/sdk/launcher/core/BaseRuntime;", "lib_minigame_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class GameVersionAction implements Action<GameVersionInfo> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    @Nullable
    public GameVersionInfo perform(@Nullable BaseRuntime runtime) {
        if (!(runtime instanceof GameRuntime)) {
            return null;
        }
        GameRuntime gameRuntime = (GameRuntime) runtime;
        String jsVersion = gameRuntime.getJsVersion();
        String tritonVersion = gameRuntime.getTritonVersion();
        if (jsVersion == null || jsVersion.length() == 0) {
            return null;
        }
        if (tritonVersion == null || tritonVersion.length() == 0) {
            return null;
        }
        return new GameVersionInfo(jsVersion, tritonVersion);
    }
}

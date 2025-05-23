package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.minigame.manager.GameInfoManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetGameInfoManager implements Action<GameInfoManager> {
    public static GameInfoManager obtain(IMiniAppContext iMiniAppContext) {
        return (GameInfoManager) iMiniAppContext.performAction(new GetGameInfoManager());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public GameInfoManager perform(BaseRuntime baseRuntime) {
        if (baseRuntime instanceof GameRuntime) {
            return ((GameRuntime) baseRuntime).getGameInfoManager();
        }
        return null;
    }
}

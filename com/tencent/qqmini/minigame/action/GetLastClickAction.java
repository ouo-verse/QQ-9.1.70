package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GetLastClickAction implements Action<String> {
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public String perform(BaseRuntime baseRuntime) {
        if (baseRuntime instanceof GameRuntime) {
            return ((GameRuntime) baseRuntime).getLastClicks();
        }
        return null;
    }
}

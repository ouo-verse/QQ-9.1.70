package com.tencent.qqmini.minigame.manager;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqmini.minigame.GamePage;
import com.tencent.qqmini.minigame.GameRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* loaded from: classes23.dex */
public class GameVideoPlayerManager {
    private static final String TAG = "GameVideoPlayerManager";
    private static final Action<ViewGroup> getAdViewContainerAction = new Action<ViewGroup>() { // from class: com.tencent.qqmini.minigame.manager.GameVideoPlayerManager.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
        public ViewGroup perform(BaseRuntime baseRuntime) {
            GamePage gamePage = (GamePage) baseRuntime.getPage();
            if (gamePage != null) {
                return gamePage.getGameContainerView();
            }
            return null;
        }
    };

    GameVideoPlayerManager() {
    }

    public static void addPlayerView(IMiniAppContext iMiniAppContext, ViewGroup viewGroup, boolean z16) {
        ViewGroup viewGroup2 = (ViewGroup) iMiniAppContext.performAction(getAdViewContainerAction);
        if (viewGroup2 == null) {
            QMLog.e(TAG, "addPlayerView error: parent == null");
            return;
        }
        viewGroup2.removeView(viewGroup);
        if (z16) {
            viewGroup2.addView(viewGroup, 0);
        } else {
            viewGroup2.addView(viewGroup);
        }
    }

    public static void removeView(IMiniAppContext iMiniAppContext, View view) {
        ViewGroup viewGroup = (ViewGroup) iMiniAppContext.performAction(getAdViewContainerAction);
        if (viewGroup == null) {
            QMLog.e(TAG, "removePlayerView error: parent == null");
        } else {
            viewGroup.removeView(view);
        }
    }

    public static void setUnderGameView(IMiniAppContext iMiniAppContext, boolean z16) {
        if (iMiniAppContext instanceof GameRuntime) {
            IPage page = ((GameRuntime) iMiniAppContext).getPage();
            if (page instanceof GamePage) {
                ((GamePage) page).setUnderGameView(z16);
            }
        }
    }
}

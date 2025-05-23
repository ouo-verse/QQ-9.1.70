package com.tencent.hippy.qq.view.video.gamecenter;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyController(name = GameCenterVideoViewController.CLASS_NAME)
/* loaded from: classes7.dex */
public class GameCenterVideoViewController extends HippyViewController<GameCenterVideoView> {
    public static final String CLASS_NAME = "gcVideoView";
    private static final String TAG = "GameCenterVideoViewCont";
    private int mHippyEngineId = Integer.MIN_VALUE;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private interface PropName {
        public static final String AUTO_PLAY = "autoPlay";
        public static final String CLEAR_DANMU = "clearDanmu";
        public static final String COVER_URL = "coverUrl";
        public static final String DISABLE_PAUSE_COVER = "disablePauseCover";
        public static final String INDEPENDENT_PLAYER = "independentPlayer";
        public static final String KEEP_SCREEN_ON = "keepScreenOn";
        public static final String LOADING_STYLES = "loadingStyles";
        public static final String LOOP = "loop";
        public static final String MUTED = "muted";
        public static final String ON_PROGRESS = "onProgress";
        public static final String PALY_NONE_NET = "playNoneNet";
        public static final String PLAY_REPORT_PARAMS = "playReportParams";
        public static final String PRELOAD = "preload";
        public static final String SET_DANMU_DATA = "setDanmuData";
        public static final String SRC = "src";
        public static final String TYPE = "type";
        public static final String UI_STYLE = "uiStyle";
        public static final String VIDEO_BACKGROUND = "videoBackgroundColor";
        public static final String VIDEO_COVER_REMOVE_DELAY_MILLSEC = "videoCoverRemoveDelayMillSec";
        public static final String XYAXIS = "XYaxis";
    }

    @HippyControllerProps(name = PropName.CLEAR_DANMU)
    public void clearDanmu(GameCenterVideoView gameCenterVideoView) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "clearDanmu call");
        }
        gameCenterVideoView.clearDanmu();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public View createView(HippyRootView hippyRootView, int i3, HippyEngineContext hippyEngineContext, String str, HippyMap hippyMap) {
        if (hippyEngineContext != null) {
            this.mHippyEngineId = hippyEngineContext.getEngineId();
        }
        return super.createView(hippyRootView, i3, hippyEngineContext, str, hippyMap);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "autoPlay")
    public void setAutoPlay(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setAutoPlay(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "coverUrl")
    public void setCoverUrl(GameCenterVideoView gameCenterVideoView, String str) {
        gameCenterVideoView.setCoverUrl(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = PropName.SET_DANMU_DATA)
    public void setDanmuData(GameCenterVideoView gameCenterVideoView, String str) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "setDanmuData call");
        }
        gameCenterVideoView.setDanmuData(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "disablePauseCover")
    public void setDisablePauseCover(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setDisablePauseCover(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "independentPlayer")
    public void setIndependentPlayer(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setIndependentPlayer(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = PropName.KEEP_SCREEN_ON)
    public void setKeepScreenOnFunction(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setKeepScreenOnFunction(z16);
    }

    @HippyControllerProps(defaultType = "number", name = "loadingStyles")
    public void setLoadingIconStyle(GameCenterVideoView gameCenterVideoView, int i3) {
        gameCenterVideoView.setLoadingIconStyle(i3);
    }

    @HippyControllerProps(defaultType = "number", name = "loop")
    public void setLoop(GameCenterVideoView gameCenterVideoView, int i3) {
        gameCenterVideoView.setLoop(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "muted")
    public void setMuted(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setMuted(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "onProgress")
    public void setOnProgress(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setListenProgress(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = PropName.PALY_NONE_NET)
    public void setPlayNoneNet(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setPlayNoneNet(z16);
    }

    @HippyControllerProps(defaultType = "map", name = PropName.PLAY_REPORT_PARAMS)
    public void setPlayReportParamsFunction(GameCenterVideoView gameCenterVideoView, HippyMap hippyMap) {
        gameCenterVideoView.setPlayReportParamsFunction(hippyMap);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "preload")
    public void setPreload(GameCenterVideoView gameCenterVideoView, boolean z16) {
        gameCenterVideoView.setPreload(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "src")
    public void setSrc(GameCenterVideoView gameCenterVideoView, String str) {
        gameCenterVideoView.setSrc(str);
    }

    @HippyControllerProps(defaultType = "number", name = "type")
    public void setType(GameCenterVideoView gameCenterVideoView, int i3) {
        gameCenterVideoView.setType(i3);
    }

    @HippyControllerProps(defaultType = "number", name = "uiStyle")
    public void setUIStyle(GameCenterVideoView gameCenterVideoView, int i3) {
        gameCenterVideoView.setUIStyle(i3);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.STRING, name = "videoBackgroundColor")
    public void setVideoBackgroundColor(GameCenterVideoView gameCenterVideoView, String str) {
        gameCenterVideoView.setVideoBackgroundColor(str);
    }

    @HippyControllerProps(defaultType = "number", name = "XYaxis")
    public void setXYaxis(GameCenterVideoView gameCenterVideoView, int i3) {
        gameCenterVideoView.setXYaxis(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context, HippyMap hippyMap) {
        return new GameCenterVideoView(context, this.mHippyEngineId);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(GameCenterVideoView gameCenterVideoView) {
        gameCenterVideoView.onAfterUpdateProps();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(GameCenterVideoView gameCenterVideoView) {
        QLog.d(TAG, 1, "onViewDestroy");
        super.onViewDestroy((GameCenterVideoViewController) gameCenterVideoView);
        if (gameCenterVideoView != null) {
            gameCenterVideoView.destory();
        }
    }

    @HippyControllerProps(defaultType = "number", name = PropName.VIDEO_COVER_REMOVE_DELAY_MILLSEC)
    public void setVideoBackgroundColor(GameCenterVideoView gameCenterVideoView, int i3) {
        gameCenterVideoView.setCoverShowDelayedMillSec(i3);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(GameCenterVideoView gameCenterVideoView, String str, HippyArray hippyArray) {
        gameCenterVideoView.dispatchFunction(str, hippyArray, null);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void dispatchFunction(GameCenterVideoView gameCenterVideoView, String str, HippyArray hippyArray, Promise promise) {
        gameCenterVideoView.dispatchFunction(str, hippyArray, promise);
    }
}

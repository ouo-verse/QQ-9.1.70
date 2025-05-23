package com.tencent.hippy.qq.view.video.gamecenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.SeekBar;
import androidx.collection.ArrayMap;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData;
import com.tencent.mobileqq.gamecenter.media.DanmakuLayout;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.gamecenter.media.c;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewEvent;
import com.tencent.mtt.hippy.uimanager.NativeGestureDispatcher;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.superplayer.api.ISuperPlayer;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class GameCenterVideoView extends HippyViewGroup {
    private static final FunctionExecutor NO_OP_FUNCTION;
    private static final int PLAYER_INFO_CURRENT_LOOP_START = 107;
    private static final SparseIntArray STATUS_MAP;
    public static final int STYLE_IMMERSIVE = 0;
    public static final int STYLE_NORMAL = 15;
    public static final int STYLE_SHOW_AUDIO_BTN = 2;
    public static final int STYLE_SHOW_FULLSCREEN_BTN = 8;
    public static final int STYLE_SHOW_PLAY_BTN = 1;
    public static final int STYLE_SHOW_PROGRESS_BTN = 4;
    private static final String TAG = "GameCenterVideoView";
    private boolean mAutoPlay;
    private int mCoverDelayedRemoveMillSec;
    private String mCoverUrl;
    private int mCurrentLoop;
    private boolean mDisablePauseCover;
    private long mDuration;
    private boolean mEnablePlayNoneNet;
    private boolean mIndependentPlayer;
    private boolean mIsDoingFullscreen;
    private boolean mIsLandscapeWhenFullScreen;
    private boolean mKeepScreenOn;
    private volatile boolean mListenProgress;
    private int mLoop;
    private boolean mMuted;
    private HippyMap mPlayReportMap;
    private boolean mPreload;
    private final HippyMap mProgressMap;
    private volatile SDKInitListenerWithAction mSDKInitListener;
    private String mSrc;
    private int mType;
    private int mUIStyle;
    private VideoViewWrapper mVideoView;
    private int mXYaxis;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface FunctionExecutor {
        void execute(HippyArray hippyArray, Promise promise);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class SDKInitListenerWithAction implements SDKInitListener {
        Runnable action;
        volatile GameCenterVideoView videoView;

        SDKInitListenerWithAction(GameCenterVideoView gameCenterVideoView, Runnable runnable) {
            this.videoView = gameCenterVideoView;
            this.action = runnable;
        }

        public void onDestroy() {
            this.videoView = null;
        }

        @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
        public void onSDKInited(boolean z16) {
            if (this.videoView != null) {
                if (z16) {
                    this.videoView.post(this.action);
                } else {
                    QLog.e(GameCenterVideoView.TAG, 1, "initSDKAsync failed");
                }
                this.videoView = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class VideoViewWrapper extends com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController {
        private static final String EVENT_NAME_EMPTY_AREA_CLICKED = "onEmptyAreaClicked";
        private boolean mAttachCalled;
        private boolean mDestroyed;
        private boolean mDetachCalled;
        private ArrayMap<String, FunctionExecutor> mFunctionMap;
        private int mHippyEngineId;
        private boolean mOnPreparedCalled;
        private boolean mReleaseCalled;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class GetProgressFunction implements FunctionExecutor {
            GetProgressFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (promise == null) {
                    return;
                }
                VideoViewWrapper videoViewWrapper = VideoViewWrapper.this;
                promise.resolve(videoViewWrapper.updateProgressMap(videoViewWrapper.getCurrentPostion()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class GetStateFunction implements FunctionExecutor {
            GetStateFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (promise == null) {
                    return;
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_PLAY_STATE, VideoViewWrapper.this.getCurrentStatus());
                promise.resolve(hippyMap);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class PauseFunction implements FunctionExecutor {
            PauseFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (VideoViewWrapper.this.mDestroyed) {
                    return;
                }
                VideoViewWrapper.this.pause();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class PlayFunction implements FunctionExecutor {
            PlayFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (!VideoViewWrapper.this.mDestroyed) {
                    GameCenterVideoView.this.doActionAfterSDKInit(new Runnable() { // from class: com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.VideoViewWrapper.PlayFunction.1
                        @Override // java.lang.Runnable
                        public void run() {
                            VideoViewWrapper.this.play();
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class SeekFunction implements FunctionExecutor {
            SeekFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (VideoViewWrapper.this.mDestroyed) {
                    return;
                }
                VideoViewWrapper.this.seekTo(hippyArray.getInt(0));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class SetSpeedRatioFunction implements FunctionExecutor {
            SetSpeedRatioFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (VideoViewWrapper.this.mDestroyed) {
                    return;
                }
                VideoViewWrapper.this.setSpeedRatio((float) hippyArray.getDouble(0));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class StopFunction implements FunctionExecutor {
            StopFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (VideoViewWrapper.this.mDestroyed) {
                    return;
                }
                VideoViewWrapper.this.stop();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class setListenProgressFunction implements FunctionExecutor {
            setListenProgressFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                GameCenterVideoView.this.setListenProgress(hippyArray.getBoolean(0));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* loaded from: classes7.dex */
        public class setMutedFunction implements FunctionExecutor {
            setMutedFunction() {
            }

            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
                if (VideoViewWrapper.this.mDestroyed) {
                    return;
                }
                VideoViewWrapper.this.setMute(hippyArray.getBoolean(0));
            }
        }

        public VideoViewWrapper(@NonNull Context context, int i3) {
            super(context);
            this.mHippyEngineId = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public ArrayMap<String, FunctionExecutor> ensureFunctionMap() {
            if (this.mFunctionMap == null) {
                ArrayMap<String, FunctionExecutor> arrayMap = new ArrayMap<>();
                this.mFunctionMap = arrayMap;
                arrayMap.put("play", new PlayFunction());
                this.mFunctionMap.put(InnerAudioPlugin.AUDIO_OPERATE_SEEK, new SeekFunction());
                this.mFunctionMap.put("pause", new PauseFunction());
                this.mFunctionMap.put("stop", new StopFunction());
                this.mFunctionMap.put(HippyQQPagView.FunctionName.GET_PROGRESS, new GetProgressFunction());
                this.mFunctionMap.put("curPlayState", new GetStateFunction());
                this.mFunctionMap.put("setListenProgress", new setListenProgressFunction());
                this.mFunctionMap.put("setMuted", new setMutedFunction());
                this.mFunctionMap.put("setSpeedRatio", new SetSpeedRatioFunction());
            }
            return this.mFunctionMap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$handleMessage$0() {
            View view = this.mCoverContainer;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public HippyMap updateProgressMap(long j3) {
            GameCenterVideoView.this.mProgressMap.pushLong("progressTime", j3);
            GameCenterVideoView.this.mProgressMap.pushLong("duration", GameCenterVideoView.this.mDuration);
            return GameCenterVideoView.this.mProgressMap;
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void destroy() {
            this.mDestroyed = true;
            super.destroy();
            if (!GameCenterVideoView.this.mIndependentPlayer && c.b().a() == this) {
                c.b().c();
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void enterFullScreen() {
            super.enterFullScreen();
            GameCenterVideoView.this.mIsDoingFullscreen = true;
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void exitFullScreen() {
            release();
            super.exitFullScreen();
            GameCenterVideoView.this.mIsDoingFullscreen = false;
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController, android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 4) {
                if (getCurrentStatus() == 5) {
                    if (!GameCenterVideoView.this.mDisablePauseCover) {
                        this.mCoverContainer.setVisibility(0);
                    }
                } else if (getCurrentStatus() == 3) {
                    if (this.isFromSeekComplete) {
                        this.isFromSeekComplete = false;
                        this.mCoverContainer.setVisibility(8);
                    } else if (!GameCenterVideoView.this.mDisablePauseCover && GameCenterVideoView.this.mCoverDelayedRemoveMillSec > 0) {
                        Object obj = message.obj;
                        if (!(obj instanceof String) || !isFromClickTwoPauseScene((String) obj)) {
                            this.mCoverContainer.setVisibility(0);
                            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.hippy.qq.view.video.gamecenter.a
                                @Override // java.lang.Runnable
                                public final void run() {
                                    GameCenterVideoView.VideoViewWrapper.this.lambda$handleMessage$0();
                                }
                            }, GameCenterVideoView.this.mCoverDelayedRemoveMillSec);
                        }
                    }
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController, android.view.ViewGroup, android.view.View
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            this.mAttachCalled = true;
            if (GameCenterVideoView.this.mKeepScreenOn) {
                setKeepScreenOn(true);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void onCompletion(ISuperPlayer iSuperPlayer) {
            super.onCompletion(iSuperPlayer);
            GameCenterVideoView.this.mCurrentLoop = 1;
            GameCenterVideoView.this.sendEvent("onPlayFinish", null);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            this.mDetachCalled = true;
            if (GameCenterVideoView.this.mKeepScreenOn) {
                setKeepScreenOn(false);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void onEmptyAreaClicked() {
            GameCenterVideoView.this.sendEvent(EVENT_NAME_EMPTY_AREA_CLICKED, null);
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.TAG, 2, "onError, errCode:", Integer.valueOf(i17), ", errMsg:", str);
            }
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("errcode", i17);
            hippyMap.pushString("errorMsg", str);
            hippyMap.pushString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, String.valueOf(i16));
            hippyMap.pushString("module", String.valueOf(i3));
            GameCenterVideoView.this.sendEvent("onError", hippyMap);
            return super.onError(iSuperPlayer, i3, i16, i17, str);
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public boolean onInfo(ISuperPlayer iSuperPlayer, int i3, long j3, long j16, Object obj) {
            if (105 == i3) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("src", GameCenterVideoView.this.mSrc);
                GameCenterVideoView.this.sendEvent("onPlayFirstFrame", hippyMap);
            }
            if (i3 == 107) {
                GameCenterVideoView gameCenterVideoView = GameCenterVideoView.this;
                int i16 = gameCenterVideoView.mCurrentLoop + 1;
                gameCenterVideoView.mCurrentLoop = i16;
                if (i16 >= GameCenterVideoView.this.mLoop && GameCenterVideoView.this.mLoop > 1) {
                    iSuperPlayer.setLoopback(false);
                }
            }
            return super.onInfo(iSuperPlayer, i3, j3, j16, obj);
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        protected void onPlayerCreated(ISuperPlayer iSuperPlayer) {
            if (GameCenterVideoView.this.mLoop == 0 || GameCenterVideoView.this.mLoop > 1) {
                GameCenterVideoView.this.mCurrentLoop = 1;
                iSuperPlayer.setLoopback(true);
            }
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
            super.onProgressChanged(seekBar, i3, z16);
            if (GameCenterVideoView.this.mListenProgress) {
                GameCenterVideoView.this.sendEvent("onProgress", updateProgressMap(i3));
            }
            QLog.isColorLevel();
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
            super.onVideoPrepared(iSuperPlayer);
            this.mOnPreparedCalled = true;
            GameCenterVideoView.this.bindVideoPlayerInfo(iSuperPlayer);
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        protected void onViewChanged(View view) {
            GameCenterVideoView.this.forceViewMeasure(view);
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void play() {
            super.play();
            new HippyViewEvent("onVideoPlay").send(GameCenterVideoView.this, "");
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void release() {
            super.release();
            this.mReleaseCalled = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public Activity scanForActivity(Context context) {
            HippyQQEngine engineInstance = HippyQQEngine.getEngineInstance(this.mHippyEngineId);
            if (engineInstance != null && engineInstance.getActivity() != null) {
                return engineInstance.getActivity();
            }
            return super.scanForActivity(context);
        }

        @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController
        public void setCurrentStatus(int i3) {
            int currentStatus = getCurrentStatus();
            super.setCurrentStatus(i3);
            if (QLog.isColorLevel()) {
                QLog.d(com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.TAG, 2, "onVideoStatusChanged, oldStatus:", Integer.valueOf(currentStatus), ", curStatus:", Integer.valueOf(i3));
            }
            if (i3 != 0 && i3 != 4 && i3 != 3 && i3 != 5 && i3 != 7) {
                if (i3 == 2) {
                    GameCenterVideoView.this.mDuration = getDuration();
                }
            } else {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushInt("curPlayState", GameCenterVideoView.STATUS_MAP.get(i3));
                hippyMap.pushInt("oldPlayState", GameCenterVideoView.STATUS_MAP.get(currentStatus));
                GameCenterVideoView.this.sendEvent("onPlayStateChanged", hippyMap);
            }
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        STATUS_MAP = sparseIntArray;
        sparseIntArray.put(0, 0);
        sparseIntArray.put(4, 3);
        sparseIntArray.put(3, 4);
        sparseIntArray.put(5, 5);
        sparseIntArray.put(7, 6);
        NO_OP_FUNCTION = new FunctionExecutor() { // from class: com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.3
            @Override // com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.FunctionExecutor
            public void execute(HippyArray hippyArray, Promise promise) {
            }
        };
    }

    public GameCenterVideoView(@NonNull Context context, int i3) {
        super(context);
        this.mLoop = 1;
        this.mCurrentLoop = 1;
        this.mMuted = true;
        this.mAutoPlay = false;
        this.mXYaxis = 0;
        this.mEnablePlayNoneNet = false;
        this.mIndependentPlayer = false;
        this.mIsLandscapeWhenFullScreen = true;
        this.mProgressMap = new HippyMap();
        this.mDisablePauseCover = false;
        this.mIsDoingFullscreen = false;
        initVideoView(context, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bindVideoPlayerInfo(ISuperPlayer iSuperPlayer) {
        if (!needBindVideoPlayerInfo()) {
            return;
        }
        VideoReport.bindVideoPlayerInfo(iSuperPlayer, new VideoEntity.Builder().setContentId(this.mPlayReportMap.getString("contentId")).setIdentifier(this.mPlayReportMap.getString(IECDtReport.ACTION_IDENTIFIER)).setPage((Object) this.mPlayReportMap.getString("page")).setContentType(this.mPlayReportMap.getInt("contentType")).setVideoDuration(this.mPlayReportMap.getInt("videoDuration")).ignoreReport(this.mPlayReportMap.getBoolean("ignoreReport")).addCustomParams(HippyCommonUtils.hippyMapToMap(this.mPlayReportMap.getMap(QQBrowserActivity.APP_PARAM))).setVideoView((View) this.mVideoView).bizReady(true).build());
        QLog.d(TAG, 4, "bindVideoPlayerInfo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doActionAfterSDKInit(Runnable runnable) {
        if (QQVideoPlaySDKManager.isSDKReady()) {
            runnable.run();
        } else if (this.mSDKInitListener == null) {
            this.mSDKInitListener = new SDKInitListenerWithAction(this, runnable);
            QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this.mSDKInitListener);
        } else {
            this.mSDKInitListener.action = runnable;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceViewMeasure() {
        if (this.mIsDoingFullscreen) {
            return;
        }
        forceViewMeasure(this);
    }

    private void initVideoView(@NonNull Context context, int i3) {
        VideoViewWrapper videoViewWrapper = new VideoViewWrapper(context, i3);
        this.mVideoView = videoViewWrapper;
        videoViewWrapper.setBackgroundColor(-16777216);
        addView(this.mVideoView, -1, -1);
    }

    private boolean needBindVideoPlayerInfo() {
        HippyMap hippyMap = this.mPlayReportMap;
        if (hippyMap != null && hippyMap.size() > 0 && !TextUtils.isEmpty(this.mPlayReportMap.getString("contentId"))) {
            return true;
        }
        return false;
    }

    public void clearDanmu() {
        DanmakuLayout danmakuLayout = this.mVideoView.getDanmakuLayout();
        if (danmakuLayout != null) {
            danmakuLayout.l();
        }
    }

    public void destory() {
        this.mVideoView.destroy();
        if (this.mSDKInitListener != null) {
            this.mSDKInitListener.onDestroy();
            this.mSDKInitListener = null;
        }
    }

    public void dispatchFunction(String str, HippyArray hippyArray, Promise promise) {
        ((FunctionExecutor) this.mVideoView.ensureFunctionMap().getOrDefault(str, NO_OP_FUNCTION)).execute(hippyArray, promise);
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public NativeGestureDispatcher getGestureDispatcher() {
        return null;
    }

    public void onAfterUpdateProps() {
        FeedsItemData feedsItemData = new FeedsItemData();
        int i3 = this.mType;
        if (i3 != 2 && i3 != 1) {
            feedsItemData.type = 2;
            feedsItemData.videoVid = this.mSrc;
        } else {
            feedsItemData.type = i3;
            String str = this.mSrc;
            feedsItemData.videoUrl = str;
            if (i3 != 1) {
                HtmlOffline.d(str, MobileQQ.sMobileQQ.waitAppRuntime(null));
            }
        }
        String str2 = this.mCoverUrl;
        feedsItemData.coverImgUrl = str2;
        feedsItemData.independentPlayer = this.mIndependentPlayer;
        HtmlOffline.d(str2, MobileQQ.sMobileQQ.waitAppRuntime(null));
        this.mVideoView.setData(feedsItemData, 1, this.mPreload);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onAfterUpdateProps: ", this);
        }
        this.mVideoView.setVideoStatusChangerListener(new GameCenterVideoViewController.h() { // from class: com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.1
            @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.h
            public void onAudioMute(boolean z16, int i16, boolean z17) {
                if (QLog.isColorLevel()) {
                    QLog.d(GameCenterVideoView.TAG, 2, "onAudioMute " + z16);
                }
                if (z17) {
                    HippyMap hippyMap = new HippyMap();
                    hippyMap.pushBoolean("isMuted", z16);
                    GameCenterVideoView.this.sendEvent("onVoiceStateChanged", hippyMap);
                }
            }

            @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.h
            public void onSrceenModeChanged(boolean z16, int i16) {
                if (QLog.isColorLevel()) {
                    QLog.d(GameCenterVideoView.TAG, 2, "onSrceenModeChanged, fullScreen:", Boolean.valueOf(z16));
                }
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushBoolean(OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, z16);
                GameCenterVideoView.this.sendEvent("onFullScreenChanged", hippyMap);
            }

            @Override // com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.h
            public void onVideoStatusChanged(int i16, int i17) {
            }
        });
        doActionAfterSDKInit(new Runnable() { // from class: com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.2
            @Override // java.lang.Runnable
            public void run() {
                if (GameCenterVideoView.this.mXYaxis != 0) {
                    GameCenterVideoView.this.mVideoView.setXYaxis(GameCenterVideoView.this.mXYaxis);
                }
                GameCenterVideoView.this.mVideoView.setPlayNoneNet(GameCenterVideoView.this.mEnablePlayNoneNet);
                if (GameCenterVideoView.this.mAutoPlay) {
                    GameCenterVideoView.this.mVideoView.autoPlay();
                }
                if (GameCenterVideoView.this.mPreload) {
                    GameCenterVideoView.this.mVideoView.preload();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.supportui.views.asyncimage.AsyncImageView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (getChildAt(0) != null) {
            getChildAt(0).layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getChildAt(0) != null) {
            getChildAt(0).measure(i3, i16);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        super.requestLayout();
        post(new Runnable() { // from class: com.tencent.hippy.qq.view.video.gamecenter.GameCenterVideoView.4
            @Override // java.lang.Runnable
            public void run() {
                GameCenterVideoView.this.forceViewMeasure();
            }
        });
    }

    public void sendEvent(String str, HippyMap hippyMap) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendEvent, eventName:", str, ", data:", hippyMap);
        }
        new HippyViewEvent(str).send(this, hippyMap);
    }

    public void setAutoPlay(boolean z16) {
        this.mAutoPlay = z16;
    }

    public void setCoverShowDelayedMillSec(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[setCoverShowDelayedMillSec]], delayedMillSec:", Integer.valueOf(i3));
        }
        this.mCoverDelayedRemoveMillSec = i3;
    }

    public void setCoverUrl(String str) {
        this.mCoverUrl = str;
    }

    public void setDanmuData(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("data");
            if (optJSONArray == null) {
                return;
            }
            com.tencent.mobileqq.gamecenter.media.a[] aVarArr = new com.tencent.mobileqq.gamecenter.media.a[str.length()];
            for (int i3 = 0; i3 < str.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    aVarArr[i3] = new com.tencent.mobileqq.gamecenter.media.a(optJSONObject.optString("text"), optJSONObject.optDouble("onScreenTime"), optJSONObject.optDouble("screenDuration"), optJSONObject.optString("fontColor"), optJSONObject.optString("backgroundColor"));
                }
            }
            this.mVideoView.getDanmakuLayout().k(aVarArr);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "setDanmuData Err:" + e16.toString());
        }
    }

    public void setDisablePauseCover(boolean z16) {
        this.mDisablePauseCover = z16;
    }

    public void setIndependentPlayer(boolean z16) {
        this.mIndependentPlayer = z16;
    }

    public void setIsLandscapeWhenFullScreen(boolean z16) {
        this.mIsLandscapeWhenFullScreen = z16;
        this.mVideoView.setIsLandscapeWhenFullScreen(z16);
    }

    public void setKeepScreenOnFunction(boolean z16) {
        this.mKeepScreenOn = z16;
    }

    public void setListenProgress(boolean z16) {
        this.mListenProgress = z16;
    }

    public void setLoadingIconStyle(int i3) {
        VideoViewWrapper videoViewWrapper = this.mVideoView;
        if (videoViewWrapper != null) {
            videoViewWrapper.setLoadingIconStyle(i3);
        }
    }

    public void setLoop(int i3) {
        if (i3 >= 0) {
            this.mLoop = i3;
        }
    }

    public void setMuted(boolean z16) {
        this.mMuted = z16;
        this.mVideoView.setMute(z16);
    }

    public void setPlayNoneNet(boolean z16) {
        this.mEnablePlayNoneNet = z16;
    }

    public void setPlayReportParamsFunction(HippyMap hippyMap) {
        this.mPlayReportMap = hippyMap;
    }

    public void setPreload(boolean z16) {
        this.mPreload = z16;
    }

    public void setShowErrorToast(boolean z16) {
        this.mVideoView.setShowErrorToast(z16);
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public void setType(int i3) {
        this.mType = i3;
    }

    public void setUIStyle(int i3) {
        boolean z16;
        QLog.i(TAG, 2, "[setUIStyle] uiStyle:" + i3);
        this.mUIStyle = i3;
        VideoViewWrapper videoViewWrapper = this.mVideoView;
        boolean z17 = false;
        if ((i3 & 1) != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        videoViewWrapper.setPlayEnabled(z16);
        if ((i3 & 2) != 0) {
            this.mVideoView.enableVolumeSwitch();
        }
        VideoViewWrapper videoViewWrapper2 = this.mVideoView;
        if ((i3 & 4) != 0) {
            z17 = true;
        }
        videoViewWrapper2.setProgressEnabled(z17);
        if ((i3 & 8) != 0) {
            this.mVideoView.enableFullScreenSwitch();
        }
    }

    public void setVideoBackgroundColor(String str) {
        try {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[setVideoBackgroundColor], color:" + str);
            }
            if (!str.startsWith("#")) {
                str = "#" + str;
            }
            this.mVideoView.setBackgroundColor(Color.parseColor(str));
        } catch (IllegalArgumentException e16) {
            QLog.e(TAG, 1, "fail to setBackgroundColor, e:" + e16);
        }
    }

    public void setVideoDuration(int i3) {
        VideoViewWrapper videoViewWrapper = this.mVideoView;
        if (videoViewWrapper != null) {
            videoViewWrapper.setVideoDuration(i3);
        }
    }

    public void setXYaxis(int i3) {
        this.mXYaxis = i3;
    }

    @Override // android.view.View
    @androidx.annotation.NonNull
    public String toString() {
        return "GameCenterVideoView{mSrc=" + this.mSrc + ", mType=" + this.mType + ", mLoop=" + this.mLoop + ", mCurrentLoop=" + this.mCurrentLoop + ", mCoverUrl=" + this.mCoverUrl + ", mMuted=" + this.mMuted + ", mAutoPlay=" + this.mAutoPlay + ", mPreload=" + this.mPreload + ", mUIStyle=" + this.mUIStyle + "}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void forceViewMeasure(View view) {
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    @Override // com.tencent.mtt.hippy.views.image.HippyImageView, com.tencent.mtt.hippy.uimanager.HippyViewBase
    public void setGestureDispatcher(NativeGestureDispatcher nativeGestureDispatcher) {
    }
}

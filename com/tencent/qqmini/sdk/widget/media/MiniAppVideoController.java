package com.tencent.qqmini.sdk.widget.media;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.plugin.VideoJsPlugin;
import com.tencent.qqmini.sdk.R;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import com.tencent.qqmini.sdk.widget.media.MediaUtils;
import com.tencent.qqmini.sdk.widget.media.MiniAppVideoPlayerListenerHolder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;
import java.util.Queue;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppVideoController implements Handler.Callback {
    private static final int MEDIA_INFO_SUPER_BUFFERING_END = 113;
    private static final int MEDIA_INFO_SUPER_BUFFERING_START = 112;
    private static final String TAG = "MiniAppVideoController";
    private Bitmap cachedCaptureImage;
    private MiniAppVideoConfig config;
    private String data;
    private final Handler handler;
    private boolean isAutoPausedOnBackground;
    private boolean isBufferStart;
    private boolean isBusyInChangeScreen;
    private boolean isChangingProgress;
    private boolean isPageBackground;
    private boolean isPause;
    private boolean isVideoPrepared;
    private IJsService jsService;
    private int lastBufferProgress;
    private MiniAppVideoPlayerListenerHolder listenerHolder;
    private WeakReference<Activity> mActivityRef;
    private AudioManager mAudioManager;
    private long mCurrPos;
    private int maxVolume;
    private IMiniAppContext miniAppContext;
    private boolean needPauseOnLoad;
    private int oldVolume;
    private int originHeight;
    private int originWidth;
    private IVideoPlayer player;
    private boolean playingBefore;
    private int rotation;
    private Queue<Message> taskQueueRunAfterVideoPrepared;

    /* renamed from: ui, reason: collision with root package name */
    private IVideoPlayerUI f348402ui;
    private long videoPlayerId;
    private Observer videoPlayerStatusObserver;
    private int webViewId;

    public MiniAppVideoController() {
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.isVideoPrepared = false;
        this.isBusyInChangeScreen = false;
        this.isBufferStart = false;
        this.lastBufferProgress = 0;
        this.maxVolume = 0;
        this.oldVolume = 0;
        this.taskQueueRunAfterVideoPrepared = new LinkedList();
    }

    static /* synthetic */ int access$3308(MiniAppVideoController miniAppVideoController) {
        int i3 = miniAppVideoController.lastBufferProgress;
        miniAppVideoController.lastBufferProgress = i3 + 1;
        return i3;
    }

    private void avoidLockScreen() {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "avoidLockScreen mActivityRef is invalid!");
            return;
        }
        this.mActivityRef.get().getWindow().addFlags(128);
        this.mActivityRef.get().getWindow().clearFlags(1);
        QMLog.d(TAG, "avoidLockScreen");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackFullScreenChange() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("videoId", this.videoPlayerId);
            jSONObject.put("fullScreen", this.config.isFullScreen);
            evaluateSubscribeJS("onVideoFullScreenChange", jSONObject.toString());
        } catch (JSONException e16) {
            QMLog.e(TAG, "callBackFullScreenChange error!", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnVideoPlay() throws JSONException {
        IMiniAppContext iMiniAppContext = this.miniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.isMiniGame()) {
            callbackVideoStateChange("play");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoId", this.videoPlayerId);
        jSONObject.put("data", this.data);
        evaluateSubscribeJS("onVideoPlay", jSONObject.toString());
        QMLog.d(TAG, "OnVideoPreparedListener - onVideoPrepared evaluateSubcribeJS onVideoPlay = " + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnVideoWaiting() throws JSONException {
        IMiniAppContext iMiniAppContext = this.miniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.isMiniGame()) {
            callbackVideoStateChange("waiting");
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoId", this.videoPlayerId);
        jSONObject.put("data", this.data);
        evaluateSubscribeJS("onVideoWaiting", jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackVideoStateChange(String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("videoPlayerId", this.videoPlayerId);
            jSONObject.put("state", str);
            if ("timeUpdate".equals(str)) {
                jSONObject.put("position", this.player.getCurrentPostion() / 1000.0d);
                jSONObject.put("duration", this.player.getDuration() / 1000.0d);
            }
            evaluateSubscribeJS("onVideoStateChange", jSONObject.toString());
        } catch (Throwable th5) {
            QMLog.e(TAG, "callbackVideoStateChange error.", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAvoidLockScreen() {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "cancelAvoidLockScreen mActivityRef is invalid!");
            return;
        }
        this.mActivityRef.get().getWindow().clearFlags(128);
        this.mActivityRef.get().getWindow().addFlags(1);
        QMLog.d(TAG, "cancelAvoidLockScreen");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void evaluateSubscribeJS(String str, String str2) {
        IJsService iJsService = this.jsService;
        if (iJsService != null) {
            iJsService.evaluateSubscribeJS(str, str2, this.webViewId);
            return;
        }
        IMiniAppContext iMiniAppContext = this.miniAppContext;
        if (iMiniAppContext != null) {
            iMiniAppContext.performAction(ServiceSubscribeEvent.obtain(str, str2, this.webViewId));
            return;
        }
        QMLog.e(TAG, "miniAppContext and pageWebView is null.");
        if (!((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
        } else {
            throw new IllegalArgumentException("evaluateSubscribeJS: jsService and miniAppContext are all invalid.");
        }
    }

    private int getAndSelectVideoTrackIndex(MediaExtractor mediaExtractor) {
        for (int i3 = 0; i3 < mediaExtractor.getTrackCount(); i3++) {
            try {
                QMLog.d(VideoJsPlugin.TAG, "format for track " + i3 + " is " + mediaExtractor.getTrackFormat(i3).getString("mime"));
                if (mediaExtractor.getTrackFormat(i3).getString("mime").startsWith("video/")) {
                    mediaExtractor.selectTrack(i3);
                    return i3;
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "getAndSelectVideoTrackIndex error!", e16);
                return -1;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getCachedCaptureImage() {
        Bitmap bitmap = this.cachedCaptureImage;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.cachedCaptureImage.recycle();
            this.cachedCaptureImage = null;
        }
        Bitmap bitmap2 = this.cachedCaptureImage;
        if (bitmap2 == null || bitmap2.isRecycled()) {
            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.18
                @Override // java.lang.Runnable
                public void run() {
                    MiniAppVideoController.this.captureImage(new AbsVideoPlayer.OnCaptureImageListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.18.1
                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener
                        public void onCaptureImageSucceed(Bitmap bitmap3) {
                            if (bitmap3 != null && !bitmap3.isRecycled()) {
                                MiniAppVideoController.this.cachedCaptureImage = Bitmap.createBitmap(bitmap3);
                            }
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener
                        public void onCaptureImageFailed() {
                        }
                    });
                }
            }, 1000L);
        }
    }

    private AbsVideoPlayer.OnCaptureImageListener getCaptureImageListener(final AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener) {
        return new AbsVideoPlayer.OnCaptureImageListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.19
            private boolean hasCallImageSucceed = false;
            private boolean hasCallImageFailed = false;

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener
            public void onCaptureImageFailed() {
                if (this.hasCallImageFailed) {
                    return;
                }
                onCaptureImageListener.onCaptureImageFailed();
                this.hasCallImageFailed = true;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCaptureImageListener
            public void onCaptureImageSucceed(Bitmap bitmap) {
                if (this.hasCallImageSucceed) {
                    return;
                }
                final Bitmap createBitmap = Bitmap.createBitmap(bitmap);
                final Canvas canvas = new Canvas(createBitmap);
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.19.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppVideoController.this.f348402ui.onCaptureImageSucceed(canvas);
                        onCaptureImageListener.onCaptureImageSucceed(createBitmap);
                        AnonymousClass19.this.hasCallImageSucceed = true;
                    }
                });
            }
        };
    }

    private View.OnClickListener getClickListener() {
        return new View.OnClickListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                if (MiniAppVideoController.this.player != null) {
                    if (view.getId() == R.id.play_status_img) {
                        MiniAppVideoController.this.handlePlayBtnClick();
                    } else if (view.getId() != R.id.video_playing_iv_control && view.getId() != R.id.video_playing_iv_control_center) {
                        if (view.getId() != R.id.video_playing_iv_window && view.getId() != R.id.video_playing_iv_back_fullscreen) {
                            if (view.getId() == R.id.video_playing_iv_barrage) {
                                MiniAppVideoController.this.f348402ui.showPopCtrViewThenAutoHide(MiniAppVideoController.this.config);
                                MiniAppVideoController.this.f348402ui.updateDanmuView(MiniAppVideoController.this.config);
                                MiniAppVideoController.this.f348402ui.resetBarrageDrawable(MiniAppVideoController.this.config);
                            } else if (view.getId() == R.id.video_playing_iv_mute) {
                                MiniAppVideoController.this.config.muted = !MiniAppVideoController.this.player.getOutputMute();
                                if (!MiniAppVideoController.this.player.updateMute(MiniAppVideoController.this.config)) {
                                    QMLog.e(MiniAppVideoController.TAG, "switch mute state failed.");
                                } else {
                                    MiniAppVideoController.this.f348402ui.resetMuteImage(MiniAppVideoController.this.config, MiniAppVideoController.this.config.muted);
                                }
                            }
                        } else {
                            MiniAppVideoController.this.f348402ui.showPopCtrViewThenAutoHide(MiniAppVideoController.this.config);
                            MiniAppVideoController.this.switchScreenSize();
                            MiniAppVideoController.this.f348402ui.resetWindowIvDrawable(MiniAppVideoController.this.config);
                        }
                    } else {
                        MiniAppVideoController.this.operate();
                        MiniAppVideoController.this.f348402ui.updatePopCtrView(MiniAppVideoController.this.config, MiniAppVideoController.this.player.isPlaying());
                        MiniAppVideoController.this.f348402ui.resetControlIvDrawable(MiniAppVideoController.this.player.isPlaying());
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    private AbsVideoPlayer.OnCompletionListener getOnCompletionListener() {
        return new AbsVideoPlayer.OnCompletionListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.8
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnCompletionListener
            public void onCompletion(AbsVideoPlayer absVideoPlayer) {
                MiniAppVideoController.this.config.initialTime = 0.0d;
                if (MiniAppVideoController.this.config.isFullScreen) {
                    MiniAppVideoController.this.smallScreen();
                }
                if (MiniAppVideoController.this.miniAppContext != null && MiniAppVideoController.this.miniAppContext.isMiniGame()) {
                    MiniAppVideoController.this.callbackVideoStateChange("ended");
                } else {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", MiniAppVideoController.this.data);
                        jSONObject.put("videoId", MiniAppVideoController.this.videoPlayerId);
                        MiniAppVideoController.this.evaluateSubscribeJS("onVideoEnded", jSONObject.toString());
                        QMLog.d(MiniAppVideoController.TAG, "evaluateSubcribeJS onVideoEnded = " + jSONObject.toString());
                    } catch (Exception e16) {
                        QMLog.e(MiniAppVideoController.TAG, "getOnCompletionListener error!", e16);
                    }
                }
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppVideoController.this.f348402ui.updateCenterBtn(MiniAppVideoController.this.config);
                        MiniAppVideoController.this.f348402ui.hideControllerPopContainer();
                        MiniAppVideoController.this.handler.removeMessages(2002);
                    }
                });
            }
        };
    }

    private AbsVideoPlayer.OnControllerClickListener getOnControllerClickListener() {
        return new AbsVideoPlayer.OnControllerClickListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.5
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener
            public void onBackClick(AbsVideoPlayer absVideoPlayer) {
                QMLog.d(MiniAppVideoController.TAG, "video player onBackClick");
                if (!MiniAppVideoController.this.isActivityRefValid()) {
                    QMLog.e(MiniAppVideoController.TAG, "onBackClick mActivityRef is invalid!");
                } else if (MiniAppVideoController.this.config.isFullScreen) {
                    MiniAppVideoController.this.smallScreen();
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener
            public void onBackOnFullScreenClick(AbsVideoPlayer absVideoPlayer) {
                QMLog.d(MiniAppVideoController.TAG, "video player onBackOnFullScreenClick");
                if (!MiniAppVideoController.this.isActivityRefValid()) {
                    QMLog.e(MiniAppVideoController.TAG, "onBackOnFullScreenClick mActivityRef is invalid!");
                } else if (MiniAppVideoController.this.config.isFullScreen) {
                    MiniAppVideoController.this.smallScreen();
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener
            public void onFullScreenClick(AbsVideoPlayer absVideoPlayer) {
                MiniAppVideoController.this.switchScreenSize();
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener
            public void onAttationClick(AbsVideoPlayer absVideoPlayer) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener
            public void onCacheClick(AbsVideoPlayer absVideoPlayer) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnControllerClickListener
            public void onFeedbackClick(AbsVideoPlayer absVideoPlayer) {
            }
        };
    }

    private AbsVideoPlayer.OnErrorListener getOnErrorListener() {
        return new AbsVideoPlayer.OnErrorListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.10
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnErrorListener
            public boolean onError(AbsVideoPlayer absVideoPlayer, int i3, int i16) {
                QMLog.e(MiniAppVideoController.TAG, "video onError: m what=" + i3 + " extra=" + i16);
                if (MiniAppVideoController.this.miniAppContext != null && MiniAppVideoController.this.miniAppContext.isMiniGame()) {
                    MiniAppVideoController.this.callbackVideoStateChange("error");
                    return true;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("videoId", MiniAppVideoController.this.videoPlayerId);
                    jSONObject.put("data", MiniAppVideoController.this.data);
                    MiniAppVideoController.this.evaluateSubscribeJS("onVideoError", jSONObject.toString());
                    QMLog.d(MiniAppVideoController.TAG, "evaluateSubcribeJS onVideoError = " + jSONObject);
                    return true;
                } catch (JSONException e16) {
                    QMLog.e(MiniAppVideoController.TAG, "getOnErrorListener error!", e16);
                    return true;
                }
            }
        };
    }

    private AbsVideoPlayer.OnInfoListener getOnInfoListener() {
        return new AbsVideoPlayer.OnInfoListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.9
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnInfoListener
            public boolean onInfo(AbsVideoPlayer absVideoPlayer, int i3, int i16) {
                if (QMLog.isColorLevel()) {
                    QMLog.d(MiniAppVideoController.TAG, "onInfo: " + i3 + " " + i3);
                }
                int superMsg = MiniAppVideoController.this.getSuperMsg(i3);
                if (superMsg != 21) {
                    if (superMsg == 22) {
                        QMLog.d(MiniAppVideoController.TAG, "video player PLAYER_INFO_ENDOF_BUFFERING--------------");
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("data", MiniAppVideoController.this.data);
                            MiniAppVideoController.this.evaluateSubscribeJS("onVideoLoadedData", jSONObject.toString());
                            QMLog.d(MiniAppVideoController.TAG, "evaluateSubcribeJS onVideoLoadedData = " + jSONObject.toString());
                            return false;
                        } catch (JSONException e16) {
                            QMLog.e(MiniAppVideoController.TAG, "getOnInfoListener error!", e16);
                            return false;
                        }
                    }
                    return false;
                }
                QMLog.d(MiniAppVideoController.TAG, "video player PLAYER_INFO_START_BUFFERING--------------");
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("data", MiniAppVideoController.this.data);
                    MiniAppVideoController.this.evaluateSubscribeJS("onVideoLoadStart", jSONObject2.toString());
                    QMLog.d(MiniAppVideoController.TAG, "evaluateSubcribeJS onVideoLoadStart = " + jSONObject2.toString());
                    return false;
                } catch (JSONException e17) {
                    QMLog.e(MiniAppVideoController.TAG, "getOnInfoListener error!", e17);
                    return false;
                }
            }
        };
    }

    private SeekBar.OnSeekBarChangeListener getOnSeekBarChangeListener() {
        return new SeekBar.OnSeekBarChangeListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.4
            private long position;

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i3, boolean z16) {
                if (z16 && MiniAppVideoController.this.player != null) {
                    long j3 = i3;
                    this.position = (MiniAppVideoController.this.player.getDuration() * j3) / seekBar.getMax();
                    MiniAppVideoController.this.f348402ui.onProgressChanged(MiniAppVideoController.parseTimeString(j3));
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                MiniAppVideoController.this.f348402ui.onStartTrackingTouch(MiniAppVideoController.this.config);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                EventCollector.getInstance().onStopTrackingTouchBefore(seekBar);
                if (MiniAppVideoController.this.player != null) {
                    MiniAppVideoController.this.seekTo((int) this.position);
                }
                MiniAppVideoController.this.f348402ui.onStopTrackingTouch(MiniAppVideoController.this.config);
                if (MiniAppVideoController.this.player != null) {
                    MiniAppVideoController.this.f348402ui.setProgressByPlayingTime(MiniAppVideoController.this.player.getDuration(), MiniAppVideoController.this.player.getCurrentPostion());
                }
                EventCollector.getInstance().onStopTrackingTouch(seekBar);
            }
        };
    }

    private AbsVideoPlayer.OnSeekCompleteListener getOnSeekCompleteListener() {
        return new AbsVideoPlayer.OnSeekCompleteListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.11
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnSeekCompleteListener
            public void onSeekComplete(AbsVideoPlayer absVideoPlayer) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MiniAppVideoController.this.f348402ui.hideLoadingView();
                    }
                });
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", MiniAppVideoController.this.data);
                    MiniAppVideoController.this.evaluateSubscribeJS("onVideoSeeked", jSONObject.toString());
                    QMLog.d(MiniAppVideoController.TAG, "evaluateSubcribeJS onVideoSeeked = " + jSONObject);
                } catch (JSONException e16) {
                    QMLog.e(MiniAppVideoController.TAG, "getOnSeekCompleteListener error!", e16);
                }
            }
        };
    }

    private AbsVideoPlayer.OnVideoPreparedListener getOnVideoPreparedListener() {
        return new AbsVideoPlayer.OnVideoPreparedListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.7
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoPreparedListener
            public void onVideoPrepared(final AbsVideoPlayer absVideoPlayer) {
                MiniAppVideoController.this.isVideoPrepared = true;
                if (MiniAppVideoController.this.playingBefore) {
                    try {
                        MiniAppVideoController.this.isBufferStart = false;
                        MiniAppVideoController.this.playingBefore = true;
                        MiniAppVideoController.this.callbackOnVideoWaiting();
                        MiniAppVideoController.this.updateBufferProgress(false);
                        if (MiniAppVideoController.this.needPauseOnLoad) {
                            if (absVideoPlayer.isPlaying()) {
                                absVideoPlayer.pause();
                            }
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MiniAppVideoController.this.f348402ui.hideLoadingView();
                                }
                            });
                            MiniAppVideoController.this.needPauseOnLoad = false;
                        } else {
                            absVideoPlayer.start();
                            MiniAppVideoController.this.callbackOnVideoPlay();
                            MiniAppVideoController.this.getCachedCaptureImage();
                            ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.7.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    MiniAppVideoController.this.f348402ui.hideVideoPosterImg();
                                    MiniAppVideoController.this.f348402ui.showPopCtrViewThenAutoHide(MiniAppVideoController.this.config);
                                    MiniAppVideoController.this.f348402ui.hideLoadingView();
                                    long duration = absVideoPlayer.getDuration();
                                    MiniAppVideoController.this.f348402ui.updatePlayingTime(MiniAppVideoController.parseTimeString(absVideoPlayer.getCurrentPostion()));
                                    MiniAppVideoController.this.f348402ui.setProgressByPlayingTime(duration, absVideoPlayer.getCurrentPostion());
                                    long screenWidth = (ImmersiveUtils.getScreenWidth() * 2) / 3;
                                    if (duration >= 0 && MiniAppVideoController.this.config.showProgress) {
                                        if (MiniAppVideoController.this.isActivityRefValid() && DisplayUtil.dip2px((Context) MiniAppVideoController.this.mActivityRef.get(), MiniAppVideoController.this.config.videoWidth) < screenWidth && !MiniAppVideoController.this.config.isFullScreen) {
                                            MiniAppVideoController.this.config.hideTimeDesc = true;
                                            MiniAppVideoController.this.f348402ui.setSeekBarGone();
                                        } else {
                                            MiniAppVideoController.this.config.hideTimeDesc = false;
                                            MiniAppVideoController.this.f348402ui.setSeekBarVisible();
                                            MiniAppVideoController.this.f348402ui.updateTotalTimeText(MiniAppVideoController.parseTimeString(duration));
                                        }
                                    } else {
                                        MiniAppVideoController.this.f348402ui.setSeekBarInvisible();
                                    }
                                    MiniAppVideoController.this.f348402ui.resetControlIvDrawable(true);
                                    MiniAppVideoController.this.config.isBarrageOpen = MiniAppVideoController.this.f348402ui.getIsBarrageOn();
                                    MiniAppVideoController.this.f348402ui.resetWindowIvDrawable(MiniAppVideoController.this.config);
                                    MiniAppVideoController.this.f348402ui.resetBarrageDrawable(MiniAppVideoController.this.config);
                                    MiniAppVideoController.this.isChangingProgress = false;
                                }
                            }, 200L);
                            MiniAppVideoController.this.sendPlayingMsg(200L);
                        }
                        while (MiniAppVideoController.this.taskQueueRunAfterVideoPrepared.size() > 0) {
                            MiniAppVideoController.this.handler.sendMessage((Message) MiniAppVideoController.this.taskQueueRunAfterVideoPrepared.poll());
                        }
                    } catch (JSONException e16) {
                        QMLog.e(MiniAppVideoController.TAG, "getOnVideoPreparedListener error!", e16);
                    }
                }
            }
        };
    }

    private AbsVideoPlayer.OnVideoViewInitListener getOnVideoViewInitListener() {
        return new AbsVideoPlayer.OnVideoViewInitListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.1
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AbsVideoPlayer.OnVideoViewInitListener
            public void onVideoViewInit(final View view) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (view == null) {
                            QMLog.e(MiniAppVideoController.TAG, "onVideoViewInit view is null?!");
                            return;
                        }
                        MiniAppVideoController.this.player.setupPlayer(MiniAppVideoController.this.config, MiniAppVideoController.this.listenerHolder);
                        MiniAppVideoController.this.f348402ui.setUpVideoView(view, MiniAppVideoController.this.config);
                        MiniAppVideoController.this.f348402ui.updateCenterBtn(MiniAppVideoController.this.config);
                        MiniAppVideoController miniAppVideoController = MiniAppVideoController.this;
                        miniAppVideoController.initPoster(miniAppVideoController.config);
                        if (MiniAppVideoController.this.mCurrPos > 0 && MiniAppVideoController.this.isWifiConnect()) {
                            QMLog.d(MiniAppVideoController.TAG, "play current pos is: " + MiniAppVideoController.this.mCurrPos);
                            MiniAppVideoController miniAppVideoController2 = MiniAppVideoController.this;
                            miniAppVideoController2.play(miniAppVideoController2.mCurrPos);
                            MiniAppVideoController.this.f348402ui.resetControlIvDrawable(MiniAppVideoController.this.isPause ^ true);
                            MiniAppVideoController miniAppVideoController3 = MiniAppVideoController.this;
                            miniAppVideoController3.needPauseOnLoad = miniAppVideoController3.isPause;
                        }
                    }
                });
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getSuperMsg(int i3) {
        if (i3 == 112) {
            return 21;
        }
        if (i3 == 113) {
            return 22;
        }
        return i3;
    }

    private VideoGestureRelativeLayout.VideoGestureListener getVideoGestureListener() {
        return new VideoGestureRelativeLayout.VideoGestureListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.3
            @Override // com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
            public void onBrightnessGesture(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                MiniAppVideoController.this.f348402ui.onBrightnessGesture(MiniAppVideoController.this.config, motionEvent, motionEvent2, f16, f17);
            }

            @Override // com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
            public void onDoubleTapGesture(MotionEvent motionEvent) {
                if (MiniAppVideoController.this.config.enablePlayGesture) {
                    MiniAppVideoController.this.operate();
                    MiniAppVideoController.this.f348402ui.onDoubleTapGesture(MiniAppVideoController.this.config, MiniAppVideoController.this.player.isPlaying());
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
            public void onDown(MotionEvent motionEvent) {
                if (!MiniAppVideoController.this.isActivityRefValid()) {
                    QMLog.e(MiniAppVideoController.TAG, "onDown mActivityRef is invalid!");
                    return;
                }
                MiniAppVideoController.this.f348402ui.onDown(SystemMethodProxy.getStreamVolume(MiniAppVideoController.this.mAudioManager, 3), Settings.System.getInt(((Activity) MiniAppVideoController.this.mActivityRef.get()).getContentResolver(), "screen_brightness", 255));
            }

            @Override // com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
            public void onEndFF_REW(MotionEvent motionEvent) {
                MiniAppVideoController.this.f348402ui.onEndFF_REW(motionEvent);
            }

            @Override // com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
            public void onProgressGesture(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                MiniAppVideoController.this.f348402ui.onProgressGesture(MiniAppVideoController.this.config, motionEvent, motionEvent2, f16, f17);
                if (MiniAppVideoController.this.player != null) {
                    MiniAppVideoController.this.seekTo((((int) MiniAppVideoController.this.player.getDuration()) * MiniAppVideoController.this.f348402ui.getGestureProgress()) / 100);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
            public void onSingleTapGesture(MotionEvent motionEvent) {
                MiniAppVideoController.this.f348402ui.onSingleTapGesture(MiniAppVideoController.this.config, motionEvent);
            }

            @Override // com.tencent.qqmini.sdk.launcher.widget.VideoGestureRelativeLayout.VideoGestureListener
            public void onVolumeGesture(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                MiniAppVideoController.this.f348402ui.onVolumeGesture(MiniAppVideoController.this.config, motionEvent, motionEvent2, f16, f17, MiniAppVideoController.this.maxVolume, MiniAppVideoController.this.mAudioManager);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handlePlayBtnClick() {
        if (this.f348402ui.getStatusImgVisibility() == 0) {
            if (this.config.initialTime > 0.0d && getCurrentPos() == 0) {
                play((long) (this.config.initialTime * 1000.0d));
            } else {
                play(getCurrentPos());
            }
        }
    }

    private void initPlayer(MiniAppVideoConfig miniAppVideoConfig) {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "initPlayer mActivityRef is invalid!");
            return;
        }
        AudioManager audioManager = (AudioManager) this.mActivityRef.get().getSystemService("audio");
        this.mAudioManager = audioManager;
        if (audioManager != null) {
            this.maxVolume = audioManager.getStreamMaxVolume(3);
        }
        this.player = new IVideoPlayerImpl(this.mActivityRef.get());
        MiniAppVideoPlayerListenerHolder initPlayerListenerHolder = initPlayerListenerHolder();
        this.listenerHolder = initPlayerListenerHolder;
        this.player.createVideoView(initPlayerListenerHolder.onVideoViewInitListener, miniAppVideoConfig.underGameView);
    }

    private MiniAppVideoPlayerListenerHolder initPlayerListenerHolder() {
        return new MiniAppVideoPlayerListenerHolder.Builder().setOnVideoViewInitListener(getOnVideoViewInitListener()).setOnControllerClickListener(getOnControllerClickListener()).setOnVideoPreparedListener(getOnVideoPreparedListener()).setOnCompletionListener(getOnCompletionListener()).setOnErrorListener(getOnErrorListener()).setOnInfoListener(getOnInfoListener()).setOnSeekCompleteListener(getOnSeekCompleteListener()).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPoster(MiniAppVideoConfig miniAppVideoConfig) {
        if (!miniAppVideoConfig.autoplay) {
            if (!StringUtil.isEmpty(miniAppVideoConfig.poster)) {
                setPoster();
            } else if (!StringUtil.isEmpty(miniAppVideoConfig.mUrls)) {
                MediaUtils.getImageForVideo(this.miniAppContext, miniAppVideoConfig.mUrls, new MediaUtils.OnLoadVideoImageListener() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.13
                    @Override // com.tencent.qqmini.sdk.widget.media.MediaUtils.OnLoadVideoImageListener
                    public void onLoadImage(File file) {
                        if (file != null) {
                            MiniAppVideoController.this.f348402ui.setPoster(ImageUtil.getLocalBitmap(file.getAbsolutePath()));
                        }
                    }
                });
            }
        }
    }

    private void initUI() {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "initUI mActivityRef is invalid!");
            return;
        }
        IVideoPlayerUIImpl iVideoPlayerUIImpl = new IVideoPlayerUIImpl(this.mActivityRef);
        this.f348402ui = iVideoPlayerUIImpl;
        iVideoPlayerUIImpl.setController(this);
        this.f348402ui.setUpUI(getClickListener(), getVideoGestureListener(), getOnSeekBarChangeListener());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isActivityRefValid() {
        WeakReference<Activity> weakReference = this.mActivityRef;
        if (weakReference != null && weakReference.get() != null) {
            return true;
        }
        return false;
    }

    private boolean isLandscapeVideo() {
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer != null) {
            int videoWidth = iVideoPlayer.getVideoWidth();
            int videoHeight = this.player.getVideoHeight();
            if (videoWidth == 0 || videoHeight == 0) {
                videoWidth = this.originWidth;
                videoHeight = this.originHeight;
            }
            int i3 = this.rotation;
            if (i3 != 0 && i3 != 180) {
                if (videoWidth > videoHeight) {
                    return false;
                }
            } else if (videoWidth < videoHeight) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void parseOriVideoSize(String str) {
        FileInputStream fileInputStream;
        MediaExtractor mediaExtractor;
        Throwable th5;
        if (!TextUtils.isEmpty(str) && str.startsWith("wxfile")) {
            try {
                fileInputStream = new FileInputStream(this.config.mUrls);
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                mediaExtractor = null;
            }
            try {
                mediaExtractor = new MediaExtractor();
            } catch (Throwable th7) {
                th = th7;
                mediaExtractor = null;
                th5 = th;
                try {
                    Log.e(TAG, "parseOriVideoSize: ", th5);
                    if (fileInputStream != null) {
                    }
                    if (mediaExtractor == null) {
                    }
                    mediaExtractor.release();
                } finally {
                }
            }
            try {
                mediaExtractor.setDataSource(fileInputStream.getFD());
                int andSelectVideoTrackIndex = getAndSelectVideoTrackIndex(mediaExtractor);
                if (andSelectVideoTrackIndex > -1) {
                    MediaFormat trackFormat = mediaExtractor.getTrackFormat(andSelectVideoTrackIndex);
                    if (trackFormat.containsKey("rotation-degrees")) {
                        this.rotation = trackFormat.getInteger("rotation-degrees");
                    }
                    this.originWidth = trackFormat.getInteger("width");
                    this.originHeight = trackFormat.getInteger("height");
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused) {
                    mediaExtractor.release();
                }
            } catch (Throwable th8) {
                th5 = th8;
                Log.e(TAG, "parseOriVideoSize: ", th5);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                if (mediaExtractor == null) {
                    return;
                }
                mediaExtractor.release();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String parseTimeString(long j3) {
        long j16 = j3 / 1000;
        if (j3 % 1000 != 0) {
            j16++;
        }
        return parseTwoBitNumString(j16 / 60) + ":" + parseTwoBitNumString((int) (j16 % 60));
    }

    private static String parseTwoBitNumString(long j3) {
        if (j3 == 0) {
            return "00";
        }
        if (j3 < 10) {
            return "0" + j3;
        }
        return Long.toString(j3);
    }

    private String parseUrl(String str) {
        IMiniAppContext iMiniAppContext = this.miniAppContext;
        if (iMiniAppContext != null) {
            return ((MiniAppFileManager) iMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
        }
        return null;
    }

    private void pause() {
        QMLog.d(TAG, "pause");
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer == null) {
            return;
        }
        this.playingBefore = false;
        if (!iVideoPlayer.isPlaying()) {
            return;
        }
        cancelAvoidLockScreen();
        this.player.pause();
        this.isPause = true;
        IMiniAppContext iMiniAppContext = this.miniAppContext;
        if (iMiniAppContext != null && iMiniAppContext.isMiniGame()) {
            callbackVideoStateChange("pause");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("videoId", this.videoPlayerId);
            jSONObject.put("data", this.data);
            evaluateSubscribeJS("onVideoPause", jSONObject.toString());
        } catch (JSONException e16) {
            QMLog.e(TAG, "pause error!", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPlayingMsg(long j3) {
        Message obtain = Message.obtain();
        obtain.what = 2002;
        this.handler.sendMessageDelayed(obtain, j3);
    }

    private void setPoster() {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "setPoster mActivityRef is invalid!");
            return;
        }
        Drawable drawable = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mActivityRef.get(), this.config.poster, 0, 0, null);
        if (drawable != null) {
            this.f348402ui.setPoster(drawable);
        }
    }

    private void start() {
        QMLog.d(TAG, "start");
        avoidLockScreen();
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer != null && iVideoPlayer.getCurrentPostion() > 0) {
            this.player.start();
            IMiniAppContext iMiniAppContext = this.miniAppContext;
            if (iMiniAppContext != null && iMiniAppContext.isMiniGame()) {
                callbackVideoStateChange("play");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", this.data);
                    evaluateSubscribeJS("onVideoPlay", jSONObject.toString());
                    QMLog.d(TAG, "evaluateSubcribeJS onVideoPlay = " + jSONObject.toString());
                } catch (JSONException e16) {
                    QMLog.e(TAG, "start error!", e16);
                }
            }
        } else {
            play((long) (this.config.initialTime * 1000.0d));
        }
        this.isPause = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void switchScreenSize() {
        if (this.config.isFullScreen) {
            smallScreen();
        } else {
            fullScreen();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBufferProgress(boolean z16) {
        Runnable runnable = new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.12
            @Override // java.lang.Runnable
            public void run() {
                int i3;
                if (!MiniAppVideoController.this.isBufferStart && MiniAppVideoController.this.lastBufferProgress == 0) {
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", MiniAppVideoController.this.data);
                    if (MiniAppVideoController.this.isBufferStart) {
                        i3 = MiniAppVideoController.this.lastBufferProgress;
                    } else {
                        i3 = 100;
                    }
                    jSONObject.put(InnerAudioPlugin.AUDIO_PROPERTY_BUFFERED, i3);
                    jSONObject.put("videoId", MiniAppVideoController.this.videoPlayerId);
                    MiniAppVideoController.this.evaluateSubscribeJS("onVideoProgress", jSONObject.toString());
                } catch (JSONException e16) {
                    QMLog.e(MiniAppVideoController.TAG, "updateBufferProgress error!", e16);
                }
                if (!MiniAppVideoController.this.isBufferStart) {
                    MiniAppVideoController.this.lastBufferProgress = 0;
                    return;
                }
                if (MiniAppVideoController.this.lastBufferProgress > 98) {
                    return;
                }
                if (MiniAppVideoController.this.lastBufferProgress < 60) {
                    MiniAppVideoController.this.lastBufferProgress += 10;
                } else if (MiniAppVideoController.this.lastBufferProgress < 90) {
                    MiniAppVideoController.this.lastBufferProgress += 5;
                } else {
                    MiniAppVideoController.access$3308(MiniAppVideoController.this);
                }
                MiniAppVideoController.this.updateBufferProgress(true);
            }
        };
        if (!z16) {
            runnable.run();
        } else if (this.isBufferStart || this.lastBufferProgress != 0) {
            ThreadManager.getUIHandler().postDelayed(runnable, 20L);
        }
    }

    private void updatePoster(MiniAppVideoConfig miniAppVideoConfig) {
        String str = miniAppVideoConfig.poster;
        if (str != null && !str.equals(miniAppVideoConfig.lastPoster)) {
            setPoster();
        }
        miniAppVideoConfig.lastPoster = miniAppVideoConfig.poster;
    }

    public void captureImage(AbsVideoPlayer.OnCaptureImageListener onCaptureImageListener) {
        if (onCaptureImageListener == null) {
            QMLog.e(TAG, "captureImage onCaptureImageListener is null");
            return;
        }
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer == null) {
            QMLog.e(TAG, "captureImage video player is null");
            onCaptureImageListener.onCaptureImageFailed();
            return;
        }
        try {
            if (!iVideoPlayer.isPlaying()) {
                Bitmap bitmap = this.cachedCaptureImage;
                if (bitmap != null && !bitmap.isRecycled()) {
                    onCaptureImageListener.onCaptureImageSucceed(this.cachedCaptureImage);
                    return;
                } else {
                    onCaptureImageListener.onCaptureImageFailed();
                    return;
                }
            }
            int playerViewWidth = this.f348402ui.getPlayerViewWidth();
            int playerViewHeight = this.f348402ui.getPlayerViewHeight();
            this.player.setOnCaptureImageListener(getCaptureImageListener(onCaptureImageListener));
            this.player.captureImageInTime(playerViewWidth, playerViewHeight);
        } catch (Exception e16) {
            QMLog.e(TAG, "captureImage video player fail!,e" + e16);
            onCaptureImageListener.onCaptureImageFailed();
        }
    }

    public void fullScreen() {
        if (!this.isVideoPrepared) {
            Message message = new Message();
            message.what = 2004;
            this.taskQueueRunAfterVideoPrepared.add(message);
        } else {
            if (this.isBusyInChangeScreen) {
                return;
            }
            QMLog.e("fullScreen - fullScreen()", "fullScreen() - config.isFullScreen = true");
            this.config.isFullScreen = true;
            final boolean isLandscapeVideo = isLandscapeVideo();
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.20
                @Override // java.lang.Runnable
                public void run() {
                    MiniAppVideoController.this.f348402ui.fullScreen(MiniAppVideoController.this.config, MiniAppVideoController.this.miniAppContext, isLandscapeVideo, MiniAppVideoController.parseTimeString(MiniAppVideoController.this.player.getCurrentPostion()));
                    MiniAppVideoController.this.callBackFullScreenChange(isLandscapeVideo);
                }
            });
        }
    }

    public long getCurrentPos() {
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer == null) {
            return 0L;
        }
        return iVideoPlayer.getCurrentPostion();
    }

    public FrameLayout getUI() {
        IVideoPlayerUI iVideoPlayerUI = this.f348402ui;
        if (iVideoPlayerUI != null) {
            return iVideoPlayerUI.getUI();
        }
        QMLog.e(TAG, "IVideoPlayerUI is null when doing getUI()!");
        return null;
    }

    public Observer getVideoPlayerStatusObserver() {
        if (this.videoPlayerStatusObserver == null) {
            this.videoPlayerStatusObserver = new Observer() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.14
                @Override // java.util.Observer
                public void update(Observable observable, Object obj) {
                    if (!(obj instanceof String)) {
                        return;
                    }
                    String str = (String) obj;
                    if (MiniAppVideoConstants.NOTIFY_STATUS_RESET.equals(str) && MiniAppVideoController.this.config.autoPauseIfNavigate) {
                        MiniAppVideoController.this.smallScreen();
                        MiniAppVideoController.this.stop();
                    } else {
                        MiniAppVideoConstants.NOTIFY_STATUS_RESUME.equals(str);
                    }
                }
            };
        }
        return this.videoPlayerStatusObserver;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 2002) {
            if (i3 != 2004) {
                return false;
            }
            fullScreen();
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer != null && iVideoPlayer.isPlaying()) {
            this.f348402ui.updatePlayingTime(parseTimeString(this.player.getCurrentPostion()));
            this.f348402ui.updateDanmuTime(this.player.getCurrentPostion());
            if (!this.isChangingProgress) {
                this.f348402ui.setProgressByPlayingTime(this.player.getDuration(), this.player.getCurrentPostion());
            }
            IMiniAppContext iMiniAppContext = this.miniAppContext;
            if (iMiniAppContext != null && iMiniAppContext.isMiniGame()) {
                callbackVideoStateChange("timeUpdate");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", this.data);
                    jSONObject.put("position", this.player.getCurrentPostion() / 1000.0d);
                    jSONObject.put("duration", this.player.getDuration() / 1000.0d);
                    jSONObject.put("videoId", this.videoPlayerId);
                    evaluateSubscribeJS("onVideoTimeUpdate", jSONObject.toString());
                } catch (JSONException e16) {
                    QMLog.e(TAG, "handleMessage MSG_WHAT_PLAYING error!", e16);
                }
            }
        }
        if (!this.isPause) {
            sendPlayingMsg((currentTimeMillis + 200) - System.currentTimeMillis());
        }
        return true;
    }

    public void initVideoPlayerSettings(JSONObject jSONObject) {
        updateConfig(jSONObject);
        initPlayer(this.config);
        updateVideoPlayerSettings(jSONObject);
    }

    public boolean isFullScreen() {
        return this.config.isFullScreen;
    }

    public boolean isPageBackground() {
        return this.isPageBackground;
    }

    public boolean isPlaying() {
        return false;
    }

    public boolean isWifiConnect() {
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "isWifiConnect mActivityRef is invalid!");
            return false;
        }
        return ((ConnectivityManager) this.mActivityRef.get().getSystemService("connectivity")).getNetworkInfo(1).isConnected();
    }

    public void onPageBackground() {
        this.isPageBackground = true;
        if (this.config.autoPauseIfOpenNative && !this.isAutoPausedOnBackground) {
            this.isAutoPausedOnBackground = pauseWithUi();
        }
    }

    public void onPageForeground() {
        this.isPageBackground = false;
        if (this.isAutoPausedOnBackground && this.player != null) {
            this.f348402ui.changeState();
        }
    }

    public void operate() {
        QMLog.d(TAG, "operate");
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer == null) {
            return;
        }
        if (iVideoPlayer.isPlaying()) {
            pause();
        } else {
            start();
            sendPlayingMsg(200L);
        }
    }

    public boolean pauseWithUi() {
        boolean isPlaying = this.player.isPlaying();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.17
            @Override // java.lang.Runnable
            public void run() {
                MiniAppVideoController.this.player.pause();
                MiniAppVideoController.this.f348402ui.setVideoPauseImg();
                QMLog.d(MiniAppVideoController.TAG, "pauseWithUi");
            }
        });
        return isPlaying;
    }

    public void play() {
        play(getCurrentPos());
    }

    public void playDanmu(String str, int i3) {
        this.f348402ui.showBarrageNextTime(str, i3);
    }

    public boolean playWithUi() {
        if (!this.player.isPlaying()) {
            this.f348402ui.changeState();
            return true;
        }
        return false;
    }

    public void release() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.16
            @Override // java.lang.Runnable
            public void run() {
                MiniAppVideoController.this.f348402ui.release();
                MiniAppVideoController.this.player.release();
                MiniAppVideoController.this.cancelAvoidLockScreen();
            }
        });
        this.handler.removeMessages(2002);
    }

    public boolean seekTo(int i3) {
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer == null) {
            return false;
        }
        if (i3 < 0) {
            iVideoPlayer.seekTo(0);
            return true;
        }
        long duration = iVideoPlayer.getDuration();
        if (duration > 0 && i3 > duration) {
            this.player.seekTo((int) duration);
            return true;
        }
        this.config.initialTime = i3 / 1000.0d;
        if (duration > 0) {
            this.player.seekTo(i3);
        }
        return true;
    }

    public void setData(String str) {
        this.data = str;
    }

    public void setJsService(IJsService iJsService) {
        this.jsService = iJsService;
    }

    public void setMiniAppContext(IMiniAppContext iMiniAppContext) {
        this.miniAppContext = iMiniAppContext;
    }

    public void setPageWebViewId(int i3) {
        this.webViewId = i3;
    }

    public void setVideoPath(String str) {
        QMLog.d(TAG, "setVideoPath: " + str);
        this.isPause = false;
        this.isVideoPrepared = false;
        if (isPlaying()) {
            stop(false);
        }
        this.f348402ui.updateCenterBtn(this.config);
        this.f348402ui.hideControllerPopContainer();
        this.handler.removeMessages(2002);
        this.config.mUrls = parseUrl(str);
        MiniAppVideoConfig miniAppVideoConfig = this.config;
        if (miniAppVideoConfig.isResetPath || miniAppVideoConfig.autoplay) {
            this.handler.postDelayed(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.21
                @Override // java.lang.Runnable
                public void run() {
                    QMLog.i(MiniAppVideoController.TAG, "player is reset and autoplay");
                    MiniAppVideoController miniAppVideoController = MiniAppVideoController.this;
                    miniAppVideoController.play((long) (miniAppVideoController.config.initialTime * 1000.0d));
                }
            }, 100L);
        }
        this.config.isResetPath = true;
        this.rotation = 0;
        parseOriVideoSize(str);
    }

    public void setVideoPlayerId(int i3) {
        this.videoPlayerId = i3;
    }

    public void smallScreen() {
        this.mCurrPos = this.player.getCurrentPostion();
        QMLog.d(TAG, "smallScreen current pos is: " + this.mCurrPos);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.6
            @Override // java.lang.Runnable
            public void run() {
                MiniAppVideoController.this.f348402ui.smallScreen(MiniAppVideoController.this.miniAppContext, MiniAppVideoController.this.config);
                MiniAppVideoController.this.callBackFullScreenChange();
            }
        });
    }

    public void stop() {
        stop(true);
    }

    public void updateConfig(JSONObject jSONObject) {
        this.config.initSetting(jSONObject);
    }

    public void updateVideoPlayerSettings(JSONObject jSONObject) {
        this.f348402ui.updateVideoGestureSetting(this.config);
        this.player.updateObjFit(this.config);
        this.player.updateMute(this.config);
        this.f348402ui.updateControllerView(this.config);
        this.f348402ui.resetMuteImage(this.config, this.player.getOutputMute());
        this.f348402ui.updateVideoPosition(this.config, this.miniAppContext.isMiniGame());
        updatePoster(this.config);
    }

    private void stop(boolean z16) {
        if (z16 && this.config.isFullScreen) {
            smallScreen();
        }
        this.isVideoPrepared = false;
        IVideoPlayer iVideoPlayer = this.player;
        if (iVideoPlayer != null) {
            iVideoPlayer.stop();
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.widget.media.MiniAppVideoController.15
            @Override // java.lang.Runnable
            public void run() {
                MiniAppVideoController.this.f348402ui.hideLoadingView();
                MiniAppVideoController.this.cancelAvoidLockScreen();
            }
        });
    }

    public void play(long j3) {
        if (this.player == null || StringUtil.isEmpty(this.config.mUrls)) {
            return;
        }
        if (!isActivityRefValid()) {
            QMLog.e(TAG, "play mActivityRef is invalid!");
            return;
        }
        this.isBufferStart = true;
        updateBufferProgress(false);
        avoidLockScreen();
        this.playingBefore = true;
        this.isVideoPrepared = false;
        this.player.stop();
        if (this.config.enableDanmu) {
            this.player.startPlayDanmu();
        }
        IVideoPlayer iVideoPlayer = this.player;
        Activity activity = this.mActivityRef.get();
        MiniAppVideoConfig miniAppVideoConfig = this.config;
        iVideoPlayer.openMediaPlayerByUrl(activity, miniAppVideoConfig.mUrls, j3, miniAppVideoConfig.provisionUrl, miniAppVideoConfig.licenseUrl, Boolean.valueOf(miniAppVideoConfig.isDrm));
        this.f348402ui.showLoadingView();
        this.f348402ui.hidePlayerStatusImg();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackFullScreenChange(boolean z16) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("data", this.data);
            jSONObject.put("videoId", this.videoPlayerId);
            jSONObject.put("fullScreen", this.config.isFullScreen);
            if (z16) {
                jSONObject.put("direction", "horizontal");
            } else {
                jSONObject.put("direction", "vertical");
            }
            evaluateSubscribeJS("onVideoFullScreenChange", jSONObject.toString());
        } catch (JSONException e16) {
            QMLog.e(TAG, "callBackFullScreenChange error isLandscapeVideo:" + z16, e16);
        }
    }

    public MiniAppVideoController(Activity activity) {
        this.handler = new Handler(Looper.getMainLooper(), this);
        this.isVideoPrepared = false;
        this.isBusyInChangeScreen = false;
        this.isBufferStart = false;
        this.lastBufferProgress = 0;
        this.maxVolume = 0;
        this.oldVolume = 0;
        this.taskQueueRunAfterVideoPrepared = new LinkedList();
        this.mActivityRef = new WeakReference<>(activity);
        this.config = new MiniAppVideoConfig();
        initUI();
    }
}

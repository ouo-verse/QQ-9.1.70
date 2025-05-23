package com.tencent.gdtad.views.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForVideoView;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtImpressionReporter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.qqvideoplatform.api.PlatformInfo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerOption;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.api.TVideoNetInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtVideoView extends FrameLayout implements LifecycleObserver {
    private static final int STATE_DESTROYED = 8;
    private static final int STATE_ERROR = 7;
    private static final int STATE_INITIALIZE_START = 1;
    private static final int STATE_INITIALIZE_SUCCESS = 2;
    private static final int STATE_PAUSED = 5;
    private static final int STATE_PLAYING = 4;
    private static final int STATE_STOPPED = 6;
    private static final int STATE_VIDEO_PREPARED = 3;
    private static final String TAG = "GdtVideoView";
    private ISuperPlayer.OnCompletionListener mCompletionListener;
    private URLImageView mCoverImgView;
    private ISuperPlayer.OnErrorListener mErrorListener;
    private volatile boolean mFirstLoopEndedOnce;
    private final Handler mHandler;
    private ISuperPlayer.OnInfoListener mInfoListener;
    private volatile boolean mIsLoopEnd;
    private volatile boolean mIsVideoViewVisible;
    volatile Long mLastLoopEndTimeStampMs;
    private final List<WeakReference<GdtVideoListener>> mListeners;
    private ISuperPlayer.OnVideoPreparedListener mPreparedListener;
    private GdtVideoReportListenerImp mReportListener;
    private ISuperPlayer.OnTVideoNetInfoListener mTVideoNetInfoListener;
    private volatile boolean mUpdated;
    private GdtVideoData mVideoData;
    private volatile ISuperPlayer mVideoPlayer;
    private final GdtImpressionReporter.GdtVideoReportInfo mVideoReportInfo;
    private volatile int mVideoState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.views.video.GdtVideoView$5, reason: invalid class name */
    /* loaded from: classes6.dex */
    public class AnonymousClass5 implements ISuperPlayer.OnInfoListener {
        AnonymousClass5() {
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnInfoListener
        public boolean onInfo(ISuperPlayer iSuperPlayer, final int i3, long j3, long j16, Object obj) {
            GdtLog.i(GdtVideoView.TAG, "onInfo: what :" + i3 + " arg1 :" + j3 + " arg2 :" + j16 + " extra :" + obj);
            GdtVideoView.this.runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.5.1

                /* compiled from: P */
                /* renamed from: com.tencent.gdtad.views.video.GdtVideoView$5$1$a */
                /* loaded from: classes6.dex */
                class a implements jm0.a {
                    a() {
                    }

                    @Override // jm0.a
                    public void pausePlay() {
                        GdtVideoView.this.pause(false);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    GdtVideoReportListenerImp gdtVideoReportListenerImp = GdtVideoView.this.mReportListener;
                    int i16 = i3;
                    if (i16 != 105) {
                        if (i16 != 107) {
                            if (i16 == 108) {
                                GdtLog.d(GdtVideoView.TAG, "is current loop end :" + GdtVideoView.this.mFirstLoopEndedOnce);
                                GdtVideoView.this.mIsLoopEnd = true;
                                if (System.currentTimeMillis() - GdtVideoView.this.mLastLoopEndTimeStampMs.longValue() > 500 && gdtVideoReportListenerImp != null) {
                                    GdtVideoView.this.mLastLoopEndTimeStampMs = Long.valueOf(System.currentTimeMillis());
                                    QLog.d(GdtVideoView.TAG, 1, "report onCompleted LOOP_END");
                                    gdtVideoReportListenerImp.onCompleted(GdtVideoView.this.mVideoData, GdtVideoView.this.mVideoReportInfo);
                                }
                                if (!GdtVideoView.this.mFirstLoopEndedOnce) {
                                    AdAnalysisHelperForVideoView.reportFirstCompleted(GdtVideoView.this.getContext(), GdtVideoView.this.mUpdated, GdtVideoView.this.mVideoData.getAd());
                                    GdtVideoView.this.notifyFirstTimeLoopEnd();
                                    GdtVideoView.this.mFirstLoopEndedOnce = true;
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ((IGdtAPI) QRoute.api(IGdtAPI.class)).checkAppForegroundState(0, new a());
                        GdtVideoView.this.notifyCurrentLoopStart();
                        return;
                    }
                    GdtLog.d(GdtVideoView.TAG, "first video frame rendered.");
                    if (gdtVideoReportListenerImp != null) {
                        gdtVideoReportListenerImp.onStarted(GdtVideoView.this.mVideoData, GdtVideoView.this.mVideoPlayer.getCurrentPositionMs());
                    }
                    GdtVideoView.this.notifyFirstFrameRendered();
                    AdAnalysisHelperForVideoView.reportFirstFrameRendered(GdtVideoView.this.getContext(), GdtVideoView.this.mUpdated, GdtVideoView.this.mVideoData.getAd());
                }
            });
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface GdtVideoListener {
        void onCompletion();

        void onCurrentLoopStart();

        void onError(AdError adError);

        void onFirstFrameRendered();

        void onFirstTimeLoopEnd();

        void onVideoPrepared();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements ISuperPlayer.OnTVideoNetInfoListener {
        a() {
        }

        @Override // com.tencent.superplayer.api.ISuperPlayer.OnTVideoNetInfoListener
        public void onTVideoNetInfoUpdate(ISuperPlayer iSuperPlayer, TVideoNetInfo tVideoNetInfo) {
            GdtLog.d(GdtVideoView.TAG, "onTVideoNetInfoUpdate");
        }
    }

    public GdtVideoView(@NotNull Context context, @NotNull GdtVideoData gdtVideoData) {
        super(context);
        this.mVideoState = 1;
        this.mUpdated = false;
        this.mFirstLoopEndedOnce = false;
        this.mIsVideoViewVisible = false;
        this.mIsLoopEnd = false;
        this.mListeners = new CopyOnWriteArrayList();
        this.mVideoReportInfo = new GdtImpressionReporter.GdtVideoReportInfo();
        this.mLastLoopEndTimeStampMs = 0L;
        this.mVideoData = new GdtVideoData(gdtVideoData);
        this.mHandler = new Handler(Looper.getMainLooper());
        AdAnalysisHelperForVideoView.reportInitializeStart(context, this.mUpdated, this.mVideoData.getAd());
        initListeners();
        initPlayerSDK(context);
        initVideoReports();
    }

    private boolean canPlay() {
        if (this.mVideoState < 2) {
            GdtLog.e(TAG, "playOnMainThread player not ready : state = " + this.mVideoState);
        } else if (this.mVideoState != 7 && this.mVideoState != 8) {
            if (isPlaying()) {
                GdtLog.e(TAG, "playOnMainThread failed : isPlaying ");
            } else if (this.mVideoPlayer == null) {
                GdtLog.e(TAG, "playOnMainThread failed : mVideoPlayer == null ");
            } else if (this.mVideoState == 3 || this.mVideoState == 5 || this.mVideoState == 6) {
                return true;
            }
        } else {
            GdtLog.e(TAG, "playOnMainThread player invalid : state = " + this.mVideoState);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroyOnMainThread() {
        GdtLog.d(TAG, "destroy");
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.stop();
            this.mVideoPlayer.setOnVideoPreparedListener(null);
            this.mVideoPlayer.setOnCompletionListener(null);
            this.mVideoPlayer.setOnTVideoNetInfoUpdateListener(null);
            this.mVideoPlayer.setOnErrorListener(null);
            this.mVideoPlayer.setOnInfoListener(null);
            this.mVideoPlayer.release();
            this.mVideoPlayer = null;
            this.mVideoState = 8;
        }
        List<WeakReference<GdtVideoListener>> list = this.mListeners;
        if (list != null) {
            list.clear();
        }
        if (this.mReportListener != null) {
            this.mReportListener = null;
        }
        this.mCompletionListener = null;
        removeLifecycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doStartOnMainThread() {
        if (this.mVideoPlayer == null) {
            return;
        }
        if (this.mVideoState == 3 || this.mVideoState == 5 || this.mVideoState == 6) {
            this.mVideoPlayer.setOutputMute(!this.mVideoData.isVolumOpen());
            if (com.tencent.mobileqq.ad.debug.a.f186830a.j()) {
                this.mVideoPlayer.setOutputMute(false);
            }
            this.mVideoPlayer.setLoopback(this.mVideoData.isLoop());
            this.mVideoPlayer.start();
            this.mVideoState = 4;
            hideCoverImg();
        }
    }

    private void hideCoverImg() {
        post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.15
            @Override // java.lang.Runnable
            public void run() {
                if (GdtVideoView.this.mCoverImgView != null) {
                    GdtVideoView.this.mCoverImgView.setVisibility(8);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initCoverImgView(Context context) {
        GdtVideoData gdtVideoData = this.mVideoData;
        if (gdtVideoData != null && !TextUtils.isEmpty(gdtVideoData.getCoverUrl())) {
            GdtLog.e(TAG, "initCoverImgView url :" + this.mVideoData.getCoverUrl());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            URLImageView uRLImageView = new URLImageView(context);
            this.mCoverImgView = uRLImageView;
            uRLImageView.setImageURL(this.mVideoData.getCoverUrl());
            addView(this.mCoverImgView, layoutParams);
        }
    }

    private void initListeners() {
        this.mPreparedListener = new ISuperPlayer.OnVideoPreparedListener() { // from class: com.tencent.gdtad.views.video.GdtVideoView.1
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener
            public void onVideoPrepared(ISuperPlayer iSuperPlayer) {
                GdtVideoView.this.runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        GdtLog.d(GdtVideoView.TAG, "onVideoPrepared mVideoStatus :" + GdtVideoView.this.mVideoState);
                        if (GdtVideoView.this.mVideoState > 3) {
                            GdtVideoView.this.notifyError(new AdError(313), Integer.MIN_VALUE);
                            return;
                        }
                        GdtVideoView.this.mVideoState = 3;
                        long j3 = 0;
                        if (GdtVideoView.this.mVideoData.getDurationMillis() <= 0) {
                            GdtVideoData gdtVideoData = GdtVideoView.this.mVideoData;
                            if (GdtVideoView.this.mVideoPlayer != null) {
                                j3 = GdtVideoView.this.mVideoPlayer.getDurationMs();
                            }
                            gdtVideoData.setDurationMillis(j3);
                        }
                        GdtVideoView.this.notifyPrepared();
                        if (GdtVideoView.this.mVideoData.isVisibleDirectPlay() && GdtVideoView.this.mIsVideoViewVisible) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (GdtVideoView.this.mVideoData.isDirectPlay() || z16) {
                            GdtLog.d(GdtVideoView.TAG, "video ready to play");
                            GdtVideoView.this.doStartOnMainThread();
                        }
                    }
                });
            }
        };
        this.mCompletionListener = new ISuperPlayer.OnCompletionListener() { // from class: com.tencent.gdtad.views.video.GdtVideoView.2
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener
            public void onCompletion(ISuperPlayer iSuperPlayer) {
                GdtVideoView.this.runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtLog.d(GdtVideoView.TAG, "onCompletion");
                        GdtVideoView.this.notifyCompletion();
                    }
                });
            }
        };
        this.mTVideoNetInfoListener = new a();
        this.mErrorListener = new ISuperPlayer.OnErrorListener() { // from class: com.tencent.gdtad.views.video.GdtVideoView.4
            @Override // com.tencent.superplayer.api.ISuperPlayer.OnErrorListener
            public boolean onError(ISuperPlayer iSuperPlayer, final int i3, final int i16, final int i17, final String str) {
                GdtVideoView.this.runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GdtLog.e(GdtVideoView.TAG, "onError module :" + i3 + " errorType :" + i16 + " errorCode :" + i17 + " extraInfo :" + str);
                        GdtVideoView.this.mVideoReportInfo.setErrorTypeFromSP(i16, i17);
                        GdtVideoView.this.notifyError(new AdError(GdtVideoView.mappingErrorCode(i17)), i17);
                    }
                });
                return false;
            }
        };
        this.mInfoListener = new AnonymousClass5();
    }

    private void initPlayerSDK(final Context context) {
        runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.6
            @Override // java.lang.Runnable
            public void run() {
                if (QQVideoPlaySDKManager.isSDKReady()) {
                    GdtVideoView.this.initVideoViewOnMainThread(context);
                } else {
                    GdtVideoView.this.installPlayerSDKOnMainThread(context);
                }
            }
        });
    }

    private void initVideoReports() {
        int i3;
        this.mReportListener = new GdtVideoReportListenerImp(this.mVideoData.getPlayScene());
        GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo = this.mVideoReportInfo;
        if (this.mVideoData.isDirectPlay()) {
            i3 = 11;
        } else {
            i3 = 12;
        }
        gdtVideoReportInfo.setPlayType(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void initVideoViewOnMainThread(@NotNull Context context) {
        observeLifecycle();
        ISPlayerVideoView createPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(context);
        if (createPlayerVideoView instanceof View) {
            View view = (View) createPlayerVideoView;
            view.setBackgroundColor(this.mVideoData.getVideoDefaultBackgroundColor());
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            addView(view, 0);
            this.mVideoPlayer = SuperPlayerFactory.createMediaPlayer(context, 110, createPlayerVideoView);
            if (this.mVideoPlayer == null) {
                GdtLog.i(TAG, "initVideo return mVideoPlayer == null");
                notifyError(new AdError(310), Integer.MIN_VALUE);
                return;
            }
            this.mVideoPlayer.setOnVideoPreparedListener(this.mPreparedListener);
            this.mVideoPlayer.setOnCompletionListener(this.mCompletionListener);
            this.mVideoPlayer.setOnTVideoNetInfoUpdateListener(this.mTVideoNetInfoListener);
            this.mVideoPlayer.setOnErrorListener(this.mErrorListener);
            this.mVideoPlayer.setOnInfoListener(this.mInfoListener);
            this.mVideoState = 2;
            AdAnalysisHelperForVideoView.reportInitializeSuccess(context, this.mUpdated, this.mVideoData.getAd());
            prepare();
            return;
        }
        GdtLog.e(TAG, "!mVideoView instanceof View)");
        notifyError(new AdError(312), Integer.MIN_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void installPlayerSDKOnMainThread(final Context context) {
        GdtLog.i(TAG, "installSDK");
        QQVideoPlaySDKManager.initSDKAsync(context, new SDKInitListener() { // from class: com.tencent.gdtad.views.video.GdtVideoView.7
            @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
            public void onSDKInited(final boolean z16) {
                GdtLog.i(GdtVideoView.TAG, "onSDKInited " + z16);
                GdtVideoView.this.mHandler.post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.7.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!z16) {
                            GdtVideoView.this.notifyError(new AdError(309), Integer.MIN_VALUE);
                        } else {
                            AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                            GdtVideoView.this.initVideoViewOnMainThread(context);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int mappingErrorCode(int i3) {
        if (i3 < 14000100 || i3 > 14000113) {
            if (i3 < 14010001 || i3 > 14010033) {
                if (i3 < 14020001 || i3 > 14020010) {
                    if (i3 >= 14030001 && i3 <= 14030022) {
                        return 3;
                    }
                    return 1;
                }
                return 3;
            }
            return 3;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCompletion() {
        GdtVideoListener gdtVideoListener;
        GdtVideoReportListenerImp gdtVideoReportListenerImp = this.mReportListener;
        if (gdtVideoReportListenerImp != null) {
            gdtVideoReportListenerImp.onCompleted(this.mVideoData, this.mVideoReportInfo);
        }
        AdAnalysisHelperForVideoView.reportFirstCompleted(getContext(), this.mUpdated, this.mVideoData.getAd());
        List<WeakReference<GdtVideoListener>> list = this.mListeners;
        if (list != null && !list.isEmpty()) {
            for (WeakReference<GdtVideoListener> weakReference : this.mListeners) {
                if (weakReference != null) {
                    gdtVideoListener = weakReference.get();
                } else {
                    gdtVideoListener = null;
                }
                if (gdtVideoListener != null) {
                    gdtVideoListener.onCompletion();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyCurrentLoopStart() {
        GdtVideoListener gdtVideoListener;
        for (WeakReference<GdtVideoListener> weakReference : this.mListeners) {
            if (weakReference != null) {
                gdtVideoListener = weakReference.get();
            } else {
                gdtVideoListener = null;
            }
            if (gdtVideoListener != null) {
                gdtVideoListener.onCurrentLoopStart();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyError(AdError adError, int i3) {
        GdtVideoListener gdtVideoListener;
        long j3;
        this.mVideoState = 7;
        showCoverImg();
        GdtVideoReportListenerImp gdtVideoReportListenerImp = this.mReportListener;
        if (gdtVideoReportListenerImp != null) {
            GdtVideoData gdtVideoData = this.mVideoData;
            if (this.mVideoPlayer != null) {
                j3 = this.mVideoPlayer.getCurrentPositionMs();
            } else {
                j3 = 0;
            }
            gdtVideoReportListenerImp.onError(gdtVideoData, j3, this.mVideoReportInfo);
        }
        AdAnalysisHelperForVideoView.reportError(getContext(), adError, i3, this.mUpdated, this.mVideoData.getAd());
        List<WeakReference<GdtVideoListener>> list = this.mListeners;
        if (list != null && !list.isEmpty()) {
            for (WeakReference<GdtVideoListener> weakReference : this.mListeners) {
                if (weakReference != null) {
                    gdtVideoListener = weakReference.get();
                } else {
                    gdtVideoListener = null;
                }
                if (gdtVideoListener != null) {
                    gdtVideoListener.onError(adError);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFirstFrameRendered() {
        GdtVideoListener gdtVideoListener;
        for (WeakReference<GdtVideoListener> weakReference : this.mListeners) {
            if (weakReference != null) {
                gdtVideoListener = weakReference.get();
            } else {
                gdtVideoListener = null;
            }
            if (gdtVideoListener != null) {
                gdtVideoListener.onFirstFrameRendered();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFirstTimeLoopEnd() {
        GdtVideoListener gdtVideoListener;
        for (WeakReference<GdtVideoListener> weakReference : this.mListeners) {
            if (weakReference != null) {
                gdtVideoListener = weakReference.get();
            } else {
                gdtVideoListener = null;
            }
            if (gdtVideoListener != null) {
                gdtVideoListener.onFirstTimeLoopEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyPrepared() {
        GdtVideoListener gdtVideoListener;
        AdAnalysisHelperForVideoView.reportInitializeSuccess(getContext(), this.mUpdated, this.mVideoData.getAd());
        List<WeakReference<GdtVideoListener>> list = this.mListeners;
        if (list != null && !list.isEmpty()) {
            for (WeakReference<GdtVideoListener> weakReference : this.mListeners) {
                if (weakReference != null) {
                    gdtVideoListener = weakReference.get();
                } else {
                    gdtVideoListener = null;
                }
                if (gdtVideoListener != null) {
                    gdtVideoListener.onVideoPrepared();
                }
            }
        }
    }

    private void observeLifecycle() {
        Object context = getContext();
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().addObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseOnMainThread() {
        if (this.mVideoState != 7 && this.mVideoState != 8) {
            if (isPlaying()) {
                if (this.mVideoPlayer != null) {
                    GdtLog.d(TAG, "pause");
                    this.mVideoPlayer.pause();
                    this.mVideoState = 5;
                    GdtVideoReportListenerImp gdtVideoReportListenerImp = this.mReportListener;
                    if (gdtVideoReportListenerImp != null) {
                        gdtVideoReportListenerImp.onStopped(this.mVideoData, this.mVideoPlayer.getCurrentPositionMs(), this.mVideoReportInfo);
                        return;
                    }
                    return;
                }
                return;
            }
            GdtLog.d(TAG, "can not pause, video is not playing");
            return;
        }
        GdtLog.e(TAG, "pauseOnMainThread failed : player invalid");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void playOnMainThread() {
        if (canPlay()) {
            doStartOnMainThread();
        }
    }

    private void prepare() {
        SuperPlayerVideoInfo createVideoInfoForTVideo;
        String url = this.mVideoData.getUrl();
        String vid = this.mVideoData.getVid();
        GdtLog.d(TAG, "play url :" + url);
        if (!TextUtils.isEmpty(url)) {
            createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForUrl(url, 104, (String) null, (String) null);
        } else if (!TextUtils.isEmpty(vid)) {
            createVideoInfoForTVideo = SuperPlayerFactory.createVideoInfoForTVideo(PlatformInfo.ID_QQGAME, vid);
        } else {
            notifyError(new AdError(311), Integer.MIN_VALUE);
            return;
        }
        SuperPlayerVideoInfo superPlayerVideoInfo = createVideoInfoForTVideo;
        if (this.mVideoPlayer != null) {
            SuperPlayerOption obtain = SuperPlayerOption.obtain();
            obtain.accurateSeekOnOpen = true;
            this.mVideoPlayer.openMediaPlayer(getContext(), superPlayerVideoInfo, this.mVideoData.getStartPositionMillis(), obtain);
        }
    }

    private void removeLifecycle() {
        Object context = getContext();
        if (context instanceof LifecycleOwner) {
            ((LifecycleOwner) context).getLifecycle().removeObserver(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runOnMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekToOnMainThread(int i3) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.seekTo(i3);
        }
    }

    private void showCoverImg() {
        post(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.14
            @Override // java.lang.Runnable
            public void run() {
                if (GdtVideoView.this.mCoverImgView == null) {
                    GdtVideoView gdtVideoView = GdtVideoView.this;
                    gdtVideoView.initCoverImgView(gdtVideoView.getContext());
                } else {
                    GdtVideoView.this.mCoverImgView.setVisibility(0);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopOnMainThread(boolean z16) {
        if (this.mVideoState != 7 && this.mVideoState != 8) {
            if (isPlaying()) {
                if (this.mVideoPlayer != null) {
                    GdtLog.d(TAG, "stop");
                    this.mVideoPlayer.stop();
                    this.mVideoState = 6;
                    GdtVideoReportListenerImp gdtVideoReportListenerImp = this.mReportListener;
                    if (gdtVideoReportListenerImp != null && z16) {
                        gdtVideoReportListenerImp.onStopped(this.mVideoData, this.mVideoPlayer.getCurrentPositionMs(), this.mVideoReportInfo);
                        return;
                    }
                    return;
                }
                return;
            }
            GdtLog.d(TAG, "can not pause, video is not playing");
            return;
        }
        GdtLog.e(TAG, "stopOnMainThread failed : player invalid");
    }

    private void updateData(final GdtVideoData gdtVideoData) {
        runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.13
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView.this.updateDataOnMainThread(gdtVideoData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateDataOnMainThread(GdtVideoData gdtVideoData) {
        GdtVideoData gdtVideoData2;
        GdtLog.d(TAG, "update data isPlaying :" + isPlaying() + " state :" + this.mVideoState);
        if (this.mVideoState == 8) {
            GdtLog.e(TAG, "updateDataOnMainThread failed : player invalid");
            return;
        }
        if (this.mVideoState >= 2) {
            this.mVideoState = 2;
        }
        if (gdtVideoData != null) {
            gdtVideoData2 = new GdtVideoData(gdtVideoData);
        } else {
            gdtVideoData2 = this.mVideoData;
        }
        this.mVideoData = gdtVideoData2;
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.reset();
        }
        List<WeakReference<GdtVideoListener>> list = this.mListeners;
        if (list != null) {
            list.clear();
        }
        GdtImpressionReporter.GdtVideoReportInfo gdtVideoReportInfo = this.mVideoReportInfo;
        if (gdtVideoReportInfo != null) {
            gdtVideoReportInfo.resetAll();
        }
        this.mUpdated = true;
        this.mFirstLoopEndedOnce = false;
        prepare();
    }

    private void updatePlayType(boolean z16) {
        int i3;
        if (z16) {
            i3 = 12;
        } else {
            i3 = 11;
        }
        this.mVideoReportInfo.setPlayType(i3);
    }

    public boolean addVideoListener(WeakReference<GdtVideoListener> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            if (!this.mListeners.contains(weakReference)) {
                this.mListeners.add(weakReference);
                return true;
            }
            GdtLog.e(TAG, "addVideoListener failed, already added.");
        }
        return false;
    }

    public void click() {
        GdtLog.i(TAG, "click");
        this.mVideoReportInfo.setFinishType(2);
    }

    public void destroy() {
        runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.12
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView.this.destroyOnMainThread();
            }
        });
    }

    public long getCurrentPositionMs() {
        ISuperPlayer iSuperPlayer = this.mVideoPlayer;
        if (iSuperPlayer == null) {
            return 0L;
        }
        return iSuperPlayer.getCurrentPositionMs();
    }

    public long getVideoDurationMs() {
        if (this.mVideoPlayer == null) {
            return 0L;
        }
        return this.mVideoPlayer.getDurationMs();
    }

    public boolean isPlaying() {
        if (this.mVideoPlayer != null && this.mVideoPlayer.isPlaying()) {
            return true;
        }
        return false;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        QLog.d(TAG, 1, "Lifecycle onDestroy");
        destroy();
    }

    public void pause(boolean z16) {
        updatePlayType(z16);
        runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.9
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView.this.pauseOnMainThread();
            }
        });
    }

    public void play(boolean z16) {
        updatePlayType(z16);
        runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.8
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView.this.playOnMainThread();
            }
        });
    }

    public boolean removeVideoListener(WeakReference<GdtVideoListener> weakReference) {
        if (weakReference == null) {
            return false;
        }
        if (this.mListeners.contains(weakReference)) {
            return this.mListeners.remove(weakReference);
        }
        GdtLog.e(TAG, "removeVideoListener failed, not add yet.");
        return false;
    }

    public void seekTo(final int i3) {
        GdtLog.d(TAG, "seekTo :" + i3);
        runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.11
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView.this.seekToOnMainThread(i3);
            }
        });
    }

    public void setVideoViewVisible(boolean z16) {
        this.mIsVideoViewVisible = z16;
    }

    public void setVolumeState(boolean z16) {
        if (this.mVideoPlayer != null) {
            this.mVideoPlayer.setOutputMute(!z16);
        }
        GdtVideoData gdtVideoData = this.mVideoData;
        if (gdtVideoData != null) {
            gdtVideoData.setVolumOpen(z16);
        }
    }

    public void stop(boolean z16, final boolean z17) {
        if (!this.mIsLoopEnd) {
            updatePlayType(z16);
        }
        runOnMainThread(new Runnable() { // from class: com.tencent.gdtad.views.video.GdtVideoView.10
            @Override // java.lang.Runnable
            public void run() {
                GdtVideoView.this.stopOnMainThread(z17);
            }
        });
    }

    public void updateFinishType(int i3) {
        this.mVideoReportInfo.setFinishType(i3);
    }

    public void updateVoiceOn(boolean z16) {
        if (this.mVideoPlayer == null) {
            return;
        }
        this.mVideoPlayer.setOutputMute(!z16);
    }
}

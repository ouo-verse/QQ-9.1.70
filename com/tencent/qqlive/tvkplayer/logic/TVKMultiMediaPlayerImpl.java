package com.tencent.qqlive.tvkplayer.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKAudioEffectInfo;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioPostProcessorListener;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKPostProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.ITVKAudioFx;
import com.tencent.qqlive.tvkplayer.api.postprocess.effect.video.ITVKVideoFx;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKElapsedTimeStatistics;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKThreadPool;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes23.dex */
public class TVKMultiMediaPlayerImpl implements ITVKMediaPlayer {
    private static String TAG = "TVKTPPlayer[TVKMultiMediaPlayerImpl]";
    private Looper mCallBackLooper;
    private Context mCtx;
    private ITVKDrawableContainer mCurDrawableContainer;
    private volatile ITVKMediaPlayer mCurMediaPlayer;
    private TVKUserInfo mCurUserInfo;
    private ITVKMediaPlayer.OnAdClickedListener mOnAdClickedListener;
    private ITVKMediaPlayer.OnAdCustomCommandListener mOnAdCustomCommandListener;
    private ITVKMediaPlayer.OnAudioFrameOutListener mOnAudioFrameOutListener;
    private ITVKMediaPlayer.OnCaptureImageListener mOnCaptureImageListener;
    private ITVKMediaPlayer.OnCompletionListener mOnCompletionListener;
    private ITVKMediaPlayer.OnErrorListener mOnErrorListener;
    private ITVKMediaPlayer.OnGetUserInfoListener mOnGetUserInfoListener;
    private ITVKMediaPlayer.OnInfoListener mOnInfoListener;
    private ITVKMediaPlayer.OnLogoPositionListener mOnLogoPositionListener;
    private ITVKMediaPlayer.OnLoopBackChangedListener mOnLoopBackChangedListener;
    private ITVKMediaPlayer.OnMidAdListener mOnMidAdListener;
    private ITVKMediaPlayer.OnNetVideoInfoListener mOnNetVideoInfoListener;
    private ITVKMediaPlayer.OnPermissionTimeoutListener mOnPermissionTimeoutListener;
    private ITVKMediaPlayer.OnPostRollAdListener mOnPostRollAdListener;
    private ITVKMediaPlayer.OnPreAdListener mOnPreAdListener;
    private ITVKMediaPlayer.OnScrollAdListener mOnScrollAdListener;
    private ITVKMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private ITVKMediaPlayer.OnVideoFrameOutListener mOnVideoFrameOutListener;
    private ITVKMediaPlayer.OnVideoPreparedListener mOnVideoPreparedListener;
    private ITVKMediaPlayer.OnVideoPreparingListener mOnVideoPreparingListener;
    private ITVKMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private TVKPlayerVideoInfo mVideoInfo;
    private String mCurDefinition = "";
    private boolean mContinuousVids = false;
    private boolean mLastestOnCompleted = false;
    private ITVKAudioFxProcessor mAudioFxProcessor = null;
    private ITVKVideoFxProcessor mVideoFxProcessor = null;
    private ArrayList<ITVKVideoFx> mVideoFx = new ArrayList<>();
    private ArrayList<ITVKAudioFx> mAudioFx = new ArrayList<>();
    private ITVKAudioPostProcessorListener mAudioProcessorListener = null;
    private boolean mIsAudioProcessorConnected = false;
    private boolean mIsVideoProcessorConnected = false;
    private int mXYaxisType = 0;
    private int mAlignmentType = 0;
    private float mSpeedRatio = 1.0f;
    private boolean mMute = false;
    private boolean mLoopBack = false;
    private float mGainRatio = 1.0f;
    private boolean mVrEnable = false;
    private boolean mStaticLogoOpen = true;
    private boolean mDynamicLogoOpen = true;
    private Set<ITVKPlayerEventListener> mPlayerEventListeners = new CopyOnWriteArraySet();
    private Set<ITVKReportEventListener> mReportEventListeners = new CopyOnWriteArraySet();
    private Queue<MediaPlayerEntry> mCacheMediaPlayers = new ConcurrentLinkedQueue();
    private ITVKMediaPlayer.OnNetVideoInfoListener mInnerOnNetVideoInfoListener = new ITVKMediaPlayer.OnNetVideoInfoListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.1
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
        public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
            ITVKMediaPlayer.OnNetVideoInfoListener onNetVideoInfoListener = TVKMultiMediaPlayerImpl.this.mOnNetVideoInfoListener;
            if (onNetVideoInfoListener != null) {
                onNetVideoInfoListener.onNetVideoInfo(TVKMultiMediaPlayerImpl.this, tVKNetVideoInfo);
            }
        }
    };
    private ITVKMediaPlayer.OnVideoPreparedListener mInnerOnVideoPreparedListener = new ITVKMediaPlayer.OnVideoPreparedListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.2
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer iTVKMediaPlayer2;
            Object asset;
            TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onVideoPrepared.");
            synchronized (TVKMultiMediaPlayerImpl.this) {
                MediaPlayerEntry mediaPlayerEntry = (MediaPlayerEntry) TVKMultiMediaPlayerImpl.this.mCacheMediaPlayers.peek();
                boolean z16 = true;
                if (mediaPlayerEntry != null) {
                    if (iTVKMediaPlayer != mediaPlayerEntry.mMediaPlayer) {
                        TVKLogUtil.w(TVKMultiMediaPlayerImpl.TAG, "onVideoPrepared, multi vid.");
                    }
                    if (TVKMultiMediaPlayerImpl.this.mLastestOnCompleted) {
                        TVKMultiMediaPlayerImpl.this.mCacheMediaPlayers.remove();
                        iTVKMediaPlayer2 = TVKMultiMediaPlayerImpl.this.mCurMediaPlayer;
                        TVKMultiMediaPlayerImpl.this.mCurMediaPlayer = mediaPlayerEntry.mMediaPlayer;
                        TVKMultiMediaPlayerImpl.this.mVideoInfo = mediaPlayerEntry.mVideoInfo;
                        TVKMultiMediaPlayerImpl.this.mLastestOnCompleted = false;
                    } else {
                        mediaPlayerEntry.mPrepared = true;
                        return;
                    }
                } else {
                    iTVKMediaPlayer2 = null;
                }
                if (TVKMultiMediaPlayerImpl.this.mContinuousVids && (!TVKMultiMediaPlayerImpl.this.mContinuousVids || mediaPlayerEntry != null)) {
                    z16 = false;
                }
                if (z16) {
                    ITVKMediaPlayer.OnVideoPreparedListener onVideoPreparedListener = TVKMultiMediaPlayerImpl.this.mOnVideoPreparedListener;
                    if (onVideoPreparedListener != null) {
                        onVideoPreparedListener.onVideoPrepared(TVKMultiMediaPlayerImpl.this);
                        TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onVideoPrepared output.");
                        return;
                    }
                    return;
                }
                if (iTVKMediaPlayer2 != null) {
                    TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onVideoPrepared, lastest player destroy.");
                    iTVKMediaPlayer2.stop();
                    iTVKMediaPlayer2.release();
                    ITVKMediaPlayer.OnInfoListener onInfoListener = TVKMultiMediaPlayerImpl.this.mOnInfoListener;
                    if (onInfoListener != null) {
                        TVKMultiMediaPlayerImpl tVKMultiMediaPlayerImpl = TVKMultiMediaPlayerImpl.this;
                        onInfoListener.onInfo(tVKMultiMediaPlayerImpl, 70, tVKMultiMediaPlayerImpl.mVideoInfo);
                        String str = TVKMultiMediaPlayerImpl.TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("onVideoPrepared, interactive start, asset:");
                        if (TVKMultiMediaPlayerImpl.this.mVideoInfo == null) {
                            asset = "";
                        } else {
                            asset = TVKMultiMediaPlayerImpl.this.mVideoInfo.getAsset();
                        }
                        sb5.append(asset);
                        TVKLogUtil.i(str, sb5.toString());
                    }
                    TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onVideoPrepared, interactive play start.");
                    TVKMultiMediaPlayerImpl.this.mCurMediaPlayer.updatePlayerVideoView(TVKMultiMediaPlayerImpl.this.mCurDrawableContainer);
                    TVKMultiMediaPlayerImpl.this.mCurMediaPlayer.start();
                }
            }
        }
    };
    private ITVKMediaPlayer.OnLoopBackChangedListener mInnerOnLoopBackChangedListener = new ITVKMediaPlayer.OnLoopBackChangedListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.3
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLoopBackChangedListener
        public void onLoopBackChanged(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnLoopBackChangedListener onLoopBackChangedListener = TVKMultiMediaPlayerImpl.this.mOnLoopBackChangedListener;
            if (onLoopBackChangedListener != null) {
                onLoopBackChangedListener.onLoopBackChanged(TVKMultiMediaPlayerImpl.this);
            }
        }
    };
    private ITVKMediaPlayer.OnCompletionListener mInnerOnCompletionListener = new ITVKMediaPlayer.OnCompletionListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.4
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
        public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer iTVKMediaPlayer2;
            TVKPlayerVideoInfo tVKPlayerVideoInfo;
            boolean z16;
            Object asset;
            TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onCompletion.");
            synchronized (TVKMultiMediaPlayerImpl.this) {
                TVKMultiMediaPlayerImpl.this.mLastestOnCompleted = true;
                MediaPlayerEntry mediaPlayerEntry = (MediaPlayerEntry) TVKMultiMediaPlayerImpl.this.mCacheMediaPlayers.peek();
                if (mediaPlayerEntry != null && mediaPlayerEntry.mPrepared) {
                    TVKMultiMediaPlayerImpl.this.mCacheMediaPlayers.remove();
                    iTVKMediaPlayer2 = TVKMultiMediaPlayerImpl.this.mCurMediaPlayer;
                    tVKPlayerVideoInfo = TVKMultiMediaPlayerImpl.this.mVideoInfo;
                    TVKMultiMediaPlayerImpl.this.mCurMediaPlayer = mediaPlayerEntry.mMediaPlayer;
                    TVKMultiMediaPlayerImpl.this.mVideoInfo = mediaPlayerEntry.mVideoInfo;
                    TVKMultiMediaPlayerImpl.this.mLastestOnCompleted = false;
                } else {
                    iTVKMediaPlayer2 = null;
                    tVKPlayerVideoInfo = null;
                }
                z16 = !TVKMultiMediaPlayerImpl.this.mContinuousVids;
                if (tVKPlayerVideoInfo == null) {
                    tVKPlayerVideoInfo = TVKMultiMediaPlayerImpl.this.mVideoInfo;
                }
            }
            if (z16) {
                ITVKMediaPlayer.OnCompletionListener onCompletionListener = TVKMultiMediaPlayerImpl.this.mOnCompletionListener;
                if (onCompletionListener != null) {
                    onCompletionListener.onCompletion(TVKMultiMediaPlayerImpl.this);
                    TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onCompletion output.");
                    return;
                } else {
                    TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onCompletion, no listener.");
                    return;
                }
            }
            ITVKMediaPlayer.OnInfoListener onInfoListener = TVKMultiMediaPlayerImpl.this.mOnInfoListener;
            if (onInfoListener != null) {
                onInfoListener.onInfo(TVKMultiMediaPlayerImpl.this, 69, tVKPlayerVideoInfo);
                String str = TVKMultiMediaPlayerImpl.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("onCompletion, interactive eof, asset:");
                if (tVKPlayerVideoInfo == null) {
                    asset = "";
                } else {
                    asset = tVKPlayerVideoInfo.getAsset();
                }
                sb5.append(asset);
                TVKLogUtil.i(str, sb5.toString());
            }
            if (iTVKMediaPlayer2 != null) {
                TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onCompletion, last player destroy.");
                iTVKMediaPlayer2.stop();
                iTVKMediaPlayer2.release();
                if (onInfoListener != null) {
                    TVKMultiMediaPlayerImpl tVKMultiMediaPlayerImpl = TVKMultiMediaPlayerImpl.this;
                    onInfoListener.onInfo(tVKMultiMediaPlayerImpl, 70, tVKMultiMediaPlayerImpl.mVideoInfo);
                    TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onCompletion, interactive start.");
                }
                TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "onCompletion, interactive play start.");
                TVKMultiMediaPlayerImpl.this.mCurMediaPlayer.updatePlayerVideoView(TVKMultiMediaPlayerImpl.this.mCurDrawableContainer);
                TVKMultiMediaPlayerImpl.this.mCurMediaPlayer.start();
            }
        }
    };
    private ITVKMediaPlayer.OnPermissionTimeoutListener mInnerOnPermissionTimeoutListener = new ITVKMediaPlayer.OnPermissionTimeoutListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.5
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPermissionTimeoutListener
        public void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnPermissionTimeoutListener onPermissionTimeoutListener = TVKMultiMediaPlayerImpl.this.mOnPermissionTimeoutListener;
            if (onPermissionTimeoutListener != null) {
                onPermissionTimeoutListener.onPermissionTimeout(TVKMultiMediaPlayerImpl.this);
            }
        }
    };
    private ITVKMediaPlayer.OnSeekCompleteListener mInnerOnSeekCompleteListener = new ITVKMediaPlayer.OnSeekCompleteListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.6
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = TVKMultiMediaPlayerImpl.this.mOnSeekCompleteListener;
            if (onSeekCompleteListener != null) {
                onSeekCompleteListener.onSeekComplete(TVKMultiMediaPlayerImpl.this);
            }
        }
    };
    private ITVKMediaPlayer.OnCaptureImageListener mInnerOnCaptureImageListener = new ITVKMediaPlayer.OnCaptureImageListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.7
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener = TVKMultiMediaPlayerImpl.this.mOnCaptureImageListener;
            if (onCaptureImageListener != null) {
                onCaptureImageListener.onCaptureImageFailed(TVKMultiMediaPlayerImpl.this, i3, i16);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap) {
            ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener = TVKMultiMediaPlayerImpl.this.mOnCaptureImageListener;
            if (onCaptureImageListener != null) {
                onCaptureImageListener.onCaptureImageSucceed(TVKMultiMediaPlayerImpl.this, i3, i16, i17, bitmap);
            }
        }
    };
    private ITVKMediaPlayer.OnErrorListener mInnerOnErrorListener = new ITVKMediaPlayer.OnErrorListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.8
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
        public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
            ITVKMediaPlayer.OnErrorListener onErrorListener = TVKMultiMediaPlayerImpl.this.mOnErrorListener;
            if (onErrorListener != null) {
                return onErrorListener.onError(TVKMultiMediaPlayerImpl.this, tVKError);
            }
            return false;
        }
    };
    private ITVKMediaPlayer.OnInfoListener mInnerOnInfoListener = new ITVKMediaPlayer.OnInfoListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.9
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
        public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
            ITVKMediaPlayer.OnInfoListener onInfoListener = TVKMultiMediaPlayerImpl.this.mOnInfoListener;
            if (onInfoListener != null) {
                return onInfoListener.onInfo(TVKMultiMediaPlayerImpl.this, i3, obj);
            }
            return false;
        }
    };
    private ITVKMediaPlayer.OnGetUserInfoListener mInnerOnGetUserInfoListener = new ITVKMediaPlayer.OnGetUserInfoListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.10
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnGetUserInfoListener
        public TVKUserInfo onGetUserInfo(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnGetUserInfoListener onGetUserInfoListener = TVKMultiMediaPlayerImpl.this.mOnGetUserInfoListener;
            if (onGetUserInfoListener != null) {
                return onGetUserInfoListener.onGetUserInfo(TVKMultiMediaPlayerImpl.this);
            }
            return null;
        }
    };
    private ITVKMediaPlayer.OnLogoPositionListener mInnerOnLogoPositionListener = new ITVKMediaPlayer.OnLogoPositionListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.11
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLogoPositionListener
        public void onOriginalLogoPosition(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, int i18, boolean z16) {
            ITVKMediaPlayer.OnLogoPositionListener onLogoPositionListener = TVKMultiMediaPlayerImpl.this.mOnLogoPositionListener;
            if (onLogoPositionListener != null) {
                onLogoPositionListener.onOriginalLogoPosition(TVKMultiMediaPlayerImpl.this, i3, i16, i17, i18, z16);
            }
        }
    };
    private ITVKMediaPlayer.OnVideoSizeChangedListener mInnerOnVideoSizeChangedListener = new ITVKMediaPlayer.OnVideoSizeChangedListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.12
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            ITVKMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = TVKMultiMediaPlayerImpl.this.mOnVideoSizeChangedListener;
            if (onVideoSizeChangedListener != null) {
                onVideoSizeChangedListener.onVideoSizeChanged(TVKMultiMediaPlayerImpl.this, i3, i16);
            }
        }
    };
    private ITVKMediaPlayer.OnVideoFrameOutListener mInnerOnVideoFrameOutListener = new ITVKMediaPlayer.OnVideoFrameOutListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.13
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoFrameOutListener
        public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
            ITVKMediaPlayer.OnVideoFrameOutListener onVideoFrameOutListener = TVKMultiMediaPlayerImpl.this.mOnVideoFrameOutListener;
            if (onVideoFrameOutListener != null) {
                onVideoFrameOutListener.onVideoFrameOut(tVKVideoFrameBuffer);
            }
        }
    };
    private ITVKMediaPlayer.OnAudioFrameOutListener mInnerOnAudioFrameOutListener = new ITVKMediaPlayer.OnAudioFrameOutListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.14
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAudioFrameOutListener
        public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
            ITVKMediaPlayer.OnAudioFrameOutListener onAudioFrameOutListener = TVKMultiMediaPlayerImpl.this.mOnAudioFrameOutListener;
            if (onAudioFrameOutListener != null) {
                onAudioFrameOutListener.onAudioFrameOut(tVKAudioFrameBuffer);
            }
        }
    };
    private ITVKPlayerEventListener mInnerPlayerEventListener = new ITVKPlayerEventListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.15
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener
        public void onPlayerEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.PlayerEvent playerEvent, ITVKPlayerEventListener.EventParams eventParams) {
            Set set = TVKMultiMediaPlayerImpl.this.mPlayerEventListeners;
            if (set != null) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((ITVKPlayerEventListener) it.next()).onPlayerEvent(TVKMultiMediaPlayerImpl.this, playerEvent, eventParams);
                }
            }
        }
    };
    private ITVKReportEventListener mInnerReportEventListener = new ITVKReportEventListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.16
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener
        public void onReportEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKReportEventListener.ReportEvent reportEvent, ITVKReportEventListener.ReportEventParams reportEventParams) {
            TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, "notify : onReportPushEvent event:" + reportEvent);
            Set set = TVKMultiMediaPlayerImpl.this.mReportEventListeners;
            if (set != null) {
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    ((ITVKReportEventListener) it.next()).onReportEvent(TVKMultiMediaPlayerImpl.this, reportEvent, reportEventParams);
                }
            }
        }
    };
    private ITVKMediaPlayer.OnPreAdListener mInnerOnPreAdListener = new ITVKMediaPlayer.OnPreAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.17
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnPreAdListener onPreAdListener = TVKMultiMediaPlayerImpl.this.mOnPreAdListener;
            if (onPreAdListener != null) {
                onPreAdListener.onPreAdFinish(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            ITVKMediaPlayer.OnPreAdListener onPreAdListener = TVKMultiMediaPlayerImpl.this.mOnPreAdListener;
            if (onPreAdListener != null) {
                onPreAdListener.onPreAdPrepared(TVKMultiMediaPlayerImpl.this, j3);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnPreAdListener onPreAdListener = TVKMultiMediaPlayerImpl.this.mOnPreAdListener;
            if (onPreAdListener != null) {
                onPreAdListener.onPreAdPreparing(TVKMultiMediaPlayerImpl.this);
            }
        }
    };
    private ITVKMediaPlayer.OnMidAdListener mInnerOnMidAdListener = new ITVKMediaPlayer.OnMidAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.18
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            ITVKMediaPlayer.OnMidAdListener onMidAdListener = TVKMultiMediaPlayerImpl.this.mOnMidAdListener;
            if (onMidAdListener != null) {
                onMidAdListener.onMidAdCountdown(TVKMultiMediaPlayerImpl.this, j3);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            ITVKMediaPlayer.OnMidAdListener onMidAdListener = TVKMultiMediaPlayerImpl.this.mOnMidAdListener;
            if (onMidAdListener != null) {
                onMidAdListener.onMidAdEndCountdown(TVKMultiMediaPlayerImpl.this, j3);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnMidAdListener onMidAdListener = TVKMultiMediaPlayerImpl.this.mOnMidAdListener;
            if (onMidAdListener != null) {
                onMidAdListener.onMidAdFinish(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16) {
            ITVKMediaPlayer.OnMidAdListener onMidAdListener = TVKMultiMediaPlayerImpl.this.mOnMidAdListener;
            if (onMidAdListener != null) {
                onMidAdListener.onMidAdStartCountdown(TVKMultiMediaPlayerImpl.this, j3, j16);
            }
        }
    };
    private ITVKMediaPlayer.OnPostRollAdListener mInnerOnPostRollAdListener = new ITVKMediaPlayer.OnPostRollAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.19
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener = TVKMultiMediaPlayerImpl.this.mOnPostRollAdListener;
            if (onPostRollAdListener != null) {
                onPostRollAdListener.onPostAdFinish(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener = TVKMultiMediaPlayerImpl.this.mOnPostRollAdListener;
            if (onPostRollAdListener != null) {
                onPostRollAdListener.onPostrollAdPrepared(TVKMultiMediaPlayerImpl.this, j3);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener = TVKMultiMediaPlayerImpl.this.mOnPostRollAdListener;
            if (onPostRollAdListener != null) {
                onPostRollAdListener.onPostrollAdPreparing(TVKMultiMediaPlayerImpl.this);
            }
        }
    };
    private ITVKMediaPlayer.OnAdClickedListener mInnerOnAdClickedListener = new ITVKMediaPlayer.OnAdClickedListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.20
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdExitFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onAdExitFullScreenClick(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onAdFullScreenClick(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdReturnClick(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onAdReturnClick(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdSkipClick(ITVKMediaPlayer iTVKMediaPlayer, boolean z16, int i3) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onAdSkipClick(TVKMultiMediaPlayerImpl.this, z16, i3);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdWarnerTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onAdWarnerTipClick(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onEnterVipTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onEnterVipTipClick(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewClosed(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onLandingViewClosed(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewFail(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onLandingViewFail(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewWillPresent(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onLandingViewWillPresent(TVKMultiMediaPlayerImpl.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onVolumeChange(ITVKMediaPlayer iTVKMediaPlayer, float f16) {
            ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = TVKMultiMediaPlayerImpl.this.mOnAdClickedListener;
            if (onAdClickedListener != null) {
                onAdClickedListener.onVolumeChange(TVKMultiMediaPlayerImpl.this, f16);
            }
        }
    };
    private ITVKMediaPlayer.OnVideoPreparingListener mInnerOnVideoPreparingListener = new ITVKMediaPlayer.OnVideoPreparingListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.21
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparingListener
        public void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            ITVKMediaPlayer.OnVideoPreparingListener onVideoPreparingListener = TVKMultiMediaPlayerImpl.this.mOnVideoPreparingListener;
            if (onVideoPreparingListener != null) {
                onVideoPreparingListener.onVideoPreparing(TVKMultiMediaPlayerImpl.this);
            }
        }
    };
    private ITVKMediaPlayer.OnScrollAdListener mInnerOnScrollAdListener = new ITVKMediaPlayer.OnScrollAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.22
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
        public void onFinishAd(ITVKMediaPlayer iTVKMediaPlayer, int i3) {
            ITVKMediaPlayer.OnScrollAdListener onScrollAdListener = TVKMultiMediaPlayerImpl.this.mOnScrollAdListener;
            if (onScrollAdListener != null) {
                onScrollAdListener.onFinishAd(TVKMultiMediaPlayerImpl.this, i3);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
        public void onSwitchAd(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj, Object obj2) {
            ITVKMediaPlayer.OnScrollAdListener onScrollAdListener = TVKMultiMediaPlayerImpl.this.mOnScrollAdListener;
            if (onScrollAdListener != null) {
                onScrollAdListener.onSwitchAd(TVKMultiMediaPlayerImpl.this, i3, obj, obj2);
            }
        }
    };
    private ITVKMediaPlayer.OnAdCustomCommandListener mInnerOnAdCustomCommandListener = new ITVKMediaPlayer.OnAdCustomCommandListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.23
        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdCustomCommandListener
        public Object onAdCustomCommand(ITVKMediaPlayer iTVKMediaPlayer, String str, Object obj) {
            ITVKMediaPlayer.OnAdCustomCommandListener onAdCustomCommandListener = TVKMultiMediaPlayerImpl.this.mOnAdCustomCommandListener;
            if (onAdCustomCommandListener != null) {
                onAdCustomCommandListener.onAdCustomCommand(TVKMultiMediaPlayerImpl.this, str, obj);
                return null;
            }
            return null;
        }
    };
    private ITVKAudioFxProcessor audioFxProcessor = new ITVKAudioFxProcessor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.24
        @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
        public boolean addEffect(ITVKAudioFx iTVKAudioFx) {
            if (TVKMultiMediaPlayerImpl.this.mAudioFxProcessor == null) {
                return false;
            }
            TVKMultiMediaPlayerImpl.this.mAudioFx.add(iTVKAudioFx);
            return TVKMultiMediaPlayerImpl.this.mAudioFxProcessor.addEffect(iTVKAudioFx);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
        public TVKAudioEffectInfo[] getSupportedAudioEffectInfo() {
            if (TVKMultiMediaPlayerImpl.this.mAudioFxProcessor != null) {
                return TVKMultiMediaPlayerImpl.this.mAudioFxProcessor.getSupportedAudioEffectInfo();
            }
            return new TVKAudioEffectInfo[0];
        }

        @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
        public void removeAllEffects() {
            if (TVKMultiMediaPlayerImpl.this.mAudioFxProcessor != null) {
                TVKMultiMediaPlayerImpl.this.mAudioFxProcessor.removeAllEffects();
            }
            TVKMultiMediaPlayerImpl.this.mAudioFx.clear();
        }

        @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
        public void removeEffect(ITVKAudioFx iTVKAudioFx) {
            if (TVKMultiMediaPlayerImpl.this.mAudioFxProcessor != null) {
                TVKMultiMediaPlayerImpl.this.mAudioFxProcessor.removeEffect(iTVKAudioFx);
            }
            TVKMultiMediaPlayerImpl.this.mAudioFx.remove(iTVKAudioFx);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor
        public void setListener(ITVKAudioPostProcessorListener iTVKAudioPostProcessorListener) {
            if (TVKMultiMediaPlayerImpl.this.mAudioFxProcessor != null) {
                TVKMultiMediaPlayerImpl.this.mAudioFxProcessor.setListener(iTVKAudioPostProcessorListener);
            }
            TVKMultiMediaPlayerImpl.this.mAudioProcessorListener = iTVKAudioPostProcessorListener;
        }
    };
    private ITVKVideoFxProcessor mCurrentVideoFxProcessor = new ITVKVideoFxProcessor() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.25
        @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor
        public void addFxModel(ITVKVideoFx iTVKVideoFx) throws IllegalStateException {
            if (TVKMultiMediaPlayerImpl.this.mVideoFxProcessor != null) {
                TVKMultiMediaPlayerImpl.this.mVideoFx.add(iTVKVideoFx);
                TVKMultiMediaPlayerImpl.this.mVideoFxProcessor.addFxModel(iTVKVideoFx);
                return;
            }
            throw new IllegalStateException("processor is null.");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor
        public void removeFx(ITVKVideoFx iTVKVideoFx) {
            if (TVKMultiMediaPlayerImpl.this.mVideoFxProcessor != null) {
                TVKMultiMediaPlayerImpl.this.mVideoFxProcessor.removeFx(iTVKVideoFx);
            }
            TVKMultiMediaPlayerImpl.this.mVideoFx.remove(iTVKVideoFx);
        }
    };

    /* loaded from: classes23.dex */
    private static class MediaPlayerEntry {
        final ITVKMediaPlayer mMediaPlayer;
        boolean mPrepared = false;
        final TVKPlayerVideoInfo mVideoInfo;

        MediaPlayerEntry(ITVKMediaPlayer iTVKMediaPlayer, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
            this.mMediaPlayer = iTVKMediaPlayer;
            this.mVideoInfo = tVKPlayerVideoInfo;
        }
    }

    public TVKMultiMediaPlayerImpl(Context context, ITVKDrawableContainer iTVKDrawableContainer, Looper looper) {
        this.mCtx = context.getApplicationContext();
        this.mCallBackLooper = looper;
        TVKElapsedTimeStatistics tVKElapsedTimeStatistics = new TVKElapsedTimeStatistics();
        tVKElapsedTimeStatistics.startPoint();
        this.mCurMediaPlayer = new TVKStateKeeperPlayerManager(this.mCtx, iTVKDrawableContainer, looper);
        TVKLogUtil.i(TAG, "TVKSyncPlayerManager cost=" + tVKElapsedTimeStatistics.costTimeMsFromStartPointAndPoint());
        this.mCurDrawableContainer = iTVKDrawableContainer;
        this.mCurMediaPlayer.addPlayerEventListener(this.mInnerPlayerEventListener);
        this.mCurMediaPlayer.addReportEventListener(this.mInnerReportEventListener);
    }

    private void adListenerInit(ITVKMediaPlayer iTVKMediaPlayer) {
        if (this.mOnMidAdListener != null) {
            iTVKMediaPlayer.setOnMidAdListener(this.mInnerOnMidAdListener);
        }
        if (this.mOnAdClickedListener != null) {
            iTVKMediaPlayer.setOnAdClickedListener(this.mInnerOnAdClickedListener);
        }
        if (this.mOnPreAdListener != null) {
            iTVKMediaPlayer.setOnPreAdListener(new ITVKMediaPlayer.OnPreAdListener() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.26
                @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
                public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer2) {
                }

                @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
                public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer2) {
                }

                @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
                public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer2, long j3) {
                }
            });
        }
        if (this.mOnScrollAdListener != null) {
            iTVKMediaPlayer.setOnScrollAdListener(this.mInnerOnScrollAdListener);
        }
        if (this.mOnAdCustomCommandListener != null) {
            iTVKMediaPlayer.setOnAdCustomCommandListener(this.mInnerOnAdCustomCommandListener);
        }
        if (this.mOnPostRollAdListener != null) {
            iTVKMediaPlayer.setOnPostRollAdListener(this.mInnerOnPostRollAdListener);
        }
    }

    private void listenerInit(ITVKMediaPlayer iTVKMediaPlayer) {
        adListenerInit(iTVKMediaPlayer);
        if (this.mOnCompletionListener != null) {
            iTVKMediaPlayer.setOnCompletionListener(this.mInnerOnCompletionListener);
        }
        if (this.mOnVideoPreparedListener != null) {
            iTVKMediaPlayer.setOnVideoPreparedListener(this.mInnerOnVideoPreparedListener);
        }
        if (this.mOnPermissionTimeoutListener != null) {
            iTVKMediaPlayer.setOnPermissionTimeoutListener(this.mInnerOnPermissionTimeoutListener);
        }
        if (this.mOnCaptureImageListener != null) {
            iTVKMediaPlayer.setOnCaptureImageListener(this.mInnerOnCaptureImageListener);
        }
        if (this.mOnNetVideoInfoListener != null) {
            iTVKMediaPlayer.setOnNetVideoInfoListener(this.mInnerOnNetVideoInfoListener);
        }
        if (this.mOnLoopBackChangedListener != null) {
            iTVKMediaPlayer.setOnLoopbackChangedListener(this.mInnerOnLoopBackChangedListener);
        }
        if (this.mOnSeekCompleteListener != null) {
            iTVKMediaPlayer.setOnSeekCompleteListener(this.mInnerOnSeekCompleteListener);
        }
        if (this.mOnErrorListener != null) {
            iTVKMediaPlayer.setOnErrorListener(this.mInnerOnErrorListener);
        }
        if (this.mOnInfoListener != null) {
            iTVKMediaPlayer.setOnInfoListener(this.mInnerOnInfoListener);
        }
        if (this.mOnGetUserInfoListener != null) {
            iTVKMediaPlayer.setOnGetUserInfoListener(this.mInnerOnGetUserInfoListener);
        }
        if (this.mOnLogoPositionListener != null) {
            iTVKMediaPlayer.setOnLogoPositionListener(this.mInnerOnLogoPositionListener);
        }
        if (this.mOnVideoSizeChangedListener != null) {
            iTVKMediaPlayer.setOnVideoSizeChangedListener(this.mInnerOnVideoSizeChangedListener);
        }
        if (this.mOnVideoFrameOutListener != null) {
            iTVKMediaPlayer.setOnVideoFrameOutListener(this.mInnerOnVideoFrameOutListener);
        }
        if (this.mOnAudioFrameOutListener != null) {
            iTVKMediaPlayer.setOnAudioFrameOutListener(this.mInnerOnAudioFrameOutListener);
        }
        iTVKMediaPlayer.addPlayerEventListener(this.mInnerPlayerEventListener);
    }

    private void paramReset() {
        this.mXYaxisType = 0;
        this.mAlignmentType = 0;
        this.mSpeedRatio = 1.0f;
        this.mMute = false;
        this.mLoopBack = false;
        this.mGainRatio = 1.0f;
        this.mVrEnable = false;
        this.mContinuousVids = false;
        this.mLastestOnCompleted = false;
    }

    private void parameterInit(ITVKMediaPlayer iTVKMediaPlayer) {
        iTVKMediaPlayer.setXYaxis(this.mXYaxisType);
        iTVKMediaPlayer.setAlignment(this.mAlignmentType);
        iTVKMediaPlayer.setPlaySpeedRatio(this.mSpeedRatio);
        iTVKMediaPlayer.setOutputMute(this.mMute);
        iTVKMediaPlayer.setLoopback(this.mLoopBack);
        iTVKMediaPlayer.setAudioGainRatio(this.mGainRatio);
        TVKLogUtil.i(TAG, "parameterInit, mStaticLogoOpen:" + this.mStaticLogoOpen + "mDynamicLogoOpen" + this.mDynamicLogoOpen);
        boolean z16 = this.mStaticLogoOpen;
        if (!z16) {
            iTVKMediaPlayer.onRealTimeInfoChange(11, Boolean.valueOf(z16));
        }
        boolean z17 = this.mDynamicLogoOpen;
        if (!z17) {
            iTVKMediaPlayer.onRealTimeInfoChange(12, Boolean.valueOf(z17));
        }
        if (this.mAudioFxProcessor != null) {
            ITVKAudioFxProcessor audioFxProcessor = iTVKMediaPlayer.getAudioFxProcessor();
            this.mAudioFxProcessor = audioFxProcessor;
            if (audioFxProcessor != null) {
                ITVKAudioPostProcessorListener iTVKAudioPostProcessorListener = this.mAudioProcessorListener;
                if (iTVKAudioPostProcessorListener != null) {
                    audioFxProcessor.setListener(iTVKAudioPostProcessorListener);
                }
                for (int i3 = 0; i3 < this.mAudioFx.size(); i3++) {
                    this.mAudioFxProcessor.addEffect(this.mAudioFx.get(i3));
                }
                if (this.mIsAudioProcessorConnected) {
                    iTVKMediaPlayer.connectPostProcessor(this.mAudioFxProcessor);
                }
            }
        }
        if (this.mVideoFxProcessor != null) {
            ITVKVideoFxProcessor videoFxProcessor = iTVKMediaPlayer.getVideoFxProcessor();
            this.mVideoFxProcessor = videoFxProcessor;
            if (videoFxProcessor != null) {
                for (int i16 = 0; i16 < this.mVideoFx.size(); i16++) {
                    this.mVideoFxProcessor.addFxModel(this.mVideoFx.get(i16));
                }
                if (this.mIsVideoProcessorConnected) {
                    iTVKMediaPlayer.connectPostProcessor(this.mVideoFxProcessor);
                }
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayerEventListeners.add(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mReportEventListeners.add(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addTrack(int i3, String str, String str2) throws IllegalArgumentException {
        this.mCurMediaPlayer.addTrack(i3, str, str2);
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        this.mCurMediaPlayer.bindVideoPlayerInfo(obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int captureImageInTime(int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        return this.mCurMediaPlayer.captureImageInTime(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void connectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        if (iTVKPostProcessor instanceof ITVKAudioFxProcessor) {
            this.mCurMediaPlayer.connectPostProcessor(this.mAudioFxProcessor);
            this.mIsAudioProcessorConnected = true;
        }
        if (iTVKPostProcessor instanceof ITVKVideoFxProcessor) {
            this.mCurMediaPlayer.connectPostProcessor(this.mVideoFxProcessor);
            this.mIsVideoProcessorConnected = true;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void deselectTrack(int i3) {
        this.mCurMediaPlayer.deselectTrack(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void disconnectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        if (iTVKPostProcessor != null) {
            if (iTVKPostProcessor instanceof ITVKAudioFxProcessor) {
                this.mCurMediaPlayer.disconnectPostProcessor(this.mAudioFxProcessor);
                this.mIsAudioProcessorConnected = false;
            }
            if (iTVKPostProcessor instanceof ITVKVideoFxProcessor) {
                this.mCurMediaPlayer.disconnectPostProcessor(this.mVideoFxProcessor);
                this.mIsVideoProcessorConnected = false;
                return;
            }
            return;
        }
        throw new IllegalStateException("processor is null.");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getAdCurrentPosition() {
        return this.mCurMediaPlayer.getAdCurrentPosition();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public Object getAdStatus() {
        return this.mCurMediaPlayer.getAdStatus();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKAudioFxProcessor getAudioFxProcessor() {
        ITVKAudioFxProcessor audioFxProcessor = this.mCurMediaPlayer.getAudioFxProcessor();
        this.mAudioFxProcessor = audioFxProcessor;
        if (audioFxProcessor == null) {
            return null;
        }
        return this.audioFxProcessor;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getAvailablePositionMs() {
        return this.mCurMediaPlayer.getAvailablePositionMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getBufferPercent() {
        return this.mCurMediaPlayer.getBufferPercent();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TVKNetVideoInfo getCurNetVideoInfo() {
        return this.mCurMediaPlayer.getCurNetVideoInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getCurrentPosition() {
        return this.mCurMediaPlayer.getCurrentPosition();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getDownloadSpeed(int i3) {
        return this.mCurMediaPlayer.getDownloadSpeed(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getDuration() {
        return this.mCurMediaPlayer.getDuration();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public String getHlsTagInfo(String str) {
        return this.mCurMediaPlayer.getHlsTagInfo(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean getOutputMute() {
        return this.mCurMediaPlayer.getOutputMute();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getPlayedTime() {
        return this.mCurMediaPlayer.getPlayedTime();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TPProgramInfo[] getProgramInfo() {
        return this.mCurMediaPlayer.getProgramInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @Nullable
    public ITVKRichMediaSynchronizer getRichMediaSynchronizer() throws IllegalStateException {
        return this.mCurMediaPlayer.getRichMediaSynchronizer();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getSelectedTrack(int i3) {
        return this.mCurMediaPlayer.getSelectedTrack(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public String getStreamDumpInfo() {
        return this.mCurMediaPlayer.getStreamDumpInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKSubtitleRendererController getSubtitleRendererController() {
        return this.mCurMediaPlayer.getSubtitleRendererController();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TVKTrackInfo[] getTrackInfo() {
        return this.mCurMediaPlayer.getTrackInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKVideoFxProcessor getVideoFxProcessor() {
        ITVKVideoFxProcessor videoFxProcessor = this.mCurMediaPlayer.getVideoFxProcessor();
        this.mVideoFxProcessor = videoFxProcessor;
        if (videoFxProcessor == null) {
            return null;
        }
        return this.mCurrentVideoFxProcessor;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoHeight() {
        return this.mCurMediaPlayer.getVideoHeight();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoRotation() {
        return this.mCurMediaPlayer.getVideoRotation();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKVideoViewBase getVideoView() {
        return this.mCurMediaPlayer.getVideoView();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoWidth() {
        return this.mCurMediaPlayer.getVideoWidth();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isLoopBack() {
        return this.mCurMediaPlayer.isLoopBack();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isPaused() {
        return this.mCurMediaPlayer.isPaused();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isPlaying() {
        return this.mCurMediaPlayer.isPlaying();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onClickPause() {
        this.mCurMediaPlayer.onClickPause();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean onKeyEvent(KeyEvent keyEvent) {
        return this.mCurMediaPlayer.onKeyEvent(keyEvent);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        if (i3 == 7) {
            if (obj instanceof Boolean) {
                this.mContinuousVids = ((Boolean) obj).booleanValue();
            }
            TVKLogUtil.i(TAG, "onRealTimeInfoChange, continuous vid:" + this.mContinuousVids);
        }
        if ((i3 == 11 || i3 == 9) && (obj instanceof Boolean)) {
            this.mStaticLogoOpen = ((Boolean) obj).booleanValue();
            TVKLogUtil.i(TAG, "onRealTimeInfoChange, mStaticLogoOpen:" + this.mStaticLogoOpen);
        }
        if (i3 == 12 && (obj instanceof Boolean)) {
            this.mDynamicLogoOpen = ((Boolean) obj).booleanValue();
            TVKLogUtil.i(TAG, "onRealTimeInfoChange, mDynamicLogoOpen:" + this.mDynamicLogoOpen);
        }
        this.mCurMediaPlayer.onRealTimeInfoChange(i3, obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onSkipAdResult(boolean z16) {
        this.mCurMediaPlayer.onSkipAdResult(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean onTouchEvent(View view, MotionEvent motionEvent) {
        return this.mCurMediaPlayer.onTouchEvent(view, motionEvent);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        TVKLogUtil.i(TAG, "api call: openMediaPlayer.");
        this.mCurUserInfo = tVKUserInfo;
        this.mVideoInfo = tVKPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null) {
            this.mCurDefinition = tVKPlayerVideoInfo.getDefinition();
        }
        if (context != null) {
            this.mCtx = context.getApplicationContext();
        }
        this.mCurMediaPlayer.openMediaPlayer(this.mCtx, tVKUserInfo, tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void pause() {
        TVKLogUtil.i(TAG, "api call: pause.");
        this.mCurMediaPlayer.pause();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void pauseDownload() {
        this.mCurMediaPlayer.pauseDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void refreshPlayer() {
        this.mCurMediaPlayer.refreshPlayer();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void refreshPlayerWithReopen() {
        this.mCurMediaPlayer.refreshPlayerWithReopen();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void release() {
        TVKLogUtil.i(TAG, "api call:release.");
        this.mCurMediaPlayer.release();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayerEventListeners.remove(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void removeReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mReportEventListeners.remove(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void resumeDownload() {
        this.mCurMediaPlayer.resumeDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void saveReport() {
        this.mCurMediaPlayer.saveReport();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekForLive(long j3) {
        TVKLogUtil.i(TAG, "api call:seekForLive.");
        this.mCurMediaPlayer.seekForLive(j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekTo(int i3) {
        TVKLogUtil.i(TAG, "api call:seekTo.");
        this.mCurMediaPlayer.seekTo(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekToAccuratePos(int i3) {
        TVKLogUtil.i(TAG, "api call:seekToAccuratePos.");
        this.mCurMediaPlayer.seekToAccuratePos(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekToAccuratePosFast(int i3) {
        TVKLogUtil.i(TAG, "api call:seekToAccuratePosFast.");
        this.mCurMediaPlayer.seekToAccuratePosFast(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void selectProgram(int i3, long j3) {
        this.mCurMediaPlayer.selectProgram(i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void selectTrack(int i3) {
        this.mCurMediaPlayer.selectTrack(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setAlignment(int i3) {
        this.mAlignmentType = i3;
        this.mCurMediaPlayer.setAlignment(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setAudioGainRatio(float f16) {
        this.mGainRatio = f16;
        this.mCurMediaPlayer.setAudioGainRatio(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @RequiresApi(api = 24)
    public void setDisplayOffset(float f16, float f17) {
        this.mCurMediaPlayer.setDisplayOffset(f16, f17);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setDisplayScale(float f16) {
        this.mCurMediaPlayer.setDisplayScale(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setLoopback(boolean z16) {
        this.mLoopBack = z16;
        this.mCurMediaPlayer.setLoopback(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setNextLoopVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        this.mVideoInfo = tVKPlayerVideoInfo;
        this.mCurMediaPlayer.setNextLoopVideoInfo(tVKPlayerVideoInfo, str);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setNextPlayerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo == null) {
            return;
        }
        try {
            TVKPlayerVideoInfo m239clone = tVKPlayerVideoInfo.m239clone();
            m239clone.setDefinition(this.mCurDefinition);
            TVKLogUtil.i(TAG, "setNextPlayerVideoInfo, asset:" + m239clone.getAsset());
            ITVKMediaPlayer createPlayerManager = TVKPlayerManagerFactory.getInstance().createPlayerManager(this.mCtx, null, this.mCallBackLooper);
            listenerInit(createPlayerManager);
            parameterInit(createPlayerManager);
            createPlayerManager.onRealTimeInfoChange(7, Boolean.valueOf(this.mContinuousVids));
            m239clone.addAdParamsMap("PLAY_STRATEGY", QAdPlayStrategyDefine$PlayStrategyKey.NO_AD);
            createPlayerManager.openMediaPlayer(this.mCtx, this.mCurUserInfo, m239clone);
            synchronized (this) {
                this.mCacheMediaPlayers.add(new MediaPlayerEntry(createPlayerManager, m239clone));
            }
        } catch (CloneNotSupportedException e16) {
            TVKLogUtil.e(TAG, e16, "check video info implementation");
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAdClickedListener(ITVKMediaPlayer.OnAdClickedListener onAdClickedListener) {
        this.mOnAdClickedListener = onAdClickedListener;
        this.mCurMediaPlayer.setOnAdClickedListener(this.mInnerOnAdClickedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAdCustomCommandListener(ITVKMediaPlayer.OnAdCustomCommandListener onAdCustomCommandListener) {
        this.mOnAdCustomCommandListener = onAdCustomCommandListener;
        this.mCurMediaPlayer.setOnAdCustomCommandListener(this.mInnerOnAdCustomCommandListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAudioFrameOutListener(ITVKMediaPlayer.OnAudioFrameOutListener onAudioFrameOutListener) {
        this.mOnAudioFrameOutListener = onAudioFrameOutListener;
        this.mCurMediaPlayer.setOnAudioFrameOutListener(this.mInnerOnAudioFrameOutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnCaptureImageListener(ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.mOnCaptureImageListener = onCaptureImageListener;
        this.mCurMediaPlayer.setOnCaptureImageListener(this.mInnerOnCaptureImageListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnCompletionListener(ITVKMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
        this.mCurMediaPlayer.setOnCompletionListener(this.mInnerOnCompletionListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnErrorListener(ITVKMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        this.mCurMediaPlayer.setOnErrorListener(this.mInnerOnErrorListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnGetUserInfoListener(ITVKMediaPlayer.OnGetUserInfoListener onGetUserInfoListener) {
        this.mOnGetUserInfoListener = onGetUserInfoListener;
        this.mCurMediaPlayer.setOnGetUserInfoListener(this.mInnerOnGetUserInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnInfoListener(ITVKMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
        this.mCurMediaPlayer.setOnInfoListener(this.mInnerOnInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnLogoPositionListener(ITVKMediaPlayer.OnLogoPositionListener onLogoPositionListener) {
        this.mOnLogoPositionListener = onLogoPositionListener;
        this.mCurMediaPlayer.setOnLogoPositionListener(this.mInnerOnLogoPositionListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnLoopbackChangedListener(ITVKMediaPlayer.OnLoopBackChangedListener onLoopBackChangedListener) {
        this.mOnLoopBackChangedListener = onLoopBackChangedListener;
        this.mCurMediaPlayer.setOnLoopbackChangedListener(this.mInnerOnLoopBackChangedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnMidAdListener(ITVKMediaPlayer.OnMidAdListener onMidAdListener) {
        this.mOnMidAdListener = onMidAdListener;
        this.mCurMediaPlayer.setOnMidAdListener(this.mInnerOnMidAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnNetVideoInfoListener(ITVKMediaPlayer.OnNetVideoInfoListener onNetVideoInfoListener) {
        this.mOnNetVideoInfoListener = onNetVideoInfoListener;
        this.mCurMediaPlayer.setOnNetVideoInfoListener(this.mInnerOnNetVideoInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPermissionTimeoutListener(ITVKMediaPlayer.OnPermissionTimeoutListener onPermissionTimeoutListener) {
        this.mOnPermissionTimeoutListener = onPermissionTimeoutListener;
        this.mCurMediaPlayer.setOnPermissionTimeoutListener(this.mInnerOnPermissionTimeoutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPostRollAdListener(ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener) {
        this.mOnPostRollAdListener = onPostRollAdListener;
        this.mCurMediaPlayer.setOnPostRollAdListener(this.mInnerOnPostRollAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPreAdListener(ITVKMediaPlayer.OnPreAdListener onPreAdListener) {
        this.mOnPreAdListener = onPreAdListener;
        this.mCurMediaPlayer.setOnPreAdListener(this.mInnerOnPreAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnScrollAdListener(ITVKMediaPlayer.OnScrollAdListener onScrollAdListener) {
        this.mOnScrollAdListener = onScrollAdListener;
        this.mCurMediaPlayer.setOnScrollAdListener(this.mInnerOnScrollAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnSeekCompleteListener(ITVKMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
        this.mCurMediaPlayer.setOnSeekCompleteListener(this.mInnerOnSeekCompleteListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoFrameOutListener(ITVKMediaPlayer.OnVideoFrameOutListener onVideoFrameOutListener) {
        this.mOnVideoFrameOutListener = onVideoFrameOutListener;
        this.mCurMediaPlayer.setOnVideoFrameOutListener(this.mInnerOnVideoFrameOutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoPreparedListener(ITVKMediaPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        this.mOnVideoPreparedListener = onVideoPreparedListener;
        this.mCurMediaPlayer.setOnVideoPreparedListener(this.mInnerOnVideoPreparedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoPreparingListener(ITVKMediaPlayer.OnVideoPreparingListener onVideoPreparingListener) {
        this.mOnVideoPreparingListener = onVideoPreparingListener;
        this.mCurMediaPlayer.setOnVideoPreparingListener(this.mInnerOnVideoPreparingListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoSizeChangedListener(ITVKMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
        this.mCurMediaPlayer.setOnVideoSizeChangedListener(this.mInnerOnVideoSizeChangedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean setOutputMute(boolean z16) {
        this.mMute = z16;
        return this.mCurMediaPlayer.setOutputMute(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setPlaySpeedRatio(float f16) {
        this.mSpeedRatio = f16;
        this.mCurMediaPlayer.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setSurface(Surface surface) {
        this.mCurMediaPlayer.setSurface(surface);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setXYaxis(int i3) {
        this.mXYaxisType = i3;
        this.mCurMediaPlayer.setXYaxis(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void skipAd() {
        this.mCurMediaPlayer.skipAd();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void start() {
        TVKLogUtil.i(TAG, "api call: start.");
        this.mCurMediaPlayer.start();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void stop() {
        TVKLogUtil.i(TAG, "api call: stop.");
        synchronized (this) {
            paramReset();
        }
        this.mCurMediaPlayer.stop();
        if (!this.mCacheMediaPlayers.isEmpty()) {
            TVKThreadPool.getInstance().obtainHighPriorityExecutor().execute(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.logic.TVKMultiMediaPlayerImpl.27
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        MediaPlayerEntry mediaPlayerEntry = (MediaPlayerEntry) TVKMultiMediaPlayerImpl.this.mCacheMediaPlayers.peek();
                        while (mediaPlayerEntry != null) {
                            ITVKMediaPlayer iTVKMediaPlayer = mediaPlayerEntry.mMediaPlayer;
                            if (iTVKMediaPlayer != null) {
                                iTVKMediaPlayer.stop();
                                iTVKMediaPlayer.release();
                            }
                            mediaPlayerEntry = (MediaPlayerEntry) TVKMultiMediaPlayerImpl.this.mCacheMediaPlayers.remove();
                        }
                    } catch (Exception e16) {
                        TVKLogUtil.i(TVKMultiMediaPlayerImpl.TAG, e16.getMessage());
                    }
                }
            });
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException {
        this.mCurDefinition = str;
        this.mCurMediaPlayer.switchDefinition(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        this.mCurUserInfo = tVKUserInfo;
        this.mVideoInfo = tVKPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null) {
            this.mCurDefinition = tVKPlayerVideoInfo.getDefinition();
        }
        this.mCurMediaPlayer.switchDefinitionWithReopen(tVKUserInfo, tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updatePlayerVideoView(ITVKDrawableContainer iTVKDrawableContainer) {
        this.mCurDrawableContainer = iTVKDrawableContainer;
        this.mCurMediaPlayer.updatePlayerVideoView(iTVKDrawableContainer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updateReportParam(TVKProperties tVKProperties) {
        this.mCurMediaPlayer.updateReportParam(tVKProperties);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updateUserInfo(TVKUserInfo tVKUserInfo) {
        this.mCurUserInfo = tVKUserInfo;
        this.mCurMediaPlayer.updateUserInfo(tVKUserInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updateVrReportParam(TVKProperties tVKProperties) {
        this.mCurMediaPlayer.updateVrReportParam(tVKProperties);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addTrack(int i3, String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalArgumentException {
        this.mCurMediaPlayer.addTrack(i3, str, tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onClickPause(ViewGroup viewGroup) {
        this.mCurMediaPlayer.onClickPause(viewGroup);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @RequiresApi(api = 24)
    public void setDisplayScale(float f16, float f17, float f18) {
        this.mCurMediaPlayer.setDisplayScale(f16, f17, f18);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setLoopback(boolean z16, long j3, long j16) throws IllegalStateException, IllegalArgumentException {
        this.mLoopBack = z16;
        this.mCurMediaPlayer.setLoopback(z16, j3, j16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        this.mCurUserInfo = tVKUserInfo;
        this.mVideoInfo = tVKPlayerVideoInfo;
        if (tVKPlayerVideoInfo != null) {
            this.mCurDefinition = tVKPlayerVideoInfo.getDefinition();
        }
        this.mCurMediaPlayer.switchDefinition(tVKUserInfo, tVKPlayerVideoInfo);
    }
}

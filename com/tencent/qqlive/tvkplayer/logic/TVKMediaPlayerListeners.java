package com.tencent.qqlive.tvkplayer.logic;

import android.graphics.Bitmap;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;

/* loaded from: classes23.dex */
public class TVKMediaPlayerListeners implements ITVKMediaPlayer.OnPreAdListener, ITVKMediaPlayer.OnMidAdListener, ITVKMediaPlayer.OnPostRollAdListener, ITVKMediaPlayer.OnAdClickedListener, ITVKMediaPlayer.OnVideoPreparingListener, ITVKMediaPlayer.OnVideoPreparedListener, ITVKMediaPlayer.OnNetVideoInfoListener, ITVKMediaPlayer.OnCompletionListener, ITVKMediaPlayer.OnLoopBackChangedListener, ITVKMediaPlayer.OnPermissionTimeoutListener, ITVKMediaPlayer.OnSeekCompleteListener, ITVKMediaPlayer.OnCaptureImageListener, ITVKMediaPlayer.OnErrorListener, ITVKMediaPlayer.OnInfoListener, ITVKMediaPlayer.OnGetUserInfoListener, ITVKMediaPlayer.OnLogoPositionListener, ITVKMediaPlayer.OnVideoSizeChangedListener, ITVKMediaPlayer.OnScrollAdListener, ITVKMediaPlayer.OnAdCustomCommandListener, ITVKMediaPlayer.OnVideoFrameOutListener, ITVKMediaPlayer.OnAudioFrameOutListener {
    private TVKMediaPlayerListenersEmptyImpl mEmptyListeners;
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
    private String mTag = "TVKPlayer[TVKPlayerMediaPlayerListeners]";

    /* loaded from: classes23.dex */
    interface Combine extends ITVKMediaPlayer.OnPreAdListener, ITVKMediaPlayer.OnMidAdListener, ITVKMediaPlayer.OnPostRollAdListener, ITVKMediaPlayer.OnAdClickedListener, ITVKMediaPlayer.OnVideoPreparingListener, ITVKMediaPlayer.OnVideoPreparedListener, ITVKMediaPlayer.OnNetVideoInfoListener, ITVKMediaPlayer.OnCompletionListener, ITVKMediaPlayer.OnLoopBackChangedListener, ITVKMediaPlayer.OnPermissionTimeoutListener, ITVKMediaPlayer.OnSeekCompleteListener, ITVKMediaPlayer.OnCaptureImageListener, ITVKMediaPlayer.OnErrorListener, ITVKMediaPlayer.OnInfoListener, ITVKMediaPlayer.OnGetUserInfoListener, ITVKMediaPlayer.OnLogoPositionListener, ITVKMediaPlayer.OnVideoSizeChangedListener, ITVKMediaPlayer.OnScrollAdListener, ITVKMediaPlayer.OnAdCustomCommandListener, ITVKMediaPlayer.OnVideoFrameOutListener, ITVKMediaPlayer.OnAudioFrameOutListener {
    }

    /* loaded from: classes23.dex */
    private class TVKMediaPlayerListenersEmptyImpl implements ITVKMediaPlayer.OnPreAdListener, ITVKMediaPlayer.OnMidAdListener, ITVKMediaPlayer.OnPostRollAdListener, ITVKMediaPlayer.OnAdClickedListener, ITVKMediaPlayer.OnVideoPreparingListener, ITVKMediaPlayer.OnVideoPreparedListener, ITVKMediaPlayer.OnNetVideoInfoListener, ITVKMediaPlayer.OnCompletionListener, ITVKMediaPlayer.OnLoopBackChangedListener, ITVKMediaPlayer.OnPermissionTimeoutListener, ITVKMediaPlayer.OnSeekCompleteListener, ITVKMediaPlayer.OnCaptureImageListener, ITVKMediaPlayer.OnErrorListener, ITVKMediaPlayer.OnInfoListener, ITVKMediaPlayer.OnGetUserInfoListener, ITVKMediaPlayer.OnLogoPositionListener, ITVKMediaPlayer.OnVideoSizeChangedListener, ITVKMediaPlayer.OnScrollAdListener, ITVKMediaPlayer.OnAdCustomCommandListener, ITVKMediaPlayer.OnVideoFrameOutListener, ITVKMediaPlayer.OnAudioFrameOutListener {
        TVKMediaPlayerListenersEmptyImpl() {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdCustomCommandListener
        public Object onAdCustomCommand(ITVKMediaPlayer iTVKMediaPlayer, String str, Object obj) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onAdCustomCommand");
            return null;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdExitFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onAdExitFullScreenClick");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onAdFullScreenClick");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdReturnClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onAdReturnClick");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdSkipClick(ITVKMediaPlayer iTVKMediaPlayer, boolean z16, int i3) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onAdSkipClick");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdWarnerTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onAdWarnerTipClick");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAudioFrameOutListener
        public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onAudioFrameOut");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onCaptureImageFailed");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onCaptureImageSucceed");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
        public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onCompletion");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onEnterVipTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onEnterVipTipClick");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
        public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onError");
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
        public void onFinishAd(ITVKMediaPlayer iTVKMediaPlayer, int i3) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onFinishAd");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnGetUserInfoListener
        public TVKUserInfo onGetUserInfo(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onGetUserInfo");
            return null;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
        public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onInfo");
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewClosed(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onLandingViewClosed");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewFail(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onLandingViewFail");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewWillPresent(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onLandingViewWillPresent");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLoopBackChangedListener
        public void onLoopBackChanged(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onLoopBackChanged");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onMidAdCountdown");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onMidAdEndCountdown");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onMidAdPlayCompleted");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onMidAdStartCountdown");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
        public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onNetVideoInfo");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLogoPositionListener
        public void onOriginalLogoPosition(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, int i18, boolean z16) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onOriginalLogoPosition");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPermissionTimeoutListener
        public void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onPermissionTimeout");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onPostAdPlayCompleted");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onPostrollAdPrepared");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onPostrollAdPreparing");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onPreAdPlayCompleted");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onPreAdPrepared");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onPreAdPreparing");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onSeekComplete");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
        public void onSwitchAd(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj, Object obj2) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onSwitchAd");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoFrameOutListener
        public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onVideoFrameOut");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onVideoPrepared");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparingListener
        public void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onVideoPreparing");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onVideoSizeChanged");
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onVolumeChange(ITVKMediaPlayer iTVKMediaPlayer, float f16) {
            TVKLogUtil.i(TVKMediaPlayerListeners.this.mTag, "empty media player listener , onVolumeChange");
        }
    }

    public TVKMediaPlayerListeners() {
        TVKMediaPlayerListenersEmptyImpl tVKMediaPlayerListenersEmptyImpl = new TVKMediaPlayerListenersEmptyImpl();
        this.mEmptyListeners = tVKMediaPlayerListenersEmptyImpl;
        this.mOnPreAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnMidAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnPostRollAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnAdClickedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoPreparingListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoPreparedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnNetVideoInfoListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnCompletionListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnLoopBackChangedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnPermissionTimeoutListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnSeekCompleteListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnCaptureImageListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnErrorListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnInfoListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnGetUserInfoListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnLogoPositionListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoSizeChangedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnScrollAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnAdCustomCommandListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoFrameOutListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnAudioFrameOutListener = tVKMediaPlayerListenersEmptyImpl;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdCustomCommandListener
    public Object onAdCustomCommand(ITVKMediaPlayer iTVKMediaPlayer, String str, Object obj) {
        return this.mOnAdCustomCommandListener.onAdCustomCommand(iTVKMediaPlayer, str, obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdExitFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onAdExitFullScreenClick(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onAdFullScreenClick(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdReturnClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onAdReturnClick(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdSkipClick(ITVKMediaPlayer iTVKMediaPlayer, boolean z16, int i3) {
        this.mOnAdClickedListener.onAdSkipClick(iTVKMediaPlayer, z16, i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdWarnerTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onAdWarnerTipClick(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAudioFrameOutListener
    public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
        this.mOnAudioFrameOutListener.onAudioFrameOut(tVKAudioFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
        this.mOnCaptureImageListener.onCaptureImageFailed(iTVKMediaPlayer, i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap) {
        this.mOnCaptureImageListener.onCaptureImageSucceed(iTVKMediaPlayer, i3, i16, i17, bitmap);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
    public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnCompletionListener.onCompletion(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onEnterVipTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onEnterVipTipClick(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
    public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
        this.mOnErrorListener.onError(iTVKMediaPlayer, tVKError);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
    public void onFinishAd(ITVKMediaPlayer iTVKMediaPlayer, int i3) {
        this.mOnScrollAdListener.onFinishAd(iTVKMediaPlayer, i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnGetUserInfoListener
    public TVKUserInfo onGetUserInfo(ITVKMediaPlayer iTVKMediaPlayer) {
        return this.mOnGetUserInfoListener.onGetUserInfo(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
    public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
        this.mOnInfoListener.onInfo(iTVKMediaPlayer, i3, obj);
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewClosed(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onLandingViewClosed(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewFail(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onLandingViewFail(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewWillPresent(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnAdClickedListener.onLandingViewWillPresent(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLoopBackChangedListener
    public void onLoopBackChanged(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnLoopBackChangedListener.onLoopBackChanged(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mOnMidAdListener.onMidAdCountdown(iTVKMediaPlayer, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mOnMidAdListener.onMidAdEndCountdown(iTVKMediaPlayer, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnMidAdListener.onMidAdFinish(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16) {
        this.mOnMidAdListener.onMidAdStartCountdown(iTVKMediaPlayer, j3, j16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
    public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
        this.mOnNetVideoInfoListener.onNetVideoInfo(iTVKMediaPlayer, tVKNetVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLogoPositionListener
    public void onOriginalLogoPosition(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, int i18, boolean z16) {
        this.mOnLogoPositionListener.onOriginalLogoPosition(iTVKMediaPlayer, i3, i16, i17, i18, z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPermissionTimeoutListener
    public void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnPermissionTimeoutListener.onPermissionTimeout(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnPostRollAdListener.onPostAdFinish(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mOnPostRollAdListener.onPostrollAdPrepared(iTVKMediaPlayer, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnPostRollAdListener.onPostrollAdPreparing(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnPreAdListener.onPreAdFinish(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        this.mOnPreAdListener.onPreAdPrepared(iTVKMediaPlayer, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnPreAdListener.onPreAdPreparing(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnSeekCompleteListener.onSeekComplete(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
    public void onSwitchAd(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj, Object obj2) {
        this.mOnScrollAdListener.onSwitchAd(iTVKMediaPlayer, i3, obj, obj2);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoFrameOutListener
    public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
        this.mOnVideoFrameOutListener.onVideoFrameOut(tVKVideoFrameBuffer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnVideoPreparedListener.onVideoPrepared(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparingListener
    public void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        this.mOnVideoPreparingListener.onVideoPreparing(iTVKMediaPlayer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
        this.mOnVideoSizeChangedListener.onVideoSizeChanged(iTVKMediaPlayer, i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onVolumeChange(ITVKMediaPlayer iTVKMediaPlayer, float f16) {
        this.mOnAdClickedListener.onVolumeChange(iTVKMediaPlayer, f16);
    }

    public void recycle() {
        TVKMediaPlayerListenersEmptyImpl tVKMediaPlayerListenersEmptyImpl = this.mEmptyListeners;
        this.mOnPreAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnMidAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnPostRollAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnAdClickedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoPreparingListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoPreparedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnNetVideoInfoListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnCompletionListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnLoopBackChangedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnPermissionTimeoutListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnSeekCompleteListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnCaptureImageListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnErrorListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnInfoListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnGetUserInfoListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnLogoPositionListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoSizeChangedListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnScrollAdListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnAdCustomCommandListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnVideoFrameOutListener = tVKMediaPlayerListenersEmptyImpl;
        this.mOnAudioFrameOutListener = tVKMediaPlayerListenersEmptyImpl;
    }

    public void setOnAdClickedListener(ITVKMediaPlayer.OnAdClickedListener onAdClickedListener) {
        if (onAdClickedListener == null) {
            onAdClickedListener = this.mEmptyListeners;
        }
        this.mOnAdClickedListener = onAdClickedListener;
    }

    public void setOnAdCustomCommandListener(ITVKMediaPlayer.OnAdCustomCommandListener onAdCustomCommandListener) {
        if (onAdCustomCommandListener == null) {
            onAdCustomCommandListener = this.mEmptyListeners;
        }
        this.mOnAdCustomCommandListener = onAdCustomCommandListener;
    }

    public void setOnAudioPcmDataListener(ITVKMediaPlayer.OnAudioFrameOutListener onAudioFrameOutListener) {
        if (onAudioFrameOutListener == null) {
            onAudioFrameOutListener = this.mEmptyListeners;
        }
        this.mOnAudioFrameOutListener = onAudioFrameOutListener;
    }

    public void setOnCaptureImageListener(ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener) {
        if (onCaptureImageListener == null) {
            onCaptureImageListener = this.mEmptyListeners;
        }
        this.mOnCaptureImageListener = onCaptureImageListener;
    }

    public void setOnCompletionListener(ITVKMediaPlayer.OnCompletionListener onCompletionListener) {
        if (onCompletionListener == null) {
            onCompletionListener = this.mEmptyListeners;
        }
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(ITVKMediaPlayer.OnErrorListener onErrorListener) {
        if (onErrorListener == null) {
            onErrorListener = this.mEmptyListeners;
        }
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnGetUserInfoListener(ITVKMediaPlayer.OnGetUserInfoListener onGetUserInfoListener) {
        if (onGetUserInfoListener == null) {
            onGetUserInfoListener = this.mEmptyListeners;
        }
        this.mOnGetUserInfoListener = onGetUserInfoListener;
    }

    public void setOnInfoListener(ITVKMediaPlayer.OnInfoListener onInfoListener) {
        if (onInfoListener == null) {
            onInfoListener = this.mEmptyListeners;
        }
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnLogoPositionListener(ITVKMediaPlayer.OnLogoPositionListener onLogoPositionListener) {
        if (onLogoPositionListener == null) {
            onLogoPositionListener = this.mEmptyListeners;
        }
        this.mOnLogoPositionListener = onLogoPositionListener;
    }

    public void setOnLoopBackChangedListener(ITVKMediaPlayer.OnLoopBackChangedListener onLoopBackChangedListener) {
        if (onLoopBackChangedListener == null) {
            onLoopBackChangedListener = this.mEmptyListeners;
        }
        this.mOnLoopBackChangedListener = onLoopBackChangedListener;
    }

    public void setOnMidAdListener(ITVKMediaPlayer.OnMidAdListener onMidAdListener) {
        if (onMidAdListener == null) {
            onMidAdListener = this.mEmptyListeners;
        }
        this.mOnMidAdListener = onMidAdListener;
    }

    public void setOnNetVideoInfoListener(ITVKMediaPlayer.OnNetVideoInfoListener onNetVideoInfoListener) {
        if (onNetVideoInfoListener == null) {
            onNetVideoInfoListener = this.mEmptyListeners;
        }
        this.mOnNetVideoInfoListener = onNetVideoInfoListener;
    }

    public void setOnPermissionTimeoutListener(ITVKMediaPlayer.OnPermissionTimeoutListener onPermissionTimeoutListener) {
        if (onPermissionTimeoutListener == null) {
            onPermissionTimeoutListener = this.mEmptyListeners;
        }
        this.mOnPermissionTimeoutListener = onPermissionTimeoutListener;
    }

    public void setOnPostRollAdListener(ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener) {
        if (onPostRollAdListener == null) {
            onPostRollAdListener = this.mEmptyListeners;
        }
        this.mOnPostRollAdListener = onPostRollAdListener;
    }

    public void setOnPreAdListener(ITVKMediaPlayer.OnPreAdListener onPreAdListener) {
        if (onPreAdListener == null) {
            onPreAdListener = this.mEmptyListeners;
        }
        this.mOnPreAdListener = onPreAdListener;
    }

    public void setOnScrollAdListener(ITVKMediaPlayer.OnScrollAdListener onScrollAdListener) {
        if (onScrollAdListener == null) {
            onScrollAdListener = this.mEmptyListeners;
        }
        this.mOnScrollAdListener = onScrollAdListener;
    }

    public void setOnSeekCompleteListener(ITVKMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        if (onSeekCompleteListener == null) {
            onSeekCompleteListener = this.mEmptyListeners;
        }
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnVideoOutputFrameListener(ITVKMediaPlayer.OnVideoFrameOutListener onVideoFrameOutListener) {
        if (onVideoFrameOutListener == null) {
            onVideoFrameOutListener = this.mEmptyListeners;
        }
        this.mOnVideoFrameOutListener = onVideoFrameOutListener;
    }

    public void setOnVideoPreparedListener(ITVKMediaPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        if (onVideoPreparedListener == null) {
            onVideoPreparedListener = this.mEmptyListeners;
        }
        this.mOnVideoPreparedListener = onVideoPreparedListener;
    }

    public void setOnVideoPreparingListener(ITVKMediaPlayer.OnVideoPreparingListener onVideoPreparingListener) {
        if (onVideoPreparingListener == null) {
            onVideoPreparingListener = this.mEmptyListeners;
        }
        this.mOnVideoPreparingListener = onVideoPreparingListener;
    }

    public void setOnVideoSizeChangedListener(ITVKMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        if (onVideoSizeChangedListener == null) {
            onVideoSizeChangedListener = this.mEmptyListeners;
        }
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }
}

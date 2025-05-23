package com.tencent.qqlive.tvkplayer.logic;

import android.graphics.Bitmap;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKListenerManager implements ITVKMediaPlayer.OnPreAdListener, ITVKMediaPlayer.OnMidAdListener, ITVKMediaPlayer.OnPostRollAdListener, ITVKMediaPlayer.OnAdClickedListener, ITVKMediaPlayer.OnScrollAdListener, ITVKMediaPlayer.OnAdCustomCommandListener, ITVKMediaPlayer.OnVideoPreparingListener, ITVKMediaPlayer.OnVideoPreparedListener, ITVKMediaPlayer.OnNetVideoInfoListener, ITVKMediaPlayer.OnCompletionListener, ITVKMediaPlayer.OnLoopBackChangedListener, ITVKMediaPlayer.OnPermissionTimeoutListener, ITVKMediaPlayer.OnSeekCompleteListener, ITVKMediaPlayer.OnCaptureImageListener, ITVKMediaPlayer.OnErrorListener, ITVKMediaPlayer.OnInfoListener, ITVKMediaPlayer.OnLogoPositionListener, ITVKMediaPlayer.OnVideoSizeChangedListener, ITVKMediaPlayer.OnVideoFrameOutListener, ITVKMediaPlayer.OnAudioFrameOutListener, ITVKPlayerEventListener, ITVKReportEventListener {
    private static final String TAG = "TVKPlayer[TVKListenerManager]";
    private ITVKMediaPlayer.OnCaptureImageListener mOnCaptureImageListener = null;
    private ITVKMediaPlayer.OnErrorListener mOnErrorListener = null;
    private ITVKMediaPlayer.OnInfoListener mOnInfoListener = null;
    private ITVKMediaPlayer.OnAdClickedListener mOnAdClickedListener = null;
    private ITVKMediaPlayer.OnLogoPositionListener mOnLogoPositionListener = null;
    private ITVKMediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener = null;
    private ITVKMediaPlayer.OnPreAdListener mOnPreAdListener = null;
    private ITVKMediaPlayer.OnMidAdListener mOnMidAdListener = null;
    private ITVKMediaPlayer.OnPostRollAdListener mOnPostrollAdListener = null;
    private ITVKMediaPlayer.OnVideoPreparingListener mOnVideoPreparingListener = null;
    private ITVKMediaPlayer.OnVideoPreparedListener mOnVideoPreparedListener = null;
    private ITVKMediaPlayer.OnNetVideoInfoListener mOnNetVideoInfoListener = null;
    private ITVKMediaPlayer.OnCompletionListener mOnCompletionListener = null;
    private ITVKMediaPlayer.OnLoopBackChangedListener mOnLoopbackChangedListener = null;
    private ITVKMediaPlayer.OnPermissionTimeoutListener mOnPermissionTimeoutListener = null;
    private ITVKMediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener = null;
    private ITVKMediaPlayer.OnScrollAdListener mOnScrollAdListener = null;
    private ITVKMediaPlayer.OnAdCustomCommandListener mOnAdCustomCommandListener = null;
    private ITVKMediaPlayer.OnGetUserInfoListener mOnGetUserInfoListener = null;
    private ITVKMediaPlayer.OnVideoFrameOutListener mOnVideoFrameOutListener = null;
    private ITVKMediaPlayer.OnAudioFrameOutListener monAudioFrameOutListener = null;
    private Set<ITVKPlayerEventListener> mPlayerEventListeners = new HashSet();
    private Set<ITVKReportEventListener> mReportEventListeners = new HashSet();

    public void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayerEventListeners.add(iTVKPlayerEventListener);
    }

    public void addReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mReportEventListeners.add(iTVKReportEventListener);
    }

    public boolean hasOnCaptureImageListener() {
        if (this.mOnCaptureImageListener == null) {
            return false;
        }
        return true;
    }

    public boolean hasOnPermissionTimeoutLis() {
        if (this.mOnPermissionTimeoutListener == null) {
            return false;
        }
        return true;
    }

    public boolean hasOnPostrollAdPrepared() {
        if (this.mOnPostrollAdListener == null) {
            return false;
        }
        return true;
    }

    public boolean hasOnPreAdListener() {
        if (this.mOnPreAdListener == null) {
            return false;
        }
        return true;
    }

    public boolean hasOnVideoPreparedListener() {
        if (this.mOnVideoPreparedListener == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdCustomCommandListener
    public Object onAdCustomCommand(ITVKMediaPlayer iTVKMediaPlayer, String str, Object obj) {
        ITVKMediaPlayer.OnAdCustomCommandListener onAdCustomCommandListener = this.mOnAdCustomCommandListener;
        if (onAdCustomCommandListener != null) {
            TVKLogUtil.i(TAG, "notify : onAdCustomCommand type:" + str);
            return onAdCustomCommandListener.onAdCustomCommand(iTVKMediaPlayer, str, obj);
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdExitFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onAdExitFullScreenClick");
            onAdClickedListener.onAdExitFullScreenClick(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onAdFullScreenClick");
            onAdClickedListener.onAdFullScreenClick(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdReturnClick(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onAdReturnClick");
            onAdClickedListener.onAdReturnClick(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdSkipClick(ITVKMediaPlayer iTVKMediaPlayer, boolean z16, int i3) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onAdSkipClick isCopyRightForWarner:" + z16);
            onAdClickedListener.onAdSkipClick(iTVKMediaPlayer, z16, i3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onAdWarnerTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onAdWarnerTipClick");
            onAdClickedListener.onAdWarnerTipClick(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAudioFrameOutListener
    public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
        ITVKMediaPlayer.OnAudioFrameOutListener onAudioFrameOutListener = this.monAudioFrameOutListener;
        if (onAudioFrameOutListener != null) {
            TVKLogUtil.i(TAG, "notify : onAudioFrameOut");
            onAudioFrameOutListener.onAudioFrameOut(tVKAudioFrameBuffer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
    public void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
        ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener = this.mOnCaptureImageListener;
        if (onCaptureImageListener != null) {
            TVKLogUtil.i(TAG, "notify : onCaptureImageFailed id:" + i3 + ", errCode:" + i16);
            onCaptureImageListener.onCaptureImageFailed(iTVKMediaPlayer, i3, i16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
    public void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap) {
        ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener = this.mOnCaptureImageListener;
        if (onCaptureImageListener != null) {
            TVKLogUtil.i(TAG, "notify : onCaptureImageSucceed id:" + i3 + ", width:" + i16 + ", height:" + i17);
            onCaptureImageListener.onCaptureImageSucceed(iTVKMediaPlayer, i3, i16, i17, bitmap);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
    public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
        if (onCompletionListener != null) {
            TVKLogUtil.i(TAG, "notify : onCompletion");
            onCompletionListener.onCompletion(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
    public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
        ITVKMediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
        if (onErrorListener != null) {
            TVKLogUtil.i(TAG, "notify : onError " + tVKError.toString());
            return onErrorListener.onError(iTVKMediaPlayer, tVKError);
        }
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
    public void onFinishAd(ITVKMediaPlayer iTVKMediaPlayer, int i3) {
        ITVKMediaPlayer.OnScrollAdListener onScrollAdListener = this.mOnScrollAdListener;
        if (onScrollAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onFinishAd");
            onScrollAdListener.onFinishAd(iTVKMediaPlayer, i3);
        }
    }

    public TVKUserInfo onGetUserInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKUserInfo tVKUserInfo) {
        ITVKMediaPlayer.OnGetUserInfoListener onGetUserInfoListener = this.mOnGetUserInfoListener;
        if (onGetUserInfoListener != null) {
            TVKLogUtil.i(TAG, "notify : onGetUserInfo");
            return onGetUserInfoListener.onGetUserInfo(iTVKMediaPlayer);
        }
        return tVKUserInfo;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
    public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
        ITVKMediaPlayer.OnInfoListener onInfoListener = this.mOnInfoListener;
        if (onInfoListener != null) {
            TVKLogUtil.i(TAG, "notify : onInfo, what : " + i3);
            return onInfoListener.onInfo(iTVKMediaPlayer, i3, obj);
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewClosed(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onLandingViewClosed");
            onAdClickedListener.onLandingViewClosed(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewFail(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onLandingViewFail");
            onAdClickedListener.onLandingViewFail(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onLandingViewWillPresent(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onLandingViewWillPresent");
            onAdClickedListener.onLandingViewWillPresent(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLoopBackChangedListener
    public void onLoopBackChanged(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnLoopBackChangedListener onLoopBackChangedListener = this.mOnLoopbackChangedListener;
        if (onLoopBackChangedListener != null) {
            TVKLogUtil.i(TAG, "notify : onLoopBackChanged");
            onLoopBackChangedListener.onLoopBackChanged(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        ITVKMediaPlayer.OnMidAdListener onMidAdListener = this.mOnMidAdListener;
        if (onMidAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onMidAdCountdown, countDownMilsec:" + j3);
            onMidAdListener.onMidAdCountdown(iTVKMediaPlayer, j3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        ITVKMediaPlayer.OnMidAdListener onMidAdListener = this.mOnMidAdListener;
        if (onMidAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onMidAdEndCountdown, adDuration:" + j3);
            onMidAdListener.onMidAdEndCountdown(iTVKMediaPlayer, j3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnMidAdListener onMidAdListener = this.mOnMidAdListener;
        if (onMidAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onMidAdPlayCompleted");
            onMidAdListener.onMidAdFinish(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
    public void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16) {
        ITVKMediaPlayer.OnMidAdListener onMidAdListener = this.mOnMidAdListener;
        if (onMidAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onMidAdStartCountdown, countDownMilsec:" + j3);
            onMidAdListener.onMidAdStartCountdown(iTVKMediaPlayer, j3, j16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
    public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
        ITVKMediaPlayer.OnNetVideoInfoListener onNetVideoInfoListener = this.mOnNetVideoInfoListener;
        if (onNetVideoInfoListener != null) {
            TVKLogUtil.i(TAG, "notify : onNetVideoInfo");
            onNetVideoInfoListener.onNetVideoInfo(iTVKMediaPlayer, tVKNetVideoInfo);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLogoPositionListener
    public void onOriginalLogoPosition(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, int i18, boolean z16) {
        ITVKMediaPlayer.OnLogoPositionListener onLogoPositionListener = this.mOnLogoPositionListener;
        if (onLogoPositionListener != null) {
            TVKLogUtil.i(TAG, "notify : onOriginalLogoPosition xAxis:" + i3 + ", yAxis:" + i16 + ", height:" + i17 + ", width:" + i18 + ", isShow:" + z16);
            onLogoPositionListener.onOriginalLogoPosition(iTVKMediaPlayer, i3, i16, i17, i18, z16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPermissionTimeoutListener
    public void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnPermissionTimeoutListener onPermissionTimeoutListener = this.mOnPermissionTimeoutListener;
        if (onPermissionTimeoutListener != null) {
            TVKLogUtil.i(TAG, "notify : onPermissionTimeout");
            onPermissionTimeoutListener.onPermissionTimeout(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener
    public void onPlayerEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKPlayerEventListener.PlayerEvent playerEvent, ITVKPlayerEventListener.EventParams eventParams) {
        Set<ITVKPlayerEventListener> set = this.mPlayerEventListeners;
        if (set != null) {
            TVKLogUtil.i(TAG, "notify : onPlayerEvent event:" + playerEvent);
            Iterator<ITVKPlayerEventListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onPlayerEvent(iTVKMediaPlayer, playerEvent, eventParams);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener = this.mOnPostrollAdListener;
        if (onPostRollAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onPostAdFinish");
            onPostRollAdListener.onPostAdFinish(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener = this.mOnPostrollAdListener;
        if (onPostRollAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onPostrollAdPrepared");
            onPostRollAdListener.onPostrollAdPrepared(iTVKMediaPlayer, j3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
    public void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener = this.mOnPostrollAdListener;
        if (onPostRollAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onPostrollAdPreparing");
            onPostRollAdListener.onPostrollAdPreparing(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnPreAdListener onPreAdListener = this.mOnPreAdListener;
        if (onPreAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onPreAdPlayCompleted");
            onPreAdListener.onPreAdFinish(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
        ITVKMediaPlayer.OnPreAdListener onPreAdListener = this.mOnPreAdListener;
        if (onPreAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onPreAdPrepared, adDuration=" + j3);
            onPreAdListener.onPreAdPrepared(iTVKMediaPlayer, j3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
    public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnPreAdListener onPreAdListener = this.mOnPreAdListener;
        if (onPreAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onPreAdPreparing");
            onPreAdListener.onPreAdPreparing(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener
    public void onReportEvent(ITVKMediaPlayer iTVKMediaPlayer, ITVKReportEventListener.ReportEvent reportEvent, ITVKReportEventListener.ReportEventParams reportEventParams) {
        Set<ITVKReportEventListener> set = this.mReportEventListeners;
        if (set != null) {
            TVKLogUtil.i(TAG, "notify : onReportPushEvent event:" + reportEvent);
            Iterator<ITVKReportEventListener> it = set.iterator();
            while (it.hasNext()) {
                it.next().onReportEvent(iTVKMediaPlayer, reportEvent, reportEventParams);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnSeekCompleteListener onSeekCompleteListener = this.mOnSeekCompleteListener;
        if (onSeekCompleteListener != null) {
            TVKLogUtil.i(TAG, "notify : onSeekComplete");
            onSeekCompleteListener.onSeekComplete(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
    public void onSwitchAd(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj, Object obj2) {
        ITVKMediaPlayer.OnScrollAdListener onScrollAdListener = this.mOnScrollAdListener;
        if (onScrollAdListener != null) {
            TVKLogUtil.i(TAG, "notify : onSwitchAd");
            onScrollAdListener.onSwitchAd(iTVKMediaPlayer, i3, obj, obj2);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoFrameOutListener
    public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
        ITVKMediaPlayer.OnVideoFrameOutListener onVideoFrameOutListener = this.mOnVideoFrameOutListener;
        if (onVideoFrameOutListener != null) {
            TVKLogUtil.i(TAG, "notify : onVideoFrameOut");
            onVideoFrameOutListener.onVideoFrameOut(tVKVideoFrameBuffer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
    public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnVideoPreparedListener onVideoPreparedListener = this.mOnVideoPreparedListener;
        TVKLogUtil.i(TAG, "notify : onVideoPrepared: onVideoPreparedListener = " + onVideoPreparedListener);
        if (onVideoPreparedListener != null) {
            TVKLogUtil.i(TAG, "notify : onVideoPrepared");
            onVideoPreparedListener.onVideoPrepared(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparingListener
    public void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
        ITVKMediaPlayer.OnVideoPreparingListener onVideoPreparingListener = this.mOnVideoPreparingListener;
        TVKLogUtil.i(TAG, "notify : onVideoPreparing: onVideoPreparingListener = " + onVideoPreparingListener);
        if (onVideoPreparingListener != null) {
            TVKLogUtil.i(TAG, "notify : onVideoPreparing");
            onVideoPreparingListener.onVideoPreparing(iTVKMediaPlayer);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
        ITVKMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
        if (onVideoSizeChangedListener != null) {
            TVKLogUtil.i(TAG, "notify : onVideoSizeChanged");
            onVideoSizeChangedListener.onVideoSizeChanged(iTVKMediaPlayer, i3, i16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onVolumeChange(ITVKMediaPlayer iTVKMediaPlayer, float f16) {
        ITVKMediaPlayer.OnAdClickedListener onAdClickedListener = this.mOnAdClickedListener;
        if (onAdClickedListener != null) {
            TVKLogUtil.i(TAG, "notify : onVolumeChange value:" + f16);
            onAdClickedListener.onVolumeChange(iTVKMediaPlayer, f16);
        }
    }

    public void release() {
        this.mOnCaptureImageListener = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mOnAdClickedListener = null;
        this.mOnLogoPositionListener = null;
        this.mOnVideoSizeChangedListener = null;
        this.mOnPreAdListener = null;
        this.mOnMidAdListener = null;
        this.mOnPostrollAdListener = null;
        this.mOnVideoPreparingListener = null;
        this.mOnVideoPreparedListener = null;
        this.mOnNetVideoInfoListener = null;
        this.mOnCompletionListener = null;
        this.mOnLoopbackChangedListener = null;
        this.mOnPermissionTimeoutListener = null;
        this.mOnSeekCompleteListener = null;
        this.mOnScrollAdListener = null;
        this.mOnAdCustomCommandListener = null;
        this.mOnGetUserInfoListener = null;
        this.mOnVideoFrameOutListener = null;
        this.monAudioFrameOutListener = null;
    }

    public void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayerEventListeners.remove(iTVKPlayerEventListener);
    }

    public void removeReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mReportEventListeners.remove(iTVKReportEventListener);
    }

    public void setOnAdClickedListener(ITVKMediaPlayer.OnAdClickedListener onAdClickedListener) {
        this.mOnAdClickedListener = onAdClickedListener;
    }

    public void setOnAdCustomCommandListener(ITVKMediaPlayer.OnAdCustomCommandListener onAdCustomCommandListener) {
        this.mOnAdCustomCommandListener = onAdCustomCommandListener;
    }

    public void setOnAudioPcmDataListener(ITVKMediaPlayer.OnAudioFrameOutListener onAudioFrameOutListener) {
        this.monAudioFrameOutListener = onAudioFrameOutListener;
    }

    public void setOnCaptureImageListener(ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.mOnCaptureImageListener = onCaptureImageListener;
    }

    public void setOnCompletionListener(ITVKMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
    }

    public void setOnErrorListener(ITVKMediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
    }

    public void setOnGetUserInfoListener(ITVKMediaPlayer.OnGetUserInfoListener onGetUserInfoListener) {
        this.mOnGetUserInfoListener = onGetUserInfoListener;
    }

    public void setOnInfoListener(ITVKMediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
    }

    public void setOnLogoPositionListener(ITVKMediaPlayer.OnLogoPositionListener onLogoPositionListener) {
        this.mOnLogoPositionListener = onLogoPositionListener;
    }

    public void setOnLoopbackChangedListener(ITVKMediaPlayer.OnLoopBackChangedListener onLoopBackChangedListener) {
        this.mOnLoopbackChangedListener = onLoopBackChangedListener;
    }

    public void setOnMidAdListener(ITVKMediaPlayer.OnMidAdListener onMidAdListener) {
        this.mOnMidAdListener = onMidAdListener;
    }

    public void setOnNetVideoInfoListener(ITVKMediaPlayer.OnNetVideoInfoListener onNetVideoInfoListener) {
        this.mOnNetVideoInfoListener = onNetVideoInfoListener;
    }

    public void setOnPermissionTimeoutListener(ITVKMediaPlayer.OnPermissionTimeoutListener onPermissionTimeoutListener) {
        this.mOnPermissionTimeoutListener = onPermissionTimeoutListener;
    }

    public void setOnPostRollAdListener(ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener) {
        this.mOnPostrollAdListener = onPostRollAdListener;
    }

    public void setOnPreAdListener(ITVKMediaPlayer.OnPreAdListener onPreAdListener) {
        this.mOnPreAdListener = onPreAdListener;
    }

    public void setOnScrollAdListener(ITVKMediaPlayer.OnScrollAdListener onScrollAdListener) {
        this.mOnScrollAdListener = onScrollAdListener;
    }

    public void setOnSeekCompleteListener(ITVKMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
    }

    public void setOnVideoOutputFrameListener(ITVKMediaPlayer.OnVideoFrameOutListener onVideoFrameOutListener) {
        this.mOnVideoFrameOutListener = onVideoFrameOutListener;
    }

    public void setOnVideoPreparedListener(ITVKMediaPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        this.mOnVideoPreparedListener = onVideoPreparedListener;
    }

    public void setOnVideoPreparingListener(ITVKMediaPlayer.OnVideoPreparingListener onVideoPreparingListener) {
        this.mOnVideoPreparingListener = onVideoPreparingListener;
    }

    public void setOnVideoSizeChangedListener(ITVKMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
    public void onEnterVipTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
    }
}

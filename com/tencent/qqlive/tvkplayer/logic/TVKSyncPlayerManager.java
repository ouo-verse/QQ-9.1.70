package com.tencent.qqlive.tvkplayer.logic;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKReportEventListener;
import com.tencent.qqlive.tvkplayer.api.TVKAudioFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoFrameBuffer;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKAudioFxProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKPostProcessor;
import com.tencent.qqlive.tvkplayer.api.postprocess.ITVKVideoFxProcessor;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.render.ITVKVideoViewBase;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.api.subtitle.ITVKSubtitleRendererController;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.logic.TVKMediaPlayerListeners;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr;
import com.tencent.qqlive.tvkplayer.videotrack.TVKVideoTrackPlayerMgr;
import com.tencent.thumbplayer.api.common.TPProgramInfo;

/* loaded from: classes23.dex */
public class TVKSyncPlayerManager implements ITVKMediaPlayer {
    private static final String TAG = "TVKSyncPlayerManager";
    private boolean mIsMainPlayerBuffering = false;
    private boolean mIsVideoTrackBuffering = false;
    private final TVKMediaPlayerListeners mListeners;
    protected final ITVKMediaPlayer mPlayer;
    protected final TVKPlayerManagerListeners mPlayerListeners;
    private final ITVKVideoTrackPlayerMgr mVideoTrackMgr;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes23.dex */
    public class TVKPlayerManagerListeners implements TVKMediaPlayerListeners.Combine {
        protected TVKPlayerManagerListeners() {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdCustomCommandListener
        public Object onAdCustomCommand(ITVKMediaPlayer iTVKMediaPlayer, String str, Object obj) {
            return TVKSyncPlayerManager.this.mListeners.onAdCustomCommand(TVKSyncPlayerManager.this, str, obj);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdExitFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onAdExitFullScreenClick(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdFullScreenClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onAdFullScreenClick(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdReturnClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onAdReturnClick(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdSkipClick(ITVKMediaPlayer iTVKMediaPlayer, boolean z16, int i3) {
            TVKSyncPlayerManager.this.mListeners.onAdSkipClick(TVKSyncPlayerManager.this, z16, i3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onAdWarnerTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onAdWarnerTipClick(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAudioFrameOutListener
        public void onAudioFrameOut(TVKAudioFrameBuffer tVKAudioFrameBuffer) {
            TVKSyncPlayerManager.this.mListeners.onAudioFrameOut(tVKAudioFrameBuffer);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageFailed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            TVKSyncPlayerManager.this.mListeners.onCaptureImageFailed(TVKSyncPlayerManager.this, i3, i16);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCaptureImageListener
        public void onCaptureImageSucceed(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, Bitmap bitmap) {
            TVKSyncPlayerManager.this.mListeners.onCaptureImageSucceed(TVKSyncPlayerManager.this, i3, i16, i17, bitmap);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
        public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.resetFlag();
            TVKSyncPlayerManager.this.mListeners.onCompletion(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onEnterVipTipClick(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onEnterVipTipClick(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
        public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
            TVKSyncPlayerManager.this.resetFlag();
            return TVKSyncPlayerManager.this.mListeners.onError(TVKSyncPlayerManager.this, tVKError);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
        public void onFinishAd(ITVKMediaPlayer iTVKMediaPlayer, int i3) {
            TVKSyncPlayerManager.this.mListeners.onFinishAd(TVKSyncPlayerManager.this, i3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnGetUserInfoListener
        public TVKUserInfo onGetUserInfo(ITVKMediaPlayer iTVKMediaPlayer) {
            return TVKSyncPlayerManager.this.mListeners.onGetUserInfo(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
        public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
            if (i3 == 21) {
                TVKLogUtil.i(TVKSyncPlayerManager.TAG, "onInfo : main track buffering start");
                TVKSyncPlayerManager.this.mIsMainPlayerBuffering = true;
                if (!TVKSyncPlayerManager.this.mVideoTrackMgr.isVideoTrackEmpty()) {
                    TVKSyncPlayerManager.this.mVideoTrackMgr.pause();
                    TVKLogUtil.i(TVKSyncPlayerManager.TAG, "onInfo : main track buffering start, pause");
                }
                TVKSyncPlayerManager.this.notifyBufferStart();
                return true;
            }
            if (i3 == 22) {
                TVKLogUtil.i(TVKSyncPlayerManager.TAG, "onInfo : main track buffering end");
                TVKSyncPlayerManager.this.mIsMainPlayerBuffering = false;
                if (!TVKSyncPlayerManager.this.mIsVideoTrackBuffering) {
                    if (!TVKSyncPlayerManager.this.mVideoTrackMgr.isVideoTrackEmpty()) {
                        TVKSyncPlayerManager.this.mVideoTrackMgr.start();
                        TVKLogUtil.i(TVKSyncPlayerManager.TAG, "onInfo : main track buffering end, start");
                    }
                    TVKSyncPlayerManager.this.notifyBufferEnd();
                }
                return true;
            }
            if (i3 == 31) {
                TVKSyncPlayerManager.this.mVideoTrackMgr.updatePlayerType(((Integer) obj).intValue());
            }
            return TVKSyncPlayerManager.this.mListeners.onInfo(TVKSyncPlayerManager.this, i3, obj);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewClosed(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onLandingViewClosed(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewFail(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onLandingViewFail(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onLandingViewWillPresent(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onLandingViewWillPresent(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLoopBackChangedListener
        public void onLoopBackChanged(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onLoopBackChanged(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKSyncPlayerManager.this.mListeners.onMidAdCountdown(TVKSyncPlayerManager.this, j3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdEndCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKSyncPlayerManager.this.mListeners.onMidAdEndCountdown(TVKSyncPlayerManager.this, j3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onMidAdFinish(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnMidAdListener
        public void onMidAdStartCountdown(ITVKMediaPlayer iTVKMediaPlayer, long j3, long j16) {
            TVKSyncPlayerManager.this.mListeners.onMidAdStartCountdown(TVKSyncPlayerManager.this, j3, j16);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
        public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
            TVKSyncPlayerManager.this.mListeners.onNetVideoInfo(TVKSyncPlayerManager.this, tVKNetVideoInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnLogoPositionListener
        public void onOriginalLogoPosition(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16, int i17, int i18, boolean z16) {
            TVKSyncPlayerManager.this.mListeners.onOriginalLogoPosition(TVKSyncPlayerManager.this, i3, i16, i17, i18, z16);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPermissionTimeoutListener
        public void onPermissionTimeout(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onPermissionTimeout(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onPostAdFinish(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostrollAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKSyncPlayerManager.this.mListeners.onPostrollAdPrepared(TVKSyncPlayerManager.this, j3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPostRollAdListener
        public void onPostrollAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onPostrollAdPreparing(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdFinish(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onPreAdFinish(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdPrepared(ITVKMediaPlayer iTVKMediaPlayer, long j3) {
            TVKSyncPlayerManager.this.mListeners.onPreAdPrepared(TVKSyncPlayerManager.this, j3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnPreAdListener
        public void onPreAdPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onPreAdPreparing(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onSeekComplete(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnScrollAdListener
        public void onSwitchAd(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj, Object obj2) {
            TVKSyncPlayerManager.this.mListeners.onSwitchAd(TVKSyncPlayerManager.this, i3, obj, obj2);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoFrameOutListener
        public void onVideoFrameOut(TVKVideoFrameBuffer tVKVideoFrameBuffer) {
            TVKSyncPlayerManager.this.mListeners.onVideoFrameOut(tVKVideoFrameBuffer);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onVideoPrepared(TVKSyncPlayerManager.this);
            TVKSyncPlayerManager.this.mVideoTrackMgr.updateMasterPlayer(((ITVKMediaPlayerPrivate) iTVKMediaPlayer).getTVKTPPlayer());
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparingListener
        public void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKSyncPlayerManager.this.mListeners.onVideoPreparing(TVKSyncPlayerManager.this);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            TVKSyncPlayerManager.this.mListeners.onVideoSizeChanged(TVKSyncPlayerManager.this, i3, i16);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnAdClickedListener
        public void onVolumeChange(ITVKMediaPlayer iTVKMediaPlayer, float f16) {
            TVKSyncPlayerManager.this.mListeners.onVolumeChange(TVKSyncPlayerManager.this, f16);
        }
    }

    /* loaded from: classes23.dex */
    private class VideoTrackMgrListener implements ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener {
        VideoTrackMgrListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener
        public boolean onCanBePlay() {
            return !TVKSyncPlayerManager.this.mPlayer.isPaused();
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener
        public void onRequestPause() {
            TVKSyncPlayerManager.this.mIsVideoTrackBuffering = true;
            TVKSyncPlayerManager.this.notifyBufferStart();
            TVKSyncPlayerManager.this.pause();
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener
        public void onRequestResume() {
            TVKSyncPlayerManager.this.mIsVideoTrackBuffering = false;
            if (!TVKSyncPlayerManager.this.mIsMainPlayerBuffering) {
                TVKSyncPlayerManager.this.notifyBufferEnd();
                TVKSyncPlayerManager.this.start();
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayerMgr.VideoTrackMgrOnListener
        public void onTrackOpen() {
            if (TVKSyncPlayerManager.this.mIsVideoTrackBuffering) {
                TVKSyncPlayerManager.this.mIsVideoTrackBuffering = false;
                if (TVKSyncPlayerManager.this.mPlayer.isPaused()) {
                    TVKSyncPlayerManager.this.mPlayer.start();
                }
                TVKSyncPlayerManager.this.notifyBufferEnd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TVKSyncPlayerManager(Context context, ITVKDrawableContainer iTVKDrawableContainer, Looper looper) {
        this.mPlayer = TVKPlayerManagerFactory.getInstance().createPlayerManager(context, iTVKDrawableContainer, looper);
        TVKVideoTrackPlayerMgr tVKVideoTrackPlayerMgr = new TVKVideoTrackPlayerMgr(context, looper);
        this.mVideoTrackMgr = tVKVideoTrackPlayerMgr;
        tVKVideoTrackPlayerMgr.setVideoTrackPlayerMgrListener(new VideoTrackMgrListener());
        this.mPlayerListeners = new TVKPlayerManagerListeners();
        this.mListeners = new TVKMediaPlayerListeners();
        initMediaPlayer();
    }

    private void initMediaPlayer() {
        this.mPlayer.setOnPreAdListener(this.mPlayerListeners);
        this.mPlayer.setOnMidAdListener(this.mPlayerListeners);
        this.mPlayer.setOnPostRollAdListener(this.mPlayerListeners);
        this.mPlayer.setOnAdClickedListener(this.mPlayerListeners);
        this.mPlayer.setOnVideoPreparingListener(this.mPlayerListeners);
        this.mPlayer.setOnVideoPreparedListener(this.mPlayerListeners);
        this.mPlayer.setOnNetVideoInfoListener(this.mPlayerListeners);
        this.mPlayer.setOnCompletionListener(this.mPlayerListeners);
        this.mPlayer.setOnLoopbackChangedListener(this.mPlayerListeners);
        this.mPlayer.setOnPermissionTimeoutListener(this.mPlayerListeners);
        this.mPlayer.setOnSeekCompleteListener(this.mPlayerListeners);
        this.mPlayer.setOnCaptureImageListener(this.mPlayerListeners);
        this.mPlayer.setOnErrorListener(this.mPlayerListeners);
        this.mPlayer.setOnInfoListener(this.mPlayerListeners);
        this.mPlayer.setOnGetUserInfoListener(this.mPlayerListeners);
        this.mPlayer.setOnLogoPositionListener(this.mPlayerListeners);
        this.mPlayer.setOnVideoSizeChangedListener(this.mPlayerListeners);
        this.mPlayer.setOnScrollAdListener(this.mPlayerListeners);
        this.mPlayer.setOnVideoFrameOutListener(this.mPlayerListeners);
        this.mPlayer.setOnAudioFrameOutListener(this.mPlayerListeners);
        this.mPlayer.setOnAdCustomCommandListener(this.mPlayerListeners);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBufferEnd() {
        TVKMediaPlayerListeners tVKMediaPlayerListeners = this.mListeners;
        if (tVKMediaPlayerListeners != null) {
            tVKMediaPlayerListeners.onInfo(this, 22, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyBufferStart() {
        TVKMediaPlayerListeners tVKMediaPlayerListeners = this.mListeners;
        if (tVKMediaPlayerListeners != null) {
            tVKMediaPlayerListeners.onInfo(this, 21, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetFlag() {
        this.mIsMainPlayerBuffering = false;
        this.mIsVideoTrackBuffering = false;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayer.addPlayerEventListener(iTVKPlayerEventListener);
        this.mVideoTrackMgr.addPlayerEventListener(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mPlayer.addReportEventListener(iTVKReportEventListener);
        this.mVideoTrackMgr.addReportEventListener(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addTrack(int i3, String str, String str2) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mPlayer.addTrack(i3, str, str2);
            return;
        }
        throw new IllegalArgumentException("name=" + str + " url=" + str2);
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        this.mPlayer.bindVideoPlayerInfo(obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int captureImageInTime(int i3, int i16) throws IllegalStateException, IllegalArgumentException, IllegalAccessException {
        return this.mPlayer.captureImageInTime(i3, i16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void connectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        this.mPlayer.connectPostProcessor(iTVKPostProcessor);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void deselectTrack(int i3) {
        TVKTrackInfo[] trackInfo = getTrackInfo();
        if (i3 >= 0 && i3 < trackInfo.length) {
            TVKTrackInfo tVKTrackInfo = trackInfo[i3];
            if (tVKTrackInfo.getTrackType() != 1) {
                TVKLogUtil.w(TAG, "api : deselect track , not video track");
                this.mPlayer.deselectTrack(i3);
                return;
            } else {
                this.mVideoTrackMgr.deselectTrack(tVKTrackInfo);
                return;
            }
        }
        TVKLogUtil.w(TAG, "api : deselect track , trackIndex is invalid");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void disconnectPostProcessor(ITVKPostProcessor iTVKPostProcessor) throws IllegalStateException {
        this.mPlayer.disconnectPostProcessor(iTVKPostProcessor);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getAdCurrentPosition() {
        return this.mPlayer.getAdCurrentPosition();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public Object getAdStatus() {
        return this.mPlayer.getAdStatus();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKAudioFxProcessor getAudioFxProcessor() {
        return this.mPlayer.getAudioFxProcessor();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getAvailablePositionMs() {
        return this.mPlayer.getAvailablePositionMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getBufferPercent() {
        return this.mPlayer.getBufferPercent();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TVKNetVideoInfo getCurNetVideoInfo() {
        return this.mPlayer.getCurNetVideoInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getCurrentPosition() {
        long currentPosition = this.mPlayer.getCurrentPosition();
        this.mVideoTrackMgr.updatePlayerPositionMs(currentPosition);
        return currentPosition;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getDownloadSpeed(int i3) {
        return this.mPlayer.getDownloadSpeed(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getDuration() {
        return this.mPlayer.getDuration();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public String getHlsTagInfo(String str) {
        return this.mPlayer.getHlsTagInfo(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean getOutputMute() {
        return this.mPlayer.getOutputMute();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public long getPlayedTime() {
        return this.mPlayer.getPlayedTime();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TPProgramInfo[] getProgramInfo() {
        return this.mPlayer.getProgramInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @Nullable
    public ITVKRichMediaSynchronizer getRichMediaSynchronizer() throws IllegalStateException {
        return this.mPlayer.getRichMediaSynchronizer();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getSelectedTrack(int i3) {
        if (i3 == 1) {
            return this.mVideoTrackMgr.getSelectedTrack(i3);
        }
        return this.mPlayer.getSelectedTrack(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public String getStreamDumpInfo() {
        return this.mPlayer.getStreamDumpInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKSubtitleRendererController getSubtitleRendererController() {
        return this.mPlayer.getSubtitleRendererController();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public TVKTrackInfo[] getTrackInfo() {
        TVKTrackInfo[] trackInfo = this.mPlayer.getTrackInfo();
        TVKTrackInfo[] trackInfo2 = this.mVideoTrackMgr.getTrackInfo();
        if (trackInfo == null) {
            trackInfo = new TVKTrackInfo[0];
        }
        if (trackInfo2 == null) {
            trackInfo2 = new TVKTrackInfo[0];
        }
        TVKTrackInfo[] tVKTrackInfoArr = new TVKTrackInfo[trackInfo.length + trackInfo2.length];
        System.arraycopy(trackInfo, 0, tVKTrackInfoArr, 0, trackInfo.length);
        System.arraycopy(trackInfo2, 0, tVKTrackInfoArr, trackInfo.length, trackInfo2.length);
        return tVKTrackInfoArr;
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKVideoFxProcessor getVideoFxProcessor() {
        return this.mPlayer.getVideoFxProcessor();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoHeight() {
        return this.mPlayer.getVideoHeight();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoRotation() {
        return this.mPlayer.getVideoRotation();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public ITVKVideoViewBase getVideoView() {
        return this.mPlayer.getVideoView();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public int getVideoWidth() {
        return this.mPlayer.getVideoWidth();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isLoopBack() {
        return this.mPlayer.isLoopBack();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isPaused() {
        return this.mPlayer.isPaused();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean isPlaying() {
        return this.mPlayer.isPlaying();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onClickPause() {
        this.mPlayer.onClickPause();
        this.mVideoTrackMgr.onClickPause();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean onKeyEvent(KeyEvent keyEvent) {
        return this.mPlayer.onKeyEvent(keyEvent);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onRealTimeInfoChange(int i3, Object obj) throws IllegalArgumentException {
        this.mPlayer.onRealTimeInfoChange(i3, obj);
        this.mVideoTrackMgr.onRealTimeInfoChange(i3, obj);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onSkipAdResult(boolean z16) {
        this.mPlayer.onSkipAdResult(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean onTouchEvent(View view, MotionEvent motionEvent) {
        return this.mPlayer.onTouchEvent(view, motionEvent);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void openMediaPlayer(Context context, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mPlayer.openMediaPlayer(context, tVKUserInfo, tVKPlayerVideoInfo);
        this.mVideoTrackMgr.updateUserInfo(tVKUserInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void pause() {
        this.mPlayer.pause();
        this.mVideoTrackMgr.pause();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void pauseDownload() {
        this.mPlayer.pauseDownload();
        this.mVideoTrackMgr.pauseDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void refreshPlayer() {
        this.mPlayer.refreshPlayer();
        this.mVideoTrackMgr.refreshPlayer();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void refreshPlayerWithReopen() {
        this.mPlayer.refreshPlayerWithReopen();
        this.mVideoTrackMgr.refreshPlayerWithReopen();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void release() {
        resetFlag();
        this.mVideoTrackMgr.release();
        this.mPlayer.release();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        this.mPlayer.removePlayerEventListener(iTVKPlayerEventListener);
        this.mVideoTrackMgr.removePlayerEventListener(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void removeReportEventListener(ITVKReportEventListener iTVKReportEventListener) {
        this.mPlayer.removeReportEventListener(iTVKReportEventListener);
        this.mVideoTrackMgr.removeReportEventListener(iTVKReportEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void resumeDownload() {
        this.mPlayer.resumeDownload();
        this.mVideoTrackMgr.resumeDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void saveReport() {
        this.mPlayer.saveReport();
        this.mVideoTrackMgr.saveReport();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekForLive(long j3) {
        this.mPlayer.seekForLive(j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekTo(int i3) {
        this.mPlayer.seekTo(i3);
        this.mVideoTrackMgr.seekTo(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekToAccuratePos(int i3) {
        this.mPlayer.seekToAccuratePos(i3);
        this.mVideoTrackMgr.seekToAccuratePos(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void seekToAccuratePosFast(int i3) {
        this.mPlayer.seekToAccuratePosFast(i3);
        this.mVideoTrackMgr.seekToAccuratePos(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void selectProgram(int i3, long j3) {
        this.mPlayer.selectProgram(i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void selectTrack(int i3) {
        TVKTrackInfo[] trackInfo = getTrackInfo();
        if (i3 >= 0 && i3 < trackInfo.length) {
            TVKTrackInfo tVKTrackInfo = trackInfo[i3];
            if (tVKTrackInfo.getTrackType() != 1) {
                TVKLogUtil.w(TAG, "api : select track , not video track");
                this.mPlayer.selectTrack(i3);
                return;
            } else {
                this.mVideoTrackMgr.selectTrack(tVKTrackInfo);
                getCurrentPosition();
                return;
            }
        }
        TVKLogUtil.w(TAG, "api : select track , trackIndex is invalid");
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setAlignment(int i3) {
        this.mPlayer.setAlignment(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setAudioGainRatio(float f16) {
        this.mPlayer.setAudioGainRatio(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @RequiresApi(api = 24)
    public void setDisplayOffset(float f16, float f17) {
        this.mPlayer.setDisplayOffset(f16, f17);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setDisplayScale(float f16) {
        this.mPlayer.setDisplayScale(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setLoopback(boolean z16) {
        this.mPlayer.setLoopback(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setNextLoopVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) {
        this.mPlayer.setNextLoopVideoInfo(tVKPlayerVideoInfo, str);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setNextPlayerVideoInfo(TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        this.mPlayer.setNextPlayerVideoInfo(tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAdClickedListener(ITVKMediaPlayer.OnAdClickedListener onAdClickedListener) {
        this.mListeners.setOnAdClickedListener(onAdClickedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAdCustomCommandListener(ITVKMediaPlayer.OnAdCustomCommandListener onAdCustomCommandListener) {
        this.mListeners.setOnAdCustomCommandListener(onAdCustomCommandListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnAudioFrameOutListener(ITVKMediaPlayer.OnAudioFrameOutListener onAudioFrameOutListener) {
        this.mListeners.setOnAudioPcmDataListener(onAudioFrameOutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnCaptureImageListener(ITVKMediaPlayer.OnCaptureImageListener onCaptureImageListener) {
        this.mListeners.setOnCaptureImageListener(onCaptureImageListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnCompletionListener(ITVKMediaPlayer.OnCompletionListener onCompletionListener) {
        this.mListeners.setOnCompletionListener(onCompletionListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnErrorListener(ITVKMediaPlayer.OnErrorListener onErrorListener) {
        this.mListeners.setOnErrorListener(onErrorListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnGetUserInfoListener(ITVKMediaPlayer.OnGetUserInfoListener onGetUserInfoListener) {
        this.mListeners.setOnGetUserInfoListener(onGetUserInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnInfoListener(ITVKMediaPlayer.OnInfoListener onInfoListener) {
        this.mListeners.setOnInfoListener(onInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnLogoPositionListener(ITVKMediaPlayer.OnLogoPositionListener onLogoPositionListener) {
        this.mListeners.setOnLogoPositionListener(onLogoPositionListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnLoopbackChangedListener(ITVKMediaPlayer.OnLoopBackChangedListener onLoopBackChangedListener) {
        this.mListeners.setOnLoopBackChangedListener(onLoopBackChangedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnMidAdListener(ITVKMediaPlayer.OnMidAdListener onMidAdListener) {
        this.mListeners.setOnMidAdListener(onMidAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnNetVideoInfoListener(ITVKMediaPlayer.OnNetVideoInfoListener onNetVideoInfoListener) {
        this.mListeners.setOnNetVideoInfoListener(onNetVideoInfoListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPermissionTimeoutListener(ITVKMediaPlayer.OnPermissionTimeoutListener onPermissionTimeoutListener) {
        this.mListeners.setOnPermissionTimeoutListener(onPermissionTimeoutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPostRollAdListener(ITVKMediaPlayer.OnPostRollAdListener onPostRollAdListener) {
        this.mListeners.setOnPostRollAdListener(onPostRollAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnPreAdListener(ITVKMediaPlayer.OnPreAdListener onPreAdListener) {
        this.mListeners.setOnPreAdListener(onPreAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnScrollAdListener(ITVKMediaPlayer.OnScrollAdListener onScrollAdListener) {
        this.mListeners.setOnScrollAdListener(onScrollAdListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnSeekCompleteListener(ITVKMediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mListeners.setOnSeekCompleteListener(onSeekCompleteListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoFrameOutListener(ITVKMediaPlayer.OnVideoFrameOutListener onVideoFrameOutListener) {
        this.mListeners.setOnVideoOutputFrameListener(onVideoFrameOutListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoPreparedListener(ITVKMediaPlayer.OnVideoPreparedListener onVideoPreparedListener) {
        this.mListeners.setOnVideoPreparedListener(onVideoPreparedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoPreparingListener(ITVKMediaPlayer.OnVideoPreparingListener onVideoPreparingListener) {
        this.mListeners.setOnVideoPreparingListener(onVideoPreparingListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setOnVideoSizeChangedListener(ITVKMediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mListeners.setOnVideoSizeChangedListener(onVideoSizeChangedListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public boolean setOutputMute(boolean z16) {
        return this.mPlayer.setOutputMute(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setPlaySpeedRatio(float f16) {
        this.mPlayer.setPlaySpeedRatio(f16);
        this.mVideoTrackMgr.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setSurface(Surface surface) {
        this.mPlayer.setSurface(surface);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setXYaxis(int i3) {
        this.mPlayer.setXYaxis(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void skipAd() {
        this.mPlayer.skipAd();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void start() {
        this.mPlayer.start();
        this.mVideoTrackMgr.start();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void stop() {
        this.mPlayer.stop();
        this.mVideoTrackMgr.stop();
        resetFlag();
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException {
        this.mPlayer.switchDefinition(str);
        this.mVideoTrackMgr.switchDefinition(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void switchDefinitionWithReopen(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        this.mPlayer.switchDefinitionWithReopen(tVKUserInfo, tVKPlayerVideoInfo);
        this.mVideoTrackMgr.switchDefinitionWithReopen(tVKUserInfo, tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updatePlayerVideoView(ITVKDrawableContainer iTVKDrawableContainer) {
        this.mPlayer.updatePlayerVideoView(iTVKDrawableContainer);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updateReportParam(TVKProperties tVKProperties) {
        this.mPlayer.updateReportParam(tVKProperties);
        this.mVideoTrackMgr.updateReportParam(tVKProperties);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updateUserInfo(TVKUserInfo tVKUserInfo) {
        this.mPlayer.updateUserInfo(tVKUserInfo);
        this.mVideoTrackMgr.updateUserInfo(tVKUserInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void updateVrReportParam(TVKProperties tVKProperties) {
        this.mPlayer.updateVrReportParam(tVKProperties);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    @RequiresApi(api = 24)
    public void setDisplayScale(float f16, float f17, float f18) {
        this.mPlayer.setDisplayScale(f16, f17, f18);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        this.mPlayer.setLoopback(z16, j3, j16);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void onClickPause(ViewGroup viewGroup) {
        this.mPlayer.onClickPause(viewGroup);
        this.mVideoTrackMgr.onClickPause(viewGroup);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        this.mPlayer.switchDefinition(tVKUserInfo, tVKPlayerVideoInfo);
        this.mVideoTrackMgr.switchDefinition(tVKUserInfo, tVKPlayerVideoInfo);
    }

    @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer
    public void addTrack(int i3, String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalArgumentException {
        this.mPlayer.addTrack(i3, str, tVKPlayerVideoInfo);
        this.mVideoTrackMgr.addTrack(i3, str, tVKPlayerVideoInfo);
    }
}

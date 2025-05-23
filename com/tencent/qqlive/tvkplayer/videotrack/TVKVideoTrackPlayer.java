package com.tencent.qqlive.tvkplayer.videotrack;

import android.content.Context;
import android.os.Looper;
import com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer;
import com.tencent.qqlive.tvkplayer.api.ITVKPlayerEventListener;
import com.tencent.qqlive.tvkplayer.api.ITVKVideoTrackListener;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKProperties;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.render.ITVKDrawableContainer;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.logic.ITVKMediaPlayerPrivate;
import com.tencent.qqlive.tvkplayer.logic.TVKPlayerManagerFactory;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer;
import com.tencent.thumbplayer.api.connection.ITPPlayerConnection;
import com.tencent.thumbplayer.api.connection.ITPPlayerConnectionNode;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionFactory;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;

/* loaded from: classes23.dex */
public class TVKVideoTrackPlayer implements ITVKVideoTrackPlayer {
    private static final String TAG = "TVKVideoTrackPlayer";
    private Context mContext;
    private int mCurState;
    private ITVKTPPlayer mMasterPlayer;
    private InnerPlayerListener mMediaPlayerListener;
    private ITPPlayerConnection mPlayerConnection;
    private TVKPlayerVideoInfo mPlayerVideoInfo;
    private TVKVideoTrackImpl mTrackInfo;
    private ITVKVideoTrackListener mTrackInfoListener;
    private ITVKMediaPlayer mTrackPlayer;
    private ITVKVideoTrackPlayer.VideoTrackPlayerListener mTrackPlayerListener;
    private TVKUserInfo mUserInfo;

    /* loaded from: classes23.dex */
    public class InnerPlayerListener implements ITVKMediaPlayer.OnNetVideoInfoListener, ITVKMediaPlayer.OnCompletionListener, ITVKMediaPlayer.OnErrorListener, ITVKMediaPlayer.OnInfoListener, ITVKMediaPlayer.OnVideoPreparedListener, ITVKMediaPlayer.OnVideoSizeChangedListener, ITVKMediaPlayer.OnSeekCompleteListener, ITVKMediaPlayer.OnVideoPreparingListener {
        public InnerPlayerListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnCompletionListener
        public void onCompletion(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onCompletion");
            TVKVideoTrackPlayer.this.changeState(7);
            TVKVideoTrackPlayer.this.notifyOnShowingEnd();
            TVKVideoTrackPlayer.this.deactivateAndReleaseConnection();
            if (TVKVideoTrackPlayer.this.mTrackPlayerListener != null) {
                TVKVideoTrackPlayer.this.mTrackPlayerListener.onCompletion(TVKVideoTrackPlayer.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnErrorListener
        public boolean onError(ITVKMediaPlayer iTVKMediaPlayer, TVKError tVKError) {
            TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onError");
            TVKVideoTrackPlayer.this.changeState(9);
            TVKVideoTrackPlayer.this.notifyOnError(tVKError);
            TVKVideoTrackPlayer.this.deactivateAndReleaseConnection();
            if (TVKVideoTrackPlayer.this.mTrackPlayerListener != null) {
                TVKVideoTrackPlayer.this.mTrackPlayerListener.onError(TVKVideoTrackPlayer.this, tVKError);
                return false;
            }
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnInfoListener
        public boolean onInfo(ITVKMediaPlayer iTVKMediaPlayer, int i3, Object obj) {
            if (i3 == 21) {
                TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onStartBuffering");
                if (TVKVideoTrackPlayer.this.mTrackPlayerListener != null) {
                    TVKVideoTrackPlayer.this.mTrackPlayerListener.onStartBuffering(TVKVideoTrackPlayer.this);
                    return false;
                }
                return false;
            }
            if (i3 == 22) {
                TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onEndBuffering");
                if (TVKVideoTrackPlayer.this.mTrackPlayerListener != null) {
                    TVKVideoTrackPlayer.this.mTrackPlayerListener.onEndBuffering(TVKVideoTrackPlayer.this);
                    return false;
                }
                return false;
            }
            if (i3 == 62) {
                TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onVideoTrackShowingStart");
                TVKVideoTrackPlayer.this.notifyOnShowingStart();
                return false;
            }
            return false;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnNetVideoInfoListener
        public void onNetVideoInfo(ITVKMediaPlayer iTVKMediaPlayer, TVKNetVideoInfo tVKNetVideoInfo) {
            TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onNetVideoInfo");
            TVKVideoTrackPlayer.this.notifyOnVideoTrackNetInfo(tVKNetVideoInfo);
            if (TVKVideoTrackPlayer.this.mTrackPlayerListener != null) {
                TVKVideoTrackPlayer.this.mTrackPlayerListener.onNetVideoInfo(TVKVideoTrackPlayer.this, tVKNetVideoInfo);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onSeekComplete");
            if (TVKVideoTrackPlayer.this.mTrackPlayerListener != null) {
                TVKVideoTrackPlayer.this.mTrackPlayerListener.onSeekComplete(TVKVideoTrackPlayer.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparedListener
        public void onVideoPrepared(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onVideoPrepared");
            TVKVideoTrackPlayer.this.changeState(4);
            if (TVKVideoTrackPlayer.this.mTrackPlayer instanceof ITVKMediaPlayerPrivate) {
                long j3 = 0;
                if (TVKVideoTrackPlayer.this.getVideoTrackInfo().getPlayDurationMs() > 0) {
                    j3 = (TVKVideoTrackPlayer.this.mTrackPlayer.getDuration() - TVKVideoTrackPlayer.this.getVideoTrackInfo().getPlayDurationMs()) - TVKVideoTrackPlayer.this.getVideoTrackInfo().getVideoTrackStartPositionMs();
                }
                ((ITVKMediaPlayerPrivate) TVKVideoTrackPlayer.this.mTrackPlayer).addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_SKIP_END_TIME_MS, j3));
                ITPPlayerConnectionNode createConnectionNode = TPPlayerConnectionFactory.createConnectionNode(TVKVideoTrackPlayer.this.mMasterPlayer.getTPPlayer());
                ITPPlayerConnectionNode createConnectionNode2 = TPPlayerConnectionFactory.createConnectionNode(((ITVKMediaPlayerPrivate) TVKVideoTrackPlayer.this.mTrackPlayer).getTVKTPPlayer().getTPPlayer());
                createConnectionNode2.setConfig(0, TVKVideoTrackPlayer.this.mTrackInfo.getInsertTimeMs() - TVKVideoTrackPlayer.this.getVideoTrackInfo().getVideoTrackStartPositionMs());
                try {
                    TVKVideoTrackPlayer.this.mPlayerConnection = TPPlayerConnectionFactory.createConnection(createConnectionNode, createConnectionNode2);
                } catch (TPLoadLibraryException e16) {
                    TVKLogUtil.e(TVKVideoTrackPlayer.TAG, "TPPlayerConnectionFactory createConnection TPLoadLibraryException:" + e16);
                } catch (UnsupportedOperationException e17) {
                    TVKLogUtil.e(TVKVideoTrackPlayer.TAG, "TPPlayerConnectionFactory createConnection UnsupportedOperationException:" + e17);
                }
                TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "connect master player and track(sub) player, connection=" + TVKVideoTrackPlayer.this.mPlayerConnection);
                TVKVideoTrackPlayer.this.activeConnection();
            }
            if (TVKVideoTrackPlayer.this.mTrackPlayerListener != null) {
                TVKVideoTrackPlayer.this.mTrackPlayerListener.onVideoPrepared(TVKVideoTrackPlayer.this);
            }
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoPreparingListener
        public void onVideoPreparing(ITVKMediaPlayer iTVKMediaPlayer) {
            TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onVideoPreparing");
            TVKVideoTrackPlayer.this.changeState(3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.ITVKMediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(ITVKMediaPlayer iTVKMediaPlayer, int i3, int i16) {
            TVKLogUtil.i(TVKVideoTrackPlayer.TAG, "player callback : onVideoSizeChanged");
            TVKVideoTrackPlayer.this.notifyOnVideoSizeChange(i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes23.dex */
    public class TVKVideoTrackImpl extends TVKVideoTrackInfo {
        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public long getInsertTimeMs() {
            return TVKUtils.optLong(this.playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_VIDEO_TRACK_INSERT_POSITION_MS, ""), 0L);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public long getPlayDurationMs() {
            return TVKUtils.optLong(this.playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_VIDEO_TRACK_PLAY_DURATION_MS, ""), 0L);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public long getVideoTrackCurrentPositionMs() {
            return TVKVideoTrackPlayer.this.mTrackPlayer.getCurrentPosition();
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public long getVideoTrackDurationMs() {
            return TVKVideoTrackPlayer.this.mTrackPlayer.getDuration();
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public int getVideoTrackHeight() {
            return TVKVideoTrackPlayer.this.mTrackPlayer.getVideoHeight();
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public TVKNetVideoInfo getVideoTrackNetVideoInfo() {
            return TVKVideoTrackPlayer.this.mTrackPlayer.getCurNetVideoInfo();
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public long getVideoTrackStartPositionMs() {
            return TVKUtils.optLong(this.playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_VIDEO_TRACK_START_POSITION_MS, ""), 0L);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public int getVideoTrackWidth() {
            return TVKVideoTrackPlayer.this.mTrackPlayer.getVideoWidth();
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public void setVideoScaleParam(float f16) {
            TVKVideoTrackPlayer.this.mTrackPlayer.setDisplayScale(f16);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public void setVideoTrackListener(ITVKVideoTrackListener iTVKVideoTrackListener) {
            TVKVideoTrackPlayer.this.mTrackInfoListener = iTVKVideoTrackListener;
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public void setXYaxis(int i3) {
            TVKVideoTrackPlayer.this.mTrackPlayer.setXYaxis(i3);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public void updateUserInfo(TVKUserInfo tVKUserInfo) {
            TVKVideoTrackPlayer.this.mTrackPlayer.updateUserInfo(tVKUserInfo);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public void updateVideoView(ITVKDrawableContainer iTVKDrawableContainer) {
            TVKVideoTrackPlayer.this.mTrackPlayer.updatePlayerVideoView(iTVKDrawableContainer);
        }

        @Override // com.tencent.qqlive.tvkplayer.api.TVKVideoTrackInfo
        public boolean videoTrackEnablePreload() {
            if (this.playerVideoInfo.getConfigMap().containsKey(TVKPlayerVideoInfo.PLAYER_CFG_KEY_VIDEO_TRACK_ENABLE_PRELOAD) && this.playerVideoInfo.getConfigMapValue(TVKPlayerVideoInfo.PLAYER_CFG_KEY_VIDEO_TRACK_ENABLE_PRELOAD, "").equalsIgnoreCase("true")) {
                return true;
            }
            return false;
        }

        TVKVideoTrackImpl(String str, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
            super(str, tVKPlayerVideoInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TVKVideoTrackPlayer(Context context, String str, TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, ITVKTPPlayer iTVKTPPlayer, Looper looper) {
        TVKLogUtil.i(TAG, "api call : new TVKVideoTrackPlayer");
        changeState(1);
        this.mContext = context;
        this.mUserInfo = tVKUserInfo;
        try {
            this.mPlayerVideoInfo = tVKPlayerVideoInfo.m239clone();
        } catch (CloneNotSupportedException e16) {
            TVKLogUtil.e(TAG, e16, "check video info implementation");
            this.mPlayerVideoInfo = new TVKPlayerVideoInfo(TVKAssetFactory.createUrlAsset(""));
        }
        this.mMasterPlayer = iTVKTPPlayer;
        this.mTrackInfo = new TVKVideoTrackImpl(str, tVKPlayerVideoInfo);
        TVKLogUtil.i(TAG, "video track pass param : insetTimeMs : " + this.mTrackInfo.getInsertTimeMs());
        TVKLogUtil.i(TAG, "video track pass param : startPositionMs : " + this.mTrackInfo.getVideoTrackStartPositionMs());
        TVKLogUtil.i(TAG, "video track pass param : playDurationMs : " + this.mTrackInfo.getPlayDurationMs());
        TVKLogUtil.i(TAG, "video track pass param : enablePreload : " + this.mTrackInfo.videoTrackEnablePreload());
        this.mTrackPlayer = TVKPlayerManagerFactory.getInstance().createPlayerManager(context, null, looper);
        InnerPlayerListener innerPlayerListener = new InnerPlayerListener();
        this.mMediaPlayerListener = innerPlayerListener;
        this.mTrackPlayer.setOnCompletionListener(innerPlayerListener);
        this.mTrackPlayer.setOnErrorListener(this.mMediaPlayerListener);
        this.mTrackPlayer.setOnVideoPreparedListener(this.mMediaPlayerListener);
        this.mTrackPlayer.setOnNetVideoInfoListener(this.mMediaPlayerListener);
        this.mTrackPlayer.setOnVideoSizeChangedListener(this.mMediaPlayerListener);
        this.mTrackPlayer.setOnInfoListener(this.mMediaPlayerListener);
        this.mTrackPlayer.setOutputMute(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deactivateAndReleaseConnection() {
        try {
            this.mPlayerConnection.deactivateConnection();
            this.mPlayerConnection.release();
            TVKLogUtil.i(TAG, "deactivate and release Connection");
        } catch (UnsupportedOperationException e16) {
            TVKLogUtil.e(TAG, "TPPlayerConnectionMgr deactivateConnection UnsupportedOperationException " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnError(TVKError tVKError) {
        ITVKVideoTrackListener iTVKVideoTrackListener = this.mTrackInfoListener;
        if (iTVKVideoTrackListener != null) {
            iTVKVideoTrackListener.onVideoTrackError(this.mTrackInfo, tVKError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnShowingEnd() {
        ITVKVideoTrackListener iTVKVideoTrackListener = this.mTrackInfoListener;
        if (iTVKVideoTrackListener != null) {
            iTVKVideoTrackListener.onVideoTrackShowingEnd(this.mTrackInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnShowingStart() {
        ITVKVideoTrackListener iTVKVideoTrackListener = this.mTrackInfoListener;
        if (iTVKVideoTrackListener != null) {
            iTVKVideoTrackListener.onVideoTrackShowingStart(this.mTrackInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnVideoSizeChange(int i3, int i16) {
        ITVKVideoTrackListener iTVKVideoTrackListener = this.mTrackInfoListener;
        if (iTVKVideoTrackListener != null) {
            iTVKVideoTrackListener.onVideoTrackSizeChange(this.mTrackInfo, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyOnVideoTrackNetInfo(TVKNetVideoInfo tVKNetVideoInfo) {
        ITVKVideoTrackListener iTVKVideoTrackListener = this.mTrackInfoListener;
        if (iTVKVideoTrackListener != null) {
            iTVKVideoTrackListener.onVideoTrackNetInfo(this.mTrackInfo, tVKNetVideoInfo);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void activeConnection() {
        ITPPlayerConnection iTPPlayerConnection = this.mPlayerConnection;
        if (iTPPlayerConnection != null) {
            try {
                iTPPlayerConnection.activateConnection();
                TVKLogUtil.i(TAG, "activeConnection");
            } catch (UnsupportedOperationException e16) {
                TVKLogUtil.e(TAG, "TPPlayerConnectionMgr activeConnection UnsupportedOperationException " + e16);
            }
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void addPlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        TVKLogUtil.i(TAG, "api call : addPlayerEventListener");
        this.mTrackPlayer.addPlayerEventListener(iTVKPlayerEventListener);
    }

    public synchronized void changeState(int i3) {
        if (this.mCurState != i3) {
            this.mCurState = i3;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void deSelect() {
        changeState(1);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public TVKVideoTrackInfo getVideoTrackInfo() {
        return this.mTrackInfo;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public boolean isSelected() {
        int i3 = this.mCurState;
        if (i3 > 1 && i3 != 9) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void openMediaPlayer(long j3, long j16) {
        TVKLogUtil.i(TAG, "api call : openMediaPlayer");
        int i3 = this.mCurState;
        if (i3 == 1 || i3 == 2 || i3 == 8 || i3 == 7 || i3 == 9) {
            if (this.mPlayerVideoInfo.getAsset() == null) {
                TVKLogUtil.w(TAG, "openMediaPlayer failed, asset is null");
                return;
            }
            TVKLogUtil.i(TAG, "api call : openMediaPlayer asset=" + this.mPlayerVideoInfo.getAsset() + ", startPositionMilsec=" + j3 + ", skipEndMilsec=" + j16);
            long j17 = j3 + ((long) TVKMediaPlayerConfig.PlayerConfig.sync_player_loss_time);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("startPositionMilsec=");
            sb5.append(j17);
            sb5.append(", skipEndMilsec=");
            sb5.append(j16);
            TVKLogUtil.i(TAG, sb5.toString());
            ITVKMediaPlayer iTVKMediaPlayer = this.mTrackPlayer;
            if (iTVKMediaPlayer instanceof ITVKMediaPlayerPrivate) {
                ((ITVKMediaPlayerPrivate) iTVKMediaPlayer).addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_START_PLAYING_TIME_ACCURATE_SEEK, TVKMediaPlayerConfig.PlayerConfig.sync_enable_accurate_startpos));
            }
            this.mPlayerVideoInfo.setSkipStartPositionMs(j17);
            this.mPlayerVideoInfo.setSkipEndPositionMs(j16);
            this.mPlayerVideoInfo.setDefinition("auto");
            this.mPlayerVideoInfo.addConfigMap("ad_close", "true");
            this.mPlayerVideoInfo.addConfigMap("player_forcetype", String.valueOf(2));
            this.mTrackPlayer.openMediaPlayer(this.mContext, this.mUserInfo, this.mPlayerVideoInfo);
            changeState(3);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void pause() {
        TVKLogUtil.i(TAG, "api call : pause");
        if (this.mCurState == 5) {
            changeState(6);
            this.mTrackPlayer.pause();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void pauseDownload() {
        TVKLogUtil.i(TAG, "api call : pauseDownload");
        this.mTrackPlayer.pauseDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void release() {
        TVKLogUtil.i(TAG, "api call : release");
        this.mTrackPlayer.release();
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void removePlayerEventListener(ITVKPlayerEventListener iTVKPlayerEventListener) {
        TVKLogUtil.i(TAG, "api call : removePlayerEventListener");
        this.mTrackPlayer.removePlayerEventListener(iTVKPlayerEventListener);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void resumeDownload() {
        TVKLogUtil.i(TAG, "api call : resumeDownload");
        this.mTrackPlayer.resumeDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void saveReport() {
        TVKLogUtil.i(TAG, "api call : saveReport");
        this.mTrackPlayer.saveReport();
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void seekTo(int i3) {
        TVKLogUtil.i(TAG, "api call : seekTo");
        this.mTrackPlayer.seekTo(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void seekToAccuratePos(int i3) {
        TVKLogUtil.i(TAG, "api call : seekToAccuratePos");
        this.mTrackPlayer.seekToAccuratePos(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void select() {
        int i3 = this.mCurState;
        if (i3 == 1 || i3 == 9) {
            changeState(2);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void setPlaySpeedRatio(float f16) {
        TVKLogUtil.i(TAG, "api call : setPlaySpeedRatio");
        this.mTrackPlayer.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void setVideoTrackPlayerListener(ITVKVideoTrackPlayer.VideoTrackPlayerListener videoTrackPlayerListener) {
        this.mTrackPlayerListener = videoTrackPlayerListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void start() {
        TVKLogUtil.i(TAG, "api call : start");
        int i3 = this.mCurState;
        if (i3 == 4 || i3 == 6) {
            changeState(5);
            this.mTrackPlayer.start();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public int state() {
        return this.mCurState;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void stop() {
        TVKLogUtil.i(TAG, "api call : stop");
        int i3 = this.mCurState;
        if (i3 != 1 && i3 != 8 && i3 != 7) {
            changeState(8);
            deactivateAndReleaseConnection();
            this.mTrackPlayer.stop();
            notifyOnShowingEnd();
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void switchDefinition(String str) throws IllegalStateException, IllegalArgumentException {
        TVKLogUtil.i(TAG, "api call : switchDefinition");
        this.mTrackPlayer.switchDefinition(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void updateMasterPlayer(ITVKTPPlayer iTVKTPPlayer) {
        this.mMasterPlayer = iTVKTPPlayer;
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void updateReportParam(TVKProperties tVKProperties) {
        TVKLogUtil.i(TAG, "api call : updateReportParam");
        this.mTrackPlayer.updateReportParam(tVKProperties);
    }

    @Override // com.tencent.qqlive.tvkplayer.videotrack.ITVKVideoTrackPlayer
    public void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalStateException, IllegalArgumentException {
        TVKLogUtil.i(TAG, "api call : switchDefinition");
        this.mTrackPlayer.switchDefinition(tVKUserInfo, tVKPlayerVideoInfo);
    }
}

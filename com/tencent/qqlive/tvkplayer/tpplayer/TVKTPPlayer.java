package com.tencent.qqlive.tvkplayer.tpplayer;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.qqlive.tvkplayer.context.TVKContext;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKLogUtil;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer;
import com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayerListener;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKPlayerStrategy;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPMediaAssetRequest;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import com.tencent.thumbplayer.api.player.TPPlayerFactory;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;

/* loaded from: classes23.dex */
public class TVKTPPlayer implements ITVKTPPlayer {
    private static final int MEDIACODEC_INIT_TIMEOUT_MS = 2000;
    private static final String TAG = "TVKTPPlayer";
    private boolean mIsMediaCodecInitializing;
    private ITVKTPPlayerListener mListeners;
    private long mMediaCodecConfigureStartTimeMs;
    private final TPPlayerListeners mTPListeners;
    private final ITPPlayer mTPPlayer;
    private TVKContext mTVKContext;

    /* loaded from: classes23.dex */
    private class SimulatedLiveListener implements ITPSimulatedLiveMediaAsset.ITPSimulatedLiveListener {
        SimulatedLiveListener() {
        }

        @Override // com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset.ITPSimulatedLiveListener
        public void onNextAssetRequired(ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest iTPSimulatedLiveAssetRequest) {
            TVKTPPlayer.this.mListeners.onNextAssetRequired(iTPSimulatedLiveAssetRequest);
        }
    }

    /* loaded from: classes23.dex */
    public class TPPlayerListeners implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoSizeChangedListener, ITPPlayerListener.IOnSubtitleDataOutListener, ITPPlayerListener.IOnVideoFrameOutListener, ITPPlayerListener.IOnAudioFrameOutListener, ITPPlayerListener.IOnDebugTrackingInfoListener, ITPPlayerListener.IOnMediaAssetExpireListener, ITPPlayerListener.IOnSnapshotListener, ITPPlayerListener.IOnGetRemainTimeBeforePlayListener {
        public TPPlayerListeners() {
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioFrameOutListener
        public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            TVKTPPlayer.this.mListeners.onAudioFrameOut(tPAudioFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
            TVKTPPlayer.this.mListeners.onCompletion();
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnDebugTrackingInfoListener
        public void onDebugTrackingInfo(ITPPlayer iTPPlayer, TPDebugTrackingInfo tPDebugTrackingInfo) {
            TVKTPPlayer.this.mListeners.onDebugTrackingInfo(tPDebugTrackingInfo);
            TVKTPPlayer.this.handleOnDebugTrackingInfo(tPDebugTrackingInfo);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            TVKTPPlayer.this.mListeners.onError(tPError);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnGetRemainTimeBeforePlayListener
        public long onGetRemainTimeBeforePlayMs(ITPPlayer iTPPlayer) {
            return TVKTPPlayer.this.mListeners.onGetRemainTimeBeforePlayMs();
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i3, TPOnInfoParam tPOnInfoParam) {
            ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
            TVKTPPlayer.this.mListeners.onInfo(i3, tPOnInfoParam);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnMediaAssetExpireListener
        public void onMediaAssetExpire(ITPPlayer iTPPlayer, ITPMediaAssetRequest iTPMediaAssetRequest) {
            TVKTPPlayer.this.mListeners.onMediaAssetExpire(iTPMediaAssetRequest);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            TVKTPPlayer.this.mListeners.onPrepared();
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
            TVKTPPlayer.this.mListeners.onSeekComplete(j3);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError) {
            TVKTPPlayer.this.mListeners.onSnapshotFailed(j3, tPError);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
            TVKTPPlayer.this.mListeners.onSnapshotSuccess(j3, j16, tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSubtitleDataOutListener
        public void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            TVKTPPlayer.this.mListeners.onSubtitleDataOut(tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoFrameOutListener
        public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
            TVKTPPlayer.this.mListeners.onVideoFrameOut(tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            TVKTPPlayer.this.mListeners.onVideoSizeChanged(i3, i16);
        }
    }

    public TVKTPPlayer(TVKContext tVKContext, Looper looper) throws TPLoadLibraryException, IllegalStateException {
        this(tVKContext, looper, looper, (TPPlayerConstructParams) null);
    }

    private void dealMediaCodecInitTimeoutCount() {
        if (this.mIsMediaCodecInitializing) {
            if (System.currentTimeMillis() - this.mMediaCodecConfigureStartTimeMs > 2000) {
                TVKPlayerStrategy.increaseMediaCodecInitContinuousTimeoutCount();
                TVKLogUtil.i(TAG, "dealMediaCodecInitTimeoutCount:" + TVKPlayerStrategy.getMediaCodecInitContinuousTimeoutCount());
            }
            this.mIsMediaCodecInitializing = false;
            this.mMediaCodecConfigureStartTimeMs = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnDebugTrackingInfo(TPDebugTrackingInfo tPDebugTrackingInfo) {
        if (tPDebugTrackingInfo.getTrackingInfoID() == 11) {
            dealMediaCodecInitTimeoutCount();
            this.mIsMediaCodecInitializing = true;
            this.mMediaCodecConfigureStartTimeMs = tPDebugTrackingInfo.getTimeSince1970Ms();
        } else if (tPDebugTrackingInfo.getTrackingInfoID() == 14) {
            this.mIsMediaCodecInitializing = false;
            this.mMediaCodecConfigureStartTimeMs = 0L;
            TVKPlayerStrategy.resetMediaCodecInitContinuousTimeoutCount();
            TVKLogUtil.i(TAG, "OnDebugTrackingInfo, mediacodec init continuous timeout count: 0");
        }
    }

    private void setListeners() {
        this.mTPPlayer.setOnPreparedListener(this.mTPListeners);
        this.mTPPlayer.setOnCompletionListener(this.mTPListeners);
        this.mTPPlayer.setOnInfoListener(this.mTPListeners);
        this.mTPPlayer.setOnErrorListener(this.mTPListeners);
        this.mTPPlayer.setOnSeekCompleteListener(this.mTPListeners);
        this.mTPPlayer.setOnVideoSizeChangedListener(this.mTPListeners);
        this.mTPPlayer.setOnSubtitleDataOutListener(this.mTPListeners);
        this.mTPPlayer.setOnVideoFrameOutListener(this.mTPListeners);
        this.mTPPlayer.setOnAudioFrameOutListener(this.mTPListeners);
        this.mTPPlayer.setOnDebugTrackingInfoListener(this.mTPListeners);
        this.mTPPlayer.setOnSnapshotListener(this.mTPListeners);
        this.mTPPlayer.setOnMediaAssetExpireListener(this.mTPListeners);
        this.mTPPlayer.setOnGetRemainTimeBeforePlayListener(this.mTPListeners);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException {
        this.mTPPlayer.addAudioTrackSource(iTPMediaAsset, str);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) throws IllegalStateException {
        this.mTPPlayer.addOptionalParam(tPOptionalParam);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException, UnsupportedOperationException {
        this.mTPPlayer.addSubtitleTrackSource(iTPMediaAsset, str);
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public void bindVideoPlayerInfo(Object obj) {
        ITPPlayer iTPPlayer = this.mTPPlayer;
        if (iTPPlayer != null) {
            iTPPlayer.bindVideoPlayerInfo(obj);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void deselectTrackAsync(int i3, long j3) {
        this.mTPPlayer.deselectTrackAsync(i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public long getAvailablePositionMs() {
        return this.mTPPlayer.getAvailablePositionMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public long getCurrentPositionMs() {
        return this.mTPPlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public long getDurationMs() {
        return this.mTPPlayer.getDurationMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public int getHeight() {
        return this.mTPPlayer.getHeight();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public int getPlayerCoreType() {
        return this.mTPPlayer.getPlayerCoreType();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public String getProperty(String str) {
        return this.mTPPlayer.getProperty(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public ITPBusinessReportManager getReportManager() {
        return this.mTPPlayer.getReportManager();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public ITPPlayer getTPPlayer() {
        return this.mTPPlayer;
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    @Nullable
    public TPTrackInfo[] getTrackInfo() {
        return this.mTPPlayer.getTrackInfo();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public int getWidth() {
        return this.mTPPlayer.getWidth();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void pause() throws IllegalStateException {
        this.mTPPlayer.pause();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void pauseDownload() {
        try {
            this.mTPPlayer.pauseDownload();
        } catch (IllegalStateException e16) {
            TVKLogUtil.e(TAG, "pauseDownload has exception:" + e16);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void prepareAsync() throws IllegalStateException, UnsupportedOperationException {
        this.mTPPlayer.prepareAsync();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void release() {
        this.mTPPlayer.release();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void removeTrack(int i3) throws IllegalArgumentException {
        this.mTPPlayer.removeTrack(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void reset() throws IllegalStateException {
        this.mTPPlayer.reset();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void resumeDownload() {
        this.mTPPlayer.resumeDownload();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void seekToAsync(int i3) throws IllegalStateException {
        this.mTPPlayer.seekToAsync(i3);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void selectTrackAsync(int i3, long j3) {
        this.mTPPlayer.selectTrackAsync(i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setAudioMute(boolean z16) {
        this.mTPPlayer.setAudioMute(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setAudioVolume(float f16) {
        this.mTPPlayer.setAudioVolume(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setDataSource(ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException, UnsupportedOperationException {
        TVKContext tVKContext = this.mTVKContext;
        if (tVKContext != null) {
            this.mTPPlayer.setLogTagPrefix(tVKContext.getTag());
        }
        if (iTPMediaAsset instanceof ITPSimulatedLiveMediaAsset) {
            ((ITPSimulatedLiveMediaAsset) iTPMediaAsset).setSimulatedLiveListener(new SimulatedLiveListener());
        }
        this.mTPPlayer.setDataSource(iTPMediaAsset);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setLoopback(boolean z16) {
        this.mTPPlayer.setLoopback(z16);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setPlaySpeedRatio(float f16) {
        this.mTPPlayer.setPlaySpeedRatio(f16);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        this.mTPPlayer.setRichMediaSynchronizer(iTPRichMediaSynchronizer);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setSurface(Surface surface) {
        this.mTPPlayer.setSurface(surface);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setTVKTPPlayerListener(ITVKTPPlayerListener iTVKTPPlayerListener) {
        this.mListeners = iTVKTPPlayerListener;
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException {
        this.mTPPlayer.snapshotAsync(tPSnapshotParams, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void start() throws IllegalStateException {
        this.mTPPlayer.start();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void stop() throws IllegalStateException {
        dealMediaCodecInitTimeoutCount();
        this.mTPPlayer.stop();
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        this.mTPPlayer.switchDataSourceAndSelectTrackAsync(iTPMediaAsset, i3, iArr, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        this.mTPPlayer.switchDataSourceAsync(iTPMediaAsset, j3);
    }

    public TVKTPPlayer(TVKContext tVKContext, Looper looper, @Nullable TPPlayerConstructParams tPPlayerConstructParams) throws TPLoadLibraryException, IllegalStateException {
        this(tVKContext, looper, looper, tPPlayerConstructParams);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void seekToAsync(int i3, long j3) throws IllegalStateException {
        this.mTPPlayer.seekToAsync(i3, j3);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void setLoopback(boolean z16, long j3, long j16) throws IllegalStateException, IllegalArgumentException {
        this.mTPPlayer.setLoopback(z16, j3, j16);
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        this.mTPPlayer.switchDataSourceAsync(iTPMediaAsset, i3, j3);
    }

    public TVKTPPlayer(TVKContext tVKContext, Looper looper, Looper looper2, @Nullable TPPlayerConstructParams tPPlayerConstructParams) throws TPLoadLibraryException, IllegalStateException {
        this(tVKContext.getContext(), looper, looper2, tPPlayerConstructParams);
        this.mTVKContext = tVKContext;
        this.mTPPlayer.setLogTagPrefix(tVKContext.getTag());
    }

    @Override // com.tencent.qqlive.tvkplayer.tpplayer.api.ITVKTPPlayer
    public void seekToAsync(int i3, int i16, long j3) throws IllegalStateException {
        this.mTPPlayer.seekToAsync(i3, i16, j3);
    }

    public TVKTPPlayer(Context context, Looper looper, Looper looper2, @Nullable TPPlayerConstructParams tPPlayerConstructParams) throws TPLoadLibraryException, IllegalStateException {
        this.mIsMediaCodecInitializing = false;
        this.mMediaCodecConfigureStartTimeMs = 0L;
        this.mTPPlayer = TPPlayerFactory.createTPPlayer(context, looper, looper2, tPPlayerConstructParams);
        this.mTPListeners = new TPPlayerListeners();
        setListeners();
    }
}

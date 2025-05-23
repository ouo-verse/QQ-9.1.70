package com.tencent.thumbplayer.impl.selfdev;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.ITPSnapshotor;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPErrorCode;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.TPNativeRetCode;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.utils.TPAudioPassThroughPluginDetector;
import com.tencent.thumbplayer.core.utils.TPHeadsetPluginDetector;
import com.tencent.thumbplayer.core.utils.TPScreenRefreshRateDetector;
import com.tencent.thumbplayer.core.utils.TPSystemInfo;
import com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer;
import com.tencent.thumbplayer.impl.ITPInnerPlayer;
import com.tencent.thumbplayer.impl.ITPInnerPlayerListener;
import com.tencent.thumbplayer.impl.TPInnerPlayerListeners;
import com.tencent.thumbplayer.impl.selfdev.TPSelfDevPlayer;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import com.tencent.thumbplayer.snapshot.TPSelfDevSnapshotor;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes26.dex */
public class TPSelfDevPlayer implements ITPInnerPlayer {
    private final TPContext mCtx;
    private final TPInnerPlayerListeners mInnerPlayerListeners;
    private ITPMediaAsset mMediaAsset;
    private ReadWriteLock mReadWriteLock = new ReentrantReadWriteLock();
    private long mSelfDevPlayerContext;
    private final Map<Integer, Long> mSnapshotTaskIdToOpaque;
    private ITPSnapshotor mSnapshotor;
    private final SwitchThreadListeners mSwitchThreadListeners;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class SwitchThreadListeners implements ITPPlayerListener.IOnPreparedListener, ITPPlayerListener.IOnInfoListener, ITPPlayerListener.IOnErrorListener, ITPPlayerListener.IOnCompletionListener, ITPPlayerListener.IOnDebugTrackingInfoListener, ITPPlayerListener.IOnSeekCompleteListener, ITPPlayerListener.IOnVideoSizeChangedListener, ITPInnerPlayerListener.IOnEventRecordListener, ITPSnapshotor.ITPSnapshotorListener {
        private final Handler mHandler;

        public SwitchThreadListeners(Looper looper) {
            this.mHandler = new Handler(looper);
        }

        private void execute(Runnable runnable) {
            if (this.mHandler.getLooper() == Looper.myLooper()) {
                runnable.run();
            } else {
                this.mHandler.post(runnable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onCompletion$1() {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onCompletion(TPSelfDevPlayer.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDebugTrackingInfo$7(TPDebugTrackingInfo tPDebugTrackingInfo) {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onDebugTrackingInfo(TPSelfDevPlayer.this, tPDebugTrackingInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onDrmInfo$8(TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onDrmInfo(TPSelfDevPlayer.this, tPPlayerDrmParams);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$3(TPError tPError) {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onError(TPSelfDevPlayer.this, tPError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onError$4(int i3, TPError tPError) {
            Long l3 = (Long) TPSelfDevPlayer.this.mSnapshotTaskIdToOpaque.remove(Integer.valueOf(i3));
            if (l3 == null) {
                return;
            }
            TPSelfDevPlayer.this.mInnerPlayerListeners.onSnapshotFailed(TPSelfDevPlayer.this, l3.longValue(), tPError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onInfo$2(int i3, TPOnInfoParam tPOnInfoParam) {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onInfo(TPSelfDevPlayer.this, i3, tPOnInfoParam);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onPrepared$0() {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onPrepared(TPSelfDevPlayer.this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSeekComplete$5(long j3) {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onSeekComplete(TPSelfDevPlayer.this, j3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onSuccess$9(int i3, long j3, TPVideoFrameBuffer tPVideoFrameBuffer) {
            Long l3 = (Long) TPSelfDevPlayer.this.mSnapshotTaskIdToOpaque.remove(Integer.valueOf(i3));
            if (l3 == null) {
                return;
            }
            TPSelfDevPlayer.this.mInnerPlayerListeners.onSnapshotSuccess(TPSelfDevPlayer.this, l3.longValue(), j3, tPVideoFrameBuffer);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onVideoSizeChanged$6(int i3, int i16) {
            TPSelfDevPlayer.this.mInnerPlayerListeners.onVideoSizeChanged(TPSelfDevPlayer.this, i3, i16);
        }

        public void clearAllEvents() {
            this.mHandler.removeCallbacksAndMessages(null);
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.e
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onCompletion$1();
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnDebugTrackingInfoListener
        public void onDebugTrackingInfo(ITPPlayer iTPPlayer, final TPDebugTrackingInfo tPDebugTrackingInfo) {
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.f
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onDebugTrackingInfo$7(tPDebugTrackingInfo);
                }
            });
        }

        @Override // com.tencent.thumbplayer.impl.ITPInnerPlayerListener.IOnEventRecordListener
        public void onDrmInfo(ITPInnerPlayer iTPInnerPlayer, final TPGeneralPlayFlowParams.TPPlayerDrmParams tPPlayerDrmParams) {
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.h
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onDrmInfo$8(tPPlayerDrmParams);
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull final TPError tPError) {
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.c
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onError$3(tPError);
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, final int i3, final TPOnInfoParam tPOnInfoParam) {
            ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.d
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onInfo$2(i3, tPOnInfoParam);
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.j
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onPrepared$0();
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, final long j3) {
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.i
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onSeekComplete$5(j3);
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
        public void onSuccess(final int i3, long j3, final long j16, @NonNull final TPVideoFrameBuffer tPVideoFrameBuffer) {
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.b
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onSuccess$9(i3, j16, tPVideoFrameBuffer);
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, final int i3, final int i16) {
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.a
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onVideoSizeChanged$6(i3, i16);
                }
            });
        }

        @Override // com.tencent.thumbplayer.api.snapshot.ITPSnapshotor.ITPSnapshotorListener
        public void onError(final int i3, long j3, @NonNull final TPError tPError) {
            execute(new Runnable() { // from class: com.tencent.thumbplayer.impl.selfdev.g
                @Override // java.lang.Runnable
                public final void run() {
                    TPSelfDevPlayer.SwitchThreadListeners.this.lambda$onError$4(i3, tPError);
                }
            });
        }
    }

    public TPSelfDevPlayer(TPContext tPContext) throws TPLoadLibraryException {
        int i3;
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            TPHeadsetPluginDetector.init(tPContext.getAppContext());
            TPAudioPassThroughPluginDetector.init(tPContext.getAppContext());
            TPScreenRefreshRateDetector.init(tPContext.getAppContext());
            TPSystemInfo.initAudioBestSettings(tPContext.getAppContext());
            try {
                i3 = native_createPlayer();
            } catch (UnsatisfiedLinkError e16) {
                TPLogUtil.e(tPContext.getLogTag(), "failed to create native player: " + e16.getMessage());
                i3 = TPNativeRetCode.FAILED;
            }
            if (i3 == 0) {
                this.mCtx = tPContext;
                this.mSnapshotTaskIdToOpaque = new HashMap();
                this.mInnerPlayerListeners = new TPInnerPlayerListeners(tPContext.getLogTag());
                this.mSwitchThreadListeners = new SwitchThreadListeners(tPContext.getWorkerLooper());
                setListenersToNative();
                TPLogUtil.i(tPContext.getLogTag(), "TPSelfDevPlayer construct");
                return;
            }
            throw new TPLoadLibraryException("failed to create native player, errorCode:" + i3);
        }
        throw new TPLoadLibraryException("failed to create native player while library not successfully loaded");
    }

    @Nullable
    private boolean createAndInitSnapshotor() {
        if (this.mMediaAsset == null) {
            return false;
        }
        TPSelfDevSnapshotor tPSelfDevSnapshotor = new TPSelfDevSnapshotor();
        this.mSnapshotor = tPSelfDevSnapshotor;
        try {
            tPSelfDevSnapshotor.init(this.mMediaAsset, this.mSwitchThreadListeners);
            return true;
        } catch (TPLoadLibraryException | IllegalArgumentException | IllegalStateException | UnsupportedOperationException e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "init snapshotor failed" + e16.getMessage());
            this.mSnapshotor = null;
            return false;
        }
    }

    private long getSelfDevPlayerContext() {
        this.mReadWriteLock.readLock().lock();
        this.mReadWriteLock.readLock().unlock();
        return this.mSelfDevPlayerContext;
    }

    private native int native_addAudioTrackSource(ITPMediaAsset iTPMediaAsset, String str);

    private native int native_addOptionalParam(TPOptionalParam tPOptionalParam);

    private native int native_addSubtitleTrackSource(ITPMediaAsset iTPMediaAsset, String str);

    private native int native_createPlayer();

    private native int native_deselectTrackAsync(int i3, long j3);

    private native long native_getAvailablePositionMs();

    private native long native_getCurrentPositionMs();

    private native long native_getDemuxerCurrentOriginalPts();

    private native long native_getDemuxerOffsetInFile();

    private native long native_getDurationMs();

    private native TPDynamicStatisticParams native_getDynamicStatisticParams(boolean z16);

    private native TPGeneralPlayFlowParams native_getGeneralPlayFlowParams();

    private native int native_getHeight();

    private native TPProgramInfo[] native_getProgramInfo();

    private native String native_getProperty(String str);

    private native TPTrackInfo[] native_getTrackInfo();

    private native int native_getWidth();

    private native int native_pause();

    private native int native_pauseDownload();

    private native int native_prepareAsync();

    private native int native_release();

    private native int native_removeTrack(int i3);

    private native int native_reset();

    private native int native_resume();

    private native int native_resumeDownload();

    private native int native_seekToAsync(long j3, int i3, long j16);

    private native int native_selectProgramAsync(int i3, long j3);

    private native int native_selectTrackAsync(int i3, long j3);

    private native int native_setAudioMute(boolean z16);

    private native int native_setAudioNormalizeVolumeParams(String str);

    private native int native_setAudioVolume(float f16);

    private native int native_setDataSource(ITPMediaAsset iTPMediaAsset);

    private native int native_setLogTagPrefix(String str);

    private native int native_setLoopback(boolean z16, long j3, long j16);

    private native int native_setOnAudioFrameOutListener(ITPPlayerListener.IOnAudioFrameOutListener iOnAudioFrameOutListener);

    private native int native_setOnAudioProcessFrameOutListener(ITPPlayerListener.IOnAudioProcessFrameOutListener iOnAudioProcessFrameOutListener);

    private native int native_setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener);

    private native int native_setOnDebugTrackingInfoListener(ITPPlayerListener.IOnDebugTrackingInfoListener iOnDebugTrackingInfoListener);

    private native int native_setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener);

    private native int native_setOnEventRecordListener(ITPInnerPlayerListener.IOnEventRecordListener iOnEventRecordListener);

    private native int native_setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener);

    private native int native_setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener);

    private native int native_setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener);

    private native int native_setOnSubtitleDataOutListener(ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener);

    private native int native_setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener);

    private native int native_setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener);

    private native int native_setPlaySpeedRatio(float f16);

    private native int native_setSurface(Surface surface);

    private native int native_start();

    private native int native_stop();

    private native int native_switchDataSourceAndSelectTrackAsync(ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3);

    private native int native_switchDataSourceAsync(ITPMediaAsset iTPMediaAsset, int i3, long j3);

    private void releaseSnapshotorIfNeeded() {
        ITPSnapshotor iTPSnapshotor = this.mSnapshotor;
        if (iTPSnapshotor == null) {
            return;
        }
        iTPSnapshotor.release();
        this.mSnapshotor = null;
        Iterator<Map.Entry<Integer, Long>> it = this.mSnapshotTaskIdToOpaque.entrySet().iterator();
        while (it.hasNext()) {
            this.mInnerPlayerListeners.onSnapshotFailed(this, it.next().getValue().longValue(), new TPError(1001, TPErrorCode.TP_ERROR_CODE_GENERAL_FAILED));
        }
        this.mSnapshotTaskIdToOpaque.clear();
    }

    private void setListenersToNative() {
        try {
            native_setOnVideoFrameOutListener(this.mInnerPlayerListeners);
            native_setOnAudioFrameOutListener(this.mInnerPlayerListeners);
            native_setOnSubtitleDataOutListener(this.mInnerPlayerListeners);
            native_setOnAudioProcessFrameOutListener(this.mInnerPlayerListeners);
            native_setOnPreparedListener(this.mSwitchThreadListeners);
            native_setOnInfoListener(this.mSwitchThreadListeners);
            native_setOnErrorListener(this.mSwitchThreadListeners);
            native_setOnCompletionListener(this.mSwitchThreadListeners);
            native_setOnDebugTrackingInfoListener(this.mSwitchThreadListeners);
            native_setOnSeekCompleteListener(this.mSwitchThreadListeners);
            native_setOnVideoSizeChangedListener(this.mSwitchThreadListeners);
            native_setOnEventRecordListener(this.mSwitchThreadListeners);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set inner listener " + e16.getMessage());
        }
    }

    private void setSelfDevPlayerContext(long j3) {
        this.mReadWriteLock.writeLock().lock();
        this.mSelfDevPlayerContext = j3;
        this.mReadWriteLock.writeLock().unlock();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str) && iTPMediaAsset.isValid() && iTPMediaAsset.getAssetType() == 3) {
            try {
                native_addAudioTrackSource(iTPMediaAsset, str);
                return;
            } catch (UnsatisfiedLinkError e16) {
                TPLogUtil.e(this.mCtx.getLogTag(), "failed to add audio track source: " + e16.getMessage());
                return;
            }
        }
        throw new IllegalArgumentException("addAudioTrackSource, name or asset is invalid");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addOptionalParam(TPOptionalParam<?> tPOptionalParam) throws IllegalStateException {
        try {
            native_addOptionalParam(tPOptionalParam);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to add optional param: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void addPlugin(ITPPluginBase iTPPluginBase) {
        com.tencent.thumbplayer.api.player.a.a(this, iTPPluginBase);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str) && iTPMediaAsset.isValid() && iTPMediaAsset.getAssetType() == 3) {
            try {
                native_addSubtitleTrackSource(iTPMediaAsset, str);
                return;
            } catch (UnsatisfiedLinkError e16) {
                TPLogUtil.e(this.mCtx.getLogTag(), "failed to add subtitle track source: " + e16.getMessage());
                return;
            }
        }
        throw new IllegalArgumentException("addSubtitleTrackSource, name or asset is invalid");
    }

    @Override // com.tencent.thumbplayer.api.dtreport.IDtReport
    public /* synthetic */ void bindVideoPlayerInfo(Object obj) {
        we4.a.a(this, obj);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void deselectTrackAsync(int i3) {
        deselectTrackAsync(i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getAvailablePositionMs() {
        try {
            return native_getAvailablePositionMs();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get available position: " + e16.getMessage());
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getCurrentPositionMs() {
        try {
            return native_getCurrentPositionMs();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get current position: " + e16.getMessage());
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ int getCurrentState() {
        return com.tencent.thumbplayer.impl.a.a(this);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public long getDemuxerCurrentOriginalPtsUs() {
        try {
            return native_getDemuxerCurrentOriginalPts();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get demuxer current original pts: " + e16.getMessage());
            return -1L;
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public long getDemuxerOffsetInFileByte() {
        try {
            return native_getDemuxerOffsetInFile();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get demuxer offset in file: " + e16.getMessage());
            return -1L;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getDurationMs() {
        try {
            return native_getDurationMs();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get duration: " + e16.getMessage());
            return 0L;
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    @Nullable
    public TPDynamicStatisticParams getDynamicStatisticParams(boolean z16) {
        try {
            return native_getDynamicStatisticParams(z16);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get dynamic statistic params: " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    @Nullable
    public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
        try {
            return native_getGeneralPlayFlowParams();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get general play flow params: " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getHeight() {
        try {
            return native_getHeight();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get height: " + e16.getMessage());
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getPlayerCoreType() {
        return 2;
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    public TPProgramInfo[] getProgramInfo() {
        try {
            return native_getProgramInfo();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get program info: " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public String getProperty(String str) throws IllegalStateException {
        try {
            return native_getProperty(str);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get property(" + str + "): " + e16.getMessage());
            return "";
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ ITPReportExtendedController getReportExtendedController() {
        return com.tencent.thumbplayer.impl.a.b(this);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ ITPBusinessReportManager getReportManager() {
        return com.tencent.thumbplayer.impl.a.c(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ TPContext getTPConext() {
        return com.tencent.thumbplayer.api.player.a.b(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    public TPTrackInfo[] getTrackInfo() {
        try {
            return native_getTrackInfo();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get track info: " + e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getWidth() {
        try {
            return native_getWidth();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get width: " + e16.getMessage());
            return 0;
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void pause() throws IllegalStateException {
        try {
            native_pause();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to pause: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void pauseDownload() throws IllegalStateException {
        try {
            native_pauseDownload();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to pause download: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void prepareAsync() throws IllegalStateException {
        try {
            native_prepareAsync();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to prepare async: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void release() {
        this.mInnerPlayerListeners.clear();
        this.mSwitchThreadListeners.clearAllEvents();
        try {
            native_release();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to release: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void removeTrack(int i3) throws IllegalArgumentException {
        int i16;
        try {
            i16 = native_removeTrack(i3);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to remove track: " + e16.getMessage());
            i16 = TPNativeRetCode.FAILED;
        }
        if (i16 == 0) {
            return;
        }
        throw new IllegalArgumentException("failed to remove track, errorCode:" + i16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reset() {
        this.mSwitchThreadListeners.clearAllEvents();
        this.mMediaAsset = null;
        releaseSnapshotorIfNeeded();
        try {
            native_reset();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to reset: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void resumeDownload() {
        try {
            native_resumeDownload();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to resume download: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3) throws IllegalStateException {
        seekToAsync(j3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectProgramAsync(int i3) {
        selectProgramAsync(i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectTrackAsync(int i3) {
        selectTrackAsync(i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioMute(boolean z16) {
        try {
            native_setAudioMute(z16);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set audio mute: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioNormalizeVolumeParams(String str) {
        try {
            native_setAudioNormalizeVolumeParams(str);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set audio normalize volume params: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioVolume(float f16) {
        try {
            native_setAudioVolume(f16);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set audio volume: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
        com.tencent.thumbplayer.api.player.a.c(this, i3, i16, i17, i18, i19);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setDataSource(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException {
        try {
            native_setDataSource(iTPMediaAsset);
            this.mMediaAsset = iTPMediaAsset;
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set data source: " + e16.getMessage());
        }
        ReportThumbPlayer.getInstance().setDataSource(this, iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLogTagPrefix(String str) {
        try {
            native_setLogTagPrefix(str);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set log tag prefix: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16) {
        setLoopback(z16, 0L, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioFrameOutListener(ITPPlayerListener.IOnAudioFrameOutListener iOnAudioFrameOutListener) {
        this.mInnerPlayerListeners.setOnAudioFrameOutListener(iOnAudioFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioProcessFrameOutListener(ITPPlayerListener.IOnAudioProcessFrameOutListener iOnAudioProcessFrameOutListener) {
        this.mInnerPlayerListeners.setOnAudioProcessFrameOutListener(iOnAudioProcessFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        this.mInnerPlayerListeners.setOnCompletionListener(iOnCompletionListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnDebugTrackingInfoListener(ITPPlayerListener.IOnDebugTrackingInfoListener iOnDebugTrackingInfoListener) {
        this.mInnerPlayerListeners.setOnDebugTrackingInfoListener(iOnDebugTrackingInfoListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        this.mInnerPlayerListeners.setOnErrorListener(iOnErrorListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public void setOnEventRecordListener(ITPInnerPlayerListener.IOnEventRecordListener iOnEventRecordListener) {
        this.mInnerPlayerListeners.setOnEventRecordListener(iOnEventRecordListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener) {
        com.tencent.thumbplayer.impl.a.e(this, iOnGetRemainTimeBeforePlayListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        this.mInnerPlayerListeners.setOnInfoListener(iOnInfoListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener) {
        com.tencent.thumbplayer.impl.a.f(this, iOnMediaAssetExpireListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        this.mInnerPlayerListeners.setOnPreparedListener(iOnPreparedListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        this.mInnerPlayerListeners.setOnSeekCompleteListener(iOnSeekCompleteListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSnapshotListener(ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener) {
        this.mInnerPlayerListeners.setOnSnapshotListener(iOnSnapshotListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener) {
        com.tencent.thumbplayer.impl.a.g(this, iOnStateChangedListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
        com.tencent.thumbplayer.impl.a.h(this, iOnStopAsyncCompleteListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSubtitleDataOutListener(ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener) {
        this.mInnerPlayerListeners.setOnSubtitleDataOutListener(iOnSubtitleDataOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        this.mInnerPlayerListeners.setOnVideoFrameOutListener(iOnVideoFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        this.mInnerPlayerListeners.setOnVideoSizeChangedListener(iOnVideoSizeChangedListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setPlaySpeedRatio(float f16) {
        try {
            native_setPlaySpeedRatio(f16);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set play speed ratio: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        com.tencent.thumbplayer.impl.a.i(this, iTPRichMediaSynchronizer);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurface(Surface surface) {
        try {
            native_setSurface(surface);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set surface: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        Surface surface;
        if (surfaceHolder != null && surfaceHolder.getSurface() == null) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to get surface from surfaceHolder");
            return;
        }
        if (surfaceHolder == null) {
            surface = null;
        } else {
            surface = surfaceHolder.getSurface();
        }
        try {
            native_setSurface(surface);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set surface holder: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams) throws IllegalStateException {
        snapshotAsync(tPSnapshotParams, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void start() throws IllegalStateException {
        try {
            native_start();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to start: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void stop() throws IllegalStateException {
        try {
            native_stop();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to stop: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void stopAsync() {
        com.tencent.thumbplayer.impl.a.j(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        try {
            native_switchDataSourceAndSelectTrackAsync(iTPMediaAsset, i3, iArr, j3);
            this.mMediaAsset = iTPMediaAsset;
            releaseSnapshotorIfNeeded();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to switch data source and select track async: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        switchDataSourceAsync(iTPMediaAsset, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void deselectTrackAsync(int i3, long j3) {
        try {
            native_deselectTrackAsync(i3, j3);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to deselect track async: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, long j16) throws IllegalStateException {
        seekToAsync(j3, 0, j16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectProgramAsync(int i3, long j3) {
        try {
            native_selectProgramAsync(i3, j3);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to select program async: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectTrackAsync(int i3, long j3) {
        try {
            native_selectTrackAsync(i3, j3);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to select track async: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        try {
            native_setLoopback(z16, j3, j16);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to set loop back: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException {
        if (this.mSnapshotor == null && !createAndInitSnapshotor()) {
            throw new IllegalStateException("create snapshotor failed");
        }
        try {
            this.mSnapshotTaskIdToOpaque.put(Integer.valueOf(this.mSnapshotor.snapshotAsyncAtPosition(getCurrentPositionMs(), tPSnapshotParams)), Long.valueOf(j3));
        } catch (TPLoadLibraryException | IllegalStateException | UnsupportedOperationException e16) {
            throw new IllegalStateException(e16);
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException, IllegalArgumentException {
        switchDataSourceAsync(iTPMediaAsset, 0, j3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, int i3) throws IllegalStateException {
        seekToAsync(j3, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        switchDataSourceAsync(iTPMediaAsset, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, int i3, long j16) throws IllegalStateException {
        try {
            native_seekToAsync(j3, i3, j16);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to seek: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException {
        try {
            native_switchDataSourceAsync(iTPMediaAsset, i3, j3);
            this.mMediaAsset = iTPMediaAsset;
            releaseSnapshotorIfNeeded();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(this.mCtx.getLogTag(), "failed to switch data source: " + e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setIsActive(boolean z16) {
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public void setPlayRemuxer(ITPPlayRemuxer iTPPlayRemuxer) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reopenPlayer(int i3, boolean z16) {
    }
}

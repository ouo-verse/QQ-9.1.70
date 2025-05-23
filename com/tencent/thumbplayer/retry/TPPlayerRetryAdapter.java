package com.tencent.thumbplayer.retry;

import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.video.playback.ReportThumbPlayer;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPAudioFrameBuffer;
import com.tencent.thumbplayer.api.common.TPDebugTrackingInfo;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPProgramInfo;
import com.tencent.thumbplayer.api.common.TPSubtitleData;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import com.tencent.thumbplayer.api.common.TPVideoFrameBuffer;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import com.tencent.thumbplayer.api.player.ITPPlayer;
import com.tencent.thumbplayer.api.player.ITPPlayerListener;
import com.tencent.thumbplayer.api.player.TPPlayerConstructParams;
import com.tencent.thumbplayer.api.player.a;
import com.tencent.thumbplayer.api.report.v1.ITPBusinessReportManager;
import com.tencent.thumbplayer.api.report.v2.ITPReportExtendedController;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;
import com.tencent.thumbplayer.api.snapshot.TPSnapshotParams;
import com.tencent.thumbplayer.common.TPContext;
import com.tencent.thumbplayer.common.TPDynamicStatisticParams;
import com.tencent.thumbplayer.common.TPErrorCode;
import com.tencent.thumbplayer.common.TPGeneralPlayFlowParams;
import com.tencent.thumbplayer.common.TPPlayerCoreTypeToString;
import com.tencent.thumbplayer.common.TPPlayerStateToString;
import com.tencent.thumbplayer.common.annotation.TPOnInfoIDAttributeUtils;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.datatransport.play.ITPPlayRemuxer;
import com.tencent.thumbplayer.impl.ITPInnerPlayer;
import com.tencent.thumbplayer.impl.ITPInnerPlayerListener;
import com.tencent.thumbplayer.impl.TPInnerPlayerListeners;
import com.tencent.thumbplayer.retry.TPPlayerInputParams;
import com.tencent.thumbplayer.retry.TPPlayerRuntimeParams;
import com.tencent.thumbplayer.tpplayer.plugin.ITPPluginBase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes26.dex */
public class TPPlayerRetryAdapter implements ITPPlayerRetryAdapter {
    private ITPInnerPlayer mPlayer;
    private TPPlayerCoreChooser mPlayerCoreChooser;
    private final TPInnerPlayerListeners mPlayerListeners;
    private final TPRetryPlayerListeners mRetryPlayerListeners;
    private final TPContext mTPContext;
    private Map<Long, Long> mUniqueIDToOpaqueMap = new HashMap();
    private long mUniqueIDCounter = 0;
    private final TPPlayerInputParams mInputParams = new TPPlayerInputParams();
    private final TPPlayerRuntimeParams mRuntimeParams = new TPPlayerRuntimeParams();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes26.dex */
    public class TPRetryPlayerListeners extends TPInnerPlayerListeners {
        public TPRetryPlayerListeners(String str) {
            super(str);
        }

        private boolean handleOnceInfoID(int i3, TPOnInfoParam tPOnInfoParam) {
            if (!TPOnInfoIDAttributeUtils.isOnceInfoID(i3)) {
                return false;
            }
            if (!TPPlayerRetryAdapter.this.mRuntimeParams.isOnceInfoIDNotified(i3)) {
                TPPlayerRetryAdapter.this.mRuntimeParams.addNotifiedOnceInfoID(i3);
                TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, i3, tPOnInfoParam);
                return true;
            }
            return true;
        }

        private boolean handleSelectTrackOrDeselectTrackComplete(int i3, TPOnInfoParam tPOnInfoParam) {
            if (i3 != 10 && i3 != 11 && i3 != 12 && i3 != 13) {
                return false;
            }
            if (tPOnInfoParam == null) {
                TPLogUtil.w(TPPlayerRetryAdapter.this.mTPContext.getLogTag(), "select or deselect track complete, but onInfoParam is null!");
                TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, i3, tPOnInfoParam);
                return true;
            }
            if (TPPlayerRetryAdapter.this.mRuntimeParams.findSelectOrDeselectTrackRecordWithUniqueID(tPOnInfoParam.getLongParam1())) {
                TPPlayerRetryAdapter.this.mRuntimeParams.removeSelectOrDeselectTrackRecord(tPOnInfoParam.getLongParam1());
                TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, i3, new TPOnInfoParam.Builder(tPOnInfoParam).setLongParam(TPPlayerRetryAdapter.this.getOpaqueFromUniqueId(tPOnInfoParam.getLongParam1())).build());
            }
            return true;
        }

        private boolean handleSwitchDataSourceComplete(int i3, TPOnInfoParam tPOnInfoParam) {
            if (i3 != 3) {
                return false;
            }
            if (tPOnInfoParam == null) {
                TPLogUtil.w(TPPlayerRetryAdapter.this.mTPContext.getLogTag(), "switch data source complete, but onInfoParam is null!");
                TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, i3, tPOnInfoParam);
                return true;
            }
            TPPlayerRetryAdapter.this.mRuntimeParams.onSwitchDatasourceComplete(tPOnInfoParam.getLongParam1());
            TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, i3, new TPOnInfoParam.Builder(tPOnInfoParam).setLongParam(TPPlayerRetryAdapter.this.getOpaqueFromUniqueId(tPOnInfoParam.getLongParam1())).build());
            return true;
        }

        private void processRetryOnPlayerPrepared(ITPPlayer iTPPlayer) {
            TPLogUtil.i(TPPlayerRetryAdapter.this.mTPContext.getLogTag(), "retrying, player prepared, process retry on player prepared");
            TPPlayerRetryAdapter.this.recoverInvokeOnRetryFinish(iTPPlayer);
            TPLogUtil.i(TPPlayerRetryAdapter.this.mTPContext.getLogTag(), "retrying, player prepared, recover player state to " + TPPlayerStateToString.getStateName(TPPlayerRetryAdapter.this.mTPContext.getStateQuerier().getCurrentState()));
            if (TPPlayerRetryAdapter.this.mTPContext.getStateQuerier().isInStates(2)) {
                TPPlayerRetryAdapter.this.mPlayerListeners.onPrepared(TPPlayerRetryAdapter.this);
            } else if (TPPlayerRetryAdapter.this.mTPContext.getStateQuerier().isInStates(4)) {
                try {
                    iTPPlayer.start();
                } catch (IllegalStateException e16) {
                    TPLogUtil.e(TPPlayerRetryAdapter.this.mTPContext.getLogTag(), "retrying, player start failed:" + e16);
                    TPPlayerRetryAdapter.this.handleOnError(new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_UNMATCHED_STATE));
                }
            }
            TPPlayerRetryAdapter.this.mRuntimeParams.setRetrying(false);
            TPPlayerRetryAdapter.this.mRuntimeParams.onRetryFinished();
            TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, 201, null);
            TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, 50001, null);
        }

        private void updateRuntimeParamsOnPlayerPrepared(ITPPlayer iTPPlayer) {
            TPPlayerRetryAdapter.this.mRuntimeParams.setDurationMs(iTPPlayer.getDurationMs());
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioFrameOutListener
        public void onAudioFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            TPPlayerRetryAdapter.this.mPlayerListeners.onAudioFrameOut(TPPlayerRetryAdapter.this, tPAudioFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnAudioProcessFrameOutListener
        public TPAudioFrameBuffer onAudioProcessFrameOut(ITPPlayer iTPPlayer, TPAudioFrameBuffer tPAudioFrameBuffer) {
            return TPPlayerRetryAdapter.this.mPlayerListeners.onAudioProcessFrameOut(TPPlayerRetryAdapter.this, tPAudioFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnCompletionListener
        public void onCompletion(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onCompletion(iTPPlayer);
            TPPlayerRetryAdapter.this.mPlayerListeners.onCompletion(TPPlayerRetryAdapter.this);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnDebugTrackingInfoListener
        public void onDebugTrackingInfo(ITPPlayer iTPPlayer, TPDebugTrackingInfo tPDebugTrackingInfo) {
            TPPlayerRetryAdapter.this.mPlayerListeners.onDebugTrackingInfo(TPPlayerRetryAdapter.this, tPDebugTrackingInfo);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnErrorListener
        public void onError(ITPPlayer iTPPlayer, @NonNull TPError tPError) {
            ReportThumbPlayer.getInstance().onError(iTPPlayer, tPError);
            TPLogUtil.e(TPPlayerRetryAdapter.this.mTPContext.getLogTag(), "onError, error: " + tPError);
            TPPlayerRetryAdapter.this.handleOnError(tPError);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnInfoListener
        public void onInfo(ITPPlayer iTPPlayer, int i3, TPOnInfoParam tPOnInfoParam) {
            ReportThumbPlayer.getInstance().onInfo(iTPPlayer, i3, tPOnInfoParam);
            if (handleSwitchDataSourceComplete(i3, tPOnInfoParam) || handleSelectTrackOrDeselectTrackComplete(i3, tPOnInfoParam) || handleOnceInfoID(i3, tPOnInfoParam)) {
                return;
            }
            TPPlayerRetryAdapter.this.mPlayerListeners.onInfo(TPPlayerRetryAdapter.this, i3, tPOnInfoParam);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnPreparedListener
        public void onPrepared(ITPPlayer iTPPlayer) {
            ReportThumbPlayer.getInstance().onPrepared(iTPPlayer);
            updateRuntimeParamsOnPlayerPrepared(iTPPlayer);
            if (TPPlayerRetryAdapter.this.mRuntimeParams.isRetrying()) {
                processRetryOnPlayerPrepared(iTPPlayer);
            } else {
                TPPlayerRetryAdapter.this.mPlayerListeners.onPrepared(TPPlayerRetryAdapter.this);
            }
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSeekCompleteListener
        public void onSeekComplete(ITPPlayer iTPPlayer, long j3) {
            TPPlayerRetryAdapter.this.mRuntimeParams.onSeekComplete(j3);
            TPPlayerRetryAdapter.this.mPlayerListeners.onSeekComplete(TPPlayerRetryAdapter.this, TPPlayerRetryAdapter.this.getOpaqueFromUniqueId(j3));
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotFailed(ITPPlayer iTPPlayer, long j3, @NonNull TPError tPError) {
            TPPlayerRetryAdapter.this.mPlayerListeners.onSnapshotFailed(TPPlayerRetryAdapter.this, j3, tPError);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSnapshotListener
        public void onSnapshotSuccess(ITPPlayer iTPPlayer, long j3, long j16, @NonNull TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPPlayerRetryAdapter.this.mPlayerListeners.onSnapshotSuccess(TPPlayerRetryAdapter.this, j3, j16, tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnSubtitleDataOutListener
        public void onSubtitleDataOut(ITPPlayer iTPPlayer, TPSubtitleData tPSubtitleData) {
            TPPlayerRetryAdapter.this.mPlayerListeners.onSubtitleDataOut(TPPlayerRetryAdapter.this, tPSubtitleData);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoFrameOutListener
        public void onVideoFrameOut(ITPPlayer iTPPlayer, TPVideoFrameBuffer tPVideoFrameBuffer) {
            TPPlayerRetryAdapter.this.mPlayerListeners.onVideoFrameOut(TPPlayerRetryAdapter.this, tPVideoFrameBuffer);
        }

        @Override // com.tencent.thumbplayer.tpplayer.TPPlayerListeners, com.tencent.thumbplayer.api.player.ITPPlayerListener.IOnVideoSizeChangedListener
        public void onVideoSizeChanged(ITPPlayer iTPPlayer, int i3, int i16) {
            if (TPPlayerRetryAdapter.this.mRuntimeParams.getWidth() == i3 && TPPlayerRetryAdapter.this.mRuntimeParams.getHeight() == i16) {
                return;
            }
            TPPlayerRetryAdapter.this.mRuntimeParams.setWidth(i3);
            TPPlayerRetryAdapter.this.mRuntimeParams.setHeight(i16);
            TPPlayerRetryAdapter.this.mPlayerListeners.onVideoSizeChanged(TPPlayerRetryAdapter.this, i3, i16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TPPlayerRetryAdapter(@NonNull TPContext tPContext, @Nullable TPPlayerConstructParams tPPlayerConstructParams) throws TPLoadLibraryException {
        this.mTPContext = tPContext;
        this.mPlayerListeners = new TPInnerPlayerListeners(tPContext.getLogTag());
        this.mRetryPlayerListeners = new TPRetryPlayerListeners(tPContext.getLogTag());
        this.mPlayerCoreChooser = new TPPlayerCoreChooser(tPContext, getPlayerCoreTypes(tPPlayerConstructParams));
        ITPInnerPlayer createPlayerCoreForFirstOpen = createPlayerCoreForFirstOpen();
        this.mPlayer = createPlayerCoreForFirstOpen;
        if (createPlayerCoreForFirstOpen != null) {
        } else {
            throw new TPLoadLibraryException("create player failed.");
        }
    }

    private void addAudioTrack(ITPInnerPlayer iTPInnerPlayer) {
        for (TPPlayerInputParams.AudioTrackArguments audioTrackArguments : this.mInputParams.getAudioTrackArgumentList()) {
            try {
                iTPInnerPlayer.addAudioTrackSource(audioTrackArguments.getMediaAsset(), audioTrackArguments.getName());
            } catch (IllegalArgumentException e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "setupAudioTrack failed, exception:" + e16);
            }
        }
    }

    private void addOptionalParamInternal(@NonNull TPOptionalParam<?> tPOptionalParam) {
        if (TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_ENABLE_REUSE_PLAYER.equals(tPOptionalParam.getKey())) {
            this.mRuntimeParams.setEnableReusePlayer(((Boolean) tPOptionalParam.getValue()).booleanValue());
        }
    }

    private void addSubtitleTrack(ITPInnerPlayer iTPInnerPlayer) {
        for (TPPlayerInputParams.SubtitleArguments subtitleArguments : this.mInputParams.getSubtitleArgumentList()) {
            try {
                iTPInnerPlayer.addSubtitleTrackSource(subtitleArguments.getMediaAsset(), subtitleArguments.getName());
            } catch (IllegalArgumentException e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "setupSubtitleTrack failed, exception:" + e16);
            }
        }
    }

    private long assignUniqueIdForOpaque(long j3) {
        long j16 = this.mUniqueIDCounter + 1;
        this.mUniqueIDCounter = j16;
        this.mUniqueIDToOpaqueMap.put(Long.valueOf(j16), Long.valueOf(j3));
        return this.mUniqueIDCounter;
    }

    @Nullable
    private ITPInnerPlayer createPlayerCoreForFirstOpen() {
        ITPInnerPlayer choosePlayerCoreForFirstOpen = this.mPlayerCoreChooser.choosePlayerCoreForFirstOpen();
        if (choosePlayerCoreForFirstOpen == null) {
            return null;
        }
        setPlayerListener(choosePlayerCoreForFirstOpen);
        return choosePlayerCoreForFirstOpen;
    }

    @Nullable
    private ITPInnerPlayer createPlayerCoreForRetry() {
        ITPInnerPlayer choosePlayerCoreForRetry = this.mPlayerCoreChooser.choosePlayerCoreForRetry();
        if (choosePlayerCoreForRetry == null) {
            return null;
        }
        setPlayerListener(choosePlayerCoreForRetry);
        return choosePlayerCoreForRetry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getOpaqueFromUniqueId(long j3) {
        if (!this.mUniqueIDToOpaqueMap.containsKey(Long.valueOf(j3))) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "invalid uniqueID: " + j3);
            return -1L;
        }
        return this.mUniqueIDToOpaqueMap.get(Long.valueOf(j3)).longValue();
    }

    private int[] getPlayerCoreTypes(@Nullable TPPlayerConstructParams tPPlayerConstructParams) {
        if (tPPlayerConstructParams != null) {
            for (TPOptionalParam<?> tPOptionalParam : tPPlayerConstructParams.getOptionalParams()) {
                if (TPPlayerConstructParams.CONSTRUCT_ID_QUEUE_INT_CORE_TYPE.equals(tPOptionalParam.getKey())) {
                    return (int[]) tPOptionalParam.getValue();
                }
            }
        }
        return null;
    }

    private int getTrackIndexInTrackInfos(int i3, String str, TPTrackInfo[] tPTrackInfoArr) {
        for (int i16 = 0; i16 < tPTrackInfoArr.length; i16++) {
            if (i3 == tPTrackInfoArr[i16].getMediaType() && !TextUtils.isEmpty(str) && str.equals(tPTrackInfoArr[i16].getName())) {
                return i16;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnError(@NonNull TPError tPError) {
        if (this.mRuntimeParams.getError() == null) {
            this.mRuntimeParams.setError(tPError);
        }
        ITPInnerPlayer createPlayerCoreForRetry = createPlayerCoreForRetry();
        if (createPlayerCoreForRetry == null) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "onError, no retry player, return error:" + this.mRuntimeParams.getError());
            this.mPlayerListeners.onError(this, this.mRuntimeParams.getError());
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "retrying player with player core type:" + TPPlayerCoreTypeToString.getPlayerCoreName(createPlayerCoreForRetry.getPlayerCoreType()));
        reopenOnPlayerError(tPError, createPlayerCoreForRetry);
    }

    private void notifyPlayerCoreTypeChanged(int i3) {
        if (this.mRuntimeParams.getPlayerCoreType() != i3) {
            this.mRuntimeParams.setPlayerCoreType(i3);
            this.mPlayerListeners.onInfo(this, 50002, new TPOnInfoParam.Builder().setLongParam(i3).build());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recoverInvokeOnRetryFinish(ITPPlayer iTPPlayer) {
        TPPlayerRuntimeParams.PendingInvokeArgumentsDuringRetry pendingInvokeArgumentsDuringRetry = this.mRuntimeParams.getPendingInvokeArgumentsDuringRetry();
        recoverSwitchDataSourceInvoke(iTPPlayer, pendingInvokeArgumentsDuringRetry.getSwitchedDataSourceArguments());
        recoverSeekInvoke(iTPPlayer, pendingInvokeArgumentsDuringRetry.getSeekArguments());
        recoverSelectAndDeselectTrackInvokeWithUniqueIDList(iTPPlayer, pendingInvokeArgumentsDuringRetry.getSelectAndDeselectTrackRecordList());
    }

    private void recoverSeekInvoke(ITPPlayer iTPPlayer, TPPlayerRuntimeParams.SeekArguments seekArguments) {
        if (seekArguments == null) {
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "retrying, player prepared, recover seek invoke:" + seekArguments);
        try {
            if (seekArguments.getSeekMode() == 0) {
                iTPPlayer.seekToAsync(seekArguments.getSeekPositionMs(), seekArguments.getUniqueID());
            } else {
                iTPPlayer.seekToAsync(seekArguments.getSeekPositionMs(), seekArguments.getSeekMode(), seekArguments.getUniqueID());
            }
        } catch (IllegalStateException e16) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "retrying, player seekTo failed:" + e16);
        }
    }

    private void recoverSelectAndDeselectTrackInvokeWithArgumentsList(@NonNull ITPPlayer iTPPlayer, @Nullable List<Object> list) {
        TPTrackInfo[] trackInfo;
        if (list != null && !list.isEmpty() && (trackInfo = iTPPlayer.getTrackInfo()) != null && trackInfo.length != 0) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "retrying, player prepared, recover selectAndDeselectTrack invoke:" + list);
            for (Object obj : list) {
                if (obj instanceof TPPlayerInputParams.SelectTrackAsyncArguments) {
                    setupSelectTrack(iTPPlayer, trackInfo, (TPPlayerInputParams.SelectTrackAsyncArguments) obj);
                } else if (obj instanceof TPPlayerInputParams.DeselectTrackAsyncArguments) {
                    setupDeselectTrack(iTPPlayer, trackInfo, (TPPlayerInputParams.DeselectTrackAsyncArguments) obj);
                }
            }
        }
    }

    private void recoverSelectAndDeselectTrackInvokeWithUniqueIDList(@NonNull ITPPlayer iTPPlayer, @Nullable List<Long> list) {
        TPTrackInfo[] trackInfo;
        if (list != null && !list.isEmpty() && (trackInfo = iTPPlayer.getTrackInfo()) != null && trackInfo.length != 0) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "retrying, player prepared, recover selectAndDeselectTrack invoke:" + list);
            Iterator<Long> it = list.iterator();
            while (it.hasNext()) {
                Object trackArgumentsWithUniqueID = trackArgumentsWithUniqueID(it.next().longValue());
                if (trackArgumentsWithUniqueID instanceof TPPlayerInputParams.SelectTrackAsyncArguments) {
                    setupSelectTrack(iTPPlayer, trackInfo, (TPPlayerInputParams.SelectTrackAsyncArguments) trackArgumentsWithUniqueID);
                } else if (trackArgumentsWithUniqueID instanceof TPPlayerInputParams.DeselectTrackAsyncArguments) {
                    setupDeselectTrack(iTPPlayer, trackInfo, (TPPlayerInputParams.DeselectTrackAsyncArguments) trackArgumentsWithUniqueID);
                }
            }
        }
    }

    private void recoverSwitchDataSourceInvoke(ITPPlayer iTPPlayer, TPPlayerRuntimeParams.SwitchedDataSourceArguments switchedDataSourceArguments) {
        if (switchedDataSourceArguments == null) {
            return;
        }
        TPLogUtil.i(this.mTPContext.getLogTag(), "retrying, player prepared, recover switchDataSource invoke:" + switchedDataSourceArguments);
        try {
            if (switchedDataSourceArguments.getSwitchDataSourceAsyncMethodType() == 0) {
                iTPPlayer.switchDataSourceAsync(switchedDataSourceArguments.getMediaAsset(), switchedDataSourceArguments.getUniqueID());
            } else if (switchedDataSourceArguments.getSwitchDataSourceAsyncMethodType() == 1) {
                iTPPlayer.switchDataSourceAsync(switchedDataSourceArguments.getMediaAsset(), switchedDataSourceArguments.getMode(), switchedDataSourceArguments.getUniqueID());
            } else if (switchedDataSourceArguments.getSwitchDataSourceAsyncMethodType() == 2) {
                iTPPlayer.switchDataSourceAndSelectTrackAsync(switchedDataSourceArguments.getMediaAsset(), switchedDataSourceArguments.getMode(), tracksNameToIdx(switchedDataSourceArguments.getTracksName()), switchedDataSourceArguments.getUniqueID());
            } else {
                TPLogUtil.w(this.mTPContext.getLogTag(), "retrying, player switchDataSource failed, unknown type");
            }
        } catch (IllegalStateException e16) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "retrying, player switchDataSource failed:" + e16);
        }
    }

    private void reopenOnPlayerError(@NonNull TPError tPError, @NonNull ITPInnerPlayer iTPInnerPlayer) {
        try {
            TPLogUtil.i(this.mTPContext.getLogTag(), "reopenOnPlayerError:" + tPError);
            if (tPError.getCurrentPosMs() != Long.MIN_VALUE) {
                updateRuntimeParamsBeforeRetry(tPError.getCurrentPosMs());
            } else {
                updateRuntimeParamsBeforeRetry(this.mPlayer.getCurrentPositionMs());
            }
            int playerCoreType = this.mPlayer.getPlayerCoreType();
            this.mPlayer.reset();
            this.mPlayer.release();
            this.mPlayer = iTPInnerPlayer;
            this.mRuntimeParams.setUseRetryPlayerCore(true);
            setupPlayerBeforePrepare(this.mPlayer);
            reparametrizeOnRetryBegin(this.mPlayer, false);
            this.mPlayer.prepareAsync();
            this.mRuntimeParams.setRetrying(true);
            this.mPlayerListeners.onInfo(this, 50000, new TPOnInfoParam.Builder().setLongParam(playerCoreType, this.mPlayer.getPlayerCoreType()).setObjParam(tPError).build());
            this.mPlayerListeners.onInfo(this, 200, null);
            TPLogUtil.i(this.mTPContext.getLogTag(), "retrying player with player core type:" + this.mPlayer.getPlayerCoreType());
        } catch (Exception e16) {
            TPLogUtil.e(this.mTPContext.getLogTag(), "retrying player failed, exception:" + e16);
            handleOnError(tPError);
        }
    }

    private void reparametrizeOnRetryBegin(ITPInnerPlayer iTPInnerPlayer, boolean z16) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "reparametrizeOnRetryBegin, enableAccurateStartPosition:" + z16 + ", currentPositionMs:" + this.mRuntimeParams.getCurrentPositionMs() + ", currentState:" + TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState()));
        iTPInnerPlayer.addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS, this.mRuntimeParams.getCurrentPositionMs()));
        if (z16) {
            iTPInnerPlayer.addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_BEFORE_BOOL_START_PLAYING_TIME_ACCURATE_SEEK, true));
        }
    }

    private void setPlayerListener(ITPInnerPlayer iTPInnerPlayer) {
        iTPInnerPlayer.setOnPreparedListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnCompletionListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnInfoListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnErrorListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnSeekCompleteListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnVideoSizeChangedListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnVideoFrameOutListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnAudioFrameOutListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnAudioProcessFrameOutListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnSubtitleDataOutListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnDebugTrackingInfoListener(this.mRetryPlayerListeners);
        iTPInnerPlayer.setOnSnapshotListener(this.mRetryPlayerListeners);
    }

    private void setupDeselectTrack(ITPPlayer iTPPlayer, TPTrackInfo[] tPTrackInfoArr, TPPlayerInputParams.DeselectTrackAsyncArguments deselectTrackAsyncArguments) {
        int trackIndexInTrackInfos = getTrackIndexInTrackInfos(deselectTrackAsyncArguments.getMediaType(), deselectTrackAsyncArguments.getTrackName(), tPTrackInfoArr);
        if (trackIndexInTrackInfos < 0) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "setupDeselectTrack, invalid trackIndexInPlayerTrackInfo\uff0c must something wrong");
        } else {
            iTPPlayer.deselectTrackAsync(trackIndexInTrackInfos, deselectTrackAsyncArguments.getUniqueID());
        }
    }

    private void setupOptionalParams(ITPInnerPlayer iTPInnerPlayer) {
        if (this.mInputParams.getOptionalParamList() == null) {
            return;
        }
        Iterator<TPOptionalParam<?>> it = this.mInputParams.getOptionalParamList().iterator();
        while (it.hasNext()) {
            iTPInnerPlayer.addOptionalParam(it.next());
        }
    }

    private void setupPlayerBeforePrepare(@NonNull ITPInnerPlayer iTPInnerPlayer) {
        setPlayerListener(iTPInnerPlayer);
        iTPInnerPlayer.setDataSource(this.mInputParams.getMediaAsset());
        notifyPlayerCoreTypeChanged(iTPInnerPlayer.getPlayerCoreType());
        setupOptionalParams(iTPInnerPlayer);
        addSubtitleTrack(iTPInnerPlayer);
        addAudioTrack(iTPInnerPlayer);
        recoverSelectAndDeselectTrackInvokeWithArgumentsList(iTPInnerPlayer, this.mInputParams.getSelectAndDeselectTrackArgumentList());
        setupSelectProgram(iTPInnerPlayer);
        if (this.mInputParams.getLoopbackArguments() != null) {
            if (this.mInputParams.getLoopbackArguments().getLoopbackMethodType() == 0) {
                iTPInnerPlayer.setLoopback(this.mInputParams.getLoopbackArguments().isLoopback());
            } else {
                iTPInnerPlayer.setLoopback(this.mInputParams.getLoopbackArguments().isLoopback(), this.mInputParams.getLoopbackArguments().getStartPositionMs(), this.mInputParams.getLoopbackArguments().getEndPositionMs());
            }
        }
        iTPInnerPlayer.setAudioMute(this.mInputParams.isAudioMute());
        iTPInnerPlayer.setAudioVolume(this.mInputParams.getAudioVolume());
        iTPInnerPlayer.setPlaySpeedRatio(this.mInputParams.getPlaySpeedRatio());
        if (!TextUtils.isEmpty(this.mInputParams.getAudioNormalizeVolumeParams())) {
            iTPInnerPlayer.setAudioNormalizeVolumeParams(this.mInputParams.getAudioNormalizeVolumeParams());
        }
        if (this.mInputParams.getSurfaceObj() instanceof SurfaceHolder) {
            iTPInnerPlayer.setSurfaceHolder((SurfaceHolder) this.mInputParams.getSurfaceObj());
        } else if (this.mInputParams.getSurfaceObj() instanceof Surface) {
            iTPInnerPlayer.setSurface((Surface) this.mInputParams.getSurfaceObj());
        }
    }

    private void setupSelectProgram(ITPInnerPlayer iTPInnerPlayer) {
        if (this.mInputParams.getSelectProgramAsyncArguments() == null) {
            return;
        }
        iTPInnerPlayer.selectProgramAsync(this.mInputParams.getSelectProgramAsyncArguments().getProgramIndex(), this.mInputParams.getSelectProgramAsyncArguments().getOpaque());
    }

    private void setupSelectTrack(ITPPlayer iTPPlayer, TPTrackInfo[] tPTrackInfoArr, TPPlayerInputParams.SelectTrackAsyncArguments selectTrackAsyncArguments) {
        int trackIndexInTrackInfos = getTrackIndexInTrackInfos(selectTrackAsyncArguments.getMediaType(), selectTrackAsyncArguments.getTrackName(), tPTrackInfoArr);
        if (trackIndexInTrackInfos < 0) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "setupSelectTrack, invalid trackIndexInPlayerTrackInfo\uff0c must something wrong");
        } else {
            iTPPlayer.selectTrackAsync(trackIndexInTrackInfos, selectTrackAsyncArguments.getUniqueID());
        }
    }

    private Object trackArgumentsWithUniqueID(long j3) {
        for (Object obj : this.mInputParams.getSelectAndDeselectTrackArgumentList()) {
            if (obj instanceof TPPlayerInputParams.SelectTrackAsyncArguments) {
                if (((TPPlayerInputParams.SelectTrackAsyncArguments) obj).getUniqueID() == j3) {
                    return obj;
                }
            } else if ((obj instanceof TPPlayerInputParams.DeselectTrackAsyncArguments) && ((TPPlayerInputParams.DeselectTrackAsyncArguments) obj).getUniqueID() == j3) {
                return obj;
            }
        }
        return null;
    }

    private String[] tracksIdxToName(int[] iArr) {
        TPTrackInfo[] trackInfo = getTrackInfo();
        String[] strArr = new String[iArr.length];
        int i3 = 0;
        for (int i16 : iArr) {
            if (i16 >= 0 && i16 < trackInfo.length) {
                strArr[i3] = trackInfo[i16].getName();
                i3++;
            }
        }
        return (String[]) Arrays.copyOf(strArr, i3);
    }

    private int[] tracksNameToIdx(String[] strArr) {
        TPTrackInfo[] trackInfo = getTrackInfo();
        int[] iArr = new int[strArr.length];
        int i3 = 0;
        for (String str : strArr) {
            for (int i16 = 0; i16 < trackInfo.length; i16++) {
                if (trackInfo[i16].getName().equals(str)) {
                    iArr[i3] = i16;
                    i3++;
                }
            }
        }
        return Arrays.copyOf(iArr, i3);
    }

    private void updateRuntimeParamsBeforeRetry(long j3) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "updateRuntimeParamsBeforeRetry, currentPositionMs:" + j3 + ", currentState:" + TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState()) + ", isRetrying:" + this.mRuntimeParams.isRetrying());
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "already in retrying");
            TPPlayerRuntimeParams.PendingInvokeArgumentsDuringRetry pendingInvokeArgumentsDuringRetry = this.mRuntimeParams.getPendingInvokeArgumentsDuringRetry();
            if (pendingInvokeArgumentsDuringRetry.getSeekArguments() != null) {
                TPLogUtil.i(this.mTPContext.getLogTag(), "use seekArguments.seekPositionMs:" + pendingInvokeArgumentsDuringRetry.getSeekArguments().getSeekPositionMs());
                this.mRuntimeParams.setCurrentPositionMs(pendingInvokeArgumentsDuringRetry.getSeekArguments().getSeekPositionMs());
                pendingInvokeArgumentsDuringRetry.setSeekArguments(null);
                TPPlayerRuntimeParams tPPlayerRuntimeParams = this.mRuntimeParams;
                tPPlayerRuntimeParams.setAvailablePositionMs(tPPlayerRuntimeParams.getCurrentPositionMs());
                return;
            }
            return;
        }
        if (this.mTPContext.getStateQuerier().isInStates(2)) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "preparing state, use startPlayingTimeMs as retry position");
            TPOptionalParam<?> optionalParam = this.mInputParams.getOptionalParam(TPOptionalID.OPTIONAL_ID_BEFORE_LONG_START_PLAYING_TIME_MS);
            if (optionalParam != null) {
                long longValue = ((Long) optionalParam.getValue()).longValue();
                TPLogUtil.i(this.mTPContext.getLogTag(), "startPlayingTimeMs:" + longValue);
                if (longValue >= 0) {
                    this.mRuntimeParams.setCurrentPositionMs(longValue);
                }
            } else {
                TPLogUtil.i(this.mTPContext.getLogTag(), "startPlayingTimeOptionalParam is null");
            }
        } else {
            TPLogUtil.i(this.mTPContext.getLogTag(), "not preparing state, use currentPositionMs: " + j3 + " as retry position");
            this.mRuntimeParams.setCurrentPositionMs(j3);
        }
        TPPlayerRuntimeParams tPPlayerRuntimeParams2 = this.mRuntimeParams;
        tPPlayerRuntimeParams2.setAvailablePositionMs(tPPlayerRuntimeParams2.getCurrentPositionMs());
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addAudioTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        this.mPlayer.addAudioTrackSource(iTPMediaAsset, str);
        this.mInputParams.onAddAudioTrackSource(iTPMediaAsset, str);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addOptionalParam(@NonNull TPOptionalParam<?> tPOptionalParam) throws IllegalStateException {
        addOptionalParamInternal(tPOptionalParam);
        this.mInputParams.onAddOptionalParam(tPOptionalParam);
        this.mPlayer.addOptionalParam(tPOptionalParam);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void addPlugin(ITPPluginBase iTPPluginBase) {
        a.a(this, iTPPluginBase);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void addSubtitleTrackSource(@NonNull ITPMediaAsset iTPMediaAsset, String str) throws IllegalArgumentException {
        this.mPlayer.addSubtitleTrackSource(iTPMediaAsset, str);
        this.mInputParams.onAddSubtitleTrackSource(iTPMediaAsset, str);
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
        if (this.mRuntimeParams.isRetrying()) {
            return this.mRuntimeParams.getAvailablePositionMs();
        }
        return this.mPlayer.getAvailablePositionMs();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getCurrentPositionMs() {
        if (this.mRuntimeParams.isRetrying()) {
            return this.mRuntimeParams.getCurrentPositionMs();
        }
        return this.mPlayer.getCurrentPositionMs();
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ int getCurrentState() {
        return com.tencent.thumbplayer.impl.a.a(this);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public long getDemuxerCurrentOriginalPtsUs() {
        return this.mPlayer.getDemuxerCurrentOriginalPtsUs();
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public long getDemuxerOffsetInFileByte() {
        return this.mPlayer.getDemuxerOffsetInFileByte();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public long getDurationMs() {
        if (this.mRuntimeParams.getDurationMs() > 0) {
            return this.mRuntimeParams.getDurationMs();
        }
        return this.mPlayer.getDurationMs();
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    @Nullable
    public TPDynamicStatisticParams getDynamicStatisticParams(boolean z16) {
        return this.mPlayer.getDynamicStatisticParams(z16);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    @Nullable
    public TPGeneralPlayFlowParams getGeneralPlayFlowParams() {
        return this.mPlayer.getGeneralPlayFlowParams();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getHeight() {
        if (this.mRuntimeParams.getHeight() > 0) {
            return this.mRuntimeParams.getHeight();
        }
        return this.mPlayer.getHeight();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getPlayerCoreType() {
        return this.mPlayer.getPlayerCoreType();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    public TPProgramInfo[] getProgramInfo() {
        return this.mPlayer.getProgramInfo();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public String getProperty(String str) throws IllegalStateException {
        return this.mPlayer.getProperty(str);
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
        return a.b(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    @Nullable
    public TPTrackInfo[] getTrackInfo() {
        return this.mPlayer.getTrackInfo();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public int getWidth() {
        if (this.mRuntimeParams.getWidth() > 0) {
            return this.mRuntimeParams.getWidth();
        }
        return this.mPlayer.getWidth();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void pause() throws IllegalStateException {
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "The player is retrying, and when the retry is complete, player will be changed to: " + TPPlayerStateToString.getStateName(5));
            return;
        }
        this.mPlayer.pause();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void pauseDownload() throws IllegalStateException {
        this.mPlayer.pauseDownload();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void prepareAsync() throws IllegalStateException {
        notifyPlayerCoreTypeChanged(this.mPlayer.getPlayerCoreType());
        this.mPlayer.prepareAsync();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void release() {
        this.mPlayer.release();
        this.mInputParams.onRelease();
        this.mRuntimeParams.onRelease();
        this.mPlayerListeners.clear();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void removeTrack(int i3) throws IllegalArgumentException {
        int length;
        if (!this.mRuntimeParams.isRetrying()) {
            TPTrackInfo[] trackInfo = this.mPlayer.getTrackInfo();
            if (trackInfo != null && i3 >= 0 && i3 < trackInfo.length) {
                this.mPlayer.removeTrack(i3);
                TPTrackInfo tPTrackInfo = trackInfo[i3];
                if (tPTrackInfo.getMediaType() == 1) {
                    this.mInputParams.onRemoveAudioTrack(tPTrackInfo.getName());
                    return;
                } else {
                    if (tPTrackInfo.getMediaType() == 3) {
                        this.mInputParams.onRemoveSubtitleTrack(tPTrackInfo.getName());
                        return;
                    }
                    return;
                }
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("removeTrack, trackIndex:");
            sb5.append(i3);
            sb5.append(" is out range[0, ");
            if (trackInfo == null) {
                length = 0;
            } else {
                length = trackInfo.length;
            }
            sb5.append(length);
            sb5.append("]");
            throw new IllegalArgumentException(sb5.toString());
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "player is retrying, removeTrack will be ignored.");
        throw new IllegalArgumentException("player is retrying, removeTrack will be ignored.");
    }

    @Override // com.tencent.thumbplayer.retry.ITPPlayerRetryAdapter
    public void reopenPlayer(boolean z16) throws IllegalStateException {
        TPLogUtil.i(this.mTPContext.getLogTag(), "reopenPlayer, enableAccurateStartPosition: " + z16 + ", state: " + TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState()));
        if (!this.mTPContext.getStateQuerier().isInStates(0, 1)) {
            updateRuntimeParamsBeforeRetry(this.mPlayer.getCurrentPositionMs());
            this.mPlayer.reset();
            setupPlayerBeforePrepare(this.mPlayer);
            reparametrizeOnRetryBegin(this.mPlayer, z16);
            try {
                this.mPlayer.prepareAsync();
                this.mRuntimeParams.setRetrying(true);
                this.mPlayerListeners.onInfo(this, 50000, new TPOnInfoParam.Builder().setLongParam(this.mPlayer.getPlayerCoreType(), this.mPlayer.getPlayerCoreType()).build());
                this.mPlayerListeners.onInfo(this, 200, null);
                return;
            } catch (Exception e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "reopen player failed, exception:" + e16);
                handleOnError(new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_UNMATCHED_STATE));
                return;
            }
        }
        TPLogUtil.e(this.mTPContext.getLogTag(), "reopenPlayer, invalid state:" + TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState()));
        throw new IllegalStateException(String.format("invalid state:%s", TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState())));
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reset() {
        if (!this.mRuntimeParams.isUseRetryPlayerCore() && this.mRuntimeParams.isEnableReusePlayer()) {
            this.mPlayer.reset();
        } else {
            TPLogUtil.i(this.mTPContext.getLogTag(), "not enable reuse player or use the retry player, need to release the player and create the player for first open");
            this.mPlayer.release();
            this.mPlayerCoreChooser.reset();
            this.mPlayer = createPlayerCoreForFirstOpen();
        }
        this.mUniqueIDCounter = 0L;
        this.mUniqueIDToOpaqueMap.clear();
        this.mInputParams.onReset();
        this.mRuntimeParams.onReset();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void resumeDownload() {
        this.mPlayer.resumeDownload();
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
        this.mPlayer.setAudioMute(z16);
        this.mInputParams.onSetAudioMute(z16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioNormalizeVolumeParams(String str) {
        this.mPlayer.setAudioNormalizeVolumeParams(str);
        this.mInputParams.onSetAudioNormalizeVolumeParams(str);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setAudioVolume(float f16) {
        this.mPlayer.setAudioVolume(f16);
        this.mInputParams.onSetAudioVolume(f16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setBusinessDownloadStrategy(int i3, int i16, int i17, int i18, int i19) {
        a.c(this, i3, i16, i17, i18, i19);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setDataSource(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalArgumentException, IllegalStateException {
        this.mPlayer.setDataSource(iTPMediaAsset);
        this.mInputParams.onSetDataSource(iTPMediaAsset);
        ReportThumbPlayer.getInstance().setDataSource(this, iTPMediaAsset);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setIsActive(boolean z16) {
        this.mPlayer.setIsActive(z16);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLogTagPrefix(String str) {
        this.mPlayer.setLogTagPrefix(str);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16) {
        setLoopback(z16, 0L, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioFrameOutListener(ITPPlayerListener.IOnAudioFrameOutListener iOnAudioFrameOutListener) {
        this.mPlayerListeners.setOnAudioFrameOutListener(iOnAudioFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnAudioProcessFrameOutListener(ITPPlayerListener.IOnAudioProcessFrameOutListener iOnAudioProcessFrameOutListener) {
        this.mPlayerListeners.setOnAudioProcessFrameOutListener(iOnAudioProcessFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnCompletionListener(ITPPlayerListener.IOnCompletionListener iOnCompletionListener) {
        this.mPlayerListeners.setOnCompletionListener(iOnCompletionListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnDebugTrackingInfoListener(ITPPlayerListener.IOnDebugTrackingInfoListener iOnDebugTrackingInfoListener) {
        this.mPlayerListeners.setOnDebugTrackingInfoListener(iOnDebugTrackingInfoListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnErrorListener(ITPPlayerListener.IOnErrorListener iOnErrorListener) {
        this.mPlayerListeners.setOnErrorListener(iOnErrorListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public void setOnEventRecordListener(ITPInnerPlayerListener.IOnEventRecordListener iOnEventRecordListener) {
        this.mPlayerListeners.setOnEventRecordListener(iOnEventRecordListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setOnGetRemainTimeBeforePlayListener(ITPPlayerListener.IOnGetRemainTimeBeforePlayListener iOnGetRemainTimeBeforePlayListener) {
        com.tencent.thumbplayer.impl.a.e(this, iOnGetRemainTimeBeforePlayListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnInfoListener(ITPPlayerListener.IOnInfoListener iOnInfoListener) {
        this.mPlayerListeners.setOnInfoListener(iOnInfoListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnMediaAssetExpireListener(ITPPlayerListener.IOnMediaAssetExpireListener iOnMediaAssetExpireListener) {
        this.mPlayerListeners.setOnMediaAssetExpireListener(iOnMediaAssetExpireListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnPreparedListener(ITPPlayerListener.IOnPreparedListener iOnPreparedListener) {
        this.mPlayerListeners.setOnPreparedListener(iOnPreparedListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSeekCompleteListener(ITPPlayerListener.IOnSeekCompleteListener iOnSeekCompleteListener) {
        this.mPlayerListeners.setOnSeekCompleteListener(iOnSeekCompleteListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSnapshotListener(ITPPlayerListener.IOnSnapshotListener iOnSnapshotListener) {
        this.mPlayerListeners.setOnSnapshotListener(iOnSnapshotListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnStateChangedListener(ITPPlayerListener.IOnStateChangedListener iOnStateChangedListener) {
        this.mPlayerListeners.setOnStateChangedListener(iOnStateChangedListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnSubtitleDataOutListener(ITPPlayerListener.IOnSubtitleDataOutListener iOnSubtitleDataOutListener) {
        this.mPlayerListeners.setOnSubtitleDataOutListener(iOnSubtitleDataOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoFrameOutListener(ITPPlayerListener.IOnVideoFrameOutListener iOnVideoFrameOutListener) {
        this.mPlayerListeners.setOnVideoFrameOutListener(iOnVideoFrameOutListener);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnVideoSizeChangedListener(ITPPlayerListener.IOnVideoSizeChangedListener iOnVideoSizeChangedListener) {
        this.mPlayerListeners.setOnVideoSizeChangedListener(iOnVideoSizeChangedListener);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer
    public void setPlayRemuxer(ITPPlayRemuxer iTPPlayRemuxer) {
        this.mPlayer.setPlayRemuxer(iTPPlayRemuxer);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setPlaySpeedRatio(float f16) {
        this.mPlayer.setPlaySpeedRatio(f16);
        this.mInputParams.onSetPlaySpeedRatio(f16);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void setRichMediaSynchronizer(ITPRichMediaSynchronizer iTPRichMediaSynchronizer) {
        com.tencent.thumbplayer.impl.a.i(this, iTPRichMediaSynchronizer);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurface(Surface surface) {
        this.mPlayer.setSurface(surface);
        this.mInputParams.onSetSurface(surface);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.mPlayer.setSurfaceHolder(surfaceHolder);
        this.mInputParams.onSetSurfaceHolder(surfaceHolder);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams) throws IllegalStateException {
        snapshotAsync(tPSnapshotParams, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void start() throws IllegalStateException {
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "The player is retrying, and when the retry is complete, player will be changed to: " + TPPlayerStateToString.getStateName(4));
            return;
        }
        this.mPlayer.start();
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void stop() throws IllegalStateException {
        this.mPlayer.stop();
        this.mRuntimeParams.onStop();
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public /* synthetic */ void stopAsync() {
        com.tencent.thumbplayer.impl.a.j(this);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAndSelectTrackAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, int[] iArr, long j3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        if (!this.mRuntimeParams.isRetrying()) {
            long assignUniqueIdForOpaque = assignUniqueIdForOpaque(j3);
            TPTrackInfo[] trackInfo = getTrackInfo();
            this.mRuntimeParams.onSwitchDataSourceAndSelectTrack(iTPMediaAsset, i3, tracksIdxToName(iArr), assignUniqueIdForOpaque);
            this.mInputParams.onSwitchDataSource(iTPMediaAsset, i3, assignUniqueIdForOpaque);
            for (int i16 : iArr) {
                this.mInputParams.onSelectTrackAsync(trackInfo[i16].getMediaType(), trackInfo[i16].getName(), assignUniqueIdForOpaque);
            }
            this.mPlayer.switchDataSourceAndSelectTrackAsync(iTPMediaAsset, i3, iArr, assignUniqueIdForOpaque);
            return;
        }
        TPLogUtil.w(this.mTPContext.getLogTag(), "player is retrying, switchDataSourceAndSelectTrackAsync is not allowed.");
        throw new IllegalStateException("player is retrying, switchDataSourceAndSelectTrackAsync is not allowed.");
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        switchDataSourceAsync(iTPMediaAsset, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void deselectTrackAsync(int i3, long j3) {
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "player is retrying, deselectTrackAsync will be ignored.");
            this.mPlayerListeners.onInfo(this, 13, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_UNMATCHED_STATE)).build());
            return;
        }
        TPTrackInfo[] trackInfo = this.mPlayer.getTrackInfo();
        if (trackInfo != null && i3 >= 0 && i3 < trackInfo.length) {
            long assignUniqueIdForOpaque = assignUniqueIdForOpaque(j3);
            this.mInputParams.onDeselectTrackAsync(trackInfo[i3].getMediaType(), trackInfo[i3].getName(), assignUniqueIdForOpaque);
            this.mRuntimeParams.addDeselectTrackRecord(assignUniqueIdForOpaque);
            this.mPlayer.deselectTrackAsync(i3, assignUniqueIdForOpaque);
            return;
        }
        String logTag = this.mTPContext.getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("deselectTrackAsync, trackIndex:");
        sb5.append(i3);
        sb5.append(" is out range[0, ");
        sb5.append(trackInfo == null ? 0 : trackInfo.length);
        sb5.append("]");
        TPLogUtil.w(logTag, sb5.toString());
        this.mPlayerListeners.onInfo(this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_INVALID_ARG)).build());
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, long j16) throws IllegalStateException {
        long assignUniqueIdForOpaque = assignUniqueIdForOpaque(j16);
        this.mRuntimeParams.onSeekToAsync(j3, assignUniqueIdForOpaque);
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "The player is retrying, and when the retry is complete, player will be sought to: " + j3);
            return;
        }
        this.mPlayer.seekToAsync(j3, 0, assignUniqueIdForOpaque);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectProgramAsync(int i3, long j3) {
        this.mPlayer.selectProgramAsync(i3, j3);
        this.mInputParams.onSelectProgramAsync(i3, j3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void selectTrackAsync(int i3, long j3) {
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.w(this.mTPContext.getLogTag(), "player is retrying, selectTrackAsync will be ignored.");
            this.mPlayerListeners.onInfo(this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_UNMATCHED_STATE)).build());
            return;
        }
        TPTrackInfo[] trackInfo = this.mPlayer.getTrackInfo();
        if (trackInfo != null && i3 >= 0 && i3 < trackInfo.length) {
            long assignUniqueIdForOpaque = assignUniqueIdForOpaque(j3);
            this.mInputParams.onSelectTrackAsync(trackInfo[i3].getMediaType(), trackInfo[i3].getName(), assignUniqueIdForOpaque);
            this.mRuntimeParams.addSelectTrackRecord(assignUniqueIdForOpaque);
            this.mPlayer.selectTrackAsync(i3, assignUniqueIdForOpaque);
            return;
        }
        String logTag = this.mTPContext.getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("selectTrackAsync, trackIndex:");
        sb5.append(i3);
        sb5.append(" is out range[0, ");
        sb5.append(trackInfo == null ? 0 : trackInfo.length);
        sb5.append("]");
        TPLogUtil.w(logTag, sb5.toString());
        this.mPlayerListeners.onInfo(this, 11, new TPOnInfoParam.Builder().setLongParam(j3).setObjParam(new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_INVALID_ARG)).build());
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void setLoopback(boolean z16, long j3, long j16) {
        this.mPlayer.setLoopback(z16, j3, j16);
        this.mInputParams.onSetLoopback(z16, j3, j16);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void snapshotAsync(TPSnapshotParams tPSnapshotParams, long j3) throws IllegalStateException {
        this.mPlayer.snapshotAsync(tPSnapshotParams, j3);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, long j3) throws IllegalStateException, IllegalArgumentException {
        long assignUniqueIdForOpaque = assignUniqueIdForOpaque(j3);
        this.mRuntimeParams.onSwitchDataSource(iTPMediaAsset, assignUniqueIdForOpaque);
        this.mInputParams.onSwitchDataSource(iTPMediaAsset, assignUniqueIdForOpaque);
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "The player is retrying, and when the retry is complete, player will be switched dataSource to: " + iTPMediaAsset);
            return;
        }
        this.mPlayer.switchDataSourceAsync(iTPMediaAsset, assignUniqueIdForOpaque);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, int i3) {
        seekToAsync(j3, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void seekToAsync(long j3, int i3, long j16) throws IllegalStateException {
        long assignUniqueIdForOpaque = assignUniqueIdForOpaque(j16);
        this.mRuntimeParams.onSeekToAsync(j3, i3, assignUniqueIdForOpaque);
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "The player is retrying, and when the retry is complete, player will be sought to: " + j3 + " with mode:" + i3);
            return;
        }
        this.mPlayer.seekToAsync(j3, i3, assignUniqueIdForOpaque);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3) throws IllegalStateException, IllegalArgumentException, UnsupportedOperationException {
        switchDataSourceAsync(iTPMediaAsset, i3, -1L);
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void switchDataSourceAsync(@NonNull ITPMediaAsset iTPMediaAsset, int i3, long j3) throws IllegalStateException, IllegalArgumentException {
        long assignUniqueIdForOpaque = assignUniqueIdForOpaque(j3);
        this.mRuntimeParams.onSwitchDataSource(iTPMediaAsset, i3, assignUniqueIdForOpaque);
        this.mInputParams.onSwitchDataSource(iTPMediaAsset, i3, assignUniqueIdForOpaque);
        if (this.mRuntimeParams.isRetrying()) {
            TPLogUtil.i(this.mTPContext.getLogTag(), "The player is retrying, and when the retry is complete, player will be switched dataSource to: " + iTPMediaAsset);
            return;
        }
        this.mPlayer.switchDataSourceAsync(iTPMediaAsset, i3, assignUniqueIdForOpaque);
    }

    @Override // com.tencent.thumbplayer.impl.ITPInnerPlayer, com.tencent.thumbplayer.api.player.ITPPlayer
    public void setOnStopAsyncCompleteListener(ITPPlayerListener.IOnStopAsyncCompleteListener iOnStopAsyncCompleteListener) {
    }

    @Override // com.tencent.thumbplayer.api.player.ITPPlayer
    public void reopenPlayer(int i3, boolean z16) {
        TPLogUtil.i(this.mTPContext.getLogTag(), "reopenPlayer, enableAccurateStartPosition: " + z16 + ", state: " + TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState()));
        if (!this.mTPContext.getStateQuerier().isInStates(0, 1)) {
            updateRuntimeParamsBeforeRetry(this.mPlayer.getCurrentPositionMs());
            if (this.mPlayer.getPlayerCoreType() == i3) {
                this.mPlayer.reset();
            } else {
                ITPInnerPlayer choosePlayerCoreForTargetType = this.mPlayerCoreChooser.choosePlayerCoreForTargetType(i3);
                if (choosePlayerCoreForTargetType == null) {
                    return;
                }
                this.mPlayer.reset();
                this.mPlayer.release();
                this.mPlayer = choosePlayerCoreForTargetType;
            }
            setupPlayerBeforePrepare(this.mPlayer);
            reparametrizeOnRetryBegin(this.mPlayer, z16);
            try {
                this.mPlayer.prepareAsync();
                this.mRuntimeParams.setRetrying(true);
                this.mPlayerListeners.onInfo(this, 50000, new TPOnInfoParam.Builder().setLongParam(this.mPlayer.getPlayerCoreType(), this.mPlayer.getPlayerCoreType()).build());
                this.mPlayerListeners.onInfo(this, 200, null);
                return;
            } catch (Exception e16) {
                TPLogUtil.e(this.mTPContext.getLogTag(), "reopen player failed, exception:" + e16);
                handleOnError(new TPError(TPErrorCode.TP_ERROR_CODE_GENERAL_UNMATCHED_STATE));
                return;
            }
        }
        TPLogUtil.e(this.mTPContext.getLogTag(), "reopenPlayer, invalid state:" + TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState()));
        throw new IllegalStateException(String.format("invalid state:%s", TPPlayerStateToString.getStateName(this.mTPContext.getStateQuerier().getCurrentState())));
    }
}

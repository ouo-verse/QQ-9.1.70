package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKOnFunctionCompleteListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseInterruptFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKMediaSourceControllerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.TVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.qqlive.tvkplayer.tools.log.TVKLogger;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
public abstract class TVKBaseUniversalInterruptFunction extends TVKBaseInterruptFunction {
    protected static final String API_CALL_PREFIX = "api call: ";

    @NonNull
    protected static final Method sTakeOverMethodGetAvailablePositionMs;

    @NonNull
    protected static final Method sTakeOverMethodGetCurrentPosition;

    @NonNull
    protected static final Method sTakeOverMethodOnPrepared;

    @NonNull
    protected static final Method sTakeOverMethodPause;

    @NonNull
    protected static final Method sTakeOverMethodPrepare;

    @NonNull
    protected static final Method sTakeOverMethodStart;
    protected final TVKQQLiveAssetPlayerContext mAssetPlayerContext;
    protected ITVKMediaSourceController mAssetRequester;

    @Nullable
    protected Object[] mCurrentTriggerArgArray;
    protected Method mCurrentTriggerMethod;
    protected final ITVKLogger mLogger;
    protected ITVKOnFunctionCompleteListener mOnFunctionCompleteListener;
    private boolean mHasInterruptCGIFinished = false;
    private boolean mHasSendBufferStartMsg = false;
    protected volatile int mRequestId = -1;
    protected ITVKMediaSourceListener mMediaSourceListener = new MediaSourceListener();

    /* compiled from: P */
    /* loaded from: classes23.dex */
    protected class MediaSourceListener implements ITVKMediaSourceListener {
        protected MediaSourceListener() {
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
        public void onFailure(int i3, ITVKAsset iTVKAsset, @NonNull TVKError tVKError) {
            TVKBaseUniversalInterruptFunction.this.mLogger.error("onFailure() called with: requestId = [" + i3 + "], errorInfo = [" + tVKError + "]", new Object[0]);
            if (TVKBaseUniversalInterruptFunction.this.mRequestId == i3) {
                TVKBaseUniversalInterruptFunction.this.mHasInterruptCGIFinished = true;
                TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getPlayerSharedOperator().processError(tVKError);
                TVKBaseUniversalInterruptFunction tVKBaseUniversalInterruptFunction = TVKBaseUniversalInterruptFunction.this;
                tVKBaseUniversalInterruptFunction.mOnFunctionCompleteListener.onComplete(tVKBaseUniversalInterruptFunction);
                return;
            }
            TVKBaseUniversalInterruptFunction.this.mLogger.warn("onFailure, not same request, mRequestId=" + TVKBaseUniversalInterruptFunction.this.mRequestId + " requestId=" + i3, new Object[0]);
        }

        @Override // com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceListener
        public void onSuccess(int i3, ITVKAsset iTVKAsset, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
            if (TVKBaseUniversalInterruptFunction.this.mRequestId != i3) {
                TVKBaseUniversalInterruptFunction.this.mLogger.warn("onSuccess, not same request, mRequestId=" + TVKBaseUniversalInterruptFunction.this.mRequestId + " requestId=" + i3, new Object[0]);
                return;
            }
            TVKBaseUniversalInterruptFunction.this.mLogger.info("onSuccess() called with: requestId = [" + i3 + "], mediaAsset = [" + iTPMediaAsset + "], netVideoInfo = [" + tVKNetVideoInfo + "]", new Object[0]);
            if (!iTPMediaAsset.isValid()) {
                TVKBaseUniversalInterruptFunction.this.mLogger.error("CGI onSuccess, mediaAsset invalid!", new Object[0]);
                TVKBaseUniversalInterruptFunction.this.processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
                return;
            }
            TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getRuntimeParam().setTPMediaAsset(iTPMediaAsset);
            TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getPlayerSharedOperator().processCGIRequestSuccess(tVKNetVideoInfo);
            TVKBaseUniversalInterruptFunction.this.mHasInterruptCGIFinished = true;
            TVKPlayerState state = TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getState();
            ITVKPlayerState.STATE state2 = ITVKPlayerState.STATE.CGIED;
            if (state.less(state2)) {
                TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getState().changeState(state2);
                ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getAssetPlayerListener();
                if (assetPlayerListener != null) {
                    assetPlayerListener.onVideoCGIed(tVKNetVideoInfo);
                    return;
                }
                return;
            }
            if (TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getState().is(state2)) {
                TVKBaseUniversalInterruptFunction.this.mLogger.info("onSuccess, state is CGIED, return", new Object[0]);
            } else {
                TVKBaseUniversalInterruptFunction.this.mAssetPlayerContext.getPlayerSharedOperator().setupPlayerAndPrepareAsync(iTPMediaAsset, true);
                TVKBaseUniversalInterruptFunction.this.processWhenPlayerPrepareAsync();
            }
        }
    }

    static {
        try {
            sTakeOverMethodGetCurrentPosition = TVKQQLiveAssetPlayer.class.getMethod("getCurrentPosition", new Class[0]);
            sTakeOverMethodStart = TVKQQLiveAssetPlayer.class.getMethod("start", new Class[0]);
            sTakeOverMethodPause = TVKQQLiveAssetPlayer.class.getMethod("pause", new Class[0]);
            sTakeOverMethodOnPrepared = TVKQQLiveAssetPlayer.class.getMethod("onPrepared", new Class[0]);
            sTakeOverMethodPrepare = TVKQQLiveAssetPlayer.class.getMethod("prepare", new Class[0]);
            sTakeOverMethodGetAvailablePositionMs = TVKQQLiveAssetPlayer.class.getMethod("getAvailablePositionMs", new Class[0]);
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method! please fix me", e16);
        }
    }

    public TVKBaseUniversalInterruptFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull String str) {
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        this.mLogger = new TVKLogger(tVKQQLiveAssetPlayerContext, str);
    }

    private void cancelAssetRequestIfExist() {
        if (this.mAssetRequester != null && this.mRequestId != -1) {
            this.mLogger.info("cancelAssetRequestIfExist, mRequestId:" + this.mRequestId, new Object[0]);
            this.mAssetRequester.cancelRequest(this.mRequestId);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void cancel() {
        cancelAssetRequestIfExist();
        this.mAssetPlayerContext.getPlayerSharedOperator().stopAndResetPlayer();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getAvailablePositionMs() {
        return this.mAssetPlayerContext.getRuntimeParam().getLastPositionMs();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long getCurrentPosition() {
        if (this.mAssetPlayerContext.getState().less(ITVKPlayerState.STATE.STARTED)) {
            return this.mAssetPlayerContext.getRuntimeParam().getStartPositionMs();
        }
        return this.mAssetPlayerContext.getRuntimeParam().getLastPositionMs();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object[] getCurrentTriggerArgs() {
        return this.mCurrentTriggerArgArray;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Method getCurrentTriggerMethod() {
        return this.mCurrentTriggerMethod;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public int getTargetAssetType() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyBufferEnd(boolean z16) {
        long j3;
        if (this.mHasSendBufferStartMsg) {
            if (z16) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            notifyInfoMsg(113, j3, 0L, null);
            this.mHasSendBufferStartMsg = false;
            this.mLogger.info("notify buffering end!", new Object[0]);
            return;
        }
        this.mLogger.warn("can not notify buffer end cause not send buffer start", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyBufferStart(boolean z16) {
        long j3;
        if (this.mAssetPlayerContext.getState().is(ITVKPlayerState.STATE.STARTED)) {
            if (z16) {
                j3 = 1;
            } else {
                j3 = 0;
            }
            notifyInfoMsg(112, j3, 0L, null);
            this.mHasSendBufferStartMsg = true;
            this.mLogger.info("notify buffering start!", new Object[0]);
            return;
        }
        this.mLogger.warn("can not notify buffer start in state=" + this.mAssetPlayerContext.getState().state(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void notifyInfoMsg(int i3, long j3, long j16, @Nullable Object obj) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener != null) {
            this.mLogger.info("notify info msg, what=" + i3, new Object[0]);
            assetPlayerListener.onInfo(i3, j3, j16, obj);
            return;
        }
        this.mLogger.warn("can not send msg.what=" + i3 + " cause assetPlayerListener is null", new Object[0]);
    }

    protected void notifyOnPrepared() {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener == null) {
            this.mLogger.error("assetPlayerListener == null, cannot notify onPrepared", new Object[0]);
        } else {
            assetPlayerListener.onVideoPrepared();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPrepared() {
        this.mLogger.info("onPrepared!", new Object[0]);
        this.mAssetPlayerContext.getPlayerSharedOperator().preprocessWhenPlayerPrepared();
        processWhenPlayerOnPrepared();
        TVKPlayerState state = this.mAssetPlayerContext.getState();
        ITVKPlayerState.STATE state2 = ITVKPlayerState.STATE.PREPARED;
        if (state.less(state2)) {
            state.changeState(state2);
            notifyOnPrepared();
        } else if (state.is(ITVKPlayerState.STATE.STARTED)) {
            try {
                this.mLogger.info("onPrepared, call player.start", new Object[0]);
                this.mAssetPlayerContext.getPlayer().start();
            } catch (IllegalStateException e16) {
                this.mLogger.error("catching a IllegalStateException during start", new Object[0]);
                this.mLogger.printException(e16);
                processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
                return;
            }
        } else if (!state.is(ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.warn("unhandled state in onPrepared, state=" + state.state(), new Object[0]);
        }
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void pause() {
        this.mLogger.info("api call: pause", new Object[0]);
        TVKPlayerState state = this.mAssetPlayerContext.getState();
        ITVKPlayerState.STATE state2 = ITVKPlayerState.STATE.PAUSED;
        if (state.is(ITVKPlayerState.STATE.STARTED, state2, ITVKPlayerState.STATE.COMPLETE)) {
            this.mAssetPlayerContext.getState().changeState(state2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void prepare() {
        if (this.mAssetPlayerContext.getState().is(ITVKPlayerState.STATE.CGIED)) {
            this.mAssetPlayerContext.getState().changeState(ITVKPlayerState.STATE.PREPARING);
            if (this.mHasInterruptCGIFinished) {
                this.mAssetPlayerContext.getPlayerSharedOperator().setupPlayerAndPrepareAsync(this.mAssetPlayerContext.getRuntimeParam().getTPMediaAsset(), true);
                processWhenPlayerPrepareAsync();
                return;
            }
            return;
        }
        this.mLogger.error("api call: prepare, should not call prepare in state=" + this.mAssetPlayerContext.getState().state(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processPlayerErrorAndFinishFunction(TVKError tVKError) {
        this.mAssetPlayerContext.getPlayerSharedOperator().processError(tVKError);
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    protected abstract void processWhenPlayerOnPrepared();

    protected abstract void processWhenPlayerPrepareAsync();

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestNetVideoInfoToRebootPlayer(String str) {
        requestNetVideoInfoToRebootPlayer(str, false);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void reset() {
        this.mHasInterruptCGIFinished = false;
        this.mHasSendBufferStartMsg = false;
        this.mRequestId = -1;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void setOnCompleteListener(ITVKOnFunctionCompleteListener iTVKOnFunctionCompleteListener) {
        this.mOnFunctionCompleteListener = iTVKOnFunctionCompleteListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void start() {
        this.mLogger.info("api call: start", new Object[0]);
        TVKPlayerState state = this.mAssetPlayerContext.getState();
        ITVKPlayerState.STATE state2 = ITVKPlayerState.STATE.STARTED;
        if (state.is(ITVKPlayerState.STATE.PREPARED, state2, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE)) {
            this.mAssetPlayerContext.getState().changeState(state2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestNetVideoInfoToRebootPlayer(String str, boolean z16) {
        cancelAssetRequestIfExist();
        TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext = this.mAssetPlayerContext;
        ITVKMediaSourceController createMediaSourceController = TVKMediaSourceControllerFactory.createMediaSourceController(tVKQQLiveAssetPlayerContext, tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper(), this.mMediaSourceListener);
        this.mAssetRequester = createMediaSourceController;
        if (createMediaSourceController == null) {
            this.mLogger.error("failed to create media source controller", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        this.mRequestId = this.mAssetRequester.requestNetVideoInfo(new TVKCGIRequestParam.Builder(inputParam.getPlayerVideoInfo(), this.mAssetPlayerContext.getRuntimeParam().getTVKAsset(), inputParam.getUserInfo()).definition(str).streamFormatId(TVKFormatIDChooser.chooseFormatID(inputParam.getPlayerVideoInfo())).flowId(inputParam.getFlowId()).isUserSwitchDefinitionOrAudioTrack(z16).build(), this.mAssetPlayerContext.getFeatureGroup(), TVKFeatureFactory.createFeatureParamGroup(inputParam, this.mAssetPlayerContext.getRuntimeParam()));
        notifyInfoMsg(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, 0L, 0L, null);
    }
}

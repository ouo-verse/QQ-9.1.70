package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureExtraParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKMediaSourceControllerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.baseinfo.TVKCommParams;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIParamsBuildHelper;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKUniversalRefreshPlayerFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String CB_CALL_PREFIX = "player call: ";
    private static final String MODULE_NAME = "RefreshPlayerFunction";
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodRefreshPlayer;
    private ITVKMediaSourceController mAssetRequester;

    @Nullable
    private Object[] mCurrentTriggerArgArray;
    private Method mCurrentTriggerMethod;
    private volatile int mRequestId;

    static {
        try {
            sTriggerMethodRefreshPlayer = TVKQQLiveAssetPlayer.class.getMethod("refreshPlayer", new Class[0]);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method, please fix this problem(rename method)", e16);
        }
    }

    public TVKUniversalRefreshPlayerFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        this.mRequestId = -1;
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodRefreshPlayer, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.r
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKUniversalRefreshPlayerFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.s
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKUniversalRefreshPlayerFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        return arrayList;
    }

    private void cancelAssetRequestIfExist() {
        if (this.mAssetRequester != null && this.mRequestId != -1) {
            this.mLogger.info("cancelAssetRequestIfExist, mRequestId:" + this.mRequestId, new Object[0]);
            this.mAssetRequester.cancelRequest(this.mRequestId);
        }
    }

    private boolean isValidParam(ITVKAsset iTVKAsset, TVKNetVideoInfo tVKNetVideoInfo) {
        if (!TVKAssetUtils.isQQLiveAsset(iTVKAsset)) {
            this.mLogger.warn("player call: onInfo, playerVideoInfo is null or not live vod play", new Object[0]);
            return false;
        }
        if (tVKNetVideoInfo == null) {
            this.mLogger.warn("player call: onInfo, netVideoInfo is null", new Object[0]);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    private void notifyInfoMsg(int i3, @Nullable Object obj) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener != null) {
            assetPlayerListener.onInfo(i3, 0L, 0L, obj);
            return;
        }
        this.mLogger.warn("can not send msg.what=" + i3 + " cause assetPlayerListener is null", new Object[0]);
    }

    private void refreshPlayer() {
        String definition;
        this.mLogger.info("player call: refresh player start.", new Object[0]);
        if (!TextUtils.isEmpty(TVKCommParams.getOriginalUpc())) {
            this.mLogger.info("currently under free flow and pause download", new Object[0]);
            this.mAssetPlayerContext.getPlayer().pauseDownload();
        }
        notifyInfoMsg(528, null);
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo != null) {
            definition = netVideoInfo.getCurDefinition().getDefn();
        } else {
            definition = this.mAssetPlayerContext.getInputParam().getDefinition();
        }
        requestNetVideoInfo(definition);
    }

    private void requestNetVideoInfo(String str) {
        cancelAssetRequestIfExist();
        TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext = this.mAssetPlayerContext;
        ITVKMediaSourceController createMediaSourceController = TVKMediaSourceControllerFactory.createMediaSourceController(tVKQQLiveAssetPlayerContext, tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper(), this.mMediaSourceListener);
        this.mAssetRequester = createMediaSourceController;
        if (createMediaSourceController == null) {
            this.mLogger.warn("createQQLiveRequester return null, return", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        this.mRequestId = this.mAssetRequester.requestNetVideoInfo(new TVKCGIRequestParam.Builder(inputParam.getPlayerVideoInfo(), this.mAssetPlayerContext.getRuntimeParam().getTVKAsset(), inputParam.getUserInfo()).definition(str).streamFormatId(TVKFormatIDChooser.chooseFormatID(inputParam.getPlayerVideoInfo())).flowId(inputParam.getFlowId()).build(), this.mAssetPlayerContext.getFeatureGroup(), TVKFeatureFactory.createFeatureParamGroup(inputParam, this.mAssetPlayerContext.getRuntimeParam(), new TVKPlayerFeatureExtraParam.Builder().assetExpireRequestMap(TVKCGIParamsBuildHelper.buildVodExtTag2Param(this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo())).build()));
        notifyInfoMsg(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, null);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void cancel() {
        ITVKMediaSourceController iTVKMediaSourceController;
        this.mLogger.info("cancel function", new Object[0]);
        if (this.mRequestId != -1 && (iTVKMediaSourceController = this.mAssetRequester) != null) {
            iTVKMediaSourceController.cancelRequest(this.mRequestId);
        }
        this.mRequestId = -1;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        this.mAssetPlayerContext = tVKQQLiveAssetPlayerContext;
        if (!isValidParam(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset(), tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo())) {
            this.mOnFunctionCompleteListener.onComplete(this);
            return null;
        }
        refreshPlayer();
        return null;
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
    @NonNull
    public List<TVKMethodMatcher> getNotificationMatcherList() {
        return Collections.emptyList();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    @NonNull
    public List<TVKMethodMatcher> getTakeOverMethodMatcherList() {
        return Collections.emptyList();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public int getTargetAssetType() {
        return 0;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    @NonNull
    public List<TVKMethodMatcher> getTriggerMatcherList() throws IllegalStateException {
        return sTriggerMethodMatcherList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected void processOnNetVideoInfoFailure(int i3, @NonNull TVKError tVKError) {
        if (this.mRequestId != i3) {
            this.mLogger.error("onFailure, cancelled and return", new Object[0]);
            return;
        }
        this.mLogger.error("onFailure, requestId:" + i3 + ", errorModule:" + tVKError.getErrorModule() + ", errorCode:" + tVKError.getMainErrorCode(), new Object[0]);
        this.mAssetPlayerContext.getPlayerSharedOperator().processError(tVKError);
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected boolean processOnNetVideoInfoSuccess(int i3, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        if (this.mRequestId != i3) {
            this.mLogger.error("onSuccess, cancelled and return", new Object[0]);
            return false;
        }
        this.mLogger.info("CGI onSuccess, requestId:" + i3, new Object[0]);
        if (!iTPMediaAsset.isValid()) {
            this.mLogger.error("CGI onSuccess, mediaAsset invalid! current mediaAsset=" + iTPMediaAsset, new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
            return false;
        }
        this.mAssetPlayerContext.getPlayer().resumeDownload();
        try {
            this.mLogger.info("CGI onSuccess, player.refreshPlayer, switchDataSourceAsync, tpMediaAsset=" + iTPMediaAsset, new Object[0]);
            removeAndDeselectPreviousAddToCoreTrackFromVinfo();
            int[] addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes = addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes();
            if (addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes == null) {
                this.mAssetPlayerContext.getPlayer().switchDataSourceAsync(iTPMediaAsset, 4, -1L);
            } else {
                this.mAssetPlayerContext.getPlayer().switchDataSourceAndSelectTrackAsync(iTPMediaAsset, 4, addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes, -1000L);
            }
            this.mAssetPlayerContext.getRuntimeParam().setTPMediaAsset(iTPMediaAsset);
            this.mLogger.info("update tpMediaAsset success", new Object[0]);
            notifyInfoMsg(529, null);
            this.mOnFunctionCompleteListener.onComplete(this);
            return true;
        } catch (IllegalArgumentException e16) {
            this.mLogger.printException(e16);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return false;
        } catch (IllegalStateException e17) {
            this.mLogger.printException(e17);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_STATE_ERR));
            return false;
        } catch (UnsupportedOperationException e18) {
            this.mLogger.printException(e18);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_NOT_SUPPORT_ERR));
            return false;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        return null;
    }
}

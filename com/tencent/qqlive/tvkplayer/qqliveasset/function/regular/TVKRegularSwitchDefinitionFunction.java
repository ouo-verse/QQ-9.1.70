package com.tencent.qqlive.tvkplayer.qqliveasset.function.regular;

import android.text.TextUtils;
import android.util.SparseLongArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKMediaSourceControllerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.postprocessor.video.TVKVideoPostProcessor;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKPostProcessorStrategy;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRegularSwitchDefinitionFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String API_CALL = "api call: ";
    private static final String TAG = "TVKRegularSwitchDefinitionFunction";

    @NonNull
    private static final Method sTakeOverMethodOnInfo;

    @NonNull
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;

    @NonNull
    private static final Method sTriggerMethodSwitchDefinition;

    @NonNull
    private static final Method sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo;
    private ITVKMediaSourceController mAssetRequester;

    @Nullable
    private Object[] mCurrentTriggerArgArray;
    private Method mCurrentTriggerMethod;
    private final ITVKSwitchDispatcher mDefinitionSwitchDispatcher;
    private volatile int mRequestId;
    private final SparseLongArray mRequestIdToTaskIdMap;

    @NonNull
    private final List<TVKMethodMatcher> mTakeOverMethodMatcherList;

    static {
        try {
            sTriggerMethodSwitchDefinition = TVKQQLiveAssetPlayer.class.getMethod(QCircleLiveFeedsPlayerEvent.EVENT_SWITCH_DEFINITION, String.class);
            sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo = TVKQQLiveAssetPlayer.class.getMethod(QCircleLiveFeedsPlayerEvent.EVENT_SWITCH_DEFINITION, TVKUserInfo.class, TVKPlayerVideoInfo.class);
            sTakeOverMethodOnInfo = TVKQQLiveAssetPlayer.class.getMethod("onInfo", Integer.TYPE, TPOnInfoParam.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method! please fix me", e16);
        }
    }

    public TVKRegularSwitchDefinitionFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, TAG);
        ArrayList arrayList = new ArrayList();
        this.mTakeOverMethodMatcherList = arrayList;
        this.mRequestIdToTaskIdMap = new SparseLongArray();
        this.mRequestId = -1;
        this.mDefinitionSwitchDispatcher = tVKQQLiveAssetPlayerContext.getDefinitionSwitchDispatcher();
        arrayList.add(new TVKMethodMatcher(sTakeOverMethodOnInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.t
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext2, Object[] objArr) {
                boolean lambda$new$4;
                lambda$new$4 = TVKRegularSwitchDefinitionFunction.this.lambda$new$4(tVKQQLiveAssetPlayerContext2, objArr);
                return lambda$new$4;
            }
        }, null));
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSwitchDefinition, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.p
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKRegularSwitchDefinitionFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.q
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKRegularSwitchDefinitionFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.r
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$2;
                lambda$buildTriggerMethodMatchers$2 = TVKRegularSwitchDefinitionFunction.lambda$buildTriggerMethodMatchers$2(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$2;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.s
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$3;
                lambda$buildTriggerMethodMatchers$3 = TVKRegularSwitchDefinitionFunction.lambda$buildTriggerMethodMatchers$3(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$3;
            }
        }));
        return arrayList;
    }

    private void cancelAssetRequestIfExist() {
        if (this.mAssetRequester != null && this.mRequestId != -1) {
            this.mLogger.info("cancelAssetRequestIfExist, mRequestId:" + this.mRequestId, new Object[0]);
            this.mAssetRequester.cancelRequest(this.mRequestId);
            this.mRequestId = -1;
        }
    }

    private void dealAvsSeparateSwitchAudioTrackMsg() {
        String audioTrack;
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo.getCurAudioTrack() == null) {
            audioTrack = "";
        } else {
            audioTrack = netVideoInfo.getCurAudioTrack().getAudioTrack();
        }
        if (this.mAssetPlayerContext.getRuntimeParam().isAvsSeparateDolbyAudioTrackSwitching() && TVKNetVideoInfo.AUDIO_TRACK_DOLBY.equalsIgnoreCase(audioTrack)) {
            this.mLogger.info("onInfo, dealSwitchAudioTrackMsg, switching avs separate db audiotrack and need notify PLAYER_INFO_SWITCH_AUDIOTRACK_DONE", new Object[0]);
            this.mAssetPlayerContext.getRuntimeParam().setAvsSeparateDolbyAudioTrackSwitching(false);
            notifyOnInfoMessage(126, 0L, 0L, netVideoInfo.getCurAudioTrack().getAudioShowName());
        }
    }

    private void dealPostProcessForSwitchDefinition() {
        TVKPlayerRuntimeParam runtimeParam = this.mAssetPlayerContext.getRuntimeParam();
        TVKVideoPostProcessor videoPostProcessor = this.mAssetPlayerContext.getVideoPostProcessor();
        boolean isSupportVideoProcessor = TVKPostProcessorStrategy.isSupportVideoProcessor(runtimeParam.getNetVideoInfo(), this.mAssetPlayerContext.getCurrentPlayerFeatureList());
        boolean isNeedConnectVideoProcessor = TVKPostProcessorStrategy.isNeedConnectVideoProcessor(runtimeParam, this.mAssetPlayerContext.getCurrentPlayerFeatureList());
        if (videoPostProcessor.isPostProcessorConnected() && !isSupportVideoProcessor) {
            this.mLogger.info("dealPostProcessorForSwitchDefinition, Monet closed by source is HDR10 or DRM", new Object[0]);
            if (videoPostProcessor.isSDREnhanceEnabled()) {
                notifyOnInfoMessage(74, 0L, 0L, null);
            } else if (videoPostProcessor.isBlindnessEnabled()) {
                notifyOnInfoMessage(75, 0L, 0L, null);
            }
            videoPostProcessor.reset();
            return;
        }
        if (isNeedConnectVideoProcessor) {
            this.mLogger.info("dealPostProcessorForSwitchDefinition, video post processor is need to connect", new Object[0]);
            boolean isNeedSDREnhance = runtimeParam.isNeedSDREnhance();
            boolean isNeedSuperResolution = runtimeParam.isNeedSuperResolution();
            this.mLogger.info("connectVideoPostProcessor, needSDREnhance = " + isNeedSDREnhance + ", needSuperResolution =" + isNeedSuperResolution, new Object[0]);
            if (isNeedSDREnhance) {
                videoPostProcessor.addSDREnhanceEffect();
            }
            if (isNeedSuperResolution) {
                videoPostProcessor.addSuperResolutionEffect();
            }
            boolean connectPostProcessor = videoPostProcessor.connectPostProcessor(runtimeParam.getVideoWidth(), runtimeParam.getVideoHeight());
            this.mLogger.info("connectPostProcessor success: " + connectPostProcessor, new Object[0]);
        }
    }

    private void handleAdaptiveDefinitionState() {
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        if (!inputParam.isAdaptiveDefinition()) {
            return;
        }
        inputParam.setAdaptiveDefinition(false);
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK, false));
        notifyOnInfoMessage(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE, 0L, 0L, Boolean.valueOf(inputParam.isAdaptiveDefinition()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        String str = (String) objArr[0];
        if (!TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset()) || TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$2(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        TVKPlayerVideoInfo tVKPlayerVideoInfo = (TVKPlayerVideoInfo) objArr[1];
        if (TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset()) && (tVKPlayerVideoInfo == null || !TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equalsIgnoreCase(tVKPlayerVideoInfo.getDefinition()))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$3(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED, ITVKPlayerState.STATE.COMPLETE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$4(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        TPOnInfoParam tPOnInfoParam;
        if (((Integer) objArr[0]).intValue() != 3 || (tPOnInfoParam = (TPOnInfoParam) objArr[1]) == null) {
            return false;
        }
        ITVKSwitchDispatcher.Ret queryTaskByTaskId = this.mDefinitionSwitchDispatcher.queryTaskByTaskId(tPOnInfoParam.getLongParam1());
        if (queryTaskByTaskId.retCode == 2 || queryTaskByTaskId.type != 0) {
            return false;
        }
        return true;
    }

    private void notifyOnInfoMessage(int i3, long j3, long j16, Object obj) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener == null) {
            this.mLogger.error("assetPlayerListener is null, can not notify onInfo", new Object[0]);
            return;
        }
        this.mLogger.info("notify onInfo msg, what=" + i3, new Object[0]);
        assetPlayerListener.onInfo(i3, j3, j16, obj);
    }

    private void onInfo(TPOnInfoParam tPOnInfoParam) {
        ITVKSwitchDispatcher.Ret driveTaskWhenPlayerSuccess = this.mDefinitionSwitchDispatcher.driveTaskWhenPlayerSuccess(tPOnInfoParam.getLongParam1());
        if (driveTaskWhenPlayerSuccess.retCode == 0) {
            notifyOnInfoMessage(111, 1L, 0L, null);
            this.mLogger.info("onInfo, switch definition success", new Object[0]);
            dealAvsSeparateSwitchAudioTrackMsg();
            this.mOnFunctionCompleteListener.onComplete(this);
            return;
        }
        this.mLogger.warn("onInfo, driveTaskWhenPlayerSuccess, retCode=" + driveTaskWhenPlayerSuccess.retCode, new Object[0]);
    }

    private void requestNetVideoInfo(@NonNull String str) {
        ITVKSwitchDispatcher.Ret addTask = this.mDefinitionSwitchDispatcher.addTask(new ITVKSwitchDispatcher.SwitchInfo.Builder().definition(str).taskName(TVKUtils.getMd5(TVKUtils.generateMapPairStringByAnd(this.mAssetPlayerContext.getInputParam().getPlayerVideoInfo().getExtraRequestParamsMap()) + str)).defnSwitchType(0).build());
        if (addTask.retCode != 0) {
            this.mLogger.info("addTask ret.retCode != OK, retCode=" + addTask.retCode, new Object[0]);
            return;
        }
        cancelAssetRequestIfExist();
        TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext = this.mAssetPlayerContext;
        ITVKMediaSourceController createMediaSourceController = TVKMediaSourceControllerFactory.createMediaSourceController(tVKQQLiveAssetPlayerContext, tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper(), this.mMediaSourceListener);
        this.mAssetRequester = createMediaSourceController;
        if (createMediaSourceController == null) {
            this.mLogger.warn("createQQLiveRequester return null, return", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        notifyOnInfoMessage(522, 1L, 0L, null);
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        inputParam.setDefinition(str);
        this.mRequestId = this.mAssetRequester.requestNetVideoInfo(new TVKCGIRequestParam.Builder(inputParam.getPlayerVideoInfo(), this.mAssetPlayerContext.getRuntimeParam().getTVKAsset(), inputParam.getUserInfo()).definition(str).flowId(inputParam.getFlowId()).streamFormatId(TVKFormatIDChooser.chooseFormatID(inputParam.getPlayerVideoInfo())).isUserSwitchDefinitionOrAudioTrack(true).build(), this.mAssetPlayerContext.getFeatureGroup(), TVKFeatureFactory.createFeatureParamGroup(inputParam, this.mAssetPlayerContext.getRuntimeParam()));
        this.mRequestIdToTaskIdMap.put(this.mRequestId, addTask.taskId);
        notifyOnInfoMessage(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, 0L, 0L, null);
        this.mLogger.info("requestNetVideoInfo, definition:" + str + ", mRequestId=" + this.mRequestId, new Object[0]);
    }

    private void switchDefinition(String str) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str)) {
            this.mLogger.info("api call: switchDefinition, definition=" + str, new Object[0]);
            handleAdaptiveDefinitionState();
            requestNetVideoInfo(str);
            return;
        }
        this.mLogger.error("api call: switch definition with empty definition arg, return", new Object[0]);
        throw new IllegalArgumentException("switchDefinition, definition can not be empty");
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void cancel() {
        cancelAssetRequestIfExist();
        this.mDefinitionSwitchDispatcher.clear();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodSwitchDefinition, method)) {
            switchDefinition((String) objArr[0]);
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo, method)) {
            switchDefinition((TVKUserInfo) objArr[0], (TVKPlayerVideoInfo) objArr[1]);
            return null;
        }
        this.mOnFunctionCompleteListener.onComplete(this);
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
        return this.mTakeOverMethodMatcherList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public int getTargetAssetType() {
        return 2;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    @NonNull
    public List<TVKMethodMatcher> getTriggerMatcherList() throws IllegalStateException {
        return sTriggerMethodMatcherList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected void processOnNetVideoInfoFailure(int i3, @NonNull TVKError tVKError) {
        this.mLogger.warn("CGI onFailure, requestId=" + i3, new Object[0]);
        ITVKSwitchDispatcher.Ret driveTaskWhenCGIFailed = this.mDefinitionSwitchDispatcher.driveTaskWhenCGIFailed(this.mRequestIdToTaskIdMap.get(i3));
        if (driveTaskWhenCGIFailed.retCode != 0) {
            this.mLogger.info("CGI onFailure, driveTaskWhenCGIFailed, retCode=" + driveTaskWhenCGIFailed.retCode, new Object[0]);
            return;
        }
        this.mAssetPlayerContext.getPlayerSharedOperator().processError(tVKError);
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected boolean processOnNetVideoInfoSuccess(int i3, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        this.mLogger.info("CGI onSuccess, requestId=" + i3, new Object[0]);
        ITVKSwitchDispatcher.Ret driveTaskWhenCGISuccess = this.mDefinitionSwitchDispatcher.driveTaskWhenCGISuccess(this.mRequestIdToTaskIdMap.get(i3));
        if (driveTaskWhenCGISuccess.retCode != 0) {
            this.mLogger.warn("CGI onSuccess, driveTaskWhenCGISuccess, retCode=" + driveTaskWhenCGISuccess.retCode, new Object[0]);
            return false;
        }
        if (!iTPMediaAsset.isValid()) {
            this.mLogger.error("CGI onSuccess, mediaAsset invalid! do not switch definition", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
            return false;
        }
        dealPostProcessForSwitchDefinition();
        this.mLogger.info("CGI onSuccess, driveTaskWhenCGISuccess, retCode == RET_OK", new Object[0]);
        try {
            notifyOnInfoMessage(523, 1L, 0L, null);
            this.mLogger.info("CGI onSuccess, player.switchDefinition, taskID=" + driveTaskWhenCGISuccess.taskId + ", tpMediaAsset=" + iTPMediaAsset, new Object[0]);
            removeAndDeselectPreviousAddToCoreTrackFromVinfo();
            int[] addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes = addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes();
            if (addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes == null) {
                this.mAssetPlayerContext.getPlayer().switchDataSourceAsync(iTPMediaAsset, 2, driveTaskWhenCGISuccess.taskId);
            } else {
                this.mAssetPlayerContext.getPlayer().switchDataSourceAndSelectTrackAsync(iTPMediaAsset, 2, addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes, driveTaskWhenCGISuccess.taskId);
            }
            this.mAssetPlayerContext.getRuntimeParam().setTPMediaAsset(iTPMediaAsset);
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
        if (TVKMethodMatcher.isSameMethod(sTakeOverMethodOnInfo, method)) {
            onInfo((TPOnInfoParam) objArr[1]);
        }
        return null;
    }

    private void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) throws IllegalArgumentException {
        if (tVKPlayerVideoInfo != null) {
            String definition = tVKPlayerVideoInfo.getDefinition();
            if (!TextUtils.isEmpty(definition)) {
                this.mLogger.info("api call: switchDefinition with userInfo and playerVideoInfo, definition=" + definition, new Object[0]);
                TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
                inputParam.setUserInfo(tVKUserInfo);
                inputParam.setPlayerVideoInfo(tVKPlayerVideoInfo);
                this.mAssetPlayerContext.getRuntimeParam().setTVKAsset(tVKPlayerVideoInfo.getAsset());
                handleAdaptiveDefinitionState();
                requestNetVideoInfo(definition);
                return;
            }
            this.mLogger.error("api call: switch definition with empty definition arg, return", new Object[0]);
            throw new IllegalArgumentException("switchDefinition, definition can not be empty");
        }
        this.mLogger.error("api call: switch definition with null video info", new Object[0]);
        throw new IllegalArgumentException("switchDefinition, video info can not be null");
    }
}

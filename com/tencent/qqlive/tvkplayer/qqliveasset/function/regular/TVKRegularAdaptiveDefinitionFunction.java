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
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKMediaSourceControllerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKDefinitionUtils;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.tpplayer.tools.TVKTPCapability;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalID;
import com.tencent.thumbplayer.api.optionalparam.TPOptionalParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRegularAdaptiveDefinitionFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String API_CALL = "api call: ";
    private static final String TAG = "TVKRegularAdaptiveDefinitionFunction";

    @NonNull
    private static final Method sTakeOverMethodOnInfo;

    @NonNull
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;

    @NonNull
    private static final Method sTriggerMethodOnInfo;

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
            Class cls = Integer.TYPE;
            sTriggerMethodOnInfo = TVKQQLiveAssetPlayer.class.getMethod("onInfo", cls, TPOnInfoParam.class);
            sTakeOverMethodOnInfo = TVKQQLiveAssetPlayer.class.getMethod("onInfo", cls, TPOnInfoParam.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method! please fix me", e16);
        }
    }

    public TVKRegularAdaptiveDefinitionFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, TAG);
        ArrayList arrayList = new ArrayList();
        this.mTakeOverMethodMatcherList = arrayList;
        this.mRequestIdToTaskIdMap = new SparseLongArray();
        this.mRequestId = -1;
        this.mDefinitionSwitchDispatcher = tVKQQLiveAssetPlayerContext.getDefinitionSwitchDispatcher();
        arrayList.add(new TVKMethodMatcher(sTakeOverMethodOnInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.a
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext2, Object[] objArr) {
                boolean lambda$new$6;
                lambda$new$6 = TVKRegularAdaptiveDefinitionFunction.this.lambda$new$6(tVKQQLiveAssetPlayerContext2, objArr);
                return lambda$new$6;
            }
        }, null));
    }

    private void adaptiveSwitchDefinition(long j3) {
        if (!this.mAssetPlayerContext.getInputParam().isAdaptiveDefinition()) {
            this.mOnFunctionCompleteListener.onComplete(this);
            this.mLogger.warn("adaptiveSwitchDefinition, currently not in adaptive definition mode", new Object[0]);
            return;
        }
        if (!TVKTPCapability.isAdaptiveSwitchDefinitionSupported(this.mAssetPlayerContext.getContext())) {
            this.mLogger.warn("handleSwitchDefinitionSelfAdaption, currently not support adaptive switch definition", new Object[0]);
            return;
        }
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo == null) {
            this.mOnFunctionCompleteListener.onComplete(this);
            this.mLogger.warn("adaptiveSwitchDefinition, netVideoInfo is empty", new Object[0]);
            return;
        }
        String suggestDefinition = getSuggestDefinition(j3, TVKDefinitionUtils.getSortedDefnInfoList(netVideoInfo.getDefinitionList()));
        if (TextUtils.isEmpty(suggestDefinition)) {
            this.mOnFunctionCompleteListener.onComplete(this);
            this.mLogger.warn("adaptiveSwitchDefinition, def is null", new Object[0]);
            return;
        }
        this.mLogger.info("adaptiveSwitchDefinition, switch to:" + suggestDefinition, new Object[0]);
        requestNetVideoInfo(suggestDefinition);
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSwitchDefinition, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.b
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKRegularAdaptiveDefinitionFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.c
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKRegularAdaptiveDefinitionFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.d
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$2;
                lambda$buildTriggerMethodMatchers$2 = TVKRegularAdaptiveDefinitionFunction.lambda$buildTriggerMethodMatchers$2(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$2;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.e
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$3;
                lambda$buildTriggerMethodMatchers$3 = TVKRegularAdaptiveDefinitionFunction.lambda$buildTriggerMethodMatchers$3(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$3;
            }
        }));
        arrayList.add(new TVKMethodMatcher(sTriggerMethodOnInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.f
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$4;
                lambda$buildTriggerMethodMatchers$4 = TVKRegularAdaptiveDefinitionFunction.lambda$buildTriggerMethodMatchers$4(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$4;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.g
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$5;
                lambda$buildTriggerMethodMatchers$5 = TVKRegularAdaptiveDefinitionFunction.lambda$buildTriggerMethodMatchers$5(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$5;
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
            this.mLogger.info("onInfo, dealSwitchAudioTrackMsg, switching avs separate db audio track and need notify PLAYER_INFO_SWITCH_AUDIOTRACK_DONE", new Object[0]);
            this.mAssetPlayerContext.getRuntimeParam().setAvsSeparateDolbyAudioTrackSwitching(false);
            notifyOnInfoMessage(126, 0L, 0L, netVideoInfo.getCurAudioTrack().getAudioShowName());
        }
    }

    private String getSuggestDefinition(long j3, List<TVKNetVideoInfo.DefnInfo> list) {
        String str;
        if (list.isEmpty()) {
            this.mLogger.warn("sortedDefnList is empty", new Object[0]);
            return null;
        }
        boolean isVip = this.mAssetPlayerContext.getInputParam().getUserInfo().isVip();
        Iterator<TVKNetVideoInfo.DefnInfo> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                TVKNetVideoInfo.DefnInfo next = it.next();
                if (!next.isVipOnly() || isVip) {
                    if (j3 >= next.getVideoBandwidth() + next.getAudioBandwidth()) {
                        str = next.getDefn();
                        break;
                    }
                }
            } else {
                str = null;
                break;
            }
        }
        if (TextUtils.isEmpty(str)) {
            this.mLogger.warn("there is no playable definition, suggest bitrate: " + j3, new Object[0]);
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        String str = (String) objArr[0];
        if (!TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset()) || !TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$2(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        TVKPlayerVideoInfo tVKPlayerVideoInfo = (TVKPlayerVideoInfo) objArr[1];
        if (TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset()) && tVKPlayerVideoInfo != null && TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equalsIgnoreCase(tVKPlayerVideoInfo.getDefinition())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$3(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$4(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        if (((Integer) objArr[0]).intValue() != 80002) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$5(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$6(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
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
        } else {
            assetPlayerListener.onInfo(i3, j3, j16, obj);
        }
    }

    private void onInfo(int i3, TPOnInfoParam tPOnInfoParam) {
        long longParam1 = tPOnInfoParam.getLongParam1();
        ITVKSwitchDispatcher.Ret driveTaskWhenPlayerSuccess = this.mDefinitionSwitchDispatcher.driveTaskWhenPlayerSuccess(longParam1);
        if (driveTaskWhenPlayerSuccess.retCode != 0) {
            this.mLogger.warn("onInfo, driveTaskWhenPlayerSuccess, retCode=" + driveTaskWhenPlayerSuccess.retCode, new Object[0]);
            return;
        }
        this.mLogger.info("onInfo, adaptive switch definition success, opaque=" + longParam1, new Object[0]);
        notifyOnInfoMessage(512, 1L, 0L, null);
        dealAvsSeparateSwitchAudioTrackMsg();
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    private void requestNetVideoInfo(@NonNull String str) {
        ITVKSwitchDispatcher.Ret addTask = this.mDefinitionSwitchDispatcher.addTask(new ITVKSwitchDispatcher.SwitchInfo.Builder().definition(str).taskName(TVKUtils.getMd5(TVKUtils.generateMapPairStringByAnd(this.mAssetPlayerContext.getInputParam().getPlayerVideoInfo().getExtraRequestParamsMap()) + str)).defnSwitchType(1).build());
        if (addTask.retCode != 0) {
            this.mLogger.info("addTask ret.retCode != OK, retCode=" + addTask.retCode, new Object[0]);
            if (addTask.retCode != 1) {
                this.mOnFunctionCompleteListener.onComplete(this);
                return;
            }
            return;
        }
        if (str.equalsIgnoreCase(this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo().getCurDefinition().getDefn())) {
            this.mLogger.warn("def is same as curDefinition :" + str, new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
            return;
        }
        cancelAssetRequestIfExist();
        TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext = this.mAssetPlayerContext;
        ITVKMediaSourceController createMediaSourceController = TVKMediaSourceControllerFactory.createMediaSourceController(tVKQQLiveAssetPlayerContext, tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper(), this.mMediaSourceListener);
        this.mAssetRequester = createMediaSourceController;
        if (createMediaSourceController == null) {
            this.mLogger.warn("createQQLiveRequester return null, return", new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
            return;
        }
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        this.mRequestId = this.mAssetRequester.requestNetVideoInfo(new TVKCGIRequestParam.Builder(inputParam.getPlayerVideoInfo(), this.mAssetPlayerContext.getRuntimeParam().getTVKAsset(), inputParam.getUserInfo()).definition(str).flowId(inputParam.getFlowId()).streamFormatId(TVKFormatIDChooser.chooseFormatID(inputParam.getPlayerVideoInfo())).build(), this.mAssetPlayerContext.getFeatureGroup(), TVKFeatureFactory.createFeatureParamGroup(inputParam, this.mAssetPlayerContext.getRuntimeParam()));
        this.mRequestIdToTaskIdMap.put(this.mRequestId, addTask.taskId);
        notifyOnInfoMessage(511, 1L, 0L, null);
    }

    private void switchDefinition(String str) throws IllegalArgumentException {
        this.mLogger.info("api call: adaptiveSwitchDefinition, definition=" + str, new Object[0]);
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        if (!TVKTPCapability.isAdaptiveSwitchDefinitionSupported(this.mAssetPlayerContext.getContext())) {
            notifyOnInfoMessage(513, 0L, 0L, str);
            this.mOnFunctionCompleteListener.onComplete(this);
            return;
        }
        if (!inputParam.isAdaptiveDefinition()) {
            inputParam.setAdaptiveDefinition(true);
            this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_ENABLE_SUGGESTED_BITRATE_CALLBACK, true));
            notifyOnInfoMessage(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE, 0L, 0L, Boolean.valueOf(inputParam.isAdaptiveDefinition()));
            notifyOnInfoMessage(535, 0L, 0L, str);
        }
        this.mOnFunctionCompleteListener.onComplete(this);
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
            TVKPlayerVideoInfo tVKPlayerVideoInfo = (TVKPlayerVideoInfo) objArr[1];
            switchDefinition((TVKUserInfo) objArr[0], tVKPlayerVideoInfo, tVKPlayerVideoInfo.getDefinition());
            return null;
        }
        if (!tVKQQLiveAssetPlayerContext.getState().is(ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED)) {
            this.mLogger.warn("onInfo adaptiveSwitchDefinition, in illegal state=" + tVKQQLiveAssetPlayerContext.getState().state(), new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodOnInfo, method)) {
            adaptiveSwitchDefinition(((TPOnInfoParam) objArr[1]).getLongParam1());
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
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected boolean processOnNetVideoInfoSuccess(int i3, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        this.mLogger.info("CGI onSuccess, requestId=" + i3, new Object[0]);
        ITVKSwitchDispatcher.Ret driveTaskWhenCGISuccess = this.mDefinitionSwitchDispatcher.driveTaskWhenCGISuccess(this.mRequestIdToTaskIdMap.get(i3));
        if (driveTaskWhenCGISuccess.retCode != 0) {
            this.mLogger.warn("CGI onSuccess, driveTaskWhenCGISuccess, retCode=" + driveTaskWhenCGISuccess.retCode, new Object[0]);
            if (driveTaskWhenCGISuccess.retCode != 3) {
                this.mOnFunctionCompleteListener.onComplete(this);
            }
            return false;
        }
        if (!iTPMediaAsset.isValid()) {
            this.mLogger.error("CGI onSuccess, mediaSource invalid! do not switch definition", new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
            return false;
        }
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildLong("optional_id_global_long_adaptive_limit_bitrate_range_max", tVKNetVideoInfo.getMaxBitrate()));
        this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildLong(TPOptionalID.OPTIONAL_ID_GLOBAL_LONG_ADAPTIVE_LIMIT_BITRATE_RANGE_MIN, 0L));
        this.mLogger.info("CGI onSuccess, driveTaskWhenCGISuccess, retCode == RET_OK", new Object[0]);
        try {
            notifyOnInfoMessage(534, 1L, 0L, null);
            this.mLogger.info("CGI onSuccess, player.adaptiveSwitchDefinition, taskID=" + driveTaskWhenCGISuccess.taskId + ", tpMediaAsset=" + iTPMediaAsset, new Object[0]);
            removeAndDeselectPreviousAddToCoreTrackFromVinfo();
            int[] addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes = addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes();
            if (addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes == null) {
                this.mAssetPlayerContext.getPlayer().switchDataSourceAsync(iTPMediaAsset, 2, driveTaskWhenCGISuccess.taskId);
            } else {
                this.mAssetPlayerContext.getPlayer().switchDataSourceAndSelectTrackAsync(iTPMediaAsset, 2, addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes, driveTaskWhenCGISuccess.taskId);
            }
            this.mAssetPlayerContext.getRuntimeParam().setTPMediaAsset(iTPMediaAsset);
            return true;
        } catch (IllegalArgumentException | IllegalStateException | UnsupportedOperationException e16) {
            this.mLogger.printException(e16);
            this.mOnFunctionCompleteListener.onComplete(this);
            return false;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        if (TVKMethodMatcher.isSameMethod(sTakeOverMethodOnInfo, method)) {
            onInfo(((Integer) objArr[0]).intValue(), (TPOnInfoParam) objArr[1]);
        }
        return null;
    }

    private void switchDefinition(TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) throws IllegalArgumentException {
        this.mLogger.info("api call: adaptiveSwitchDefinition with userInfo, definition=" + str, new Object[0]);
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        inputParam.setUserInfo(tVKUserInfo);
        inputParam.setPlayerVideoInfo(tVKPlayerVideoInfo);
        switchDefinition(str);
    }
}

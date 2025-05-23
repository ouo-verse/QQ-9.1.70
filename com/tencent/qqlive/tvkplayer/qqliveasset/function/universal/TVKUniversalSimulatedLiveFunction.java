package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOnlineSimulatedLiveAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKMediaSourceControllerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.config.TVKUrlConfig;
import com.tencent.qqlive.tvkplayer.tools.http.TVKHttpProcessorFactory;
import com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUrlBuilder;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.asset.ITPSimulatedLiveMediaAsset;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.core.datatransport.aidl.TPDataTransportMessageInfo;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUniversalSimulatedLiveFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String HTTP_REQUEST_TAG = "TVKUniversalSimulatedLiveFunction";
    private static final int HTTP_REQUEST_TIMEOUT_MS = 10000;
    private static final String PREVIEW_COUNT_DEDUCTION_SERVICE_HEADERS_KEY_COOKIE = "Cookie";
    private static final String PREVIEW_COUNT_DEDUCTION_SERVICE_PARAM_KEY_PID = "pid";
    private static final String TAG = "TVKUniversalSimulatedLiveFunction";
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodOnInfoEndOfCurrentClip;
    private static final Method sTriggerMethodOnNextAssetRequired;
    private TVKError mCgiError;
    private Object[] mCurrentTriggerArgArray;
    private Method mCurrentTriggerMethod;
    private int mIndexOfRealtimePlayingVid;
    private boolean mIsRequesting;
    private ITVKMediaSourceController mMediaSourceController;
    private final Queue<TVKNetVideoInfo> mNotPlayedNetVideoInfoQueue;
    private int mRequestId;
    private ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest mSimulatedLiveAssetRequest;
    private int mVidCountOfCgiSucceededLeadingPlaying;
    private List<String> mVidList;

    static {
        try {
            sTriggerMethodOnNextAssetRequired = TVKQQLiveAssetPlayer.class.getMethod("onNextAssetRequired", ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest.class);
            sTriggerMethodOnInfoEndOfCurrentClip = TVKQQLiveAssetPlayer.class.getMethod("onInfo", Integer.TYPE, TPOnInfoParam.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("FIX ME!", e16);
        }
    }

    public TVKUniversalSimulatedLiveFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, "TVKUniversalSimulatedLiveFunction");
        this.mNotPlayedNetVideoInfoQueue = new LinkedList();
        this.mRequestId = -1;
        this.mIsRequesting = false;
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodOnNextAssetRequired, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.ag
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKUniversalSimulatedLiveFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.ah
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKUniversalSimulatedLiveFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        arrayList.add(new TVKMethodMatcher(sTriggerMethodOnInfoEndOfCurrentClip, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.ai
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$2;
                lambda$buildTriggerMethodMatchers$2 = TVKUniversalSimulatedLiveFunction.lambda$buildTriggerMethodMatchers$2(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$2;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.aj
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$3;
                lambda$buildTriggerMethodMatchers$3 = TVKUniversalSimulatedLiveFunction.lambda$buildTriggerMethodMatchers$3(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$3;
            }
        }));
        return arrayList;
    }

    private String getDefinition() {
        String definition = this.mAssetPlayerContext.getInputParam().getDefinition();
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo == null) {
            return definition;
        }
        TVKNetVideoInfo.DefnInfo curDefinition = netVideoInfo.getCurDefinition();
        if (curDefinition == null) {
            return definition;
        }
        return curDefinition.getDefn();
    }

    private void handleBeginningOfVid() {
        TVKNetVideoInfo poll = this.mNotPlayedNetVideoInfoQueue.poll();
        if (poll == null) {
            this.mLogger.error("[handleBeginningOfVid] logical error: got a null object from NetVideoInfo queue", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        this.mAssetPlayerContext.getPlayerSharedOperator().processCGIRequestSuccess(poll);
        notifyInfoMsg(549, poll);
        if (poll.isPreview()) {
            notifyPreviewCountDeduction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$2(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        if (((Integer) objArr[0]).intValue() != 80100) {
            return false;
        }
        Object obj = objArr[1];
        if (!(obj instanceof TPOnInfoParam)) {
            return false;
        }
        TPOnInfoParam tPOnInfoParam = (TPOnInfoParam) obj;
        if (!(tPOnInfoParam.getObjParam() instanceof TPDataTransportMessageInfo) || ((TPDataTransportMessageInfo) tPOnInfoParam.getObjParam()).messageType != 26) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$3(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    private void notifyInfoMsg(int i3, Object obj) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener != null) {
            assetPlayerListener.onInfo(i3, 0L, 0L, obj);
            return;
        }
        this.mLogger.warn("cannot send info=" + i3 + ": listener is null", new Object[0]);
    }

    private void notifyPreviewCountDeduction() {
        String safeString;
        ITVKAsset asset = this.mAssetPlayerContext.getInputParam().getPlayerVideoInfo().getAsset();
        if (!(asset instanceof TVKOnlineSimulatedLiveAsset)) {
            this.mLogger.error("[notifyPreviewCountDeduction] logical error: input asset type mismatch", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("pid", ((TVKOnlineSimulatedLiveAsset) asset).getPid());
        String buildUrl = new TVKUrlBuilder().setUrl(TVKUrlConfig.getServiceUrl(TVKUrlConfig.SERVICE_NAME_SIMULATED_LIVE_PREVIEW_COUNT_DEDUCTION)).addParam(hashMap).buildUrl();
        this.mLogger.info("[notifyPreviewCountDeduction] url generated: " + buildUrl, new Object[0]);
        TVKUserInfo userInfo = this.mAssetPlayerContext.getInputParam().getUserInfo();
        HashMap hashMap2 = new HashMap();
        if (userInfo == null) {
            safeString = "";
        } else {
            safeString = TVKUtils.getSafeString(userInfo.getLoginCookie());
        }
        hashMap2.put("Cookie", safeString);
        this.mLogger.info("[notifyPreviewCountDeduction] headers generated: " + hashMap2, new Object[0]);
        TVKHttpProcessorFactory.getHttpRequester().executeAsync(new ITVKHttpProcessor.TVKHttpRequest.Builder(ITVKHttpProcessor.TVKHttpRequest.HttpMethod.GET, buildUrl).reqTag("TVKUniversalSimulatedLiveFunction").headers(hashMap2).callTimeoutMs(10000L).build(), new ITVKHttpProcessor.ITVKHttpCallback() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKUniversalSimulatedLiveFunction.1
            @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
            public void onFailure(@NonNull IOException iOException) {
                TVKUniversalSimulatedLiveFunction.this.mLogger.error("[notifyPreviewCountDeduction] failed to reduce preview chances: " + iOException, new Object[0]);
            }

            @Override // com.tencent.qqlive.tvkplayer.tools.http.api.ITVKHttpProcessor.ITVKHttpCallback
            public void onSuccess(@NonNull ITVKHttpProcessor.TVKHttpResponse tVKHttpResponse) {
                TVKUniversalSimulatedLiveFunction.this.mLogger.info("[notifyPreviewCountDeduction] successfully reduced preview chances", new Object[0]);
            }
        });
    }

    private void onInfoEndOfCurrentClip() {
        this.mLogger.info("[onInfoEndOfCurrentClip] onInfo received", new Object[0]);
        if (!updateParamsIfNecessary()) {
            this.mLogger.error("[onInfoEndOfCurrentClip] fail to update params", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        this.mIndexOfRealtimePlayingVid = (this.mIndexOfRealtimePlayingVid + 1) % this.mVidList.size();
        int i3 = this.mVidCountOfCgiSucceededLeadingPlaying - 1;
        this.mVidCountOfCgiSucceededLeadingPlaying = i3;
        if (i3 < 0) {
            if (this.mCgiError != null) {
                this.mLogger.error("[onInfoEndOfCurrentClip] no playable vid any more. Process CGI error", new Object[0]);
                processPlayerErrorAndFinishFunction(this.mCgiError);
            }
        } else {
            handleBeginningOfVid();
        }
        if (!this.mIsRequesting) {
            this.mOnFunctionCompleteListener.onComplete(this);
        }
    }

    private void onNextAssetRequired(ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest iTPSimulatedLiveAssetRequest) {
        this.mLogger.info("[onNextAssetRequired] onNextAssetRequired received", new Object[0]);
        if (!updateParamsIfNecessary()) {
            this.mLogger.error("[onNextAssetRequired] fail to update params", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        this.mSimulatedLiveAssetRequest = iTPSimulatedLiveAssetRequest;
        TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext = this.mAssetPlayerContext;
        ITVKMediaSourceController createMediaSourceController = TVKMediaSourceControllerFactory.createMediaSourceController(tVKQQLiveAssetPlayerContext, tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper(), this.mMediaSourceListener);
        this.mMediaSourceController = createMediaSourceController;
        if (createMediaSourceController == null) {
            this.mLogger.error("[onNextAssetRequired] cannot create media source controller", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PARAM_INVALID_ERR));
            return;
        }
        String definition = getDefinition();
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        TVKPlayerRuntimeParam runtimeParam = this.mAssetPlayerContext.getRuntimeParam();
        TVKPlayerVideoInfo playerVideoInfo = inputParam.getPlayerVideoInfo();
        List<String> list = this.mVidList;
        this.mRequestId = this.mMediaSourceController.requestNetVideoInfo(new TVKCGIRequestParam.Builder(playerVideoInfo, TVKAssetFactory.createOnlineVodVidAsset(list.get(((this.mIndexOfRealtimePlayingVid + this.mVidCountOfCgiSucceededLeadingPlaying) + 1) % list.size()), ""), inputParam.getUserInfo()).definition(definition).streamFormatId(TVKFormatIDChooser.chooseFormatID(inputParam.getPlayerVideoInfo())).flowId(inputParam.getFlowId()).build(), this.mAssetPlayerContext.getFeatureGroup(), TVKFeatureFactory.createFeatureParamGroup(inputParam, runtimeParam));
        this.mIsRequesting = true;
        notifyInfoMsg(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, null);
    }

    private boolean updateParamsIfNecessary() {
        if (!this.mAssetPlayerContext.getRuntimeParam().shouldUpdateSimulatedLiveParams()) {
            this.mLogger.info("[updateParamsIfNecessary] should not update params", new Object[0]);
            return true;
        }
        this.mLogger.info("[updateParamsIfNecessary] updating params", new Object[0]);
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (!(netVideoInfo instanceof TVKVodVideoInfo)) {
            this.mLogger.error("[updateParamsIfNecessary] not a vod video info", new Object[0]);
            return false;
        }
        List<String> vidList = ((TVKVodVideoInfo) netVideoInfo).getSimulatedLiveInfo().getVidList();
        if (vidList.isEmpty()) {
            this.mLogger.error("[updateParamsIfNecessary] cannot find vid list", new Object[0]);
            return false;
        }
        this.mVidList = vidList;
        int indexOf = vidList.indexOf(netVideoInfo.getVid());
        this.mIndexOfRealtimePlayingVid = indexOf;
        if (indexOf < 0) {
            this.mLogger.error("[updateParamsIfNecessary] cannot find current vid in vid list", new Object[0]);
            return false;
        }
        this.mVidCountOfCgiSucceededLeadingPlaying = 0;
        this.mCgiError = null;
        this.mNotPlayedNetVideoInfoQueue.clear();
        this.mAssetPlayerContext.getRuntimeParam().setShouldUpdateSimulatedLiveParams(false);
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void cancel() {
        this.mLogger.info("cancelling function", new Object[0]);
        this.mMediaSourceController.cancelRequest(this.mRequestId);
        this.mRequestId = -1;
        this.mIsRequesting = false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodOnNextAssetRequired, method)) {
            onNextAssetRequired((ITPSimulatedLiveMediaAsset.ITPSimulatedLiveAssetRequest) objArr[0]);
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodOnInfoEndOfCurrentClip, method)) {
            onInfoEndOfCurrentClip();
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
        this.mLogger.error("[processOnNetVideoInfoFailure] request id=" + i3 + ", error=" + tVKError, new Object[0]);
        this.mIsRequesting = false;
        if (this.mRequestId != i3) {
            this.mLogger.warn("[processOnNetVideoInfoFailure] request might be cancelled. current request id=" + this.mRequestId, new Object[0]);
            return;
        }
        if (this.mVidCountOfCgiSucceededLeadingPlaying < 0) {
            this.mLogger.error("[processOnNetVideoInfoFailure] no playable vid any more. Process CGI error", new Object[0]);
            processPlayerErrorAndFinishFunction(tVKError);
            return;
        }
        this.mLogger.error("[processOnNetVideoInfoFailure] " + this.mVidCountOfCgiSucceededLeadingPlaying + " unplayed vid(s) left. Hold the error", new Object[0]);
        this.mCgiError = tVKError;
        this.mOnFunctionCompleteListener.onComplete(this);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected boolean processOnNetVideoInfoSuccess(int i3, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        this.mLogger.info("[processOnNetVideoInfoSuccess] received request id=" + i3, new Object[0]);
        this.mIsRequesting = false;
        if (this.mRequestId != i3) {
            this.mLogger.warn("[processOnNetVideoInfoSuccess] request might be cancelled. current request id=" + this.mRequestId, new Object[0]);
            return false;
        }
        if (!iTPMediaAsset.isValid()) {
            this.mLogger.error("[processOnNetVideoInfoSuccess] invalid media asset", new Object[0]);
            processOnNetVideoInfoFailure(i3, new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
            return false;
        }
        try {
            this.mSimulatedLiveAssetRequest.appendMediaAsset(iTPMediaAsset);
            this.mNotPlayedNetVideoInfoQueue.offer(tVKNetVideoInfo);
            int i16 = this.mVidCountOfCgiSucceededLeadingPlaying + 1;
            this.mVidCountOfCgiSucceededLeadingPlaying = i16;
            if (i16 <= 0) {
                handleBeginningOfVid();
            }
            this.mOnFunctionCompleteListener.onComplete(this);
            return false;
        } catch (IllegalArgumentException e16) {
            this.mLogger.error("[processOnNetVideoInfoSuccess] cannot append media asset: " + e16, new Object[0]);
            processOnNetVideoInfoFailure(i3, new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
            return false;
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        return null;
    }
}

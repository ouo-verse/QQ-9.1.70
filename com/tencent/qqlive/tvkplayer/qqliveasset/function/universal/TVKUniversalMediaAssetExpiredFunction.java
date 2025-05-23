package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetFactory;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.asset.TVKOfflineVodVidAsset;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerInputParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKFeatureParamGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureExtraParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.feature.TVKPlayerFeatureGroup;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.ITVKMediaSourceController;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.controller.TVKMediaSourceControllerFactory;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.TVKFormatIDChooser;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.qqlive.tvkplayer.vinfo.api.TVKCGIRequestParam;
import com.tencent.qqlive.tvkplayer.vinfo.common.TVKCGIParamsBuildHelper;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.player.ITPMediaAssetRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUniversalMediaAssetExpiredFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String API_CALL = "api call: ";
    private static final String CB_CALL_PREFIX = "player call: ";
    private static final String MODULE_NAME = "TVKUniversalMediaAssetExpiredFunction";
    private static final List<TVKMethodMatcher> sTakeOverMethodMatcherList;
    private static final Method sTakeOverMethodUpdateUserInfo;
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodOnMediaAssetExpire;
    private ITVKMediaSourceController mAssetRequester;

    @Nullable
    private Object[] mCurrentTriggerArgArray;
    private Method mCurrentTriggerMethod;
    private final Handler mHandler;
    private volatile boolean mIsMediaAssetExpirePendingNetwork;
    private ITPMediaAssetRequest mMediaAssetRequest;
    private final TVKGlobalEventNotifier.OnGlobalEventChangeListener mNetworkChangeListener;
    private volatile int mRequestId;
    private boolean mShouldHandleMediaAssetExpire;

    static {
        try {
            sTriggerMethodOnMediaAssetExpire = TVKQQLiveAssetPlayer.class.getMethod("onMediaAssetExpire", ITPMediaAssetRequest.class);
            sTakeOverMethodUpdateUserInfo = TVKQQLiveAssetPlayer.class.getMethod("updateUserInfo", TVKUserInfo.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
            sTakeOverMethodMatcherList = buildTakeOverMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method, please fix this problem(rename method)", e16);
        }
    }

    public TVKUniversalMediaAssetExpiredFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        this.mRequestId = -1;
        this.mShouldHandleMediaAssetExpire = false;
        this.mIsMediaAssetExpirePendingNetwork = false;
        this.mNetworkChangeListener = new TVKGlobalEventNotifier.OnGlobalEventChangeListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.e
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier.OnGlobalEventChangeListener
            public final void onEvent(int i3, int i16, int i17, Object obj) {
                TVKUniversalMediaAssetExpiredFunction.this.lambda$new$0(i3, i16, i17, obj);
            }
        };
        this.mHandler = new Handler(tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper());
    }

    private static List<TVKMethodMatcher> buildTakeOverMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTakeOverMethodUpdateUserInfo, null, null));
        return arrayList;
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodOnMediaAssetExpire, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.g
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKUniversalMediaAssetExpiredFunction.lambda$buildTriggerMethodMatchers$1(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.h
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$2;
                lambda$buildTriggerMethodMatchers$2 = TVKUniversalMediaAssetExpiredFunction.lambda$buildTriggerMethodMatchers$2(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$2;
            }
        }));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMediaAssetExpire() {
        this.mShouldHandleMediaAssetExpire = false;
        if (TVKVideoInfoFromType.FROM_TYPE_DL_PROXY == this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo().getFromType()) {
            handlePlayerOfflineToOnline();
        } else {
            handlePlayerUrlExpired();
        }
    }

    private void handlePlayerOfflineToOnline() {
        this.mLogger.info("player call: onMediaAssetExpire, handlePlayerOfflineToOnline", new Object[0]);
        TVKPlayerVideoInfo playerVideoInfo = this.mAssetPlayerContext.getInputParam().getPlayerVideoInfo();
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (!isValidParam(netVideoInfo, this.mAssetPlayerContext.getRuntimeParam().getTVKAsset())) {
            this.mOnFunctionCompleteListener.onComplete(this);
            return;
        }
        ITVKAsset tVKAsset = this.mAssetPlayerContext.getRuntimeParam().getTVKAsset();
        if (tVKAsset.getAssetType() == 262144) {
            TVKOfflineVodVidAsset tVKOfflineVodVidAsset = (TVKOfflineVodVidAsset) tVKAsset;
            this.mAssetPlayerContext.getRuntimeParam().setTVKAsset(TVKAssetFactory.createOnlineVodVidAsset(tVKOfflineVodVidAsset.getVid(), tVKOfflineVodVidAsset.getCid()));
        }
        playerVideoInfo.removeConfigMap(TVKPlayerVideoInfo.PLAYER_CFG_KEY_COMPATIBLE_MODE);
        requestNetVideoInfo(TVKCGIParamsBuildHelper.buildVodExtTag2Param(netVideoInfo), ((TVKVodVideoInfo) netVideoInfo).getDownloadType(), true);
        notifyInfoMsg(209, null);
    }

    private void handlePlayerUrlExpired() {
        this.mLogger.info("player call: onMediaAssetExpire, handlePlayerUrlExpired", new Object[0]);
        requestNetVideoInfo(TVKCGIParamsBuildHelper.buildVodExtTag2Param(this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo()), TVKFormatIDChooser.chooseFormatID(this.mAssetPlayerContext.getInputParam().getPlayerVideoInfo()), false);
    }

    private boolean isValidParam(TVKNetVideoInfo tVKNetVideoInfo, ITVKAsset iTVKAsset) {
        if (!TVKAssetUtils.isVodAsset(iTVKAsset)) {
            this.mLogger.warn("player call: onInfo, playerVideoInfo is null or not vod play", new Object[0]);
            return false;
        }
        if (tVKNetVideoInfo == null) {
            this.mLogger.warn("player call: onInfo, netVideoInfo is null", new Object[0]);
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$2(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(int i3, int i16, int i17, Object obj) {
        if (i3 == 100003) {
            onNetworkChange();
        }
    }

    private void notifyInfoMsg(int i3, @Nullable Object obj) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener != null) {
            assetPlayerListener.onInfo(i3, 0L, 0L, obj);
            return;
        }
        this.mLogger.warn("can not send msg.what=" + i3 + " cause assetPlayerListener is null", new Object[0]);
    }

    private void onNetworkChange() {
        if (TVKNetworkUtils.isNetworkAvailable() && this.mIsMediaAssetExpirePendingNetwork) {
            this.mLogger.info("onNetworkChange, request userInfo and handleOMediaAssetExpired", new Object[0]);
            this.mIsMediaAssetExpirePendingNetwork = false;
            this.mHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.f
                @Override // java.lang.Runnable
                public final void run() {
                    TVKUniversalMediaAssetExpiredFunction.this.requestUserInfoAndHandleOnMediaAssetExpired();
                }
            });
        }
    }

    private void requestNetVideoInfo(Map<String, String> map, int i3, boolean z16) {
        String definition;
        TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext = this.mAssetPlayerContext;
        this.mAssetRequester = TVKMediaSourceControllerFactory.createMediaSourceController(tVKQQLiveAssetPlayerContext, tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper(), this.mMediaSourceListener);
        TVKPlayerInputParam inputParam = this.mAssetPlayerContext.getInputParam();
        TVKPlayerRuntimeParam runtimeParam = this.mAssetPlayerContext.getRuntimeParam();
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo != null && netVideoInfo.getCurDefinition() != null) {
            definition = netVideoInfo.getCurDefinition().getDefn();
        } else {
            definition = inputParam.getDefinition();
        }
        TVKCGIRequestParam build = new TVKCGIRequestParam.Builder(inputParam.getPlayerVideoInfo(), runtimeParam.getTVKAsset(), inputParam.getUserInfo()).definition(definition).streamFormatId(i3).flowId(inputParam.getFlowId()).build();
        TVKFeatureParamGroup createFeatureParamGroup = TVKFeatureFactory.createFeatureParamGroup(inputParam, this.mAssetPlayerContext.getRuntimeParam(), new TVKPlayerFeatureExtraParam.Builder().assetExpireRequestMap(map).build());
        if (z16) {
            this.mRequestId = this.mAssetRequester.requestNetVideoInfo(build, new TVKPlayerFeatureGroup(new ArrayList(TVKFeatureFactory.createVodFeatureListForOfflineDownload(this.mAssetPlayerContext))), null);
        } else {
            this.mRequestId = this.mAssetRequester.requestNetVideoInfo(build, this.mAssetPlayerContext.getFeatureGroup(), createFeatureParamGroup);
        }
        notifyInfoMsg(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_REQUEST, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUserInfoAndHandleOnMediaAssetExpired() {
        if (!this.mShouldHandleMediaAssetExpire) {
            this.mLogger.warn("onMediaAssetExpire, should not handle media asset ", new Object[0]);
            return;
        }
        this.mLogger.info("player call: onMediaAssetExpire, send request update user info message", new Object[0]);
        notifyInfoMsg(547, null);
        this.mLogger.info("player call: onMediaAssetExpire, schedule request video info task", new Object[0]);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.d
            @Override // java.lang.Runnable
            public final void run() {
                TVKUniversalMediaAssetExpiredFunction.this.handleMediaAssetExpire();
            }
        }, TVKMediaPlayerConfig.PlayerConfig.media_asset_expire_wait_user_info_update_timeout_ms);
    }

    private void updateUserInfo(TVKUserInfo tVKUserInfo) {
        this.mLogger.info("api call: updateUserInfo, set userInfo to input param", new Object[0]);
        this.mAssetPlayerContext.getInputParam().setUserInfo(tVKUserInfo);
        if (!this.mShouldHandleMediaAssetExpire) {
            this.mLogger.warn("updateUserInfo, should not handle media asset ", new Object[0]);
            return;
        }
        this.mLogger.info("api call: updateUserInfo, cancel scheduled media asset expire request video info task", new Object[0]);
        this.mLogger.info("api call: updateUserInfo, media asset expire request video info execute immediately", new Object[0]);
        this.mHandler.removeCallbacksAndMessages(null);
        handleMediaAssetExpire();
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
        if (!isValidParam(tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo(), this.mAssetPlayerContext.getRuntimeParam().getTVKAsset())) {
            this.mOnFunctionCompleteListener.onComplete(this);
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodOnMediaAssetExpire, method)) {
            ITPMediaAssetRequest iTPMediaAssetRequest = (ITPMediaAssetRequest) objArr[0];
            this.mMediaAssetRequest = iTPMediaAssetRequest;
            if (iTPMediaAssetRequest == null) {
                this.mLogger.warn("player call: onMediaAssetExpire, mMediaAssetRequest is null", new Object[0]);
                this.mOnFunctionCompleteListener.onComplete(this);
                return null;
            }
            this.mShouldHandleMediaAssetExpire = true;
            if (!TVKNetworkUtils.isNetworkAvailable() && TVKMediaPlayerConfig.PlayerConfig.enable_delay_request_userinfo_when_network_unavailable) {
                this.mLogger.info("player call: onMediaAssetExpire, waiting for network to be available, delaying the request for userInfo and handling mediaAssetExpire", new Object[0]);
                this.mIsMediaAssetExpirePendingNetwork = true;
                TVKGlobalEventNotifier.getInstance().addEventListener(this.mNetworkChangeListener);
                return null;
            }
            requestUserInfoAndHandleOnMediaAssetExpired();
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
        return sTakeOverMethodMatcherList;
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
        this.mLogger.info("onSuccess, requestId:" + i3, new Object[0]);
        if (!iTPMediaAsset.isValid()) {
            this.mLogger.error("onSuccess, mediaAsset is invalid, mediaAsset=" + iTPMediaAsset, new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
            return false;
        }
        removeAndDeselectPreviousAddToCoreTrackFromVinfo();
        int[] addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes = addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes();
        if (addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes == null) {
            ITPMediaAssetRequest iTPMediaAssetRequest = this.mMediaAssetRequest;
            if (iTPMediaAssetRequest != null) {
                iTPMediaAssetRequest.updateMediaAsset(iTPMediaAsset);
            }
        } else {
            this.mAssetPlayerContext.getPlayer().switchDataSourceAndSelectTrackAsync(iTPMediaAsset, 4, addNewTrackFromVinfoToCoreAndReturnToBeSelectedIndexes, -1000L);
        }
        this.mAssetPlayerContext.getRuntimeParam().setTPMediaAsset(iTPMediaAsset);
        this.mOnFunctionCompleteListener.onComplete(this);
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseAccompanyFunction, com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void reset() {
        super.reset();
        this.mShouldHandleMediaAssetExpire = false;
        this.mIsMediaAssetExpirePendingNetwork = false;
        this.mMediaAssetRequest = null;
        TVKGlobalEventNotifier.getInstance().removeEventListener(this.mNetworkChangeListener);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        if (TVKMethodMatcher.isSameMethod(sTakeOverMethodUpdateUserInfo, method)) {
            updateUserInfo((TVKUserInfo) objArr[0]);
        }
        return null;
    }
}

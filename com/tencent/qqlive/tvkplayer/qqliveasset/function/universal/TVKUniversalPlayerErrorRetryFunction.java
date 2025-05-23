package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKPlayerRuntimeParam;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKPlayerRetryStrategy;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.qqlive.tvkplayer.vinfo.api.feature.ITVKFeatureBase;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKUniversalPlayerErrorRetryFunction extends TVKBaseUniversalInterruptFunction {
    private static final String MODULE_NAME = "TVKUniversalPlayerErrorRetryFunction";

    @NonNull
    private static final List<TVKMethodMatcher> sTakeOverMethodMatcherList;

    @NonNull
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;

    @NonNull
    private static final Method sTriggerMethodOnError;

    @NonNull
    private static final Method sTriggerMethodOnVideoFxFatal;
    private TVKPlayerRuntimeParam mRuntimeParam;

    static {
        try {
            sTriggerMethodOnError = TVKQQLiveAssetPlayer.class.getMethod("onError", TPError.class);
            sTriggerMethodOnVideoFxFatal = TVKQQLiveAssetPlayer.class.getMethod("onVideoFxFatal", Integer.TYPE, String.class, Object.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
            sTakeOverMethodMatcherList = buildTakeOverMethodMatchers();
        } catch (NoSuchMethodException unused) {
            throw new RuntimeException("no such method! please fix me");
        }
    }

    public TVKUniversalPlayerErrorRetryFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, MODULE_NAME);
    }

    private static List<TVKMethodMatcher> buildTakeOverMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodGetCurrentPosition, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodStart, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodPause, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodOnPrepared, null, null));
        return arrayList;
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodOnError, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.n
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKUniversalPlayerErrorRetryFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.o
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKUniversalPlayerErrorRetryFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        arrayList.add(new TVKMethodMatcher(sTriggerMethodOnVideoFxFatal, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.p
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$2;
                lambda$buildTriggerMethodMatchers$2 = TVKUniversalPlayerErrorRetryFunction.lambda$buildTriggerMethodMatchers$2(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$2;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.q
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$3;
                lambda$buildTriggerMethodMatchers$3 = TVKUniversalPlayerErrorRetryFunction.lambda$buildTriggerMethodMatchers$3(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$3;
            }
        }));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$2(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$3(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    private void onError(int i3, int i16, int i17, TVKError tVKError) {
        String definition;
        notifyBufferStart(false);
        ITVKPlayerRetryStrategy.RetryActionRet retryActionForPlayerError = this.mAssetPlayerContext.getRetryStrategy().getRetryActionForPlayerError(i3, i16, i17);
        int retryAction = retryActionForPlayerError.getRetryAction();
        if (retryAction != 1) {
            if (retryAction != 2) {
                if (retryAction != 3) {
                    this.mLogger.error("unhandled retryAction:" + retryActionForPlayerError, new Object[0]);
                    this.mOnFunctionCompleteListener.onComplete(this);
                    return;
                }
                this.mRuntimeParam.increaseErrorRetryCount();
                TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
                if (netVideoInfo != null) {
                    definition = netVideoInfo.getCurDefinition().getDefn();
                } else {
                    definition = this.mAssetPlayerContext.getInputParam().getDefinition();
                }
                ITVKFeatureBase iTVKFeatureBase = (ITVKFeatureBase) retryActionForPlayerError.getExtra();
                if (iTVKFeatureBase != null) {
                    iTVKFeatureBase.setEnable(false);
                }
                this.mAssetPlayerContext.getPlayerSharedOperator().stopAndResetPlayer();
                requestNetVideoInfoToRetry(definition);
                return;
            }
            this.mRuntimeParam.increaseErrorRetryCount();
            String str = (String) retryActionForPlayerError.getExtra();
            this.mAssetPlayerContext.getPlayerSharedOperator().stopAndResetPlayer();
            requestNetVideoInfoToRetry(str);
            return;
        }
        this.mLogger.error("PlayerErrorRetryFunction cannot retry anymore!", new Object[0]);
        processPlayerErrorAndFinishFunction(tVKError);
    }

    private void parseErrorAudioTrackFromTPErrorToTVK(@NonNull TPError tPError, @NonNull TVKError tVKError) {
        if (tPError.getExtraParam(TPError.TP_ERROR_EXTRA_PARAM_INT_TRACK_INDEX) instanceof Integer) {
            int intValue = ((Integer) tPError.getExtraParam(TPError.TP_ERROR_EXTRA_PARAM_INT_TRACK_INDEX)).intValue();
            TPTrackInfo[] trackInfo = this.mAssetPlayerContext.getPlayer().getTrackInfo();
            if (intValue >= 0 && trackInfo != null && intValue < trackInfo.length) {
                TPTrackInfo tPTrackInfo = trackInfo[intValue];
                for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
                    if ((tVKTrackInfo instanceof TVKAudioTrackVinfo) && TextUtils.equals(tPTrackInfo.getName(), tVKTrackInfo.getTrackUniqueId())) {
                        tVKError.addExtraInfo(TVKError.ExtraInfoKey.ERROR_AUDIO_TRACK_NAME, ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo().getAudioTrack());
                        return;
                    }
                }
            }
        }
    }

    private void requestNetVideoInfoToRetry(String str) {
        this.mAssetPlayerContext.getEventSender().sendEvent(TVKEventId.PLAYER_STATE_ERROR_RETRY, 0, 0, "", null);
        requestNetVideoInfoToRebootPlayer(str);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        this.mRuntimeParam = tVKQQLiveAssetPlayerContext.getRuntimeParam();
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodOnError, method)) {
            TPError tPError = (TPError) objArr[0];
            int errorType = tPError.getErrorType();
            int errorCode = tPError.getErrorCode();
            int i3 = TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR;
            TVKError tVKError = new TVKError(i3, errorCode);
            parseErrorAudioTrackFromTPErrorToTVK(tPError, tVKError);
            onError(i3, errorType, errorCode, tVKError);
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodOnVideoFxFatal, method)) {
            int intValue = ((Integer) objArr[0]).intValue();
            int i16 = TVKCommonErrorCodeUtil.MODULE.VIDEO_FX_ERR;
            TVKError tVKError2 = new TVKError(i16, intValue);
            this.mLogger.error("get onVideoFxFatal and retry. errorCode: " + intValue, new Object[0]);
            this.mAssetPlayerContext.getVideoPostProcessor().reset();
            onError(i16, -1, intValue, tVKError2);
            return null;
        }
        return null;
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
    @NonNull
    public List<TVKMethodMatcher> getTriggerMatcherList() throws IllegalStateException {
        return sTriggerMethodMatcherList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalInterruptFunction
    protected void processWhenPlayerOnPrepared() {
        notifyBufferEnd(false);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalInterruptFunction, com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void reset() {
        super.reset();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        if (TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodOnPrepared, method)) {
            onPrepared();
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodGetCurrentPosition, method)) {
            return Long.valueOf(getCurrentPosition());
        }
        if (TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodStart, method)) {
            start();
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodPause, method)) {
            pause();
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodGetAvailablePositionMs, method)) {
            return Long.valueOf(getAvailablePositionMs());
        }
        this.mLogger.error("takeOverMethod unhandled!, method name=" + method.getName(), new Object[0]);
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalInterruptFunction
    protected void processWhenPlayerPrepareAsync() {
    }
}

package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKLiveVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.source.TVKLivePlaybackTPMediaAssetBuilder;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUniversalSeekLiveFunction extends TVKBaseUniversalInterruptFunction {
    private static final String MODULE_NAME = "TVKUniversalSeekLiveFunction";
    private static final List<TVKMethodMatcher> sTakeOverMethodMatcherList;
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodSeekForLive;

    static {
        try {
            sTriggerMethodSeekForLive = TVKQQLiveAssetPlayer.class.getMethod("seekForLive", Long.TYPE);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
            sTakeOverMethodMatcherList = buildTakeOverMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method, please fix this problem(rename method)", e16);
        }
    }

    public TVKUniversalSeekLiveFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
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
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSeekForLive, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.ae
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKUniversalSeekLiveFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.af
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKUniversalSeekLiveFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        return arrayList;
    }

    private ITPMediaAsset createLivePlaybackMediaAsset() {
        try {
            return ((TVKLivePlaybackTPMediaAssetBuilder) TVKLivePlaybackTPMediaAssetBuilder.newBuilder().playerVideoInfo(this.mAssetPlayerContext.getInputParam().getPlayerVideoInfo()).inputDefinition(this.mAssetPlayerContext.getInputParam().getDefinition()).flowId(this.mAssetPlayerContext.getInputParam().getFlowId()).liveVideoInfo((TVKLiveVideoInfo) this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo())).elapsedRealTimeOnGetCgiPlaybackUrlMs(this.mAssetPlayerContext.getRuntimeParam().getElapsedRealTimeOnGetCgiPlaybackUrlMs()).playbackPositionSec(this.mAssetPlayerContext.getInputParam().getLiveBackPlayTimeSec()).build();
        } catch (IllegalArgumentException e16) {
            this.mLogger.error("error encountered while generating media asset: " + e16, new Object[0]);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return TVKAssetUtils.isLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    private void notifyOnSeekComplete() {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener == null) {
            this.mLogger.error("assetPlayerListener == null, cannot notify onSeekComplete", new Object[0]);
        } else {
            assetPlayerListener.onSeekComplete();
        }
    }

    private void seekForLive(long j3) {
        long j16;
        String definition;
        this.mLogger.info("api call: seekForLive, positionMs=" + j3, new Object[0]);
        notifyBufferStart(true);
        if (j3 == -1) {
            j16 = -1;
        } else {
            j16 = j3 / 1000;
        }
        boolean isLiveBackPlay = this.mAssetPlayerContext.getRuntimeParam().isLiveBackPlay();
        if (j16 != -1 && isLiveBackPlay) {
            this.mLogger.info("api call: seekForLive, now is liveback play and seek again", new Object[0]);
            this.mAssetPlayerContext.getInputParam().setLiveBackPlayTimeSec(j16);
            this.mAssetPlayerContext.getPlayerSharedOperator().stopAndResetPlayer();
            ITPMediaAsset createLivePlaybackMediaAsset = createLivePlaybackMediaAsset();
            if (createLivePlaybackMediaAsset == null) {
                this.mLogger.error("pretty strange that seeking in playback mode generates a null media asset. FIX ME", new Object[0]);
                processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAY_URL_EMPTY_ERR));
                return;
            } else {
                this.mAssetPlayerContext.getRuntimeParam().setTPMediaAsset(createLivePlaybackMediaAsset);
                this.mAssetPlayerContext.getPlayerSharedOperator().setupPlayerAndPrepareAsync(this.mAssetPlayerContext.getRuntimeParam().getTPMediaAsset(), true);
                return;
            }
        }
        this.mAssetPlayerContext.getInputParam().setLiveBackPlayTimeSec(j16);
        this.mAssetPlayerContext.getPlayerSharedOperator().stopAndResetPlayer();
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo != null) {
            definition = netVideoInfo.getCurDefinition().getDefn();
        } else {
            definition = this.mAssetPlayerContext.getInputParam().getDefinition();
        }
        requestNetVideoInfoToRebootPlayer(definition);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        long longValue = ((Long) objArr[0]).longValue();
        if (longValue == 0) {
            this.mLogger.error("api call: seekForLive, positionMs == 0L, should not seekForLive", new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
            return null;
        }
        seekForLive(longValue);
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
        notifyOnSeekComplete();
        notifyBufferEnd(true);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        this.mLogger.info("takeOverMethod, method:" + method.getName(), new Object[0]);
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
        if (!TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodGetAvailablePositionMs, method)) {
            return null;
        }
        return Long.valueOf(getAvailablePositionMs());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalInterruptFunction
    protected void processWhenPlayerPrepareAsync() {
    }
}

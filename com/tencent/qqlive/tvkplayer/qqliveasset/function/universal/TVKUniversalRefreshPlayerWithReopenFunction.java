package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes23.dex */
public class TVKUniversalRefreshPlayerWithReopenFunction extends TVKBaseUniversalInterruptFunction {
    private static final String MODULE_NAME = "RefreshPlayerWithReopenFunction";
    private static final List<TVKMethodMatcher> sTakeOverMethodMatcherList;
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodRefreshPlayer;
    private static final Method sTriggerMethodRefreshPlayerWithReopen;

    static {
        try {
            sTriggerMethodRefreshPlayerWithReopen = TVKQQLiveAssetPlayer.class.getMethod("refreshPlayerWithReopen", new Class[0]);
            sTriggerMethodRefreshPlayer = TVKQQLiveAssetPlayer.class.getMethod("refreshPlayer", new Class[0]);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
            sTakeOverMethodMatcherList = buildTakeOverMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method, please fix this problem(rename method)", e16);
        }
    }

    public TVKUniversalRefreshPlayerWithReopenFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
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
        arrayList.add(new TVKMethodMatcher(sTriggerMethodRefreshPlayerWithReopen, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.t
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKUniversalRefreshPlayerWithReopenFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.u
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKUniversalRefreshPlayerWithReopenFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        arrayList.add(new TVKMethodMatcher(sTriggerMethodRefreshPlayer, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.v
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$2;
                lambda$buildTriggerMethodMatchers$2 = TVKUniversalRefreshPlayerWithReopenFunction.lambda$buildTriggerMethodMatchers$2(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$2;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.w
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$3;
                lambda$buildTriggerMethodMatchers$3 = TVKUniversalRefreshPlayerWithReopenFunction.lambda$buildTriggerMethodMatchers$3(iTVKPlayerState);
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
        return iTVKPlayerState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$2(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        if (!tVKQQLiveAssetPlayerContext.getState().is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING) || !TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$3(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING);
    }

    private void refreshPlayerWithReopen() {
        String definition;
        notifyBufferStart(true);
        notifyInfoMsg(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_START, 0L, 0L, null);
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
        refreshPlayerWithReopen();
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
        notifyInfoMsg(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_REFRESH_PLAYER_WITH_REOPEN_END, 0L, 0L, null);
        notifyBufferEnd(true);
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

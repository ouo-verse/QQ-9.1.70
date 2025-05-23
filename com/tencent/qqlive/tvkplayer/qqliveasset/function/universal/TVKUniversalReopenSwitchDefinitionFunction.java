package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.api.room.QCircleLiveFeedsPlayerEvent;
import com.tencent.qqlive.tvkplayer.api.TVKDefinitionType;
import com.tencent.qqlive.tvkplayer.api.TVKPlayerVideoInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
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

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUniversalReopenSwitchDefinitionFunction extends TVKBaseUniversalInterruptFunction {
    private static final String MODULE_NAME = "ReopenSwitchDefinitionFunction";

    @NonNull
    private static final List<TVKMethodMatcher> sTakeOverMethodMatcherList;

    @NonNull
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;

    @NonNull
    private static final Method sTriggerMethodSwitchDefinition;

    @NonNull
    private static final Method sTriggerMethodSwitchDefinitionReopenWithUserInfoAndPlayerVideoInfo;

    @NonNull
    private static final Method sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo;

    static {
        try {
            sTriggerMethodSwitchDefinitionReopenWithUserInfoAndPlayerVideoInfo = TVKQQLiveAssetPlayer.class.getMethod("switchDefinitionWithReopen", TVKUserInfo.class, TVKPlayerVideoInfo.class);
            sTriggerMethodSwitchDefinition = TVKQQLiveAssetPlayer.class.getMethod(QCircleLiveFeedsPlayerEvent.EVENT_SWITCH_DEFINITION, String.class);
            sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo = TVKQQLiveAssetPlayer.class.getMethod(QCircleLiveFeedsPlayerEvent.EVENT_SWITCH_DEFINITION, TVKUserInfo.class, TVKPlayerVideoInfo.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
            sTakeOverMethodMatcherList = buildTakeOverMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method, please fix this problem(rename method)", e16);
        }
    }

    public TVKUniversalReopenSwitchDefinitionFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, MODULE_NAME);
    }

    private static List<TVKMethodMatcher> buildTakeOverMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodPrepare, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodGetCurrentPosition, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodStart, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodPause, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodOnPrepared, null, null));
        return arrayList;
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSwitchDefinitionReopenWithUserInfoAndPlayerVideoInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.x
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKUniversalReopenSwitchDefinitionFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.y
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean isValidStateForSwitchDefnReopen;
                isValidStateForSwitchDefnReopen = TVKUniversalReopenSwitchDefinitionFunction.isValidStateForSwitchDefnReopen(iTVKPlayerState);
                return isValidStateForSwitchDefnReopen;
            }
        }));
        Method method = sTriggerMethodSwitchDefinition;
        arrayList.add(new TVKMethodMatcher(method, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.z
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean isValidArgsForSwitchingDefinition;
                isValidArgsForSwitchingDefinition = TVKUniversalReopenSwitchDefinitionFunction.isValidArgsForSwitchingDefinition(tVKQQLiveAssetPlayerContext);
                return isValidArgsForSwitchingDefinition;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.aa
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean isValidStateForSwitchingDefinition;
                isValidStateForSwitchingDefinition = TVKUniversalReopenSwitchDefinitionFunction.isValidStateForSwitchingDefinition(iTVKPlayerState);
                return isValidStateForSwitchingDefinition;
            }
        }));
        Method method2 = sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo;
        arrayList.add(new TVKMethodMatcher(method2, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.ab
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean isValidArgsForSwitchingDefinition;
                isValidArgsForSwitchingDefinition = TVKUniversalReopenSwitchDefinitionFunction.isValidArgsForSwitchingDefinition(tVKQQLiveAssetPlayerContext);
                return isValidArgsForSwitchingDefinition;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.aa
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean isValidStateForSwitchingDefinition;
                isValidStateForSwitchingDefinition = TVKUniversalReopenSwitchDefinitionFunction.isValidStateForSwitchingDefinition(iTVKPlayerState);
                return isValidStateForSwitchingDefinition;
            }
        }));
        arrayList.add(new TVKMethodMatcher(method, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.ac
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$3;
                lambda$buildTriggerMethodMatchers$3 = TVKUniversalReopenSwitchDefinitionFunction.lambda$buildTriggerMethodMatchers$3(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$3;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.y
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean isValidStateForSwitchDefnReopen;
                isValidStateForSwitchDefnReopen = TVKUniversalReopenSwitchDefinitionFunction.isValidStateForSwitchDefnReopen(iTVKPlayerState);
                return isValidStateForSwitchDefnReopen;
            }
        }));
        arrayList.add(new TVKMethodMatcher(method2, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.ad
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$4;
                lambda$buildTriggerMethodMatchers$4 = TVKUniversalReopenSwitchDefinitionFunction.lambda$buildTriggerMethodMatchers$4(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$4;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.y
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean isValidStateForSwitchDefnReopen;
                isValidStateForSwitchDefnReopen = TVKUniversalReopenSwitchDefinitionFunction.isValidStateForSwitchDefnReopen(iTVKPlayerState);
                return isValidStateForSwitchDefnReopen;
            }
        }));
        return arrayList;
    }

    private String dealWithAdaptiveDefinition(String str) {
        boolean equals = TVKDefinitionType.DEFINITION_TYPE_ADAPTIVE.equals(str);
        if (equals != this.mAssetPlayerContext.getInputParam().isAdaptiveDefinition()) {
            this.mAssetPlayerContext.getInputParam().setAdaptiveDefinition(equals);
            notifyInfoMsg(TVKQQLiveAssetPlayerMsg.PLAYER_INFO_UPDATE_ADAPTIVE_DEFINITION_STATE, 0L, 0L, Boolean.valueOf(equals));
        }
        if (equals) {
            return "auto";
        }
        return str;
    }

    private static boolean isValidArgsForDolbyVisionSwitching(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull String str) {
        boolean z16;
        if (!tVKQQLiveAssetPlayerContext.getRuntimeParam().isDolbyVision() && !TVKDefinitionType.DEFINITION_TYPE_DOLBYVISION.equalsIgnoreCase(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset()) || !z16) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidArgsForSwitchingDefinition(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        if (!tVKQQLiveAssetPlayerContext.getState().is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING) || !TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidStateForSwitchDefnReopen(@NonNull ITVKPlayerState iTVKPlayerState) {
        return !iTVKPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.ERROR, ITVKPlayerState.STATE.RELEASED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isValidStateForSwitchingDefinition(@NonNull ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$3(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        return isValidArgsForDolbyVisionSwitching(tVKQQLiveAssetPlayerContext, (String) objArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$4(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        String definition;
        TVKPlayerVideoInfo tVKPlayerVideoInfo = (TVKPlayerVideoInfo) objArr[1];
        if (tVKPlayerVideoInfo == null) {
            definition = "";
        } else {
            definition = tVKPlayerVideoInfo.getDefinition();
        }
        return isValidArgsForDolbyVisionSwitching(tVKQQLiveAssetPlayerContext, definition);
    }

    private void switchDefinitionWithReopen(@Nullable TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo) {
        if (tVKPlayerVideoInfo != null) {
            switchDefinitionWithReopen(tVKUserInfo, tVKPlayerVideoInfo, tVKPlayerVideoInfo.getDefinition());
        } else {
            this.mLogger.error("api call: switch definition with null video info", new Object[0]);
            throw new IllegalArgumentException("switchDefinitionWithReopen, video info can not be null");
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodSwitchDefinitionReopenWithUserInfoAndPlayerVideoInfo, method)) {
            switchDefinitionWithReopen((TVKUserInfo) objArr[0], (TVKPlayerVideoInfo) objArr[1]);
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodSwitchDefinition, method)) {
            switchDefinitionWithReopen(tVKQQLiveAssetPlayerContext.getInputParam().getUserInfo(), tVKQQLiveAssetPlayerContext.getInputParam().getPlayerVideoInfo(), (String) objArr[0]);
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodSwitchDefinitionWithUserInfoAndPlayerVideoInfo, method)) {
            switchDefinitionWithReopen((TVKUserInfo) objArr[0], (TVKPlayerVideoInfo) objArr[1]);
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
        notifyInfoMsg(111, 2L, 0L, null);
        notifyBufferEnd(true);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalInterruptFunction
    protected void processWhenPlayerPrepareAsync() {
        notifyInfoMsg(523, 2L, 0L, null);
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
        if (TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodPrepare, method)) {
            prepare();
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(TVKBaseUniversalInterruptFunction.sTakeOverMethodGetAvailablePositionMs, method)) {
            return Long.valueOf(getAvailablePositionMs());
        }
        this.mLogger.error("takeOverMethod unhandled!, method name=" + method.getName(), new Object[0]);
        return null;
    }

    private void switchDefinitionWithReopen(@Nullable TVKUserInfo tVKUserInfo, TVKPlayerVideoInfo tVKPlayerVideoInfo, String str) throws IllegalStateException, IllegalArgumentException {
        if (!TextUtils.isEmpty(str)) {
            this.mLogger.info("api call: switchDefinitionWithReopen , definition=" + str, new Object[0]);
            String dealWithAdaptiveDefinition = dealWithAdaptiveDefinition(str);
            notifyBufferStart(true);
            notifyInfoMsg(522, 2L, 0L, null);
            this.mAssetPlayerContext.getPlayerSharedOperator().stopAndResetPlayer();
            this.mAssetPlayerContext.getInputParam().setUserInfo(tVKUserInfo);
            this.mAssetPlayerContext.getInputParam().setPlayerVideoInfo(tVKPlayerVideoInfo);
            this.mAssetPlayerContext.getRuntimeParam().setTVKAsset(tVKPlayerVideoInfo.getAsset());
            requestNetVideoInfoToRebootPlayer(dealWithAdaptiveDefinition, true);
            return;
        }
        this.mLogger.error("api call: switchDefinitionWithReopen, definition is empty, can not reopen", new Object[0]);
        throw new IllegalArgumentException("switchDefinitionWithReopen, definition can not be empty");
    }
}

package com.tencent.qqlive.tvkplayer.qqliveasset.function.universal;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.TVKUserInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVideoInfoFromType;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKSubtitleTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKNetworkUtils;
import com.tencent.thumbplayer.api.player.ITPMediaAssetRequest;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUniversalMediaAssetExpiredWithReopenFunction extends TVKBaseUniversalInterruptFunction {
    private static final String MODULE_NAME = "TVKUniversalMediaAssetExpiredWithReopenFunction";
    private static final List<TVKMethodMatcher> sTakeOverMethodMatcherList;
    private static final Method sTakeOverMethodUpdateUserInfo;
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodOnMediaAssetExpire;
    private final Handler mHandler;
    private volatile boolean mIsMediaAssetExpirePendingNetwork;
    private final TVKGlobalEventNotifier.OnGlobalEventChangeListener mNetworkChangeListener;
    private boolean mShouldHandleMediaAssetExpired;

    static {
        try {
            sTriggerMethodOnMediaAssetExpire = TVKQQLiveAssetPlayer.class.getMethod("onMediaAssetExpire", ITPMediaAssetRequest.class);
            sTakeOverMethodUpdateUserInfo = TVKQQLiveAssetPlayer.class.getMethod("updateUserInfo", TVKUserInfo.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
            sTakeOverMethodMatcherList = buildTakeOverMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method, please fix this problem (rename method)", e16);
        }
    }

    public TVKUniversalMediaAssetExpiredWithReopenFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, MODULE_NAME);
        this.mNetworkChangeListener = new TVKGlobalEventNotifier.OnGlobalEventChangeListener() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.i
            @Override // com.tencent.qqlive.tvkplayer.tools.utils.TVKGlobalEventNotifier.OnGlobalEventChangeListener
            public final void onEvent(int i3, int i16, int i17, Object obj) {
                TVKUniversalMediaAssetExpiredWithReopenFunction.this.lambda$new$0(i3, i16, i17, obj);
            }
        };
        this.mShouldHandleMediaAssetExpired = false;
        this.mIsMediaAssetExpirePendingNetwork = false;
        this.mHandler = new Handler(tVKQQLiveAssetPlayerContext.getInputParam().getWorkThreadLooper());
    }

    private static List<TVKMethodMatcher> buildTakeOverMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTakeOverMethodUpdateUserInfo, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodGetCurrentPosition, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodStart, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodPause, null, null));
        arrayList.add(new TVKMethodMatcher(TVKBaseUniversalInterruptFunction.sTakeOverMethodOnPrepared, null, null));
        return arrayList;
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodOnMediaAssetExpire, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.l
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKUniversalMediaAssetExpiredWithReopenFunction.lambda$buildTriggerMethodMatchers$1(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.m
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$2;
                lambda$buildTriggerMethodMatchers$2 = TVKUniversalMediaAssetExpiredWithReopenFunction.lambda$buildTriggerMethodMatchers$2(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$2;
            }
        }));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleMediaAssetExpired() {
        String definition;
        this.mLogger.info("handleMediaAssetExpired", new Object[0]);
        this.mShouldHandleMediaAssetExpired = false;
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo != null && netVideoInfo.getCurDefinition() != null) {
            definition = netVideoInfo.getCurDefinition().getDefn();
        } else {
            definition = this.mAssetPlayerContext.getInputParam().getDefinition();
        }
        notifyBufferStart(false);
        this.mAssetPlayerContext.getPlayerSharedOperator().stopAndResetPlayer();
        requestNetVideoInfoToRebootPlayer(definition);
    }

    private static boolean isExternalVinfoAudioOrSubtitleTrackSelected(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        for (TVKTrackInfo tVKTrackInfo : tVKQQLiveAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (tVKTrackInfo.isSelected()) {
                if (tVKTrackInfo instanceof TVKSubtitleTrackVinfo) {
                    TVKSubtitleTrackVinfo tVKSubtitleTrackVinfo = (TVKSubtitleTrackVinfo) tVKTrackInfo;
                    if (tVKSubtitleTrackVinfo.getSubTitle() != null && !tVKSubtitleTrackVinfo.getSubTitle().isAvsSeparate()) {
                        return true;
                    }
                }
                if (tVKTrackInfo instanceof TVKAudioTrackVinfo) {
                    TVKAudioTrackVinfo tVKAudioTrackVinfo = (TVKAudioTrackVinfo) tVKTrackInfo;
                    if (tVKAudioTrackVinfo.getAudioTrackInfo() != null && tVKAudioTrackVinfo.getAudioTrackInfo().getTrackType() != 1 && !tVKAudioTrackVinfo.getAudioTrackInfo().isAvsSeparate()) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (!(netVideoInfo instanceof TVKVodVideoInfo) || ((TVKVodVideoInfo) netVideoInfo).getFromType() == TVKVideoInfoFromType.FROM_TYPE_DL_PROXY || !isExternalVinfoAudioOrSubtitleTrackSelected(tVKQQLiveAssetPlayerContext)) {
            return false;
        }
        return true;
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

    private void onNetworkChange() {
        if (TVKNetworkUtils.isNetworkAvailable() && this.mIsMediaAssetExpirePendingNetwork) {
            this.mLogger.info("onNetworkChange", new Object[0]);
            this.mIsMediaAssetExpirePendingNetwork = false;
            this.mHandler.post(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.k
                @Override // java.lang.Runnable
                public final void run() {
                    TVKUniversalMediaAssetExpiredWithReopenFunction.this.requestUserInfoAndHandleOnMediaAssetExpired();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void requestUserInfoAndHandleOnMediaAssetExpired() {
        if (!this.mShouldHandleMediaAssetExpired) {
            this.mLogger.warn("onMediaAssetExpire, should not handle media asset expired", new Object[0]);
            return;
        }
        this.mLogger.info("onMediaAssetExpire, request update user info", new Object[0]);
        notifyInfoMsg(547, 0L, 0L, null);
        this.mHandler.postDelayed(new Runnable() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.j
            @Override // java.lang.Runnable
            public final void run() {
                TVKUniversalMediaAssetExpiredWithReopenFunction.this.handleMediaAssetExpired();
            }
        }, TVKMediaPlayerConfig.PlayerConfig.media_asset_expire_wait_user_info_update_timeout_ms);
    }

    private void updateUserInfo(TVKUserInfo tVKUserInfo) {
        this.mLogger.info("[updateUserInfo] set userInfo to input param", new Object[0]);
        this.mAssetPlayerContext.getInputParam().setUserInfo(tVKUserInfo);
        if (!this.mShouldHandleMediaAssetExpired) {
            this.mLogger.warn("[updateUserInfo] should not handle media asset expired", new Object[0]);
            return;
        }
        this.mLogger.info("[updateUserInfo] handle media asset expired immediately", new Object[0]);
        this.mHandler.removeCallbacksAndMessages(null);
        handleMediaAssetExpired();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodOnMediaAssetExpire, method)) {
            this.mShouldHandleMediaAssetExpired = true;
            if (!TVKNetworkUtils.isNetworkAvailable() && TVKMediaPlayerConfig.PlayerConfig.enable_delay_request_userinfo_when_network_unavailable) {
                this.mLogger.info("onMediaAssetExpire, network unavailable", new Object[0]);
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
        this.mShouldHandleMediaAssetExpired = false;
        this.mIsMediaAssetExpirePendingNetwork = false;
        TVKGlobalEventNotifier.getInstance().removeEventListener(this.mNetworkChangeListener);
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        if (TVKMethodMatcher.isSameMethod(sTakeOverMethodUpdateUserInfo, method)) {
            updateUserInfo((TVKUserInfo) objArr[0]);
            return null;
        }
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

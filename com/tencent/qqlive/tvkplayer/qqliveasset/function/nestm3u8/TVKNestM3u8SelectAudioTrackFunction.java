package com.tencent.qqlive.tvkplayer.qqliveasset.function.nestm3u8;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKVodVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKTrackUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.strategy.ITVKSwitchDispatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.external.TVKAudioTrackExternal;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKAudioTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKNestM3u8SelectAudioTrackFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String API_CALL = "api call: ";
    private static final String TAG = "TVKNestM3u8SelectAudioTrackFunction";
    private static final Method sTakeOverMethodOnInfo;
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodSelectTrack;

    @Nullable
    private Object[] mCurrentTriggerArgArray;
    private Method mCurrentTriggerMethod;
    private final ITVKSwitchDispatcher mSelectAudioTrackDispatcher;
    private final List<TVKMethodMatcher> mTakeOverMethodMatcherList;

    static {
        try {
            Class cls = Integer.TYPE;
            sTriggerMethodSelectTrack = TVKQQLiveAssetPlayer.class.getMethod("selectTrack", cls);
            sTakeOverMethodOnInfo = TVKQQLiveAssetPlayer.class.getMethod("onInfo", cls, TPOnInfoParam.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method! please fix me", e16);
        }
    }

    public TVKNestM3u8SelectAudioTrackFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, TAG);
        ArrayList arrayList = new ArrayList();
        this.mTakeOverMethodMatcherList = arrayList;
        this.mSelectAudioTrackDispatcher = tVKQQLiveAssetPlayerContext.getAudioTrackSwitchDispatcher();
        arrayList.add(new TVKMethodMatcher(sTakeOverMethodOnInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.nestm3u8.c
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext2, Object[] objArr) {
                boolean lambda$new$2;
                lambda$new$2 = TVKNestM3u8SelectAudioTrackFunction.this.lambda$new$2(tVKQQLiveAssetPlayerContext2, objArr);
                return lambda$new$2;
            }
        }, null));
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSelectTrack, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.nestm3u8.a
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKNestM3u8SelectAudioTrackFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.nestm3u8.b
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKNestM3u8SelectAudioTrackFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        return arrayList;
    }

    private void dealAvsSeparateDolbyAudioTrack() {
        String audioTrack;
        TVKNetVideoInfo netVideoInfo = this.mAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (netVideoInfo.getCurAudioTrack() == null) {
            audioTrack = "";
        } else {
            audioTrack = netVideoInfo.getCurAudioTrack().getAudioTrack();
        }
        if (this.mAssetPlayerContext.getRuntimeParam().isAvsSeparateDolbyAudioTrackSwitching() && TVKNetVideoInfo.AUDIO_TRACK_DOLBY.equalsIgnoreCase(audioTrack)) {
            this.mLogger.info("onInfo, dealAvsSeparateDolbyAudioTrack, setAvsSeparateDolbyAudioTrackSwitching false", new Object[0]);
            this.mAssetPlayerContext.getRuntimeParam().setAvsSeparateDolbyAudioTrackSwitching(false);
        }
    }

    private void handleSelectTrackFailed(TPOnInfoParam tPOnInfoParam) {
        ITVKSwitchDispatcher.Ret driveTaskWhenPlayerFailed = this.mSelectAudioTrackDispatcher.driveTaskWhenPlayerFailed(tPOnInfoParam.getLongParam1());
        if (driveTaskWhenPlayerFailed.retCode == 0) {
            dealAvsSeparateDolbyAudioTrack();
            this.mLogger.info("onInfo, select audio track failed cause player error", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_SELECT_TRACK_ERR));
        } else {
            this.mLogger.warn("onInfo, driveTaskWhenPlayerFailed, retCode=" + driveTaskWhenPlayerFailed.retCode, new Object[0]);
        }
    }

    private void handleSelectTrackSuccess(TPOnInfoParam tPOnInfoParam) {
        ITVKSwitchDispatcher.Ret driveTaskWhenPlayerSuccess = this.mSelectAudioTrackDispatcher.driveTaskWhenPlayerSuccess(tPOnInfoParam.getLongParam1());
        if (driveTaskWhenPlayerSuccess.retCode == 0) {
            TVKTrackUtils.selectTrackByName(driveTaskWhenPlayerSuccess.info.getAudioTrack(), 2, this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList());
            notifyOnInfoMessage(126, driveTaskWhenPlayerSuccess.info.getAudioTrack());
            dealAvsSeparateDolbyAudioTrack();
            this.mLogger.info("onInfo, select audio track success", new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
            return;
        }
        this.mLogger.warn("onInfo, driveTaskWhenPlayerSuccess, retCode=" + driveTaskWhenPlayerSuccess.retCode, new Object[0]);
    }

    private static boolean isNestM3u8AVSVideoSource(@NonNull TVKVodVideoInfo tVKVodVideoInfo) {
        if (tVKVodVideoInfo.getMasterM3u8Info() != null && !TextUtils.isEmpty(tVKVodVideoInfo.getMasterM3u8Info().getM3u8Url()) && tVKVodVideoInfo.getCurDefinition() != null && tVKVodVideoInfo.getCurDefinition().isAvsSeparate()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        int intValue = ((Integer) objArr[0]).intValue();
        List<TVKTrackInfo> trackInfoList = tVKQQLiveAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (trackInfoList.size() <= intValue) {
            return false;
        }
        TVKTrackInfo tVKTrackInfo = trackInfoList.get(intValue);
        if (tVKTrackInfo.getTrackType() != 2 || (tVKTrackInfo instanceof TVKAudioTrackExternal)) {
            return false;
        }
        TVKNetVideoInfo netVideoInfo = tVKQQLiveAssetPlayerContext.getRuntimeParam().getNetVideoInfo();
        if (!TVKAssetUtils.isVodAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset()) || !isNestM3u8AVSVideoSource((TVKVodVideoInfo) netVideoInfo)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        TPOnInfoParam tPOnInfoParam;
        int intValue = ((Integer) objArr[0]).intValue();
        if ((intValue != 10 && intValue != 11 && intValue != 3) || (tPOnInfoParam = (TPOnInfoParam) objArr[1]) == null) {
            return false;
        }
        ITVKSwitchDispatcher.Ret queryTaskByTaskId = this.mSelectAudioTrackDispatcher.queryTaskByTaskId(tPOnInfoParam.getLongParam1());
        if (queryTaskByTaskId.retCode == 2 || queryTaskByTaskId.type != 1) {
            return false;
        }
        return true;
    }

    private void notifyOnInfoMessage(int i3, Object obj) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener == null) {
            this.mLogger.error("assetPlayerListener is null, can not notify onInfo", new Object[0]);
        } else {
            assetPlayerListener.onInfo(i3, 0L, 0L, obj);
        }
    }

    private void onInfo(int i3, TPOnInfoParam tPOnInfoParam) {
        if (i3 != 10 && i3 != 3) {
            if (i3 == 11) {
                handleSelectTrackFailed(tPOnInfoParam);
                return;
            }
            return;
        }
        handleSelectTrackSuccess(tPOnInfoParam);
    }

    private void resetAllAudioTrackInfoSelectedState() {
        for (TVKTrackInfo tVKTrackInfo : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (tVKTrackInfo.getTrackType() == 2) {
                tVKTrackInfo.setSelected(false);
            }
        }
    }

    private void selectAudioTrackByPlayer(TVKTrackInfo tVKTrackInfo, long j3) {
        int trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, this.mAssetPlayerContext.getPlayer().getTrackInfo());
        if (trackIdByName == -1) {
            this.mLogger.warn("selectAudioTrackByPlayer, but track id -1, failed .", new Object[0]);
            this.mSelectAudioTrackDispatcher.driveTaskWhenPlayerFailed(j3);
            this.mOnFunctionCompleteListener.onComplete(this);
        } else {
            notifyOnInfoMessage(524, tVKTrackInfo.getTrackName());
            resetAllAudioTrackInfoSelectedState();
            notifyOnInfoMessage(525, tVKTrackInfo.getTrackName());
            this.mAssetPlayerContext.getPlayer().selectTrackAsync(trackIdByName, j3);
        }
    }

    private void selectTrack(int i3) throws IllegalArgumentException, IllegalStateException {
        List<TVKTrackInfo> trackInfoList = this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (i3 >= 0 && i3 < trackInfoList.size()) {
            TVKAudioTrackVinfo tVKAudioTrackVinfo = (TVKAudioTrackVinfo) trackInfoList.get(i3);
            this.mLogger.info("api call: selectTrack, with index=" + i3 + " name=" + tVKAudioTrackVinfo.getTrackName(), new Object[0]);
            if (tVKAudioTrackVinfo.isSelected()) {
                this.mLogger.info("api call: selectTrack, audioTrackName=" + tVKAudioTrackVinfo.getTrackName() + " is already selected", new Object[0]);
                this.mOnFunctionCompleteListener.onComplete(this);
                return;
            }
            ITVKSwitchDispatcher.Ret addTask = this.mSelectAudioTrackDispatcher.addTask(new ITVKSwitchDispatcher.SwitchInfo.Builder().audioTrack(tVKAudioTrackVinfo.getTrackName()).build());
            if (addTask.retCode != 0) {
                return;
            }
            this.mAssetPlayerContext.getInputParam().setCurAudioTrack(tVKAudioTrackVinfo.getAudioTrackInfo().getAudioTrack());
            if (!tVKAudioTrackVinfo.getAudioTrackInfo().isAvsSeparate() && !TVKTrackUtils.isAudioTrackWithUrl(tVKAudioTrackVinfo.getAudioTrackInfo())) {
                this.mSelectAudioTrackDispatcher.driveTaskWhenPlayerFailed(addTask.taskId);
                this.mLogger.info("api call: selectTrack failed, empty audioTrackUrl cause player error", new Object[0]);
                processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_SELECT_TRACK_ERR));
                return;
            } else {
                this.mLogger.info("api call: selectTrack, audioTrack is AvsSeparate, no need to CGI", new Object[0]);
                selectAudioTrackByPlayer(tVKAudioTrackVinfo, addTask.taskId);
                return;
            }
        }
        this.mOnFunctionCompleteListener.onComplete(this);
        throw new IllegalArgumentException("selectTrack with illegal index=" + i3 + " trackInfoList.size=" + trackInfoList.size());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void cancel() {
        this.mSelectAudioTrackDispatcher.clear();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        if (tVKQQLiveAssetPlayerContext.getState().is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING)) {
            this.mOnFunctionCompleteListener.onComplete(this);
            return null;
        }
        selectTrack(((Integer) objArr[0]).intValue());
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
        return 1;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    @NonNull
    public List<TVKMethodMatcher> getTriggerMatcherList() throws IllegalStateException {
        return sTriggerMethodMatcherList;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected boolean processOnNetVideoInfoSuccess(int i3, @NonNull ITPMediaAsset iTPMediaAsset, @NonNull TVKNetVideoInfo tVKNetVideoInfo) {
        return true;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        if (TVKMethodMatcher.isSameMethod(sTakeOverMethodOnInfo, method)) {
            onInfo(((Integer) objArr[0]).intValue(), (TPOnInfoParam) objArr[1]);
        }
        return null;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected void processOnNetVideoInfoFailure(int i3, @NonNull TVKError tVKError) {
    }
}

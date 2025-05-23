package com.tencent.qqlive.tvkplayer.qqliveasset.function.regular;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.asset.TVKAssetUtils;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
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
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.qqlive.tvkplayer.tools.utils.TVKCommonErrorCodeUtil;
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
public class TVKRegularSelectAudioTrackFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String API_CALL = "api call: ";
    private static final String TAG = "TVKRegularSelectAudioTrackFunction";
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

    public TVKRegularSelectAudioTrackFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, TAG);
        ArrayList arrayList = new ArrayList();
        this.mTakeOverMethodMatcherList = arrayList;
        this.mSelectAudioTrackDispatcher = tVKQQLiveAssetPlayerContext.getAudioTrackSwitchDispatcher();
        arrayList.add(new TVKMethodMatcher(sTakeOverMethodOnInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.h
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext2, Object[] objArr) {
                boolean lambda$new$2;
                lambda$new$2 = TVKRegularSelectAudioTrackFunction.this.lambda$new$2(tVKQQLiveAssetPlayerContext2, objArr);
                return lambda$new$2;
            }
        }, null));
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSelectTrack, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.i
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean lambda$buildTriggerMethodMatchers$0;
                lambda$buildTriggerMethodMatchers$0 = TVKRegularSelectAudioTrackFunction.lambda$buildTriggerMethodMatchers$0(tVKQQLiveAssetPlayerContext, objArr);
                return lambda$buildTriggerMethodMatchers$0;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.j
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKRegularSelectAudioTrackFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        return arrayList;
    }

    private void handleSelectTrackFailed(TPOnInfoParam tPOnInfoParam) {
        ITVKSwitchDispatcher.Ret driveTaskWhenPlayerFailed = this.mSelectAudioTrackDispatcher.driveTaskWhenPlayerFailed(tPOnInfoParam.getLongParam1());
        if (driveTaskWhenPlayerFailed.retCode == 0) {
            this.mLogger.info("onInfo, select audio track failed cause player error", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_SELECT_TRACK_ERR));
            return;
        }
        this.mLogger.warn("onInfo, driveTaskWhenPlayerFailed, retCode=" + driveTaskWhenPlayerFailed.retCode, new Object[0]);
    }

    private void handleSelectTrackSuccess(TPOnInfoParam tPOnInfoParam) {
        ITVKSwitchDispatcher.Ret driveTaskWhenPlayerSuccess = this.mSelectAudioTrackDispatcher.driveTaskWhenPlayerSuccess(tPOnInfoParam.getLongParam1());
        if (driveTaskWhenPlayerSuccess.retCode == 0) {
            TVKTrackUtils.selectTrackByName(driveTaskWhenPlayerSuccess.info.getAudioTrack(), 2, this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList());
            notifyOnInfoMessage(126, driveTaskWhenPlayerSuccess.info.getAudioTrack());
            this.mLogger.info("onInfo, select audio track success", new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
            if (!TVKMediaPlayerConfig.PlayerConfig.enable_spatial_audio_rendering_all_time) {
                this.mAssetPlayerContext.getPlayer().addOptionalParam(TPOptionalParam.buildBoolean(TPOptionalID.OPTIONAL_ID_GLOBAL_BOOL_ENABLE_AUDIO_SPATIAL_RENDERING, needEnableAudioSpatialRendering(driveTaskWhenPlayerSuccess.info.getAudioTrack())));
                return;
            }
            return;
        }
        this.mLogger.warn("onInfo, driveTaskWhenPlayerSuccess, retCode=" + driveTaskWhenPlayerSuccess.retCode, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$0(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        int intValue = ((Integer) objArr[0]).intValue();
        List<TVKTrackInfo> trackInfoList = tVKQQLiveAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (trackInfoList.size() <= intValue) {
            return false;
        }
        TVKTrackInfo tVKTrackInfo = trackInfoList.get(intValue);
        if (tVKTrackInfo.getTrackType() != 2) {
            return false;
        }
        if ((tVKTrackInfo instanceof TVKAudioTrackVinfo) && ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo().isAvsSeparate()) {
            return false;
        }
        return TVKAssetUtils.isQQLiveAsset(tVKQQLiveAssetPlayerContext.getRuntimeParam().getTVKAsset());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$2(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        TPOnInfoParam tPOnInfoParam;
        int intValue = ((Integer) objArr[0]).intValue();
        if ((intValue != 10 && intValue != 11) || (tPOnInfoParam = (TPOnInfoParam) objArr[1]) == null) {
            return false;
        }
        ITVKSwitchDispatcher.Ret queryTaskByTaskId = this.mSelectAudioTrackDispatcher.queryTaskByTaskId(tPOnInfoParam.getLongParam1());
        if (queryTaskByTaskId.retCode == 2 || queryTaskByTaskId.type != 1) {
            return false;
        }
        return true;
    }

    private boolean needEnableAudioSpatialRendering(String str) {
        TVKTrackInfo tVKTrackInfo = null;
        for (TVKTrackInfo tVKTrackInfo2 : this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList()) {
            if (TextUtils.equals(tVKTrackInfo2.getTrackName(), str)) {
                tVKTrackInfo = tVKTrackInfo2;
            }
        }
        if (tVKTrackInfo == null || !(tVKTrackInfo instanceof TVKAudioTrackVinfo)) {
            return false;
        }
        TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo();
        if (audioTrackInfo.getTrackType() != 0) {
            return false;
        }
        if (audioTrackInfo.getAudioType() != 8 && audioTrackInfo.getAudioType() != 9) {
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
        if (i3 == 10) {
            handleSelectTrackSuccess(tPOnInfoParam);
        } else if (i3 == 11) {
            handleSelectTrackFailed(tPOnInfoParam);
        }
    }

    private void recordTrackSelectedBeforePrepared(int i3) {
        TVKNetVideoInfo.AudioTrackInfo audioTrackInfo;
        this.mLogger.info("selectTrack, state=" + this.mAssetPlayerContext.getState() + " less than prepared, record track index=" + i3, new Object[0]);
        List<TVKTrackInfo> trackInfoList = this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (i3 >= 0 && i3 < trackInfoList.size()) {
            TVKTrackInfo tVKTrackInfo = trackInfoList.get(i3);
            if (tVKTrackInfo.getTrackType() == 2) {
                for (TVKTrackInfo tVKTrackInfo2 : trackInfoList) {
                    if (tVKTrackInfo2.getTrackType() == 2) {
                        tVKTrackInfo2.setSelected(false);
                    }
                }
                if ((tVKTrackInfo instanceof TVKAudioTrackVinfo) && ((audioTrackInfo = ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo()) == null || TextUtils.isEmpty(audioTrackInfo.getAudioPlayUrl()))) {
                    this.mLogger.warn("selectTrack invalid, audioTrack=" + audioTrackInfo + ", url is null", new Object[0]);
                    return;
                }
                tVKTrackInfo.setSelected(true);
                return;
            }
            this.mLogger.warn("selectTrack invalid, not audio track", new Object[0]);
            return;
        }
        this.mLogger.warn("selectTrack, invalid index=" + i3 + ", trackInfoList size is " + trackInfoList.size(), new Object[0]);
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
            this.mAssetPlayerContext.getMediaTrackSelector().addAudioTrackToPlayerCore(tVKTrackInfo);
            trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, this.mAssetPlayerContext.getPlayer().getTrackInfo());
        }
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

    private void selectAudioTrackInfoExternal(TVKTrackInfo tVKTrackInfo, ITVKSwitchDispatcher.Ret ret) {
        this.mAssetPlayerContext.getInputParam().setCurAudioTrack("");
        if (!TextUtils.isEmpty(((TVKAudioTrackExternal) tVKTrackInfo).getAudioTrackUrl())) {
            this.mLogger.info("api call: selectTrack, externally added audioTrack has a url", new Object[0]);
            selectAudioTrackByPlayer(tVKTrackInfo, ret.taskId);
        } else {
            this.mLogger.warn("api call: selectTrack failed, externally added audioTrack has no url", new Object[0]);
            this.mOnFunctionCompleteListener.onComplete(this);
        }
    }

    private void selectAudioTrackInfoInner(TVKTrackInfo tVKTrackInfo, ITVKSwitchDispatcher.Ret ret) {
        TVKNetVideoInfo.AudioTrackInfo audioTrackInfo = ((TVKAudioTrackVinfo) tVKTrackInfo).getAudioTrackInfo();
        this.mAssetPlayerContext.getInputParam().setCurAudioTrack(audioTrackInfo.getAudioTrack());
        if (!TVKTrackUtils.isInternalAudioTrack(tVKTrackInfo) && !TVKTrackUtils.isAudioTrackWithUrl(audioTrackInfo)) {
            this.mSelectAudioTrackDispatcher.driveTaskWhenPlayerFailed(ret.taskId);
            this.mLogger.info("selectTrack failed, empty audioTrackUrl cause player error", new Object[0]);
            processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_SELECT_TRACK_ERR));
        } else {
            this.mLogger.info("api call: selectTrack, audioTrack is Internal or vinfo external has a url", new Object[0]);
            selectAudioTrackByPlayer(tVKTrackInfo, ret.taskId);
        }
    }

    private void selectTrack(int i3) throws IllegalArgumentException, IllegalStateException {
        List<TVKTrackInfo> trackInfoList = this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (i3 >= 0 && i3 < trackInfoList.size()) {
            TVKTrackInfo tVKTrackInfo = trackInfoList.get(i3);
            this.mLogger.info("api call: selectTrack, with index=" + i3 + ", name=" + tVKTrackInfo.getTrackName(), new Object[0]);
            if (tVKTrackInfo.isSelected()) {
                this.mLogger.info("api call: selectTrack, audioTrackName=" + tVKTrackInfo.getTrackName() + " is already selected", new Object[0]);
                this.mOnFunctionCompleteListener.onComplete(this);
                return;
            }
            if (!TVKMediaPlayerConfig.PlayerConfig.is_support_multi_audiotrack) {
                processPlayerErrorAndFinishFunction(new TVKError(TVKCommonErrorCodeUtil.MODULE.PLAY_QQLIVE_ASSET_ERR, TVKCommonErrorCodeUtil.CODE.LOGIC.PLAYER_NOT_SUPPORT_ERR));
                return;
            }
            ITVKSwitchDispatcher.Ret addTask = this.mSelectAudioTrackDispatcher.addTask(new ITVKSwitchDispatcher.SwitchInfo.Builder().audioTrack(tVKTrackInfo.getTrackName()).build());
            if (addTask.retCode != 0) {
                return;
            }
            if (tVKTrackInfo instanceof TVKAudioTrackExternal) {
                selectAudioTrackInfoExternal(tVKTrackInfo, addTask);
                return;
            } else {
                selectAudioTrackInfoInner(tVKTrackInfo, addTask);
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
            recordTrackSelectedBeforePrepared(((Integer) objArr[0]).intValue());
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
        return 2;
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

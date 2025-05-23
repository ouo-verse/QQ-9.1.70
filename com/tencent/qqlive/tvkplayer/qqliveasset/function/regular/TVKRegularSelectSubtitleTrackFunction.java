package com.tencent.qqlive.tvkplayer.qqliveasset.function.regular;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.tvkplayer.api.TVKError;
import com.tencent.qqlive.tvkplayer.api.TVKTrackInfo;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.api.ITVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.common.TVKTrackUtils;
import com.tencent.qqlive.tvkplayer.qqliveasset.context.TVKQQLiveAssetPlayerContext;
import com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.TVKQQLiveAssetPlayer;
import com.tencent.qqlive.tvkplayer.qqliveasset.state.ITVKPlayerState;
import com.tencent.qqlive.tvkplayer.qqliveasset.track.vinfo.TVKSubtitleTrackVinfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher;
import com.tencent.qqlive.tvkplayer.qqliveasset.trigger.TVKMethodMatcher;
import com.tencent.qqlive.tvkplayer.tools.log.ITVKLogger;
import com.tencent.thumbplayer.api.asset.ITPMediaAsset;
import com.tencent.thumbplayer.api.common.TPError;
import com.tencent.thumbplayer.api.common.TPOnInfoParam;
import com.tencent.thumbplayer.api.common.TPTrackInfo;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRegularSelectSubtitleTrackFunction extends TVKBaseUniversalAccompanyFunction {
    private static final String API_CALL = "api call: ";
    private static final String TAG = "TVKRegularSelectSubtitleTrackFunction";
    private static final Method sTakeOverMethodOnInfo;
    private static final Method sTriggerMethodDeselectTrack;
    private static final List<TVKMethodMatcher> sTriggerMethodMatcherList;
    private static final Method sTriggerMethodSelectTrack;

    @Nullable
    private Object[] mCurrentTriggerArgArray;
    private Method mCurrentTriggerMethod;

    @NonNull
    private final TVKSubtitleTrackSwitchDispatcher mSubtitleTrackSwitchDispatcher;
    private final List<TVKMethodMatcher> mTakeOverMethodMatcherList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class TVKSubtitleTrackSwitchDispatcher {
        private static final AtomicLong sTaskId = new AtomicLong(20000);
        private final Map<Long, TVKTrackInfo> mTaskIdToTrackInfoMap;

        TVKSubtitleTrackSwitchDispatcher() {
            this.mTaskIdToTrackInfoMap = new HashMap();
        }

        public long addTask(@NonNull TVKTrackInfo tVKTrackInfo) {
            long andIncrement = sTaskId.getAndIncrement();
            this.mTaskIdToTrackInfoMap.put(Long.valueOf(andIncrement), tVKTrackInfo);
            return andIncrement;
        }

        public void clear() {
            this.mTaskIdToTrackInfoMap.clear();
        }

        @Nullable
        public TVKTrackInfo driveTaskWhenPlayerFailed(long j3) {
            return this.mTaskIdToTrackInfoMap.remove(Long.valueOf(j3));
        }

        @Nullable
        public TVKTrackInfo driveTaskWhenPlayerSuccess(long j3) {
            return this.mTaskIdToTrackInfoMap.remove(Long.valueOf(j3));
        }

        public boolean hasAllTaskFinished() {
            return this.mTaskIdToTrackInfoMap.isEmpty();
        }

        public TVKTrackInfo queryTrackInfoByTaskId(long j3) {
            return this.mTaskIdToTrackInfoMap.get(Long.valueOf(j3));
        }
    }

    static {
        try {
            Class cls = Integer.TYPE;
            sTriggerMethodSelectTrack = TVKQQLiveAssetPlayer.class.getMethod("selectTrack", cls);
            sTriggerMethodDeselectTrack = TVKQQLiveAssetPlayer.class.getMethod("deselectTrack", cls);
            sTakeOverMethodOnInfo = TVKQQLiveAssetPlayer.class.getMethod("onInfo", cls, TPOnInfoParam.class);
            sTriggerMethodMatcherList = buildTriggerMethodMatchers();
        } catch (NoSuchMethodException e16) {
            throw new RuntimeException("no such method! please fix me", e16);
        }
    }

    public TVKRegularSelectSubtitleTrackFunction(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext) {
        super(tVKQQLiveAssetPlayerContext, TAG);
        ArrayList arrayList = new ArrayList();
        this.mTakeOverMethodMatcherList = arrayList;
        this.mSubtitleTrackSwitchDispatcher = new TVKSubtitleTrackSwitchDispatcher();
        arrayList.add(new TVKMethodMatcher(sTakeOverMethodOnInfo, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.k
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext2, Object[] objArr) {
                boolean lambda$new$4;
                lambda$new$4 = TVKRegularSelectSubtitleTrackFunction.this.lambda$new$4(tVKQQLiveAssetPlayerContext2, objArr);
                return lambda$new$4;
            }
        }, null));
    }

    private static List<TVKMethodMatcher> buildTriggerMethodMatchers() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TVKMethodMatcher(sTriggerMethodSelectTrack, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.l
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean isArgsMatch;
                isArgsMatch = TVKRegularSelectSubtitleTrackFunction.isArgsMatch(tVKQQLiveAssetPlayerContext, objArr);
                return isArgsMatch;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.m
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$1;
                lambda$buildTriggerMethodMatchers$1 = TVKRegularSelectSubtitleTrackFunction.lambda$buildTriggerMethodMatchers$1(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$1;
            }
        }));
        arrayList.add(new TVKMethodMatcher(sTriggerMethodDeselectTrack, new ITVKArgsMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.n
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKArgsMatcher
            public final boolean isMatch(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
                boolean isArgsMatch;
                isArgsMatch = TVKRegularSelectSubtitleTrackFunction.isArgsMatch(tVKQQLiveAssetPlayerContext, objArr);
                return isArgsMatch;
            }
        }, new ITVKStateMatcher() { // from class: com.tencent.qqlive.tvkplayer.qqliveasset.function.regular.o
            @Override // com.tencent.qqlive.tvkplayer.qqliveasset.trigger.ITVKStateMatcher
            public final boolean isMatch(ITVKPlayerState iTVKPlayerState) {
                boolean lambda$buildTriggerMethodMatchers$3;
                lambda$buildTriggerMethodMatchers$3 = TVKRegularSelectSubtitleTrackFunction.lambda$buildTriggerMethodMatchers$3(iTVKPlayerState);
                return lambda$buildTriggerMethodMatchers$3;
            }
        }));
        return arrayList;
    }

    private boolean deselectTrack(int i3) {
        List<TVKTrackInfo> trackInfoList = this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (i3 >= 0 && i3 < trackInfoList.size()) {
            TVKTrackInfo tVKTrackInfo = trackInfoList.get(i3);
            if (this.mAssetPlayerContext.getState().is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING)) {
                this.mLogger.info("deselectTrack, state=" + this.mAssetPlayerContext.getState() + " less than prepared, record track index=" + i3, new Object[0]);
                recordTrackDeselectedBeforePrepared(tVKTrackInfo);
                return false;
            }
            this.mLogger.info("api call: deselectTrack, with index=" + i3 + " name=" + tVKTrackInfo.getTrackName(), new Object[0]);
            ITVKLogger iTVKLogger = this.mLogger;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("deselectSubtitle start, trackName: ");
            sb5.append(tVKTrackInfo.getTrackName());
            iTVKLogger.info(sb5.toString(), new Object[0]);
            TPTrackInfo[] trackInfo = this.mAssetPlayerContext.getPlayer().getTrackInfo();
            int trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, trackInfo);
            if (trackIdByName != -1 && trackInfo[trackIdByName].isSelected()) {
                notifyOnInfoMessage(127, "");
                this.mAssetPlayerContext.getPlayer().deselectTrackAsync(trackIdByName, this.mSubtitleTrackSwitchDispatcher.addTask(tVKTrackInfo));
                return true;
            }
            this.mLogger.warn("deselectSubtitle , but no selected track in player", new Object[0]);
            return false;
        }
        throw new IllegalArgumentException("deselectTrack with illegal index=" + i3 + " trackInfoList.size=" + trackInfoList.size());
    }

    private void handleDeselectTrackFailed(TPOnInfoParam tPOnInfoParam) {
        long longParam1 = tPOnInfoParam.getLongParam1();
        if (this.mSubtitleTrackSwitchDispatcher.driveTaskWhenPlayerFailed(longParam1) == null) {
            this.mLogger.warn("onInfo, player deselect track failed, but not subtitle task", new Object[0]);
            return;
        }
        TPError tPError = (TPError) tPOnInfoParam.getObjParam();
        this.mLogger.info("onInfo, player deselect subtitle track failed , opaque:" + longParam1, new Object[0]);
        notifyOnInfoMessage(128, (long) tPError.getErrorCode(), 0L, "");
        if (this.mSubtitleTrackSwitchDispatcher.hasAllTaskFinished()) {
            this.mOnFunctionCompleteListener.onComplete(this);
        } else {
            this.mLogger.info("handleDeselectTrackFailed, there are pending subtitle tracks to select or deselect", new Object[0]);
        }
    }

    private void handleDeselectTrackSuccess(TPOnInfoParam tPOnInfoParam) {
        long longParam1 = tPOnInfoParam.getLongParam1();
        TVKTrackInfo driveTaskWhenPlayerSuccess = this.mSubtitleTrackSwitchDispatcher.driveTaskWhenPlayerSuccess(longParam1);
        if (driveTaskWhenPlayerSuccess == null) {
            this.mLogger.warn("onInfo, player deselect track success, but not subtitle task", new Object[0]);
            return;
        }
        this.mLogger.info("onInfo, player deselect subtitle track success , opaque:" + longParam1, new Object[0]);
        TVKTrackUtils.deselectTrackByName(driveTaskWhenPlayerSuccess.getTrackName(), 3, this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList());
        notifyOnInfoMessage(128, 0L, 0L, "");
        if (this.mSubtitleTrackSwitchDispatcher.hasAllTaskFinished()) {
            this.mOnFunctionCompleteListener.onComplete(this);
        } else {
            this.mLogger.info("handleDeselectTrackSuccess, there are pending subtitle tracks to select or deselect", new Object[0]);
        }
    }

    private void handleSelectTrackFailed(TPOnInfoParam tPOnInfoParam) {
        long longParam1 = tPOnInfoParam.getLongParam1();
        TVKTrackInfo driveTaskWhenPlayerFailed = this.mSubtitleTrackSwitchDispatcher.driveTaskWhenPlayerFailed(longParam1);
        if (driveTaskWhenPlayerFailed == null) {
            this.mLogger.warn("onInfo, player select track failed, but not subtitle task", new Object[0]);
            return;
        }
        TPError tPError = (TPError) tPOnInfoParam.getObjParam();
        this.mLogger.info("onInfo, player select subtitle track failed , opaque:" + longParam1, new Object[0]);
        notifyOnInfoMessage(128, (long) tPError.getErrorCode(), 0L, driveTaskWhenPlayerFailed.getTrackName());
        if (this.mSubtitleTrackSwitchDispatcher.hasAllTaskFinished()) {
            this.mOnFunctionCompleteListener.onComplete(this);
        } else {
            this.mLogger.info("handleSelectTrackFailed, there are pending subtitle tracks to select or deselect", new Object[0]);
        }
    }

    private void handleSelectTrackSuccess(TPOnInfoParam tPOnInfoParam) {
        long longParam1 = tPOnInfoParam.getLongParam1();
        TVKTrackInfo driveTaskWhenPlayerSuccess = this.mSubtitleTrackSwitchDispatcher.driveTaskWhenPlayerSuccess(longParam1);
        if (driveTaskWhenPlayerSuccess == null) {
            this.mLogger.warn("onInfo, player select track success, but not subtitle task", new Object[0]);
            return;
        }
        this.mLogger.info("onInfo, player select subtitle track success , opaque:" + longParam1, new Object[0]);
        TVKTrackUtils.selectTrackByName(driveTaskWhenPlayerSuccess.getTrackName(), 3, this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList());
        notifyOnInfoMessage(128, 0L, 0L, driveTaskWhenPlayerSuccess.getTrackName());
        if (this.mSubtitleTrackSwitchDispatcher.hasAllTaskFinished()) {
            this.mOnFunctionCompleteListener.onComplete(this);
        } else {
            this.mLogger.info("handleSelectTrackSuccess, there are pending subtitle tracks to select or deselect", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isArgsMatch(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object... objArr) {
        int intValue = ((Integer) objArr[0]).intValue();
        List<TVKTrackInfo> trackInfoList = tVKQQLiveAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (trackInfoList.size() <= intValue || trackInfoList.get(intValue).getTrackType() != 3) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$1(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$buildTriggerMethodMatchers$3(ITVKPlayerState iTVKPlayerState) {
        return iTVKPlayerState.is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING, ITVKPlayerState.STATE.PREPARED, ITVKPlayerState.STATE.STARTED, ITVKPlayerState.STATE.PAUSED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$new$4(TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, Object[] objArr) {
        TPOnInfoParam tPOnInfoParam;
        int intValue = ((Integer) objArr[0]).intValue();
        if ((intValue != 10 && intValue != 11 && intValue != 12 && intValue != 13) || (tPOnInfoParam = (TPOnInfoParam) objArr[1]) == null || this.mSubtitleTrackSwitchDispatcher.queryTrackInfoByTaskId(tPOnInfoParam.getLongParam1()) == null) {
            return false;
        }
        return true;
    }

    private void notifyOnInfoMessage(int i3, Object obj) {
        notifyOnInfoMessage(i3, 0L, 0L, obj);
    }

    private void onInfo(int i3, TPOnInfoParam tPOnInfoParam) {
        if (i3 == 10) {
            handleSelectTrackSuccess(tPOnInfoParam);
            return;
        }
        if (i3 == 11) {
            handleSelectTrackFailed(tPOnInfoParam);
        } else if (i3 == 12) {
            handleDeselectTrackSuccess(tPOnInfoParam);
        } else if (i3 == 13) {
            handleDeselectTrackFailed(tPOnInfoParam);
        }
    }

    private void recordTrackDeselectedBeforePrepared(TVKTrackInfo tVKTrackInfo) {
        if (TVKTrackUtils.isAvsSeparateTrack(tVKTrackInfo)) {
            this.mLogger.info("deselectTrack, current track is avs separate, can't be deselected before the PREPARED state", new Object[0]);
        } else {
            tVKTrackInfo.setSelected(false);
        }
    }

    private void recordTrackSelectedBeforePrepared(TVKTrackInfo tVKTrackInfo) {
        if (TVKTrackUtils.isAvsSeparateTrack(tVKTrackInfo)) {
            this.mLogger.info("selectTrack, select track is avs separate, can't be selected before the PREPARED state", new Object[0]);
        } else {
            tVKTrackInfo.setSelected(true);
        }
    }

    private boolean selectTrack(int i3) throws IllegalArgumentException, IllegalStateException {
        List<TVKTrackInfo> trackInfoList = this.mAssetPlayerContext.getRuntimeParam().getTrackInfoList();
        if (i3 >= 0 && i3 < trackInfoList.size()) {
            TVKTrackInfo tVKTrackInfo = trackInfoList.get(i3);
            if (this.mAssetPlayerContext.getState().is(ITVKPlayerState.STATE.IDLE, ITVKPlayerState.STATE.CGING, ITVKPlayerState.STATE.CGIED, ITVKPlayerState.STATE.PREPARING)) {
                this.mLogger.info("selectTrack, state=" + this.mAssetPlayerContext.getState() + " less than prepared, record track index=" + i3, new Object[0]);
                recordTrackSelectedBeforePrepared(tVKTrackInfo);
                return false;
            }
            this.mLogger.info("api call: selectTrack, with index=" + i3 + " name=" + tVKTrackInfo.getTrackName(), new Object[0]);
            int trackIdByName = TVKTrackUtils.getTrackIdByName(tVKTrackInfo, this.mAssetPlayerContext.getPlayer().getTrackInfo());
            if (trackIdByName == -1) {
                this.mLogger.warn("switch subtitle , but player track id -1, failed", new Object[0]);
                return false;
            }
            if (tVKTrackInfo instanceof TVKSubtitleTrackVinfo) {
                this.mAssetPlayerContext.getInputParam().setCurSubtitleTrack(String.valueOf(((TVKSubtitleTrackVinfo) tVKTrackInfo).getSubTitle().getLangId()));
            } else {
                this.mAssetPlayerContext.getInputParam().setCurSubtitleTrack("");
            }
            notifyOnInfoMessage(127, tVKTrackInfo.getTrackName());
            this.mAssetPlayerContext.getPlayer().selectTrackAsync(trackIdByName, this.mSubtitleTrackSwitchDispatcher.addTask(tVKTrackInfo));
            return true;
        }
        throw new IllegalArgumentException("selectTrack with illegal index=" + i3 + " trackInfoList.size=" + trackInfoList.size());
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public boolean consumeNotification(@NonNull Method method, Object... objArr) {
        return false;
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object execute(@NonNull TVKQQLiveAssetPlayerContext tVKQQLiveAssetPlayerContext, @NonNull Method method, Object... objArr) throws Exception {
        this.mCurrentTriggerMethod = method;
        this.mCurrentTriggerArgArray = objArr;
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodSelectTrack, method)) {
            if (!selectTrack(((Integer) objArr[0]).intValue()) && this.mSubtitleTrackSwitchDispatcher.hasAllTaskFinished()) {
                this.mOnFunctionCompleteListener.onComplete(this);
            }
            return null;
        }
        if (TVKMethodMatcher.isSameMethod(sTriggerMethodDeselectTrack, method) && !deselectTrack(((Integer) objArr[0]).intValue()) && this.mSubtitleTrackSwitchDispatcher.hasAllTaskFinished()) {
            this.mOnFunctionCompleteListener.onComplete(this);
        }
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

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.TVKBaseAccompanyFunction, com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void reset() {
        this.mSubtitleTrackSwitchDispatcher.clear();
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public Object takeOverMethod(@NonNull Method method, Object... objArr) {
        if (TVKMethodMatcher.isSameMethod(sTakeOverMethodOnInfo, method)) {
            onInfo(((Integer) objArr[0]).intValue(), (TPOnInfoParam) objArr[1]);
        }
        return null;
    }

    private void notifyOnInfoMessage(int i3, long j3, long j16, Object obj) {
        ITVKQQLiveAssetPlayer.ITVKQQLiveAssetPlayerListener assetPlayerListener = this.mAssetPlayerContext.getAssetPlayerListener();
        if (assetPlayerListener == null) {
            this.mLogger.error("assetPlayerListener is null, can not notify onInfo", new Object[0]);
        } else {
            assetPlayerListener.onInfo(i3, j3, j16, obj);
        }
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.ITVKFunction
    public void cancel() {
    }

    @Override // com.tencent.qqlive.tvkplayer.qqliveasset.function.universal.TVKBaseUniversalAccompanyFunction
    protected void processOnNetVideoInfoFailure(int i3, @NonNull TVKError tVKError) {
    }
}

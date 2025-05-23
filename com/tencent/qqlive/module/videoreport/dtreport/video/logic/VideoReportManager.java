package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConfigConstants;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoBaseEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoEntity;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.OnInfoTaskManager;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoReportManager {
    private static final String TAG = "video.VideoReportManager";
    private final Map<Integer, Object> bizPlayerToNativePlayer;
    private final Map<String, com.tencent.qqlive.module.videoreport.dtreport.video.data.a> historyPlayInfo;
    private VideoSession lastVideoSession;
    private final OnInfoTaskManager onInfoTaskManager;
    private a onPlayerInfoChangeListener;
    private final Map<Integer, Object> playerToDataSource;
    private final Map<Integer, VideoReportFlowInfo> playerToFlow;
    private final Map<Integer, VideoSession> playerToSession;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class InstanceHolder {
        static VideoReportManager sInstance = new VideoReportManager();

        InstanceHolder() {
        }
    }

    private void addHistoryPlayInfo(@NonNull VideoSession videoSession) {
        this.historyPlayInfo.put(generateHistoryPlayInfoKey(videoSession), videoSession.getPlayHistory());
    }

    private void changeState(@NonNull Object obj, int i3) {
        getValidReportFlowInfo(obj).setVideoState(i3);
    }

    private VideoSession createAdSessionFromVideoSession(Object obj, VideoSession videoSession) {
        return new VideoSession(new VideoEntity.Builder().setContentId(videoSession.getContentId()).addCustomParams(videoSession.getCustomParams()).setContentType(1).bizReady(true).setVideoDuration(VideoReportPlayerUtils.getDuration(obj)).setVideoView(videoSession.getVideoView()).build(), new Object().hashCode());
    }

    private void dealPlayEnd(Object obj, int i3, int i16, String str) {
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        if (getPlayerState(obj) != 2) {
            Log.d(TAG, "dealPlayEnd(), state error\uff0cno need report! state=" + VideoReportPlayerUtils.stateToString(getPlayerState(obj)));
            VideoReportPlayerUtils.debugEnd(str, debugStart);
            return;
        }
        VideoReportFlowInfo videoReportFlowInfo = this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        if (videoReportFlowInfo == null) {
            Log.w(TAG, "dealPlayEnd(), " + str + " playerInfo is null! ptr=" + obj);
            return;
        }
        VideoSession videoSession = videoReportFlowInfo.getVideoSession();
        if (videoSession == null) {
            Log.w(TAG, "dealPlayEnd(), " + str + " session is null!");
            VideoReportPlayerUtils.debugEnd(str, debugStart);
            return;
        }
        if (videoSession.isIgnoreReport()) {
            Log.w(TAG, "dealPlayEnd(), ignore, not need report!");
            VideoReportPlayerUtils.debugEnd(str, debugStart);
            return;
        }
        forceReportStartEventIfNeed(obj, videoSession);
        videoSession.end(VideoReportPlayerUtils.getCurrentPosition(obj), i3);
        changeState(obj, i16);
        VideoPageReporter.getInstance().reportEndEvent(obj, videoSession);
        addHistoryPlayInfo(videoSession);
        VideoReportPlayerUtils.debugEnd(str, debugStart);
        Log.i(TAG, "dealPlayEnd(), endReason:" + i3 + " ,endState:" + i16 + " ,endTag:" + str + " ,ptr=" + obj);
        VideoHeartBeatManager.getInstance().stopStagingHeartBeat();
    }

    private void dealPlayStart(Object obj, boolean z16) {
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        if (getPlayerState(obj) == 2) {
            Log.w(TAG, "dealPlayStart(), state error\uff0cno need report! state=" + VideoReportPlayerUtils.stateToString(getPlayerState(obj)));
            VideoReportPlayerUtils.debugEnd("start", debugStart);
            return;
        }
        VideoEntity videoEntityFromPlayer = getVideoEntityFromPlayer(obj);
        if (videoEntityFromPlayer == null) {
            Log.e(TAG, "dealPlayStart(), failed to get player VideoEntity");
            return;
        }
        int hashCode = obj.hashCode();
        int bizPlayer = videoEntityFromPlayer.getBizPlayer();
        this.bizPlayerToNativePlayer.put(Integer.valueOf(bizPlayer), obj);
        VideoSession currentPlaySession = getCurrentPlaySession(obj);
        if (currentPlaySession == null) {
            currentPlaySession = new VideoSession(videoEntityFromPlayer, bizPlayer);
            this.playerToSession.put(Integer.valueOf(hashCode), currentPlaySession);
        }
        Log.d(TAG, "dealPlayStart(), getCurrentPlaySession, " + VideoReportPlayerUtils.sessionLog(currentPlaySession));
        if (currentPlaySession.isIgnoreReport()) {
            Log.w(TAG, "dealPlayStart(), ignore, not need report!, ptr=" + obj);
            VideoReportPlayerUtils.debugEnd("start", debugStart);
            return;
        }
        int i3 = 1;
        if (1 != currentPlaySession.getContentType() && isPlayAd(obj)) {
            currentPlaySession = createAdSessionFromVideoSession(obj, currentPlaySession);
            this.playerToSession.put(Integer.valueOf(hashCode), currentPlaySession);
        }
        if (!isCurrentVideoSessionValid(currentPlaySession)) {
            Log.w(TAG, "dealPlayStart(), has unbind player. no need report!, ptr=" + obj);
            VideoReportPlayerUtils.debugEnd("start", debugStart);
            return;
        }
        VideoReportFlowInfo validReportFlowInfo = getValidReportFlowInfo(obj);
        int playType = playType(currentPlaySession);
        long startPosition = startPosition(obj, z16);
        if (!z16) {
            i3 = startPlayReason(currentPlaySession, startPosition);
        }
        currentPlaySession.start(i3, startPosition, playType, validReportFlowInfo.getPlaySpeedRatio());
        Log.w(TAG, "dealPlayStart(), isBizReady=" + currentPlaySession.isBizReady() + ", ptr=" + obj);
        if (currentPlaySession.isBizReady()) {
            VideoPageReporter.getInstance().tryReportStartEvent(obj, currentPlaySession);
        } else {
            VideoPageReporter.getInstance().stashStartEvent(obj, currentPlaySession);
        }
        validReportFlowInfo.setVideoSession(currentPlaySession);
        validReportFlowInfo.setPlayerObject(currentPlaySession.getVideoPlayerObject());
        changeState(obj, 2);
        VideoReportPlayerUtils.debugEnd("start", debugStart);
        VideoHeartBeatManager.getInstance().startStagingHeartBeat();
    }

    private synchronized void forceReportStartEventIfNeed(Object obj, VideoSession videoSession) {
        if (!videoSession.isBizReady() || videoSession.hasStashStart()) {
            VideoPageReporter.getInstance().forceReportStartEvent(obj, videoSession);
            videoSession.bizReady();
        }
    }

    private String generateHistoryPlayInfoKey(@NonNull VideoSession videoSession) {
        return videoSession.getContentId() + "_" + videoSession.getContentType();
    }

    @Nullable
    private VideoSession getCurrentPlaySession(Object obj) {
        VideoReportFlowInfo videoReportFlowInfo = this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        if (videoReportFlowInfo == null) {
            return null;
        }
        return videoReportFlowInfo.getVideoSession();
    }

    private com.tencent.qqlive.module.videoreport.dtreport.video.data.a getHistoryPlayInfo(@NonNull VideoSession videoSession) {
        return this.historyPlayInfo.get(generateHistoryPlayInfoKey(videoSession));
    }

    public static VideoReportManager getInstance() {
        return InstanceHolder.sInstance;
    }

    private int getPlayerState(Object obj) {
        VideoReportFlowInfo videoReportFlowInfo = this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        if (videoReportFlowInfo != null) {
            return videoReportFlowInfo.getVideoState();
        }
        return -1;
    }

    @NonNull
    private VideoReportFlowInfo getValidReportFlowInfo(Object obj) {
        VideoReportFlowInfo videoReportFlowInfo = this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        if (videoReportFlowInfo == null) {
            VideoReportFlowInfo videoReportFlowInfo2 = new VideoReportFlowInfo();
            this.playerToFlow.put(Integer.valueOf(obj.hashCode()), videoReportFlowInfo2);
            return videoReportFlowInfo2;
        }
        return videoReportFlowInfo;
    }

    @Nullable
    private VideoEntity getVideoEntityFromPlayer(Object obj) {
        return VideoReportPlayerUtils.getVideoEntity(obj);
    }

    private boolean isContinuePlay(long j3, long j16) {
        if (Math.abs(j3 - j16) <= 2000) {
            return true;
        }
        return false;
    }

    private boolean isCurrentVideoSessionValid(VideoSession videoSession) {
        return this.playerToSession.containsValue(videoSession);
    }

    private boolean isPlayAd(Object obj) {
        if (this.playerToFlow.get(Integer.valueOf(obj.hashCode())) != null) {
            return VideoReportPlayerUtils.isPlayAdFormNewPlayerDataSource(this.playerToDataSource.get(Integer.valueOf(obj.hashCode())));
        }
        return false;
    }

    private int playType(VideoSession videoSession) {
        int playTypeV1;
        if (DTConfigConstants.config.newPlayTypeSupport()) {
            playTypeV1 = playTypeV2(videoSession);
        } else {
            playTypeV1 = playTypeV1(videoSession);
        }
        this.lastVideoSession = videoSession;
        return playTypeV1;
    }

    private int playTypeV1(VideoSession videoSession) {
        VideoSession videoSession2 = this.lastVideoSession;
        if (videoSession2 != null && TextUtils.equals(videoSession2.getContentId(), videoSession.getContentId())) {
            return 2;
        }
        return 1;
    }

    private int playTypeV2(VideoSession videoSession) {
        Iterator<com.tencent.qqlive.module.videoreport.dtreport.video.data.a> it = this.historyPlayInfo.values().iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(videoSession.getContentId(), it.next().a())) {
                return 2;
            }
        }
        return 1;
    }

    private synchronized void reportStartEventIfNeed(Object obj, VideoSession videoSession, boolean z16) {
        if (!videoSession.isBizReady() && z16) {
            VideoPageReporter.getInstance().tryReportStartEvent(obj, videoSession);
            videoSession.bizReady();
        }
    }

    private void resetSession(Object obj) {
        VideoReportFlowInfo validReportFlowInfo = getValidReportFlowInfo(obj);
        validReportFlowInfo.setStartPosition(0L);
        validReportFlowInfo.setLoopStartPositionMs(0L);
        validReportFlowInfo.setVideoSession(null);
    }

    private int startPlayReason(VideoSession videoSession, long j3) {
        com.tencent.qqlive.module.videoreport.dtreport.video.data.a historyPlayInfo = getHistoryPlayInfo(videoSession);
        if (historyPlayInfo == null || historyPlayInfo.b() == 0 || j3 == 0 || !isContinuePlay(j3, historyPlayInfo.b())) {
            return 1;
        }
        if (videoSession.getPageId() == historyPlayInfo.c()) {
            return 2;
        }
        return 3;
    }

    private long startPosition(Object obj, boolean z16) {
        long j3;
        VideoReportFlowInfo videoReportFlowInfo = this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        if (z16) {
            if (videoReportFlowInfo == null) {
                return 0L;
            }
            return videoReportFlowInfo.getLoopStartPositionMs();
        }
        if (getPlayerState(obj) == 1) {
            if (videoReportFlowInfo != null) {
                j3 = videoReportFlowInfo.getStartPosition();
            } else {
                j3 = 0;
            }
            if (j3 > 0) {
                return j3;
            }
        }
        return VideoReportPlayerUtils.getCurrentPosition(obj);
    }

    private void updateSession(VideoSession videoSession, VideoBaseEntity videoBaseEntity) {
        videoSession.updateVideoEntity(videoBaseEntity);
        if (videoBaseEntity.isBizReady()) {
            videoSession.bizReady();
        }
    }

    public void bindDataSource(Object obj, Object obj2) {
        this.playerToDataSource.put(Integer.valueOf(obj.hashCode()), obj2);
    }

    public synchronized void bindVideoInfo(@NonNull Object obj, @NonNull VideoEntity videoEntity) {
        if (!DTConfigConstants.config.videoReportSupport()) {
            Log.w(TAG, "bindVideoInfo(), video report not support, please turn on the switch if need video report!");
            return;
        }
        Log.d(TAG, "bindVideoInfo(), instance=" + obj + ", " + VideoReportPlayerUtils.entityLog(videoEntity));
        videoEntity.bindBizPlayer(obj.hashCode());
        a aVar = this.onPlayerInfoChangeListener;
        if (aVar != null) {
            aVar.c(obj, videoEntity);
        }
    }

    public Map<Integer, Object> getPlayerMap() {
        return this.bizPlayerToNativePlayer;
    }

    public Map<Integer, VideoReportFlowInfo> getPlayerToFlowMap() {
        return this.playerToFlow;
    }

    public VideoReportFlowInfo getVideoReportFlowInfo(Object obj) {
        if (obj != null) {
            return this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        }
        return null;
    }

    public void loopEnd(Object obj) {
        Log.i(TAG, "loopEnd(), ptr=" + obj);
        dealPlayEnd(obj, 2, 4, "stop");
    }

    public void loopStart(Object obj) {
        Log.d(TAG, "loopStart(), ptr=" + obj);
        dealPlayStart(obj, true);
    }

    public void onCompletion(Object obj) {
        Log.i(TAG, "onCompletion(), ptr=" + obj);
        dealPlayEnd(obj, 2, 4, "onCompletion");
        resetSession(obj);
    }

    public void onError(Object obj, int i3, int i16) {
        Log.i(TAG, "onError(), ptr=" + obj + ", errorType=" + i3 + ", errorCode=" + i16);
        dealPlayEnd(obj, 1, 4, "onError");
        resetSession(obj);
    }

    public void onInfo(Object obj, int i3, long j3, long j16) {
        this.onInfoTaskManager.doTask(getPlayerState(obj), obj, i3, j3, j16);
    }

    public void onPrepared(Object obj) {
        Log.d(TAG, "onPrepared(), ptr=" + obj);
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        if (obj != null) {
            changeState(obj, 1);
        }
        VideoReportPlayerUtils.debugEnd("onPrepared", debugStart);
    }

    public void pause(Object obj) {
        Log.i(TAG, "pause(), ptr=" + obj);
        dealPlayEnd(obj, 3, 3, "pause");
    }

    public void release(Object obj) {
        Log.i(TAG, "release() ,ptr=" + obj);
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        dealPlayEnd(obj, 2, 4, "release");
        VideoReportFlowInfo videoReportFlowInfo = this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        if (videoReportFlowInfo != null) {
            this.playerToSession.remove(Integer.valueOf(obj.hashCode()));
            this.bizPlayerToNativePlayer.remove(Integer.valueOf(videoReportFlowInfo.getPlayerObject()));
        }
        this.playerToFlow.remove(Integer.valueOf(obj.hashCode()));
        VideoReportPlayerUtils.debugEnd("release", debugStart);
    }

    public void reset(Object obj) {
        Log.i(TAG, "reset(), ptr=" + obj);
        dealPlayEnd(obj, 2, 4, "reset");
        resetSession(obj);
    }

    public void seekTo(Object obj, long j3) {
        Log.i(TAG, "seekTo(), ptr=" + obj + ", positionMs=" + j3);
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        if (getPlayerState(obj) != 2) {
            Log.w(TAG, "seekTo(), state error\uff0cno need report! state=" + VideoReportPlayerUtils.stateToString(getPlayerState(obj)));
            VideoReportPlayerUtils.debugEnd("seekTo", debugStart);
            return;
        }
        VideoReportFlowInfo videoReportFlowInfo = this.playerToFlow.get(Integer.valueOf(obj.hashCode()));
        if (videoReportFlowInfo == null) {
            Log.w(TAG, "seekTo(), playerInfo is null! ptr=" + obj);
            return;
        }
        VideoSession videoSession = videoReportFlowInfo.getVideoSession();
        if (videoSession == null) {
            Log.w(TAG, "seekTo(), session is null!");
            VideoReportPlayerUtils.debugEnd("seekTo", debugStart);
        } else {
            videoSession.seekTo(VideoReportPlayerUtils.getCurrentPosition(obj), j3);
        }
    }

    public void setLoopback(Object obj, boolean z16, long j3, long j16) {
        Log.i(TAG, "setLoopback(), ptr=" + obj);
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        if (z16 && obj != null) {
            getValidReportFlowInfo(obj).setLoopStartPositionMs(j3);
        }
        VideoReportPlayerUtils.debugEnd("setLoopback", debugStart);
    }

    public synchronized void setOnDTPlayInfoChangeListener(a aVar) {
        this.onPlayerInfoChangeListener = aVar;
    }

    public void setPlaySpeedRatio(Object obj, float f16) {
        Log.i(TAG, "setPlaySpeedRatio(), ptr=" + obj + ", speedRatio=" + f16);
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        float correctPlaySpeedRatio = VideoReportPlayerUtils.correctPlaySpeedRatio(f16);
        VideoReportFlowInfo validReportFlowInfo = getValidReportFlowInfo(obj);
        validReportFlowInfo.setPlaySpeedRatio(correctPlaySpeedRatio);
        if (getPlayerState(obj) != 2) {
            Log.w(TAG, "setPlaySpeedRatio(), state error\uff0cno need report! state=" + VideoReportPlayerUtils.stateToString(getPlayerState(obj)));
            VideoReportPlayerUtils.debugEnd("setPlaySpeedRatio", debugStart);
            return;
        }
        VideoSession videoSession = validReportFlowInfo.getVideoSession();
        if (videoSession == null) {
            Log.w(TAG, "setPlaySpeedRatio(), session is null!");
            VideoReportPlayerUtils.debugEnd("seekTo", debugStart);
        } else {
            videoSession.speedRatioPlay(correctPlaySpeedRatio, VideoReportPlayerUtils.getCurrentPosition(obj));
        }
    }

    public void setStartPosition(Object obj, Object obj2) {
        Log.d(TAG, "setStartPosition(), ptr=" + obj);
        VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
        if (obj != null && VideoReportPlayerUtils.isSetStartPosition(obj2)) {
            long startPosition = VideoReportPlayerUtils.getStartPosition(obj2);
            Log.d(TAG, "setStartPosition,position =" + startPosition);
            getValidReportFlowInfo(obj).setStartPosition(startPosition);
        }
        VideoReportPlayerUtils.debugEnd("setStartPosition", debugStart);
    }

    public void start(Object obj) {
        Log.d(TAG, "start() -->, ptr=" + obj);
        dealPlayStart(obj, false);
        Log.d(TAG, "start() <--, ptr=" + obj);
    }

    public void stop(Object obj) {
        Log.i(TAG, "stop(), ptr=" + obj);
        dealPlayEnd(obj, 2, 4, "stop");
        resetSession(obj);
    }

    public synchronized void unbindVideoInfo(@NonNull Object obj) {
        if (!DTConfigConstants.config.videoReportSupport()) {
            Log.w(TAG, "unbindVideoInfo(), video report not support, please turn on the switch if need video report!");
            return;
        }
        Log.d(TAG, "unbindVideoInfo(), instance=" + obj);
        a aVar = this.onPlayerInfoChangeListener;
        if (aVar != null) {
            aVar.b(obj);
        }
    }

    public synchronized void updateVideoInfo(@NonNull Object obj, @NonNull VideoBaseEntity videoBaseEntity) {
        if (!DTConfigConstants.config.videoReportSupport()) {
            Log.w(TAG, "updateVideoInfo(), video report not support, please turn on the switch if need video report!");
            return;
        }
        Log.d(TAG, "updateVideoInfo(), instance=" + obj);
        videoBaseEntity.bindBizPlayer(obj.hashCode());
        a aVar = this.onPlayerInfoChangeListener;
        if (aVar != null) {
            aVar.a(obj, videoBaseEntity);
        }
        Object obj2 = this.bizPlayerToNativePlayer.get(Integer.valueOf(obj.hashCode()));
        if (obj2 == null) {
            return;
        }
        VideoSession currentPlaySession = getCurrentPlaySession(Integer.valueOf(obj2.hashCode()));
        if (currentPlaySession == null) {
            return;
        }
        currentPlaySession.updateVideoEntity(videoBaseEntity);
        if (currentPlaySession.isIgnoreReport()) {
            Log.w(TAG, "updateVideoInfo(), ignore report");
        } else {
            reportStartEventIfNeed(obj2, currentPlaySession, videoBaseEntity.isBizReady());
        }
    }

    VideoReportManager() {
        this.lastVideoSession = null;
        this.historyPlayInfo = new ConcurrentHashMap();
        this.bizPlayerToNativePlayer = new ConcurrentHashMap();
        this.playerToSession = Collections.synchronizedMap(new LinkedHashMap());
        this.playerToFlow = new ConcurrentHashMap();
        this.playerToDataSource = new HashMap();
        this.onInfoTaskManager = new OnInfoTaskManager();
        this.onPlayerInfoChangeListener = null;
    }
}

package com.tencent.qqlive.module.videoreport.dtreport.video.logic;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.task.ThreadUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoHeartBeatManager {
    private static final int MAX_STAGING_HEARTBEAT_INTERVAL = 1800000;
    private static final int MIN_STAGING_HEARTBEAT_INTERVAL = 60000;
    private static final String TAG = "video.VideoHeartBeatManager";
    private boolean isHeartBeatStarted;
    private boolean isInitStagingHeartBeatProcessor;
    private HeartBeatProcessor mStagingHeartBeatProcessor;
    private int mTimePinInterval;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static VideoHeartBeatManager sInstance = new VideoHeartBeatManager();

        InstanceHolder() {
        }
    }

    public static VideoHeartBeatManager getInstance() {
        return InstanceHolder.sInstance;
    }

    private boolean hasStartedPlayer() {
        Map<Integer, VideoReportFlowInfo> playerToFlowMap = VideoReportManager.getInstance().getPlayerToFlowMap();
        if (playerToFlowMap == null) {
            return false;
        }
        Collection<VideoReportFlowInfo> values = playerToFlowMap.values();
        if (values.isEmpty()) {
            return false;
        }
        Iterator<VideoReportFlowInfo> it = values.iterator();
        while (it.hasNext()) {
            if (it.next().getVideoState() == 2) {
                return true;
            }
        }
        return false;
    }

    private void initHeartBeatProcessor() {
        if (this.isInitStagingHeartBeatProcessor) {
            return;
        }
        int videoHeartBeatInterval = VideoReportInner.getInstance().getConfiguration().getVideoHeartBeatInterval() * 1000;
        this.mTimePinInterval = videoHeartBeatInterval;
        if (videoHeartBeatInterval < 60000) {
            this.mTimePinInterval = 60000;
        } else if (videoHeartBeatInterval > 1800000) {
            this.mTimePinInterval = 1800000;
        }
        HeartBeatProcessor heartBeatProcessor = new HeartBeatProcessor(true, this.mTimePinInterval);
        this.mStagingHeartBeatProcessor = heartBeatProcessor;
        heartBeatProcessor.setHeartBeatCallback(new HeartBeatProcessor.IHeartBeatCallback() { // from class: com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatManager.1
            @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback
            public void saveHeartBeatInfo(String str, long j3, long j16) {
                Log.d(VideoHeartBeatManager.TAG, "setHeartBeatCallback, saveHeartBeatInfo");
                ThreadUtils.execTask(new Runnable() { // from class: com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoHeartBeatManager.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoHeartBeatManager.this.saveEndEvent();
                    }
                });
            }

            @Override // com.tencent.qqlive.module.videoreport.dtreport.time.base.HeartBeatProcessor.IHeartBeatCallback
            public void reportHeartBeat(String str, long j3, long j16) {
            }
        });
        this.isInitStagingHeartBeatProcessor = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveEndEvent() {
        Log.d(TAG, "saveEndEvent()");
        Map<Integer, Object> playerMap = VideoReportManager.getInstance().getPlayerMap();
        if (playerMap == null) {
            Log.w(TAG, "saveEndEvent(), playerMap is empty!");
            return;
        }
        Map<Integer, VideoReportFlowInfo> playerToFlowMap = VideoReportManager.getInstance().getPlayerToFlowMap();
        if (playerToFlowMap == null) {
            Log.w(TAG, "saveEndEvent(), playerInfoMap is empty!");
            return;
        }
        Collection<Object> values = playerMap.values();
        if (values.isEmpty()) {
            Log.w(TAG, "saveEndEvent(), thumbPlayerObjects is empty!");
            return;
        }
        for (Object obj : values) {
            Log.d(TAG, "saveEndEvent(), playerObject:" + obj);
            if (obj == null) {
                return;
            }
            VideoReportFlowInfo videoReportFlowInfo = playerToFlowMap.get(Integer.valueOf(obj.hashCode()));
            if (videoReportFlowInfo == null) {
                Log.w(TAG, "saveEndEvent(), playerInfo is null! ptr=" + obj);
                return;
            }
            if (videoReportFlowInfo.getVideoState() != 2) {
                Log.w(TAG, "saveEndEvent(), videoState is not STARTED");
                return;
            }
            VideoSession videoSession = videoReportFlowInfo.getVideoSession();
            if (videoSession == null) {
                Log.w(TAG, "saveEndEvent(), session is null!");
                return;
            } else if (videoSession.isIgnoreReport()) {
                Log.w(TAG, "saveEndEvent(), ignore, not need report!");
                return;
            } else {
                videoSession.stagingEnd(VideoReportPlayerUtils.getCurrentPosition(obj), 4);
                VideoPageReporter.getInstance().stashEndEvent(obj, videoSession);
            }
        }
    }

    public void startStagingHeartBeat() {
        Log.d(TAG, "startStagingHeartBeat()");
        if (this.isHeartBeatStarted) {
            Log.d(TAG, "startStagingHeartBeat(), ignore");
            return;
        }
        initHeartBeatProcessor();
        this.mStagingHeartBeatProcessor.start();
        this.isHeartBeatStarted = true;
    }

    public void stopStagingHeartBeat() {
        Log.d(TAG, "stopStagingHeartBeat()");
        if (!hasStartedPlayer() && this.isInitStagingHeartBeatProcessor) {
            this.mStagingHeartBeatProcessor.stop();
            this.isHeartBeatStarted = false;
        } else {
            Log.d(TAG, "stopStagingHeartBeat(), ignore");
        }
    }

    VideoHeartBeatManager() {
        this.isInitStagingHeartBeatProcessor = false;
        this.isHeartBeatStarted = false;
    }
}

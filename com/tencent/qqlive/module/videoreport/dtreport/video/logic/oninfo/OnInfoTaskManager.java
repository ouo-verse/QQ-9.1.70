package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import android.util.SparseArray;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OnInfoTaskManager {
    private static final String TAG = "video.OnInfoTaskManager";
    private SparseArray<IOnInfoTask> onInfoTaskMap = new SparseArray<>();

    public OnInfoTaskManager() {
        Log.i(TAG, "create OnInfoTaskManager!");
        init();
    }

    private int getKey(int i3) {
        return VideoReportPlayerUtils.convertEventIdToPlayer(i3);
    }

    private void init() {
        this.onInfoTaskMap.put(getKey(1), new BufferStartTask());
        this.onInfoTaskMap.put(getKey(2), new BufferEndTask());
        this.onInfoTaskMap.put(getKey(5), new LoopStartTask());
        this.onInfoTaskMap.put(getKey(6), new LoopEndTask());
    }

    public void doTask(int i3, Object obj, int i16, long j3, long j16) {
        VideoReportFlowInfo videoReportFlowInfo = VideoReportManager.getInstance().getVideoReportFlowInfo(Integer.valueOf(obj.hashCode()));
        if (videoReportFlowInfo == null) {
            Log.w(TAG, "OnInfoTaskManager doTask flowInfo is null, ptr=" + obj);
            return;
        }
        IOnInfoTask iOnInfoTask = this.onInfoTaskMap.get(i16);
        if (iOnInfoTask != null) {
            iOnInfoTask.setExtraParams(i3, videoReportFlowInfo);
            iOnInfoTask.doTask(obj, i16, j3, j16);
        }
    }
}

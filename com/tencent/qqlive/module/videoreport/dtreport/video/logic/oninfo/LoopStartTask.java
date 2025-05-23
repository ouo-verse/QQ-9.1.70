package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportManager;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LoopStartTask implements IOnInfoTask {
    private static final String TAG = "video.LoopStartTask";
    private VideoReportFlowInfo flowInfo;
    private int playerState;

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.IOnInfoTask
    public void doTask(Object obj, int i3, long j3, long j16) {
        Log.i(TAG, "loopStart, ptr=" + obj + ", playerState=" + this.playerState);
        if (this.playerState == 4 && this.flowInfo.isLoopEnd()) {
            Log.i(TAG, "loopStart, ptr=" + obj);
            VideoReportManager.getInstance().loopStart(obj);
            this.flowInfo.setLoopEnd(false);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.IOnInfoTask
    public void setExtraParams(int i3, VideoReportFlowInfo videoReportFlowInfo) {
        this.playerState = i3;
        this.flowInfo = videoReportFlowInfo;
    }
}

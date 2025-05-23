package com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo;

import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.dtreport.video.data.VideoSession;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportFlowInfo;
import com.tencent.qqlive.module.videoreport.dtreport.video.logic.VideoReportPlayerUtils;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BufferStartTask implements IOnInfoTask {
    private static final String TAG = "video.BufferStartTask";
    private VideoReportFlowInfo flowInfo;
    private int playerState;

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.IOnInfoTask
    public void doTask(Object obj, int i3, long j3, long j16) {
        Log.d(TAG, "bufferStart, ptr=" + obj + ", playerState=" + this.playerState);
        if (this.playerState == 2) {
            VideoReportPlayerUtils.DebugTime debugStart = VideoReportPlayerUtils.debugStart();
            VideoSession videoSession = this.flowInfo.getVideoSession();
            if (videoSession != null) {
                videoSession.bufferStart();
            }
            VideoReportPlayerUtils.debugEnd("bufferStart", debugStart);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.video.logic.oninfo.IOnInfoTask
    public void setExtraParams(int i3, VideoReportFlowInfo videoReportFlowInfo) {
        this.playerState = i3;
        this.flowInfo = videoReportFlowInfo;
    }
}

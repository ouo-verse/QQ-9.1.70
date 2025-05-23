package com.tencent.biz.richframework.video.rfw.player.monitor;

import com.tencent.biz.richframework.video.rfw.player.stinfo.RFWPlayerReportInfo;

/* loaded from: classes5.dex */
public interface IRFWPlayerMonitor {
    void handleInfo(int i3, long j3, long j16, Object obj);

    void handleReport(RFWPlayerReportInfo rFWPlayerReportInfo, String str);
}

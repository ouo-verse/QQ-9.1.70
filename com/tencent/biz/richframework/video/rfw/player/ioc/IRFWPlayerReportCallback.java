package com.tencent.biz.richframework.video.rfw.player.ioc;

import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;

/* loaded from: classes5.dex */
public interface IRFWPlayerReportCallback {
    void onReportFront(RFWPlayerOptions rFWPlayerOptions, long j3, String str, List<FeedCloudCommon$Entry> list);
}

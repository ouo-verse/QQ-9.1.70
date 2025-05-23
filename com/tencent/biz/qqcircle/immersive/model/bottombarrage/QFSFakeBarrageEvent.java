package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StBarrage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFakeBarrageEvent extends SimpleBaseEvent {
    private int contextHashCode;
    private String feedId;
    private FeedCloudMeta$StBarrage mBarrage;

    public QFSFakeBarrageEvent(String str, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i3) {
        this.feedId = str;
        this.mBarrage = QCirclePluginUtil.deepCopyBarrage(feedCloudMeta$StBarrage);
        this.contextHashCode = i3;
    }

    public FeedCloudMeta$StBarrage getBarrage() {
        return this.mBarrage;
    }

    public int getContextHashCode() {
        return this.contextHashCode;
    }

    public String getFeedId() {
        return this.feedId;
    }
}

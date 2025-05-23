package com.tencent.biz.qqcircle.immersive.model.bottombarrage;

import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta$StBarrage;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSBarrageUpdateEvent extends SimpleBaseEvent {
    public static final int EVENT_ADD_BARRAGE = 1;
    public static final int EVENT_ADD_BARRAGE_FAILURE = 2;
    public int contextHashCode;
    public int eventStatus;
    public String fakeBarrageId;
    public String feedId;
    public FeedCloudMeta$StBarrage mBarrage;

    public QFSBarrageUpdateEvent(int i3, String str, FeedCloudMeta$StBarrage feedCloudMeta$StBarrage, int i16) {
        this.eventStatus = i3;
        this.feedId = str;
        this.mBarrage = QCirclePluginUtil.deepCopyBarrage(feedCloudMeta$StBarrage);
        this.contextHashCode = i16;
    }
}

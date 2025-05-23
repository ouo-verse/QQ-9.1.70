package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudWrite$PushBoxBasic;
import java.util.List;

/* loaded from: classes4.dex */
public class QFSUpdatePushStateEvent extends SimpleBaseEvent {
    private List<FeedCloudWrite$PushBoxBasic> mPushBoxBasics;

    public QFSUpdatePushStateEvent(List<FeedCloudWrite$PushBoxBasic> list) {
        this.mPushBoxBasics = list;
    }

    public List<FeedCloudWrite$PushBoxBasic> getPushBoxBasics() {
        return this.mPushBoxBasics;
    }
}

package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSModifyFeedEvent extends SimpleBaseEvent {
    private String mFeedId;
    private long mGroupId;
    private String mGroupName;

    public QFSModifyFeedEvent(String str, String str2, long j3) {
        this.mFeedId = str;
        this.mGroupName = str2;
        this.mGroupId = j3;
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public String getGroupName() {
        return this.mGroupName;
    }
}

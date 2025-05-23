package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudRead$FilterGroup;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSSearchFilterDataEvent extends SimpleBaseEvent {
    private int mContextHashCode;
    private List<FeedCloudRead$FilterGroup> mFilterGroups;

    public QFSSearchFilterDataEvent(List<FeedCloudRead$FilterGroup> list, int i3) {
        this.mFilterGroups = list;
        this.mContextHashCode = i3;
    }

    public int getContextHashCode() {
        return this.mContextHashCode;
    }

    public List<FeedCloudRead$FilterGroup> getFilterGroups() {
        return this.mFilterGroups;
    }
}

package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudEeveeBase$StEeveeDialogData;

/* loaded from: classes16.dex */
public class QFSTagPolymerizationTaskDoneShowDialogEvent extends SimpleBaseEvent {
    private FeedCloudEeveeBase$StEeveeDialogData mStEeveeDialogData;

    public QFSTagPolymerizationTaskDoneShowDialogEvent(FeedCloudEeveeBase$StEeveeDialogData feedCloudEeveeBase$StEeveeDialogData) {
        this.mStEeveeDialogData = feedCloudEeveeBase$StEeveeDialogData;
    }

    public FeedCloudEeveeBase$StEeveeDialogData getStEeveeDialogData() {
        return this.mStEeveeDialogData;
    }
}

package com.tencent.biz.subscribe.event;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* loaded from: classes5.dex */
public class PublishBoxStatusEvent extends SimpleBaseEvent {
    public boolean hasOfflineWaitingTask;
    public boolean hasRunningTask;
    public int taskCount;

    public PublishBoxStatusEvent(Bundle bundle) {
        if (bundle != null) {
            this.taskCount = bundle.getInt("taskCount", 0);
            this.hasRunningTask = bundle.getBoolean("hasRunningTask", false);
            this.hasOfflineWaitingTask = bundle.getBoolean("hasOfflineWaitingTask", false);
        }
    }
}

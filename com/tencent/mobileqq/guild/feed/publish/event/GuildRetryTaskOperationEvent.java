package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildRetryTaskOperationEvent extends SimpleBaseEvent {
    public static final int TYPE_PUBLISH_RETRY = 2;
    public static final int TYPE_UPLOAD_RETRY = 1;
    public String forcePostChannelId;
    private String mMainTaskId;
    private String mTaskId;
    private int mType;
    public boolean showSuccessToast = true;
    public boolean showFailToast = true;
    private boolean isAutoRetryReportValue = false;

    public GuildRetryTaskOperationEvent(int i3, String str) {
        this.mType = i3;
        this.mMainTaskId = str;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public String getTaskId() {
        return this.mTaskId;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isAutoRetryReportValue() {
        return this.isAutoRetryReportValue;
    }

    public void setAutoRetryReportValue(boolean z16) {
        this.isAutoRetryReportValue = z16;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public String toString() {
        return "GuildRetryTaskOperationEvent{mType=" + this.mType + ", mMainTaskId='" + this.mMainTaskId + "', mTaskId='" + this.mTaskId + "', forcePostChannelId='" + this.forcePostChannelId + "'}";
    }
}

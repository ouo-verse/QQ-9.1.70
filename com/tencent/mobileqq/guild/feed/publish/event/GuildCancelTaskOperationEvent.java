package com.tencent.mobileqq.guild.feed.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildCancelTaskOperationEvent extends SimpleBaseEvent {
    public static final String ACTION_TYPE_TASK_SUCCESS = "task_success";
    public static final String ACTION_TYPE_USER_OPERATION = "user_operation";
    public static final int TYPE_PUBLISH_CANCEL = 2;
    public static final int TYPE_UPLOAD_CANCEL = 1;
    private String mActionType;
    private boolean mIsBeyondGuild;
    private String mMainTaskId;
    private int mReportCancelType;
    private String mTaskId;
    private int mType;

    public GuildCancelTaskOperationEvent(int i3, String str, boolean z16) {
        this.mType = i3;
        this.mMainTaskId = str;
        this.mIsBeyondGuild = z16;
    }

    public String getActionType() {
        return this.mActionType;
    }

    public String getMainTaskId() {
        return this.mMainTaskId;
    }

    public int getReportCancelType() {
        return this.mReportCancelType;
    }

    public String getTaskId() {
        return this.mTaskId;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isBeyondGuild() {
        return this.mIsBeyondGuild;
    }

    public void setActionType(String str) {
        this.mActionType = str;
    }

    public void setReportCancelType(int i3) {
        this.mReportCancelType = i3;
    }

    public void setTaskId(String str) {
        this.mTaskId = str;
    }

    public String toString() {
        return "GuildCancelTaskOperationEvent{mType=" + this.mType + ", mMainTaskId='" + this.mMainTaskId + "', mTaskId='" + this.mTaskId + "', mActionType='" + this.mActionType + "', isBeyondGuild='" + this.mIsBeyondGuild + "'}";
    }
}

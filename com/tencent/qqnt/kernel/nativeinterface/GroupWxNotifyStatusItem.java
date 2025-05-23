package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupWxNotifyStatusItem {
    public long groupCode;
    public GroupWxNotifyStatus status = GroupWxNotifyStatus.values()[0];

    public long getGroupCode() {
        return this.groupCode;
    }

    public GroupWxNotifyStatus getStatus() {
        return this.status;
    }

    public String toString() {
        return "GroupWxNotifyStatusItem{groupCode=" + this.groupCode + ",status=" + this.status + ",}";
    }
}

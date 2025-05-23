package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupInviteExt implements Serializable {
    public long groupCode;
    long serialVersionUID = 1;
    public GroupInviteType srcType = GroupInviteType.values()[0];
    public GroupInviteStatus waitStatus = GroupInviteStatus.values()[0];
    public GroupNotifyInvitorRole invitorRole = GroupNotifyInvitorRole.values()[0];

    public long getGroupCode() {
        return this.groupCode;
    }

    public GroupNotifyInvitorRole getInvitorRole() {
        return this.invitorRole;
    }

    public GroupInviteType getSrcType() {
        return this.srcType;
    }

    public GroupInviteStatus getWaitStatus() {
        return this.waitStatus;
    }

    public String toString() {
        return "GroupInviteExt{srcType=" + this.srcType + ",groupCode=" + this.groupCode + ",waitStatus=" + this.waitStatus + ",invitorRole=" + this.invitorRole + ",}";
    }
}

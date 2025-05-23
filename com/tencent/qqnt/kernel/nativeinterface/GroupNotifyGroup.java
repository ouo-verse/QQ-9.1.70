package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupNotifyGroup implements Serializable {
    public long groupCode;
    long serialVersionUID = 1;
    public String groupName = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String toString() {
        return "GroupNotifyGroup{groupCode=" + this.groupCode + ",groupName=" + this.groupName + ",}";
    }
}

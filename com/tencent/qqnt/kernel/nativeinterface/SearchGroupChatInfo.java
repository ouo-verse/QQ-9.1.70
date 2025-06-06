package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGroupChatInfo {
    public long groupCode;
    public boolean hasModifyConfGroupFace;
    public boolean hasModifyConfGroupName;
    public boolean isConf;
    public String groupName = "";
    public String remark = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public boolean getHasModifyConfGroupFace() {
        return this.hasModifyConfGroupFace;
    }

    public boolean getHasModifyConfGroupName() {
        return this.hasModifyConfGroupName;
    }

    public boolean getIsConf() {
        return this.isConf;
    }

    public String getRemark() {
        return this.remark;
    }

    public String toString() {
        return "SearchGroupChatInfo{groupCode=" + this.groupCode + ",isConf=" + this.isConf + ",hasModifyConfGroupFace=" + this.hasModifyConfGroupFace + ",hasModifyConfGroupName=" + this.hasModifyConfGroupName + ",groupName=" + this.groupName + ",remark=" + this.remark + ",}";
    }
}

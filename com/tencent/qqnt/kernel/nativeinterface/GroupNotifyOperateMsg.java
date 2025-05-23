package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupNotifyOperateMsg implements IKernelModel {
    public int operateSource;
    public GroupNotifyOperateType operateType = GroupNotifyOperateType.values()[0];
    public GroupNotifyTargetMsg targetMsg = new GroupNotifyTargetMsg();

    public int getOperateSource() {
        return this.operateSource;
    }

    public GroupNotifyOperateType getOperateType() {
        return this.operateType;
    }

    public GroupNotifyTargetMsg getTargetMsg() {
        return this.targetMsg;
    }

    public void setOperateSource(int i3) {
        this.operateSource = i3;
    }

    public void setOperateType(GroupNotifyOperateType groupNotifyOperateType) {
        this.operateType = groupNotifyOperateType;
    }

    public void setTargetMsg(GroupNotifyTargetMsg groupNotifyTargetMsg) {
        this.targetMsg = groupNotifyTargetMsg;
    }

    public String toString() {
        return "GroupNotifyOperateMsg{operateType=" + this.operateType + ",targetMsg=" + this.targetMsg + ",operateSource=" + this.operateSource + ",}";
    }
}

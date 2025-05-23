package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupMsgLimitFreqRsp {
    public long groupCode;
    public int msgLimitFrequency;

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getMsgLimitFrequency() {
        return this.msgLimitFrequency;
    }

    public String toString() {
        return "GroupMsgLimitFreqRsp{groupCode=" + this.groupCode + ",msgLimitFrequency=" + this.msgLimitFrequency + ",}";
    }
}

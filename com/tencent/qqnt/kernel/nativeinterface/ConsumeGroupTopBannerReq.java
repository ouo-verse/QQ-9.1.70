package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ConsumeGroupTopBannerReq {
    public int bizType;
    public long groupId;
    public byte[] msgId = new byte[0];

    public int getBizType() {
        return this.bizType;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public byte[] getMsgId() {
        return this.msgId;
    }

    public String toString() {
        return "ConsumeGroupTopBannerReq{bizType=" + this.bizType + ",msgId=" + this.msgId + ",groupId=" + this.groupId + ",}";
    }
}

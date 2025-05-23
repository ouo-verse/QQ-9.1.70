package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TopicRecallReq {
    public long groupCode;
    public String recallId = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getRecallId() {
        return this.recallId;
    }

    public String toString() {
        return "TopicRecallReq{groupCode=" + this.groupCode + ",recallId=" + this.recallId + ",}";
    }
}

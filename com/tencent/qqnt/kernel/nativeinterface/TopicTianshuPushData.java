package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class TopicTianshuPushData {
    public long groupCode;
    public TopicRecallResult result = new TopicRecallResult();

    public long getGroupCode() {
        return this.groupCode;
    }

    public TopicRecallResult getResult() {
        return this.result;
    }

    public String toString() {
        return "TopicTianshuPushData{groupCode=" + this.groupCode + ",result=" + this.result + ",}";
    }
}

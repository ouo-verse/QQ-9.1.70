package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TopicRecallRsp {
    public int emptyReason;
    public TopicRecallResult result = new TopicRecallResult();
    public int stopRequestSeconds;

    public int getEmptyReason() {
        return this.emptyReason;
    }

    public TopicRecallResult getResult() {
        return this.result;
    }

    public int getStopRequestSeconds() {
        return this.stopRequestSeconds;
    }

    public String toString() {
        return "TopicRecallRsp{stopRequestSeconds=" + this.stopRequestSeconds + ",result=" + this.result + ",emptyReason=" + this.emptyReason + ",}";
    }
}

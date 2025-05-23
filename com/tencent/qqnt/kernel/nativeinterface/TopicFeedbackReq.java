package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TopicFeedbackReq {
    public long groupCode;
    public int source;
    public int type;
    public String recallId = "";
    public String itemId = "";

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getRecallId() {
        return this.recallId;
    }

    public int getSource() {
        return this.source;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "TopicFeedbackReq{groupCode=" + this.groupCode + ",type=" + this.type + ",source=" + this.source + ",recallId=" + this.recallId + ",itemId=" + this.itemId + ",}";
    }
}

package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTopicInfo {
    public long topicId;
    public String topicContent = "";
    public String schema = "";
    public String hotText = "";

    public String getHotText() {
        return this.hotText;
    }

    public String getSchema() {
        return this.schema;
    }

    public String getTopicContent() {
        return this.topicContent;
    }

    public long getTopicId() {
        return this.topicId;
    }

    public String toString() {
        return "GProTopicInfo{topicId=" + this.topicId + ",topicContent=" + this.topicContent + ",schema=" + this.schema + ",hotText=" + this.hotText + ",}";
    }
}

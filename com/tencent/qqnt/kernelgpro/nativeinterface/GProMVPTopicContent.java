package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPTopicContent implements Serializable {
    public int showStatus;
    public long topicId;
    long serialVersionUID = 1;
    public String topicName = "";
    public String schema = "";

    public String getSchema() {
        return this.schema;
    }

    public int getShowStatus() {
        return this.showStatus;
    }

    public long getTopicId() {
        return this.topicId;
    }

    public String getTopicName() {
        return this.topicName;
    }

    public String toString() {
        return "GProMVPTopicContent{topicId=" + this.topicId + ",topicName=" + this.topicName + ",showStatus=" + this.showStatus + ",schema=" + this.schema + ",}";
    }
}

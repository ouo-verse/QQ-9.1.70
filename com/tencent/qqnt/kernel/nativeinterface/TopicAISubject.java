package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TopicAISubject implements Serializable {
    long serialVersionUID = 1;
    public String itemId = "";
    public String content = "";
    public String reportData = "";

    public String getContent() {
        return this.content;
    }

    public String getItemId() {
        return this.itemId;
    }

    public String getReportData() {
        return this.reportData;
    }

    public String toString() {
        return "TopicAISubject{itemId=" + this.itemId + ",content=" + this.content + ",reportData=" + this.reportData + ",}";
    }
}

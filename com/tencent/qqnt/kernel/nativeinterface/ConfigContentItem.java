package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ConfigContentItem {
    public String content;
    public int taskId;

    public ConfigContentItem() {
        this.content = "";
    }

    public String getContent() {
        return this.content;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "ConfigContentItem{taskId=" + this.taskId + ",content=" + this.content + ",}";
    }

    public ConfigContentItem(int i3, String str) {
        this.taskId = i3;
        this.content = str;
    }
}

package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ShareTopicReq {
    public String ext = "";
    public long topicId;
    public int type;

    public String getExt() {
        return this.ext;
    }

    public long getTopicId() {
        return this.topicId;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "ShareTopicReq{type=" + this.type + ",topicId=" + this.topicId + ",ext=" + this.ext + ",}";
    }
}

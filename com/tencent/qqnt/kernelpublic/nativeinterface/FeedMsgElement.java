package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FeedMsgElement implements Serializable {
    public String content;
    long serialVersionUID;
    public long tinyId;

    public FeedMsgElement() {
        this.serialVersionUID = 1L;
        this.content = "";
    }

    public String getContent() {
        return this.content;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "FeedMsgElement{tinyId=" + this.tinyId + ",content=" + this.content + ",}";
    }

    public FeedMsgElement(long j3, String str) {
        this.serialVersionUID = 1L;
        this.tinyId = j3;
        this.content = str;
    }
}

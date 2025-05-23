package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTopicElem implements Serializable {
    long serialVersionUID = 1;
    public GProStRichTextTopicContent topicContent = new GProStRichTextTopicContent();

    public GProStRichTextTopicContent getTopicContent() {
        return this.topicContent;
    }

    public String toString() {
        return "GProTopicElem{topicContent=" + this.topicContent + ",}";
    }
}

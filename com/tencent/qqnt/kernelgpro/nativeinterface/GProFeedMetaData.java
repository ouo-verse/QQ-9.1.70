package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProFeedMetaData implements Serializable {
    public long lastModifiedTime;
    long serialVersionUID = 1;
    public GProContentMetaData content = new GProContentMetaData();

    public GProContentMetaData getContent() {
        return this.content;
    }

    public long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public String toString() {
        return "GProFeedMetaData{content=" + this.content + ",lastModifiedTime=" + this.lastModifiedTime + ",}";
    }
}

package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProContentMetaData implements Serializable {
    public long ContentID;
    long serialVersionUID = 1;
    public GProRichTextContentCount count = new GProRichTextContentCount();

    public long getContentID() {
        return this.ContentID;
    }

    public GProRichTextContentCount getCount() {
        return this.count;
    }

    public String toString() {
        return "GProContentMetaData{count=" + this.count + ",ContentID=" + this.ContentID + ",}";
    }
}

package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStNoticeTxtInfo {
    public GProStRichText content = new GProStRichText();
    public GProStRichText contentOfReference = new GProStRichText();

    public GProStRichText getContent() {
        return this.content;
    }

    public GProStRichText getContentOfReference() {
        return this.contentOfReference;
    }

    public String toString() {
        return "GProStNoticeTxtInfo{content=" + this.content + ",contentOfReference=" + this.contentOfReference + ",}";
    }
}

package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProURLElem implements Serializable {
    long serialVersionUID = 1;
    public GProStRichTextURLContent urlContent = new GProStRichTextURLContent();

    public GProStRichTextURLContent getUrlContent() {
        return this.urlContent;
    }

    public String toString() {
        return "GProURLElem{urlContent=" + this.urlContent + ",}";
    }
}

package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGroupElem implements Serializable {
    long serialVersionUID = 1;
    public GProStRichTextGroupContent groupContent = new GProStRichTextGroupContent();

    public GProStRichTextGroupContent getGroupContent() {
        return this.groupContent;
    }

    public String toString() {
        return "GProGroupElem{groupContent=" + this.groupContent + ",}";
    }
}

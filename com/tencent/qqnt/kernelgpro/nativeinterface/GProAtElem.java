package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAtElem implements Serializable {
    long serialVersionUID = 1;
    public GProStRichTextAtContent atContent = new GProStRichTextAtContent();

    public GProStRichTextAtContent getAtContent() {
        return this.atContent;
    }

    public String toString() {
        return "GProAtElem{atContent=" + this.atContent + ",}";
    }
}

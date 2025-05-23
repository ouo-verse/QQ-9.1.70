package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProTextElem implements Serializable {
    long serialVersionUID = 1;
    public GProStRichTextTextContent textContent = new GProStRichTextTextContent();
    public GProTextProps props = new GProTextProps();

    public GProTextProps getProps() {
        return this.props;
    }

    public GProStRichTextTextContent getTextContent() {
        return this.textContent;
    }

    public String toString() {
        return "GProTextElem{textContent=" + this.textContent + ",props=" + this.props + ",}";
    }
}

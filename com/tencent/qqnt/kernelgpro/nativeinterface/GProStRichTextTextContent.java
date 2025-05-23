package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStRichTextTextContent implements Serializable {
    long serialVersionUID = 1;
    public String text = "";

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProStRichTextTextContent{text=" + this.text + ",}";
    }
}

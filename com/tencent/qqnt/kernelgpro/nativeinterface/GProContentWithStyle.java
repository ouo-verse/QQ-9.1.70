package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentWithStyle implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProParagraph> paragraphs = new ArrayList<>();

    public ArrayList<GProParagraph> getParagraphs() {
        return this.paragraphs;
    }

    public String toString() {
        return "GProContentWithStyle{paragraphs=" + this.paragraphs + ",}";
    }
}

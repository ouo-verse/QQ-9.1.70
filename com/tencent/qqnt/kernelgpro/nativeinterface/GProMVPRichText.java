package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPRichText implements Serializable {
    public ArrayList<GProMVPRichTextContent> contents;
    long serialVersionUID;

    public GProMVPRichText() {
        this.serialVersionUID = 1L;
        this.contents = new ArrayList<>();
    }

    public ArrayList<GProMVPRichTextContent> getContents() {
        return this.contents;
    }

    public String toString() {
        return "GProMVPRichText{contents=" + this.contents + ",}";
    }

    public GProMVPRichText(ArrayList<GProMVPRichTextContent> arrayList) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.contents = arrayList;
    }
}

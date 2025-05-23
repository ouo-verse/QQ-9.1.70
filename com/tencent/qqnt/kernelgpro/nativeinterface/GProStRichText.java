package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStRichText implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProStRichTextContent> contents = new ArrayList<>();
    public ArrayList<GProStImage> images = new ArrayList<>();

    public ArrayList<GProStRichTextContent> getContents() {
        return this.contents;
    }

    public ArrayList<GProStImage> getImages() {
        return this.images;
    }

    public String toString() {
        return "GProStRichText{contents=" + this.contents + ",images=" + this.images + ",}";
    }
}

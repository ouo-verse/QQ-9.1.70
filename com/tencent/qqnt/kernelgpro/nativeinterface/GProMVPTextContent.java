package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPTextContent implements Serializable {
    long serialVersionUID;
    public String text;

    public GProMVPTextContent() {
        this.serialVersionUID = 1L;
        this.text = "";
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProMVPTextContent{text=" + this.text + ",}";
    }

    public GProMVPTextContent(String str) {
        this.serialVersionUID = 1L;
        this.text = str;
    }
}

package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProConditionalTag implements Serializable {
    public byte[] buff;
    public String name;
    long serialVersionUID;

    public GProConditionalTag() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.buff = new byte[0];
    }

    public byte[] getBuff() {
        return this.buff;
    }

    public String getName() {
        return this.name;
    }

    public void setBuff(byte[] bArr) {
        this.buff = bArr;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "GProConditionalTag{name=" + this.name + ",buff=" + this.buff + ",}";
    }

    public GProConditionalTag(String str, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.name = str;
        this.buff = bArr;
    }
}

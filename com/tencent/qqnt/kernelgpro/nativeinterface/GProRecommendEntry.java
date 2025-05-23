package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProRecommendEntry implements Serializable {
    public String key;
    long serialVersionUID;
    public byte[] value;

    public GProRecommendEntry() {
        this.serialVersionUID = 1L;
        this.key = "";
        this.value = new byte[0];
    }

    public String getKey() {
        return this.key;
    }

    public byte[] getValue() {
        return this.value;
    }

    public String toString() {
        return "GProRecommendEntry{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProRecommendEntry(String str, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.key = str;
        this.value = bArr;
    }
}

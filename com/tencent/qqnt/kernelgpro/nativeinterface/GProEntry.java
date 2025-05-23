package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProEntry implements Serializable {
    public String key;
    long serialVersionUID;
    public byte[] value;

    public GProEntry() {
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
        return "GProEntry{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProEntry(String str, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.key = str;
        this.value = bArr;
    }
}

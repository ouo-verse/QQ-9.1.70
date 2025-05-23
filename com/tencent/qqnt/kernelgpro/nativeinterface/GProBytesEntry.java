package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProBytesEntry {
    public String key = "";
    public byte[] value = new byte[0];

    public String getKey() {
        return this.key;
    }

    public byte[] getValue() {
        return this.value;
    }

    public String toString() {
        return "GProBytesEntry{key=" + this.key + ",value=" + this.value + ",}";
    }
}

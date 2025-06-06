package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class NearbyProBytesEntry {
    public String key;
    public byte[] value;

    public NearbyProBytesEntry() {
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
        return "NearbyProBytesEntry{key=" + this.key + ",value=" + this.value + ",}";
    }

    public NearbyProBytesEntry(String str, byte[] bArr) {
        this.key = str;
        this.value = bArr;
    }
}

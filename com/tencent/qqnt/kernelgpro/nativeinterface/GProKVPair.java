package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProKVPair implements Serializable {
    public String key;
    long serialVersionUID;
    public byte[] value;

    public GProKVPair() {
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

    public void setKey(String str) {
        this.key = str;
    }

    public void setValue(byte[] bArr) {
        this.value = bArr;
    }

    public String toString() {
        return "GProKVPair{key=" + this.key + ",value=" + this.value + ",}";
    }

    public GProKVPair(String str, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.key = str;
        this.value = bArr;
    }
}

package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelInfoExtendInfoEntry implements Serializable {
    public int key;
    long serialVersionUID = 1;
    public byte[] value = new byte[0];

    public int getKey() {
        return this.key;
    }

    public byte[] getValue() {
        return this.value;
    }

    public String toString() {
        return "GProChannelInfoExtendInfoEntry{key=" + this.key + ",value=" + this.value + ",}";
    }
}

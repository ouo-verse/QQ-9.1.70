package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class StructTypeValue {
    public int type;
    public byte[] value = new byte[0];

    public int getType() {
        return this.type;
    }

    public byte[] getValue() {
        return this.value;
    }

    public String toString() {
        return "StructTypeValue{type=" + this.type + ",value=" + this.value + ",}";
    }
}

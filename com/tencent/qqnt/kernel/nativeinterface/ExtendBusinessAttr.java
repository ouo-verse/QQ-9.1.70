package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ExtendBusinessAttr {
    public byte[] buffer;
    public int type;

    public ExtendBusinessAttr() {
        this.buffer = new byte[0];
    }

    public byte[] getBuffer() {
        return this.buffer;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "ExtendBusinessAttr{type=" + this.type + ",buffer=" + this.buffer + ",}";
    }

    public ExtendBusinessAttr(int i3, byte[] bArr) {
        this.type = i3;
        this.buffer = bArr;
    }
}

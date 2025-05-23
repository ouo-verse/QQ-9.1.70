package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ByteArrayField extends JceField {
    private byte[] data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteArrayField(byte[] bArr, int i3) {
        super(i3);
        this.data = bArr;
    }

    public byte[] get() {
        return this.data;
    }

    public void set(byte[] bArr) {
        this.data = bArr;
    }
}

package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ByteField extends NumberField {
    private byte data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteField(byte b16, int i3) {
        super(i3);
        this.data = b16;
    }

    public byte get() {
        return this.data;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        return Byte.valueOf(this.data);
    }

    public void set(byte b16) {
        this.data = b16;
    }
}

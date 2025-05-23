package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ShortField extends NumberField {
    private short data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShortField(short s16, int i3) {
        super(i3);
        this.data = s16;
    }

    public short get() {
        return this.data;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        return Short.valueOf(this.data);
    }

    public void set(short s16) {
        this.data = s16;
    }
}

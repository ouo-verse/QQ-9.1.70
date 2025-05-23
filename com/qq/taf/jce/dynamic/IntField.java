package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public class IntField extends NumberField {
    private int data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntField(int i3, int i16) {
        super(i16);
        this.data = i3;
    }

    public int get() {
        return this.data;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        return Integer.valueOf(this.data);
    }

    public void set(int i3) {
        this.data = i3;
    }
}

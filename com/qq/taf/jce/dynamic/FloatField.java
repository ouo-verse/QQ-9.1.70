package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FloatField extends NumberField {
    private float data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatField(float f16, int i3) {
        super(i3);
        this.data = f16;
    }

    public float get() {
        return this.data;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        return Float.valueOf(this.data);
    }

    public void set(float f16) {
        this.data = f16;
    }
}

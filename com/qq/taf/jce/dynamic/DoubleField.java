package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DoubleField extends NumberField {
    private double data;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DoubleField(double d16, int i3) {
        super(i3);
        this.data = d16;
    }

    public double get() {
        return this.data;
    }

    @Override // com.qq.taf.jce.dynamic.NumberField
    public Number getNumber() {
        return Double.valueOf(this.data);
    }

    public void set(double d16) {
        this.data = d16;
    }
}

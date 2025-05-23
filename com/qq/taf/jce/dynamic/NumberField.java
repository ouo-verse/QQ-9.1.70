package com.qq.taf.jce.dynamic;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class NumberField extends JceField {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NumberField(int i3) {
        super(i3);
    }

    public byte byteValue() {
        return getNumber().byteValue();
    }

    public double doubleValue() {
        return getNumber().doubleValue();
    }

    public float floatValue() {
        return getNumber().floatValue();
    }

    public abstract Number getNumber();

    public int intValue() {
        return getNumber().intValue();
    }

    public long longValue() {
        return getNumber().longValue();
    }

    public short shortValue() {
        return getNumber().shortValue();
    }
}

package org.apache.commons.lang.mutable;

import org.apache.commons.lang.math.NumberUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableFloat extends Number implements Comparable, Mutable {
    private static final long serialVersionUID = 5787169186L;
    private float value;

    public MutableFloat() {
    }

    public void add(float f16) {
        this.value += f16;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return NumberUtils.compare(this.value, ((MutableFloat) obj).value);
    }

    public void decrement() {
        this.value -= 1.0f;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MutableFloat) && Float.floatToIntBits(((MutableFloat) obj).value) == Float.floatToIntBits(this.value)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public Object getValue() {
        return new Float(this.value);
    }

    public int hashCode() {
        return Float.floatToIntBits(this.value);
    }

    public void increment() {
        this.value += 1.0f;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Float.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Float.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void setValue(float f16) {
        this.value = f16;
    }

    public void subtract(float f16) {
        this.value -= f16;
    }

    public Float toFloat() {
        return new Float(floatValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableFloat(float f16) {
        this.value = f16;
    }

    public void add(Number number) {
        this.value += number.floatValue();
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        setValue(((Number) obj).floatValue());
    }

    public void subtract(Number number) {
        this.value -= number.floatValue();
    }

    public MutableFloat(Number number) {
        this.value = number.floatValue();
    }

    public MutableFloat(String str) throws NumberFormatException {
        this.value = Float.parseFloat(str);
    }
}

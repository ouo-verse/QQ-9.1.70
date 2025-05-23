package org.apache.commons.lang.mutable;

import org.apache.commons.lang.math.NumberUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableDouble extends Number implements Comparable, Mutable {
    private static final long serialVersionUID = 1587163916;
    private double value;

    public MutableDouble() {
    }

    public void add(double d16) {
        this.value += d16;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return NumberUtils.compare(this.value, ((MutableDouble) obj).value);
    }

    public void decrement() {
        this.value -= 1.0d;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if ((obj instanceof MutableDouble) && Double.doubleToLongBits(((MutableDouble) obj).value) == Double.doubleToLongBits(this.value)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public Object getValue() {
        return new Double(this.value);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.value);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public void increment() {
        this.value += 1.0d;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    public boolean isInfinite() {
        return Double.isInfinite(this.value);
    }

    public boolean isNaN() {
        return Double.isNaN(this.value);
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) this.value;
    }

    public void setValue(double d16) {
        this.value = d16;
    }

    public void subtract(double d16) {
        this.value -= d16;
    }

    public Double toDouble() {
        return new Double(doubleValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableDouble(double d16) {
        this.value = d16;
    }

    public void add(Number number) {
        this.value += number.doubleValue();
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        setValue(((Number) obj).doubleValue());
    }

    public void subtract(Number number) {
        this.value -= number.doubleValue();
    }

    public MutableDouble(Number number) {
        this.value = number.doubleValue();
    }

    public MutableDouble(String str) throws NumberFormatException {
        this.value = Double.parseDouble(str);
    }
}

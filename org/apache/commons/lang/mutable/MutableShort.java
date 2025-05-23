package org.apache.commons.lang.mutable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableShort extends Number implements Comparable, Mutable {
    private static final long serialVersionUID = -2135791679;
    private short value;

    public MutableShort() {
    }

    public void add(short s16) {
        this.value = (short) (this.value + s16);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        short s16 = ((MutableShort) obj).value;
        short s17 = this.value;
        if (s17 < s16) {
            return -1;
        }
        if (s17 == s16) {
            return 0;
        }
        return 1;
    }

    public void decrement() {
        this.value = (short) (this.value - 1);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableShort) || this.value != ((MutableShort) obj).shortValue()) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.value;
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public Object getValue() {
        return new Short(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (short) (this.value + 1);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void setValue(short s16) {
        this.value = s16;
    }

    @Override // java.lang.Number
    public short shortValue() {
        return this.value;
    }

    public void subtract(short s16) {
        this.value = (short) (this.value - s16);
    }

    public Short toShort() {
        return new Short(shortValue());
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }

    public MutableShort(short s16) {
        this.value = s16;
    }

    public void add(Number number) {
        this.value = (short) (this.value + number.shortValue());
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        setValue(((Number) obj).shortValue());
    }

    public void subtract(Number number) {
        this.value = (short) (this.value - number.shortValue());
    }

    public MutableShort(Number number) {
        this.value = number.shortValue();
    }

    public MutableShort(String str) throws NumberFormatException {
        this.value = Short.parseShort(str);
    }
}

package org.apache.commons.lang.mutable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableByte extends Number implements Comparable, Mutable {
    private static final long serialVersionUID = -1585823265;
    private byte value;

    public MutableByte() {
    }

    public void add(byte b16) {
        this.value = (byte) (this.value + b16);
    }

    @Override // java.lang.Number
    public byte byteValue() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        byte b16 = ((MutableByte) obj).value;
        byte b17 = this.value;
        if (b17 < b16) {
            return -1;
        }
        if (b17 == b16) {
            return 0;
        }
        return 1;
    }

    public void decrement() {
        this.value = (byte) (this.value - 1);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableByte) || this.value != ((MutableByte) obj).byteValue()) {
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
        return new Byte(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value = (byte) (this.value + 1);
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void setValue(byte b16) {
        this.value = b16;
    }

    public void subtract(byte b16) {
        this.value = (byte) (this.value - b16);
    }

    public Byte toByte() {
        return new Byte(byteValue());
    }

    public String toString() {
        return String.valueOf((int) this.value);
    }

    public MutableByte(byte b16) {
        this.value = b16;
    }

    public void add(Number number) {
        this.value = (byte) (this.value + number.byteValue());
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        setValue(((Number) obj).byteValue());
    }

    public void subtract(Number number) {
        this.value = (byte) (this.value - number.byteValue());
    }

    public MutableByte(Number number) {
        this.value = number.byteValue();
    }

    public MutableByte(String str) throws NumberFormatException {
        this.value = Byte.parseByte(str);
    }
}

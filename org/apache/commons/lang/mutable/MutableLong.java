package org.apache.commons.lang.mutable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableLong extends Number implements Comparable, Mutable {
    private static final long serialVersionUID = 62986528375L;
    private long value;

    public MutableLong() {
    }

    public void add(long j3) {
        this.value += j3;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        long j3 = ((MutableLong) obj).value;
        long j16 = this.value;
        if (j16 < j3) {
            return -1;
        }
        if (j16 == j3) {
            return 0;
        }
        return 1;
    }

    public void decrement() {
        this.value--;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MutableLong) || this.value != ((MutableLong) obj).longValue()) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) this.value;
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public Object getValue() {
        return new Long(this.value);
    }

    public int hashCode() {
        long j3 = this.value;
        return (int) (j3 ^ (j3 >>> 32));
    }

    public void increment() {
        this.value++;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void setValue(long j3) {
        this.value = j3;
    }

    public void subtract(long j3) {
        this.value -= j3;
    }

    public Long toLong() {
        return new Long(longValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableLong(long j3) {
        this.value = j3;
    }

    public void add(Number number) {
        this.value += number.longValue();
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        setValue(((Number) obj).longValue());
    }

    public void subtract(Number number) {
        this.value -= number.longValue();
    }

    public MutableLong(Number number) {
        this.value = number.longValue();
    }

    public MutableLong(String str) throws NumberFormatException {
        this.value = Long.parseLong(str);
    }
}

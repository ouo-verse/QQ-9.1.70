package org.apache.commons.lang.mutable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MutableInt extends Number implements Comparable, Mutable {
    private static final long serialVersionUID = 512176391864L;
    private int value;

    public MutableInt() {
    }

    public void add(int i3) {
        this.value += i3;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        int i3 = ((MutableInt) obj).value;
        int i16 = this.value;
        if (i16 < i3) {
            return -1;
        }
        if (i16 == i3) {
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
        if (!(obj instanceof MutableInt) || this.value != ((MutableInt) obj).intValue()) {
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
        return new Integer(this.value);
    }

    public int hashCode() {
        return this.value;
    }

    public void increment() {
        this.value++;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public void setValue(int i3) {
        this.value = i3;
    }

    public void subtract(int i3) {
        this.value -= i3;
    }

    public Integer toInteger() {
        return new Integer(intValue());
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public MutableInt(int i3) {
        this.value = i3;
    }

    public void add(Number number) {
        this.value += number.intValue();
    }

    @Override // org.apache.commons.lang.mutable.Mutable
    public void setValue(Object obj) {
        setValue(((Number) obj).intValue());
    }

    public void subtract(Number number) {
        this.value -= number.intValue();
    }

    public MutableInt(Number number) {
        this.value = number.intValue();
    }

    public MutableInt(String str) throws NumberFormatException {
        this.value = Integer.parseInt(str);
    }
}

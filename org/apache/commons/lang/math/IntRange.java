package org.apache.commons.lang.math;

import java.io.Serializable;
import org.apache.commons.lang.text.StrBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class IntRange extends Range implements Serializable {
    private static final long serialVersionUID = 71849363892730L;
    private transient int hashCode;
    private final int max;
    private transient Integer maxObject;
    private final int min;
    private transient Integer minObject;
    private transient String toString;

    public IntRange(int i3) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        this.min = i3;
        this.max = i3;
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean containsInteger(int i3) {
        if (i3 >= this.min && i3 <= this.max) {
            return true;
        }
        return false;
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsInteger(number.intValue());
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean containsRange(Range range) {
        if (range == null || !containsInteger(range.getMinimumInteger()) || !containsInteger(range.getMaximumInteger())) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IntRange)) {
            return false;
        }
        IntRange intRange = (IntRange) obj;
        if (this.min == intRange.min && this.max == intRange.max) {
            return true;
        }
        return false;
    }

    @Override // org.apache.commons.lang.math.Range
    public double getMaximumDouble() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.Range
    public float getMaximumFloat() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.Range
    public int getMaximumInteger() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.Range
    public long getMaximumLong() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.Range
    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Integer(this.max);
        }
        return this.maxObject;
    }

    @Override // org.apache.commons.lang.math.Range
    public double getMinimumDouble() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.Range
    public float getMinimumFloat() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.Range
    public int getMinimumInteger() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.Range
    public long getMinimumLong() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.Range
    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Integer(this.min);
        }
        return this.minObject;
    }

    @Override // org.apache.commons.lang.math.Range
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            this.hashCode = (((((17 * 37) + IntRange.class.hashCode()) * 37) + this.min) * 37) + this.max;
        }
        return this.hashCode;
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean overlapsRange(Range range) {
        if (range == null) {
            return false;
        }
        if (!range.containsInteger(this.min) && !range.containsInteger(this.max) && !containsInteger(range.getMinimumInteger())) {
            return false;
        }
        return true;
    }

    public int[] toArray() {
        int i3 = (this.max - this.min) + 1;
        int[] iArr = new int[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            iArr[i16] = this.min + i16;
        }
        return iArr;
    }

    @Override // org.apache.commons.lang.math.Range
    public String toString() {
        if (this.toString == null) {
            StrBuilder strBuilder = new StrBuilder(32);
            strBuilder.append("Range[");
            strBuilder.append(this.min);
            strBuilder.append(',');
            strBuilder.append(this.max);
            strBuilder.append(']');
            this.toString = strBuilder.toString();
        }
        return this.toString;
    }

    public IntRange(Number number) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number != null) {
            this.min = number.intValue();
            this.max = number.intValue();
            if (number instanceof Integer) {
                Integer num = (Integer) number;
                this.minObject = num;
                this.maxObject = num;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The number must not be null");
    }

    public IntRange(int i3, int i16) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (i16 < i3) {
            this.min = i16;
            this.max = i3;
        } else {
            this.min = i3;
            this.max = i16;
        }
    }

    public IntRange(Number number, Number number2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number != null && number2 != null) {
            int intValue = number.intValue();
            int intValue2 = number2.intValue();
            if (intValue2 < intValue) {
                this.min = intValue2;
                this.max = intValue;
                if (number2 instanceof Integer) {
                    this.minObject = (Integer) number2;
                }
                if (number instanceof Integer) {
                    this.maxObject = (Integer) number;
                    return;
                }
                return;
            }
            this.min = intValue;
            this.max = intValue2;
            if (number instanceof Integer) {
                this.minObject = (Integer) number;
            }
            if (number2 instanceof Integer) {
                this.maxObject = (Integer) number2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The numbers must not be null");
    }
}

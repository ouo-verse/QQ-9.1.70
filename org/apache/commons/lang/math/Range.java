package org.apache.commons.lang.math;

import org.apache.commons.lang.text.StrBuilder;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Range {
    public boolean containsDouble(Number number) {
        if (number == null) {
            return false;
        }
        return containsDouble(number.doubleValue());
    }

    public boolean containsFloat(Number number) {
        if (number == null) {
            return false;
        }
        return containsFloat(number.floatValue());
    }

    public boolean containsInteger(Number number) {
        if (number == null) {
            return false;
        }
        return containsInteger(number.intValue());
    }

    public boolean containsLong(Number number) {
        if (number == null) {
            return false;
        }
        return containsLong(number.longValue());
    }

    public abstract boolean containsNumber(Number number);

    public boolean containsRange(Range range) {
        if (range == null || !containsNumber(range.getMinimumNumber()) || !containsNumber(range.getMaximumNumber())) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Range range = (Range) obj;
        if (getMinimumNumber().equals(range.getMinimumNumber()) && getMaximumNumber().equals(range.getMaximumNumber())) {
            return true;
        }
        return false;
    }

    public double getMaximumDouble() {
        return getMaximumNumber().doubleValue();
    }

    public float getMaximumFloat() {
        return getMaximumNumber().floatValue();
    }

    public int getMaximumInteger() {
        return getMaximumNumber().intValue();
    }

    public long getMaximumLong() {
        return getMaximumNumber().longValue();
    }

    public abstract Number getMaximumNumber();

    public double getMinimumDouble() {
        return getMinimumNumber().doubleValue();
    }

    public float getMinimumFloat() {
        return getMinimumNumber().floatValue();
    }

    public int getMinimumInteger() {
        return getMinimumNumber().intValue();
    }

    public long getMinimumLong() {
        return getMinimumNumber().longValue();
    }

    public abstract Number getMinimumNumber();

    public int hashCode() {
        return ((((629 + getClass().hashCode()) * 37) + getMinimumNumber().hashCode()) * 37) + getMaximumNumber().hashCode();
    }

    public boolean overlapsRange(Range range) {
        if (range == null) {
            return false;
        }
        if (!range.containsNumber(getMinimumNumber()) && !range.containsNumber(getMaximumNumber()) && !containsNumber(range.getMinimumNumber())) {
            return false;
        }
        return true;
    }

    public String toString() {
        StrBuilder strBuilder = new StrBuilder(32);
        strBuilder.append("Range[");
        strBuilder.append(getMinimumNumber());
        strBuilder.append(',');
        strBuilder.append(getMaximumNumber());
        strBuilder.append(']');
        return strBuilder.toString();
    }

    public boolean containsDouble(double d16) {
        return NumberUtils.compare(getMinimumDouble(), d16) <= 0 && NumberUtils.compare(getMaximumDouble(), d16) >= 0;
    }

    public boolean containsFloat(float f16) {
        return NumberUtils.compare(getMinimumFloat(), f16) <= 0 && NumberUtils.compare(getMaximumFloat(), f16) >= 0;
    }

    public boolean containsInteger(int i3) {
        return i3 >= getMinimumInteger() && i3 <= getMaximumInteger();
    }

    public boolean containsLong(long j3) {
        return j3 >= getMinimumLong() && j3 <= getMaximumLong();
    }
}

package org.apache.commons.lang.math;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FloatRange extends Range implements Serializable {
    private static final long serialVersionUID = 71849363892750L;
    private transient int hashCode;
    private final float max;
    private transient Float maxObject;
    private final float min;
    private transient Float minObject;
    private transient String toString;

    public FloatRange(float f16) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (!Float.isNaN(f16)) {
            this.min = f16;
            this.max = f16;
            return;
        }
        throw new IllegalArgumentException("The number must not be NaN");
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean containsFloat(float f16) {
        if (f16 >= this.min && f16 <= this.max) {
            return true;
        }
        return false;
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean containsNumber(Number number) {
        if (number == null) {
            return false;
        }
        return containsFloat(number.floatValue());
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean containsRange(Range range) {
        if (range == null || !containsFloat(range.getMinimumFloat()) || !containsFloat(range.getMaximumFloat())) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FloatRange)) {
            return false;
        }
        FloatRange floatRange = (FloatRange) obj;
        if (Float.floatToIntBits(this.min) == Float.floatToIntBits(floatRange.min) && Float.floatToIntBits(this.max) == Float.floatToIntBits(floatRange.max)) {
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
        return (int) this.max;
    }

    @Override // org.apache.commons.lang.math.Range
    public long getMaximumLong() {
        return this.max;
    }

    @Override // org.apache.commons.lang.math.Range
    public Number getMaximumNumber() {
        if (this.maxObject == null) {
            this.maxObject = new Float(this.max);
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
        return (int) this.min;
    }

    @Override // org.apache.commons.lang.math.Range
    public long getMinimumLong() {
        return this.min;
    }

    @Override // org.apache.commons.lang.math.Range
    public Number getMinimumNumber() {
        if (this.minObject == null) {
            this.minObject = new Float(this.min);
        }
        return this.minObject;
    }

    @Override // org.apache.commons.lang.math.Range
    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 17;
            int hashCode = (17 * 37) + FloatRange.class.hashCode();
            this.hashCode = hashCode;
            int floatToIntBits = (hashCode * 37) + Float.floatToIntBits(this.min);
            this.hashCode = floatToIntBits;
            this.hashCode = (floatToIntBits * 37) + Float.floatToIntBits(this.max);
        }
        return this.hashCode;
    }

    @Override // org.apache.commons.lang.math.Range
    public boolean overlapsRange(Range range) {
        if (range == null) {
            return false;
        }
        if (!range.containsFloat(this.min) && !range.containsFloat(this.max) && !containsFloat(range.getMinimumFloat())) {
            return false;
        }
        return true;
    }

    @Override // org.apache.commons.lang.math.Range
    public String toString() {
        if (this.toString == null) {
            StringBuffer stringBuffer = new StringBuffer(32);
            stringBuffer.append("Range[");
            stringBuffer.append(this.min);
            stringBuffer.append(',');
            stringBuffer.append(this.max);
            stringBuffer.append(']');
            this.toString = stringBuffer.toString();
        }
        return this.toString;
    }

    public FloatRange(Number number) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number != null) {
            float floatValue = number.floatValue();
            this.min = floatValue;
            float floatValue2 = number.floatValue();
            this.max = floatValue2;
            if (!Float.isNaN(floatValue) && !Float.isNaN(floatValue2)) {
                if (number instanceof Float) {
                    Float f16 = (Float) number;
                    this.minObject = f16;
                    this.maxObject = f16;
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("The number must not be NaN");
        }
        throw new IllegalArgumentException("The number must not be null");
    }

    public FloatRange(float f16, float f17) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (Float.isNaN(f16) || Float.isNaN(f17)) {
            throw new IllegalArgumentException("The numbers must not be NaN");
        }
        if (f17 < f16) {
            this.min = f17;
            this.max = f16;
        } else {
            this.min = f16;
            this.max = f17;
        }
    }

    public FloatRange(Number number, Number number2) {
        this.minObject = null;
        this.maxObject = null;
        this.hashCode = 0;
        this.toString = null;
        if (number != null && number2 != null) {
            float floatValue = number.floatValue();
            float floatValue2 = number2.floatValue();
            if (Float.isNaN(floatValue) || Float.isNaN(floatValue2)) {
                throw new IllegalArgumentException("The numbers must not be NaN");
            }
            if (floatValue2 < floatValue) {
                this.min = floatValue2;
                this.max = floatValue;
                if (number2 instanceof Float) {
                    this.minObject = (Float) number2;
                }
                if (number instanceof Float) {
                    this.maxObject = (Float) number;
                    return;
                }
                return;
            }
            this.min = floatValue;
            this.max = floatValue2;
            if (number instanceof Float) {
                this.minObject = (Float) number;
            }
            if (number2 instanceof Float) {
                this.maxObject = (Float) number2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The numbers must not be null");
    }
}

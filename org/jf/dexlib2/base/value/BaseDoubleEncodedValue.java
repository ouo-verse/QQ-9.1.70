package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.DoubleEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseDoubleEncodedValue implements DoubleEncodedValue {
    @Override // org.jf.dexlib2.iface.value.DoubleEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof DoubleEncodedValue) || Double.doubleToRawLongBits(getValue()) != Double.doubleToRawLongBits(((DoubleEncodedValue) obj).getValue())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 17;
    }

    @Override // org.jf.dexlib2.iface.value.DoubleEncodedValue
    public int hashCode() {
        long doubleToRawLongBits = Double.doubleToRawLongBits(getValue());
        return (int) (doubleToRawLongBits ^ (doubleToRawLongBits >>> 32));
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.DoubleEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : Double.compare(getValue(), ((DoubleEncodedValue) encodedValue).getValue());
    }
}

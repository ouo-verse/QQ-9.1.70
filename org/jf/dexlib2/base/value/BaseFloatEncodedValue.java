package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.FloatEncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseFloatEncodedValue implements FloatEncodedValue {
    @Override // org.jf.dexlib2.iface.value.FloatEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof FloatEncodedValue) || Float.floatToRawIntBits(getValue()) != Float.floatToRawIntBits(((FloatEncodedValue) obj).getValue())) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 16;
    }

    @Override // org.jf.dexlib2.iface.value.FloatEncodedValue
    public int hashCode() {
        return Float.floatToRawIntBits(getValue());
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.FloatEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : Float.compare(getValue(), ((FloatEncodedValue) encodedValue).getValue());
    }
}

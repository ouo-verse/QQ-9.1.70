package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.LongEncodedValue;
import s1.c;
import s1.d;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseLongEncodedValue implements LongEncodedValue {
    @Override // org.jf.dexlib2.iface.value.LongEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof LongEncodedValue) || getValue() != ((LongEncodedValue) obj).getValue()) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 6;
    }

    @Override // org.jf.dexlib2.iface.value.LongEncodedValue
    public int hashCode() {
        long value = getValue();
        return (((int) value) * 31) + ((int) (value >>> 32));
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.LongEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : d.a(getValue(), ((LongEncodedValue) encodedValue).getValue());
    }
}

package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.IntEncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseIntEncodedValue implements IntEncodedValue {
    @Override // org.jf.dexlib2.iface.value.IntEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof IntEncodedValue) || getValue() != ((IntEncodedValue) obj).getValue()) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 4;
    }

    @Override // org.jf.dexlib2.iface.value.IntEncodedValue
    public int hashCode() {
        return getValue();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.IntEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : c.a(getValue(), ((IntEncodedValue) encodedValue).getValue());
    }
}

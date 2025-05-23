package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.ArrayEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.util.CollectionUtils;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseArrayEncodedValue implements ArrayEncodedValue {
    @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ArrayEncodedValue) {
            return getValue().equals(((ArrayEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 28;
    }

    @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.ArrayEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : CollectionUtils.compareAsList(getValue(), ((ArrayEncodedValue) encodedValue).getValue());
    }
}

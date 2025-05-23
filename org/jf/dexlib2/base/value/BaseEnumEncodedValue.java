package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.EnumEncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseEnumEncodedValue implements EnumEncodedValue {
    @Override // org.jf.dexlib2.iface.value.EnumEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof EnumEncodedValue) {
            return getValue().equals(((EnumEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 27;
    }

    @Override // org.jf.dexlib2.iface.value.EnumEncodedValue
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.EnumEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : getValue().compareTo(((EnumEncodedValue) encodedValue).getValue());
    }
}

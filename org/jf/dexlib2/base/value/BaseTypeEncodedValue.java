package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseTypeEncodedValue implements TypeEncodedValue {
    @Override // org.jf.dexlib2.iface.value.TypeEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof TypeEncodedValue) {
            return getValue().equals(((TypeEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 24;
    }

    @Override // org.jf.dexlib2.iface.value.TypeEncodedValue
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.TypeEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : getValue().compareTo(((TypeEncodedValue) encodedValue).getValue());
    }
}

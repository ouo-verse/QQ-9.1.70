package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.CharEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import s1.b;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseCharEncodedValue implements CharEncodedValue {
    @Override // org.jf.dexlib2.iface.value.CharEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CharEncodedValue) || getValue() != ((CharEncodedValue) obj).getValue()) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 3;
    }

    @Override // org.jf.dexlib2.iface.value.CharEncodedValue
    public int hashCode() {
        return getValue();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.CharEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : b.a(getValue(), ((CharEncodedValue) encodedValue).getValue());
    }
}

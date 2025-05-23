package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.BooleanEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import s1.a;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseBooleanEncodedValue implements BooleanEncodedValue {
    @Override // org.jf.dexlib2.iface.value.BooleanEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof BooleanEncodedValue) || getValue() != ((BooleanEncodedValue) obj).getValue()) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 31;
    }

    @Override // org.jf.dexlib2.iface.value.BooleanEncodedValue
    public int hashCode() {
        return getValue() ? 1 : 0;
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.BooleanEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : a.a(getValue(), ((BooleanEncodedValue) encodedValue).getValue());
    }
}

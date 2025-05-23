package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.ShortEncodedValue;
import s1.c;
import s1.e;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseShortEncodedValue implements ShortEncodedValue {
    @Override // org.jf.dexlib2.iface.value.ShortEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ShortEncodedValue) || getValue() != ((ShortEncodedValue) obj).getValue()) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 2;
    }

    @Override // org.jf.dexlib2.iface.value.ShortEncodedValue
    public int hashCode() {
        return getValue();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.ShortEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : e.a(getValue(), ((ShortEncodedValue) encodedValue).getValue());
    }
}

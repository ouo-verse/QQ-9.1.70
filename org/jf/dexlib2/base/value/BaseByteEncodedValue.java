package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.ByteEncodedValue;
import org.jf.dexlib2.iface.value.EncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseByteEncodedValue implements ByteEncodedValue {
    @Override // org.jf.dexlib2.iface.value.ByteEncodedValue
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ByteEncodedValue) || getValue() != ((ByteEncodedValue) obj).getValue()) {
            return false;
        }
        return true;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 0;
    }

    @Override // org.jf.dexlib2.iface.value.ByteEncodedValue
    public int hashCode() {
        return getValue();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.ByteEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : c.a(getValue(), ((ByteEncodedValue) encodedValue).getValue());
    }
}

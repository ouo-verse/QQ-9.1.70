package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.NullEncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseNullEncodedValue implements NullEncodedValue {
    @Override // org.jf.dexlib2.iface.value.NullEncodedValue
    public boolean equals(@Nullable Object obj) {
        return obj instanceof NullEncodedValue;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 30;
    }

    @Override // org.jf.dexlib2.iface.value.NullEncodedValue
    public int hashCode() {
        return 0;
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.NullEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        return c.a(getValueType(), encodedValue.getValueType());
    }
}

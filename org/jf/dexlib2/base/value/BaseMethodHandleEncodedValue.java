package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.MethodHandleEncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseMethodHandleEncodedValue implements MethodHandleEncodedValue {
    @Override // org.jf.dexlib2.iface.value.MethodHandleEncodedValue
    public boolean equals(Object obj) {
        if (obj instanceof MethodHandleEncodedValue) {
            return getValue().equals(((MethodHandleEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 22;
    }

    @Override // org.jf.dexlib2.iface.value.MethodHandleEncodedValue
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.MethodHandleEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : getValue().compareTo(((MethodHandleEncodedValue) encodedValue).getValue());
    }
}

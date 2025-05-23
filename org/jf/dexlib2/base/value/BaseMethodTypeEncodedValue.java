package org.jf.dexlib2.base.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.formatter.DexFormatter;
import org.jf.dexlib2.iface.value.EncodedValue;
import org.jf.dexlib2.iface.value.MethodTypeEncodedValue;
import s1.c;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class BaseMethodTypeEncodedValue implements MethodTypeEncodedValue {
    @Override // org.jf.dexlib2.iface.value.MethodTypeEncodedValue
    public boolean equals(Object obj) {
        if (obj instanceof MethodTypeEncodedValue) {
            return getValue().equals(((MethodTypeEncodedValue) obj).getValue());
        }
        return false;
    }

    @Override // org.jf.dexlib2.iface.value.EncodedValue
    public int getValueType() {
        return 21;
    }

    @Override // org.jf.dexlib2.iface.value.MethodTypeEncodedValue
    public int hashCode() {
        return getValue().hashCode();
    }

    public String toString() {
        return DexFormatter.INSTANCE.getEncodedValue(this);
    }

    @Override // org.jf.dexlib2.iface.value.MethodTypeEncodedValue, java.lang.Comparable
    public int compareTo(@Nonnull EncodedValue encodedValue) {
        int a16 = c.a(getValueType(), encodedValue.getValueType());
        return a16 != 0 ? a16 : getValue().compareTo(((MethodTypeEncodedValue) encodedValue).getValue());
    }
}

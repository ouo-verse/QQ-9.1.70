package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseByteEncodedValue;
import org.jf.dexlib2.iface.value.ByteEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableByteEncodedValue extends BaseByteEncodedValue implements ImmutableEncodedValue {
    protected final byte value;

    public ImmutableByteEncodedValue(byte b16) {
        this.value = b16;
    }

    public static ImmutableByteEncodedValue of(ByteEncodedValue byteEncodedValue) {
        if (byteEncodedValue instanceof ImmutableByteEncodedValue) {
            return (ImmutableByteEncodedValue) byteEncodedValue;
        }
        return new ImmutableByteEncodedValue(byteEncodedValue.getValue());
    }

    @Override // org.jf.dexlib2.iface.value.ByteEncodedValue
    public byte getValue() {
        return this.value;
    }
}

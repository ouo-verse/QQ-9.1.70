package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseCharEncodedValue;
import org.jf.dexlib2.iface.value.CharEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableCharEncodedValue extends BaseCharEncodedValue implements ImmutableEncodedValue {
    protected final char value;

    public ImmutableCharEncodedValue(char c16) {
        this.value = c16;
    }

    public static ImmutableCharEncodedValue of(CharEncodedValue charEncodedValue) {
        if (charEncodedValue instanceof ImmutableCharEncodedValue) {
            return (ImmutableCharEncodedValue) charEncodedValue;
        }
        return new ImmutableCharEncodedValue(charEncodedValue.getValue());
    }

    @Override // org.jf.dexlib2.iface.value.CharEncodedValue
    public char getValue() {
        return this.value;
    }
}

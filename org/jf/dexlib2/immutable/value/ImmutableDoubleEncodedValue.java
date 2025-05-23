package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseDoubleEncodedValue;
import org.jf.dexlib2.iface.value.DoubleEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableDoubleEncodedValue extends BaseDoubleEncodedValue implements ImmutableEncodedValue {
    protected final double value;

    public ImmutableDoubleEncodedValue(double d16) {
        this.value = d16;
    }

    public static ImmutableDoubleEncodedValue of(DoubleEncodedValue doubleEncodedValue) {
        if (doubleEncodedValue instanceof ImmutableDoubleEncodedValue) {
            return (ImmutableDoubleEncodedValue) doubleEncodedValue;
        }
        return new ImmutableDoubleEncodedValue(doubleEncodedValue.getValue());
    }

    @Override // org.jf.dexlib2.iface.value.DoubleEncodedValue
    public double getValue() {
        return this.value;
    }
}

package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseFloatEncodedValue;
import org.jf.dexlib2.iface.value.FloatEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableFloatEncodedValue extends BaseFloatEncodedValue implements ImmutableEncodedValue {
    protected final float value;

    public ImmutableFloatEncodedValue(float f16) {
        this.value = f16;
    }

    public static ImmutableFloatEncodedValue of(FloatEncodedValue floatEncodedValue) {
        if (floatEncodedValue instanceof ImmutableFloatEncodedValue) {
            return (ImmutableFloatEncodedValue) floatEncodedValue;
        }
        return new ImmutableFloatEncodedValue(floatEncodedValue.getValue());
    }

    @Override // org.jf.dexlib2.iface.value.FloatEncodedValue
    public float getValue() {
        return this.value;
    }
}

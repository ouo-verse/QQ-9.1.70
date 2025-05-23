package org.jf.dexlib2.immutable.value;

import org.jf.dexlib2.base.value.BaseBooleanEncodedValue;
import org.jf.dexlib2.iface.value.BooleanEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableBooleanEncodedValue extends BaseBooleanEncodedValue implements ImmutableEncodedValue {
    protected final boolean value;
    public static final ImmutableBooleanEncodedValue TRUE_VALUE = new ImmutableBooleanEncodedValue(true);
    public static final ImmutableBooleanEncodedValue FALSE_VALUE = new ImmutableBooleanEncodedValue(false);

    ImmutableBooleanEncodedValue(boolean z16) {
        this.value = z16;
    }

    public static ImmutableBooleanEncodedValue forBoolean(boolean z16) {
        if (z16) {
            return TRUE_VALUE;
        }
        return FALSE_VALUE;
    }

    public static ImmutableBooleanEncodedValue of(BooleanEncodedValue booleanEncodedValue) {
        return forBoolean(booleanEncodedValue.getValue());
    }

    @Override // org.jf.dexlib2.iface.value.BooleanEncodedValue
    public boolean getValue() {
        return this.value;
    }
}

package org.jf.dexlib2.immutable.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseEnumEncodedValue;
import org.jf.dexlib2.iface.value.EnumEncodedValue;
import org.jf.dexlib2.immutable.reference.ImmutableFieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableEnumEncodedValue extends BaseEnumEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final ImmutableFieldReference value;

    public ImmutableEnumEncodedValue(@Nonnull ImmutableFieldReference immutableFieldReference) {
        this.value = immutableFieldReference;
    }

    public static ImmutableEnumEncodedValue of(EnumEncodedValue enumEncodedValue) {
        if (enumEncodedValue instanceof ImmutableEnumEncodedValue) {
            return (ImmutableEnumEncodedValue) enumEncodedValue;
        }
        return new ImmutableEnumEncodedValue(ImmutableFieldReference.of(enumEncodedValue.getValue()));
    }

    @Override // org.jf.dexlib2.iface.value.EnumEncodedValue
    @Nonnull
    public ImmutableFieldReference getValue() {
        return this.value;
    }
}

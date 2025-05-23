package org.jf.dexlib2.immutable.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseFieldEncodedValue;
import org.jf.dexlib2.iface.value.FieldEncodedValue;
import org.jf.dexlib2.immutable.reference.ImmutableFieldReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableFieldEncodedValue extends BaseFieldEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final ImmutableFieldReference value;

    public ImmutableFieldEncodedValue(@Nonnull ImmutableFieldReference immutableFieldReference) {
        this.value = immutableFieldReference;
    }

    public static ImmutableFieldEncodedValue of(@Nonnull FieldEncodedValue fieldEncodedValue) {
        if (fieldEncodedValue instanceof ImmutableFieldEncodedValue) {
            return (ImmutableFieldEncodedValue) fieldEncodedValue;
        }
        return new ImmutableFieldEncodedValue(ImmutableFieldReference.of(fieldEncodedValue.getValue()));
    }

    @Override // org.jf.dexlib2.iface.value.FieldEncodedValue
    @Nonnull
    public ImmutableFieldReference getValue() {
        return this.value;
    }
}

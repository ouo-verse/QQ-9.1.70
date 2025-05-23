package org.jf.dexlib2.immutable.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseMethodEncodedValue;
import org.jf.dexlib2.iface.value.MethodEncodedValue;
import org.jf.dexlib2.immutable.reference.ImmutableMethodReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMethodEncodedValue extends BaseMethodEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final ImmutableMethodReference value;

    public ImmutableMethodEncodedValue(@Nonnull ImmutableMethodReference immutableMethodReference) {
        this.value = immutableMethodReference;
    }

    public static ImmutableMethodEncodedValue of(@Nonnull MethodEncodedValue methodEncodedValue) {
        if (methodEncodedValue instanceof ImmutableMethodEncodedValue) {
            return (ImmutableMethodEncodedValue) methodEncodedValue;
        }
        return new ImmutableMethodEncodedValue(ImmutableMethodReference.of(methodEncodedValue.getValue()));
    }

    @Override // org.jf.dexlib2.iface.value.MethodEncodedValue
    @Nonnull
    public ImmutableMethodReference getValue() {
        return this.value;
    }
}

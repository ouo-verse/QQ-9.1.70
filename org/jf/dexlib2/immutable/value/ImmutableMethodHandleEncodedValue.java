package org.jf.dexlib2.immutable.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseMethodHandleEncodedValue;
import org.jf.dexlib2.iface.value.MethodHandleEncodedValue;
import org.jf.dexlib2.immutable.reference.ImmutableMethodHandleReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMethodHandleEncodedValue extends BaseMethodHandleEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final ImmutableMethodHandleReference methodHandleReference;

    public ImmutableMethodHandleEncodedValue(@Nonnull ImmutableMethodHandleReference immutableMethodHandleReference) {
        this.methodHandleReference = immutableMethodHandleReference;
    }

    @Nonnull
    public static ImmutableMethodHandleEncodedValue of(@Nonnull MethodHandleEncodedValue methodHandleEncodedValue) {
        if (methodHandleEncodedValue instanceof ImmutableMethodHandleEncodedValue) {
            return (ImmutableMethodHandleEncodedValue) methodHandleEncodedValue;
        }
        return new ImmutableMethodHandleEncodedValue(ImmutableMethodHandleReference.of(methodHandleEncodedValue.getValue()));
    }

    @Override // org.jf.dexlib2.iface.value.MethodHandleEncodedValue
    @Nonnull
    public ImmutableMethodHandleReference getValue() {
        return this.methodHandleReference;
    }
}

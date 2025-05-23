package org.jf.dexlib2.immutable.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseMethodTypeEncodedValue;
import org.jf.dexlib2.iface.value.MethodTypeEncodedValue;
import org.jf.dexlib2.immutable.reference.ImmutableMethodProtoReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableMethodTypeEncodedValue extends BaseMethodTypeEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final ImmutableMethodProtoReference methodProtoReference;

    public ImmutableMethodTypeEncodedValue(@Nonnull ImmutableMethodProtoReference immutableMethodProtoReference) {
        this.methodProtoReference = immutableMethodProtoReference;
    }

    @Nonnull
    public static ImmutableMethodTypeEncodedValue of(@Nonnull MethodTypeEncodedValue methodTypeEncodedValue) {
        if (methodTypeEncodedValue instanceof ImmutableMethodTypeEncodedValue) {
            return (ImmutableMethodTypeEncodedValue) methodTypeEncodedValue;
        }
        return new ImmutableMethodTypeEncodedValue(ImmutableMethodProtoReference.of(methodTypeEncodedValue.getValue()));
    }

    @Override // org.jf.dexlib2.iface.value.MethodTypeEncodedValue
    @Nonnull
    public ImmutableMethodProtoReference getValue() {
        return this.methodProtoReference;
    }
}

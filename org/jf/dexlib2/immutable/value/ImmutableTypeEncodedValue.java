package org.jf.dexlib2.immutable.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseTypeEncodedValue;
import org.jf.dexlib2.iface.value.TypeEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableTypeEncodedValue extends BaseTypeEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final String value;

    public ImmutableTypeEncodedValue(@Nonnull String str) {
        this.value = str;
    }

    public static ImmutableTypeEncodedValue of(@Nonnull TypeEncodedValue typeEncodedValue) {
        if (typeEncodedValue instanceof ImmutableTypeEncodedValue) {
            return (ImmutableTypeEncodedValue) typeEncodedValue;
        }
        return new ImmutableTypeEncodedValue(typeEncodedValue.getValue());
    }

    @Override // org.jf.dexlib2.iface.value.TypeEncodedValue
    @Nonnull
    public String getValue() {
        return this.value;
    }
}

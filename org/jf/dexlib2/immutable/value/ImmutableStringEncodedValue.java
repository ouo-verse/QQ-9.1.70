package org.jf.dexlib2.immutable.value;

import javax.annotation.Nonnull;
import org.jf.dexlib2.base.value.BaseStringEncodedValue;
import org.jf.dexlib2.iface.value.StringEncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ImmutableStringEncodedValue extends BaseStringEncodedValue implements ImmutableEncodedValue {

    @Nonnull
    protected final String value;

    public ImmutableStringEncodedValue(@Nonnull String str) {
        this.value = str;
    }

    public static ImmutableStringEncodedValue of(@Nonnull StringEncodedValue stringEncodedValue) {
        if (stringEncodedValue instanceof ImmutableStringEncodedValue) {
            return (ImmutableStringEncodedValue) stringEncodedValue;
        }
        return new ImmutableStringEncodedValue(stringEncodedValue.getValue());
    }

    @Override // org.jf.dexlib2.iface.value.StringEncodedValue
    @Nonnull
    public String getValue() {
        return this.value;
    }
}

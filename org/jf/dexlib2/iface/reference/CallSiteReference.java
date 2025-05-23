package org.jf.dexlib2.iface.reference;

import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.value.EncodedValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface CallSiteReference extends Reference {
    boolean equals(@Nullable Object obj);

    @Nonnull
    List<? extends EncodedValue> getExtraArguments();

    @Nonnull
    MethodHandleReference getMethodHandle();

    @Nonnull
    String getMethodName();

    @Nonnull
    MethodProtoReference getMethodProto();

    @Nonnull
    String getName();

    int hashCode();
}

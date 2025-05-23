package org.jf.dexlib2.iface;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.jf.dexlib2.iface.reference.TypeReference;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface ExceptionHandler extends Comparable<ExceptionHandler> {
    @Override // java.lang.Comparable
    /* bridge */ /* synthetic */ int compareTo(@Nonnull ExceptionHandler exceptionHandler);

    /* JADX WARN: Can't rename method to resolve collision */
    int compareTo(@Nonnull ExceptionHandler exceptionHandler);

    boolean equals(@Nullable Object obj);

    @Nullable
    String getExceptionType();

    @Nullable
    TypeReference getExceptionTypeReference();

    int getHandlerCodeAddress();

    int hashCode();
}

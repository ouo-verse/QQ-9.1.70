package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public interface d<F, T> {
    @CanIgnoreReturnValue
    @NullableDecl
    T apply(@NullableDecl F f16);

    boolean equals(@NullableDecl Object obj);
}

package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class t<V> extends AbstractFuture.h<V> {
    t() {
    }

    public static <V> t<V> I() {
        return new t<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean D(@NullableDecl V v3) {
        return super.D(v3);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean E(Throwable th5) {
        return super.E(th5);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    @Beta
    public boolean F(q<? extends V> qVar) {
        return super.F(qVar);
    }
}

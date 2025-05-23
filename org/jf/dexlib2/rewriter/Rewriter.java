package org.jf.dexlib2.rewriter;

import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Rewriter<T> {
    @Nonnull
    T rewrite(@Nonnull T t16);
}

package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public interface x<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    E next();

    E peek();
}

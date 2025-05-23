package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Iterator;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ai<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

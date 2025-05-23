package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class o {
    protected abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}

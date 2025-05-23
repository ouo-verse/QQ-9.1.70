package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.common.base.d<F, ? extends T> function;
    final Ordering<T> ordering;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByFunctionOrdering(com.google.common.base.d<F, ? extends T> dVar, Ordering<T> ordering) {
        this.function = (com.google.common.base.d) com.google.common.base.j.m(dVar);
        this.ordering = (Ordering) com.google.common.base.j.m(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(F f16, F f17) {
        return this.ordering.compare(this.function.apply(f16), this.function.apply(f17));
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        if (this.function.equals(byFunctionOrdering.function) && this.ordering.equals(byFunctionOrdering.ordering)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return com.google.common.base.g.b(this.function, this.ordering);
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}

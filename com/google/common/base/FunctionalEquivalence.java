package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@Beta
@GwtCompatible
/* loaded from: classes2.dex */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final d<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FunctionalEquivalence(d<F, ? extends T> dVar, Equivalence<T> equivalence) {
        this.function = (d) j.m(dVar);
        this.resultEquivalence = (Equivalence) j.m(equivalence);
    }

    @Override // com.google.common.base.Equivalence
    protected boolean doEquivalent(F f16, F f17) {
        return this.resultEquivalence.equivalent(this.function.apply(f16), this.function.apply(f17));
    }

    @Override // com.google.common.base.Equivalence
    protected int doHash(F f16) {
        return this.resultEquivalence.hash(this.function.apply(f16));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence functionalEquivalence = (FunctionalEquivalence) obj;
        if (this.function.equals(functionalEquivalence.function) && this.resultEquivalence.equals(functionalEquivalence.resultEquivalence)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return g.b(this.function, this.resultEquivalence);
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}

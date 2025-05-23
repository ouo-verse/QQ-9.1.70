package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class e<T> extends ai<T> {

    /* renamed from: d, reason: collision with root package name */
    @NullableDecl
    private T f35024d;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(@NullableDecl T t16) {
        this.f35024d = t16;
    }

    @NullableDecl
    protected abstract T a(T t16);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f35024d != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            try {
                T t16 = this.f35024d;
                this.f35024d = a(t16);
                return t16;
            } catch (Throwable th5) {
                this.f35024d = a(this.f35024d);
                throw th5;
            }
        }
        throw new NoSuchElementException();
    }
}

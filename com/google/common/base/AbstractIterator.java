package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class AbstractIterator<T> implements Iterator<T> {

    /* renamed from: d, reason: collision with root package name */
    private State f34668d = State.NOT_READY;

    /* renamed from: e, reason: collision with root package name */
    @NullableDecl
    private T f34669e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public enum State {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34670a;

        static {
            int[] iArr = new int[State.values().length];
            f34670a = iArr;
            try {
                iArr[State.READY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34670a[State.DONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private boolean c() {
        this.f34668d = State.FAILED;
        this.f34669e = a();
        if (this.f34668d != State.DONE) {
            this.f34668d = State.READY;
            return true;
        }
        return false;
    }

    protected abstract T a();

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    @NullableDecl
    public final T b() {
        this.f34668d = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        boolean z16;
        if (this.f34668d != State.FAILED) {
            z16 = true;
        } else {
            z16 = false;
        }
        j.s(z16);
        int i3 = a.f34670a[this.f34668d.ordinal()];
        if (i3 == 1) {
            return true;
        }
        if (i3 == 2) {
            return false;
        }
        return c();
    }

    @Override // java.util.Iterator
    public final T next() {
        if (hasNext()) {
            this.f34668d = State.NOT_READY;
            T t16 = this.f34669e;
            this.f34669e = null;
            return t16;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}

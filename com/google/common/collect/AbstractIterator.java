package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class AbstractIterator<T> extends ai<T> {

    @NullableDecl
    private T next;
    private State state = State.NOT_READY;

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
        static final /* synthetic */ int[] f34830a;

        static {
            int[] iArr = new int[State.values().length];
            f34830a = iArr;
            try {
                iArr[State.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34830a[State.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private boolean tryToComputeNext() {
        this.state = State.FAILED;
        this.next = computeNext();
        if (this.state != State.DONE) {
            this.state = State.READY;
            return true;
        }
        return false;
    }

    protected abstract T computeNext();

    /* JADX INFO: Access modifiers changed from: protected */
    @CanIgnoreReturnValue
    public final T endOfData() {
        this.state = State.DONE;
        return null;
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final boolean hasNext() {
        boolean z16;
        if (this.state != State.FAILED) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.s(z16);
        int i3 = a.f34830a[this.state.ordinal()];
        if (i3 == 1) {
            return false;
        }
        if (i3 == 2) {
            return true;
        }
        return tryToComputeNext();
    }

    @Override // java.util.Iterator
    @CanIgnoreReturnValue
    public final T next() {
        if (hasNext()) {
            this.state = State.NOT_READY;
            T t16 = this.next;
            this.next = null;
            return t16;
        }
        throw new NoSuchElementException();
    }

    public final T peek() {
        if (hasNext()) {
            return this.next;
        }
        throw new NoSuchElementException();
    }
}

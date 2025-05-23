package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004\u00a8\u0006\u000e"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class FlatteningSequence$iterator$1<E> implements Iterator<E>, KMappedMarker {

    @Nullable
    private Iterator<? extends E> itemIterator;

    @NotNull
    private final Iterator<T> iterator;
    final /* synthetic */ FlatteningSequence<T, R, E> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlatteningSequence$iterator$1(FlatteningSequence<T, R, E> flatteningSequence) {
        Sequence sequence;
        this.this$0 = flatteningSequence;
        sequence = ((FlatteningSequence) flatteningSequence).sequence;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean ensureItemIterator() {
        boolean z16;
        Function1 function1;
        Function1 function12;
        Iterator<? extends E> it = this.itemIterator;
        if (it != null && !it.hasNext()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.itemIterator = null;
        }
        while (true) {
            if (this.itemIterator != null) {
                break;
            }
            if (!this.iterator.hasNext()) {
                return false;
            }
            Object next = this.iterator.next();
            function1 = ((FlatteningSequence) this.this$0).iterator;
            function12 = ((FlatteningSequence) this.this$0).transformer;
            Iterator<? extends E> it5 = (Iterator) function1.invoke(function12.invoke(next));
            if (it5.hasNext()) {
                this.itemIterator = it5;
                break;
            }
        }
    }

    @Nullable
    public final Iterator<E> getItemIterator() {
        return this.itemIterator;
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return ensureItemIterator();
    }

    @Override // java.util.Iterator
    public E next() {
        if (ensureItemIterator()) {
            Iterator<? extends E> it = this.itemIterator;
            Intrinsics.checkNotNull(it);
            return it.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setItemIterator(@Nullable Iterator<? extends E> it) {
        this.itemIterator = it;
    }
}

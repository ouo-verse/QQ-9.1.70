package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"kotlin/sequences/SubSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "position", "", "getPosition", "()I", "setPosition", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class SubSequence$iterator$1<T> implements Iterator<T>, KMappedMarker {

    @NotNull
    private final Iterator<T> iterator;
    private int position;
    final /* synthetic */ SubSequence<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubSequence$iterator$1(SubSequence<T> subSequence) {
        Sequence sequence;
        this.this$0 = subSequence;
        sequence = ((SubSequence) subSequence).sequence;
        this.iterator = sequence.iterator();
    }

    /* JADX WARN: Incorrect condition in loop: B:2:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void drop() {
        int i3;
        while (r0 < i3 && this.iterator.hasNext()) {
            this.iterator.next();
            this.position++;
        }
    }

    @NotNull
    public final Iterator<T> getIterator() {
        return this.iterator;
    }

    public final int getPosition() {
        return this.position;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        int i3;
        drop();
        int i16 = this.position;
        i3 = ((SubSequence) this.this$0).endIndex;
        if (i16 < i3 && this.iterator.hasNext()) {
            return true;
        }
        return false;
    }

    @Override // java.util.Iterator
    public T next() {
        int i3;
        drop();
        int i16 = this.position;
        i3 = ((SubSequence) this.this$0).endIndex;
        if (i16 < i3) {
            this.position++;
            return this.iterator.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void setPosition(int i3) {
        this.position = i3;
    }
}

package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
/* loaded from: classes28.dex */
public final class OneElementArrayMap$iterator$1<T> implements Iterator<T>, KMappedMarker {
    private boolean notVisited = true;
    final /* synthetic */ OneElementArrayMap<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OneElementArrayMap$iterator$1(OneElementArrayMap<T> oneElementArrayMap) {
        this.this$0 = oneElementArrayMap;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.notVisited;
    }

    @Override // java.util.Iterator
    @NotNull
    public T next() {
        if (this.notVisited) {
            this.notVisited = false;
            return this.this$0.getValue();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}

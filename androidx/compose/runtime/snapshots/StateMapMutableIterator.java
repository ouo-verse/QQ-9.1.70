package androidx.compose.runtime.snapshots;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\"\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B3\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u001c\u001a\u00020\u001dH\u0004J\u0006\u0010\u001e\u001a\u00020\u001fJ%\u0010 \u001a\u0002H!\"\u0004\b\u0002\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0084\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\u001dR(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R(\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bX\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006&"}, d2 = {"Landroidx/compose/runtime/snapshots/StateMapMutableIterator;", "K", "V", "", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "iterator", "", "", "(Landroidx/compose/runtime/snapshots/SnapshotStateMap;Ljava/util/Iterator;)V", "current", "getCurrent", "()Ljava/util/Map$Entry;", "setCurrent", "(Ljava/util/Map$Entry;)V", "getIterator", "()Ljava/util/Iterator;", "getMap", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "modification", "", "getModification", "()I", "setModification", "(I)V", "next", "getNext", "setNext", "advance", "", "hasNext", "", "modify", "T", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "remove", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
abstract class StateMapMutableIterator<K, V> {
    private Map.Entry<? extends K, ? extends V> current;
    private final Iterator<Map.Entry<K, V>> iterator;
    private final SnapshotStateMap<K, V> map;
    private int modification;
    private Map.Entry<? extends K, ? extends V> next;

    /* JADX WARN: Multi-variable type inference failed */
    public StateMapMutableIterator(SnapshotStateMap<K, V> map, Iterator<? extends Map.Entry<? extends K, ? extends V>> iterator) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        this.map = map;
        this.iterator = iterator;
        this.modification = map.getModification$runtime_release();
        advance();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void advance() {
        this.current = this.next;
        this.next = this.iterator.hasNext() ? this.iterator.next() : null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map.Entry<K, V> getCurrent() {
        return this.current;
    }

    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    public final SnapshotStateMap<K, V> getMap() {
        return this.map;
    }

    protected final int getModification() {
        return this.modification;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Map.Entry<K, V> getNext() {
        return this.next;
    }

    public final boolean hasNext() {
        return this.next != null;
    }

    protected final <T> T modify(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (getMap().getModification$runtime_release() == this.modification) {
            T invoke = block.invoke();
            this.modification = getMap().getModification$runtime_release();
            return invoke;
        }
        throw new ConcurrentModificationException();
    }

    public final void remove() {
        if (getMap().getModification$runtime_release() == this.modification) {
            Map.Entry<? extends K, ? extends V> entry = this.current;
            if (entry != null) {
                this.map.remove(entry.getKey());
                this.current = null;
                Unit unit = Unit.INSTANCE;
                this.modification = getMap().getModification$runtime_release();
                return;
            }
            throw new IllegalStateException();
        }
        throw new ConcurrentModificationException();
    }

    protected final void setCurrent(Map.Entry<? extends K, ? extends V> entry) {
        this.current = entry;
    }

    protected final void setModification(int i3) {
        this.modification = i3;
    }

    protected final void setNext(Map.Entry<? extends K, ? extends V> entry) {
        this.next = entry;
    }
}

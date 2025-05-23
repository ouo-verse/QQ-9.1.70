package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a2\u0006\u0002\u0010\u0005J\r\u0010\u0015\u001a\u00028\u0000H\u0004\u00a2\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0010H\u0002J\u000e\u0010\u001b\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010\u0016R\u0018\u0010\u0006\u001a\u00020\u00078\u0002@\u0002X\u0083\u000e\u00a2\u0006\b\n\u0000\u0012\u0004\b\b\u0010\tR \u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bX\u0084\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001c"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetIterator;", "E", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;)V", "hasNext", "", "getHasNext$annotations", "()V", "path", "", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNodeIterator;", "getPath", "()Ljava/util/List;", "pathLastIndex", "", "getPathLastIndex", "()I", "setPathLastIndex", "(I)V", "currentElement", "()Ljava/lang/Object;", "ensureNextElementIsReady", "", "moveToNextNodeWithData", "pathIndex", "next", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public class PersistentHashSetIterator<E> implements Iterator<E>, KMappedMarker {
    private boolean hasNext;
    private final List<TrieNodeIterator<E>> path;
    private int pathLastIndex;

    public PersistentHashSetIterator(TrieNode<E> node) {
        List<TrieNodeIterator<E>> mutableListOf;
        Intrinsics.checkNotNullParameter(node, "node");
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new TrieNodeIterator());
        this.path = mutableListOf;
        this.hasNext = true;
        TrieNodeIterator.reset$default(mutableListOf.get(0), node.getBuffer(), 0, 2, null);
        this.pathLastIndex = 0;
        ensureNextElementIsReady();
    }

    private final void ensureNextElementIsReady() {
        if (this.path.get(this.pathLastIndex).hasNextElement()) {
            return;
        }
        for (int i3 = this.pathLastIndex; -1 < i3; i3--) {
            int moveToNextNodeWithData = moveToNextNodeWithData(i3);
            if (moveToNextNodeWithData == -1 && this.path.get(i3).hasNextCell()) {
                this.path.get(i3).moveToNextCell();
                moveToNextNodeWithData = moveToNextNodeWithData(i3);
            }
            if (moveToNextNodeWithData != -1) {
                this.pathLastIndex = moveToNextNodeWithData;
                return;
            }
            if (i3 > 0) {
                this.path.get(i3 - 1).moveToNextCell();
            }
            this.path.get(i3).reset(TrieNode.INSTANCE.getEMPTY$runtime_release().getBuffer(), 0);
        }
        this.hasNext = false;
    }

    private final int moveToNextNodeWithData(int pathIndex) {
        if (this.path.get(pathIndex).hasNextElement()) {
            return pathIndex;
        }
        if (!this.path.get(pathIndex).hasNextNode()) {
            return -1;
        }
        TrieNode<? extends E> currentNode = this.path.get(pathIndex).currentNode();
        int i3 = pathIndex + 1;
        if (i3 == this.path.size()) {
            this.path.add(new TrieNodeIterator<>());
        }
        TrieNodeIterator.reset$default(this.path.get(i3), currentNode.getBuffer(), 0, 2, null);
        return moveToNextNodeWithData(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final E currentElement() {
        CommonFunctionsKt.m32assert(hasNext());
        return this.path.get(this.pathLastIndex).currentElement();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<TrieNodeIterator<E>> getPath() {
        return this.path;
    }

    protected final int getPathLastIndex() {
        return this.pathLastIndex;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public E next() {
        if (this.hasNext) {
            E nextElement = this.path.get(this.pathLastIndex).nextElement();
            ensureNextElementIsReady();
            return nextElement;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setPathLastIndex(int i3) {
        this.pathLastIndex = i3;
    }

    private static /* synthetic */ void getHasNext$annotations() {
    }
}

package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0000\u0018\u0000 _*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001_B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u00a2\u0006\u0002\u0010\u0007B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0002\u0010\nJ)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u001cJ#\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\u001fJ\b\u0010 \u001a\u00020\u0004H\u0002J\u001b\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010%J\u001b\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u0000H\u0002\u00a2\u0006\u0002\u0010\"J\u0016\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u0004H\u0002J#\u0010)\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010*J\u001c\u0010+\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u0015\u0010-\u001a\u00028\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010/J\u0016\u00100\u001a\u00020$2\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002J\u0010\u00101\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0015\u00102\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0000\u00a2\u0006\u0002\b3JE\u00104\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00028\u00002\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0002\u0010:J=\u0010;\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\b\u00109\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0002\u0010?J3\u0010@\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004H\u0002\u00a2\u0006\u0002\u0010AJ5\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D\u00a2\u0006\u0002\u0010EJ6\u0010F\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ+\u0010I\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u00109\u001a\u00020\tH\u0002\u00a2\u0006\u0002\u0010JJ'\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002\u00a2\u0006\u0002\u0010LJ,\u0010M\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J'\u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001a\u001a\u00028\u00002\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DH\u0002\u00a2\u0006\u0002\u0010LJ(\u0010O\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J\u001e\u0010P\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010(\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J(\u0010Q\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010G\u001a\u00020H2\u0006\u00109\u001a\u00020\tH\u0002J;\u0010R\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00042\u0006\u0010>\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002\u00a2\u0006\u0002\u0010?J5\u0010S\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u00042\n\u0010C\u001a\u0006\u0012\u0002\b\u00030D\u00a2\u0006\u0002\u0010EJ2\u0010T\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ&\u0010U\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\tH\u0002J2\u0010W\u001a\u0004\u0018\u00010\u00022\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030DJ,\u0010X\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u00109\u001a\u00020\tH\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010.\u001a\u00020\u0004H\u0002J)\u0010\\\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u001cJ\u001e\u0010]\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010V\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J$\u0010^\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010Y\u001a\u00020\u00042\f\u0010Z\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006`"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "E", "", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "buffer", "", "(I[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(I[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "getBitmap", "()I", "setBitmap", "(I)V", "getBuffer", "()[Ljava/lang/Object;", "setBuffer", "([Ljava/lang/Object;)V", "[Ljava/lang/Object;", "getOwnedBy", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnedBy", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "add", "elementHash", DTConstants.TAG.ELEMENT, "shift", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "addElementAt", "positionMask", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "calculateSize", "collisionAdd", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "collisionContainsElement", "", "(Ljava/lang/Object;)Z", "collisionRemove", "collisionRemoveElementAtIndex", "i", "contains", "(ILjava/lang/Object;I)Z", "containsAll", "otherNode", "elementAtIndex", "index", "(I)Ljava/lang/Object;", "elementsIdentityEquals", "hasNoCellAt", "indexOfCellAt", "indexOfCellAt$runtime_release", "makeNode", "elementHash1", "element1", "elementHash2", "element2", "owner", "(ILjava/lang/Object;ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "makeNodeAtIndex", "elementIndex", "newElementHash", "newElement", "(IILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "moveElementToNode", "(IILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAdd", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableAddAll", "intersectionSizeRef", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableAddElementAt", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAdd", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/PersistentHashSetBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "mutableCollisionAddAll", "mutableCollisionRemove", "mutableCollisionRemoveAll", "mutableCollisionRemoveElementAtIndex", "mutableCollisionRetainAll", "mutableMoveElementToNode", "mutableRemove", "mutableRemoveAll", "mutableRemoveCellAtIndex", "cellIndex", "mutableRetainAll", "mutableUpdateNodeAtIndex", "nodeIndex", "newNode", "nodeAtIndex", "remove", "removeCellAtIndex", "updateNodeAtIndex", "Companion", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class TrieNode<E> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TrieNode EMPTY = new TrieNode(0, new Object[0]);
    private int bitmap;
    private Object[] buffer;
    private MutabilityOwnership ownedBy;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode$Companion;", "", "()V", PatternUtils.NO_MATCH, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableSet/TrieNode;", "runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }

        private Companion() {
        }
    }

    public TrieNode(int i3, Object[] buffer, MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.bitmap = i3;
        this.buffer = buffer;
        this.ownedBy = mutabilityOwnership;
    }

    private final TrieNode<E> addElementAt(int positionMask, E element) {
        Object[] addElementAtIndex;
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release(positionMask), element);
        return new TrieNode<>(positionMask | this.bitmap, addElementAtIndex);
    }

    private final int calculateSize() {
        if (this.bitmap == 0) {
            return this.buffer.length;
        }
        int i3 = 0;
        for (Object obj : this.buffer) {
            i3 += obj instanceof TrieNode ? ((TrieNode) obj).calculateSize() : 1;
        }
        return i3;
    }

    private final TrieNode<E> collisionAdd(E element) {
        Object[] addElementAtIndex;
        if (collisionContainsElement(element)) {
            return this;
        }
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, 0, element);
        return new TrieNode<>(0, addElementAtIndex);
    }

    private final boolean collisionContainsElement(E element) {
        boolean contains;
        contains = ArraysKt___ArraysKt.contains((E[]) this.buffer, element);
        return contains;
    }

    private final TrieNode<E> collisionRemove(E element) {
        int indexOf;
        indexOf = ArraysKt___ArraysKt.indexOf((E[]) this.buffer, element);
        return indexOf != -1 ? collisionRemoveElementAtIndex(indexOf) : this;
    }

    private final TrieNode<E> collisionRemoveElementAtIndex(int i3) {
        Object[] removeCellAtIndex;
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i3);
        return new TrieNode<>(0, removeCellAtIndex);
    }

    private final E elementAtIndex(int index) {
        return (E) this.buffer[index];
    }

    private final boolean hasNoCellAt(int positionMask) {
        return (positionMask & this.bitmap) == 0;
    }

    private final TrieNode<E> makeNodeAtIndex(int elementIndex, int newElementHash, E newElement, int shift, MutabilityOwnership owner) {
        E elementAtIndex = elementAtIndex(elementIndex);
        return makeNode(elementAtIndex != null ? elementAtIndex.hashCode() : 0, elementAtIndex, newElementHash, newElement, shift + 5, owner);
    }

    private final TrieNode<E> moveElementToNode(int elementIndex, int newElementHash, E newElement, int shift) {
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[elementIndex] = makeNodeAtIndex(elementIndex, newElementHash, newElement, shift, null);
        return new TrieNode<>(this.bitmap, copyOf);
    }

    private final TrieNode<E> mutableAddElementAt(int positionMask, E element, MutabilityOwnership owner) {
        Object[] addElementAtIndex;
        Object[] addElementAtIndex2;
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(positionMask);
        if (this.ownedBy == owner) {
            addElementAtIndex2 = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, element);
            this.buffer = addElementAtIndex2;
            this.bitmap = positionMask | this.bitmap;
            return this;
        }
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, indexOfCellAt$runtime_release, element);
        return new TrieNode<>(positionMask | this.bitmap, addElementAtIndex, owner);
    }

    private final TrieNode<E> mutableCollisionAdd(E element, PersistentHashSetBuilder<?> mutator) {
        Object[] addElementAtIndex;
        Object[] addElementAtIndex2;
        if (collisionContainsElement(element)) {
            return this;
        }
        mutator.setSize(mutator.size() + 1);
        if (this.ownedBy == mutator.getOwnership()) {
            addElementAtIndex2 = TrieNodeKt.addElementAtIndex(this.buffer, 0, element);
            this.buffer = addElementAtIndex2;
            return this;
        }
        addElementAtIndex = TrieNodeKt.addElementAtIndex(this.buffer, 0, element);
        return new TrieNode<>(0, addElementAtIndex, mutator.getOwnership());
    }

    private final TrieNode<E> mutableCollisionRemove(E element, PersistentHashSetBuilder<?> mutator) {
        int indexOf;
        indexOf = ArraysKt___ArraysKt.indexOf((E[]) this.buffer, element);
        if (indexOf == -1) {
            return this;
        }
        mutator.setSize(mutator.size() - 1);
        return mutableCollisionRemoveElementAtIndex(indexOf, mutator.getOwnership());
    }

    private final TrieNode<E> mutableCollisionRemoveElementAtIndex(int i3, MutabilityOwnership owner) {
        Object[] removeCellAtIndex;
        Object[] removeCellAtIndex2;
        if (this.ownedBy == owner) {
            removeCellAtIndex2 = TrieNodeKt.removeCellAtIndex(this.buffer, i3);
            this.buffer = removeCellAtIndex2;
            return this;
        }
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, i3);
        return new TrieNode<>(0, removeCellAtIndex, owner);
    }

    private final TrieNode<E> mutableMoveElementToNode(int elementIndex, int newElementHash, E newElement, int shift, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            this.buffer[elementIndex] = makeNodeAtIndex(elementIndex, newElementHash, newElement, shift, owner);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[elementIndex] = makeNodeAtIndex(elementIndex, newElementHash, newElement, shift, owner);
        return new TrieNode<>(this.bitmap, copyOf, owner);
    }

    private final TrieNode<E> mutableRemoveCellAtIndex(int cellIndex, int positionMask, MutabilityOwnership owner) {
        Object[] removeCellAtIndex;
        Object[] removeCellAtIndex2;
        if (this.ownedBy == owner) {
            removeCellAtIndex2 = TrieNodeKt.removeCellAtIndex(this.buffer, cellIndex);
            this.buffer = removeCellAtIndex2;
            this.bitmap ^= positionMask;
            return this;
        }
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, cellIndex);
        return new TrieNode<>(positionMask ^ this.bitmap, removeCellAtIndex, owner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v4 */
    private final TrieNode<E> mutableUpdateNodeAtIndex(int nodeIndex, TrieNode<E> newNode, MutabilityOwnership owner) {
        ?? r06 = newNode.buffer;
        if (r06.length == 1) {
            ?? r07 = r06[0];
            if (!(r07 instanceof TrieNode)) {
                if (this.buffer.length == 1) {
                    newNode.bitmap = this.bitmap;
                    return newNode;
                }
                newNode = r07;
            }
        }
        if (this.ownedBy == owner) {
            this.buffer[nodeIndex] = newNode;
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[nodeIndex] = newNode;
        return new TrieNode<>(this.bitmap, copyOf, owner);
    }

    private final TrieNode<E> nodeAtIndex(int index) {
        Object obj = this.buffer[index];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
    }

    private final TrieNode<E> removeCellAtIndex(int cellIndex, int positionMask) {
        Object[] removeCellAtIndex;
        removeCellAtIndex = TrieNodeKt.removeCellAtIndex(this.buffer, cellIndex);
        return new TrieNode<>(positionMask ^ this.bitmap, removeCellAtIndex);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r0v3 */
    private final TrieNode<E> updateNodeAtIndex(int nodeIndex, TrieNode<E> newNode) {
        ?? r06 = newNode.buffer;
        if (r06.length == 1) {
            ?? r07 = r06[0];
            if (!(r07 instanceof TrieNode)) {
                if (this.buffer.length == 1) {
                    newNode.bitmap = this.bitmap;
                    return newNode;
                }
                newNode = r07;
            }
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[nodeIndex] = newNode;
        return new TrieNode<>(this.bitmap, copyOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean containsAll(TrieNode<E> otherNode, int shift) {
        boolean contains;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        if (this == otherNode) {
            return true;
        }
        if (shift > 30) {
            for (Object obj : otherNode.buffer) {
                contains = ArraysKt___ArraysKt.contains(this.buffer, obj);
                if (!contains) {
                    return false;
                }
            }
            return true;
        }
        int i3 = this.bitmap;
        int i16 = otherNode.bitmap;
        int i17 = i3 & i16;
        if (i17 != i16) {
            return false;
        }
        while (i17 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i17);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = otherNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj2 = this.buffer[indexOfCellAt$runtime_release];
            Object obj3 = otherNode.buffer[indexOfCellAt$runtime_release2];
            boolean z16 = obj2 instanceof TrieNode;
            boolean z17 = obj3 instanceof TrieNode;
            if (z16 && z17) {
                if (obj2 != null) {
                    TrieNode trieNode = (TrieNode) obj2;
                    if (obj3 != null) {
                        if (!trieNode.containsAll((TrieNode) obj3, shift + 5)) {
                            return false;
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
                }
            } else if (!z16) {
                if (z17 || !Intrinsics.areEqual(obj2, obj3)) {
                    return false;
                }
            } else if (obj2 != null) {
                if (!((TrieNode) obj2).contains(obj3 != null ? obj3.hashCode() : 0, obj3, shift + 5)) {
                    return false;
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.containsAll$lambda-13>");
            }
            i17 ^= lowestOneBit;
        }
        return true;
    }

    public final int getBitmap() {
        return this.bitmap;
    }

    public final Object[] getBuffer() {
        return this.buffer;
    }

    public final MutabilityOwnership getOwnedBy() {
        return this.ownedBy;
    }

    public final int indexOfCellAt$runtime_release(int positionMask) {
        return Integer.bitCount((positionMask - 1) & this.bitmap);
    }

    public final TrieNode<E> mutableAdd(int elementHash, E element, int shift, PersistentHashSetBuilder<?> mutator) {
        TrieNode<E> mutableAdd;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(indexSegment)) {
            mutator.setSize(mutator.size() + 1);
            return mutableAddElementAt(indexSegment, element, mutator.getOwnership());
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                mutableAdd = nodeAtIndex.mutableCollisionAdd(element, mutator);
            } else {
                mutableAdd = nodeAtIndex.mutableAdd(elementHash, element, shift + 5, mutator);
            }
            return nodeAtIndex == mutableAdd ? this : mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, mutableAdd, mutator.getOwnership());
        }
        if (Intrinsics.areEqual(element, obj)) {
            return this;
        }
        mutator.setSize(mutator.size() + 1);
        return mutableMoveElementToNode(indexOfCellAt$runtime_release, elementHash, element, shift, mutator.getOwnership());
    }

    public final TrieNode<E> mutableRemove(int elementHash, E element, int shift, PersistentHashSetBuilder<?> mutator) {
        TrieNode<E> mutableRemove;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                mutableRemove = nodeAtIndex.mutableCollisionRemove(element, mutator);
            } else {
                mutableRemove = nodeAtIndex.mutableRemove(elementHash, element, shift + 5, mutator);
            }
            return (this.ownedBy == mutator.getOwnership() || nodeAtIndex != mutableRemove) ? mutableUpdateNodeAtIndex(indexOfCellAt$runtime_release, mutableRemove, mutator.getOwnership()) : this;
        }
        if (!Intrinsics.areEqual(element, obj)) {
            return this;
        }
        mutator.setSize(mutator.size() - 1);
        return mutableRemoveCellAtIndex(indexOfCellAt$runtime_release, indexSegment, mutator.getOwnership());
    }

    public final void setBitmap(int i3) {
        this.bitmap = i3;
    }

    public final void setBuffer(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.buffer = objArr;
    }

    public final void setOwnedBy(MutabilityOwnership mutabilityOwnership) {
        this.ownedBy = mutabilityOwnership;
    }

    public final TrieNode<E> add(int elementHash, E element, int shift) {
        TrieNode<E> add;
        int indexSegment = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(indexSegment)) {
            return addElementAt(indexSegment, element);
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return Intrinsics.areEqual(element, obj) ? this : moveElementToNode(indexOfCellAt$runtime_release, elementHash, element, shift);
        }
        TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (shift == 30) {
            add = nodeAtIndex.collisionAdd(element);
        } else {
            add = nodeAtIndex.add(elementHash, element, shift + 5);
        }
        return nodeAtIndex == add ? this : updateNodeAtIndex(indexOfCellAt$runtime_release, add);
    }

    public final boolean contains(int elementHash, E element, int shift) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(indexSegment)) {
            return false;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (obj instanceof TrieNode) {
            TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
            if (shift == 30) {
                return nodeAtIndex.collisionContainsElement(element);
            }
            return nodeAtIndex.contains(elementHash, element, shift + 5);
        }
        return Intrinsics.areEqual(element, obj);
    }

    public final TrieNode<E> remove(int elementHash, E element, int shift) {
        TrieNode<E> remove;
        int indexSegment = 1 << TrieNodeKt.indexSegment(elementHash, shift);
        if (hasNoCellAt(indexSegment)) {
            return this;
        }
        int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(indexSegment);
        Object obj = this.buffer[indexOfCellAt$runtime_release];
        if (!(obj instanceof TrieNode)) {
            return Intrinsics.areEqual(element, obj) ? removeCellAtIndex(indexOfCellAt$runtime_release, indexSegment) : this;
        }
        TrieNode<E> nodeAtIndex = nodeAtIndex(indexOfCellAt$runtime_release);
        if (shift == 30) {
            remove = nodeAtIndex.collisionRemove(element);
        } else {
            remove = nodeAtIndex.remove(elementHash, element, shift + 5);
        }
        return nodeAtIndex == remove ? this : updateNodeAtIndex(indexOfCellAt$runtime_release, remove);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<E> mutableCollisionAddAll(TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(this.buffer.length);
            return this;
        }
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + otherNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        Object[] objArr2 = otherNode.buffer;
        int length = this.buffer.length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < objArr2.length) {
            CommonFunctionsKt.m32assert(i16 <= i3);
            if (!collisionContainsElement(objArr2[i3])) {
                copyOf[length + i16] = objArr2[i3];
                i16++;
                CommonFunctionsKt.m32assert(length + i16 <= copyOf.length);
            }
            i3++;
        }
        int length2 = i16 + this.buffer.length;
        intersectionSizeRef.plusAssign(copyOf.length - length2);
        if (length2 == this.buffer.length) {
            return this;
        }
        if (length2 == otherNode.buffer.length) {
            return otherNode;
        }
        if (length2 != copyOf.length) {
            copyOf = Arrays.copyOf(copyOf, length2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        }
        if (Intrinsics.areEqual(this.ownedBy, owner)) {
            this.buffer = copyOf;
            return this;
        }
        return new TrieNode<>(0, copyOf, owner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRemoveAll(TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        Object[] objArr;
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(this.buffer.length);
            return EMPTY;
        }
        if (Intrinsics.areEqual(owner, this.ownedBy)) {
            objArr = this.buffer;
        } else {
            objArr = new Object[this.buffer.length];
        }
        Object[] objArr2 = this.buffer;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m32assert(i16 <= i3);
            if (!otherNode.collisionContainsElement(objArr2[i3])) {
                objArr[0 + i16] = objArr2[i3];
                i16++;
                CommonFunctionsKt.m32assert(0 + i16 <= objArr.length);
            }
            i3++;
        }
        intersectionSizeRef.plusAssign(this.buffer.length - i16);
        if (i16 == 0) {
            return EMPTY;
        }
        if (i16 == 1) {
            return objArr[0];
        }
        if (i16 == this.buffer.length) {
            return this;
        }
        if (i16 == objArr.length) {
            return new TrieNode(0, objArr, owner);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i16);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, owner);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object mutableCollisionRetainAll(TrieNode<E> otherNode, DeltaCounter intersectionSizeRef, MutabilityOwnership owner) {
        Object[] objArr;
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(this.buffer.length);
            return this;
        }
        if (Intrinsics.areEqual(owner, this.ownedBy)) {
            objArr = this.buffer;
        } else {
            objArr = new Object[Math.min(this.buffer.length, otherNode.buffer.length)];
        }
        Object[] objArr2 = this.buffer;
        int i3 = 0;
        int i16 = 0;
        while (true) {
            if (i3 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.m32assert(i16 <= i3);
            if (otherNode.collisionContainsElement(objArr2[i3])) {
                objArr[0 + i16] = objArr2[i3];
                i16++;
                CommonFunctionsKt.m32assert(0 + i16 <= objArr.length);
            }
            i3++;
        }
        intersectionSizeRef.plusAssign(i16);
        if (i16 == 0) {
            return EMPTY;
        }
        if (i16 == 1) {
            return objArr[0];
        }
        if (i16 == this.buffer.length) {
            return this;
        }
        if (i16 == otherNode.buffer.length) {
            return otherNode;
        }
        if (i16 == objArr.length) {
            return new TrieNode(0, objArr, owner);
        }
        Object[] copyOf = Arrays.copyOf(objArr, i16);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        return new TrieNode(0, copyOf, owner);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i3, Object[] buffer) {
        this(i3, buffer, null);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }

    private final boolean elementsIdentityEquals(TrieNode<E> otherNode) {
        if (this == otherNode) {
            return true;
        }
        if (this.bitmap != otherNode.bitmap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.buffer[i3] != otherNode.buffer[i3]) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final TrieNode<E> mutableAddAll(TrieNode<E> otherNode, int shift, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder<?> mutator) {
        Object[] objArr;
        int i3;
        Object makeNode;
        TrieNode mutableAdd;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.setCount(intersectionSizeRef.getCount() + calculateSize());
            return this;
        }
        if (shift > 30) {
            return mutableCollisionAddAll(otherNode, intersectionSizeRef, mutator.getOwnership());
        }
        int i16 = this.bitmap;
        int i17 = otherNode.bitmap | i16;
        TrieNode<E> trieNode = (i17 == i16 && Intrinsics.areEqual(this.ownedBy, mutator.getOwnership())) ? this : new TrieNode<>(i17, new Object[Integer.bitCount(i17)], mutator.getOwnership());
        int i18 = i17;
        int i19 = 0;
        while (i18 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i18);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = otherNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object[] objArr2 = trieNode.buffer;
            if (hasNoCellAt(lowestOneBit)) {
                makeNode = otherNode.buffer[indexOfCellAt$runtime_release2];
            } else if (otherNode.hasNoCellAt(lowestOneBit)) {
                makeNode = this.buffer[indexOfCellAt$runtime_release];
            } else {
                Object obj = this.buffer[indexOfCellAt$runtime_release];
                Object obj2 = otherNode.buffer[indexOfCellAt$runtime_release2];
                boolean z16 = obj instanceof TrieNode;
                boolean z17 = obj2 instanceof TrieNode;
                if (!z16 || !z17) {
                    if (z16) {
                        if (obj != null) {
                            TrieNode trieNode2 = (TrieNode) obj;
                            int size = mutator.size();
                            mutableAdd = trieNode2.mutableAdd(obj2 != null ? obj2.hashCode() : 0, obj2, shift + 5, mutator);
                            if (mutator.size() == size) {
                                intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                            }
                            Unit unit = Unit.INSTANCE;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                        }
                    } else if (z17) {
                        if (obj2 != null) {
                            TrieNode trieNode3 = (TrieNode) obj2;
                            int size2 = mutator.size();
                            mutableAdd = trieNode3.mutableAdd(obj != null ? obj.hashCode() : 0, obj, shift + 5, mutator);
                            if (mutator.size() == size2) {
                                intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                            }
                            Unit unit2 = Unit.INSTANCE;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                        }
                    } else if (Intrinsics.areEqual(obj, obj2)) {
                        intersectionSizeRef.setCount(intersectionSizeRef.getCount() + 1);
                        Unit unit3 = Unit.INSTANCE;
                        makeNode = obj;
                    } else {
                        objArr = objArr2;
                        i3 = lowestOneBit;
                        makeNode = makeNode(obj != null ? obj.hashCode() : 0, obj, obj2 != null ? obj2.hashCode() : 0, obj2, shift + 5, mutator.getOwnership());
                        objArr[i19] = makeNode;
                        i19++;
                        i18 ^= i3;
                    }
                    makeNode = mutableAdd;
                } else if (obj != null) {
                    TrieNode trieNode4 = (TrieNode) obj;
                    if (obj2 != null) {
                        makeNode = trieNode4.mutableAddAll((TrieNode) obj2, shift + 5, intersectionSizeRef, mutator);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableAddAll$lambda-6>");
                }
            }
            objArr = objArr2;
            i3 = lowestOneBit;
            objArr[i19] = makeNode;
            i19++;
            i18 ^= i3;
        }
        return elementsIdentityEquals(trieNode) ? this : otherNode.elementsIdentityEquals(trieNode) ? otherNode : trieNode;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cf, code lost:
    
        if ((r13 instanceof androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode) == false) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mutableRemoveAll(TrieNode<E> otherNode, int shift, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder<?> mutator) {
        TrieNode<E> trieNode;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(calculateSize());
            return EMPTY;
        }
        if (shift > 30) {
            return mutableCollisionRemoveAll(otherNode, intersectionSizeRef, mutator.getOwnership());
        }
        int i3 = this.bitmap & otherNode.bitmap;
        if (i3 == 0) {
            return this;
        }
        if (Intrinsics.areEqual(this.ownedBy, mutator.getOwnership())) {
            trieNode = this;
        } else {
            int i16 = this.bitmap;
            Object[] objArr = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            trieNode = new TrieNode<>(i16, copyOf, mutator.getOwnership());
        }
        int i17 = this.bitmap;
        while (i3 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i3);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = otherNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj = this.buffer[indexOfCellAt$runtime_release];
            Object obj2 = otherNode.buffer[indexOfCellAt$runtime_release2];
            boolean z16 = obj instanceof TrieNode;
            boolean z17 = obj2 instanceof TrieNode;
            if (z16 && z17) {
                if (obj != null) {
                    TrieNode trieNode2 = (TrieNode) obj;
                    if (obj2 != null) {
                        obj = trieNode2.mutableRemoveAll((TrieNode) obj2, shift + 5, intersectionSizeRef, mutator);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                }
            } else if (z16) {
                if (obj != null) {
                    TrieNode trieNode3 = (TrieNode) obj;
                    int size = mutator.size();
                    TrieNode mutableRemove = trieNode3.mutableRemove(obj2 != null ? obj2.hashCode() : 0, obj2, shift + 5, mutator);
                    if (size != mutator.size()) {
                        intersectionSizeRef.plusAssign(1);
                        Object[] objArr2 = mutableRemove.buffer;
                        if (objArr2.length == 1) {
                            obj = objArr2[0];
                        }
                        obj = mutableRemove;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                }
            } else if (z17) {
                if (obj2 != null) {
                    if (((TrieNode) obj2).contains(obj != null ? obj.hashCode() : 0, obj, shift + 5)) {
                        intersectionSizeRef.plusAssign(1);
                        obj = EMPTY;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRemoveAll$lambda-11$lambda-10>");
                }
            } else if (Intrinsics.areEqual(obj, obj2)) {
                intersectionSizeRef.plusAssign(1);
                obj = EMPTY;
            }
            if (obj == EMPTY) {
                i17 ^= lowestOneBit;
            }
            trieNode.buffer[indexOfCellAt$runtime_release] = obj;
            i3 ^= lowestOneBit;
        }
        int bitCount = Integer.bitCount(i17);
        if (i17 == 0) {
            return EMPTY;
        }
        if (i17 == this.bitmap) {
            return trieNode.elementsIdentityEquals(this) ? this : trieNode;
        }
        if (bitCount == 1 && shift != 0) {
            Object obj3 = trieNode.buffer[trieNode.indexOfCellAt$runtime_release(i17)];
            return obj3 instanceof TrieNode ? new TrieNode(i17, new Object[]{obj3}, mutator.getOwnership()) : obj3;
        }
        Object[] objArr3 = new Object[bitCount];
        Object[] objArr4 = trieNode.buffer;
        int i18 = 0;
        int i19 = 0;
        while (i18 < objArr4.length) {
            CommonFunctionsKt.m32assert(i19 <= i18);
            if (objArr4[i18] != INSTANCE.getEMPTY$runtime_release()) {
                objArr3[0 + i19] = objArr4[i18];
                i19++;
                CommonFunctionsKt.m32assert(0 + i19 <= bitCount);
            }
            i18++;
        }
        return new TrieNode(i17, objArr3, mutator.getOwnership());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object mutableRetainAll(TrieNode<E> otherNode, int shift, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder<?> mutator) {
        TrieNode trieNode;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.plusAssign(calculateSize());
            return this;
        }
        if (shift > 30) {
            return mutableCollisionRetainAll(otherNode, intersectionSizeRef, mutator.getOwnership());
        }
        int i3 = this.bitmap & otherNode.bitmap;
        if (i3 == 0) {
            return EMPTY;
        }
        TrieNode<E> trieNode2 = (Intrinsics.areEqual(this.ownedBy, mutator.getOwnership()) && i3 == this.bitmap) ? this : new TrieNode<>(i3, new Object[Integer.bitCount(i3)], mutator.getOwnership());
        int i16 = i3;
        int i17 = 0;
        int i18 = 0;
        while (i16 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i16);
            int indexOfCellAt$runtime_release = indexOfCellAt$runtime_release(lowestOneBit);
            int indexOfCellAt$runtime_release2 = otherNode.indexOfCellAt$runtime_release(lowestOneBit);
            Object obj = this.buffer[indexOfCellAt$runtime_release];
            Object obj2 = otherNode.buffer[indexOfCellAt$runtime_release2];
            boolean z16 = obj instanceof TrieNode;
            boolean z17 = obj2 instanceof TrieNode;
            if (z16 && z17) {
                if (obj != null) {
                    TrieNode trieNode3 = (TrieNode) obj;
                    if (obj2 != null) {
                        obj = trieNode3.mutableRetainAll((TrieNode) obj2, shift + 5, intersectionSizeRef, mutator);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                }
            } else if (z16) {
                if (obj != null) {
                    if (((TrieNode) obj).contains(obj2 != null ? obj2.hashCode() : 0, obj2, shift + 5)) {
                        intersectionSizeRef.plusAssign(1);
                        obj = obj2;
                    } else {
                        obj = EMPTY;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                }
            } else if (z17) {
                if (obj2 != null) {
                    if (((TrieNode) obj2).contains(obj != null ? obj.hashCode() : 0, obj, shift + 5)) {
                        intersectionSizeRef.plusAssign(1);
                    } else {
                        obj = EMPTY;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.mutableRetainAll$lambda-9$lambda-8>");
                }
            } else if (Intrinsics.areEqual(obj, obj2)) {
                intersectionSizeRef.plusAssign(1);
            } else {
                obj = EMPTY;
            }
            if (obj != EMPTY) {
                i17 |= lowestOneBit;
            }
            trieNode2.buffer[i18] = obj;
            i18++;
            i16 ^= lowestOneBit;
        }
        int bitCount = Integer.bitCount(i17);
        if (i17 == 0) {
            return EMPTY;
        }
        if (i17 == i3) {
            return trieNode2.elementsIdentityEquals(this) ? this : trieNode2.elementsIdentityEquals(otherNode) ? otherNode : trieNode2;
        }
        if (bitCount == 1 && shift != 0) {
            Object obj3 = trieNode2.buffer[trieNode2.indexOfCellAt$runtime_release(i17)];
            if (!(obj3 instanceof TrieNode)) {
                return obj3;
            }
            trieNode = new TrieNode(i17, new Object[]{obj3}, mutator.getOwnership());
        } else {
            Object[] objArr = new Object[bitCount];
            Object[] objArr2 = trieNode2.buffer;
            int i19 = 0;
            int i26 = 0;
            while (i19 < objArr2.length) {
                CommonFunctionsKt.m32assert(i26 <= i19);
                if (objArr2[i19] != INSTANCE.getEMPTY$runtime_release()) {
                    objArr[0 + i26] = objArr2[i19];
                    i26++;
                    CommonFunctionsKt.m32assert(0 + i26 <= bitCount);
                }
                i19++;
            }
            trieNode = new TrieNode(i17, objArr, mutator.getOwnership());
        }
        return trieNode;
    }

    private final TrieNode<E> makeNode(int elementHash1, E element1, int elementHash2, E element2, int shift, MutabilityOwnership owner) {
        Object[] objArr;
        if (shift > 30) {
            return new TrieNode<>(0, new Object[]{element1, element2}, owner);
        }
        int indexSegment = TrieNodeKt.indexSegment(elementHash1, shift);
        int indexSegment2 = TrieNodeKt.indexSegment(elementHash2, shift);
        if (indexSegment != indexSegment2) {
            if (indexSegment < indexSegment2) {
                objArr = new Object[]{element1, element2};
            } else {
                objArr = new Object[]{element2, element1};
            }
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), objArr, owner);
        }
        return new TrieNode<>(1 << indexSegment, new Object[]{makeNode(elementHash1, element1, elementHash2, element2, shift + 5, owner)}, owner);
    }
}

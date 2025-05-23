package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001aE\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0010\u001a\u0002H\rH\u0002\u00a2\u0006\u0002\u0010\u0011\u001a)\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\u0013\u001a)\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u0001H\u0002\u00a2\u0006\u0002\u0010\u0013\u001aA\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u000e\u0010\u0017\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0018H\u0002\u00a2\u0006\u0002\u0010\u0019\u001aM\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\r*\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u0002H\f2\u0006\u0010\u0010\u001a\u0002H\rH\u0002\u00a2\u0006\u0002\u0010\u001b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"ENTRY_SIZE", "", "LOG_MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR", "MAX_BRANCHING_FACTOR_MINUS_ONE", "MAX_SHIFT", "indexSegment", "index", "shift", "insertEntryAtIndex", "", "", "K", "V", "keyIndex", "key", "value", "([Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "removeEntryAtIndex", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "removeNodeAtIndex", "nodeIndex", "replaceEntryWithNode", "newNode", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)[Ljava/lang/Object;", "replaceNodeWithEntry", "([Ljava/lang/Object;IILjava/lang/Object;Ljava/lang/Object;)[Ljava/lang/Object;", "runtime_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes39.dex */
public final class TrieNodeKt {
    public static final int ENTRY_SIZE = 2;
    public static final int LOG_MAX_BRANCHING_FACTOR = 5;
    public static final int MAX_BRANCHING_FACTOR = 32;
    public static final int MAX_BRANCHING_FACTOR_MINUS_ONE = 31;
    public static final int MAX_SHIFT = 30;

    public static final /* synthetic */ Object[] access$insertEntryAtIndex(Object[] objArr, int i3, Object obj, Object obj2) {
        return insertEntryAtIndex(objArr, i3, obj, obj2);
    }

    public static final /* synthetic */ Object[] access$removeEntryAtIndex(Object[] objArr, int i3) {
        return removeEntryAtIndex(objArr, i3);
    }

    public static final /* synthetic */ Object[] access$removeNodeAtIndex(Object[] objArr, int i3) {
        return removeNodeAtIndex(objArr, i3);
    }

    public static final /* synthetic */ Object[] access$replaceEntryWithNode(Object[] objArr, int i3, int i16, TrieNode trieNode) {
        return replaceEntryWithNode(objArr, i3, i16, trieNode);
    }

    public static final /* synthetic */ Object[] access$replaceNodeWithEntry(Object[] objArr, int i3, int i16, Object obj, Object obj2) {
        return replaceNodeWithEntry(objArr, i3, i16, obj, obj2);
    }

    public static final int indexSegment(int i3, int i16) {
        return (i3 >> i16) & 31;
    }

    public static final <K, V> Object[] insertEntryAtIndex(Object[] objArr, int i3, K k3, V v3) {
        Object[] objArr2 = new Object[objArr.length + 2];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i3 + 2, i3, objArr.length);
        objArr2[i3] = k3;
        objArr2[i3 + 1] = v3;
        return objArr2;
    }

    public static final Object[] removeEntryAtIndex(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[objArr.length - 2];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i3, i3 + 2, objArr.length);
        return objArr2;
    }

    public static final Object[] removeNodeAtIndex(Object[] objArr, int i3) {
        Object[] objArr2 = new Object[objArr.length - 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i3, i3 + 1, objArr.length);
        return objArr2;
    }

    public static final <K, V> Object[] replaceNodeWithEntry(Object[] objArr, int i3, int i16, K k3, V v3) {
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        ArraysKt___ArraysJvmKt.copyInto(copyOf, copyOf, i3 + 2, i3 + 1, objArr.length);
        ArraysKt___ArraysJvmKt.copyInto(copyOf, copyOf, i16 + 2, i16, i3);
        copyOf[i16] = k3;
        copyOf[i16 + 1] = v3;
        return copyOf;
    }

    public static final Object[] replaceEntryWithNode(Object[] objArr, int i3, int i16, TrieNode<?, ?> trieNode) {
        int i17 = i16 - 2;
        Object[] objArr2 = new Object[(objArr.length - 2) + 1];
        ArraysKt___ArraysJvmKt.copyInto$default(objArr, objArr2, 0, 0, i3, 6, (Object) null);
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i3, i3 + 2, i16);
        objArr2[i17] = trieNode;
        ArraysKt___ArraysJvmKt.copyInto(objArr, objArr2, i17 + 1, i16, objArr.length);
        return objArr2;
    }
}

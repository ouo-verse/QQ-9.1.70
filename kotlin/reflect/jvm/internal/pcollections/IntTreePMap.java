package kotlin.reflect.jvm.internal.pcollections;

/* loaded from: classes28.dex */
final class IntTreePMap<V> {
    private static final IntTreePMap<Object> EMPTY = new IntTreePMap<>(IntTree.EMPTYNODE);
    private final IntTree<V> root;

    IntTreePMap(IntTree<V> intTree) {
        this.root = intTree;
    }

    public static <V> IntTreePMap<V> empty() {
        return (IntTreePMap<V>) EMPTY;
    }

    private IntTreePMap<V> withRoot(IntTree<V> intTree) {
        if (intTree == this.root) {
            return this;
        }
        return new IntTreePMap<>(intTree);
    }

    public V get(int i3) {
        return this.root.get(i3);
    }

    public IntTreePMap<V> minus(int i3) {
        return withRoot(this.root.minus(i3));
    }

    public IntTreePMap<V> plus(int i3, V v3) {
        return withRoot(this.root.plus(i3, v3));
    }
}

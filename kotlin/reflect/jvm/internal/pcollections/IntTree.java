package kotlin.reflect.jvm.internal.pcollections;

/* compiled from: P */
/* loaded from: classes28.dex */
final class IntTree<V> {
    static final IntTree<Object> EMPTYNODE = new IntTree<>();
    private final long key;
    private final IntTree<V> left;
    private final IntTree<V> right;
    private final int size;
    private final V value;

    IntTree() {
        this.size = 0;
        this.key = 0L;
        this.value = null;
        this.left = null;
        this.right = null;
    }

    private long minKey() {
        IntTree<V> intTree = this.left;
        if (intTree.size == 0) {
            return this.key;
        }
        return intTree.minKey() + this.key;
    }

    private IntTree<V> rebalanced(IntTree<V> intTree, IntTree<V> intTree2) {
        return (intTree == this.left && intTree2 == this.right) ? this : rebalanced(this.key, this.value, intTree, intTree2);
    }

    private IntTree<V> withKey(long j3) {
        if (this.size != 0 && j3 != this.key) {
            return new IntTree<>(j3, this.value, this.left, this.right);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public V get(long j3) {
        if (this.size == 0) {
            return null;
        }
        long j16 = this.key;
        if (j3 < j16) {
            return this.left.get(j3 - j16);
        }
        if (j3 > j16) {
            return this.right.get(j3 - j16);
        }
        return this.value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntTree<V> minus(long j3) {
        if (this.size == 0) {
            return this;
        }
        long j16 = this.key;
        if (j3 < j16) {
            return rebalanced(this.left.minus(j3 - j16), this.right);
        }
        if (j3 > j16) {
            return rebalanced(this.left, this.right.minus(j3 - j16));
        }
        IntTree<V> intTree = this.left;
        if (intTree.size == 0) {
            IntTree<V> intTree2 = this.right;
            return intTree2.withKey(intTree2.key + j16);
        }
        IntTree<V> intTree3 = this.right;
        if (intTree3.size == 0) {
            return intTree.withKey(intTree.key + j16);
        }
        long minKey = intTree3.minKey();
        long j17 = this.key;
        long j18 = minKey + j17;
        V v3 = this.right.get(j18 - j17);
        IntTree<V> minus = this.right.minus(j18 - this.key);
        IntTree<V> withKey = minus.withKey((minus.key + this.key) - j18);
        IntTree<V> intTree4 = this.left;
        return rebalanced(j18, v3, intTree4.withKey((intTree4.key + this.key) - j18), withKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IntTree<V> plus(long j3, V v3) {
        if (this.size == 0) {
            return new IntTree<>(j3, v3, this, this);
        }
        long j16 = this.key;
        if (j3 < j16) {
            return rebalanced(this.left.plus(j3 - j16, v3), this.right);
        }
        if (j3 > j16) {
            return rebalanced(this.left, this.right.plus(j3 - j16, v3));
        }
        if (v3 == this.value) {
            return this;
        }
        return new IntTree<>(j3, v3, this.left, this.right);
    }

    private static <V> IntTree<V> rebalanced(long j3, V v3, IntTree<V> intTree, IntTree<V> intTree2) {
        int i3 = ((IntTree) intTree).size;
        int i16 = ((IntTree) intTree2).size;
        if (i3 + i16 > 1) {
            if (i3 >= i16 * 5) {
                IntTree<V> intTree3 = ((IntTree) intTree).left;
                IntTree<V> intTree4 = ((IntTree) intTree).right;
                if (((IntTree) intTree4).size < ((IntTree) intTree3).size * 2) {
                    long j16 = ((IntTree) intTree).key;
                    return new IntTree<>(j16 + j3, ((IntTree) intTree).value, intTree3, new IntTree(-j16, v3, intTree4.withKey(((IntTree) intTree4).key + j16), intTree2));
                }
                IntTree<V> intTree5 = ((IntTree) intTree4).left;
                IntTree<V> intTree6 = ((IntTree) intTree4).right;
                long j17 = ((IntTree) intTree4).key;
                long j18 = ((IntTree) intTree).key + j17 + j3;
                V v16 = ((IntTree) intTree4).value;
                IntTree intTree7 = new IntTree(-j17, ((IntTree) intTree).value, intTree3, intTree5.withKey(((IntTree) intTree5).key + j17));
                long j19 = ((IntTree) intTree).key;
                long j26 = ((IntTree) intTree4).key;
                return new IntTree<>(j18, v16, intTree7, new IntTree((-j19) - j26, v3, intTree6.withKey(((IntTree) intTree6).key + j26 + j19), intTree2));
            }
            if (i16 >= i3 * 5) {
                IntTree<V> intTree8 = ((IntTree) intTree2).left;
                IntTree<V> intTree9 = ((IntTree) intTree2).right;
                if (((IntTree) intTree8).size < ((IntTree) intTree9).size * 2) {
                    long j27 = ((IntTree) intTree2).key;
                    return new IntTree<>(j27 + j3, ((IntTree) intTree2).value, new IntTree(-j27, v3, intTree, intTree8.withKey(((IntTree) intTree8).key + j27)), intTree9);
                }
                IntTree<V> intTree10 = ((IntTree) intTree8).left;
                IntTree<V> intTree11 = ((IntTree) intTree8).right;
                long j28 = ((IntTree) intTree8).key;
                long j29 = ((IntTree) intTree2).key;
                long j36 = j28 + j29 + j3;
                V v17 = ((IntTree) intTree8).value;
                IntTree intTree12 = new IntTree((-j29) - j28, v3, intTree, intTree10.withKey(((IntTree) intTree10).key + j28 + j29));
                long j37 = ((IntTree) intTree8).key;
                return new IntTree<>(j36, v17, intTree12, new IntTree(-j37, ((IntTree) intTree2).value, intTree11.withKey(((IntTree) intTree11).key + j37), intTree9));
            }
        }
        return new IntTree<>(j3, v3, intTree, intTree2);
    }

    IntTree(long j3, V v3, IntTree<V> intTree, IntTree<V> intTree2) {
        this.key = j3;
        this.value = v3;
        this.left = intTree;
        this.right = intTree2;
        this.size = intTree.size + 1 + intTree2.size;
    }
}

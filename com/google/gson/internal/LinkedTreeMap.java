package com.google.gson.internal;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class LinkedTreeMap<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Comparator<Comparable> NATURAL_ORDER = new Comparator<Comparable>() { // from class: com.google.gson.internal.LinkedTreeMap.1
        @Override // java.util.Comparator
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> comparator;
    private LinkedTreeMap<K, V>.EntrySet entrySet;
    final Node<K, V> header;
    private LinkedTreeMap<K, V>.KeySet keySet;
    int modCount;
    Node<K, V> root;
    int size;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if ((obj instanceof Map.Entry) && LinkedTreeMap.this.findByEntry((Map.Entry) obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<Map.Entry<K, V>>() { // from class: com.google.gson.internal.LinkedTreeMap.EntrySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    return nextNode();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Node<K, V> findByEntry;
            if (!(obj instanceof Map.Entry) || (findByEntry = LinkedTreeMap.this.findByEntry((Map.Entry) obj)) == null) {
                return false;
            }
            LinkedTreeMap.this.removeInternal(findByEntry, true);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            LinkedTreeMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LinkedTreeMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new LinkedTreeMap<K, V>.LinkedTreeMapIterator<K>() { // from class: com.google.gson.internal.LinkedTreeMap.KeySet.1
                {
                    LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
                }

                @Override // java.util.Iterator
                public K next() {
                    return nextNode().key;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (LinkedTreeMap.this.removeInternalByKey(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LinkedTreeMap.this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public abstract class LinkedTreeMapIterator<T> implements Iterator<T> {
        int expectedModCount;
        Node<K, V> lastReturned = null;
        Node<K, V> next;

        LinkedTreeMapIterator() {
            this.next = LinkedTreeMap.this.header.next;
            this.expectedModCount = LinkedTreeMap.this.modCount;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.next != LinkedTreeMap.this.header) {
                return true;
            }
            return false;
        }

        final Node<K, V> nextNode() {
            Node<K, V> node = this.next;
            LinkedTreeMap linkedTreeMap = LinkedTreeMap.this;
            if (node != linkedTreeMap.header) {
                if (linkedTreeMap.modCount == this.expectedModCount) {
                    this.next = node.next;
                    this.lastReturned = node;
                    return node;
                }
                throw new ConcurrentModificationException();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public final void remove() {
            Node<K, V> node = this.lastReturned;
            if (node != null) {
                LinkedTreeMap.this.removeInternal(node, true);
                this.lastReturned = null;
                this.expectedModCount = LinkedTreeMap.this.modCount;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public LinkedTreeMap() {
        this(NATURAL_ORDER);
    }

    private boolean equal(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    private void rebalance(Node<K, V> node, boolean z16) {
        int i3;
        int i16;
        int i17;
        int i18;
        while (node != null) {
            Node<K, V> node2 = node.left;
            Node<K, V> node3 = node.right;
            int i19 = 0;
            if (node2 != null) {
                i3 = node2.height;
            } else {
                i3 = 0;
            }
            if (node3 != null) {
                i16 = node3.height;
            } else {
                i16 = 0;
            }
            int i26 = i3 - i16;
            if (i26 == -2) {
                Node<K, V> node4 = node3.left;
                Node<K, V> node5 = node3.right;
                if (node5 != null) {
                    i18 = node5.height;
                } else {
                    i18 = 0;
                }
                if (node4 != null) {
                    i19 = node4.height;
                }
                int i27 = i19 - i18;
                if (i27 != -1 && (i27 != 0 || z16)) {
                    rotateRight(node3);
                    rotateLeft(node);
                } else {
                    rotateLeft(node);
                }
                if (z16) {
                    return;
                }
            } else if (i26 == 2) {
                Node<K, V> node6 = node2.left;
                Node<K, V> node7 = node2.right;
                if (node7 != null) {
                    i17 = node7.height;
                } else {
                    i17 = 0;
                }
                if (node6 != null) {
                    i19 = node6.height;
                }
                int i28 = i19 - i17;
                if (i28 != 1 && (i28 != 0 || z16)) {
                    rotateLeft(node2);
                    rotateRight(node);
                } else {
                    rotateRight(node);
                }
                if (z16) {
                    return;
                }
            } else if (i26 == 0) {
                node.height = i3 + 1;
                if (z16) {
                    return;
                }
            } else {
                node.height = Math.max(i3, i16) + 1;
                if (!z16) {
                    return;
                }
            }
            node = node.parent;
        }
    }

    private void replaceInParent(Node<K, V> node, Node<K, V> node2) {
        Node<K, V> node3 = node.parent;
        node.parent = null;
        if (node2 != null) {
            node2.parent = node3;
        }
        if (node3 != null) {
            if (node3.left == node) {
                node3.left = node2;
                return;
            } else {
                node3.right = node2;
                return;
            }
        }
        this.root = node2;
    }

    private void rotateLeft(Node<K, V> node) {
        int i3;
        int i16;
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node3.left;
        Node<K, V> node5 = node3.right;
        node.right = node4;
        if (node4 != null) {
            node4.parent = node;
        }
        replaceInParent(node, node3);
        node3.left = node;
        node.parent = node3;
        int i17 = 0;
        if (node2 != null) {
            i3 = node2.height;
        } else {
            i3 = 0;
        }
        if (node4 != null) {
            i16 = node4.height;
        } else {
            i16 = 0;
        }
        int max = Math.max(i3, i16) + 1;
        node.height = max;
        if (node5 != null) {
            i17 = node5.height;
        }
        node3.height = Math.max(max, i17) + 1;
    }

    private void rotateRight(Node<K, V> node) {
        int i3;
        int i16;
        Node<K, V> node2 = node.left;
        Node<K, V> node3 = node.right;
        Node<K, V> node4 = node2.left;
        Node<K, V> node5 = node2.right;
        node.left = node5;
        if (node5 != null) {
            node5.parent = node;
        }
        replaceInParent(node, node2);
        node2.right = node;
        node.parent = node2;
        int i17 = 0;
        if (node3 != null) {
            i3 = node3.height;
        } else {
            i3 = 0;
        }
        if (node5 != null) {
            i16 = node5.height;
        } else {
            i16 = 0;
        }
        int max = Math.max(i3, i16) + 1;
        node.height = max;
        if (node4 != null) {
            i17 = node4.height;
        }
        node2.height = Math.max(max, i17) + 1;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new LinkedHashMap(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        this.root = null;
        this.size = 0;
        this.modCount++;
        Node<K, V> node = this.header;
        node.prev = node;
        node.next = node;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (findByObject(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        LinkedTreeMap<K, V>.EntrySet entrySet = this.entrySet;
        if (entrySet == null) {
            LinkedTreeMap<K, V>.EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }
        return entrySet;
    }

    Node<K, V> find(K k3, boolean z16) {
        int i3;
        Node<K, V> node;
        Comparable comparable;
        Node<K, V> node2;
        Comparator<? super K> comparator = this.comparator;
        Node<K, V> node3 = this.root;
        if (node3 != null) {
            if (comparator == NATURAL_ORDER) {
                comparable = (Comparable) k3;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i3 = comparable.compareTo(node3.key);
                } else {
                    i3 = comparator.compare(k3, node3.key);
                }
                if (i3 == 0) {
                    return node3;
                }
                if (i3 < 0) {
                    node2 = node3.left;
                } else {
                    node2 = node3.right;
                }
                if (node2 == null) {
                    break;
                }
                node3 = node2;
            }
        } else {
            i3 = 0;
        }
        if (!z16) {
            return null;
        }
        Node<K, V> node4 = this.header;
        if (node3 == null) {
            if (comparator == NATURAL_ORDER && !(k3 instanceof Comparable)) {
                throw new ClassCastException(k3.getClass().getName() + " is not Comparable");
            }
            node = new Node<>(node3, k3, node4, node4.prev);
            this.root = node;
        } else {
            node = new Node<>(node3, k3, node4, node4.prev);
            if (i3 < 0) {
                node3.left = node;
            } else {
                node3.right = node;
            }
            rebalance(node3, true);
        }
        this.size++;
        this.modCount++;
        return node;
    }

    Node<K, V> findByEntry(Map.Entry<?, ?> entry) {
        boolean z16;
        Node<K, V> findByObject = findByObject(entry.getKey());
        if (findByObject != null && equal(findByObject.value, entry.getValue())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return null;
        }
        return findByObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    Node<K, V> findByObject(Object obj) {
        if (obj == 0) {
            return null;
        }
        try {
            return find(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            return findByObject.value;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        LinkedTreeMap<K, V>.KeySet keySet = this.keySet;
        if (keySet == null) {
            LinkedTreeMap<K, V>.KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }
        return keySet;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k3, V v3) {
        if (k3 != null) {
            Node<K, V> find = find(k3, true);
            V v16 = find.value;
            find.value = v3;
            return v16;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        Node<K, V> removeInternalByKey = removeInternalByKey(obj);
        if (removeInternalByKey != null) {
            return removeInternalByKey.value;
        }
        return null;
    }

    void removeInternal(Node<K, V> node, boolean z16) {
        Node<K, V> first;
        int i3;
        if (z16) {
            Node<K, V> node2 = node.prev;
            node2.next = node.next;
            node.next.prev = node2;
        }
        Node<K, V> node3 = node.left;
        Node<K, V> node4 = node.right;
        Node<K, V> node5 = node.parent;
        int i16 = 0;
        if (node3 != null && node4 != null) {
            if (node3.height > node4.height) {
                first = node3.last();
            } else {
                first = node4.first();
            }
            removeInternal(first, false);
            Node<K, V> node6 = node.left;
            if (node6 != null) {
                i3 = node6.height;
                first.left = node6;
                node6.parent = first;
                node.left = null;
            } else {
                i3 = 0;
            }
            Node<K, V> node7 = node.right;
            if (node7 != null) {
                i16 = node7.height;
                first.right = node7;
                node7.parent = first;
                node.right = null;
            }
            first.height = Math.max(i3, i16) + 1;
            replaceInParent(node, first);
            return;
        }
        if (node3 != null) {
            replaceInParent(node, node3);
            node.left = null;
        } else if (node4 != null) {
            replaceInParent(node, node4);
            node.right = null;
        } else {
            replaceInParent(node, null);
        }
        rebalance(node5, false);
        this.size--;
        this.modCount++;
    }

    Node<K, V> removeInternalByKey(Object obj) {
        Node<K, V> findByObject = findByObject(obj);
        if (findByObject != null) {
            removeInternal(findByObject, true);
        }
        return findByObject;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.size;
    }

    public LinkedTreeMap(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.header = new Node<>();
        this.comparator = comparator == null ? NATURAL_ORDER : comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Node<K, V> implements Map.Entry<K, V> {
        int height;
        final K key;
        Node<K, V> left;
        Node<K, V> next;
        Node<K, V> parent;
        Node<K, V> prev;
        Node<K, V> right;
        V value;

        Node() {
            this.key = null;
            this.prev = this;
            this.next = this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k3 = this.key;
            if (k3 == null) {
                if (entry.getKey() != null) {
                    return false;
                }
            } else if (!k3.equals(entry.getKey())) {
                return false;
            }
            V v3 = this.value;
            if (v3 == null) {
                if (entry.getValue() != null) {
                    return false;
                }
            } else if (!v3.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public Node<K, V> first() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.left; node2 != null; node2 = node2.left) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k3 = this.key;
            int i3 = 0;
            if (k3 == null) {
                hashCode = 0;
            } else {
                hashCode = k3.hashCode();
            }
            V v3 = this.value;
            if (v3 != null) {
                i3 = v3.hashCode();
            }
            return hashCode ^ i3;
        }

        public Node<K, V> last() {
            Node<K, V> node = this;
            for (Node<K, V> node2 = this.right; node2 != null; node2 = node2.right) {
                node = node2;
            }
            return node;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            V v16 = this.value;
            this.value = v3;
            return v16;
        }

        public String toString() {
            return this.key + ContainerUtils.KEY_VALUE_DELIMITER + this.value;
        }

        Node(Node<K, V> node, K k3, Node<K, V> node2, Node<K, V> node3) {
            this.parent = node;
            this.key = k3;
            this.height = 1;
            this.next = node2;
            this.prev = node3;
            node3.next = this;
            node2.prev = this;
        }
    }
}

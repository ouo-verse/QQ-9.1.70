package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new RegularImmutableMap(null, new Object[0], 0);
    private static final long serialVersionUID = 0;

    @VisibleForTesting
    final transient Object[] alternatingKeysAndValues;

    /* renamed from: i, reason: collision with root package name */
    private final transient int[] f34989i;

    /* renamed from: m, reason: collision with root package name */
    private final transient int f34990m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class EntrySet<K, V> extends ImmutableSet<Map.Entry<K, V>> {

        /* renamed from: f, reason: collision with root package name */
        private final transient ImmutableMap<K, V> f34991f;

        /* renamed from: h, reason: collision with root package name */
        private final transient Object[] f34992h;

        /* renamed from: i, reason: collision with root package name */
        private final transient int f34993i;

        /* renamed from: m, reason: collision with root package name */
        private final transient int f34994m;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EntrySet(ImmutableMap<K, V> immutableMap, Object[] objArr, int i3, int i16) {
            this.f34991f = immutableMap;
            this.f34992h = objArr;
            this.f34993i = i3;
            this.f34994m = i16;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.f34991f.get(key))) {
                return false;
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i3) {
            return asList().copyIntoArray(objArr, i3);
        }

        @Override // com.google.common.collect.ImmutableSet
        ImmutableList<Map.Entry<K, V>> createAsList() {
            return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.RegularImmutableMap.EntrySet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return EntrySet.this.f34994m;
                }

                @Override // java.util.List
                public Map.Entry<K, V> get(int i3) {
                    com.google.common.base.j.k(i3, EntrySet.this.f34994m);
                    int i16 = i3 * 2;
                    return new AbstractMap.SimpleImmutableEntry(EntrySet.this.f34992h[EntrySet.this.f34993i + i16], EntrySet.this.f34992h[i16 + (EntrySet.this.f34993i ^ 1)]);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f34994m;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public ai<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class KeySet<K> extends ImmutableSet<K> {

        /* renamed from: f, reason: collision with root package name */
        private final transient ImmutableMap<K, ?> f34995f;

        /* renamed from: h, reason: collision with root package name */
        private final transient ImmutableList<K> f34996h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeySet(ImmutableMap<K, ?> immutableMap, ImmutableList<K> immutableList) {
            this.f34995f = immutableMap;
            this.f34996h = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        public ImmutableList<K> asList() {
            return this.f34996h;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            if (this.f34995f.get(obj) != null) {
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int copyIntoArray(Object[] objArr, int i3) {
            return asList().copyIntoArray(objArr, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f34995f.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public ai<K> iterator() {
            return asList().iterator();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static final class KeysOrValuesAsList extends ImmutableList<Object> {

        /* renamed from: f, reason: collision with root package name */
        private final transient Object[] f34997f;

        /* renamed from: h, reason: collision with root package name */
        private final transient int f34998h;

        /* renamed from: i, reason: collision with root package name */
        private final transient int f34999i;

        /* JADX INFO: Access modifiers changed from: package-private */
        public KeysOrValuesAsList(Object[] objArr, int i3, int i16) {
            this.f34997f = objArr;
            this.f34998h = i3;
            this.f34999i = i16;
        }

        @Override // java.util.List
        public Object get(int i3) {
            com.google.common.base.j.k(i3, this.f34999i);
            return this.f34997f[(i3 * 2) + this.f34998h];
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f34999i;
        }
    }

    RegularImmutableMap(int[] iArr, Object[] objArr, int i3) {
        this.f34989i = iArr;
        this.alternatingKeysAndValues = objArr;
        this.f34990m = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> create(int i3, Object[] objArr) {
        if (i3 == 0) {
            return (RegularImmutableMap) EMPTY;
        }
        if (i3 == 1) {
            h.a(objArr[0], objArr[1]);
            return new RegularImmutableMap<>(null, objArr, 1);
        }
        com.google.common.base.j.p(i3, objArr.length >> 1);
        return new RegularImmutableMap<>(createHashTable(objArr, i3, ImmutableSet.chooseTableSize(i3), 0), objArr, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0034, code lost:
    
        r12[r7] = r5;
        r3 = r3 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int[] createHashTable(Object[] objArr, int i3, int i16, int i17) {
        if (i3 == 1) {
            h.a(objArr[i17], objArr[i17 ^ 1]);
            return null;
        }
        int i18 = i16 - 1;
        int[] iArr = new int[i16];
        Arrays.fill(iArr, -1);
        int i19 = 0;
        while (i19 < i3) {
            int i26 = i19 * 2;
            int i27 = i26 + i17;
            Object obj = objArr[i27];
            Object obj2 = objArr[i26 + (i17 ^ 1)];
            h.a(obj, obj2);
            int b16 = p.b(obj.hashCode());
            while (true) {
                int i28 = b16 & i18;
                int i29 = iArr[i28];
                if (i29 == -1) {
                    break;
                }
                if (!objArr[i29].equals(obj)) {
                    b16 = i28 + 1;
                } else {
                    throw new IllegalArgumentException("Multiple entries with same key: " + obj + ContainerUtils.KEY_VALUE_DELIMITER + obj2 + " and " + objArr[i29] + ContainerUtils.KEY_VALUE_DELIMITER + objArr[i29 ^ 1]);
                }
            }
        }
        return iArr;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new EntrySet(this, this.alternatingKeysAndValues, 0, this.f34990m);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new KeySet(this, new KeysOrValuesAsList(this.alternatingKeysAndValues, 0, this.f34990m));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new KeysOrValuesAsList(this.alternatingKeysAndValues, 1, this.f34990m);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @NullableDecl
    public V get(@NullableDecl Object obj) {
        return (V) get(this.f34989i, this.alternatingKeysAndValues, this.f34990m, 0, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f34990m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object get(@NullableDecl int[] iArr, @NullableDecl Object[] objArr, int i3, int i16, @NullableDecl Object obj) {
        if (obj == null) {
            return null;
        }
        if (i3 == 1) {
            if (objArr[i16].equals(obj)) {
                return objArr[i16 ^ 1];
            }
            return null;
        }
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        int b16 = p.b(obj.hashCode());
        while (true) {
            int i17 = b16 & length;
            int i18 = iArr[i17];
            if (i18 == -1) {
                return null;
            }
            if (objArr[i18].equals(obj)) {
                return objArr[i18 ^ 1];
            }
            b16 = i17 + 1;
        }
    }
}

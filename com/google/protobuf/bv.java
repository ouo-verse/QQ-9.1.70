package com.google.protobuf;

import com.google.protobuf.z;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class bv<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private volatile bv<K, V>.c C;

    /* renamed from: d, reason: collision with root package name */
    private final int f35755d;

    /* renamed from: e, reason: collision with root package name */
    private List<bv<K, V>.e> f35756e;

    /* renamed from: f, reason: collision with root package name */
    private Map<K, V> f35757f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f35758h;

    /* renamed from: i, reason: collision with root package name */
    private volatile bv<K, V>.g f35759i;

    /* renamed from: m, reason: collision with root package name */
    private Map<K, V> f35760m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [FieldDescriptorType] */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a<FieldDescriptorType> extends bv<FieldDescriptorType, Object> {
        a(int i3) {
            super(i3, null);
        }

        @Override // com.google.protobuf.bv, java.util.AbstractMap, java.util.Map
        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return super.put((z.c) obj, obj2);
        }

        @Override // com.google.protobuf.bv
        public void r() {
            if (!q()) {
                for (int i3 = 0; i3 < m(); i3++) {
                    Map.Entry<FieldDescriptorType, Object> l3 = l(i3);
                    if (((z.c) l3.getKey()).isRepeated()) {
                        l3.setValue(Collections.unmodifiableList((List) l3.getValue()));
                    }
                }
                for (Map.Entry<FieldDescriptorType, Object> entry : o()) {
                    if (((z.c) entry.getKey()).isRepeated()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            super.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class c extends bv<K, V>.g {
        c() {
            super(bv.this, null);
        }

        @Override // com.google.protobuf.bv.g, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new b(bv.this, null);
        }

        /* synthetic */ c(bv bvVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f35765a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Iterable<Object> f35766b = new b();

        /* compiled from: P */
        /* loaded from: classes2.dex */
        static class a implements Iterator<Object> {
            a() {
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: P */
        /* loaded from: classes2.dex */
        static class b implements Iterable<Object> {
            b() {
            }

            @Override // java.lang.Iterable
            public Iterator<Object> iterator() {
                return d.f35765a;
            }
        }

        static <T> Iterable<T> b() {
            return (Iterable<T>) f35766b;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements Map.Entry<K, V>, Comparable<bv<K, V>.e> {

        /* renamed from: d, reason: collision with root package name */
        private final K f35767d;

        /* renamed from: e, reason: collision with root package name */
        private V f35768e;

        e(bv bvVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        private boolean d(Object obj, Object obj2) {
            if (obj == null) {
                if (obj2 == null) {
                    return true;
                }
                return false;
            }
            return obj.equals(obj2);
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(bv<K, V>.e eVar) {
            return getKey().compareTo(eVar.getKey());
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (d(this.f35767d, entry.getKey()) && d(this.f35768e, entry.getValue())) {
                return true;
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.f35768e;
        }

        @Override // java.util.Map.Entry
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public K getKey() {
            return this.f35767d;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int hashCode;
            K k3 = this.f35767d;
            int i3 = 0;
            if (k3 == null) {
                hashCode = 0;
            } else {
                hashCode = k3.hashCode();
            }
            V v3 = this.f35768e;
            if (v3 != null) {
                i3 = v3.hashCode();
            }
            return hashCode ^ i3;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            bv.this.i();
            V v16 = this.f35768e;
            this.f35768e = v3;
            return v16;
        }

        public String toString() {
            return this.f35767d + ContainerUtils.KEY_VALUE_DELIMITER + this.f35768e;
        }

        e(K k3, V v3) {
            this.f35767d = k3;
            this.f35768e = v3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class g extends AbstractSet<Map.Entry<K, V>> {
        g() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            if (!contains(entry)) {
                bv.this.put(entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            bv.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = bv.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new f(bv.this, null);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                bv.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return bv.this.size();
        }

        /* synthetic */ g(bv bvVar, a aVar) {
            this();
        }
    }

    /* synthetic */ bv(int i3, a aVar) {
        this(i3);
    }

    private int h(K k3) {
        int size = this.f35756e.size() - 1;
        if (size >= 0) {
            int compareTo = k3.compareTo(this.f35756e.get(size).getKey());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i3 = 0;
        while (i3 <= size) {
            int i16 = (i3 + size) / 2;
            int compareTo2 = k3.compareTo(this.f35756e.get(i16).getKey());
            if (compareTo2 < 0) {
                size = i16 - 1;
            } else if (compareTo2 > 0) {
                i3 = i16 + 1;
            } else {
                return i16;
            }
        }
        return -(i3 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (!this.f35758h) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    private void k() {
        i();
        if (this.f35756e.isEmpty() && !(this.f35756e instanceof ArrayList)) {
            this.f35756e = new ArrayList(this.f35755d);
        }
    }

    private SortedMap<K, V> p() {
        i();
        if (this.f35757f.isEmpty() && !(this.f35757f instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f35757f = treeMap;
            this.f35760m = treeMap.descendingMap();
        }
        return (SortedMap) this.f35757f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends z.c<FieldDescriptorType>> bv<FieldDescriptorType, Object> s(int i3) {
        return new a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V u(int i3) {
        i();
        V value = this.f35756e.remove(i3).getValue();
        if (!this.f35757f.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = p().entrySet().iterator();
            this.f35756e.add(new e(this, it.next()));
            it.remove();
        }
        return value;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        i();
        if (!this.f35756e.isEmpty()) {
            this.f35756e.clear();
        }
        if (!this.f35757f.isEmpty()) {
            this.f35757f.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (h(comparable) < 0 && !this.f35757f.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.f35759i == null) {
            this.f35759i = new g(this, null);
        }
        return this.f35759i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bv)) {
            return super.equals(obj);
        }
        bv bvVar = (bv) obj;
        int size = size();
        if (size != bvVar.size()) {
            return false;
        }
        int m3 = m();
        if (m3 != bvVar.m()) {
            return entrySet().equals(bvVar.entrySet());
        }
        for (int i3 = 0; i3 < m3; i3++) {
            if (!l(i3).equals(bvVar.l(i3))) {
                return false;
            }
        }
        if (m3 == size) {
            return true;
        }
        return this.f35757f.equals(bvVar.f35757f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int h16 = h(comparable);
        if (h16 >= 0) {
            return this.f35756e.get(h16).getValue();
        }
        return this.f35757f.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int m3 = m();
        int i3 = 0;
        for (int i16 = 0; i16 < m3; i16++) {
            i3 += this.f35756e.get(i16).hashCode();
        }
        if (n() > 0) {
            return i3 + this.f35757f.hashCode();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> j() {
        if (this.C == null) {
            this.C = new c(this, null);
        }
        return this.C;
    }

    public Map.Entry<K, V> l(int i3) {
        return this.f35756e.get(i3);
    }

    public int m() {
        return this.f35756e.size();
    }

    public int n() {
        return this.f35757f.size();
    }

    public Iterable<Map.Entry<K, V>> o() {
        if (this.f35757f.isEmpty()) {
            return d.b();
        }
        return this.f35757f.entrySet();
    }

    public boolean q() {
        return this.f35758h;
    }

    public void r() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (!this.f35758h) {
            if (this.f35757f.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.f35757f);
            }
            this.f35757f = unmodifiableMap;
            if (this.f35760m.isEmpty()) {
                unmodifiableMap2 = Collections.emptyMap();
            } else {
                unmodifiableMap2 = Collections.unmodifiableMap(this.f35760m);
            }
            this.f35760m = unmodifiableMap2;
            this.f35758h = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        i();
        Comparable comparable = (Comparable) obj;
        int h16 = h(comparable);
        if (h16 >= 0) {
            return (V) u(h16);
        }
        if (this.f35757f.isEmpty()) {
            return null;
        }
        return this.f35757f.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.f35756e.size() + this.f35757f.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public V put(K k3, V v3) {
        i();
        int h16 = h(k3);
        if (h16 >= 0) {
            return this.f35756e.get(h16).setValue(v3);
        }
        k();
        int i3 = -(h16 + 1);
        if (i3 >= this.f35755d) {
            return p().put(k3, v3);
        }
        int size = this.f35756e.size();
        int i16 = this.f35755d;
        if (size == i16) {
            bv<K, V>.e remove = this.f35756e.remove(i16 - 1);
            p().put(remove.getKey(), remove.getValue());
        }
        this.f35756e.add(i3, new e(k3, v3));
        return null;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class b implements Iterator<Map.Entry<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        private int f35761d;

        /* renamed from: e, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f35762e;

        b() {
            this.f35761d = bv.this.f35756e.size();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f35762e == null) {
                this.f35762e = bv.this.f35760m.entrySet().iterator();
            }
            return this.f35762e;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!a().hasNext()) {
                List list = bv.this.f35756e;
                int i3 = this.f35761d - 1;
                this.f35761d = i3;
                return (Map.Entry) list.get(i3);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i3 = this.f35761d;
            if ((i3 > 0 && i3 <= bv.this.f35756e.size()) || a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* synthetic */ b(bv bvVar, a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private class f implements Iterator<Map.Entry<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        private int f35770d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f35771e;

        /* renamed from: f, reason: collision with root package name */
        private Iterator<Map.Entry<K, V>> f35772f;

        f() {
            this.f35770d = -1;
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.f35772f == null) {
                this.f35772f = bv.this.f35757f.entrySet().iterator();
            }
            return this.f35772f;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            this.f35771e = true;
            int i3 = this.f35770d + 1;
            this.f35770d = i3;
            if (i3 < bv.this.f35756e.size()) {
                return (Map.Entry) bv.this.f35756e.get(this.f35770d);
            }
            return a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f35770d + 1 < bv.this.f35756e.size()) {
                return true;
            }
            if (!bv.this.f35757f.isEmpty() && a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (this.f35771e) {
                this.f35771e = false;
                bv.this.i();
                if (this.f35770d < bv.this.f35756e.size()) {
                    bv bvVar = bv.this;
                    int i3 = this.f35770d;
                    this.f35770d = i3 - 1;
                    bvVar.u(i3);
                    return;
                }
                a().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }

        /* synthetic */ f(bv bvVar, a aVar) {
            this();
        }
    }

    bv(int i3) {
        this.f35755d = i3;
        this.f35756e = Collections.emptyList();
        this.f35757f = Collections.emptyMap();
        this.f35760m = Collections.emptyMap();
    }
}

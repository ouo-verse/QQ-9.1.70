package com.xingin.xhssharesdk.a;

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

/* compiled from: P */
/* loaded from: classes28.dex */
public class p<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f389954m = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f389955d;

    /* renamed from: e, reason: collision with root package name */
    public List<p<K, V>.b> f389956e;

    /* renamed from: f, reason: collision with root package name */
    public Map<K, V> f389957f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f389958h;

    /* renamed from: i, reason: collision with root package name */
    public volatile p<K, V>.d f389959i;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static final C10096a f389960a = new C10096a();

        /* renamed from: b, reason: collision with root package name */
        public static final b f389961b = new b();

        /* compiled from: P */
        /* renamed from: com.xingin.xhssharesdk.a.p$a$a, reason: collision with other inner class name */
        /* loaded from: classes28.dex */
        public static class C10096a implements Iterator<Object> {
            @Override // java.util.Iterator
            public final boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        }

        /* compiled from: P */
        /* loaded from: classes28.dex */
        public static class b implements Iterable<Object> {
            @Override // java.lang.Iterable
            public final Iterator<Object> iterator() {
                return a.f389960a;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class b implements Map.Entry<K, V>, Comparable<p<K, V>.b> {

        /* renamed from: d, reason: collision with root package name */
        public final K f389962d;

        /* renamed from: e, reason: collision with root package name */
        public V f389963e;

        public b() {
            throw null;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            return this.f389962d.compareTo(((b) obj).f389962d);
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            boolean equals;
            boolean equals2;
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k3 = this.f389962d;
            Object key = entry.getKey();
            if (k3 == null) {
                if (key == null) {
                    equals = true;
                } else {
                    equals = false;
                }
            } else {
                equals = k3.equals(key);
            }
            if (equals) {
                V v3 = this.f389963e;
                Object value = entry.getValue();
                if (v3 == null) {
                    if (value == null) {
                        equals2 = true;
                    } else {
                        equals2 = false;
                    }
                } else {
                    equals2 = v3.equals(value);
                }
                if (equals2) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f389962d;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            return this.f389963e;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int hashCode;
            K k3 = this.f389962d;
            int i3 = 0;
            if (k3 == null) {
                hashCode = 0;
            } else {
                hashCode = k3.hashCode();
            }
            V v3 = this.f389963e;
            if (v3 != null) {
                i3 = v3.hashCode();
            }
            return hashCode ^ i3;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v3) {
            p pVar = p.this;
            int i3 = p.f389954m;
            pVar.f();
            V v16 = this.f389963e;
            this.f389963e = v3;
            return v16;
        }

        public final String toString() {
            return this.f389962d + ContainerUtils.KEY_VALUE_DELIMITER + this.f389963e;
        }

        public b(K k3, V v3) {
            this.f389962d = k3;
            this.f389963e = v3;
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class c implements Iterator<Map.Entry<K, V>> {

        /* renamed from: d, reason: collision with root package name */
        public int f389965d = -1;

        /* renamed from: e, reason: collision with root package name */
        public boolean f389966e;

        /* renamed from: f, reason: collision with root package name */
        public Iterator<Map.Entry<K, V>> f389967f;

        public c() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            if (this.f389965d + 1 < p.this.f389956e.size()) {
                return true;
            }
            if (this.f389967f == null) {
                this.f389967f = p.this.f389957f.entrySet().iterator();
            }
            if (this.f389967f.hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public final Object next() {
            this.f389966e = true;
            int i3 = this.f389965d + 1;
            this.f389965d = i3;
            if (i3 < p.this.f389956e.size()) {
                return p.this.f389956e.get(this.f389965d);
            }
            if (this.f389967f == null) {
                this.f389967f = p.this.f389957f.entrySet().iterator();
            }
            return this.f389967f.next();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.f389966e) {
                this.f389966e = false;
                p pVar = p.this;
                int i3 = p.f389954m;
                pVar.f();
                if (this.f389965d < p.this.f389956e.size()) {
                    p pVar2 = p.this;
                    int i16 = this.f389965d;
                    this.f389965d = i16 - 1;
                    pVar2.f();
                    V v3 = pVar2.f389956e.remove(i16).f389963e;
                    if (!pVar2.f389957f.isEmpty()) {
                        pVar2.f();
                        if (pVar2.f389957f.isEmpty() && !(pVar2.f389957f instanceof TreeMap)) {
                            pVar2.f389957f = new TreeMap();
                        }
                        Iterator it = ((SortedMap) pVar2.f389957f).entrySet().iterator();
                        List<p<K, V>.b> list = pVar2.f389956e;
                        Map.Entry entry = (Map.Entry) it.next();
                        list.add(new b((Comparable) entry.getKey(), entry.getValue()));
                        it.remove();
                        return;
                    }
                    return;
                }
                if (this.f389967f == null) {
                    this.f389967f = p.this.f389957f.entrySet().iterator();
                }
                this.f389967f.remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public class d extends AbstractSet<Map.Entry<K, V>> {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                p.this.put((Comparable) entry.getKey(), entry.getValue());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            p.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = p.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value && (obj2 == null || !obj2.equals(value))) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator<Map.Entry<K, V>> iterator() {
            return new c();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                p.this.remove(entry.getKey());
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return p.this.size();
        }
    }

    public p(int i3) {
        this.f389955d = i3;
        this.f389956e = Collections.emptyList();
        this.f389957f = Collections.emptyMap();
    }

    public static o d(int i3) {
        return new o(i3);
    }

    public final int c(K k3) {
        int size = this.f389956e.size() - 1;
        if (size >= 0) {
            int compareTo = k3.compareTo(this.f389956e.get(size).f389962d);
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
            int compareTo2 = k3.compareTo(this.f389956e.get(i16).f389962d);
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

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        f();
        if (!this.f389956e.isEmpty()) {
            this.f389956e.clear();
        }
        if (!this.f389957f.isEmpty()) {
            this.f389957f.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        if (c(comparable) < 0 && !this.f389957f.containsKey(comparable)) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final V put(K k3, V v3) {
        f();
        int c16 = c(k3);
        if (c16 >= 0) {
            return this.f389956e.get(c16).setValue(v3);
        }
        f();
        if (this.f389956e.isEmpty() && !(this.f389956e instanceof ArrayList)) {
            this.f389956e = new ArrayList(this.f389955d);
        }
        int i3 = -(c16 + 1);
        if (i3 >= this.f389955d) {
            f();
            if (this.f389957f.isEmpty() && !(this.f389957f instanceof TreeMap)) {
                this.f389957f = new TreeMap();
            }
            return (V) ((SortedMap) this.f389957f).put(k3, v3);
        }
        int size = this.f389956e.size();
        int i16 = this.f389955d;
        if (size == i16) {
            p<K, V>.b remove = this.f389956e.remove(i16 - 1);
            f();
            if (this.f389957f.isEmpty() && !(this.f389957f instanceof TreeMap)) {
                this.f389957f = new TreeMap();
            }
            ((SortedMap) this.f389957f).put(remove.f389962d, remove.f389963e);
        }
        this.f389956e.add(i3, new b(k3, v3));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        if (this.f389959i == null) {
            this.f389959i = new d();
        }
        return this.f389959i;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return super.equals(obj);
        }
        p pVar = (p) obj;
        int size = size();
        if (size != pVar.size()) {
            return false;
        }
        int size2 = this.f389956e.size();
        if (size2 != pVar.f389956e.size()) {
            return ((AbstractSet) entrySet()).equals(pVar.entrySet());
        }
        for (int i3 = 0; i3 < size2; i3++) {
            if (!this.f389956e.get(i3).equals(pVar.f389956e.get(i3))) {
                return false;
            }
        }
        if (size2 == size) {
            return true;
        }
        return this.f389957f.equals(pVar.f389957f);
    }

    public final void f() {
        if (!this.f389958h) {
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void g() {
        Map<K, V> unmodifiableMap;
        if (!this.f389958h) {
            if (this.f389957f.isEmpty()) {
                unmodifiableMap = Collections.emptyMap();
            } else {
                unmodifiableMap = Collections.unmodifiableMap(this.f389957f);
            }
            this.f389957f = unmodifiableMap;
            this.f389958h = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int c16 = c(comparable);
        if (c16 >= 0) {
            return this.f389956e.get(c16).f389963e;
        }
        return this.f389957f.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int size = this.f389956e.size();
        int i3 = 0;
        for (int i16 = 0; i16 < size; i16++) {
            i3 += this.f389956e.get(i16).hashCode();
        }
        if (this.f389957f.size() > 0) {
            return i3 + this.f389957f.hashCode();
        }
        return i3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        f();
        Comparable comparable = (Comparable) obj;
        int c16 = c(comparable);
        if (c16 >= 0) {
            f();
            V v3 = this.f389956e.remove(c16).f389963e;
            if (!this.f389957f.isEmpty()) {
                f();
                if (this.f389957f.isEmpty() && !(this.f389957f instanceof TreeMap)) {
                    this.f389957f = new TreeMap();
                }
                Iterator it = ((SortedMap) this.f389957f).entrySet().iterator();
                List<p<K, V>.b> list = this.f389956e;
                Map.Entry entry = (Map.Entry) it.next();
                list.add(new b((Comparable) entry.getKey(), entry.getValue()));
                it.remove();
            }
            return v3;
        }
        if (this.f389957f.isEmpty()) {
            return null;
        }
        return this.f389957f.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f389957f.size() + this.f389956e.size();
    }

    public /* synthetic */ p(int i3, int i16) {
        this(i3);
    }
}

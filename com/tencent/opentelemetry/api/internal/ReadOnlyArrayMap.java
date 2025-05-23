package com.tencent.opentelemetry.api.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReadOnlyArrayMap<K, V> extends AbstractMap<K, V> {
    static IPatchRedirector $redirector_;
    private final List<Object> array;
    private final int size;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    final class EntrySetView extends ReadOnlyArrayMap<K, V>.SetView<Map.Entry<K, V>> {
        static IPatchRedirector $redirector_;

        EntrySetView() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReadOnlyArrayMap.this);
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            int arrayIndexOfKey;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || (arrayIndexOfKey = ReadOnlyArrayMap.this.arrayIndexOfKey(entry.getKey())) == -1) {
                    return false;
                }
                return ReadOnlyArrayMap.this.value(arrayIndexOfKey + 1).equals(entry.getValue());
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.opentelemetry.api.internal.ReadOnlyArrayMap.SetView
        public Map.Entry<K, V> elementAtArrayIndex(int i3) {
            return new AbstractMap.SimpleImmutableEntry(ReadOnlyArrayMap.this.key(i3), ReadOnlyArrayMap.this.value(i3 + 1));
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    final class KeySetView extends ReadOnlyArrayMap<K, V>.SetView<K> {
        static IPatchRedirector $redirector_;

        KeySetView() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReadOnlyArrayMap.this);
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            return ReadOnlyArrayMap.this.containsKey(obj);
        }

        @Override // com.tencent.opentelemetry.api.internal.ReadOnlyArrayMap.SetView
        K elementAtArrayIndex(int i3) {
            return (K) ReadOnlyArrayMap.this.key(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public abstract class SetView<E> implements Set<E> {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        final class ReadOnlyIterator implements Iterator<E> {
            static IPatchRedirector $redirector_;
            int current;

            ReadOnlyIterator() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) SetView.this);
                } else {
                    this.current = 0;
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
                }
                if (this.current < ReadOnlyArrayMap.this.array.size()) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            public E next() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    return (E) iPatchRedirector.redirect((short) 3, (Object) this);
                }
                if (hasNext()) {
                    E e16 = (E) SetView.this.elementAtArrayIndex(this.current);
                    this.current += 2;
                    return e16;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    iPatchRedirector.redirect((short) 4, (Object) this);
                    return;
                }
                throw new UnsupportedOperationException();
            }
        }

        SetView() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReadOnlyArrayMap.this);
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(E e16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) e16)).booleanValue();
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) collection)).booleanValue();
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this);
                return;
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) collection)).booleanValue();
            }
            if (collection == null) {
                return false;
            }
            if (collection.isEmpty()) {
                return true;
            }
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        <T> T[] copyTo(T[] tArr) {
            int i3 = 0;
            int i16 = 0;
            while (i3 < ReadOnlyArrayMap.this.array.size()) {
                tArr[i16] = elementAtArrayIndex(i3);
                i3 += 2;
                i16++;
            }
            return tArr;
        }

        abstract E elementAtArrayIndex(int i3);

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Iterator) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return new ReadOnlyIterator();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, obj)).booleanValue();
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) collection)).booleanValue();
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) collection)).booleanValue();
            }
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return ReadOnlyArrayMap.this.size;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? copyTo(new Object[ReadOnlyArrayMap.this.size]) : (Object[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (T[]) ((Object[]) iPatchRedirector.redirect((short) 5, (Object) this, (Object) tArr));
            }
            if (tArr.length < ReadOnlyArrayMap.this.size) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size()));
            }
            return (T[]) copyTo(tArr);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    final class ValuesView extends ReadOnlyArrayMap<K, V>.SetView<V> {
        static IPatchRedirector $redirector_;

        ValuesView() {
            super();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ReadOnlyArrayMap.this);
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, obj)).booleanValue();
            }
            return ReadOnlyArrayMap.this.containsValue(obj);
        }

        @Override // com.tencent.opentelemetry.api.internal.ReadOnlyArrayMap.SetView
        V elementAtArrayIndex(int i3) {
            return (V) ReadOnlyArrayMap.this.value(i3 + 1);
        }
    }

    ReadOnlyArrayMap(List<Object> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) list);
        } else {
            this.array = list;
            this.size = list.size() / 2;
        }
    }

    public static <K, V> Map<K, V> wrap(List<Object> list) {
        if (list.isEmpty()) {
            return Collections.emptyMap();
        }
        return new ReadOnlyArrayMap(list);
    }

    int arrayIndexOfKey(Object obj) {
        for (int i3 = 0; i3 < this.array.size(); i3 += 2) {
            if (obj.equals(key(i3))) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null || arrayIndexOfKey(obj) == -1) {
            return false;
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, obj)).booleanValue();
        }
        for (int i3 = 0; i3 < this.array.size(); i3 += 2) {
            if (value(i3 + 1).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Set) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new EntrySetView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    @Nullable
    public V get(Object obj) {
        int arrayIndexOfKey;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (V) iPatchRedirector.redirect((short) 5, (Object) this, obj);
        }
        if (obj == null || (arrayIndexOfKey = arrayIndexOfKey(obj)) == -1) {
            return null;
        }
        return value(arrayIndexOfKey + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return false;
    }

    K key(int i3) {
        return (K) this.array.get(i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Set) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return new KeySetView();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (V) iPatchRedirector.redirect((short) 10, (Object) this, (Object) k3, (Object) v3);
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) map);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (V) iPatchRedirector.redirect((short) 11, (Object) this, obj);
        }
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.size;
    }

    @Override // java.util.AbstractMap
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ReadOnlyArrayMap{");
        for (int i3 = 0; i3 < this.array.size(); i3 += 2) {
            sb5.append(key(i3));
            sb5.append('=');
            sb5.append(value(i3 + 1));
            sb5.append(',');
        }
        sb5.setLength(sb5.length() - 1);
        sb5.append("}");
        return sb5.toString();
    }

    V value(int i3) {
        return (V) this.array.get(i3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Collection) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return new ValuesView();
    }
}

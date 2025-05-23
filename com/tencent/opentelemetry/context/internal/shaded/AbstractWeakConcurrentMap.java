package com.tencent.opentelemetry.context.internal.shaded;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class AbstractWeakConcurrentMap<K, V, L> extends ReferenceQueue<K> implements Runnable, Iterable<Map.Entry<K, V>> {
    static IPatchRedirector $redirector_;
    final ConcurrentMap<WeakKey<K>, V> target;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private class EntryIterator implements Iterator<Map.Entry<K, V>> {
        static IPatchRedirector $redirector_;
        private final Iterator<Map.Entry<WeakKey<K>, V>> iterator;
        private Map.Entry<WeakKey<K>, V> nextEntry;
        private K nextKey;

        /* synthetic */ EntryIterator(AbstractWeakConcurrentMap abstractWeakConcurrentMap, Iterator it, AnonymousClass1 anonymousClass1) {
            this(it);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, this, abstractWeakConcurrentMap, it, anonymousClass1);
        }

        private void findNext() {
            while (this.iterator.hasNext()) {
                Map.Entry<WeakKey<K>, V> next = this.iterator.next();
                this.nextEntry = next;
                K k3 = next.getKey().get();
                this.nextKey = k3;
                if (k3 != null) {
                    return;
                }
            }
            this.nextEntry = null;
            this.nextKey = null;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            if (this.nextKey != null) {
                return true;
            }
            return false;
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

        EntryIterator(Iterator<Map.Entry<WeakKey<K>, V>> it) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AbstractWeakConcurrentMap.this, (Object) it);
            } else {
                this.iterator = it;
                findNext();
            }
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Map.Entry) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            K k3 = this.nextKey;
            if (k3 != null) {
                try {
                    return new SimpleEntry(AbstractWeakConcurrentMap.this, k3, this.nextEntry, null);
                } finally {
                    findNext();
                }
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class SimpleEntry implements Map.Entry<K, V> {
        static IPatchRedirector $redirector_;
        final Map.Entry<WeakKey<K>, V> entry;
        private final K key;

        /* synthetic */ SimpleEntry(AbstractWeakConcurrentMap abstractWeakConcurrentMap, Object obj, Map.Entry entry, AnonymousClass1 anonymousClass1) {
            this(obj, entry);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, this, abstractWeakConcurrentMap, obj, entry, anonymousClass1);
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (K) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this.key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (V) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.entry.getValue();
        }

        @Override // java.util.Map.Entry
        public V setValue(V v3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) v3);
            }
            v3.getClass();
            return this.entry.setValue(v3);
        }

        SimpleEntry(K k3, Map.Entry<WeakKey<K>, V> entry) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, AbstractWeakConcurrentMap.this, k3, entry);
            } else {
                this.key = k3;
                this.entry = entry;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class WeakKey<K> extends WeakReference<K> {
        static IPatchRedirector $redirector_;
        private final int hashCode;

        WeakKey(K k3, ReferenceQueue<? super K> referenceQueue) {
            super(k3, referenceQueue);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) k3, (Object) referenceQueue);
            } else {
                this.hashCode = System.identityHashCode(k3);
            }
        }

        public boolean equals(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
            }
            if (obj instanceof WeakKey) {
                if (((WeakKey) obj).get() == get()) {
                    return true;
                }
                return false;
            }
            return obj.equals(this);
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.hashCode;
        }

        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return String.valueOf(get());
        }
    }

    protected AbstractWeakConcurrentMap() {
        this(new ConcurrentHashMap());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public int approximateSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.target.size();
    }

    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.target.clear();
        }
    }

    public boolean containsKey(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) k3)).booleanValue();
        }
        k3.getClass();
        L lookupKey = getLookupKey(k3);
        try {
            return this.target.containsKey(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    protected V defaultValue(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (V) iPatchRedirector.redirect((short) 11, (Object) this, (Object) k3);
        }
        return null;
    }

    public void expungeStaleEntries() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        while (true) {
            Reference<? extends K> poll = poll();
            if (poll != null) {
                this.target.remove(poll);
            } else {
                return;
            }
        }
    }

    public V get(K k3) {
        V putIfAbsent;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (V) iPatchRedirector.redirect((short) 3, (Object) this, (Object) k3);
        }
        k3.getClass();
        L lookupKey = getLookupKey(k3);
        try {
            V v3 = this.target.get(lookupKey);
            if (v3 == null) {
                V defaultValue = defaultValue(k3);
                if (defaultValue != null && (putIfAbsent = this.target.putIfAbsent(new WeakKey<>(k3, this), defaultValue)) != null) {
                    return putIfAbsent;
                }
                return defaultValue;
            }
            return v3;
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    public V getIfPresent(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (V) iPatchRedirector.redirect((short) 4, (Object) this, (Object) k3);
        }
        k3.getClass();
        L lookupKey = getLookupKey(k3);
        try {
            return this.target.get(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    protected abstract L getLookupKey(K k3);

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Iterator) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return new EntryIterator(this, this.target.entrySet().iterator(), null);
    }

    public V put(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (V) iPatchRedirector.redirect((short) 6, (Object) this, (Object) k3, (Object) v3);
        }
        if (k3 != null && v3 != null) {
            return this.target.put(new WeakKey<>(k3, this), v3);
        }
        throw null;
    }

    public V putIfAbsent(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (V) iPatchRedirector.redirect((short) 7, (Object) this, (Object) k3, (Object) v3);
        }
        if (k3 != null && v3 != null) {
            L lookupKey = getLookupKey(k3);
            try {
                V v16 = this.target.get(lookupKey);
                if (v16 == null) {
                    return this.target.putIfAbsent(new WeakKey<>(k3, this), v3);
                }
                return v16;
            } finally {
                resetLookupKey(lookupKey);
            }
        }
        throw null;
    }

    public V putIfProbablyAbsent(K k3, V v3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (V) iPatchRedirector.redirect((short) 8, (Object) this, (Object) k3, (Object) v3);
        }
        if (k3 != null && v3 != null) {
            return this.target.putIfAbsent(new WeakKey<>(k3, this), v3);
        }
        throw null;
    }

    public V remove(K k3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (V) iPatchRedirector.redirect((short) 9, (Object) this, (Object) k3);
        }
        k3.getClass();
        L lookupKey = getLookupKey(k3);
        try {
            return this.target.remove(lookupKey);
        } finally {
            resetLookupKey(lookupKey);
        }
    }

    protected abstract void resetLookupKey(L l3);

    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        while (!Thread.interrupted()) {
            try {
                this.target.remove(remove());
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (String) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.target.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractWeakConcurrentMap(ConcurrentMap<WeakKey<K>, V> concurrentMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.target = concurrentMap;
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) concurrentMap);
        }
    }
}

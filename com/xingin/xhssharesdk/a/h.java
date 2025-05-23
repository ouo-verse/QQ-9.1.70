package com.xingin.xhssharesdk.a;

import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class h extends i {

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: d, reason: collision with root package name */
        public final Map.Entry<K, h> f389923d;

        public a(Map.Entry<K, h> entry) {
            this.f389923d = entry;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            return this.f389923d.getKey();
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            h value = this.f389923d.getValue();
            if (value == null) {
                return null;
            }
            return value.a();
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            if (obj instanceof l) {
                h value = this.f389923d.getValue();
                l lVar = value.f389925a;
                value.f389926b = null;
                value.f389925a = (l) obj;
                return lVar;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: d, reason: collision with root package name */
        public final Iterator<Map.Entry<K, Object>> f389924d;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.f389924d = it;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f389924d.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Map.Entry<K, Object> next = this.f389924d.next();
            if (next.getValue() instanceof h) {
                return new a(next);
            }
            return next;
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f389924d.remove();
        }
    }

    public final l a() {
        if (this.f389925a == null) {
            synchronized (this) {
                if (this.f389925a == null) {
                    try {
                        this.f389925a = null;
                        this.f389926b = e.f389907b;
                    } catch (m unused) {
                        this.f389925a = null;
                        this.f389926b = e.f389907b;
                    }
                }
            }
        }
        return this.f389925a;
    }

    public final boolean equals(Object obj) {
        return a().equals(obj);
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a().toString();
    }
}

package com.google.protobuf;

import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ae extends af {

    /* renamed from: f, reason: collision with root package name */
    private final au f35647f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<K> implements Map.Entry<K, Object> {

        /* renamed from: d, reason: collision with root package name */
        private Map.Entry<K, ae> f35648d;

        public ae a() {
            return this.f35648d.getValue();
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f35648d.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            ae value = this.f35648d.getValue();
            if (value == null) {
                return null;
            }
            return value.g();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (obj instanceof au) {
                return this.f35648d.getValue().e((au) obj);
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }

        b(Map.Entry<K, ae> entry) {
            this.f35648d = entry;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: d, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f35649d;

        public c(Iterator<Map.Entry<K, Object>> it) {
            this.f35649d = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, Object> next() {
            Map.Entry<K, Object> next = this.f35649d.next();
            if (next.getValue() instanceof ae) {
                return new b(next);
            }
            return next;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f35649d.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f35649d.remove();
        }
    }

    public ae(au auVar, t tVar, ByteString byteString) {
        super(tVar, byteString);
        this.f35647f = auVar;
    }

    @Override // com.google.protobuf.af
    public boolean equals(Object obj) {
        return g().equals(obj);
    }

    public au g() {
        return d(this.f35647f);
    }

    @Override // com.google.protobuf.af
    public int hashCode() {
        return g().hashCode();
    }

    public String toString() {
        return g().toString();
    }
}

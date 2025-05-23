package com.tencent.mtt.hippy.runtime.builtins;

import android.util.Pair;
import androidx.annotation.NonNull;
import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e extends i {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, Object> f337622a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private Set<Pair<String, Object>> f337623b;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private static final class a implements Iterator<Pair<String, Object>> {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<Map.Entry<String, Object>> f337624a;

        a(Iterator<Map.Entry<String, Object>> it) {
            this.f337624a = it;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Pair<String, Object> next() {
            Map.Entry<String, Object> next = this.f337624a.next();
            return new Pair<>(next.getKey(), next.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f337624a.hasNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static final class b extends AbstractSet<Pair<String, Object>> {

        /* renamed from: a, reason: collision with root package name */
        private final e f337625a;

        b(e eVar) {
            this.f337625a = eVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Pair<String, Object>> iterator() {
            return new a(this.f337625a.f337622a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f337625a.h();
        }
    }

    public static int a(e eVar) {
        return eVar.f337622a.size();
    }

    public static Set<Pair<String, Object>> b(e eVar) {
        return new b(eVar);
    }

    @Override // 
    @NonNull
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e clone() throws CloneNotSupportedException {
        e eVar = (e) super.clone();
        for (Pair<String, Object> pair : i()) {
            eVar.a((String) pair.first, i.b(pair.second));
        }
        return eVar;
    }

    public int h() {
        return this.f337622a.size();
    }

    public Set<Pair<String, Object>> i() {
        Set<Pair<String, Object>> set = this.f337623b;
        if (set == null) {
            b bVar = new b(this);
            this.f337623b = bVar;
            return bVar;
        }
        return set;
    }

    public Object a(String str) {
        return this.f337622a.get(str);
    }

    public boolean b(String str) {
        return this.f337622a.containsKey(str);
    }

    public Object a(String str, Object obj) {
        return this.f337622a.put(str, obj);
    }
}

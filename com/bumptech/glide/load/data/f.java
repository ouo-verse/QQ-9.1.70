package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.data.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static final e.a<?> f31575b = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, e.a<?>> f31576a = new HashMap();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements e.a<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.e.a
        @NonNull
        public e<Object> build(@NonNull Object obj) {
            return new b(obj);
        }
    }

    @NonNull
    public synchronized <T> e<T> a(@NonNull T t16) {
        e.a<?> aVar;
        h0.j.d(t16);
        aVar = this.f31576a.get(t16.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it = this.f31576a.values().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                e.a<?> next = it.next();
                if (next.a().isAssignableFrom(t16.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f31575b;
        }
        return (e<T>) aVar.build(t16);
    }

    public synchronized void b(@NonNull e.a<?> aVar) {
        this.f31576a.put(aVar.a(), aVar);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class b implements e<Object> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f31577a;

        b(@NonNull Object obj) {
            this.f31577a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        @NonNull
        public Object a() {
            return this.f31577a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void cleanup() {
        }
    }
}

package com.bumptech.glide;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, Object> f31486a;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Map<Class<?>, Object> f31487a = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        public e b() {
            return new e(this);
        }
    }

    e(a aVar) {
        this.f31486a = Collections.unmodifiableMap(new HashMap(aVar.f31487a));
    }

    public boolean a(Class<Object> cls) {
        return this.f31486a.containsKey(cls);
    }
}

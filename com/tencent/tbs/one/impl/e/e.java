package com.tencent.tbs.one.impl.e;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class e<T> {

    /* renamed from: a, reason: collision with root package name */
    public a f375020a;

    /* renamed from: b, reason: collision with root package name */
    public T f375021b;

    /* renamed from: c, reason: collision with root package name */
    public Object f375022c;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum a {
        EXISTING,
        BUILTIN,
        BUILTIN_ASSETS,
        LOCAL,
        ONLINE,
        EXTENSION,
        LOCAL_FILE,
        LEGACY_LOCAL_FILE,
        SHARING,
        LEGACY_SHARING
    }

    public static <T> e<T> a(a aVar, T t16) {
        e<T> eVar = new e<>();
        eVar.f375020a = aVar;
        eVar.f375021b = t16;
        return eVar;
    }
}

package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: b, reason: collision with root package name */
    private final ArrayMap<d<?>, Object> f31595b = new h0.b();

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void f(@NonNull d<T> dVar, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        dVar.g(obj, messageDigest);
    }

    @Override // com.bumptech.glide.load.c
    public void b(@NonNull MessageDigest messageDigest) {
        for (int i3 = 0; i3 < this.f31595b.size(); i3++) {
            f(this.f31595b.keyAt(i3), this.f31595b.valueAt(i3), messageDigest);
        }
    }

    @Nullable
    public <T> T c(@NonNull d<T> dVar) {
        if (this.f31595b.containsKey(dVar)) {
            return (T) this.f31595b.get(dVar);
        }
        return dVar.c();
    }

    public void d(@NonNull e eVar) {
        this.f31595b.putAll((SimpleArrayMap<? extends d<?>, ? extends Object>) eVar.f31595b);
    }

    @NonNull
    public <T> e e(@NonNull d<T> dVar, @NonNull T t16) {
        this.f31595b.put(dVar, t16);
        return this;
    }

    @Override // com.bumptech.glide.load.c
    public boolean equals(Object obj) {
        if (obj instanceof e) {
            return this.f31595b.equals(((e) obj).f31595b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.c
    public int hashCode() {
        return this.f31595b.hashCode();
    }

    public String toString() {
        return "Options{values=" + this.f31595b + '}';
    }
}

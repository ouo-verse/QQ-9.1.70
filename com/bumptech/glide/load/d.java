package com.bumptech.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import h0.j;
import java.security.MessageDigest;

/* compiled from: P */
/* loaded from: classes.dex */
public final class d<T> {

    /* renamed from: e, reason: collision with root package name */
    private static final b<Object> f31561e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final T f31562a;

    /* renamed from: b, reason: collision with root package name */
    private final b<T> f31563b;

    /* renamed from: c, reason: collision with root package name */
    private final String f31564c;

    /* renamed from: d, reason: collision with root package name */
    private volatile byte[] f31565d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(@NonNull byte[] bArr, @NonNull T t16, @NonNull MessageDigest messageDigest);
    }

    d(@NonNull String str, @Nullable T t16, @NonNull b<T> bVar) {
        this.f31564c = j.b(str);
        this.f31562a = t16;
        this.f31563b = (b) j.d(bVar);
    }

    @NonNull
    public static <T> d<T> a(@NonNull String str, @Nullable T t16, @NonNull b<T> bVar) {
        return new d<>(str, t16, bVar);
    }

    @NonNull
    private static <T> b<T> b() {
        return (b<T>) f31561e;
    }

    @NonNull
    private byte[] d() {
        if (this.f31565d == null) {
            this.f31565d = this.f31564c.getBytes(c.f31560a);
        }
        return this.f31565d;
    }

    @NonNull
    public static <T> d<T> e(@NonNull String str) {
        return new d<>(str, null, b());
    }

    @NonNull
    public static <T> d<T> f(@NonNull String str, @NonNull T t16) {
        return new d<>(str, t16, b());
    }

    @Nullable
    public T c() {
        return this.f31562a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f31564c.equals(((d) obj).f31564c);
        }
        return false;
    }

    public void g(@NonNull T t16, @NonNull MessageDigest messageDigest) {
        this.f31563b.a(d(), t16, messageDigest);
    }

    public int hashCode() {
        return this.f31564c.hashCode();
    }

    public String toString() {
        return "Option{key='" + this.f31564c + "'}";
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements b<Object> {
        a() {
        }

        @Override // com.bumptech.glide.load.d.b
        public void a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    }
}

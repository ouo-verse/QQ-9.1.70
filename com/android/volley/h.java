package com.android.volley;

import androidx.annotation.Nullable;
import com.android.volley.c;

/* compiled from: P */
/* loaded from: classes.dex */
public class h<T> {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final T f31337a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final c.a f31338b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final VolleyError f31339c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f31340d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface a {
        void onErrorResponse(VolleyError volleyError);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface b<T> {
        void onResponse(T t16);
    }

    h(@Nullable T t16, @Nullable c.a aVar) {
        this.f31340d = false;
        this.f31337a = t16;
        this.f31338b = aVar;
        this.f31339c = null;
    }

    public static <T> h<T> a(VolleyError volleyError) {
        return new h<>(volleyError);
    }

    public static <T> h<T> c(@Nullable T t16, @Nullable c.a aVar) {
        return new h<>(t16, aVar);
    }

    public boolean b() {
        if (this.f31339c == null) {
            return true;
        }
        return false;
    }

    h(VolleyError volleyError) {
        this.f31340d = false;
        this.f31337a = null;
        this.f31338b = null;
        this.f31339c = volleyError;
    }
}

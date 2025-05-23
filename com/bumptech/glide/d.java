package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.b;
import com.bumptech.glide.load.engine.h;
import e0.i;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    @VisibleForTesting
    static final g<?, ?> f31475k = new a();

    /* renamed from: a, reason: collision with root package name */
    private final r.b f31476a;

    /* renamed from: b, reason: collision with root package name */
    private final Registry f31477b;

    /* renamed from: c, reason: collision with root package name */
    private final e0.f f31478c;

    /* renamed from: d, reason: collision with root package name */
    private final b.a f31479d;

    /* renamed from: e, reason: collision with root package name */
    private final List<com.bumptech.glide.request.d<Object>> f31480e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, g<?, ?>> f31481f;

    /* renamed from: g, reason: collision with root package name */
    private final h f31482g;

    /* renamed from: h, reason: collision with root package name */
    private final e f31483h;

    /* renamed from: i, reason: collision with root package name */
    private final int f31484i;

    /* renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy("this")
    private com.bumptech.glide.request.e f31485j;

    public d(@NonNull Context context, @NonNull r.b bVar, @NonNull Registry registry, @NonNull e0.f fVar, @NonNull b.a aVar, @NonNull Map<Class<?>, g<?, ?>> map, @NonNull List<com.bumptech.glide.request.d<Object>> list, @NonNull h hVar, @NonNull e eVar, int i3) {
        super(context.getApplicationContext());
        this.f31476a = bVar;
        this.f31477b = registry;
        this.f31478c = fVar;
        this.f31479d = aVar;
        this.f31480e = list;
        this.f31481f = map;
        this.f31482g = hVar;
        this.f31483h = eVar;
        this.f31484i = i3;
    }

    @NonNull
    public <X> i<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f31478c.a(imageView, cls);
    }

    @NonNull
    public r.b b() {
        return this.f31476a;
    }

    public List<com.bumptech.glide.request.d<Object>> c() {
        return this.f31480e;
    }

    public synchronized com.bumptech.glide.request.e d() {
        if (this.f31485j == null) {
            this.f31485j = this.f31479d.build().K();
        }
        return this.f31485j;
    }

    @NonNull
    public <T> g<?, T> e(@NonNull Class<T> cls) {
        g<?, T> gVar = (g) this.f31481f.get(cls);
        if (gVar == null) {
            for (Map.Entry<Class<?>, g<?, ?>> entry : this.f31481f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    gVar = (g) entry.getValue();
                }
            }
        }
        if (gVar == null) {
            return (g<?, T>) f31475k;
        }
        return gVar;
    }

    @NonNull
    public h f() {
        return this.f31482g;
    }

    public e g() {
        return this.f31483h;
    }

    public int h() {
        return this.f31484i;
    }

    @NonNull
    public Registry i() {
        return this.f31477b;
    }
}

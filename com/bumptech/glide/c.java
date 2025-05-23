package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.b;
import com.bumptech.glide.e;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.manager.i;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import r.k;
import s.a;
import s.i;

/* compiled from: P */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    private h f31459c;

    /* renamed from: d, reason: collision with root package name */
    private r.d f31460d;

    /* renamed from: e, reason: collision with root package name */
    private r.b f31461e;

    /* renamed from: f, reason: collision with root package name */
    private s.h f31462f;

    /* renamed from: g, reason: collision with root package name */
    private GlideExecutor f31463g;

    /* renamed from: h, reason: collision with root package name */
    private GlideExecutor f31464h;

    /* renamed from: i, reason: collision with root package name */
    private a.InterfaceC11197a f31465i;

    /* renamed from: j, reason: collision with root package name */
    private i f31466j;

    /* renamed from: k, reason: collision with root package name */
    private b0.b f31467k;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    private i.b f31470n;

    /* renamed from: o, reason: collision with root package name */
    private GlideExecutor f31471o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f31472p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    private List<com.bumptech.glide.request.d<Object>> f31473q;

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<?>, g<?, ?>> f31457a = new ArrayMap();

    /* renamed from: b, reason: collision with root package name */
    private final e.a f31458b = new e.a();

    /* renamed from: l, reason: collision with root package name */
    private int f31468l = 4;

    /* renamed from: m, reason: collision with root package name */
    private b.a f31469m = new a();

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements b.a {
        a() {
        }

        @Override // com.bumptech.glide.b.a
        @NonNull
        public com.bumptech.glide.request.e build() {
            return new com.bumptech.glide.request.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class b {
        b() {
        }
    }

    /* compiled from: P */
    /* renamed from: com.bumptech.glide.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0213c {
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class d {
        d() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public com.bumptech.glide.b a(@NonNull Context context) {
        if (this.f31463g == null) {
            this.f31463g = GlideExecutor.i();
        }
        if (this.f31464h == null) {
            this.f31464h = GlideExecutor.g();
        }
        if (this.f31471o == null) {
            this.f31471o = GlideExecutor.c();
        }
        if (this.f31466j == null) {
            this.f31466j = new i.a(context).a();
        }
        if (this.f31467k == null) {
            this.f31467k = new b0.d();
        }
        if (this.f31460d == null) {
            int b16 = this.f31466j.b();
            if (b16 > 0) {
                this.f31460d = new k(b16);
            } else {
                this.f31460d = new r.e();
            }
        }
        if (this.f31461e == null) {
            this.f31461e = new r.i(this.f31466j.a());
        }
        if (this.f31462f == null) {
            this.f31462f = new s.g(this.f31466j.d());
        }
        if (this.f31465i == null) {
            this.f31465i = new s.f(context);
        }
        if (this.f31459c == null) {
            this.f31459c = new h(this.f31462f, this.f31465i, this.f31464h, this.f31463g, GlideExecutor.j(), this.f31471o, this.f31472p);
        }
        List<com.bumptech.glide.request.d<Object>> list = this.f31473q;
        if (list == null) {
            this.f31473q = Collections.emptyList();
        } else {
            this.f31473q = Collections.unmodifiableList(list);
        }
        e b17 = this.f31458b.b();
        return new com.bumptech.glide.b(context, this.f31459c, this.f31462f, this.f31460d, this.f31461e, new com.bumptech.glide.manager.i(this.f31470n, b17), this.f31467k, this.f31468l, this.f31469m, this.f31457a, this.f31473q, b17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(@Nullable i.b bVar) {
        this.f31470n = bVar;
    }
}

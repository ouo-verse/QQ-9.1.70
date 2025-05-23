package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.d;
import java.util.Collections;
import java.util.List;
import t.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class u implements d, d.a {
    private b C;

    /* renamed from: d, reason: collision with root package name */
    private final e<?> f31771d;

    /* renamed from: e, reason: collision with root package name */
    private final d.a f31772e;

    /* renamed from: f, reason: collision with root package name */
    private int f31773f;

    /* renamed from: h, reason: collision with root package name */
    private com.bumptech.glide.load.engine.a f31774h;

    /* renamed from: i, reason: collision with root package name */
    private Object f31775i;

    /* renamed from: m, reason: collision with root package name */
    private volatile n.a<?> f31776m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements d.a<Object> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n.a f31777d;

        a(n.a aVar) {
            this.f31777d = aVar;
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void c(@NonNull Exception exc) {
            if (u.this.f(this.f31777d)) {
                u.this.h(this.f31777d, exc);
            }
        }

        @Override // com.bumptech.glide.load.data.d.a
        public void d(@Nullable Object obj) {
            if (u.this.f(this.f31777d)) {
                u.this.g(this.f31777d, obj);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(e<?> eVar, d.a aVar) {
        this.f31771d = eVar;
        this.f31772e = aVar;
    }

    private void b(Object obj) {
        long b16 = h0.f.b();
        try {
            com.bumptech.glide.load.a<X> p16 = this.f31771d.p(obj);
            c cVar = new c(p16, obj, this.f31771d.k());
            this.C = new b(this.f31776m.f435123a, this.f31771d.o());
            this.f31771d.d().a(this.C, cVar);
            if (Log.isLoggable("SourceGenerator", 2)) {
                Log.v("SourceGenerator", "Finished encoding source to cache, key: " + this.C + ", data: " + obj + ", encoder: " + p16 + ", duration: " + h0.f.a(b16));
            }
            this.f31776m.f435125c.cleanup();
            this.f31774h = new com.bumptech.glide.load.engine.a(Collections.singletonList(this.f31776m.f435123a), this.f31771d, this);
        } catch (Throwable th5) {
            this.f31776m.f435125c.cleanup();
            throw th5;
        }
    }

    private boolean e() {
        if (this.f31773f < this.f31771d.g().size()) {
            return true;
        }
        return false;
    }

    private void j(n.a<?> aVar) {
        this.f31776m.f435125c.b(this.f31771d.l(), new a(aVar));
    }

    @Override // com.bumptech.glide.load.engine.d
    public boolean a() {
        Object obj = this.f31775i;
        if (obj != null) {
            this.f31775i = null;
            b(obj);
        }
        com.bumptech.glide.load.engine.a aVar = this.f31774h;
        if (aVar != null && aVar.a()) {
            return true;
        }
        this.f31774h = null;
        this.f31776m = null;
        boolean z16 = false;
        while (!z16 && e()) {
            List<n.a<?>> g16 = this.f31771d.g();
            int i3 = this.f31773f;
            this.f31773f = i3 + 1;
            this.f31776m = g16.get(i3);
            if (this.f31776m != null && (this.f31771d.e().c(this.f31776m.f435125c.getDataSource()) || this.f31771d.t(this.f31776m.f435125c.a()))) {
                j(this.f31776m);
                z16 = true;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.load.engine.d.a
    public void c(com.bumptech.glide.load.c cVar, Object obj, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource, com.bumptech.glide.load.c cVar2) {
        this.f31772e.c(cVar, obj, dVar, this.f31776m.f435125c.getDataSource(), cVar);
    }

    @Override // com.bumptech.glide.load.engine.d
    public void cancel() {
        n.a<?> aVar = this.f31776m;
        if (aVar != null) {
            aVar.f435125c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.engine.d.a
    public void d(com.bumptech.glide.load.c cVar, Exception exc, com.bumptech.glide.load.data.d<?> dVar, DataSource dataSource) {
        this.f31772e.d(cVar, exc, dVar, this.f31776m.f435125c.getDataSource());
    }

    boolean f(n.a<?> aVar) {
        n.a<?> aVar2 = this.f31776m;
        if (aVar2 != null && aVar2 == aVar) {
            return true;
        }
        return false;
    }

    void g(n.a<?> aVar, Object obj) {
        g e16 = this.f31771d.e();
        if (obj != null && e16.c(aVar.f435125c.getDataSource())) {
            this.f31775i = obj;
            this.f31772e.i();
        } else {
            d.a aVar2 = this.f31772e;
            com.bumptech.glide.load.c cVar = aVar.f435123a;
            com.bumptech.glide.load.data.d<?> dVar = aVar.f435125c;
            aVar2.c(cVar, obj, dVar, dVar.getDataSource(), this.C);
        }
    }

    void h(n.a<?> aVar, @NonNull Exception exc) {
        d.a aVar2 = this.f31772e;
        b bVar = this.C;
        com.bumptech.glide.load.data.d<?> dVar = aVar.f435125c;
        aVar2.d(bVar, exc, dVar, dVar.getDataSource());
    }

    @Override // com.bumptech.glide.load.engine.d.a
    public void i() {
        throw new UnsupportedOperationException();
    }
}

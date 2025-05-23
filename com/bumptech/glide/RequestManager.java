package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b0.a;
import b0.i;
import b0.j;
import b0.k;
import e0.h;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes.dex */
public class RequestManager implements ComponentCallbacks2, b0.f {
    private static final com.bumptech.glide.request.e H = com.bumptech.glide.request.e.e0(Bitmap.class).K();
    private static final com.bumptech.glide.request.e I = com.bumptech.glide.request.e.e0(z.c.class).K();
    private static final com.bumptech.glide.request.e J = com.bumptech.glide.request.e.f0(com.bumptech.glide.load.engine.g.f31694c).R(Priority.LOW).Y(true);
    private final Runnable C;
    private final b0.a D;
    private final CopyOnWriteArrayList<com.bumptech.glide.request.d<Object>> E;

    @GuardedBy("this")
    private com.bumptech.glide.request.e F;
    private boolean G;

    /* renamed from: d, reason: collision with root package name */
    protected final b f31443d;

    /* renamed from: e, reason: collision with root package name */
    protected final Context f31444e;

    /* renamed from: f, reason: collision with root package name */
    final b0.e f31445f;

    /* renamed from: h, reason: collision with root package name */
    @GuardedBy("this")
    private final j f31446h;

    /* renamed from: i, reason: collision with root package name */
    @GuardedBy("this")
    private final i f31447i;

    /* renamed from: m, reason: collision with root package name */
    @GuardedBy("this")
    private final k f31448m;

    /* compiled from: P */
    /* loaded from: classes.dex */
    private class a implements a.InterfaceC0081a {

        /* renamed from: a, reason: collision with root package name */
        @GuardedBy("RequestManager.this")
        private final j f31449a;

        a(@NonNull j jVar) {
            this.f31449a = jVar;
        }

        @Override // b0.a.InterfaceC0081a
        public void a(boolean z16) {
            if (z16) {
                synchronized (RequestManager.this) {
                    this.f31449a.e();
                }
            }
        }
    }

    public RequestManager(@NonNull b bVar, @NonNull b0.e eVar, @NonNull i iVar, @NonNull Context context) {
        this(bVar, eVar, iVar, new j(), bVar.g(), context);
    }

    private void x(@NonNull h<?> hVar) {
        boolean w3 = w(hVar);
        com.bumptech.glide.request.c request = hVar.getRequest();
        if (!w3 && !this.f31443d.p(hVar) && request != null) {
            hVar.h(null);
            request.clear();
        }
    }

    @NonNull
    @CheckResult
    public <ResourceType> f<ResourceType> d(@NonNull Class<ResourceType> cls) {
        return new f<>(this.f31443d, this, cls, this.f31444e);
    }

    @NonNull
    @CheckResult
    public f<Bitmap> i() {
        return d(Bitmap.class).a(H);
    }

    @NonNull
    @CheckResult
    public f<Drawable> j() {
        return d(Drawable.class);
    }

    public void k(@Nullable h<?> hVar) {
        if (hVar == null) {
            return;
        }
        x(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<com.bumptech.glide.request.d<Object>> l() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized com.bumptech.glide.request.e m() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public <T> g<?, T> n(Class<T> cls) {
        return this.f31443d.i().e(cls);
    }

    @NonNull
    @CheckResult
    public f<Drawable> o(@Nullable File file) {
        return j().r0(file);
    }

    @Override // b0.f
    public synchronized void onDestroy() {
        this.f31448m.onDestroy();
        Iterator<h<?>> it = this.f31448m.i().iterator();
        while (it.hasNext()) {
            k(it.next());
        }
        this.f31448m.d();
        this.f31446h.b();
        this.f31445f.a(this);
        this.f31445f.a(this.D);
        h0.k.u(this.C);
        this.f31443d.s(this);
    }

    @Override // b0.f
    public synchronized void onStart() {
        t();
        this.f31448m.onStart();
    }

    @Override // b0.f
    public synchronized void onStop() {
        s();
        this.f31448m.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        if (i3 == 60 && this.G) {
            r();
        }
    }

    @NonNull
    @CheckResult
    public f<Drawable> p(@Nullable String str) {
        return j().t0(str);
    }

    public synchronized void q() {
        this.f31446h.c();
    }

    public synchronized void r() {
        q();
        Iterator<RequestManager> it = this.f31447i.a().iterator();
        while (it.hasNext()) {
            it.next().q();
        }
    }

    public synchronized void s() {
        this.f31446h.d();
    }

    public synchronized void t() {
        this.f31446h.f();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.f31446h + ", treeNode=" + this.f31447i + "}";
    }

    protected synchronized void u(@NonNull com.bumptech.glide.request.e eVar) {
        this.F = eVar.clone().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void v(@NonNull h<?> hVar, @NonNull com.bumptech.glide.request.c cVar) {
        this.f31448m.j(hVar);
        this.f31446h.g(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean w(@NonNull h<?> hVar) {
        com.bumptech.glide.request.c request = hVar.getRequest();
        if (request == null) {
            return true;
        }
        if (this.f31446h.a(request)) {
            this.f31448m.k(hVar);
            hVar.h(null);
            return true;
        }
        return false;
    }

    RequestManager(b bVar, b0.e eVar, i iVar, j jVar, b0.b bVar2, Context context) {
        this.f31448m = new k();
        Runnable runnable = new Runnable() { // from class: com.bumptech.glide.RequestManager.1
            @Override // java.lang.Runnable
            public void run() {
                RequestManager requestManager = RequestManager.this;
                requestManager.f31445f.b(requestManager);
            }
        };
        this.C = runnable;
        this.f31443d = bVar;
        this.f31445f = eVar;
        this.f31447i = iVar;
        this.f31446h = jVar;
        this.f31444e = context;
        b0.a a16 = bVar2.a(context.getApplicationContext(), new a(jVar));
        this.D = a16;
        if (h0.k.p()) {
            h0.k.t(runnable);
        } else {
            eVar.b(this);
        }
        eVar.b(a16);
        this.E = new CopyOnWriteArrayList<>(bVar.i().c());
        u(bVar.i().d());
        bVar.o(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }
}

package com.bumptech.glide.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.c;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.h;
import com.bumptech.glide.load.engine.q;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import e0.h;
import h0.k;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes.dex */
public final class SingleRequest<R> implements c, e0.g, f {
    private static final boolean D = Log.isLoggable("Request", 2);

    @GuardedBy("requestLock")
    private int A;

    @GuardedBy("requestLock")
    private boolean B;

    @Nullable
    private RuntimeException C;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f31891a;

    /* renamed from: b, reason: collision with root package name */
    private final i0.c f31892b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f31893c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private final d<R> f31894d;

    /* renamed from: e, reason: collision with root package name */
    private final RequestCoordinator f31895e;

    /* renamed from: f, reason: collision with root package name */
    private final Context f31896f;

    /* renamed from: g, reason: collision with root package name */
    private final com.bumptech.glide.d f31897g;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private final Object f31898h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<R> f31899i;

    /* renamed from: j, reason: collision with root package name */
    private final a<?> f31900j;

    /* renamed from: k, reason: collision with root package name */
    private final int f31901k;

    /* renamed from: l, reason: collision with root package name */
    private final int f31902l;

    /* renamed from: m, reason: collision with root package name */
    private final Priority f31903m;

    /* renamed from: n, reason: collision with root package name */
    private final h<R> f31904n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    private final List<d<R>> f31905o;

    /* renamed from: p, reason: collision with root package name */
    private final f0.e<? super R> f31906p;

    /* renamed from: q, reason: collision with root package name */
    private final Executor f31907q;

    /* renamed from: r, reason: collision with root package name */
    @GuardedBy("requestLock")
    private q<R> f31908r;

    /* renamed from: s, reason: collision with root package name */
    @GuardedBy("requestLock")
    private h.d f31909s;

    /* renamed from: t, reason: collision with root package name */
    @GuardedBy("requestLock")
    private long f31910t;

    /* renamed from: u, reason: collision with root package name */
    private volatile com.bumptech.glide.load.engine.h f31911u;

    /* renamed from: v, reason: collision with root package name */
    @GuardedBy("requestLock")
    private Status f31912v;

    /* renamed from: w, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f31913w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f31914x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    @GuardedBy("requestLock")
    private Drawable f31915y;

    /* renamed from: z, reason: collision with root package name */
    @GuardedBy("requestLock")
    private int f31916z;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    SingleRequest(Context context, com.bumptech.glide.d dVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, a<?> aVar, int i3, int i16, Priority priority, e0.h<R> hVar, @Nullable d<R> dVar2, @Nullable List<d<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.h hVar2, f0.e<? super R> eVar, Executor executor) {
        this.f31891a = D ? String.valueOf(super.hashCode()) : null;
        this.f31892b = i0.c.a();
        this.f31893c = obj;
        this.f31896f = context;
        this.f31897g = dVar;
        this.f31898h = obj2;
        this.f31899i = cls;
        this.f31900j = aVar;
        this.f31901k = i3;
        this.f31902l = i16;
        this.f31903m = priority;
        this.f31904n = hVar;
        this.f31894d = dVar2;
        this.f31905o = list;
        this.f31895e = requestCoordinator;
        this.f31911u = hVar2;
        this.f31906p = eVar;
        this.f31907q = executor;
        this.f31912v = Status.PENDING;
        if (this.C == null && dVar.g().a(c.C0213c.class)) {
            this.C = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    private void d() {
        if (!this.B) {
        } else {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean e() {
        RequestCoordinator requestCoordinator = this.f31895e;
        if (requestCoordinator != null && !requestCoordinator.e(this)) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private boolean f() {
        RequestCoordinator requestCoordinator = this.f31895e;
        if (requestCoordinator != null && !requestCoordinator.d(this)) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private boolean g() {
        RequestCoordinator requestCoordinator = this.f31895e;
        if (requestCoordinator != null && !requestCoordinator.b(this)) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private void h() {
        d();
        this.f31892b.c();
        this.f31904n.c(this);
        h.d dVar = this.f31909s;
        if (dVar != null) {
            dVar.a();
            this.f31909s = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable i() {
        if (this.f31913w == null) {
            Drawable j3 = this.f31900j.j();
            this.f31913w = j3;
            if (j3 == null && this.f31900j.i() > 0) {
                this.f31913w = m(this.f31900j.i());
            }
        }
        return this.f31913w;
    }

    @GuardedBy("requestLock")
    private Drawable j() {
        if (this.f31915y == null) {
            Drawable k3 = this.f31900j.k();
            this.f31915y = k3;
            if (k3 == null && this.f31900j.l() > 0) {
                this.f31915y = m(this.f31900j.l());
            }
        }
        return this.f31915y;
    }

    @GuardedBy("requestLock")
    private Drawable k() {
        if (this.f31914x == null) {
            Drawable q16 = this.f31900j.q();
            this.f31914x = q16;
            if (q16 == null && this.f31900j.r() > 0) {
                this.f31914x = m(this.f31900j.r());
            }
        }
        return this.f31914x;
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.f31895e;
        if (requestCoordinator != null && requestCoordinator.getRoot().isAnyResourceSet()) {
            return false;
        }
        return true;
    }

    @GuardedBy("requestLock")
    private Drawable m(@DrawableRes int i3) {
        Resources.Theme theme;
        if (this.f31900j.w() != null) {
            theme = this.f31900j.w();
        } else {
            theme = this.f31896f.getTheme();
        }
        return x.a.a(this.f31897g, i3, theme);
    }

    private void n(String str) {
        Log.v("Request", str + " this: " + this.f31891a);
    }

    private static int o(int i3, float f16) {
        if (i3 != Integer.MIN_VALUE) {
            return Math.round(f16 * i3);
        }
        return i3;
    }

    @GuardedBy("requestLock")
    private void p() {
        RequestCoordinator requestCoordinator = this.f31895e;
        if (requestCoordinator != null) {
            requestCoordinator.f(this);
        }
    }

    @GuardedBy("requestLock")
    private void q() {
        RequestCoordinator requestCoordinator = this.f31895e;
        if (requestCoordinator != null) {
            requestCoordinator.a(this);
        }
    }

    public static <R> SingleRequest<R> r(Context context, com.bumptech.glide.d dVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i3, int i16, Priority priority, e0.h<R> hVar, d<R> dVar2, @Nullable List<d<R>> list, RequestCoordinator requestCoordinator, com.bumptech.glide.load.engine.h hVar2, f0.e<? super R> eVar, Executor executor) {
        return new SingleRequest<>(context, dVar, obj, obj2, cls, aVar, i3, i16, priority, hVar, dVar2, list, requestCoordinator, hVar2, eVar, executor);
    }

    private void s(GlideException glideException, int i3) {
        boolean z16;
        this.f31892b.c();
        synchronized (this.f31893c) {
            glideException.setOrigin(this.C);
            int h16 = this.f31897g.h();
            if (h16 <= i3) {
                Log.w("Glide", "Load failed for " + this.f31898h + " with size [" + this.f31916z + HippyTKDListViewAdapter.X + this.A + "]", glideException);
                if (h16 <= 4) {
                    glideException.logRootCauses("Glide");
                }
            }
            this.f31909s = null;
            this.f31912v = Status.FAILED;
            boolean z17 = true;
            this.B = true;
            try {
                List<d<R>> list = this.f31905o;
                if (list != null) {
                    Iterator<d<R>> it = list.iterator();
                    z16 = false;
                    while (it.hasNext()) {
                        z16 |= it.next().b(glideException, this.f31898h, this.f31904n, l());
                    }
                } else {
                    z16 = false;
                }
                d<R> dVar = this.f31894d;
                if (dVar == null || !dVar.b(glideException, this.f31898h, this.f31904n, l())) {
                    z17 = false;
                }
                if (!(z16 | z17)) {
                    u();
                }
                this.B = false;
                p();
            } catch (Throwable th5) {
                this.B = false;
                throw th5;
            }
        }
    }

    @GuardedBy("requestLock")
    private void t(q<R> qVar, R r16, DataSource dataSource, boolean z16) {
        boolean z17;
        boolean l3 = l();
        this.f31912v = Status.COMPLETE;
        this.f31908r = qVar;
        if (this.f31897g.h() <= 3) {
            Log.d("Glide", "Finished loading " + r16.getClass().getSimpleName() + " from " + dataSource + " for " + this.f31898h + " with size [" + this.f31916z + HippyTKDListViewAdapter.X + this.A + "] in " + h0.f.a(this.f31910t) + " ms");
        }
        boolean z18 = true;
        this.B = true;
        try {
            List<d<R>> list = this.f31905o;
            if (list != null) {
                Iterator<d<R>> it = list.iterator();
                z17 = false;
                while (it.hasNext()) {
                    z17 |= it.next().a(r16, this.f31898h, this.f31904n, dataSource, l3);
                }
            } else {
                z17 = false;
            }
            d<R> dVar = this.f31894d;
            if (dVar == null || !dVar.a(r16, this.f31898h, this.f31904n, dataSource, l3)) {
                z18 = false;
            }
            if (!(z18 | z17)) {
                this.f31904n.g(r16, this.f31906p.a(dataSource, l3));
            }
            this.B = false;
            q();
        } catch (Throwable th5) {
            this.B = false;
            throw th5;
        }
    }

    @GuardedBy("requestLock")
    private void u() {
        Drawable drawable;
        if (!f()) {
            return;
        }
        if (this.f31898h == null) {
            drawable = j();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = i();
        }
        if (drawable == null) {
            drawable = k();
        }
        this.f31904n.e(drawable);
    }

    @Override // com.bumptech.glide.request.f
    public void a(GlideException glideException) {
        s(glideException, 5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.request.f
    public void b(q<?> qVar, DataSource dataSource, boolean z16) {
        Object obj;
        String str;
        this.f31892b.c();
        q<?> qVar2 = null;
        try {
            synchronized (this.f31893c) {
                try {
                    this.f31909s = null;
                    if (qVar == null) {
                        a(new GlideException("Expected to receive a Resource<R> with an object of " + this.f31899i + " inside, but instead got null."));
                        return;
                    }
                    Object obj2 = qVar.get();
                    try {
                        if (obj2 != null && this.f31899i.isAssignableFrom(obj2.getClass())) {
                            if (!g()) {
                                this.f31908r = null;
                                this.f31912v = Status.COMPLETE;
                                this.f31911u.k(qVar);
                                return;
                            }
                            t(qVar, obj2, dataSource, z16);
                            return;
                        }
                        this.f31908r = null;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("Expected to receive an object of ");
                        sb5.append(this.f31899i);
                        sb5.append(" but instead got ");
                        if (obj2 != null) {
                            obj = obj2.getClass();
                        } else {
                            obj = "";
                        }
                        sb5.append(obj);
                        sb5.append("{");
                        sb5.append(obj2);
                        sb5.append("} inside Resource{");
                        sb5.append(qVar);
                        sb5.append("}.");
                        if (obj2 != null) {
                            str = "";
                        } else {
                            str = " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                        }
                        sb5.append(str);
                        a(new GlideException(sb5.toString()));
                        this.f31911u.k(qVar);
                    } catch (Throwable th5) {
                        qVar2 = qVar;
                        th = th5;
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            }
        } catch (Throwable th7) {
            if (qVar2 != null) {
                this.f31911u.k(qVar2);
            }
            throw th7;
        }
    }

    @Override // com.bumptech.glide.request.c
    public void begin() {
        int i3;
        synchronized (this.f31893c) {
            d();
            this.f31892b.c();
            this.f31910t = h0.f.b();
            if (this.f31898h == null) {
                if (k.s(this.f31901k, this.f31902l)) {
                    this.f31916z = this.f31901k;
                    this.A = this.f31902l;
                }
                if (j() == null) {
                    i3 = 5;
                } else {
                    i3 = 3;
                }
                s(new GlideException("Received null model"), i3);
                return;
            }
            Status status = this.f31912v;
            Status status2 = Status.RUNNING;
            if (status != status2) {
                if (status == Status.COMPLETE) {
                    b(this.f31908r, DataSource.MEMORY_CACHE, false);
                    return;
                }
                Status status3 = Status.WAITING_FOR_SIZE;
                this.f31912v = status3;
                if (k.s(this.f31901k, this.f31902l)) {
                    onSizeReady(this.f31901k, this.f31902l);
                } else {
                    this.f31904n.a(this);
                }
                Status status4 = this.f31912v;
                if ((status4 == status2 || status4 == status3) && f()) {
                    this.f31904n.f(k());
                }
                if (D) {
                    n("finished run method in " + h0.f.a(this.f31910t));
                }
                return;
            }
            throw new IllegalArgumentException("Cannot restart a running request");
        }
    }

    @Override // com.bumptech.glide.request.c
    public boolean c(c cVar) {
        int i3;
        int i16;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        Priority priority;
        int i17;
        int i18;
        int i19;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        Priority priority2;
        int i26;
        if (!(cVar instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.f31893c) {
            i3 = this.f31901k;
            i16 = this.f31902l;
            obj = this.f31898h;
            cls = this.f31899i;
            aVar = this.f31900j;
            priority = this.f31903m;
            List<d<R>> list = this.f31905o;
            if (list != null) {
                i17 = list.size();
            } else {
                i17 = 0;
            }
        }
        SingleRequest singleRequest = (SingleRequest) cVar;
        synchronized (singleRequest.f31893c) {
            i18 = singleRequest.f31901k;
            i19 = singleRequest.f31902l;
            obj2 = singleRequest.f31898h;
            cls2 = singleRequest.f31899i;
            aVar2 = singleRequest.f31900j;
            priority2 = singleRequest.f31903m;
            List<d<R>> list2 = singleRequest.f31905o;
            if (list2 != null) {
                i26 = list2.size();
            } else {
                i26 = 0;
            }
        }
        if (i3 == i18 && i16 == i19 && k.b(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && i17 == i26) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.request.c
    public void clear() {
        synchronized (this.f31893c) {
            d();
            this.f31892b.c();
            Status status = this.f31912v;
            Status status2 = Status.CLEARED;
            if (status == status2) {
                return;
            }
            h();
            q<R> qVar = this.f31908r;
            if (qVar != null) {
                this.f31908r = null;
            } else {
                qVar = null;
            }
            if (e()) {
                this.f31904n.b(k());
            }
            this.f31912v = status2;
            if (qVar != null) {
                this.f31911u.k(qVar);
            }
        }
    }

    @Override // com.bumptech.glide.request.f
    public Object getLock() {
        this.f31892b.c();
        return this.f31893c;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isAnyResourceSet() {
        boolean z16;
        synchronized (this.f31893c) {
            if (this.f31912v == Status.COMPLETE) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isCleared() {
        boolean z16;
        synchronized (this.f31893c) {
            if (this.f31912v == Status.CLEARED) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isComplete() {
        boolean z16;
        synchronized (this.f31893c) {
            if (this.f31912v == Status.COMPLETE) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // com.bumptech.glide.request.c
    public boolean isRunning() {
        boolean z16;
        synchronized (this.f31893c) {
            Status status = this.f31912v;
            if (status != Status.RUNNING && status != Status.WAITING_FOR_SIZE) {
                z16 = false;
            }
            z16 = true;
        }
        return z16;
    }

    @Override // e0.g
    public void onSizeReady(int i3, int i16) {
        Object obj;
        this.f31892b.c();
        Object obj2 = this.f31893c;
        synchronized (obj2) {
            try {
                try {
                    boolean z16 = D;
                    if (z16) {
                        n("Got onSizeReady in " + h0.f.a(this.f31910t));
                    }
                    if (this.f31912v == Status.WAITING_FOR_SIZE) {
                        Status status = Status.RUNNING;
                        this.f31912v = status;
                        float v3 = this.f31900j.v();
                        this.f31916z = o(i3, v3);
                        this.A = o(i16, v3);
                        if (z16) {
                            n("finished setup for calling load in " + h0.f.a(this.f31910t));
                        }
                        obj = obj2;
                        try {
                            this.f31909s = this.f31911u.f(this.f31897g, this.f31898h, this.f31900j.u(), this.f31916z, this.A, this.f31900j.t(), this.f31899i, this.f31903m, this.f31900j.h(), this.f31900j.x(), this.f31900j.H(), this.f31900j.D(), this.f31900j.n(), this.f31900j.B(), this.f31900j.z(), this.f31900j.y(), this.f31900j.m(), this, this.f31907q);
                            if (this.f31912v != status) {
                                this.f31909s = null;
                            }
                            if (z16) {
                                n("finished onSizeReady in " + h0.f.a(this.f31910t));
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            throw th;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                    obj = obj2;
                }
            } catch (Throwable th7) {
                th = th7;
            }
        }
    }

    @Override // com.bumptech.glide.request.c
    public void pause() {
        synchronized (this.f31893c) {
            if (isRunning()) {
                clear();
            }
        }
    }
}

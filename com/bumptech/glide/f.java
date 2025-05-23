package com.bumptech.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.SingleRequest;
import e0.h;
import e0.i;
import h0.j;
import h0.k;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes.dex */
public class f<TranscodeType> extends com.bumptech.glide.request.a<f<TranscodeType>> {

    /* renamed from: l0, reason: collision with root package name */
    protected static final com.bumptech.glide.request.e f31488l0 = new com.bumptech.glide.request.e().e(com.bumptech.glide.load.engine.g.f31694c).R(Priority.LOW).Y(true);
    private final Context X;
    private final RequestManager Y;
    private final Class<TranscodeType> Z;

    /* renamed from: a0, reason: collision with root package name */
    private final b f31489a0;

    /* renamed from: b0, reason: collision with root package name */
    private final d f31490b0;

    /* renamed from: c0, reason: collision with root package name */
    @NonNull
    private g<?, ? super TranscodeType> f31491c0;

    /* renamed from: d0, reason: collision with root package name */
    @Nullable
    private Object f31492d0;

    /* renamed from: e0, reason: collision with root package name */
    @Nullable
    private List<com.bumptech.glide.request.d<TranscodeType>> f31493e0;

    /* renamed from: f0, reason: collision with root package name */
    @Nullable
    private f<TranscodeType> f31494f0;

    /* renamed from: g0, reason: collision with root package name */
    @Nullable
    private f<TranscodeType> f31495g0;

    /* renamed from: h0, reason: collision with root package name */
    @Nullable
    private Float f31496h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f31497i0 = true;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f31498j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f31499k0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31500a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f31501b;

        static {
            int[] iArr = new int[Priority.values().length];
            f31501b = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31501b[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31501b[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f31501b[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            f31500a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f31500a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f31500a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f31500a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f31500a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f31500a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f31500a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f31500a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"CheckResult"})
    public f(@NonNull b bVar, RequestManager requestManager, Class<TranscodeType> cls, Context context) {
        this.f31489a0 = bVar;
        this.Y = requestManager;
        this.Z = cls;
        this.X = context;
        this.f31491c0 = requestManager.n(cls);
        this.f31490b0 = bVar.i();
        l0(requestManager.l());
        a(requestManager.m());
    }

    private com.bumptech.glide.request.c g0(h<TranscodeType> hVar, @Nullable com.bumptech.glide.request.d<TranscodeType> dVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        return h0(new Object(), hVar, dVar, null, this.f31491c0, aVar.s(), aVar.p(), aVar.o(), aVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.bumptech.glide.request.c h0(Object obj, h<TranscodeType> hVar, @Nullable com.bumptech.glide.request.d<TranscodeType> dVar, @Nullable RequestCoordinator requestCoordinator, g<?, ? super TranscodeType> gVar, Priority priority, int i3, int i16, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        RequestCoordinator requestCoordinator2;
        RequestCoordinator requestCoordinator3;
        if (this.f31495g0 != null) {
            requestCoordinator3 = new com.bumptech.glide.request.b(obj, requestCoordinator);
            requestCoordinator2 = requestCoordinator3;
        } else {
            requestCoordinator2 = null;
            requestCoordinator3 = requestCoordinator;
        }
        com.bumptech.glide.request.c i06 = i0(obj, hVar, dVar, requestCoordinator3, gVar, priority, i3, i16, aVar, executor);
        if (requestCoordinator2 == null) {
            return i06;
        }
        int p16 = this.f31495g0.p();
        int o16 = this.f31495g0.o();
        if (k.s(i3, i16) && !this.f31495g0.J()) {
            p16 = aVar.p();
            o16 = aVar.o();
        }
        f<TranscodeType> fVar = this.f31495g0;
        com.bumptech.glide.request.b bVar = requestCoordinator2;
        bVar.k(i06, fVar.h0(obj, hVar, dVar, bVar, fVar.f31491c0, fVar.s(), p16, o16, this.f31495g0, executor));
        return bVar;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.bumptech.glide.request.a] */
    private com.bumptech.glide.request.c i0(Object obj, h<TranscodeType> hVar, com.bumptech.glide.request.d<TranscodeType> dVar, @Nullable RequestCoordinator requestCoordinator, g<?, ? super TranscodeType> gVar, Priority priority, int i3, int i16, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        g<?, ? super TranscodeType> gVar2;
        Priority k06;
        f<TranscodeType> fVar = this.f31494f0;
        if (fVar != null) {
            if (!this.f31499k0) {
                g<?, ? super TranscodeType> gVar3 = fVar.f31491c0;
                if (fVar.f31497i0) {
                    gVar2 = gVar;
                } else {
                    gVar2 = gVar3;
                }
                if (fVar.C()) {
                    k06 = this.f31494f0.s();
                } else {
                    k06 = k0(priority);
                }
                Priority priority2 = k06;
                int p16 = this.f31494f0.p();
                int o16 = this.f31494f0.o();
                if (k.s(i3, i16) && !this.f31494f0.J()) {
                    p16 = aVar.p();
                    o16 = aVar.o();
                }
                com.bumptech.glide.request.g gVar4 = new com.bumptech.glide.request.g(obj, requestCoordinator);
                com.bumptech.glide.request.c v06 = v0(obj, hVar, dVar, aVar, gVar4, gVar, priority, i3, i16, executor);
                this.f31499k0 = true;
                f<TranscodeType> fVar2 = this.f31494f0;
                com.bumptech.glide.request.c h06 = fVar2.h0(obj, hVar, dVar, gVar4, gVar2, priority2, p16, o16, fVar2, executor);
                this.f31499k0 = false;
                gVar4.j(v06, h06);
                return gVar4;
            }
            throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
        }
        if (this.f31496h0 != null) {
            com.bumptech.glide.request.g gVar5 = new com.bumptech.glide.request.g(obj, requestCoordinator);
            gVar5.j(v0(obj, hVar, dVar, aVar, gVar5, gVar, priority, i3, i16, executor), v0(obj, hVar, dVar, aVar.clone().X(this.f31496h0.floatValue()), gVar5, gVar, k0(priority), i3, i16, executor));
            return gVar5;
        }
        return v0(obj, hVar, dVar, aVar, requestCoordinator, gVar, priority, i3, i16, executor);
    }

    @NonNull
    private Priority k0(@NonNull Priority priority) {
        int i3 = a.f31501b[priority.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4) {
                    throw new IllegalArgumentException("unknown priority: " + s());
                }
                return Priority.IMMEDIATE;
            }
            return Priority.HIGH;
        }
        return Priority.NORMAL;
    }

    @SuppressLint({"CheckResult"})
    private void l0(List<com.bumptech.glide.request.d<Object>> list) {
        Iterator<com.bumptech.glide.request.d<Object>> it = list.iterator();
        while (it.hasNext()) {
            e0((com.bumptech.glide.request.d) it.next());
        }
    }

    private <Y extends h<TranscodeType>> Y n0(@NonNull Y y16, @Nullable com.bumptech.glide.request.d<TranscodeType> dVar, com.bumptech.glide.request.a<?> aVar, Executor executor) {
        j.d(y16);
        if (this.f31498j0) {
            com.bumptech.glide.request.c g06 = g0(y16, dVar, aVar, executor);
            com.bumptech.glide.request.c request = y16.getRequest();
            if (g06.c(request) && !q0(aVar, request)) {
                if (!((com.bumptech.glide.request.c) j.d(request)).isRunning()) {
                    request.begin();
                }
                return y16;
            }
            this.Y.k(y16);
            y16.h(g06);
            this.Y.v(y16, g06);
            return y16;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    private boolean q0(com.bumptech.glide.request.a<?> aVar, com.bumptech.glide.request.c cVar) {
        if (!aVar.B() && cVar.isComplete()) {
            return true;
        }
        return false;
    }

    @NonNull
    private f<TranscodeType> u0(@Nullable Object obj) {
        if (A()) {
            return c().u0(obj);
        }
        this.f31492d0 = obj;
        this.f31498j0 = true;
        return U();
    }

    private com.bumptech.glide.request.c v0(Object obj, h<TranscodeType> hVar, com.bumptech.glide.request.d<TranscodeType> dVar, com.bumptech.glide.request.a<?> aVar, RequestCoordinator requestCoordinator, g<?, ? super TranscodeType> gVar, Priority priority, int i3, int i16, Executor executor) {
        Context context = this.X;
        d dVar2 = this.f31490b0;
        return SingleRequest.r(context, dVar2, obj, this.f31492d0, this.Z, aVar, i3, i16, priority, hVar, dVar, this.f31493e0, requestCoordinator, dVar2.f(), gVar.b(), executor);
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> e0(@Nullable com.bumptech.glide.request.d<TranscodeType> dVar) {
        if (A()) {
            return c().e0(dVar);
        }
        if (dVar != null) {
            if (this.f31493e0 == null) {
                this.f31493e0 = new ArrayList();
            }
            this.f31493e0.add(dVar);
        }
        return U();
    }

    @Override // com.bumptech.glide.request.a
    @NonNull
    @CheckResult
    /* renamed from: f0, reason: merged with bridge method [inline-methods] */
    public f<TranscodeType> a(@NonNull com.bumptech.glide.request.a<?> aVar) {
        j.d(aVar);
        return (f) super.a(aVar);
    }

    @Override // com.bumptech.glide.request.a
    @CheckResult
    /* renamed from: j0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public f<TranscodeType> clone() {
        f<TranscodeType> fVar = (f) super.clone();
        fVar.f31491c0 = (g<?, ? super TranscodeType>) fVar.f31491c0.clone();
        if (fVar.f31493e0 != null) {
            fVar.f31493e0 = new ArrayList(fVar.f31493e0);
        }
        f<TranscodeType> fVar2 = fVar.f31494f0;
        if (fVar2 != null) {
            fVar.f31494f0 = fVar2.c();
        }
        f<TranscodeType> fVar3 = fVar.f31495g0;
        if (fVar3 != null) {
            fVar.f31495g0 = fVar3.c();
        }
        return fVar;
    }

    @NonNull
    public <Y extends h<TranscodeType>> Y m0(@NonNull Y y16) {
        return (Y) o0(y16, null, h0.e.b());
    }

    @NonNull
    <Y extends h<TranscodeType>> Y o0(@NonNull Y y16, @Nullable com.bumptech.glide.request.d<TranscodeType> dVar, Executor executor) {
        return (Y) n0(y16, dVar, this, executor);
    }

    @NonNull
    public i<ImageView, TranscodeType> p0(@NonNull ImageView imageView) {
        f<TranscodeType> fVar;
        k.a();
        j.d(imageView);
        if (!I() && G() && imageView.getScaleType() != null) {
            switch (a.f31500a[imageView.getScaleType().ordinal()]) {
                case 1:
                    fVar = clone().L();
                    break;
                case 2:
                    fVar = clone().M();
                    break;
                case 3:
                case 4:
                case 5:
                    fVar = clone().N();
                    break;
                case 6:
                    fVar = clone().M();
                    break;
            }
            return (i) n0(this.f31490b0.a(imageView, this.Z), null, fVar, h0.e.b());
        }
        fVar = this;
        return (i) n0(this.f31490b0.a(imageView, this.Z), null, fVar, h0.e.b());
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> r0(@Nullable File file) {
        return u0(file);
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> s0(@Nullable Object obj) {
        return u0(obj);
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> t0(@Nullable String str) {
        return u0(str);
    }

    @NonNull
    @CheckResult
    public f<TranscodeType> w0(@NonNull g<?, ? super TranscodeType> gVar) {
        if (A()) {
            return c().w0(gVar);
        }
        this.f31491c0 = (g) j.d(gVar);
        this.f31497i0 = false;
        return U();
    }
}

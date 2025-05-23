package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.j;
import com.bumptech.glide.load.resource.bitmap.s;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.request.a;
import com.tencent.mobileqq.data.MessageRecord;
import h0.k;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class a<T extends a<T>> implements Cloneable {

    @Nullable
    private Drawable C;
    private int D;
    private boolean I;

    @Nullable
    private Drawable K;
    private int L;
    private boolean Q;

    @Nullable
    private Resources.Theme R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean W;

    /* renamed from: d, reason: collision with root package name */
    private int f31917d;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private Drawable f31921i;

    /* renamed from: m, reason: collision with root package name */
    private int f31922m;

    /* renamed from: e, reason: collision with root package name */
    private float f31918e = 1.0f;

    /* renamed from: f, reason: collision with root package name */
    @NonNull
    private com.bumptech.glide.load.engine.g f31919f = com.bumptech.glide.load.engine.g.f31696e;

    /* renamed from: h, reason: collision with root package name */
    @NonNull
    private Priority f31920h = Priority.NORMAL;
    private boolean E = true;
    private int F = -1;
    private int G = -1;

    @NonNull
    private com.bumptech.glide.load.c H = g0.a.c();
    private boolean J = true;

    @NonNull
    private com.bumptech.glide.load.e M = new com.bumptech.glide.load.e();

    @NonNull
    private Map<Class<?>, h<?>> N = new h0.b();

    @NonNull
    private Class<?> P = Object.class;
    private boolean V = true;

    private boolean E(int i3) {
        return F(this.f31917d, i3);
    }

    private static boolean F(int i3, int i16) {
        if ((i3 & i16) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    private T O(@NonNull DownsampleStrategy downsampleStrategy, @NonNull h<Bitmap> hVar) {
        return S(downsampleStrategy, hVar, false);
    }

    @NonNull
    private T S(@NonNull DownsampleStrategy downsampleStrategy, @NonNull h<Bitmap> hVar, boolean z16) {
        T P;
        if (z16) {
            P = b0(downsampleStrategy, hVar);
        } else {
            P = P(downsampleStrategy, hVar);
        }
        P.V = true;
        return P;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean A() {
        return this.S;
    }

    public final boolean B() {
        return this.E;
    }

    public final boolean C() {
        return E(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean D() {
        return this.V;
    }

    public final boolean G() {
        return this.J;
    }

    public final boolean H() {
        return this.I;
    }

    public final boolean I() {
        return E(2048);
    }

    public final boolean J() {
        return k.s(this.G, this.F);
    }

    @NonNull
    public T K() {
        this.Q = true;
        return T();
    }

    @NonNull
    @CheckResult
    public T L() {
        return P(DownsampleStrategy.f31788e, new j());
    }

    @NonNull
    @CheckResult
    public T M() {
        return O(DownsampleStrategy.f31787d, new com.bumptech.glide.load.resource.bitmap.k());
    }

    @NonNull
    @CheckResult
    public T N() {
        return O(DownsampleStrategy.f31786c, new u());
    }

    @NonNull
    final T P(@NonNull DownsampleStrategy downsampleStrategy, @NonNull h<Bitmap> hVar) {
        if (this.S) {
            return (T) clone().P(downsampleStrategy, hVar);
        }
        f(downsampleStrategy);
        return a0(hVar, false);
    }

    @NonNull
    @CheckResult
    public T Q(int i3, int i16) {
        if (this.S) {
            return (T) clone().Q(i3, i16);
        }
        this.G = i3;
        this.F = i16;
        this.f31917d |= 512;
        return U();
    }

    @NonNull
    @CheckResult
    public T R(@NonNull Priority priority) {
        if (this.S) {
            return (T) clone().R(priority);
        }
        this.f31920h = (Priority) h0.j.d(priority);
        this.f31917d |= 8;
        return U();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NonNull
    public final T U() {
        if (!this.Q) {
            return T();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    @NonNull
    @CheckResult
    public <Y> T V(@NonNull com.bumptech.glide.load.d<Y> dVar, @NonNull Y y16) {
        if (this.S) {
            return (T) clone().V(dVar, y16);
        }
        h0.j.d(dVar);
        h0.j.d(y16);
        this.M.e(dVar, y16);
        return U();
    }

    @NonNull
    @CheckResult
    public T W(@NonNull com.bumptech.glide.load.c cVar) {
        if (this.S) {
            return (T) clone().W(cVar);
        }
        this.H = (com.bumptech.glide.load.c) h0.j.d(cVar);
        this.f31917d |= 1024;
        return U();
    }

    @NonNull
    @CheckResult
    public T X(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        if (this.S) {
            return (T) clone().X(f16);
        }
        if (f16 >= 0.0f && f16 <= 1.0f) {
            this.f31918e = f16;
            this.f31917d |= 2;
            return U();
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    @NonNull
    @CheckResult
    public T Y(boolean z16) {
        if (this.S) {
            return (T) clone().Y(true);
        }
        this.E = !z16;
        this.f31917d |= 256;
        return U();
    }

    @NonNull
    @CheckResult
    public T Z(@NonNull h<Bitmap> hVar) {
        return a0(hVar, true);
    }

    @NonNull
    @CheckResult
    public T a(@NonNull a<?> aVar) {
        if (this.S) {
            return (T) clone().a(aVar);
        }
        if (F(aVar.f31917d, 2)) {
            this.f31918e = aVar.f31918e;
        }
        if (F(aVar.f31917d, 262144)) {
            this.T = aVar.T;
        }
        if (F(aVar.f31917d, 1048576)) {
            this.W = aVar.W;
        }
        if (F(aVar.f31917d, 4)) {
            this.f31919f = aVar.f31919f;
        }
        if (F(aVar.f31917d, 8)) {
            this.f31920h = aVar.f31920h;
        }
        if (F(aVar.f31917d, 16)) {
            this.f31921i = aVar.f31921i;
            this.f31922m = 0;
            this.f31917d &= -33;
        }
        if (F(aVar.f31917d, 32)) {
            this.f31922m = aVar.f31922m;
            this.f31921i = null;
            this.f31917d &= -17;
        }
        if (F(aVar.f31917d, 64)) {
            this.C = aVar.C;
            this.D = 0;
            this.f31917d &= -129;
        }
        if (F(aVar.f31917d, 128)) {
            this.D = aVar.D;
            this.C = null;
            this.f31917d &= -65;
        }
        if (F(aVar.f31917d, 256)) {
            this.E = aVar.E;
        }
        if (F(aVar.f31917d, 512)) {
            this.G = aVar.G;
            this.F = aVar.F;
        }
        if (F(aVar.f31917d, 1024)) {
            this.H = aVar.H;
        }
        if (F(aVar.f31917d, 4096)) {
            this.P = aVar.P;
        }
        if (F(aVar.f31917d, 8192)) {
            this.K = aVar.K;
            this.L = 0;
            this.f31917d &= -16385;
        }
        if (F(aVar.f31917d, 16384)) {
            this.L = aVar.L;
            this.K = null;
            this.f31917d &= -8193;
        }
        if (F(aVar.f31917d, 32768)) {
            this.R = aVar.R;
        }
        if (F(aVar.f31917d, 65536)) {
            this.J = aVar.J;
        }
        if (F(aVar.f31917d, 131072)) {
            this.I = aVar.I;
        }
        if (F(aVar.f31917d, 2048)) {
            this.N.putAll(aVar.N);
            this.V = aVar.V;
        }
        if (F(aVar.f31917d, 524288)) {
            this.U = aVar.U;
        }
        if (!this.J) {
            this.N.clear();
            int i3 = this.f31917d & MessageRecord.MSG_TYPE_GAME_PARTY_GRAY_TIPS;
            this.I = false;
            this.f31917d = i3 & (-131073);
            this.V = true;
        }
        this.f31917d |= aVar.f31917d;
        this.M.d(aVar.M);
        return U();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    T a0(@NonNull h<Bitmap> hVar, boolean z16) {
        if (this.S) {
            return (T) clone().a0(hVar, z16);
        }
        s sVar = new s(hVar, z16);
        c0(Bitmap.class, hVar, z16);
        c0(Drawable.class, sVar, z16);
        c0(BitmapDrawable.class, sVar.c(), z16);
        c0(z.c.class, new z.f(hVar), z16);
        return U();
    }

    @NonNull
    public T b() {
        if (this.Q && !this.S) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.S = true;
        return K();
    }

    @NonNull
    @CheckResult
    final T b0(@NonNull DownsampleStrategy downsampleStrategy, @NonNull h<Bitmap> hVar) {
        if (this.S) {
            return (T) clone().b0(downsampleStrategy, hVar);
        }
        f(downsampleStrategy);
        return Z(hVar);
    }

    @Override // 
    @CheckResult
    /* renamed from: c */
    public T clone() {
        try {
            T t16 = (T) super.clone();
            com.bumptech.glide.load.e eVar = new com.bumptech.glide.load.e();
            t16.M = eVar;
            eVar.d(this.M);
            h0.b bVar = new h0.b();
            t16.N = bVar;
            bVar.putAll(this.N);
            t16.Q = false;
            t16.S = false;
            return t16;
        } catch (CloneNotSupportedException e16) {
            throw new RuntimeException(e16);
        }
    }

    @NonNull
    <Y> T c0(@NonNull Class<Y> cls, @NonNull h<Y> hVar, boolean z16) {
        if (this.S) {
            return (T) clone().c0(cls, hVar, z16);
        }
        h0.j.d(cls);
        h0.j.d(hVar);
        this.N.put(cls, hVar);
        int i3 = this.f31917d | 2048;
        this.J = true;
        int i16 = i3 | 65536;
        this.f31917d = i16;
        this.V = false;
        if (z16) {
            this.f31917d = i16 | 131072;
            this.I = true;
        }
        return U();
    }

    @NonNull
    @CheckResult
    public T d(@NonNull Class<?> cls) {
        if (this.S) {
            return (T) clone().d(cls);
        }
        this.P = (Class) h0.j.d(cls);
        this.f31917d |= 4096;
        return U();
    }

    @NonNull
    @CheckResult
    public T d0(boolean z16) {
        if (this.S) {
            return (T) clone().d0(z16);
        }
        this.W = z16;
        this.f31917d |= 1048576;
        return U();
    }

    @NonNull
    @CheckResult
    public T e(@NonNull com.bumptech.glide.load.engine.g gVar) {
        if (this.S) {
            return (T) clone().e(gVar);
        }
        this.f31919f = (com.bumptech.glide.load.engine.g) h0.j.d(gVar);
        this.f31917d |= 4;
        return U();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (Float.compare(aVar.f31918e, this.f31918e) != 0 || this.f31922m != aVar.f31922m || !k.c(this.f31921i, aVar.f31921i) || this.D != aVar.D || !k.c(this.C, aVar.C) || this.L != aVar.L || !k.c(this.K, aVar.K) || this.E != aVar.E || this.F != aVar.F || this.G != aVar.G || this.I != aVar.I || this.J != aVar.J || this.T != aVar.T || this.U != aVar.U || !this.f31919f.equals(aVar.f31919f) || this.f31920h != aVar.f31920h || !this.M.equals(aVar.M) || !this.N.equals(aVar.N) || !this.P.equals(aVar.P) || !k.c(this.H, aVar.H) || !k.c(this.R, aVar.R)) {
            return false;
        }
        return true;
    }

    @NonNull
    @CheckResult
    public T f(@NonNull DownsampleStrategy downsampleStrategy) {
        return V(DownsampleStrategy.f31791h, h0.j.d(downsampleStrategy));
    }

    @NonNull
    public final com.bumptech.glide.load.engine.g h() {
        return this.f31919f;
    }

    public int hashCode() {
        return k.n(this.R, k.n(this.H, k.n(this.P, k.n(this.N, k.n(this.M, k.n(this.f31920h, k.n(this.f31919f, k.o(this.U, k.o(this.T, k.o(this.J, k.o(this.I, k.m(this.G, k.m(this.F, k.o(this.E, k.n(this.K, k.m(this.L, k.n(this.C, k.m(this.D, k.n(this.f31921i, k.m(this.f31922m, k.k(this.f31918e)))))))))))))))))))));
    }

    public final int i() {
        return this.f31922m;
    }

    @Nullable
    public final Drawable j() {
        return this.f31921i;
    }

    @Nullable
    public final Drawable k() {
        return this.K;
    }

    public final int l() {
        return this.L;
    }

    public final boolean m() {
        return this.U;
    }

    @NonNull
    public final com.bumptech.glide.load.e n() {
        return this.M;
    }

    public final int o() {
        return this.F;
    }

    public final int p() {
        return this.G;
    }

    @Nullable
    public final Drawable q() {
        return this.C;
    }

    public final int r() {
        return this.D;
    }

    @NonNull
    public final Priority s() {
        return this.f31920h;
    }

    @NonNull
    public final Class<?> t() {
        return this.P;
    }

    @NonNull
    public final com.bumptech.glide.load.c u() {
        return this.H;
    }

    public final float v() {
        return this.f31918e;
    }

    @Nullable
    public final Resources.Theme w() {
        return this.R;
    }

    @NonNull
    public final Map<Class<?>, h<?>> x() {
        return this.N;
    }

    public final boolean y() {
        return this.W;
    }

    public final boolean z() {
        return this.T;
    }

    private T T() {
        return this;
    }
}

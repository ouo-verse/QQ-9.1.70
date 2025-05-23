package com.tencent.qqnt.chats.view.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.Px;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes24.dex */
public class Shimmer {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final float[] f355606a;

    /* renamed from: b, reason: collision with root package name */
    final int[] f355607b;

    /* renamed from: c, reason: collision with root package name */
    final RectF f355608c;

    /* renamed from: d, reason: collision with root package name */
    int f355609d;

    /* renamed from: e, reason: collision with root package name */
    @ColorInt
    int f355610e;

    /* renamed from: f, reason: collision with root package name */
    @ColorInt
    int f355611f;

    /* renamed from: g, reason: collision with root package name */
    int f355612g;

    /* renamed from: h, reason: collision with root package name */
    int f355613h;

    /* renamed from: i, reason: collision with root package name */
    int f355614i;

    /* renamed from: j, reason: collision with root package name */
    float f355615j;

    /* renamed from: k, reason: collision with root package name */
    float f355616k;

    /* renamed from: l, reason: collision with root package name */
    float f355617l;

    /* renamed from: m, reason: collision with root package name */
    float f355618m;

    /* renamed from: n, reason: collision with root package name */
    float f355619n;

    /* renamed from: o, reason: collision with root package name */
    boolean f355620o;

    /* renamed from: p, reason: collision with root package name */
    boolean f355621p;

    /* renamed from: q, reason: collision with root package name */
    boolean f355622q;

    /* renamed from: r, reason: collision with root package name */
    int f355623r;

    /* renamed from: s, reason: collision with root package name */
    int f355624s;

    /* renamed from: t, reason: collision with root package name */
    long f355625t;

    /* renamed from: u, reason: collision with root package name */
    long f355626u;

    /* renamed from: v, reason: collision with root package name */
    long f355627v;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes24.dex */
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes24.dex */
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class a extends b<a> {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f355628a.f355622q = true;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qqnt.chats.view.shimmer.Shimmer.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public a d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (a) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static abstract class b<T extends b<T>> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final Shimmer f355628a;

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f355628a = new Shimmer();
            }
        }

        private static float b(float f16, float f17, float f18) {
            return Math.min(f17, Math.max(f16, f18));
        }

        public Shimmer a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                return (Shimmer) iPatchRedirector.redirect((short) 22, (Object) this);
            }
            this.f355628a.b();
            this.f355628a.c();
            return this.f355628a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public T c(TypedArray typedArray) {
            int i3 = ow3.a.H3;
            if (typedArray.hasValue(i3)) {
                g(typedArray.getBoolean(i3, this.f355628a.f355620o));
            }
            int i16 = ow3.a.E3;
            if (typedArray.hasValue(i16)) {
                e(typedArray.getBoolean(i16, this.f355628a.f355621p));
            }
            int i17 = ow3.a.F3;
            if (typedArray.hasValue(i17)) {
                f(typedArray.getFloat(i17, 0.3f));
            }
            int i18 = ow3.a.P3;
            if (typedArray.hasValue(i18)) {
                n(typedArray.getFloat(i18, 1.0f));
            }
            if (typedArray.hasValue(ow3.a.L3)) {
                j(typedArray.getInt(r0, (int) this.f355628a.f355625t));
            }
            int i19 = ow3.a.S3;
            if (typedArray.hasValue(i19)) {
                p(typedArray.getInt(i19, this.f355628a.f355623r));
            }
            if (typedArray.hasValue(ow3.a.T3)) {
                q(typedArray.getInt(r0, (int) this.f355628a.f355626u));
            }
            int i26 = ow3.a.U3;
            if (typedArray.hasValue(i26)) {
                r(typedArray.getInt(i26, this.f355628a.f355624s));
            }
            if (typedArray.hasValue(ow3.a.W3)) {
                t(typedArray.getInt(r0, (int) this.f355628a.f355627v));
            }
            int i27 = ow3.a.J3;
            if (typedArray.hasValue(i27)) {
                int i28 = typedArray.getInt(i27, this.f355628a.f355609d);
                if (i28 != 1) {
                    if (i28 != 2) {
                        if (i28 != 3) {
                            h(0);
                        } else {
                            h(3);
                        }
                    } else {
                        h(2);
                    }
                } else {
                    h(1);
                }
            }
            int i29 = ow3.a.V3;
            if (typedArray.hasValue(i29)) {
                if (typedArray.getInt(i29, this.f355628a.f355612g) != 1) {
                    s(0);
                } else {
                    s(1);
                }
            }
            int i36 = ow3.a.K3;
            if (typedArray.hasValue(i36)) {
                i(typedArray.getFloat(i36, this.f355628a.f355618m));
            }
            int i37 = ow3.a.N3;
            if (typedArray.hasValue(i37)) {
                l(typedArray.getDimensionPixelSize(i37, this.f355628a.f355613h));
            }
            int i38 = ow3.a.M3;
            if (typedArray.hasValue(i38)) {
                k(typedArray.getDimensionPixelSize(i38, this.f355628a.f355614i));
            }
            int i39 = ow3.a.R3;
            if (typedArray.hasValue(i39)) {
                o(typedArray.getFloat(i39, this.f355628a.f355617l));
            }
            int i46 = ow3.a.Y3;
            if (typedArray.hasValue(i46)) {
                v(typedArray.getFloat(i46, this.f355628a.f355615j));
            }
            int i47 = ow3.a.O3;
            if (typedArray.hasValue(i47)) {
                m(typedArray.getFloat(i47, this.f355628a.f355616k));
            }
            int i48 = ow3.a.X3;
            if (typedArray.hasValue(i48)) {
                u(typedArray.getFloat(i48, this.f355628a.f355619n));
            }
            return d();
        }

        protected abstract T d();

        public T e(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return (T) iPatchRedirector.redirect((short) 16, (Object) this, z16);
            }
            this.f355628a.f355621p = z16;
            return d();
        }

        public T f(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return (T) iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16));
            }
            int b16 = (int) (b(0.0f, 1.0f, f16) * 255.0f);
            Shimmer shimmer = this.f355628a;
            shimmer.f355611f = (b16 << 24) | (shimmer.f355611f & 16777215);
            return d();
        }

        public T g(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return (T) iPatchRedirector.redirect((short) 15, (Object) this, z16);
            }
            this.f355628a.f355620o = z16;
            return d();
        }

        public T h(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (T) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            this.f355628a.f355609d = i3;
            return d();
        }

        public T i(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return (T) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            }
            if (f16 >= 0.0f) {
                this.f355628a.f355618m = f16;
                return d();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f16);
        }

        public T j(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                return (T) iPatchRedirector.redirect((short) 21, (Object) this, j3);
            }
            if (j3 >= 0) {
                this.f355628a.f355625t = j3;
                return d();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j3);
        }

        public T k(@Px int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (T) iPatchRedirector.redirect((short) 7, (Object) this, i3);
            }
            if (i3 >= 0) {
                this.f355628a.f355614i = i3;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height: " + i3);
        }

        public T l(@Px int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (T) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            if (i3 >= 0) {
                this.f355628a.f355613h = i3;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width: " + i3);
        }

        public T m(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return (T) iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            }
            if (f16 >= 0.0f) {
                this.f355628a.f355616k = f16;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f16);
        }

        public T n(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (T) iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
            }
            int b16 = (int) (b(0.0f, 1.0f, f16) * 255.0f);
            Shimmer shimmer = this.f355628a;
            shimmer.f355610e = (b16 << 24) | (shimmer.f355610e & 16777215);
            return d();
        }

        public T o(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (T) iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            }
            if (f16 >= 0.0f) {
                this.f355628a.f355617l = f16;
                return d();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f16);
        }

        public T p(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                return (T) iPatchRedirector.redirect((short) 17, (Object) this, i3);
            }
            this.f355628a.f355623r = i3;
            return d();
        }

        public T q(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                return (T) iPatchRedirector.redirect((short) 19, (Object) this, j3);
            }
            if (j3 >= 0) {
                this.f355628a.f355626u = j3;
                return d();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j3);
        }

        public T r(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                return (T) iPatchRedirector.redirect((short) 18, (Object) this, i3);
            }
            this.f355628a.f355624s = i3;
            return d();
        }

        public T s(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (T) iPatchRedirector.redirect((short) 5, (Object) this, i3);
            }
            this.f355628a.f355612g = i3;
            return d();
        }

        public T t(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                return (T) iPatchRedirector.redirect((short) 20, (Object) this, j3);
            }
            if (j3 >= 0) {
                this.f355628a.f355627v = j3;
                return d();
            }
            throw new IllegalArgumentException("Given a negative start delay: " + j3);
        }

        public T u(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (T) iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
            }
            this.f355628a.f355619n = f16;
            return d();
        }

        public T v(float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return (T) iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            }
            if (f16 >= 0.0f) {
                this.f355628a.f355615j = f16;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static class c extends b<c> {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f355628a.f355622q = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.qqnt.chats.view.shimmer.Shimmer.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public c c(TypedArray typedArray) {
            super.c(typedArray);
            int i3 = ow3.a.G3;
            if (typedArray.hasValue(i3)) {
                y(typedArray.getColor(i3, this.f355628a.f355611f));
            }
            int i16 = ow3.a.Q3;
            if (typedArray.hasValue(i16)) {
                z(typedArray.getColor(i16, this.f355628a.f355610e));
            }
            return d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.qqnt.chats.view.shimmer.Shimmer.b
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public c d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (c) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this;
        }

        public c y(@ColorInt int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (c) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            Shimmer shimmer = this.f355628a;
            shimmer.f355611f = (i3 & 16777215) | (shimmer.f355611f & (-16777216));
            return d();
        }

        public c z(@ColorInt int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (c) iPatchRedirector.redirect((short) 2, (Object) this, i3);
            }
            this.f355628a.f355610e = i3;
            return d();
        }
    }

    Shimmer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f355606a = new float[4];
        this.f355607b = new int[4];
        this.f355608c = new RectF();
        this.f355609d = 0;
        this.f355610e = -1;
        this.f355611f = 1291845631;
        this.f355612g = 0;
        this.f355613h = 0;
        this.f355614i = 0;
        this.f355615j = 1.0f;
        this.f355616k = 1.0f;
        this.f355617l = 0.0f;
        this.f355618m = 0.5f;
        this.f355619n = 20.0f;
        this.f355620o = true;
        this.f355621p = true;
        this.f355622q = true;
        this.f355623r = -1;
        this.f355624s = 1;
        this.f355625t = 1000L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i3) {
        int i16 = this.f355614i;
        if (i16 <= 0) {
            return Math.round(this.f355616k * i3);
        }
        return i16;
    }

    void b() {
        if (this.f355612g != 1) {
            int[] iArr = this.f355607b;
            int i3 = this.f355611f;
            iArr[0] = i3;
            int i16 = this.f355610e;
            iArr[1] = i16;
            iArr[2] = i16;
            iArr[3] = i3;
            return;
        }
        int[] iArr2 = this.f355607b;
        int i17 = this.f355610e;
        iArr2[0] = i17;
        iArr2[1] = i17;
        int i18 = this.f355611f;
        iArr2[2] = i18;
        iArr2[3] = i18;
    }

    void c() {
        if (this.f355612g != 1) {
            this.f355606a[0] = Math.max(((1.0f - this.f355617l) - this.f355618m) / 2.0f, 0.0f);
            this.f355606a[1] = Math.max(((1.0f - this.f355617l) - 0.001f) / 2.0f, 0.0f);
            this.f355606a[2] = Math.min(((this.f355617l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.f355606a[3] = Math.min(((this.f355617l + 1.0f) + this.f355618m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.f355606a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f355617l, 1.0f);
        this.f355606a[2] = Math.min(this.f355617l + this.f355618m, 1.0f);
        this.f355606a[3] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i3) {
        int i16 = this.f355613h;
        if (i16 <= 0) {
            return Math.round(this.f355615j * i3);
        }
        return i16;
    }
}

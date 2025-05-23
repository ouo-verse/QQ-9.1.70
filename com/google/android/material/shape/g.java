package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: m, reason: collision with root package name */
    public static final j1.c f34052m = new j1.e(0.5f);

    /* renamed from: a, reason: collision with root package name */
    j1.d f34053a;

    /* renamed from: b, reason: collision with root package name */
    j1.d f34054b;

    /* renamed from: c, reason: collision with root package name */
    j1.d f34055c;

    /* renamed from: d, reason: collision with root package name */
    j1.d f34056d;

    /* renamed from: e, reason: collision with root package name */
    j1.c f34057e;

    /* renamed from: f, reason: collision with root package name */
    j1.c f34058f;

    /* renamed from: g, reason: collision with root package name */
    j1.c f34059g;

    /* renamed from: h, reason: collision with root package name */
    j1.c f34060h;

    /* renamed from: i, reason: collision with root package name */
    com.google.android.material.shape.b f34061i;

    /* renamed from: j, reason: collision with root package name */
    com.google.android.material.shape.b f34062j;

    /* renamed from: k, reason: collision with root package name */
    com.google.android.material.shape.b f34063k;

    /* renamed from: l, reason: collision with root package name */
    com.google.android.material.shape.b f34064l;

    /* compiled from: P */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public interface c {
        @NonNull
        j1.c a(@NonNull j1.c cVar);
    }

    @NonNull
    public static b a() {
        return new b();
    }

    @NonNull
    public static b b(Context context, @StyleRes int i3, @StyleRes int i16) {
        return c(context, i3, i16, 0);
    }

    @NonNull
    private static b c(Context context, @StyleRes int i3, @StyleRes int i16, int i17) {
        return d(context, i3, i16, new j1.a(i17));
    }

    @NonNull
    private static b d(Context context, @StyleRes int i3, @StyleRes int i16, @NonNull j1.c cVar) {
        if (i16 != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i3);
            i3 = i16;
            context = contextThemeWrapper;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i3, w0.a.f443933k7);
        try {
            int i17 = obtainStyledAttributes.getInt(w0.a.f443944l7, 0);
            int i18 = obtainStyledAttributes.getInt(w0.a.f443978o7, i17);
            int i19 = obtainStyledAttributes.getInt(w0.a.f443990p7, i17);
            int i26 = obtainStyledAttributes.getInt(w0.a.f443966n7, i17);
            int i27 = obtainStyledAttributes.getInt(w0.a.f443955m7, i17);
            j1.c m3 = m(obtainStyledAttributes, w0.a.f444002q7, cVar);
            j1.c m16 = m(obtainStyledAttributes, w0.a.f444038t7, m3);
            j1.c m17 = m(obtainStyledAttributes, w0.a.f444050u7, m3);
            j1.c m18 = m(obtainStyledAttributes, w0.a.f444026s7, m3);
            return new b().C(i18, m16).G(i19, m17).x(i26, m18).t(i27, m(obtainStyledAttributes, w0.a.f444014r7, m3));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static b e(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16) {
        return f(context, attributeSet, i3, i16, 0);
    }

    @NonNull
    public static b f(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16, int i17) {
        return g(context, attributeSet, i3, i16, new j1.a(i17));
    }

    @NonNull
    public static b g(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i3, @StyleRes int i16, @NonNull j1.c cVar) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.f443920j5, i3, i16);
        int resourceId = obtainStyledAttributes.getResourceId(w0.a.f443931k5, 0);
        int resourceId2 = obtainStyledAttributes.getResourceId(w0.a.f443942l5, 0);
        obtainStyledAttributes.recycle();
        return d(context, resourceId, resourceId2, cVar);
    }

    @NonNull
    private static j1.c m(TypedArray typedArray, int i3, @NonNull j1.c cVar) {
        TypedValue peekValue = typedArray.peekValue(i3);
        if (peekValue == null) {
            return cVar;
        }
        int i16 = peekValue.type;
        if (i16 == 5) {
            return new j1.a(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
        }
        if (i16 == 6) {
            return new j1.e(peekValue.getFraction(1.0f, 1.0f));
        }
        return cVar;
    }

    @NonNull
    public com.google.android.material.shape.b h() {
        return this.f34063k;
    }

    @NonNull
    public j1.d i() {
        return this.f34056d;
    }

    @NonNull
    public j1.c j() {
        return this.f34060h;
    }

    @NonNull
    public j1.d k() {
        return this.f34055c;
    }

    @NonNull
    public j1.c l() {
        return this.f34059g;
    }

    @NonNull
    public com.google.android.material.shape.b n() {
        return this.f34064l;
    }

    @NonNull
    public com.google.android.material.shape.b o() {
        return this.f34062j;
    }

    @NonNull
    public com.google.android.material.shape.b p() {
        return this.f34061i;
    }

    @NonNull
    public j1.d q() {
        return this.f34053a;
    }

    @NonNull
    public j1.c r() {
        return this.f34057e;
    }

    @NonNull
    public j1.d s() {
        return this.f34054b;
    }

    @NonNull
    public j1.c t() {
        return this.f34058f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean u(@NonNull RectF rectF) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (this.f34064l.getClass().equals(com.google.android.material.shape.b.class) && this.f34062j.getClass().equals(com.google.android.material.shape.b.class) && this.f34061i.getClass().equals(com.google.android.material.shape.b.class) && this.f34063k.getClass().equals(com.google.android.material.shape.b.class)) {
            z16 = true;
        } else {
            z16 = false;
        }
        float a16 = this.f34057e.a(rectF);
        if (this.f34058f.a(rectF) == a16 && this.f34060h.a(rectF) == a16 && this.f34059g.a(rectF) == a16) {
            z17 = true;
        } else {
            z17 = false;
        }
        if ((this.f34054b instanceof f) && (this.f34053a instanceof f) && (this.f34055c instanceof f) && (this.f34056d instanceof f)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z16 && z17 && z18) {
            return true;
        }
        return false;
    }

    @NonNull
    public b v() {
        return new b(this);
    }

    @NonNull
    public g w(float f16) {
        return v().o(f16).m();
    }

    @NonNull
    public g x(@NonNull j1.c cVar) {
        return v().p(cVar).m();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public g y(@NonNull c cVar) {
        return v().F(cVar.a(r())).J(cVar.a(t())).w(cVar.a(j())).A(cVar.a(l())).m();
    }

    g(@NonNull b bVar) {
        this.f34053a = bVar.f34065a;
        this.f34054b = bVar.f34066b;
        this.f34055c = bVar.f34067c;
        this.f34056d = bVar.f34068d;
        this.f34057e = bVar.f34069e;
        this.f34058f = bVar.f34070f;
        this.f34059g = bVar.f34071g;
        this.f34060h = bVar.f34072h;
        this.f34061i = bVar.f34073i;
        this.f34062j = bVar.f34074j;
        this.f34063k = bVar.f34075k;
        this.f34064l = bVar.f34076l;
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        @NonNull
        private j1.d f34065a;

        /* renamed from: b, reason: collision with root package name */
        @NonNull
        private j1.d f34066b;

        /* renamed from: c, reason: collision with root package name */
        @NonNull
        private j1.d f34067c;

        /* renamed from: d, reason: collision with root package name */
        @NonNull
        private j1.d f34068d;

        /* renamed from: e, reason: collision with root package name */
        @NonNull
        private j1.c f34069e;

        /* renamed from: f, reason: collision with root package name */
        @NonNull
        private j1.c f34070f;

        /* renamed from: g, reason: collision with root package name */
        @NonNull
        private j1.c f34071g;

        /* renamed from: h, reason: collision with root package name */
        @NonNull
        private j1.c f34072h;

        /* renamed from: i, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.b f34073i;

        /* renamed from: j, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.b f34074j;

        /* renamed from: k, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.b f34075k;

        /* renamed from: l, reason: collision with root package name */
        @NonNull
        private com.google.android.material.shape.b f34076l;

        public b() {
            this.f34065a = d.b();
            this.f34066b = d.b();
            this.f34067c = d.b();
            this.f34068d = d.b();
            this.f34069e = new j1.a(0.0f);
            this.f34070f = new j1.a(0.0f);
            this.f34071g = new j1.a(0.0f);
            this.f34072h = new j1.a(0.0f);
            this.f34073i = d.c();
            this.f34074j = d.c();
            this.f34075k = d.c();
            this.f34076l = d.c();
        }

        private static float n(j1.d dVar) {
            if (dVar instanceof f) {
                return ((f) dVar).f34051a;
            }
            if (dVar instanceof com.google.android.material.shape.a) {
                return ((com.google.android.material.shape.a) dVar).f34047a;
            }
            return -1.0f;
        }

        @NonNull
        public b A(@NonNull j1.c cVar) {
            this.f34071g = cVar;
            return this;
        }

        @NonNull
        public b B(@NonNull com.google.android.material.shape.b bVar) {
            this.f34073i = bVar;
            return this;
        }

        @NonNull
        public b C(int i3, @NonNull j1.c cVar) {
            return D(d.a(i3)).F(cVar);
        }

        @NonNull
        public b D(@NonNull j1.d dVar) {
            this.f34065a = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                E(n3);
            }
            return this;
        }

        @NonNull
        public b E(@Dimension float f16) {
            this.f34069e = new j1.a(f16);
            return this;
        }

        @NonNull
        public b F(@NonNull j1.c cVar) {
            this.f34069e = cVar;
            return this;
        }

        @NonNull
        public b G(int i3, @NonNull j1.c cVar) {
            return H(d.a(i3)).J(cVar);
        }

        @NonNull
        public b H(@NonNull j1.d dVar) {
            this.f34066b = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                I(n3);
            }
            return this;
        }

        @NonNull
        public b I(@Dimension float f16) {
            this.f34070f = new j1.a(f16);
            return this;
        }

        @NonNull
        public b J(@NonNull j1.c cVar) {
            this.f34070f = cVar;
            return this;
        }

        @NonNull
        public g m() {
            return new g(this);
        }

        @NonNull
        public b o(@Dimension float f16) {
            return E(f16).I(f16).z(f16).v(f16);
        }

        @NonNull
        public b p(@NonNull j1.c cVar) {
            return F(cVar).J(cVar).A(cVar).w(cVar);
        }

        @NonNull
        public b q(int i3, @Dimension float f16) {
            return r(d.a(i3)).o(f16);
        }

        @NonNull
        public b r(@NonNull j1.d dVar) {
            return D(dVar).H(dVar).y(dVar).u(dVar);
        }

        @NonNull
        public b s(@NonNull com.google.android.material.shape.b bVar) {
            this.f34075k = bVar;
            return this;
        }

        @NonNull
        public b t(int i3, @NonNull j1.c cVar) {
            return u(d.a(i3)).w(cVar);
        }

        @NonNull
        public b u(@NonNull j1.d dVar) {
            this.f34068d = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                v(n3);
            }
            return this;
        }

        @NonNull
        public b v(@Dimension float f16) {
            this.f34072h = new j1.a(f16);
            return this;
        }

        @NonNull
        public b w(@NonNull j1.c cVar) {
            this.f34072h = cVar;
            return this;
        }

        @NonNull
        public b x(int i3, @NonNull j1.c cVar) {
            return y(d.a(i3)).A(cVar);
        }

        @NonNull
        public b y(@NonNull j1.d dVar) {
            this.f34067c = dVar;
            float n3 = n(dVar);
            if (n3 != -1.0f) {
                z(n3);
            }
            return this;
        }

        @NonNull
        public b z(@Dimension float f16) {
            this.f34071g = new j1.a(f16);
            return this;
        }

        public b(@NonNull g gVar) {
            this.f34065a = d.b();
            this.f34066b = d.b();
            this.f34067c = d.b();
            this.f34068d = d.b();
            this.f34069e = new j1.a(0.0f);
            this.f34070f = new j1.a(0.0f);
            this.f34071g = new j1.a(0.0f);
            this.f34072h = new j1.a(0.0f);
            this.f34073i = d.c();
            this.f34074j = d.c();
            this.f34075k = d.c();
            this.f34076l = d.c();
            this.f34065a = gVar.f34053a;
            this.f34066b = gVar.f34054b;
            this.f34067c = gVar.f34055c;
            this.f34068d = gVar.f34056d;
            this.f34069e = gVar.f34057e;
            this.f34070f = gVar.f34058f;
            this.f34071g = gVar.f34059g;
            this.f34072h = gVar.f34060h;
            this.f34073i = gVar.f34061i;
            this.f34074j = gVar.f34062j;
            this.f34075k = gVar.f34063k;
            this.f34076l = gVar.f34064l;
        }
    }

    public g() {
        this.f34053a = d.b();
        this.f34054b = d.b();
        this.f34055c = d.b();
        this.f34056d = d.b();
        this.f34057e = new j1.a(0.0f);
        this.f34058f = new j1.a(0.0f);
        this.f34059g = new j1.a(0.0f);
        this.f34060h = new j1.a(0.0f);
        this.f34061i = d.c();
        this.f34062j = d.c();
        this.f34063k = d.c();
        this.f34064l = d.c();
    }
}

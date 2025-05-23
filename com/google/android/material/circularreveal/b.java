package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.CircularRevealHelper;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface b extends CircularRevealHelper.a {

    /* compiled from: P */
    /* renamed from: com.google.android.material.circularreveal.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0232b implements TypeEvaluator<e> {

        /* renamed from: b, reason: collision with root package name */
        public static final TypeEvaluator<e> f33503b = new C0232b();

        /* renamed from: a, reason: collision with root package name */
        private final e f33504a = new e();

        @Override // android.animation.TypeEvaluator
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e evaluate(float f16, @NonNull e eVar, @NonNull e eVar2) {
            this.f33504a.b(e1.a.d(eVar.f33507a, eVar2.f33507a, f16), e1.a.d(eVar.f33508b, eVar2.f33508b, f16), e1.a.d(eVar.f33509c, eVar2.f33509c, f16));
            return this.f33504a;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class c extends Property<b, e> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<b, e> f33505a = new c("circularReveal");

        c(String str) {
            super(e.class, str);
        }

        @Override // android.util.Property
        @Nullable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e get(@NonNull b bVar) {
            return bVar.f();
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull b bVar, @Nullable e eVar) {
            bVar.setRevealInfo(eVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class d extends Property<b, Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final Property<b, Integer> f33506a = new d("circularRevealScrimColor");

        d(String str) {
            super(Integer.class, str);
        }

        @Override // android.util.Property
        @NonNull
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer get(@NonNull b bVar) {
            return Integer.valueOf(bVar.d());
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(@NonNull b bVar, @NonNull Integer num) {
            bVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public float f33507a;

        /* renamed from: b, reason: collision with root package name */
        public float f33508b;

        /* renamed from: c, reason: collision with root package name */
        public float f33509c;

        public boolean a() {
            if (this.f33509c == Float.MAX_VALUE) {
                return true;
            }
            return false;
        }

        public void b(float f16, float f17, float f18) {
            this.f33507a = f16;
            this.f33508b = f17;
            this.f33509c = f18;
        }

        public void c(@NonNull e eVar) {
            b(eVar.f33507a, eVar.f33508b, eVar.f33509c);
        }

        e() {
        }

        public e(float f16, float f17, float f18) {
            this.f33507a = f16;
            this.f33508b = f17;
            this.f33509c = f18;
        }

        public e(@NonNull e eVar) {
            this(eVar.f33507a, eVar.f33508b, eVar.f33509c);
        }
    }

    void b();

    @ColorInt
    int d();

    void e();

    @Nullable
    e f();

    void setCircularRevealOverlayDrawable(@Nullable Drawable drawable);

    void setCircularRevealScrimColor(@ColorInt int i3);

    void setRevealInfo(@Nullable e eVar);
}

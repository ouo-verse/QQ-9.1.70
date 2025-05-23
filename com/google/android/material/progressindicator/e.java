package com.google.android.material.progressindicator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class e<S extends b> extends f {
    private static final FloatPropertyCompat<e> R = new a("indicatorLevel");
    private g<S> L;
    private final SpringForce M;
    private final SpringAnimation N;
    private float P;
    private boolean Q;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends FloatPropertyCompat<e> {
        a(String str) {
            super(str);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public float getValue(e eVar) {
            return eVar.A() * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void setValue(e eVar, float f16) {
            eVar.C(f16 / 10000.0f);
        }
    }

    e(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar) {
        super(context, bVar);
        this.Q = false;
        B(gVar);
        SpringForce springForce = new SpringForce();
        this.M = springForce;
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(50.0f);
        SpringAnimation springAnimation = new SpringAnimation(this, R);
        this.N = springAnimation;
        springAnimation.setSpring(springForce);
        o(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float A() {
        return this.P;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(float f16) {
        this.P = f16;
        invalidateSelf();
    }

    @NonNull
    public static e<CircularProgressIndicatorSpec> x(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new e<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec));
    }

    @NonNull
    public static e<LinearProgressIndicatorSpec> y(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return new e<>(context, linearProgressIndicatorSpec, new j(linearProgressIndicatorSpec));
    }

    void B(@NonNull g<S> gVar) {
        this.L = gVar;
        gVar.f(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(float f16) {
        setLevel((int) (f16 * 10000.0f));
    }

    @Override // com.google.android.material.progressindicator.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Rect rect = new Rect();
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(rect)) {
            canvas.save();
            this.L.g(canvas, h());
            this.L.c(canvas, this.I);
            this.L.b(canvas, this.I, 0.0f, A(), z0.a.a(this.f33976e.f33952c[0], getAlpha()));
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.L.d();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.L.e();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.N.skipToEnd();
        C(getLevel() / 10000.0f);
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        if (this.Q) {
            this.N.skipToEnd();
            C(i3 / 10000.0f);
            return true;
        }
        this.N.setStartValue(A() * 10000.0f);
        this.N.animateToFinalPosition(i3);
        return true;
    }

    @Override // com.google.android.material.progressindicator.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i3) {
        super.setAlpha(i3);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(@Nullable ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z16, boolean z17) {
        return super.setVisible(z16, z17);
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.f, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean t(boolean z16, boolean z17, boolean z18) {
        return super.t(z16, z17, z18);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.f
    public boolean u(boolean z16, boolean z17, boolean z18) {
        boolean u16 = super.u(z16, z17, z18);
        float a16 = this.f33977f.a(this.f33975d.getContentResolver());
        if (a16 == 0.0f) {
            this.Q = true;
        } else {
            this.Q = false;
            this.M.setStiffness(50.0f / a16);
        }
        return u16;
    }

    @Override // com.google.android.material.progressindicator.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public g<S> z() {
        return this.L;
    }
}

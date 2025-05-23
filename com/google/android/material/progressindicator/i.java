package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class i<S extends b> extends f {
    private g<S> L;
    private h<ObjectAnimator> M;

    i(@NonNull Context context, @NonNull b bVar, @NonNull g<S> gVar, @NonNull h<ObjectAnimator> hVar) {
        super(context, bVar);
        A(gVar);
        z(hVar);
    }

    @NonNull
    public static i<CircularProgressIndicatorSpec> v(@NonNull Context context, @NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return new i<>(context, circularProgressIndicatorSpec, new c(circularProgressIndicatorSpec), new d(circularProgressIndicatorSpec));
    }

    @NonNull
    public static i<LinearProgressIndicatorSpec> w(@NonNull Context context, @NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        h lVar;
        j jVar = new j(linearProgressIndicatorSpec);
        if (linearProgressIndicatorSpec.f33947g == 0) {
            lVar = new k(linearProgressIndicatorSpec);
        } else {
            lVar = new l(context, linearProgressIndicatorSpec);
        }
        return new i<>(context, linearProgressIndicatorSpec, jVar, lVar);
    }

    void A(@NonNull g<S> gVar) {
        this.L = gVar;
        gVar.f(this);
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
            int i3 = 0;
            while (true) {
                h<ObjectAnimator> hVar = this.M;
                int[] iArr = hVar.f33987c;
                if (i3 < iArr.length) {
                    g<S> gVar = this.L;
                    Paint paint = this.I;
                    float[] fArr = hVar.f33986b;
                    int i16 = i3 * 2;
                    gVar.b(canvas, paint, fArr[i16], fArr[i16 + 1], iArr[i3]);
                    i3++;
                } else {
                    canvas.restore();
                    return;
                }
            }
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

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    @Override // com.google.android.material.progressindicator.f
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
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
        if (!isRunning()) {
            this.M.a();
        }
        this.f33977f.a(this.f33975d.getContentResolver());
        if (z16 && z18) {
            this.M.g();
        }
        return u16;
    }

    @Override // com.google.android.material.progressindicator.f, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(@NonNull Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public h<ObjectAnimator> x() {
        return this.M;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public g<S> y() {
        return this.L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(@NonNull h<ObjectAnimator> hVar) {
        this.M = hVar;
        hVar.e(this);
    }
}

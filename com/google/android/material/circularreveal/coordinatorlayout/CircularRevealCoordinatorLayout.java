package com.google.android.material.circularreveal.coordinatorlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CircularRevealCoordinatorLayout extends CoordinatorLayout implements b {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final CircularRevealHelper f33510d;

    public CircularRevealCoordinatorLayout(@NonNull Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.b
    public void b() {
        this.f33510d.a();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public int d() {
        return this.f33510d.e();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f33510d;
        if (circularRevealHelper != null) {
            circularRevealHelper.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.b
    public void e() {
        this.f33510d.b();
    }

    @Override // com.google.android.material.circularreveal.b
    @Nullable
    public b.e f() {
        return this.f33510d.g();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f33510d;
        if (circularRevealHelper != null) {
            return circularRevealHelper.i();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f33510d.j(drawable);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealScrimColor(@ColorInt int i3) {
        this.f33510d.k(i3);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.f33510d.l(eVar);
    }

    public CircularRevealCoordinatorLayout(@NonNull Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33510d = new CircularRevealHelper(this);
    }
}

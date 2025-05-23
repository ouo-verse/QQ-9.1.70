package com.google.android.material.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.circularreveal.b;

/* compiled from: P */
/* loaded from: classes2.dex */
public class CircularRevealRelativeLayout extends RelativeLayout implements b {

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final CircularRevealHelper f33501d;

    public CircularRevealRelativeLayout(Context context) {
        this(context, null);
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public void a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // com.google.android.material.circularreveal.b
    public void b() {
        this.f33501d.a();
    }

    @Override // com.google.android.material.circularreveal.CircularRevealHelper.a
    public boolean c() {
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public int d() {
        return this.f33501d.e();
    }

    @Override // android.view.View
    public void draw(@NonNull Canvas canvas) {
        CircularRevealHelper circularRevealHelper = this.f33501d;
        if (circularRevealHelper != null) {
            circularRevealHelper.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.circularreveal.b
    public void e() {
        this.f33501d.b();
    }

    @Override // com.google.android.material.circularreveal.b
    @Nullable
    public b.e f() {
        return this.f33501d.g();
    }

    @Override // android.view.View
    public boolean isOpaque() {
        CircularRevealHelper circularRevealHelper = this.f33501d;
        if (circularRevealHelper != null) {
            return circularRevealHelper.i();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.f33501d.j(drawable);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setCircularRevealScrimColor(@ColorInt int i3) {
        this.f33501d.k(i3);
    }

    @Override // com.google.android.material.circularreveal.b
    public void setRevealInfo(@Nullable b.e eVar) {
        this.f33501d.l(eVar);
    }

    public CircularRevealRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33501d = new CircularRevealHelper(this);
    }
}

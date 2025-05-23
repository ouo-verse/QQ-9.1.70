package com.tencent.mapsdk.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qn extends Drawable {

    /* renamed from: c, reason: collision with root package name */
    private static final int f149879c = -2829100;

    /* renamed from: d, reason: collision with root package name */
    private static final int f149880d = -10066330;

    /* renamed from: e, reason: collision with root package name */
    private static final int f149881e = 16777215;

    /* renamed from: a, reason: collision with root package name */
    boolean f149882a = false;

    /* renamed from: b, reason: collision with root package name */
    boolean f149883b;

    /* renamed from: f, reason: collision with root package name */
    private Paint f149884f;

    public qn() {
        Paint paint = new Paint();
        this.f149884f = paint;
        paint.setAntiAlias(true);
        this.f149884f.setStrokeJoin(Paint.Join.BEVEL);
    }

    private void b(boolean z16) {
        this.f149883b = z16;
    }

    public final void a(float f16) {
        this.f149884f.setStrokeWidth(f16);
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        int i3;
        if (this.f149882a) {
            Paint paint = this.f149884f;
            if (this.f149883b) {
                i3 = f149880d;
            } else {
                i3 = f149879c;
            }
            paint.setColor(i3);
        } else {
            this.f149884f.setColor(16777215);
        }
        canvas.drawLines(new float[]{0.0f, getBounds().height(), getBounds().width() / 2.0f, 0.0f, getBounds().width() / 2.0f, 0.0f, getBounds().width(), getBounds().height()}, this.f149884f);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return getBounds().height();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return getBounds().width();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i3) {
        this.f149884f.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f149884f.setColorFilter(colorFilter);
    }

    private void a(boolean z16) {
        this.f149882a = z16;
    }
}

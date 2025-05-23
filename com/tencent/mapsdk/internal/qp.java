package com.tencent.mapsdk.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qp extends Drawable {

    /* renamed from: a, reason: collision with root package name */
    private static final int f149886a = -12028419;

    /* renamed from: b, reason: collision with root package name */
    private Paint f149887b;

    public qp() {
        Paint paint = new Paint();
        this.f149887b = paint;
        paint.setAntiAlias(true);
        if (tf.f150436c.equals("wechat")) {
            this.f149887b.setColor(-16531104);
        } else {
            this.f149887b.setColor(f149886a);
        }
    }

    private void a(int i3) {
        this.f149887b.setColor(i3);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(getBounds().width() / 2.0f, getBounds().height() / 2.0f, getBounds().width() / 2.0f, this.f149887b);
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
        this.f149887b.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f149887b.setColorFilter(colorFilter);
    }
}

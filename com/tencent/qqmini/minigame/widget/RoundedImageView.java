package com.tencent.qqmini.minigame.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class RoundedImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private Paint f346887d;

    /* renamed from: e, reason: collision with root package name */
    private Path f346888e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f346889f;

    /* renamed from: h, reason: collision with root package name */
    private int f346890h;

    public RoundedImageView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.f346887d = paint;
        paint.setAntiAlias(true);
        this.f346887d.setDither(true);
        this.f346888e = new Path();
        this.f346889f = new RectF();
        this.f346890h = 26;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        this.f346888e.reset();
        this.f346889f.set(0.0f, 0.0f, getWidth(), getHeight());
        Path path = this.f346888e;
        RectF rectF = this.f346889f;
        int i3 = this.f346890h;
        path.addRoundRect(rectF, i3, i3, Path.Direction.CW);
        canvas.clipPath(this.f346888e);
        canvas.drawRect(this.f346889f, this.f346887d);
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        super.onDraw(canvas);
    }

    public void setRadius(int i3) {
        this.f346890h = i3;
        invalidate();
    }

    public RoundedImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }
}

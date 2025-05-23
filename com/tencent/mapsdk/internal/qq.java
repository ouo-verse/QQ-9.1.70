package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class qq extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Path f149888a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f149889b;

    /* renamed from: c, reason: collision with root package name */
    private Paint f149890c;

    /* renamed from: d, reason: collision with root package name */
    private RectF f149891d;

    /* renamed from: e, reason: collision with root package name */
    private float f149892e;

    /* renamed from: f, reason: collision with root package name */
    private float f149893f;

    /* renamed from: g, reason: collision with root package name */
    private int f149894g;

    public qq(Context context) {
        super(context);
        this.f149894g = -1;
        a();
    }

    private void a() {
        this.f149893f = getResources().getDisplayMetrics().density / 2.0f;
        this.f149888a = new Path();
        b();
    }

    private void b() {
        Paint paint = new Paint();
        this.f149889b = paint;
        paint.setColor(this.f149894g);
        this.f149889b.setAntiAlias(true);
        this.f149889b.setStyle(Paint.Style.FILL);
        this.f149889b.setShadowLayer(this.f149893f, 0.0f, 0.0f, -1);
        Paint paint2 = new Paint();
        this.f149890c = paint2;
        paint2.setColor(this.f149894g);
        this.f149890c.setAntiAlias(true);
        this.f149890c.setStyle(Paint.Style.STROKE);
        this.f149890c.setShadowLayer(this.f149893f, 0.0f, 0.0f, -16777216);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(this.f149891d, null, 31);
        canvas.drawColor(this.f149894g);
        canvas.drawPath(this.f149888a, this.f149890c);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f149889b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.f149888a, this.f149889b);
        } else {
            this.f149889b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path = new Path();
            path.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CW);
            path.op(this.f149888a, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.f149889b);
        }
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected final void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.f149891d == null) {
            this.f149891d = new RectF();
        }
        this.f149891d.right = getMeasuredWidth();
        this.f149891d.bottom = getMeasuredHeight();
        if (this.f149891d.width() < this.f149891d.height()) {
            this.f149892e = this.f149891d.width() / 2.0f;
        } else {
            this.f149892e = this.f149891d.height() / 2.0f;
        }
        this.f149888a.reset();
        Path path = this.f149888a;
        RectF rectF = this.f149891d;
        float f16 = this.f149892e;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
    }

    public final void setDarkStyle(boolean z16) {
        if (z16) {
            this.f149894g = Color.parseColor("#2C2C2C");
        } else {
            this.f149894g = -1;
        }
        b();
        invalidate();
    }

    qq(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f149894g = -1;
        a();
    }

    private void a(Canvas canvas) {
        if (Build.VERSION.SDK_INT <= 27) {
            this.f149889b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.f149888a, this.f149889b);
            return;
        }
        this.f149889b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(0.0f, 0.0f, getWidth(), getHeight(), Path.Direction.CW);
        path.op(this.f149888a, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.f149889b);
    }
}

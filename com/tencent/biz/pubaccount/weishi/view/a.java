package com.tencent.biz.pubaccount.weishi.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.view.View;

/* compiled from: P */
/* loaded from: classes32.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public Path f82434a;

    /* renamed from: b, reason: collision with root package name */
    public Paint f82435b;

    /* renamed from: c, reason: collision with root package name */
    public int f82436c;

    /* renamed from: d, reason: collision with root package name */
    public int f82437d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f82438e;

    /* renamed from: f, reason: collision with root package name */
    public Region f82439f;

    /* renamed from: g, reason: collision with root package name */
    public RectF f82440g;

    public void a() {
        this.f82440g = new RectF();
        this.f82434a = new Path();
        this.f82439f = new Region();
        Paint paint = new Paint();
        this.f82435b = paint;
        paint.setColor(-1);
        this.f82435b.setAntiAlias(true);
    }

    public void b(Canvas canvas) {
        if (this.f82437d > 0) {
            this.f82435b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.f82435b.setColor(-1);
            this.f82435b.setStrokeWidth(this.f82437d * 2);
            this.f82435b.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f82434a, this.f82435b);
            this.f82435b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.f82435b.setColor(this.f82436c);
            this.f82435b.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f82434a, this.f82435b);
        }
        this.f82435b.setColor(-1);
        this.f82435b.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f82435b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.f82434a, this.f82435b);
            return;
        }
        this.f82435b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        Path path = new Path();
        path.addRect(0.0f, 0.0f, (int) this.f82440g.width(), (int) this.f82440g.height(), Path.Direction.CW);
        path.op(this.f82434a, Path.Op.DIFFERENCE);
        canvas.drawPath(path, this.f82435b);
    }

    public void c(View view, int i3, int i16) {
        this.f82440g.set(0.0f, 0.0f, i3, i16);
        d(view);
    }

    public void d(View view) {
        float width;
        RectF rectF = new RectF();
        int width2 = (int) this.f82440g.width();
        int height = (int) this.f82440g.height();
        rectF.right = width2 - view.getPaddingRight();
        rectF.bottom = height - view.getPaddingBottom();
        rectF.left = view.getPaddingLeft();
        rectF.top = view.getPaddingTop();
        this.f82434a.reset();
        if (rectF.width() >= rectF.height()) {
            width = rectF.height();
        } else {
            width = rectF.width();
        }
        float f16 = width / 2.0f;
        float f17 = height / 2;
        PointF pointF = new PointF(width2 / 2, f17);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f82434a.addCircle(pointF.x, pointF.y, f16, Path.Direction.CW);
            this.f82434a.moveTo(0.0f, 0.0f);
            this.f82434a.moveTo(width2, height);
        } else {
            float f18 = f17 - f16;
            this.f82434a.moveTo(rectF.left, f18);
            this.f82434a.addCircle(pointF.x, f18 + f16, f16, Path.Direction.CW);
        }
        this.f82439f.setPath(this.f82434a, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}

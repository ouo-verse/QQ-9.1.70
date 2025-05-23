package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f implements e {

    /* renamed from: a, reason: collision with root package name */
    private Paint f68340a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f68341b;

    /* renamed from: c, reason: collision with root package name */
    private o f68342c;

    /* renamed from: d, reason: collision with root package name */
    private int f68343d = BaseAIOUtils.f(6.0f, BaseApplication.getContext().getResources());

    /* renamed from: e, reason: collision with root package name */
    public float f68344e;

    /* renamed from: f, reason: collision with root package name */
    public float f68345f;

    /* renamed from: g, reason: collision with root package name */
    private b f68346g;

    public f(b bVar) {
        Paint paint = new Paint();
        this.f68340a = paint;
        paint.setAntiAlias(true);
        this.f68340a.setStyle(Paint.Style.STROKE);
        this.f68340a.setStrokeJoin(Paint.Join.ROUND);
        this.f68340a.setStrokeCap(Paint.Cap.ROUND);
        this.f68340a.setStrokeWidth(this.f68343d);
        this.f68340a.setColor(-1);
        this.f68340a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint();
        this.f68341b = paint2;
        paint2.setAntiAlias(true);
        this.f68341b.setStyle(Paint.Style.STROKE);
        this.f68341b.setStrokeJoin(Paint.Join.ROUND);
        this.f68341b.setStrokeCap(Paint.Cap.ROUND);
        this.f68341b.setColor(-1);
        this.f68341b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f68346g = bVar;
    }

    private void f(Paint paint, o oVar) {
        paint.setStrokeWidth(oVar.f68429d);
        paint.setShader(null);
    }

    public void a(Canvas canvas, c cVar, Paint paint) {
        if (cVar instanceof o) {
            o oVar = (o) cVar;
            if (oVar.f68427b != null) {
                f(paint, oVar);
                canvas.drawPath(oVar.f68427b, paint);
            }
        }
    }

    public Paint b() {
        return this.f68340a;
    }

    public Paint c() {
        return this.f68341b;
    }

    public void e() {
        this.f68340a.setStrokeWidth(this.f68343d);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                return true;
            }
            float f16 = this.f68344e;
            float f17 = (x16 + f16) / 2.0f;
            float f18 = this.f68345f;
            float f19 = (y16 + f18) / 2.0f;
            o oVar = this.f68342c;
            if (oVar != null) {
                oVar.f68427b.quadTo(f16, f18, f17, f19);
                this.f68342c.f68430e.add(new n(n.f68421h, this.f68344e, this.f68345f, f17, f19));
            }
            this.f68344e = x16;
            this.f68345f = y16;
            return true;
        }
        this.f68344e = x16;
        this.f68345f = y16;
        o oVar2 = new o(new Path(), 111, this.f68340a.getColor(), this.f68343d);
        this.f68342c = oVar2;
        b bVar = this.f68346g;
        if (bVar != null) {
            bVar.d(oVar2);
        }
        this.f68342c.f68427b.reset();
        this.f68342c.f68427b.moveTo(x16, y16);
        float f26 = x16 + 1.0f;
        float f27 = 1.0f + y16;
        this.f68342c.f68427b.lineTo(f26, f27);
        this.f68342c.f68430e.add(new n(n.f68419f, x16, y16));
        this.f68342c.f68430e.add(new n(n.f68420g, f26, f27));
        return true;
    }

    public void d() {
        this.f68342c = null;
    }

    public void g(float f16) {
        this.f68343d = (int) f16;
        this.f68340a.setStrokeWidth(f16);
    }
}

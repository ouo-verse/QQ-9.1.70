package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;

/* compiled from: P */
/* loaded from: classes32.dex */
public class p implements e {

    /* renamed from: a, reason: collision with root package name */
    private Paint f68431a;

    /* renamed from: b, reason: collision with root package name */
    private Paint f68432b;

    /* renamed from: c, reason: collision with root package name */
    private o f68433c;

    /* renamed from: d, reason: collision with root package name */
    private int f68434d;

    /* renamed from: e, reason: collision with root package name */
    private int f68435e;

    /* renamed from: f, reason: collision with root package name */
    public float f68436f;

    /* renamed from: g, reason: collision with root package name */
    public float f68437g;

    /* renamed from: h, reason: collision with root package name */
    private b f68438h;

    public p(b bVar) {
        Paint paint = new Paint();
        this.f68431a = paint;
        paint.setAntiAlias(true);
        this.f68431a.setStyle(Paint.Style.STROKE);
        this.f68431a.setStrokeJoin(Paint.Join.ROUND);
        this.f68431a.setStrokeCap(Paint.Cap.ROUND);
        Paint paint2 = new Paint();
        this.f68432b = paint2;
        paint2.setAntiAlias(true);
        this.f68432b.setStyle(Paint.Style.STROKE);
        this.f68432b.setStrokeJoin(Paint.Join.ROUND);
        this.f68432b.setStrokeCap(Paint.Cap.ROUND);
        this.f68438h = bVar;
    }

    public void a(Canvas canvas, c cVar, Paint paint) {
        if (cVar instanceof o) {
            o oVar = (o) cVar;
            if (oVar.f68427b != null) {
                h(paint, oVar);
                canvas.drawPath(oVar.f68427b, paint);
            }
        }
    }

    public Paint b() {
        return this.f68431a;
    }

    public Paint c() {
        return this.f68432b;
    }

    public void e() {
        this.f68431a.setXfermode(null);
        this.f68431a.setColor(this.f68434d);
        this.f68431a.setStrokeWidth(this.f68435e);
    }

    public void f(int i3) {
        this.f68431a.setColor(i3);
        this.f68434d = i3;
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
            float f16 = this.f68436f;
            float f17 = (x16 + f16) / 2.0f;
            float f18 = this.f68437g;
            float f19 = (y16 + f18) / 2.0f;
            o oVar = this.f68433c;
            if (oVar != null) {
                oVar.f68427b.quadTo(f16, f18, f17, f19);
                this.f68433c.f68430e.add(new n(n.f68421h, this.f68436f, this.f68437g, f17, f19));
            }
            this.f68436f = x16;
            this.f68437g = y16;
            return true;
        }
        this.f68436f = x16;
        this.f68437g = y16;
        o oVar2 = new o(new Path(), 101, this.f68431a.getColor(), this.f68435e);
        this.f68433c = oVar2;
        b bVar = this.f68438h;
        if (bVar != null) {
            bVar.d(oVar2);
        }
        DoodleLayout.P1("use_graffiti");
        this.f68433c.f68427b.reset();
        this.f68433c.f68427b.moveTo(x16, y16);
        float f26 = x16 + 1.0f;
        float f27 = 1.0f + y16;
        this.f68433c.f68427b.lineTo(f26, f27);
        this.f68433c.f68430e.add(new n(n.f68419f, x16, y16));
        this.f68433c.f68430e.add(new n(n.f68420g, f26, f27));
        return true;
    }

    private void h(Paint paint, o oVar) {
        paint.setXfermode(null);
        paint.setColor(oVar.f68428c);
        paint.setStrokeWidth(oVar.f68429d);
        paint.setShader(null);
    }

    public void d() {
        this.f68433c = null;
    }

    public void g(float f16) {
        this.f68435e = (int) f16;
        this.f68431a.setStrokeWidth(f16);
    }
}

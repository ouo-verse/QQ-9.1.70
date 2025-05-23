package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RegionView extends View {
    static IPatchRedirector $redirector_;
    int C;
    boolean D;
    float E;
    private PortraitImageview F;
    Rect[] G;
    Rect H;

    /* renamed from: d, reason: collision with root package name */
    final Rect f184078d;

    /* renamed from: e, reason: collision with root package name */
    final Paint f184079e;

    /* renamed from: f, reason: collision with root package name */
    int f184080f;

    /* renamed from: h, reason: collision with root package name */
    int f184081h;

    /* renamed from: i, reason: collision with root package name */
    int f184082i;

    /* renamed from: m, reason: collision with root package name */
    int f184083m;

    public RegionView(Context context, PortraitImageview portraitImageview, int i3, int i16, int i17, boolean z16) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, portraitImageview, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Boolean.valueOf(z16));
            return;
        }
        this.f184078d = new Rect();
        this.f184079e = new Paint();
        this.E = 0.0f;
        portraitImageview.setRegionView(this);
        this.F = portraitImageview;
        this.f184082i = i3;
        this.f184083m = i16;
        this.C = i17;
        this.D = z16;
    }

    private RectF b() {
        RectF rectF = new RectF();
        rectF.set(this.f184078d);
        rectF.left -= 2.0f;
        rectF.right += 2.0f;
        rectF.top -= 2.0f;
        rectF.bottom += 2.0f;
        return rectF;
    }

    public Bitmap a() {
        Bitmap.Config config;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Bitmap) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Matrix e16 = this.F.e();
        RectF g16 = this.F.g();
        e16.postTranslate(-g16.left, -g16.top);
        e16.postScale(this.f184082i / g16.width(), this.f184083m / g16.height(), 0.0f, 0.0f);
        int i3 = this.f184082i;
        int i16 = this.f184083m;
        if (this.D) {
            config = Bitmap.Config.ARGB_8888;
        } else {
            config = Bitmap.Config.RGB_565;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
        Bitmap d16 = this.F.d();
        if (createBitmap != null && d16 != null) {
            new Canvas(createBitmap).drawBitmap(d16, e16, new Paint(6));
        }
        return createBitmap;
    }

    public Rect c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Rect) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        Matrix e16 = this.F.e();
        RectF g16 = this.F.g();
        Bitmap d16 = this.F.d();
        Matrix matrix = new Matrix();
        e16.invert(matrix);
        RectF rectF = new RectF();
        matrix.mapRect(rectF, g16);
        if (QLog.isColorLevel()) {
            QLog.i("RegionView", 2, String.format("getClipInfo src=[%.0f,%.0f,%.0f,%.0f],dst=[%.0f,%.0f,%.0f,%.0f],[tW,tH]=[%d,%d]", Float.valueOf(g16.left), Float.valueOf(g16.top), Float.valueOf(g16.right), Float.valueOf(g16.bottom), Float.valueOf(rectF.left), Float.valueOf(rectF.top), Float.valueOf(rectF.right), Float.valueOf(rectF.bottom), Integer.valueOf(d16.getWidth()), Integer.valueOf(d16.getHeight())));
        }
        Rect rect = new Rect();
        rectF.round(rect);
        rect.left = Math.max(rect.left, 0);
        rect.top = Math.max(rect.top, 0);
        rect.right = Math.min(rect.right, d16.getWidth());
        rect.bottom = Math.min(rect.bottom, d16.getHeight());
        return rect;
    }

    public Bitmap d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.F.d();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        PortraitImageview portraitImageview = this.F;
        if (portraitImageview != null) {
            this.f184080f = portraitImageview.c();
            this.f184081h = this.F.b();
        }
        this.f184078d.left = (getWidth() - this.f184080f) / 2;
        this.f184078d.right = (getWidth() + this.f184080f) / 2;
        this.f184078d.top = (getHeight() - this.f184081h) / 2;
        this.f184078d.bottom = (getHeight() + this.f184081h) / 2;
        if (this.C == 0) {
            this.f184079e.setColor(1711276032);
            this.f184079e.setStyle(Paint.Style.FILL);
            Path path = new Path();
            Rect rect = this.f184078d;
            float height = rect.top + (rect.height() * 0.5f);
            path.moveTo(getWidth(), height);
            Rect rect2 = this.f184078d;
            path.addArc(new RectF(rect2.left, rect2.top, rect2.right, rect2.bottom), 0.0f, -360.0f);
            path.moveTo(getWidth(), height);
            path.lineTo(getWidth(), getHeight());
            path.lineTo(0.0f, getHeight());
            path.lineTo(0.0f, 0.0f);
            path.lineTo(getWidth(), 0.0f);
            path.moveTo(getWidth(), height);
            path.close();
            canvas.drawPath(path, this.f184079e);
            this.f184079e.setAntiAlias(true);
            this.f184079e.setStyle(Paint.Style.STROKE);
            this.f184079e.setColor(1291845632);
            this.f184079e.setStrokeWidth(5.0f);
            Rect rect3 = this.f184078d;
            canvas.drawCircle(rect3.left + (rect3.width() * 0.5f), height, this.f184078d.width() * 0.5f, this.f184079e);
            this.f184079e.setColor(-1);
            this.f184079e.setStrokeWidth(3.0f);
            Rect rect4 = this.f184078d;
            canvas.drawCircle(rect4.left + (rect4.width() * 0.5f), height, this.f184078d.width() * 0.5f, this.f184079e);
            return;
        }
        Rect rect5 = this.f184078d;
        Rect rect6 = this.f184078d;
        Rect rect7 = this.f184078d;
        Rect rect8 = this.f184078d;
        Rect rect9 = this.f184078d;
        Rect rect10 = this.f184078d;
        Rect rect11 = this.f184078d;
        this.G = new Rect[]{new Rect(0, 0, rect5.left, rect5.top), new Rect(rect6.left, 0, rect6.right, rect6.top), new Rect(this.f184078d.right, 0, getWidth(), this.f184078d.top), new Rect(0, rect7.top, rect7.left, rect7.bottom), new Rect(rect8.right, rect8.top, getWidth(), this.f184078d.bottom), new Rect(0, rect9.bottom, rect9.left, getHeight()), new Rect(rect10.left, rect10.bottom, rect10.right, getHeight()), new Rect(rect11.right, rect11.bottom, getWidth(), getHeight())};
        Rect rect12 = new Rect();
        this.H = rect12;
        rect12.set(this.f184078d);
        Rect rect13 = this.H;
        rect13.left -= 2;
        rect13.right += 2;
        rect13.top -= 2;
        rect13.bottom += 2;
        this.f184079e.setColor(1711276032);
        this.f184079e.setStyle(Paint.Style.FILL);
        int i3 = 0;
        while (true) {
            Rect[] rectArr = this.G;
            if (i3 < rectArr.length) {
                canvas.drawRect(rectArr[i3], this.f184079e);
                i3++;
            } else {
                this.f184079e.setColor(0);
                canvas.drawRect(this.H, this.f184079e);
                this.f184079e.setStyle(Paint.Style.STROKE);
                this.f184079e.setStrokeWidth(5.0f);
                this.f184079e.setColor(1291845632);
                canvas.drawRect(this.H, this.f184079e);
                this.f184079e.setStyle(Paint.Style.STROKE);
                this.f184079e.setStrokeWidth(3.0f);
                this.f184079e.setColor(-1);
                RectF b16 = b();
                float f16 = this.E;
                canvas.drawRoundRect(b16, f16, f16, this.f184079e);
                return;
            }
        }
    }

    public void setBorderRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        } else {
            this.E = f16;
        }
    }
}

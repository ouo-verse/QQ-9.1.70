package com.tencent.mobileqq.qqlive.room.widget;

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

/* compiled from: P */
/* loaded from: classes17.dex */
public class RegionView extends View {
    static IPatchRedirector $redirector_;
    int C;
    int D;
    int E;
    private PortraitImageView F;
    private Rect[] G;
    private Rect H;
    private RectF I;
    private Path J;
    private Bitmap K;

    /* renamed from: d, reason: collision with root package name */
    final Rect f272146d;

    /* renamed from: e, reason: collision with root package name */
    final Paint f272147e;

    /* renamed from: f, reason: collision with root package name */
    int f272148f;

    /* renamed from: h, reason: collision with root package name */
    int f272149h;

    /* renamed from: i, reason: collision with root package name */
    int f272150i;

    /* renamed from: m, reason: collision with root package name */
    int f272151m;

    public RegionView(Context context, PortraitImageView portraitImageView, int i3, int i16, int i17, int i18, int i19) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, portraitImageView, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19));
            return;
        }
        this.f272146d = new Rect();
        this.f272147e = new Paint();
        this.H = new Rect();
        this.I = new RectF();
        this.J = new Path();
        portraitImageView.setRegionView(this);
        this.F = portraitImageView;
        this.f272150i = i3;
        this.f272151m = i16;
        this.C = i17;
        this.D = i18;
        this.E = i19;
        this.G = new Rect[]{new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect()};
    }

    public Bitmap a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bitmap) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        Matrix e16 = this.F.e();
        RectF g16 = this.F.g();
        e16.postTranslate(-g16.left, -g16.top);
        e16.postScale(this.f272150i / g16.width(), this.f272151m / g16.height(), 0.0f, 0.0f);
        Bitmap createBitmap = Bitmap.createBitmap(this.f272150i, this.f272151m, Bitmap.Config.RGB_565);
        Bitmap d16 = this.F.d();
        if (createBitmap != null && d16 != null) {
            new Canvas(createBitmap).drawBitmap(d16, e16, new Paint(6));
        }
        return createBitmap;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.f272150i != 0 && this.f272151m != 0) {
            PortraitImageView portraitImageView = this.F;
            if (portraitImageView != null) {
                this.f272148f = portraitImageView.c();
                this.f272149h = this.F.b();
            }
            int i3 = this.D;
            if (i3 == 0) {
                this.f272146d.left = (getWidth() - this.f272148f) / 2;
                this.f272146d.right = (getWidth() + this.f272148f) / 2;
            } else {
                Rect rect = this.f272146d;
                rect.left = i3;
                rect.right = this.f272148f + i3;
            }
            int i16 = this.E;
            if (i16 == 0) {
                this.f272146d.top = (getHeight() - this.f272149h) / 2;
                this.f272146d.bottom = (getHeight() + this.f272149h) / 2;
            } else {
                Rect rect2 = this.f272146d;
                rect2.top = i16;
                rect2.bottom = this.f272149h + i16;
            }
            if (this.C == 0) {
                this.f272147e.setColor(1711276032);
                this.f272147e.setStyle(Paint.Style.FILL);
                Rect rect3 = this.f272146d;
                float height = rect3.top + (rect3.height() * 0.5f);
                this.J.reset();
                this.J.moveTo(getWidth(), height);
                RectF rectF = this.I;
                Rect rect4 = this.f272146d;
                rectF.set(rect4.left, rect4.top, rect4.right, rect4.bottom);
                this.J.addArc(this.I, 0.0f, -360.0f);
                this.J.moveTo(getWidth(), height);
                this.J.lineTo(getWidth(), getHeight());
                this.J.lineTo(0.0f, getHeight());
                this.J.lineTo(0.0f, 0.0f);
                this.J.lineTo(getWidth(), 0.0f);
                this.J.moveTo(getWidth(), height);
                this.J.close();
                canvas.drawPath(this.J, this.f272147e);
                this.f272147e.setAntiAlias(true);
                this.f272147e.setStyle(Paint.Style.STROKE);
                this.f272147e.setColor(1291845632);
                this.f272147e.setStrokeWidth(5.0f);
                Rect rect5 = this.f272146d;
                canvas.drawCircle(rect5.left + (rect5.width() * 0.5f), height, this.f272146d.width() * 0.5f, this.f272147e);
                this.f272147e.setColor(-1);
                this.f272147e.setStrokeWidth(3.0f);
                Rect rect6 = this.f272146d;
                canvas.drawCircle(rect6.left + (rect6.width() * 0.5f), height, this.f272146d.width() * 0.5f, this.f272147e);
                return;
            }
            Rect rect7 = this.G[0];
            Rect rect8 = this.f272146d;
            rect7.set(0, 0, rect8.left, rect8.top);
            Rect rect9 = this.G[1];
            Rect rect10 = this.f272146d;
            rect9.set(rect10.left, 0, rect10.right, rect10.top);
            this.G[2].set(this.f272146d.right, 0, getWidth(), this.f272146d.top);
            Rect rect11 = this.G[3];
            Rect rect12 = this.f272146d;
            rect11.set(0, rect12.top, rect12.left, rect12.bottom);
            Rect rect13 = this.G[4];
            Rect rect14 = this.f272146d;
            rect13.set(rect14.right, rect14.top, getWidth(), this.f272146d.bottom);
            Rect rect15 = this.G[5];
            Rect rect16 = this.f272146d;
            rect15.set(0, rect16.bottom, rect16.left, getHeight());
            Rect rect17 = this.G[6];
            Rect rect18 = this.f272146d;
            rect17.set(rect18.left, rect18.bottom, rect18.right, getHeight());
            Rect rect19 = this.G[7];
            Rect rect20 = this.f272146d;
            rect19.set(rect20.right, rect20.bottom, getWidth(), getHeight());
            this.H.set(this.f272146d);
            Rect rect21 = this.H;
            rect21.left -= 2;
            rect21.right += 2;
            rect21.top -= 2;
            rect21.bottom += 2;
            this.f272147e.setColor(1711276032);
            this.f272147e.setStyle(Paint.Style.FILL);
            int i17 = 0;
            while (true) {
                Rect[] rectArr = this.G;
                if (i17 >= rectArr.length) {
                    break;
                }
                canvas.drawRect(rectArr[i17], this.f272147e);
                i17++;
            }
            this.f272147e.setColor(0);
            canvas.drawRect(this.H, this.f272147e);
            this.f272147e.setStyle(Paint.Style.STROKE);
            this.f272147e.setStrokeWidth(5.0f);
            this.f272147e.setColor(1291845632);
            canvas.drawRect(this.H, this.f272147e);
            this.f272147e.setStyle(Paint.Style.STROKE);
            this.f272147e.setStrokeWidth(3.0f);
            this.f272147e.setColor(-1);
            Bitmap bitmap = this.K;
            if (bitmap != null) {
                Rect rect22 = this.H;
                canvas.drawBitmap(bitmap, rect22.left, rect22.top, this.f272147e);
            } else {
                canvas.drawRect(this.H, this.f272147e);
            }
        }
    }

    public void setCropBitmap(Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bitmap);
        } else {
            this.K = bitmap;
        }
    }
}

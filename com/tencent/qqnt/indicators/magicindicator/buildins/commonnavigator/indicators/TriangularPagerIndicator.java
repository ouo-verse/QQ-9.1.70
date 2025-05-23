package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.indicators.magicindicator.buildins.a;

/* loaded from: classes24.dex */
public class TriangularPagerIndicator extends View {
    static IPatchRedirector $redirector_;
    private float C;
    private Path D;
    private Interpolator E;
    private float F;

    /* renamed from: d, reason: collision with root package name */
    private Paint f357079d;

    /* renamed from: e, reason: collision with root package name */
    private int f357080e;

    /* renamed from: f, reason: collision with root package name */
    private int f357081f;

    /* renamed from: h, reason: collision with root package name */
    private int f357082h;

    /* renamed from: i, reason: collision with root package name */
    private int f357083i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f357084m;

    public TriangularPagerIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = new Path();
        this.E = new LinearInterpolator();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.f357079d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f357080e = a.a(context, 3.0d);
        this.f357083i = a.a(context, 14.0d);
        this.f357082h = a.a(context, 8.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        this.f357079d.setColor(this.f357081f);
        if (this.f357084m) {
            canvas.drawRect(0.0f, (getHeight() - this.C) - this.f357082h, getWidth(), ((getHeight() - this.C) - this.f357082h) + this.f357080e, this.f357079d);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.f357080e) - this.C, getWidth(), getHeight() - this.C, this.f357079d);
        }
        this.D.reset();
        if (this.f357084m) {
            this.D.moveTo(this.F - (this.f357083i / 2), (getHeight() - this.C) - this.f357082h);
            this.D.lineTo(this.F, getHeight() - this.C);
            this.D.lineTo(this.F + (this.f357083i / 2), (getHeight() - this.C) - this.f357082h);
        } else {
            this.D.moveTo(this.F - (this.f357083i / 2), getHeight() - this.C);
            this.D.lineTo(this.F, (getHeight() - this.f357082h) - this.C);
            this.D.lineTo(this.F + (this.f357083i / 2), getHeight() - this.C);
        }
        this.D.close();
        canvas.drawPath(this.D, this.f357079d);
    }

    public void setLineColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.f357081f = i3;
        }
    }

    public void setLineHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f357080e = i3;
        }
    }

    public void setReverse(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, z16);
        } else {
            this.f357084m = z16;
        }
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) interpolator);
            return;
        }
        this.E = interpolator;
        if (interpolator == null) {
            this.E = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f357082h = i3;
        }
    }

    public void setTriangleWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f357083i = i3;
        }
    }

    public void setYOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, Float.valueOf(f16));
        } else {
            this.C = f16;
        }
    }
}

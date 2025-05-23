package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.indicators.magicindicator.buildins.a;

/* loaded from: classes24.dex */
public class WrapPagerIndicator extends View {
    static IPatchRedirector $redirector_;
    private Paint C;
    private RectF D;
    private boolean E;

    /* renamed from: d, reason: collision with root package name */
    private int f357085d;

    /* renamed from: e, reason: collision with root package name */
    private int f357086e;

    /* renamed from: f, reason: collision with root package name */
    private int f357087f;

    /* renamed from: h, reason: collision with root package name */
    private float f357088h;

    /* renamed from: i, reason: collision with root package name */
    private Interpolator f357089i;

    /* renamed from: m, reason: collision with root package name */
    private Interpolator f357090m;

    public WrapPagerIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f357089i = new LinearInterpolator();
        this.f357090m = new LinearInterpolator();
        this.D = new RectF();
        a(context);
    }

    private void a(Context context) {
        Paint paint = new Paint(1);
        this.C = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f357085d = a.a(context, 6.0d);
        this.f357086e = a.a(context, 10.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        this.C.setColor(this.f357087f);
        RectF rectF = this.D;
        float f16 = this.f357088h;
        canvas.drawRoundRect(rectF, f16, f16, this.C);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) interpolator);
            return;
        }
        this.f357090m = interpolator;
        if (interpolator == null) {
            this.f357090m = new LinearInterpolator();
        }
    }

    public void setFillColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
        } else {
            this.f357087f = i3;
        }
    }

    public void setHorizontalPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f357086e = i3;
        }
    }

    public void setRoundRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
        } else {
            this.f357088h = f16;
            this.E = true;
        }
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) interpolator);
            return;
        }
        this.f357089i = interpolator;
        if (interpolator == null) {
            this.f357089i = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f357085d = i3;
        }
    }
}

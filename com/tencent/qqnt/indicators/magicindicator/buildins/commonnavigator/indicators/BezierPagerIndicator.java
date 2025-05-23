package com.tencent.qqnt.indicators.magicindicator.buildins.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.indicators.magicindicator.buildins.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes24.dex */
public class BezierPagerIndicator extends View {
    static IPatchRedirector $redirector_;
    private float C;
    private Paint D;
    private Path E;
    private List<Integer> F;
    private Interpolator G;
    private Interpolator H;

    /* renamed from: d, reason: collision with root package name */
    private float f357062d;

    /* renamed from: e, reason: collision with root package name */
    private float f357063e;

    /* renamed from: f, reason: collision with root package name */
    private float f357064f;

    /* renamed from: h, reason: collision with root package name */
    private float f357065h;

    /* renamed from: i, reason: collision with root package name */
    private float f357066i;

    /* renamed from: m, reason: collision with root package name */
    private float f357067m;

    public BezierPagerIndicator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.E = new Path();
        this.G = new AccelerateInterpolator();
        this.H = new DecelerateInterpolator();
        b(context);
    }

    private void a(Canvas canvas) {
        this.E.reset();
        float height = (getHeight() - this.f357066i) - this.f357067m;
        this.E.moveTo(this.f357065h, height);
        this.E.lineTo(this.f357065h, height - this.f357064f);
        Path path = this.E;
        float f16 = this.f357065h;
        float f17 = this.f357063e;
        path.quadTo(f16 + ((f17 - f16) / 2.0f), height, f17, height - this.f357062d);
        this.E.lineTo(this.f357063e, this.f357062d + height);
        Path path2 = this.E;
        float f18 = this.f357065h;
        path2.quadTo(((this.f357063e - f18) / 2.0f) + f18, height, f18, this.f357064f + height);
        this.E.close();
        canvas.drawPath(this.E, this.D);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.D = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f357067m = a.a(context, 3.5d);
        this.C = a.a(context, 2.0d);
        this.f357066i = a.a(context, 1.5d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        canvas.drawCircle(this.f357063e, (getHeight() - this.f357066i) - this.f357067m, this.f357062d, this.D);
        canvas.drawCircle(this.f357065h, (getHeight() - this.f357066i) - this.f357067m, this.f357064f, this.D);
        a(canvas);
    }

    public void setColors(Integer... numArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) numArr);
        } else {
            this.F = Arrays.asList(numArr);
        }
    }

    public void setEndInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) interpolator);
            return;
        }
        this.H = interpolator;
        if (interpolator == null) {
            this.H = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            this.f357067m = f16;
        }
    }

    public void setMinCircleRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
        } else {
            this.C = f16;
        }
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) interpolator);
            return;
        }
        this.G = interpolator;
        if (interpolator == null) {
            this.G = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
        } else {
            this.f357066i = f16;
        }
    }
}

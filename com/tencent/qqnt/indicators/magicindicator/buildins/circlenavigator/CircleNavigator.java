package com.tencent.qqnt.indicators.magicindicator.buildins.circlenavigator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes24.dex */
public class CircleNavigator extends View implements bx3.a {
    static IPatchRedirector $redirector_;
    private Interpolator C;
    private Paint D;
    private List<PointF> E;
    private float F;
    private boolean G;
    private float H;
    private float I;
    private int J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private int f357049d;

    /* renamed from: e, reason: collision with root package name */
    private int f357050e;

    /* renamed from: f, reason: collision with root package name */
    private int f357051f;

    /* renamed from: h, reason: collision with root package name */
    private int f357052h;

    /* renamed from: i, reason: collision with root package name */
    private int f357053i;

    /* renamed from: m, reason: collision with root package name */
    private int f357054m;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public interface a {
    }

    public CircleNavigator(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.C = new LinearInterpolator();
        this.D = new Paint(1);
        this.E = new ArrayList();
        this.K = true;
        e(context);
    }

    private void c(Canvas canvas) {
        this.D.setStyle(Paint.Style.STROKE);
        this.D.setStrokeWidth(this.f357051f);
        int size = this.E.size();
        for (int i3 = 0; i3 < size; i3++) {
            PointF pointF = this.E.get(i3);
            canvas.drawCircle(pointF.x, pointF.y, this.f357049d, this.D);
        }
    }

    private void d(Canvas canvas) {
        this.D.setStyle(Paint.Style.FILL);
        if (this.E.size() > 0) {
            canvas.drawCircle(this.F, (int) ((getHeight() / 2.0f) + 0.5f), this.f357049d, this.D);
        }
    }

    private void e(Context context) {
        this.J = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f357049d = com.tencent.qqnt.indicators.magicindicator.buildins.a.a(context, 3.0d);
        this.f357052h = com.tencent.qqnt.indicators.magicindicator.buildins.a.a(context, 8.0d);
        this.f357051f = com.tencent.qqnt.indicators.magicindicator.buildins.a.a(context, 1.0d);
    }

    private int f(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        return (this.f357049d * 2) + (this.f357051f * 2) + getPaddingTop() + getPaddingBottom();
    }

    private int g(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != Integer.MIN_VALUE && mode != 0) {
            if (mode != 1073741824) {
                return 0;
            }
            return size;
        }
        int i16 = this.f357054m;
        return (this.f357051f * 2) + (this.f357049d * i16 * 2) + ((i16 - 1) * this.f357052h) + getPaddingLeft() + getPaddingRight();
    }

    private void h() {
        this.E.clear();
        if (this.f357054m > 0) {
            int height = (int) ((getHeight() / 2.0f) + 0.5f);
            int i3 = this.f357049d;
            int i16 = (i3 * 2) + this.f357052h;
            int paddingLeft = i3 + ((int) ((this.f357051f / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i17 = 0; i17 < this.f357054m; i17++) {
                this.E.add(new PointF(paddingLeft, height));
                paddingLeft += i16;
            }
            this.F = this.E.get(this.f357053i).x;
        }
    }

    @Override // bx3.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        }
    }

    @Override // bx3.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        this.D.setColor(this.f357050e);
        c(canvas);
        d(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            h();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            setMeasuredDimension(g(i3), f(i16));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) motionEvent)).booleanValue();
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (motionEvent.getAction() == 0 && this.G) {
            this.H = x16;
            this.I = y16;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCircleClickListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) aVar);
        } else if (!this.G) {
            this.G = true;
        }
    }

    public void setCircleColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f357050e = i3;
            invalidate();
        }
    }

    public void setCircleCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.f357054m = i3;
        }
    }

    public void setCircleSpacing(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        this.f357052h = i3;
        h();
        invalidate();
    }

    public void setFollowTouch(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.K = z16;
        }
    }

    public void setRadius(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        this.f357049d = i3;
        h();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) interpolator);
            return;
        }
        this.C = interpolator;
        if (interpolator == null) {
            this.C = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3);
        } else {
            this.f357051f = i3;
            invalidate();
        }
    }

    public void setTouchable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }
}

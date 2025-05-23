package com.tencent.mobileqq.splashad.slopeslide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.gdtad.basics.adshake.animatorview.animator.KeepAnimator;
import com.tencent.gdtad.basics.adshake.animatorview.layer.PathShapeLayer;
import com.tencent.gdtad.basics.adshake.util.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b extends PathShapeLayer {
    static IPatchRedirector $redirector_;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private boolean G;
    private a H;

    /* renamed from: d, reason: collision with root package name */
    private float f288909d;

    /* renamed from: e, reason: collision with root package name */
    private Path f288910e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f288911f;

    /* renamed from: h, reason: collision with root package name */
    private final Context f288912h;

    /* renamed from: i, reason: collision with root package name */
    private Rect f288913i;

    /* renamed from: m, reason: collision with root package name */
    private float f288914m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
        void a(boolean z16, int i3, float f16, float f17);

        void b(float f16, float f17);

        void onGestureMatchStart(float f16, float f17);
    }

    public b(Context context, Rect rect, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, rect, Float.valueOf(f16));
            return;
        }
        this.F = -1;
        this.G = true;
        this.f288912h = context;
        this.f288913i = rect;
        this.f288914m = f16;
        setAnimator(new KeepAnimator(this));
    }

    private boolean a(float f16, float f17, Rect rect) {
        if (rect == null || f16 < rect.left || f16 > rect.right || f17 < rect.top || f17 > rect.bottom) {
            return false;
        }
        return true;
    }

    private void b(float f16, float f17) {
        if (!this.C) {
            this.C = true;
            if (this.f288909d - f17 >= this.f288914m) {
                this.D = true;
                Path path = this.f288910e;
                if (path != null) {
                    path.reset();
                }
                a aVar = this.H;
                if (aVar != null) {
                    aVar.a(true, 0, f16, f17);
                    this.H.b(f16, f17);
                }
            }
        }
    }

    public boolean c(MotionEvent motionEvent) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 2;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent == null || this.f288913i == null) {
            return false;
        }
        QLog.e("GesturePathLayer", 1, "process Event " + motionEvent);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        return false;
                    }
                } else {
                    float x16 = motionEvent.getX();
                    float y16 = motionEvent.getY();
                    if (!a(x16, y16, this.f288913i)) {
                        b(x16, y16);
                        return false;
                    }
                    Path path = this.f288910e;
                    if (path != null && !this.C) {
                        path.lineTo(x16, y16);
                    }
                    return true;
                }
            }
            Path path2 = this.f288910e;
            if (path2 != null) {
                path2.reset();
            }
            float x17 = motionEvent.getX();
            float y17 = motionEvent.getY();
            b(x17, y17);
            if (!this.D && (aVar = this.H) != null) {
                if (!this.E) {
                    i3 = 3;
                }
                aVar.a(false, i3, x17, y17);
            }
            return true;
        }
        this.E = false;
        float x18 = motionEvent.getX();
        float y18 = motionEvent.getY();
        this.f288909d = y18;
        a aVar2 = this.H;
        if (aVar2 != null) {
            aVar2.onGestureMatchStart(x18, y18);
        }
        if (!a(x18, this.f288909d, this.f288913i)) {
            return true;
        }
        this.C = false;
        this.E = true;
        if (this.f288910e == null) {
            this.f288910e = new Path();
        }
        if (this.f288911f == null) {
            Paint paint = new Paint();
            this.f288911f = paint;
            paint.setAntiAlias(true);
            this.f288911f.setColor(this.F);
            this.f288911f.setStyle(Paint.Style.STROKE);
            this.f288911f.setStrokeJoin(Paint.Join.ROUND);
            this.f288911f.setStrokeCap(Paint.Cap.ROUND);
            this.f288911f.setStrokeWidth(Utils.getRelativeSize(12));
            this.f288911f.setDither(true);
        }
        this.f288910e.moveTo(x18, this.f288909d);
        return true;
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.PathShapeLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        Paint paint;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        Path path = this.f288910e;
        if (path != null && (paint = this.f288911f) != null && this.G) {
            canvas.drawPath(path, paint);
        }
    }

    public void e(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.H = aVar;
        }
    }

    public void f(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) rect);
        } else {
            this.f288913i = rect;
        }
    }

    public void g(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Float.valueOf(f16));
        } else {
            this.f288914m = f16;
        }
    }

    public void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.F = i3;
        }
    }
}

package com.tencent.common.galleryactivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.util.ViscousFluidInterpolator;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AnimationView extends View {
    static IPatchRedirector $redirector_;
    public boolean C;
    private Drawable D;
    private Rect E;
    private Rect F;
    private Rect G;
    private int H;
    private int I;
    private int J;
    private h K;
    ViscousFluidInterpolator L;
    AccelerateDecelerateInterpolator M;
    boolean N;
    boolean P;
    boolean Q;
    long R;
    private Rect S;
    private Rect T;
    float U;
    float V;
    float W;

    /* renamed from: a0, reason: collision with root package name */
    float f99821a0;

    /* renamed from: b0, reason: collision with root package name */
    float f99822b0;

    /* renamed from: c0, reason: collision with root package name */
    Paint f99823c0;

    /* renamed from: d, reason: collision with root package name */
    private int f99824d;

    /* renamed from: d0, reason: collision with root package name */
    private Rect f99825d0;

    /* renamed from: e, reason: collision with root package name */
    private int f99826e;

    /* renamed from: e0, reason: collision with root package name */
    private RectF f99827e0;

    /* renamed from: f, reason: collision with root package name */
    private long f99828f;

    /* renamed from: f0, reason: collision with root package name */
    private Rect f99829f0;

    /* renamed from: h, reason: collision with root package name */
    private long f99830h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f99831i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f99832m;

    public AnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f99824d = 3;
        this.f99826e = 3;
        this.f99830h = 350L;
        this.L = new ViscousFluidInterpolator();
        this.M = new AccelerateDecelerateInterpolator();
        this.N = false;
        this.P = false;
        this.Q = true;
        this.R = 0L;
        this.f99823c0 = new Paint(6);
        this.f99825d0 = new Rect();
        this.f99827e0 = new RectF();
        this.f99829f0 = new Rect();
    }

    private void a(Canvas canvas) {
        int i3 = this.f99826e;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    h hVar = this.K;
                    if (hVar != null) {
                        hVar.onExitAnimationEnd();
                    }
                    this.f99832m = false;
                    this.D.setBounds(this.G);
                    return;
                }
                return;
            }
        } else if (this.E != null && this.F != null && this.D != null) {
            this.f99828f = SystemClock.uptimeMillis();
            this.f99826e = 2;
        } else {
            this.f99826e = 3;
            this.f99832m = false;
            super.onDraw(canvas);
            h hVar2 = this.K;
            if (hVar2 != null) {
                hVar2.onExitAnimationEnd();
                return;
            }
            return;
        }
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f99828f)) / ((float) this.f99830h);
        if (uptimeMillis >= 1.0f) {
            this.f99826e = 3;
        }
        float interpolation = this.L.getInterpolation(Math.min(uptimeMillis, 1.0f));
        Rect rect = this.E;
        Rect rect2 = this.F;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i16 = rect2.left;
        int i17 = iArr[0];
        int i18 = rect2.top;
        int i19 = iArr[1];
        Rect rect3 = new Rect(i16 + i17, i18 + i19, rect2.right + i17, rect2.bottom + i19);
        int i26 = rect3.right - rect3.left;
        float f16 = (rect.right - rect.left) + this.I;
        float f17 = (rect.bottom - rect.top) + this.J;
        float f18 = i26;
        float f19 = f16 / f18;
        float f26 = rect3.bottom - rect3.top;
        float f27 = f17 / f26;
        canvas.save();
        int i27 = this.H;
        if (i27 == 1) {
            int i28 = rect.left;
            int i29 = iArr[0];
            int i36 = rect.top;
            int i37 = iArr[1];
            canvas.translate((((i28 - i29) - this.I) - ((rect3.left - i29) * f27)) * interpolation, (((i36 - i37) - this.J) - ((rect3.top - i37) * f27)) * interpolation);
            float f28 = 1.0f - ((1.0f - f27) * interpolation);
            canvas.scale(f28, f28);
            if (this.C) {
                float f29 = (i26 - r11) / 2.0f;
                canvas.translate((-f29) * interpolation, 0.0f);
                int i38 = rect3.left;
                int i39 = iArr[0];
                float f36 = f29 * interpolation;
                int i46 = rect3.top;
                int i47 = iArr[1];
                canvas.clipRect((i38 - i39) + f36, i46 - i47, (rect3.right - i39) - f36, rect3.bottom - i47);
            } else {
                int i48 = rect3.left;
                int i49 = iArr[0];
                int i56 = rect3.top;
                int i57 = iArr[1];
                canvas.clipRect((i48 - i49) + ((this.I / f28) * interpolation), (i56 - i57) + ((this.J / f28) * interpolation), (rect3.right - i49) - ((f18 - (f16 / f27)) * interpolation), rect3.bottom - i57);
            }
        } else if (i27 == 2) {
            int i58 = rect.left;
            int i59 = iArr[0];
            int i65 = rect.top;
            int i66 = iArr[1];
            canvas.translate((((i58 - i59) - this.I) - ((rect3.left - i59) * f19)) * interpolation, (((i65 - i66) - this.J) - ((rect3.top - i66) * f19)) * interpolation);
            float f37 = 1.0f - ((1.0f - f19) * interpolation);
            canvas.scale(f37, f37);
            if (this.C) {
                float f38 = (r11 - i26) / 2.0f;
                canvas.translate(0.0f, (-f38) * interpolation);
                int i67 = rect3.left;
                int i68 = iArr[0];
                int i69 = rect3.top;
                int i75 = iArr[1];
                float f39 = f38 * interpolation;
                canvas.clipRect(i67 - i68, (i69 - i75) + f39, rect3.right - i68, (rect3.bottom - i75) - f39);
            } else {
                int i76 = rect3.left;
                int i77 = iArr[0];
                int i78 = rect3.top;
                int i79 = iArr[1];
                canvas.clipRect((i76 - i77) + ((this.I / f37) * interpolation), (i78 - i79) + ((this.J / f37) * interpolation), rect3.right - i77, (rect3.bottom - i79) - ((f26 - (f17 / f19)) * interpolation));
            }
        } else {
            int i85 = rect.left;
            int i86 = iArr[0];
            float f46 = ((i85 - i86) - ((rect3.left - i86) * f19)) * interpolation;
            int i87 = rect.top;
            int i88 = iArr[1];
            canvas.translate(f46, ((i87 - i88) - ((rect3.top - i88) * f27)) * interpolation);
            canvas.scale(1.0f - ((1.0f - f19) * interpolation), 1.0f - ((1.0f - f27) * interpolation));
        }
        this.D.setBounds(this.F);
        this.D.draw(canvas);
        canvas.restore();
        invalidate();
    }

    private void b(Canvas canvas) {
        int i3 = this.f99824d;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    this.f99831i = false;
                    h hVar = this.K;
                    if (hVar != null) {
                        hVar.onEnterAnimationEnd();
                    }
                    canvas.save();
                    this.D.setBounds(this.F);
                    this.D.draw(canvas);
                    canvas.restore();
                    this.D.setBounds(this.G);
                    return;
                }
                return;
            }
        } else if (this.E != null && this.F != null && this.D != null) {
            this.f99828f = SystemClock.uptimeMillis();
            this.f99824d = 2;
            canvas.save();
        } else {
            this.f99824d = 3;
            this.f99831i = false;
            h hVar2 = this.K;
            if (hVar2 != null) {
                hVar2.onEnterAnimationEnd();
            }
            super.onDraw(canvas);
            return;
        }
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f99828f)) / ((float) this.f99830h);
        if (uptimeMillis >= 1.0f) {
            this.f99824d = 3;
        }
        float interpolation = 1.0f - this.M.getInterpolation(Math.min(uptimeMillis, 1.0f));
        Rect rect = this.E;
        Rect rect2 = this.F;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i16 = rect2.left;
        int i17 = iArr[0];
        int i18 = rect2.top;
        int i19 = iArr[1];
        Rect rect3 = new Rect(i16 + i17, i18 + i19, rect2.right + i17, rect2.bottom + i19);
        int width = rect3.width();
        int height = rect3.height();
        float width2 = rect.width();
        float height2 = rect.height();
        float f16 = width;
        float f17 = width2 / f16;
        float f18 = height;
        float f19 = height2 / f18;
        canvas.save();
        int i26 = this.H;
        if (i26 == 1) {
            int i27 = rect.left;
            int i28 = iArr[0];
            int i29 = rect.top;
            int i36 = iArr[1];
            canvas.translate(((i27 - i28) - ((rect3.left - i28) * f19)) * interpolation, ((i29 - i36) - ((rect3.top - i36) * f19)) * interpolation);
            float f26 = 1.0f - ((1.0f - f19) * interpolation);
            canvas.scale(f26, f26);
            if (this.C) {
                float f27 = (width - height) / 2.0f;
                canvas.translate((-f27) * interpolation, 0.0f);
                int i37 = rect3.left;
                int i38 = iArr[0];
                float f28 = f27 * interpolation;
                int i39 = rect3.top;
                int i46 = iArr[1];
                canvas.clipRect((i37 - i38) + f28, i39 - i46, (rect3.right - i38) - f28, rect3.bottom - i46);
            } else {
                int i47 = rect3.left;
                int i48 = iArr[0];
                int i49 = rect3.top;
                int i56 = iArr[1];
                canvas.clipRect(i47 - i48, i49 - i56, (rect3.right - i48) - ((f16 - (width2 / f19)) * interpolation), rect3.bottom - i56);
            }
        } else if (i26 == 2) {
            int i57 = rect.left;
            int i58 = iArr[0];
            int i59 = rect.top;
            int i65 = iArr[1];
            canvas.translate(((i57 - i58) - ((rect3.left - i58) * f17)) * interpolation, ((i59 - i65) - ((rect3.top - i65) * f17)) * interpolation);
            float f29 = 1.0f - ((1.0f - f17) * interpolation);
            canvas.scale(f29, f29);
            if (this.C) {
                float f36 = (height - width) / 2.0f;
                canvas.translate(0.0f, (-f36) * interpolation);
                int i66 = rect3.left;
                int i67 = iArr[0];
                int i68 = rect3.top;
                int i69 = iArr[1];
                float f37 = f36 * interpolation;
                canvas.clipRect(i66 - i67, (i68 - i69) + f37, rect3.right - i67, (rect3.bottom - i69) - f37);
            } else {
                int i75 = rect3.left;
                int i76 = iArr[0];
                int i77 = rect3.top;
                int i78 = iArr[1];
                canvas.clipRect(i75 - i76, i77 - i78, rect3.right - i76, (rect3.bottom - i78) - ((f18 - (height2 / f17)) * interpolation));
            }
        } else {
            int i79 = rect.left;
            int i85 = iArr[0];
            float f38 = ((i79 - i85) - ((rect3.left - i85) * f17)) * interpolation;
            int i86 = rect.top;
            int i87 = iArr[1];
            canvas.translate(f38, ((i86 - i87) - ((rect3.top - i87) * f19)) * interpolation);
            canvas.scale(1.0f - ((1.0f - f17) * interpolation), 1.0f - ((1.0f - f19) * interpolation));
        }
        this.D.setBounds(this.F);
        this.D.draw(canvas);
        canvas.restore();
        invalidate();
    }

    private void c(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        if (this.R > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.R;
            float f16 = ((float) currentTimeMillis) / ((float) this.f99830h);
            this.f99822b0 = f16;
            if (this.Q) {
                this.f99822b0 = this.M.getInterpolation(f16);
            } else {
                this.f99822b0 = this.L.getInterpolation(f16);
            }
            float f17 = this.f99822b0;
            float f18 = 1.0f - f17;
            if (this.N) {
                if (currentTimeMillis <= this.f99830h) {
                    Rect rect = this.S;
                    Rect rect2 = this.T;
                    float f19 = (rect.top * f18) + (rect2.top * f17);
                    this.U = f19;
                    float f26 = (rect.bottom * f18) + (rect2.bottom * f17);
                    this.V = f26;
                    float f27 = (rect.left * f18) + (rect2.left * f17);
                    this.W = f27;
                    float f28 = (rect.right * f18) + (rect2.right * f17);
                    this.f99821a0 = f28;
                    this.f99825d0.set((int) f27, (int) f19, (int) f28, (int) f26);
                    Rect rect3 = this.E;
                    float f29 = this.F.top;
                    float f36 = this.f99822b0;
                    float f37 = (rect3.top * f18) + (f29 * f36);
                    this.U = f37;
                    float f38 = (rect3.bottom * f18) + (r2.bottom * f36);
                    this.V = f38;
                    float f39 = (rect3.left * f18) + (r2.left * f36);
                    this.W = f39;
                    float f46 = (rect3.right * f18) + (r2.right * f36);
                    this.f99821a0 = f46;
                    this.f99827e0.set(f39, f37, f46, f38);
                } else {
                    this.N = false;
                    h hVar = this.K;
                    if (hVar != null) {
                        if (this.Q) {
                            hVar.onEnterAnimationEnd();
                        } else {
                            hVar.onExitAnimationEnd();
                        }
                    }
                }
            }
            float width = this.f99827e0.width() / this.f99825d0.width();
            float height = this.f99827e0.height() / this.f99825d0.height();
            RectF rectF = this.f99827e0;
            float f47 = rectF.left;
            Rect rect4 = this.f99825d0;
            canvas.translate(f47 - (rect4.left * width), rectF.top - (rect4.top * height));
            canvas.scale(width, height);
            canvas.clipRect(this.f99825d0);
            this.D.draw(canvas);
            invalidate();
        }
        canvas.restore();
    }

    private void d() {
        this.R = System.currentTimeMillis();
        this.N = true;
        this.G = this.D.copyBounds();
        Rect rect = new Rect(0, 0, this.D.getIntrinsicWidth(), this.D.getIntrinsicHeight());
        this.f99829f0 = rect;
        this.D.setBounds(rect);
    }

    public void e(Drawable drawable, Rect rect, Rect rect2, int i3, int i16, int i17, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, drawable, rect, rect2, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Long.valueOf(j3));
            return;
        }
        this.f99826e = 1;
        this.f99832m = true;
        this.D = drawable;
        this.G = drawable.copyBounds();
        this.E = rect;
        this.F = rect2;
        this.H = i3;
        this.I = i16;
        this.J = i17;
        this.f99830h = j3;
        h hVar = this.K;
        if (hVar != null) {
            hVar.onExitAnimationStart();
        }
        invalidate();
    }

    public void f(Drawable drawable, Rect rect, Rect rect2, Rect rect3, Rect rect4, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, drawable, rect, rect2, rect3, rect4, Long.valueOf(j3));
            return;
        }
        this.P = true;
        this.Q = false;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        Rect rect5 = new Rect(rect3);
        rect5.offset(iArr[0], -iArr[1]);
        this.S = rect2;
        this.T = rect;
        this.E = rect4;
        this.F = rect5;
        this.D = drawable;
        this.f99830h = j3;
        d();
        h hVar = this.K;
        if (hVar != null) {
            hVar.onExitAnimationStart();
        }
    }

    public void g(Drawable drawable, Rect rect, Rect rect2, int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, drawable, rect, rect2, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.f99824d = 1;
        this.f99831i = true;
        this.D = drawable;
        this.G = drawable.copyBounds();
        this.E = rect;
        this.F = rect2;
        this.H = i3;
        this.f99830h = j3;
        h hVar = this.K;
        if (hVar != null) {
            hVar.onEnterAnimationStart();
        }
        invalidate();
    }

    public void h(Drawable drawable, Rect rect, Rect rect2, Rect rect3, Rect rect4, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, drawable, rect, rect2, rect3, rect4, Long.valueOf(j3));
            return;
        }
        this.P = true;
        this.Q = true;
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        Rect rect5 = new Rect(rect3);
        rect5.offset(iArr[0], -iArr[1]);
        this.S = rect;
        this.T = rect2;
        this.E = rect5;
        this.F = rect4;
        this.D = drawable;
        this.f99830h = j3;
        d();
        h hVar = this.K;
        if (hVar != null) {
            hVar.onEnterAnimationStart();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        if (this.P) {
            c(canvas);
            return;
        }
        if (this.f99831i) {
            b(canvas);
        } else if (this.f99832m) {
            a(canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    public void setAnimationListener(h hVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
        } else {
            this.K = hVar;
        }
    }
}

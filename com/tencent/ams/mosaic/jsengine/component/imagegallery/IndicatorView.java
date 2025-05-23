package com.tencent.ams.mosaic.jsengine.component.imagegallery;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes3.dex */
public class IndicatorView extends View {
    static IPatchRedirector $redirector_;
    private int C;
    private int D;
    private float E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private boolean J;

    /* renamed from: d, reason: collision with root package name */
    private Paint f71221d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f71222e;

    /* renamed from: f, reason: collision with root package name */
    private float f71223f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f71224h;

    /* renamed from: i, reason: collision with root package name */
    private float f71225i;

    /* renamed from: m, reason: collision with root package name */
    private int f71226m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f71227a;

        /* renamed from: b, reason: collision with root package name */
        public int f71228b;

        /* renamed from: c, reason: collision with root package name */
        public float f71229c;

        /* renamed from: d, reason: collision with root package name */
        public int f71230d;

        /* renamed from: e, reason: collision with root package name */
        public float f71231e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f71232f;

        /* renamed from: g, reason: collision with root package name */
        public int f71233g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f71234h;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f71227a = -1;
            this.f71228b = -1;
            this.f71229c = -1.0f;
            this.f71230d = -1;
            this.f71231e = -1.0f;
            this.f71232f = true;
            this.f71233g = -1;
            this.f71234h = true;
        }
    }

    public IndicatorView(Context context, a aVar) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aVar);
            return;
        }
        this.D = -1;
        this.E = 20.0f;
        this.F = -1;
        this.G = -1278226481;
        this.H = true;
        this.J = true;
        e(aVar);
        a();
    }

    private void a() {
        if (this.f71222e == null) {
            Paint paint = new Paint();
            this.f71222e = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f71222e.setColor(this.G);
            this.f71222e.setAntiAlias(true);
        }
        if (this.f71221d == null) {
            Paint paint2 = new Paint();
            this.f71221d = paint2;
            paint2.setStyle(Paint.Style.FILL);
            this.f71221d.setColor(this.F);
            this.f71221d.setAntiAlias(true);
        }
    }

    private void e(a aVar) {
        if (aVar != null) {
            int i3 = aVar.f71227a;
            if (i3 > 0) {
                this.F = i3;
            }
            int i16 = aVar.f71228b;
            if (i16 > 0) {
                this.G = i16;
            }
            float f16 = aVar.f71229c;
            if (f16 > 0.0f) {
                this.E = f16;
            }
            int i17 = aVar.f71233g;
            if (i17 > 0) {
                this.I = i17;
            }
            this.H = aVar.f71232f;
            this.J = aVar.f71234h;
        }
        invalidate();
    }

    public void b(float f16, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Float.valueOf(f16), Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (f16 == 0.0f) {
            f.e("IndicatorView", "move onPageSelected: " + i3);
            this.C = i3;
        }
        this.f71226m = i3;
        this.f71223f = f16;
        this.f71224h = z16;
        this.f71225i = f16 * this.E * 3.0f;
        invalidate();
    }

    public void c(int i3, float f16, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Float.valueOf(f16), Integer.valueOf(i16));
            return;
        }
        if (!this.H) {
            return;
        }
        boolean z17 = this.f71224h;
        int i17 = this.D;
        int i18 = i16 / 10;
        if (i17 / 10 > i18) {
            z16 = false;
        } else if (i17 / 10 >= i18) {
            z16 = z17;
        }
        int i19 = this.I;
        if (i19 > 0 && !this.J) {
            b(f16, i3 % i19, z16);
        } else if (i19 > 0) {
            b(f16, i3, z16);
        }
        this.D = i16;
    }

    public void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        if (this.H) {
            return;
        }
        int i16 = this.I;
        if (i16 > 0 && !this.J) {
            b(0.0f, i3 % i16, false);
        } else if (i16 > 0) {
            b(0.0f, i3, false);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int h16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            return;
        }
        super.onDraw(canvas);
        if (this.I <= 0) {
            return;
        }
        canvas.translate(getWidth() / 2.0f, getHeight() / 2.0f);
        a();
        float f16 = this.E;
        float f17 = 3.0f * f16;
        int i3 = this.f71226m;
        if (i3 == this.I - 1) {
            float f18 = (((-r5) * 0.5f) * f17) - f16;
            float f19 = (f16 * 2.0f) + f18 + this.f71225i;
            float f26 = -f16;
            for (int i16 = 1; i16 < this.I - 1; i16++) {
                float f27 = this.E;
                canvas.drawCircle((f19 - f27) + (i16 * f17), 0.0f, f27, this.f71222e);
            }
            float f28 = this.f71223f;
            if (f28 < 1.0f && f28 > 0.0f) {
                RectF rectF = new RectF(f18, f26, f19, f16);
                this.f71221d.setColor(MosaicUtils.h(this.G, this.F, this.f71223f));
                float f29 = this.E;
                canvas.drawRoundRect(rectF, f29, f29, this.f71221d);
            } else {
                float f36 = this.E;
                canvas.drawCircle(f19 - f36, 0.0f, f36, this.f71222e);
            }
            float f37 = ((-r0) * 0.5f * f17) + (this.I * f17);
            float f38 = this.E;
            float f39 = f37 + f38;
            RectF rectF2 = new RectF(((f39 - (2.0f * f38)) - f17) + this.f71225i, -f38, f39, f38);
            int i17 = this.C;
            if (i17 == 0) {
                h16 = MosaicUtils.h(this.G, this.F, 1.0f - this.f71223f);
            } else if (i17 == this.f71226m) {
                h16 = MosaicUtils.h(this.F, this.G, this.f71223f);
            } else {
                h16 = MosaicUtils.h(this.G, this.F, this.f71223f);
            }
            this.f71221d.setColor(h16);
            float f46 = this.E;
            canvas.drawRoundRect(rectF2, f46, f46, this.f71221d);
            return;
        }
        int i18 = i3 + 3;
        while (true) {
            if (i18 > this.I) {
                break;
            }
            canvas.drawCircle(((-r0) * 0.5f * f17) + (i18 * f17), 0.0f, this.E, this.f71222e);
            i18++;
        }
        for (int i19 = this.f71226m - 1; i19 >= 0; i19--) {
            canvas.drawCircle(((-this.I) * 0.5f * f17) + (i19 * f17), 0.0f, this.E, this.f71222e);
        }
        if (this.f71223f < 1.0f) {
            float f47 = this.E;
            float f48 = ((((-this.I) * 0.5f) * f17) + (this.f71226m * f17)) - f47;
            RectF rectF3 = new RectF(f48, -f47, (((f47 * 2.0f) + f48) + f17) - this.f71225i, f47);
            this.f71221d.setColor(MosaicUtils.h(this.F, this.G, this.f71223f));
            float f49 = this.E;
            canvas.drawRoundRect(rectF3, f49, f49, this.f71221d);
        }
        if (this.f71226m < this.I - 1) {
            float f56 = ((-r4) * 0.5f * f17) + ((r0 + 2) * f17);
            float f57 = this.E;
            float f58 = f56 + f57;
            RectF rectF4 = new RectF((f58 - (2.0f * f57)) - this.f71225i, -f57, f58, f57);
            this.f71221d.setColor(MosaicUtils.h(this.G, this.F, this.f71223f));
            float f59 = this.E;
            canvas.drawRoundRect(rectF4, f59, f59, this.f71221d);
        }
    }

    public void setCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.I = i3;
            invalidate();
        }
    }
}

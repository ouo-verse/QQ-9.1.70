package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.avcore.jni.codec.HWColorFormat;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.util.Arrays;

/* loaded from: classes20.dex */
public class MessageProgressView extends View {
    public float A0;
    private float B0;
    public float C;
    private float C0;
    public Resources D;
    public Drawable D0;
    public a E;
    Rect E0;
    AccelerateDecelerateInterpolator F;
    private Paint F0;
    private float G;
    private RectF G0;
    private float H;
    private Paint H0;
    private float I;
    private Paint I0;
    private float J;
    private Paint J0;
    private float K;
    private Paint K0;
    private float L;
    private float M;
    private float N;
    private float P;
    private float Q;
    public float R;
    public long S;
    public long T;
    public long U;
    public int V;
    public float W;

    /* renamed from: a0, reason: collision with root package name */
    public float f315817a0;

    /* renamed from: b0, reason: collision with root package name */
    private Path f315818b0;

    /* renamed from: c0, reason: collision with root package name */
    private RectF f315819c0;

    /* renamed from: d, reason: collision with root package name */
    public final String f315820d;

    /* renamed from: d0, reason: collision with root package name */
    private Path f315821d0;

    /* renamed from: e, reason: collision with root package name */
    public int f315822e;

    /* renamed from: e0, reason: collision with root package name */
    private float[] f315823e0;

    /* renamed from: f, reason: collision with root package name */
    public int f315824f;

    /* renamed from: f0, reason: collision with root package name */
    private boolean f315825f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f315826g0;

    /* renamed from: h, reason: collision with root package name */
    public String f315827h;

    /* renamed from: h0, reason: collision with root package name */
    private float f315828h0;

    /* renamed from: i, reason: collision with root package name */
    public long f315829i;

    /* renamed from: i0, reason: collision with root package name */
    public long f315830i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f315831j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f315832k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f315833l0;

    /* renamed from: m, reason: collision with root package name */
    public float f315834m;

    /* renamed from: m0, reason: collision with root package name */
    private float f315835m0;

    /* renamed from: n0, reason: collision with root package name */
    private float f315836n0;

    /* renamed from: o0, reason: collision with root package name */
    private float f315837o0;

    /* renamed from: p0, reason: collision with root package name */
    private float f315838p0;

    /* renamed from: q0, reason: collision with root package name */
    private float f315839q0;

    /* renamed from: r0, reason: collision with root package name */
    private float f315840r0;

    /* renamed from: s0, reason: collision with root package name */
    public Drawable f315841s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f315842t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f315843u0;

    /* renamed from: v0, reason: collision with root package name */
    private RectF f315844v0;

    /* renamed from: w0, reason: collision with root package name */
    private int f315845w0;

    /* renamed from: x0, reason: collision with root package name */
    private float f315846x0;

    /* renamed from: y0, reason: collision with root package name */
    private RectF f315847y0;

    /* renamed from: z0, reason: collision with root package name */
    public Path f315848z0;

    /* loaded from: classes20.dex */
    public interface a {
        void a(String str);
    }

    public MessageProgressView(Context context) {
        super(context);
        this.f315820d = "MessageProgressView";
        this.f315822e = -1;
        this.f315824f = 0;
        this.f315829i = -1L;
        this.G = 14.0f;
        this.H = 8.0f;
        this.I = 0.0f;
        this.J = 5.0f;
        this.K = 4.0f;
        this.L = 10.0f;
        this.M = 10.0f;
        this.N = 16.0f;
        this.P = 1.0f;
        this.Q = 14.0f;
        this.R = Math.abs(0.0f - 10.0f);
        this.S = 534L;
        this.T = 400L;
        this.U = 767L;
        this.V = HWColorFormat.COLOR_FormatVendorStartUnused;
        this.f315826g0 = true;
        this.f315830i0 = 667L;
        this.f315840r0 = -1.0f;
        this.f315842t0 = 0;
        this.f315845w0 = -1;
        this.A0 = 23.0f;
        p();
    }

    private int b(float f16, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * f16) + 0.5f);
    }

    private void g(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (!this.f315826g0) {
            this.f315819c0.set(0.0f, 0.0f, width, height);
            this.f315818b0.reset();
            this.f315818b0.addRoundRect(this.f315819c0, this.f315823e0, Path.Direction.CW);
            this.f315818b0.close();
        } else {
            Resources resources = this.D;
            if (this.f315825f0) {
                this.f315819c0.set(0.0f, 0.0f, width - this.W, height);
            } else {
                this.f315819c0.set(this.W, 0.0f, width, height);
            }
            this.f315818b0.reset();
            float b16 = b(this.J, resources);
            if (this.f315825f0) {
                this.f315818b0.addRoundRect(this.f315819c0, this.f315823e0, Path.Direction.CW);
                this.f315818b0.moveTo(width - b(this.G, resources), b(this.H, resources));
                this.f315818b0.quadTo(width - b(this.K, resources), b(this.L, resources), width - this.I, b16);
                this.f315818b0.quadTo(width - b(this.P, resources), b(this.Q, resources), width - b(this.M, resources), b(this.N, resources));
            } else {
                this.f315818b0.addRoundRect(this.f315819c0, this.f315823e0, Path.Direction.CCW);
                this.f315818b0.moveTo(b(this.G, resources), b(this.H, resources));
                this.f315818b0.quadTo(b(this.K, resources), b(this.L, resources), this.I, b16);
                this.f315818b0.quadTo(b(this.P, resources), b(this.Q, resources), b(this.M, resources), b(this.N, resources));
            }
            this.f315818b0.close();
        }
        l(canvas, this.f315818b0, this.f315821d0);
    }

    private void l(Canvas canvas, Path path, Path path2) {
        if (this.f315824f < 100) {
            this.K0.setColor(this.V);
            canvas.drawPath(this.f315818b0, this.K0);
            return;
        }
        float sqrt = (float) Math.sqrt((getWidth() * getWidth()) + (getHeight() * getHeight()));
        float f16 = (((float) this.f315829i) / ((float) this.S)) * sqrt;
        this.f315828h0 = n(0.0f, sqrt, f16);
        this.f315821d0.reset();
        this.f315821d0.addCircle(this.f315834m, this.C, f16, Path.Direction.CW);
        this.f315821d0.close();
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        canvas.clipPath(this.f315821d0, Region.Op.DIFFERENCE);
        canvas.drawPath(this.f315818b0, this.K0);
        canvas.restoreToCount(saveLayer);
    }

    private float n(float f16, float f17, float f18) {
        if (f18 >= f16 && f18 <= f17) {
            float f19 = f17 - f16;
            try {
                float interpolation = this.F.getInterpolation(new BigDecimal((f18 - f16) / f19).setScale(3, 4).floatValue());
                if (interpolation >= 0.0f && interpolation <= 1.0f) {
                    return (interpolation * f19) + f16;
                }
            } catch (Exception unused) {
            }
        }
        return f18;
    }

    public void a(String str) {
        RefreshProgressRunnable b16 = com.tencent.mobileqq.utils.bs.c().b(str);
        if (b16 != null) {
            if (QLog.isColorLevel()) {
                QLog.d("MessageProgressView", 2, " bind  key=" + str + " animRunnable.mProgress = " + b16.f316165m);
            }
            b16.a(this, b16.f316165m);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Canvas canvas) {
        if (this.f315824f == 100 && this.f315842t0 == 1) {
            long j3 = this.f315829i;
            long j16 = this.T;
            if (j3 >= j16) {
                long j17 = this.U;
                if (j3 < j17) {
                    this.f315846x0 = ((((float) j3) - ((float) j16)) / ((float) (j17 - j16))) * 360.0f;
                    this.I0.setStrokeWidth(this.f315832k0);
                    RectF rectF = this.f315847y0;
                    float f16 = this.f315834m;
                    float f17 = this.f315831j0;
                    float f18 = this.C;
                    rectF.set(f16 - f17, f18 - f17, f16 + f17, f18 + f17);
                    canvas.drawArc(this.f315847y0, -90.0f, -this.f315846x0, false, this.I0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            if (this.f315824f < 0) {
                return;
            }
            g(canvas);
            return;
        }
        super.draw(canvas);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(Canvas canvas) {
        BlurMaskFilter blurMaskFilter;
        int i3 = this.f315824f;
        if (i3 < 0 || i3 >= 100) {
            return;
        }
        long j3 = this.f315829i;
        long j16 = this.f315830i0;
        float f16 = this.f315835m0;
        float f17 = this.f315836n0;
        float f18 = ((((float) j3) / ((float) j16)) * (f16 - f17)) + f17;
        this.f315839q0 = f18;
        float f19 = ((float) j3) / ((float) j16);
        float f26 = this.f315832k0;
        float f27 = this.f315833l0;
        this.f315838p0 = (f19 * (f26 - f27)) + f27;
        float n3 = n(f17, f16, f18);
        this.f315837o0 = this.f315831j0 + (n(this.f315833l0, this.f315832k0, this.f315838p0) / 2.0f);
        this.F0.setStrokeWidth(n3);
        try {
            blurMaskFilter = new BlurMaskFilter(n3, BlurMaskFilter.Blur.SOLID);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("MessageProgressView", 2, "create BlurMaskFilter exp:" + e16.getMessage());
            }
            blurMaskFilter = null;
        }
        if (blurMaskFilter != null) {
            this.F0.setMaskFilter(blurMaskFilter);
        }
        canvas.drawCircle(this.f315834m, this.C, this.f315837o0, this.F0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(Canvas canvas, float f16) {
        int i3 = this.f315824f;
        if (i3 < 0) {
            super.draw(canvas);
            return;
        }
        if (i3 >= 100) {
            return;
        }
        float f17 = (this.f315833l0 + this.f315832k0) / 2.0f;
        float f18 = this.f315831j0 + f17;
        this.F0.setStrokeWidth(f17);
        RectF rectF = this.G0;
        float f19 = this.f315834m;
        float f26 = this.C;
        rectF.set(f19 - f18, f26 - f18, f19 + f18, f26 + f18);
        canvas.drawArc(this.G0, -90.0f, f16 * 360.0f, false, this.F0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(Canvas canvas) {
        int i3 = this.f315824f;
        if (i3 < 0 || i3 >= 100) {
            return;
        }
        RectF rectF = this.f315844v0;
        float f16 = this.f315834m;
        float f17 = this.f315831j0;
        float f18 = this.C;
        rectF.set(f16 - f17, f18 - f17, f16 + f17, f18 + f17);
        this.H0.setTextSize(this.f315843u0);
        Paint.FontMetrics fontMetrics = this.H0.getFontMetrics();
        canvas.drawText(this.f315824f + "%", this.f315844v0.centerX(), (int) ((this.f315844v0.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.H0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(Canvas canvas, String str) {
        RectF rectF = this.f315844v0;
        float f16 = this.f315834m;
        float f17 = this.f315831j0;
        float f18 = this.C;
        rectF.set(f16 - f17, f18 - f17, f16 + f17, f18 + f17);
        this.H0.setTextSize(b(10.0f, getResources()));
        Paint.FontMetrics fontMetrics = this.H0.getFontMetrics();
        canvas.drawText(str, this.f315844v0.centerX(), (int) ((this.f315844v0.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f)), this.H0);
    }

    public void j(Canvas canvas, Drawable drawable) {
        float width;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            this.E0.set(0, 0, intrinsicWidth, intrinsicWidth);
            if (this.f315826g0) {
                if (this.f315825f0) {
                    width = ((getWidth() - intrinsicWidth) / 2.0f) - (this.W / 2.0f);
                } else {
                    width = ((getWidth() - intrinsicWidth) / 2.0f) + (this.W / 2.0f);
                }
            } else {
                width = (getWidth() - intrinsicWidth) / 2.0f;
            }
            this.E0.offset((int) width, (getHeight() - intrinsicWidth) / 2);
            drawable.setBounds(this.E0);
            drawable.draw(canvas);
        }
    }

    public void k(Canvas canvas) {
        Drawable drawable;
        if (this.f315842t0 == 2 && (drawable = this.f315841s0) != null) {
            j(canvas, drawable);
            return;
        }
        this.I0.setStrokeWidth(this.f315832k0);
        RectF rectF = this.f315847y0;
        float f16 = this.f315834m;
        float f17 = this.f315831j0;
        float f18 = this.C;
        rectF.set(f16 - f17, f18 - f17, f16 + f17, f18 + f17);
        canvas.drawArc(this.f315847y0, 0.0f, 360.0f, false, this.I0);
        float f19 = (this.f315831j0 * 2.0f) / 3.0f;
        float sqrt = (float) Math.sqrt(((f19 * 5.0f) * f19) / 4.0f);
        this.f315848z0.reset();
        float f26 = f19 / 2.0f;
        float f27 = sqrt / 2.0f;
        this.f315848z0.moveTo((this.f315834m - f26) + 5.0f, this.C - f27);
        this.f315848z0.lineTo((this.f315834m - f26) + 5.0f, this.C + f27);
        this.f315848z0.lineTo(this.f315834m + f26 + 5.0f, this.C);
        this.f315848z0.close();
        canvas.drawPath(this.f315848z0, this.J0);
    }

    public void m(Canvas canvas) {
        if (this.f315824f == 100) {
            if (this.f315842t0 == 1) {
                float f16 = (this.f315831j0 * 2.0f) / 3.0f;
                float sqrt = (float) Math.sqrt(((f16 * 5.0f) * f16) / 4.0f);
                this.f315848z0.reset();
                float f17 = f16 / 2.0f;
                float f18 = sqrt / 2.0f;
                this.f315848z0.moveTo((this.f315834m - f17) + 5.0f, this.C - f18);
                this.f315848z0.lineTo((this.f315834m - f17) + 5.0f, this.C + f18);
                this.f315848z0.lineTo(this.f315834m + f17 + 5.0f, this.C);
                this.f315848z0.close();
                long j3 = this.f315829i;
                long j16 = this.T;
                if (j3 >= j16) {
                    long j17 = this.U;
                    if (j3 < j17) {
                        this.B0 = (1.0f - ((((float) j3) - ((float) j16)) / ((float) (j17 - j16)))) * this.A0;
                        this.C0 = ((((float) j3) - ((float) j16)) / ((float) (j17 - j16))) * 1.0f;
                        canvas.save();
                        canvas.rotate(this.B0, this.f315834m, this.C);
                        float f19 = this.C0;
                        canvas.scale(f19, f19, this.f315834m, this.C);
                        canvas.drawPath(this.f315848z0, this.J0);
                        canvas.restore();
                    }
                }
            }
            if (this.f315829i >= this.U && this.f315842t0 != 0) {
                setDrawStatus(2);
            }
        }
    }

    public boolean o(String str) {
        if (com.tencent.mobileqq.utils.bs.c().b(str) != null) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    @TargetApi(11)
    public void onDraw(Canvas canvas) {
        int i3 = this.f315822e;
        if (i3 == 1) {
            r();
            d(canvas);
            e(canvas);
            String str = this.f315827h;
            if (str != null) {
                i(canvas, str);
            } else {
                h(canvas);
            }
            c(canvas);
            m(canvas);
            return;
        }
        if (i3 == 2) {
            r();
            k(canvas);
        } else if (i3 == 3) {
            r();
            j(canvas, this.D0);
        }
    }

    @TargetApi(11)
    public void p() {
        this.D = getResources();
        this.F = new AccelerateDecelerateInterpolator();
        this.f315831j0 = b(22.0f, getResources());
        this.f315833l0 = b(2.5f, getResources());
        this.f315832k0 = b(5.0f, getResources());
        this.f315835m0 = b(5.0f, getResources());
        this.f315836n0 = b(2.5f, getResources());
        this.f315843u0 = b(16.0f, getResources());
        Paint paint = new Paint();
        this.F0 = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.F0.setColor(-1);
        this.F0.setAntiAlias(true);
        this.G0 = new RectF();
        Paint paint2 = new Paint();
        this.H0 = paint2;
        paint2.setAntiAlias(true);
        this.H0.setTextSize(this.f315843u0);
        this.H0.setColor(this.f315845w0);
        this.H0.setTextAlign(Paint.Align.CENTER);
        Paint paint3 = new Paint();
        this.I0 = paint3;
        paint3.setStyle(Paint.Style.STROKE);
        this.I0.setColor(-1);
        this.I0.setAntiAlias(true);
        Paint paint4 = new Paint();
        this.J0 = paint4;
        paint4.setStyle(Paint.Style.FILL);
        this.J0.setColor(-1);
        this.J0.setAntiAlias(true);
        this.f315848z0 = new Path();
        Paint paint5 = new Paint();
        this.K0 = paint5;
        paint5.setAntiAlias(true);
        this.K0.setFilterBitmap(true);
        this.K0.setStyle(Paint.Style.FILL);
        this.f315818b0 = new Path();
        this.f315819c0 = new RectF();
        this.f315821d0 = new Path();
        this.f315823e0 = new float[8];
        this.E0 = new Rect();
        this.f315844v0 = new RectF();
        this.f315847y0 = new RectF();
        this.W = b(this.R, getResources());
        this.f315817a0 = b(70.0f, getResources());
        setLayerType(1, null);
    }

    public void q(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("MessageProgressView", 2, " stopAnim  key=" + str);
        }
        com.tencent.mobileqq.utils.bs.c().e(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void r() {
        if (this.f315826g0) {
            if (this.f315825f0) {
                this.f315834m = (getWidth() / 2.0f) - (this.W / 2.0f);
            } else {
                this.f315834m = (getWidth() / 2.0f) + (this.W / 2.0f);
            }
        } else {
            this.f315834m = getWidth() / 2;
        }
        this.C = getHeight() / 2;
        if (Math.min(getWidth(), getHeight()) < this.f315817a0) {
            this.f315831j0 = b(10.0f, getResources());
            this.f315833l0 = b(1.25f, getResources());
            this.f315832k0 = b(2.5f, getResources());
            this.f315835m0 = b(4.0f, getResources());
            this.f315836n0 = b(2.0f, getResources());
            this.f315843u0 = b(9.0f, getResources());
            float f16 = this.f315840r0;
            if (f16 > 0.0f) {
                this.f315831j0 = f16;
            }
        }
    }

    public void setAnimProgress(int i3, String str) {
        this.f315827h = null;
        this.f315824f = i3;
        if (this.f315822e == 1) {
            RefreshProgressRunnable b16 = com.tencent.mobileqq.utils.bs.c().b(str);
            if (b16 == null) {
                RefreshProgressRunnable refreshProgressRunnable = new RefreshProgressRunnable(this, str, i3);
                if (QLog.isColorLevel()) {
                    QLog.d("MessageProgressView", 2, " setAnimProgress new AnimRunnable key=" + str + " progress=" + i3);
                }
                com.tencent.mobileqq.utils.bs.c().a(str, refreshProgressRunnable);
                ViewCompat.postOnAnimation(this, refreshProgressRunnable);
                if (!QLog.isColorLevel() || i3 < 100) {
                    return;
                }
                QLog.d("MessageProgressView", 2, "progress >= 100, but animRunnable is null, progress:" + i3);
                return;
            }
            b16.a(this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MessageProgressView", 2, "setAnimProgress failed, progress:" + i3 + ", key:" + str + ", mDrawStatus:" + this.f315822e);
        }
    }

    public void setAnimRunnableListener(a aVar) {
        this.E = aVar;
    }

    public void setBreathingCircleRadius(float f16) {
        this.f315840r0 = b(f16, getResources());
    }

    public void setCornerDirection(boolean z16) {
        this.f315825f0 = z16;
    }

    public void setCustomSize(int i3) {
        if (i3 == 1) {
            this.f315831j0 = b(15.0f, getResources());
            this.f315833l0 = b(2.0f, getResources());
            this.f315832k0 = b(4.0f, getResources());
            this.f315835m0 = b(5.0f, getResources());
            this.f315836n0 = b(2.5f, getResources());
            this.f315843u0 = b(13.0f, getResources());
        }
    }

    public void setDisplayInTextView(int i3, int i16) {
        this.f315843u0 = i3;
        this.f315845w0 = i16;
    }

    public void setDrawFinishDefault(boolean z16) {
        if (z16) {
            this.f315842t0 = 1;
        } else {
            this.f315842t0 = 0;
        }
    }

    public void setDrawFinishDrawable(Drawable drawable) {
        if (drawable != null) {
            this.f315842t0 = 2;
            this.f315841s0 = drawable;
        } else {
            this.f315842t0 = 0;
        }
    }

    public void setDrawFinishResource(int i3) {
        if (getResources() != null) {
            Drawable drawable = getResources().getDrawable(i3);
            this.f315841s0 = drawable;
            if (drawable != null) {
                this.f315842t0 = 2;
            } else {
                this.f315842t0 = 0;
            }
        }
    }

    public void setDrawStatus(int i3) {
        this.f315822e = i3;
        if (i3 != 1) {
            invalidate();
        }
    }

    public void setImageDrawable(Drawable drawable) {
        this.D0 = drawable;
        invalidate();
    }

    public void setImageResource(int i3) {
        if (getResources() != null) {
            this.D0 = getResources().getDrawable(i3);
            invalidate();
        }
    }

    public void setProgressBackgroudColor(int i3) {
        this.V = i3;
    }

    public void setRadius(float f16, boolean z16) {
        if (z16) {
            f16 = b(f16, this.D);
        }
        float[] fArr = this.f315823e0;
        if (fArr != null) {
            Arrays.fill(fArr, f16);
        }
    }

    public void setSharpCornerCor(float[] fArr) {
        this.G = fArr[0];
        this.H = fArr[1];
        float f16 = fArr[2];
        this.I = f16;
        this.J = fArr[3];
        this.K = fArr[4];
        this.L = fArr[5];
        float f17 = fArr[6];
        this.M = f17;
        this.N = fArr[7];
        this.P = fArr[8];
        this.Q = fArr[9];
        this.R = Math.abs(f16 - f17);
        this.W = b(r4, getResources());
    }

    public void setShowCorner(boolean z16) {
        this.f315826g0 = z16;
    }

    public void setAnimProgress(String str, String str2) {
        this.f315827h = str;
        this.f315824f = 0;
        if (this.f315822e == 1) {
            RefreshProgressRunnable b16 = com.tencent.mobileqq.utils.bs.c().b(str2);
            if (b16 == null) {
                RefreshProgressRunnable refreshProgressRunnable = new RefreshProgressRunnable(this, str2, this.f315824f);
                com.tencent.mobileqq.utils.bs.c().a(str2, refreshProgressRunnable);
                ViewCompat.postOnAnimation(this, refreshProgressRunnable);
                return;
            }
            b16.a(this, this.f315824f);
        }
    }

    public MessageProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315820d = "MessageProgressView";
        this.f315822e = -1;
        this.f315824f = 0;
        this.f315829i = -1L;
        this.G = 14.0f;
        this.H = 8.0f;
        this.I = 0.0f;
        this.J = 5.0f;
        this.K = 4.0f;
        this.L = 10.0f;
        this.M = 10.0f;
        this.N = 16.0f;
        this.P = 1.0f;
        this.Q = 14.0f;
        this.R = Math.abs(0.0f - 10.0f);
        this.S = 534L;
        this.T = 400L;
        this.U = 767L;
        this.V = HWColorFormat.COLOR_FormatVendorStartUnused;
        this.f315826g0 = true;
        this.f315830i0 = 667L;
        this.f315840r0 = -1.0f;
        this.f315842t0 = 0;
        this.f315845w0 = -1;
        this.A0 = 23.0f;
        p();
    }

    public MessageProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315820d = "MessageProgressView";
        this.f315822e = -1;
        this.f315824f = 0;
        this.f315829i = -1L;
        this.G = 14.0f;
        this.H = 8.0f;
        this.I = 0.0f;
        this.J = 5.0f;
        this.K = 4.0f;
        this.L = 10.0f;
        this.M = 10.0f;
        this.N = 16.0f;
        this.P = 1.0f;
        this.Q = 14.0f;
        this.R = Math.abs(0.0f - 10.0f);
        this.S = 534L;
        this.T = 400L;
        this.U = 767L;
        this.V = HWColorFormat.COLOR_FormatVendorStartUnused;
        this.f315826g0 = true;
        this.f315830i0 = 667L;
        this.f315840r0 = -1.0f;
        this.f315842t0 = 0;
        this.f315845w0 = -1;
        this.A0 = 23.0f;
        p();
    }
}

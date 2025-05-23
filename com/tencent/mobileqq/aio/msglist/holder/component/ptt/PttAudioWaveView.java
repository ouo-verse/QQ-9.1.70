package com.tencent.mobileqq.aio.msglist.holder.component.ptt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Random;

/* loaded from: classes11.dex */
public class PttAudioWaveView extends View {
    static IPatchRedirector $redirector_;
    float A0;
    float B0;
    private int C;
    private float C0;
    int D;
    private final int E;
    private int F;
    private volatile boolean G;
    private int[] H;
    private float I;
    View.OnClickListener J;
    a K;
    Bitmap L;
    Bitmap M;
    Canvas N;
    Canvas P;
    int Q;
    int R;
    int S;
    int T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f191749a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f191750b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f191751c0;

    /* renamed from: d, reason: collision with root package name */
    private float[] f191752d;

    /* renamed from: d0, reason: collision with root package name */
    private Xfermode f191753d0;

    /* renamed from: e, reason: collision with root package name */
    private Paint f191754e;

    /* renamed from: e0, reason: collision with root package name */
    private PorterDuff.Mode f191755e0;

    /* renamed from: f, reason: collision with root package name */
    private int f191756f;

    /* renamed from: f0, reason: collision with root package name */
    private c f191757f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f191758g0;

    /* renamed from: h, reason: collision with root package name */
    private int f191759h;

    /* renamed from: h0, reason: collision with root package name */
    private int f191760h0;

    /* renamed from: i, reason: collision with root package name */
    private float f191761i;

    /* renamed from: i0, reason: collision with root package name */
    private int f191762i0;

    /* renamed from: j0, reason: collision with root package name */
    boolean f191763j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f191764k0;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f191765l0;

    /* renamed from: m, reason: collision with root package name */
    private boolean f191766m;

    /* renamed from: m0, reason: collision with root package name */
    boolean f191767m0;

    /* renamed from: n0, reason: collision with root package name */
    int f191768n0;

    /* renamed from: o0, reason: collision with root package name */
    PorterDuffXfermode f191769o0;

    /* renamed from: p0, reason: collision with root package name */
    RectF f191770p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f191771q0;

    /* renamed from: r0, reason: collision with root package name */
    boolean f191772r0;

    /* renamed from: s0, reason: collision with root package name */
    boolean f191773s0;

    /* renamed from: t0, reason: collision with root package name */
    private float f191774t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f191775u0;

    /* renamed from: v0, reason: collision with root package name */
    private long f191776v0;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f191777w0;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f191778x0;

    /* renamed from: y0, reason: collision with root package name */
    private b f191779y0;

    /* renamed from: z0, reason: collision with root package name */
    private float[] f191780z0;

    /* loaded from: classes11.dex */
    public interface a {
        void a();

        void endDrag();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void onStart();
    }

    /* loaded from: classes11.dex */
    public interface c {
        void a(PttAudioWaveView pttAudioWaveView, float f16, boolean z16);

        void b(PttAudioWaveView pttAudioWaveView, float f16);

        void c(PttAudioWaveView pttAudioWaveView);
    }

    public PttAudioWaveView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f191752d = new float[0];
        this.f191759h = -1;
        this.f191761i = 0.0f;
        this.f191766m = false;
        this.C = -1;
        this.D = p(-1, 0.33f);
        this.E = 1;
        this.G = true;
        this.I = 0.0f;
        this.f191755e0 = PorterDuff.Mode.SRC_IN;
        this.f191758g0 = 0;
        this.f191760h0 = 0;
        this.f191763j0 = false;
        this.f191764k0 = false;
        this.f191765l0 = false;
        this.f191767m0 = true;
        this.f191768n0 = 0;
        this.f191769o0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f191770p0 = new RectF();
        this.f191772r0 = false;
        this.f191773s0 = false;
        this.f191774t0 = 0.0f;
        this.f191775u0 = -1;
        this.f191776v0 = 0L;
        this.f191777w0 = false;
        this.f191778x0 = false;
        this.f191780z0 = new float[0];
        this.A0 = 0.0f;
        this.B0 = 0.0f;
        this.C0 = 1.5f;
        k();
    }

    private static Bitmap b(int i3, int i16) {
        try {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        } catch (Throwable unused) {
            System.gc();
            QLog.i("PttAudioWaveView", 1, "createBitmapSafely catch OutOfMemoryError");
            return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
        }
    }

    private void c() {
        Paint paint;
        if (this.P != null && (paint = this.f191754e) != null && this.f191752d.length > 0 && this.f191772r0) {
            int i3 = 0;
            this.f191772r0 = false;
            paint.setStrokeWidth(1.0f);
            this.f191754e.setColor(this.C);
            this.f191754e.setXfermode(this.f191769o0);
            this.P.drawPaint(this.f191754e);
            this.f191754e.setXfermode(null);
            while (true) {
                float[] fArr = this.f191752d;
                if (i3 < fArr.length) {
                    int i16 = this.f191775u0;
                    g(i3, i16 - fArr[i3], i16);
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void d() {
        this.f191754e.setStrokeWidth(1.0f);
        this.f191754e.setXfermode(this.f191769o0);
        this.N.drawPaint(this.f191754e);
        this.f191754e.setXfermode(null);
        this.f191770p0.set(0.0f, 0.0f, this.I, getMeasuredHeight());
        this.N.drawRect(this.f191770p0, this.f191754e);
        this.f191754e.setAlpha(75);
        this.f191770p0.set(this.I, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.N.drawRect(this.f191770p0, this.f191754e);
        this.f191754e.setAlpha(255);
    }

    private void e(Canvas canvas) {
        this.f191754e.setStrokeWidth(this.f191751c0);
        float f16 = this.I;
        int i3 = this.f191758g0;
        if (f16 > i3) {
            this.I = i3;
        }
        float f17 = this.I;
        int i16 = this.f191760h0;
        if (f17 < i16) {
            this.I = i16;
        }
        int dip2px = ViewUtils.dip2px(1.0f);
        int measuredHeight = getMeasuredHeight() - ViewUtils.dip2px(1.0f);
        if (this.f191767m0) {
            float f18 = this.I;
            float f19 = dip2px;
            float f26 = measuredHeight;
            int i17 = this.D;
            this.f191754e.setShader(new LinearGradient(f18, f19, f18, f26, new int[]{i17, this.C, i17}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            float f27 = this.I;
            canvas.drawLine(f27, f19, f27, f26, this.f191754e);
            this.f191754e.setShader(null);
        }
    }

    private void f() {
        if (this.P != null && this.f191754e != null && this.f191752d.length > 0 && this.f191777w0) {
            if (this.f191776v0 == 0) {
                this.f191776v0 = SystemClock.elapsedRealtime();
            }
            int i3 = 0;
            this.f191772r0 = false;
            this.f191754e.setStrokeWidth(1.0f);
            this.f191754e.setColor(this.C);
            this.f191754e.setXfermode(this.f191769o0);
            this.P.drawPaint(this.f191754e);
            this.f191754e.setXfermode(null);
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f191776v0;
            while (true) {
                float[] fArr = this.f191752d;
                if (i3 >= fArr.length) {
                    break;
                }
                float f16 = (float) (elapsedRealtime - (i3 * 24));
                if (f16 > 0.0f) {
                    float min = fArr[i3] * Math.min(f16 / 160.0f, 1.0f);
                    this.f191780z0[i3] = min;
                    int i16 = this.f191775u0;
                    g(i3, i16 - min, i16);
                }
                i3++;
            }
            if (((float) elapsedRealtime) < ((this.f191780z0.length - 1) * 24) + 160.0f) {
                invalidate();
            } else {
                this.f191778x0 = true;
            }
        }
    }

    public static float h(int i3, int i16, float f16) {
        return (float) (1.0d - Math.pow(1.0f - (i3 / i16), f16 * 2.0f));
    }

    private int i() {
        int measuredHeight = getMeasuredHeight() - this.f191768n0;
        if (measuredHeight < ViewUtils.dip2px(12.0f)) {
            measuredHeight = ViewUtils.dip2px(12.0f);
        }
        if (measuredHeight > ViewUtils.dip2px(17.0f)) {
            return ViewUtils.dip2px(17.0f);
        }
        return measuredHeight;
    }

    private void k() {
        Paint paint = new Paint();
        this.f191754e = paint;
        paint.setAntiAlias(true);
        this.f191754e.setColor(this.C);
        this.f191754e.setStrokeWidth(1.0f);
        this.F = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f191753d0 = new PorterDuffXfermode(this.f191755e0);
        int dip2px = ViewUtils.dip2px(3.0f);
        this.U = dip2px;
        this.f191749a0 = dip2px;
        this.f191750b0 = ViewUtils.dip2px(2.0f);
        this.f191751c0 = ViewUtils.dip2px(1.0f);
        this.f191762i0 = com.tencent.mobileqq.aio.msglist.holder.c.f190651a.e();
        this.f191771q0 = ViewUtils.dip2px(5.0f);
    }

    private Bitmap l(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return b(i3, i16);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i3 && height == i16) {
            return bitmap;
        }
        Bitmap b16 = b(i3, i16);
        if (QLog.isColorLevel()) {
            QLog.d("PttAudioWaveView", 2, "initBitmap change width =" + i3 + " height=" + i16 + " oldBitmapWidth =" + width + " oldBitmpHeight=" + height);
        }
        return b16;
    }

    private void o(float f16, int i3, int i16) {
        this.f191766m = true;
        this.f191761i = (f16 - i3) / (i16 - i3);
    }

    public static int p(int i3, float f16) {
        return (((int) ((((((i3 >> 24) & 255) / 255.0f) * f16) * 255.0f) + 0.5f)) << 24) | (((int) (((((i3 >> 16) & 255) / 255.0f) * 255.0f) + 0.5f)) << 16) | (((int) (((((i3 >> 8) & 255) / 255.0f) * 255.0f) + 0.5f)) << 8) | ((int) ((((i3 & 255) / 255.0f) * 255.0f) + 0.5f));
    }

    private void q(boolean z16) {
        super.setPressed(z16);
    }

    public void a() {
        float f16;
        float f17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        this.G = true;
        int[] iArr = this.H;
        int length = (iArr.length % 4) + 3;
        this.f191752d = new float[iArr.length];
        int i3 = this.V - this.W;
        for (int i16 = 0; i16 < this.f191752d.length; i16++) {
            float h16 = h(this.H[i16], 255, this.C0);
            if (h16 > 0.9d) {
                f16 = this.U + (h16 * (this.W - r5));
                h16 = (float) Math.sin((6.28d / length) * i16);
                f17 = i3;
            } else {
                int i17 = this.U;
                f16 = i17;
                f17 = this.V - i17;
            }
            float f18 = f16 + (h16 * f17);
            if (f18 > this.f191749a0) {
                this.f191749a0 = (int) f18;
            }
            this.f191752d[i16] = f18;
        }
        int i18 = 1;
        while (true) {
            float[] fArr = this.f191752d;
            if (i18 < fArr.length - 1) {
                float f19 = fArr[i18 - 1];
                int i19 = i18 + 1;
                float f26 = fArr[i19];
                double d16 = f19 * 0.5d;
                float f27 = fArr[i18];
                if (d16 > f27) {
                    fArr[i18] = (f19 + f27) / 2.0f;
                }
                double d17 = f26 * 0.5d;
                float f28 = fArr[i18];
                if (d17 > f28) {
                    fArr[i18] = (f28 + f26) / 2.0f;
                }
                i18 = i19;
            } else {
                return;
            }
        }
    }

    protected void g(int i3, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        int length = this.f191752d.length;
        int measuredWidth = getMeasuredWidth() - 1;
        int i16 = this.Q;
        float f18 = ((measuredWidth - i16) - this.S) / length;
        int i17 = this.f191771q0;
        if (f18 > i17) {
            f18 = i17;
        }
        this.f191774t0 = f18;
        int i18 = ((int) (i3 * f18)) + 1 + i16;
        int i19 = this.f191750b0 + i18;
        float f19 = i18;
        float f26 = i19;
        this.f191770p0.set(f19, f16, f26, f17);
        this.P.drawRect(this.f191770p0, this.f191754e);
        if (i3 == this.f191752d.length - 1) {
            this.f191758g0 = i19;
        }
        if (i3 == 0) {
            this.f191760h0 = i18;
        }
        float f27 = (int) (this.f191750b0 / 2.0f);
        this.f191770p0.set(f19, (f16 - f27) + 1.0f, f26, f16 + f27 + 1.0f);
        this.P.drawArc(this.f191770p0, 180.0f, 180.0f, true, this.f191754e);
        this.f191770p0.set(f19, (f17 - f27) - 1.0f, f26, (f17 + f27) - 1.0f);
        this.P.drawArc(this.f191770p0, 180.0f, -180.0f, true, this.f191754e);
    }

    public float j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Float) iPatchRedirector.redirect((short) 10, (Object) this)).floatValue();
        }
        return this.I;
    }

    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        this.I = 0.0f;
        this.f191761i = 0.0f;
        invalidate();
    }

    public void n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.f191777w0 = false;
            this.f191778x0 = false;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        int saveLayer;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) canvas);
            return;
        }
        Bitmap bitmap2 = this.L;
        if (bitmap2 != null && !bitmap2.isRecycled() && (bitmap = this.M) != null && !bitmap.isRecycled()) {
            if (this.f191777w0) {
                f();
            } else {
                c();
            }
            if (this.I <= 0.0f && !this.f191765l0) {
                canvas.save();
                saveLayer = 0;
            } else {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
                this.f191773s0 = true;
            }
            this.f191754e.setXfermode(null);
            this.f191754e.setColor(this.C);
            canvas.drawBitmap(this.M, 0.0f, 0.0f, this.f191754e);
            if (this.I > 0.0f) {
                d();
                this.f191754e.setXfermode(this.f191753d0);
                canvas.drawBitmap(this.L, 0.0f, 0.0f, this.f191754e);
                this.f191754e.setXfermode(null);
            }
            if (this.I > 0.0f || this.f191765l0) {
                e(canvas);
            }
            if (this.f191773s0) {
                canvas.restoreToCount(saveLayer);
                this.f191773s0 = false;
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0 && z16) {
            this.Q = getPaddingLeft();
            this.R = getPaddingTop();
            this.S = getPaddingRight();
            this.T = getPaddingBottom();
            int measuredWidth = ((this.f191756f + (getMeasuredWidth() / 2)) / 2) - (getMeasuredWidth() / 2);
            this.f191756f = measuredWidth;
            if (measuredWidth < 0) {
                this.f191756f = 0;
            }
            this.f191759h = getMeasuredHeight() / 2;
            this.f191768n0 = getMeasuredHeight() - ViewUtils.dip2px(17.0f);
            this.f191775u0 = getMeasuredHeight() - (this.f191768n0 / 2);
            this.V = i();
            this.L = l(this.L, this.f191762i0 + this.Q + this.S, getMeasuredHeight() + this.R + this.T);
            this.M = l(this.M, this.f191762i0 + this.Q + this.S, getMeasuredHeight() + this.R + this.T);
            this.N = new Canvas(this.L);
            this.P = new Canvas(this.M);
            this.f191772r0 = true;
            this.W = (int) (this.V * 0.8d);
            if (!this.G) {
                a();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent.getAction() == 0) {
            this.A0 = motionEvent.getX();
            this.B0 = motionEvent.getY();
            this.f191763j0 = false;
            this.f191765l0 = false;
            q(true);
            if (this.I > 0.0f) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        if (motionEvent.getAction() == 2) {
            float abs = Math.abs(motionEvent.getX() - this.A0);
            if (!this.f191763j0 && abs > this.F) {
                this.f191763j0 = true;
                getParent().requestDisallowInterceptTouchEvent(true);
                a aVar = this.K;
                if (aVar != null) {
                    aVar.a();
                }
            }
            if (this.f191764k0 && this.f191763j0) {
                this.I = motionEvent.getX();
                invalidate();
                o(motionEvent.getX(), this.f191760h0, this.f191758g0);
                c cVar = this.f191757f0;
                if (cVar != null) {
                    if (!this.f191765l0) {
                        this.f191765l0 = true;
                        cVar.c(this);
                    }
                    this.f191757f0.b(this, Math.min(Math.max(this.f191761i, 0.0f), 1.0f));
                }
            }
            return true;
        }
        if (motionEvent.getAction() == 1) {
            a aVar2 = this.K;
            if (aVar2 != null) {
                aVar2.endDrag();
            }
            this.f191765l0 = false;
            q(false);
            if (!this.f191763j0) {
                View.OnClickListener onClickListener = this.J;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                return true;
            }
            c cVar2 = this.f191757f0;
            if (cVar2 != null) {
                cVar2.a(this, this.f191761i, this.f191764k0);
            }
            if (this.f191764k0) {
                return true;
            }
        } else if (motionEvent.getAction() == 3) {
            a aVar3 = this.K;
            if (aVar3 != null) {
                aVar3.endDrag();
            }
            c cVar3 = this.f191757f0;
            if (cVar3 != null) {
                cVar3.a(this, this.f191761i, this.f191764k0);
            }
            this.f191765l0 = false;
        }
        return false;
    }

    public void r() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        int length = this.H.length;
        this.f191780z0 = new float[length];
        if (length > 0 && !this.f191778x0 && this.f191777w0 && (bVar = this.f191779y0) != null) {
            bVar.onStart();
        }
    }

    public float s(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Float) iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16))).floatValue();
        }
        float f17 = this.f191774t0;
        float length = this.f191752d.length * f17;
        return (f16 / length) * (length - (f17 - this.f191750b0));
    }

    public void setAudioData(ArrayList<Byte> arrayList, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i16 = 3;
        int i17 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, arrayList, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.G = false;
        this.f191777w0 = z16;
        int dip2px = i3 / ViewUtils.dip2px(5.0f);
        if (dip2px > 50) {
            dip2px = 50;
        }
        if (dip2px >= 3) {
            i16 = dip2px;
        }
        if (arrayList == null) {
            this.H = new int[i16];
            Random random = new Random(System.currentTimeMillis());
            while (i17 < i16) {
                this.H[i17] = random.nextInt(255);
                i17++;
            }
            return;
        }
        if (arrayList.isEmpty()) {
            this.H = new int[i16];
            while (i17 < i16) {
                this.H[i17] = 80;
                i17++;
            }
            return;
        }
        int[] iArr = new int[i16];
        float size = arrayList.size() / i16;
        int i18 = 255;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        float f16 = size;
        long j3 = 0;
        for (int i28 = 0; i28 < arrayList.size(); i28++) {
            j3 += arrayList.get(i28).byteValue() & 255;
            i19++;
            if (i28 >= f16 || i28 == arrayList.size() - 1) {
                int i29 = i27 + 1;
                iArr[i27] = (int) (j3 / i19);
                int i36 = i29 - 1;
                i26 = Math.max(i26, iArr[i36]);
                i18 = Math.min(i18, iArr[i36]);
                f16 = size * (i29 + 1);
                i27 = i29;
                j3 = 0;
                i19 = 0;
            }
        }
        this.H = iArr;
        if (this.f191752d.length <= 0 && this.f191759h > 0) {
            a();
            this.f191772r0 = true;
        }
        r();
    }

    public void setCanSupportSlide(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f191764k0 = z16;
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) onClickListener);
        } else {
            this.J = onClickListener;
        }
    }

    public void setOnDragProgressListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
        } else {
            this.K = aVar;
        }
    }

    public void setOnSendAnimStartListener(b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) bVar);
        } else {
            this.f191779y0 = bVar;
        }
    }

    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Float.valueOf(f16));
            return;
        }
        float f17 = 1.0f;
        if (f16 == 1.0f) {
            f16 = 0.0f;
        }
        if (this.f191766m && f16 < this.f191761i) {
            return;
        }
        this.f191766m = false;
        if (f16 <= 1.0f) {
            f17 = f16;
        }
        float s16 = s(f17);
        this.f191761i = s16;
        this.I = this.f191758g0 * s16;
        invalidate();
    }

    public void setProgressColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else if (i3 != this.C) {
            this.C = i3;
            this.D = p(i3, 0.33f);
            this.f191772r0 = true;
            invalidate();
        }
    }

    public void setProgressX(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
        } else {
            this.I = f16;
        }
    }

    public void setSeekListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.f191757f0 = cVar;
        }
    }

    public PttAudioWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f191752d = new float[0];
        this.f191759h = -1;
        this.f191761i = 0.0f;
        this.f191766m = false;
        this.C = -1;
        this.D = p(-1, 0.33f);
        this.E = 1;
        this.G = true;
        this.I = 0.0f;
        this.f191755e0 = PorterDuff.Mode.SRC_IN;
        this.f191758g0 = 0;
        this.f191760h0 = 0;
        this.f191763j0 = false;
        this.f191764k0 = false;
        this.f191765l0 = false;
        this.f191767m0 = true;
        this.f191768n0 = 0;
        this.f191769o0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f191770p0 = new RectF();
        this.f191772r0 = false;
        this.f191773s0 = false;
        this.f191774t0 = 0.0f;
        this.f191775u0 = -1;
        this.f191776v0 = 0L;
        this.f191777w0 = false;
        this.f191778x0 = false;
        this.f191780z0 = new float[0];
        this.A0 = 0.0f;
        this.B0 = 0.0f;
        this.C0 = 1.5f;
        k();
    }

    public PttAudioWaveView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f191752d = new float[0];
        this.f191759h = -1;
        this.f191761i = 0.0f;
        this.f191766m = false;
        this.C = -1;
        this.D = p(-1, 0.33f);
        this.E = 1;
        this.G = true;
        this.I = 0.0f;
        this.f191755e0 = PorterDuff.Mode.SRC_IN;
        this.f191758g0 = 0;
        this.f191760h0 = 0;
        this.f191763j0 = false;
        this.f191764k0 = false;
        this.f191765l0 = false;
        this.f191767m0 = true;
        this.f191768n0 = 0;
        this.f191769o0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f191770p0 = new RectF();
        this.f191772r0 = false;
        this.f191773s0 = false;
        this.f191774t0 = 0.0f;
        this.f191775u0 = -1;
        this.f191776v0 = 0L;
        this.f191777w0 = false;
        this.f191778x0 = false;
        this.f191780z0 = new float[0];
        this.A0 = 0.0f;
        this.B0 = 0.0f;
        this.C0 = 1.5f;
        k();
    }
}

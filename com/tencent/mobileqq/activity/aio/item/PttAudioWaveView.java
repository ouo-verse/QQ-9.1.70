package com.tencent.mobileqq.activity.aio.item;

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
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Random;

/* loaded from: classes10.dex */
public class PttAudioWaveView extends View {
    private float A0;
    int C;
    private int D;
    private int E;
    private volatile boolean F;
    private int[] G;
    private float H;
    View.OnLongClickListener I;
    View.OnClickListener J;
    private boolean K;
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
    private int f179388a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f179389b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f179390c0;

    /* renamed from: d, reason: collision with root package name */
    private float[] f179391d;

    /* renamed from: d0, reason: collision with root package name */
    private int f179392d0;

    /* renamed from: e, reason: collision with root package name */
    private Paint f179393e;

    /* renamed from: e0, reason: collision with root package name */
    private Xfermode f179394e0;

    /* renamed from: f, reason: collision with root package name */
    private int f179395f;

    /* renamed from: f0, reason: collision with root package name */
    private PorterDuff.Mode f179396f0;

    /* renamed from: g0, reason: collision with root package name */
    private b f179397g0;

    /* renamed from: h, reason: collision with root package name */
    private int f179398h;

    /* renamed from: h0, reason: collision with root package name */
    private int f179399h0;

    /* renamed from: i, reason: collision with root package name */
    private float f179400i;

    /* renamed from: i0, reason: collision with root package name */
    private int f179401i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f179402j0;

    /* renamed from: k0, reason: collision with root package name */
    boolean f179403k0;

    /* renamed from: l0, reason: collision with root package name */
    boolean f179404l0;

    /* renamed from: m, reason: collision with root package name */
    private int f179405m;

    /* renamed from: m0, reason: collision with root package name */
    boolean f179406m0;

    /* renamed from: n0, reason: collision with root package name */
    boolean f179407n0;

    /* renamed from: o0, reason: collision with root package name */
    boolean f179408o0;

    /* renamed from: p0, reason: collision with root package name */
    int f179409p0;

    /* renamed from: q0, reason: collision with root package name */
    PorterDuffXfermode f179410q0;

    /* renamed from: r0, reason: collision with root package name */
    RectF f179411r0;

    /* renamed from: s0, reason: collision with root package name */
    private int f179412s0;

    /* renamed from: t0, reason: collision with root package name */
    boolean f179413t0;

    /* renamed from: u0, reason: collision with root package name */
    boolean f179414u0;

    /* renamed from: v0, reason: collision with root package name */
    boolean f179415v0;

    /* renamed from: w0, reason: collision with root package name */
    private float f179416w0;

    /* renamed from: x0, reason: collision with root package name */
    float f179417x0;

    /* renamed from: y0, reason: collision with root package name */
    float f179418y0;

    /* renamed from: z0, reason: collision with root package name */
    Runnable f179419z0;

    /* loaded from: classes10.dex */
    public interface a {
    }

    /* loaded from: classes10.dex */
    public interface b {
        void a(PttAudioWaveView pttAudioWaveView, float f16);

        void b(PttAudioWaveView pttAudioWaveView);
    }

    public PttAudioWaveView(Context context) {
        super(context);
        this.f179391d = new float[0];
        this.f179398h = -1;
        this.f179400i = 0.0f;
        this.f179405m = -1;
        this.C = o(-1, 0.33f);
        this.D = 1;
        this.F = true;
        this.H = 0.0f;
        this.K = false;
        this.f179396f0 = PorterDuff.Mode.SRC_IN;
        this.f179399h0 = 0;
        this.f179401i0 = 0;
        this.f179403k0 = false;
        this.f179404l0 = false;
        this.f179406m0 = false;
        this.f179407n0 = false;
        this.f179408o0 = true;
        this.f179409p0 = 15;
        this.f179410q0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f179411r0 = new RectF();
        this.f179413t0 = false;
        this.f179414u0 = false;
        this.f179415v0 = false;
        this.f179416w0 = 0.0f;
        this.f179417x0 = 0.0f;
        this.f179418y0 = 0.0f;
        this.f179419z0 = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.1
            @Override // java.lang.Runnable
            public void run() {
                PttAudioWaveView pttAudioWaveView = PttAudioWaveView.this;
                pttAudioWaveView.f179403k0 = true;
                pttAudioWaveView.p(false);
                PttAudioWaveView pttAudioWaveView2 = PttAudioWaveView.this;
                View.OnLongClickListener onLongClickListener = pttAudioWaveView2.I;
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(pttAudioWaveView2);
                }
            }
        };
        this.A0 = 1.5f;
        k();
    }

    public static double b(int[] iArr) {
        int length = iArr.length;
        double d16 = 0.0d;
        double d17 = 0.0d;
        for (int i3 : iArr) {
            d17 += i3;
        }
        double d18 = length;
        double d19 = d17 / d18;
        for (int i16 : iArr) {
            d16 += (i16 - d19) * (i16 - d19);
        }
        return d16 / d18;
    }

    public static int[] d(int[] iArr, int i3) {
        if (i3 < 100) {
            int[] iArr2 = new int[i3];
            for (int i16 = 0; i16 < i3; i16++) {
                int i17 = (int) (iArr[i16] * 0.024805825f);
                iArr2[i16] = i17;
                if (i17 > 255) {
                    iArr2[i16] = 255;
                }
            }
            return iArr2;
        }
        int[] iArr3 = new int[100];
        float f16 = i3 / 100.0f;
        int i18 = 0;
        int i19 = 0;
        float f17 = f16;
        long j3 = 0;
        for (int i26 = 0; i26 < i3; i26++) {
            j3 += iArr[i26];
            i18++;
            if (i26 > f17) {
                int i27 = (int) ((((float) j3) / i18) * 0.024805825f);
                iArr3[i19] = i27;
                if (i27 > 255) {
                    iArr3[i19] = 255;
                }
                i19++;
                f17 = f16 * (i19 + 1);
                i18 = 0;
                j3 = 0;
            }
        }
        return iArr3;
    }

    private void f() {
        if (this.P != null && this.f179393e != null && this.f179391d.length > 0 && this.f179414u0) {
            if (QLog.isColorLevel()) {
                QLog.d("PttAudioWaveView", 2, "drawBitMapDesWave mSelectColor=" + Integer.toHexString(this.f179405m) + "bitmpt" + this.M.getHeight() + " " + this.M.getWidth() + " len" + this.f179391d.length + " this=" + this);
            }
            int i3 = 0;
            this.f179414u0 = false;
            this.f179393e.setStrokeWidth(1.0f);
            this.f179393e.setColor(this.f179405m);
            this.f179393e.setXfermode(this.f179410q0);
            this.P.drawPaint(this.f179393e);
            this.f179393e.setXfermode(null);
            while (true) {
                float[] fArr = this.f179391d;
                if (i3 < fArr.length) {
                    int i16 = this.f179398h;
                    float f16 = fArr[i3];
                    i(i3, i16 - (f16 / 2.0f), i16 + (f16 / 2.0f));
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void g() {
        this.f179393e.setStrokeWidth(1.0f);
        this.f179393e.setXfermode(this.f179410q0);
        this.N.drawPaint(this.f179393e);
        this.f179393e.setXfermode(null);
        this.f179411r0.set(0.0f, 0.0f, this.H, getMeasuredHeight());
        this.N.drawRect(this.f179411r0, this.f179393e);
        this.f179393e.setAlpha(75);
        this.f179411r0.set(this.H, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.N.drawRect(this.f179411r0, this.f179393e);
        this.f179393e.setAlpha(255);
    }

    private void h(Canvas canvas) {
        this.f179393e.setStrokeWidth(this.f179392d0);
        float f16 = this.H;
        int i3 = this.f179399h0;
        if (f16 > i3) {
            this.H = i3;
        }
        float f17 = this.H;
        int i16 = this.f179401i0;
        if (f17 < i16) {
            this.H = i16;
        }
        if (this.f179408o0) {
            float f18 = this.H;
            float measuredHeight = getMeasuredHeight();
            int i17 = this.C;
            this.f179393e.setShader(new LinearGradient(f18, 0.0f, f18, measuredHeight, new int[]{i17, this.f179405m, i17}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
            float f19 = this.H;
            canvas.drawLine(f19, 0.0f, f19, getMeasuredHeight(), this.f179393e);
            this.f179393e.setShader(null);
        }
    }

    public static float j(int i3, int i16, float f16) {
        return (float) (1.0d - Math.pow(1.0f - (i3 / i16), f16 * 2.0f));
    }

    private void k() {
        Paint paint = new Paint();
        this.f179393e = paint;
        paint.setAntiAlias(true);
        this.f179393e.setColor(this.f179405m);
        this.f179393e.setStrokeWidth(this.D);
        this.E = ViewConfiguration.get(getContext()).getScaledTouchSlop() * 2;
        this.f179394e0 = new PorterDuffXfermode(this.f179396f0);
        int dip2px = ViewUtils.dip2px(3.0f);
        this.U = dip2px;
        this.f179388a0 = dip2px;
        this.f179390c0 = ViewUtils.dip2px(3.0f) - 1;
        this.f179392d0 = ViewUtils.dip2px(1.0f);
        this.f179402j0 = ViewUtils.dip2px(174.0f);
        this.f179412s0 = ViewUtils.dip2px(5.0f);
    }

    private Bitmap l(Bitmap bitmap, int i3, int i16) {
        if (bitmap == null) {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width == i3 && height == i16) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        if (QLog.isColorLevel()) {
            QLog.d("PttAudioWaveView", 2, "initBitmap change width =" + i3 + " height=" + i16 + " oldBitmapWidth =" + width + " oldBitmpHeight=" + height);
        }
        return createBitmap;
    }

    private void n(float f16, int i3, int i16) {
        this.f179400i = (f16 - i3) / (i16 - i3);
    }

    public static int o(int i3, float f16) {
        return (((int) ((((((i3 >> 24) & 255) / 255.0f) * f16) * 255.0f) + 0.5f)) << 24) | (((int) (((((i3 >> 16) & 255) / 255.0f) * 255.0f) + 0.5f)) << 16) | (((int) (((((i3 >> 8) & 255) / 255.0f) * 255.0f) + 0.5f)) << 8) | ((int) ((((i3 & 255) / 255.0f) * 255.0f) + 0.5f));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16) {
        super.setPressed(z16);
    }

    public void c() {
        float f16;
        float f17;
        this.F = true;
        int[] iArr = this.G;
        int length = (iArr.length % 4) + 3;
        this.f179391d = new float[iArr.length];
        int i3 = this.V - this.W;
        for (int i16 = 0; i16 < this.f179391d.length; i16++) {
            float j3 = j(this.G[i16], 255, this.A0);
            if (j3 > 0.9d) {
                f16 = this.U + (j3 * (this.W - r5));
                j3 = (float) Math.sin((6.28d / length) * i16);
                f17 = i3;
            } else {
                int i17 = this.U;
                f16 = i17;
                f17 = this.V - i17;
            }
            float f18 = f16 + (j3 * f17);
            if (f18 > this.f179388a0) {
                this.f179388a0 = (int) f18;
            }
            this.f179391d[i16] = f18;
        }
        int i18 = 1;
        while (true) {
            float[] fArr = this.f179391d;
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

    public void e() {
        if (QLog.isColorLevel()) {
            QLog.d("PttAudioWaveView", 2, "destory");
        }
        Bitmap bitmap = this.L;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.L.recycle();
        }
        Bitmap bitmap2 = this.M;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.M.recycle();
        }
        this.L = null;
        this.M = null;
    }

    protected void i(int i3, float f16, float f17) {
        int length = this.f179391d.length;
        int measuredWidth = getMeasuredWidth();
        int i16 = this.D;
        int i17 = this.Q;
        float f18 = (((measuredWidth - i16) - i17) - this.S) / length;
        int i18 = this.f179412s0;
        if (f18 > i18) {
            f18 = i18;
        }
        this.f179416w0 = f18;
        int i19 = ((int) (i3 * f18)) + i16 + i17;
        int i26 = this.f179390c0 + i19;
        float f19 = i19;
        float f26 = i26;
        this.f179411r0.set(f19, f16, f26, f17);
        this.P.drawRect(this.f179411r0, this.f179393e);
        if (i3 == this.f179391d.length - 1) {
            this.f179399h0 = i26;
        }
        if (i3 == 0) {
            this.f179401i0 = i19;
        }
        float f27 = (int) (this.f179390c0 / 2.0f);
        this.f179411r0.set(f19, (f16 - f27) + 1.0f, f26, f16 + f27 + 1.0f);
        this.P.drawArc(this.f179411r0, 180.0f, 180.0f, true, this.f179393e);
        this.f179411r0.set(f19, (f17 - f27) - 1.0f, f26, (f17 + f27) - 1.0f);
        this.P.drawArc(this.f179411r0, 180.0f, -180.0f, true, this.f179393e);
    }

    public void m() {
        this.H = 0.0f;
        this.f179400i = 0.0f;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap;
        int saveLayer;
        Bitmap bitmap2 = this.L;
        if (bitmap2 != null && !bitmap2.isRecycled() && (bitmap = this.M) != null && !bitmap.isRecycled()) {
            f();
            if (this.H <= 0.0f && !this.f179407n0) {
                canvas.save();
                saveLayer = 0;
            } else {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight(), null, 31);
                this.f179415v0 = true;
            }
            this.f179393e.setXfermode(null);
            this.f179393e.setColor(this.f179405m);
            canvas.drawBitmap(this.M, 0.0f, 0.0f, this.f179393e);
            if (this.H > 0.0f) {
                g();
                this.f179393e.setXfermode(this.f179394e0);
                canvas.drawBitmap(this.L, 0.0f, 0.0f, this.f179393e);
                this.f179393e.setXfermode(null);
            }
            if (this.H > 0.0f || this.f179407n0) {
                h(canvas);
            }
            if (this.f179415v0) {
                canvas.restoreToCount(saveLayer);
                this.f179415v0 = false;
            } else {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (QLog.isColorLevel()) {
            QLog.d("PttAudioWaveView", 2, "onLayout changed=" + z16 + " left=" + i3 + " top=" + i16 + " right=" + i17 + " bottom=" + i18 + " hasDataConvert=" + this.F);
        }
        if (getMeasuredWidth() > 0 && getMeasuredHeight() > 0) {
            if (z16) {
                this.Q = getPaddingLeft();
                this.R = getPaddingTop();
                this.S = getPaddingRight();
                this.T = getPaddingBottom();
                int measuredWidth = ((this.f179395f + (getMeasuredWidth() / 2)) / 2) - (getMeasuredWidth() / 2);
                this.f179395f = measuredWidth;
                if (measuredWidth < 0) {
                    this.f179395f = 0;
                }
                this.f179398h = getMeasuredHeight() / 2;
                int measuredHeight = getMeasuredHeight() - (ViewUtils.dpToPx(this.f179409p0) * 2);
                this.V = measuredHeight;
                if (measuredHeight < ViewUtils.dpToPx(12.0f)) {
                    this.V = ViewUtils.dpToPx(12.0f);
                }
                int i19 = this.f179398h;
                int i26 = this.V;
                this.f179389b0 = i19 + (i26 / 2);
                this.W = (int) (i26 * 0.8d);
                if (!this.F) {
                    c();
                }
            }
            boolean z17 = z16 | this.K;
            this.K = z17;
            if (z17) {
                this.L = l(this.L, this.f179402j0 + this.Q + this.S, getMeasuredHeight() + this.R + this.T);
                this.M = l(this.M, this.f179402j0 + this.Q + this.S, getMeasuredHeight() + this.R + this.T);
                this.N = new Canvas(this.L);
                this.P = new Canvas(this.M);
                this.f179414u0 = true;
                this.K = false;
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f179417x0 = motionEvent.getX();
            this.f179418y0 = motionEvent.getY();
            if (this.f179413t0) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            this.f179403k0 = false;
            this.f179404l0 = false;
            this.f179407n0 = false;
            p(true);
            getHandler().postDelayed(this.f179419z0, 500L);
            return true;
        }
        if (motionEvent.getAction() == 2) {
            float abs = Math.abs(motionEvent.getX() - this.f179417x0);
            float abs2 = Math.abs(motionEvent.getY() - this.f179418y0);
            int i3 = this.E;
            if (abs > i3 || abs2 > i3) {
                if (this.f179406m0) {
                    this.H = motionEvent.getX();
                    invalidate();
                    n(motionEvent.getX(), this.f179401i0, this.f179399h0);
                    b bVar = this.f179397g0;
                    if (bVar != null && !this.f179407n0) {
                        this.f179407n0 = true;
                        bVar.b(this);
                    }
                }
                getHandler().removeCallbacks(this.f179419z0);
                this.f179404l0 = true;
            }
            return true;
        }
        if (motionEvent.getAction() == 1) {
            getHandler().removeCallbacks(this.f179419z0);
            this.f179407n0 = false;
            p(false);
            boolean z16 = this.f179403k0;
            if (!z16 && !this.f179404l0) {
                View.OnClickListener onClickListener = this.J;
                if (onClickListener != null) {
                    onClickListener.onClick(this);
                }
                return true;
            }
            if (!z16 && this.f179406m0) {
                b bVar2 = this.f179397g0;
                if (bVar2 != null) {
                    bVar2.a(this, this.f179400i);
                    ReportController.o(null, "dc00898", "", "", "0X8009D00", "0X8009D00", 3, 0, "", "", "", "");
                }
                return true;
            }
        } else if (motionEvent.getAction() == 3) {
            getHandler().removeCallbacks(this.f179419z0);
            this.f179407n0 = false;
        }
        return false;
    }

    public float q(float f16) {
        float f17 = this.f179416w0;
        float length = this.f179391d.length * f17;
        return (f16 / length) * (length - (f17 - this.f179390c0));
    }

    public void setAudioData(int[] iArr, int i3, int i16) {
        Object obj;
        int i17 = 0;
        this.F = false;
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("setAudioData mCenterHeight=");
            sb5.append(this.f179398h);
            sb5.append(" data.length");
            float[] fArr = this.f179391d;
            if (fArr != null) {
                obj = Integer.valueOf(fArr.length);
            } else {
                obj = "";
            }
            sb5.append(obj);
            QLog.d("PttAudioWaveView", 2, sb5.toString());
        }
        int dpToPx = i3 / ViewUtils.dpToPx(5.0f);
        if (dpToPx > 34) {
            dpToPx = 34;
        }
        if (dpToPx < 3) {
            dpToPx = 3;
        }
        int i18 = 255;
        if (iArr == null) {
            this.G = new int[dpToPx];
            Random random = new Random(System.currentTimeMillis());
            while (i17 < dpToPx) {
                this.G[i17] = random.nextInt(255);
                i17++;
            }
            return;
        }
        int[] iArr2 = new int[dpToPx];
        float f16 = dpToPx;
        float length = iArr.length / f16;
        int i19 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        float f17 = length;
        long j3 = 0;
        while (i26 < iArr.length) {
            float f18 = length;
            float f19 = f16;
            j3 += iArr[i26];
            i27++;
            if (i26 >= f17 || i26 == iArr.length - 1) {
                int i29 = i28 + 1;
                iArr2[i28] = (int) (j3 / i27);
                int i36 = i29 - 1;
                int i37 = iArr2[i36];
                i17 += i37;
                i19 = Math.max(i19, i37);
                i18 = Math.min(i18, iArr2[i36]);
                f17 = f18 * (i29 + 1);
                i28 = i29;
                j3 = 0;
                i27 = 0;
            }
            i26++;
            f16 = f19;
            length = f18;
        }
        float f26 = f16;
        this.G = iArr2;
        if (this.f179391d.length <= 0 && this.f179398h > 0) {
            c();
            this.f179414u0 = true;
        }
        if (this.L == null) {
            this.K = true;
        }
        if (new Random().nextInt(1000) == 520) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("voiceLength", String.valueOf(i16));
            hashMap.put("waveWidth", String.valueOf(i3));
            hashMap.put("waveNum", String.valueOf(dpToPx));
            hashMap.put("waveMax", String.valueOf(i19));
            hashMap.put("waveMin", String.valueOf(i18));
            hashMap.put("waveAvg", String.valueOf(i17 / f26));
            hashMap.put("waveVar", String.valueOf(Math.sqrt(b(iArr2))));
            if (QLog.isColorLevel()) {
                QLog.d("PttAudioWaveView", 2, "real do report");
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "PttWaveInfo", true, 0L, 0L, hashMap, "");
        }
    }

    public void setCanSupportSlide(boolean z16) {
        this.f179406m0 = z16;
    }

    public void setMaxTopBottomPadding(int i3) {
        this.f179409p0 = i3;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.J = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.I = onLongClickListener;
    }

    public void setProgress(float f16) {
        if (f16 > 1.0f) {
            f16 = 1.0f;
        }
        float q16 = q(f16);
        this.f179400i = q16;
        this.H = this.f179399h0 * q16;
        invalidate();
    }

    public void setProgressColor(int i3) {
        if (i3 != this.f179405m) {
            this.f179405m = i3;
            this.C = o(i3, 0.33f);
            this.f179414u0 = true;
            invalidate();
        }
    }

    public void setProgressX(float f16) {
        this.H = f16;
    }

    public void setSeekListener(b bVar) {
        this.f179397g0 = bVar;
    }

    public void setShouldDisallowInterceptTouch(boolean z16) {
        this.f179413t0 = z16;
    }

    public void setShowProgressLine(boolean z16) {
        this.f179408o0 = z16;
    }

    public void setOnPressListener(a aVar) {
    }

    public PttAudioWaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f179391d = new float[0];
        this.f179398h = -1;
        this.f179400i = 0.0f;
        this.f179405m = -1;
        this.C = o(-1, 0.33f);
        this.D = 1;
        this.F = true;
        this.H = 0.0f;
        this.K = false;
        this.f179396f0 = PorterDuff.Mode.SRC_IN;
        this.f179399h0 = 0;
        this.f179401i0 = 0;
        this.f179403k0 = false;
        this.f179404l0 = false;
        this.f179406m0 = false;
        this.f179407n0 = false;
        this.f179408o0 = true;
        this.f179409p0 = 15;
        this.f179410q0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f179411r0 = new RectF();
        this.f179413t0 = false;
        this.f179414u0 = false;
        this.f179415v0 = false;
        this.f179416w0 = 0.0f;
        this.f179417x0 = 0.0f;
        this.f179418y0 = 0.0f;
        this.f179419z0 = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.1
            @Override // java.lang.Runnable
            public void run() {
                PttAudioWaveView pttAudioWaveView = PttAudioWaveView.this;
                pttAudioWaveView.f179403k0 = true;
                pttAudioWaveView.p(false);
                PttAudioWaveView pttAudioWaveView2 = PttAudioWaveView.this;
                View.OnLongClickListener onLongClickListener = pttAudioWaveView2.I;
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(pttAudioWaveView2);
                }
            }
        };
        this.A0 = 1.5f;
        k();
    }

    public PttAudioWaveView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f179391d = new float[0];
        this.f179398h = -1;
        this.f179400i = 0.0f;
        this.f179405m = -1;
        this.C = o(-1, 0.33f);
        this.D = 1;
        this.F = true;
        this.H = 0.0f;
        this.K = false;
        this.f179396f0 = PorterDuff.Mode.SRC_IN;
        this.f179399h0 = 0;
        this.f179401i0 = 0;
        this.f179403k0 = false;
        this.f179404l0 = false;
        this.f179406m0 = false;
        this.f179407n0 = false;
        this.f179408o0 = true;
        this.f179409p0 = 15;
        this.f179410q0 = new PorterDuffXfermode(PorterDuff.Mode.CLEAR);
        this.f179411r0 = new RectF();
        this.f179413t0 = false;
        this.f179414u0 = false;
        this.f179415v0 = false;
        this.f179416w0 = 0.0f;
        this.f179417x0 = 0.0f;
        this.f179418y0 = 0.0f;
        this.f179419z0 = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.item.PttAudioWaveView.1
            @Override // java.lang.Runnable
            public void run() {
                PttAudioWaveView pttAudioWaveView = PttAudioWaveView.this;
                pttAudioWaveView.f179403k0 = true;
                pttAudioWaveView.p(false);
                PttAudioWaveView pttAudioWaveView2 = PttAudioWaveView.this;
                View.OnLongClickListener onLongClickListener = pttAudioWaveView2.I;
                if (onLongClickListener != null) {
                    onLongClickListener.onLongClick(pttAudioWaveView2);
                }
            }
        };
        this.A0 = 1.5f;
        k();
    }
}

package com.tencent.qqnt.aio.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes23.dex */
public class BubbleImageView extends ChatThumbView {
    static IPatchRedirector $redirector_;

    /* renamed from: t0, reason: collision with root package name */
    public static final float[] f352353t0;

    /* renamed from: u0, reason: collision with root package name */
    protected static boolean f352354u0;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    public int L;
    public float M;
    Paint N;
    Bitmap P;
    Canvas Q;
    Shader R;
    ComposeShader S;
    BitmapShader T;
    Path U;
    Path V;
    RectF W;

    /* renamed from: a0, reason: collision with root package name */
    RectF f352355a0;

    /* renamed from: b0, reason: collision with root package name */
    Paint f352356b0;

    /* renamed from: c0, reason: collision with root package name */
    float[] f352357c0;

    /* renamed from: d0, reason: collision with root package name */
    private Paint f352358d0;

    /* renamed from: e0, reason: collision with root package name */
    Path f352359e0;

    /* renamed from: f0, reason: collision with root package name */
    RectF f352360f0;

    /* renamed from: g0, reason: collision with root package name */
    private float f352361g0;

    /* renamed from: h0, reason: collision with root package name */
    protected Resources f352362h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f352363i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f352364j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f352365k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f352366l0;

    /* renamed from: m, reason: collision with root package name */
    private float f352367m;

    /* renamed from: m0, reason: collision with root package name */
    private int f352368m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f352369n0;

    /* renamed from: o0, reason: collision with root package name */
    private Paint f352370o0;

    /* renamed from: p0, reason: collision with root package name */
    private Path f352371p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f352372q0;

    /* renamed from: r0, reason: collision with root package name */
    protected boolean f352373r0;

    /* renamed from: s0, reason: collision with root package name */
    protected boolean f352374s0;

    static {
        boolean z16;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        f352353t0 = new float[]{7.0f, 9.0f, 0.0f, 6.0f, 2.5f, 9.0f, 5.5f, 15.0f, 0.5f, 13.0f};
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (!upperCase.contains("BV0720") && !upperCase.contains("M821")) {
            z16 = false;
        } else {
            z16 = true;
        }
        f352354u0 = z16;
    }

    public BubbleImageView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f352367m = 14.0f;
        this.C = 8.0f;
        this.D = 0.0f;
        this.E = 5.0f;
        this.F = 4.0f;
        this.G = 10.0f;
        this.H = 10.0f;
        this.I = 16.0f;
        this.J = 1.0f;
        this.K = 14.0f;
        this.M = Math.abs(0.0f - 10.0f);
        this.f352364j0 = true;
        this.f352365k0 = false;
        this.f352366l0 = false;
        this.f352368m0 = 1610612736;
        this.f352369n0 = (int) (Math.random() * 1000.0d);
        this.f352373r0 = false;
        init();
    }

    public static int d(float f16, Resources resources) {
        return (int) ((resources.getDisplayMetrics().density * f16) + 0.5f);
    }

    private void e(Canvas canvas) {
        Shader i3;
        int width = getWidth();
        int height = getHeight();
        if (width > 0 && height > 0) {
            Bitmap bitmap = this.P;
            if (bitmap != null && (bitmap.getWidth() != width || this.P.getHeight() != height)) {
                this.P = null;
                this.W.setEmpty();
                this.U = null;
                this.f352355a0.setEmpty();
                this.V = null;
                this.R = null;
            }
            if (this.P == null) {
                try {
                    try {
                        this.P = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        this.P = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                    }
                } catch (OutOfMemoryError unused2) {
                    URLDrawable.clearMemoryCache();
                    try {
                        this.P = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                    } catch (OutOfMemoryError unused3) {
                    }
                }
                Canvas canvas2 = this.Q;
                if (canvas2 != null) {
                    canvas2.setBitmap(this.P);
                }
            }
            if (this.P == null) {
                super.draw(canvas);
                return;
            }
            if (this.Q == null) {
                Canvas canvas3 = new Canvas(this.P);
                this.Q = canvas3;
                canvas3.setBitmap(this.P);
            }
            if (this.T == null) {
                Bitmap bitmap2 = this.P;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.T = new BitmapShader(bitmap2, tileMode, tileMode);
            }
            if (this.f352365k0) {
                if (this.S == null && (i3 = i()) != null) {
                    this.S = new ComposeShader(this.T, i3, PorterDuff.Mode.SRC_OVER);
                }
                this.R = this.S;
            } else {
                this.R = this.T;
            }
            this.N.setShader(this.R);
            super.draw(this.Q);
            if (this.f352366l0) {
                this.Q.drawColor(this.f352368m0);
            }
            h(canvas);
            return;
        }
        super.draw(canvas);
    }

    private void f(Canvas canvas) {
        Path path;
        int saveCount = canvas.getSaveCount();
        canvas.save();
        super.draw(canvas);
        if (this.f352365k0) {
            if (this.f352358d0 == null) {
                Paint paint = new Paint();
                this.f352358d0 = paint;
                paint.setShader(i());
            }
            canvas.drawPaint(this.f352358d0);
        }
        if (this.f352366l0) {
            canvas.drawColor(this.f352368m0);
        }
        g(canvas);
        Paint paint2 = this.f352370o0;
        if (paint2 != null && (path = this.f352371p0) != null) {
            canvas.drawPath(path, paint2);
        }
        canvas.restoreToCount(saveCount);
    }

    private void h(Canvas canvas) {
        Resources resources = this.f352362h0;
        int width = getWidth();
        int height = getHeight();
        if (!this.f352364j0) {
            this.W.set(0.0f, 0.0f, width, height);
            RectF rectF = this.W;
            float f16 = this.f352361g0;
            canvas.drawRoundRect(rectF, f16, f16, this.N);
            return;
        }
        if (this.f352363i0) {
            if (this.W.isEmpty()) {
                this.W.set(0.0f, 0.0f, width - d(this.M, resources), height);
            }
            if (this.U == null) {
                float d16 = d(this.E, resources);
                Path path = new Path();
                path.moveTo(width - d(this.f352367m, resources), d(this.C, resources));
                path.quadTo(width - d(this.F, resources), d(this.G, resources), width, d16);
                path.quadTo(width - d(this.J, resources), d(this.K, resources), width - d(this.H, resources), d(this.I, resources));
                path.close();
                this.U = path;
            }
        } else {
            if (this.f352355a0.isEmpty()) {
                this.f352355a0.set(d(this.M, resources), 0.0f, width, height);
            }
            if (this.V == null) {
                float d17 = d(this.E, resources);
                Path path2 = new Path();
                path2.moveTo(d(this.f352367m, resources), d(this.C, resources));
                path2.quadTo(d(this.F, resources), d(this.G, resources), 0.0f, d17);
                path2.quadTo(d(this.J, resources), d(this.K, resources), d(this.H, resources), d(this.I, resources));
                path2.close();
                this.V = path2;
            }
        }
        if (this.f352363i0) {
            RectF rectF2 = this.W;
            float f17 = this.f352361g0;
            canvas.drawRoundRect(rectF2, f17, f17, this.N);
            canvas.drawPath(this.U, this.N);
            Paint paint = this.f352370o0;
            if (paint != null) {
                canvas.drawPath(this.U, paint);
                return;
            }
            return;
        }
        RectF rectF3 = this.f352355a0;
        float f18 = this.f352361g0;
        canvas.drawRoundRect(rectF3, f18, f18, this.N);
        canvas.drawPath(this.V, this.N);
        Paint paint2 = this.f352370o0;
        if (paint2 != null) {
            canvas.drawPath(this.V, paint2);
        }
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) canvas);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f352374s0) {
            super.draw(canvas);
        } else {
            int i3 = this.L;
            if (i3 == 1) {
                f(canvas);
            } else if (i3 == 2) {
                e(canvas);
            } else {
                super.draw(canvas);
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (VersionUtils.isHoneycomb()) {
            z16 = canvas.isHardwareAccelerated();
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel() && currentTimeMillis2 > 10) {
            QLog.w("BubbleImageView" + this.f352369n0, 2, "draw(): isHardwaveAccelerated= " + z16 + ", drawMode = " + this.L + ", cost =" + currentTimeMillis2);
        }
    }

    protected void g(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) canvas);
        } else {
            canvas.drawPath(this.f352359e0, this.f352356b0);
        }
    }

    public Shader i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Shader) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return null;
    }

    protected void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.f352372q0 = f352354u0;
        if (VersionUtils.isHoneycomb()) {
            this.L = 1;
        } else {
            this.L = 2;
        }
        c();
        this.f352362h0 = getResources();
        int i3 = this.L;
        if (i3 == 1) {
            Paint paint = new Paint();
            this.f352356b0 = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f352356b0.setAntiAlias(true);
            this.f352356b0.setFilterBitmap(true);
            this.f352356b0.setColor(-16777216);
            this.f352356b0.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f352359e0 = new Path();
            this.f352360f0 = new RectF();
            this.f352357c0 = new float[8];
            return;
        }
        if (i3 == 2) {
            Paint paint2 = new Paint();
            this.N = paint2;
            paint2.setAntiAlias(true);
            this.N.setFilterBitmap(true);
            this.W = new RectF();
            this.f352355a0 = new RectF();
            this.f352359e0 = new Path();
            this.f352360f0 = new RectF();
            this.f352357c0 = new float[8];
        }
    }

    @Override // android.view.View
    public void invalidate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            super.invalidate();
        }
    }

    public void j(float f16, float f17) {
        float d16;
        float d17;
        float f18;
        float d18;
        float d19;
        float d26;
        float d27;
        float d28;
        float d29;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        if (!this.f352364j0) {
            this.f352360f0.set(0.0f, 0.0f, f16, f17);
            this.f352359e0.reset();
            this.f352359e0.addRoundRect(this.f352360f0, this.f352357c0, Path.Direction.CW);
            if (this.f352373r0) {
                this.f352359e0.setFillType(Path.FillType.INVERSE_EVEN_ODD);
            }
            Path path = this.f352371p0;
            if (path != null) {
                path.reset();
                this.f352371p0.addRoundRect(this.f352360f0, this.f352357c0, Path.Direction.CW);
                return;
            }
            return;
        }
        Resources resources = this.f352362h0;
        float d36 = d(this.M, resources);
        if (this.f352363i0) {
            this.f352360f0.set(0.0f, 0.0f, f16 - d36, f17);
        } else {
            this.f352360f0.set(d36, 0.0f, f16, f17);
        }
        this.f352359e0.reset();
        float d37 = d(this.E, resources);
        if (this.f352363i0) {
            if (this.f352373r0) {
                Path path2 = new Path();
                path2.addRoundRect(this.f352360f0, this.f352357c0, Path.Direction.CW);
                path2.setFillType(Path.FillType.EVEN_ODD);
                Path path3 = new Path();
                d16 = f16 - d(this.f352367m, resources);
                d17 = d(this.C, resources);
                path3.moveTo(d16, d17);
                f18 = f16 - d(this.D, resources);
                d18 = f16 - d(this.F, resources);
                d19 = d(this.G, resources);
                path3.quadTo(d18, d19, f18, d37);
                d26 = f16 - d(this.H, resources);
                float d38 = d(this.I, resources);
                d28 = f16 - d(this.J, resources);
                float d39 = d(this.K, resources);
                path3.quadTo(d28, d39, d26, d38);
                path3.setFillType(Path.FillType.EVEN_ODD);
                Path path4 = new Path();
                path4.op(path2, path3, Path.Op.UNION);
                path4.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                this.f352359e0 = path4;
                d29 = d39;
                d27 = d38;
            } else {
                this.f352359e0.addRoundRect(this.f352360f0, this.f352357c0, Path.Direction.CW);
                d16 = f16 - d(this.f352367m, resources);
                d17 = d(this.C, resources);
                this.f352359e0.moveTo(d16, d17);
                f18 = f16 - d(this.D, resources);
                d18 = f16 - d(this.F, resources);
                d19 = d(this.G, resources);
                this.f352359e0.quadTo(d18, d19, f18, d37);
                d26 = f16 - d(this.H, resources);
                d27 = d(this.I, resources);
                d28 = f16 - d(this.J, resources);
                d29 = d(this.K, resources);
                this.f352359e0.quadTo(d28, d29, d26, d27);
            }
        } else if (this.f352373r0) {
            Path path5 = new Path();
            path5.addRoundRect(this.f352360f0, this.f352357c0, Path.Direction.CW);
            path5.setFillType(Path.FillType.EVEN_ODD);
            Path path6 = new Path();
            d16 = d(this.f352367m, resources);
            d17 = d(this.C, resources);
            path6.moveTo(d16, d17);
            f18 = this.D;
            d18 = d(this.F, resources);
            d19 = d(this.G, resources);
            path6.quadTo(d18, d19, f18, d37);
            d26 = d(this.H, resources);
            float d46 = d(this.I, resources);
            float d47 = d(this.J, resources);
            float d48 = d(this.K, resources);
            path6.quadTo(d47, d48, d26, d46);
            Path path7 = new Path();
            path7.op(path5, path6, Path.Op.UNION);
            path7.setFillType(Path.FillType.INVERSE_EVEN_ODD);
            this.f352359e0 = path7;
            d29 = d48;
            d27 = d46;
            d28 = d47;
        } else {
            this.f352359e0.addRoundRect(this.f352360f0, this.f352357c0, Path.Direction.CCW);
            d16 = d(this.f352367m, resources);
            d17 = d(this.C, resources);
            this.f352359e0.moveTo(d16, d17);
            f18 = this.D;
            d18 = d(this.F, resources);
            d19 = d(this.G, resources);
            this.f352359e0.quadTo(d18, d19, f18, d37);
            d26 = d(this.H, resources);
            d27 = d(this.I, resources);
            d28 = d(this.J, resources);
            d29 = d(this.K, resources);
            this.f352359e0.quadTo(d28, d29, d26, d27);
        }
        this.f352359e0.close();
        Path path8 = this.f352371p0;
        if (path8 != null) {
            path8.reset();
            float f19 = this.f352361g0 * 2.0f;
            if (this.f352363i0) {
                float f26 = d29;
                float asin = (float) ((Math.asin(d(this.I - this.C, resources) / this.f352357c0[2]) * 180.0d) / 3.141592653589793d);
                this.f352371p0.moveTo(d26, d27);
                this.f352371p0.lineTo(d26, f17 - this.f352361g0);
                float f27 = d26 - f19;
                float f28 = d27;
                float f29 = f17 - f19;
                this.f352360f0.set(f27, f29, d26, f17);
                this.f352371p0.arcTo(this.f352360f0, 0.0f, 90.0f);
                this.f352371p0.lineTo(this.f352361g0 + 0.0f, f17);
                this.f352360f0.set(0.0f, f29, f19, f17);
                this.f352371p0.arcTo(this.f352360f0, 90.0f, 90.0f);
                this.f352371p0.lineTo(0.0f, this.f352361g0);
                this.f352360f0.set(0.0f, 0.0f, f19, f19);
                this.f352371p0.arcTo(this.f352360f0, 180.0f, 90.0f);
                this.f352371p0.lineTo(d26 - this.f352361g0, 0.0f);
                this.f352360f0.set(f27, 0.0f, d26, f19);
                this.f352371p0.arcTo(this.f352360f0, 270.0f, 90.0f - asin);
                this.f352371p0.lineTo(d16, d17);
                this.f352371p0.quadTo(d18, d19, f18, d37);
                this.f352371p0.quadTo(d28, f26, d26, f28);
            } else {
                float f36 = d29;
                float asin2 = (float) ((Math.asin(d(this.I - this.C, resources) / this.f352357c0[0]) * 180.0d) / 3.141592653589793d);
                this.f352371p0.moveTo(d16, d17);
                float f37 = d26 + f19;
                this.f352360f0.set(d26, 0.0f, f37, f19);
                this.f352371p0.arcTo(this.f352360f0, asin2 + 180.0f, 90.0f - asin2);
                this.f352371p0.lineTo(f16 - this.f352361g0, 0.0f);
                float f38 = f16 - f19;
                this.f352360f0.set(f38, 0.0f, f16, f19);
                this.f352371p0.arcTo(this.f352360f0, 270.0f, 90.0f);
                this.f352371p0.lineTo(f16, f17 - this.f352361g0);
                float f39 = f17 - f19;
                this.f352360f0.set(f38, f39, f16, f17);
                this.f352371p0.arcTo(this.f352360f0, 0.0f, 90.0f);
                this.f352371p0.lineTo(this.f352361g0 + d26, f17);
                this.f352360f0.set(d26, f39, f37, f17);
                this.f352371p0.arcTo(this.f352360f0, 90.0f, 90.0f);
                this.f352371p0.lineTo(d26, this.f352361g0);
                this.f352371p0.lineTo(d26, d27);
                this.f352371p0.quadTo(d28, f36, f18, d37);
                this.f352371p0.quadTo(d18, d19, d16, d17);
            }
            this.f352371p0.close();
        }
    }

    public void k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        setSharpCornerCor(f352353t0);
        if (this.f352370o0 == null || this.f352371p0 == null) {
            Paint paint = new Paint();
            this.f352370o0 = paint;
            paint.setColor(i3);
            this.f352370o0.setAntiAlias(true);
            this.f352370o0.setStrokeWidth(Math.max(1, d(0.5f, getResources())));
            this.f352370o0.setStyle(Paint.Style.STROKE);
            this.f352371p0 = new Path();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(11)
    protected void onAttachedToWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onAttachedToWindow();
        if (this.f352372q0) {
            setLayerType(1, null);
        } else if (this.L == 1 && VersionUtils.isHoneycomb()) {
            setLayerType(2, null);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(11)
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.onDetachedFromWindow();
        if (this.L == 1 && VersionUtils.isHoneycomb()) {
            setLayerType(0, null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16 && this.L == 1) {
            j(getWidth(), getHeight());
        }
    }

    public void setColorMask(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.f352368m0 = i3;
        }
    }

    public void setRadius(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
            return;
        }
        float d16 = d(f16, this.f352362h0);
        this.f352361g0 = d16;
        float[] fArr = this.f352357c0;
        if (fArr != null) {
            Arrays.fill(fArr, d16);
        }
    }

    public void setRadiusBottom(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
            return;
        }
        this.f352361g0 = d(f16, this.f352362h0);
        float[] fArr = this.f352357c0;
        if (fArr != null) {
            Arrays.fill(fArr, 0, 4, 0.0f);
            Arrays.fill(this.f352357c0, 4, 8, this.f352361g0);
        }
    }

    public void setRadiusTop(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        float d16 = d(f16, this.f352362h0);
        this.f352361g0 = d16;
        float[] fArr = this.f352357c0;
        if (fArr != null) {
            Arrays.fill(fArr, 0, 4, d16);
            Arrays.fill(this.f352357c0, 4, 8, 0.0f);
        }
    }

    public void setSend(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        if (this.f352363i0 != z16) {
            this.f352363i0 = z16;
            if (getWidth() != 0 && getHeight() != 0) {
                j(getWidth(), getHeight());
            }
        }
    }

    public void setSharpCornerCor(float[] fArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) fArr);
            return;
        }
        this.f352367m = fArr[0];
        this.C = fArr[1];
        float f16 = fArr[2];
        this.D = f16;
        this.E = fArr[3];
        this.F = fArr[4];
        this.G = fArr[5];
        float f17 = fArr[6];
        this.H = f17;
        this.I = fArr[7];
        this.J = fArr[8];
        this.K = fArr[9];
        this.M = Math.abs(f16 - f17);
    }

    public void setShowEdge(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else if (z16) {
            k(Color.parseColor("#14000000"));
        } else {
            this.f352370o0 = null;
            this.f352371p0 = null;
        }
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f352367m = 14.0f;
        this.C = 8.0f;
        this.D = 0.0f;
        this.E = 5.0f;
        this.F = 4.0f;
        this.G = 10.0f;
        this.H = 10.0f;
        this.I = 16.0f;
        this.J = 1.0f;
        this.K = 14.0f;
        this.M = Math.abs(0.0f - 10.0f);
        this.f352364j0 = true;
        this.f352365k0 = false;
        this.f352366l0 = false;
        this.f352368m0 = 1610612736;
        this.f352369n0 = (int) (Math.random() * 1000.0d);
        this.f352373r0 = false;
        init();
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f352367m = 14.0f;
        this.C = 8.0f;
        this.D = 0.0f;
        this.E = 5.0f;
        this.F = 4.0f;
        this.G = 10.0f;
        this.H = 10.0f;
        this.I = 16.0f;
        this.J = 1.0f;
        this.K = 14.0f;
        this.M = Math.abs(0.0f - 10.0f);
        this.f352364j0 = true;
        this.f352365k0 = false;
        this.f352366l0 = false;
        this.f352368m0 = 1610612736;
        this.f352369n0 = (int) (Math.random() * 1000.0d);
        this.f352373r0 = false;
        init();
    }
}

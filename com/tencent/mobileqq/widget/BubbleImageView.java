package com.tencent.mobileqq.widget;

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
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes20.dex */
public class BubbleImageView extends ChatThumbView {

    /* renamed from: r0, reason: collision with root package name */
    public static final float[] f315449r0 = {7.0f, 9.0f, 0.0f, 6.0f, 2.5f, 9.0f, 5.5f, 15.0f, 0.5f, 13.0f};

    /* renamed from: s0, reason: collision with root package name */
    protected static boolean f315450s0;
    private float C;
    private float D;
    private float E;
    private float F;
    private float G;
    private float H;
    private float I;
    public int J;
    public float K;
    Paint L;
    Bitmap M;
    Canvas N;
    Shader P;
    ComposeShader Q;
    BitmapShader R;
    Path S;
    Path T;
    RectF U;
    RectF V;
    Paint W;

    /* renamed from: a0, reason: collision with root package name */
    float[] f315451a0;

    /* renamed from: b0, reason: collision with root package name */
    private Paint f315452b0;

    /* renamed from: c0, reason: collision with root package name */
    Path f315453c0;

    /* renamed from: d0, reason: collision with root package name */
    RectF f315454d0;

    /* renamed from: e0, reason: collision with root package name */
    private float f315455e0;

    /* renamed from: f0, reason: collision with root package name */
    protected Resources f315456f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f315457g0;

    /* renamed from: h, reason: collision with root package name */
    private float f315458h;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f315459h0;

    /* renamed from: i, reason: collision with root package name */
    private float f315460i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f315461i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f315462j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f315463k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f315464l0;

    /* renamed from: m, reason: collision with root package name */
    private float f315465m;

    /* renamed from: m0, reason: collision with root package name */
    private Paint f315466m0;

    /* renamed from: n0, reason: collision with root package name */
    private Path f315467n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f315468o0;

    /* renamed from: p0, reason: collision with root package name */
    protected boolean f315469p0;

    /* renamed from: q0, reason: collision with root package name */
    protected boolean f315470q0;

    static {
        boolean z16;
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (!upperCase.contains("BV0720") && !upperCase.contains("M821")) {
            z16 = false;
        } else {
            z16 = true;
        }
        f315450s0 = z16;
    }

    public BubbleImageView(Context context) {
        super(context);
        this.f315458h = 14.0f;
        this.f315460i = 8.0f;
        this.f315465m = 0.0f;
        this.C = 5.0f;
        this.D = 4.0f;
        this.E = 10.0f;
        this.F = 10.0f;
        this.G = 16.0f;
        this.H = 1.0f;
        this.I = 14.0f;
        this.K = Math.abs(0.0f - 10.0f);
        this.f315459h0 = true;
        this.f315461i0 = false;
        this.f315462j0 = false;
        this.f315463k0 = 1610612736;
        this.f315464l0 = (int) (Math.random() * 1000.0d);
        this.f315469p0 = false;
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
            Bitmap bitmap = this.M;
            if (bitmap != null && (bitmap.getWidth() != width || this.M.getHeight() != height)) {
                this.M = null;
                this.U.setEmpty();
                this.S = null;
                this.V.setEmpty();
                this.T = null;
                this.P = null;
            }
            if (this.M == null) {
                try {
                    try {
                        this.M = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        this.M = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                    }
                } catch (OutOfMemoryError unused2) {
                    URLDrawable.clearMemoryCache();
                    try {
                        this.M = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
                    } catch (OutOfMemoryError unused3) {
                    }
                }
                Canvas canvas2 = this.N;
                if (canvas2 != null) {
                    canvas2.setBitmap(this.M);
                }
            }
            if (this.M == null) {
                super.draw(canvas);
                return;
            }
            if (this.N == null) {
                Canvas canvas3 = new Canvas(this.M);
                this.N = canvas3;
                canvas3.setBitmap(this.M);
            }
            if (this.R == null) {
                Bitmap bitmap2 = this.M;
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                this.R = new BitmapShader(bitmap2, tileMode, tileMode);
            }
            if (this.f315461i0) {
                if (this.Q == null && (i3 = i()) != null) {
                    this.Q = new ComposeShader(this.R, i3, PorterDuff.Mode.SRC_OVER);
                }
                this.P = this.Q;
            } else {
                this.P = this.R;
            }
            this.L.setShader(this.P);
            super.draw(this.N);
            if (this.f315462j0) {
                this.N.drawColor(this.f315463k0);
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
        if (this.f315461i0) {
            if (this.f315452b0 == null) {
                Paint paint = new Paint();
                this.f315452b0 = paint;
                paint.setShader(i());
            }
            canvas.drawPaint(this.f315452b0);
        }
        if (this.f315462j0) {
            canvas.drawColor(this.f315463k0);
        }
        g(canvas);
        Paint paint2 = this.f315466m0;
        if (paint2 != null && (path = this.f315467n0) != null) {
            canvas.drawPath(path, paint2);
        }
        canvas.restoreToCount(saveCount);
    }

    private void h(Canvas canvas) {
        Resources resources = this.f315456f0;
        int width = getWidth();
        int height = getHeight();
        if (!this.f315459h0) {
            this.U.set(0.0f, 0.0f, width, height);
            RectF rectF = this.U;
            float f16 = this.f315455e0;
            canvas.drawRoundRect(rectF, f16, f16, this.L);
            return;
        }
        if (this.f315457g0) {
            if (this.U.isEmpty()) {
                this.U.set(0.0f, 0.0f, width - d(this.K, resources), height);
            }
            if (this.S == null) {
                float d16 = d(this.C, resources);
                Path path = new Path();
                path.moveTo(width - d(this.f315458h, resources), d(this.f315460i, resources));
                path.quadTo(width - d(this.D, resources), d(this.E, resources), width, d16);
                path.quadTo(width - d(this.H, resources), d(this.I, resources), width - d(this.F, resources), d(this.G, resources));
                path.close();
                this.S = path;
            }
        } else {
            if (this.V.isEmpty()) {
                this.V.set(d(this.K, resources), 0.0f, width, height);
            }
            if (this.T == null) {
                float d17 = d(this.C, resources);
                Path path2 = new Path();
                path2.moveTo(d(this.f315458h, resources), d(this.f315460i, resources));
                path2.quadTo(d(this.D, resources), d(this.E, resources), 0.0f, d17);
                path2.quadTo(d(this.H, resources), d(this.I, resources), d(this.F, resources), d(this.G, resources));
                path2.close();
                this.T = path2;
            }
        }
        if (this.f315457g0) {
            RectF rectF2 = this.U;
            float f17 = this.f315455e0;
            canvas.drawRoundRect(rectF2, f17, f17, this.L);
            canvas.drawPath(this.S, this.L);
            Paint paint = this.f315466m0;
            if (paint != null) {
                canvas.drawPath(this.S, paint);
                return;
            }
            return;
        }
        RectF rectF3 = this.V;
        float f18 = this.f315455e0;
        canvas.drawRoundRect(rectF3, f18, f18, this.L);
        canvas.drawPath(this.T, this.L);
        Paint paint2 = this.f315466m0;
        if (paint2 != null) {
            canvas.drawPath(this.T, paint2);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z16;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f315470q0) {
            super.draw(canvas);
        } else {
            int i3 = this.J;
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
            QLog.w("BubbleImageView" + this.f315464l0, 2, "draw(): isHardwaveAccelerated= " + z16 + ", drawMode = " + this.J + ", cost =" + currentTimeMillis2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(Canvas canvas) {
        canvas.drawPath(this.f315453c0, this.W);
    }

    public Shader i() {
        return null;
    }

    protected void init() {
        this.f315468o0 = f315450s0;
        if (VersionUtils.isHoneycomb()) {
            this.J = 1;
        } else {
            this.J = 2;
        }
        c();
        this.f315456f0 = getResources();
        int i3 = this.J;
        if (i3 == 1) {
            Paint paint = new Paint();
            this.W = paint;
            paint.setStyle(Paint.Style.FILL);
            this.W.setAntiAlias(true);
            this.W.setFilterBitmap(true);
            this.W.setColor(-16777216);
            this.W.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            this.f315453c0 = new Path();
            this.f315454d0 = new RectF();
            this.f315451a0 = new float[8];
            return;
        }
        if (i3 == 2) {
            Paint paint2 = new Paint();
            this.L = paint2;
            paint2.setAntiAlias(true);
            this.L.setFilterBitmap(true);
            this.U = new RectF();
            this.V = new RectF();
            this.f315453c0 = new Path();
            this.f315454d0 = new RectF();
            this.f315451a0 = new float[8];
        }
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
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
        float f19;
        float f26;
        Path path;
        if (!this.f315459h0) {
            this.f315454d0.set(0.0f, 0.0f, f16, f17);
            this.f315453c0.reset();
            this.f315453c0.addRoundRect(this.f315454d0, this.f315451a0, Path.Direction.CW);
            if (this.f315469p0) {
                this.f315453c0.setFillType(Path.FillType.INVERSE_EVEN_ODD);
            }
            Path path2 = this.f315467n0;
            if (path2 != null) {
                path2.reset();
                this.f315467n0.addRoundRect(this.f315454d0, this.f315451a0, Path.Direction.CW);
                return;
            }
            return;
        }
        Resources resources = this.f315456f0;
        float d36 = d(this.K, resources);
        if (this.f315457g0) {
            this.f315454d0.set(0.0f, 0.0f, f16 - d36, f17);
        } else {
            this.f315454d0.set(d36, 0.0f, f16, f17);
        }
        this.f315453c0.reset();
        float d37 = d(this.C, resources);
        if (this.f315457g0) {
            if (this.f315469p0) {
                Path path3 = new Path();
                path3.addRoundRect(this.f315454d0, this.f315451a0, Path.Direction.CW);
                path3.setFillType(Path.FillType.EVEN_ODD);
                Path path4 = new Path();
                float d38 = f16 - d(this.f315458h, resources);
                d17 = d(this.f315460i, resources);
                path4.moveTo(d38, d17);
                f18 = f16 - d(this.f315465m, resources);
                d18 = f16 - d(this.D, resources);
                d19 = d(this.E, resources);
                path4.quadTo(d18, d19, f18, d37);
                d26 = f16 - d(this.F, resources);
                d27 = d(this.G, resources);
                d28 = f16 - d(this.H, resources);
                float d39 = d(this.I, resources);
                path4.quadTo(d28, d39, d26, d27);
                f19 = d39;
                path4.setFillType(Path.FillType.EVEN_ODD);
                Path path5 = new Path();
                f26 = d38;
                path5.op(path3, path4, Path.Op.UNION);
                path5.setFillType(Path.FillType.INVERSE_EVEN_ODD);
                this.f315453c0 = path5;
                d29 = f19;
                d16 = f26;
                this.f315453c0.close();
                path = this.f315467n0;
                if (path == null) {
                    path.reset();
                    float f27 = this.f315455e0 * 2.0f;
                    if (this.f315457g0) {
                        float f28 = d29;
                        float asin = (float) ((Math.asin(d(this.G - this.f315460i, resources) / this.f315451a0[2]) * 180.0d) / 3.141592653589793d);
                        this.f315467n0.moveTo(d26, d27);
                        this.f315467n0.lineTo(d26, f17 - this.f315455e0);
                        float f29 = d26 - f27;
                        float f36 = f17 - f27;
                        this.f315454d0.set(f29, f36, d26, f17);
                        this.f315467n0.arcTo(this.f315454d0, 0.0f, 90.0f);
                        this.f315467n0.lineTo(this.f315455e0 + 0.0f, f17);
                        this.f315454d0.set(0.0f, f36, f27, f17);
                        this.f315467n0.arcTo(this.f315454d0, 90.0f, 90.0f);
                        this.f315467n0.lineTo(0.0f, this.f315455e0);
                        this.f315454d0.set(0.0f, 0.0f, f27, f27);
                        this.f315467n0.arcTo(this.f315454d0, 180.0f, 90.0f);
                        this.f315467n0.lineTo(d26 - this.f315455e0, 0.0f);
                        this.f315454d0.set(f29, 0.0f, d26, f27);
                        this.f315467n0.arcTo(this.f315454d0, 270.0f, 90.0f - asin);
                        this.f315467n0.lineTo(d16, d17);
                        this.f315467n0.quadTo(d18, d19, f18, d37);
                        this.f315467n0.quadTo(d28, f28, d26, d27);
                    } else {
                        float f37 = d29;
                        float asin2 = (float) ((Math.asin(d(this.G - this.f315460i, resources) / this.f315451a0[0]) * 180.0d) / 3.141592653589793d);
                        this.f315467n0.moveTo(d16, d17);
                        float f38 = d26 + f27;
                        this.f315454d0.set(d26, 0.0f, f38, f27);
                        this.f315467n0.arcTo(this.f315454d0, asin2 + 180.0f, 90.0f - asin2);
                        this.f315467n0.lineTo(f16 - this.f315455e0, 0.0f);
                        float f39 = f16 - f27;
                        this.f315454d0.set(f39, 0.0f, f16, f27);
                        this.f315467n0.arcTo(this.f315454d0, 270.0f, 90.0f);
                        this.f315467n0.lineTo(f16, f17 - this.f315455e0);
                        float f46 = f17 - f27;
                        this.f315454d0.set(f39, f46, f16, f17);
                        this.f315467n0.arcTo(this.f315454d0, 0.0f, 90.0f);
                        this.f315467n0.lineTo(this.f315455e0 + d26, f17);
                        this.f315454d0.set(d26, f46, f38, f17);
                        this.f315467n0.arcTo(this.f315454d0, 90.0f, 90.0f);
                        this.f315467n0.lineTo(d26, this.f315455e0);
                        this.f315467n0.lineTo(d26, d27);
                        this.f315467n0.quadTo(d28, f37, f18, d37);
                        this.f315467n0.quadTo(d18, d19, d16, d17);
                    }
                    this.f315467n0.close();
                    return;
                }
                return;
            }
            this.f315453c0.addRoundRect(this.f315454d0, this.f315451a0, Path.Direction.CW);
            d16 = f16 - d(this.f315458h, resources);
            d17 = d(this.f315460i, resources);
            this.f315453c0.moveTo(d16, d17);
            f18 = f16 - d(this.f315465m, resources);
            d18 = f16 - d(this.D, resources);
            d19 = d(this.E, resources);
            this.f315453c0.quadTo(d18, d19, f18, d37);
            d26 = f16 - d(this.F, resources);
            d27 = d(this.G, resources);
            d28 = f16 - d(this.H, resources);
            d29 = d(this.I, resources);
            this.f315453c0.quadTo(d28, d29, d26, d27);
            this.f315453c0.close();
            path = this.f315467n0;
            if (path == null) {
            }
        } else if (this.f315469p0) {
            Path path6 = new Path();
            path6.addRoundRect(this.f315454d0, this.f315451a0, Path.Direction.CW);
            path6.setFillType(Path.FillType.EVEN_ODD);
            Path path7 = new Path();
            float d46 = d(this.f315458h, resources);
            d17 = d(this.f315460i, resources);
            path7.moveTo(d46, d17);
            f18 = this.f315465m;
            d18 = d(this.D, resources);
            d19 = d(this.E, resources);
            path7.quadTo(d18, d19, f18, d37);
            d26 = d(this.F, resources);
            d27 = d(this.G, resources);
            d28 = d(this.H, resources);
            float d47 = d(this.I, resources);
            path7.quadTo(d28, d47, d26, d27);
            f19 = d47;
            Path path8 = new Path();
            f26 = d46;
            path8.op(path6, path7, Path.Op.UNION);
            path8.setFillType(Path.FillType.INVERSE_EVEN_ODD);
            this.f315453c0 = path8;
            d29 = f19;
            d16 = f26;
            this.f315453c0.close();
            path = this.f315467n0;
            if (path == null) {
            }
        } else {
            this.f315453c0.addRoundRect(this.f315454d0, this.f315451a0, Path.Direction.CCW);
            d16 = d(this.f315458h, resources);
            d17 = d(this.f315460i, resources);
            this.f315453c0.moveTo(d16, d17);
            f18 = this.f315465m;
            d18 = d(this.D, resources);
            d19 = d(this.E, resources);
            this.f315453c0.quadTo(d18, d19, f18, d37);
            d26 = d(this.F, resources);
            d27 = d(this.G, resources);
            d28 = d(this.H, resources);
            d29 = d(this.I, resources);
            this.f315453c0.quadTo(d28, d29, d26, d27);
            this.f315453c0.close();
            path = this.f315467n0;
            if (path == null) {
            }
        }
    }

    public void k(int i3) {
        setSharpCornerCor(f315449r0);
        if (this.f315466m0 == null || this.f315467n0 == null) {
            Paint paint = new Paint();
            this.f315466m0 = paint;
            paint.setColor(i3);
            this.f315466m0.setAntiAlias(true);
            this.f315466m0.setStrokeWidth(Math.max(1, d(0.5f, getResources())));
            this.f315466m0.setStyle(Paint.Style.STROKE);
            this.f315467n0 = new Path();
        }
    }

    public void l(boolean z16) {
        if (z16 != this.f315461i0) {
            this.f315461i0 = z16;
            requestLayout();
            invalidate();
        }
    }

    public void m(boolean z16) {
        if (this.f315459h0 != z16) {
            this.f315459h0 = z16;
            requestLayout();
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    @TargetApi(11)
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f315468o0) {
            setLayerType(1, null);
        } else if (this.J == 1 && VersionUtils.isHoneycomb()) {
            setLayerType(2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ImageView, android.view.View
    @TargetApi(11)
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.J == 1 && VersionUtils.isHoneycomb()) {
            setLayerType(0, null);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16 && this.J == 1) {
            j(getWidth(), getHeight());
        }
    }

    public void setColorMask(int i3) {
        this.f315463k0 = i3;
    }

    public void setRadius(float f16) {
        float d16 = d(f16, this.f315456f0);
        this.f315455e0 = d16;
        float[] fArr = this.f315451a0;
        if (fArr != null) {
            Arrays.fill(fArr, d16);
        }
    }

    public void setRadiusBottom(float f16) {
        this.f315455e0 = d(f16, this.f315456f0);
        float[] fArr = this.f315451a0;
        if (fArr != null) {
            Arrays.fill(fArr, 0, 4, 0.0f);
            Arrays.fill(this.f315451a0, 4, 8, this.f315455e0);
        }
    }

    public void setRadiusTop(float f16) {
        float d16 = d(f16, this.f315456f0);
        this.f315455e0 = d16;
        float[] fArr = this.f315451a0;
        if (fArr != null) {
            Arrays.fill(fArr, 0, 4, d16);
            Arrays.fill(this.f315451a0, 4, 8, 0.0f);
        }
    }

    public void setSend(boolean z16) {
        if (this.f315457g0 != z16) {
            this.f315457g0 = z16;
            if (getWidth() != 0 && getHeight() != 0) {
                j(getWidth(), getHeight());
            }
        }
    }

    public void setSharpCornerCor(float[] fArr) {
        this.f315458h = fArr[0];
        this.f315460i = fArr[1];
        float f16 = fArr[2];
        this.f315465m = f16;
        this.C = fArr[3];
        this.D = fArr[4];
        this.E = fArr[5];
        float f17 = fArr[6];
        this.F = f17;
        this.G = fArr[7];
        this.H = fArr[8];
        this.I = fArr[9];
        this.K = Math.abs(f16 - f17);
    }

    public void setShowEdge(boolean z16) {
        if (z16) {
            k(Color.parseColor("#14000000"));
        } else {
            this.f315466m0 = null;
            this.f315467n0 = null;
        }
    }

    public BubbleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315458h = 14.0f;
        this.f315460i = 8.0f;
        this.f315465m = 0.0f;
        this.C = 5.0f;
        this.D = 4.0f;
        this.E = 10.0f;
        this.F = 10.0f;
        this.G = 16.0f;
        this.H = 1.0f;
        this.I = 14.0f;
        this.K = Math.abs(0.0f - 10.0f);
        this.f315459h0 = true;
        this.f315461i0 = false;
        this.f315462j0 = false;
        this.f315463k0 = 1610612736;
        this.f315464l0 = (int) (Math.random() * 1000.0d);
        this.f315469p0 = false;
        init();
    }

    protected void c() {
    }

    public BubbleImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315458h = 14.0f;
        this.f315460i = 8.0f;
        this.f315465m = 0.0f;
        this.C = 5.0f;
        this.D = 4.0f;
        this.E = 10.0f;
        this.F = 10.0f;
        this.G = 16.0f;
        this.H = 1.0f;
        this.I = 14.0f;
        this.K = Math.abs(0.0f - 10.0f);
        this.f315459h0 = true;
        this.f315461i0 = false;
        this.f315462j0 = false;
        this.f315463k0 = 1610612736;
        this.f315464l0 = (int) (Math.random() * 1000.0d);
        this.f315469p0 = false;
        init();
    }
}

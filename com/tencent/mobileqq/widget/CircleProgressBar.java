package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* loaded from: classes20.dex */
public class CircleProgressBar extends View {
    public String C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public int K;
    public int L;
    public int M;
    public int N;
    public float P;
    public float Q;
    public float R;
    public float S;
    public float T;
    public float U;
    public float V;
    public float W;

    /* renamed from: a0, reason: collision with root package name */
    public float f315496a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f315497b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f315498c0;

    /* renamed from: d, reason: collision with root package name */
    public Paint f315499d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f315500d0;

    /* renamed from: e, reason: collision with root package name */
    public TextPaint f315501e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f315502e0;

    /* renamed from: f, reason: collision with root package name */
    public int f315503f;

    /* renamed from: f0, reason: collision with root package name */
    public int f315504f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f315505g0;

    /* renamed from: h, reason: collision with root package name */
    public int f315506h;

    /* renamed from: h0, reason: collision with root package name */
    public long f315507h0;

    /* renamed from: i, reason: collision with root package name */
    public int f315508i;

    /* renamed from: i0, reason: collision with root package name */
    public long f315509i0;

    /* renamed from: j0, reason: collision with root package name */
    public long f315510j0;

    /* renamed from: k0, reason: collision with root package name */
    public long f315511k0;

    /* renamed from: l0, reason: collision with root package name */
    public float f315512l0;

    /* renamed from: m, reason: collision with root package name */
    public float f315513m;

    /* renamed from: m0, reason: collision with root package name */
    public RectF f315514m0;

    /* renamed from: n0, reason: collision with root package name */
    a f315515n0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 10000) {
                CircleProgressBar circleProgressBar = CircleProgressBar.this;
                circleProgressBar.f315498c0 += 3;
                circleProgressBar.postInvalidate();
                if (CircleProgressBar.this.f315500d0) {
                    sendEmptyMessageDelayed(10000, 50L);
                }
            }
        }
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315499d = new Paint();
        this.f315501e = new TextPaint();
        this.C = "10";
        this.f315497b0 = -90;
        this.f315498c0 = -90;
        this.f315500d0 = false;
        this.f315502e0 = false;
        this.f315514m0 = new RectF();
        this.f315515n0 = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CircleProgressBar);
        this.f315503f = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_ringBgColor, Color.parseColor("#999999"));
        this.f315506h = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_progressColor, Color.parseColor("#12b7f5"));
        this.f315508i = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_processTextColor, Color.parseColor("#000000"));
        this.f315513m = obtainStyledAttributes.getDimension(R.styleable.CircleProgressBar_processTextSize, 25.0f);
        this.D = obtainStyledAttributes.getDimension(R.styleable.CircleProgressBar_innerRingSize, 200.0f);
        this.E = obtainStyledAttributes.getDimension(R.styleable.CircleProgressBar_outerRingSize, 250.0f);
        this.F = obtainStyledAttributes.getInteger(R.styleable.CircleProgressBar_progressArg, 60);
        this.G = obtainStyledAttributes.getDimension(R.styleable.CircleProgressBar_textTransform, 40.0f);
        this.H = obtainStyledAttributes.getDimension(R.styleable.CircleProgressBar_qqRingSize, 200.0f);
        this.I = obtainStyledAttributes.getDimension(R.styleable.CircleProgressBar_fileRingSize, 200.0f);
        this.J = obtainStyledAttributes.getDimension(R.styleable.CircleProgressBar_otherRingSize, 200.0f);
        this.K = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_qqRingColor, Color.parseColor("#999999"));
        this.L = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_fileRingColor, Color.parseColor("#999999"));
        this.M = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_otherRingColor, Color.parseColor("#999999"));
        this.N = obtainStyledAttributes.getColor(R.styleable.CircleProgressBar_avaRingColor, Color.parseColor("#999999"));
        obtainStyledAttributes.recycle();
        float f16 = this.E;
        float f17 = this.D;
        float f18 = (f16 - f17) / 2.0f;
        this.P = f18;
        this.U = (f17 / 2.0f) + (f18 / 2.0f);
        float f19 = (this.H - f17) / 2.0f;
        this.Q = f19;
        float f26 = (this.I - f17) / 2.0f;
        this.R = f26;
        float f27 = (this.J - f17) / 2.0f;
        this.S = f27;
        this.T = f18;
        this.V = (f17 / 2.0f) + (f19 / 2.0f);
        this.W = (f17 / 2.0f) + (f26 / 2.0f);
        this.f315496a0 = (f17 / 2.0f) + (f27 / 2.0f);
    }

    private double a(float f16) {
        return (f16 / 360.0f) * 2.0f * 3.141592653589793d;
    }

    public void b() {
        this.f315500d0 = true;
        this.f315502e0 = false;
        postInvalidate();
        this.f315515n0.sendEmptyMessageDelayed(10000, 50L);
    }

    public void c() {
        this.f315500d0 = false;
        this.f315515n0.removeMessages(10000);
        postInvalidate();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0240  */
    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        float f18;
        float f19;
        float f26;
        super.onDraw(canvas);
        this.f315504f0 = getWidth() / 2;
        this.f315505g0 = getHeight() / 2;
        if (!this.f315502e0) {
            this.f315499d.setColor(this.f315503f);
            this.f315499d.setStyle(Paint.Style.STROKE);
            this.f315499d.setStrokeWidth(this.P);
            this.f315499d.setAntiAlias(true);
            canvas.drawCircle(this.f315504f0, this.f315505g0, this.U, this.f315499d);
            if (this.f315500d0) {
                RectF rectF = this.f315514m0;
                int i3 = this.f315504f0;
                float f27 = this.U;
                rectF.left = i3 - f27;
                int i16 = this.f315505g0;
                rectF.top = i16 - f27;
                rectF.right = i3 + f27;
                rectF.bottom = i16 + f27;
                this.f315499d.setShader(new LinearGradient((float) (i3 + (f27 * Math.sin(a(this.f315498c0 + 90)))), (float) (this.f315505g0 - (this.U * Math.cos(a(this.f315498c0 + 90)))), (float) (this.f315504f0 + (this.U * Math.sin(a(this.f315498c0 + 90 + this.F)))), (float) (this.f315505g0 - (this.U * Math.cos(a((this.f315498c0 + 90) + this.F)))), this.f315503f, this.f315506h, Shader.TileMode.MIRROR));
                canvas.drawArc(this.f315514m0, this.f315498c0, this.F, false, this.f315499d);
                this.f315499d.setShader(null);
            }
            this.f315501e.setColor(this.f315508i);
            this.f315501e.setAntiAlias(true);
            this.f315501e.setTextSize(this.f315513m);
            float measureText = (this.f315504f0 - this.f315501e.measureText(this.C)) + this.G;
            float descent = this.f315505g0 - ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
            float descent2 = this.f315505g0 + ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
            canvas.drawText(this.C, measureText, descent, this.f315501e);
            this.f315501e.setTextSize(this.f315513m / 2.0f);
            float f28 = this.f315504f0 + this.G;
            canvas.drawText("%", f28, descent, this.f315501e);
            this.f315501e.setTextSize(this.f315513m / 4.0f);
            canvas.drawText(HardCodeUtil.qqStr(R.string.f171744km1), f28, descent2 - (this.f315501e.descent() + this.f315501e.ascent()), this.f315501e);
        } else {
            this.f315499d.setAntiAlias(true);
            this.f315499d.setStyle(Paint.Style.STROKE);
            this.f315499d.setColor(this.N);
            this.f315499d.setStrokeWidth(this.T);
            canvas.drawCircle(this.f315504f0, this.f315505g0, this.U, this.f315499d);
            long j3 = this.f315507h0;
            float f29 = (float) (this.f315509i0 + j3 + this.f315510j0 + this.f315511k0);
            float f36 = (((float) j3) * 360.0f) / f29;
            if (f36 > 0.0f) {
                float f37 = this.f315512l0;
                if (f36 < f37) {
                    f16 = f37;
                    RectF rectF2 = new RectF();
                    int i17 = this.f315504f0;
                    float f38 = this.V;
                    rectF2.left = i17 - f38;
                    int i18 = this.f315505g0;
                    rectF2.top = i18 - f38;
                    rectF2.right = i17 + f38;
                    rectF2.bottom = i18 + f38;
                    this.f315499d.setColor(this.K);
                    this.f315499d.setStrokeWidth(this.Q);
                    canvas.drawArc(rectF2, -90.0f, f16, false, this.f315499d);
                    f17 = (((float) this.f315509i0) * 360.0f) / f29;
                    if (f17 > 0.0f) {
                        float f39 = this.f315512l0;
                        if (f17 < f39) {
                            f18 = f39;
                            int i19 = this.f315504f0;
                            float f46 = this.W;
                            rectF2.left = i19 - f46;
                            int i26 = this.f315505g0;
                            rectF2.top = i26 - f46;
                            rectF2.right = i19 + f46;
                            rectF2.bottom = i26 + f46;
                            this.f315499d.setColor(this.L);
                            this.f315499d.setStrokeWidth(this.R);
                            float f47 = f16 - 90.0f;
                            canvas.drawArc(rectF2, f47, f18, false, this.f315499d);
                            f19 = (((float) this.f315510j0) * 360.0f) / f29;
                            if (f19 > 0.0f) {
                                float f48 = this.f315512l0;
                                if (f19 < f48) {
                                    f26 = f48;
                                    int i27 = this.f315504f0;
                                    float f49 = this.f315496a0;
                                    rectF2.left = i27 - f49;
                                    int i28 = this.f315505g0;
                                    rectF2.top = i28 - f49;
                                    rectF2.right = i27 + f49;
                                    rectF2.bottom = i28 + f49;
                                    this.f315499d.setColor(this.M);
                                    this.f315499d.setStrokeWidth(this.S);
                                    canvas.drawArc(rectF2, f47 + f18, f26, false, this.f315499d);
                                    this.f315501e.setColor(this.f315508i);
                                    this.f315501e.setAntiAlias(true);
                                    this.f315501e.setTextSize(this.f315513m);
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("");
                                    long j16 = this.f315507h0;
                                    long j17 = this.f315509i0;
                                    long j18 = this.f315510j0;
                                    sb5.append((((j16 + j17) + j18) * 100) / (((j16 + j17) + j18) + this.f315511k0));
                                    String sb6 = sb5.toString();
                                    float measureText2 = (this.f315504f0 - this.f315501e.measureText(sb6)) + this.G;
                                    float descent3 = this.f315505g0 - ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
                                    float descent4 = this.f315505g0 + ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
                                    canvas.drawText(sb6, measureText2, descent3, this.f315501e);
                                    this.f315501e.setTextSize(this.f315513m / 2.0f);
                                    float f56 = this.f315504f0 + this.G;
                                    canvas.drawText("%", f56, descent3, this.f315501e);
                                    this.f315501e.setTextSize(this.f315513m / 4.0f);
                                    canvas.drawText(HardCodeUtil.qqStr(R.string.f171745km2), f56, descent4 - (this.f315501e.descent() + this.f315501e.ascent()), this.f315501e);
                                }
                            }
                            f26 = f19;
                            int i272 = this.f315504f0;
                            float f492 = this.f315496a0;
                            rectF2.left = i272 - f492;
                            int i282 = this.f315505g0;
                            rectF2.top = i282 - f492;
                            rectF2.right = i272 + f492;
                            rectF2.bottom = i282 + f492;
                            this.f315499d.setColor(this.M);
                            this.f315499d.setStrokeWidth(this.S);
                            canvas.drawArc(rectF2, f47 + f18, f26, false, this.f315499d);
                            this.f315501e.setColor(this.f315508i);
                            this.f315501e.setAntiAlias(true);
                            this.f315501e.setTextSize(this.f315513m);
                            StringBuilder sb52 = new StringBuilder();
                            sb52.append("");
                            long j162 = this.f315507h0;
                            long j172 = this.f315509i0;
                            long j182 = this.f315510j0;
                            sb52.append((((j162 + j172) + j182) * 100) / (((j162 + j172) + j182) + this.f315511k0));
                            String sb62 = sb52.toString();
                            float measureText22 = (this.f315504f0 - this.f315501e.measureText(sb62)) + this.G;
                            float descent32 = this.f315505g0 - ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
                            float descent42 = this.f315505g0 + ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
                            canvas.drawText(sb62, measureText22, descent32, this.f315501e);
                            this.f315501e.setTextSize(this.f315513m / 2.0f);
                            float f562 = this.f315504f0 + this.G;
                            canvas.drawText("%", f562, descent32, this.f315501e);
                            this.f315501e.setTextSize(this.f315513m / 4.0f);
                            canvas.drawText(HardCodeUtil.qqStr(R.string.f171745km2), f562, descent42 - (this.f315501e.descent() + this.f315501e.ascent()), this.f315501e);
                        }
                    }
                    f18 = f17;
                    int i192 = this.f315504f0;
                    float f462 = this.W;
                    rectF2.left = i192 - f462;
                    int i262 = this.f315505g0;
                    rectF2.top = i262 - f462;
                    rectF2.right = i192 + f462;
                    rectF2.bottom = i262 + f462;
                    this.f315499d.setColor(this.L);
                    this.f315499d.setStrokeWidth(this.R);
                    float f472 = f16 - 90.0f;
                    canvas.drawArc(rectF2, f472, f18, false, this.f315499d);
                    f19 = (((float) this.f315510j0) * 360.0f) / f29;
                    if (f19 > 0.0f) {
                    }
                    f26 = f19;
                    int i2722 = this.f315504f0;
                    float f4922 = this.f315496a0;
                    rectF2.left = i2722 - f4922;
                    int i2822 = this.f315505g0;
                    rectF2.top = i2822 - f4922;
                    rectF2.right = i2722 + f4922;
                    rectF2.bottom = i2822 + f4922;
                    this.f315499d.setColor(this.M);
                    this.f315499d.setStrokeWidth(this.S);
                    canvas.drawArc(rectF2, f472 + f18, f26, false, this.f315499d);
                    this.f315501e.setColor(this.f315508i);
                    this.f315501e.setAntiAlias(true);
                    this.f315501e.setTextSize(this.f315513m);
                    StringBuilder sb522 = new StringBuilder();
                    sb522.append("");
                    long j1622 = this.f315507h0;
                    long j1722 = this.f315509i0;
                    long j1822 = this.f315510j0;
                    sb522.append((((j1622 + j1722) + j1822) * 100) / (((j1622 + j1722) + j1822) + this.f315511k0));
                    String sb622 = sb522.toString();
                    float measureText222 = (this.f315504f0 - this.f315501e.measureText(sb622)) + this.G;
                    float descent322 = this.f315505g0 - ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
                    float descent422 = this.f315505g0 + ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
                    canvas.drawText(sb622, measureText222, descent322, this.f315501e);
                    this.f315501e.setTextSize(this.f315513m / 2.0f);
                    float f5622 = this.f315504f0 + this.G;
                    canvas.drawText("%", f5622, descent322, this.f315501e);
                    this.f315501e.setTextSize(this.f315513m / 4.0f);
                    canvas.drawText(HardCodeUtil.qqStr(R.string.f171745km2), f5622, descent422 - (this.f315501e.descent() + this.f315501e.ascent()), this.f315501e);
                }
            }
            f16 = f36;
            RectF rectF22 = new RectF();
            int i172 = this.f315504f0;
            float f382 = this.V;
            rectF22.left = i172 - f382;
            int i182 = this.f315505g0;
            rectF22.top = i182 - f382;
            rectF22.right = i172 + f382;
            rectF22.bottom = i182 + f382;
            this.f315499d.setColor(this.K);
            this.f315499d.setStrokeWidth(this.Q);
            canvas.drawArc(rectF22, -90.0f, f16, false, this.f315499d);
            f17 = (((float) this.f315509i0) * 360.0f) / f29;
            if (f17 > 0.0f) {
            }
            f18 = f17;
            int i1922 = this.f315504f0;
            float f4622 = this.W;
            rectF22.left = i1922 - f4622;
            int i2622 = this.f315505g0;
            rectF22.top = i2622 - f4622;
            rectF22.right = i1922 + f4622;
            rectF22.bottom = i2622 + f4622;
            this.f315499d.setColor(this.L);
            this.f315499d.setStrokeWidth(this.R);
            float f4722 = f16 - 90.0f;
            canvas.drawArc(rectF22, f4722, f18, false, this.f315499d);
            f19 = (((float) this.f315510j0) * 360.0f) / f29;
            if (f19 > 0.0f) {
            }
            f26 = f19;
            int i27222 = this.f315504f0;
            float f49222 = this.f315496a0;
            rectF22.left = i27222 - f49222;
            int i28222 = this.f315505g0;
            rectF22.top = i28222 - f49222;
            rectF22.right = i27222 + f49222;
            rectF22.bottom = i28222 + f49222;
            this.f315499d.setColor(this.M);
            this.f315499d.setStrokeWidth(this.S);
            canvas.drawArc(rectF22, f4722 + f18, f26, false, this.f315499d);
            this.f315501e.setColor(this.f315508i);
            this.f315501e.setAntiAlias(true);
            this.f315501e.setTextSize(this.f315513m);
            StringBuilder sb5222 = new StringBuilder();
            sb5222.append("");
            long j16222 = this.f315507h0;
            long j17222 = this.f315509i0;
            long j18222 = this.f315510j0;
            sb5222.append((((j16222 + j17222) + j18222) * 100) / (((j16222 + j17222) + j18222) + this.f315511k0));
            String sb6222 = sb5222.toString();
            float measureText2222 = (this.f315504f0 - this.f315501e.measureText(sb6222)) + this.G;
            float descent3222 = this.f315505g0 - ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
            float descent4222 = this.f315505g0 + ((this.f315501e.descent() + this.f315501e.ascent()) / 2.0f);
            canvas.drawText(sb6222, measureText2222, descent3222, this.f315501e);
            this.f315501e.setTextSize(this.f315513m / 2.0f);
            float f56222 = this.f315504f0 + this.G;
            canvas.drawText("%", f56222, descent3222, this.f315501e);
            this.f315501e.setTextSize(this.f315513m / 4.0f);
            canvas.drawText(HardCodeUtil.qqStr(R.string.f171745km2), f56222, descent4222 - (this.f315501e.descent() + this.f315501e.ascent()), this.f315501e);
        }
        this.f315499d.reset();
    }

    public void setFinish(long j3, long j16, long j17, long j18, float f16) {
        this.f315507h0 = j3;
        this.f315509i0 = j16;
        this.f315510j0 = j17;
        this.f315511k0 = j18;
        this.f315512l0 = f16;
        c();
        this.f315502e0 = true;
        postInvalidate();
    }

    public void setPercent(int i3) {
        if (i3 < 100) {
            this.C = "" + i3;
        } else {
            this.C = "100";
            c();
        }
        postInvalidate();
    }
}

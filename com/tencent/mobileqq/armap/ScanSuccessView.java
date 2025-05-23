package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.x;
import java.util.Random;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ScanSuccessView extends View {
    static IPatchRedirector $redirector_;
    private Paint C;
    RectF D;
    RectF E;
    RectF F;
    RectF G;
    RectF H;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float P;
    private int Q;
    private int R;
    private float S;
    private float T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f199708a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f199709b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f199710c0;

    /* renamed from: d, reason: collision with root package name */
    private Paint f199711d;

    /* renamed from: d0, reason: collision with root package name */
    String f199712d0;

    /* renamed from: e, reason: collision with root package name */
    private Paint f199713e;

    /* renamed from: e0, reason: collision with root package name */
    boolean f199714e0;

    /* renamed from: f, reason: collision with root package name */
    private Paint f199715f;

    /* renamed from: f0, reason: collision with root package name */
    private int f199716f0;

    /* renamed from: g0, reason: collision with root package name */
    boolean f199717g0;

    /* renamed from: h, reason: collision with root package name */
    private Paint f199718h;

    /* renamed from: i, reason: collision with root package name */
    private Paint f199719i;

    /* renamed from: m, reason: collision with root package name */
    private Paint f199720m;

    public ScanSuccessView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.D = new RectF();
        this.E = new RectF();
        this.F = new RectF();
        this.G = new RectF();
        this.H = new RectF();
        this.I = 51.0f;
        this.P = 10.0f;
        this.U = 0;
        this.V = 70;
        this.W = 180;
        this.f199708a0 = 10;
        this.f199709b0 = 0;
        this.f199710c0 = 1.6875f;
        this.f199712d0 = HardCodeUtil.qqStr(R.string.t3s);
        this.f199714e0 = true;
        this.f199716f0 = 18;
        this.f199717g0 = true;
        a();
    }

    private void a() {
        float f16 = this.I;
        this.J = 4.0f + f16 + 6.0f;
        this.M = 25.0f + f16;
        this.K = 36.0f + f16;
        this.L = (this.P / 2.0f) + f16 + 47.0f;
        this.N = f16 + 72.0f;
        Paint paint = new Paint();
        this.f199711d = paint;
        paint.setAntiAlias(true);
        this.f199711d.setColor(Integer.MAX_VALUE);
        this.f199711d.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f199713e = paint2;
        paint2.setAntiAlias(true);
        this.f199713e.setColor(-1);
        this.f199713e.setStyle(Paint.Style.STROKE);
        this.f199713e.setStrokeWidth(this.f199710c0 * 8.0f);
        Paint paint3 = new Paint();
        this.f199715f = paint3;
        paint3.setAntiAlias(true);
        this.f199715f.setColor(Integer.MAX_VALUE);
        this.f199715f.setStyle(Paint.Style.STROKE);
        this.f199715f.setStrokeWidth(2.0f);
        Paint paint4 = new Paint();
        this.f199718h = paint4;
        paint4.setAntiAlias(true);
        this.f199718h.setColor(-1);
        this.f199718h.setStyle(Paint.Style.STROKE);
        this.f199718h.setStrokeWidth(this.f199710c0 * 6.0f);
        Paint paint5 = new Paint();
        this.f199719i = paint5;
        paint5.setAntiAlias(true);
        this.f199719i.setColor(-1);
        this.f199719i.setStyle(Paint.Style.STROKE);
        this.f199719i.setStrokeWidth(this.f199710c0 * 16.0f);
        Paint paint6 = new Paint();
        this.f199720m = paint6;
        paint6.setAntiAlias(true);
        this.f199720m.setStyle(Paint.Style.FILL);
        this.f199720m.setARGB(255, 255, 255, 255);
        this.f199720m.setTextSize(this.f199710c0 * 28.0f);
        Paint paint7 = new Paint();
        this.C = paint7;
        paint7.setAntiAlias(true);
        this.C.setStyle(Paint.Style.FILL);
        this.C.setARGB(255, 255, 255, 255);
        int c16 = x.c(MobileQQ.sMobileQQ, 18.0f);
        this.f199716f0 = c16;
        this.C.setTextSize(c16);
        Paint.FontMetrics fontMetrics = this.f199720m.getFontMetrics();
        this.T = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) canvas);
            return;
        }
        int i3 = this.f199709b0;
        if (i3 % 10 == 9) {
            this.f199717g0 = false;
        }
        if (i3 % 10 == 0) {
            this.f199717g0 = true;
        }
        if (this.f199717g0) {
            this.f199709b0 = i3 + 1;
        } else {
            this.f199709b0 = i3 - 1;
        }
        int i16 = this.f199709b0 % 2;
        this.Q = getWidth() / 2;
        int height = getHeight() / 2;
        this.R = height;
        RectF rectF = this.D;
        int i17 = this.Q;
        float f16 = this.J;
        float f17 = this.f199710c0;
        rectF.left = i17 - (f16 * f17);
        rectF.top = height - (f16 * f17);
        rectF.right = i17 + (f16 * f17);
        rectF.bottom = height + (f16 * f17);
        RectF rectF2 = this.E;
        float f18 = this.K;
        rectF2.left = i17 - (f18 * f17);
        rectF2.top = height - (f18 * f17);
        rectF2.right = i17 + (f18 * f17);
        rectF2.bottom = height + (f18 * f17);
        RectF rectF3 = this.F;
        float f19 = this.L;
        rectF3.left = i17 - (f19 * f17);
        rectF3.top = height - (f19 * f17);
        rectF3.right = i17 + (f19 * f17);
        rectF3.bottom = height + (f19 * f17);
        RectF rectF4 = this.G;
        float f26 = this.M;
        rectF4.left = i17 - (f26 * f17);
        rectF4.top = height - (f26 * f17);
        rectF4.right = i17 + (f26 * f17);
        rectF4.bottom = height + (f26 * f17);
        RectF rectF5 = this.H;
        float f27 = this.N;
        int i18 = this.f199709b0;
        rectF5.left = (i17 - (f27 * f17)) - (i18 % 10);
        rectF5.top = (height - (f27 * f17)) - (i18 % 10);
        rectF5.right = i17 + (f27 * f17) + (i18 % 10);
        rectF5.bottom = height + (f27 * f17) + (i18 % 10);
        this.V = this.V + 10;
        this.W += 10;
        this.f199708a0 += 10;
        canvas.drawArc(rectF, r0 + 270, 90.0f, false, this.f199713e);
        canvas.drawArc(this.E, this.W + 270, 270.0f, false, this.f199718h);
        canvas.drawArc(this.F, this.f199708a0 + 90, 90.0f, false, this.f199719i);
        canvas.drawArc(this.H, 0.0f, 360.0f, false, this.f199715f);
        canvas.drawArc(this.G, 0.0f, 360.0f, false, this.f199715f);
        if (this.f199714e0) {
            canvas.drawCircle(this.Q, this.R, this.I * this.f199710c0, this.f199711d);
            if (this.U > 99) {
                this.U = 99;
            }
            String str = this.U + "%";
            float measureText = this.f199720m.measureText(str, 0, str.length());
            this.S = measureText;
            if (this.U != 0) {
                canvas.drawText(str, this.Q - (measureText / 2.0f), this.R + (this.T / 4.0f), this.f199720m);
            }
        }
        int i19 = this.R;
        float f28 = i19 + (this.T / 4.0f);
        float f29 = this.f199710c0;
        float f36 = f28 + (165.0f * f29);
        float f37 = this.N;
        float f38 = i19 + (f37 * f29);
        int i26 = this.f199716f0;
        if (f36 < f38 + (i26 / 2)) {
            f36 = i19 + (f37 * f29) + (i26 / 2);
        }
        String str2 = this.f199712d0;
        canvas.drawText(str2, this.Q - (this.C.measureText(str2, 0, str2.length()) / 2.0f), f36, this.C);
        postInvalidateDelayed(15L);
    }

    public void setFistAgree() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.U += new Random().nextInt(20);
        }
    }

    public void setScale(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.f199710c0 = i3 / 640.0f;
        }
    }

    public void setScanText(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.f199712d0 = str;
        }
    }

    public void setShowProgress(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.f199714e0 = z16;
        }
    }

    public void setTotalProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else if (i3 > this.U) {
            this.U = i3;
        }
    }
}

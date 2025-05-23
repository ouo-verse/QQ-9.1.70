package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.Clip.ClipConstant;
import java.lang.reflect.Array;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b implements ClipConstant {

    /* renamed from: e, reason: collision with root package name */
    private RectF f68036e = new RectF();

    /* renamed from: f, reason: collision with root package name */
    private RectF f68037f = new RectF();

    /* renamed from: g, reason: collision with root package name */
    private RectF f68038g = new RectF();

    /* renamed from: h, reason: collision with root package name */
    private RectF f68039h = new RectF();

    /* renamed from: i, reason: collision with root package name */
    private float[] f68040i = new float[16];

    /* renamed from: j, reason: collision with root package name */
    private float[] f68041j = new float[32];

    /* renamed from: k, reason: collision with root package name */
    private float[][] f68042k = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 2, 4);

    /* renamed from: l, reason: collision with root package name */
    private boolean f68043l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f68044m = true;

    /* renamed from: n, reason: collision with root package name */
    private boolean f68045n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f68046o = false;

    /* renamed from: p, reason: collision with root package name */
    private Matrix f68047p = new Matrix();

    /* renamed from: q, reason: collision with root package name */
    private Paint f68048q = new Paint(1);

    /* renamed from: r, reason: collision with root package name */
    private Paint f68049r = new Paint(1);

    public b() {
        this.f68048q.setStyle(Paint.Style.STROKE);
        this.f68048q.setStrokeCap(Paint.Cap.SQUARE);
        this.f68049r.setStyle(Paint.Style.STROKE);
        this.f68049r.setStrokeCap(Paint.Cap.SQUARE);
        this.f68049r.setColor(201326592);
        this.f68049r.setStrokeWidth(24.0f);
    }

    public ClipConstant.Anchor a(float f16, float f17) {
        if (!ClipConstant.Anchor.isCohesionContains(this.f68036e, -48.0f, f16, f17) || ClipConstant.Anchor.isCohesionContains(this.f68036e, 48.0f, f16, f17)) {
            return null;
        }
        float[] cohesion = ClipConstant.Anchor.cohesion(this.f68036e, 0.0f);
        float[] fArr = {f16, f17};
        int i3 = 0;
        for (int i16 = 0; i16 < cohesion.length; i16++) {
            if (Math.abs(cohesion[i16] - fArr[i16 >> 1]) < 48.0f) {
                i3 |= 1 << i16;
            }
        }
        ClipConstant.Anchor valueOf = ClipConstant.Anchor.valueOf(i3);
        if (valueOf != null) {
            this.f68046o = false;
        }
        return valueOf;
    }

    public RectF b(float f16, float f17) {
        RectF rectF = new RectF(this.f68036e);
        rectF.offset(f16, f17);
        return rectF;
    }

    public RectF c() {
        return this.f68038g;
    }

    public void d(float f16) {
        if (this.f68046o) {
            RectF rectF = this.f68036e;
            RectF rectF2 = this.f68037f;
            float f17 = rectF2.left;
            RectF rectF3 = this.f68038g;
            float f18 = f17 + ((rectF3.left - f17) * f16);
            float f19 = rectF2.top;
            float f26 = f19 + ((rectF3.top - f19) * f16);
            float f27 = rectF2.right;
            float f28 = f27 + ((rectF3.right - f27) * f16);
            float f29 = rectF2.bottom;
            rectF.set(f18, f26, f28, f29 + ((rectF3.bottom - f29) * f16));
        }
    }

    public boolean e() {
        this.f68037f.set(this.f68036e);
        this.f68038g.set(this.f68036e);
        a.d(this.f68039h, this.f68038g, 60.0f);
        boolean z16 = !this.f68038g.equals(this.f68037f);
        this.f68046o = z16;
        return z16;
    }

    public boolean f() {
        return this.f68043l;
    }

    public boolean g() {
        return this.f68046o;
    }

    public boolean h() {
        return this.f68044m;
    }

    public void i(Canvas canvas) {
        if (this.f68044m) {
            return;
        }
        int i3 = 0;
        float[] fArr = {this.f68036e.width(), this.f68036e.height()};
        for (int i16 = 0; i16 < this.f68042k.length; i16++) {
            int i17 = 0;
            while (true) {
                float[] fArr2 = this.f68042k[i16];
                if (i17 < fArr2.length) {
                    fArr2[i17] = fArr[i16] * ClipConstant.f68030a[i17];
                    i17++;
                }
            }
        }
        int i18 = 0;
        while (true) {
            float[] fArr3 = this.f68040i;
            if (i18 >= fArr3.length) {
                break;
            }
            fArr3[i18] = this.f68042k[i18 & 1][(1935858840 >>> (i18 << 1)) & 3];
            i18++;
        }
        while (true) {
            float[] fArr4 = this.f68041j;
            if (i3 < fArr4.length) {
                float f16 = this.f68042k[i3 & 1][(179303760 >>> i3) & 1];
                float[] fArr5 = ClipConstant.f68032c;
                byte b16 = ClipConstant.f68033d[i3];
                fArr4[i3] = f16 + fArr5[b16 & 3] + ClipConstant.f68031b[b16 >> 2];
                i3++;
            } else {
                RectF rectF = this.f68036e;
                canvas.translate(rectF.left, rectF.top);
                this.f68048q.setStyle(Paint.Style.STROKE);
                this.f68048q.setColor(-2130706433);
                this.f68048q.setStrokeWidth(3.0f);
                canvas.drawLines(this.f68040i, this.f68048q);
                RectF rectF2 = this.f68036e;
                canvas.translate(-rectF2.left, -rectF2.top);
                this.f68048q.setColor(-1);
                this.f68048q.setStrokeWidth(5.0f);
                canvas.drawRect(this.f68036e, this.f68049r);
                canvas.drawRect(this.f68036e, this.f68048q);
                RectF rectF3 = this.f68036e;
                canvas.translate(rectF3.left, rectF3.top);
                this.f68048q.setColor(-1);
                this.f68048q.setStrokeWidth(10.0f);
                canvas.drawLines(this.f68041j, this.f68048q);
                return;
            }
        }
    }

    public void j(ClipConstant.Anchor anchor, float f16, float f17) {
        anchor.moveFrame(this.f68039h, this.f68036e, f16, f17);
    }

    public void l(RectF rectF, float f16) {
        RectF rectF2 = new RectF();
        this.f68047p.setRotate(f16, rectF.centerX(), rectF.centerY());
        this.f68047p.mapRect(rectF2, rectF);
        k(rectF2.width(), rectF2.height());
    }

    public void m(float f16, float f17) {
        this.f68039h.set(0.0f, 0.0f, f16, f17 * 1.0f);
        if (this.f68036e.isEmpty()) {
            return;
        }
        a.a(this.f68039h, this.f68036e);
        this.f68038g.set(this.f68036e);
    }

    public void n(boolean z16) {
        this.f68043l = z16;
    }

    public void o(boolean z16) {
        this.f68046o = z16;
    }

    public void p(boolean z16) {
        this.f68044m = z16;
    }

    public void q(boolean z16) {
        this.f68045n = z16;
    }

    private void k(float f16, float f17) {
        p(true);
        this.f68036e.set(0.0f, 0.0f, f16, f17);
        a.d(this.f68039h, this.f68036e, 60.0f);
        this.f68038g.set(this.f68036e);
    }
}

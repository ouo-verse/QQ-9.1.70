package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MetaballView extends View {
    private float C;
    private ArrayList<b> D;
    private float E;
    private c F;
    private b G;
    float[] H;
    float[] I;
    float[] J;
    float[] K;
    float[] L;
    float[] M;
    float[] N;
    float[] P;
    float[] Q;
    float[] R;
    float[] S;
    float[] T;
    float[] U;
    Path V;

    /* renamed from: d, reason: collision with root package name */
    private Paint f252983d;

    /* renamed from: e, reason: collision with root package name */
    private float f252984e;

    /* renamed from: f, reason: collision with root package name */
    private float f252985f;

    /* renamed from: h, reason: collision with root package name */
    private final int f252986h;

    /* renamed from: i, reason: collision with root package name */
    private int f252987i;

    /* renamed from: m, reason: collision with root package name */
    private final float f252988m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        float[] f252989a;

        /* renamed from: b, reason: collision with root package name */
        float f252990b;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends Animation {
        c() {
        }

        @Override // android.view.animation.Animation
        protected void applyTransformation(float f16, Transformation transformation) {
            super.applyTransformation(f16, transformation);
            MetaballView.this.E = f16;
            MetaballView.this.invalidate();
        }
    }

    public MetaballView(Context context) {
        super(context);
        this.f252983d = new Paint();
        this.f252984e = 1.0f;
        this.f252985f = 10.0f;
        this.f252986h = 2;
        this.f252987i = 60;
        this.f252988m = 0.3f;
        this.D = new ArrayList<>();
        this.H = new float[2];
        this.I = new float[2];
        this.J = new float[2];
        this.K = new float[2];
        this.L = new float[2];
        this.M = new float[2];
        this.N = new float[2];
        this.P = new float[2];
        this.Q = new float[2];
        this.R = new float[2];
        this.S = new float[2];
        this.T = new float[2];
        this.U = new float[2];
        this.V = new Path();
        g();
    }

    private float b(float[] fArr, float[] fArr2) {
        float f16 = fArr[0] - fArr2[0];
        float f17 = fArr[1] - fArr2[1];
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    private float d(float[] fArr) {
        float f16 = fArr[0];
        float f17 = fArr[1];
        return (float) Math.sqrt((f16 * f16) + (f17 * f17));
    }

    private void f(float f16, float f17, float[] fArr) {
        double d16 = f16;
        double d17 = f17;
        fArr[0] = (float) (Math.cos(d16) * d17);
        fArr[1] = (float) (Math.sin(d16) * d17);
    }

    private void g() {
        this.f252985f = e();
        this.f252987i = c();
        float f16 = this.f252985f * 1.3f;
        this.f252983d.setColor(-16395392);
        this.f252983d.setStyle(Paint.Style.FILL);
        this.f252983d.setAntiAlias(true);
        b bVar = new b();
        float f17 = this.f252985f;
        bVar.f252989a = new float[]{this.f252987i + f17, f16};
        bVar.f252990b = (f17 / 4.0f) * 3.0f;
        this.D.add(bVar);
        b bVar2 = new b();
        float f18 = this.f252985f;
        bVar2.f252989a = new float[]{((f18 * 2.0f) + this.f252987i) * 1, f16};
        bVar2.f252990b = f18;
        this.D.add(bVar2);
        float f19 = this.f252985f;
        this.C = (((f19 * 2.0f) + this.f252987i) * 2.0f) - (f19 * 2.0f);
    }

    private void h(Canvas canvas, int i3, int i16, float f16, float f17, float f18) {
        float f19;
        b bVar = this.D.get(i16);
        b bVar2 = this.D.get(i3);
        float b16 = b(bVar.f252989a, bVar2.f252989a);
        float f26 = bVar.f252990b;
        float f27 = bVar2.f252990b;
        if (b16 > f18) {
            float[] fArr = bVar2.f252989a;
            canvas.drawCircle(fArr[0], fArr[1], f27, this.f252983d);
        } else {
            f27 *= ((1.0f - (b16 / f18)) * 0.3f) + 1.0f;
            float[] fArr2 = bVar2.f252989a;
            canvas.drawCircle(fArr2[0], fArr2[1], f27, this.f252983d);
        }
        float f28 = 0.0f;
        if (f26 != 0.0f && f27 != 0.0f && b16 <= f18) {
            if (b16 > Math.abs(f26 - f27)) {
                float f29 = f26 + f27;
                if (b16 < f29) {
                    float f36 = f26 * f26;
                    float f37 = b16 * b16;
                    float f38 = f27 * f27;
                    float acos = (float) Math.acos(((f36 + f37) - f38) / ((f26 * 2.0f) * b16));
                    float acos2 = (float) Math.acos(((f38 + f37) - f36) / ((f27 * 2.0f) * b16));
                    f28 = acos;
                    f19 = acos2;
                } else {
                    f19 = 0.0f;
                }
                float f39 = bVar2.f252989a[1];
                float[] fArr3 = bVar.f252989a;
                float atan2 = (float) Math.atan2(f39 - fArr3[1], r10[0] - fArr3[0]);
                float acos3 = (float) Math.acos(r8 / b16);
                float f46 = (acos3 - f28) * f16;
                float f47 = atan2 + f28 + f46;
                float f48 = (atan2 - f28) - f46;
                double d16 = atan2;
                double d17 = f19;
                double d18 = ((3.141592653589793d - d17) - acos3) * f16;
                float f49 = (float) (((d16 + 3.141592653589793d) - d17) - d18);
                float f56 = (float) ((d16 - 3.141592653589793d) + d17 + d18);
                f(f47, f26, this.H);
                f(f48, f26, this.I);
                f(f49, f27, this.J);
                f(f56, f27, this.K);
                float[] fArr4 = this.L;
                float[] fArr5 = this.H;
                float f57 = fArr5[0];
                float[] fArr6 = bVar.f252989a;
                fArr4[0] = f57 + fArr6[0];
                fArr4[1] = fArr5[1] + fArr6[1];
                float[] fArr7 = this.M;
                float[] fArr8 = this.I;
                fArr7[0] = fArr8[0] + fArr6[0];
                fArr7[1] = fArr8[1] + fArr6[1];
                float[] fArr9 = this.N;
                float[] fArr10 = this.J;
                float f58 = fArr10[0];
                float[] fArr11 = bVar2.f252989a;
                fArr9[0] = f58 + fArr11[0];
                fArr9[1] = fArr10[1] + fArr11[1];
                float[] fArr12 = this.P;
                float[] fArr13 = this.K;
                fArr12[0] = fArr13[0] + fArr11[0];
                fArr12[1] = fArr13[1] + fArr11[1];
                float[] fArr14 = this.Q;
                fArr14[0] = fArr4[0] - fArr9[0];
                fArr14[1] = fArr4[1] - fArr9[1];
                float min = Math.min(f16 * f17, d(fArr14) / f29) * Math.min(1.0f, (2.0f * b16) / f29);
                float f59 = f26 * min;
                float f65 = f27 * min;
                f(f47 - 1.5707964f, f59, this.R);
                f(f49 + 1.5707964f, f65, this.S);
                f(f56 - 1.5707964f, f65, this.T);
                f(f48 + 1.5707964f, f59, this.U);
                this.V.reset();
                Path path = this.V;
                float[] fArr15 = this.L;
                path.moveTo(fArr15[0], fArr15[1]);
                Path path2 = this.V;
                float[] fArr16 = this.L;
                float f66 = fArr16[0];
                float[] fArr17 = this.R;
                float f67 = fArr17[0] + f66;
                float f68 = fArr16[1] + fArr17[1];
                float[] fArr18 = this.N;
                float f69 = fArr18[0];
                float[] fArr19 = this.S;
                float f75 = f69 + fArr19[0];
                float f76 = fArr18[1];
                path2.cubicTo(f67, f68, f75, f76 + fArr19[1], f69, f76);
                Path path3 = this.V;
                float[] fArr20 = this.P;
                path3.lineTo(fArr20[0], fArr20[1]);
                Path path4 = this.V;
                float[] fArr21 = this.P;
                float f77 = fArr21[0];
                float[] fArr22 = this.T;
                float f78 = fArr22[0] + f77;
                float f79 = fArr21[1] + fArr22[1];
                float[] fArr23 = this.M;
                float f85 = fArr23[0];
                float[] fArr24 = this.U;
                float f86 = f85 + fArr24[0];
                float f87 = fArr23[1];
                path4.cubicTo(f78, f79, f86, f87 + fArr24[1], f85, f87);
                Path path5 = this.V;
                float[] fArr25 = this.L;
                path5.lineTo(fArr25[0], fArr25[1]);
                this.V.close();
                canvas.drawPath(this.V, this.f252983d);
            }
        }
    }

    private void j() {
        c cVar = new c();
        this.F = cVar;
        cVar.setDuration(1000L);
        this.F.setInterpolator(new AccelerateDecelerateInterpolator());
        this.F.setRepeatCount(-1);
        this.F.setRepeatMode(2);
        startAnimation(this.F);
    }

    private void k() {
        clearAnimation();
        postInvalidate();
    }

    protected int c() {
        return (int) ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 20.0f);
    }

    protected int e() {
        return (int) ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).dp2px(getContext(), 10.0f);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            j();
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (getVisibility() == 0) {
            k();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b bVar = this.D.get(0);
        this.G = bVar;
        float[] fArr = bVar.f252989a;
        float f16 = (this.C * this.E) + this.f252985f;
        fArr[0] = f16;
        canvas.drawCircle(f16, fArr[1], bVar.f252990b, this.f252983d);
        int size = this.D.size();
        for (int i3 = 1; i3 < size; i3++) {
            h(canvas, i3, 0, 0.6f, this.f252984e, this.f252985f * 2.0f);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(View.resolveSizeAndState((int) (((this.f252985f * 2.0f) + this.f252987i) * 2.0f), i3, 0), View.resolveSizeAndState((int) (this.f252985f * 2.0f * 1.4f), i16, 0));
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        boolean z16;
        super.onVisibilityChanged(view, i3);
        if (i3 == 0 && getVisibility() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            k();
        } else {
            j();
        }
    }

    public void setPaintMode(int i3) {
        Paint.Style style;
        Paint paint = this.f252983d;
        if (i3 == 0) {
            style = Paint.Style.STROKE;
        } else {
            style = Paint.Style.FILL;
        }
        paint.setStyle(style);
        invalidate();
    }

    public MetaballView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f252983d = new Paint();
        this.f252984e = 1.0f;
        this.f252985f = 10.0f;
        this.f252986h = 2;
        this.f252987i = 60;
        this.f252988m = 0.3f;
        this.D = new ArrayList<>();
        this.H = new float[2];
        this.I = new float[2];
        this.J = new float[2];
        this.K = new float[2];
        this.L = new float[2];
        this.M = new float[2];
        this.N = new float[2];
        this.P = new float[2];
        this.Q = new float[2];
        this.R = new float[2];
        this.S = new float[2];
        this.T = new float[2];
        this.U = new float[2];
        this.V = new Path();
        i(context, attributeSet, 0);
        g();
    }

    public MetaballView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f252983d = new Paint();
        this.f252984e = 1.0f;
        this.f252985f = 10.0f;
        this.f252986h = 2;
        this.f252987i = 60;
        this.f252988m = 0.3f;
        this.D = new ArrayList<>();
        this.H = new float[2];
        this.I = new float[2];
        this.J = new float[2];
        this.K = new float[2];
        this.L = new float[2];
        this.M = new float[2];
        this.N = new float[2];
        this.P = new float[2];
        this.Q = new float[2];
        this.R = new float[2];
        this.S = new float[2];
        this.T = new float[2];
        this.U = new float[2];
        this.V = new Path();
        i(context, attributeSet, i3);
        g();
    }

    protected void i(Context context, AttributeSet attributeSet, int i3) {
    }
}

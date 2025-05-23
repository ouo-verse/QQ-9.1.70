package com.tencent.mobileqq.guild.media.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

/* compiled from: P */
/* loaded from: classes14.dex */
public class VolumnAnimateView extends View {
    private static final float[] N = {151.0f, 90.0f, 151.0f, 106.62f, 144.36f, 121.68f, 133.58f, 132.68f, 122.51f, 143.99f, 107.07f, 151.0f, 90.0f, 151.0f, 56.31f, 151.0f, 29.0f, 123.69f, 29.0f, 90.0f, 29.0f, 73.04f, 35.92f, 57.71f, 47.08f, 46.65f, 58.11f, 35.74f, 73.27f, 29.0f, 90.0f, 29.0f, 123.69f, 29.0f, 151.0f, 56.31f, 151.0f, 90.0f, 153.98f, 90.02f, 153.98f, 108.47f, 146.17f, 125.09f, 133.68f, 136.77f, 122.25f, 147.47f, 106.88f, 154.02f, 89.98f, 154.02f, 54.63f, 154.02f, 25.98f, 125.37f, 25.98f, 90.02f, 25.98f, 73.64f, 32.14f, 58.69f, 42.26f, 47.37f, 53.98f, 34.27f, 71.02f, 26.02f, 89.98f, 26.02f, 125.33f, 26.02f, 153.98f, 54.67f, 153.98f, 90.02f, 157.98f, 90.02f, 157.98f, 108.9f, 150.28f, 125.99f, 137.85f, 138.31f, 125.56f, 150.49f, 108.65f, 158.02f, 89.98f, 158.02f, 52.43f, 158.02f, 21.98f, 127.57f, 21.98f, 90.02f, 21.98f, 70.69f, 30.04f, 53.25f, 42.99f, 40.87f, 55.2f, 29.19f, 71.75f, 22.02f, 89.98f, 22.02f, 127.54f, 22.02f, 157.98f, 52.46f, 157.98f, 90.02f};
    private static final float[] P = {152.14f, 101.72f, 150.07f, 118.8f, 148.21f, 128.53f, 137.45f, 139.51f, 126.4f, 150.79f, 107.25f, 153.15f, 90.22f, 153.15f, 56.6f, 153.15f, 29.34f, 126.91f, 26.19f, 90.17f, 24.61f, 71.68f, 26.19f, 48.18f, 40.89f, 34.54f, 55.39f, 21.07f, 81.41f, 27.73f, 98.61f, 30.34f, 133.25f, 35.59f, 156.34f, 67.08f, 152.14f, 101.72f, 157.0f, 90.93f, 157.0f, 109.34f, 153.77f, 127.44f, 141.35f, 139.09f, 129.97f, 149.77f, 106.68f, 158.39f, 90.22f, 156.89f, 55.79f, 153.75f, 19.27f, 126.53f, 14.05f, 90.93f, 11.63f, 74.43f, 10.92f, 53.23f, 31.79f, 39.62f, 55.95f, 23.86f, 73.99f, 22.79f, 90.22f, 23.91f, 120.48f, 26.01f, 157.0f, 55.65f, 157.0f, 90.93f, 161.28f, 93.26f, 161.28f, 112.09f, 158.03f, 133.12f, 145.64f, 145.4f, 133.38f, 157.54f, 106.88f, 160.0f, 88.27f, 160.0f, 50.82f, 160.0f, 22.56f, 129.76f, 17.34f, 90.13f, 14.66f, 69.74f, 14.86f, 35.74f, 27.77f, 23.4f, 39.94f, 11.76f, 72.62f, 12.97f, 90.35f, 15.06f, 126.89f, 19.35f, 161.28f, 55.83f, 161.28f, 93.26f};
    private float C;
    private Matrix D;
    private int E;
    private int F;
    private ValueAnimator G;
    private float H;
    private float I;
    private float J;
    private boolean K;
    private int L;
    private float[] M;

    /* renamed from: d, reason: collision with root package name */
    private final int f229800d;

    /* renamed from: e, reason: collision with root package name */
    private Path[] f229801e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable[] f229802f;

    /* renamed from: h, reason: collision with root package name */
    private int[] f229803h;

    /* renamed from: i, reason: collision with root package name */
    private float[] f229804i;

    /* renamed from: m, reason: collision with root package name */
    private float f229805m;

    @RequiresApi(api = 21)
    public VolumnAnimateView(Context context) {
        this(context, null);
    }

    private void b() {
        int i3 = 0;
        while (true) {
            float[] fArr = N;
            if (i3 < fArr.length) {
                float[] fArr2 = this.M;
                float f16 = fArr[i3];
                float f17 = f16 + ((P[i3] - f16) * this.H);
                fArr2[i3] = f17;
                if (i3 % 2 == 1 && f17 > 162.0f) {
                    fArr2[i3] = 162.0f;
                }
                i3++;
            } else {
                return;
            }
        }
    }

    private void c() {
        int i3 = -1;
        for (int i16 = 0; i16 < 3; i16++) {
            this.f229801e[i16].reset();
            Path path = this.f229801e[i16];
            float[] fArr = this.M;
            int i17 = i3 + 1;
            float f16 = fArr[i17];
            i3 = i17 + 1;
            path.moveTo(f16, fArr[i3]);
            for (int i18 = 0; i18 < 6; i18++) {
                Path path2 = this.f229801e[i16];
                float[] fArr2 = this.M;
                int i19 = i3 + 1;
                float f17 = fArr2[i19];
                int i26 = i19 + 1;
                float f18 = fArr2[i26];
                int i27 = i26 + 1;
                float f19 = fArr2[i27];
                int i28 = i27 + 1;
                float f26 = fArr2[i28];
                int i29 = i28 + 1;
                float f27 = fArr2[i29];
                i3 = i29 + 1;
                path2.cubicTo(f17, f18, f19, f26, f27, fArr2[i3]);
            }
            this.f229801e[i16].close();
        }
    }

    private void d() {
        b();
        c();
        o();
        n();
    }

    private void e() {
        for (int i3 = 0; i3 < 3; i3++) {
            this.f229801e[i3] = new Path();
        }
        g();
        h();
        i();
        f();
    }

    private void f() {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.G = valueAnimator;
        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.G.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.guild.media.widget.bg
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                VolumnAnimateView.this.j(valueAnimator2);
            }
        });
        this.G.setDuration(150L);
        m();
    }

    private void h() {
        for (int i3 = 0; i3 < 3; i3++) {
            this.f229802f[i3].setAlpha(this.f229803h[i3]);
        }
    }

    private void i() {
        this.E = getWidth();
        int height = getHeight();
        this.F = height;
        int i3 = this.E;
        if (i3 > 0 && height > 0) {
            this.f229805m = (i3 * 1.0f) / 180.0f;
            this.C = (height * 1.0f) / 180.0f;
            for (int i16 = 0; i16 < 3; i16++) {
                this.f229802f[i16].setBounds(-10, -10, this.E + 10, this.F + 10);
            }
            d();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(ValueAnimator valueAnimator) {
        this.H = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        d();
        postInvalidate();
    }

    private void k(boolean z16) {
        float f16;
        if (z16) {
            this.K = !this.K;
        } else {
            this.K = false;
            this.I = this.J;
            for (int i3 = 0; i3 < 3; i3++) {
                this.f229804i[i3] = (float) (Math.random() * 360.0d);
            }
        }
        ValueAnimator valueAnimator = this.G;
        float[] fArr = new float[2];
        boolean z17 = this.K;
        float f17 = 0.0f;
        if (z17) {
            f16 = this.I;
        } else {
            f16 = 0.0f;
        }
        fArr[0] = f16;
        if (!z17) {
            f17 = this.I;
        }
        fArr[1] = f17;
        valueAnimator.setFloatValues(fArr);
        this.G.start();
    }

    private void l() {
        if (!this.K && Float.compare(this.H, this.I) >= 0) {
            k(true);
        } else if (Float.compare(this.H, 0.0f) <= 0 && this.K) {
            k(false);
        }
    }

    private void m() {
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (Float.compare(declaredField.getFloat(null), 0.0f) == 0) {
                QLog.i("QGMC.VolumnAnimateView", 1, "Settings.Global.ANIMATOR_DURATION_SCALE was 0, reset to 1");
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable th5) {
            QLog.e("QGMC.VolumnAnimateView", 1, th5.getMessage());
        }
    }

    private void n() {
        float f16 = this.E / 2;
        float f17 = this.F / 2;
        for (int i3 = 0; i3 < 3; i3++) {
            float f18 = (this.f229804i[i3] + (this.H * 5.0f)) % 360.0f;
            this.D.reset();
            this.D.postRotate(f18, f16, f17);
            this.f229801e[i3].transform(this.D);
        }
    }

    private void o() {
        this.D.reset();
        this.D.postScale(this.f229805m, this.C);
        for (int i3 = 0; i3 < 3; i3++) {
            this.f229801e[i3].transform(this.D);
        }
    }

    public void g() {
        this.f229802f[0] = getResources().getDrawable(R.drawable.guild_audio_gradient_circle_s);
        this.f229802f[1] = getResources().getDrawable(R.drawable.guild_audio_gradient_circle_m);
        this.f229802f[2] = getResources().getDrawable(R.drawable.guild_audio_gradient_circle_b);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i3 = 2; i3 >= 0; i3--) {
            canvas.save();
            canvas.clipPath(this.f229801e[i3]);
            this.f229802f[i3].draw(canvas);
            canvas.restore();
        }
        l();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        i();
    }

    public void setVolume(int i3) {
        float f16 = (i3 * 1.0f) / 100.0f;
        if (Float.compare(f16, 0.0f) == 0) {
            f16 = 0.01f;
        }
        this.J = f16;
        if (!this.G.isRunning()) {
            k(false);
        }
    }

    @RequiresApi(api = 21)
    public VolumnAnimateView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @RequiresApi(api = 21)
    public VolumnAnimateView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    @RequiresApi(api = 21)
    public VolumnAnimateView(Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f229800d = 3;
        this.f229801e = new Path[3];
        this.f229802f = new Drawable[3];
        this.f229803h = new int[]{204, 150, 100};
        this.f229804i = new float[]{0.0f, 0.0f, 0.0f};
        this.f229805m = 1.0f;
        this.C = 1.0f;
        this.D = new Matrix();
        this.H = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = false;
        this.L = 0;
        this.M = new float[N.length];
        e();
    }

    public void setCircleColorType(int i3) {
    }
}

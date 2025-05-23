package com.tencent.biz.qqcircle.immersive.views;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSLightView extends View {
    private float C;
    private boolean D;
    private Rect E;
    private ValueAnimator F;

    /* renamed from: d, reason: collision with root package name */
    private Shader f90384d;

    /* renamed from: e, reason: collision with root package name */
    private Matrix f90385e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f90386f;

    /* renamed from: h, reason: collision with root package name */
    private int f90387h;

    /* renamed from: i, reason: collision with root package name */
    private int f90388i;

    /* renamed from: m, reason: collision with root package name */
    private float f90389m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue == 1.0f) {
                QFSLightView.this.D = false;
            }
            QFSLightView.this.f90389m = ((r0.f90387h * 4) * floatValue) - (QFSLightView.this.f90387h * 2);
            QFSLightView.this.C = r0.f90388i * floatValue;
            if (QFSLightView.this.f90385e != null) {
                QFSLightView.this.f90385e.setTranslate(QFSLightView.this.f90389m, QFSLightView.this.C);
            }
            if (QFSLightView.this.f90384d != null) {
                QFSLightView.this.f90384d.setLocalMatrix(QFSLightView.this.f90385e);
            }
            QFSLightView.this.invalidate();
        }
    }

    public QFSLightView(Context context) {
        this(context, null);
    }

    private void j() {
        this.E = new Rect();
        this.f90386f = new Paint();
        k();
    }

    private void k() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.F = ofFloat;
        ofFloat.setDuration(1000L);
        this.F.addUpdateListener(new a());
    }

    public void l() {
        ValueAnimator valueAnimator;
        Log.d("LightView", "startAnimation mAnimating=" + this.D + ",valueAnimator=" + this.F);
        if (!this.D && (valueAnimator = this.F) != null) {
            this.D = true;
            valueAnimator.start();
        }
    }

    public void m() {
        ValueAnimator valueAnimator;
        Log.d("LightView", "stopAnimation mAnimating=" + this.D + ",valueAnimator=" + this.F);
        if (this.D && (valueAnimator = this.F) != null) {
            this.D = false;
            valueAnimator.cancel();
            invalidate();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.D && this.f90385e != null) {
            canvas.drawRect(this.E, this.f90386f);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        this.E.set(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        if (this.f90387h == 0) {
            this.f90387h = getWidth();
            this.f90388i = getHeight();
            if (this.f90387h > 0) {
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, this.f90387h / 2, this.f90388i, new int[]{16777215, 1946157055, 16777215, -1711276033, 16777215}, new float[]{0.2f, 0.35f, 0.5f, 0.7f, 1.0f}, Shader.TileMode.CLAMP);
                this.f90384d = linearGradient;
                this.f90386f.setShader(linearGradient);
                this.f90386f.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                Matrix matrix = new Matrix();
                this.f90385e = matrix;
                matrix.setTranslate(this.f90387h * (-2), this.f90388i);
                this.f90384d.setLocalMatrix(this.f90385e);
                this.E.set(0, 0, i3, i16);
            }
        }
    }

    public QFSLightView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSLightView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f90387h = 0;
        this.f90388i = 0;
        this.f90389m = 0.0f;
        this.C = 0.0f;
        this.D = false;
        j();
    }
}

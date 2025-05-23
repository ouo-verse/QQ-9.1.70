package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.widget.StorageCircleProgress;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes20.dex */
public class LoadingCircleProgress extends StorageCircleProgress {
    private final StorageCircleProgress.a I;
    private float J;
    private int K;
    private int L;
    private int[] M;
    private float[] N;
    private int P;
    private int Q;

    public LoadingCircleProgress(Context context) {
        this(context, null);
    }

    private void j() {
        Path path = this.I.f316328c;
        path.reset();
        float f16 = (this.J / this.f316325m) * 360.0f;
        float f17 = this.P;
        float f18 = f17 + f16;
        if (f18 > 360.0f) {
            path.addArc(this.f316322f, f17, 360 - r3);
            path.addArc(this.f316322f, 0.0f, f18 % 360.0f);
            return;
        }
        path.addArc(this.f316322f, f17, f16);
    }

    private void l() {
        SweepGradient sweepGradient;
        int[] iArr = this.M;
        if (iArr == null) {
            int i3 = this.K;
            int i16 = this.L;
            if (i3 == i16) {
                this.I.f316327b.setColor(i16);
                return;
            }
        }
        if (iArr == null) {
            sweepGradient = new SweepGradient(this.f316320d / 2.0f, this.f316321e / 2.0f, this.K, this.L);
        } else {
            sweepGradient = new SweepGradient(this.f316320d / 2.0f, this.f316321e / 2.0f, this.M, this.N);
        }
        this.I.f316327b.setShader(sweepGradient);
    }

    private void p() {
        float f16 = (this.f316320d / 2.0f) - (this.f316323h / 2.0f);
        int i3 = this.Q;
        this.P = i3;
        if (this.C != Paint.Cap.BUTT) {
            this.P = i3 + ((int) Math.ceil((((r2 / 2.0f) * 180.0f) / 3.141592653589793d) / f16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.StorageCircleProgress, android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        l();
        p();
        j();
    }

    @Override // com.tencent.mobileqq.widget.StorageCircleProgress
    public void setCap(Paint.Cap cap) {
        if (this.C != cap) {
            this.C = cap;
            this.I.f316327b.setStrokeCap(cap);
            j();
        }
        super.setCap(cap);
    }

    public void setLoadingProgress(float f16) {
        this.J = f16;
        j();
        invalidate();
    }

    @Override // com.tencent.mobileqq.widget.StorageCircleProgress
    public void setStartAngel(int i3) {
        this.Q = i3;
        p();
        j();
        super.setStartAngel(i3);
    }

    @Override // com.tencent.mobileqq.widget.StorageCircleProgress
    public void setStrokeWidth(float f16) {
        this.I.f316327b.setStrokeWidth(f16);
        j();
        super.setStrokeWidth(f16);
    }

    public void setSweepGradient(int[] iArr, float[] fArr) {
        this.M = iArr;
        this.N = fArr;
        if (iArr != null && this.f316320d != 0) {
            this.I.f316327b.setShader(new SweepGradient(this.f316320d / 2.0f, this.f316321e / 2.0f, iArr, fArr));
        }
        invalidate();
    }

    public LoadingCircleProgress(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingCircleProgress(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        StorageCircleProgress.a aVar = new StorageCircleProgress.a();
        this.I = aVar;
        Paint paint = new Paint();
        aVar.f316327b = paint;
        paint.setStrokeWidth(h());
        paint.setStrokeCap(f());
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u51.a.B0);
        this.K = obtainStyledAttributes.getColor(u51.a.E0, SupportMenu.CATEGORY_MASK);
        this.L = obtainStyledAttributes.getColor(u51.a.C0, SupportMenu.CATEGORY_MASK);
        this.J = obtainStyledAttributes.getFloat(u51.a.D0, 0.0f);
        obtainStyledAttributes.recycle();
        aVar.f316328c = new Path();
        aVar.f316326a = 0;
        this.Q = this.f316324i;
        c(aVar);
    }

    public void setSweepGradient(int i3, int i16) {
        this.M = null;
        this.N = null;
        this.K = i3;
        this.L = i16;
        l();
        invalidate();
    }
}

package com.tencent.mobileqq.widget.tip;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUICustomBubbleView extends FrameLayout {
    private int C;
    private int D;
    private int E;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    private Path f317511d;

    /* renamed from: e, reason: collision with root package name */
    private final Paint f317512e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f317513f;

    /* renamed from: h, reason: collision with root package name */
    private float f317514h;

    /* renamed from: i, reason: collision with root package name */
    private int f317515i;

    /* renamed from: m, reason: collision with root package name */
    private int f317516m;

    public QUICustomBubbleView(@NonNull Context context) {
        super(context);
        this.f317512e = new Paint();
        this.f317513f = new Paint();
        setWillNotDraw(false);
        e();
    }

    private void a() {
        int i3 = this.f317516m;
        if (i3 != 1 && i3 != 0) {
            if (i3 == 3 || i3 == 2) {
                d();
                return;
            }
            return;
        }
        c();
    }

    private void b() {
        if (this.f317511d == null) {
            this.f317511d = new Path();
        }
        RectF rectF = new RectF(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        Path path = new Path();
        float f16 = this.f317514h;
        path.addRoundRect(rectF, f16, f16, Path.Direction.CW);
        this.f317511d.op(path, Path.Op.UNION);
    }

    private void c() {
        int paddingTop;
        int i3;
        if (this.f317511d == null) {
            this.f317511d = new Path();
        }
        int paddingLeft = getPaddingLeft() + this.f317515i + this.C;
        double sqrt = Math.sqrt(2.0d);
        float f16 = (float) ((r3 / 3.0f) / sqrt);
        float f17 = this.f317515i - f16;
        if (this.f317516m == 0) {
            paddingTop = getHeight() - getPaddingBottom();
        } else {
            paddingTop = getPaddingTop();
        }
        int i16 = this.f317516m;
        if (i16 != 0) {
            f17 = -f17;
        }
        if (i16 == 0) {
            i3 = this.f317515i;
        } else {
            i3 = -this.f317515i;
        }
        float f18 = paddingTop;
        this.f317511d.moveTo(paddingLeft - this.f317515i, f18);
        float f19 = paddingLeft;
        float f26 = f17 + f18;
        this.f317511d.lineTo(f19 - f16, f26);
        this.f317511d.quadTo(f19, i3 + f18, f16 + f19, f26);
        this.f317511d.lineTo(paddingLeft + this.f317515i, f18);
    }

    private void d() {
        int paddingLeft;
        int i3;
        if (this.f317511d == null) {
            this.f317511d = new Path();
        }
        int paddingTop = getPaddingTop() + this.f317515i + this.D;
        double sqrt = Math.sqrt(2.0d);
        float f16 = (float) ((r3 / 3.0f) / sqrt);
        float f17 = this.f317515i - f16;
        if (this.f317516m == 2) {
            paddingLeft = getWidth() - getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
        }
        int i16 = this.f317516m;
        if (i16 != 2) {
            f17 = -f17;
        }
        if (i16 == 2) {
            i3 = this.f317515i;
        } else {
            i3 = -this.f317515i;
        }
        float f18 = paddingLeft;
        this.f317511d.moveTo(f18, this.f317515i + paddingTop);
        float f19 = f17 + f18;
        float f26 = paddingTop;
        this.f317511d.lineTo(f19, f26 + f16);
        this.f317511d.quadTo(i3 + f18, f26, f19, f26 - f16);
        this.f317511d.lineTo(f18, paddingTop - this.f317515i);
    }

    private void e() {
        this.f317512e.setStyle(Paint.Style.FILL);
        this.f317512e.setColor(0);
        this.f317514h = x.c(getContext(), 4.0f);
        this.f317515i = x.c(getContext(), 6.0f);
    }

    private Path f() {
        Path path = this.f317511d;
        if (path != null) {
            return path;
        }
        this.f317511d = new Path();
        a();
        b();
        this.f317511d.close();
        return this.f317511d;
    }

    public int g() {
        return this.f317515i * 2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(f(), this.f317512e);
        if (this.F) {
            canvas.drawPath(f(), this.f317513f);
        }
    }

    public void setArrowOffsetX(int i3) {
        if (this.C != i3) {
            float measuredWidth = ((getMeasuredWidth() - getPaddingEnd()) - g()) - getPaddingStart();
            float f16 = this.f317514h;
            float f17 = measuredWidth - f16;
            float f18 = i3;
            if (f18 < f16) {
                this.C = (int) f16;
            } else if (f18 > f17) {
                this.C = (int) f17;
            } else {
                this.C = i3;
            }
            this.f317511d = null;
            invalidate();
        }
    }

    public void setArrowOffsetY(int i3) {
        if (this.D != i3) {
            float measuredHeight = ((getMeasuredHeight() - getPaddingTop()) - g()) - getPaddingBottom();
            float f16 = this.f317514h;
            float f17 = measuredHeight - f16;
            float f18 = i3;
            if (f18 < f16) {
                this.D = (int) f16;
            } else if (f18 > f17) {
                this.D = (int) f17;
            } else {
                this.D = i3;
            }
            this.f317511d = null;
            invalidate();
        }
    }

    public void setArrowPosition(int i3) {
        this.f317516m = i3;
    }

    public void setBubbleColor(int i3) {
        if (i3 == this.E) {
            return;
        }
        this.E = i3;
        this.f317512e.setColor(i3);
    }

    public void setCornerRadius(float f16) {
        this.f317514h = f16;
    }

    public void setEnableBound(boolean z16) {
        this.F = z16;
        if (z16) {
            this.f317513f.setStyle(Paint.Style.STROKE);
            this.f317513f.setStrokeWidth(2.0f);
            this.f317513f.setColor(ie0.a.f().g(getContext(), R.color.ala, 1000));
        }
    }

    public void setEnableShadow(boolean z16) {
        if (z16) {
            this.f317512e.setShadowLayer(12.0f, 0.0f, 4.0f, ie0.a.f().g(getContext(), R.color.f157952an2, 1000));
        } else {
            this.f317512e.clearShadowLayer();
        }
    }

    public QUICustomBubbleView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f317512e = new Paint();
        this.f317513f = new Paint();
        setWillNotDraw(false);
        e();
    }
}

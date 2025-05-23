package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes20.dex */
public class CircleProgressView extends View {
    private int C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private Paint H;
    private boolean I;
    private int J;
    private Handler K;

    /* renamed from: d, reason: collision with root package name */
    private Paint f315517d;

    /* renamed from: e, reason: collision with root package name */
    private int f315518e;

    /* renamed from: f, reason: collision with root package name */
    private int f315519f;

    /* renamed from: h, reason: collision with root package name */
    private RectF f315520h;

    /* renamed from: i, reason: collision with root package name */
    private int f315521i;

    /* renamed from: m, reason: collision with root package name */
    private int f315522m;

    /* loaded from: classes20.dex */
    private class Animator implements Runnable {
        final /* synthetic */ CircleProgressView this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (this.this$0.E) {
                this.this$0.C += this.this$0.G;
            } else {
                this.this$0.C++;
            }
            this.this$0.C %= 360;
            this.this$0.K.postDelayed(this, 16L);
            this.this$0.invalidate();
        }
    }

    public CircleProgressView(Context context) {
        super(context);
        this.f315522m = 10;
        this.C = 0;
        this.D = true;
        this.E = true;
        this.F = 40;
        this.G = 3;
        this.I = false;
        this.J = 4;
        this.K = new Handler();
        g();
    }

    private int f(int i3) {
        return (int) ((i3 / 100.0f) * 360.0f);
    }

    private void g() {
        this.f315522m = (int) ((getResources().getDisplayMetrics().density * 3.0f) + 0.5f);
        this.J = (int) ((getResources().getDisplayMetrics().density * 2.0f) + 0.5f);
        Paint paint = new Paint();
        this.f315517d = paint;
        paint.setColor(-15550475);
        this.f315517d.setStyle(Paint.Style.STROKE);
        this.f315517d.setStrokeWidth(this.f315522m);
        this.f315517d.setFlags(1);
        this.f315520h = new RectF();
        Paint paint2 = new Paint();
        this.H = paint2;
        paint2.setColor(-1);
        this.H.setStyle(Paint.Style.STROKE);
        this.H.setStrokeWidth(this.f315522m);
        this.H.setFlags(1);
        setBackgroundColor(0);
    }

    public boolean h() {
        if (getVisibility() == 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (!this.E) {
            canvas.save();
            if (this.D) {
                canvas.rotate(-36.0f, this.f315518e / 2, this.f315519f / 2);
                canvas.drawArc(this.f315520h, 0.0f, this.C, false, this.f315517d);
            } else {
                canvas.rotate(222.0f, this.f315518e / 2, this.f315519f / 2);
                canvas.drawArc(this.f315520h, 0.0f, this.C, false, this.f315517d);
            }
            canvas.restore();
            return;
        }
        canvas.save();
        canvas.rotate(this.C, this.f315518e / 2, this.f315519f / 2);
        canvas.drawArc(this.f315520h, 0.0f, this.F, false, this.H);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f315518e = i3;
        this.f315519f = i16;
        int i19 = this.f315522m - this.J;
        this.f315522m = i19;
        this.f315520h.set(i19, i19, i3 - i19, i16 - i19);
    }

    public void setIndeterminate(boolean z16) {
        if (this.E != z16) {
            if (QLog.isColorLevel()) {
                QLog.e("CircleProgressView", 2, "setIndeterminate() change mIndeterminate = " + this.E);
            }
            this.E = z16;
        }
    }

    public void setIsSend(boolean z16) {
        this.D = z16;
    }

    public void setProgress(int i3) {
        if (QLog.isColorLevel()) {
            QLog.e("CircleProgressView", 2, "setProgress() progress = " + i3);
        }
        if (i3 >= 0 && i3 <= 100) {
            if (this.E) {
                if (QLog.isColorLevel()) {
                    QLog.e("CircleProgressView", 2, "setProgress() mIndeterminate = true, just return");
                    return;
                }
                return;
            }
            if (!h()) {
                setVisibility(0);
            }
            if (this.I) {
                this.K.removeCallbacksAndMessages(null);
            }
            if (i3 <= 2) {
                i3 = 2;
            }
            this.f315521i = i3;
            this.C = f(i3);
            invalidate();
        }
    }

    public void setIndeterminate(boolean z16, int i3, int i16) {
        if (this.E != z16) {
            if (QLog.isColorLevel()) {
                QLog.e("CircleProgressView", 2, "setIndeterminate() change mIndeterminate = " + this.E);
            }
            this.E = z16;
        }
        this.F = i3;
        this.G = i16;
    }

    public CircleProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleProgressView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315522m = 10;
        this.C = 0;
        this.D = true;
        this.E = true;
        this.F = 40;
        this.G = 3;
        this.I = false;
        this.J = 4;
        this.K = new Handler();
        g();
    }
}

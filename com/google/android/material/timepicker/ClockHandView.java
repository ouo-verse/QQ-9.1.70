package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.annotation.Dimension;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.ViewCompat;
import com.tencent.mobileqq.R;
import com.tencent.tencentmap.mapsdk.maps.model.GeometryConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public class ClockHandView extends View {
    private final List<c> C;
    private final int D;
    private final float E;
    private final Paint F;
    private final RectF G;

    @Px
    private final int H;
    private float I;
    private boolean J;
    private double K;
    private int L;

    /* renamed from: d, reason: collision with root package name */
    private ValueAnimator f34465d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f34466e;

    /* renamed from: f, reason: collision with root package name */
    private float f34467f;

    /* renamed from: h, reason: collision with root package name */
    private float f34468h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f34469i;

    /* renamed from: m, reason: collision with root package name */
    private int f34470m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.m(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface c {
        void j0(@FloatRange(from = 0.0d, to = 360.0d) float f16, boolean z16);
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.av5);
    }

    private void c(Canvas canvas) {
        int height = getHeight() / 2;
        float width = getWidth() / 2;
        float cos = (this.L * ((float) Math.cos(this.K))) + width;
        float f16 = height;
        float sin = (this.L * ((float) Math.sin(this.K))) + f16;
        this.F.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.D, this.F);
        double sin2 = Math.sin(this.K);
        double cos2 = Math.cos(this.K);
        this.F.setStrokeWidth(this.H);
        canvas.drawLine(width, f16, r1 + ((int) (cos2 * r6)), height + ((int) (r6 * sin2)), this.F);
        canvas.drawCircle(width, f16, this.E, this.F);
    }

    private int e(float f16, float f17) {
        int degrees = ((int) Math.toDegrees(Math.atan2(f17 - (getHeight() / 2), f16 - (getWidth() / 2)))) + 90;
        if (degrees < 0) {
            return degrees + 360;
        }
        return degrees;
    }

    private Pair<Float, Float> h(float f16) {
        float f17 = f();
        if (Math.abs(f17 - f16) > 180.0f) {
            if (f17 > 180.0f && f16 < 180.0f) {
                f16 += 360.0f;
            }
            if (f17 < 180.0f && f16 > 180.0f) {
                f17 += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(f17), Float.valueOf(f16));
    }

    private boolean i(float f16, float f17, boolean z16, boolean z17, boolean z18) {
        boolean z19;
        float e16 = e(f16, f17);
        boolean z26 = false;
        if (f() != e16) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z17 && z19) {
            return true;
        }
        if (!z19 && !z16) {
            return false;
        }
        if (z18 && this.f34466e) {
            z26 = true;
        }
        l(e16, z26);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(@FloatRange(from = 0.0d, to = 360.0d) float f16, boolean z16) {
        float f17 = f16 % 360.0f;
        this.I = f17;
        this.K = Math.toRadians(f17 - 90.0f);
        int height = getHeight() / 2;
        float width = (getWidth() / 2) + (this.L * ((float) Math.cos(this.K)));
        float sin = height + (this.L * ((float) Math.sin(this.K)));
        RectF rectF = this.G;
        int i3 = this.D;
        rectF.set(width - i3, sin - i3, width + i3, sin + i3);
        Iterator<c> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().j0(f17, z16);
        }
        invalidate();
    }

    public void b(c cVar) {
        this.C.add(cVar);
    }

    public RectF d() {
        return this.G;
    }

    @FloatRange(from = 0.0d, to = GeometryConstants.LONGITUDE_SPAN)
    public float f() {
        return this.I;
    }

    public int g() {
        return this.D;
    }

    public void j(@Dimension int i3) {
        this.L = i3;
        invalidate();
    }

    public void k(@FloatRange(from = 0.0d, to = 360.0d) float f16) {
        l(f16, false);
    }

    public void l(@FloatRange(from = 0.0d, to = 360.0d) float f16, boolean z16) {
        ValueAnimator valueAnimator = this.f34465d;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z16) {
            m(f16, false);
            return;
        }
        Pair<Float, Float> h16 = h(f16);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) h16.first).floatValue(), ((Float) h16.second).floatValue());
        this.f34465d = ofFloat;
        ofFloat.setDuration(200L);
        this.f34465d.addUpdateListener(new a());
        this.f34465d.addListener(new b());
        this.f34465d.start();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        k(f());
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        int actionMasked = motionEvent.getActionMasked();
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked != 1 && actionMasked != 2) {
                z17 = false;
                z16 = false;
                z18 = false;
            } else {
                int i3 = (int) (x16 - this.f34467f);
                int i16 = (int) (y16 - this.f34468h);
                if ((i3 * i3) + (i16 * i16) > this.f34470m) {
                    z19 = true;
                } else {
                    z19 = false;
                }
                this.f34469i = z19;
                z17 = this.J;
                if (actionMasked == 1) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                z18 = z26;
                z16 = false;
            }
        } else {
            this.f34467f = x16;
            this.f34468h = y16;
            this.f34469i = true;
            this.J = false;
            z16 = true;
            z17 = false;
            z18 = false;
        }
        this.J |= i(x16, y16, z17, z16, z18);
        return true;
    }

    public ClockHandView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new ArrayList();
        Paint paint = new Paint();
        this.F = paint;
        this.G = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.S1, i3, R.style.asx);
        this.L = obtainStyledAttributes.getDimensionPixelSize(w0.a.U1, 0);
        this.D = obtainStyledAttributes.getDimensionPixelSize(w0.a.V1, 0);
        this.H = getResources().getDimensionPixelSize(R.dimen.cou);
        this.E = r6.getDimensionPixelSize(R.dimen.cos);
        int color = obtainStyledAttributes.getColor(w0.a.T1, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        k(0.0f);
        this.f34470m = ViewConfiguration.get(context).getScaledTouchSlop();
        ViewCompat.setImportantForAccessibility(this, 2);
        obtainStyledAttributes.recycle();
    }
}

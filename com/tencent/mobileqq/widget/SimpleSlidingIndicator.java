package com.tencent.mobileqq.widget;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SimpleSlidingIndicator extends AbsSlidingIndicator {

    /* renamed from: l0, reason: collision with root package name */
    private static final int[] f316251l0 = {R.attr.textSize, R.attr.textColor};

    /* renamed from: b0, reason: collision with root package name */
    private int f316252b0;

    /* renamed from: c0, reason: collision with root package name */
    private int f316253c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f316254d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f316255e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f316256f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f316257g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f316258h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f316259i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f316260j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f316261k0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SimpleSlidingIndicator.this.V = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SimpleSlidingIndicator.this.invalidate();
        }
    }

    public SimpleSlidingIndicator(Context context) {
        this(context, null);
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void b(int i3, View view) {
        view.setFocusable(true);
        t(i3, view);
        if (this.I) {
            int i16 = this.f316253c0;
            view.setPadding(i16 + 2, 0, i16 + 2, 0);
        } else {
            int i17 = this.f316253c0;
            view.setPadding(i17, 0, i17, 0);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        int i18 = this.f316259i0;
        if (i18 != 0) {
            if (i3 == 0) {
                layoutParams.leftMargin = 0;
            } else {
                layoutParams.leftMargin = i18;
            }
        }
        int i19 = this.f316260j0;
        if (i19 != 0) {
            layoutParams.width = i19;
        }
        this.f315359d.addView(view, i3, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void d() {
        int i3 = this.f315362h;
        int i16 = this.f315361f;
        if (i3 != i16) {
            View childAt = this.f315359d.getChildAt(i3);
            View childAt2 = this.f315359d.getChildAt(this.f315361f);
            if (childAt != null && childAt2 != null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(childAt.getLeft(), childAt2.getLeft());
                ofInt.setDuration(200L);
                ofInt.addUpdateListener(new a());
                ofInt.start();
                return;
            }
            return;
        }
        this.V = this.f315359d.getChildAt(i16).getLeft();
        invalidate();
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void g(Canvas canvas) {
        int height = getHeight();
        View childAt = this.f315359d.getChildAt(this.f315361f);
        RectF rectF = this.K;
        int i3 = this.V;
        rectF.set((this.f316253c0 + i3) - this.f316255e0, this.f316254d0, ((i3 + childAt.getWidth()) - this.f316253c0) + this.f316255e0, height - this.f316254d0);
        canvas.drawRoundRect(this.K, this.f316256f0, this.f316257g0, this.J);
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected int h() {
        return this.f315359d.getChildAt(this.f315361f).getLeft();
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected int[] i() {
        int i3 = this.f316261k0;
        return new int[]{i3, 0, i3, 0};
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected int k() {
        return this.f316261k0 + ((this.f316260j0 + this.f316259i0) * this.f315361f);
    }

    protected void x(Context context) {
        this.H = ViewUtils.dpToPx(16.0f);
        this.f316261k0 = ViewUtils.dpToPx(16.0f);
        this.f316259i0 = ViewUtils.dpToPx(2.0f);
        this.f316253c0 = ViewUtils.dpToPx(2.0f);
        this.E = context.getResources().getColor(com.tencent.mobileqq.R.color.f157007hd);
        this.f316252b0 = 25;
        this.f316254d0 = ViewUtils.dpToPx(12.0f);
        this.f316255e0 = ViewUtils.dpToPx(2.0f);
        this.f316256f0 = ViewUtils.dpToPx(16.0f);
        this.f316257g0 = ViewUtils.dpToPx(16.0f);
        this.C = context.getResources().getColor(com.tencent.mobileqq.R.color.f157007hd);
        this.D = context.getResources().getColor(com.tencent.mobileqq.R.color.skin_gray2_theme_version2);
    }

    public void y(int i3, int i16, int i17, int i18) {
        int[] iArr;
        String[] strArr;
        this.f316260j0 = i3;
        this.f316259i0 = i16;
        this.f316253c0 = i17;
        this.f316261k0 = i18;
        if (this.f315359d != null) {
            int[] i19 = i();
            this.f315359d.setPadding(i19[0], i19[1], i19[2], i19[3]);
        }
        if (this.f315359d != null && (iArr = this.f315364m) != null && iArr.length > 0 && (strArr = this.f315363i) != null && strArr.length > 0) {
            n();
        }
        if (QLog.isColorLevel()) {
            QLog.i("SimpleSlidingIndicator", 2, "update, tabWidth[" + i3 + "], gap[" + i16 + "], plr[" + i17 + "], cplr[" + i18 + "], pos[" + this.f315361f);
        }
    }

    public SimpleSlidingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SimpleSlidingIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316252b0 = 25;
        this.f316253c0 = 6;
        this.f316254d0 = 12;
        this.f316255e0 = 12;
        this.f316256f0 = 16;
        this.f316257g0 = 16;
        this.f316258h0 = 52;
        this.f316259i0 = 0;
        this.f316260j0 = 0;
        this.f316261k0 = 0;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f316258h0 = (int) TypedValue.applyDimension(1, this.f316258h0, displayMetrics);
        this.f316254d0 = (int) TypedValue.applyDimension(1, this.f316254d0, displayMetrics);
        this.f316255e0 = (int) TypedValue.applyDimension(1, this.f316255e0, displayMetrics);
        this.f316256f0 = (int) TypedValue.applyDimension(1, this.f316256f0, displayMetrics);
        this.f316257g0 = (int) TypedValue.applyDimension(1, this.f316257g0, displayMetrics);
        this.f316253c0 = (int) TypedValue.applyDimension(1, this.f316253c0, displayMetrics);
        this.H = (int) TypedValue.applyDimension(2, this.H, displayMetrics);
        this.f316259i0 = (int) TypedValue.applyDimension(1, this.f316259i0, displayMetrics);
        this.f316260j0 = (int) TypedValue.applyDimension(1, this.f316260j0, displayMetrics);
        this.f316261k0 = (int) TypedValue.applyDimension(1, this.f316261k0, displayMetrics);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f316251l0);
        this.H = obtainStyledAttributes.getDimensionPixelSize(0, this.H);
        obtainStyledAttributes.recycle();
        x(context);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator);
            this.E = obtainStyledAttributes2.getColor(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_indicatorColor, this.E);
            this.f316252b0 = obtainStyledAttributes2.getInt(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_indicatorAlpha, this.f316252b0);
            this.C = obtainStyledAttributes2.getColor(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_checkTextColor, this.C);
            this.D = obtainStyledAttributes2.getColor(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_uncheckTextColor, this.D);
            this.f316256f0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_indicatorRoundRectX, this.f316256f0);
            this.f316257g0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_indicatorRoundRectY, this.f316257g0);
            this.f316254d0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_indicatorMarginTopBottom, this.f316254d0);
            this.f316255e0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_indicatorMarginLeftRight, this.f316255e0);
            this.f316253c0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_tabPaddingLeftRight, this.f316253c0);
            this.f316259i0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_tabGap, this.f316259i0);
            this.f316260j0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_tabWidth, this.f316260j0);
            this.f316261k0 = obtainStyledAttributes2.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.SimpleSlidingIndicator_tabContainerPaddingLeftRight, this.f316261k0);
            obtainStyledAttributes2.recycle();
        }
        int i16 = this.f316252b0;
        if (i16 > 255) {
            this.f316252b0 = 255;
        } else if (i16 < 0) {
            this.f316252b0 = 0;
        }
        m();
        l(context);
    }
}

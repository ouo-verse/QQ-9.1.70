package com.tencent.mobileqq.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
@TargetApi(14)
/* loaded from: classes20.dex */
public class UnderlineIndicator extends AbsSlidingIndicator {

    /* renamed from: b0, reason: collision with root package name */
    private int f316494b0;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f316495d;

        a(int i3) {
            this.f316495d = i3;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            UnderlineIndicator.this.V = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            UnderlineIndicator underlineIndicator = UnderlineIndicator.this;
            if (underlineIndicator.V == this.f316495d) {
                underlineIndicator.P = false;
            }
            underlineIndicator.invalidate();
        }
    }

    public UnderlineIndicator(Context context) {
        this(context, null);
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void b(int i3, View view) {
        int i16;
        view.setFocusable(true);
        t(i3, view);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        layoutParams.gravity = 17;
        int y16 = y();
        if (i3 > 0) {
            i16 = this.R * 2;
        } else {
            i16 = this.R;
        }
        layoutParams.leftMargin = y16 - i16;
        this.f315359d.addView(view, i3, layoutParams);
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void d() {
        int i3 = this.f315362h;
        int i16 = this.f315361f;
        if (i3 != i16) {
            int i17 = z(i3)[0];
            int i18 = z(this.f315361f)[0];
            ValueAnimator ofInt = ValueAnimator.ofInt(i17, i18);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new a(i18));
            ofInt.start();
            this.P = true;
            return;
        }
        this.V = z(i16)[0];
        invalidate();
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected void g(Canvas canvas) {
        int[] z16 = z(this.f315361f);
        int i3 = z16[2] - z16[0];
        int i16 = this.V;
        int i17 = z16[3];
        this.J.setColor(getResources().getColor(R.color.qui_common_brand_standard));
        this.K.set(i16, z16[1], i3 + i16, i17);
        canvas.drawRoundRect(this.K, 0.0f, 0.0f, this.J);
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected int h() {
        return z(this.f315361f)[0];
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected int[] i() {
        return new int[]{0, 0, this.f316494b0, 0};
    }

    @Override // com.tencent.mobileqq.widget.AbsSlidingIndicator
    protected int k() {
        return x();
    }

    protected int x() {
        int i3 = 0;
        for (int i16 = 0; i16 < this.f315361f; i16++) {
            i3 = (int) (i3 + this.J.measureText(this.f315363i[i16]));
        }
        return i3 + (y() * (this.f315361f + 1));
    }

    protected int y() {
        String[] strArr = this.f315363i;
        if (strArr == null) {
            return this.f316494b0;
        }
        int i3 = 0;
        for (String str : strArr) {
            i3 = (int) (i3 + this.J.measureText(str));
        }
        int screenWidth = (ViewUtils.getScreenWidth() - i3) / (this.f315363i.length + 1);
        int i16 = this.f316494b0;
        if (screenWidth >= i16) {
            return screenWidth;
        }
        return i16;
    }

    protected int[] z(int i3) {
        View childAt = this.f315359d.getChildAt(i3);
        int width = childAt.getWidth();
        int height = getHeight();
        int measureText = ((int) (width - this.J.measureText(this.f315363i[i3]))) / 2;
        int left = childAt.getLeft() + measureText;
        int right = childAt.getRight() - measureText;
        int dpToPx = (height / 2) + (this.H / 2) + ViewUtils.dpToPx(5.0f);
        return new int[]{left, dpToPx, right, ViewUtils.dpToPx(2.0f) + dpToPx};
    }

    public UnderlineIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnderlineIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316494b0 = 0;
        this.C = context.getResources().getColor(R.color.qui_common_brand_standard);
        this.D = context.getResources().getColor(R.color.qui_common_text_primary);
        this.R = 10;
        this.H = ViewUtils.dpToPx(16.0f);
        this.f316494b0 = com.tencent.mobileqq.util.x.c(context, 20.0f);
        m();
        l(context);
    }
}

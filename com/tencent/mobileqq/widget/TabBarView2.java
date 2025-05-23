package com.tencent.mobileqq.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.util.TokenResUtils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class TabBarView2 extends TabBarView {

    /* renamed from: q0, reason: collision with root package name */
    private static final int[] f316354q0 = {R.attr.textSize, R.attr.textColor};

    /* renamed from: h0, reason: collision with root package name */
    private int f316355h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f316356i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f316357j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f316358k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f316359l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f316360m0;

    /* renamed from: n0, reason: collision with root package name */
    private Paint f316361n0;

    /* renamed from: o0, reason: collision with root package name */
    private RectF f316362o0;

    /* renamed from: p0, reason: collision with root package name */
    private Rect f316363p0;

    public TabBarView2(Context context) {
        this(context, null);
    }

    private void l(Canvas canvas) {
        View childAt;
        View childAt2 = getChildAt(this.R);
        if (childAt2 != null) {
            this.f316361n0.setColor(this.f316357j0);
            this.f316361n0.setAlpha(this.f316358k0);
            RedDotTextView redDotTextView = this.T.get(this.R);
            this.f316339b0.setTextSize((this.J * getContext().getResources().getDisplayMetrics().density) + 0.5f);
            String str = this.V.get(this.R);
            this.f316339b0.getTextBounds(str, 0, str.length(), this.f316363p0);
            float width = this.f316363p0.width();
            float height = this.f316363p0.height();
            int right = (int) (((childAt2.getRight() - childAt2.getLeft()) - width) / 2.0f);
            int i3 = (int) (right + width);
            int bottom = (int) (((childAt2.getBottom() - childAt2.getTop()) - height) / 2.0f);
            int i16 = (int) (bottom + height);
            if (redDotTextView != null) {
                int left = childAt2.getLeft() + right;
                int left2 = childAt2.getLeft() + i3;
                int top = childAt2.getTop() + bottom;
                int top2 = childAt2.getTop() + i16;
                if (this.P > 0.0f && (childAt = getChildAt(this.Q)) != null) {
                    int right2 = (int) (((childAt.getRight() - childAt.getLeft()) - this.f316339b0.measureText(this.V.get(this.Q).toString())) / 2.0f);
                    left = (int) (left + (this.P * (((childAt.getLeft() + right2) - this.f316344i) - left)));
                    left2 = (int) (left2 + (this.P * (((childAt.getLeft() + ((int) (right2 + r5))) + this.f316344i) - left2)));
                }
                RectF rectF = this.f316362o0;
                int i17 = this.f316360m0;
                int i18 = this.f316359l0;
                rectF.set(left - i17, top - i18, left2 + i17, top2 + i18);
                canvas.drawRoundRect(this.f316362o0, this.f316355h0, this.f316356i0, this.f316361n0);
            }
        }
    }

    private void y() {
        Paint paint = new Paint();
        this.f316361n0 = paint;
        paint.setAntiAlias(true);
        this.f316361n0.setStyle(Paint.Style.FILL);
        this.f316362o0 = new RectF();
    }

    @Override // com.tencent.mobileqq.widget.TabBarView
    protected void s(Canvas canvas) {
        if (QQTheme.isNowSimpleUI()) {
            m(canvas, this.f316361n0, this.f316345m);
        } else {
            l(canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TabBarView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i3;
        int i16;
        int i17;
        int i18;
        this.f316355h0 = 16;
        this.f316356i0 = 16;
        this.f316357j0 = -16776961;
        this.f316358k0 = 25;
        this.f316359l0 = 9;
        this.f316360m0 = 15;
        this.f316363p0 = new Rect();
        this.f316342f = ViewUtils.dip2px(56.0f);
        this.J = 16;
        boolean isDefaultTheme = QQTheme.isDefaultTheme();
        int i19 = this.f316358k0;
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (!QQTheme.isNowSimpleUI()) {
            if (isNowThemeIsNight) {
                i16 = com.tencent.mobileqq.R.color.f157006hc;
                i17 = com.tencent.mobileqq.R.color.f157005hb;
                i18 = com.tencent.mobileqq.R.color.f157004ha;
                i3 = 30;
            } else if (isDefaultTheme) {
                i3 = i19;
                i16 = com.tencent.mobileqq.R.color.f157007hd;
                i17 = com.tencent.mobileqq.R.color.skin_gray2_theme_version2;
            } else {
                i16 = com.tencent.mobileqq.R.color.qui_button_bg_ghost_pressed;
                i17 = com.tencent.mobileqq.R.color.qui_common_text_primary;
                i18 = com.tencent.mobileqq.R.color.skin_black_theme_version2;
                i3 = i19;
            }
            this.C = getResources().getColor(i17);
            this.f316345m = getResources().getColor(i16);
            this.f316357j0 = getResources().getColor(i18);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.f316359l0 = (int) TypedValue.applyDimension(1, this.f316359l0, displayMetrics);
            this.f316360m0 = (int) TypedValue.applyDimension(1, this.f316360m0, displayMetrics);
            this.f316355h0 = (int) TypedValue.applyDimension(1, this.f316355h0, displayMetrics);
            this.f316356i0 = (int) TypedValue.applyDimension(1, this.f316356i0, displayMetrics);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f316354q0);
            this.f316357j0 = obtainStyledAttributes.getColor(jj2.b.f410264y7, this.f316357j0);
            this.f316358k0 = obtainStyledAttributes.getInt(jj2.b.f410253x7, this.f316358k0);
            this.f316355h0 = obtainStyledAttributes.getDimensionPixelSize(jj2.b.B7, this.f316355h0);
            this.f316356i0 = obtainStyledAttributes.getDimensionPixelSize(jj2.b.C7, this.f316356i0);
            this.f316359l0 = obtainStyledAttributes.getDimensionPixelSize(jj2.b.A7, this.f316359l0);
            this.f316360m0 = obtainStyledAttributes.getDimensionPixelSize(jj2.b.f410275z7, this.f316360m0);
            obtainStyledAttributes.recycle();
            if (!"1103".equals(QQTheme.getCurrentThemeId()) || QQTheme.isNowSimpleUI()) {
                this.f316357j0 = getResources().getColor(i18);
                this.f316358k0 = i3;
            }
            if (TokenResUtils.useTokenRes3()) {
                this.f316357j0 = getResources().getColor(com.tencent.mobileqq.R.color.qui_common_brand_standard);
                this.f316345m = getResources().getColor(com.tencent.mobileqq.R.color.qui_common_brand_standard);
                this.f316358k0 = 51;
            }
            y();
        }
        i17 = isNowThemeIsNight ? com.tencent.mobileqq.R.color.f158017al3 : com.tencent.mobileqq.R.color.black;
        i16 = com.tencent.mobileqq.R.color.skin_color_indicator;
        i3 = 255;
        i18 = i16;
        this.C = getResources().getColor(i17);
        this.f316345m = getResources().getColor(i16);
        this.f316357j0 = getResources().getColor(i18);
        DisplayMetrics displayMetrics2 = getResources().getDisplayMetrics();
        this.f316359l0 = (int) TypedValue.applyDimension(1, this.f316359l0, displayMetrics2);
        this.f316360m0 = (int) TypedValue.applyDimension(1, this.f316360m0, displayMetrics2);
        this.f316355h0 = (int) TypedValue.applyDimension(1, this.f316355h0, displayMetrics2);
        this.f316356i0 = (int) TypedValue.applyDimension(1, this.f316356i0, displayMetrics2);
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f316354q0);
        this.f316357j0 = obtainStyledAttributes2.getColor(jj2.b.f410264y7, this.f316357j0);
        this.f316358k0 = obtainStyledAttributes2.getInt(jj2.b.f410253x7, this.f316358k0);
        this.f316355h0 = obtainStyledAttributes2.getDimensionPixelSize(jj2.b.B7, this.f316355h0);
        this.f316356i0 = obtainStyledAttributes2.getDimensionPixelSize(jj2.b.C7, this.f316356i0);
        this.f316359l0 = obtainStyledAttributes2.getDimensionPixelSize(jj2.b.A7, this.f316359l0);
        this.f316360m0 = obtainStyledAttributes2.getDimensionPixelSize(jj2.b.f410275z7, this.f316360m0);
        obtainStyledAttributes2.recycle();
        if (!"1103".equals(QQTheme.getCurrentThemeId())) {
        }
        this.f316357j0 = getResources().getColor(i18);
        this.f316358k0 = i3;
        if (TokenResUtils.useTokenRes3()) {
        }
        y();
    }
}

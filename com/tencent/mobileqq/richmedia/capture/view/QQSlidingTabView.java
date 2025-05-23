package com.tencent.mobileqq.richmedia.capture.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class QQSlidingTabView extends HorizontalScrollView {
    private static final int[] U = {R.attr.textSize, R.attr.textColor};
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private Paint P;
    private int Q;
    private int R;
    private boolean S;
    private int T;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout.LayoutParams f281446d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f281447e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<View> f281448f;

    /* renamed from: h, reason: collision with root package name */
    private int f281449h;

    /* renamed from: i, reason: collision with root package name */
    private int f281450i;

    /* renamed from: m, reason: collision with root package name */
    private int f281451m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface a {
    }

    public QQSlidingTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f281446d = null;
        this.f281447e = null;
        this.f281448f = new ArrayList<>(5);
        this.f281449h = -7829368;
        this.f281450i = -16777216;
        this.f281451m = Color.parseColor("#E62555");
        this.C = 14;
        this.D = 0;
        this.E = 15;
        this.F = 5;
        this.G = 52;
        this.H = 0;
        this.I = 4;
        this.J = -16776961;
        this.K = 1;
        this.L = -3355444;
        this.M = 0;
        this.N = 0;
        this.P = null;
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.T = -1;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f281446d = new LinearLayout.LayoutParams(-2, -1);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f281447e = linearLayout;
        linearLayout.setOrientation(0);
        this.f281447e.setLayoutParams(this.f281446d);
        addView(this.f281447e);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.D = (int) TypedValue.applyDimension(1, this.D, displayMetrics);
        this.G = (int) TypedValue.applyDimension(1, this.G, displayMetrics);
        this.I = (int) TypedValue.applyDimension(1, this.I, displayMetrics);
        this.K = (int) TypedValue.applyDimension(1, this.K, displayMetrics);
        this.E = (int) TypedValue.applyDimension(1, this.E, displayMetrics);
        this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
        this.F = (int) TypedValue.applyDimension(1, this.F, displayMetrics);
        context.obtainStyledAttributes(attributeSet, U).recycle();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle);
        this.D = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabStartEndMargin, this.D);
        this.E = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabPadding, this.E);
        this.J = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabIndicatorColor, this.J);
        this.I = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabIndicatorHeight, this.I);
        this.f281449h = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabTextNormalColor, this.f281449h);
        this.f281450i = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabTextCheckedColor, this.f281450i);
        this.L = obtainStyledAttributes.getColor(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabUnderlineColor, this.L);
        this.K = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabUnderlineHeight, this.K);
        this.C = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabTextSize, this.C);
        this.F = obtainStyledAttributes.getDimensionPixelSize(com.tencent.mobileqq.R.styleable.QIMSlidingTabViewStyle_tabIndicatorPadding, this.F);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.P = paint;
        paint.setAntiAlias(true);
        this.P.setColor(this.J);
        this.P.setStyle(Paint.Style.FILL);
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        this.R = ScreenUtil.dip2px(this.Q);
    }

    private void b(int i3) {
        View childAt = this.f281447e.getChildAt(i3);
        if (childAt != null) {
            int scrollX = getScrollX();
            int i16 = this.E * 4;
            int right = ((childAt.getRight() - scrollX) - getWidth()) + i16;
            if (right > 0) {
                smoothScrollBy(right, 0);
                return;
            }
            int left = (childAt.getLeft() - scrollX) - i16;
            if (left < 0) {
                smoothScrollBy(left, 0);
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        super.onDraw(canvas);
        int height = getHeight();
        View childAt = this.f281447e.getChildAt(this.M);
        if (childAt != null) {
            if (this.S) {
                this.H = childAt.getLeft();
                b(this.M);
                this.S = false;
            }
            if (this.M == 0 && this.H < childAt.getLeft()) {
                this.H = childAt.getLeft();
            }
            if (this.T == this.M) {
                i3 = this.f281451m;
            } else {
                i3 = this.J;
            }
            this.P.setColor(i3);
            int i16 = this.H;
            RectF rectF = new RectF(this.F + i16, height - this.I, (i16 + childAt.getWidth()) - this.F, height);
            int i17 = this.R;
            canvas.drawRoundRect(rectF, i17, i17, this.P);
        }
    }

    public void setIndicateColor(int i3) {
        this.J = i3;
        this.P.setColor(i3);
        invalidate();
    }

    public QQSlidingTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f281446d = null;
        this.f281447e = null;
        this.f281448f = new ArrayList<>(5);
        this.f281449h = -7829368;
        this.f281450i = -16777216;
        this.f281451m = Color.parseColor("#E62555");
        this.C = 14;
        this.D = 0;
        this.E = 15;
        this.F = 5;
        this.G = 52;
        this.H = 0;
        this.I = 4;
        this.J = -16776961;
        this.K = 1;
        this.L = -3355444;
        this.M = 0;
        this.N = 0;
        this.P = null;
        this.Q = 0;
        this.R = 0;
        this.S = false;
        this.T = -1;
        a(context, attributeSet);
    }

    public void setTabCheckListener(a aVar) {
    }
}

package com.tencent.aelight.camera.aebase.view;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
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
import jj2.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQSlidingTabView extends HorizontalScrollView {
    private static final int[] S = {R.attr.textSize, R.attr.textColor};
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
    private Paint N;
    private int P;
    private int Q;
    private boolean R;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout.LayoutParams f66084d;

    /* renamed from: e, reason: collision with root package name */
    private LinearLayout f66085e;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<View> f66086f;

    /* renamed from: h, reason: collision with root package name */
    private int f66087h;

    /* renamed from: i, reason: collision with root package name */
    private int f66088i;

    /* renamed from: m, reason: collision with root package name */
    private int f66089m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface a {
    }

    public QQSlidingTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f66084d = null;
        this.f66085e = null;
        this.f66086f = new ArrayList<>(5);
        this.f66087h = -7829368;
        this.f66088i = -16777216;
        this.f66089m = 14;
        this.C = 0;
        this.D = 15;
        this.E = 5;
        this.F = 52;
        this.G = 0;
        this.H = 4;
        this.I = -16776961;
        this.J = 1;
        this.K = -3355444;
        this.L = 0;
        this.M = 0;
        this.N = null;
        this.P = 0;
        this.Q = 0;
        this.R = false;
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f66084d = new LinearLayout.LayoutParams(-2, -1);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f66085e = linearLayout;
        linearLayout.setOrientation(0);
        this.f66085e.setLayoutParams(this.f66084d);
        addView(this.f66085e);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.C = (int) TypedValue.applyDimension(1, this.C, displayMetrics);
        this.F = (int) TypedValue.applyDimension(1, this.F, displayMetrics);
        this.H = (int) TypedValue.applyDimension(1, this.H, displayMetrics);
        this.J = (int) TypedValue.applyDimension(1, this.J, displayMetrics);
        this.D = (int) TypedValue.applyDimension(1, this.D, displayMetrics);
        this.f66089m = (int) TypedValue.applyDimension(1, this.f66089m, displayMetrics);
        this.E = (int) TypedValue.applyDimension(1, this.E, displayMetrics);
        context.obtainStyledAttributes(attributeSet, S).recycle();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.I5);
        this.C = obtainStyledAttributes.getDimensionPixelSize(4, this.C);
        this.D = obtainStyledAttributes.getDimensionPixelSize(3, this.D);
        this.I = obtainStyledAttributes.getColor(0, this.I);
        this.H = obtainStyledAttributes.getDimensionPixelSize(1, this.H);
        this.f66087h = obtainStyledAttributes.getColor(6, this.f66087h);
        this.f66088i = obtainStyledAttributes.getColor(5, this.f66088i);
        this.K = obtainStyledAttributes.getColor(8, this.K);
        this.J = obtainStyledAttributes.getDimensionPixelSize(9, this.J);
        this.f66089m = obtainStyledAttributes.getDimensionPixelSize(7, this.f66089m);
        this.E = obtainStyledAttributes.getDimensionPixelSize(2, this.E);
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.N = paint;
        paint.setAntiAlias(true);
        this.N.setColor(this.I);
        this.N.setStyle(Paint.Style.FILL);
        setFillViewport(true);
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        this.Q = ScreenUtil.dip2px(this.P);
    }

    private void b(int i3) {
        View childAt = this.f66085e.getChildAt(i3);
        if (childAt != null) {
            int scrollX = getScrollX();
            int i16 = this.D * 4;
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
        super.onDraw(canvas);
        int height = getHeight();
        View childAt = this.f66085e.getChildAt(this.L);
        if (childAt != null) {
            if (this.R) {
                this.G = childAt.getLeft();
                b(this.L);
                this.R = false;
            }
            if (this.L == 0 && this.G < childAt.getLeft()) {
                this.G = childAt.getLeft();
            }
            int i3 = this.G;
            RectF rectF = new RectF(this.E + i3, height - this.H, (i3 + childAt.getWidth()) - this.E, height);
            int i16 = this.Q;
            canvas.drawRoundRect(rectF, i16, i16, this.N);
        }
    }

    public void setIndicateColor(int i3) {
        this.I = i3;
        this.N.setColor(i3);
        invalidate();
    }

    public QQSlidingTabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f66084d = null;
        this.f66085e = null;
        this.f66086f = new ArrayList<>(5);
        this.f66087h = -7829368;
        this.f66088i = -16777216;
        this.f66089m = 14;
        this.C = 0;
        this.D = 15;
        this.E = 5;
        this.F = 52;
        this.G = 0;
        this.H = 4;
        this.I = -16776961;
        this.J = 1;
        this.K = -3355444;
        this.L = 0;
        this.M = 0;
        this.N = null;
        this.P = 0;
        this.Q = 0;
        this.R = false;
        a(context, attributeSet);
    }

    public void setTabCheckListener(a aVar) {
    }
}

package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class HorizontalItemIndicator extends ViewGroup {
    private Paint C;
    private Scroller D;

    /* renamed from: d, reason: collision with root package name */
    private int f315708d;

    /* renamed from: e, reason: collision with root package name */
    private int f315709e;

    /* renamed from: f, reason: collision with root package name */
    private int f315710f;

    /* renamed from: h, reason: collision with root package name */
    private int f315711h;

    /* renamed from: i, reason: collision with root package name */
    private int f315712i;

    /* renamed from: m, reason: collision with root package name */
    private int f315713m;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    public HorizontalItemIndicator(Context context) {
        this(context, null);
    }

    private TextView a(int i3) {
        return (TextView) getChildAt(i3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int measuredWidth;
        if (this.D.computeScrollOffset()) {
            measuredWidth = this.D.getCurrX();
            Log.i("tmp", "currMid is " + measuredWidth);
            postInvalidate();
        } else {
            measuredWidth = (getChildAt(this.f315712i).getMeasuredWidth() / 2) + getChildAt(this.f315712i).getLeft();
            int i3 = this.f315713m;
            if (i3 != this.f315712i) {
                TextView a16 = a(i3);
                a16.setTextSize(0, this.f315709e);
                a16.setTextColor(this.f315708d);
            }
            TextView a17 = a(this.f315712i);
            a17.setTextSize(0, this.f315710f);
            a17.setTextColor(this.f315711h);
        }
        int measuredWidth2 = getMeasuredWidth() / 2;
        canvas.save();
        canvas.translate(measuredWidth2 - measuredWidth, 0.0f);
        super.dispatchDraw(canvas);
        canvas.restore();
        canvas.drawCircle(measuredWidth2, getChildAt(0).getBottom() + 8 + 6, 6.0f, this.C);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i26 = paddingLeft + marginLayoutParams.leftMargin;
            int paddingTop = getPaddingTop() + marginLayoutParams.topMargin;
            int i27 = measuredWidth + i26;
            childAt.layout(i26, paddingTop, i27, measuredHeight + paddingTop);
            paddingLeft = marginLayoutParams.rightMargin + i27;
        }
    }

    @Override // android.view.View
    @TargetApi(11)
    protected void onMeasure(int i3, int i16) {
        int childCount = getChildCount();
        measureChildren(i3, i16);
        int i17 = 0;
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i17 += marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + childAt.getMeasuredWidth();
                i18 = Math.max(i18, marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + childAt.getMeasuredHeight());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(Math.max(i17 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i3, 0), View.resolveSizeAndState(Math.max(i18 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i16, 0));
    }

    public void setCurrItem(int i3) {
        int i16;
        if (i3 >= 0 && i3 < getChildCount() && this.D.isFinished() && i3 != (i16 = this.f315712i)) {
            this.f315713m = i16;
            this.f315712i = i3;
            requestLayout();
        }
    }

    public void setNextItem() {
        int i3 = this.f315712i + 1;
        if (i3 >= getChildCount()) {
            return;
        }
        setCurrItem(i3);
    }

    public void setPrevItem() {
        int i3 = this.f315712i - 1;
        if (i3 < 0) {
            return;
        }
        setCurrItem(i3);
    }

    public HorizontalItemIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalItemIndicator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = new Paint();
        this.D = new Scroller(getContext());
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.HorizontalItemIndicator, i3, 0);
        try {
            this.f315708d = obtainStyledAttributes.getColor(R.styleable.HorizontalItemIndicator_itemTextColor, -1711276033);
            this.f315709e = obtainStyledAttributes.getDimensionPixelSize(R.styleable.HorizontalItemIndicator_itemTextSize, 28);
            this.f315711h = obtainStyledAttributes.getColor(R.styleable.HorizontalItemIndicator_itemCurrTextColor, -1);
            obtainStyledAttributes.recycle();
            this.f315710f = this.f315709e;
            this.C.setStyle(Paint.Style.FILL);
            this.C.setColor(-1);
            setWillNotDraw(false);
        } catch (Throwable th5) {
            obtainStyledAttributes.recycle();
            throw th5;
        }
    }

    public void setOnItemChanged(a aVar) {
    }
}

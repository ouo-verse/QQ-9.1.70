package com.tencent.av.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RotateLayout extends ViewGroup {
    private final float[] C;
    private boolean D;

    /* renamed from: d, reason: collision with root package name */
    private int f77219d;

    /* renamed from: e, reason: collision with root package name */
    private final Matrix f77220e;

    /* renamed from: f, reason: collision with root package name */
    private final Rect f77221f;

    /* renamed from: h, reason: collision with root package name */
    private final RectF f77222h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f77223i;

    /* renamed from: m, reason: collision with root package name */
    private final float[] f77224m;

    public RotateLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(-this.f77219d, getWidth() / 2.0f, getHeight() / 2.0f);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.f77224m[0] = motionEvent.getX();
        this.f77224m[1] = motionEvent.getY();
        this.f77220e.mapPoints(this.C, this.f77224m);
        float[] fArr = this.C;
        motionEvent.setLocation(fArr[0], fArr[1]);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        float[] fArr2 = this.f77224m;
        motionEvent.setLocation(fArr2[0], fArr2[1]);
        return dispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
        invalidate();
        return super.invalidateChildInParent(iArr, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        if (this.D || z16) {
            RectF rectF = this.f77222h;
            RectF rectF2 = this.f77223i;
            rectF.set(0.0f, 0.0f, i17 - i3, i18 - i16);
            this.f77220e.setRotate(this.f77219d, rectF.centerX(), rectF.centerY());
            this.f77220e.mapRect(rectF2, rectF);
            rectF2.round(this.f77221f);
            this.D = false;
        }
        View childAt = getChildAt(0);
        if (childAt != null) {
            Rect rect = this.f77221f;
            childAt.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        View childAt = getChildAt(0);
        if (childAt != null) {
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            int i17 = this.f77219d;
            int i18 = layoutParams.f77225a;
            if (i17 != i18) {
                this.f77219d = i18;
                this.D = true;
            }
            if (Math.abs(this.f77219d % 180) == 90) {
                measureChild(childAt, i16, i3);
                setMeasuredDimension(View.resolveSize(childAt.getMeasuredHeight(), i3), View.resolveSize(childAt.getMeasuredWidth(), i16));
                return;
            } else {
                measureChild(childAt, i3, i16);
                setMeasuredDimension(View.resolveSize(childAt.getMeasuredWidth(), i3), View.resolveSize(childAt.getMeasuredHeight(), i16));
                return;
            }
        }
        super.onMeasure(i3, i16);
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        this.D = true;
        super.setLayoutParams(layoutParams);
    }

    public RotateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f77220e = new Matrix();
        this.f77221f = new Rect();
        this.f77222h = new RectF();
        this.f77223i = new RectF();
        this.f77224m = new float[2];
        this.C = new float[2];
        this.D = true;
        setWillNotDraw(false);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public int f77225a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, az3.a.f27550u4);
            this.f77225a = obtainStyledAttributes.getInt(az3.a.f27557v4, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}

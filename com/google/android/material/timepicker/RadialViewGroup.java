package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import j1.e;

/* compiled from: P */
/* loaded from: classes2.dex */
class RadialViewGroup extends ConstraintLayout {

    /* renamed from: d, reason: collision with root package name */
    private final Runnable f34473d;

    /* renamed from: e, reason: collision with root package name */
    private int f34474e;

    /* renamed from: f, reason: collision with root package name */
    private MaterialShapeDrawable f34475f;

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static boolean C0(View view) {
        return "skip".equals(view.getTag());
    }

    private void E0() {
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.f34473d);
            handler.post(this.f34473d);
        }
    }

    private Drawable z0() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.f34475f = materialShapeDrawable;
        materialShapeDrawable.W(new e(0.5f));
        this.f34475f.Y(ColorStateList.valueOf(-1));
        return this.f34475f;
    }

    @Dimension
    public int A0() {
        return this.f34474e;
    }

    public void B0(@Dimension int i3) {
        this.f34474e = i3;
        D0();
    }

    protected void D0() {
        int childCount = getChildCount();
        int i3 = 1;
        for (int i16 = 0; i16 < childCount; i16++) {
            if (C0(getChildAt(i16))) {
                i3++;
            }
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        float f16 = 0.0f;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getId() != R.id.twu && !C0(childAt)) {
                constraintSet.constrainCircle(childAt.getId(), R.id.twu, this.f34474e, f16);
                f16 += 360.0f / (childCount - i3);
            }
        }
        constraintSet.applyTo(this);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i3, layoutParams);
        if (view.getId() == -1) {
            view.setId(ViewCompat.generateViewId());
        }
        E0();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        D0();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        E0();
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i3) {
        this.f34475f.Y(ColorStateList.valueOf(i3));
    }

    public RadialViewGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        LayoutInflater.from(context).inflate(R.layout.f168260fh1, this);
        ViewCompat.setBackground(this, z0());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w0.a.Y6, i3, 0);
        this.f34474e = obtainStyledAttributes.getDimensionPixelSize(w0.a.Z6, 0);
        this.f34473d = new Runnable() { // from class: com.google.android.material.timepicker.RadialViewGroup.1
            @Override // java.lang.Runnable
            public void run() {
                RadialViewGroup.this.D0();
            }
        };
        obtainStyledAttributes.recycle();
    }
}

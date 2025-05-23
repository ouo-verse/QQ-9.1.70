package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.o;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;
import g1.c;
import k1.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialDivider extends View {

    /* renamed from: m, reason: collision with root package name */
    private static final int f33616m = 2131953465;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private final MaterialShapeDrawable f33617d;

    /* renamed from: e, reason: collision with root package name */
    private int f33618e;

    /* renamed from: f, reason: collision with root package name */
    @ColorInt
    private int f33619f;

    /* renamed from: h, reason: collision with root package name */
    private int f33620h;

    /* renamed from: i, reason: collision with root package name */
    private int f33621i;

    public MaterialDivider(@NonNull Context context) {
        this(context, null);
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        int i3;
        int width;
        int i16;
        super.onDraw(canvas);
        boolean z16 = true;
        if (ViewCompat.getLayoutDirection(this) != 1) {
            z16 = false;
        }
        if (z16) {
            i3 = this.f33621i;
        } else {
            i3 = this.f33620h;
        }
        if (z16) {
            width = getWidth();
            i16 = this.f33620h;
        } else {
            width = getWidth();
            i16 = this.f33621i;
        }
        this.f33617d.setBounds(i3, 0, width - i16, getBottom() - getTop());
        this.f33617d.draw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int mode = View.MeasureSpec.getMode(i16);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i17 = this.f33618e;
            if (i17 > 0 && measuredHeight != i17) {
                measuredHeight = i17;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    public void setDividerColor(@ColorInt int i3) {
        if (this.f33619f != i3) {
            this.f33619f = i3;
            this.f33617d.Y(ColorStateList.valueOf(i3));
            invalidate();
        }
    }

    public void setDividerColorResource(@ColorRes int i3) {
        setDividerColor(ContextCompat.getColor(getContext(), i3));
    }

    public void setDividerInsetEnd(@Px int i3) {
        this.f33621i = i3;
    }

    public void setDividerInsetEndResource(@DimenRes int i3) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i3));
    }

    public void setDividerInsetStart(@Px int i3) {
        this.f33620h = i3;
    }

    public void setDividerInsetStartResource(@DimenRes int i3) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i3));
    }

    public void setDividerThickness(@Px int i3) {
        if (this.f33618e != i3) {
            this.f33618e = i3;
            requestLayout();
        }
    }

    public void setDividerThicknessResource(@DimenRes int i3) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i3));
    }

    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.av8);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialDivider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = f33616m;
        Context context2 = getContext();
        this.f33617d = new MaterialShapeDrawable();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.f443814a5, i3, i16, new int[0]);
        this.f33618e = h16.getDimensionPixelSize(w0.a.f443862e5, getResources().getDimensionPixelSize(R.dimen.f159135cp4));
        this.f33620h = h16.getDimensionPixelOffset(w0.a.f443850d5, 0);
        this.f33621i = h16.getDimensionPixelOffset(w0.a.f443838c5, 0);
        setDividerColor(c.a(context2, h16, w0.a.f443826b5).getDefaultColor());
        h16.recycle();
    }
}

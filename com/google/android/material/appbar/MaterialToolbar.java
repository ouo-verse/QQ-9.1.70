package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.o;
import com.google.android.material.internal.p;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MaterialToolbar extends Toolbar {
    private static final ImageView.ScaleType[] C = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    /* renamed from: m, reason: collision with root package name */
    private static final int f33237m = 2131953508;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private Integer f33238d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f33239e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f33240f;

    /* renamed from: h, reason: collision with root package name */
    @Nullable
    private ImageView.ScaleType f33241h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    private Boolean f33242i;

    public MaterialToolbar(@NonNull Context context) {
        this(context, null);
    }

    private Pair<Integer, Integer> a(@Nullable TextView textView, @Nullable TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i3 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i16 = 0; i16 < getChildCount(); i16++) {
            View childAt = getChildAt(i16);
            if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                if (childAt.getRight() < i3 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i3 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void b(Context context) {
        int i3;
        Drawable background = getBackground();
        if (background != null && !(background instanceof ColorDrawable)) {
            return;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        if (background != null) {
            i3 = ((ColorDrawable) background).getColor();
        } else {
            i3 = 0;
        }
        materialShapeDrawable.Y(ColorStateList.valueOf(i3));
        materialShapeDrawable.N(context);
        materialShapeDrawable.X(ViewCompat.getElevation(this));
        ViewCompat.setBackground(this, materialShapeDrawable);
    }

    private void c(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i3 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i16 = measuredWidth2 + i3;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i3, 0), Math.max(i16 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i3 += max;
            i16 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i16 - i3, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i3, view.getTop(), i16, view.getBottom());
    }

    private void d() {
        if (!this.f33239e && !this.f33240f) {
            return;
        }
        TextView g16 = p.g(this);
        TextView e16 = p.e(this);
        if (g16 == null && e16 == null) {
            return;
        }
        Pair<Integer, Integer> a16 = a(g16, e16);
        if (this.f33239e && g16 != null) {
            c(g16, a16);
        }
        if (this.f33240f && e16 != null) {
            c(e16, a16);
        }
    }

    @Nullable
    private Drawable e(@Nullable Drawable drawable) {
        if (drawable != null && this.f33238d != null) {
            Drawable wrap = DrawableCompat.wrap(drawable.mutate());
            DrawableCompat.setTint(wrap, this.f33238d.intValue());
            return wrap;
        }
        return drawable;
    }

    private void f() {
        ImageView d16 = p.d(this);
        if (d16 != null) {
            Boolean bool = this.f33242i;
            if (bool != null) {
                d16.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.f33241h;
            if (scaleType != null) {
                d16.setScaleType(scaleType);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.google.android.material.shape.d.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        d();
        f();
    }

    @Override // android.view.View
    @RequiresApi(21)
    public void setElevation(float f16) {
        super.setElevation(f16);
        com.google.android.material.shape.d.d(this, f16);
    }

    public void setLogoAdjustViewBounds(boolean z16) {
        Boolean bool = this.f33242i;
        if (bool == null || bool.booleanValue() != z16) {
            this.f33242i = Boolean.valueOf(z16);
            requestLayout();
        }
    }

    public void setLogoScaleType(@NonNull ImageView.ScaleType scaleType) {
        if (this.f33241h != scaleType) {
            this.f33241h = scaleType;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        super.setNavigationIcon(e(drawable));
    }

    public void setNavigationIconTint(@ColorInt int i3) {
        this.f33238d = Integer.valueOf(i3);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z16) {
        if (this.f33240f != z16) {
            this.f33240f = z16;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z16) {
        if (this.f33239e != z16) {
            this.f33239e = z16;
            requestLayout();
        }
    }

    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bj9);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialToolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(k1.a.c(context, attributeSet, i3, r4), attributeSet, i3);
        int i16 = f33237m;
        Context context2 = getContext();
        TypedArray h16 = o.h(context2, attributeSet, w0.a.f444059v5, i3, i16, new int[0]);
        int i17 = w0.a.f444094y5;
        if (h16.hasValue(i17)) {
            setNavigationIconTint(h16.getColor(i17, -1));
        }
        this.f33239e = h16.getBoolean(w0.a.A5, false);
        this.f33240f = h16.getBoolean(w0.a.f444106z5, false);
        int i18 = h16.getInt(w0.a.f444082x5, -1);
        if (i18 >= 0) {
            ImageView.ScaleType[] scaleTypeArr = C;
            if (i18 < scaleTypeArr.length) {
                this.f33241h = scaleTypeArr[i18];
            }
        }
        int i19 = w0.a.f444070w5;
        if (h16.hasValue(i19)) {
            this.f33242i = Boolean.valueOf(h16.getBoolean(i19, false));
        }
        h16.recycle();
        b(context2);
    }
}

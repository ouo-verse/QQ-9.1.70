package com.google.android.material.navigationrail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.o;
import com.google.android.material.navigation.NavigationBarView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class NavigationRailView extends NavigationBarView {
    private final int C;

    @Nullable
    private View D;

    @Nullable
    private Boolean E;

    @Nullable
    private Boolean F;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements ViewUtils.d {
        a() {
        }

        @Override // com.google.android.material.internal.ViewUtils.d
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils.e eVar) {
            NavigationRailView navigationRailView = NavigationRailView.this;
            if (navigationRailView.v(navigationRailView.E)) {
                eVar.f33793b += windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).top;
            }
            NavigationRailView navigationRailView2 = NavigationRailView.this;
            if (navigationRailView2.v(navigationRailView2.F)) {
                eVar.f33795d += windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            }
            boolean z16 = true;
            if (ViewCompat.getLayoutDirection(view) != 1) {
                z16 = false;
            }
            int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
            int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
            int i3 = eVar.f33792a;
            if (z16) {
                systemWindowInsetLeft = systemWindowInsetRight;
            }
            eVar.f33792a = i3 + systemWindowInsetLeft;
            eVar.a(view);
            return windowInsetsCompat;
        }
    }

    public NavigationRailView(@NonNull Context context) {
        this(context, null);
    }

    private void p() {
        ViewUtils.b(this, new a());
    }

    private NavigationRailMenuView r() {
        return (NavigationRailMenuView) h();
    }

    private boolean s() {
        View view = this.D;
        if (view != null && view.getVisibility() != 8) {
            return true;
        }
        return false;
    }

    private int t(int i3) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i3) != 1073741824 && suggestedMinimumWidth > 0) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), 1073741824);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v(Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        return ViewCompat.getFitsSystemWindows(this);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int e() {
        return 7;
    }

    public void n(@LayoutRes int i3) {
        o(LayoutInflater.from(getContext()).inflate(i3, (ViewGroup) this, false));
    }

    public void o(@NonNull View view) {
        u();
        this.D = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.topMargin = this.C;
        addView(view, 0, layoutParams);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        NavigationRailMenuView r16 = r();
        int i19 = 0;
        if (s()) {
            int bottom = this.D.getBottom() + this.C;
            int top = r16.getTop();
            if (top < bottom) {
                i19 = bottom - top;
            }
        } else if (r16.v()) {
            i19 = this.C;
        }
        if (i19 > 0) {
            r16.layout(r16.getLeft(), r16.getTop() + i19, r16.getRight(), r16.getBottom() + i19);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        int t16 = t(i3);
        super.onMeasure(t16, i16);
        if (s()) {
            measureChild(r(), t16, View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - this.D.getMeasuredHeight()) - this.C, Integer.MIN_VALUE));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.navigation.NavigationBarView
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public NavigationRailMenuView d(@NonNull Context context) {
        return new NavigationRailMenuView(context);
    }

    public void setItemMinimumHeight(@Px int i3) {
        ((NavigationRailMenuView) h()).setItemMinimumHeight(i3);
    }

    public void setMenuGravity(int i3) {
        r().A(i3);
    }

    public void u() {
        View view = this.D;
        if (view != null) {
            removeView(view);
            this.D = null;
        }
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ay_);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, R.style.f173848as0);
    }

    public NavigationRailView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.E = null;
        this.F = null;
        this.C = getResources().getDimensionPixelSize(R.dimen.cuy);
        TintTypedArray i17 = o.i(getContext(), attributeSet, w0.a.f443875f6, i3, i16, new int[0]);
        int resourceId = i17.getResourceId(w0.a.f443887g6, 0);
        if (resourceId != 0) {
            n(resourceId);
        }
        setMenuGravity(i17.getInt(w0.a.f443910i6, 49));
        int i18 = w0.a.f443899h6;
        if (i17.hasValue(i18)) {
            setItemMinimumHeight(i17.getDimensionPixelSize(i18, -1));
        }
        int i19 = w0.a.f443932k6;
        if (i17.hasValue(i19)) {
            this.E = Boolean.valueOf(i17.getBoolean(i19, false));
        }
        int i26 = w0.a.f443921j6;
        if (i17.hasValue(i26)) {
            this.F = Boolean.valueOf(i17.getBoolean(i26, false));
        }
        i17.recycle();
        p();
    }
}

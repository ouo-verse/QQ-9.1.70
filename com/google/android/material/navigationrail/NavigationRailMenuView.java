package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {

    /* renamed from: e0, reason: collision with root package name */
    @Px
    private int f33933e0;

    /* renamed from: f0, reason: collision with root package name */
    private final FrameLayout.LayoutParams f33934f0;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        this.f33933e0 = -1;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.f33934f0 = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
        s(true);
    }

    private int w(int i3, int i16, int i17) {
        int max = i16 / Math.max(1, i17);
        int i18 = this.f33933e0;
        if (i18 == -1) {
            i18 = View.MeasureSpec.getSize(i3);
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(i18, max), 0);
    }

    private int x(View view, int i3, int i16) {
        if (view.getVisibility() != 8) {
            view.measure(i3, i16);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int y(int i3, int i16, int i17, View view) {
        int makeMeasureSpec;
        w(i3, i16, i17);
        if (view == null) {
            makeMeasureSpec = w(i3, i16, i17);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt != view) {
                i18 += x(childAt, i3, makeMeasureSpec);
            }
        }
        return i18;
    }

    private int z(int i3, int i16, int i17) {
        int i18;
        View childAt = getChildAt(m());
        if (childAt != null) {
            i18 = x(childAt, i3, w(i3, i16, i17));
            i16 -= i18;
            i17--;
        } else {
            i18 = 0;
        }
        return i18 + y(i3, i16, i17, childAt);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i3) {
        FrameLayout.LayoutParams layoutParams = this.f33934f0;
        if (layoutParams.gravity != i3) {
            layoutParams.gravity = i3;
            setLayoutParams(layoutParams);
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView f(@NonNull Context context) {
        return new a(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int i19 = i17 - i3;
        int i26 = 0;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt = getChildAt(i27);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i26;
                childAt.layout(0, i26, i19, measuredHeight);
                i26 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int y16;
        int size = View.MeasureSpec.getSize(i16);
        int size2 = j().getVisibleItems().size();
        if (size2 > 1 && n(i(), size2)) {
            y16 = z(i3, size, size2);
        } else {
            y16 = y(i3, size, size2, null);
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i3), i3, 0), View.resolveSizeAndState(y16, i16, 0));
    }

    public void setItemMinimumHeight(@Px int i3) {
        if (this.f33933e0 != i3) {
            this.f33933e0 = i3;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        if ((this.f33934f0.gravity & 112) == 48) {
            return true;
        }
        return false;
    }
}

package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {

    /* renamed from: e0, reason: collision with root package name */
    private final int f33334e0;

    /* renamed from: f0, reason: collision with root package name */
    private final int f33335f0;

    /* renamed from: g0, reason: collision with root package name */
    private final int f33336g0;

    /* renamed from: h0, reason: collision with root package name */
    private final int f33337h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f33338i0;

    /* renamed from: j0, reason: collision with root package name */
    private int[] f33339j0;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.f33334e0 = resources.getDimensionPixelSize(R.dimen.c8a);
        this.f33335f0 = resources.getDimensionPixelSize(R.dimen.c8b);
        this.f33336g0 = resources.getDimensionPixelSize(R.dimen.c85);
        this.f33337h0 = resources.getDimensionPixelSize(R.dimen.c86);
        this.f33339j0 = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    protected NavigationBarItemView f(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        int childCount = getChildCount();
        int i19 = i17 - i3;
        int i26 = i18 - i16;
        int i27 = 0;
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt = getChildAt(i28);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i29 = i19 - i27;
                    childAt.layout(i29 - childAt.getMeasuredWidth(), 0, i29, i26);
                } else {
                    childAt.layout(i27, 0, childAt.getMeasuredWidth() + i27, i26);
                }
                i27 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        int i17;
        int i18;
        int i19;
        MenuBuilder j3 = j();
        int size = View.MeasureSpec.getSize(i3);
        int size2 = j3.getVisibleItems().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i16);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        int i26 = 1;
        if (n(i(), size2) && v()) {
            View childAt = getChildAt(m());
            int i27 = this.f33337h0;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f33336g0, Integer.MIN_VALUE), makeMeasureSpec);
                i27 = Math.max(i27, childAt.getMeasuredWidth());
            }
            if (childAt.getVisibility() != 8) {
                i17 = 1;
            } else {
                i17 = 0;
            }
            int i28 = size2 - i17;
            int min = Math.min(size - (this.f33335f0 * i28), Math.min(i27, this.f33336g0));
            int i29 = size - min;
            if (i28 == 0) {
                i18 = 1;
            } else {
                i18 = i28;
            }
            int min2 = Math.min(i29 / i18, this.f33334e0);
            int i36 = i29 - (i28 * min2);
            for (int i37 = 0; i37 < childCount; i37++) {
                if (getChildAt(i37).getVisibility() != 8) {
                    int[] iArr = this.f33339j0;
                    if (i37 == m()) {
                        i19 = min;
                    } else {
                        i19 = min2;
                    }
                    iArr[i37] = i19;
                    if (i36 > 0) {
                        int[] iArr2 = this.f33339j0;
                        iArr2[i37] = iArr2[i37] + 1;
                        i36--;
                    }
                } else {
                    this.f33339j0[i37] = 0;
                }
            }
        } else {
            if (size2 != 0) {
                i26 = size2;
            }
            int min3 = Math.min(size / i26, this.f33336g0);
            int i38 = size - (size2 * min3);
            for (int i39 = 0; i39 < childCount; i39++) {
                if (getChildAt(i39).getVisibility() != 8) {
                    int[] iArr3 = this.f33339j0;
                    iArr3[i39] = min3;
                    if (i38 > 0) {
                        iArr3[i39] = min3 + 1;
                        i38--;
                    }
                } else {
                    this.f33339j0[i39] = 0;
                }
            }
        }
        int i46 = 0;
        for (int i47 = 0; i47 < childCount; i47++) {
            View childAt2 = getChildAt(i47);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.f33339j0[i47], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i46 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i46, View.MeasureSpec.makeMeasureSpec(i46, 1073741824), 0), View.resolveSizeAndState(size3, i16, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z16) {
        this.f33338i0 = z16;
    }

    public boolean v() {
        return this.f33338i0;
    }
}

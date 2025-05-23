package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import androidx.annotation.DimenRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.tencent.mobileqq.R;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
final class a extends NavigationBarItemView {
    public a(@NonNull Context context) {
        super(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @DimenRes
    protected int j() {
        return R.dimen.cuw;
    }

    @Override // com.google.android.material.navigation.NavigationBarItemView
    @LayoutRes
    protected int k() {
        return R.layout.fls;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (View.MeasureSpec.getMode(i16) == 0) {
            setMeasuredDimension(getMeasuredWidthAndState(), View.resolveSizeAndState(Math.max(getMeasuredHeight(), View.MeasureSpec.getSize(i16)), i16, 0));
        }
    }
}

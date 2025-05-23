package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hp.a;

/* loaded from: classes9.dex */
public final class AppBrandCapsuleBarPlaceHolderView extends View implements a {

    /* renamed from: a, reason: collision with root package name */
    public int f152236a;

    /* renamed from: b, reason: collision with root package name */
    public int f152237b;

    public AppBrandCapsuleBarPlaceHolderView(Context context) {
        super(context);
        this.f152236a = -1;
        this.f152237b = -1;
    }

    @Override // com.tencent.luggage.wxa.hp.a
    public boolean a(Canvas canvas) {
        return true;
    }

    @Override // android.view.View
    public void onMeasure(int i3, int i16) {
        if (getVisibility() == 0) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.max(this.f152236a, 0), 1073741824), View.MeasureSpec.makeMeasureSpec(Math.max(this.f152237b, 0), 1073741824));
        } else {
            super.onMeasure(i3, i16);
        }
    }

    public void setFixedHeight(@Dimension(unit = 1) int i3) {
        int max = Math.max(i3, 0);
        if (max != this.f152237b) {
            this.f152237b = max;
            if (max != getMeasuredHeight()) {
                requestLayout();
            }
        }
    }

    public void setFixedWidth(@Dimension(unit = 1) int i3) {
        int max = Math.max(i3, 0);
        if (max != this.f152236a) {
            this.f152236a = max;
            if (max != getMeasuredWidth()) {
                requestLayout();
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean z16;
        if (getLayoutParams() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        super.setLayoutParams(layoutParams);
        if (z16) {
            this.f152236a = Math.max(0, layoutParams.width);
            this.f152237b = Math.max(0, layoutParams.height);
        }
    }

    public AppBrandCapsuleBarPlaceHolderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f152236a = -1;
        this.f152237b = -1;
    }

    public AppBrandCapsuleBarPlaceHolderView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152236a = -1;
        this.f152237b = -1;
    }

    @TargetApi(21)
    public AppBrandCapsuleBarPlaceHolderView(Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        this.f152236a = -1;
        this.f152237b = -1;
    }
}

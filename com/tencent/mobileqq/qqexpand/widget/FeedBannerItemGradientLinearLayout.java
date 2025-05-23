package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/* compiled from: P */
/* loaded from: classes35.dex */
public class FeedBannerItemGradientLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name */
    private View f264154d;

    /* renamed from: e, reason: collision with root package name */
    private View f264155e;

    public FeedBannerItemGradientLinearLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f264154d = new View(getContext());
        this.f264155e = new View(getContext());
        setOrientation(1);
        addView(this.f264154d, new LinearLayout.LayoutParams(-1, -2));
        addView(this.f264155e, new LinearLayout.LayoutParams(-1, -1));
    }

    public void b(int i3, int i16, int i17) {
        this.f264154d.getLayoutParams().height = i3;
        this.f264154d.setBackgroundColor(i16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{i16, i17});
        this.f264155e.setBackgroundDrawable(gradientDrawable);
    }

    public FeedBannerItemGradientLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FeedBannerItemGradientLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}

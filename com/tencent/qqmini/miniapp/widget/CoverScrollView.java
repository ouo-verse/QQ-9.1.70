package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;

/* compiled from: P */
/* loaded from: classes23.dex */
public class CoverScrollView extends CoverView {
    private FrameLayout container;
    private ScrollView scrollView;

    public CoverScrollView(@NonNull Context context) {
        super(context);
        this.scrollView = new ScrollView(context);
        FrameLayout frameLayout = new FrameLayout(context);
        this.container = frameLayout;
        this.scrollView.addView(frameLayout);
        addView(this.scrollView, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        this.container.addView(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        this.container.removeView(view);
    }

    public void setBorder(int i3, int i16, float f16, int i17) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i17);
        gradientDrawable.setCornerRadius(f16 * DisplayUtil.getDensity(getContext()));
        if (i3 > 0) {
            gradientDrawable.setStroke(i3, i16);
        }
        this.scrollView.setBackgroundDrawable(gradientDrawable);
    }

    public void setContainerSize(int i3, int i16) {
        if (this.container != null) {
            this.container.setLayoutParams(new FrameLayout.LayoutParams(i3, i16));
        }
    }

    public void setScrollTop(int i3) {
        this.scrollView.setScrollY(i3);
    }
}

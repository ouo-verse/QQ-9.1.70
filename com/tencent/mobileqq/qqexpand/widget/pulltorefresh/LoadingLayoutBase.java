package com.tencent.mobileqq.qqexpand.widget.pulltorefresh;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class LoadingLayoutBase extends FrameLayout implements a {
    public LoadingLayoutBase(Context context) {
        super(context);
    }

    public abstract void a();

    public abstract void b();

    public abstract void d();

    public abstract int e();

    public abstract void f(float f16);

    public abstract void g();

    public final void setHeight(int i3) {
        getLayoutParams().height = i3;
        requestLayout();
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public abstract /* synthetic */ void setPullLabel(CharSequence charSequence);

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public abstract /* synthetic */ void setRefreshingLabel(CharSequence charSequence);

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public abstract /* synthetic */ void setReleaseLabel(CharSequence charSequence);

    public final void setWidth(int i3) {
        getLayoutParams().width = i3;
        requestLayout();
    }

    public LoadingLayoutBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LoadingLayoutBase(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setLastUpdatedLabel(CharSequence charSequence) {
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setLoadingDrawable(Drawable drawable) {
    }

    @Override // com.tencent.mobileqq.qqexpand.widget.pulltorefresh.a
    public void setRefreshResultLabel(CharSequence charSequence) {
    }

    public void setTextTypeface(Typeface typeface) {
    }
}

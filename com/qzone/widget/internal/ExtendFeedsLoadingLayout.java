package com.qzone.widget.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.PullToRefreshBase;
import com.tencent.mobileqq.qqexpand.widget.pulltorefresh.internal.FlipLoadingLayout;
import cooperation.qzone.util.QZLog;
import ep.a;

/* compiled from: P */
/* loaded from: classes37.dex */
public class ExtendFeedsLoadingLayout extends FlipLoadingLayout implements a {
    public ExtendFeedsLoadingLayout(Context context, PullToRefreshBase.Mode mode, PullToRefreshBase.Orientation orientation, TypedArray typedArray) {
        super(context, mode, orientation, typedArray);
    }

    @Override // ep.a
    public void c(int i3, String str) {
        if (QZLog.isColorLevel()) {
            QZLog.i("ExtendFeedsLoadingLayout", 2, "showResult: " + str);
        }
        super.setRefreshResultLabel(str);
        super.g();
    }

    public void setPullLabel(String str) {
        super.setPullLabel((CharSequence) str);
    }

    public void setRefreshingLabel(String str) {
        if (QZLog.isColorLevel()) {
            QZLog.i("ExtendFeedsLoadingLayout", 2, "setRefreshingLabel: " + str);
        }
        super.setRefreshingLabel((CharSequence) str);
    }

    public void setReleaseLabel(String str) {
        if (QZLog.isColorLevel()) {
            QZLog.i("ExtendFeedsLoadingLayout", 2, "setReleaseLabel: " + str);
        }
        super.setReleaseLabel((CharSequence) str);
    }

    @Override // ep.a
    public void setSubHeaderText(CharSequence charSequence) {
        if (QZLog.isColorLevel()) {
            QZLog.i("ExtendFeedsLoadingLayout", 2, "setSubHeaderText: " + ((Object) charSequence));
        }
        super.setLastUpdatedLabel(charSequence);
    }

    public void setSubTextColor(int i3) {
    }

    @Override // ep.a
    public void setTextColor(int i3) {
    }

    public void setSubTextColor(ColorStateList colorStateList) {
    }

    public void setTextColor(ColorStateList colorStateList) {
    }

    @Override // ep.a
    public View getView() {
        return this;
    }

    public void setBackgroundAlpha(int i3) {
    }

    public void setDividerVisible(boolean z16) {
    }

    @Override // ep.a
    public void setHeaderLayoutBackgroundColor(int i3) {
    }

    @Override // ep.a
    public void setLoadingBackgroundColor(int i3) {
    }

    @Override // ep.a
    public void setNotAdaptNightMode(boolean z16) {
    }

    public void setPullAnimationEnabled(boolean z16) {
    }

    public void setPullDrawable(Drawable drawable) {
    }

    public void setReleaseDrawable(Drawable drawable) {
    }

    public void setSubTextSize(float f16) {
    }

    public void setTextSize(float f16) {
    }

    public void setViewHeight(int i3) {
    }
}

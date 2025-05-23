package com.tencent.mobileqq.mini.profilecard;

import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import java.util.List;

/* loaded from: classes15.dex */
public abstract class BaseMiniAppProfileCardView extends LinearLayout {
    public BaseMiniAppProfileCardView(Context context) {
        super(context);
    }

    public abstract View getListView();

    public abstract void setData(List<INTERFACE$StApiAppInfo> list);

    public abstract void setProfileType(boolean z16);

    public abstract void setTextColor(int i3);

    public abstract void setTextColor(ColorStateList colorStateList);

    public BaseMiniAppProfileCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseMiniAppProfileCardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

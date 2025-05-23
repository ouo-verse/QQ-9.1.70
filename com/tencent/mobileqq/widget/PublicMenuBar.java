package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.ui.CustomMenuBar;

/* loaded from: classes20.dex */
public class PublicMenuBar extends CustomMenuBar {
    public PublicMenuBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setSwitchButtonVisibility(boolean z16) {
        if (z16) {
            this.f96962d.setVisibility(0);
        } else {
            this.f96962d.setVisibility(8);
        }
    }
}

package com.tencent.mobileqq.icgame.base.room.multipage.controller;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;

/* loaded from: classes15.dex */
public class MultiPageViewPager extends VerticalViewPager {
    private boolean I0;

    public MultiPageViewPager(Context context) {
        super(context);
        this.I0 = false;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        int i3 = configuration.orientation;
        if (i3 == 2) {
            this.I0 = true;
        } else if (i3 == 1) {
            this.I0 = false;
        }
        setScrollForbidden(this.I0);
        super.onConfigurationChanged(configuration);
        com.tencent.mobileqq.icgame.base.room.multipage.api.a aVar = (com.tencent.mobileqq.icgame.base.room.multipage.api.a) ((c) q()).e();
        if (aVar != null) {
            aVar.onOrientationChange(this.I0);
        }
    }

    @Override // com.tencent.mobileqq.icgame.base.room.multipage.controller.VerticalViewPager
    public void setCurrentItem(int i3) {
        if (this.f237180d) {
            return;
        }
        super.setCurrentItem(i3);
    }

    public MultiPageViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I0 = false;
    }
}

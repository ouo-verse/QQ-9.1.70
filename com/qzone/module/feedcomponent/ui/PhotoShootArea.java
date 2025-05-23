package com.qzone.module.feedcomponent.ui;

import android.graphics.drawable.Drawable;

/* loaded from: classes39.dex */
public class PhotoShootArea extends ColorFeedTextAreaEx {
    public PhotoShootArea(int i3) {
        super(i3);
    }

    @Override // com.qzone.module.feedcomponent.ui.FeedTextAreaEx
    public void setData(String str, int i3, Drawable drawable) {
        this.mLeftDrawable = drawable;
        if (drawable != null) {
            int i16 = AreaConst.dp15;
            int i17 = AreaConst.dp3_5;
            drawable.setBounds(0, i17, i16, i16 + i17);
        }
        super.setData(str, i3);
    }
}

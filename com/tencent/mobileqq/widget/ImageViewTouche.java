package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ImageViewTouche extends ImageViewTouchBase {
    private boolean mEnableTrackballScroll;
    private Bitmap region;
    private boolean showRegion;

    public ImageViewTouche(Context context) {
        super(context);
    }

    public void postTranslateCenter(float f16, float f17) {
        super.postTranslate(f16, f17);
        center(true, true);
    }

    public void setEnableTrackballScroll(boolean z16) {
        this.mEnableTrackballScroll = z16;
    }

    public ImageViewTouche(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}

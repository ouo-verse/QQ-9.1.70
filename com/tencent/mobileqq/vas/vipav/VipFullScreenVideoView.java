package com.tencent.mobileqq.vas.vipav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.VideoView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VipFullScreenVideoView extends VideoView {
    public VipFullScreenVideoView(Context context) {
        super(context);
    }

    @Override // android.widget.VideoView, android.view.SurfaceView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getHolder() != null && getHolder().getSurfaceFrame() != null) {
            int width = getHolder().getSurfaceFrame().width();
            int height = getHolder().getSurfaceFrame().height();
            if (width > 0 && height > 0 && getHeight() > 0 && getWidth() > 0) {
                float f16 = height / width;
                int defaultSize = View.getDefaultSize(getResources().getDisplayMetrics().widthPixels, i3);
                int defaultSize2 = View.getDefaultSize(getResources().getDisplayMetrics().heightPixels, i16);
                float f17 = defaultSize2;
                float f18 = defaultSize;
                if (f16 < f17 / f18) {
                    defaultSize = (int) (f17 / f16);
                } else {
                    defaultSize2 = (int) (f18 * f16);
                }
                setMeasuredDimension(defaultSize, defaultSize2);
            }
        }
    }

    public VipFullScreenVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VipFullScreenVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}

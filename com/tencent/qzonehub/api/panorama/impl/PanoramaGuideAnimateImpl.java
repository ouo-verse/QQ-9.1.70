package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.widget.LinearLayout;
import com.tencent.qzonehub.api.panorama.IPanoramaGuideAnimate;
import com.tencent.qzonehub.api.panorama.OnAnimateListener;
import cooperation.qzone.panorama.widget.PanoramaGuideAnimate;

/* loaded from: classes34.dex */
public class PanoramaGuideAnimateImpl implements IPanoramaGuideAnimate {
    @Override // com.tencent.qzonehub.api.panorama.IPanoramaGuideAnimate
    public void addView(LinearLayout linearLayout, int i3) {
        ((PanoramaGuideAnimate) linearLayout).addView(i3);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaGuideAnimate
    public LinearLayout getPanoramaGuideAnimate(Context context) {
        return new PanoramaGuideAnimate(context);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaGuideAnimate
    public void setOnAnimateListener(LinearLayout linearLayout, OnAnimateListener onAnimateListener) {
        ((PanoramaGuideAnimate) linearLayout).setOnAnimateListener(onAnimateListener);
    }
}

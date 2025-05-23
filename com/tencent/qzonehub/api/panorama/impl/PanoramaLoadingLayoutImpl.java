package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.widget.RelativeLayout;
import com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout;
import cooperation.qzone.panorama.widget.PanoramaLoadingLayout;

/* loaded from: classes34.dex */
public class PanoramaLoadingLayoutImpl implements IPanoramaLoadingLayout {
    @Override // com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
    public RelativeLayout getPanoramaLoadingLayout(Context context) {
        return new PanoramaLoadingLayout(context);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
    public boolean isPanoramaLoading() {
        return PanoramaLoadingLayout.isPanoramaLoading;
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
    public void onRecycled(RelativeLayout relativeLayout) {
        ((PanoramaLoadingLayout) relativeLayout).onRecycled();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
    public void setPanoramaLoading(boolean z16) {
        PanoramaLoadingLayout.isPanoramaLoading = z16;
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
    public void showLoading(RelativeLayout relativeLayout, boolean z16, boolean z17) {
        ((PanoramaLoadingLayout) relativeLayout).showLoading(z16, z17);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
    public void startRotateAnimate(RelativeLayout relativeLayout) {
        ((PanoramaLoadingLayout) relativeLayout).startRotateAnimate();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaLoadingLayout
    public void stopRotateAnimate(RelativeLayout relativeLayout) {
        ((PanoramaLoadingLayout) relativeLayout).stopRotateAnimate();
    }
}

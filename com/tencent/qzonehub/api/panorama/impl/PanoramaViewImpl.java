package com.tencent.qzonehub.api.panorama.impl;

import android.content.Context;
import android.view.TextureView;
import com.tencent.qzonehub.api.panorama.IPanoramaView;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.util.PanoramaConfig;
import cooperation.qzone.panorama.widget.PanoramaView;

/* loaded from: classes34.dex */
public class PanoramaViewImpl implements IPanoramaView {
    @Override // com.tencent.qzonehub.api.panorama.IPanoramaView
    public void changeRenderMode(TextureView textureView, int i3) {
        ((PanoramaView) textureView).changeRenderMode(i3);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaView
    public void changeRotate(TextureView textureView, float f16, float f17) {
        ((PanoramaView) textureView).changeRotate(f16, f17);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaView
    public TextureView getPanoramaView(Context context) {
        return new PanoramaView(context);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaView
    public void onRecycled(TextureView textureView) {
        ((PanoramaView) textureView).onRecycled();
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaView
    public void setOnPanoramaClickListener(TextureView textureView, OnPanoramaClickListener onPanoramaClickListener) {
        ((PanoramaView) textureView).setOnPanoramaClickListener(onPanoramaClickListener);
    }

    @Override // com.tencent.qzonehub.api.panorama.IPanoramaView
    public void startShowPanorama(TextureView textureView, PanoramaConfig.Builder builder, OnPanoramaLoadingListener onPanoramaLoadingListener) {
        ((PanoramaView) textureView).startShowPanorama(builder, onPanoramaLoadingListener);
    }
}

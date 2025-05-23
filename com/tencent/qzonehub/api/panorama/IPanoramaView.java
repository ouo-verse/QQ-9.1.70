package com.tencent.qzonehub.api.panorama;

import android.content.Context;
import android.view.TextureView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import cooperation.qzone.panorama.callback.OnPanoramaClickListener;
import cooperation.qzone.panorama.callback.OnPanoramaLoadingListener;
import cooperation.qzone.panorama.util.PanoramaConfig;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IPanoramaView extends QRouteApi {
    void changeRenderMode(TextureView textureView, int i3);

    void changeRotate(TextureView textureView, float f16, float f17);

    TextureView getPanoramaView(Context context);

    void onRecycled(TextureView textureView);

    void setOnPanoramaClickListener(TextureView textureView, OnPanoramaClickListener onPanoramaClickListener);

    void startShowPanorama(TextureView textureView, PanoramaConfig.Builder builder, OnPanoramaLoadingListener onPanoramaLoadingListener);
}

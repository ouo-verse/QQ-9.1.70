package com.tencent.qqlive.tvkplayer.view.api;

import android.view.Surface;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKRenderSurface {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IVideoSurfaceCallback {
        void onSurfaceChanged(ITVKRenderSurface iTVKRenderSurface, Surface surface);

        void onSurfaceCreated(ITVKRenderSurface iTVKRenderSurface, Surface surface);

        void onSurfaceDestroyed(ITVKRenderSurface iTVKRenderSurface, Surface surface);
    }

    void addVideoSurfaceCallBack(IVideoSurfaceCallback iVideoSurfaceCallback);

    Surface getRenderSurface();

    boolean isSurfaceReady();

    void removeVideoSurfaceCallBack(IVideoSurfaceCallback iVideoSurfaceCallback);

    void setFixedSize(int i3, int i16);
}

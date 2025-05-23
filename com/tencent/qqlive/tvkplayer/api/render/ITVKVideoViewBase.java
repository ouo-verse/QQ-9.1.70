package com.tencent.qqlive.tvkplayer.api.render;

import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKVideoViewBase extends ITVKDrawableContainer {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IVideoViewCallback {
        void onSurfaceChanged(ITVKVideoViewBase iTVKVideoViewBase, Surface surface, int i3, int i16);

        void onSurfaceCreated(ITVKVideoViewBase iTVKVideoViewBase, Surface surface);

        void onSurfaceDestroyed(ITVKVideoViewBase iTVKVideoViewBase, Surface surface);
    }

    void addViewCallback(IVideoViewCallback iVideoViewCallback);

    View getCurrentDisplayView();

    ViewGroup getLogoView();

    ViewGroup getSubtitleView();

    void releaseSurfaceTexture();

    void removeViewCallback(IVideoViewCallback iVideoViewCallback);

    boolean resumeSurfaceTexture();

    void setLogoView(ViewGroup viewGroup);

    void setSubtitleView(ViewGroup viewGroup);

    boolean storeSurfaceTexture();
}

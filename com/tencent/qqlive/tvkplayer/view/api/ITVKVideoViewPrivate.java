package com.tencent.qqlive.tvkplayer.view.api;

import android.view.ViewGroup;

/* loaded from: classes23.dex */
public interface ITVKVideoViewPrivate {

    /* loaded from: classes23.dex */
    public interface IViewEventListener {
        void onReleaseSurfaceTexture();

        void onResumeSurfaceTexture();

        void onStoreSurfaceTexture();
    }

    void addViewEventListener(IViewEventListener iViewEventListener);

    int getFixedHeight();

    int getFixedWidth();

    ViewGroup getInnerDarkLogoView();

    ViewGroup getInnerLogoView();

    ViewGroup getInnerSubtitleView();

    void printView();

    void removeViewEventListener(IViewEventListener iViewEventListener);

    void reset();

    void setAlignment(int i3);

    void setDisplayOffset(float f16, float f17);

    void setDisplayScale(float f16);

    void setDisplayScale(float f16, float f17, float f18);

    boolean setViewSecure(boolean z16);

    void setXYaxis(int i3);
}

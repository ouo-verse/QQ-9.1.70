package com.tencent.ams.fusion.widget.alphaplayer;

import android.view.View;

/* loaded from: classes3.dex */
interface AlphaPlayerView {

    /* loaded from: classes3.dex */
    public interface SurfaceListener {
        void onSurfaceAvailable(Object obj, int i3, int i16);

        void onSurfaceDestroyed(Object obj);
    }

    int getHeight();

    Object getSurface();

    View getView();

    int getWidth();

    boolean isAvailable();

    void setPlayInfo(PlayInfo playInfo);

    void setSurfaceListener(SurfaceListener surfaceListener);
}

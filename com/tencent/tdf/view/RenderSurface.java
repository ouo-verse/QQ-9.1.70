package com.tencent.tdf.view;

import android.view.Surface;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface RenderSurface {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface Callback {
        void surfaceChanged(Surface surface, int i3, int i16);

        void surfaceCreated(Surface surface);

        void surfaceDestroyed(Surface surface);
    }

    void attachSurfaceToRenderer();

    void setRenderInImageView(boolean z16);
}

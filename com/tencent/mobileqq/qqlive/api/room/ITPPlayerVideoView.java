package com.tencent.mobileqq.qqlive.api.room;

import android.graphics.Rect;
import android.view.View;

/* loaded from: classes17.dex */
public interface ITPPlayerVideoView {
    public static final int PLAYER_SCALE_BOTH_FULLSCREEN = 1;
    public static final int PLAYER_SCALE_ORIGINAL_FULLSCREEN = 2;
    public static final int PLAYER_SCALE_ORIGINAL_RATIO = 0;
    public static final int PLAYER_SCALE_ORIGINAL_RATIO_SQUARE = 3;

    /* loaded from: classes17.dex */
    public interface IVideoSurfaceCallback {
        void onSurfaceChanged(Object obj);

        void onSurfaceCreated(Object obj);

        void onSurfaceDestroy(Object obj);
    }

    /* loaded from: classes17.dex */
    public interface IVideoViewCallback {
        void onSurfaceChanged(Object obj);

        void onSurfaceCreated(Object obj);

        void onSurfaceDestroy(Object obj);
    }

    void addSurfaceCallback(IVideoSurfaceCallback iVideoSurfaceCallback);

    void blackScreen(boolean z16);

    View getCurrentDisplayView();

    Rect getDisplayViewRect();

    int getViewRenderMode();

    void release();

    void removeSurfaceCallback(IVideoSurfaceCallback iVideoSurfaceCallback);

    boolean setDegree(int i3);

    void setFixedSize(int i3, int i16);

    void setScaleParam(float f16);

    void setXYAxis(int i3);
}

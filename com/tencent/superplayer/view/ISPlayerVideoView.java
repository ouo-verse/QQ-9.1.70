package com.tencent.superplayer.view;

import android.view.Surface;
import android.view.View;
import com.tencent.superplayer.view.SPlayerVideoView;

/* loaded from: classes26.dex */
public interface ISPlayerVideoView {

    /* loaded from: classes26.dex */
    public interface IVideoViewCallBack {
        void onSurfaceChanged(Object obj);

        void onSurfaceCreated(Object obj);

        void onSurfaceDestroy(Object obj);
    }

    void addViewCallBack(IVideoViewCallBack iVideoViewCallBack);

    void changeSurfaceObject(SPlayerVideoView.SurfaceObject surfaceObject);

    boolean disableViewCallback();

    boolean enableViewCallback();

    String getLogTag();

    View getRenderView();

    int getRenderViewHeight();

    int getRenderViewWidth();

    Surface getSurface();

    boolean isSurfaceReady();

    boolean isTextureView();

    void removeViewCallBack(IVideoViewCallBack iVideoViewCallBack);

    void setDegree(int i3);

    void setFixedSize(int i3, int i16);

    void setScaleParam(float f16);

    void setXYaxis(int i3);
}

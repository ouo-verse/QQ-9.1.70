package com.tencent.qqlive.tvkplayer.view.subview;

import android.view.Surface;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKDisplayView {

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface IDisplayViewCallback {
        void onViewChanged(Surface surface, int i3, int i16);

        void onViewCreated(Surface surface, int i3, int i16);

        boolean onViewDestroyed(Surface surface);
    }

    boolean setDegree(int i3);

    void setFixedSize(int i3, int i16);

    void setOffset(float f16, float f17);

    void setOpaqueInfo(boolean z16);

    void setScale(float f16);

    void setScale(float f16, float f17, float f18);

    void setViewCallBack(IDisplayViewCallback iDisplayViewCallback);

    boolean setViewSecure(boolean z16);

    void setXYaxis(int i3);
}

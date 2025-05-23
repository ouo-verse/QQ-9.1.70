package com.tencent.superplayer.view;

/* loaded from: classes26.dex */
public interface ISPlayerViewBase {

    /* loaded from: classes26.dex */
    public interface ViewCreateCallBack {
        void onViewChanged(Object obj, int i3, int i16);

        void onViewCreated(Object obj, int i3, int i16);

        boolean onViewDestroyed(Object obj);
    }

    boolean setDegree(int i3);

    void setScaleParam(float f16);

    void setVideoViewTagId(String str);

    void setVideoWidthAndHeight(int i3, int i16);

    void setViewCallBack(ViewCreateCallBack viewCreateCallBack);

    void setXYaxis(int i3);
}

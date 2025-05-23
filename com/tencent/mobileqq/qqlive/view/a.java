package com.tencent.mobileqq.qqlive.view;

/* compiled from: P */
/* loaded from: classes17.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public interface InterfaceC8403a {
        void onViewChanged(Object obj, int i3, int i16);

        void onViewCreated(Object obj, int i3, int i16);

        void onViewDestroyed(Object obj);
    }

    boolean setDegree(int i3);

    void setOpaqueInfo(boolean z16);

    void setScaleParam(float f16);

    void setVideoWidthAndHeight(int i3, int i16);

    void setViewCallBack(InterfaceC8403a interfaceC8403a);

    void setXYAxis(int i3);
}

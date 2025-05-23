package com.tencent.mobileqq.groupvideo.bridgeengine;

import androidx.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes12.dex */
public interface IQAvsdkService extends IBaseService {
    IQAvsdkRenderTexture create() throws NoSuchMethodException;

    IQavSdkMultiOperator getMultiOperator();

    IQAvSdkCamera getQAvSdkCamera();

    IQAvSdkVideoFrame2GLRender getQAvSdkVideoFrame2GLRender();

    IQavSdkGraphicRenderMgr getQavSdkGraphicRenderMgr();

    void initQavSdk(int i3, long j3);

    void registerObserver(IQavMultiObserverProxy iQavMultiObserverProxy);

    void setAudioRoute();

    void unInit();
}

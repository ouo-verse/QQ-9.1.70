package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IAsyncControl extends QRouteApi {
    Object createCaptureAsyncControl();

    void destory();

    Object getAsynControl();

    String getCameraCreatedResultInfo();

    boolean isCameraCreated();

    boolean isCameraCreatedResult();

    void startAsyncStep(int i3);

    void startAsyncStep(String str, Object[] objArr);

    void startPeakPreLoadAsyncStep();
}
